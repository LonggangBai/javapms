/*  1:   */ package com.portal.datacenter.docdata.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.portal.datacenter.docdata.dao.KeywordDao;
/*  5:   */ import com.portal.datacenter.docdata.entity.Keyword;
/*  6:   */ import java.util.List;
/*  7:   */ import org.apache.commons.lang.StringUtils;
/*  8:   */ import org.hibernate.Criteria;
/*  9:   */ import org.hibernate.Session;
/* 10:   */ import org.hibernate.criterion.Criterion;
/* 11:   */ import org.hibernate.criterion.Order;
/* 12:   */ import org.hibernate.criterion.Restrictions;
/* 13:   */ import org.springframework.stereotype.Repository;
/* 14:   */ 
/* 15:   */ @Repository
/* 16:   */ public class KeywordDaoImpl
/* 17:   */   extends HibernateBaseDao<Keyword, Integer>
/* 18:   */   implements KeywordDao
/* 19:   */ {
/* 20:   */   public List<Keyword> getList(Integer siteId, boolean enable, boolean cacheable, String sortname, String sortorder)
/* 21:   */   {
/* 22:20 */     Criteria crit = createCriteria(new Criterion[0]);
/* 23:21 */     if (siteId != null) {
/* 24:22 */       crit.add(Restrictions.eq("site.id", siteId));
/* 25:   */     }
/* 26:24 */     if (enable) {
/* 27:25 */       crit.add(Restrictions.eq("enable", Boolean.valueOf(true)));
/* 28:   */     }
/* 29:27 */     if (!StringUtils.isBlank(sortname))
/* 30:   */     {
/* 31:28 */       if ("asc".equals(sortorder)) {
/* 32:29 */         crit.addOrder(Order.asc(sortname));
/* 33:   */       } else {
/* 34:31 */         crit.addOrder(Order.desc(sortname));
/* 35:   */       }
/* 36:   */     }
/* 37:   */     else {
/* 38:34 */       crit.addOrder(Order.desc("id"));
/* 39:   */     }
/* 40:36 */     crit.setCacheable(cacheable);
/* 41:37 */     return findByCriteria(crit);
/* 42:   */   }
/* 43:   */   
/* 44:   */   public Keyword findById(Integer id)
/* 45:   */   {
/* 46:41 */     Keyword entity = (Keyword)get(id);
/* 47:42 */     return entity;
/* 48:   */   }
/* 49:   */   
/* 50:   */   public Keyword save(Keyword bean)
/* 51:   */   {
/* 52:46 */     getSession().save(bean);
/* 53:47 */     return bean;
/* 54:   */   }
/* 55:   */   
/* 56:   */   public Keyword deleteById(Integer id)
/* 57:   */   {
/* 58:51 */     Keyword entity = (Keyword)super.get(id);
/* 59:52 */     if (entity != null) {
/* 60:53 */       getSession().delete(entity);
/* 61:   */     }
/* 62:55 */     return entity;
/* 63:   */   }
/* 64:   */   
/* 65:   */   protected Class<Keyword> getEntityClass()
/* 66:   */   {
/* 67:60 */     return Keyword.class;
/* 68:   */   }
/* 69:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.docdata.dao.impl.KeywordDaoImpl
 * JD-Core Version:    0.7.0.1
 */