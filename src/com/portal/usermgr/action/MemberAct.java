/*   1:    */ package com.portal.usermgr.action;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.page.Pagination;
/*   4:    */ import com.javapms.basic.page.SimplePage;
/*   5:    */ import com.javapms.basic.utils.ResponseUtils;
/*   6:    */ import com.javapms.basic.utils.ServicesUtils;
/*   7:    */ import com.portal.datacenter.operatedata.service.LogService;
/*   8:    */ import com.portal.sysmgr.entity.Site;
/*   9:    */ import com.portal.sysmgr.utils.ContextTools;
/*  10:    */ import com.portal.usermgr.entity.Group;
/*  11:    */ import com.portal.usermgr.entity.Member;
/*  12:    */ import com.portal.usermgr.entity.User;
/*  13:    */ import com.portal.usermgr.service.GroupService;
/*  14:    */ import com.portal.usermgr.service.MemberService;
/*  15:    */ import com.portal.usermgr.service.UserService;
/*  16:    */ import java.util.List;
/*  17:    */ import javax.servlet.http.HttpServletRequest;
/*  18:    */ import javax.servlet.http.HttpServletResponse;
/*  19:    */ import org.apache.shiro.authz.annotation.RequiresPermissions;
/*  20:    */ import org.json.JSONException;
/*  21:    */ import org.json.JSONObject;
/*  22:    */ import org.slf4j.Logger;
/*  23:    */ import org.slf4j.LoggerFactory;
/*  24:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  25:    */ import org.springframework.stereotype.Controller;
/*  26:    */ import org.springframework.ui.ModelMap;
/*  27:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  28:    */ 
/*  29:    */ @Controller
/*  30:    */ public class MemberAct
/*  31:    */ {
/*  32: 35 */   private static final Logger log = LoggerFactory.getLogger(MemberAct.class);
/*  33:    */   @Autowired
/*  34:    */   private MemberService service;
/*  35:    */   @Autowired
/*  36:    */   private UserService userService;
/*  37:    */   @Autowired
/*  38:    */   private GroupService groupService;
/*  39:    */   @Autowired
/*  40:    */   private LogService logService;
/*  41:    */   
/*  42:    */   @RequiresPermissions({"admin:member:list"})
/*  43:    */   @RequestMapping({"/member/v_list.do"})
/*  44:    */   public String list(HttpServletRequest request, ModelMap model)
/*  45:    */   {
/*  46: 40 */     Site site = ContextTools.getSite(request);
/*  47: 41 */     List<Group> groupList = this.groupService.getList(site.getId(), null, null);
/*  48: 42 */     model.addAttribute("groupList", groupList);
/*  49: 43 */     return "userMgr/member/list";
/*  50:    */   }
/*  51:    */   
/*  52:    */   @RequiresPermissions({"admin:member:add"})
/*  53:    */   @RequestMapping({"/member/v_add.do"})
/*  54:    */   public String add(HttpServletRequest request, ModelMap model)
/*  55:    */   {
/*  56: 49 */     Site site = ContextTools.getSite(request);
/*  57: 50 */     List<Group> groupList = this.groupService.getList(site.getId(), null, null);
/*  58: 51 */     model.addAttribute("groupList", groupList);
/*  59: 52 */     return "userMgr/member/add";
/*  60:    */   }
/*  61:    */   
/*  62:    */   @RequiresPermissions({"admin:member:edit"})
/*  63:    */   @RequestMapping({"/member/v_edit.do"})
/*  64:    */   public String edit(Integer id, HttpServletRequest request, ModelMap model)
/*  65:    */   {
/*  66: 58 */     Site site = ContextTools.getSite(request);
/*  67: 59 */     List<Group> groupList = this.groupService.getList(site.getId(), null, null);
/*  68: 60 */     model.addAttribute("member", this.service.findById(id));
/*  69: 61 */     model.addAttribute("groupList", groupList);
/*  70: 62 */     model.addAttribute("siteId", site.getId());
/*  71: 63 */     return "userMgr/member/edit";
/*  72:    */   }
/*  73:    */   
/*  74:    */   @RequiresPermissions({"admin:member:save"})
/*  75:    */   @RequestMapping({"/member/o_save.do"})
/*  76:    */   public String save(User user, Member bean, Integer groupId, HttpServletRequest request, ModelMap model)
/*  77:    */   {
/*  78: 70 */     if (this.userService.findByUsername(user.getUsername()) != null)
/*  79:    */     {
/*  80: 71 */       model.addAttribute("msg", "该用户已经存在，添加失败!");
/*  81: 72 */       model.addAttribute("status", Integer.valueOf(0));
/*  82: 73 */       return add(request, model);
/*  83:    */     }
/*  84: 75 */     String ip = ServicesUtils.getIpAddr(request);
/*  85: 76 */     bean = this.service.registerMember(user, bean, ip, groupId);
/*  86: 77 */     log.info("save Member id={}", bean.getId());
/*  87: 78 */     model.addAttribute("msg", "会员添加成功!");
/*  88: 79 */     model.addAttribute("status", Integer.valueOf(1));
/*  89: 80 */     return add(request, model);
/*  90:    */   }
/*  91:    */   
/*  92:    */   @RequiresPermissions({"admin:member:update"})
/*  93:    */   @RequestMapping({"/member/o_update.do"})
/*  94:    */   public String update(User user, Member bean, Integer groupId, HttpServletRequest request, ModelMap model)
/*  95:    */   {
/*  96: 87 */     Site site = ContextTools.getSite(request);
/*  97: 88 */     bean = this.service.updateMember(user, bean, groupId, site.getId());
/*  98: 89 */     log.info("update Member id={}.", bean.getId());
/*  99: 90 */     model.addAttribute("msg", "会员修改成功!");
/* 100: 91 */     return edit(bean.getId(), request, model);
/* 101:    */   }
/* 102:    */   
/* 103:    */   @RequestMapping({"/member/jsonData.do"})
/* 104:    */   public String dataPageByJosn(String key, Integer groupId, String sortname, String sortorder, Integer page, Integer pagesize, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 105:    */   {
/* 106: 99 */     Site site = ContextTools.getSite(request);
/* 107:100 */     Pagination pag = this.service.getPage(key, site.getId(), groupId, sortname, 
/* 108:101 */       sortorder, SimplePage.cpn(page), pagesize.intValue());
/* 109:102 */     model.addAttribute("pag", pag);
/* 110:103 */     model.addAttribute("siteId", site.getId());
/* 111:104 */     response.setHeader("Cache-Control", "no-cache");
/* 112:105 */     response.setContentType("text/json;charset=UTF-8");
/* 113:106 */     return "userMgr/member/data";
/* 114:    */   }
/* 115:    */   
/* 116:    */   @RequiresPermissions({"admin:member:delete"})
/* 117:    */   @RequestMapping({"/member/o_ajax_delete.do"})
/* 118:    */   public void deleteRole(Integer[] ids, HttpServletRequest request, HttpServletResponse response)
/* 119:    */     throws JSONException
/* 120:    */   {
/* 121:113 */     JSONObject json = new JSONObject();
/* 122:114 */     Member[] beans = this.service.deleteByIds(ids);
/* 123:115 */     for (Member bean : beans)
/* 124:    */     {
/* 125:116 */       log.info("delete Member id={}", bean.getId());
/* 126:117 */       this.logService.operating(request, "删除会员", "id=" + bean.getId() + 
/* 127:118 */         ";name=" + bean.getUser().getUsername());
/* 128:    */     }
/* 129:120 */     json.put("success", true);
/* 130:121 */     json.put("status", 1);
/* 131:122 */     ResponseUtils.renderJson(response, json.toString());
/* 132:    */   }
/* 133:    */   
/* 134:    */   @RequiresPermissions({"admin:member:updatePass"})
/* 135:    */   @RequestMapping({"/member/o_updatePass.do"})
/* 136:    */   public String updatePass(Integer memberId, String password, HttpServletRequest request, ModelMap model)
/* 137:    */   {
/* 138:130 */     this.service.updatePass(memberId, password);
/* 139:131 */     log.info("update Member Password id={}.", memberId);
/* 140:132 */     model.addAttribute("msg", "密码修改成功!");
/* 141:133 */     return list(request, model);
/* 142:    */   }
/* 143:    */   
/* 144:    */   @RequestMapping({"/member/o_checkuser.do"})
/* 145:    */   public void checkUser(String username, HttpServletRequest request, HttpServletResponse response)
/* 146:    */   {
/* 147:139 */     User user = this.userService.findByUsername(username);
/* 148:140 */     if (user != null)
/* 149:    */     {
/* 150:141 */       ResponseUtils.renderJson(response, "false");
/* 151:142 */       return;
/* 152:    */     }
/* 153:144 */     ResponseUtils.renderJson(response, "true");
/* 154:    */   }
/* 155:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.action.MemberAct
 * JD-Core Version:    0.7.0.1
 */