/*  1:   */ package com.portal.extrafunc.entity;
/*  2:   */ 
/*  3:   */ import com.portal.extrafunc.entity.base.BaseForumStatis;
/*  4:   */ 
/*  5:   */ public class ForumStatis
/*  6:   */   extends BaseForumStatis
/*  7:   */ {
/*  8:   */   private static final long serialVersionUID = 1L;
/*  9:   */   
/* 10:   */   public ForumStatis() {}
/* 11:   */   
/* 12:   */   public ForumStatis(Integer id)
/* 13:   */   {
/* 14:19 */     super(id);
/* 15:   */   }
/* 16:   */   
/* 17:   */   public ForumStatis(Integer id, Integer postsToday, Integer postsYestoday, Integer highestDay, Integer postsTotal)
/* 18:   */   {
/* 19:37 */     super(id, postsToday, postsYestoday, highestDay, postsTotal);
/* 20:   */   }
/* 21:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.entity.ForumStatis
 * JD-Core Version:    0.7.0.1
 */