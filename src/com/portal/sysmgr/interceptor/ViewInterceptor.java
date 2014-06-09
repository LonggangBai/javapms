/*  1:   */ package com.portal.sysmgr.interceptor;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.utils.StringBeanUtils;
/*  4:   */ import com.portal.sysmgr.entity.Site;
/*  5:   */ import com.portal.sysmgr.service.SiteService;
/*  6:   */ import com.portal.sysmgr.utils.ContextTools;
/*  7:   */ import com.portal.usermgr.entity.User;
/*  8:   */ import com.portal.usermgr.service.UserService;
/*  9:   */ import java.io.IOException;
/* 10:   */ import java.util.List;
/* 11:   */ import javax.servlet.ServletException;
/* 12:   */ import javax.servlet.http.HttpServletRequest;
/* 13:   */ import javax.servlet.http.HttpServletResponse;
/* 14:   */ import org.apache.commons.lang.StringUtils;
/* 15:   */ import org.apache.shiro.SecurityUtils;
/* 16:   */ import org.apache.shiro.subject.Subject;
/* 17:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 18:   */ import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/* 19:   */ import org.springframework.web.util.UrlPathHelper;
/* 20:   */ 
/* 21:   */ public class ViewInterceptor
/* 22:   */   extends HandlerInterceptorAdapter
/* 23:   */ {
/* 24:   */   private SiteService siteService;
/* 25:   */   private UserService userService;
/* 26:   */   
/* 27:   */   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
/* 28:   */     throws ServletException
/* 29:   */   {
/* 30:34 */     Site site = getSite(request, response);
/* 31:35 */     ContextTools.setSite(request, site);
/* 32:36 */     UrlPathHelper helper = new UrlPathHelper();
/* 33:37 */     String queryString = helper.getOriginatingQueryString(request);
/* 34:38 */     if ((!StringUtils.isBlank(queryString)) && 
/* 35:39 */       (StringBeanUtils.hasHtml(queryString))) {
/* 36:   */       try
/* 37:   */       {
/* 38:41 */         response.setContentType("text/html;charset=UTF-8");
/* 39:42 */         response.sendError(404);
/* 40:   */       }
/* 41:   */       catch (IOException e)
/* 42:   */       {
/* 43:44 */         e.printStackTrace();
/* 44:   */       }
/* 45:   */     }
/* 46:48 */     Subject subject = SecurityUtils.getSubject();
/* 47:49 */     if (subject.isAuthenticated())
/* 48:   */     {
/* 49:50 */       String username = (String)subject.getPrincipal();
/* 50:51 */       User user = this.userService.findByUsername(username);
/* 51:52 */       ContextTools.setUser(request, user);
/* 52:   */     }
/* 53:54 */     return true;
/* 54:   */   }
/* 55:   */   
/* 56:   */   private Site getSite(HttpServletRequest request, HttpServletResponse response)
/* 57:   */   {
/* 58:59 */     Site site = getByDomain(request);
/* 59:60 */     if (site == null) {
/* 60:61 */       site = getByDefault();
/* 61:   */     }
/* 62:63 */     if (site == null) {
/* 63:64 */       throw new RuntimeException("cannot get site!");
/* 64:   */     }
/* 65:66 */     return site;
/* 66:   */   }
/* 67:   */   
/* 68:   */   private Site getByDomain(HttpServletRequest request)
/* 69:   */   {
/* 70:71 */     String domain = request.getServerName();
/* 71:72 */     if (!StringUtils.isBlank(domain)) {
/* 72:73 */       return this.siteService.findByDomain(domain, true);
/* 73:   */     }
/* 74:75 */     return null;
/* 75:   */   }
/* 76:   */   
/* 77:   */   private Site getByDefault()
/* 78:   */   {
/* 79:79 */     List<Site> list = this.siteService.getListFromCache();
/* 80:80 */     if (list.size() > 0) {
/* 81:81 */       return (Site)list.get(0);
/* 82:   */     }
/* 83:83 */     return null;
/* 84:   */   }
/* 85:   */   
/* 86:   */   @Autowired
/* 87:   */   public void setSiteService(SiteService siteService)
/* 88:   */   {
/* 89:92 */     this.siteService = siteService;
/* 90:   */   }
/* 91:   */   
/* 92:   */   @Autowired
/* 93:   */   public void setUserService(UserService userService)
/* 94:   */   {
/* 95:97 */     this.userService = userService;
/* 96:   */   }
/* 97:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.sysmgr.interceptor.ViewInterceptor
 * JD-Core Version:    0.7.0.1
 */