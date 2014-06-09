/*   1:    */ package com.portal.recruitcenter.service.impl;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.hibernate3.Updater;
/*   4:    */ import com.javapms.basic.page.Pagination;
/*   5:    */ import com.portal.datacenter.commdata.service.IndustryService;
/*   6:    */ import com.portal.datacenter.commdata.service.MetierService;
/*   7:    */ import com.portal.recruitcenter.dao.JobIntentDao;
/*   8:    */ import com.portal.recruitcenter.entity.JobIntent;
/*   9:    */ import com.portal.recruitcenter.entity.Resume;
/*  10:    */ import com.portal.recruitcenter.service.JobIntentService;
/*  11:    */ import com.portal.recruitcenter.service.ResumeService;
/*  12:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  13:    */ import org.springframework.stereotype.Service;
/*  14:    */ import org.springframework.transaction.annotation.Transactional;
/*  15:    */ 
/*  16:    */ @Service
/*  17:    */ @Transactional
/*  18:    */ public class JobIntentServiceImpl
/*  19:    */   implements JobIntentService
/*  20:    */ {
/*  21:    */   private JobIntentDao dao;
/*  22:    */   private ResumeService resumeService;
/*  23:    */   private MetierService metierService;
/*  24:    */   private IndustryService industryService;
/*  25:    */   
/*  26:    */   @Transactional(readOnly=true)
/*  27:    */   public Pagination getPage(int pageNo, int pageSize)
/*  28:    */   {
/*  29: 22 */     Pagination page = this.dao.getPage(pageNo, pageSize);
/*  30: 23 */     return page;
/*  31:    */   }
/*  32:    */   
/*  33:    */   @Transactional(readOnly=true)
/*  34:    */   public Pagination getPageByTag(String key, Integer personalId, Integer metierId, Integer industryId, Integer specialId, Byte wage, Byte edu, Byte minwork, Byte maxwork, Boolean gender, Boolean show, int pageNo, int pageSize)
/*  35:    */   {
/*  36: 31 */     return this.dao.getPageByTag(key, personalId, metierId, industryId, 
/*  37: 32 */       specialId, wage, edu, minwork, maxwork, gender, show, pageNo, 
/*  38: 33 */       pageSize);
/*  39:    */   }
/*  40:    */   
/*  41:    */   @Transactional(readOnly=true)
/*  42:    */   public JobIntent findById(Integer id)
/*  43:    */   {
/*  44: 38 */     JobIntent entity = this.dao.findById(id);
/*  45: 39 */     return entity;
/*  46:    */   }
/*  47:    */   
/*  48:    */   public JobIntent save(JobIntent bean, Integer resumeId, Integer metierId, Integer metierId2, Integer industryId)
/*  49:    */   {
/*  50: 44 */     Resume resume = this.resumeService.findById(resumeId);
/*  51: 45 */     bean.setResume(resume);
/*  52: 46 */     if (metierId != null) {
/*  53: 47 */       bean.setMetier(this.metierService.findById(metierId));
/*  54:    */     }
/*  55: 49 */     if (metierId2 != null) {
/*  56: 50 */       bean.setMetier2(this.metierService.findById(metierId2));
/*  57:    */     }
/*  58: 52 */     if (industryId != null) {
/*  59: 53 */       bean.setIndustry(this.industryService.findById(industryId));
/*  60:    */     }
/*  61: 55 */     bean.init();
/*  62: 56 */     this.dao.save(bean);
/*  63: 57 */     resume.setIntent(bean);
/*  64: 58 */     return bean;
/*  65:    */   }
/*  66:    */   
/*  67:    */   public JobIntent update(JobIntent bean, Integer resumeId, Integer metierId, Integer metierId2, Integer industryId)
/*  68:    */   {
/*  69: 63 */     bean.setId(resumeId);
/*  70: 64 */     Updater<JobIntent> updater = new Updater(bean);
/*  71: 65 */     bean = this.dao.updateByUpdater(updater);
/*  72: 66 */     if (metierId != null) {
/*  73: 67 */       bean.setMetier(this.metierService.findById(metierId));
/*  74:    */     }
/*  75: 69 */     if (metierId2 != null) {
/*  76: 70 */       bean.setMetier2(this.metierService.findById(metierId2));
/*  77:    */     }
/*  78: 72 */     if (industryId != null) {
/*  79: 73 */       bean.setIndustry(this.industryService.findById(industryId));
/*  80:    */     }
/*  81: 75 */     return bean;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public int deleteByPersonalId(Integer personalId)
/*  85:    */   {
/*  86: 79 */     return this.dao.deleteByPersonalId(personalId);
/*  87:    */   }
/*  88:    */   
/*  89:    */   public JobIntent deleteById(Integer id)
/*  90:    */   {
/*  91: 83 */     JobIntent bean = this.dao.deleteById(id);
/*  92: 84 */     return bean;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public JobIntent[] deleteByIds(Integer[] ids)
/*  96:    */   {
/*  97: 88 */     JobIntent[] beans = new JobIntent[ids.length];
/*  98: 89 */     int i = 0;
/*  99: 89 */     for (int len = ids.length; i < len; i++) {
/* 100: 90 */       beans[i] = deleteById(ids[i]);
/* 101:    */     }
/* 102: 92 */     return beans;
/* 103:    */   }
/* 104:    */   
/* 105:    */   @Autowired
/* 106:    */   public void setDao(JobIntentDao dao)
/* 107:    */   {
/* 108:102 */     this.dao = dao;
/* 109:    */   }
/* 110:    */   
/* 111:    */   @Autowired
/* 112:    */   public void setResumeService(ResumeService resumeService)
/* 113:    */   {
/* 114:107 */     this.resumeService = resumeService;
/* 115:    */   }
/* 116:    */   
/* 117:    */   @Autowired
/* 118:    */   public void setMetierService(MetierService metierService)
/* 119:    */   {
/* 120:112 */     this.metierService = metierService;
/* 121:    */   }
/* 122:    */   
/* 123:    */   @Autowired
/* 124:    */   public void setIndustryService(IndustryService industryService)
/* 125:    */   {
/* 126:117 */     this.industryService = industryService;
/* 127:    */   }
/* 128:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.service.impl.JobIntentServiceImpl
 * JD-Core Version:    0.7.0.1
 */