/*  1:   */ package com.portal.extrafunc.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.page.Pagination;
/*  4:   */ import com.portal.extrafunc.dao.PostsTxtDao;
/*  5:   */ import com.portal.extrafunc.entity.Posts;
/*  6:   */ import com.portal.extrafunc.entity.PostsTxt;
/*  7:   */ import com.portal.extrafunc.service.PostsTxtService;
/*  8:   */ import org.springframework.beans.factory.annotation.Autowired;
/*  9:   */ import org.springframework.stereotype.Service;
/* 10:   */ import org.springframework.transaction.annotation.Transactional;
/* 11:   */ 
/* 12:   */ @Service
/* 13:   */ @Transactional
/* 14:   */ public class PostsTxtServiceImpl
/* 15:   */   implements PostsTxtService
/* 16:   */ {
/* 17:   */   private PostsTxtDao dao;
/* 18:   */   
/* 19:   */   @Transactional(readOnly=true)
/* 20:   */   public Pagination getPage(int pageNo, int pageSize)
/* 21:   */   {
/* 22:18 */     Pagination page = this.dao.getPage(pageNo, pageSize);
/* 23:19 */     return page;
/* 24:   */   }
/* 25:   */   
/* 26:   */   @Transactional(readOnly=true)
/* 27:   */   public PostsTxt findById(Integer id)
/* 28:   */   {
/* 29:24 */     PostsTxt entity = this.dao.findById(id);
/* 30:25 */     return entity;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public PostsTxt save(String content, Posts posts)
/* 34:   */   {
/* 35:29 */     PostsTxt txt = new PostsTxt();
/* 36:30 */     txt.setContent(content);
/* 37:31 */     txt.setPosts(posts);
/* 38:32 */     this.dao.save(txt);
/* 39:33 */     posts.setTxt(txt);
/* 40:34 */     return txt;
/* 41:   */   }
/* 42:   */   
/* 43:   */   public PostsTxt update(Integer txtId, String content)
/* 44:   */   {
/* 45:38 */     PostsTxt txt = findById(txtId);
/* 46:39 */     txt.setContent(content);
/* 47:40 */     return txt;
/* 48:   */   }
/* 49:   */   
/* 50:   */   public PostsTxt deleteById(Integer id)
/* 51:   */   {
/* 52:44 */     PostsTxt bean = this.dao.deleteById(id);
/* 53:45 */     return bean;
/* 54:   */   }
/* 55:   */   
/* 56:   */   public PostsTxt[] deleteByIds(Integer[] ids)
/* 57:   */   {
/* 58:49 */     PostsTxt[] beans = new PostsTxt[ids.length];
/* 59:50 */     int i = 0;
/* 60:50 */     for (int len = ids.length; i < len; i++) {
/* 61:51 */       beans[i] = deleteById(ids[i]);
/* 62:   */     }
/* 63:53 */     return beans;
/* 64:   */   }
/* 65:   */   
/* 66:   */   @Autowired
/* 67:   */   public void setDao(PostsTxtDao dao)
/* 68:   */   {
/* 69:60 */     this.dao = dao;
/* 70:   */   }
/* 71:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.impl.PostsTxtServiceImpl
 * JD-Core Version:    0.7.0.1
 */