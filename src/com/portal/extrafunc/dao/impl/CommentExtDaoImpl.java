/*  1:   */ package com.portal.extrafunc.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.extrafunc.dao.CommentExtDao;
/*  6:   */ import com.portal.extrafunc.entity.CommentExt;
/*  7:   */ import org.hibernate.Criteria;
/*  8:   */ import org.hibernate.Query;
/*  9:   */ import org.hibernate.Session;
/* 10:   */ import org.hibernate.criterion.Criterion;
/* 11:   */ import org.springframework.stereotype.Repository;
/* 12:   */ 
/* 13:   */ @Repository
/* 14:   */ public class CommentExtDaoImpl
/* 15:   */   extends HibernateBaseDao<CommentExt, Integer>
/* 16:   */   implements CommentExtDao
/* 17:   */ {
/* 18:   */   public Pagination getPage(int pageNo, int pageSize)
/* 19:   */   {
/* 20:15 */     Criteria crit = createCriteria(new Criterion[0]);
/* 21:16 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 22:17 */     return page;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public CommentExt findById(Integer id)
/* 26:   */   {
/* 27:21 */     CommentExt entity = (CommentExt)get(id);
/* 28:22 */     return entity;
/* 29:   */   }
/* 30:   */   
/* 31:   */   public CommentExt save(CommentExt bean)
/* 32:   */   {
/* 33:26 */     getSession().save(bean);
/* 34:27 */     return bean;
/* 35:   */   }
/* 36:   */   
/* 37:   */   public int deleteByDocId(Integer docId)
/* 38:   */   {
/* 39:31 */     String hql = "delete from CommentExt bean where bean.id in (select c.id from Comment c where c.doc.id=:docId)";
/* 40:   */     
/* 41:33 */     return getSession().createQuery(hql).setParameter("docId", docId)
/* 42:34 */       .executeUpdate();
/* 43:   */   }
/* 44:   */   
/* 45:   */   public CommentExt deleteById(Integer id)
/* 46:   */   {
/* 47:38 */     CommentExt entity = (CommentExt)super.get(id);
/* 48:39 */     if (entity != null) {
/* 49:40 */       getSession().delete(entity);
/* 50:   */     }
/* 51:42 */     return entity;
/* 52:   */   }
/* 53:   */   
/* 54:   */   protected Class<CommentExt> getEntityClass()
/* 55:   */   {
/* 56:47 */     return CommentExt.class;
/* 57:   */   }
/* 58:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.dao.impl.CommentExtDaoImpl
 * JD-Core Version:    0.7.0.1
 */