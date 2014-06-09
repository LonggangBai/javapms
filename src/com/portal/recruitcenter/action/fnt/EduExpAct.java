/*   1:    */ package com.portal.recruitcenter.action.fnt;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.page.Pagination;
/*   4:    */ import com.portal.datacenter.commdata.entity.Specialty;
/*   5:    */ import com.portal.datacenter.commdata.service.SpecialtyService;
/*   6:    */ import com.portal.recruitcenter.entity.EduExp;
/*   7:    */ import com.portal.recruitcenter.entity.Resume;
/*   8:    */ import com.portal.recruitcenter.service.EduExpService;
/*   9:    */ import com.portal.recruitcenter.service.ResumeService;
/*  10:    */ import com.portal.sysmgr.entity.Site;
/*  11:    */ import com.portal.sysmgr.utils.ContextTools;
/*  12:    */ import com.portal.sysmgr.utils.ViewTools;
/*  13:    */ import com.portal.usermgr.entity.User;
/*  14:    */ import java.util.Calendar;
/*  15:    */ import java.util.List;
/*  16:    */ import javax.servlet.http.HttpServletRequest;
/*  17:    */ import javax.servlet.http.HttpServletResponse;
/*  18:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  19:    */ import org.springframework.stereotype.Controller;
/*  20:    */ import org.springframework.ui.ModelMap;
/*  21:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  22:    */ 
/*  23:    */ @Controller
/*  24:    */ public class EduExpAct
/*  25:    */ {
/*  26:    */   public static final String EDU_LIST = "tpl.eduList";
/*  27:    */   public static final String EDU_EDIT = "tpl.eduEdit";
/*  28:    */   @Autowired
/*  29:    */   private EduExpService eduExpService;
/*  30:    */   @Autowired
/*  31:    */   private ResumeService resumeService;
/*  32:    */   @Autowired
/*  33:    */   private SpecialtyService specialtyService;
/*  34:    */   
/*  35:    */   @RequestMapping(value={"/edu/list.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  36:    */   public String eduList(Integer resumeId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  37:    */   {
/*  38: 37 */     Site site = ContextTools.getSite(request);
/*  39: 38 */     User user = ContextTools.getUser(request);
/*  40: 39 */     ViewTools.frontData(request, model, site);
/*  41: 43 */     if (resumeId == null) {
/*  42: 44 */       return ViewTools.pageNotFound(response);
/*  43:    */     }
/*  44: 46 */     Resume resume = this.resumeService.findById(resumeId);
/*  45: 47 */     if (resume == null) {
/*  46: 48 */       return ViewTools.pageNotFound(response);
/*  47:    */     }
/*  48: 53 */     Calendar c = Calendar.getInstance();
/*  49: 54 */     int year = c.get(1);
/*  50: 55 */     List<Specialty> specialtyList = this.specialtyService.getSpecialtyList(null);
/*  51: 56 */     Pagination pagination = this.eduExpService.getPage(resumeId, 1, 20);
/*  52: 57 */     model.addAttribute("pagination", pagination);
/*  53: 58 */     model.addAttribute("year", Integer.valueOf(year));
/*  54: 59 */     model.addAttribute("resumeId", resumeId);
/*  55: 60 */     model.addAttribute("specialtyList", specialtyList);
/*  56: 61 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/*  57: 62 */       "personal", "tpl.eduList");
/*  58:    */   }
/*  59:    */   
/*  60:    */   @RequestMapping(value={"/edu/edit.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  61:    */   public String eduEdit(Integer eduId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  62:    */   {
/*  63: 68 */     Site site = ContextTools.getSite(request);
/*  64: 69 */     User user = ContextTools.getUser(request);
/*  65: 70 */     ViewTools.frontData(request, model, site);
/*  66: 74 */     if (eduId == null) {
/*  67: 75 */       return ViewTools.pageNotFound(response);
/*  68:    */     }
/*  69: 77 */     EduExp edu = this.eduExpService.findById(eduId);
/*  70: 78 */     if (edu == null) {
/*  71: 79 */       return ViewTools.pageNotFound(response);
/*  72:    */     }
/*  73: 84 */     Calendar c = Calendar.getInstance();
/*  74: 85 */     int year = c.get(1);
/*  75: 86 */     List<Specialty> specialtyList = this.specialtyService.getSpecialtyList(null);
/*  76: 87 */     List<Specialty> specialtyList1 = this.specialtyService.getSpecialtyChild(edu
/*  77: 88 */       .getSpecial().getParent().getId());
/*  78: 89 */     Pagination pagination = this.eduExpService.getPage(edu.getResume().getId(), 
/*  79: 90 */       1, 20);
/*  80: 91 */     String startYear = edu.getStartTime().substring(0, 
/*  81: 92 */       edu.getStartTime().indexOf("-"));
/*  82: 93 */     String startMonth = edu.getStartTime().substring(
/*  83: 94 */       edu.getStartTime().indexOf("-") + 1);
/*  84: 95 */     String endYear = edu.getEndTime().substring(0, 
/*  85: 96 */       edu.getEndTime().indexOf("-"));
/*  86: 97 */     String endMonth = edu.getEndTime().substring(
/*  87: 98 */       edu.getEndTime().indexOf("-") + 1);
/*  88: 99 */     model.addAttribute("edu", edu);
/*  89:100 */     model.addAttribute("year", Integer.valueOf(year));
/*  90:101 */     model.addAttribute("startYear", startYear);
/*  91:102 */     model.addAttribute("startMonth", startMonth);
/*  92:103 */     model.addAttribute("endYear", endYear);
/*  93:104 */     model.addAttribute("resumeId", edu.getResume().getId());
/*  94:105 */     model.addAttribute("endMonth", endMonth);
/*  95:106 */     model.addAttribute("pagination", pagination);
/*  96:107 */     model.addAttribute("specialtyList1", specialtyList1);
/*  97:108 */     model.addAttribute("specialtyList", specialtyList);
/*  98:109 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/*  99:110 */       "personal", "tpl.eduEdit");
/* 100:    */   }
/* 101:    */   
/* 102:    */   @RequestMapping(value={"/edu/save.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 103:    */   public String eduSave(EduExp edu, Integer resumeId, Integer specialtyId, String startYear, String startMonth, String endYear, String endMonth, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 104:    */   {
/* 105:118 */     Site site = ContextTools.getSite(request);
/* 106:119 */     User user = ContextTools.getUser(request);
/* 107:120 */     ViewTools.frontData(request, model, site);
/* 108:124 */     if (resumeId == null) {
/* 109:125 */       return ViewTools.pageNotFound(response);
/* 110:    */     }
/* 111:127 */     Resume resume = this.resumeService.findById(resumeId);
/* 112:128 */     if (resume == null) {
/* 113:129 */       return ViewTools.pageNotFound(response);
/* 114:    */     }
/* 115:134 */     String startTime = startYear + "-" + startMonth;
/* 116:135 */     String endTime = endYear + "-" + endMonth;
/* 117:136 */     edu.setStartTime(startTime);
/* 118:137 */     edu.setEndTime(endTime);
/* 119:138 */     this.eduExpService.save(edu, resumeId, specialtyId);
/* 120:139 */     return "redirect:list.jsp?resumeId=" + resumeId;
/* 121:    */   }
/* 122:    */   
/* 123:    */   @RequestMapping(value={"/edu/update.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 124:    */   public String eduUpdate(EduExp edu, Integer specialtyId, String startYear, String startMonth, String endYear, String endMonth, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 125:    */   {
/* 126:147 */     Site site = ContextTools.getSite(request);
/* 127:148 */     User user = ContextTools.getUser(request);
/* 128:149 */     ViewTools.frontData(request, model, site);
/* 129:153 */     if (edu.getId() == null) {
/* 130:154 */       return ViewTools.pageNotFound(response);
/* 131:    */     }
/* 132:156 */     EduExp eduexp = this.eduExpService.findById(edu.getId());
/* 133:157 */     if (eduexp == null) {
/* 134:158 */       return ViewTools.pageNotFound(response);
/* 135:    */     }
/* 136:163 */     String startTime = startYear + "-" + startMonth;
/* 137:164 */     String endTime = endYear + "-" + endMonth;
/* 138:165 */     edu.setStartTime(startTime);
/* 139:166 */     edu.setEndTime(endTime);
/* 140:167 */     edu = this.eduExpService.update(edu, specialtyId);
/* 141:168 */     return "redirect:list.jsp?resumeId=" + edu.getResume().getId();
/* 142:    */   }
/* 143:    */   
/* 144:    */   @RequestMapping(value={"/edu/delete.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 145:    */   public String eduDelete(Integer eduId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 146:    */   {
/* 147:174 */     Site site = ContextTools.getSite(request);
/* 148:175 */     User user = ContextTools.getUser(request);
/* 149:176 */     ViewTools.frontData(request, model, site);
/* 150:180 */     if (eduId == null) {
/* 151:181 */       return ViewTools.pageNotFound(response);
/* 152:    */     }
/* 153:183 */     EduExp eduexp = this.eduExpService.findById(eduId);
/* 154:184 */     if (eduexp == null) {
/* 155:185 */       return ViewTools.pageNotFound(response);
/* 156:    */     }
/* 157:190 */     EduExp edu = this.eduExpService.deleteById(eduId);
/* 158:191 */     return "redirect:list.jsp?resumeId=" + edu.getResume().getId();
/* 159:    */   }
/* 160:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.action.fnt.EduExpAct
 * JD-Core Version:    0.7.0.1
 */