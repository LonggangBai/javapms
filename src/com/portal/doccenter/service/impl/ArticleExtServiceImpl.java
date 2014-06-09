/*  1:   */ package com.portal.doccenter.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.portal.doccenter.dao.ArticleExtDao;
/*  5:   */ import com.portal.doccenter.entity.Article;
/*  6:   */ import com.portal.doccenter.entity.ArticleExt;
/*  7:   */ import com.portal.doccenter.service.ArticleExtService;
/*  8:   */ import org.springframework.beans.factory.annotation.Autowired;
/*  9:   */ import org.springframework.stereotype.Service;
/* 10:   */ import org.springframework.transaction.annotation.Transactional;
/* 11:   */ 
/* 12:   */ @Service
/* 13:   */ @Transactional
/* 14:   */ public class ArticleExtServiceImpl
/* 15:   */   implements ArticleExtService
/* 16:   */ {
/* 17:   */   private ArticleExtDao dao;
/* 18:   */   
/* 19:   */   public ArticleExt save(ArticleExt ext, Article article)
/* 20:   */   {
/* 21:17 */     article.setArticleExt(ext);
/* 22:18 */     ext.setArticle(article);
/* 23:19 */     ext.init();
/* 24:20 */     this.dao.save(ext);
/* 25:21 */     article.setArticleExt(ext);
/* 26:22 */     return ext;
/* 27:   */   }
/* 28:   */   
/* 29:   */   public ArticleExt update(ArticleExt bean)
/* 30:   */   {
/* 31:26 */     Updater<ArticleExt> updater = new Updater(bean);
/* 32:27 */     bean = this.dao.updateByUpdater(updater);
/* 33:28 */     bean.blankToNull();
/* 34:29 */     return bean;
/* 35:   */   }
/* 36:   */   
/* 37:   */   @Autowired
/* 38:   */   public void setDao(ArticleExtDao dao)
/* 39:   */   {
/* 40:36 */     this.dao = dao;
/* 41:   */   }
/* 42:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.service.impl.ArticleExtServiceImpl
 * JD-Core Version:    0.7.0.1
 */