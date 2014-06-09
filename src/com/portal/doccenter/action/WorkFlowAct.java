/*   1:    */ package com.portal.doccenter.action;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.page.Pagination;
/*   4:    */ import com.javapms.basic.page.SimplePage;
/*   5:    */ import com.javapms.basic.utils.ResponseUtils;
/*   6:    */ import com.portal.doccenter.entity.WorkFlow;
/*   7:    */ import com.portal.doccenter.service.WorkFlowService;
/*   8:    */ import com.portal.sysmgr.entity.Site;
/*   9:    */ import com.portal.sysmgr.utils.ContextTools;
/*  10:    */ import com.portal.usermgr.entity.Role;
/*  11:    */ import com.portal.usermgr.service.RoleService;
/*  12:    */ import java.util.List;
/*  13:    */ import javax.servlet.http.HttpServletRequest;
/*  14:    */ import javax.servlet.http.HttpServletResponse;
/*  15:    */ import org.apache.shiro.authz.annotation.RequiresPermissions;
/*  16:    */ import org.json.JSONException;
/*  17:    */ import org.json.JSONObject;
/*  18:    */ import org.slf4j.Logger;
/*  19:    */ import org.slf4j.LoggerFactory;
/*  20:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  21:    */ import org.springframework.stereotype.Controller;
/*  22:    */ import org.springframework.ui.ModelMap;
/*  23:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  24:    */ 
/*  25:    */ @Controller
/*  26:    */ public class WorkFlowAct
/*  27:    */ {
/*  28: 32 */   private static final Logger log = LoggerFactory.getLogger(WorkFlowAct.class);
/*  29:    */   @Autowired
/*  30:    */   private WorkFlowService service;
/*  31:    */   @Autowired
/*  32:    */   private RoleService roleService;
/*  33:    */   
/*  34:    */   @RequiresPermissions({"admin:workflow:list"})
/*  35:    */   @RequestMapping({"/workflow/v_list.do"})
/*  36:    */   public String list(Integer pageNo, HttpServletRequest request, ModelMap model)
/*  37:    */   {
/*  38: 38 */     Site site = ContextTools.getSite(request);
/*  39: 39 */     List<Role> list = this.roleService.getListBySite(site.getId());
/*  40: 40 */     model.addAttribute("list", list);
/*  41: 41 */     return "docCenter/config/workflow/list";
/*  42:    */   }
/*  43:    */   
/*  44:    */   @RequiresPermissions({"admin:workflow:save"})
/*  45:    */   @RequestMapping({"/workflow/o_save.do"})
/*  46:    */   public String save(WorkFlow bean, Integer[] step, Integer[] roleIds, HttpServletRequest request, ModelMap model)
/*  47:    */   {
/*  48: 48 */     Site site = ContextTools.getSite(request);
/*  49: 49 */     bean = this.service.save(bean, site, step, roleIds);
/*  50: 50 */     log.info("save WorkFlow id={}", bean.getId());
/*  51: 51 */     return "redirect:v_list.do";
/*  52:    */   }
/*  53:    */   
/*  54:    */   @RequiresPermissions({"admin:workflow:update"})
/*  55:    */   @RequestMapping({"/workflow/o_update.do"})
/*  56:    */   public String update(WorkFlow bean, Integer[] step, Integer[] roleIds, Integer pageNo, HttpServletRequest request, ModelMap model)
/*  57:    */   {
/*  58: 58 */     bean = this.service.update(bean, step, roleIds);
/*  59: 59 */     log.info("update WorkFlow id={}.", bean.getId());
/*  60: 60 */     return list(pageNo, request, model);
/*  61:    */   }
/*  62:    */   
/*  63:    */   @RequestMapping({"/workflow/jsonData.do"})
/*  64:    */   public String dataPageByJosn(String sortname, String sortorder, Integer page, Integer pagesize, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  65:    */   {
/*  66: 67 */     Site site = ContextTools.getSite(request);
/*  67: 68 */     Pagination pagination = this.service.getPage(site.getId(), sortname, 
/*  68: 69 */       sortorder, SimplePage.cpn(page), pagesize.intValue());
/*  69: 70 */     model.addAttribute("page", pagination);
/*  70: 71 */     response.setHeader("Cache-Control", "no-cache");
/*  71: 72 */     response.setContentType("text/json;charset=UTF-8");
/*  72: 73 */     return "docCenter/config/workflow/dataJson";
/*  73:    */   }
/*  74:    */   
/*  75:    */   @RequiresPermissions({"admin:workflow:delete"})
/*  76:    */   @RequestMapping({"/workflow/o_ajax_delete.do"})
/*  77:    */   public void deleteWorkflow(Integer[] ids, HttpServletRequest request, HttpServletResponse response)
/*  78:    */     throws JSONException
/*  79:    */   {
/*  80: 80 */     JSONObject json = new JSONObject();
/*  81: 81 */     WorkFlow[] beans = this.service.deleteByIds(ids);
/*  82: 82 */     for (WorkFlow bean : beans) {
/*  83: 83 */       log.info("delete WorkFlow id={}", bean.getId());
/*  84:    */     }
/*  85: 85 */     json.put("success", true);
/*  86: 86 */     json.put("status", 1);
/*  87: 87 */     ResponseUtils.renderJson(response, json.toString());
/*  88:    */   }
/*  89:    */   
/*  90:    */   @RequestMapping({"/workflow/o_ajax_find.do"})
/*  91:    */   public String workflowFind(Integer id, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  92:    */   {
/*  93: 94 */     Site site = ContextTools.getSite(request);
/*  94: 95 */     WorkFlow wf = this.service.findById(id);
/*  95: 96 */     List<Role> list = this.roleService.getListBySite(site.getId());
/*  96: 97 */     model.addAttribute("list", list);
/*  97: 98 */     model.addAttribute("wf", wf);
/*  98: 99 */     response.setHeader("Cache-Control", "no-cache");
/*  99:100 */     response.setContentType("text/json;charset=UTF-8");
/* 100:101 */     return "docCenter/config/workflow/stepData";
/* 101:    */   }
/* 102:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.action.WorkFlowAct
 * JD-Core Version:    0.7.0.1
 */