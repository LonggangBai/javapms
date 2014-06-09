/*   1:    */ package com.portal.recruitcenter.service.impl;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.hibernate3.Updater;
/*   4:    */ import com.javapms.basic.page.Pagination;
/*   5:    */ import com.portal.datacenter.commdata.service.MetierService;
/*   6:    */ import com.portal.recruitcenter.dao.JobPostDao;
/*   7:    */ import com.portal.recruitcenter.entity.CompanyInfo;
/*   8:    */ import com.portal.recruitcenter.entity.JobPost;
/*   9:    */ import com.portal.recruitcenter.entity.JobPostExt;
/*  10:    */ import com.portal.recruitcenter.service.JobPostExtService;
/*  11:    */ import com.portal.recruitcenter.service.JobPostService;
/*  12:    */ import com.portal.recruitcenter.service.PersonalFavoriteService;
/*  13:    */ import com.portal.recruitcenter.service.ResumeApplyService;
/*  14:    */ import java.util.Date;
/*  15:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  16:    */ import org.springframework.stereotype.Service;
/*  17:    */ import org.springframework.transaction.annotation.Transactional;
/*  18:    */ 
/*  19:    */ @Service
/*  20:    */ @Transactional
/*  21:    */ public class JobPostServiceImpl
/*  22:    */   implements JobPostService
/*  23:    */ {
/*  24:    */   private JobPostDao dao;
/*  25:    */   private JobPostExtService jobPostExtService;
/*  26:    */   private MetierService metierService;
/*  27:    */   private ResumeApplyService resumeApplyService;
/*  28:    */   private PersonalFavoriteService personalFavoriteService;
/*  29:    */   
/*  30:    */   @Transactional(readOnly=true)
/*  31:    */   public Pagination getPage(String key, Integer companyId, Integer metierId, Integer industryId, Byte wage, Byte edu, Integer natureId, Byte scale, Byte gender, Byte workExp, Integer minAge, Integer maxAge, String jobType, Boolean show, int pageNo, int pageSize)
/*  32:    */   {
/*  33: 30 */     Pagination page = this.dao.getPage(key, companyId, metierId, industryId, 
/*  34: 31 */       wage, edu, natureId, scale, gender, workExp, minAge, maxAge, 
/*  35: 32 */       jobType, show, pageNo, pageSize);
/*  36: 33 */     return page;
/*  37:    */   }
/*  38:    */   
/*  39:    */   @Transactional(readOnly=true)
/*  40:    */   public Pagination getPageByTag(String key, Integer companyId, Integer metierId, Integer industryId, Byte wage, Byte edu, Integer natureId, Byte scale, Byte gender, Byte workExp, Integer minAge, Integer maxAge, String jobType, Boolean checkTime, Boolean show, int pageNo, int pageSize)
/*  41:    */   {
/*  42: 42 */     return this.dao.getPageByTag(key, companyId, metierId, industryId, wage, 
/*  43: 43 */       edu, natureId, scale, gender, workExp, minAge, maxAge, jobType, 
/*  44: 44 */       checkTime, show, pageNo, pageSize);
/*  45:    */   }
/*  46:    */   
/*  47:    */   @Transactional(readOnly=true)
/*  48:    */   public int countByCompanyId(Integer companyId)
/*  49:    */   {
/*  50: 49 */     return this.dao.countByCompanyId(companyId);
/*  51:    */   }
/*  52:    */   
/*  53:    */   @Transactional(readOnly=true)
/*  54:    */   public JobPost findById(Integer id)
/*  55:    */   {
/*  56: 54 */     JobPost entity = this.dao.findById(id);
/*  57: 55 */     return entity;
/*  58:    */   }
/*  59:    */   
/*  60:    */   public JobPost save(JobPost bean, JobPostExt ext, Integer metierId)
/*  61:    */   {
/*  62: 59 */     if (metierId != null) {
/*  63: 60 */       bean.setMetier(this.metierService.findById(metierId));
/*  64:    */     }
/*  65: 62 */     CompanyInfo info = bean.getCompany();
/*  66: 63 */     if (info != null) {
/*  67: 64 */       info.setLastPostTime(new Date());
/*  68:    */     }
/*  69: 66 */     bean.init();
/*  70: 67 */     this.dao.save(bean);
/*  71: 68 */     this.jobPostExtService.save(ext, bean);
/*  72: 69 */     return bean;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public JobPost update(JobPost bean, JobPostExt ext, Integer metierId)
/*  76:    */   {
/*  77: 73 */     Updater<JobPost> updater = new Updater(bean);
/*  78: 74 */     bean = this.dao.updateByUpdater(updater);
/*  79: 75 */     if (metierId != null) {
/*  80: 76 */       bean.setMetier(this.metierService.findById(metierId));
/*  81:    */     }
/*  82: 78 */     CompanyInfo info = bean.getCompany();
/*  83: 79 */     if (info != null) {
/*  84: 80 */       info.setLastPostTime(new Date());
/*  85:    */     }
/*  86: 82 */     this.jobPostExtService.update(ext);
/*  87: 83 */     return bean;
/*  88:    */   }
/*  89:    */   
/*  90:    */   public JobPost update(JobPost bean)
/*  91:    */   {
/*  92: 87 */     Updater<JobPost> updater = new Updater(bean);
/*  93: 88 */     bean = this.dao.updateByUpdater(updater);
/*  94: 89 */     return bean;
/*  95:    */   }
/*  96:    */   
/*  97:    */   public int deleteByCompanyId(Integer companyId)
/*  98:    */   {
/*  99: 93 */     this.resumeApplyService.deleteByCompanyId(companyId);
/* 100: 94 */     this.personalFavoriteService.deleteByCompanyId(companyId);
/* 101: 95 */     this.jobPostExtService.deleteByCompanyId(companyId);
/* 102: 96 */     return this.dao.deleteByCompanyId(companyId);
/* 103:    */   }
/* 104:    */   
/* 105:    */   public int deleteByMetierId(Integer metierId)
/* 106:    */   {
/* 107:100 */     this.resumeApplyService.deleteByMetierId(metierId);
/* 108:101 */     this.personalFavoriteService.deleteByMetierId(metierId);
/* 109:102 */     this.jobPostExtService.deleteByMetierId(metierId);
/* 110:103 */     return this.dao.deleteByMetierId(metierId);
/* 111:    */   }
/* 112:    */   
/* 113:    */   public JobPost deleteById(Integer id)
/* 114:    */   {
/* 115:107 */     JobPost bean = this.dao.findById(id);
/* 116:108 */     this.resumeApplyService.deleteByJobId(id);
/* 117:109 */     this.personalFavoriteService.deleteByJobId(id);
/* 118:110 */     bean = this.dao.deleteById(id);
/* 119:111 */     return bean;
/* 120:    */   }
/* 121:    */   
/* 122:    */   public JobPost[] deleteByIds(Integer[] ids)
/* 123:    */   {
/* 124:115 */     JobPost[] beans = new JobPost[ids.length];
/* 125:116 */     int i = 0;
/* 126:116 */     for (int len = ids.length; i < len; i++) {
/* 127:117 */       beans[i] = deleteById(ids[i]);
/* 128:    */     }
/* 129:119 */     return beans;
/* 130:    */   }
/* 131:    */   
/* 132:    */   @Autowired
/* 133:    */   public void setDao(JobPostDao dao)
/* 134:    */   {
/* 135:130 */     this.dao = dao;
/* 136:    */   }
/* 137:    */   
/* 138:    */   @Autowired
/* 139:    */   public void setJobPostExtService(JobPostExtService jobPostExtService)
/* 140:    */   {
/* 141:135 */     this.jobPostExtService = jobPostExtService;
/* 142:    */   }
/* 143:    */   
/* 144:    */   @Autowired
/* 145:    */   public void setResumeApplyService(ResumeApplyService resumeApplyService)
/* 146:    */   {
/* 147:140 */     this.resumeApplyService = resumeApplyService;
/* 148:    */   }
/* 149:    */   
/* 150:    */   @Autowired
/* 151:    */   public void setPersonalFavoriteService(PersonalFavoriteService personalFavoriteService)
/* 152:    */   {
/* 153:145 */     this.personalFavoriteService = personalFavoriteService;
/* 154:    */   }
/* 155:    */   
/* 156:    */   @Autowired
/* 157:    */   public void setMetierService(MetierService metierService)
/* 158:    */   {
/* 159:150 */     this.metierService = metierService;
/* 160:    */   }
/* 161:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.service.impl.JobPostServiceImpl
 * JD-Core Version:    0.7.0.1
 */