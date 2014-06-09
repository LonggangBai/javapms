/*  1:   */ package com.portal.sysmgr.interceptor;
/*  2:   */ 
/*  3:   */ import com.portal.sysmgr.entity.Site;
/*  4:   */ import com.portal.sysmgr.service.SiteService;
/*  5:   */ import com.portal.sysmgr.utils.ContextTools;
/*  6:   */ import com.portal.usermgr.entity.User;
/*  7:   */ import com.portal.usermgr.service.UserService;
/*  8:   */ import java.util.List;
/*  9:   */ import javax.servlet.http.HttpServletRequest;
/* 10:   */ import javax.servlet.http.HttpServletResponse;
/* 11:   */ import org.apache.commons.lang.StringUtils;
/* 12:   */ import org.apache.shiro.SecurityUtils;
/* 13:   */ import org.apache.shiro.subject.Subject;
/* 14:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 15:   */ import org.springframework.web.servlet.ModelAndView;
/* 16:   */ import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/* 17:   */ 
/* 18:   */ public class AdminInterceptor
/* 19:   */   extends HandlerInterceptorAdapter
/* 20:   */ {
/* 21:   */   private SiteService siteService;
/* 22:   */   private UserService userService;
/* 23:   */   
/* 24:   */   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
/* 25:   */     throws Exception
/* 26:   */   {
/* 27:31 */     Site site = getSite(request, response);
/* 28:32 */     ContextTools.setSite(request, site);
/* 29:33 */     Subject subject = SecurityUtils.getSubject();
/* 30:34 */     if ((subject.isAuthenticated()) || (subject.isRemembered()))
/* 31:   */     {
/* 32:35 */       String username = (String)subject.getPrincipal();
/* 33:36 */       User user = this.userService.findByUsername(username);
/* 34:37 */       ContextTools.setUser(request, user);
/* 35:   */     }
/* 36:39 */     return true;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mav)
/* 40:   */     throws Exception
/* 41:   */   {}
/* 42:   */   
/* 43:   */   private Site getSite(HttpServletRequest request, HttpServletResponse response)
/* 44:   */   {
/* 45:51 */     Site site = getByDomain(request);
/* 46:52 */     if (site == null) {
/* 47:53 */       site = getByDefault();
/* 48:   */     }
/* 49:55 */     if (site == null) {
/* 50:56 */       throw new RuntimeException("cannot get site!");
/* 51:   */     }
/* 52:58 */     return site;
/* 53:   */   }
/* 54:   */   
/* 55:   */   private Site getByDomain(HttpServletRequest request)
/* 56:   */   {
/* 57:63 */     String domain = request.getServerName();
/* 58:64 */     if (!StringUtils.isBlank(domain)) {
/* 59:65 */       return this.siteService.findByDomain(domain, true);
/* 60:   */     }
/* 61:67 */     return null;
/* 62:   */   }
/* 63:   */   
/* 64:   */   private Site getByDefault()
/* 65:   */   {
/* 66:71 */     List<Site> list = this.siteService.getListFromCache();
/* 67:72 */     if (list.size() > 0) {
/* 68:73 */       return (Site)list.get(0);
/* 69:   */     }
/* 70:75 */     return null;
/* 71:   */   }
/* 72:   */   
/* 73:   */   @Autowired
/* 74:   */   public void setSiteService(SiteService siteService)
/* 75:   */   {
/* 76:84 */     this.siteService = siteService;
/* 77:   */   }
/* 78:   */   
/* 79:   */   @Autowired
/* 80:   */   public void setUserService(UserService userService)
/* 81:   */   {
/* 82:89 */     this.userService = userService;
/* 83:   */   }
/* 84:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.sysmgr.interceptor.AdminInterceptor
 * JD-Core Version:    0.7.0.1
 */