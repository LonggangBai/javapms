/*  1:   */ package com.portal.doccenter.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.portal.doccenter.dao.ModelFieldDao;
/*  5:   */ import com.portal.doccenter.entity.ModelField;
/*  6:   */ import java.util.Iterator;
/*  7:   */ import java.util.List;
/*  8:   */ import org.apache.commons.lang.StringUtils;
/*  9:   */ import org.hibernate.Criteria;
/* 10:   */ import org.hibernate.Query;
/* 11:   */ import org.hibernate.Session;
/* 12:   */ import org.hibernate.criterion.Criterion;
/* 13:   */ import org.hibernate.criterion.Order;
/* 14:   */ import org.hibernate.criterion.Restrictions;
/* 15:   */ import org.springframework.stereotype.Repository;
/* 16:   */ 
/* 17:   */ @Repository
/* 18:   */ public class ModelFieldDaoImpl
/* 19:   */   extends HibernateBaseDao<ModelField, Integer>
/* 20:   */   implements ModelFieldDao
/* 21:   */ {
/* 22:   */   public List<ModelField> getList(Integer modelId, boolean hasDisabled, String sortname, String sortorder)
/* 23:   */   {
/* 24:22 */     Criteria crit = createCriteria(new Criterion[0]);
/* 25:23 */     crit.add(Restrictions.eq("model.id", modelId));
/* 26:24 */     if (!hasDisabled) {
/* 27:25 */       crit.add(Restrictions.eq("show", Boolean.valueOf(true)));
/* 28:   */     }
/* 29:27 */     if (!StringUtils.isBlank(sortname))
/* 30:   */     {
/* 31:28 */       if ("asc".equals(sortorder)) {
/* 32:29 */         crit.addOrder(Order.asc(sortname));
/* 33:   */       } else {
/* 34:31 */         crit.addOrder(Order.desc(sortname));
/* 35:   */       }
/* 36:   */     }
/* 37:   */     else
/* 38:   */     {
/* 39:34 */       crit.addOrder(Order.asc("priority"));
/* 40:35 */       crit.addOrder(Order.asc("id"));
/* 41:   */     }
/* 42:37 */     return findByCriteria(crit);
/* 43:   */   }
/* 44:   */   
/* 45:   */   public List<ModelField> getListByPriority(Integer modelId, Integer priority, Integer priority1, boolean hasDisabled)
/* 46:   */   {
/* 47:42 */     Criteria crit = createCriteria(new Criterion[0]);
/* 48:43 */     crit.add(Restrictions.eq("model.id", modelId));
/* 49:44 */     crit.add(Restrictions.ge("priority", priority));
/* 50:45 */     crit.add(Restrictions.lt("priority", priority1));
/* 51:46 */     if (!hasDisabled) {
/* 52:47 */       crit.add(Restrictions.eq("show", Boolean.valueOf(true)));
/* 53:   */     }
/* 54:49 */     crit.addOrder(Order.asc("priority"));
/* 55:50 */     crit.addOrder(Order.asc("id"));
/* 56:51 */     return findByCriteria(crit);
/* 57:   */   }
/* 58:   */   
/* 59:   */   public int getMaxPriority(Integer modelId)
/* 60:   */   {
/* 61:55 */     String hql = "select max(bean.priority) from ModelField bean where bean.model.id=:modelId";
/* 62:56 */     Query query = getSession().createQuery(hql);
/* 63:57 */     query.setParameter("modelId", modelId);
/* 64:58 */     return ((Number)query.iterate().next()).intValue();
/* 65:   */   }
/* 66:   */   
/* 67:   */   public ModelField findById(Integer id)
/* 68:   */   {
/* 69:62 */     ModelField entity = (ModelField)get(id);
/* 70:63 */     return entity;
/* 71:   */   }
/* 72:   */   
/* 73:   */   public ModelField save(ModelField bean)
/* 74:   */   {
/* 75:67 */     getSession().save(bean);
/* 76:68 */     return bean;
/* 77:   */   }
/* 78:   */   
/* 79:   */   public ModelField deleteById(Integer id)
/* 80:   */   {
/* 81:72 */     ModelField entity = (ModelField)super.get(id);
/* 82:73 */     if (entity != null) {
/* 83:74 */       getSession().delete(entity);
/* 84:   */     }
/* 85:76 */     return entity;
/* 86:   */   }
/* 87:   */   
/* 88:   */   protected Class<ModelField> getEntityClass()
/* 89:   */   {
/* 90:81 */     return ModelField.class;
/* 91:   */   }
/* 92:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.dao.impl.ModelFieldDaoImpl
 * JD-Core Version:    0.7.0.1
 */