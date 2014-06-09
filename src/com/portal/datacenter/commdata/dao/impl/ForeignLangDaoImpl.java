/*  1:   */ package com.portal.datacenter.commdata.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.datacenter.commdata.dao.ForeignLangDao;
/*  6:   */ import com.portal.datacenter.commdata.entity.ForeignLang;
/*  7:   */ import java.util.List;
/*  8:   */ import org.hibernate.Criteria;
/*  9:   */ import org.hibernate.Session;
/* 10:   */ import org.hibernate.criterion.Criterion;
/* 11:   */ import org.hibernate.criterion.Order;
/* 12:   */ import org.springframework.stereotype.Repository;
/* 13:   */ 
/* 14:   */ @Repository
/* 15:   */ public class ForeignLangDaoImpl
/* 16:   */   extends HibernateBaseDao<ForeignLang, Integer>
/* 17:   */   implements ForeignLangDao
/* 18:   */ {
/* 19:   */   public Pagination getPage(int pageNo, int pageSize)
/* 20:   */   {
/* 21:18 */     Criteria crit = createCriteria(new Criterion[0]);
/* 22:19 */     crit.addOrder(Order.asc("code"));
/* 23:20 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 24:21 */     return page;
/* 25:   */   }
/* 26:   */   
/* 27:   */   public List<ForeignLang> getForeignLangList()
/* 28:   */   {
/* 29:25 */     Criteria crit = createCriteria(new Criterion[0]);
/* 30:26 */     crit.addOrder(Order.asc("code"));
/* 31:27 */     return findByCriteria(crit);
/* 32:   */   }
/* 33:   */   
/* 34:   */   public ForeignLang findById(Integer id)
/* 35:   */   {
/* 36:31 */     ForeignLang entity = (ForeignLang)get(id);
/* 37:32 */     return entity;
/* 38:   */   }
/* 39:   */   
/* 40:   */   public ForeignLang save(ForeignLang bean)
/* 41:   */   {
/* 42:36 */     getSession().save(bean);
/* 43:37 */     return bean;
/* 44:   */   }
/* 45:   */   
/* 46:   */   public ForeignLang deleteById(Integer id)
/* 47:   */   {
/* 48:41 */     ForeignLang entity = (ForeignLang)super.get(id);
/* 49:42 */     if (entity != null) {
/* 50:43 */       getSession().delete(entity);
/* 51:   */     }
/* 52:45 */     return entity;
/* 53:   */   }
/* 54:   */   
/* 55:   */   protected Class<ForeignLang> getEntityClass()
/* 56:   */   {
/* 57:50 */     return ForeignLang.class;
/* 58:   */   }
/* 59:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.commdata.dao.impl.ForeignLangDaoImpl
 * JD-Core Version:    0.7.0.1
 */