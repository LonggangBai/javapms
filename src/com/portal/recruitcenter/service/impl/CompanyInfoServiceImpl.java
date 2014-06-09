/*   1:    */ package com.portal.recruitcenter.service.impl;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.hibernate3.Updater;
/*   4:    */ import com.javapms.basic.page.Pagination;
/*   5:    */ import com.portal.datacenter.commdata.service.EconomyTypeService;
/*   6:    */ import com.portal.datacenter.commdata.service.IndustryService;
/*   7:    */ import com.portal.recruitcenter.dao.CompanyInfoDao;
/*   8:    */ import com.portal.recruitcenter.entity.CompanyInfo;
/*   9:    */ import com.portal.recruitcenter.entity.CompanyInfoExt;
/*  10:    */ import com.portal.recruitcenter.service.CompanyFavoriteService;
/*  11:    */ import com.portal.recruitcenter.service.CompanyInfoExtService;
/*  12:    */ import com.portal.recruitcenter.service.CompanyInfoService;
/*  13:    */ import com.portal.recruitcenter.service.JobPostService;
/*  14:    */ import com.portal.recruitcenter.service.VipTypeService;
/*  15:    */ import com.portal.usermgr.entity.User;
/*  16:    */ import com.portal.usermgr.service.SiteMessageService;
/*  17:    */ import com.portal.usermgr.service.UserService;
/*  18:    */ import java.util.Date;
/*  19:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  20:    */ import org.springframework.stereotype.Service;
/*  21:    */ import org.springframework.transaction.annotation.Transactional;
/*  22:    */ 
/*  23:    */ @Service
/*  24:    */ @Transactional
/*  25:    */ public class CompanyInfoServiceImpl
/*  26:    */   implements CompanyInfoService
/*  27:    */ {
/*  28:    */   private CompanyInfoDao dao;
/*  29:    */   private EconomyTypeService economyTypeService;
/*  30:    */   private IndustryService industryService;
/*  31:    */   private UserService userService;
/*  32:    */   private CompanyInfoExtService infoExtService;
/*  33:    */   private JobPostService jobPostService;
/*  34:    */   private CompanyFavoriteService companyFavoriteService;
/*  35:    */   private SiteMessageService siteMessageService;
/*  36:    */   private VipTypeService vipTypeService;
/*  37:    */   
/*  38:    */   @Transactional(readOnly=true)
/*  39:    */   public Pagination getPage(int pageNo, int pageSize)
/*  40:    */   {
/*  41: 30 */     Pagination page = this.dao.getPage(pageNo, pageSize);
/*  42: 31 */     return page;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public Pagination getPageByTag(String key, Integer industryId, Integer natureId, Boolean havejob, Byte workexp, Integer worktype, Boolean commend, Boolean vip, int pageNo, int pageSize)
/*  46:    */   {
/*  47: 37 */     return this.dao.getPageByTag(key, industryId, natureId, havejob, workexp, 
/*  48: 38 */       worktype, commend, vip, pageNo, pageSize);
/*  49:    */   }
/*  50:    */   
/*  51:    */   @Transactional(readOnly=true)
/*  52:    */   public Pagination getPageBySelect(String key, Integer natureId, Integer industryId, Date startTime, Date endTime, int pageNo, int pageSize)
/*  53:    */   {
/*  54: 45 */     return this.dao.getPageBySelect(key, natureId, industryId, startTime, 
/*  55: 46 */       endTime, pageNo, pageSize);
/*  56:    */   }
/*  57:    */   
/*  58:    */   public Pagination getPageByApply(String key, Integer natureId, Integer industryId, Date startTime, Date endTime, int pageNo, int pageSize)
/*  59:    */   {
/*  60: 52 */     return this.dao.getPageByApply(key, natureId, industryId, startTime, 
/*  61: 53 */       endTime, pageNo, pageSize);
/*  62:    */   }
/*  63:    */   
/*  64:    */   @Transactional(readOnly=true)
/*  65:    */   public CompanyInfo findById(Integer id)
/*  66:    */   {
/*  67: 58 */     CompanyInfo entity = this.dao.findById(id);
/*  68: 59 */     return entity;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public CompanyInfo regist(CompanyInfo info, CompanyInfoExt ext, String username, String email, String password, String ip)
/*  72:    */   {
/*  73: 64 */     info.init();
/*  74: 65 */     this.dao.save(info);
/*  75:    */     
/*  76:    */ 
/*  77:    */ 
/*  78:    */ 
/*  79: 70 */     return info;
/*  80:    */   }
/*  81:    */   
/*  82:    */   public CompanyInfo save(CompanyInfo bean, CompanyInfoExt ext, Integer natureId, Integer industryId1, Integer industryId2)
/*  83:    */   {
/*  84: 75 */     bean.setIndustry1(this.industryService.findById(industryId1));
/*  85: 76 */     bean.setIndustry2(this.industryService.findById(industryId2));
/*  86: 77 */     bean.setNature(this.economyTypeService.findById(natureId));
/*  87: 78 */     bean.init();
/*  88: 79 */     this.dao.save(bean);
/*  89: 80 */     this.infoExtService.save(ext, bean);
/*  90: 81 */     return bean;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public CompanyInfo update(CompanyInfo bean, CompanyInfoExt ext, Integer natureId, Integer industryId1, Integer industryId2, Integer typeId)
/*  94:    */   {
/*  95: 87 */     Updater<CompanyInfo> updater = new Updater(bean);
/*  96: 88 */     bean = this.dao.updateByUpdater(updater);
/*  97: 89 */     if (industryId1 != null) {
/*  98: 90 */       bean.setIndustry1(this.industryService.findById(industryId1));
/*  99:    */     } else {
/* 100: 92 */       bean.setIndustry1(null);
/* 101:    */     }
/* 102: 94 */     if (industryId2 != null) {
/* 103: 95 */       bean.setIndustry2(this.industryService.findById(industryId2));
/* 104:    */     } else {
/* 105: 97 */       bean.setIndustry2(null);
/* 106:    */     }
/* 107: 99 */     if (natureId != null) {
/* 108:100 */       bean.setNature(this.economyTypeService.findById(natureId));
/* 109:    */     } else {
/* 110:102 */       bean.setNature(null);
/* 111:    */     }
/* 112:104 */     if (typeId != null)
/* 113:    */     {
/* 114:105 */       ext.setDredgeTime(new Date());
/* 115:106 */       bean.setVipType(this.vipTypeService.findById(typeId));
/* 116:    */     }
/* 117:    */     else
/* 118:    */     {
/* 119:108 */       bean.setVipType(null);
/* 120:    */     }
/* 121:110 */     this.infoExtService.update(ext, bean);
/* 122:111 */     return bean;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public CompanyInfo applyVip(CompanyInfo bean, Integer typeId)
/* 126:    */   {
/* 127:115 */     Updater<CompanyInfo> updater = new Updater(bean);
/* 128:116 */     bean = this.dao.updateByUpdater(updater);
/* 129:117 */     if (typeId != null) {
/* 130:118 */       bean.setApplyType(this.vipTypeService.findById(typeId));
/* 131:    */     }
/* 132:120 */     CompanyInfoExt ext = this.infoExtService.findById(bean.getId());
/* 133:121 */     ext.setApplyVip(Boolean.valueOf(true));
/* 134:122 */     ext.setApplyTime(new Date());
/* 135:123 */     return bean;
/* 136:    */   }
/* 137:    */   
/* 138:    */   public CompanyInfo applyAgree(Integer companyId)
/* 139:    */   {
/* 140:127 */     CompanyInfo info = findById(companyId);
/* 141:128 */     CompanyInfoExt ext = this.infoExtService.findById(companyId);
/* 142:129 */     ext.setApplyVip(Boolean.valueOf(false));
/* 143:130 */     info.setVipType(info.getApplyType());
/* 144:131 */     ext.setDredgeTime(new Date());
/* 145:132 */     return info;
/* 146:    */   }
/* 147:    */   
/* 148:    */   public CompanyInfo reflush(CompanyInfo bean)
/* 149:    */   {
/* 150:136 */     Updater<CompanyInfo> updater = new Updater(bean);
/* 151:137 */     bean = this.dao.updateByUpdater(updater);
/* 152:138 */     bean.setLastPostTime(new Date());
/* 153:139 */     return bean;
/* 154:    */   }
/* 155:    */   
/* 156:    */   public CompanyInfo update(CompanyInfo bean, Integer typeId)
/* 157:    */   {
/* 158:143 */     Updater<CompanyInfo> updater = new Updater(bean);
/* 159:144 */     bean = this.dao.updateByUpdater(updater);
/* 160:145 */     CompanyInfoExt ext = this.infoExtService.findById(bean.getId());
/* 161:146 */     if (typeId != null)
/* 162:    */     {
/* 163:147 */       ext.setDredgeTime(new Date());
/* 164:148 */       bean.setVipType(this.vipTypeService.findById(typeId));
/* 165:    */     }
/* 166:    */     else
/* 167:    */     {
/* 168:150 */       bean.setVipType(null);
/* 169:    */     }
/* 170:152 */     return bean;
/* 171:    */   }
/* 172:    */   
/* 173:    */   public CompanyInfo deleteById(Integer id)
/* 174:    */   {
/* 175:156 */     CompanyInfo bean = findById(id);
/* 176:    */     
/* 177:158 */     this.companyFavoriteService.deleteByCompanyId(id);
/* 178:    */     
/* 179:160 */     this.jobPostService.deleteByCompanyId(id);
/* 180:161 */     User user = this.userService.findByCompany(id);
/* 181:162 */     if (user != null)
/* 182:    */     {
/* 183:163 */       this.siteMessageService.deleteByUserId(user.getId());
/* 184:164 */       this.userService.deleteById(user.getId());
/* 185:    */     }
/* 186:166 */     bean = this.dao.deleteById(id);
/* 187:167 */     return bean;
/* 188:    */   }
/* 189:    */   
/* 190:    */   public CompanyInfo[] deleteByIds(Integer[] ids)
/* 191:    */   {
/* 192:171 */     CompanyInfo[] beans = new CompanyInfo[ids.length];
/* 193:172 */     int i = 0;
/* 194:172 */     for (int len = ids.length; i < len; i++) {
/* 195:173 */       beans[i] = deleteById(ids[i]);
/* 196:    */     }
/* 197:175 */     return beans;
/* 198:    */   }
/* 199:    */   
/* 200:    */   @Autowired
/* 201:    */   public void setDao(CompanyInfoDao dao)
/* 202:    */   {
/* 203:190 */     this.dao = dao;
/* 204:    */   }
/* 205:    */   
/* 206:    */   @Autowired
/* 207:    */   public void setEconomyTypeService(EconomyTypeService economyTypeService)
/* 208:    */   {
/* 209:195 */     this.economyTypeService = economyTypeService;
/* 210:    */   }
/* 211:    */   
/* 212:    */   @Autowired
/* 213:    */   public void setIndustryService(IndustryService industryService)
/* 214:    */   {
/* 215:200 */     this.industryService = industryService;
/* 216:    */   }
/* 217:    */   
/* 218:    */   @Autowired
/* 219:    */   public void setPmsUserService(UserService userService)
/* 220:    */   {
/* 221:205 */     this.userService = userService;
/* 222:    */   }
/* 223:    */   
/* 224:    */   @Autowired
/* 225:    */   public void setInfoExtService(CompanyInfoExtService infoExtService)
/* 226:    */   {
/* 227:210 */     this.infoExtService = infoExtService;
/* 228:    */   }
/* 229:    */   
/* 230:    */   @Autowired
/* 231:    */   public void setJobPostService(JobPostService jobPostService)
/* 232:    */   {
/* 233:215 */     this.jobPostService = jobPostService;
/* 234:    */   }
/* 235:    */   
/* 236:    */   @Autowired
/* 237:    */   public void setCompanyFavoriteService(CompanyFavoriteService companyFavoriteService)
/* 238:    */   {
/* 239:220 */     this.companyFavoriteService = companyFavoriteService;
/* 240:    */   }
/* 241:    */   
/* 242:    */   @Autowired
/* 243:    */   public void setSiteMessageService(SiteMessageService siteMessageService)
/* 244:    */   {
/* 245:225 */     this.siteMessageService = siteMessageService;
/* 246:    */   }
/* 247:    */   
/* 248:    */   @Autowired
/* 249:    */   public void setVipTypeService(VipTypeService vipTypeService)
/* 250:    */   {
/* 251:230 */     this.vipTypeService = vipTypeService;
/* 252:    */   }
/* 253:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.service.impl.CompanyInfoServiceImpl
 * JD-Core Version:    0.7.0.1
 */