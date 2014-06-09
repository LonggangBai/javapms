/*  1:   */ package com.portal.extrafunc.entity;
/*  2:   */ 
/*  3:   */ import com.portal.extrafunc.entity.base.BaseMessageBoard;
/*  4:   */ import com.portal.sysmgr.entity.Site;
/*  5:   */ import java.sql.Timestamp;
/*  6:   */ import java.util.Date;
/*  7:   */ 
/*  8:   */ public class MessageBoard
/*  9:   */   extends BaseMessageBoard
/* 10:   */ {
/* 11:   */   private static final long serialVersionUID = 1L;
/* 12:   */   
/* 13:   */   public void init()
/* 14:   */   {
/* 15:11 */     if (getShow() == null) {
/* 16:12 */       setShow(Boolean.valueOf(true));
/* 17:   */     }
/* 18:14 */     if (getCreateTime() == null) {
/* 19:15 */       setCreateTime(new Timestamp(System.currentTimeMillis()));
/* 20:   */     }
/* 21:   */   }
/* 22:   */   
/* 23:   */   public String getContent()
/* 24:   */   {
/* 25:20 */     MessageBoardExt ext = getExt();
/* 26:21 */     if (ext != null) {
/* 27:22 */       return ext.getContent();
/* 28:   */     }
/* 29:24 */     return null;
/* 30:   */   }
/* 31:   */   
/* 32:   */   public String getReply()
/* 33:   */   {
/* 34:28 */     MessageBoardExt ext = getExt();
/* 35:29 */     if (ext != null) {
/* 36:30 */       return ext.getReply();
/* 37:   */     }
/* 38:32 */     return null;
/* 39:   */   }
/* 40:   */   
/* 41:   */   public MessageBoard() {}
/* 42:   */   
/* 43:   */   public MessageBoard(Integer id)
/* 44:   */   {
/* 45:44 */     super(id);
/* 46:   */   }
/* 47:   */   
/* 48:   */   public MessageBoard(Integer id, Site site, MessageType type, String title, String name, String mobile, String email, Boolean show, Date createTime)
/* 49:   */   {
/* 50:57 */     super(id, site, type, title, name, mobile, email, show, createTime);
/* 51:   */   }
/* 52:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.entity.MessageBoard
 * JD-Core Version:    0.7.0.1
 */