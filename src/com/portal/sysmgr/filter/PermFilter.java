/*  1:   */ package com.portal.sysmgr.filter;
/*  2:   */ 
/*  3:   */ import com.portal.usermgr.service.AdminService;
/*  4:   */ import com.portal.usermgr.service.UserService;
/*  5:   */ import javax.servlet.ServletRequest;
/*  6:   */ import javax.servlet.ServletResponse;
/*  7:   */ import org.apache.shiro.authc.AuthenticationToken;
/*  8:   */ import org.apache.shiro.subject.Subject;
/*  9:   */ import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
/* 10:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 11:   */ 
/* 12:   */ public class PermFilter
/* 13:   */   extends FormAuthenticationFilter
/* 14:   */ {
/* 15:   */   private UserService userService;
/* 16:   */   private AdminService adminService;
/* 17:   */   
/* 18:   */   protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
/* 19:   */   {
/* 20:25 */     boolean isAllowed = super.isAccessAllowed(request, response, 
/* 21:26 */       mappedValue);
/* 22:27 */     if ((isAllowed) && (isLoginRequest(request, response)))
/* 23:   */     {
/* 24:   */       try
/* 25:   */       {
/* 26:29 */         issueSuccessRedirect(request, response);
/* 27:   */       }
/* 28:   */       catch (Exception localException) {}
/* 29:32 */       return false;
/* 30:   */     }
/* 31:34 */     return isAllowed;
/* 32:   */   }
/* 33:   */   
/* 34:   */   protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response)
/* 35:   */     throws Exception
/* 36:   */   {
/* 37:41 */     return super.onLoginSuccess(token, subject, request, response);
/* 38:   */   }
/* 39:   */   
/* 40:   */   @Autowired
/* 41:   */   public void setUserService(UserService userService)
/* 42:   */   {
/* 43:49 */     this.userService = userService;
/* 44:   */   }
/* 45:   */   
/* 46:   */   @Autowired
/* 47:   */   public void setAdminService(AdminService adminService)
/* 48:   */   {
/* 49:54 */     this.adminService = adminService;
/* 50:   */   }
/* 51:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.sysmgr.filter.PermFilter
 * JD-Core Version:    0.7.0.1
 */