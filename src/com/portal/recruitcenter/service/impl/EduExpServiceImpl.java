/*  1:   */ package com.portal.recruitcenter.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.datacenter.commdata.service.SpecialtyService;
/*  6:   */ import com.portal.recruitcenter.dao.EduExpDao;
/*  7:   */ import com.portal.recruitcenter.entity.EduExp;
/*  8:   */ import com.portal.recruitcenter.service.EduExpService;
/*  9:   */ import com.portal.recruitcenter.service.ResumeService;
/* 10:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 11:   */ import org.springframework.stereotype.Service;
/* 12:   */ import org.springframework.transaction.annotation.Transactional;
/* 13:   */ 
/* 14:   */ @Service
/* 15:   */ @Transactional
/* 16:   */ public class EduExpServiceImpl
/* 17:   */   implements EduExpService
/* 18:   */ {
/* 19:   */   private EduExpDao dao;
/* 20:   */   private ResumeService resumeService;
/* 21:   */   private SpecialtyService specialtyService;
/* 22:   */   
/* 23:   */   @Transactional(readOnly=true)
/* 24:   */   public Pagination getPage(Integer resumeId, int pageNo, int pageSize)
/* 25:   */   {
/* 26:20 */     Pagination page = this.dao.getPage(resumeId, pageNo, pageSize);
/* 27:21 */     return page;
/* 28:   */   }
/* 29:   */   
/* 30:   */   @Transactional(readOnly=true)
/* 31:   */   public EduExp findById(Integer id)
/* 32:   */   {
/* 33:26 */     EduExp entity = this.dao.findById(id);
/* 34:27 */     return entity;
/* 35:   */   }
/* 36:   */   
/* 37:   */   public EduExp save(EduExp bean, Integer resumeId, Integer specialtyId)
/* 38:   */   {
/* 39:31 */     if (resumeId != null) {
/* 40:32 */       bean.setResume(this.resumeService.findById(resumeId));
/* 41:   */     }
/* 42:34 */     if (specialtyId != null) {
/* 43:35 */       bean.setSpecial(this.specialtyService.findById(specialtyId));
/* 44:   */     }
/* 45:37 */     bean.init();
/* 46:38 */     this.dao.save(bean);
/* 47:39 */     return bean;
/* 48:   */   }
/* 49:   */   
/* 50:   */   public EduExp update(EduExp bean, Integer specialtyId)
/* 51:   */   {
/* 52:43 */     Updater<EduExp> updater = new Updater(bean);
/* 53:44 */     bean = this.dao.updateByUpdater(updater);
/* 54:45 */     if (specialtyId != null) {
/* 55:46 */       bean.setSpecial(this.specialtyService.findById(specialtyId));
/* 56:   */     }
/* 57:48 */     return bean;
/* 58:   */   }
/* 59:   */   
/* 60:   */   public int deleteByPersonalId(Integer personalId)
/* 61:   */   {
/* 62:52 */     return this.dao.deleteByPersonalId(personalId);
/* 63:   */   }
/* 64:   */   
/* 65:   */   public int deleteByResumeId(Integer resumeId)
/* 66:   */   {
/* 67:56 */     return this.dao.deleteByResumeId(resumeId);
/* 68:   */   }
/* 69:   */   
/* 70:   */   public int deleteBySpecialId(Integer specialId)
/* 71:   */   {
/* 72:60 */     return this.dao.deleteBySpecialId(specialId);
/* 73:   */   }
/* 74:   */   
/* 75:   */   public EduExp deleteById(Integer id)
/* 76:   */   {
/* 77:64 */     EduExp bean = this.dao.deleteById(id);
/* 78:65 */     return bean;
/* 79:   */   }
/* 80:   */   
/* 81:   */   public EduExp[] deleteByIds(Integer[] ids)
/* 82:   */   {
/* 83:69 */     EduExp[] beans = new EduExp[ids.length];
/* 84:70 */     int i = 0;
/* 85:70 */     for (int len = ids.length; i < len; i++) {
/* 86:71 */       beans[i] = deleteById(ids[i]);
/* 87:   */     }
/* 88:73 */     return beans;
/* 89:   */   }
/* 90:   */   
/* 91:   */   @Autowired
/* 92:   */   public void setDao(EduExpDao dao)
/* 93:   */   {
/* 94:82 */     this.dao = dao;
/* 95:   */   }
/* 96:   */   
/* 97:   */   @Autowired
/* 98:   */   public void setResumeService(ResumeService resumeService)
/* 99:   */   {
/* :0:87 */     this.resumeService = resumeService;
/* :1:   */   }
/* :2:   */   
/* :3:   */   @Autowired
/* :4:   */   public void setSpecialtyService(SpecialtyService specialtyService)
/* :5:   */   {
/* :6:92 */     this.specialtyService = specialtyService;
/* :7:   */   }
/* :8:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.service.impl.EduExpServiceImpl
 * JD-Core Version:    0.7.0.1
 */