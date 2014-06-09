/*   1:    */ package com.portal.sysmgr.utils;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.plugin.springmvc.MessageResolver;
/*   4:    */ import com.javapms.basic.utils.ServicesUtils;
/*   5:    */ import com.portal.sysmgr.entity.Site;
/*   6:    */ import com.portal.usermgr.entity.User;
/*   7:    */ import freemarker.core.Environment;
/*   8:    */ import freemarker.template.AdapterTemplateModel;
/*   9:    */ import freemarker.template.TemplateException;
/*  10:    */ import freemarker.template.TemplateModel;
/*  11:    */ import freemarker.template.TemplateModelException;
/*  12:    */ import freemarker.template.TemplateNumberModel;
/*  13:    */ import java.io.IOException;
/*  14:    */ import java.util.Map;
/*  15:    */ import javax.servlet.http.HttpServletRequest;
/*  16:    */ import javax.servlet.http.HttpServletResponse;
/*  17:    */ import org.apache.commons.lang.StringUtils;
/*  18:    */ 
/*  19:    */ public class ViewTools
/*  20:    */ {
/*  21:    */   public static String getTplPath(HttpServletRequest request, String solutionPath, String dir, String name)
/*  22:    */   {
/*  23: 46 */     if (request != null) {
/*  24: 47 */       return 
/*  25:    */       
/*  26: 49 */         solutionPath + "/" + dir + "/" + MessageResolver.getMessage(request, name, new Object[0]) + ".html";
/*  27:    */     }
/*  28: 51 */     return solutionPath + "/" + dir + "/" + name + ".html";
/*  29:    */   }
/*  30:    */   
/*  31:    */   public static String pageNotFound(HttpServletResponse response)
/*  32:    */   {
/*  33:    */     try
/*  34:    */     {
/*  35: 63 */       response.sendError(404);
/*  36: 64 */       return null;
/*  37:    */     }
/*  38:    */     catch (IOException e)
/*  39:    */     {
/*  40: 66 */       e.printStackTrace();
/*  41:    */     }
/*  42: 68 */     return null;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public static String showMessage(String nextUrl, HttpServletRequest request, Map<String, Object> model, String msg, Integer status)
/*  46:    */   {
/*  47: 74 */     Site site = ContextTools.getSite(request);
/*  48: 75 */     if (!StringUtils.isBlank(msg)) {
/*  49: 76 */       model.put("msg", msg);
/*  50:    */     }
/*  51: 78 */     if (StringUtils.isBlank(nextUrl)) {
/*  52: 79 */       model.put("nextUrl", 
/*  53: 80 */         ServicesUtils.getLocation(request, false));
/*  54:    */     } else {
/*  55: 82 */       model.put("nextUrl", nextUrl);
/*  56:    */     }
/*  57: 84 */     model.put("status", status);
/*  58: 85 */     frontData(request, model, site);
/*  59: 86 */     return getTplPath(request, site.getSolutionPath(), 
/*  60: 87 */       "common/tips", "tpl.msg");
/*  61:    */   }
/*  62:    */   
/*  63:    */   public static String showLogin(HttpServletRequest request, Map<String, Object> model, String msg)
/*  64:    */   {
/*  65: 92 */     Site site = ContextTools.getSite(request);
/*  66: 93 */     if (!StringUtils.isBlank(msg)) {
/*  67: 94 */       model.put("msg", msg);
/*  68:    */     }
/*  69: 96 */     model.put("nextUrl", ServicesUtils.getLocation(request, false));
/*  70: 97 */     frontData(request, model, site);
/*  71: 98 */     return getTplPath(request, site.getSolutionPath(), 
/*  72: 99 */       "user", "member.login");
/*  73:    */   }
/*  74:    */   
/*  75:    */   public static void frontData(HttpServletRequest request, Map<String, Object> map, Site site)
/*  76:    */   {
/*  77:104 */     User user = ContextTools.getUser(request);
/*  78:105 */     String location = ServicesUtils.getLocation(request, false);
/*  79:106 */     if (user != null) {
/*  80:107 */       map.put("user", user);
/*  81:    */     }
/*  82:109 */     map.put("site", site);
/*  83:110 */     String ctx = site.getContextPath() == null ? "" : site.getContextPath();
/*  84:111 */     map.put("base", ctx);
/*  85:112 */     map.put("comm", ctx + "/skin/comm");
/*  86:113 */     String res_skin = ctx + "/skin" + "/" + site.getPath() + "/" + 
/*  87:114 */       site.getTplStyle();
/*  88:115 */     map.put("skin", res_skin.substring(1));
/*  89:116 */     map.put("location", location);
/*  90:    */   }
/*  91:    */   
/*  92:    */   public static void frontPageData(HttpServletRequest request, Map<String, Object> map)
/*  93:    */   {
/*  94:127 */     int pageNo = URLTools.getPageNo(request);
/*  95:128 */     URLTools.PageInfo info = URLTools.getPageInfo(request, false);
/*  96:129 */     String href = info.getHref();
/*  97:130 */     String hrefPre = info.getHrefPre();
/*  98:131 */     String hrefHalf = info.getHrefHalf();
/*  99:132 */     frontPageData(pageNo, href, hrefPre, hrefHalf, map);
/* 100:    */   }
/* 101:    */   
/* 102:    */   public static void frontQueryData(HttpServletRequest request, Map<String, Object> map, Site site)
/* 103:    */   {
/* 104:137 */     User user = ContextTools.getUser(request);
/* 105:138 */     String location = ServicesUtils.getLocation(request, true);
/* 106:139 */     if (user != null) {
/* 107:140 */       map.put("user", user);
/* 108:    */     }
/* 109:142 */     map.put("site", site);
/* 110:143 */     String ctx = site.getContextPath() == null ? "" : site.getContextPath();
/* 111:144 */     map.put("base", ctx);
/* 112:145 */     map.put("comm", ctx + "/skin/comm");
/* 113:146 */     String res_skin = ctx + "/skin" + "/" + site.getPath() + "/" + 
/* 114:147 */       site.getTplStyle();
/* 115:148 */     map.put("skin", res_skin.substring(1));
/* 116:149 */     map.put("location", location);
/* 117:    */   }
/* 118:    */   
/* 119:    */   public static void frontQueryPageData(HttpServletRequest request, Map<String, Object> map)
/* 120:    */   {
/* 121:160 */     int pageNo = URLTools.getPageNo(request);
/* 122:161 */     URLTools.PageInfo info = URLTools.getPageInfo(request, true);
/* 123:162 */     String href = info.getHref();
/* 124:163 */     String hrefPre = info.getHrefPre();
/* 125:164 */     String hrefHalf = info.getHrefHalf();
/* 126:165 */     frontPageData(pageNo, href, hrefPre, hrefHalf, map);
/* 127:    */   }
/* 128:    */   
/* 129:    */   public static void frontPageData(int pageNo, String href, String hrefPre, String hrefHalf, Map<String, Object> map)
/* 130:    */   {
/* 131:179 */     map.put("pn", Integer.valueOf(pageNo));
/* 132:180 */     map.put("href", href);
/* 133:181 */     map.put("hrefPre", hrefPre);
/* 134:182 */     map.put("hrefHalf", hrefHalf);
/* 135:    */   }
/* 136:    */   
/* 137:    */   public static Site getSite(Environment env)
/* 138:    */     throws TemplateModelException
/* 139:    */   {
/* 140:186 */     TemplateModel model = env.getGlobalVariable("site");
/* 141:187 */     if ((model instanceof AdapterTemplateModel)) {
/* 142:188 */       return (Site)((AdapterTemplateModel)model)
/* 143:189 */         .getAdaptedObject(Site.class);
/* 144:    */     }
/* 145:191 */     throw new TemplateModelException("'site' not found in DataModel");
/* 146:    */   }
/* 147:    */   
/* 148:    */   public static int getPageNo(Environment env)
/* 149:    */     throws TemplateException
/* 150:    */   {
/* 151:197 */     TemplateModel pageNo = env.getGlobalVariable("pn");
/* 152:198 */     if ((pageNo instanceof TemplateNumberModel)) {
/* 153:199 */       return ((TemplateNumberModel)pageNo).getAsNumber().intValue();
/* 154:    */     }
/* 155:201 */     return 1;
/* 156:    */   }
/* 157:    */   
/* 158:    */   public static int getFirst(Map<String, TemplateModel> params)
/* 159:    */     throws TemplateException
/* 160:    */   {
/* 161:207 */     Integer first = TagModelTools.getInt("first", params);
/* 162:208 */     if ((first == null) || (first.intValue() <= 0)) {
/* 163:209 */       return 0;
/* 164:    */     }
/* 165:211 */     return first.intValue() - 1;
/* 166:    */   }
/* 167:    */   
/* 168:    */   public static int getCount(Map<String, TemplateModel> params)
/* 169:    */     throws TemplateException
/* 170:    */   {
/* 171:217 */     Integer count = TagModelTools.getInt("count", params);
/* 172:218 */     if ((count == null) || (count.intValue() <= 0)) {
/* 173:219 */       return 20;
/* 174:    */     }
/* 175:221 */     return count.intValue();
/* 176:    */   }
/* 177:    */   
/* 178:    */   public static void includePagination(Site site, Map<String, TemplateModel> params, Environment env)
/* 179:    */     throws TemplateException, IOException
/* 180:    */   {
/* 181:228 */     String pageType = TagModelTools.getString("pageType", 
/* 182:229 */       params);
/* 183:230 */     if (!StringUtils.isBlank(pageType))
/* 184:    */     {
/* 185:231 */       String tpl = site.getSolutionPath() + "/common/style_page/page_" + 
/* 186:232 */         pageType + ".html";
/* 187:233 */       env.include(tpl, "UTF-8", true);
/* 188:    */     }
/* 189:    */   }
/* 190:    */   
/* 191:    */   public static void includeTpl(String tplName, Site site, Environment env)
/* 192:    */     throws IOException, TemplateException
/* 193:    */   {
/* 194:241 */     String tpl = getTplPath(null, site.getSolutionPath(), 
/* 195:242 */       "common/tags", tplName);
/* 196:243 */     env.include(tpl, "UTF-8", true);
/* 197:    */   }
/* 198:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.sysmgr.utils.ViewTools
 * JD-Core Version:    0.7.0.1
 */