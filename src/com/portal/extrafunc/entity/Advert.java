/*  1:   */ package com.portal.extrafunc.entity;
/*  2:   */ 
/*  3:   */ import com.portal.extrafunc.entity.base.BaseAdvert;
/*  4:   */ import com.portal.sysmgr.entity.Site;
/*  5:   */ import java.sql.Time;
/*  6:   */ import java.util.Date;
/*  7:   */ 
/*  8:   */ public class Advert
/*  9:   */   extends BaseAdvert
/* 10:   */ {
/* 11:   */   private static final long serialVersionUID = 1L;
/* 12:   */   public static final String IMG = "img";
/* 13:   */   public static final String FLASH = "flash";
/* 14:   */   public static final String JS = "js";
/* 15:   */   
/* 16:   */   public void init()
/* 17:   */   {
/* 18:17 */     if (getClicks() == null) {
/* 19:18 */       setClicks(Integer.valueOf(0));
/* 20:   */     }
/* 21:20 */     if (getStartTime() == null) {
/* 22:21 */       setStartTime(new Time(System.currentTimeMillis()));
/* 23:   */     }
/* 24:23 */     if (getPriority() == null) {
/* 25:24 */       setPriority(Integer.valueOf(10));
/* 26:   */     }
/* 27:   */   }
/* 28:   */   
/* 29:   */   public String getAdvTypeString()
/* 30:   */   {
/* 31:29 */     if (getAdvType().equals("img")) {
/* 32:30 */       return "图片";
/* 33:   */     }
/* 34:31 */     if (getAdvType().equals("flash")) {
/* 35:32 */       return "FLASH";
/* 36:   */     }
/* 37:34 */     return "代码";
/* 38:   */   }
/* 39:   */   
/* 40:   */   public Advert() {}
/* 41:   */   
/* 42:   */   public Advert(Integer id)
/* 43:   */   {
/* 44:47 */     super(id);
/* 45:   */   }
/* 46:   */   
/* 47:   */   public Advert(Integer id, AdvertSlot slot, Site site, String name, String advType, String url, Date startTime, Integer priority, Integer clicks, Boolean enable)
/* 48:   */   {
/* 49:61 */     super(id, slot, site, name, advType, url, startTime, priority, clicks, enable);
/* 50:   */   }
/* 51:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.entity.Advert
 * JD-Core Version:    0.7.0.1
 */