/*  1:   */ package com.portal.extrafunc.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.page.Pagination;
/*  4:   */ import com.portal.extrafunc.dao.ThemeTxtDao;
/*  5:   */ import com.portal.extrafunc.entity.Theme;
/*  6:   */ import com.portal.extrafunc.entity.ThemeTxt;
/*  7:   */ import com.portal.extrafunc.service.ThemeTxtService;
/*  8:   */ import org.springframework.beans.factory.annotation.Autowired;
/*  9:   */ import org.springframework.stereotype.Service;
/* 10:   */ import org.springframework.transaction.annotation.Transactional;
/* 11:   */ 
/* 12:   */ @Service
/* 13:   */ @Transactional
/* 14:   */ public class ThemeTxtServiceImpl
/* 15:   */   implements ThemeTxtService
/* 16:   */ {
/* 17:   */   private ThemeTxtDao dao;
/* 18:   */   
/* 19:   */   @Transactional(readOnly=true)
/* 20:   */   public Pagination getPage(int pageNo, int pageSize)
/* 21:   */   {
/* 22:18 */     Pagination page = this.dao.getPage(pageNo, pageSize);
/* 23:19 */     return page;
/* 24:   */   }
/* 25:   */   
/* 26:   */   @Transactional(readOnly=true)
/* 27:   */   public ThemeTxt findById(Integer id)
/* 28:   */   {
/* 29:24 */     ThemeTxt entity = this.dao.findById(id);
/* 30:25 */     return entity;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public ThemeTxt save(Theme theme)
/* 34:   */   {
/* 35:29 */     ThemeTxt txt = new ThemeTxt();
/* 36:30 */     txt.setContent(",");
/* 37:31 */     txt.setTheme(theme);
/* 38:32 */     this.dao.save(txt);
/* 39:33 */     theme.setTxt(txt);
/* 40:34 */     return txt;
/* 41:   */   }
/* 42:   */   
/* 43:   */   public ThemeTxt update(Integer txtId, Integer userId)
/* 44:   */   {
/* 45:38 */     ThemeTxt txt = findById(txtId);
/* 46:39 */     if (txt.getContent().indexOf("," + userId + ",") == -1) {
/* 47:40 */       txt.setContent(txt.getContent() + userId + ",");
/* 48:   */     }
/* 49:42 */     return txt;
/* 50:   */   }
/* 51:   */   
/* 52:   */   public ThemeTxt deleteById(Integer id)
/* 53:   */   {
/* 54:46 */     ThemeTxt bean = this.dao.deleteById(id);
/* 55:47 */     return bean;
/* 56:   */   }
/* 57:   */   
/* 58:   */   public ThemeTxt[] deleteByIds(Integer[] ids)
/* 59:   */   {
/* 60:51 */     ThemeTxt[] beans = new ThemeTxt[ids.length];
/* 61:52 */     int i = 0;
/* 62:52 */     for (int len = ids.length; i < len; i++) {
/* 63:53 */       beans[i] = deleteById(ids[i]);
/* 64:   */     }
/* 65:55 */     return beans;
/* 66:   */   }
/* 67:   */   
/* 68:   */   @Autowired
/* 69:   */   public void setDao(ThemeTxtDao dao)
/* 70:   */   {
/* 71:62 */     this.dao = dao;
/* 72:   */   }
/* 73:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.impl.ThemeTxtServiceImpl
 * JD-Core Version:    0.7.0.1
 */