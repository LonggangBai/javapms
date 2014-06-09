/*  1:   */ package com.portal.extrafunc.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.extrafunc.dao.SurveyDetailDao;
/*  6:   */ import com.portal.extrafunc.entity.SurveyDetail;
/*  7:   */ import com.portal.extrafunc.entity.SurveyTheme;
/*  8:   */ import com.portal.extrafunc.service.SurveyDetailService;
/*  9:   */ import com.portal.usermgr.entity.User;
/* 10:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 11:   */ import org.springframework.stereotype.Service;
/* 12:   */ import org.springframework.transaction.annotation.Transactional;
/* 13:   */ 
/* 14:   */ @Service
/* 15:   */ @Transactional
/* 16:   */ public class SurveyDetailServiceImpl
/* 17:   */   implements SurveyDetailService
/* 18:   */ {
/* 19:   */   private SurveyDetailDao dao;
/* 20:   */   
/* 21:   */   @Transactional(readOnly=true)
/* 22:   */   public Pagination getPage(Integer surveyId, int pageNo, int pageSize)
/* 23:   */   {
/* 24:20 */     Pagination page = this.dao.getPage(surveyId, pageNo, pageSize);
/* 25:21 */     return page;
/* 26:   */   }
/* 27:   */   
/* 28:   */   @Transactional(readOnly=true)
/* 29:   */   public SurveyDetail findById(Integer id)
/* 30:   */   {
/* 31:26 */     SurveyDetail entity = this.dao.findById(id);
/* 32:27 */     return entity;
/* 33:   */   }
/* 34:   */   
/* 35:   */   public SurveyDetail save(String content, SurveyTheme st, User user)
/* 36:   */   {
/* 37:31 */     SurveyDetail bean = new SurveyDetail();
/* 38:32 */     bean.setSurvey(st);
/* 39:33 */     bean.setUser(user);
/* 40:34 */     bean.setContent(content);
/* 41:35 */     bean.init();
/* 42:36 */     this.dao.save(bean);
/* 43:37 */     return bean;
/* 44:   */   }
/* 45:   */   
/* 46:   */   public SurveyDetail update(SurveyDetail bean)
/* 47:   */   {
/* 48:41 */     Updater<SurveyDetail> updater = new Updater(bean);
/* 49:42 */     bean = this.dao.updateByUpdater(updater);
/* 50:43 */     return bean;
/* 51:   */   }
/* 52:   */   
/* 53:   */   public SurveyDetail deleteById(Integer id)
/* 54:   */   {
/* 55:47 */     SurveyDetail bean = this.dao.deleteById(id);
/* 56:48 */     return bean;
/* 57:   */   }
/* 58:   */   
/* 59:   */   public SurveyDetail[] deleteByIds(Integer[] ids)
/* 60:   */   {
/* 61:52 */     SurveyDetail[] beans = new SurveyDetail[ids.length];
/* 62:53 */     int i = 0;
/* 63:53 */     for (int len = ids.length; i < len; i++) {
/* 64:54 */       beans[i] = deleteById(ids[i]);
/* 65:   */     }
/* 66:56 */     return beans;
/* 67:   */   }
/* 68:   */   
/* 69:   */   @Autowired
/* 70:   */   public void setDao(SurveyDetailDao dao)
/* 71:   */   {
/* 72:63 */     this.dao = dao;
/* 73:   */   }
/* 74:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.impl.SurveyDetailServiceImpl
 * JD-Core Version:    0.7.0.1
 */