/*   1:    */ package com.portal.recruitcenter.action.fnt;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.utils.ResponseUtils;
/*   4:    */ import com.javapms.basic.utils.ServicesUtils;
/*   5:    */ import com.portal.datacenter.commdata.entity.EconomyType;
/*   6:    */ import com.portal.datacenter.commdata.entity.Industry;
/*   7:    */ import com.portal.datacenter.commdata.entity.Metier;
/*   8:    */ import com.portal.datacenter.commdata.entity.Specialty;
/*   9:    */ import com.portal.datacenter.commdata.service.EconomyTypeService;
/*  10:    */ import com.portal.datacenter.commdata.service.IndustryService;
/*  11:    */ import com.portal.datacenter.commdata.service.MetierService;
/*  12:    */ import com.portal.datacenter.commdata.service.SpecialtyService;
/*  13:    */ import com.portal.recruitcenter.entity.PersonalFavorite;
/*  14:    */ import com.portal.recruitcenter.entity.PersonalInfo;
/*  15:    */ import com.portal.recruitcenter.entity.PersonalInfoExt;
/*  16:    */ import com.portal.recruitcenter.entity.ResumeApply;
/*  17:    */ import com.portal.recruitcenter.service.PersonalFavoriteService;
/*  18:    */ import com.portal.recruitcenter.service.PersonalInfoService;
/*  19:    */ import com.portal.recruitcenter.service.ResumeApplyService;
/*  20:    */ import com.portal.recruitcenter.service.ResumeService;
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
/*  36:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  37:    */ import org.springframework.web.bind.annotation.RequestParam;
/*  38:    */ import org.springframework.web.multipart.MultipartFile;
/*  39:    */ 
/*  40:    */ @Controller
/*  41:    */ public class PersonalAct
/*  42:    */ {
/*  43:    */   public static final String CENTER = "tpl.personalCenter";
/*  44:    */   public static final String REGISTER = "tpl.personalRegister";
/*  45:    */   public static final String INFO = "tpl.personalInfo";
/*  46:    */   public static final String JOB_APPLY = "tpl.jobApply";
/*  47:    */   public static final String JOB_HOUSE = "tpl.jobHouse";
/*  48:    */   public static final String JOB_SEARCH = "tpl.jobSearch";
/*  49:    */   public static final String SEARCH_INPUT = "tpl.resumeSearchInput";
/*  50:    */   public static final String SEARCH_RESULT = "tpl.resumeSearchResult";
/*  51:    */   @Autowired
/*  52:    */   private PersonalInfoService personalInfoService;
/*  53:    */   @Autowired
/*  54:    */   private ResumeApplyService resumeApplyService;
/*  55:    */   @Autowired
/*  56:    */   private ResumeService resumeService;
/*  57:    */   @Autowired
/*  58:    */   private SpecialtyService specialtyService;
/*  59:    */   @Autowired
/*  60:    */   private PersonalFavoriteService favoriteService;
/*  61:    */   @Autowired
/*  62:    */   private EconomyTypeService economyTypeService;
/*  63:    */   @Autowired
/*  64:    */   private MetierService metierService;
/*  65:    */   @Autowired
/*  66:    */   private IndustryService industryService;
/*  67:    */   
/*  68:    */   @RequestMapping(value={"/personal/center.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  69:    */   public String center(HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  70:    */   {
/*  71: 60 */     Site site = ContextTools.getSite(request);
/*  72: 61 */     User user = ContextTools.getUser(request);
/*  73: 62 */     ViewTools.frontData(request, model, site);
/*  74:    */     
/*  75:    */ 
/*  76:    */ 
/*  77: 66 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/*  78: 67 */       "personal", "tpl.personalCenter");
/*  79:    */   }
/*  80:    */   
/*  81:    */   @RequestMapping(value={"/personal/reg.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  82:    */   public String regist(HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  83:    */   {
/*  84: 73 */     Site site = ContextTools.getSite(request);
/*  85: 74 */     ViewTools.frontData(request, model, site);
/*  86: 75 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/*  87: 76 */       "personal", "tpl.personalRegister");
/*  88:    */   }
/*  89:    */   
/*  90:    */   @RequestMapping(value={"/personal/reg.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  91:    */   public String registSubmit(PersonalInfo info, PersonalInfoExt infoExt, String username, String email, String password, String captcha, String nextUrl, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  92:    */     throws IOException
/*  93:    */   {
/*  94: 84 */     Site site = ContextTools.getSite(request);
/*  95: 85 */     ViewTools.frontData(request, model, site);
/*  96: 86 */     String ip = ServicesUtils.getIpAddr(request);
/*  97: 87 */     this.personalInfoService
/*  98: 88 */       .regist(info, infoExt, username, email, password, ip);
/*  99: 89 */     if (!StringUtils.isBlank(nextUrl))
/* 100:    */     {
/* 101: 90 */       response.sendRedirect(nextUrl);
/* 102: 91 */       return null;
/* 103:    */     }
/* 104: 93 */     return "redirect:center.jsp";
/* 105:    */   }
/* 106:    */   
/* 107:    */   @RequestMapping(value={"/personal/material.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 108:    */   public String materialInput(HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 109:    */   {
/* 110:100 */     Site site = ContextTools.getSite(request);
/* 111:101 */     User user = ContextTools.getUser(request);
/* 112:102 */     ViewTools.frontData(request, model, site);
/* 113:    */     
/* 114:    */ 
/* 115:    */ 
/* 116:106 */     List<Specialty> specialtyList = this.specialtyService.getSpecialtyList(null);
/* 117:    */     
/* 118:    */ 
/* 119:    */ 
/* 120:    */ 
/* 121:    */ 
/* 122:    */ 
/* 123:    */ 
/* 124:114 */     model.addAttribute("specialtyList", specialtyList);
/* 125:115 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 126:116 */       "personal", "tpl.personalInfo");
/* 127:    */   }
/* 128:    */   
/* 129:    */   @RequestMapping(value={"/personal/material.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 130:    */   public String materialUpdate(PersonalInfo info, PersonalInfoExt infoext, Integer specialtyId, @RequestParam(value="file", required=false) MultipartFile file, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 131:    */   {
/* 132:124 */     Site site = ContextTools.getSite(request);
/* 133:125 */     User user = ContextTools.getUser(request);
/* 134:126 */     ViewTools.frontData(request, model, site);
/* 135:    */     
/* 136:    */ 
/* 137:    */ 
/* 138:    */ 
/* 139:    */ 
/* 140:132 */     this.personalInfoService.update(info, infoext, specialtyId, file, site);
/* 141:    */     
/* 142:    */ 
/* 143:135 */     return "redirect:material.jsp";
/* 144:    */   }
/* 145:    */   
/* 146:    */   @RequestMapping(value={"/personal/jobApply*.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 147:    */   public String jobApply(HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 148:    */   {
/* 149:141 */     Site site = ContextTools.getSite(request);
/* 150:142 */     User user = ContextTools.getUser(request);
/* 151:143 */     ViewTools.frontData(request, model, site);
/* 152:    */     
/* 153:    */ 
/* 154:    */ 
/* 155:147 */     int pageNo = URLTools.getPageNo(request);
/* 156:    */     
/* 157:    */ 
/* 158:    */ 
/* 159:151 */     ViewTools.frontPageData(request, model);
/* 160:152 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 161:153 */       "personal", "tpl.jobApply");
/* 162:    */   }
/* 163:    */   
/* 164:    */   @RequestMapping(value={"/personal/jobHouse*.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 165:    */   public String jobHouse(HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 166:    */   {
/* 167:159 */     Site site = ContextTools.getSite(request);
/* 168:160 */     User user = ContextTools.getUser(request);
/* 169:161 */     ViewTools.frontData(request, model, site);
/* 170:    */     
/* 171:    */ 
/* 172:    */ 
/* 173:165 */     int pageNo = URLTools.getPageNo(request);
/* 174:    */     
/* 175:    */ 
/* 176:    */ 
/* 177:169 */     ViewTools.frontPageData(request, model);
/* 178:170 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 179:171 */       "personal", "tpl.jobHouse");
/* 180:    */   }
/* 181:    */   
/* 182:    */   @RequestMapping(value={"/personal/jobSearch*.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 183:    */   public String jobSearch(String jobType, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 184:    */   {
/* 185:177 */     Site site = ContextTools.getSite(request);
/* 186:178 */     User user = ContextTools.getUser(request);
/* 187:179 */     ViewTools.frontData(request, model, site);
/* 188:    */     
/* 189:    */ 
/* 190:    */ 
/* 191:183 */     model.putAll(ServicesUtils.getQueryParams(request));
/* 192:184 */     model.addAttribute("jobType", jobType);
/* 193:185 */     List<Metier> metierList = this.metierService.getMetierList(null);
/* 194:186 */     List<Industry> industryList = this.industryService.getIndustryList(null);
/* 195:187 */     List<EconomyType> economyList = this.economyTypeService.getEconomyTypeList();
/* 196:188 */     model.addAttribute("metierList", metierList);
/* 197:189 */     model.addAttribute("industryList", industryList);
/* 198:190 */     model.addAttribute("economyList", economyList);
/* 199:191 */     ViewTools.frontPageData(request, model);
/* 200:192 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 201:193 */       "personal", "tpl.jobSearch");
/* 202:    */   }
/* 203:    */   
/* 204:    */   @RequestMapping(value={"/personal/apply.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 205:    */   public void apply(Integer jobId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 206:    */     throws JSONException
/* 207:    */   {
/* 208:199 */     Site site = ContextTools.getSite(request);
/* 209:200 */     User user = ContextTools.getUser(request);
/* 210:201 */     JSONObject json = new JSONObject();
/* 211:202 */     ViewTools.frontData(request, model, site);
/* 212:    */     
/* 213:    */ 
/* 214:    */ 
/* 215:    */ 
/* 216:    */ 
/* 217:    */ 
/* 218:    */ 
/* 219:    */ 
/* 220:    */ 
/* 221:    */ 
/* 222:    */ 
/* 223:    */ 
/* 224:    */ 
/* 225:    */ 
/* 226:    */ 
/* 227:    */ 
/* 228:    */ 
/* 229:    */ 
/* 230:    */ 
/* 231:    */ 
/* 232:    */ 
/* 233:    */ 
/* 234:    */ 
/* 235:    */ 
/* 236:    */ 
/* 237:228 */     json.put("success", true);
/* 238:229 */     json.put("status", 1);
/* 239:230 */     ResponseUtils.renderJson(response, json.toString());
/* 240:    */   }
/* 241:    */   
/* 242:    */   @RequestMapping(value={"/personal/favorite.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 243:    */   public void jobFavorite(Integer jobId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 244:    */     throws JSONException
/* 245:    */   {
/* 246:237 */     Site site = ContextTools.getSite(request);
/* 247:238 */     User user = ContextTools.getUser(request);
/* 248:239 */     JSONObject json = new JSONObject();
/* 249:240 */     ViewTools.frontData(request, model, site);
/* 250:    */     
/* 251:    */ 
/* 252:    */ 
/* 253:    */ 
/* 254:    */ 
/* 255:    */ 
/* 256:    */ 
/* 257:    */ 
/* 258:    */ 
/* 259:    */ 
/* 260:    */ 
/* 261:    */ 
/* 262:    */ 
/* 263:    */ 
/* 264:    */ 
/* 265:256 */     json.put("success", true);
/* 266:257 */     json.put("status", 1);
/* 267:258 */     ResponseUtils.renderJson(response, json.toString());
/* 268:    */   }
/* 269:    */   
/* 270:    */   @RequestMapping(value={"/personal/favoriteDelete.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 271:    */   public String favoriteDelete(Integer favoriteId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 272:    */   {
/* 273:266 */     User user = ContextTools.getUser(request);
/* 274:270 */     if (favoriteId == null) {
/* 275:271 */       return ViewTools.pageNotFound(response);
/* 276:    */     }
/* 277:273 */     PersonalFavorite favorite = this.favoriteService.findById(favoriteId);
/* 278:274 */     if (favorite == null) {
/* 279:275 */       return ViewTools.pageNotFound(response);
/* 280:    */     }
/* 281:280 */     this.favoriteService.deleteById(favoriteId);
/* 282:281 */     return "redirect:jobHouse.jsp";
/* 283:    */   }
/* 284:    */   
/* 285:    */   @RequestMapping(value={"/personal/applyDelete.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 286:    */   public String applyDelete(Integer applyId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 287:    */   {
/* 288:287 */     User user = ContextTools.getUser(request);
/* 289:291 */     if (applyId == null) {
/* 290:292 */       return ViewTools.pageNotFound(response);
/* 291:    */     }
/* 292:294 */     ResumeApply apply = this.resumeApplyService.findById(applyId);
/* 293:295 */     if (apply == null) {
/* 294:296 */       return ViewTools.pageNotFound(response);
/* 295:    */     }
/* 296:301 */     this.resumeApplyService.deleteById(applyId);
/* 297:302 */     return "redirect:jobApply.jsp";
/* 298:    */   }
/* 299:    */   
/* 300:    */   @RequestMapping(value={"/personal/resumeSearch.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 301:    */   public String resumeSearchInput(HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 302:    */   {
/* 303:308 */     Site site = ContextTools.getSite(request);
/* 304:309 */     ViewTools.frontData(request, model, site);
/* 305:310 */     List<Metier> metierList = this.metierService.getMetierList(null);
/* 306:311 */     List<Industry> industryList = this.industryService.getIndustryList(null);
/* 307:312 */     List<Specialty> specialtyList = this.specialtyService.getSpecialtyList(null);
/* 308:313 */     model.addAttribute("metierList", metierList);
/* 309:314 */     model.addAttribute("industryList", industryList);
/* 310:315 */     model.addAttribute("specialtyList", specialtyList);
/* 311:316 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 312:317 */       "recruit", "tpl.resumeSearchInput");
/* 313:    */   }
/* 314:    */   
/* 315:    */   @RequestMapping(value={"/personal/resumesearch*.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 316:    */   public String resumeSearch(HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 317:    */   {
/* 318:323 */     Site site = ContextTools.getSite(request);
/* 319:324 */     ViewTools.frontData(request, model, site);
/* 320:325 */     model.putAll(ServicesUtils.getQueryParams(request));
/* 321:326 */     List<Metier> metierList = this.metierService.getMetierList(null);
/* 322:327 */     List<Industry> industryList = this.industryService.getIndustryList(null);
/* 323:328 */     List<Specialty> specialtyList = this.specialtyService.getSpecialtyList(null);
/* 324:329 */     model.addAttribute("metierList", metierList);
/* 325:330 */     model.addAttribute("industryList", industryList);
/* 326:331 */     model.addAttribute("specialtyList", specialtyList);
/* 327:332 */     ViewTools.frontPageData(request, model);
/* 328:333 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 329:334 */       "recruit", "tpl.resumeSearchResult");
/* 330:    */   }
/* 331:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.action.fnt.PersonalAct
 * JD-Core Version:    0.7.0.1
 */