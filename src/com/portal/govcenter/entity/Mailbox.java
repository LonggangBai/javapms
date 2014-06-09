/*  1:   */ package com.portal.govcenter.entity;
/*  2:   */ 
/*  3:   */ import com.portal.govcenter.entity.base.BaseMailbox;
/*  4:   */ import com.portal.sysmgr.entity.Site;
/*  5:   */ import com.portal.usermgr.entity.Depart;
/*  6:   */ import java.sql.Timestamp;
/*  7:   */ import java.util.Date;
/*  8:   */ 
/*  9:   */ public class Mailbox
/* 10:   */   extends BaseMailbox
/* 11:   */ {
/* 12:   */   private static final long serialVersionUID = 1L;
/* 13:13 */   public static final Byte DELETED = Byte.valueOf((byte) 1);
/* 14:17 */   public static final Byte BACK = Byte.valueOf((byte)-1);
/* 15:21 */   public static final Byte DEALING = Byte.valueOf((byte)1);
/* 16:25 */   public static final Byte FORWARD = Byte.valueOf((byte)2);
/* 17:29 */   public static final Byte DEALED = Byte.valueOf((byte)3);
/* 18:   */   
/* 19:   */   public void init()
/* 20:   */   {
/* 21:32 */     if (getStatus() == null) {
/* 22:33 */       setStatus(DEALING);
/* 23:   */     }
/* 24:35 */     if (getShow() == null) {
/* 25:36 */       setShow(Boolean.valueOf(false));
/* 26:   */     }
/* 27:38 */     if (getCreateTime() == null) {
/* 28:39 */       setCreateTime(new Timestamp(System.currentTimeMillis()));
/* 29:   */     }
/* 30:   */   }
/* 31:   */   
/* 32:   */   public String getStatusString()
/* 33:   */   {
/* 34:44 */     if (getStatus().equals(DEALING)) {
/* 35:45 */       return "<span style='color:red'>受理中</span>";
/* 36:   */     }
/* 37:46 */     if (getStatus().equals(DEALED)) {
/* 38:47 */       return "<span style='color:blue'>已办结</span>";
/* 39:   */     }
/* 40:48 */     if (getStatus().equals(FORWARD)) {
/* 41:49 */       return "<span style='color:red'>批转</span>";
/* 42:   */     }
/* 43:50 */     if (getStatus().equals(BACK)) {
/* 44:51 */       return "<span style='color:red'>退回</span>";
/* 45:   */     }
/* 46:53 */     return "<span style='color:red'>已删除</span>";
/* 47:   */   }
/* 48:   */   
/* 49:   */   public String getContent()
/* 50:   */   {
/* 51:58 */     if (getExt() != null) {
/* 52:59 */       return getExt().getContent();
/* 53:   */     }
/* 54:61 */     return null;
/* 55:   */   }
/* 56:   */   
/* 57:   */   public String getReply()
/* 58:   */   {
/* 59:65 */     if (getExt() != null) {
/* 60:66 */       return getExt().getReply();
/* 61:   */     }
/* 62:68 */     return null;
/* 63:   */   }
/* 64:   */   
/* 65:   */   public Mailbox() {}
/* 66:   */   
/* 67:   */   public Mailbox(Integer id)
/* 68:   */   {
/* 69:80 */     super(id);
/* 70:   */   }
/* 71:   */   
/* 72:   */   public Mailbox(Integer id, Site site, Depart depart, MailboxType type, String title, String name, String mobile, String email, Byte status, Boolean show, Date createTime)
/* 73:   */   {
/* 74:95 */     super(id, site, depart, type, title, name, mobile, email, status, show, createTime);
/* 75:   */   }
/* 76:   */ }



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.portal.govcenter.entity.Mailbox

 * JD-Core Version:    0.7.0.1

 */