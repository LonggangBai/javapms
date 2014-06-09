/*   1:    */ package com.portal.govcenter.action;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.page.Pagination;
/*   4:    */ import com.javapms.basic.utils.ResponseUtils;
/*   5:    */ import com.portal.datacenter.operatedata.service.LogService;
/*   6:    */ import com.portal.govcenter.entity.Mailbox;
/*   7:    */ import com.portal.govcenter.entity.MailboxExt;
/*   8:    */ import com.portal.govcenter.service.MailboxService;
/*   9:    */ import com.portal.sysmgr.entity.Site;
/*  10:    */ import com.portal.sysmgr.utils.ContextTools;
/*  11:    */ import com.portal.usermgr.entity.Admin;
/*  12:    */ import com.portal.usermgr.entity.User;
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
/*  26:    */ public class MailboxAct
/*  27:    */ {
/*  28: 28 */   private static final Logger log = LoggerFactory.getLogger(MailboxAct.class);
/*  29:    */   @Autowired
/*  30:    */   private MailboxService service;
/*  31:    */   @Autowired
/*  32:    */   private LogService logService;
/*  33:    */   
/*  34:    */   @RequiresPermissions({"admin:mailbox:list"})
/*  35:    */   @RequestMapping({"/mailbox/v_list.do"})
/*  36:    */   public String list(Integer typeId, HttpServletRequest request, ModelMap model)
/*  37:    */   {
/*  38: 34 */     Site site = ContextTools.getSite(request);
/*  39: 35 */     User user = ContextTools.getUser(request);
/*  40: 36 */     if (user.getAdmin().haveAllManage(site.getId())) {
/*  41: 37 */       model.addAttribute("all", Boolean.valueOf(true));
/*  42:    */     } else {
/*  43: 39 */       model.addAttribute("all", Boolean.valueOf(false));
/*  44:    */     }
/*  45: 41 */     model.addAttribute("typeId", typeId);
/*  46: 42 */     return "govCenter/mailbox/list";
/*  47:    */   }
/*  48:    */   
/*  49:    */   @RequiresPermissions({"admin:mailbox:add"})
/*  50:    */   @RequestMapping({"/mailbox/v_add.do"})
/*  51:    */   public String add(HttpServletRequest request, ModelMap model)
/*  52:    */   {
/*  53: 48 */     return "govCenter/mailbox/add";
/*  54:    */   }
/*  55:    */   
/*  56:    */   @RequiresPermissions({"admin:mailbox:edit"})
/*  57:    */   @RequestMapping({"/mailbox/v_edit.do"})
/*  58:    */   public String edit(Integer id, HttpServletRequest request, ModelMap model)
/*  59:    */   {
/*  60: 54 */     model.addAttribute("mailbox", this.service.findById(id));
/*  61: 55 */     return "govCenter/mailbox/edit";
/*  62:    */   }
/*  63:    */   
/*  64:    */   @RequiresPermissions({"admin:mailbox:save"})
/*  65:    */   @RequestMapping({"/mailbox/o_save.do"})
/*  66:    */   public String save(Mailbox bean, MailboxExt ext, Integer departId, Integer typeId, HttpServletRequest request, ModelMap model)
/*  67:    */   {
/*  68: 62 */     Site site = ContextTools.getSite(request);
/*  69: 63 */     bean = this.service.save(bean, ext, site, departId, typeId);
/*  70: 64 */     log.info("save Mailbox id={}", bean.getId());
/*  71: 65 */     return add(request, model);
/*  72:    */   }
/*  73:    */   
/*  74:    */   @RequiresPermissions({"admin:mailbox:update"})
/*  75:    */   @RequestMapping({"/mailbox/o_update.do"})
/*  76:    */   public String update(Mailbox bean, MailboxExt ext, Integer pageNo, HttpServletRequest request, ModelMap model)
/*  77:    */   {
/*  78: 72 */     Site site = ContextTools.getSite(request);
/*  79: 73 */     User user = ContextTools.getUser(request);
/*  80: 74 */     bean = this.service.update(bean, ext, user, site.getId());
/*  81: 75 */     log.info("update Mailbox id={}.", bean.getId());
/*  82: 76 */     return edit(bean.getId(), request, model);
/*  83:    */   }
/*  84:    */   
/*  85:    */   @RequestMapping({"/mailbox/jsonData.do"})
/*  86:    */   public String dataPageByJosn(String name, Integer typeId, Integer page, Integer pagesize, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  87:    */   {
/*  88: 83 */     Site site = ContextTools.getSite(request);
/*  89: 84 */     User user = ContextTools.getUser(request);
/*  90: 85 */     Pagination p = this.service.getPage(name, site.getId(), user, typeId, page.intValue(), 
/*  91: 86 */       pagesize.intValue());
/*  92: 87 */     model.addAttribute("p", p);
/*  93: 88 */     response.setHeader("Cache-Control", "no-cache");
/*  94: 89 */     response.setContentType("text/json;charset=UTF-8");
/*  95: 90 */     return "govCenter/mailbox/data";
/*  96:    */   }
/*  97:    */   
/*  98:    */   @RequiresPermissions({"admin:mailbox:delete"})
/*  99:    */   @RequestMapping({"/mailbox/o_ajax_delete.do"})
/* 100:    */   public void deleteMailbox(Integer[] ids, HttpServletRequest request, HttpServletResponse response)
/* 101:    */     throws JSONException
/* 102:    */   {
/* 103: 97 */     JSONObject json = new JSONObject();
/* 104: 98 */     Mailbox[] beans = this.service.deleteByIds(ids);
/* 105: 99 */     for (Mailbox bean : beans)
/* 106:    */     {
/* 107:100 */       log.info("delete Mailbox id={}", bean.getId());
/* 108:101 */       this.logService.operating(request, "删除局长信箱", "id=" + bean.getId());
/* 109:    */     }
/* 110:103 */     json.put("success", true);
/* 111:104 */     json.put("status", 1);
/* 112:105 */     ResponseUtils.renderJson(response, json.toString());
/* 113:    */   }
/* 114:    */   
/* 115:    */   @RequiresPermissions({"admin:mailbox:show"})
/* 116:    */   @RequestMapping({"/mailbox/o_ajax_show.do"})
/* 117:    */   public void showMailbox(Integer id, HttpServletRequest request, HttpServletResponse response)
/* 118:    */     throws JSONException
/* 119:    */   {
/* 120:113 */     JSONObject json = new JSONObject();
/* 121:114 */     Mailbox mailbox = this.service.findById(id);
/* 122:115 */     if (mailbox == null)
/* 123:    */     {
/* 124:116 */       json.put("success", false);
/* 125:117 */       json.put("status", 0);
/* 126:118 */       ResponseUtils.renderJson(response, json.toString());
/* 127:119 */       return;
/* 128:    */     }
/* 129:121 */     this.service.showMailbox(id);
/* 130:122 */     json.put("success", true);
/* 131:123 */     json.put("status", 1);
/* 132:124 */     ResponseUtils.renderJson(response, json.toString());
/* 133:    */   }
/* 134:    */   
/* 135:    */   @RequestMapping({"/mailbox/o_forward.do"})
/* 136:    */   public String forward(Integer id, Integer departId, Integer typeId, HttpServletRequest request, ModelMap model)
/* 137:    */   {
/* 138:131 */     this.service.forwardMailbox(id, departId);
/* 139:132 */     return list(typeId, request, model);
/* 140:    */   }
/* 141:    */   
/* 142:    */   @RequestMapping({"/mailbox/o_back.do"})
/* 143:    */   public String back(Integer id, Integer typeId, HttpServletRequest request, ModelMap model)
/* 144:    */   {
/* 145:138 */     this.service.backMailbox(id);
/* 146:139 */     return list(typeId, request, model);
/* 147:    */   }
/* 148:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.govcenter.action.MailboxAct
 * JD-Core Version:    0.7.0.1
 */