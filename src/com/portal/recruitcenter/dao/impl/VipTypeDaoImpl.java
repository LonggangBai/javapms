/*  1:   */ package com.portal.recruitcenter.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.recruitcenter.dao.VipTypeDao;
/*  6:   */ import com.portal.recruitcenter.entity.VipType;
/*  7:   */ import java.util.List;
/*  8:   */ import org.hibernate.Criteria;
/*  9:   */ import org.hibernate.Session;
/* 10:   */ import org.hibernate.criterion.Criterion;
/* 11:   */ import org.hibernate.criterion.Order;
/* 12:   */ import org.springframework.stereotype.Repository;
/* 13:   */ 
/* 14:   */ @Repository
/* 15:   */ public class VipTypeDaoImpl
/* 16:   */   extends HibernateBaseDao<VipType, Integer>
/* 17:   */   implements VipTypeDao
/* 18:   */ {
/* 19:   */   public Pagination getPage(int pageNo, int pageSize)
/* 20:   */   {
/* 21:18 */     Criteria crit = createCriteria(new Criterion[0]);
/* 22:19 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 23:20 */     return page;
/* 24:   */   }
/* 25:   */   
/* 26:   */   public List<VipType> getAllVipType()
/* 27:   */   {
/* 28:24 */     Criteria crit = createCriteria(new Criterion[0]);
/* 29:25 */     crit.addOrder(Order.asc("id"));
/* 30:26 */     return findByCriteria(crit);
/* 31:   */   }
/* 32:   */   
/* 33:   */   public VipType findById(Integer id)
/* 34:   */   {
/* 35:30 */     VipType entity = (VipType)get(id);
/* 36:31 */     return entity;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public VipType save(VipType bean)
/* 40:   */   {
/* 41:35 */     getSession().save(bean);
/* 42:36 */     return bean;
/* 43:   */   }
/* 44:   */   
/* 45:   */   public VipType deleteById(Integer id)
/* 46:   */   {
/* 47:40 */     VipType entity = (VipType)super.get(id);
/* 48:41 */     if (entity != null) {
/* 49:42 */       getSession().delete(entity);
/* 50:   */     }
/* 51:44 */     return entity;
/* 52:   */   }
/* 53:   */   
/* 54:   */   protected Class<VipType> getEntityClass()
/* 55:   */   {
/* 56:49 */     return VipType.class;
/* 57:   */   }
/* 58:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.dao.impl.VipTypeDaoImpl
 * JD-Core Version:    0.7.0.1
 */