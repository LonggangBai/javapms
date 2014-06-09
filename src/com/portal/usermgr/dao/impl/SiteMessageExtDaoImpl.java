/*  1:   */ package com.portal.usermgr.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.usermgr.dao.SiteMessageExtDao;
/*  6:   */ import com.portal.usermgr.entity.SiteMessageExt;
/*  7:   */ import org.hibernate.Criteria;
/*  8:   */ import org.hibernate.Query;
/*  9:   */ import org.hibernate.Session;
/* 10:   */ import org.hibernate.criterion.Criterion;
/* 11:   */ import org.springframework.stereotype.Repository;
/* 12:   */ 
/* 13:   */ @Repository
/* 14:   */ public class SiteMessageExtDaoImpl
/* 15:   */   extends HibernateBaseDao<SiteMessageExt, Integer>
/* 16:   */   implements SiteMessageExtDao
/* 17:   */ {
/* 18:   */   public Pagination getPage(int pageNo, int pageSize)
/* 19:   */   {
/* 20:15 */     Criteria crit = createCriteria(new Criterion[0]);
/* 21:16 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 22:17 */     return page;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public int deleteByUserId(Integer userId)
/* 26:   */   {
/* 27:21 */     String hql = "delete from SiteMessageExt bean where bean.id in (select s.id from SiteMessage s where s.fromUser.id=:userId or s.toUser.id=:userId)";
/* 28:   */     
/* 29:   */ 
/* 30:24 */     return getSession().createQuery(hql).setParameter("userId", userId)
/* 31:25 */       .executeUpdate();
/* 32:   */   }
/* 33:   */   
/* 34:   */   public SiteMessageExt findById(Integer id)
/* 35:   */   {
/* 36:29 */     SiteMessageExt entity = (SiteMessageExt)get(id);
/* 37:30 */     return entity;
/* 38:   */   }
/* 39:   */   
/* 40:   */   public SiteMessageExt save(SiteMessageExt bean)
/* 41:   */   {
/* 42:34 */     getSession().save(bean);
/* 43:35 */     return bean;
/* 44:   */   }
/* 45:   */   
/* 46:   */   public SiteMessageExt deleteById(Integer id)
/* 47:   */   {
/* 48:39 */     SiteMessageExt entity = (SiteMessageExt)super.get(id);
/* 49:40 */     if (entity != null) {
/* 50:41 */       getSession().delete(entity);
/* 51:   */     }
/* 52:43 */     return entity;
/* 53:   */   }
/* 54:   */   
/* 55:   */   protected Class<SiteMessageExt> getEntityClass()
/* 56:   */   {
/* 57:48 */     return SiteMessageExt.class;
/* 58:   */   }
/* 59:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.dao.impl.SiteMessageExtDaoImpl
 * JD-Core Version:    0.7.0.1
 */