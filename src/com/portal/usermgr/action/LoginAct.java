/*  1:   */ package com.portal.usermgr.action;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.security.encoder.PwdEncoder;
/*  4:   */ import com.javapms.basic.utils.ServicesUtils;
/*  5:   */ import com.portal.sysmgr.entity.Site;
/*  6:   */ import com.portal.sysmgr.utils.ContextTools;
/*  7:   */ import com.portal.usermgr.entity.Admin;
/*  8:   */ import com.portal.usermgr.entity.User;
/*  9:   */ import com.portal.usermgr.service.AdminService;
/* 10:   */ import com.portal.usermgr.service.UserService;
/* 11:   */ import javax.servlet.http.HttpServletRequest;
/* 12:   */ import javax.servlet.http.HttpServletResponse;
/* 13:   */ import org.apache.commons.lang.StringUtils;
/* 14:   */ import org.apache.shiro.SecurityUtils;
/* 15:   */ import org.apache.shiro.authc.IncorrectCredentialsException;
/* 16:   */ import org.apache.shiro.authc.LockedAccountException;
/* 17:   */ import org.apache.shiro.authc.UnknownAccountException;
/* 18:   */ import org.apache.shiro.authc.UsernamePasswordToken;
/* 19:   */ import org.apache.shiro.subject.Subject;
/* 20:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 21:   */ import org.springframework.stereotype.Controller;
/* 22:   */ import org.springframework.ui.ModelMap;
/* 23:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 24:   */ import org.springframework.web.servlet.mvc.support.RedirectAttributes;
/* 25:   */ 
/* 26:   */ @Controller
/* 27:   */ public class LoginAct
/* 28:   */ {
/* 29:   */   public static final String COOKIE_ERROR_REMAINING = "_error_remaining";
/* 30:   */   @Autowired
/* 31:   */   private PwdEncoder pwdEncoder;
/* 32:   */   @Autowired
/* 33:   */   private UserService userService;
/* 34:   */   @Autowired
/* 35:   */   private AdminService adminService;
/* 36:   */   
/* 37:   */   @RequestMapping(value={"/login.do"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 38:   */   public String input(HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 39:   */   {
/* 40:36 */     return "login";
/* 41:   */   }
/* 42:   */   
/* 43:   */   @RequestMapping(value={"/login.do"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 44:   */   public String submit(String username, String password, String captcha, String nextUrl, String message, HttpServletRequest request, HttpServletResponse response, ModelMap model, RedirectAttributes ra)
/* 45:   */   {
/* 46:43 */     Subject currentUser = SecurityUtils.getSubject();
/* 47:44 */     UsernamePasswordToken token = new UsernamePasswordToken(username, 
/* 48:45 */       this.pwdEncoder.encodePassword(password));
/* 49:46 */     token.setRememberMe(true);
/* 50:   */     try
/* 51:   */     {
/* 52:48 */       currentUser.login(token);
/* 53:   */     }
/* 54:   */     catch (UnknownAccountException localUnknownAccountException) {}catch (IncorrectCredentialsException localIncorrectCredentialsException) {}catch (LockedAccountException localLockedAccountException) {}
/* 55:53 */     User user = this.userService.findByUsername(username);
/* 56:54 */     if ((currentUser.isAuthenticated()) && (user.getAdmin() != null))
/* 57:   */     {
/* 58:55 */       Site site = ContextTools.getSite(request);
/* 59:56 */       if (user.getAdmin().getRole(site.getId()) == null)
/* 60:   */       {
/* 61:57 */         currentUser.logout();
/* 62:58 */         ra.addFlashAttribute("msg", "该用户没有权限，禁止登陆!");
/* 63:59 */         return "redirect:login.do";
/* 64:   */       }
/* 65:61 */       if (user.getAdmin().getDepart(site.getId()) == null)
/* 66:   */       {
/* 67:62 */         currentUser.logout();
/* 68:63 */         ra.addFlashAttribute("msg", "该用户没有分配部门，禁止登陆,请联系管理员!");
/* 69:64 */         return "redirect:login.do";
/* 70:   */       }
/* 71:66 */       String ip = ServicesUtils.getIpAddr(request);
/* 72:67 */       this.adminService.updateLoginInfo(user, ip);
/* 73:68 */       if (!StringUtils.isBlank(nextUrl)) {
/* 74:69 */         return "redirect:" + nextUrl;
/* 75:   */       }
/* 76:71 */       return "redirect:index.do";
/* 77:   */     }
/* 78:73 */     ra.addFlashAttribute("msg", "用户名或密码错误!");
/* 79:74 */     return "redirect:login.do";
/* 80:   */   }
/* 81:   */   
/* 82:   */   @RequestMapping({"/logout.do"})
/* 83:   */   public String logout(HttpServletRequest request, HttpServletResponse response)
/* 84:   */   {
/* 85:81 */     Subject currentUser = SecurityUtils.getSubject();
/* 86:82 */     currentUser.logout();
/* 87:83 */     return "login";
/* 88:   */   }
/* 89:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.action.LoginAct
 * JD-Core Version:    0.7.0.1
 */