/*  1:   */ package com.portal.recruitcenter.entity;
/*  2:   */ 
/*  3:   */ import com.portal.recruitcenter.entity.base.BaseVipType;
/*  4:   */ 
/*  5:   */ public class VipType
/*  6:   */   extends BaseVipType
/*  7:   */ {
/*  8:   */   private static final long serialVersionUID = 1L;
/*  9:   */   
/* 10:   */   public VipType() {}
/* 11:   */   
/* 12:   */   public VipType(Integer id)
/* 13:   */   {
/* 14:19 */     super(id);
/* 15:   */   }
/* 16:   */   
/* 17:   */   public VipType(Integer id, String typeName, Integer dayCount, Integer postCount, Integer favoriteCount, Integer auditionCount, Integer receiptCount, Integer sendCount, Boolean setupLogin)
/* 18:   */   {
/* 19:45 */     super(id, typeName, dayCount, postCount, favoriteCount, auditionCount, receiptCount, sendCount, setupLogin);
/* 20:   */   }
/* 21:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.entity.VipType
 * JD-Core Version:    0.7.0.1
 */