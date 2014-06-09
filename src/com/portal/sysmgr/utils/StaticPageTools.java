/*  1:   */ package com.portal.sysmgr.utils;
/*  2:   */ 
/*  3:   */ import java.util.Calendar;
/*  4:   */ import java.util.Date;
/*  5:   */ import org.apache.commons.lang.StringUtils;
/*  6:   */ 
/*  7:   */ public class StaticPageTools
/*  8:   */ {
/*  9:   */   public static String staticUrlRule(String rule, Integer channelId, String channelPath, Integer contentId, Date date)
/* 10:   */   {
/* 11:23 */     if (StringUtils.isBlank(rule)) {
/* 12:24 */       return rule;
/* 13:   */     }
/* 14:26 */     if (channelId != null) {
/* 15:27 */       rule = StringUtils.replace(rule, "${channelId}", 
/* 16:28 */         channelId.toString());
/* 17:   */     }
/* 18:30 */     if (StringUtils.isBlank(channelPath)) {
/* 19:31 */       rule = StringUtils.replace(rule, "${channelPath}", channelPath);
/* 20:   */     }
/* 21:33 */     if (contentId != null) {
/* 22:34 */       rule = StringUtils.replace(rule, "${contentId}", 
/* 23:35 */         contentId.toString());
/* 24:   */     }
/* 25:37 */     if (date != null)
/* 26:   */     {
/* 27:39 */       Calendar cal = Calendar.getInstance();
/* 28:40 */       cal.setTime(date);
/* 29:41 */       int year = cal.get(1);
/* 30:42 */       int month = cal.get(2) + 1;
/* 31:43 */       String mm = "0" + month;
/* 32:44 */       int day = cal.get(5);
/* 33:45 */       String dd = "0" + day;
/* 34:46 */       long time = date.getTime();
/* 35:47 */       rule = StringUtils.replace(rule, "${year}", String.valueOf(year));
/* 36:48 */       rule = StringUtils.replace(rule, "${month}", String.valueOf(month));
/* 37:49 */       rule = StringUtils.replace(rule, "${MM}", mm);
/* 38:50 */       rule = StringUtils.replace(rule, "${day}", String.valueOf(day));
/* 39:51 */       rule = StringUtils.replace(rule, "${DD}", dd);
/* 40:52 */       rule = StringUtils.replace(rule, "${time}", String.valueOf(time));
/* 41:   */     }
/* 42:54 */     return rule;
/* 43:   */   }
/* 44:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.sysmgr.utils.StaticPageTools
 * JD-Core Version:    0.7.0.1
 */