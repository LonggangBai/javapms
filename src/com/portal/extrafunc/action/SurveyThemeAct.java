/*  1:   */ package com.portal.extrafunc.action;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.page.Pagination;
/*  4:   */ import com.javapms.basic.utils.ResponseUtils;
/*  5:   */ import com.portal.extrafunc.entity.SurveyTheme;
/*  6:   */ import com.portal.extrafunc.service.SurveyThemeService;
/*  7:   */ import javax.servlet.http.HttpServletRequest;
/*  8:   */ import javax.servlet.http.HttpServletResponse;
/*  9:   */ import org.apache.shiro.authz.annotation.RequiresPermissions;
/* 10:   */ import org.json.JSONException;
/* 11:   */ import org.json.JSONObject;
/* 12:   */ import org.slf4j.Logger;
/* 13:   */ import org.slf4j.LoggerFactory;
/* 14:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 15:   */ import org.springframework.stereotype.Controller;
/* 16:   */ import org.springframework.ui.ModelMap;
/* 17:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 18:   */ 
/* 19:   */ @Controller
/* 20:   */ public class SurveyThemeAct
/* 21:   */ {
/* 22:24 */   private static final Logger log = LoggerFactory.getLogger(SurveyThemeAct.class);
/* 23:   */   @Autowired
/* 24:   */   private SurveyThemeService service;
/* 25:   */   
/* 26:   */   @RequiresPermissions({"admin:surveytheme:list"})
/* 27:   */   @RequestMapping({"/surveytheme/v_list.do"})
/* 28:   */   public String list(Integer naireId, ModelMap model)
/* 29:   */   {
/* 30:29 */     model.addAttribute("naireId", naireId);
/* 31:30 */     return "extraFunc/questionnaire/surveytheme/list";
/* 32:   */   }
/* 33:   */   
/* 34:   */   @RequiresPermissions({"admin:surveytheme:add"})
/* 35:   */   @RequestMapping({"/surveytheme/v_add.do"})
/* 36:   */   public String add(Integer naireId, ModelMap model)
/* 37:   */   {
/* 38:36 */     model.addAttribute("naireId", naireId);
/* 39:37 */     return "extraFunc/questionnaire/surveytheme/add";
/* 40:   */   }
/* 41:   */   
/* 42:   */   @RequiresPermissions({"admin:surveytheme:edit"})
/* 43:   */   @RequestMapping({"/surveytheme/v_edit.do"})
/* 44:   */   public String edit(Integer id, HttpServletRequest request, ModelMap model)
/* 45:   */   {
/* 46:43 */     model.addAttribute("surveyTheme", this.service.findById(id));
/* 47:44 */     return "extraFunc/questionnaire/surveytheme/edit";
/* 48:   */   }
/* 49:   */   
/* 50:   */   @RequiresPermissions({"admin:surveytheme:edit"})
/* 51:   */   @RequestMapping({"/surveytheme/o_save.do"})
/* 52:   */   public String save(SurveyTheme bean, Integer naireId, Integer showType1, Integer showType2, String[] names, Integer[] votes, Integer[] prioritys, HttpServletRequest request, ModelMap model)
/* 53:   */   {
/* 54:52 */     bean = this.service.save(bean, naireId, showType1, showType2, names, votes, 
/* 55:53 */       prioritys);
/* 56:54 */     log.info("save SurveyTheme id={}", bean.getId());
/* 57:55 */     model.addAttribute("msg", "调查项添加成功!");
/* 58:56 */     return add(naireId, model);
/* 59:   */   }
/* 60:   */   
/* 61:   */   @RequiresPermissions({"admin:surveytheme:update"})
/* 62:   */   @RequestMapping({"/surveytheme/o_update.do"})
/* 63:   */   public String update(SurveyTheme bean, Integer showType1, Integer showType2, String[] names, Integer[] votes, Integer[] prioritys, HttpServletRequest request, ModelMap model)
/* 64:   */   {
/* 65:64 */     bean = this.service.update(bean, showType1, showType2, names, votes, 
/* 66:65 */       prioritys);
/* 67:66 */     log.info("update SurveyTheme id={}.", bean.getId());
/* 68:67 */     model.addAttribute("msg", "调查项修改成功!");
/* 69:68 */     return edit(bean.getId(), request, model);
/* 70:   */   }
/* 71:   */   
/* 72:   */   @RequestMapping({"/surveytheme/jsonData.do"})
/* 73:   */   public String dataPageByJosn(Integer naireId, Integer page, Integer pagesize, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 74:   */   {
/* 75:75 */     Pagination pagi = this.service.getPage(naireId, page.intValue(), pagesize.intValue());
/* 76:76 */     model.addAttribute("pagi", pagi);
/* 77:77 */     response.setHeader("Cache-Control", "no-cache");
/* 78:78 */     response.setContentType("text/json;charset=UTF-8");
/* 79:79 */     return "extraFunc/questionnaire/surveytheme/data";
/* 80:   */   }
/* 81:   */   
/* 82:   */   @RequiresPermissions({"admin:surveytheme:delete"})
/* 83:   */   @RequestMapping({"/surveytheme/o_ajax_delete.do"})
/* 84:   */   public void deleteSurveyTheme(Integer[] ids, HttpServletRequest request, HttpServletResponse response)
/* 85:   */     throws JSONException
/* 86:   */   {
/* 87:86 */     JSONObject json = new JSONObject();
/* 88:87 */     SurveyTheme[] beans = this.service.deleteByIds(ids);
/* 89:88 */     for (SurveyTheme bean : beans) {
/* 90:89 */       log.info("delete SurveyTheme id={}", bean.getId());
/* 91:   */     }
/* 92:91 */     json.put("success", true);
/* 93:92 */     json.put("status", 1);
/* 94:93 */     ResponseUtils.renderJson(response, json.toString());
/* 95:   */   }
/* 96:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.action.SurveyThemeAct
 * JD-Core Version:    0.7.0.1
 */