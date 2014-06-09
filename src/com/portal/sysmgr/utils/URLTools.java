/*   1:    */ package com.portal.sysmgr.utils;
/*   2:    */ 
/*   3:    */ import javax.servlet.http.HttpServletRequest;
/*   4:    */ import org.apache.commons.lang.StringUtils;
/*   5:    */ import org.springframework.web.util.UrlPathHelper;
/*   6:    */
/*   7:    */ public class URLTools
/*   8:    */ {
/*   9:    */   public static int getPageNo(HttpServletRequest request)
/*  10:    */   {
/*  11: 22 */     return getPageNo(getURI(request));
/*  12:    */   }
/*  13:    */
/*  14:    */   private static String getURI(HttpServletRequest request)
/*  15:    */   {
/*  16: 26 */     UrlPathHelper helper = new UrlPathHelper();
/*  17: 27 */     String uri = helper.getOriginatingRequestUri(request);
/*  18: 28 */     String ctx = helper.getOriginatingContextPath(request);
/*  19: 29 */     if (!StringUtils.isBlank(ctx)) {
/*  20: 30 */       return uri.substring(ctx.length());
/*  21:    */     }
/*  22: 32 */     return uri;
/*  23:    */   }
/*  24:    */
/*  25:    */   public static PageInfo getPageInfo(HttpServletRequest request, boolean query)
/*  26:    */   {
/*  27: 43 */     UrlPathHelper helper = new UrlPathHelper();
/*  28: 44 */     String uri = helper.getOriginatingRequestUri(request);
/*  29: 45 */     if (query)
/*  30:    */     {
/*  31: 46 */       String queryString = helper.getOriginatingQueryString(request);
/*  32: 47 */       return getPageInfo(uri, queryString);
/*  33:    */     }
/*  34: 49 */     return getPageInfo(uri, "");
/*  35:    */   }
/*  36:    */
/*  37:    */   public static int getPageNo(String uri)
/*  38:    */   {
/*  39: 61 */     if (uri == null) {
/*  40: 62 */       throw new IllegalArgumentException("URL地址不能为空");
/*  41:    */     }
/*  42: 64 */     if (!uri.startsWith("/")) {
/*  43: 65 */       throw new IllegalArgumentException("URL地址错误");
/*  44:    */     }
/*  45: 67 */     int pageNo = 1;
/*  46: 68 */     int bi = uri.indexOf("_");
/*  47: 69 */     int pi = uri.indexOf(".");
/*  48: 70 */     if (bi != -1)
/*  49:    */     {
/*  50:    */       String pageNoStr;
/*  52: 72 */       if (pi != -1) {
/*  53: 73 */         pageNoStr = uri.substring(bi + 1, pi);
/*  54:    */       } else {
/*  55: 75 */         pageNoStr = uri.substring(bi + 1);
/*  56:    */       }
/*  57:    */       try
/*  58:    */       {
/*  59: 78 */         pageNo = Integer.valueOf(pageNoStr).intValue();
/*  60:    */       }
/*  61:    */       catch (Exception localException) {}
/*  62:    */     }
/*  63: 82 */     return pageNo;
/*  64:    */   }
/*  65:    */
/*  66:    */   public static PageInfo getPageInfo(String uri, String queryString)
/*  67:    */   {
/*  68: 91 */     if (uri == null) {
/*  69: 92 */       return null;
/*  70:    */     }
/*  71: 94 */     if (!uri.startsWith("/")) {
/*  72: 95 */       throw new IllegalArgumentException("URL地址错误");
/*  73:    */     }
/*  74: 97 */     int bi = uri.indexOf("_");
/*  75: 98 */     int pi = uri.indexOf(".");
/*  76: 99 */     int lastSpt = uri.lastIndexOf("/") + 1;
/*  77:    */     String url;
/*  79:101 */     if (!StringUtils.isBlank(queryString)) {
/*  80:102 */       url = uri + "?" + queryString;
/*  81:    */     } else {
/*  82:104 */       url = uri;
/*  83:    */     }
/*  84:    */     String urlFormer;
/*  86:107 */     if (bi != -1)
/*  87:    */     {
/*  88:108 */       urlFormer = uri.substring(lastSpt, bi);
/*  89:    */     }
/*  90:    */     else
/*  91:    */     {
/*  93:109 */       if (pi != -1) {
/*  94:110 */         urlFormer = uri.substring(lastSpt, pi);
/*  95:    */       } else {
/*  96:112 */         urlFormer = uri.substring(lastSpt);
/*  97:    */       }
/*  98:    */     }
/*  99:    */     String urlLater;
/* 101:115 */     if (pi != -1) {
/* 102:116 */       urlLater = url.substring(pi);
/* 103:    */     } else {
/* 104:118 */       urlLater = url.substring(uri.length());
/* 105:    */     }
/* 106:120 */     String href = url.substring(lastSpt);
/* 107:121 */     return new PageInfo(href, urlFormer, urlLater);
/* 108:    */   }
/* 109:    */
/* 110:    */   public static class PageInfo
/* 111:    */   {
/* 112:    */     private String href;
/* 113:    */     private String hrefPre;
/* 114:    */     private String hrefHalf;
/* 115:    */
/* 116:    */     public PageInfo(String href, String hrefPre, String hrefHalf)
/* 117:    */     {
/* 118:133 */       this.href = href;
/* 119:134 */       this.hrefPre = hrefPre;
/* 120:135 */       this.hrefHalf = hrefHalf;
/* 121:    */     }
/* 122:    */
/* 123:    */     public String getHref()
/* 124:    */     {
/* 125:139 */       return this.href;
/* 126:    */     }
/* 127:    */
/* 128:    */     public void setHref(String href)
/* 129:    */     {
/* 130:143 */       this.href = href;
/* 131:    */     }
/* 132:    */
/* 133:    */     public String getHrefPre()
/* 134:    */     {
/* 135:147 */       return this.hrefPre;
/* 136:    */     }
/* 137:    */
/* 138:    */     public void setHrefPre(String hrefPre)
/* 139:    */     {
/* 140:151 */       this.hrefPre = hrefPre;
/* 141:    */     }
/* 142:    */
/* 143:    */     public String getHrefHalf()
/* 144:    */     {
/* 145:155 */       return this.hrefHalf;
/* 146:    */     }
/* 147:    */
/* 148:    */     public void setHrefHalf(String hrefHalf)
/* 149:    */     {
/* 150:159 */       this.hrefHalf = hrefHalf;
/* 151:    */     }
/* 152:    */   }
/* 153:    */ }



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.portal.sysmgr.utils.URLTools

 * JD-Core Version:    0.7.0.1

 */