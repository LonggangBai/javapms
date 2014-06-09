/*  1:   */ package com.portal.extrafunc.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.extrafunc.dao.QuestionnaireDao;
/*  6:   */ import com.portal.extrafunc.entity.Questionnaire;
/*  7:   */ import com.portal.extrafunc.service.QuestionnaireService;
/*  8:   */ import com.portal.sysmgr.entity.Site;
/*  9:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 10:   */ import org.springframework.stereotype.Service;
/* 11:   */ import org.springframework.transaction.annotation.Transactional;
/* 12:   */ 
/* 13:   */ @Service
/* 14:   */ @Transactional
/* 15:   */ public class QuestionnaireServiceImpl
/* 16:   */   implements QuestionnaireService
/* 17:   */ {
/* 18:   */   private QuestionnaireDao dao;
/* 19:   */   
/* 20:   */   @Transactional(readOnly=true)
/* 21:   */   public Pagination getPage(Integer siteId, boolean enable, int pageNo, int pageSize)
/* 22:   */   {
/* 23:20 */     Pagination page = this.dao.getPage(siteId, enable, pageNo, pageSize);
/* 24:21 */     return page;
/* 25:   */   }
/* 26:   */   
/* 27:   */   @Transactional(readOnly=true)
/* 28:   */   public Questionnaire findById(Integer id)
/* 29:   */   {
/* 30:26 */     Questionnaire entity = this.dao.findById(id);
/* 31:27 */     return entity;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public Questionnaire save(Questionnaire bean, Site site)
/* 35:   */   {
/* 36:31 */     bean.setSite(site);
/* 37:32 */     bean.init();
/* 38:33 */     this.dao.save(bean);
/* 39:34 */     return bean;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public Questionnaire update(Questionnaire bean)
/* 43:   */   {
/* 44:38 */     bean.updateinit();
/* 45:39 */     Updater<Questionnaire> updater = new Updater(bean);
/* 46:40 */     bean = this.dao.updateByUpdater(updater);
/* 47:41 */     return bean;
/* 48:   */   }
/* 49:   */   
/* 50:   */   public Questionnaire deleteById(Integer id)
/* 51:   */   {
/* 52:45 */     Questionnaire bean = this.dao.deleteById(id);
/* 53:46 */     return bean;
/* 54:   */   }
/* 55:   */   
/* 56:   */   public Questionnaire[] deleteByIds(Integer[] ids)
/* 57:   */   {
/* 58:50 */     Questionnaire[] beans = new Questionnaire[ids.length];
/* 59:51 */     int i = 0;
/* 60:51 */     for (int len = ids.length; i < len; i++) {
/* 61:52 */       beans[i] = deleteById(ids[i]);
/* 62:   */     }
/* 63:54 */     return beans;
/* 64:   */   }
/* 65:   */   
/* 66:   */   @Autowired
/* 67:   */   public void setDao(QuestionnaireDao dao)
/* 68:   */   {
/* 69:61 */     this.dao = dao;
/* 70:   */   }
/* 71:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.impl.QuestionnaireServiceImpl
 * JD-Core Version:    0.7.0.1
 */