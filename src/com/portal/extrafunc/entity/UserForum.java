/*  1:   */ package com.portal.extrafunc.entity;
/*  2:   */ 
/*  3:   */ import com.portal.extrafunc.entity.base.BaseUserForum;
/*  4:   */ 
/*  5:   */ public class UserForum
/*  6:   */   extends BaseUserForum
/*  7:   */ {
/*  8:   */   private static final long serialVersionUID = 1L;
/*  9:   */   public static final int NORMAL = 0;
/* 10:   */   public static final int NOT_POSTS = -1;
/* 11:   */   public static final int SHIELD = -2;
/* 12:   */   
/* 13:   */   public void init()
/* 14:   */   {
/* 15:15 */     if (getThemeCount() == null) {
/* 16:16 */       setThemeCount(Integer.valueOf(0));
/* 17:   */     }
/* 18:18 */     if (getReplyCount() == null) {
/* 19:19 */       setReplyCount(Integer.valueOf(0));
/* 20:   */     }
/* 21:21 */     if (getPoint() == null) {
/* 22:22 */       setPoint(Integer.valueOf(0));
/* 23:   */     }
/* 24:24 */     if (getStatus() == null) {
/* 25:25 */       setStatus(Integer.valueOf(0));
/* 26:   */     }
/* 27:   */   }
/* 28:   */   
/* 29:   */   public UserForum() {}
/* 30:   */   
/* 31:   */   public UserForum(Integer id)
/* 32:   */   {
/* 33:38 */     super(id);
/* 34:   */   }
/* 35:   */   
/* 36:   */   public UserForum(Integer id, Integer essenaCount, Integer themeCount, Integer replyCount, Integer point, Integer status)
/* 37:   */   {
/* 38:48 */     super(id, essenaCount, themeCount, replyCount, point, status);
/* 39:   */   }
/* 40:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.entity.UserForum
 * JD-Core Version:    0.7.0.1
 */