package com.javapms.basic.hibernate3;

import com.javapms.basic.utils.PropertyBeanUtils;
import org.hibernate.Criteria;
import org.hibernate.EntityMode;
import org.hibernate.LockOptions;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.List;

public abstract class HibernateBaseDao<T, ID extends Serializable>
        extends HibernateSimpleDao<T> {
    protected T get(ID id) {
        return get(id, false);
    }

    protected T get(ID id, boolean lock) {
        T entity;
        if (lock) {
            entity = (T) getSession().get(getEntityClass(), id, LockOptions.UPGRADE);
        } else {
            entity = (T) getSession().get(getEntityClass(), id);
        }
        return entity;
    }

    protected List<T> findByProperty(String property, Object value) {
        Assert.hasText(property);
        return createCriteria(new Criterion[]{Restrictions.eq(property, value)}).list();
    }

    protected T findUniqueByProperty(String property, Object value) {
        Assert.hasText(property);
        Assert.notNull(value);
        return (T) createCriteria(new Criterion[]{Restrictions.eq(property, value)})
                .setMaxResults(1).uniqueResult();
    }

    protected int countByProperty(String property, Object value) {
        Assert.hasText(property);
        Assert.notNull(value);
        return ((Number) createCriteria(new Criterion[]{Restrictions.eq(property, value)})
                .setProjection(Projections.rowCount()).uniqueResult())
                .intValue();
    }

    protected List<T> findByCriteria(Criterion... criterion) {
        return createCriteria(criterion).list();
    }

    public T updateByUpdater(Updater<T> updater) {
        ClassMetadata cm = this.sessionFactory.getClassMetadata(getEntityClass());
        T bean = updater.getBean();
        T po = (T) getSession().get(getEntityClass(), cm.getIdentifier(bean, EntityMode.POJO));
        updaterCopyToPersistentObject(updater, po, cm);
        return po;
    }

    private void updaterCopyToPersistentObject(Updater<T> updater, T po, ClassMetadata cm) {
        String[] propNames = cm.getPropertyNames();
        String identifierName = cm.getIdentifierPropertyName();
        T bean = updater.getBean();
        for (String propName : propNames) {
            if (!propName.equals(identifierName)) {
                try {
                    Object value = PropertyBeanUtils.getSimpleProperty(bean, propName);
                    if (updater.isUpdate(propName, value)) {
                        cm.setPropertyValue(po, propName, value, EntityMode.POJO);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(
                            "copy property to persistent object failed: '" +
                                    propName + "'", e);
                }
            }
        }
    }

    protected Criteria createCriteria(Criterion... criterions) {
        Criteria criteria = getSession().createCriteria(getEntityClass());
        for (Criterion c : criterions) {
            criteria.add(c);
        }
        return criteria;
    }

    protected abstract Class<T> getEntityClass();
}



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.javapms.basic.hibernate3.HibernateBaseDao

 * JD-Core Version:    0.7.0.1

 */