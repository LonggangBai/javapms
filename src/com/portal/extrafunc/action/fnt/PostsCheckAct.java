/*  1:   */ package com.portal.extrafunc.action.fnt;
/*  2:   */ 
/*  3:   */ import com.portal.extrafunc.action.cache.PostsCheckCache;
/*  4:   */ import org.springframework.beans.factory.annotation.Autowired;
/*  5:   */ 
/*  6:   */ public class PostsCheckAct
/*  7:   */ {
/*  8:   */   @Autowired
/*  9:   */   private PostsCheckCache checkCache;
/* 10:   */   
/* 11:   */   public void refreshCheck()
/* 12:   */   {
/* 13:17 */     this.checkCache.refreshCheck();
/* 14:   */   }
/* 15:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.action.fnt.PostsCheckAct
 * JD-Core Version:    0.7.0.1
 */