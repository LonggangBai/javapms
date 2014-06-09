/*  1:   */ package com.portal.doccenter.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.portal.doccenter.dao.ArticleTxtDao;
/*  5:   */ import com.portal.doccenter.entity.Article;
/*  6:   */ import com.portal.doccenter.entity.ArticleTxt;
/*  7:   */ import com.portal.doccenter.service.ArticleTxtService;
/*  8:   */ import org.springframework.beans.factory.annotation.Autowired;
/*  9:   */ import org.springframework.stereotype.Service;
/* 10:   */ import org.springframework.transaction.annotation.Transactional;
/* 11:   */ 
/* 12:   */ @Service
/* 13:   */ @Transactional
/* 14:   */ public class ArticleTxtServiceImpl
/* 15:   */   implements ArticleTxtService
/* 16:   */ {
/* 17:   */   private ArticleTxtDao dao;
/* 18:   */   
/* 19:   */   public ArticleTxt save(ArticleTxt txt, Article article)
/* 20:   */   {
/* 21:17 */     if (txt.isAllBlank()) {
/* 22:18 */       return null;
/* 23:   */     }
/* 24:20 */     txt.setArticle(article);
/* 25:21 */     txt.init();
/* 26:22 */     this.dao.save(txt);
/* 27:23 */     article.setArticleTxt(txt);
/* 28:24 */     return txt;
/* 29:   */   }
/* 30:   */   
/* 31:   */   public ArticleTxt update(ArticleTxt txt, Article article)
/* 32:   */   {
/* 33:29 */     ArticleTxt entity = this.dao.findById(article.getId());
/* 34:30 */     if (entity == null)
/* 35:   */     {
/* 36:31 */       entity = save(txt, article);
/* 37:32 */       return entity;
/* 38:   */     }
/* 39:34 */     Updater<ArticleTxt> updater = new Updater(txt);
/* 40:35 */     entity = this.dao.updateByUpdater(updater);
/* 41:36 */     entity.blankToNull();
/* 42:37 */     return entity;
/* 43:   */   }
/* 44:   */   
/* 45:   */   @Autowired
/* 46:   */   public void setDao(ArticleTxtDao dao)
/* 47:   */   {
/* 48:45 */     this.dao = dao;
/* 49:   */   }
/* 50:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.service.impl.ArticleTxtServiceImpl
 * JD-Core Version:    0.7.0.1
 */