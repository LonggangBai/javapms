/*  1:   */ package com.portal.sysmgr.filter;
/*  2:   */ 
/*  3:   */ import com.portal.sysmgr.entity.Site;
/*  4:   */ import com.portal.sysmgr.service.SiteService;
/*  5:   */ import com.portal.sysmgr.utils.ContextTools;
/*  6:   */ import java.io.IOException;
/*  7:   */ import java.util.List;
/*  8:   */ import javax.servlet.Filter;
/*  9:   */ import javax.servlet.FilterChain;
/* 10:   */ import javax.servlet.FilterConfig;
/* 11:   */ import javax.servlet.ServletException;
/* 12:   */ import javax.servlet.ServletRequest;
/* 13:   */ import javax.servlet.ServletResponse;
/* 14:   */ import org.apache.commons.lang.StringUtils;
/* 15:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 16:   */ 
/* 17:   */ public class SiteFilter
/* 18:   */   implements Filter
/* 19:   */ {
/* 20:   */   private SiteService siteService;
/* 21:   */   
/* 22:   */   public void destroy() {}
/* 23:   */   
/* 24:   */   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
/* 25:   */     throws IOException, ServletException
/* 26:   */   {
/* 27:41 */     Site site = getSite(request);
/* 28:42 */     ContextTools.setSite(site);
/* 29:43 */     ContextTools.setSite(request, site);
/* 30:44 */     chain.doFilter(request, response);
/* 31:45 */     ContextTools.resetSite();
/* 32:   */   }
/* 33:   */   
/* 34:   */   public void init(FilterConfig fConfig)
/* 35:   */     throws ServletException
/* 36:   */   {}
/* 37:   */   
/* 38:   */   private Site getSite(ServletRequest request)
/* 39:   */   {
/* 40:56 */     Site site = getByDomain(request);
/* 41:57 */     if (site == null) {
/* 42:58 */       site = getByDefault();
/* 43:   */     }
/* 44:60 */     if (site == null) {
/* 45:61 */       throw new RuntimeException("site not found!");
/* 46:   */     }
/* 47:63 */     return site;
/* 48:   */   }
/* 49:   */   
/* 50:   */   private Site getByDomain(ServletRequest request)
/* 51:   */   {
/* 52:68 */     String domain = request.getServerName();
/* 53:69 */     if (!StringUtils.isBlank(domain)) {
/* 54:70 */       return this.siteService.findByDomain(domain, true);
/* 55:   */     }
/* 56:72 */     return null;
/* 57:   */   }
/* 58:   */   
/* 59:   */   private Site getByDefault()
/* 60:   */   {
/* 61:76 */     List<Site> list = this.siteService.getListFromCache();
/* 62:77 */     if (list.size() > 0) {
/* 63:78 */       return (Site)list.get(0);
/* 64:   */     }
/* 65:80 */     return null;
/* 66:   */   }
/* 67:   */   
/* 68:   */   @Autowired
/* 69:   */   public void setSiteService(SiteService siteService)
/* 70:   */   {
/* 71:88 */     this.siteService = siteService;
/* 72:   */   }
/* 73:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.sysmgr.filter.SiteFilter
 * JD-Core Version:    0.7.0.1
 */