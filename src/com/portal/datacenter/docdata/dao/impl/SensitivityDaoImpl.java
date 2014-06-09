/*  1:   */ package com.portal.datacenter.docdata.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.portal.datacenter.docdata.dao.SensitivityDao;
/*  5:   */ import com.portal.datacenter.docdata.entity.Sensitivity;
/*  6:   */ import java.util.List;
/*  7:   */ import org.apache.commons.lang.StringUtils;
/*  8:   */ import org.hibernate.Criteria;
/*  9:   */ import org.hibernate.Session;
/* 10:   */ import org.hibernate.criterion.Criterion;
/* 11:   */ import org.hibernate.criterion.Order;
/* 12:   */ import org.springframework.stereotype.Repository;
/* 13:   */ 
/* 14:   */ @Repository
/* 15:   */ public class SensitivityDaoImpl
/* 16:   */   extends HibernateBaseDao<Sensitivity, Integer>
/* 17:   */   implements SensitivityDao
/* 18:   */ {
/* 19:   */   public List<Sensitivity> getList(boolean cacheable, String sortname, String sortorder)
/* 20:   */   {
/* 21:20 */     Criteria crit = createCriteria(new Criterion[0]);
/* 22:21 */     if (!StringUtils.isBlank(sortname))
/* 23:   */     {
/* 24:22 */       if ("asc".equals(sortorder)) {
/* 25:23 */         crit.addOrder(Order.asc(sortname));
/* 26:   */       } else {
/* 27:25 */         crit.addOrder(Order.desc(sortname));
/* 28:   */       }
/* 29:   */     }
/* 30:   */     else {
/* 31:28 */       crit.addOrder(Order.desc("id"));
/* 32:   */     }
/* 33:30 */     crit.setCacheable(cacheable);
/* 34:31 */     return findByCriteria(crit);
/* 35:   */   }
/* 36:   */   
/* 37:   */   public Sensitivity findById(Integer id)
/* 38:   */   {
/* 39:35 */     Sensitivity entity = (Sensitivity)get(id);
/* 40:36 */     return entity;
/* 41:   */   }
/* 42:   */   
/* 43:   */   public Sensitivity save(Sensitivity bean)
/* 44:   */   {
/* 45:40 */     getSession().save(bean);
/* 46:41 */     return bean;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public Sensitivity deleteById(Integer id)
/* 50:   */   {
/* 51:45 */     Sensitivity entity = (Sensitivity)super.get(id);
/* 52:46 */     if (entity != null) {
/* 53:47 */       getSession().delete(entity);
/* 54:   */     }
/* 55:49 */     return entity;
/* 56:   */   }
/* 57:   */   
/* 58:   */   protected Class<Sensitivity> getEntityClass()
/* 59:   */   {
/* 60:54 */     return Sensitivity.class;
/* 61:   */   }
/* 62:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.docdata.dao.impl.SensitivityDaoImpl
 * JD-Core Version:    0.7.0.1
 */