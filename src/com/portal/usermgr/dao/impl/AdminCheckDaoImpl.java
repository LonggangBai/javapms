/*  1:   */ package com.portal.usermgr.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.portal.usermgr.dao.AdminCheckDao;
/*  5:   */ import com.portal.usermgr.entity.AdminCheck;
/*  6:   */ import org.hibernate.Query;
/*  7:   */ import org.hibernate.Session;
/*  8:   */ import org.springframework.stereotype.Repository;
/*  9:   */ 
/* 10:   */ @Repository
/* 11:   */ public class AdminCheckDaoImpl
/* 12:   */   extends HibernateBaseDao<AdminCheck, Integer>
/* 13:   */   implements AdminCheckDao
/* 14:   */ {
/* 15:   */   public AdminCheck findById(Integer id)
/* 16:   */   {
/* 17:13 */     AdminCheck entity = (AdminCheck)get(id);
/* 18:14 */     return entity;
/* 19:   */   }
/* 20:   */   
/* 21:   */   public AdminCheck save(AdminCheck bean)
/* 22:   */   {
/* 23:18 */     getSession().save(bean);
/* 24:19 */     return bean;
/* 25:   */   }
/* 26:   */   
/* 27:   */   public int deleteBySiteId(Integer siteId)
/* 28:   */   {
/* 29:23 */     String hql = "delete from AdminCheck bean where bean.site.id=:siteId";
/* 30:24 */     return getSession().createQuery(hql).setParameter("siteId", siteId)
/* 31:25 */       .executeUpdate();
/* 32:   */   }
/* 33:   */   
/* 34:   */   public AdminCheck deleteById(Integer id)
/* 35:   */   {
/* 36:29 */     AdminCheck entity = (AdminCheck)super.get(id);
/* 37:30 */     if (entity != null) {
/* 38:31 */       getSession().delete(entity);
/* 39:   */     }
/* 40:33 */     return entity;
/* 41:   */   }
/* 42:   */   
/* 43:   */   public void delete(AdminCheck entity)
/* 44:   */   {
/* 45:37 */     getSession().delete(entity);
/* 46:   */   }
/* 47:   */   
/* 48:   */   protected Class<AdminCheck> getEntityClass()
/* 49:   */   {
/* 50:42 */     return AdminCheck.class;
/* 51:   */   }
/* 52:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.dao.impl.AdminCheckDaoImpl
 * JD-Core Version:    0.7.0.1
 */