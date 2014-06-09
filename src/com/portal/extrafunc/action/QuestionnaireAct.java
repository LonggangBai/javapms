/*   1:    */ package com.portal.extrafunc.action;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.page.Pagination;
/*   4:    */ import com.javapms.basic.utils.ResponseUtils;
/*   5:    */ import com.portal.extrafunc.entity.Questionnaire;
/*   6:    */ import com.portal.extrafunc.entity.SurveyTheme;
/*   7:    */ import com.portal.extrafunc.service.QuestionnaireService;
/*   8:    */ import com.portal.extrafunc.service.SurveyThemeService;
/*   9:    */ import com.portal.sysmgr.entity.Site;
/*  10:    */ import com.portal.sysmgr.utils.ContextTools;
/*  11:    */ import java.util.List;
/*  12:    */ import javax.servlet.http.HttpServletRequest;
/*  13:    */ import javax.servlet.http.HttpServletResponse;
/*  14:    */ import org.apache.shiro.authz.annotation.RequiresPermissions;
/*  15:    */ import org.json.JSONException;
/*  16:    */ import org.json.JSONObject;
/*  17:    */ import org.slf4j.Logger;
/*  18:    */ import org.slf4j.LoggerFactory;
/*  19:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  20:    */ import org.springframework.stereotype.Controller;
/*  21:    */ import org.springframework.ui.ModelMap;
/*  22:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  23:    */ 
/*  24:    */ @Controller
/*  25:    */ public class QuestionnaireAct
/*  26:    */ {
/*  27: 30 */   private static final Logger log = LoggerFactory.getLogger(QuestionnaireAct.class);
/*  28:    */   @Autowired
/*  29:    */   private QuestionnaireService service;
/*  30:    */   @Autowired
/*  31:    */   private SurveyThemeService themeService;
/*  32:    */   
/*  33:    */   @RequiresPermissions({"admin:questionnaire:list"})
/*  34:    */   @RequestMapping({"/questionnaire/v_list.do"})
/*  35:    */   public String list()
/*  36:    */   {
/*  37: 35 */     return "extraFunc/questionnaire/list";
/*  38:    */   }
/*  39:    */   
/*  40:    */   @RequiresPermissions({"admin:questionnaire:add"})
/*  41:    */   @RequestMapping({"/questionnaire/v_add.do"})
/*  42:    */   public String add(ModelMap model)
/*  43:    */   {
/*  44: 41 */     return "extraFunc/questionnaire/add";
/*  45:    */   }
/*  46:    */   
/*  47:    */   @RequiresPermissions({"admin:questionnaire:edit"})
/*  48:    */   @RequestMapping({"/questionnaire/v_edit.do"})
/*  49:    */   public String edit(Integer id, HttpServletRequest request, ModelMap model)
/*  50:    */   {
/*  51: 47 */     model.addAttribute("questionnaire", this.service.findById(id));
/*  52: 48 */     return "extraFunc/questionnaire/edit";
/*  53:    */   }
/*  54:    */   
/*  55:    */   @RequiresPermissions({"admin:questionnaire:save"})
/*  56:    */   @RequestMapping({"/questionnaire/o_save.do"})
/*  57:    */   public String save(Questionnaire bean, HttpServletRequest request, ModelMap model)
/*  58:    */   {
/*  59: 55 */     Site site = ContextTools.getSite(request);
/*  60: 56 */     bean = this.service.save(bean, site);
/*  61: 57 */     log.info("save Questionnaire id={}", bean.getId());
/*  62: 58 */     model.addAttribute("msg", "调查问卷添加成功!");
/*  63: 59 */     return add(model);
/*  64:    */   }
/*  65:    */   
/*  66:    */   @RequiresPermissions({"admin:questionnaire:update"})
/*  67:    */   @RequestMapping({"/questionnaire/o_update.do"})
/*  68:    */   public String update(Questionnaire bean, HttpServletRequest request, ModelMap model)
/*  69:    */   {
/*  70: 66 */     bean = this.service.update(bean);
/*  71: 67 */     log.info("update Questionnaire id={}.", bean.getId());
/*  72: 68 */     model.addAttribute("msg", "调查问卷修改成功!");
/*  73: 69 */     return edit(bean.getId(), request, model);
/*  74:    */   }
/*  75:    */   
/*  76:    */   @RequestMapping({"/questionnaire/jsonData.do"})
/*  77:    */   public String dataPageByJosn(Integer page, Integer pagesize, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  78:    */   {
/*  79: 76 */     Site site = ContextTools.getSite(request);
/*  80: 77 */     Pagination pagi = this.service.getPage(site.getId(), false, page.intValue(), pagesize.intValue());
/*  81: 78 */     model.addAttribute("pagi", pagi);
/*  82: 79 */     response.setHeader("Cache-Control", "no-cache");
/*  83: 80 */     response.setContentType("text/json;charset=UTF-8");
/*  84: 81 */     return "extraFunc/questionnaire/data";
/*  85:    */   }
/*  86:    */   
/*  87:    */   @RequiresPermissions({"admin:questionnaire:delete"})
/*  88:    */   @RequestMapping({"/questionnaire/o_ajax_delete.do"})
/*  89:    */   public void deleteQuestionnaire(Integer[] ids, HttpServletRequest request, HttpServletResponse response)
/*  90:    */     throws JSONException
/*  91:    */   {
/*  92: 88 */     JSONObject json = new JSONObject();
/*  93: 89 */     Questionnaire[] beans = this.service.deleteByIds(ids);
/*  94: 90 */     for (Questionnaire bean : beans) {
/*  95: 91 */       log.info("delete Questionnaire id={}", bean.getId());
/*  96:    */     }
/*  97: 93 */     json.put("success", true);
/*  98: 94 */     json.put("status", 1);
/*  99: 95 */     ResponseUtils.renderJson(response, json.toString());
/* 100:    */   }
/* 101:    */   
/* 102:    */   @RequiresPermissions({"admin:questionnaire:result"})
/* 103:    */   @RequestMapping({"/questionnaire/v_result.do"})
/* 104:    */   public String result(Integer id, HttpServletRequest request, ModelMap model)
/* 105:    */   {
/* 106:102 */     List<SurveyTheme> themeList = this.themeService.getList(id);
/* 107:103 */     model.addAttribute("question", this.service.findById(id));
/* 108:104 */     model.addAttribute("themeList", themeList);
/* 109:105 */     model.addAttribute("NORMAL", SurveyTheme.NORMAL);
/* 110:106 */     return "extraFunc/questionnaire/result";
/* 111:    */   }
/* 112:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.action.QuestionnaireAct
 * JD-Core Version:    0.7.0.1
 */