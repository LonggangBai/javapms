/*   1:    */ package com.portal.recruitcenter.action.fnt;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.page.Pagination;
/*   4:    */ import com.javapms.basic.utils.ResponseUtils;
/*   5:    */ import com.javapms.basic.utils.ServicesUtils;
/*   6:    */ import com.portal.datacenter.commdata.entity.EconomyType;
/*   7:    */ import com.portal.datacenter.commdata.entity.Industry;
/*   8:    */ import com.portal.datacenter.commdata.entity.Metier;
/*   9:    */ import com.portal.datacenter.commdata.entity.Specialty;
/*  10:    */ import com.portal.datacenter.commdata.service.EconomyTypeService;
/*  11:    */ import com.portal.datacenter.commdata.service.IndustryService;
/*  12:    */ import com.portal.datacenter.commdata.service.MetierService;
/*  13:    */ import com.portal.datacenter.commdata.service.SpecialtyService;
/*  14:    */ import com.portal.recruitcenter.entity.CompanyFavorite;
/*  15:    */ import com.portal.recruitcenter.entity.CompanyInfo;
/*  16:    */ import com.portal.recruitcenter.entity.CompanyInfoExt;
/*  17:    */ import com.portal.recruitcenter.entity.ResumeApply;
/*  18:    */ import com.portal.recruitcenter.service.CompanyFavoriteService;
/*  19:    */ import com.portal.recruitcenter.service.CompanyInfoService;
/*  20:    */ import com.portal.recruitcenter.service.ResumeApplyService;
/*  21:    */ import com.portal.sysmgr.entity.Site;
/*  22:    */ import com.portal.sysmgr.utils.ContextTools;
/*  23:    */ import com.portal.sysmgr.utils.URLTools;
/*  24:    */ import com.portal.sysmgr.utils.ViewTools;
/*  25:    */ import com.portal.usermgr.entity.User;
/*  26:    */ import java.io.IOException;
/*  27:    */ import java.util.List;
/*  28:    */ import javax.servlet.http.HttpServletRequest;
/*  29:    */ import javax.servlet.http.HttpServletResponse;
/*  30:    */ import org.apache.commons.lang.StringUtils;
/*  31:    */ import org.json.JSONException;
/*  32:    */ import org.json.JSONObject;
/*  33:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  34:    */ import org.springframework.stereotype.Controller;
/*  35:    */ import org.springframework.ui.ModelMap;
/*  36:    */ import org.springframework.web.bind.annotation.PathVariable;
/*  37:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  38:    */ 
/*  39:    */ @Controller
/*  40:    */ public class CompanyAct
/*  41:    */ {
/*  42:    */   public static final String CENTER = "tpl.companyCenter";
/*  43:    */   public static final String REGISTER = "tpl.companyRegister";
/*  44:    */   public static final String INFO = "tpl.companyInfo";
/*  45:    */   public static final String DETAIL = "tpl.companyDetail";
/*  46:    */   public static final String JOB_INTERVIEW = "tpl.jobInterview";
/*  47:    */   public static final String RESUME_FAVORITE = "tpl.resumeFavorite";
/*  48:    */   public static final String RESUME_SEARCH = "tpl.resumeSearch";
/*  49:    */   @Autowired
/*  50:    */   private CompanyInfoService companyInfoService;
/*  51:    */   @Autowired
/*  52:    */   private EconomyTypeService economyTypeService;
/*  53:    */   @Autowired
/*  54:    */   private IndustryService industryService;
/*  55:    */   @Autowired
/*  56:    */   private SpecialtyService specialtyService;
/*  57:    */   @Autowired
/*  58:    */   private MetierService metierService;
/*  59:    */   @Autowired
/*  60:    */   private ResumeApplyService resumeApplyService;
/*  61:    */   @Autowired
/*  62:    */   private CompanyFavoriteService companyFavoriteService;
/*  63:    */   
/*  64:    */   @RequestMapping(value={"/company/center.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  65:    */   public String center(HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  66:    */   {
/*  67: 58 */     Site site = ContextTools.getSite(request);
/*  68: 59 */     User user = ContextTools.getUser(request);
/*  69: 60 */     ViewTools.frontData(request, model, site);
/*  70: 61 */     if (user == null) {
/*  71: 62 */       return ViewTools.showLogin(request, model, null);
/*  72:    */     }
/*  73: 64 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/*  74: 65 */       "company", "tpl.companyCenter");
/*  75:    */   }
/*  76:    */   
/*  77:    */   @RequestMapping(value={"/company/reg.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  78:    */   public String regist(HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  79:    */   {
/*  80: 71 */     Site site = ContextTools.getSite(request);
/*  81: 72 */     ViewTools.frontData(request, model, site);
/*  82: 73 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/*  83: 74 */       "company", "tpl.companyRegister");
/*  84:    */   }
/*  85:    */   
/*  86:    */   @RequestMapping(value={"/company/reg.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  87:    */   public String registSubmit(CompanyInfo info, CompanyInfoExt ext, String username, String email, String password, String captcha, String nextUrl, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  88:    */     throws IOException
/*  89:    */   {
/*  90: 82 */     Site site = ContextTools.getSite(request);
/*  91: 83 */     ViewTools.frontData(request, model, site);
/*  92: 84 */     String ip = ServicesUtils.getIpAddr(request);
/*  93: 85 */     this.companyInfoService.regist(info, ext, username, email, password, ip);
/*  94: 86 */     if (!StringUtils.isBlank(nextUrl))
/*  95:    */     {
/*  96: 87 */       response.sendRedirect(nextUrl);
/*  97: 88 */       return null;
/*  98:    */     }
/*  99: 90 */     return ViewTools.showMessage(null, request, model, "企业注册成功", Integer.valueOf(1));
/* 100:    */   }
/* 101:    */   
/* 102:    */   @RequestMapping(value={"/company/material.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 103:    */   public String materialInput(HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 104:    */   {
/* 105: 97 */     Site site = ContextTools.getSite(request);
/* 106: 98 */     User user = ContextTools.getUser(request);
/* 107: 99 */     ViewTools.frontData(request, model, site);
/* 108:100 */     if (user == null) {
/* 109:101 */       return ViewTools.showLogin(request, model, null);
/* 110:    */     }
/* 111:103 */     List<EconomyType> economyList = this.economyTypeService.getEconomyTypeList();
/* 112:104 */     List<Industry> industryList = this.industryService.getIndustryList(null);
/* 113:    */     
/* 114:    */ 
/* 115:    */ 
/* 116:    */ 
/* 117:    */ 
/* 118:    */ 
/* 119:    */ 
/* 120:    */ 
/* 121:    */ 
/* 122:    */ 
/* 123:115 */     model.addAttribute("economyList", economyList);
/* 124:116 */     model.addAttribute("industryList", industryList);
/* 125:117 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 126:118 */       "company", "tpl.companyInfo");
/* 127:    */   }
/* 128:    */   
/* 129:    */   @RequestMapping(value={"/company/jobInterview*.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 130:    */   public String jobInterview(HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 131:    */   {
/* 132:124 */     Site site = ContextTools.getSite(request);
/* 133:125 */     User user = ContextTools.getUser(request);
/* 134:126 */     ViewTools.frontData(request, model, site);
/* 135:127 */     if (user == null) {
/* 136:128 */       return ViewTools.showLogin(request, model, null);
/* 137:    */     }
/* 138:130 */     int pageNo = URLTools.getPageNo(request);
/* 139:    */     
/* 140:132 */     Pagination page = this.resumeApplyService.getPageByTag(null, null, pageNo, 
/* 141:133 */       20);
/* 142:134 */     model.addAttribute("page", page);
/* 143:135 */     ViewTools.frontPageData(request, model);
/* 144:136 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 145:137 */       "company", "tpl.jobInterview");
/* 146:    */   }
/* 147:    */   
/* 148:    */   @RequestMapping(value={"/company/favorite*.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 149:    */   public String resumeFavorite(HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 150:    */   {
/* 151:143 */     Site site = ContextTools.getSite(request);
/* 152:144 */     User user = ContextTools.getUser(request);
/* 153:145 */     ViewTools.frontData(request, model, site);
/* 154:146 */     if (user == null) {
/* 155:147 */       return ViewTools.showLogin(request, model, null);
/* 156:    */     }
/* 157:149 */     int pageNo = URLTools.getPageNo(request);
/* 158:    */     
/* 159:151 */     Pagination page = this.companyFavoriteService.getPageByTag(null, pageNo, 20);
/* 160:152 */     model.addAttribute("page", page);
/* 161:153 */     ViewTools.frontPageData(request, model);
/* 162:154 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 163:155 */       "company", "tpl.resumeFavorite");
/* 164:    */   }
/* 165:    */   
/* 166:    */   @RequestMapping(value={"/company/resumeSearch*.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 167:    */   public String resumeSearch(HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 168:    */   {
/* 169:161 */     Site site = ContextTools.getSite(request);
/* 170:162 */     User user = ContextTools.getUser(request);
/* 171:163 */     ViewTools.frontData(request, model, site);
/* 172:164 */     if (user == null) {
/* 173:165 */       return ViewTools.showLogin(request, model, null);
/* 174:    */     }
/* 175:167 */     model.putAll(ServicesUtils.getQueryParams(request));
/* 176:168 */     List<Metier> metierList = this.metierService.getMetierList(null);
/* 177:169 */     List<Industry> industryList = this.industryService.getIndustryList(null);
/* 178:170 */     List<Specialty> specialtyList = this.specialtyService.getSpecialtyList(null);
/* 179:171 */     model.addAttribute("metierList", metierList);
/* 180:172 */     model.addAttribute("industryList", industryList);
/* 181:173 */     model.addAttribute("specialtyList", specialtyList);
/* 182:174 */     ViewTools.frontPageData(request, model);
/* 183:175 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 184:176 */       "company", "tpl.resumeSearch");
/* 185:    */   }
/* 186:    */   
/* 187:    */   @RequestMapping(value={"/company/material.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 188:    */   public String materialUpdate(CompanyInfo info, CompanyInfoExt infoext, Integer natureId, Integer industryId1, Integer industryId2, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 189:    */   {
/* 190:184 */     Site site = ContextTools.getSite(request);
/* 191:185 */     User user = ContextTools.getUser(request);
/* 192:186 */     ViewTools.frontData(request, model, site);
/* 193:187 */     if (user == null) {
/* 194:188 */       return ViewTools.showLogin(request, model, null);
/* 195:    */     }
/* 196:196 */     return "redirect:material.jsp";
/* 197:    */   }
/* 198:    */   
/* 199:    */   @RequestMapping({"/company/reflush.jsp"})
/* 200:    */   public String companyReflush(String nextUrl, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 201:    */     throws IOException
/* 202:    */   {
/* 203:202 */     Site site = ContextTools.getSite(request);
/* 204:203 */     User user = ContextTools.getUser(request);
/* 205:204 */     ViewTools.frontData(request, model, site);
/* 206:205 */     if (user == null) {
/* 207:206 */       return ViewTools.showLogin(request, model, null);
/* 208:    */     }
/* 209:209 */     if (!StringUtils.isBlank(nextUrl))
/* 210:    */     {
/* 211:210 */       response.sendRedirect(nextUrl);
/* 212:211 */       return null;
/* 213:    */     }
/* 214:213 */     return "redirect:material.jsp";
/* 215:    */   }
/* 216:    */   
/* 217:    */   @RequestMapping(value={"/company/resumefavorite.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 218:    */   public void resumefavorite(Integer resumeId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 219:    */     throws JSONException
/* 220:    */   {
/* 221:220 */     Site site = ContextTools.getSite(request);
/* 222:221 */     User user = ContextTools.getUser(request);
/* 223:222 */     ViewTools.frontData(request, model, site);
/* 224:223 */     if (user == null) {
/* 225:224 */       return;
/* 226:    */     }
/* 227:226 */     JSONObject json = new JSONObject();
/* 228:    */     
/* 229:    */ 
/* 230:    */ 
/* 231:    */ 
/* 232:    */ 
/* 233:    */ 
/* 234:    */ 
/* 235:    */ 
/* 236:    */ 
/* 237:    */ 
/* 238:    */ 
/* 239:    */ 
/* 240:    */ 
/* 241:    */ 
/* 242:    */ 
/* 243:    */ 
/* 244:    */ 
/* 245:    */ 
/* 246:245 */     CompanyFavorite favorite = this.companyFavoriteService.getFavoriteByCompany(
/* 247:246 */       null, resumeId);
/* 248:247 */     if (favorite != null)
/* 249:    */     {
/* 250:248 */       json.put("success", false);
/* 251:249 */       json.put("status", 0);
/* 252:250 */       ResponseUtils.renderJson(response, json.toString());
/* 253:251 */       return;
/* 254:    */     }
/* 255:253 */     this.companyFavoriteService.saveFavorite(null, resumeId);
/* 256:254 */     json.put("success", true);
/* 257:255 */     json.put("status", 1);
/* 258:256 */     ResponseUtils.renderJson(response, json.toString());
/* 259:    */   }
/* 260:    */   
/* 261:    */   @RequestMapping(value={"/company/favoriteDelete.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 262:    */   public String favoriteDelete(Integer favoriteId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 263:    */   {
/* 264:264 */     User user = ContextTools.getUser(request);
/* 265:265 */     if (user == null) {
/* 266:266 */       return ViewTools.showLogin(request, model, null);
/* 267:    */     }
/* 268:268 */     if (favoriteId == null) {
/* 269:269 */       return ViewTools.pageNotFound(response);
/* 270:    */     }
/* 271:271 */     CompanyFavorite favorite = this.companyFavoriteService.findById(favoriteId);
/* 272:272 */     if (favorite == null) {
/* 273:273 */       return ViewTools.pageNotFound(response);
/* 274:    */     }
/* 275:278 */     this.companyFavoriteService.deleteById(favoriteId);
/* 276:279 */     return "redirect:favorite.jsp";
/* 277:    */   }
/* 278:    */   
/* 279:    */   @RequestMapping(value={"/company/applyDelete.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 280:    */   public String applyDelete(Integer applyId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 281:    */   {
/* 282:285 */     User user = ContextTools.getUser(request);
/* 283:286 */     if (user == null) {
/* 284:287 */       return ViewTools.showLogin(request, model, null);
/* 285:    */     }
/* 286:289 */     if (applyId == null) {
/* 287:290 */       return ViewTools.pageNotFound(response);
/* 288:    */     }
/* 289:292 */     ResumeApply apply = this.resumeApplyService.findById(applyId);
/* 290:293 */     if (apply == null) {
/* 291:294 */       return ViewTools.pageNotFound(response);
/* 292:    */     }
/* 293:299 */     this.resumeApplyService.deleteById(applyId);
/* 294:300 */     return "redirect:jobInterview.jsp";
/* 295:    */   }
/* 296:    */   
/* 297:    */   @RequestMapping(value={"/company/detail{id}.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 298:    */   public String companyDetail(@PathVariable("id") Integer companyId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 299:    */   {
/* 300:307 */     Site site = ContextTools.getSite(request);
/* 301:308 */     if (companyId == null) {
/* 302:309 */       return ViewTools.pageNotFound(response);
/* 303:    */     }
/* 304:311 */     CompanyInfo company = this.companyInfoService.findById(companyId);
/* 305:312 */     if (company == null) {
/* 306:313 */       return ViewTools.pageNotFound(response);
/* 307:    */     }
/* 308:315 */     if (!company.getCheck().booleanValue()) {
/* 309:316 */       return ViewTools.pageNotFound(response);
/* 310:    */     }
/* 311:318 */     ViewTools.frontData(request, model, site);
/* 312:319 */     model.addAttribute("company", company);
/* 313:320 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 314:321 */       "recruit", "tpl.companyDetail");
/* 315:    */   }
/* 316:    */   
/* 317:    */   @RequestMapping(value={"/company/applyVip.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 318:    */   public void applyVip(Integer typeId, String linkMan, String linkTel, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 319:    */     throws JSONException
/* 320:    */   {
/* 321:328 */     Site site = ContextTools.getSite(request);
/* 322:329 */     User user = ContextTools.getUser(request);
/* 323:330 */     ViewTools.frontData(request, model, site);
/* 324:331 */     if (user == null) {
/* 325:332 */       return;
/* 326:    */     }
/* 327:334 */     JSONObject json = new JSONObject();
/* 328:    */     
/* 329:    */ 
/* 330:    */ 
/* 331:    */ 
/* 332:    */ 
/* 333:    */ 
/* 334:    */ 
/* 335:    */ 
/* 336:    */ 
/* 337:    */ 
/* 338:    */ 
/* 339:    */ 
/* 340:    */ 
/* 341:    */ 
/* 342:349 */     json.put("success", true);
/* 343:350 */     json.put("status", 1);
/* 344:351 */     ResponseUtils.renderJson(response, json.toString());
/* 345:    */   }
/* 346:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.action.fnt.CompanyAct
 * JD-Core Version:    0.7.0.1
 */