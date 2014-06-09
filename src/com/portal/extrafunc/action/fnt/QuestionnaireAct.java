/*   1:    */ package com.portal.extrafunc.action.fnt;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.utils.ServicesUtils;
/*   4:    */ import com.portal.extrafunc.entity.QuestionDetail;
/*   5:    */ import com.portal.extrafunc.entity.Questionnaire;
/*   6:    */ import com.portal.extrafunc.service.QuestionDetailService;
/*   7:    */ import com.portal.extrafunc.service.QuestionnaireService;
/*   8:    */ import com.portal.extrafunc.service.SurveyThemeService;
/*   9:    */ import com.portal.sysmgr.entity.Site;
/*  10:    */ import com.portal.sysmgr.utils.ContextTools;
/*  11:    */ import com.portal.sysmgr.utils.ViewTools;
/*  12:    */ import com.portal.usermgr.entity.User;
/*  13:    */ import java.util.Date;
/*  14:    */ import java.util.Map;
/*  15:    */ import javax.servlet.http.HttpServletRequest;
/*  16:    */ import javax.servlet.http.HttpServletResponse;
/*  17:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  18:    */ import org.springframework.stereotype.Controller;
/*  19:    */ import org.springframework.ui.ModelMap;
/*  20:    */ import org.springframework.web.bind.annotation.PathVariable;
/*  21:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  22:    */ import org.springframework.web.servlet.mvc.support.RedirectAttributes;
/*  23:    */ 
/*  24:    */ @Controller
/*  25:    */ public class QuestionnaireAct
/*  26:    */ {
/*  27:    */   public static final String QUESTION_LIST = "tpl.questionList";
/*  28:    */   public static final String QUESTION_DETAIL = "tpl.questionDetail";
/*  29:    */   @Autowired
/*  30:    */   private QuestionnaireService questService;
/*  31:    */   @Autowired
/*  32:    */   private SurveyThemeService themeService;
/*  33:    */   @Autowired
/*  34:    */   private QuestionDetailService questionDetailService;
/*  35:    */   
/*  36:    */   @RequestMapping(value={"/questionList.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  37:    */   public String questionlist(HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  38:    */   {
/*  39: 45 */     return questionlistpage(request, response, model);
/*  40:    */   }
/*  41:    */   
/*  42:    */   @RequestMapping(value={"/questionList_{page:[0-9]+}.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  43:    */   public String questionlistpage(HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  44:    */   {
/*  45: 51 */     Site site = ContextTools.getSite(request);
/*  46: 52 */     ViewTools.frontData(request, model, site);
/*  47: 53 */     ViewTools.frontPageData(request, model);
/*  48: 54 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/*  49: 55 */       "extrafunc/question", "tpl.questionList");
/*  50:    */   }
/*  51:    */   
/*  52:    */   @RequestMapping(value={"/question-{qId:[0-9]+}.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  53:    */   public String input(@PathVariable Integer qId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  54:    */   {
/*  55: 61 */     return inputpage(qId, request, response, model);
/*  56:    */   }
/*  57:    */   
/*  58:    */   @RequestMapping(value={"/question-{qId:[0-9]+}_{page:[0-9]+}.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  59:    */   public String inputpage(@PathVariable Integer qId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  60:    */   {
/*  61: 68 */     Site site = ContextTools.getSite(request);
/*  62: 69 */     Questionnaire question = this.questService.findById(qId);
/*  63: 70 */     if (question == null) {
/*  64: 71 */       return ViewTools.pageNotFound(response);
/*  65:    */     }
/*  66: 73 */     model.addAttribute("qId", qId);
/*  67: 74 */     model.addAttribute("question", question);
/*  68: 75 */     ViewTools.frontData(request, model, site);
/*  69: 76 */     ViewTools.frontPageData(request, model);
/*  70: 77 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/*  71: 78 */       "extrafunc/question", "tpl.questionDetail");
/*  72:    */   }
/*  73:    */   
/*  74:    */   @RequestMapping(value={"/questionSubmit.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  75:    */   public String questionSubmit(Integer qId, HttpServletRequest request, HttpServletResponse response, ModelMap model, RedirectAttributes ra)
/*  76:    */   {
/*  77: 84 */     Questionnaire question = this.questService.findById(qId);
/*  78: 85 */     if (question == null) {
/*  79: 86 */       return ViewTools.pageNotFound(response);
/*  80:    */     }
/*  81: 88 */     User user = ContextTools.getUser(request);
/*  82: 89 */     String result = checklogin(question, user, request, model);
/*  83: 90 */     if (result != null) {
/*  84: 91 */       return result;
/*  85:    */     }
/*  86: 93 */     String res = checkVote(question, user, request, model);
/*  87: 94 */     if (res != null)
/*  88:    */     {
/*  89: 95 */       ra.addFlashAttribute("msg", res);
/*  90: 96 */       return "redirect:question-" + qId + ".jsp";
/*  91:    */     }
/*  92: 98 */     String ip = ServicesUtils.getIpAddr(request);
/*  93: 99 */     Map<String, String> m = ServicesUtils.getRequestMap(request, "theme");
/*  94:100 */     Map<String, String[]> ml = ServicesUtils.getRequestMapList(request, 
/*  95:101 */       "thlist");
/*  96:102 */     this.themeService.voteSurvey(qId, m, ml, ip, user);
/*  97:103 */     ra.addFlashAttribute("msg", "提交成功!");
/*  98:104 */     return "redirect:question-" + qId + ".jsp";
/*  99:    */   }
/* 100:    */   
/* 101:    */   private String checklogin(Questionnaire question, User user, HttpServletRequest request, ModelMap model)
/* 102:    */   {
/* 103:109 */     if ((question.getNeedLogin().booleanValue()) && 
/* 104:110 */       (user == null)) {
/* 105:111 */       return ViewTools.showLogin(request, model, "必须登录才可以投票!");
/* 106:    */     }
/* 107:114 */     return null;
/* 108:    */   }
/* 109:    */   
/* 110:    */   private String checkVote(Questionnaire question, User user, HttpServletRequest request, ModelMap model)
/* 111:    */   {
/* 112:119 */     if (!question.getEnable().booleanValue()) {
/* 113:120 */       return "投票已关闭!";
/* 114:    */     }
/* 115:122 */     if ((question.getStartTime() != null) && 
/* 116:123 */       (!question.getStartTime().before(new Date()))) {
/* 117:124 */       return "投票还未开始!";
/* 118:    */     }
/* 119:126 */     if ((question.getEndTime() != null) && 
/* 120:127 */       (!question.getEndTime().after(new Date()))) {
/* 121:128 */       return "投票已结束!";
/* 122:    */     }
/* 123:130 */     if (question.getRepeateTime().intValue() == 9999999)
/* 124:    */     {
/* 125:131 */       if (question.getNeedLogin().booleanValue())
/* 126:    */       {
/* 127:132 */         QuestionDetail qd = this.questionDetailService.getDetail(
/* 128:133 */           question.getId(), user.getId(), null);
/* 129:134 */         if (qd != null) {
/* 130:135 */           return "你已经投过票了,不能重复投票!";
/* 131:    */         }
/* 132:    */       }
/* 133:138 */       if (question.getRestrictIp().booleanValue())
/* 134:    */       {
/* 135:139 */         String ip = ServicesUtils.getIpAddr(request);
/* 136:140 */         QuestionDetail qd = this.questionDetailService.getDetail(
/* 137:141 */           question.getId(), null, ip);
/* 138:142 */         if (qd != null) {
/* 139:143 */           return "你已经投过票了,不能重复投票!";
/* 140:    */         }
/* 141:    */       }
/* 142:    */     }
/* 143:147 */     long now = System.currentTimeMillis();
/* 144:148 */     if ((question.getRepeateTime().intValue() > 0) && 
/* 145:149 */       (question.getRepeateTime().intValue() < 9999999))
/* 146:    */     {
/* 147:150 */       Integer d = question.getRepeateTime();
/* 148:151 */       long sencond = d.intValue() * 60 * 60 * 1000;
/* 149:152 */       if (question.getNeedLogin().booleanValue())
/* 150:    */       {
/* 151:153 */         QuestionDetail qd = this.questionDetailService.getDetail(
/* 152:154 */           question.getId(), user.getId(), null);
/* 153:155 */         if (qd.getCreateTime().getTime() + sencond > now) {
/* 154:156 */           return "你已经投过票了," + d + "小时内不能重复投票!";
/* 155:    */         }
/* 156:    */       }
/* 157:159 */       if (question.getRestrictIp().booleanValue())
/* 158:    */       {
/* 159:160 */         String ip = ServicesUtils.getIpAddr(request);
/* 160:161 */         QuestionDetail qd = this.questionDetailService.getDetail(
/* 161:162 */           question.getId(), null, ip);
/* 162:163 */         if (qd.getCreateTime().getTime() + sencond > now) {
/* 163:164 */           return "你已经投过票了," + d + "小时内不能重复投票!";
/* 164:    */         }
/* 165:    */       }
/* 166:    */     }
/* 167:168 */     return null;
/* 168:    */   }
/* 169:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.action.fnt.QuestionnaireAct
 * JD-Core Version:    0.7.0.1
 */