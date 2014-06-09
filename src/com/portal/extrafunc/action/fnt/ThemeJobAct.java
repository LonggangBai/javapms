/*  1:   */ package com.portal.extrafunc.action.fnt;
/*  2:   */ 
/*  3:   */ import com.portal.extrafunc.service.ThemeService;
/*  4:   */ import org.springframework.beans.factory.annotation.Autowired;
/*  5:   */ 
/*  6:   */ public class ThemeJobAct
/*  7:   */ {
/*  8:   */   @Autowired
/*  9:   */   private ThemeService themeService;
/* 10:   */   
/* 11:   */   public void themeStatusCheck()
/* 12:   */   {
/* 13:17 */     this.themeService.themeTopCheck();
/* 14:18 */     this.themeService.themeLightCheck();
/* 15:19 */     this.themeService.themeLockCheck();
/* 16:   */   }
/* 17:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.action.fnt.ThemeJobAct
 * JD-Core Version:    0.7.0.1
 */