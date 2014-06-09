/*   1:    */ package com.portal.recruitcenter.action.fnt;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.page.Pagination;
/*   4:    */ import com.portal.datacenter.commdata.entity.Industry;
/*   5:    */ import com.portal.datacenter.commdata.entity.Metier;
/*   6:    */ import com.portal.datacenter.commdata.service.IndustryService;
/*   7:    */ import com.portal.datacenter.commdata.service.MetierService;
/*   8:    */ import com.portal.recruitcenter.entity.JobIntent;
/*   9:    */ import com.portal.recruitcenter.entity.PersonalInfo;
/*  10:    */ import com.portal.recruitcenter.entity.Resume;
/*  11:    */ import com.portal.recruitcenter.service.EduExpService;
/*  12:    */ import com.portal.recruitcenter.service.JobIntentService;
/*  13:    */ import com.portal.recruitcenter.service.ResumeService;
/*  14:    */ import com.portal.recruitcenter.service.TrainService;
/*  15:    */ import com.portal.recruitcenter.service.WorkExpService;
/*  16:    */ import com.portal.sysmgr.entity.Site;
/*  17:    */ import com.portal.sysmgr.utils.ContextTools;
/*  18:    */ import com.portal.sysmgr.utils.ViewTools;
/*  19:    */ import com.portal.usermgr.entity.User;
/*  20:    */ import com.portal.usermgr.service.UserService;
/*  21:    */ import java.util.List;
/*  22:    */ import javax.servlet.http.HttpServletRequest;
/*  23:    */ import javax.servlet.http.HttpServletResponse;
/*  24:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  25:    */ import org.springframework.stereotype.Controller;
/*  26:    */ import org.springframework.ui.ModelMap;
/*  27:    */ import org.springframework.web.bind.annotation.PathVariable;
/*  28:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  29:    */ 
/*  30:    */ @Controller
/*  31:    */ public class JobIntentAct
/*  32:    */ {
/*  33:    */   public static final String INTENT_LIST = "tpl.intentList";
/*  34:    */   public static final String INTENT_ADD = "tpl.intentAdd";
/*  35:    */   public static final String INTENT_EDIT = "tpl.intentEdit";
/*  36:    */   public static final String INTENT_INFO = "tpl.intentInfo";
/*  37:    */   @Autowired
/*  38:    */   private JobIntentService jobIntentService;
/*  39:    */   @Autowired
/*  40:    */   private EduExpService eduExpService;
/*  41:    */   @Autowired
/*  42:    */   private ResumeService resumeService;
/*  43:    */   @Autowired
/*  44:    */   private TrainService trainService;
/*  45:    */   @Autowired
/*  46:    */   private WorkExpService workExpService;
/*  47:    */   @Autowired
/*  48:    */   private MetierService metierService;
/*  49:    */   @Autowired
/*  50:    */   private IndustryService industryService;
/*  51:    */   @Autowired
/*  52:    */   private UserService userService;
/*  53:    */   
/*  54:    */   @RequestMapping(value={"/intent/edit.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  55:    */   public String intentEdit(Integer resumeId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  56:    */   {
/*  57: 45 */     Site site = ContextTools.getSite(request);
/*  58: 46 */     User user = ContextTools.getUser(request);
/*  59: 47 */     ViewTools.frontData(request, model, site);
/*  60: 51 */     if (resumeId == null) {
/*  61: 52 */       return ViewTools.pageNotFound(response);
/*  62:    */     }
/*  63: 54 */     Resume resume = this.resumeService.findById(resumeId);
/*  64: 55 */     if (resume == null) {
/*  65: 56 */       return ViewTools.pageNotFound(response);
/*  66:    */     }
/*  67: 61 */     JobIntent intent = this.jobIntentService.findById(resumeId);
/*  68: 62 */     List<Metier> metierList1 = this.metierService.getMetierList(null);
/*  69: 63 */     List<Industry> industryList1 = this.industryService.getIndustryList(null);
/*  70: 64 */     if (intent != null)
/*  71:    */     {
/*  72: 65 */       List<Metier> metierList = this.metierService.getMetierChild(intent
/*  73: 66 */         .getMetier().getParent().getId());
/*  74: 67 */       List<Industry> industryList = this.industryService
/*  75: 68 */         .getIndustryChild(intent.getIndustry().getParent().getId());
/*  76: 69 */       if (intent.getMetier2() != null)
/*  77:    */       {
/*  78: 70 */         List<Metier> metierList2 = this.metierService.getMetierChild(intent
/*  79: 71 */           .getMetier2().getParent().getId());
/*  80: 72 */         model.addAttribute("metierList2", metierList2);
/*  81:    */       }
/*  82: 74 */       model.addAttribute("metierList", metierList);
/*  83: 75 */       model.addAttribute("industryList", industryList);
/*  84:    */     }
/*  85: 77 */     model.addAttribute("resumeId", resumeId);
/*  86: 78 */     model.addAttribute("metierList1", metierList1);
/*  87: 79 */     model.addAttribute("industryList1", industryList1);
/*  88: 80 */     model.addAttribute("intent", intent);
/*  89: 81 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/*  90: 82 */       "personal", "tpl.intentEdit");
/*  91:    */   }
/*  92:    */   
/*  93:    */   @RequestMapping(value={"/intent/update.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  94:    */   public String intentUpdate(JobIntent intent, Integer resumeId, Integer metierId, Integer metierId2, Integer industryId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  95:    */   {
/*  96: 90 */     Site site = ContextTools.getSite(request);
/*  97: 91 */     User user = ContextTools.getUser(request);
/*  98: 92 */     ViewTools.frontData(request, model, site);
/*  99: 96 */     if (resumeId == null) {
/* 100: 97 */       return ViewTools.pageNotFound(response);
/* 101:    */     }
/* 102: 99 */     Resume resume = this.resumeService.findById(resumeId);
/* 103:100 */     if (resume == null) {
/* 104:101 */       return ViewTools.pageNotFound(response);
/* 105:    */     }
/* 106:106 */     JobIntent jobintent = this.jobIntentService.findById(resumeId);
/* 107:107 */     if (jobintent == null) {
/* 108:108 */       this.jobIntentService.save(intent, resumeId, metierId, metierId2, 
/* 109:109 */         industryId);
/* 110:    */     } else {
/* 111:111 */       this.jobIntentService.update(intent, resumeId, metierId, metierId2, 
/* 112:112 */         industryId);
/* 113:    */     }
/* 114:114 */     return "redirect:edit.jsp?resumeId=" + resumeId;
/* 115:    */   }
/* 116:    */   
/* 117:    */   @RequestMapping(value={"/intent/info{id}.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 118:    */   public String intentInfo(@PathVariable("id") Integer intentId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 119:    */   {
/* 120:121 */     Site site = ContextTools.getSite(request);
/* 121:122 */     ViewTools.frontData(request, model, site);
/* 122:123 */     if (intentId == null) {
/* 123:124 */       return ViewTools.pageNotFound(response);
/* 124:    */     }
/* 125:126 */     JobIntent job = this.jobIntentService.findById(intentId);
/* 126:127 */     if (job == null) {
/* 127:128 */       return ViewTools.pageNotFound(response);
/* 128:    */     }
/* 129:130 */     Pagination edupage = this.eduExpService.getPage(job.getResume().getId(), 1, 
/* 130:131 */       10);
/* 131:132 */     Pagination workpage = this.workExpService.getPage(job.getResume().getId(), 
/* 132:133 */       1, 10);
/* 133:134 */     Pagination trainpage = this.trainService.getPage(job.getResume().getId(), 1, 
/* 134:135 */       10);
/* 135:136 */     User puser = this.userService.findByPersonal(job.getResume().getPersonal()
/* 136:137 */       .getId());
/* 137:138 */     model.addAttribute("puser", puser);
/* 138:139 */     model.addAttribute("job", job);
/* 139:140 */     model.addAttribute("edupage", edupage);
/* 140:141 */     model.addAttribute("workpage", workpage);
/* 141:142 */     model.addAttribute("trainpage", trainpage);
/* 142:143 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 143:144 */       "recruit", "tpl.intentInfo");
/* 144:    */   }
/* 145:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.action.fnt.JobIntentAct
 * JD-Core Version:    0.7.0.1
 */