/*  1:   */ package com.portal.doccenter.action.fnt;
/*  2:   */ 
/*  3:   */ import com.portal.doccenter.action.fnt.cache.DocViewsCountCache;
/*  4:   */ import com.portal.extrafunc.action.cache.CommentUpCache;
/*  5:   */ import org.springframework.beans.factory.annotation.Autowired;
/*  6:   */ 
/*  7:   */ public class DocStatisAct
/*  8:   */ {
/*  9:   */   @Autowired
/* 10:   */   private DocViewsCountCache viewsCountCache;
/* 11:   */   @Autowired
/* 12:   */   private CommentUpCache commentUpCache;
/* 13:   */   
/* 14:   */   public void docViewsCount()
/* 15:   */   {
/* 16:18 */     this.viewsCountCache.viewsToDB();
/* 17:   */   }
/* 18:   */   
/* 19:   */   public void upsCount()
/* 20:   */   {
/* 21:22 */     this.commentUpCache.upsToDB();
/* 22:   */   }
/* 23:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.action.fnt.DocStatisAct
 * JD-Core Version:    0.7.0.1
 */