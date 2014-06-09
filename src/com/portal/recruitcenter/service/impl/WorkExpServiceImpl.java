/*   1:    */ package com.portal.recruitcenter.service.impl;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.hibernate3.Updater;
/*   4:    */ import com.javapms.basic.page.Pagination;
/*   5:    */ import com.portal.datacenter.commdata.service.EconomyTypeService;
/*   6:    */ import com.portal.datacenter.commdata.service.IndustryService;
/*   7:    */ import com.portal.datacenter.commdata.service.MetierService;
/*   8:    */ import com.portal.recruitcenter.dao.WorkExpDao;
/*   9:    */ import com.portal.recruitcenter.entity.WorkExp;
/*  10:    */ import com.portal.recruitcenter.service.ResumeService;
/*  11:    */ import com.portal.recruitcenter.service.WorkExpService;
/*  12:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  13:    */ import org.springframework.stereotype.Service;
/*  14:    */ import org.springframework.transaction.annotation.Transactional;
/*  15:    */ 
/*  16:    */ @Service
/*  17:    */ @Transactional
/*  18:    */ public class WorkExpServiceImpl
/*  19:    */   implements WorkExpService
/*  20:    */ {
/*  21:    */   private WorkExpDao dao;
/*  22:    */   private ResumeService resumeService;
/*  23:    */   private EconomyTypeService economyTypeService;
/*  24:    */   private MetierService metierService;
/*  25:    */   private IndustryService industryService;
/*  26:    */   
/*  27:    */   @Transactional(readOnly=true)
/*  28:    */   public Pagination getPage(Integer resumeId, int pageNo, int pageSize)
/*  29:    */   {
/*  30: 22 */     Pagination page = this.dao.getPage(resumeId, pageNo, pageSize);
/*  31: 23 */     return page;
/*  32:    */   }
/*  33:    */   
/*  34:    */   @Transactional(readOnly=true)
/*  35:    */   public WorkExp findById(Integer id)
/*  36:    */   {
/*  37: 28 */     WorkExp entity = this.dao.findById(id);
/*  38: 29 */     return entity;
/*  39:    */   }
/*  40:    */   
/*  41:    */   public WorkExp save(WorkExp bean, Integer resumeId, Integer metierId, Integer industryId, Integer economyId)
/*  42:    */   {
/*  43: 34 */     if (resumeId != null) {
/*  44: 35 */       bean.setResume(this.resumeService.findById(resumeId));
/*  45:    */     }
/*  46: 37 */     if (metierId != null) {
/*  47: 38 */       bean.setMetier(this.metierService.findById(metierId));
/*  48:    */     }
/*  49: 40 */     if (industryId != null) {
/*  50: 41 */       bean.setIndustry(this.industryService.findById(industryId));
/*  51:    */     }
/*  52: 43 */     if (economyId != null) {
/*  53: 44 */       bean.setNature(this.economyTypeService.findById(economyId));
/*  54:    */     }
/*  55: 46 */     bean.init();
/*  56: 47 */     this.dao.save(bean);
/*  57: 48 */     return bean;
/*  58:    */   }
/*  59:    */   
/*  60:    */   public WorkExp update(WorkExp bean, Integer metierId, Integer industryId, Integer economyId)
/*  61:    */   {
/*  62: 53 */     Updater<WorkExp> updater = new Updater(bean);
/*  63: 54 */     bean = this.dao.updateByUpdater(updater);
/*  64: 55 */     if (metierId != null) {
/*  65: 56 */       bean.setMetier(this.metierService.findById(metierId));
/*  66:    */     }
/*  67: 58 */     if (industryId != null) {
/*  68: 59 */       bean.setIndustry(this.industryService.findById(industryId));
/*  69:    */     }
/*  70: 61 */     if (economyId != null) {
/*  71: 62 */       bean.setNature(this.economyTypeService.findById(economyId));
/*  72:    */     }
/*  73: 64 */     return bean;
/*  74:    */   }
/*  75:    */   
/*  76:    */   public int deleteByPersonalId(Integer personalId)
/*  77:    */   {
/*  78: 68 */     return this.dao.deleteByPersonalId(personalId);
/*  79:    */   }
/*  80:    */   
/*  81:    */   public int deleteByResumeId(Integer resumeId)
/*  82:    */   {
/*  83: 72 */     return this.dao.deleteByResumeId(resumeId);
/*  84:    */   }
/*  85:    */   
/*  86:    */   public int deleteByNatureId(Integer natureId)
/*  87:    */   {
/*  88: 76 */     return this.dao.deleteByNatureId(natureId);
/*  89:    */   }
/*  90:    */   
/*  91:    */   public int deleteByMetierId(Integer metierId)
/*  92:    */   {
/*  93: 80 */     return this.dao.deleteByMetierId(metierId);
/*  94:    */   }
/*  95:    */   
/*  96:    */   public int deleteByIndustryId(Integer industryId)
/*  97:    */   {
/*  98: 84 */     return this.dao.deleteByIndustryId(industryId);
/*  99:    */   }
/* 100:    */   
/* 101:    */   public WorkExp deleteById(Integer id)
/* 102:    */   {
/* 103: 88 */     WorkExp bean = this.dao.deleteById(id);
/* 104: 89 */     return bean;
/* 105:    */   }
/* 106:    */   
/* 107:    */   public WorkExp[] deleteByIds(Integer[] ids)
/* 108:    */   {
/* 109: 93 */     WorkExp[] beans = new WorkExp[ids.length];
/* 110: 94 */     int i = 0;
/* 111: 94 */     for (int len = ids.length; i < len; i++) {
/* 112: 95 */       beans[i] = deleteById(ids[i]);
/* 113:    */     }
/* 114: 97 */     return beans;
/* 115:    */   }
/* 116:    */   
/* 117:    */   @Autowired
/* 118:    */   public void setDao(WorkExpDao dao)
/* 119:    */   {
/* 120:108 */     this.dao = dao;
/* 121:    */   }
/* 122:    */   
/* 123:    */   @Autowired
/* 124:    */   public void setResumeService(ResumeService resumeService)
/* 125:    */   {
/* 126:113 */     this.resumeService = resumeService;
/* 127:    */   }
/* 128:    */   
/* 129:    */   @Autowired
/* 130:    */   public void setEconomyTypeService(EconomyTypeService economyTypeService)
/* 131:    */   {
/* 132:118 */     this.economyTypeService = economyTypeService;
/* 133:    */   }
/* 134:    */   
/* 135:    */   @Autowired
/* 136:    */   public void setMetierService(MetierService metierService)
/* 137:    */   {
/* 138:123 */     this.metierService = metierService;
/* 139:    */   }
/* 140:    */   
/* 141:    */   @Autowired
/* 142:    */   public void setIndustryService(IndustryService industryService)
/* 143:    */   {
/* 144:128 */     this.industryService = industryService;
/* 145:    */   }
/* 146:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.service.impl.WorkExpServiceImpl
 * JD-Core Version:    0.7.0.1
 */