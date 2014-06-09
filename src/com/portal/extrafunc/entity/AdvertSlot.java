/*  1:   */ package com.portal.extrafunc.entity;
/*  2:   */ 
/*  3:   */ import com.portal.extrafunc.entity.base.BaseAdvertSlot;
/*  4:   */ import com.portal.sysmgr.entity.Site;
/*  5:   */ 
/*  6:   */ public class AdvertSlot
/*  7:   */   extends BaseAdvertSlot
/*  8:   */ {
/*  9:   */   private static final long serialVersionUID = 1L;
/* 10: 8 */   public static final Short FIXED = 1;
/* 11:10 */   public static final Short FLOAT = Short.valueOf((short)2);
/* 12:12 */   public static final Short POP = Short.valueOf((short)3);
/* 13:14 */   public static final Short COUPLET = Short.valueOf((short)4);
/* 14:   */   
/* 15:   */   public void init()
/* 16:   */   {
/* 17:17 */     if (getRemain() == null) {
/* 18:18 */       setRemain(Integer.valueOf(0));
/* 19:   */     }
/* 20:20 */     if (getScrollbar() == null) {
/* 21:21 */       setScrollbar(Boolean.valueOf(false));
/* 22:   */     }
/* 23:23 */     if (getRotation() == null) {
/* 24:24 */       setRotation(Boolean.valueOf(true));
/* 25:   */     }
/* 26:   */   }
/* 27:   */   
/* 28:   */   public String getSlotTypeString()
/* 29:   */   {
/* 30:29 */     if (getSlotType().equals(FIXED)) {
/* 31:30 */       return "固定";
/* 32:   */     }
/* 33:31 */     if (getSlotType().equals(FLOAT)) {
/* 34:32 */       return "漂浮";
/* 35:   */     }
/* 36:33 */     if (getSlotType().equals(POP)) {
/* 37:34 */       return "弹窗";
/* 38:   */     }
/* 39:36 */     return "对联";
/* 40:   */   }
/* 41:   */   
/* 42:   */   public AdvertSlot() {}
/* 43:   */   
/* 44:   */   public AdvertSlot(Integer id)
/* 45:   */   {
/* 46:49 */     super(id);
/* 47:   */   }
/* 48:   */   
/* 49:   */   public AdvertSlot(Integer id, Site site, String name, Short slotType)
/* 50:   */   {
/* 51:58 */     super(id, site, name, slotType);
/* 52:   */   }
/* 53:   */ }



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.portal.extrafunc.entity.AdvertSlot

 * JD-Core Version:    0.7.0.1

 */