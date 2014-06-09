/*   1:    */ package com.portal.recruitcenter.service.impl;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.hibernate3.Updater;
/*   4:    */ import com.javapms.basic.page.Pagination;
/*   5:    */ import com.portal.recruitcenter.dao.PersonalFavoriteDao;
/*   6:    */ import com.portal.recruitcenter.entity.PersonalFavorite;
/*   7:    */ import com.portal.recruitcenter.service.JobPostService;
/*   8:    */ import com.portal.recruitcenter.service.PersonalFavoriteService;
/*   9:    */ import com.portal.recruitcenter.service.PersonalInfoService;
/*  10:    */ import java.sql.Timestamp;
/*  11:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  12:    */ import org.springframework.stereotype.Service;
/*  13:    */ import org.springframework.transaction.annotation.Transactional;
/*  14:    */ 
/*  15:    */ @Service
/*  16:    */ @Transactional
/*  17:    */ public class PersonalFavoriteServiceImpl
/*  18:    */   implements PersonalFavoriteService
/*  19:    */ {
/*  20:    */   private PersonalFavoriteDao dao;
/*  21:    */   private PersonalInfoService personalInfoService;
/*  22:    */   private JobPostService jobPostService;
/*  23:    */   
/*  24:    */   @Transactional(readOnly=true)
/*  25:    */   public Pagination getPage(int pageNo, int pageSize)
/*  26:    */   {
/*  27: 22 */     Pagination page = this.dao.getPage(pageNo, pageSize);
/*  28: 23 */     return page;
/*  29:    */   }
/*  30:    */   
/*  31:    */   @Transactional(readOnly=true)
/*  32:    */   public Pagination getPageByTag(Integer personalId, int pageNo, int pageSize)
/*  33:    */   {
/*  34: 28 */     return this.dao.getPageByTag(personalId, pageNo, pageSize);
/*  35:    */   }
/*  36:    */   
/*  37:    */   @Transactional(readOnly=true)
/*  38:    */   public PersonalFavorite getFavoriteByPersonal(Integer personalId, Integer jobId)
/*  39:    */   {
/*  40: 34 */     return this.dao.getFavoriteByPersonal(personalId, jobId);
/*  41:    */   }
/*  42:    */   
/*  43:    */   @Transactional(readOnly=true)
/*  44:    */   public PersonalFavorite findById(Integer id)
/*  45:    */   {
/*  46: 39 */     PersonalFavorite entity = this.dao.findById(id);
/*  47: 40 */     return entity;
/*  48:    */   }
/*  49:    */   
/*  50:    */   public PersonalFavorite save(PersonalFavorite bean)
/*  51:    */   {
/*  52: 44 */     this.dao.save(bean);
/*  53: 45 */     return bean;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public PersonalFavorite saveFavorite(Integer personalId, Integer jobId)
/*  57:    */   {
/*  58: 49 */     PersonalFavorite f = new PersonalFavorite();
/*  59: 50 */     f.setCreateTime(new Timestamp(System.currentTimeMillis()));
/*  60: 51 */     f.setPersonal(this.personalInfoService.findById(personalId));
/*  61: 52 */     f.setJob(this.jobPostService.findById(jobId));
/*  62: 53 */     this.dao.save(f);
/*  63: 54 */     return f;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public PersonalFavorite update(PersonalFavorite bean)
/*  67:    */   {
/*  68: 58 */     Updater<PersonalFavorite> updater = new Updater(bean);
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
/*  83:    */   public int deleteByPersonalId(Integer personalId)
/*  84:    */   {
/*  85: 72 */     return this.dao.deleteByPersonalId(personalId);
/*  86:    */   }
/*  87:    */   
/*  88:    */   public int deleteByMetierId(Integer metierId)
/*  89:    */   {
/*  90: 76 */     return this.dao.deleteByMetierId(metierId);
/*  91:    */   }
/*  92:    */   
/*  93:    */   public PersonalFavorite deleteById(Integer id)
/*  94:    */   {
/*  95: 80 */     PersonalFavorite bean = this.dao.deleteById(id);
/*  96: 81 */     return bean;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public PersonalFavorite[] deleteByIds(Integer[] ids)
/* 100:    */   {
/* 101: 85 */     PersonalFavorite[] beans = new PersonalFavorite[ids.length];
/* 102: 86 */     int i = 0;
/* 103: 86 */     for (int len = ids.length; i < len; i++) {
/* 104: 87 */       beans[i] = deleteById(ids[i]);
/* 105:    */     }
/* 106: 89 */     return beans;
/* 107:    */   }
/* 108:    */   
/* 109:    */   @Autowired
/* 110:    */   public void setDao(PersonalFavoriteDao dao)
/* 111:    */   {
/* 112: 98 */     this.dao = dao;
/* 113:    */   }
/* 114:    */   
/* 115:    */   @Autowired
/* 116:    */   public void setPersonalInfoService(PersonalInfoService personalInfoService)
/* 117:    */   {
/* 118:103 */     this.personalInfoService = personalInfoService;
/* 119:    */   }
/* 120:    */   
/* 121:    */   @Autowired
/* 122:    */   public void setJobPostService(JobPostService jobPostService)
/* 123:    */   {
/* 124:108 */     this.jobPostService = jobPostService;
/* 125:    */   }
/* 126:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.service.impl.PersonalFavoriteServiceImpl
 * JD-Core Version:    0.7.0.1
 */