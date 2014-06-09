/*  1:   */ package com.portal.govcenter.action;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.utils.ResponseUtils;
/*  4:   */ import com.portal.datacenter.operatedata.service.LogService;
/*  5:   */ import com.portal.govcenter.entity.MailboxType;
/*  6:   */ import com.portal.govcenter.service.MailboxTypeService;
/*  7:   */ import com.portal.sysmgr.entity.Site;
/*  8:   */ import com.portal.sysmgr.utils.ContextTools;
/*  9:   */ import java.util.List;
/* 10:   */ import javax.servlet.http.HttpServletRequest;
/* 11:   */ import javax.servlet.http.HttpServletResponse;
/* 12:   */ import org.apache.shiro.authz.annotation.RequiresPermissions;
/* 13:   */ import org.json.JSONException;
/* 14:   */ import org.json.JSONObject;
/* 15:   */ import org.slf4j.Logger;
/* 16:   */ import org.slf4j.LoggerFactory;
/* 17:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 18:   */ import org.springframework.stereotype.Controller;
/* 19:   */ import org.springframework.ui.ModelMap;
/* 20:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 21:   */ 
/* 22:   */ @Controller
/* 23:   */ public class MailboxTypeAct
/* 24:   */ {
/* 25:28 */   private static final Logger log = LoggerFactory.getLogger(MailboxTypeAct.class);
/* 26:   */   @Autowired
/* 27:   */   private MailboxTypeService service;
/* 28:   */   @Autowired
/* 29:   */   private LogService logService;
/* 30:   */   
/* 31:   */   @RequiresPermissions({"admin:mailboxType:list"})
/* 32:   */   @RequestMapping({"/mailboxType/v_list.do"})
/* 33:   */   public String list()
/* 34:   */   {
/* 35:33 */     return "govCenter/type/list";
/* 36:   */   }
/* 37:   */   
/* 38:   */   @RequiresPermissions({"admin:mailboxType:add"})
/* 39:   */   @RequestMapping({"/mailboxType/v_add.do"})
/* 40:   */   public String add(ModelMap model)
/* 41:   */   {
/* 42:39 */     return "govCenter/type/add";
/* 43:   */   }
/* 44:   */   
/* 45:   */   @RequiresPermissions({"admin:mailboxType:edit"})
/* 46:   */   @RequestMapping({"/mailboxType/v_edit.do"})
/* 47:   */   public String edit(Integer id, ModelMap model)
/* 48:   */   {
/* 49:45 */     model.addAttribute("mailboxType", this.service.findById(id));
/* 50:46 */     return "govCenter/type/edit";
/* 51:   */   }
/* 52:   */   
/* 53:   */   @RequiresPermissions({"admin:mailboxType:save"})
/* 54:   */   @RequestMapping({"/mailboxType/o_save.do"})
/* 55:   */   public String save(MailboxType bean, HttpServletRequest request, ModelMap model)
/* 56:   */   {
/* 57:53 */     Site site = ContextTools.getSite(request);
/* 58:54 */     bean = this.service.save(bean, site);
/* 59:55 */     log.info("save MailboxType id={}", bean.getId());
/* 60:56 */     model.addAttribute("msg", "类型添加成功!");
/* 61:57 */     return list();
/* 62:   */   }
/* 63:   */   
/* 64:   */   @RequiresPermissions({"admin:mailboxType:update"})
/* 65:   */   @RequestMapping({"/mailboxType/o_update.do"})
/* 66:   */   public String update(MailboxType bean, ModelMap model)
/* 67:   */   {
/* 68:63 */     bean = this.service.update(bean);
/* 69:64 */     log.info("update MailboxType id={}.", bean.getId());
/* 70:65 */     model.addAttribute("msg", "类型修改成功!");
/* 71:66 */     return list();
/* 72:   */   }
/* 73:   */   
/* 74:   */   @RequestMapping({"/mailboxType/jsonData.do"})
/* 75:   */   public String dataPageByJosn(String name, Integer page, Integer pagesize, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 76:   */   {
/* 77:73 */     Site site = ContextTools.getSite(request);
/* 78:74 */     List<MailboxType> list = this.service.getList(site.getId());
/* 79:75 */     model.addAttribute("list", list);
/* 80:76 */     response.setHeader("Cache-Control", "no-cache");
/* 81:77 */     response.setContentType("text/json;charset=UTF-8");
/* 82:78 */     return "govCenter/type/data";
/* 83:   */   }
/* 84:   */   
/* 85:   */   @RequiresPermissions({"admin:mailboxType:delete"})
/* 86:   */   @RequestMapping({"/mailboxType/o_ajax_delete.do"})
/* 87:   */   public void deleteMailbox(Integer[] ids, HttpServletRequest request, HttpServletResponse response)
/* 88:   */     throws JSONException
/* 89:   */   {
/* 90:85 */     JSONObject json = new JSONObject();
/* 91:86 */     MailboxType[] beans = this.service.deleteByIds(ids);
/* 92:87 */     for (MailboxType bean : beans)
/* 93:   */     {
/* 94:88 */       log.info("delete MailboxType id={}", bean.getId());
/* 95:89 */       this.logService.operating(request, "删除局长邮箱类型", "id=" + bean.getId());
/* 96:   */     }
/* 97:91 */     json.put("success", true);
/* 98:92 */     json.put("status", 1);
/* 99:93 */     ResponseUtils.renderJson(response, json.toString());
/* :0:   */   }
/* :1:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.govcenter.action.MailboxTypeAct
 * JD-Core Version:    0.7.0.1
 */