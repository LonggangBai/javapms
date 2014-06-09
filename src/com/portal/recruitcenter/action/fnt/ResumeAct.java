/*   1:    */ package com.portal.recruitcenter.action.fnt;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.page.Pagination;
/*   4:    */ import com.javapms.basic.utils.ResponseUtils;
/*   5:    */ import com.portal.recruitcenter.entity.PersonalInfo;
/*   6:    */ import com.portal.recruitcenter.entity.Resume;
/*   7:    */ import com.portal.recruitcenter.entity.ResumeExt;
/*   8:    */ import com.portal.recruitcenter.service.EduExpService;
/*   9:    */ import com.portal.recruitcenter.service.LangAbilityService;
/*  10:    */ import com.portal.recruitcenter.service.ResumeService;
/*  11:    */ import com.portal.recruitcenter.service.TrainService;
/*  12:    */ import com.portal.recruitcenter.service.WorkExpService;
/*  13:    */ import com.portal.sysmgr.entity.Site;
/*  14:    */ import com.portal.sysmgr.utils.ContextTools;
/*  15:    */ import com.portal.sysmgr.utils.ViewTools;
/*  16:    */ import com.portal.usermgr.entity.User;
/*  17:    */ import com.portal.usermgr.service.UserService;
/*  18:    */ import javax.servlet.http.HttpServletRequest;
/*  19:    */ import javax.servlet.http.HttpServletResponse;
/*  20:    */ import org.json.JSONException;
/*  21:    */ import org.json.JSONObject;
/*  22:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  23:    */ import org.springframework.stereotype.Controller;
/*  24:    */ import org.springframework.ui.ModelMap;
/*  25:    */ import org.springframework.web.bind.annotation.PathVariable;
/*  26:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  27:    */ 
/*  28:    */ @Controller
/*  29:    */ public class ResumeAct
/*  30:    */ {
/*  31:    */   public static final String RESUME_LIST = "tpl.resumeList";
/*  32:    */   public static final String RESUME_ADD = "tpl.resumeAdd";
/*  33:    */   public static final String RESUME_EDIT = "tpl.resumeEdit";
/*  34:    */   public static final String RESUME_LEFT = "tpl.resumeLeft";
/*  35:    */   public static final String DETAIL = "tpl.resumeDetail";
/*  36:    */   @Autowired
/*  37:    */   private EduExpService eduExpService;
/*  38:    */   @Autowired
/*  39:    */   private ResumeService resumeService;
/*  40:    */   @Autowired
/*  41:    */   private TrainService trainService;
/*  42:    */   @Autowired
/*  43:    */   private WorkExpService workExpService;
/*  44:    */   @Autowired
/*  45:    */   private LangAbilityService langAbilityService;
/*  46:    */   @Autowired
/*  47:    */   private UserService userService;
/*  48:    */   
/*  49:    */   @RequestMapping(value={"/resume/list.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  50:    */   public String resumeList(HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  51:    */   {
/*  52: 46 */     Site site = ContextTools.getSite(request);
/*  53: 47 */     User user = ContextTools.getUser(request);
/*  54: 48 */     ViewTools.frontData(request, model, site);
/*  55:    */     
/*  56:    */ 
/*  57:    */ 
/*  58:    */ 
/*  59:    */ 
/*  60:    */ 
/*  61: 55 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/*  62: 56 */       "personal", "tpl.resumeList");
/*  63:    */   }
/*  64:    */   
/*  65:    */   @RequestMapping(value={"/resume/add.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  66:    */   public String resumeAdd(HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  67:    */   {
/*  68: 62 */     Site site = ContextTools.getSite(request);
/*  69: 63 */     User user = ContextTools.getUser(request);
/*  70: 64 */     ViewTools.frontData(request, model, site);
/*  71:    */     
/*  72:    */ 
/*  73:    */ 
/*  74: 68 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/*  75: 69 */       "personal", "tpl.resumeAdd");
/*  76:    */   }
/*  77:    */   
/*  78:    */   @RequestMapping(value={"/resume/edit.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  79:    */   public String resumeEdit(Integer resumeId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  80:    */   {
/*  81: 75 */     Site site = ContextTools.getSite(request);
/*  82: 76 */     User user = ContextTools.getUser(request);
/*  83: 77 */     ViewTools.frontData(request, model, site);
/*  84: 81 */     if (resumeId == null) {
/*  85: 82 */       return ViewTools.pageNotFound(response);
/*  86:    */     }
/*  87: 84 */     Resume resume = this.resumeService.findById(resumeId);
/*  88: 85 */     if (resume == null) {
/*  89: 86 */       return ViewTools.pageNotFound(response);
/*  90:    */     }
/*  91: 91 */     Pagination edupage = this.eduExpService.getPage(resume.getId(), 1, 10);
/*  92: 92 */     Pagination workpage = this.workExpService.getPage(resume.getId(), 1, 10);
/*  93: 93 */     Pagination trainpage = this.trainService.getPage(resume.getId(), 1, 10);
/*  94: 94 */     Pagination langpage = this.langAbilityService.getPage(resume.getId(), 1, 10);
/*  95: 95 */     model.addAttribute("edupage", edupage);
/*  96: 96 */     model.addAttribute("langpage", langpage);
/*  97: 97 */     model.addAttribute("workpage", workpage);
/*  98: 98 */     model.addAttribute("trainpage", trainpage);
/*  99: 99 */     model.addAttribute("resume", resume);
/* 100:100 */     model.addAttribute("resumeId", resumeId);
/* 101:101 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 102:102 */       "personal", "tpl.resumeEdit");
/* 103:    */   }
/* 104:    */   
/* 105:    */   @RequestMapping(value={"/resume/left.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 106:    */   public String resumeLeft(Integer resumeId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 107:    */   {
/* 108:108 */     Site site = ContextTools.getSite(request);
/* 109:109 */     User user = ContextTools.getUser(request);
/* 110:110 */     ViewTools.frontData(request, model, site);
/* 111:114 */     if (resumeId == null) {
/* 112:115 */       return ViewTools.pageNotFound(response);
/* 113:    */     }
/* 114:117 */     Resume resume = this.resumeService.findById(resumeId);
/* 115:118 */     if (resume == null) {
/* 116:119 */       return ViewTools.pageNotFound(response);
/* 117:    */     }
/* 118:124 */     model.addAttribute("resume", resume);
/* 119:125 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 120:126 */       "personal", "tpl.resumeLeft");
/* 121:    */   }
/* 122:    */   
/* 123:    */   @RequestMapping(value={"/resume/save.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 124:    */   public String resumeSave(Resume resume, ResumeExt ext, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 125:    */   {
/* 126:133 */     Site site = ContextTools.getSite(request);
/* 127:134 */     User user = ContextTools.getUser(request);
/* 128:135 */     ViewTools.frontData(request, model, site);
/* 129:    */     
/* 130:    */ 
/* 131:    */ 
/* 132:    */ 
/* 133:140 */     this.resumeService.save(resume, ext);
/* 134:141 */     return "redirect:list.jsp";
/* 135:    */   }
/* 136:    */   
/* 137:    */   @RequestMapping(value={"/resume/update.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 138:    */   public String resumeUpdate(Resume resume, ResumeExt ext, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 139:    */   {
/* 140:148 */     Site site = ContextTools.getSite(request);
/* 141:149 */     User user = ContextTools.getUser(request);
/* 142:150 */     ViewTools.frontData(request, model, site);
/* 143:154 */     if (resume.getId() == null) {
/* 144:155 */       return ViewTools.pageNotFound(response);
/* 145:    */     }
/* 146:157 */     Resume resumem = this.resumeService.findById(resume.getId());
/* 147:158 */     if (resumem == null) {
/* 148:159 */       return ViewTools.pageNotFound(response);
/* 149:    */     }
/* 150:164 */     this.resumeService.update(resume, ext);
/* 151:165 */     return "redirect:list.jsp";
/* 152:    */   }
/* 153:    */   
/* 154:    */   @RequestMapping(value={"/resume/delete.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 155:    */   public String resumeDelete(Integer resumeId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 156:    */   {
/* 157:171 */     Site site = ContextTools.getSite(request);
/* 158:172 */     User user = ContextTools.getUser(request);
/* 159:173 */     ViewTools.frontData(request, model, site);
/* 160:177 */     if (resumeId == null) {
/* 161:178 */       return ViewTools.pageNotFound(response);
/* 162:    */     }
/* 163:180 */     Resume resume = this.resumeService.findById(resumeId);
/* 164:181 */     if (resume == null) {
/* 165:182 */       return ViewTools.pageNotFound(response);
/* 166:    */     }
/* 167:187 */     this.resumeService.deleteById(resumeId);
/* 168:188 */     return "redirect:list.jsp";
/* 169:    */   }
/* 170:    */   
/* 171:    */   @RequestMapping(value={"/resume/detail{id}.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 172:    */   public String resumeDetail(@PathVariable("id") Integer id, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 173:    */   {
/* 174:195 */     Site site = ContextTools.getSite(request);
/* 175:196 */     ViewTools.frontData(request, model, site);
/* 176:197 */     if (id == null) {
/* 177:198 */       return ViewTools.pageNotFound(response);
/* 178:    */     }
/* 179:200 */     Resume resume = this.resumeService.findById(id);
/* 180:201 */     if (resume == null) {
/* 181:202 */       return ViewTools.pageNotFound(response);
/* 182:    */     }
/* 183:204 */     if (!resume.getPersonal().getCheck().booleanValue()) {
/* 184:205 */       return ViewTools.pageNotFound(response);
/* 185:    */     }
/* 186:207 */     Pagination edupage = this.eduExpService.getPage(resume.getId(), 1, 10);
/* 187:208 */     Pagination workpage = this.workExpService.getPage(resume.getId(), 1, 10);
/* 188:209 */     Pagination trainpage = this.trainService.getPage(resume.getId(), 1, 10);
/* 189:210 */     Pagination langpage = this.langAbilityService.getPage(resume.getId(), 1, 10);
/* 190:211 */     User puser = this.userService.findByPersonal(resume.getPersonal().getId());
/* 191:212 */     model.addAttribute("puser", puser);
/* 192:213 */     model.addAttribute("resume", resume);
/* 193:214 */     model.addAttribute("edupage", edupage);
/* 194:215 */     model.addAttribute("langpage", langpage);
/* 195:216 */     model.addAttribute("workpage", workpage);
/* 196:217 */     model.addAttribute("trainpage", trainpage);
/* 197:218 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 198:219 */       "recruit", "tpl.resumeDetail");
/* 199:    */   }
/* 200:    */   
/* 201:    */   @RequestMapping(value={"/resume/applydef.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 202:    */   public void resumeApplyDef(Integer resumeId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 203:    */     throws JSONException
/* 204:    */   {
/* 205:225 */     Site site = ContextTools.getSite(request);
/* 206:226 */     User user = ContextTools.getUser(request);
/* 207:227 */     ViewTools.frontData(request, model, site);
/* 208:231 */     if (resumeId == null) {
/* 209:232 */       return;
/* 210:    */     }
/* 211:234 */     Resume resume = this.resumeService.findById(resumeId);
/* 212:235 */     if (resume == null) {
/* 213:236 */       return;
/* 214:    */     }
/* 215:241 */     JSONObject json = new JSONObject();
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
/* 226:252 */     json.put("success", true);
/* 227:253 */     ResponseUtils.renderJson(response, json.toString());
/* 228:    */   }
/* 229:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.action.fnt.ResumeAct
 * JD-Core Version:    0.7.0.1
 */