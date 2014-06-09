/*  1:   */ package com.portal.datacenter.commdata.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.datacenter.commdata.dao.UnitTypeDao;
/*  6:   */ import com.portal.datacenter.commdata.entity.UnitType;
/*  7:   */ import org.hibernate.Criteria;
/*  8:   */ import org.hibernate.Session;
/*  9:   */ import org.hibernate.criterion.Criterion;
/* 10:   */ import org.hibernate.criterion.Order;
/* 11:   */ import org.springframework.stereotype.Repository;
/* 12:   */ 
/* 13:   */ @Repository
/* 14:   */ public class UnitTypeDaoImpl
/* 15:   */   extends HibernateBaseDao<UnitType, Integer>
/* 16:   */   implements UnitTypeDao
/* 17:   */ {
/* 18:   */   public Pagination getPage(int pageNo, int pageSize)
/* 19:   */   {
/* 20:15 */     Criteria crit = createCriteria(new Criterion[0]);
/* 21:16 */     crit.addOrder(Order.asc("code"));
/* 22:17 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 23:18 */     return page;
/* 24:   */   }
/* 25:   */   
/* 26:   */   public UnitType findById(Integer id)
/* 27:   */   {
/* 28:22 */     UnitType entity = (UnitType)get(id);
/* 29:23 */     return entity;
/* 30:   */   }
/* 31:   */   
/* 32:   */   public UnitType save(UnitType bean)
/* 33:   */   {
/* 34:27 */     getSession().save(bean);
/* 35:28 */     return bean;
/* 36:   */   }
/* 37:   */   
/* 38:   */   public UnitType deleteById(Integer id)
/* 39:   */   {
/* 40:32 */     UnitType entity = (UnitType)super.get(id);
/* 41:33 */     if (entity != null) {
/* 42:34 */       getSession().delete(entity);
/* 43:   */     }
/* 44:36 */     return entity;
/* 45:   */   }
/* 46:   */   
/* 47:   */   protected Class<UnitType> getEntityClass()
/* 48:   */   {
/* 49:41 */     return UnitType.class;
/* 50:   */   }
/* 51:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.commdata.dao.impl.UnitTypeDaoImpl
 * JD-Core Version:    0.7.0.1
 */