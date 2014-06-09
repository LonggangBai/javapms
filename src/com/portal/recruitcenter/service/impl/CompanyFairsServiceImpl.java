/*  1:   */ package com.portal.recruitcenter.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.recruitcenter.dao.CompanyFairsDao;
/*  6:   */ import com.portal.recruitcenter.entity.CompanyFairs;
/*  7:   */ import com.portal.recruitcenter.service.CompanyFairsService;
/*  8:   */ import com.portal.recruitcenter.service.CompanyInfoService;
/*  9:   */ import com.portal.recruitcenter.service.JobFairsService;
/* 10:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 11:   */ import org.springframework.stereotype.Service;
/* 12:   */ import org.springframework.transaction.annotation.Transactional;
/* 13:   */ 
/* 14:   */ @Service
/* 15:   */ @Transactional
/* 16:   */ public class CompanyFairsServiceImpl
/* 17:   */   implements CompanyFairsService
/* 18:   */ {
/* 19:   */   private CompanyFairsDao dao;
/* 20:   */   private CompanyInfoService companyInfoService;
/* 21:   */   private JobFairsService jobFairsService;
/* 22:   */   
/* 23:   */   @Transactional(readOnly=true)
/* 24:   */   public Pagination getPage(Integer companyId, Integer fairsId, int pageNo, int pageSize)
/* 25:   */   {
/* 26:21 */     Pagination page = this.dao.getPage(companyId, fairsId, pageNo, pageSize);
/* 27:22 */     return page;
/* 28:   */   }
/* 29:   */   
/* 30:   */   @Transactional(readOnly=true)
/* 31:   */   public Pagination getPageByTag(Integer fairsId, Integer companyId, Integer orderBy, int pageNo, int pageSize)
/* 32:   */   {
/* 33:28 */     return this.dao.getPageByTag(fairsId, companyId, orderBy, pageNo, pageSize);
/* 34:   */   }
/* 35:   */   
/* 36:   */   @Transactional(readOnly=true)
/* 37:   */   public CompanyFairs findById(Integer id)
/* 38:   */   {
/* 39:33 */     CompanyFairs entity = this.dao.findById(id);
/* 40:34 */     return entity;
/* 41:   */   }
/* 42:   */   
/* 43:   */   public CompanyFairs save(CompanyFairs bean, Integer companyId, Integer fairsId)
/* 44:   */   {
/* 45:39 */     if (companyId != null) {
/* 46:40 */       bean.setCompany(this.companyInfoService.findById(companyId));
/* 47:   */     }
/* 48:42 */     if (fairsId != null) {
/* 49:43 */       bean.setFairs(this.jobFairsService.findById(fairsId));
/* 50:   */     }
/* 51:45 */     bean.init();
/* 52:46 */     this.dao.save(bean);
/* 53:47 */     return bean;
/* 54:   */   }
/* 55:   */   
/* 56:   */   public CompanyFairs update(CompanyFairs bean, Integer companyId, Integer fairsId)
/* 57:   */   {
/* 58:52 */     Updater<CompanyFairs> updater = new Updater(bean);
/* 59:53 */     bean = this.dao.updateByUpdater(updater);
/* 60:54 */     if (companyId != null) {
/* 61:55 */       bean.setCompany(this.companyInfoService.findById(companyId));
/* 62:   */     }
/* 63:57 */     if (fairsId != null) {
/* 64:58 */       bean.setFairs(this.jobFairsService.findById(fairsId));
/* 65:   */     }
/* 66:60 */     return bean;
/* 67:   */   }
/* 68:   */   
/* 69:   */   public CompanyFairs deleteById(Integer id)
/* 70:   */   {
/* 71:64 */     CompanyFairs bean = this.dao.deleteById(id);
/* 72:65 */     return bean;
/* 73:   */   }
/* 74:   */   
/* 75:   */   public CompanyFairs[] deleteByIds(Integer[] ids)
/* 76:   */   {
/* 77:69 */     CompanyFairs[] beans = new CompanyFairs[ids.length];
/* 78:70 */     int i = 0;
/* 79:70 */     for (int len = ids.length; i < len; i++) {
/* 80:71 */       beans[i] = deleteById(ids[i]);
/* 81:   */     }
/* 82:73 */     return beans;
/* 83:   */   }
/* 84:   */   
/* 85:   */   @Autowired
/* 86:   */   public void setDao(CompanyFairsDao dao)
/* 87:   */   {
/* 88:82 */     this.dao = dao;
/* 89:   */   }
/* 90:   */   
/* 91:   */   @Autowired
/* 92:   */   public void setCompanyInfoService(CompanyInfoService companyInfoService)
/* 93:   */   {
/* 94:87 */     this.companyInfoService = companyInfoService;
/* 95:   */   }
/* 96:   */   
/* 97:   */   @Autowired
/* 98:   */   public void setJobFairsService(JobFairsService jobFairsService)
/* 99:   */   {
/* :0:92 */     this.jobFairsService = jobFairsService;
/* :1:   */   }
/* :2:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.service.impl.CompanyFairsServiceImpl
 * JD-Core Version:    0.7.0.1
 */