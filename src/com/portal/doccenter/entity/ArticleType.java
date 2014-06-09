/*  1:   */ package com.portal.doccenter.entity;
/*  2:   */ 
/*  3:   */ import com.portal.doccenter.entity.base.BaseArticleType;
/*  4:   */ 
/*  5:   */ public class ArticleType
/*  6:   */   extends BaseArticleType
/*  7:   */ {
/*  8:   */   private static final long serialVersionUID = 1L;
/*  9:   */   
/* 10:   */   public ArticleType() {}
/* 11:   */   
/* 12:   */   public ArticleType(Integer id)
/* 13:   */   {
/* 14:17 */     super(id);
/* 15:   */   }
/* 16:   */   
/* 17:   */   public ArticleType(Integer id, String name, Boolean hasImage, Boolean disabled)
/* 18:   */   {
/* 19:33 */     super(id, name, hasImage, disabled);
/* 20:   */   }
/* 21:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.entity.ArticleType
 * JD-Core Version:    0.7.0.1
 */