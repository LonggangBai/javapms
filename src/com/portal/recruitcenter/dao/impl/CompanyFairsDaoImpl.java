/*  1:   */ package com.portal.recruitcenter.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.recruitcenter.dao.CompanyFairsDao;
/*  6:   */ import com.portal.recruitcenter.entity.CompanyFairs;
/*  7:   */ import org.hibernate.Criteria;
/*  8:   */ import org.hibernate.Session;
/*  9:   */ import org.hibernate.criterion.Criterion;
/* 10:   */ import org.hibernate.criterion.Order;
/* 11:   */ import org.hibernate.criterion.Restrictions;
/* 12:   */ import org.springframework.stereotype.Repository;
/* 13:   */ 
/* 14:   */ @Repository
/* 15:   */ public class CompanyFairsDaoImpl
/* 16:   */   extends HibernateBaseDao<CompanyFairs, Integer>
/* 17:   */   implements CompanyFairsDao
/* 18:   */ {
/* 19:   */   public Pagination getPage(Integer companyId, Integer fairsId, int pageNo, int pageSize)
/* 20:   */   {
/* 21:18 */     Criteria crit = createCriteria(new Criterion[0]);
/* 22:19 */     if (companyId != null) {
/* 23:20 */       crit.add(Restrictions.eq("company.id", companyId));
/* 24:   */     }
/* 25:22 */     if (fairsId != null) {
/* 26:23 */       crit.add(Restrictions.eq("fairs.id", fairsId));
/* 27:   */     }
/* 28:25 */     crit.addOrder(Order.desc("createTime"));
/* 29:26 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 30:27 */     return page;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public Pagination getPageByTag(Integer fairsId, Integer companyId, Integer orderBy, int pageNo, int pageSize)
/* 34:   */   {
/* 35:32 */     Criteria crit = createCriteria(new Criterion[0]);
/* 36:33 */     if (fairsId != null) {
/* 37:34 */       crit.add(Restrictions.eq("fairs.id", fairsId));
/* 38:   */     }
/* 39:36 */     if (companyId != null) {
/* 40:37 */       crit.add(Restrictions.eq("company.id", companyId));
/* 41:   */     }
/* 42:39 */     if (orderBy.intValue() == 1) {
/* 43:40 */       crit.addOrder(Order.asc("name"));
/* 44:41 */     } else if (orderBy.intValue() == 2) {
/* 45:42 */       crit.addOrder(Order.asc("showcase"));
/* 46:43 */     } else if (orderBy.intValue() == 3) {
/* 47:44 */       crit.addOrder(Order.asc("createTime"));
/* 48:   */     } else {
/* 49:46 */       crit.addOrder(Order.desc("createTime"));
/* 50:   */     }
/* 51:48 */     return findByCriteria(crit, pageNo, pageSize);
/* 52:   */   }
/* 53:   */   
/* 54:   */   public CompanyFairs findById(Integer id)
/* 55:   */   {
/* 56:52 */     CompanyFairs entity = (CompanyFairs)get(id);
/* 57:53 */     return entity;
/* 58:   */   }
/* 59:   */   
/* 60:   */   public CompanyFairs save(CompanyFairs bean)
/* 61:   */   {
/* 62:57 */     getSession().save(bean);
/* 63:58 */     return bean;
/* 64:   */   }
/* 65:   */   
/* 66:   */   public CompanyFairs deleteById(Integer id)
/* 67:   */   {
/* 68:62 */     CompanyFairs entity = (CompanyFairs)super.get(id);
/* 69:63 */     if (entity != null) {
/* 70:64 */       getSession().delete(entity);
/* 71:   */     }
/* 72:66 */     return entity;
/* 73:   */   }
/* 74:   */   
/* 75:   */   protected Class<CompanyFairs> getEntityClass()
/* 76:   */   {
/* 77:71 */     return CompanyFairs.class;
/* 78:   */   }
/* 79:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.dao.impl.CompanyFairsDaoImpl
 * JD-Core Version:    0.7.0.1
 */