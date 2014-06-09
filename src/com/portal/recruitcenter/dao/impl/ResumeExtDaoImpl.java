/*  1:   */ package com.portal.recruitcenter.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.recruitcenter.dao.ResumeExtDao;
/*  6:   */ import com.portal.recruitcenter.entity.ResumeExt;
/*  7:   */ import org.hibernate.Criteria;
/*  8:   */ import org.hibernate.Query;
/*  9:   */ import org.hibernate.Session;
/* 10:   */ import org.hibernate.criterion.Criterion;
/* 11:   */ import org.springframework.stereotype.Repository;
/* 12:   */ 
/* 13:   */ @Repository
/* 14:   */ public class ResumeExtDaoImpl
/* 15:   */   extends HibernateBaseDao<ResumeExt, Integer>
/* 16:   */   implements ResumeExtDao
/* 17:   */ {
/* 18:   */   public Pagination getPage(int pageNo, int pageSize)
/* 19:   */   {
/* 20:15 */     Criteria crit = createCriteria(new Criterion[0]);
/* 21:16 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 22:17 */     return page;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public int deleteByPersonalId(Integer personalId)
/* 26:   */   {
/* 27:21 */     String hql = "delete from ResumeExt bean where bean.id in (select r.id from Resume r where r.personal.id=:personalId)";
/* 28:   */     
/* 29:23 */     return getSession().createQuery(hql)
/* 30:24 */       .setParameter("personalId", personalId).executeUpdate();
/* 31:   */   }
/* 32:   */   
/* 33:   */   public ResumeExt findById(Integer id)
/* 34:   */   {
/* 35:28 */     ResumeExt entity = (ResumeExt)get(id);
/* 36:29 */     return entity;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public ResumeExt save(ResumeExt bean)
/* 40:   */   {
/* 41:33 */     getSession().save(bean);
/* 42:34 */     return bean;
/* 43:   */   }
/* 44:   */   
/* 45:   */   public ResumeExt deleteById(Integer id)
/* 46:   */   {
/* 47:38 */     ResumeExt entity = (ResumeExt)super.get(id);
/* 48:39 */     if (entity != null) {
/* 49:40 */       getSession().delete(entity);
/* 50:   */     }
/* 51:42 */     return entity;
/* 52:   */   }
/* 53:   */   
/* 54:   */   protected Class<ResumeExt> getEntityClass()
/* 55:   */   {
/* 56:47 */     return ResumeExt.class;
/* 57:   */   }
/* 58:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.dao.impl.ResumeExtDaoImpl
 * JD-Core Version:    0.7.0.1
 */