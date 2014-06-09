/*   1:    */ package com.portal.recruitcenter.service.impl;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.hibernate3.Updater;
/*   4:    */ import com.javapms.basic.page.Pagination;
/*   5:    */ import com.portal.recruitcenter.dao.ResumeApplyDao;
/*   6:    */ import com.portal.recruitcenter.entity.ResumeApply;
/*   7:    */ import com.portal.recruitcenter.service.JobPostService;
/*   8:    */ import com.portal.recruitcenter.service.ResumeApplyService;
/*   9:    */ import com.portal.recruitcenter.service.ResumeService;
/*  10:    */ import java.sql.Timestamp;
/*  11:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  12:    */ import org.springframework.stereotype.Service;
/*  13:    */ import org.springframework.transaction.annotation.Transactional;
/*  14:    */ 
/*  15:    */ @Service
/*  16:    */ @Transactional
/*  17:    */ public class ResumeApplyServiceImpl
/*  18:    */   implements ResumeApplyService
/*  19:    */ {
/*  20:    */   private ResumeApplyDao dao;
/*  21:    */   private JobPostService jobPostService;
/*  22:    */   private ResumeService resumeService;
/*  23:    */   
/*  24:    */   @Transactional(readOnly=true)
/*  25:    */   public Pagination getPage(int pageNo, int pageSize)
/*  26:    */   {
/*  27: 22 */     Pagination page = this.dao.getPage(pageNo, pageSize);
/*  28: 23 */     return page;
/*  29:    */   }
/*  30:    */   
/*  31:    */   @Transactional(readOnly=true)
/*  32:    */   public Pagination getPageByTag(Integer personalId, Integer companyId, int pageNo, int pageSize)
/*  33:    */   {
/*  34: 29 */     return this.dao.getPageByTag(personalId, companyId, pageNo, pageSize);
/*  35:    */   }
/*  36:    */   
/*  37:    */   public ResumeApply getApply(Integer resumeId, Integer jobId)
/*  38:    */   {
/*  39: 33 */     return this.dao.getApply(resumeId, jobId);
/*  40:    */   }
/*  41:    */   
/*  42:    */   @Transactional(readOnly=true)
/*  43:    */   public ResumeApply findById(Integer id)
/*  44:    */   {
/*  45: 38 */     ResumeApply entity = this.dao.findById(id);
/*  46: 39 */     return entity;
/*  47:    */   }
/*  48:    */   
/*  49:    */   public ResumeApply save(ResumeApply bean)
/*  50:    */   {
/*  51: 43 */     this.dao.save(bean);
/*  52: 44 */     return bean;
/*  53:    */   }
/*  54:    */   
/*  55:    */   public ResumeApply saveApply(Integer resumeId, Integer jobId)
/*  56:    */   {
/*  57: 48 */     ResumeApply apply = new ResumeApply();
/*  58: 49 */     apply.setRead(Boolean.valueOf(false));
/*  59: 50 */     apply.setCreateTime(new Timestamp(System.currentTimeMillis()));
/*  60: 51 */     apply.setResume(this.resumeService.findById(resumeId));
/*  61: 52 */     apply.setJob(this.jobPostService.findById(jobId));
/*  62: 53 */     this.dao.save(apply);
/*  63: 54 */     return apply;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public ResumeApply update(ResumeApply bean)
/*  67:    */   {
/*  68: 58 */     Updater<ResumeApply> updater = new Updater(bean);
/*  69: 59 */     bean = this.dao.updateByUpdater(updater);
/*  70: 60 */     return bean;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public int deleteByCompanyId(Integer companyId)
/*  74:    */   {
/*  75: 64 */     return this.dao.deleteByCompanyId(companyId);
/*  76:    */   }
/*  77:    */   
/*  78:    */   public int deleteByJobId(Integer jobId)
/*  79:    */   {
/*  80: 68 */     return this.dao.deleteByJobId(jobId);
/*  81:    */   }
/*  82:    */   
/*  83:    */   public int deleteByResumelId(Integer resumeId)
/*  84:    */   {
/*  85: 72 */     return this.dao.deleteByResumelId(resumeId);
/*  86:    */   }
/*  87:    */   
/*  88:    */   public int deleteByPersonalId(Integer personalId)
/*  89:    */   {
/*  90: 76 */     return this.dao.deleteByPersonalId(personalId);
/*  91:    */   }
/*  92:    */   
/*  93:    */   public int deleteByMetierId(Integer metierId)
/*  94:    */   {
/*  95: 80 */     return this.dao.deleteByMetierId(metierId);
/*  96:    */   }
/*  97:    */   
/*  98:    */   public ResumeApply deleteById(Integer id)
/*  99:    */   {
/* 100: 84 */     ResumeApply bean = this.dao.deleteById(id);
/* 101: 85 */     return bean;
/* 102:    */   }
/* 103:    */   
/* 104:    */   public ResumeApply[] deleteByIds(Integer[] ids)
/* 105:    */   {
/* 106: 89 */     ResumeApply[] beans = new ResumeApply[ids.length];
/* 107: 90 */     int i = 0;
/* 108: 90 */     for (int len = ids.length; i < len; i++) {
/* 109: 91 */       beans[i] = deleteById(ids[i]);
/* 110:    */     }
/* 111: 93 */     return beans;
/* 112:    */   }
/* 113:    */   
/* 114:    */   @Autowired
/* 115:    */   public void setDao(ResumeApplyDao dao)
/* 116:    */   {
/* 117:102 */     this.dao = dao;
/* 118:    */   }
/* 119:    */   
/* 120:    */   @Autowired
/* 121:    */   public void setJobPostService(JobPostService jobPostService)
/* 122:    */   {
/* 123:107 */     this.jobPostService = jobPostService;
/* 124:    */   }
/* 125:    */   
/* 126:    */   @Autowired
/* 127:    */   public void setResumeService(ResumeService resumeService)
/* 128:    */   {
/* 129:112 */     this.resumeService = resumeService;
/* 130:    */   }
/* 131:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.service.impl.ResumeApplyServiceImpl
 * JD-Core Version:    0.7.0.1
 */