/*  1:   */ package com.portal.extrafunc.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.extrafunc.dao.QuestionDetailDao;
/*  6:   */ import com.portal.extrafunc.entity.QuestionDetail;
/*  7:   */ import com.portal.extrafunc.entity.Questionnaire;
/*  8:   */ import com.portal.extrafunc.service.QuestionDetailService;
/*  9:   */ import com.portal.usermgr.entity.User;
/* 10:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 11:   */ import org.springframework.stereotype.Service;
/* 12:   */ import org.springframework.transaction.annotation.Transactional;
/* 13:   */ 
/* 14:   */ @Service
/* 15:   */ @Transactional
/* 16:   */ public class QuestionDetailServiceImpl
/* 17:   */   implements QuestionDetailService
/* 18:   */ {
/* 19:   */   private QuestionDetailDao dao;
/* 20:   */   
/* 21:   */   @Transactional(readOnly=true)
/* 22:   */   public Pagination getPage(Integer questionId, int pageNo, int pageSize)
/* 23:   */   {
/* 24:20 */     Pagination page = this.dao.getPage(questionId, pageNo, pageSize);
/* 25:21 */     return page;
/* 26:   */   }
/* 27:   */   
/* 28:   */   @Transactional(readOnly=true)
/* 29:   */   public QuestionDetail getDetail(Integer questionId, Integer userId, String ip)
/* 30:   */   {
/* 31:27 */     return this.dao.getDetail(questionId, userId, ip);
/* 32:   */   }
/* 33:   */   
/* 34:   */   @Transactional(readOnly=true)
/* 35:   */   public long getCountDetail(Integer questionId)
/* 36:   */   {
/* 37:32 */     return this.dao.getCountDetail(questionId);
/* 38:   */   }
/* 39:   */   
/* 40:   */   @Transactional(readOnly=true)
/* 41:   */   public QuestionDetail findById(Integer id)
/* 42:   */   {
/* 43:37 */     QuestionDetail entity = this.dao.findById(id);
/* 44:38 */     return entity;
/* 45:   */   }
/* 46:   */   
/* 47:   */   public QuestionDetail save(Questionnaire question, User user, String ip)
/* 48:   */   {
/* 49:42 */     QuestionDetail bean = new QuestionDetail();
/* 50:43 */     bean.setQuestion(question);
/* 51:44 */     bean.setUser(user);
/* 52:45 */     bean.setIp(ip);
/* 53:46 */     bean.init();
/* 54:47 */     this.dao.save(bean);
/* 55:48 */     return bean;
/* 56:   */   }
/* 57:   */   
/* 58:   */   public QuestionDetail update(QuestionDetail bean)
/* 59:   */   {
/* 60:52 */     Updater<QuestionDetail> updater = new Updater(bean);
/* 61:53 */     bean = this.dao.updateByUpdater(updater);
/* 62:54 */     return bean;
/* 63:   */   }
/* 64:   */   
/* 65:   */   public QuestionDetail deleteById(Integer id)
/* 66:   */   {
/* 67:58 */     QuestionDetail bean = this.dao.deleteById(id);
/* 68:59 */     return bean;
/* 69:   */   }
/* 70:   */   
/* 71:   */   public QuestionDetail[] deleteByIds(Integer[] ids)
/* 72:   */   {
/* 73:63 */     QuestionDetail[] beans = new QuestionDetail[ids.length];
/* 74:64 */     int i = 0;
/* 75:64 */     for (int len = ids.length; i < len; i++) {
/* 76:65 */       beans[i] = deleteById(ids[i]);
/* 77:   */     }
/* 78:67 */     return beans;
/* 79:   */   }
/* 80:   */   
/* 81:   */   @Autowired
/* 82:   */   public void setDao(QuestionDetailDao dao)
/* 83:   */   {
/* 84:74 */     this.dao = dao;
/* 85:   */   }
/* 86:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.impl.QuestionDetailServiceImpl
 * JD-Core Version:    0.7.0.1
 */