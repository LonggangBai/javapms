/*   1:    */ package com.portal.recruitcenter.action.fnt;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.utils.ServicesUtils;
/*   4:    */ import com.portal.datacenter.commdata.entity.EconomyType;
/*   5:    */ import com.portal.datacenter.commdata.entity.Industry;
/*   6:    */ import com.portal.datacenter.commdata.entity.Metier;
/*   7:    */ import com.portal.datacenter.commdata.service.EconomyTypeService;
/*   8:    */ import com.portal.datacenter.commdata.service.IndustryService;
/*   9:    */ import com.portal.datacenter.commdata.service.MetierService;
/*  10:    */ import com.portal.recruitcenter.entity.CompanyInfo;
/*  11:    */ import com.portal.recruitcenter.entity.JobPost;
/*  12:    */ import com.portal.recruitcenter.entity.JobPostExt;
/*  13:    */ import com.portal.recruitcenter.entity.VipType;
/*  14:    */ import com.portal.recruitcenter.service.JobPostService;
/*  15:    */ import com.portal.recruitcenter.service.VipTypeService;
/*  16:    */ import com.portal.sysmgr.entity.Site;
/*  17:    */ import com.portal.sysmgr.utils.ContextTools;
/*  18:    */ import com.portal.sysmgr.utils.ViewTools;
/*  19:    */ import com.portal.usermgr.entity.User;
/*  20:    */ import java.util.List;
/*  21:    */ import javax.servlet.http.HttpServletRequest;
/*  22:    */ import javax.servlet.http.HttpServletResponse;
/*  23:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  24:    */ import org.springframework.stereotype.Controller;
/*  25:    */ import org.springframework.ui.ModelMap;
/*  26:    */ import org.springframework.web.bind.annotation.PathVariable;
/*  27:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  28:    */ 
/*  29:    */ @Controller
/*  30:    */ public class JobPostAct
/*  31:    */ {
/*  32:    */   public static final String JOB_LIST = "tpl.jobList";
/*  33:    */   public static final String JOB_INPUT = "tpl.jobInput";
/*  34:    */   public static final String JOB_EDIT = "tpl.jobEdit";
/*  35:    */   public static final String JOB_INFO = "tpl.jobInfo";
/*  36:    */   public static final String JOB_SEARCH_INPUT = "tpl.jobSearchInput";
/*  37:    */   public static final String JOB_SEARCH_RESULT = "tpl.jobSearchResult";
/*  38:    */   @Autowired
/*  39:    */   private MetierService metierService;
/*  40:    */   @Autowired
/*  41:    */   private JobPostService jobPostService;
/*  42:    */   @Autowired
/*  43:    */   private EconomyTypeService economyTypeService;
/*  44:    */   @Autowired
/*  45:    */   private IndustryService industryService;
/*  46:    */   @Autowired
/*  47:    */   private VipTypeService vipTypeService;
/*  48:    */   
/*  49:    */   @RequestMapping(value={"/jobpost/list*.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  50:    */   public String list(HttpServletRequest request, Integer pageNo, HttpServletResponse response, ModelMap model)
/*  51:    */   {
/*  52: 46 */     Site site = ContextTools.getSite(request);
/*  53: 47 */     User user = ContextTools.getUser(request);
/*  54: 48 */     ViewTools.frontData(request, model, site);
/*  55:    */     
/*  56:    */ 
/*  57:    */ 
/*  58: 52 */     List<VipType> typeList = this.vipTypeService.getAllVipType();
/*  59: 53 */     ViewTools.frontPageData(request, model);
/*  60: 54 */     model.addAttribute("typeList", typeList);
/*  61: 55 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/*  62: 56 */       "company", "tpl.jobList");
/*  63:    */   }
/*  64:    */   
/*  65:    */   @RequestMapping(value={"/jobpost/input.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  66:    */   public String input(HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  67:    */   {
/*  68: 62 */     Site site = ContextTools.getSite(request);
/*  69: 63 */     User user = ContextTools.getUser(request);
/*  70: 64 */     ViewTools.frontData(request, model, site);
/*  71:    */     
/*  72:    */ 
/*  73:    */ 
/*  74:    */ 
/*  75:    */ 
/*  76:    */ 
/*  77:    */ 
/*  78:    */ 
/*  79:    */ 
/*  80:    */ 
/*  81:    */ 
/*  82:    */ 
/*  83:    */ 
/*  84:    */ 
/*  85: 79 */     List<Metier> metierList = this.metierService.getMetierList(null);
/*  86: 80 */     model.addAttribute("metierList", metierList);
/*  87: 81 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/*  88: 82 */       "company", "tpl.jobInput");
/*  89:    */   }
/*  90:    */   
/*  91:    */   @RequestMapping(value={"/jobpost/save.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  92:    */   public String submit(JobPost job, JobPostExt ext, Integer metierId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  93:    */   {
/*  94: 89 */     Site site = ContextTools.getSite(request);
/*  95: 90 */     User user = ContextTools.getUser(request);
/*  96: 91 */     ViewTools.frontData(request, model, site);
/*  97:    */     
/*  98:    */ 
/*  99:    */ 
/* 100:    */ 
/* 101:    */ 
/* 102:    */ 
/* 103:    */ 
/* 104:    */ 
/* 105:    */ 
/* 106:    */ 
/* 107:    */ 
/* 108:    */ 
/* 109:    */ 
/* 110:    */ 
/* 111:    */ 
/* 112:107 */     this.jobPostService.save(job, ext, metierId);
/* 113:108 */     return "redirect:list.jsp";
/* 114:    */   }
/* 115:    */   
/* 116:    */   @RequestMapping(value={"/jobpost/edit.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 117:    */   public String edit(Integer id, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 118:    */   {
/* 119:114 */     Site site = ContextTools.getSite(request);
/* 120:115 */     User user = ContextTools.getUser(request);
/* 121:116 */     ViewTools.frontData(request, model, site);
/* 122:    */     
/* 123:    */ 
/* 124:    */ 
/* 125:    */ 
/* 126:    */ 
/* 127:    */ 
/* 128:    */ 
/* 129:    */ 
/* 130:    */ 
/* 131:    */ 
/* 132:    */ 
/* 133:    */ 
/* 134:    */ 
/* 135:    */ 
/* 136:    */ 
/* 137:    */ 
/* 138:    */ 
/* 139:134 */     List<Metier> metierList = this.metierService.getMetierList(null);
/* 140:    */     
/* 141:    */ 
/* 142:137 */     model.addAttribute("metierList", metierList);
/* 143:    */     
/* 144:    */ 
/* 145:140 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 146:141 */       "company", "tpl.jobEdit");
/* 147:    */   }
/* 148:    */   
/* 149:    */   @RequestMapping(value={"/jobpost/update.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 150:    */   public String update(JobPost job, JobPostExt ext, Integer metierId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 151:    */   {
/* 152:148 */     Site site = ContextTools.getSite(request);
/* 153:149 */     User user = ContextTools.getUser(request);
/* 154:150 */     ViewTools.frontData(request, model, site);
/* 155:154 */     if (job.getId() == null) {
/* 156:155 */       return ViewTools.pageNotFound(response);
/* 157:    */     }
/* 158:157 */     JobPost jobpost = this.jobPostService.findById(job.getId());
/* 159:158 */     if (jobpost == null) {
/* 160:159 */       return ViewTools.pageNotFound(response);
/* 161:    */     }
/* 162:168 */     this.jobPostService.update(job, ext, metierId);
/* 163:169 */     return "redirect:list.jsp";
/* 164:    */   }
/* 165:    */   
/* 166:    */   @RequestMapping(value={"/jobpost/delete.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 167:    */   public String delete(Integer id, Integer pageNo, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 168:    */   {
/* 169:176 */     Site site = ContextTools.getSite(request);
/* 170:177 */     User user = ContextTools.getUser(request);
/* 171:178 */     ViewTools.frontData(request, model, site);
/* 172:182 */     if (id == null) {
/* 173:183 */       return ViewTools.pageNotFound(response);
/* 174:    */     }
/* 175:185 */     JobPost job = this.jobPostService.findById(id);
/* 176:186 */     if (job == null) {
/* 177:187 */       return ViewTools.pageNotFound(response);
/* 178:    */     }
/* 179:192 */     this.jobPostService.deleteById(id);
/* 180:193 */     return "redirect:list.jsp";
/* 181:    */   }
/* 182:    */   
/* 183:    */   @RequestMapping(value={"/jobpost/info{id}.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 184:    */   public String jobInfo(@PathVariable("id") Integer intentId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 185:    */   {
/* 186:200 */     Site site = ContextTools.getSite(request);
/* 187:201 */     ViewTools.frontData(request, model, site);
/* 188:202 */     if (intentId == null) {
/* 189:203 */       return ViewTools.pageNotFound(response);
/* 190:    */     }
/* 191:205 */     JobPost job = this.jobPostService.findById(intentId);
/* 192:206 */     if (job == null) {
/* 193:207 */       return ViewTools.pageNotFound(response);
/* 194:    */     }
/* 195:209 */     if ((!job.getCheck().booleanValue()) || (!job.getCompany().getCheck().booleanValue())) {
/* 196:210 */       return ViewTools.pageNotFound(response);
/* 197:    */     }
/* 198:212 */     model.addAttribute("job", job);
/* 199:213 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 200:214 */       "recruit", "tpl.jobInfo");
/* 201:    */   }
/* 202:    */   
/* 203:    */   @RequestMapping(value={"/jobpost/jobSearch.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 204:    */   public String jobSearchInput(HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 205:    */   {
/* 206:220 */     Site site = ContextTools.getSite(request);
/* 207:221 */     ViewTools.frontData(request, model, site);
/* 208:222 */     List<Metier> metierList = this.metierService.getMetierList(null);
/* 209:223 */     List<Industry> industryList = this.industryService.getIndustryList(null);
/* 210:224 */     List<EconomyType> economyList = this.economyTypeService.getEconomyTypeList();
/* 211:225 */     model.addAttribute("metierList", metierList);
/* 212:226 */     model.addAttribute("industryList", industryList);
/* 213:227 */     model.addAttribute("economyList", economyList);
/* 214:228 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 215:229 */       "recruit", "tpl.jobSearchInput");
/* 216:    */   }
/* 217:    */   
/* 218:    */   @RequestMapping(value={"/jobpost/search*.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 219:    */   public String jobSearch(String jobType, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 220:    */   {
/* 221:235 */     Site site = ContextTools.getSite(request);
/* 222:236 */     ViewTools.frontData(request, model, site);
/* 223:237 */     model.putAll(ServicesUtils.getQueryParams(request));
/* 224:238 */     model.addAttribute("jobType", jobType);
/* 225:239 */     List<Metier> metierList = this.metierService.getMetierList(null);
/* 226:240 */     List<Industry> industryList = this.industryService.getIndustryList(null);
/* 227:241 */     List<EconomyType> economyList = this.economyTypeService.getEconomyTypeList();
/* 228:242 */     model.addAttribute("metierList", metierList);
/* 229:243 */     model.addAttribute("industryList", industryList);
/* 230:244 */     model.addAttribute("economyList", economyList);
/* 231:245 */     ViewTools.frontPageData(request, model);
/* 232:246 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 233:247 */       "recruit", "tpl.jobSearchResult");
/* 234:    */   }
/* 235:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.action.fnt.JobPostAct
 * JD-Core Version:    0.7.0.1
 */