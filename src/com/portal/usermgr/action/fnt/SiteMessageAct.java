/*   1:    */ package com.portal.usermgr.action.fnt;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.utils.ResponseUtils;
/*   4:    */ import com.portal.sysmgr.entity.Site;
/*   5:    */ import com.portal.sysmgr.utils.ContextTools;
/*   6:    */ import com.portal.sysmgr.utils.ViewTools;
/*   7:    */ import com.portal.usermgr.entity.SiteMessage;
/*   8:    */ import com.portal.usermgr.entity.SiteMessageExt;
/*   9:    */ import com.portal.usermgr.entity.User;
/*  10:    */ import com.portal.usermgr.service.SiteMessageService;
/*  11:    */ import com.portal.usermgr.service.UserService;
/*  12:    */ import javax.servlet.http.HttpServletRequest;
/*  13:    */ import javax.servlet.http.HttpServletResponse;
/*  14:    */ import org.json.JSONException;
/*  15:    */ import org.json.JSONObject;
/*  16:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  17:    */ import org.springframework.stereotype.Controller;
/*  18:    */ import org.springframework.ui.ModelMap;
/*  19:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  20:    */ 
/*  21:    */ @Controller
/*  22:    */ public class SiteMessageAct
/*  23:    */ {
/*  24:    */   public static final String MESSAGE_LIST = "tpl.messageList";
/*  25:    */   public static final String MESSAGE_VIEW = "tpl.messageView";
/*  26:    */   @Autowired
/*  27:    */   private SiteMessageService messageService;
/*  28:    */   @Autowired
/*  29:    */   private UserService userService;
/*  30:    */   
/*  31:    */   @RequestMapping(value={"/message/list.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  32:    */   public String messageList(HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  33:    */   {
/*  34: 34 */     Site site = ContextTools.getSite(request);
/*  35: 35 */     User user = ContextTools.getUser(request);
/*  36: 36 */     ViewTools.frontData(request, model, site);
/*  37: 37 */     if (user == null) {
/*  38: 38 */       return ViewTools.showLogin(request, model, null);
/*  39:    */     }
/*  40: 40 */     ViewTools.frontPageData(request, model);
/*  41: 41 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/*  42: 42 */       "user", "tpl.messageList");
/*  43:    */   }
/*  44:    */   
/*  45:    */   @RequestMapping(value={"/message/view.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  46:    */   public String messageView(Integer messageId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  47:    */   {
/*  48: 48 */     Site site = ContextTools.getSite(request);
/*  49: 49 */     User user = ContextTools.getUser(request);
/*  50: 50 */     ViewTools.frontData(request, model, site);
/*  51: 51 */     if (user == null) {
/*  52: 52 */       return ViewTools.showLogin(request, model, null);
/*  53:    */     }
/*  54: 54 */     if (messageId == null) {
/*  55: 55 */       return ViewTools.pageNotFound(response);
/*  56:    */     }
/*  57: 57 */     SiteMessage message = this.messageService.findById(messageId);
/*  58: 58 */     if (message == null) {
/*  59: 59 */       return ViewTools.pageNotFound(response);
/*  60:    */     }
/*  61: 61 */     if ((!message.getFromUser().equals(user)) && 
/*  62: 62 */       (!message.getToUser().equals(user))) {
/*  63: 63 */       return ViewTools.pageNotFound(response);
/*  64:    */     }
/*  65: 65 */     ViewTools.frontPageData(request, model);
/*  66: 66 */     model.addAttribute("message", message);
/*  67: 67 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/*  68: 68 */       "user", "tpl.messageView");
/*  69:    */   }
/*  70:    */   
/*  71:    */   @RequestMapping(value={"/message/send.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  72:    */   public String messageSubmit(SiteMessage bean, SiteMessageExt ext, Integer fromId, Integer toId, Integer replyId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  73:    */   {
/*  74: 76 */     Site site = ContextTools.getSite(request);
/*  75: 77 */     User user = ContextTools.getUser(request);
/*  76: 78 */     ViewTools.frontData(request, model, site);
/*  77: 79 */     if (user == null) {
/*  78: 80 */       return ViewTools.showLogin(request, model, null);
/*  79:    */     }
/*  80: 82 */     if ((fromId == null) || (toId == null)) {
/*  81: 83 */       return ViewTools.pageNotFound(response);
/*  82:    */     }
/*  83: 85 */     if ((!fromId.equals(user.getId())) && (!toId.equals(user.getId()))) {
/*  84: 86 */       return ViewTools.pageNotFound(response);
/*  85:    */     }
/*  86: 88 */     this.messageService.save(bean, ext, fromId, toId, replyId);
/*  87: 89 */     return "redirect:list.jsp";
/*  88:    */   }
/*  89:    */   
/*  90:    */   @RequestMapping(value={"/message/ajaxSend.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  91:    */   public void messageaAjaxSend(Integer toId, Integer replyId, Integer userType, String title, String content, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  92:    */     throws JSONException
/*  93:    */   {
/*  94: 97 */     Site site = ContextTools.getSite(request);
/*  95: 98 */     User user = ContextTools.getUser(request);
/*  96: 99 */     ViewTools.frontData(request, model, site);
/*  97:100 */     if (user == null) {
/*  98:101 */       return;
/*  99:    */     }
/* 100:103 */     JSONObject json = new JSONObject();
/* 101:104 */     if (toId == null)
/* 102:    */     {
/* 103:105 */       json.put("success", false);
/* 104:106 */       json.put("status", 0);
/* 105:107 */       ResponseUtils.renderJson(response, json.toString());
/* 106:108 */       return;
/* 107:    */     }
/* 108:110 */     User touser = null;
/* 109:111 */     if (userType.intValue() == 1) {
/* 110:112 */       touser = this.userService.findByPersonal(toId);
/* 111:113 */     } else if (userType.intValue() == 2) {
/* 112:114 */       touser = this.userService.findByCompany(toId);
/* 113:    */     } else {
/* 114:116 */       touser = this.userService.findById(toId);
/* 115:    */     }
/* 116:118 */     if (touser == null)
/* 117:    */     {
/* 118:119 */       json.put("success", false);
/* 119:120 */       json.put("status", 0);
/* 120:121 */       ResponseUtils.renderJson(response, json.toString());
/* 121:122 */       return;
/* 122:    */     }
/* 123:124 */     SiteMessage message = new SiteMessage();
/* 124:125 */     SiteMessageExt ext = new SiteMessageExt();
/* 125:126 */     message.setToUser(touser);
/* 126:127 */     message.setFromUser(user);
/* 127:128 */     ext.setTitle(title);
/* 128:129 */     ext.setContent(content);
/* 129:130 */     this.messageService.save(message, ext, null, null, replyId);
/* 130:131 */     json.put("success", true);
/* 131:132 */     json.put("status", 1);
/* 132:133 */     ResponseUtils.renderJson(response, json.toString());
/* 133:    */   }
/* 134:    */   
/* 135:    */   @RequestMapping(value={"/message/delete.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 136:    */   public String messageDelete(Integer messageId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 137:    */   {
/* 138:140 */     Site site = ContextTools.getSite(request);
/* 139:141 */     User user = ContextTools.getUser(request);
/* 140:142 */     ViewTools.frontData(request, model, site);
/* 141:143 */     if (user == null) {
/* 142:144 */       return ViewTools.showLogin(request, model, null);
/* 143:    */     }
/* 144:146 */     if (messageId == null) {
/* 145:147 */       return ViewTools.pageNotFound(response);
/* 146:    */     }
/* 147:149 */     SiteMessage message = this.messageService.findById(messageId);
/* 148:150 */     if (message == null) {
/* 149:151 */       return ViewTools.pageNotFound(response);
/* 150:    */     }
/* 151:153 */     if (message.getFromUser().equals(user))
/* 152:    */     {
/* 153:154 */       if (message.getDeleteTo().booleanValue())
/* 154:    */       {
/* 155:155 */         this.messageService.deleteById(messageId);
/* 156:    */       }
/* 157:    */       else
/* 158:    */       {
/* 159:157 */         message.setDeleteFrom(Boolean.valueOf(true));
/* 160:158 */         this.messageService.update(message);
/* 161:    */       }
/* 162:    */     }
/* 163:160 */     else if (message.getToUser().equals(user))
/* 164:    */     {
/* 165:161 */       if (message.getDeleteFrom().booleanValue())
/* 166:    */       {
/* 167:162 */         this.messageService.deleteById(messageId);
/* 168:    */       }
/* 169:    */       else
/* 170:    */       {
/* 171:164 */         message.setDeleteTo(Boolean.valueOf(true));
/* 172:165 */         this.messageService.update(message);
/* 173:    */       }
/* 174:    */     }
/* 175:    */     else {
/* 176:168 */       return ViewTools.pageNotFound(response);
/* 177:    */     }
/* 178:170 */     return "redirect:list.jsp";
/* 179:    */   }
/* 180:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.action.fnt.SiteMessageAct
 * JD-Core Version:    0.7.0.1
 */