/*  1:   */ package com.portal.sysmgr.filter;
/*  2:   */ 
/*  3:   */ import com.portal.usermgr.entity.User;
/*  4:   */ import com.portal.usermgr.service.UserService;
/*  5:   */ import java.io.IOException;
/*  6:   */ import javax.servlet.Filter;
/*  7:   */ import javax.servlet.FilterChain;
/*  8:   */ import javax.servlet.FilterConfig;
/*  9:   */ import javax.servlet.ServletException;
/* 10:   */ import javax.servlet.ServletRequest;
/* 11:   */ import javax.servlet.ServletResponse;
/* 12:   */ import org.apache.shiro.SecurityUtils;
/* 13:   */ import org.apache.shiro.subject.Subject;
/* 14:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 15:   */ 
/* 16:   */ public class AdminFilter
/* 17:   */   implements Filter
/* 18:   */ {
/* 19:   */   private UserService userService;
/* 20:   */   
/* 21:   */   public void destroy() {}
/* 22:   */   
/* 23:   */   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
/* 24:   */     throws IOException, ServletException
/* 25:   */   {
/* 26:40 */     Subject currentUser = SecurityUtils.getSubject();
/* 27:41 */     String username = (String)currentUser.getPrincipal();
/* 28:42 */     User user = this.userService.findByUsername(username);
/* 29:43 */     if ((user == null) || (user.getAdmin() == null)) {
/* 30:44 */       return;
/* 31:   */     }
/* 32:46 */     chain.doFilter(request, response);
/* 33:   */   }
/* 34:   */   
/* 35:   */   public void init(FilterConfig fConfig)
/* 36:   */     throws ServletException
/* 37:   */   {}
/* 38:   */   
/* 39:   */   @Autowired
/* 40:   */   public void setUserService(UserService userService)
/* 41:   */   {
/* 42:61 */     this.userService = userService;
/* 43:   */   }
/* 44:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.sysmgr.filter.AdminFilter
 * JD-Core Version:    0.7.0.1
 */