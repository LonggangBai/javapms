/*   1:    */ package com.portal.sysmgr.action;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.utils.ResponseUtils;
/*   4:    */ import com.portal.sysmgr.entity.Site;
/*   5:    */ import com.portal.sysmgr.service.SiteService;
/*   6:    */ import com.portal.sysmgr.utils.ContextTools;
/*   7:    */ import com.portal.usermgr.entity.User;
/*   8:    */ import java.io.IOException;
/*   9:    */ import java.util.List;
/*  10:    */ import javax.servlet.http.HttpServletRequest;
/*  11:    */ import javax.servlet.http.HttpServletResponse;
/*  12:    */ import org.apache.commons.lang.StringUtils;
/*  13:    */ import org.apache.shiro.authz.annotation.RequiresPermissions;
/*  14:    */ import org.slf4j.Logger;
/*  15:    */ import org.slf4j.LoggerFactory;
/*  16:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  17:    */ import org.springframework.stereotype.Controller;
/*  18:    */ import org.springframework.ui.ModelMap;
/*  19:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  20:    */ 
/*  21:    */ @Controller
/*  22:    */ public class SiteAct
/*  23:    */ {
/*  24: 26 */   private static final Logger log = LoggerFactory.getLogger(SiteAct.class);
/*  25:    */   @Autowired
/*  26:    */   private SiteService service;
/*  27:    */   
/*  28:    */   @RequiresPermissions({"admin:sites:list"})
/*  29:    */   @RequestMapping({"/sites/v_list.do"})
/*  30:    */   public String list(Integer pageNo, HttpServletRequest request, ModelMap model)
/*  31:    */   {
/*  32: 32 */     List<Site> list = this.service.getList();
/*  33: 33 */     model.addAttribute("list", list);
/*  34: 34 */     return "sysMgr/siteConf/sites/list";
/*  35:    */   }
/*  36:    */   
/*  37:    */   @RequiresPermissions({"admin:sites:add"})
/*  38:    */   @RequestMapping({"/sites/v_add.do"})
/*  39:    */   public String add(ModelMap model)
/*  40:    */   {
/*  41: 40 */     return "sysMgr/siteConf/sites/add";
/*  42:    */   }
/*  43:    */   
/*  44:    */   @RequiresPermissions({"admin:sites:edit"})
/*  45:    */   @RequestMapping({"/sites/v_edit.do"})
/*  46:    */   public String edit(Integer id, HttpServletRequest request, ModelMap model)
/*  47:    */   {
/*  48: 46 */     model.addAttribute("site", this.service.findById(id));
/*  49: 47 */     return "sysMgr/siteConf/sites/edit";
/*  50:    */   }
/*  51:    */   
/*  52:    */   @RequiresPermissions({"admin:sites:save"})
/*  53:    */   @RequestMapping({"/sites/o_save.do"})
/*  54:    */   public String save(Site bean, Integer uploadFtpId, HttpServletRequest request, ModelMap model)
/*  55:    */     throws IOException
/*  56:    */   {
/*  57: 54 */     Site site = ContextTools.getSite(request);
/*  58: 55 */     User user = ContextTools.getUser(request);
/*  59: 56 */     bean = this.service.save(site, user, bean, uploadFtpId);
/*  60: 57 */     log.info("save Site id={}", bean.getId());
/*  61: 58 */     return "redirect:v_list.do";
/*  62:    */   }
/*  63:    */   
/*  64:    */   @RequiresPermissions({"admin:sites:update"})
/*  65:    */   @RequestMapping({"/sites/o_update.do"})
/*  66:    */   public String update(Site bean, Integer uploadFtpId, Integer pageNo, HttpServletRequest request, ModelMap model)
/*  67:    */   {
/*  68: 65 */     bean = this.service.update(bean);
/*  69: 66 */     log.info("update Site id={}.", bean.getId());
/*  70: 67 */     return list(pageNo, request, model);
/*  71:    */   }
/*  72:    */   
/*  73:    */   @RequiresPermissions({"admin:sites:delete"})
/*  74:    */   @RequestMapping({"/sites/o_delete.do"})
/*  75:    */   public String delete(Integer[] ids, Integer pageNo, HttpServletRequest request, ModelMap model)
/*  76:    */   {
/*  77: 74 */     Site[] beans = this.service.deleteByIds(ids);
/*  78: 75 */     for (Site bean : beans) {
/*  79: 76 */       log.info("delete Site id={}", bean.getId());
/*  80:    */     }
/*  81: 78 */     return list(pageNo, request, model);
/*  82:    */   }
/*  83:    */   
/*  84:    */   @RequiresPermissions({"admin:sites:sys_edit"})
/*  85:    */   @RequestMapping({"/site/v_sys_edit.do"})
/*  86:    */   public String sysEdit(HttpServletRequest request, ModelMap model)
/*  87:    */   {
/*  88: 84 */     Site site = ContextTools.getSite(request);
/*  89: 85 */     model.addAttribute("site", site);
/*  90: 86 */     return "sysMgr/siteConf/sites/sys_edit";
/*  91:    */   }
/*  92:    */   
/*  93:    */   @RequiresPermissions({"admin:sites:sys_update"})
/*  94:    */   @RequestMapping({"/site/o_sys_update.do"})
/*  95:    */   public String sysUpdate(Site bean, HttpServletRequest request, ModelMap model)
/*  96:    */   {
/*  97: 93 */     bean = this.service.update(bean);
/*  98: 94 */     model.addAttribute("msg", "站点修改成功");
/*  99: 95 */     log.info("update Site success. id={}", bean.getId());
/* 100: 96 */     return sysEdit(request, model);
/* 101:    */   }
/* 102:    */   
/* 103:    */   @RequestMapping({"/sites/v_checkDomain.do"})
/* 104:    */   public void checkUserJson(String domain, HttpServletResponse response)
/* 105:    */   {
/* 106:    */     String pass;
/* 108:102 */     if (StringUtils.isBlank(domain)) {
/* 109:103 */       pass = "false";
/* 110:    */     } else {
/* 111:105 */       pass = this.service.findByDomain(domain, false) == null ? "true" : 
/* 112:106 */         "false";
/* 113:    */     }
/* 114:108 */     ResponseUtils.renderJson(response, pass);
/* 115:    */   }
/* 116:    */ }



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.portal.sysmgr.action.SiteAct

 * JD-Core Version:    0.7.0.1

 */