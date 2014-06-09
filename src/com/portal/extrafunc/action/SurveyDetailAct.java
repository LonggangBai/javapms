/*  1:   */ package com.portal.extrafunc.action;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.page.Pagination;
/*  4:   */ import com.javapms.basic.utils.ResponseUtils;
/*  5:   */ import com.portal.extrafunc.entity.SurveyDetail;
/*  6:   */ import com.portal.extrafunc.entity.SurveyTheme;
/*  7:   */ import com.portal.extrafunc.service.SurveyDetailService;
/*  8:   */ import com.portal.extrafunc.service.SurveyThemeService;
/*  9:   */ import com.portal.sysmgr.utils.ContextTools;
/* 10:   */ import com.portal.usermgr.entity.User;
/* 11:   */ import javax.servlet.http.HttpServletRequest;
/* 12:   */ import javax.servlet.http.HttpServletResponse;
/* 13:   */ import org.apache.shiro.authz.annotation.RequiresPermissions;
/* 14:   */ import org.json.JSONException;
/* 15:   */ import org.json.JSONObject;
/* 16:   */ import org.slf4j.Logger;
/* 17:   */ import org.slf4j.LoggerFactory;
/* 18:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 19:   */ import org.springframework.stereotype.Controller;
/* 20:   */ import org.springframework.ui.ModelMap;
/* 21:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 22:   */ 
/* 23:   */ @Controller
/* 24:   */ public class SurveyDetailAct
/* 25:   */ {
/* 26:28 */   private static final Logger log = LoggerFactory.getLogger(SurveyDetailAct.class);
/* 27:   */   @Autowired
/* 28:   */   private SurveyDetailService service;
/* 29:   */   @Autowired
/* 30:   */   private SurveyThemeService themeService;
/* 31:   */   
/* 32:   */   @RequiresPermissions({"admin:surveydetail:list"})
/* 33:   */   @RequestMapping({"/surveydetail/v_list.do"})
/* 34:   */   public String list()
/* 35:   */   {
/* 36:33 */     return "surveydetail/list";
/* 37:   */   }
/* 38:   */   
/* 39:   */   @RequiresPermissions({"admin:surveydetail:add"})
/* 40:   */   @RequestMapping({"/surveydetail/v_add.do"})
/* 41:   */   public String add(ModelMap model)
/* 42:   */   {
/* 43:39 */     return "surveydetail/add";
/* 44:   */   }
/* 45:   */   
/* 46:   */   @RequiresPermissions({"admin:surveydetail:edit"})
/* 47:   */   @RequestMapping({"/surveydetail/v_edit.do"})
/* 48:   */   public String edit(Integer id, HttpServletRequest request, ModelMap model)
/* 49:   */   {
/* 50:45 */     model.addAttribute("surveyDetail", this.service.findById(id));
/* 51:46 */     return "surveydetail/edit";
/* 52:   */   }
/* 53:   */   
/* 54:   */   @RequiresPermissions({"admin:surveydetail:edit"})
/* 55:   */   @RequestMapping({"/surveydetail/o_save.do"})
/* 56:   */   public String save(String content, Integer surveyId, HttpServletRequest request, ModelMap model)
/* 57:   */   {
/* 58:53 */     User user = ContextTools.getUser(request);
/* 59:54 */     SurveyTheme st = this.themeService.findById(surveyId);
/* 60:55 */     this.service.save(content, st, user);
/* 61:56 */     return add(model);
/* 62:   */   }
/* 63:   */   
/* 64:   */   @RequiresPermissions({"admin:surveydetail:update"})
/* 65:   */   @RequestMapping({"/surveydetail/o_update.do"})
/* 66:   */   public String update(SurveyDetail bean, HttpServletRequest request, ModelMap model)
/* 67:   */   {
/* 68:63 */     bean = this.service.update(bean);
/* 69:64 */     log.info("update SurveyDetail id={}.", bean.getId());
/* 70:65 */     return edit(bean.getId(), request, model);
/* 71:   */   }
/* 72:   */   
/* 73:   */   @RequestMapping({"/surveydetail/jsonData.do"})
/* 74:   */   public String dataPageByJosn(Integer surveyId, Integer page, Integer pagesize, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 75:   */   {
/* 76:72 */     Pagination pagi = this.service.getPage(surveyId, page.intValue(), pagesize.intValue());
/* 77:73 */     model.addAttribute("pagi", pagi);
/* 78:74 */     response.setHeader("Cache-Control", "no-cache");
/* 79:75 */     response.setContentType("text/json;charset=UTF-8");
/* 80:76 */     return "surveydetail/data";
/* 81:   */   }
/* 82:   */   
/* 83:   */   @RequiresPermissions({"admin:surveydetail:delete"})
/* 84:   */   @RequestMapping({"/surveydetail/o_ajax_delete.do"})
/* 85:   */   public void deleteSurveyDetail(Integer[] ids, HttpServletRequest request, HttpServletResponse response)
/* 86:   */     throws JSONException
/* 87:   */   {
/* 88:83 */     JSONObject json = new JSONObject();
/* 89:84 */     SurveyDetail[] beans = this.service.deleteByIds(ids);
/* 90:85 */     for (SurveyDetail bean : beans) {
/* 91:86 */       log.info("delete SurveyDetail id={}", bean.getId());
/* 92:   */     }
/* 93:88 */     json.put("success", true);
/* 94:89 */     json.put("status", 1);
/* 95:90 */     ResponseUtils.renderJson(response, json.toString());
/* 96:   */   }
/* 97:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.action.SurveyDetailAct
 * JD-Core Version:    0.7.0.1
 */