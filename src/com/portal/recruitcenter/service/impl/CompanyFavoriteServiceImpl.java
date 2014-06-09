/*   1:    */ package com.portal.recruitcenter.service.impl;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.hibernate3.Updater;
/*   4:    */ import com.javapms.basic.page.Pagination;
/*   5:    */ import com.portal.recruitcenter.dao.CompanyFavoriteDao;
/*   6:    */ import com.portal.recruitcenter.entity.CompanyFavorite;
/*   7:    */ import com.portal.recruitcenter.service.CompanyFavoriteService;
/*   8:    */ import com.portal.recruitcenter.service.CompanyInfoService;
/*   9:    */ import com.portal.recruitcenter.service.ResumeService;
/*  10:    */ import java.sql.Timestamp;
/*  11:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  12:    */ import org.springframework.stereotype.Service;
/*  13:    */ import org.springframework.transaction.annotation.Transactional;
/*  14:    */ 
/*  15:    */ @Service
/*  16:    */ @Transactional
/*  17:    */ public class CompanyFavoriteServiceImpl
/*  18:    */   implements CompanyFavoriteService
/*  19:    */ {
/*  20:    */   private CompanyFavoriteDao dao;
/*  21:    */   private CompanyInfoService companyInfoService;
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
/*  32:    */   public Pagination getPageByTag(Integer companyId, int pageNo, int pageSize)
/*  33:    */   {
/*  34: 28 */     return this.dao.getPageByTag(companyId, pageNo, pageSize);
/*  35:    */   }
/*  36:    */   
/*  37:    */   @Transactional(readOnly=true)
/*  38:    */   public CompanyFavorite getFavoriteByCompany(Integer companyId, Integer resumeId)
/*  39:    */   {
/*  40: 34 */     return this.dao.getFavoriteByCompany(companyId, resumeId);
/*  41:    */   }
/*  42:    */   
/*  43:    */   @Transactional(readOnly=true)
/*  44:    */   public int countByCompanyId(Integer companyId)
/*  45:    */   {
/*  46: 39 */     return this.dao.countByCompanyId(companyId);
/*  47:    */   }
/*  48:    */   
/*  49:    */   @Transactional(readOnly=true)
/*  50:    */   public CompanyFavorite findById(Integer id)
/*  51:    */   {
/*  52: 44 */     CompanyFavorite entity = this.dao.findById(id);
/*  53: 45 */     return entity;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public CompanyFavorite save(CompanyFavorite bean)
/*  57:    */   {
/*  58: 49 */     this.dao.save(bean);
/*  59: 50 */     return bean;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public CompanyFavorite saveFavorite(Integer companyId, Integer resumeId)
/*  63:    */   {
/*  64: 54 */     CompanyFavorite f = new CompanyFavorite();
/*  65: 55 */     f.setCreateTime(new Timestamp(System.currentTimeMillis()));
/*  66: 56 */     f.setCompany(this.companyInfoService.findById(companyId));
/*  67: 57 */     f.setResume(this.resumeService.findById(resumeId));
/*  68: 58 */     this.dao.save(f);
/*  69: 59 */     return f;
/*  70:    */   }
/*  71:    */   
/*  72:    */   public CompanyFavorite update(CompanyFavorite bean)
/*  73:    */   {
/*  74: 63 */     Updater<CompanyFavorite> updater = new Updater(bean);
/*  75: 64 */     bean = this.dao.updateByUpdater(updater);
/*  76: 65 */     return bean;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public int deleteByCompanyId(Integer companyId)
/*  80:    */   {
/*  81: 69 */     return this.dao.deleteByCompanyId(companyId);
/*  82:    */   }
/*  83:    */   
/*  84:    */   public int deleteByResumeId(Integer resumeId)
/*  85:    */   {
/*  86: 73 */     return this.dao.deleteByResumeId(resumeId);
/*  87:    */   }
/*  88:    */   
/*  89:    */   public int deleteByPersonalId(Integer personalId)
/*  90:    */   {
/*  91: 77 */     return this.dao.deleteByPersonalId(personalId);
/*  92:    */   }
/*  93:    */   
/*  94:    */   public CompanyFavorite deleteById(Integer id)
/*  95:    */   {
/*  96: 81 */     CompanyFavorite bean = this.dao.deleteById(id);
/*  97: 82 */     return bean;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public CompanyFavorite[] deleteByIds(Integer[] ids)
/* 101:    */   {
/* 102: 86 */     CompanyFavorite[] beans = new CompanyFavorite[ids.length];
/* 103: 87 */     int i = 0;
/* 104: 87 */     for (int len = ids.length; i < len; i++) {
/* 105: 88 */       beans[i] = deleteById(ids[i]);
/* 106:    */     }
/* 107: 90 */     return beans;
/* 108:    */   }
/* 109:    */   
/* 110:    */   @Autowired
/* 111:    */   public void setDao(CompanyFavoriteDao dao)
/* 112:    */   {
/* 113: 99 */     this.dao = dao;
/* 114:    */   }
/* 115:    */   
/* 116:    */   @Autowired
/* 117:    */   public void setCompanyInfoService(CompanyInfoService companyInfoService)
/* 118:    */   {
/* 119:104 */     this.companyInfoService = companyInfoService;
/* 120:    */   }
/* 121:    */   
/* 122:    */   @Autowired
/* 123:    */   public void setResumeService(ResumeService resumeService)
/* 124:    */   {
/* 125:109 */     this.resumeService = resumeService;
/* 126:    */   }
/* 127:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.service.impl.CompanyFavoriteServiceImpl
 * JD-Core Version:    0.7.0.1
 */