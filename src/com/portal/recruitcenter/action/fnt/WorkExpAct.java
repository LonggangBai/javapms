/*   1:    */ package com.portal.recruitcenter.action.fnt;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.page.Pagination;
/*   4:    */ import com.portal.datacenter.commdata.entity.EconomyType;
/*   5:    */ import com.portal.datacenter.commdata.entity.Industry;
/*   6:    */ import com.portal.datacenter.commdata.entity.Metier;
/*   7:    */ import com.portal.datacenter.commdata.service.EconomyTypeService;
/*   8:    */ import com.portal.datacenter.commdata.service.IndustryService;
/*   9:    */ import com.portal.datacenter.commdata.service.MetierService;
/*  10:    */ import com.portal.recruitcenter.entity.Resume;
/*  11:    */ import com.portal.recruitcenter.entity.WorkExp;
/*  12:    */ import com.portal.recruitcenter.service.ResumeService;
/*  13:    */ import com.portal.recruitcenter.service.WorkExpService;
/*  14:    */ import com.portal.sysmgr.entity.Site;
/*  15:    */ import com.portal.sysmgr.utils.ContextTools;
/*  16:    */ import com.portal.sysmgr.utils.ViewTools;
/*  17:    */ import com.portal.usermgr.entity.User;
/*  18:    */ import java.util.Calendar;
/*  19:    */ import java.util.List;
/*  20:    */ import javax.servlet.http.HttpServletRequest;
/*  21:    */ import javax.servlet.http.HttpServletResponse;
/*  22:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  23:    */ import org.springframework.stereotype.Controller;
/*  24:    */ import org.springframework.ui.ModelMap;
/*  25:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  26:    */ 
/*  27:    */ @Controller
/*  28:    */ public class WorkExpAct
/*  29:    */ {
/*  30:    */   public static final String WORK_LIST = "tpl.workList";
/*  31:    */   public static final String WORK_EDIT = "tpl.workEdit";
/*  32:    */   @Autowired
/*  33:    */   private WorkExpService workExpService;
/*  34:    */   @Autowired
/*  35:    */   private EconomyTypeService economyTypeService;
/*  36:    */   @Autowired
/*  37:    */   private ResumeService resumeService;
/*  38:    */   @Autowired
/*  39:    */   private MetierService metierService;
/*  40:    */   @Autowired
/*  41:    */   private IndustryService industryService;
/*  42:    */   
/*  43:    */   @RequestMapping(value={"/work/list.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  44:    */   public String workList(Integer resumeId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  45:    */   {
/*  46: 41 */     Site site = ContextTools.getSite(request);
/*  47: 42 */     User user = ContextTools.getUser(request);
/*  48: 43 */     ViewTools.frontData(request, model, site);
/*  49: 47 */     if (resumeId == null) {
/*  50: 48 */       return ViewTools.pageNotFound(response);
/*  51:    */     }
/*  52: 50 */     Resume resume = this.resumeService.findById(resumeId);
/*  53: 51 */     if (resume == null) {
/*  54: 52 */       return ViewTools.pageNotFound(response);
/*  55:    */     }
/*  56: 57 */     Calendar c = Calendar.getInstance();
/*  57: 58 */     int year = c.get(1);
/*  58: 59 */     Pagination pagination = this.workExpService.getPage(resumeId, 1, 20);
/*  59: 60 */     List<Metier> metierList = this.metierService.getMetierList(null);
/*  60: 61 */     List<Industry> industryList = this.industryService.getIndustryList(null);
/*  61: 62 */     List<EconomyType> economyList = this.economyTypeService.getEconomyTypeList();
/*  62: 63 */     model.addAttribute("metierList", metierList);
/*  63: 64 */     model.addAttribute("year", Integer.valueOf(year));
/*  64: 65 */     model.addAttribute("resumeId", resumeId);
/*  65: 66 */     model.addAttribute("industryList", industryList);
/*  66: 67 */     model.addAttribute("economyList", economyList);
/*  67: 68 */     model.addAttribute("pagination", pagination);
/*  68: 69 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/*  69: 70 */       "personal", "tpl.workList");
/*  70:    */   }
/*  71:    */   
/*  72:    */   @RequestMapping(value={"/work/edit.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  73:    */   public String workEdit(Integer workId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  74:    */   {
/*  75: 76 */     Site site = ContextTools.getSite(request);
/*  76: 77 */     User user = ContextTools.getUser(request);
/*  77: 78 */     ViewTools.frontData(request, model, site);
/*  78: 82 */     if (workId == null) {
/*  79: 83 */       return ViewTools.pageNotFound(response);
/*  80:    */     }
/*  81: 85 */     WorkExp work = this.workExpService.findById(workId);
/*  82: 86 */     if (work == null) {
/*  83: 87 */       return ViewTools.pageNotFound(response);
/*  84:    */     }
/*  85: 92 */     Calendar c = Calendar.getInstance();
/*  86: 93 */     int year = c.get(1);
/*  87: 94 */     Pagination pagination = this.workExpService.getPage(work.getResume().getId(), 1, 
/*  88: 95 */       20);
/*  89: 96 */     List<Metier> metierList = this.metierService.getMetierList(null);
/*  90: 97 */     List<Industry> industryList = this.industryService.getIndustryList(null);
/*  91: 98 */     List<Industry> industryList1 = this.industryService.getIndustryChild(work
/*  92: 99 */       .getIndustry().getParent().getId());
/*  93:100 */     List<Metier> metierList1 = this.metierService.getMetierChild(work.getMetier()
/*  94:101 */       .getParent().getId());
/*  95:102 */     List<EconomyType> economyList = this.economyTypeService.getEconomyTypeList();
/*  96:103 */     String startYear = work.getStartTime().substring(0, 
/*  97:104 */       work.getStartTime().indexOf("-"));
/*  98:105 */     String startMonth = work.getStartTime().substring(
/*  99:106 */       work.getStartTime().indexOf("-") + 1);
/* 100:107 */     String endYear = work.getEndTime().substring(0, 
/* 101:108 */       work.getEndTime().indexOf("-"));
/* 102:109 */     String endMonth = work.getEndTime().substring(
/* 103:110 */       work.getEndTime().indexOf("-") + 1);
/* 104:111 */     model.addAttribute("metierList", metierList);
/* 105:112 */     model.addAttribute("industryList", industryList);
/* 106:113 */     model.addAttribute("industryList1", industryList1);
/* 107:114 */     model.addAttribute("metierList1", metierList1);
/* 108:115 */     model.addAttribute("economyList", economyList);
/* 109:116 */     model.addAttribute("work", work);
/* 110:117 */     model.addAttribute("year", Integer.valueOf(year));
/* 111:118 */     model.addAttribute("startYear", startYear);
/* 112:119 */     model.addAttribute("startMonth", startMonth);
/* 113:120 */     model.addAttribute("endYear", endYear);
/* 114:121 */     model.addAttribute("endMonth", endMonth);
/* 115:122 */     model.addAttribute("resumeId", work.getResume().getId());
/* 116:123 */     model.addAttribute("pagination", pagination);
/* 117:124 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 118:125 */       "personal", "tpl.workEdit");
/* 119:    */   }
/* 120:    */   
/* 121:    */   @RequestMapping(value={"/work/save.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 122:    */   public String workSave(WorkExp work, Integer resumeId, Integer metierId, Integer industryId, Integer economyId, String startYear, String startMonth, String endYear, String endMonth, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 123:    */   {
/* 124:134 */     Site site = ContextTools.getSite(request);
/* 125:135 */     User user = ContextTools.getUser(request);
/* 126:136 */     ViewTools.frontData(request, model, site);
/* 127:140 */     if (resumeId == null) {
/* 128:141 */       return ViewTools.pageNotFound(response);
/* 129:    */     }
/* 130:143 */     Resume resume = this.resumeService.findById(resumeId);
/* 131:144 */     if (resume == null) {
/* 132:145 */       return ViewTools.pageNotFound(response);
/* 133:    */     }
/* 134:150 */     String startTime = startYear + "-" + startMonth;
/* 135:151 */     String endTime = endYear + "-" + endMonth;
/* 136:152 */     work.setStartTime(startTime);
/* 137:153 */     work.setEndTime(endTime);
/* 138:154 */     this.workExpService.save(work, resumeId, metierId, industryId, economyId);
/* 139:155 */     return "redirect:list.jsp?resumeId=" + resumeId;
/* 140:    */   }
/* 141:    */   
/* 142:    */   @RequestMapping(value={"/work/update.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 143:    */   public String workUpdate(WorkExp work, Integer metierId, Integer industryId, Integer economyId, String startYear, String startMonth, String endYear, String endMonth, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 144:    */   {
/* 145:164 */     Site site = ContextTools.getSite(request);
/* 146:165 */     User user = ContextTools.getUser(request);
/* 147:166 */     ViewTools.frontData(request, model, site);
/* 148:170 */     if (work.getId() == null) {
/* 149:171 */       return ViewTools.pageNotFound(response);
/* 150:    */     }
/* 151:173 */     WorkExp workexp = this.workExpService.findById(work.getId());
/* 152:174 */     if (workexp == null) {
/* 153:175 */       return ViewTools.pageNotFound(response);
/* 154:    */     }
/* 155:180 */     String startTime = startYear + "-" + startMonth;
/* 156:181 */     String endTime = endYear + "-" + endMonth;
/* 157:182 */     work.setStartTime(startTime);
/* 158:183 */     work.setEndTime(endTime);
/* 159:184 */     WorkExp exp = this.workExpService.update(work, metierId, industryId, economyId);
/* 160:185 */     return "redirect:list.jsp?resumeId=" + exp.getResume().getId();
/* 161:    */   }
/* 162:    */   
/* 163:    */   @RequestMapping(value={"/work/delete.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 164:    */   public String workDelete(Integer workId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 165:    */   {
/* 166:191 */     Site site = ContextTools.getSite(request);
/* 167:192 */     User user = ContextTools.getUser(request);
/* 168:193 */     ViewTools.frontData(request, model, site);
/* 169:197 */     if (workId == null) {
/* 170:198 */       return ViewTools.pageNotFound(response);
/* 171:    */     }
/* 172:200 */     WorkExp workexp = this.workExpService.findById(workId);
/* 173:201 */     if (workexp == null) {
/* 174:202 */       return ViewTools.pageNotFound(response);
/* 175:    */     }
/* 176:207 */     WorkExp work = this.workExpService.deleteById(workId);
/* 177:208 */     return "redirect:list.jsp?resumeId=" + work.getResume().getId();
/* 178:    */   }
/* 179:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.action.fnt.WorkExpAct
 * JD-Core Version:    0.7.0.1
 */