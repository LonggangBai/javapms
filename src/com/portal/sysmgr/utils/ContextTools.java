/*  1:   */ package com.portal.sysmgr.utils;
/*  2:   */ 
/*  3:   */ import com.portal.sysmgr.entity.Site;
/*  4:   */ import com.portal.usermgr.entity.User;
/*  5:   */ import javax.servlet.ServletRequest;
/*  6:   */ 
/*  7:   */ public class ContextTools
/*  8:   */ {
/*  9:   */   public static final String USER_KEY = "_request_user_key";
/* 10:   */   public static final String SITE_KEY = "_request_site_key";
/* 11:   */   
/* 12:   */   public static User getUser(ServletRequest request)
/* 13:   */   {
/* 14:29 */     return (User)request.getAttribute("_request_user_key");
/* 15:   */   }
/* 16:   */   
/* 17:   */   public static Integer getUserId(ServletRequest request)
/* 18:   */   {
/* 19:33 */     if (getUser(request) != null) {
/* 20:34 */       return getUser(request).getId();
/* 21:   */     }
/* 22:36 */     return null;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public static void setUser(ServletRequest request, User user)
/* 26:   */   {
/* 27:46 */     request.setAttribute("_request_user_key", user);
/* 28:   */   }
/* 29:   */   
/* 30:   */   public static Site getSite(ServletRequest request)
/* 31:   */   {
/* 32:56 */     return (Site)request.getAttribute("_request_site_key");
/* 33:   */   }
/* 34:   */   
/* 35:   */   public static Integer getSiteId(ServletRequest request)
/* 36:   */   {
/* 37:60 */     return getSite(request).getId();
/* 38:   */   }
/* 39:   */   
/* 40:   */   public static void setSite(ServletRequest request, Site site)
/* 41:   */   {
/* 42:70 */     request.setAttribute("_request_site_key", site);
/* 43:   */   }
/* 44:   */   
/* 45:76 */   private static ThreadLocal<Site> siteHolder = new ThreadLocal();
/* 46:   */   
/* 47:   */   public static void setSite(Site site)
/* 48:   */   {
/* 49:79 */     siteHolder.set(site);
/* 50:   */   }
/* 51:   */   
/* 52:   */   public static Site getSite()
/* 53:   */   {
/* 54:83 */     return (Site)siteHolder.get();
/* 55:   */   }
/* 56:   */   
/* 57:   */   public static void resetSite()
/* 58:   */   {
/* 59:87 */     siteHolder.remove();
/* 60:   */   }
/* 61:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.sysmgr.utils.ContextTools
 * JD-Core Version:    0.7.0.1
 */