/*  1:   */ package com.portal.recruitcenter.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.recruitcenter.dao.TrainDao;
/*  6:   */ import com.portal.recruitcenter.entity.Train;
/*  7:   */ import com.portal.recruitcenter.service.ResumeService;
/*  8:   */ import com.portal.recruitcenter.service.TrainService;
/*  9:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 10:   */ import org.springframework.stereotype.Service;
/* 11:   */ import org.springframework.transaction.annotation.Transactional;
/* 12:   */ 
/* 13:   */ @Service
/* 14:   */ @Transactional
/* 15:   */ public class TrainServiceImpl
/* 16:   */   implements TrainService
/* 17:   */ {
/* 18:   */   private TrainDao dao;
/* 19:   */   private ResumeService resumeService;
/* 20:   */   
/* 21:   */   @Transactional(readOnly=true)
/* 22:   */   public Pagination getPage(Integer resumeId, int pageNo, int pageSize)
/* 23:   */   {
/* 24:19 */     Pagination page = this.dao.getPage(resumeId, pageNo, pageSize);
/* 25:20 */     return page;
/* 26:   */   }
/* 27:   */   
/* 28:   */   @Transactional(readOnly=true)
/* 29:   */   public Train findById(Integer id)
/* 30:   */   {
/* 31:25 */     Train entity = this.dao.findById(id);
/* 32:26 */     return entity;
/* 33:   */   }
/* 34:   */   
/* 35:   */   public Train save(Train bean, Integer resumeId)
/* 36:   */   {
/* 37:30 */     if (resumeId != null) {
/* 38:31 */       bean.setResume(this.resumeService.findById(resumeId));
/* 39:   */     }
/* 40:33 */     bean.init();
/* 41:34 */     this.dao.save(bean);
/* 42:35 */     return bean;
/* 43:   */   }
/* 44:   */   
/* 45:   */   public Train update(Train bean)
/* 46:   */   {
/* 47:39 */     Updater<Train> updater = new Updater(bean);
/* 48:40 */     bean = this.dao.updateByUpdater(updater);
/* 49:41 */     return bean;
/* 50:   */   }
/* 51:   */   
/* 52:   */   public int deleteByPersonalId(Integer personalId)
/* 53:   */   {
/* 54:45 */     return this.dao.deleteByPersonalId(personalId);
/* 55:   */   }
/* 56:   */   
/* 57:   */   public int deleteByResumeId(Integer resumeId)
/* 58:   */   {
/* 59:49 */     return this.dao.deleteByResumeId(resumeId);
/* 60:   */   }
/* 61:   */   
/* 62:   */   public Train deleteById(Integer id)
/* 63:   */   {
/* 64:53 */     Train bean = this.dao.deleteById(id);
/* 65:54 */     return bean;
/* 66:   */   }
/* 67:   */   
/* 68:   */   public Train[] deleteByIds(Integer[] ids)
/* 69:   */   {
/* 70:58 */     Train[] beans = new Train[ids.length];
/* 71:59 */     int i = 0;
/* 72:59 */     for (int len = ids.length; i < len; i++) {
/* 73:60 */       beans[i] = deleteById(ids[i]);
/* 74:   */     }
/* 75:62 */     return beans;
/* 76:   */   }
/* 77:   */   
/* 78:   */   @Autowired
/* 79:   */   public void setDao(TrainDao dao)
/* 80:   */   {
/* 81:70 */     this.dao = dao;
/* 82:   */   }
/* 83:   */   
/* 84:   */   @Autowired
/* 85:   */   public void setResumeService(ResumeService resumeService)
/* 86:   */   {
/* 87:75 */     this.resumeService = resumeService;
/* 88:   */   }
/* 89:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.service.impl.TrainServiceImpl
 * JD-Core Version:    0.7.0.1
 */