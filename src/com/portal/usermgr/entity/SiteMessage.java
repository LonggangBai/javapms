/*  1:   */ package com.portal.usermgr.entity;
/*  2:   */ 
/*  3:   */ import com.portal.usermgr.entity.base.BaseSiteMessage;
/*  4:   */ import java.sql.Timestamp;
/*  5:   */ import java.util.Date;
/*  6:   */ 
/*  7:   */ public class SiteMessage
/*  8:   */   extends BaseSiteMessage
/*  9:   */ {
/* 10:   */   private static final long serialVersionUID = 1L;
/* 11:   */   
/* 12:   */   public void init()
/* 13:   */   {
/* 14:11 */     if (getRead() == null) {
/* 15:12 */       setRead(Boolean.valueOf(false));
/* 16:   */     }
/* 17:14 */     if (getDeleteFrom() == null) {
/* 18:15 */       setDeleteFrom(Boolean.valueOf(false));
/* 19:   */     }
/* 20:17 */     if (getDeleteTo() == null) {
/* 21:18 */       setDeleteTo(Boolean.valueOf(false));
/* 22:   */     }
/* 23:20 */     if (getCreateTime() == null) {
/* 24:21 */       setCreateTime(new Timestamp(System.currentTimeMillis()));
/* 25:   */     }
/* 26:   */   }
/* 27:   */   
/* 28:   */   public String getTitle()
/* 29:   */   {
/* 30:26 */     SiteMessageExt ext = getExt();
/* 31:27 */     if (ext != null) {
/* 32:28 */       return ext.getTitle();
/* 33:   */     }
/* 34:30 */     return null;
/* 35:   */   }
/* 36:   */   
/* 37:   */   public String getContent()
/* 38:   */   {
/* 39:34 */     SiteMessageExt ext = getExt();
/* 40:35 */     if (ext != null) {
/* 41:36 */       return ext.getContent();
/* 42:   */     }
/* 43:38 */     return null;
/* 44:   */   }
/* 45:   */   
/* 46:   */   public SiteMessage() {}
/* 47:   */   
/* 48:   */   public SiteMessage(Integer id)
/* 49:   */   {
/* 50:50 */     super(id);
/* 51:   */   }
/* 52:   */   
/* 53:   */   public SiteMessage(Integer id, User fromUser, User toUser, Date createTime, Boolean read, Boolean deleteFrom, Boolean deleteTo)
/* 54:   */   {
/* 55:62 */     super(id, fromUser, toUser, createTime, read, deleteFrom, deleteTo);
/* 56:   */   }
/* 57:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.entity.SiteMessage
 * JD-Core Version:    0.7.0.1
 */