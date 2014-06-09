/*  1:   */ package com.portal.extrafunc.entity;
/*  2:   */ 
/*  3:   */ import com.portal.extrafunc.entity.base.BaseForumOperate;
/*  4:   */ import com.portal.sysmgr.entity.Site;
/*  5:   */ import com.portal.usermgr.entity.User;
/*  6:   */ import java.sql.Timestamp;
/*  7:   */ import java.util.Date;
/*  8:   */ 
/*  9:   */ public class ForumOperate
/* 10:   */   extends BaseForumOperate
/* 11:   */ {
/* 12:   */   private static final long serialVersionUID = 1L;
/* 13:   */   public static final String THEME = "THEME";
/* 14:   */   public static final String POSTS = "POSTS";
/* 15:   */   public static final String USER = "USER";
/* 16:   */   
/* 17:   */   public void init()
/* 18:   */   {
/* 19:17 */     if (getOperateTime() == null) {
/* 20:18 */       setOperateTime(new Timestamp(System.currentTimeMillis()));
/* 21:   */     }
/* 22:   */   }
/* 23:   */   
/* 24:   */   public ForumOperate() {}
/* 25:   */   
/* 26:   */   public ForumOperate(Integer id)
/* 27:   */   {
/* 28:31 */     super(id);
/* 29:   */   }
/* 30:   */   
/* 31:   */   public ForumOperate(Integer id, User admin, Site site, Integer target, String targetType, String name, Date operateTime)
/* 32:   */   {
/* 33:43 */     super(id, admin, site, target, targetType, name, operateTime);
/* 34:   */   }
/* 35:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.entity.ForumOperate
 * JD-Core Version:    0.7.0.1
 */