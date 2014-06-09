/*  1:   */ package com.portal.extrafunc.entity;
/*  2:   */ 
/*  3:   */ import com.portal.extrafunc.entity.base.BaseSurveyItem;
/*  4:   */ 
/*  5:   */ public class SurveyItem
/*  6:   */   extends BaseSurveyItem
/*  7:   */ {
/*  8:   */   private static final long serialVersionUID = 1L;
/*  9:   */   
/* 10:   */   public void init()
/* 11:   */   {
/* 12: 9 */     if (getVotes() == null) {
/* 13:10 */       setVotes(Integer.valueOf(0));
/* 14:   */     }
/* 15:12 */     if (getPriority() == null) {
/* 16:13 */       setPriority(Integer.valueOf(10));
/* 17:   */     }
/* 18:   */   }
/* 19:   */   
/* 20:   */   public SurveyItem() {}
/* 21:   */   
/* 22:   */   public SurveyItem(String name, Integer votes, Integer priority)
/* 23:   */   {
/* 24:33 */     super(name, votes, priority);
/* 25:   */   }
/* 26:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.entity.SurveyItem
 * JD-Core Version:    0.7.0.1
 */