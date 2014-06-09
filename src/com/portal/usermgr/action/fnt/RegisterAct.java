/*   1:    */ package com.portal.usermgr.action.fnt;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.utils.ResponseUtils;
/*   4:    */ import com.javapms.basic.utils.ServicesUtils;
/*   5:    */ import com.portal.sysmgr.entity.Site;
/*   6:    */ import com.portal.sysmgr.utils.ContextTools;
/*   7:    */ import com.portal.sysmgr.utils.ViewTools;
/*   8:    */ import com.portal.usermgr.entity.Member;
/*   9:    */ import com.portal.usermgr.entity.User;
/*  10:    */ import com.portal.usermgr.service.MemberService;
/*  11:    */ import com.portal.usermgr.service.UserService;
/*  12:    */ import java.io.IOException;
/*  13:    */ import javax.servlet.http.HttpServletRequest;
/*  14:    */ import javax.servlet.http.HttpServletResponse;
/*  15:    */ import org.apache.shiro.SecurityUtils;
/*  16:    */ import org.apache.shiro.authc.IncorrectCredentialsException;
/*  17:    */ import org.apache.shiro.authc.LockedAccountException;
/*  18:    */ import org.apache.shiro.authc.UnknownAccountException;
/*  19:    */ import org.apache.shiro.authc.UsernamePasswordToken;
/*  20:    */ import org.apache.shiro.subject.Subject;
/*  21:    */ import org.slf4j.Logger;
/*  22:    */ import org.slf4j.LoggerFactory;
/*  23:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  24:    */ import org.springframework.stereotype.Controller;
/*  25:    */ import org.springframework.ui.ModelMap;
/*  26:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  27:    */ 
/*  28:    */ @Controller
/*  29:    */ public class RegisterAct
/*  30:    */ {
/*  31: 41 */   private static final Logger log = LoggerFactory.getLogger(RegisterAct.class);
/*  32:    */   public static final String REGISTER = "member.register";
/*  33:    */   @Autowired
/*  34:    */   private MemberService memberService;
/*  35:    */   @Autowired
/*  36:    */   private UserService userService;
/*  37:    */   
/*  38:    */   @RequestMapping(value={"/reg.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  39:    */   public String input(Integer groupId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  40:    */   {
/*  41: 48 */     Site site = ContextTools.getSite(request);
/*  42: 49 */     ViewTools.frontData(request, model, site);
/*  43: 50 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/*  44: 51 */       "user", "member.register");
/*  45:    */   }
/*  46:    */   
/*  47:    */   @RequestMapping(value={"/reg.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  48:    */   public String submit(User user, Member member, Integer groupId, String nextUrl, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  49:    */     throws IOException
/*  50:    */   {
/*  51: 58 */     User u = this.userService.findByUsername(user.getUsername());
/*  52: 59 */     String ip = ServicesUtils.getIpAddr(request);
/*  53: 60 */     if (u != null)
/*  54:    */     {
/*  55: 61 */       Subject currentUser = SecurityUtils.getSubject();
/*  56: 62 */       UsernamePasswordToken token = new UsernamePasswordToken(
/*  57: 63 */         user.getUsername(), user.getPassword());
/*  58: 64 */       token.setRememberMe(true);
/*  59:    */       try
/*  60:    */       {
/*  61: 66 */         currentUser.login(token);
/*  62:    */       }
/*  63:    */       catch (UnknownAccountException localUnknownAccountException) {}catch (IncorrectCredentialsException localIncorrectCredentialsException) {}catch (LockedAccountException localLockedAccountException) {}
/*  64: 71 */       if (currentUser.isAuthenticated())
/*  65:    */       {
/*  66: 72 */         User userl = this.userService.findByUsername(user.getUsername());
/*  67: 73 */         if (user.getAdmin() == null) {
/*  68: 74 */           this.memberService.updateLoginInfo(userl, ip);
/*  69:    */         }
/*  70:    */       }
/*  71: 77 */       return 
/*  72: 78 */         ViewTools.showMessage(nextUrl, request, model, "注册会员成功!", Integer.valueOf(1));
/*  73:    */     }
/*  74: 80 */     this.memberService.registerMember(user, member, ip, groupId);
/*  75: 81 */     Subject currentUser = SecurityUtils.getSubject();
/*  76: 82 */     UsernamePasswordToken token = new UsernamePasswordToken(
/*  77: 83 */       user.getUsername(), user.getPassword());
/*  78: 84 */     token.setRememberMe(true);
/*  79:    */     try
/*  80:    */     {
/*  81: 86 */       currentUser.login(token);
/*  82:    */     }
/*  83:    */     catch (UnknownAccountException localUnknownAccountException1) {}catch (IncorrectCredentialsException localIncorrectCredentialsException1) {}catch (LockedAccountException localLockedAccountException1) {}
/*  84: 91 */     if (currentUser.isAuthenticated())
/*  85:    */     {
/*  86: 92 */       User userl = this.userService.findByUsername(user.getUsername());
/*  87: 93 */       if (user.getAdmin() == null) {
/*  88: 94 */         this.memberService.updateLoginInfo(userl, ip);
/*  89:    */       }
/*  90:    */     }
/*  91: 97 */     log.info("member register success. username={}", user.getUsername());
/*  92: 98 */     return ViewTools.showMessage(nextUrl, request, model, "注册会员成功!", Integer.valueOf(1));
/*  93:    */   }
/*  94:    */   
/*  95:    */   @RequestMapping({"/checkuser.jsp"})
/*  96:    */   public void checkUser(String username, HttpServletRequest request, HttpServletResponse response)
/*  97:    */   {
/*  98:104 */     User user = this.userService.findByUsername(username);
/*  99:105 */     if (user != null)
/* 100:    */     {
/* 101:106 */       ResponseUtils.renderJson(response, "false");
/* 102:107 */       return;
/* 103:    */     }
/* 104:109 */     ResponseUtils.renderJson(response, "true");
/* 105:    */   }
/* 106:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.action.fnt.RegisterAct
 * JD-Core Version:    0.7.0.1
 */