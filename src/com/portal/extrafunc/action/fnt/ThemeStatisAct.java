/*  1:   */ package com.portal.extrafunc.action.fnt;
/*  2:   */ 
/*  3:   */ import com.portal.extrafunc.action.cache.ThemeStatisCache;
/*  4:   */ import org.springframework.beans.factory.annotation.Autowired;
/*  5:   */ 
/*  6:   */ public class ThemeStatisAct
/*  7:   */ {
/*  8:   */   @Autowired
/*  9:   */   private ThemeStatisCache statisCache;
/* 10:   */   
/* 11:   */   public void statisToDb()
/* 12:   */   {
/* 13:17 */     this.statisCache.statisToDB();
/* 14:   */   }
/* 15:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.action.fnt.ThemeStatisAct
 * JD-Core Version:    0.7.0.1
 */