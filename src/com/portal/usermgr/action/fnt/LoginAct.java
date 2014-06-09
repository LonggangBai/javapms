/*  1:   */ package com.portal.usermgr.action.fnt;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.security.encoder.PwdEncoder;
/*  4:   */ import com.javapms.basic.utils.ServicesUtils;
/*  5:   */ import com.portal.sysmgr.entity.Site;
/*  6:   */ import com.portal.sysmgr.utils.ContextTools;
/*  7:   */ import com.portal.sysmgr.utils.ViewTools;
/*  8:   */ import com.portal.usermgr.entity.User;
/*  9:   */ import com.portal.usermgr.service.AdminService;
/* 10:   */ import com.portal.usermgr.service.MemberService;
/* 11:   */ import com.portal.usermgr.service.UserService;
/* 12:   */ import javax.servlet.http.HttpServletRequest;
/* 13:   */ import javax.servlet.http.HttpServletResponse;
/* 14:   */ import org.apache.commons.lang.StringUtils;
/* 15:   */ import org.apache.shiro.SecurityUtils;
/* 16:   */ import org.apache.shiro.authc.IncorrectCredentialsException;
/* 17:   */ import org.apache.shiro.authc.LockedAccountException;
/* 18:   */ import org.apache.shiro.authc.UnknownAccountException;
/* 19:   */ import org.apache.shiro.authc.UsernamePasswordToken;
/* 20:   */ import org.apache.shiro.subject.Subject;
/* 21:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 22:   */ import org.springframework.stereotype.Controller;
/* 23:   */ import org.springframework.ui.ModelMap;
/* 24:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 25:   */ 
/* 26:   */ @Controller
/* 27:   */ public class LoginAct
/* 28:   */ {
/* 29:   */   @Autowired
/* 30:   */   private UserService userService;
/* 31:   */   @Autowired
/* 32:   */   private MemberService memberService;
/* 33:   */   @Autowired
/* 34:   */   private AdminService adminService;
/* 35:   */   @Autowired
/* 36:   */   private PwdEncoder pwdEncoder;
/* 37:   */   
/* 38:   */   @RequestMapping(value={"/login.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 39:   */   public String input(HttpServletRequest request, ModelMap model)
/* 40:   */   {
/* 41:35 */     Site site = ContextTools.getSite(request);
/* 42:36 */     User user = ContextTools.getUser(request);
/* 43:37 */     if (user != null) {
/* 44:38 */       return "redirect:forum.jsp";
/* 45:   */     }
/* 46:40 */     ViewTools.frontData(request, model, site);
/* 47:41 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 48:42 */       "user", "member.login");
/* 49:   */   }
/* 50:   */   
/* 51:   */   @RequestMapping(value={"/login.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 52:   */   public String submit(String username, String password, String nextUrl, HttpServletRequest request, ModelMap model)
/* 53:   */   {
/* 54:48 */     Site site = ContextTools.getSite(request);
/* 55:49 */     Subject currentUser = SecurityUtils.getSubject();
/* 56:50 */     UsernamePasswordToken token = new UsernamePasswordToken(username, 
/* 57:51 */       this.pwdEncoder.encodePassword(password));
/* 58:52 */     token.setRememberMe(true);
/* 59:   */     try
/* 60:   */     {
/* 61:54 */       currentUser.login(token);
/* 62:   */     }
/* 63:   */     catch (UnknownAccountException localUnknownAccountException) {}catch (IncorrectCredentialsException localIncorrectCredentialsException) {}catch (LockedAccountException localLockedAccountException) {}
/* 64:59 */     if (currentUser.isAuthenticated())
/* 65:   */     {
/* 66:60 */       User user = this.userService.findByUsername(username);
/* 67:61 */       String ip = ServicesUtils.getIpAddr(request);
/* 68:62 */       if (user.getAdmin() == null) {
/* 69:63 */         this.memberService.updateLoginInfo(user, ip);
/* 70:   */       } else {
/* 71:65 */         this.adminService.updateLoginInfo(user, ip);
/* 72:   */       }
/* 73:67 */       if (!StringUtils.isBlank(nextUrl)) {
/* 74:68 */         return "redirect:" + nextUrl;
/* 75:   */       }
/* 76:70 */       return "redirect:forum.jsp";
/* 77:   */     }
/* 78:72 */     model.addAttribute("msg", "qqqqqqqqq");
/* 79:73 */     if (!StringUtils.isBlank(nextUrl)) {
/* 80:74 */       model.addAttribute("nextUrl", nextUrl);
/* 81:   */     }
/* 82:76 */     ViewTools.frontData(request, model, site);
/* 83:77 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 84:78 */       "user", "member.login");
/* 85:   */   }
/* 86:   */   
/* 87:   */   @RequestMapping({"/logout.jsp"})
/* 88:   */   public String logout(String nextUrl, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 89:   */   {
/* 90:86 */     Site site = ContextTools.getSite(request);
/* 91:87 */     Subject currentUser = SecurityUtils.getSubject();
/* 92:88 */     currentUser.logout();
/* 93:89 */     if (!StringUtils.isBlank(nextUrl)) {
/* 94:90 */       return "redirect:" + nextUrl;
/* 95:   */     }
/* 96:92 */     ViewTools.frontData(request, model, site);
/* 97:93 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 98:94 */       "user", "member.login");
/* 99:   */   }
/* :0:   */ }



/* Location:           F:\jspqq\qqqqqq\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.portal.usermgr.action.fnt.LoginAct

 * JD-Core Version:    0.7.0.1

 */