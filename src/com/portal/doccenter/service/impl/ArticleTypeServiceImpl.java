/*  1:   */ package com.portal.doccenter.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.portal.doccenter.dao.ArticleTypeDao;
/*  5:   */ import com.portal.doccenter.entity.ArticleType;
/*  6:   */ import com.portal.doccenter.service.ArticleTypeService;
/*  7:   */ import java.util.List;
/*  8:   */ import org.springframework.beans.factory.annotation.Autowired;
/*  9:   */ import org.springframework.stereotype.Service;
/* 10:   */ import org.springframework.transaction.annotation.Transactional;
/* 11:   */ 
/* 12:   */ @Service
/* 13:   */ @Transactional
/* 14:   */ public class ArticleTypeServiceImpl
/* 15:   */   implements ArticleTypeService
/* 16:   */ {
/* 17:   */   private ArticleTypeDao dao;
/* 18:   */   
/* 19:   */   @Transactional(readOnly=true)
/* 20:   */   public List<ArticleType> getList(boolean containDisabled, String sortname, String sortorder)
/* 21:   */   {
/* 22:20 */     return this.dao.getList(containDisabled, sortname, sortorder);
/* 23:   */   }
/* 24:   */   
/* 25:   */   @Transactional(readOnly=true)
/* 26:   */   public ArticleType getDef()
/* 27:   */   {
/* 28:25 */     return this.dao.getDef();
/* 29:   */   }
/* 30:   */   
/* 31:   */   @Transactional(readOnly=true)
/* 32:   */   public ArticleType findById(Integer id)
/* 33:   */   {
/* 34:30 */     ArticleType entity = this.dao.findById(id);
/* 35:31 */     return entity;
/* 36:   */   }
/* 37:   */   
/* 38:   */   public ArticleType save(ArticleType bean)
/* 39:   */   {
/* 40:35 */     this.dao.save(bean);
/* 41:36 */     return bean;
/* 42:   */   }
/* 43:   */   
/* 44:   */   public ArticleType update(ArticleType bean)
/* 45:   */   {
/* 46:40 */     Updater<ArticleType> updater = new Updater(bean);
/* 47:41 */     ArticleType entity = this.dao.updateByUpdater(updater);
/* 48:42 */     return entity;
/* 49:   */   }
/* 50:   */   
/* 51:   */   public ArticleType deleteById(Integer id)
/* 52:   */   {
/* 53:46 */     ArticleType bean = this.dao.deleteById(id);
/* 54:47 */     return bean;
/* 55:   */   }
/* 56:   */   
/* 57:   */   public ArticleType[] deleteByIds(Integer[] ids)
/* 58:   */   {
/* 59:51 */     ArticleType[] beans = new ArticleType[ids.length];
/* 60:52 */     int i = 0;
/* 61:52 */     for (int len = ids.length; i < len; i++) {
/* 62:53 */       beans[i] = deleteById(ids[i]);
/* 63:   */     }
/* 64:55 */     return beans;
/* 65:   */   }
/* 66:   */   
/* 67:   */   @Autowired
/* 68:   */   public void setDao(ArticleTypeDao dao)
/* 69:   */   {
/* 70:62 */     this.dao = dao;
/* 71:   */   }
/* 72:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.service.impl.ArticleTypeServiceImpl
 * JD-Core Version:    0.7.0.1
 */