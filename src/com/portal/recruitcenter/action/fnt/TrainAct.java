/*   1:    */ package com.portal.recruitcenter.action.fnt;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.page.Pagination;
/*   4:    */ import com.portal.recruitcenter.entity.Resume;
/*   5:    */ import com.portal.recruitcenter.entity.Train;
/*   6:    */ import com.portal.recruitcenter.service.ResumeService;
/*   7:    */ import com.portal.recruitcenter.service.TrainService;
/*   8:    */ import com.portal.sysmgr.entity.Site;
/*   9:    */ import com.portal.sysmgr.utils.ContextTools;
/*  10:    */ import com.portal.sysmgr.utils.ViewTools;
/*  11:    */ import com.portal.usermgr.entity.User;
/*  12:    */ import java.util.Calendar;
/*  13:    */ import javax.servlet.http.HttpServletRequest;
/*  14:    */ import javax.servlet.http.HttpServletResponse;
/*  15:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  16:    */ import org.springframework.stereotype.Controller;
/*  17:    */ import org.springframework.ui.ModelMap;
/*  18:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  19:    */ 
/*  20:    */ @Controller
/*  21:    */ public class TrainAct
/*  22:    */ {
/*  23:    */   public static final String TRAIN_LIST = "tpl.trainList";
/*  24:    */   public static final String TRAIN_EDIT = "tpl.trainEdit";
/*  25:    */   @Autowired
/*  26:    */   private TrainService trainService;
/*  27:    */   @Autowired
/*  28:    */   private ResumeService resumeService;
/*  29:    */   
/*  30:    */   @RequestMapping(value={"/train/list.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  31:    */   public String trainList(Integer resumeId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  32:    */   {
/*  33: 34 */     Site site = ContextTools.getSite(request);
/*  34: 35 */     User user = ContextTools.getUser(request);
/*  35: 36 */     ViewTools.frontData(request, model, site);
/*  36: 40 */     if (resumeId == null) {
/*  37: 41 */       return ViewTools.pageNotFound(response);
/*  38:    */     }
/*  39: 43 */     Resume resume = this.resumeService.findById(resumeId);
/*  40: 44 */     if (resume == null) {
/*  41: 45 */       return ViewTools.pageNotFound(response);
/*  42:    */     }
/*  43: 50 */     Calendar c = Calendar.getInstance();
/*  44: 51 */     int year = c.get(1);
/*  45: 52 */     Pagination pagination = this.trainService.getPage(resumeId, 1, 20);
/*  46: 53 */     model.addAttribute("pagination", pagination);
/*  47: 54 */     model.addAttribute("year", Integer.valueOf(year));
/*  48: 55 */     model.addAttribute("resumeId", resumeId);
/*  49: 56 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/*  50: 57 */       "personal", "tpl.trainList");
/*  51:    */   }
/*  52:    */   
/*  53:    */   @RequestMapping(value={"/train/edit.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  54:    */   public String trainEdit(Integer trainId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  55:    */   {
/*  56: 63 */     Site site = ContextTools.getSite(request);
/*  57: 64 */     User user = ContextTools.getUser(request);
/*  58: 65 */     ViewTools.frontData(request, model, site);
/*  59: 69 */     if (trainId == null) {
/*  60: 70 */       return ViewTools.pageNotFound(response);
/*  61:    */     }
/*  62: 72 */     Train train = this.trainService.findById(trainId);
/*  63: 73 */     if (train == null) {
/*  64: 74 */       return ViewTools.pageNotFound(response);
/*  65:    */     }
/*  66: 79 */     Calendar c = Calendar.getInstance();
/*  67: 80 */     int year = c.get(1);
/*  68: 81 */     Pagination pagination = this.trainService.getPage(train.getResume().getId(), 1, 
/*  69: 82 */       20);
/*  70: 83 */     String startYear = train.getStartTime().substring(0, 
/*  71: 84 */       train.getStartTime().indexOf("-"));
/*  72: 85 */     String startMonth = train.getStartTime().substring(
/*  73: 86 */       train.getStartTime().indexOf("-") + 1);
/*  74: 87 */     String endYear = train.getEndTime().substring(0, 
/*  75: 88 */       train.getEndTime().indexOf("-"));
/*  76: 89 */     String endMonth = train.getEndTime().substring(
/*  77: 90 */       train.getEndTime().indexOf("-") + 1);
/*  78: 91 */     model.addAttribute("train", train);
/*  79: 92 */     model.addAttribute("year", Integer.valueOf(year));
/*  80: 93 */     model.addAttribute("startYear", startYear);
/*  81: 94 */     model.addAttribute("startMonth", startMonth);
/*  82: 95 */     model.addAttribute("endYear", endYear);
/*  83: 96 */     model.addAttribute("endMonth", endMonth);
/*  84: 97 */     model.addAttribute("resumeId", train.getResume().getId());
/*  85: 98 */     model.addAttribute("pagination", pagination);
/*  86: 99 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/*  87:100 */       "personal", "tpl.trainEdit");
/*  88:    */   }
/*  89:    */   
/*  90:    */   @RequestMapping(value={"/train/save.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  91:    */   public String trainSave(Train train, Integer resumeId, String startYear, String startMonth, String endYear, String endMonth, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  92:    */   {
/*  93:108 */     Site site = ContextTools.getSite(request);
/*  94:109 */     User user = ContextTools.getUser(request);
/*  95:110 */     ViewTools.frontData(request, model, site);
/*  96:114 */     if (resumeId == null) {
/*  97:115 */       return ViewTools.pageNotFound(response);
/*  98:    */     }
/*  99:117 */     Resume resume = this.resumeService.findById(resumeId);
/* 100:118 */     if (resume == null) {
/* 101:119 */       return ViewTools.pageNotFound(response);
/* 102:    */     }
/* 103:124 */     String startTime = startYear + "-" + startMonth;
/* 104:125 */     String endTime = endYear + "-" + endMonth;
/* 105:126 */     train.setStartTime(startTime);
/* 106:127 */     train.setEndTime(endTime);
/* 107:128 */     this.trainService.save(train, resumeId);
/* 108:129 */     return "redirect:list.jsp?resumeId=" + resumeId;
/* 109:    */   }
/* 110:    */   
/* 111:    */   @RequestMapping(value={"/train/update.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 112:    */   public String trainUpdate(Train train, String startYear, String startMonth, String endYear, String endMonth, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 113:    */   {
/* 114:136 */     Site site = ContextTools.getSite(request);
/* 115:137 */     User user = ContextTools.getUser(request);
/* 116:138 */     ViewTools.frontData(request, model, site);
/* 117:142 */     if (train.getId() == null) {
/* 118:143 */       return ViewTools.pageNotFound(response);
/* 119:    */     }
/* 120:145 */     Train tr = this.trainService.findById(train.getId());
/* 121:146 */     if (tr == null) {
/* 122:147 */       return ViewTools.pageNotFound(response);
/* 123:    */     }
/* 124:152 */     String startTime = startYear + "-" + startMonth;
/* 125:153 */     String endTime = endYear + "-" + endMonth;
/* 126:154 */     train.setStartTime(startTime);
/* 127:155 */     train.setEndTime(endTime);
/* 128:156 */     train = this.trainService.update(train);
/* 129:157 */     return "redirect:list.jsp?resumeId=" + train.getResume().getId();
/* 130:    */   }
/* 131:    */   
/* 132:    */   @RequestMapping(value={"/train/delete.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 133:    */   public String trainDelete(Integer trainId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 134:    */   {
/* 135:163 */     Site site = ContextTools.getSite(request);
/* 136:164 */     User user = ContextTools.getUser(request);
/* 137:165 */     ViewTools.frontData(request, model, site);
/* 138:169 */     if (trainId == null) {
/* 139:170 */       return ViewTools.pageNotFound(response);
/* 140:    */     }
/* 141:172 */     Train tr = this.trainService.findById(trainId);
/* 142:173 */     if (tr == null) {
/* 143:174 */       return ViewTools.pageNotFound(response);
/* 144:    */     }
/* 145:179 */     Train train = this.trainService.deleteById(trainId);
/* 146:180 */     return "redirect:list.jsp?resumeId=" + train.getResume().getId();
/* 147:    */   }
/* 148:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.action.fnt.TrainAct
 * JD-Core Version:    0.7.0.1
 */