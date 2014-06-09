/*  1:   */ package com.portal.doccenter.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.portal.doccenter.dao.ArticleExtDao;
/*  5:   */ import com.portal.doccenter.entity.ArticleExt;
/*  6:   */ import org.hibernate.Session;
/*  7:   */ import org.springframework.stereotype.Repository;
/*  8:   */ 
/*  9:   */ @Repository
/* 10:   */ public class ArticleExtDaoImpl
/* 11:   */   extends HibernateBaseDao<ArticleExt, Integer>
/* 12:   */   implements ArticleExtDao
/* 13:   */ {
/* 14:   */   public ArticleExt findById(Integer id)
/* 15:   */   {
/* 16:13 */     ArticleExt entity = (ArticleExt)get(id);
/* 17:14 */     return entity;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public ArticleExt save(ArticleExt bean)
/* 21:   */   {
/* 22:18 */     getSession().save(bean);
/* 23:19 */     return bean;
/* 24:   */   }
/* 25:   */   
/* 26:   */   protected Class<ArticleExt> getEntityClass()
/* 27:   */   {
/* 28:24 */     return ArticleExt.class;
/* 29:   */   }
/* 30:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.dao.impl.ArticleExtDaoImpl
 * JD-Core Version:    0.7.0.1
 */