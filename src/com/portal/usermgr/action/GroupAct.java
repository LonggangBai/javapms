/*  1:   */ package com.portal.usermgr.action;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.utils.ResponseUtils;
/*  4:   */ import com.portal.sysmgr.entity.Site;
/*  5:   */ import com.portal.sysmgr.utils.ContextTools;
/*  6:   */ import com.portal.usermgr.entity.Group;
/*  7:   */ import com.portal.usermgr.entity.GroupPerm;
/*  8:   */ import com.portal.usermgr.service.GroupService;
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
/* 23:   */ public class GroupAct
/* 24:   */ {
/* 25:27 */   private static final Logger log = LoggerFactory.getLogger(GroupAct.class);
/* 26:   */   @Autowired
/* 27:   */   private GroupService service;
/* 28:   */   
/* 29:   */   @RequiresPermissions({"admin:group:list"})
/* 30:   */   @RequestMapping({"/group/v_list.do"})
/* 31:   */   public String list(HttpServletRequest request, ModelMap model)
/* 32:   */   {
/* 33:32 */     return "userMgr/group/list";
/* 34:   */   }
/* 35:   */   
/* 36:   */   @RequiresPermissions({"admin:group:add"})
/* 37:   */   @RequestMapping({"/group/v_add.do"})
/* 38:   */   public String add(ModelMap model)
/* 39:   */   {
/* 40:38 */     return "userMgr/group/add";
/* 41:   */   }
/* 42:   */   
/* 43:   */   @RequiresPermissions({"admin:group:edit"})
/* 44:   */   @RequestMapping({"/group/v_edit.do"})
/* 45:   */   public String edit(Integer id, HttpServletRequest request, ModelMap model)
/* 46:   */   {
/* 47:44 */     model.addAttribute("group", this.service.findById(id));
/* 48:45 */     return "userMgr/group/edit";
/* 49:   */   }
/* 50:   */   
/* 51:   */   @RequiresPermissions({"admin:group:save"})
/* 52:   */   @RequestMapping({"/group/o_save.do"})
/* 53:   */   public String save(Group bean, GroupPerm groupPerm, HttpServletRequest request, ModelMap model)
/* 54:   */   {
/* 55:52 */     Site site = ContextTools.getSite(request);
/* 56:53 */     bean = this.service.saveGroup(bean, groupPerm, site);
/* 57:54 */     log.info("save Group id={}", bean.getId());
/* 58:55 */     model.addAttribute("msg", "会员组添加成功!");
/* 59:56 */     return add(model);
/* 60:   */   }
/* 61:   */   
/* 62:   */   @RequiresPermissions({"admin:group:update"})
/* 63:   */   @RequestMapping({"/group/o_update.do"})
/* 64:   */   public String update(Group bean, GroupPerm groupPerm, HttpServletRequest request, ModelMap model)
/* 65:   */   {
/* 66:63 */     bean = this.service.updateGroup(bean, groupPerm);
/* 67:64 */     log.info("update Group id={}.", bean.getId());
/* 68:65 */     model.addAttribute("msg", "会员组修改成功!");
/* 69:66 */     return edit(bean.getId(), request, model);
/* 70:   */   }
/* 71:   */   
/* 72:   */   @RequiresPermissions({"admin:group:priority"})
/* 73:   */   @RequestMapping({"/group/o_priority.do"})
/* 74:   */   public String priority(Integer[] wids, Integer[] priority, Integer regDefId, HttpServletRequest request, ModelMap model)
/* 75:   */   {
/* 76:73 */     this.service.updatePriority(wids, priority);
/* 77:74 */     model.addAttribute("msg", "排序顺序保存成功!");
/* 78:75 */     return list(request, model);
/* 79:   */   }
/* 80:   */   
/* 81:   */   @RequestMapping({"/group/jsonData.do"})
/* 82:   */   public void dataPageByJosn(String sortname, String sortorder, HttpServletRequest request, HttpServletResponse response)
/* 83:   */   {
/* 84:81 */     Site site = ContextTools.getSite(request);
/* 85:82 */     List<Group> list = this.service.getList(site.getId(), sortname, sortorder);
/* 86:83 */     ResponseUtils.renderJson(response, 
/* 87:84 */       ResponseUtils.listToJsonadmin(list, Integer.valueOf(list.size()), new String[0]));
/* 88:   */   }
/* 89:   */   
/* 90:   */   @RequiresPermissions({"admin:group:delete"})
/* 91:   */   @RequestMapping({"/group/o_ajax_delete.do"})
/* 92:   */   public void deleteGroup(Integer[] ids, HttpServletRequest request, HttpServletResponse response)
/* 93:   */     throws JSONException
/* 94:   */   {
/* 95:92 */     JSONObject json = new JSONObject();
/* 96:93 */     Group[] beans = this.service.deleteByIds(ids);
/* 97:94 */     for (Group bean : beans) {
/* 98:95 */       log.info("delete Group id={}", bean.getId());
/* 99:   */     }
/* :0:97 */     json.put("success", true);
/* :1:98 */     json.put("status", 1);
/* :2:99 */     ResponseUtils.renderJson(response, json.toString());
/* :3:   */   }
/* :4:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.action.GroupAct
 * JD-Core Version:    0.7.0.1
 */