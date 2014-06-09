/*   1:    */ package com.portal.recruitcenter.service.impl;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.hibernate3.Updater;
/*   4:    */ import com.javapms.basic.page.Pagination;
/*   5:    */ import com.portal.recruitcenter.dao.ResumeDao;
/*   6:    */ import com.portal.recruitcenter.entity.PersonalInfo;
/*   7:    */ import com.portal.recruitcenter.entity.Resume;
/*   8:    */ import com.portal.recruitcenter.entity.ResumeExt;
/*   9:    */ import com.portal.recruitcenter.service.CompanyFavoriteService;
/*  10:    */ import com.portal.recruitcenter.service.EduExpService;
/*  11:    */ import com.portal.recruitcenter.service.JobIntentService;
/*  12:    */ import com.portal.recruitcenter.service.LangAbilityService;
/*  13:    */ import com.portal.recruitcenter.service.ResumeApplyService;
/*  14:    */ import com.portal.recruitcenter.service.ResumeExtService;
/*  15:    */ import com.portal.recruitcenter.service.ResumeService;
/*  16:    */ import com.portal.recruitcenter.service.TrainService;
/*  17:    */ import com.portal.recruitcenter.service.WorkExpService;
/*  18:    */ import java.sql.Timestamp;
/*  19:    */ import java.util.List;
/*  20:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  21:    */ import org.springframework.stereotype.Service;
/*  22:    */ import org.springframework.transaction.annotation.Transactional;
/*  23:    */ 
/*  24:    */ @Service
/*  25:    */ @Transactional
/*  26:    */ public class ResumeServiceImpl
/*  27:    */   implements ResumeService
/*  28:    */ {
/*  29:    */   private ResumeDao dao;
/*  30:    */   private ResumeExtService resumeExtService;
/*  31:    */   private JobIntentService jobIntentService;
/*  32:    */   private ResumeApplyService resumeApplyService;
/*  33:    */   private CompanyFavoriteService companyFavoriteService;
/*  34:    */   private EduExpService eduExpService;
/*  35:    */   private LangAbilityService langAbilityService;
/*  36:    */   private TrainService trainService;
/*  37:    */   private WorkExpService workExpService;
/*  38:    */   
/*  39:    */   @Transactional(readOnly=true)
/*  40:    */   public Pagination getPage(Integer infoId, int pageNo, int pageSize)
/*  41:    */   {
/*  42: 30 */     Pagination page = this.dao.getPage(infoId, pageNo, pageSize);
/*  43: 31 */     return page;
/*  44:    */   }
/*  45:    */   
/*  46:    */   @Transactional(readOnly=true)
/*  47:    */   public Pagination getPageByTag(String key, Integer personalId, Integer metierId, Integer industryId, Integer specialId, Byte wage, Byte edu, Byte minwork, Byte maxwork, Boolean gender, Boolean show, int pageNo, int pageSize)
/*  48:    */   {
/*  49: 39 */     return this.dao.getPageByTag(key, personalId, metierId, industryId, 
/*  50: 40 */       specialId, wage, edu, minwork, maxwork, gender, show, pageNo, 
/*  51: 41 */       pageSize);
/*  52:    */   }
/*  53:    */   
/*  54:    */   @Transactional(readOnly=true)
/*  55:    */   public List<Resume> getList(Integer personalId)
/*  56:    */   {
/*  57: 46 */     return this.dao.getList(personalId);
/*  58:    */   }
/*  59:    */   
/*  60:    */   @Transactional(readOnly=true)
/*  61:    */   public Resume getResumeByDef(Integer personalId)
/*  62:    */   {
/*  63: 51 */     return this.dao.getResumeByDef(personalId);
/*  64:    */   }
/*  65:    */   
/*  66:    */   @Transactional(readOnly=true)
/*  67:    */   public Resume getResumeByName(Integer personalId)
/*  68:    */   {
/*  69: 56 */     return this.dao.getResumeByName(personalId);
/*  70:    */   }
/*  71:    */   
/*  72:    */   @Transactional(readOnly=true)
/*  73:    */   public Resume findById(Integer id)
/*  74:    */   {
/*  75: 61 */     Resume entity = this.dao.findById(id);
/*  76: 62 */     return entity;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public Resume save(Resume bean, ResumeExt ext)
/*  80:    */   {
/*  81: 66 */     bean.init();
/*  82: 67 */     List<Resume> resumeList = getList(bean.getPersonal().getId());
/*  83: 68 */     if ((resumeList != null) && (resumeList.size() > 0)) {
/*  84: 69 */       bean.setApplyDef(Boolean.valueOf(false));
/*  85:    */     } else {
/*  86: 71 */       bean.setApplyDef(Boolean.valueOf(true));
/*  87:    */     }
/*  88: 73 */     this.dao.save(bean);
/*  89: 74 */     this.resumeExtService.save(ext, bean);
/*  90: 75 */     return bean;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public Resume update(Resume bean, ResumeExt ext)
/*  94:    */   {
/*  95: 79 */     Updater<Resume> updater = new Updater(bean);
/*  96: 80 */     bean.setUpdateTime(new Timestamp(System.currentTimeMillis()));
/*  97: 81 */     bean = this.dao.updateByUpdater(updater);
/*  98: 82 */     List<Resume> resumeList = getList(bean.getPersonal().getId());
/*  99: 83 */     for (Resume r : resumeList) {
/* 100: 84 */       r.setApplyDef(Boolean.valueOf(false));
/* 101:    */     }
/* 102: 86 */     bean.setApplyDef(Boolean.valueOf(true));
/* 103: 87 */     this.resumeExtService.update(ext, bean);
/* 104: 88 */     return bean;
/* 105:    */   }
/* 106:    */   
/* 107:    */   public Resume update(Resume bean)
/* 108:    */   {
/* 109: 92 */     Updater<Resume> updater = new Updater(bean);
/* 110: 93 */     bean.setUpdateTime(new Timestamp(System.currentTimeMillis()));
/* 111: 94 */     bean = this.dao.updateByUpdater(updater);
/* 112: 95 */     return bean;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public int deleteByPersonalId(Integer personalId)
/* 116:    */   {
/* 117: 99 */     this.jobIntentService.deleteByPersonalId(personalId);
/* 118:100 */     this.resumeApplyService.deleteByPersonalId(personalId);
/* 119:101 */     this.companyFavoriteService.deleteByPersonalId(personalId);
/* 120:102 */     this.eduExpService.deleteByPersonalId(personalId);
/* 121:103 */     this.langAbilityService.deleteByPersonalId(personalId);
/* 122:104 */     this.trainService.deleteByPersonalId(personalId);
/* 123:105 */     this.workExpService.deleteByPersonalId(personalId);
/* 124:106 */     this.resumeExtService.deleteByPersonalId(personalId);
/* 125:107 */     return this.dao.deleteByPersonalId(personalId);
/* 126:    */   }
/* 127:    */   
/* 128:    */   public Resume deleteById(Integer id)
/* 129:    */   {
/* 130:111 */     Resume bean = this.dao.findById(id);
/* 131:112 */     this.resumeApplyService.deleteByResumelId(id);
/* 132:113 */     this.companyFavoriteService.deleteByResumeId(id);
/* 133:114 */     this.eduExpService.deleteByResumeId(id);
/* 134:115 */     this.langAbilityService.deleteByResumeId(id);
/* 135:116 */     this.trainService.deleteByResumeId(id);
/* 136:117 */     this.workExpService.deleteByResumeId(id);
/* 137:118 */     bean = this.dao.deleteById(id);
/* 138:119 */     return bean;
/* 139:    */   }
/* 140:    */   
/* 141:    */   public Resume[] deleteByIds(Integer[] ids)
/* 142:    */   {
/* 143:123 */     Resume[] beans = new Resume[ids.length];
/* 144:124 */     int i = 0;
/* 145:124 */     for (int len = ids.length; i < len; i++) {
/* 146:125 */       beans[i] = deleteById(ids[i]);
/* 147:    */     }
/* 148:127 */     return beans;
/* 149:    */   }
/* 150:    */   
/* 151:    */   @Autowired
/* 152:    */   public void setDao(ResumeDao dao)
/* 153:    */   {
/* 154:142 */     this.dao = dao;
/* 155:    */   }
/* 156:    */   
/* 157:    */   @Autowired
/* 158:    */   public void setResumeExtService(ResumeExtService resumeExtService)
/* 159:    */   {
/* 160:147 */     this.resumeExtService = resumeExtService;
/* 161:    */   }
/* 162:    */   
/* 163:    */   @Autowired
/* 164:    */   public void setJobIntentService(JobIntentService jobIntentService)
/* 165:    */   {
/* 166:152 */     this.jobIntentService = jobIntentService;
/* 167:    */   }
/* 168:    */   
/* 169:    */   @Autowired
/* 170:    */   public void setResumeApplyService(ResumeApplyService resumeApplyService)
/* 171:    */   {
/* 172:157 */     this.resumeApplyService = resumeApplyService;
/* 173:    */   }
/* 174:    */   
/* 175:    */   @Autowired
/* 176:    */   public void setCompanyFavoriteService(CompanyFavoriteService companyFavoriteService)
/* 177:    */   {
/* 178:162 */     this.companyFavoriteService = companyFavoriteService;
/* 179:    */   }
/* 180:    */   
/* 181:    */   @Autowired
/* 182:    */   public void setEduExpService(EduExpService eduExpService)
/* 183:    */   {
/* 184:167 */     this.eduExpService = eduExpService;
/* 185:    */   }
/* 186:    */   
/* 187:    */   @Autowired
/* 188:    */   public void setLangAbilityService(LangAbilityService langAbilityService)
/* 189:    */   {
/* 190:172 */     this.langAbilityService = langAbilityService;
/* 191:    */   }
/* 192:    */   
/* 193:    */   @Autowired
/* 194:    */   public void setTrainService(TrainService trainService)
/* 195:    */   {
/* 196:177 */     this.trainService = trainService;
/* 197:    */   }
/* 198:    */   
/* 199:    */   @Autowired
/* 200:    */   public void setWorkExpService(WorkExpService workExpService)
/* 201:    */   {
/* 202:182 */     this.workExpService = workExpService;
/* 203:    */   }
/* 204:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.service.impl.ResumeServiceImpl
 * JD-Core Version:    0.7.0.1
 */