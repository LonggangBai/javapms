/*  1:   */ package com.portal.doccenter.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.portal.doccenter.dao.ArticleTxtDao;
/*  5:   */ import com.portal.doccenter.entity.ArticleTxt;
/*  6:   */ import org.hibernate.Session;
/*  7:   */ import org.springframework.stereotype.Repository;
/*  8:   */ 
/*  9:   */ @Repository
/* 10:   */ public class ArticleTxtDaoImpl
/* 11:   */   extends HibernateBaseDao<ArticleTxt, Integer>
/* 12:   */   implements ArticleTxtDao
/* 13:   */ {
/* 14:   */   public ArticleTxt findById(Integer id)
/* 15:   */   {
/* 16:13 */     ArticleTxt entity = (ArticleTxt)get(id);
/* 17:14 */     return entity;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public ArticleTxt save(ArticleTxt bean)
/* 21:   */   {
/* 22:18 */     getSession().save(bean);
/* 23:19 */     return bean;
/* 24:   */   }
/* 25:   */   
/* 26:   */   protected Class<ArticleTxt> getEntityClass()
/* 27:   */   {
/* 28:24 */     return ArticleTxt.class;
/* 29:   */   }
/* 30:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.dao.impl.ArticleTxtDaoImpl
 * JD-Core Version:    0.7.0.1
 */