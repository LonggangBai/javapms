/*  1:   */ package com.portal.doccenter.service.impl;
/*  2:   */ 
/*  3:   */ import com.portal.doccenter.dao.DocStatisDao;
/*  4:   */ import com.portal.doccenter.entity.Article;
/*  5:   */ import com.portal.doccenter.entity.DocStatis;
/*  6:   */ import com.portal.doccenter.service.DocStatisService;
/*  7:   */ import org.springframework.beans.factory.annotation.Autowired;
/*  8:   */ import org.springframework.stereotype.Service;
/*  9:   */ import org.springframework.transaction.annotation.Transactional;
/* 10:   */ 
/* 11:   */ @Service
/* 12:   */ @Transactional
/* 13:   */ public class DocStatisServiceImpl
/* 14:   */   implements DocStatisService
/* 15:   */ {
/* 16:   */   private DocStatisDao dao;
/* 17:   */   
/* 18:   */   public DocStatis save(Article article)
/* 19:   */   {
/* 20:16 */     DocStatis statis = new DocStatis();
/* 21:17 */     statis.setDoc(article);
/* 22:18 */     statis.init();
/* 23:19 */     this.dao.save(statis);
/* 24:20 */     article.setDocStatis(statis);
/* 25:21 */     return statis;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public DocStatis update(Integer statisId, Integer viewsCount)
/* 29:   */   {
/* 30:25 */     DocStatis entity = this.dao.findById(statisId);
/* 31:26 */     entity.setViewsCount(viewsCount);
/* 32:27 */     return entity;
/* 33:   */   }
/* 34:   */   
/* 35:   */   @Transactional(readOnly=true)
/* 36:   */   public DocStatis findById(Integer id)
/* 37:   */   {
/* 38:32 */     DocStatis entity = this.dao.findById(id);
/* 39:33 */     return entity;
/* 40:   */   }
/* 41:   */   
/* 42:   */   @Autowired
/* 43:   */   public void setDao(DocStatisDao dao)
/* 44:   */   {
/* 45:40 */     this.dao = dao;
/* 46:   */   }
/* 47:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.service.impl.DocStatisServiceImpl
 * JD-Core Version:    0.7.0.1
 */