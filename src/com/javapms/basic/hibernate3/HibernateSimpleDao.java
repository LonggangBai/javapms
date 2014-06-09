package com.javapms.basic.hibernate3;

import com.javapms.basic.page.Pagination;
import com.javapms.basic.utils.PropertyBeanUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.impl.CriteriaImpl;
import org.hibernate.transform.ResultTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

public abstract class HibernateSimpleDao<T> {
    protected Logger log = LoggerFactory.getLogger(getClass());
    protected static final String ORDER_ENTRIES = "orderEntries";
    protected SessionFactory sessionFactory;

    protected Query createQuery(String queryString, Object... values) {
        Assert.hasText(queryString);
        Query queryObject = getSession().createQuery(queryString);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                queryObject.setParameter(i, values[i]);
            }
        }
        return queryObject;
    }

    protected T findUnique(Criteria crit) {
        Criteria c = getCriteria(crit);
        c.setMaxResults(1);
        return (T) c.uniqueResult();
    }

    protected List<T> findByCriteria(Criteria crit) {
        Criteria c = getCriteria(crit);
        return c.list();
    }

    protected Pagination findByCriteria(Criteria crit, int pageNo, int pageSize) {
        CriteriaImpl impl = (CriteriaImpl) crit;
        Projection projection = impl.getProjection();
        ResultTransformer transformer = impl.getResultTransformer();
        try {
            List<CriteriaImpl.OrderEntry> orderEntries = (List) PropertyBeanUtils.getFieldValue(
                    impl, "orderEntries");
            PropertyBeanUtils.setFieldValue(impl, "orderEntries",
                    new ArrayList());
        } catch (Exception e) {
            throw new RuntimeException("HQL异常", e);
        }
        List<CriteriaImpl.OrderEntry> orderEntries = null;
        int totalCount = ((Number) crit.setProjection(Projections.rowCount())
                .uniqueResult()).intValue();
        crit.setProjection(projection);
        if (projection == null) {
            crit.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
        }
        if (transformer != null) {
            crit.setResultTransformer(transformer);
        }
        try {
            PropertyBeanUtils.setFieldValue(impl, "orderEntries", orderEntries);
        } catch (Exception e) {
            throw new RuntimeException(
                    "set 'orderEntries' to CriteriaImpl faild", e);
        }
        Pagination p = new Pagination(pageNo, pageSize, totalCount);
        if (totalCount < 1) {
            p.setList(new ArrayList());
            return p;
        }
        crit.setFirstResult(p.getFirstResult());
        crit.setMaxResults(p.getPageSize());
        p.setList(crit.list());
        return p;
    }

    protected int countQueryResult(Finder finder) {
        Query query = getSession().createQuery(finder.getRowCountHql());
        finder.setParamsToQuery(query);
        if (finder.isCacheable()) {
            query.setCacheable(true);
        }
        return ((Number) query.iterate().next()).intValue();
    }

    private Criteria getCriteria(Criteria crit) {
        CriteriaImpl impl = (CriteriaImpl) crit;
        Projection projection = impl.getProjection();
        ResultTransformer transformer = impl.getResultTransformer();
        try {
            List<CriteriaImpl.OrderEntry> orderEntries = (List) PropertyBeanUtils.getFieldValue(
                    impl, "orderEntries");
            PropertyBeanUtils.setFieldValue(impl, "orderEntries",
                    new ArrayList());
        } catch (Exception e) {
            throw new RuntimeException("HQL异常", e);
        }
        List<CriteriaImpl.OrderEntry> orderEntries = null;
        crit.setProjection(projection);
        if (projection == null) {
            crit.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        }
        if (transformer != null) {
            crit.setResultTransformer(transformer);
        }
        try {
            PropertyBeanUtils.setFieldValue(impl, "orderEntries", orderEntries);
        } catch (Exception e) {
            throw new RuntimeException(
                    "set 'orderEntries' to CriteriaImpl faild", e);
        }
        return crit;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }
}



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.javapms.basic.hibernate3.HibernateSimpleDao

 * JD-Core Version:    0.7.0.1

 */