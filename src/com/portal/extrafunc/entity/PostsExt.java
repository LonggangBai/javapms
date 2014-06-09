/*  1:   */ package com.portal.extrafunc.entity;
/*  2:   */ 
/*  3:   */ import com.portal.extrafunc.entity.base.BasePostsExt;
/*  4:   */ 
/*  5:   */ public class PostsExt
/*  6:   */   extends BasePostsExt
/*  7:   */ {
/*  8:   */   private static final long serialVersionUID = 1L;
/*  9:   */   
/* 10:   */   public void init()
/* 11:   */   {
/* 12: 9 */     if (getEditCount() == null) {
/* 13:10 */       setEditCount(Integer.valueOf(0));
/* 14:   */     }
/* 15:   */   }
/* 16:   */   
/* 17:   */   public PostsExt() {}
/* 18:   */   
/* 19:   */   public PostsExt(Integer id)
/* 20:   */   {
/* 21:23 */     super(id);
/* 22:   */   }
/* 23:   */   
/* 24:   */   public PostsExt(Integer id, String createIp, Integer editCount)
/* 25:   */   {
/* 26:32 */     super(id, createIp, editCount);
/* 27:   */   }
/* 28:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.entity.PostsExt
 * JD-Core Version:    0.7.0.1
 */