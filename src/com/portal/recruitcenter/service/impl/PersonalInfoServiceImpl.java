/*   1:    */ package com.portal.recruitcenter.service.impl;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.hibernate3.Updater;
/*   4:    */ import com.javapms.basic.page.Pagination;
/*   5:    */ import com.javapms.basic.upload.FileRepository;
/*   6:    */ import com.portal.datacenter.commdata.service.SpecialtyService;
/*   7:    */ import com.portal.recruitcenter.dao.PersonalInfoDao;
/*   8:    */ import com.portal.recruitcenter.entity.PersonalInfo;
/*   9:    */ import com.portal.recruitcenter.entity.PersonalInfoExt;
/*  10:    */ import com.portal.recruitcenter.service.PersonalInfoExtService;
/*  11:    */ import com.portal.recruitcenter.service.PersonalInfoService;
/*  12:    */ import com.portal.recruitcenter.service.ResumeService;
/*  13:    */ import com.portal.sysmgr.entity.Site;
/*  14:    */ import com.portal.usermgr.entity.User;
/*  15:    */ import com.portal.usermgr.service.SiteMessageService;
/*  16:    */ import com.portal.usermgr.service.UserService;
/*  17:    */ import java.util.Date;
/*  18:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  19:    */ import org.springframework.stereotype.Service;
/*  20:    */ import org.springframework.transaction.annotation.Transactional;
/*  21:    */ import org.springframework.web.multipart.MultipartFile;
/*  22:    */ 
/*  23:    */ @Service
/*  24:    */ @Transactional
/*  25:    */ public class PersonalInfoServiceImpl
/*  26:    */   implements PersonalInfoService
/*  27:    */ {
/*  28:    */   private PersonalInfoDao dao;
/*  29:    */   private UserService userService;
/*  30:    */   private ResumeService resumeService;
/*  31:    */   private PersonalInfoExtService infoExtService;
/*  32:    */   private SpecialtyService specialtyService;
/*  33:    */   private FileRepository fileRepository;
/*  34:    */   private SiteMessageService siteMessageService;
/*  35:    */   
/*  36:    */   @Transactional(readOnly=true)
/*  37:    */   public Pagination getPage(int pageNo, int pageSize)
/*  38:    */   {
/*  39: 30 */     Pagination page = this.dao.getPage(pageNo, pageSize);
/*  40: 31 */     return page;
/*  41:    */   }
/*  42:    */   
/*  43:    */   @Transactional(readOnly=true)
/*  44:    */   public Pagination getPageBySelect(String key, Integer specialId, Integer industryId, Date startTime, Date endTime, int pageNo, int pageSize)
/*  45:    */   {
/*  46: 38 */     return this.dao.getPageBySelect(key, specialId, industryId, startTime, 
/*  47: 39 */       endTime, pageNo, pageSize);
/*  48:    */   }
/*  49:    */   
/*  50:    */   public Pagination getPageBySelect(int pageNo, int pageSize)
/*  51:    */   {
/*  52: 43 */     return this.dao.getPageBySelect(pageNo, pageSize);
/*  53:    */   }
/*  54:    */   
/*  55:    */   @Transactional(readOnly=true)
/*  56:    */   public PersonalInfo findById(Integer id)
/*  57:    */   {
/*  58: 48 */     PersonalInfo entity = this.dao.findById(id);
/*  59: 49 */     return entity;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public PersonalInfo regist(PersonalInfo info, PersonalInfoExt infoExt, String username, String email, String password, String ip)
/*  63:    */   {
/*  64: 54 */     info.init();
/*  65: 55 */     this.dao.save(info);
/*  66: 56 */     if (infoExt != null) {
/*  67: 57 */       this.infoExtService.save(infoExt, info);
/*  68:    */     }
/*  69: 62 */     return info;
/*  70:    */   }
/*  71:    */   
/*  72:    */   public PersonalInfo save(PersonalInfo bean, PersonalInfoExt ext, Integer specialId)
/*  73:    */   {
/*  74: 67 */     if (specialId != null) {
/*  75: 68 */       bean.setSpecial(this.specialtyService.findById(specialId));
/*  76:    */     }
/*  77: 70 */     bean.init();
/*  78: 71 */     this.dao.save(bean);
/*  79: 72 */     this.infoExtService.save(ext, bean);
/*  80: 73 */     return bean;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public PersonalInfo update(PersonalInfo bean, PersonalInfoExt ext, Integer specialId, MultipartFile file, Site site)
/*  84:    */   {
/*  85: 78 */     Updater<PersonalInfo> updater = new Updater(bean);
/*  86: 79 */     bean = this.dao.updateByUpdater(updater);
/*  87: 80 */     if (specialId != null) {
/*  88: 81 */       bean.setSpecial(this.specialtyService.findById(specialId));
/*  89:    */     } else {
/*  90: 83 */       bean.setSpecial(null);
/*  91:    */     }
/*  92: 85 */     if ((file != null) && (!file.isEmpty()))
/*  93:    */     {
/*  94: 86 */       String fileUrl = this.fileRepository.uploadFile(file, 
/*  95: 87 */         site.getUploadPath());
/*  96: 88 */       bean.setAvatar(fileUrl);
/*  97:    */     }
/*  98: 90 */     this.infoExtService.update(ext, bean);
/*  99: 91 */     return bean;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public PersonalInfo update(PersonalInfo bean)
/* 103:    */   {
/* 104: 95 */     Updater<PersonalInfo> updater = new Updater(bean);
/* 105: 96 */     bean = this.dao.updateByUpdater(updater);
/* 106: 97 */     return bean;
/* 107:    */   }
/* 108:    */   
/* 109:    */   public PersonalInfo deleteById(Integer id)
/* 110:    */   {
/* 111:101 */     PersonalInfo bean = this.dao.findById(id);
/* 112:102 */     this.resumeService.deleteByPersonalId(id);
/* 113:103 */     User user = this.userService.findByPersonal(id);
/* 114:104 */     if (user != null)
/* 115:    */     {
/* 116:105 */       this.siteMessageService.deleteByUserId(user.getId());
/* 117:106 */       this.userService.deleteById(user.getId());
/* 118:    */     }
/* 119:108 */     bean = this.dao.deleteById(id);
/* 120:109 */     return bean;
/* 121:    */   }
/* 122:    */   
/* 123:    */   public PersonalInfo[] deleteByIds(Integer[] ids)
/* 124:    */   {
/* 125:113 */     PersonalInfo[] beans = new PersonalInfo[ids.length];
/* 126:114 */     int i = 0;
/* 127:114 */     for (int len = ids.length; i < len; i++) {
/* 128:115 */       beans[i] = deleteById(ids[i]);
/* 129:    */     }
/* 130:117 */     return beans;
/* 131:    */   }
/* 132:    */   
/* 133:    */   @Autowired
/* 134:    */   public void setDao(PersonalInfoDao dao)
/* 135:    */   {
/* 136:130 */     this.dao = dao;
/* 137:    */   }
/* 138:    */   
/* 139:    */   @Autowired
/* 140:    */   public void setPmsUserService(UserService userService)
/* 141:    */   {
/* 142:135 */     this.userService = userService;
/* 143:    */   }
/* 144:    */   
/* 145:    */   @Autowired
/* 146:    */   public void setResumeService(ResumeService resumeService)
/* 147:    */   {
/* 148:140 */     this.resumeService = resumeService;
/* 149:    */   }
/* 150:    */   
/* 151:    */   @Autowired
/* 152:    */   public void setInfoExtService(PersonalInfoExtService infoExtService)
/* 153:    */   {
/* 154:145 */     this.infoExtService = infoExtService;
/* 155:    */   }
/* 156:    */   
/* 157:    */   @Autowired
/* 158:    */   public void setSpecialtyService(SpecialtyService specialtyService)
/* 159:    */   {
/* 160:150 */     this.specialtyService = specialtyService;
/* 161:    */   }
/* 162:    */   
/* 163:    */   @Autowired
/* 164:    */   public void setFileRepository(FileRepository fileRepository)
/* 165:    */   {
/* 166:155 */     this.fileRepository = fileRepository;
/* 167:    */   }
/* 168:    */   
/* 169:    */   @Autowired
/* 170:    */   public void setSiteMessageService(SiteMessageService siteMessageService)
/* 171:    */   {
/* 172:160 */     this.siteMessageService = siteMessageService;
/* 173:    */   }
/* 174:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.service.impl.PersonalInfoServiceImpl
 * JD-Core Version:    0.7.0.1
 */