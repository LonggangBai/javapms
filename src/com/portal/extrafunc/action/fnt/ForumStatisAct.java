/*  1:   */ package com.portal.extrafunc.action.fnt;
/*  2:   */ 
/*  3:   */ import com.portal.extrafunc.action.cache.ForumCache;
/*  4:   */ import com.portal.extrafunc.action.cache.ForumStatisCache;
/*  5:   */ import org.springframework.beans.factory.annotation.Autowired;
/*  6:   */ 
/*  7:   */ public class ForumStatisAct
/*  8:   */ {
/*  9:   */   @Autowired
/* 10:   */   private ForumStatisCache statisCache;
/* 11:   */   @Autowired
/* 12:   */   private ForumCache forumCache;
/* 13:   */   
/* 14:   */   public void statisToDb()
/* 15:   */   {
/* 16:18 */     this.statisCache.statisToDB();
/* 17:   */   }
/* 18:   */   
/* 19:   */   public void statisOneday()
/* 20:   */   {
/* 21:22 */     this.statisCache.statisOneday();
/* 22:   */   }
/* 23:   */   
/* 24:   */   public void forumToDb()
/* 25:   */   {
/* 26:26 */     this.forumCache.statisToDB();
/* 27:   */   }
/* 28:   */   
/* 29:   */   public void forumOneday()
/* 30:   */   {
/* 31:30 */     this.forumCache.statisOneday();
/* 32:   */   }
/* 33:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.action.fnt.ForumStatisAct
 * JD-Core Version:    0.7.0.1
 */