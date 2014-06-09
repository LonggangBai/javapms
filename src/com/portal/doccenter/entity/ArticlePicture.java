/*  1:   */ package com.portal.doccenter.entity;
/*  2:   */ 
/*  3:   */ import com.portal.doccenter.entity.base.BaseArticlePicture;
/*  4:   */ 
/*  5:   */ public class ArticlePicture
/*  6:   */   extends BaseArticlePicture
/*  7:   */ {
/*  8:   */   private static final long serialVersionUID = 1L;
/*  9:   */   
/* 10:   */   public boolean getCover()
/* 11:   */   {
/* 12: 9 */     if ((getThumb() != null) && (!getThumb().booleanValue()) && 
/* 13:10 */       (getStyle() != null) && 
/* 14:11 */       (getStyle().indexOf(",1,") > -1)) {
/* 15:12 */       return true;
/* 16:   */     }
/* 17:16 */     return false;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public ArticlePicture() {}
/* 21:   */   
/* 22:   */   public ArticlePicture(String imgPath)
/* 23:   */   {
/* 24:29 */     super(imgPath);
/* 25:   */   }
/* 26:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.entity.ArticlePicture
 * JD-Core Version:    0.7.0.1
 */