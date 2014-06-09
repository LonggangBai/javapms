/*  1:   */ package com.portal.workspace.action;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.security.encoder.PwdEncoder;
/*  4:   */ import com.portal.sysmgr.entity.Site;
/*  5:   */ import com.portal.sysmgr.utils.ContextTools;
/*  6:   */ import com.portal.usermgr.entity.User;
/*  7:   */ import com.portal.usermgr.service.UserService;
/*  8:   */ import javax.servlet.http.HttpServletRequest;
/*  9:   */ import org.apache.shiro.authz.annotation.RequiresPermissions;
/* 10:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 11:   */ import org.springframework.stereotype.Controller;
/* 12:   */ import org.springframework.ui.ModelMap;
/* 13:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 14:   */ 
/* 15:   */ @Controller
/* 16:   */ public class WorkSpaceAct
/* 17:   */ {
/* 18:   */   @Autowired
/* 19:   */   private UserService userService;
/* 20:   */   @Autowired
/* 21:   */   private PwdEncoder pwdEncoder;
/* 22:   */   
/* 23:   */   @RequiresPermissions({"admin:workspace:index"})
/* 24:   */   @RequestMapping({"/index.do"})
/* 25:   */   public String index(HttpServletRequest request, ModelMap model)
/* 26:   */   {
/* 27:23 */     Site site = ContextTools.getSite(request);
/* 28:24 */     User user = ContextTools.getUser(request);
/* 29:25 */     model.addAttribute("site", site);
/* 30:26 */     model.addAttribute("user", user);
/* 31:27 */     return "index";
/* 32:   */   }
/* 33:   */   
/* 34:   */   @RequiresPermissions({"admin:workspace:right"})
/* 35:   */   @RequestMapping({"/right.do"})
/* 36:   */   public String right(HttpServletRequest request, ModelMap model)
/* 37:   */   {
/* 38:33 */     Site site = ContextTools.getSite(request);
/* 39:34 */     User user = ContextTools.getUser(request);
/* 40:35 */     model.addAttribute("site", site);
/* 41:36 */     model.addAttribute("user", user);
/* 42:37 */     return "right";
/* 43:   */   }
/* 44:   */   
/* 45:   */   @RequiresPermissions({"admin:workspace:info"})
/* 46:   */   @RequestMapping({"/workSpace/v_info.do"})
/* 47:   */   public String profileEdit(HttpServletRequest request, ModelMap model)
/* 48:   */   {
/* 49:43 */     Site site = ContextTools.getSite(request);
/* 50:44 */     User user = ContextTools.getUser(request);
/* 51:45 */     model.addAttribute("user", user);
/* 52:46 */     model.addAttribute("siteId", site.getId());
/* 53:47 */     return "workSpace/personInfo";
/* 54:   */   }
/* 55:   */   
/* 56:   */   @RequiresPermissions({"admin:workspace:infoupdate"})
/* 57:   */   @RequestMapping({"/workSpace/o_info_update.do"})
/* 58:   */   public String profileUpdate(User user, HttpServletRequest request, ModelMap model)
/* 59:   */   {
/* 60:54 */     this.userService.update(user);
/* 61:55 */     model.addAttribute("msg", "信息修改成功!");
/* 62:56 */     return profileEdit(request, model);
/* 63:   */   }
/* 64:   */   
/* 65:   */   @RequiresPermissions({"admin:workspace:passedit"})
/* 66:   */   @RequestMapping({"/workSpace/v_passwordEdit.do"})
/* 67:   */   public String passwordEdit(HttpServletRequest request, ModelMap model)
/* 68:   */   {
/* 69:62 */     User user = ContextTools.getUser(request);
/* 70:63 */     model.addAttribute("user", user);
/* 71:64 */     return "workSpace/editPass";
/* 72:   */   }
/* 73:   */   
/* 74:   */   @RequiresPermissions({"admin:workspace:passupdate"})
/* 75:   */   @RequestMapping({"/workSpace/o_pass_update.do"})
/* 76:   */   public String passwordUpdate(String password, String newPwd, HttpServletRequest request, ModelMap model)
/* 77:   */   {
/* 78:71 */     User user = ContextTools.getUser(request);
/* 79:72 */     User u = this.userService.findById(user.getId());
/* 80:73 */     if (u.getPassword().equals(this.pwdEncoder.encodePassword(password)))
/* 81:   */     {
/* 82:74 */       u.setPassword(this.pwdEncoder.encodePassword(newPwd));
/* 83:75 */       this.userService.update(u);
/* 84:76 */       model.addAttribute("msg", "密码修改成功!");
/* 85:77 */       model.addAttribute("result", "1");
/* 86:   */     }
/* 87:   */     else
/* 88:   */     {
/* 89:79 */       model.addAttribute("msg", "原密码错误，修改失败!");
/* 90:80 */       model.addAttribute("result", "0");
/* 91:   */     }
/* 92:82 */     return passwordEdit(request, model);
/* 93:   */   }
/* 94:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.workspace.action.WorkSpaceAct
 * JD-Core Version:    0.7.0.1
 */