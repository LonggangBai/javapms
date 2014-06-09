/*  1:   */ package com.portal.extrafunc.action;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.page.Pagination;
/*  4:   */ import com.javapms.basic.utils.ResponseUtils;
/*  5:   */ import com.portal.extrafunc.entity.QuestionDetail;
/*  6:   */ import com.portal.extrafunc.service.QuestionDetailService;
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
/* 20:   */ public class QuestionDetailAct
/* 21:   */ {
/* 22:24 */   private static final Logger log = LoggerFactory.getLogger(QuestionDetailAct.class);
/* 23:   */   @Autowired
/* 24:   */   private QuestionDetailService service;
/* 25:   */   
/* 26:   */   @RequiresPermissions({"admin:questiondetail:list"})
/* 27:   */   @RequestMapping({"/questiondetail/v_list.do"})
/* 28:   */   public String list()
/* 29:   */   {
/* 30:29 */     return "questiondetail/list";
/* 31:   */   }
/* 32:   */   
/* 33:   */   @RequiresPermissions({"admin:questiondetail:add"})
/* 34:   */   @RequestMapping({"/questiondetail/v_add.do"})
/* 35:   */   public String add(ModelMap model)
/* 36:   */   {
/* 37:35 */     return "questiondetail/add";
/* 38:   */   }
/* 39:   */   
/* 40:   */   @RequiresPermissions({"admin:questiondetail:edit"})
/* 41:   */   @RequestMapping({"/questiondetail/v_edit.do"})
/* 42:   */   public String edit(Integer id, HttpServletRequest request, ModelMap model)
/* 43:   */   {
/* 44:41 */     model.addAttribute("questionDetail", this.service.findById(id));
/* 45:42 */     return "questiondetail/edit";
/* 46:   */   }
/* 47:   */   
/* 48:   */   @RequiresPermissions({"admin:questiondetail:update"})
/* 49:   */   @RequestMapping({"/questiondetail/o_update.do"})
/* 50:   */   public String update(QuestionDetail bean, HttpServletRequest request, ModelMap model)
/* 51:   */   {
/* 52:49 */     bean = this.service.update(bean);
/* 53:50 */     log.info("update QuestionDetail id={}.", bean.getId());
/* 54:51 */     return edit(bean.getId(), request, model);
/* 55:   */   }
/* 56:   */   
/* 57:   */   @RequestMapping({"/questiondetail/jsonData.do"})
/* 58:   */   public String dataPageByJosn(Integer questionId, Integer page, Integer pagesize, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 59:   */   {
/* 60:58 */     Pagination pagi = this.service.getPage(questionId, page.intValue(), pagesize.intValue());
/* 61:59 */     model.addAttribute("pagi", pagi);
/* 62:60 */     response.setHeader("Cache-Control", "no-cache");
/* 63:61 */     response.setContentType("text/json;charset=UTF-8");
/* 64:62 */     return "questiondetail/data";
/* 65:   */   }
/* 66:   */   
/* 67:   */   @RequiresPermissions({"admin:questiondetail:delete"})
/* 68:   */   @RequestMapping({"/questiondetail/o_ajax_delete.do"})
/* 69:   */   public void deleteQuestionDetail(Integer[] ids, HttpServletRequest request, HttpServletResponse response)
/* 70:   */     throws JSONException
/* 71:   */   {
/* 72:69 */     JSONObject json = new JSONObject();
/* 73:70 */     QuestionDetail[] beans = this.service.deleteByIds(ids);
/* 74:71 */     for (QuestionDetail bean : beans) {
/* 75:72 */       log.info("delete QuestionDetail id={}", bean.getId());
/* 76:   */     }
/* 77:74 */     json.put("success", true);
/* 78:75 */     json.put("status", 1);
/* 79:76 */     ResponseUtils.renderJson(response, json.toString());
/* 80:   */   }
/* 81:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.action.QuestionDetailAct
 * JD-Core Version:    0.7.0.1
 */