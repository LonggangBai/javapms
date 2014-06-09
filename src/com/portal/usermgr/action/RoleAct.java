/*   1:    */ package com.portal.usermgr.action;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.page.Pagination;
/*   4:    */ import com.javapms.basic.page.SimplePage;
/*   5:    */ import com.javapms.basic.utils.ResponseUtils;
/*   6:    */ import com.portal.datacenter.operatedata.service.LogService;
/*   7:    */ import com.portal.sysmgr.entity.Site;
/*   8:    */ import com.portal.sysmgr.utils.ContextTools;
/*   9:    */ import com.portal.usermgr.entity.Role;
/*  10:    */ import com.portal.usermgr.entity.RolePerm;
/*  11:    */ import com.portal.usermgr.service.RoleService;
/*  12:    */ import java.util.Set;
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
/*  26:    */ public class RoleAct
/*  27:    */ {
/*  28: 31 */   private static final Logger log = LoggerFactory.getLogger(RoleAct.class);
/*  29:    */   @Autowired
/*  30:    */   private LogService logService;
/*  31:    */   @Autowired
/*  32:    */   private RoleService service;
/*  33:    */   
/*  34:    */   @RequiresPermissions({"admin:role:list"})
/*  35:    */   @RequestMapping({"/role/v_list.do"})
/*  36:    */   public String list(HttpServletRequest request, ModelMap model)
/*  37:    */   {
/*  38: 36 */     return "userMgr/role/list";
/*  39:    */   }
/*  40:    */   
/*  41:    */   @RequiresPermissions({"admin:role:add"})
/*  42:    */   @RequestMapping({"/role/v_add.do"})
/*  43:    */   public String add(HttpServletRequest request, ModelMap model)
/*  44:    */   {
/*  45: 42 */     return "userMgr/role/add";
/*  46:    */   }
/*  47:    */   
/*  48:    */   @RequiresPermissions({"admin:role:edit"})
/*  49:    */   @RequestMapping({"/role/v_edit.do"})
/*  50:    */   public String edit(Integer id, HttpServletRequest request, ModelMap model)
/*  51:    */   {
/*  52: 48 */     Role role = this.service.findById(id);
/*  53: 49 */     Set<String> perms = role.getPermsSet();
/*  54: 50 */     model.addAttribute("role", role);
/*  55: 51 */     model.addAttribute("perms", perms);
/*  56: 52 */     return "userMgr/role/edit";
/*  57:    */   }
/*  58:    */   
/*  59:    */   @RequiresPermissions({"admin:role:save"})
/*  60:    */   @RequestMapping({"/role/o_save.do"})
/*  61:    */   public String save(Role bean, RolePerm rolePerm, HttpServletRequest request, ModelMap model)
/*  62:    */   {
/*  63: 59 */     Site site = ContextTools.getSite(request);
/*  64: 60 */     bean = this.service.saveRole(bean, rolePerm, site);
/*  65: 61 */     log.info("save Role id={}", bean.getId());
/*  66: 62 */     this.logService.operating(request, "添加角色", "id=" + bean.getId() + ";name=" + 
/*  67: 63 */       bean.getName());
/*  68: 64 */     model.addAttribute("msg", "角色添加成功!");
/*  69: 65 */     return add(request, model);
/*  70:    */   }
/*  71:    */   
/*  72:    */   @RequiresPermissions({"admin:role:update"})
/*  73:    */   @RequestMapping({"/role/o_update.do"})
/*  74:    */   public String update(Role bean, RolePerm rolePerm, HttpServletRequest request, ModelMap model)
/*  75:    */   {
/*  76: 72 */     bean = this.service.updateRole(bean, rolePerm);
/*  77: 73 */     log.info("update Role id={}.", bean.getId());
/*  78: 74 */     this.logService.operating(request, "更新角色", "id=" + bean.getId() + ";name=" + 
/*  79: 75 */       bean.getName());
/*  80: 76 */     model.addAttribute("msg", "角色修改成功!");
/*  81: 77 */     return edit(bean.getId(), request, model);
/*  82:    */   }
/*  83:    */   
/*  84:    */   @RequestMapping({"/role/jsonData.do"})
/*  85:    */   public String dataPageByJosn(String name, Integer departId, String sortname, String sortorder, Integer page, Integer pagesize, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  86:    */   {
/*  87: 85 */     Site site = ContextTools.getSite(request);
/*  88: 86 */     Pagination pagination = this.service.getPage(name, site.getId(), sortname, 
/*  89: 87 */       sortorder, SimplePage.cpn(page), pagesize.intValue());
/*  90: 88 */     model.addAttribute("pag", pagination);
/*  91: 89 */     response.setHeader("Cache-Control", "no-cache");
/*  92: 90 */     response.setContentType("text/json;charset=UTF-8");
/*  93: 91 */     return "userMgr/role/data";
/*  94:    */   }
/*  95:    */   
/*  96:    */   @RequiresPermissions({"admin:role:delete"})
/*  97:    */   @RequestMapping({"/role/o_ajax_delete.do"})
/*  98:    */   public void deleteRole(Integer[] ids, HttpServletRequest request, HttpServletResponse response)
/*  99:    */     throws JSONException
/* 100:    */   {
/* 101: 98 */     JSONObject json = new JSONObject();
/* 102: 99 */     Role[] beans = this.service.deleteByIds(ids);
/* 103:100 */     for (Role bean : beans)
/* 104:    */     {
/* 105:101 */       log.info("delete PmsRole id={}", bean.getId());
/* 106:102 */       this.logService.operating(request, "删除角色", "id=" + bean.getId() + 
/* 107:103 */         ";name=" + bean.getName());
/* 108:    */     }
/* 109:105 */     json.put("success", true);
/* 110:106 */     json.put("status", 1);
/* 111:107 */     ResponseUtils.renderJson(response, json.toString());
/* 112:    */   }
/* 113:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.action.RoleAct
 * JD-Core Version:    0.7.0.1
 */