/*  1:   */ package com.portal.extrafunc.entity;
/*  2:   */ 
/*  3:   */ import com.portal.doccenter.entity.Article;
/*  4:   */ import com.portal.extrafunc.entity.base.BaseComment;
/*  5:   */ import com.portal.sysmgr.entity.Site;
/*  6:   */ import java.sql.Timestamp;
/*  7:   */ import java.util.Date;
/*  8:   */ import java.util.HashSet;
/*  9:   */ import java.util.Set;
/* 10:   */ 
/* 11:   */ public class Comment
/* 12:   */   extends BaseComment
/* 13:   */ {
/* 14:   */   private static final long serialVersionUID = 1L;
/* 15:   */   
/* 16:   */   public void init()
/* 17:   */   {
/* 18:13 */     if (getUps() == null) {
/* 19:14 */       setUps(Integer.valueOf(0));
/* 20:   */     }
/* 21:16 */     if (getCreateTime() == null) {
/* 22:17 */       setCreateTime(new Timestamp(System.currentTimeMillis()));
/* 23:   */     }
/* 24:19 */     if (getLastTime() == null) {
/* 25:20 */       setLastTime(new Timestamp(System.currentTimeMillis()));
/* 26:   */     }
/* 27:22 */     if (getChecked() == null) {
/* 28:23 */       setChecked(Boolean.valueOf(true));
/* 29:   */     }
/* 30:   */   }
/* 31:   */   
/* 32:   */   public void addToChilds(Comment child)
/* 33:   */   {
/* 34:28 */     Set<Comment> set = getChild();
/* 35:29 */     if (set == null)
/* 36:   */     {
/* 37:30 */       set = new HashSet();
/* 38:31 */       setChild(set);
/* 39:   */     }
/* 40:33 */     set.add(child);
/* 41:   */   }
/* 42:   */   
/* 43:   */   public String getIp()
/* 44:   */   {
/* 45:37 */     CommentExt ext = getCommentExt();
/* 46:38 */     if (ext != null) {
/* 47:39 */       return ext.getIp();
/* 48:   */     }
/* 49:41 */     return null;
/* 50:   */   }
/* 51:   */   
/* 52:   */   public String getContent()
/* 53:   */   {
/* 54:45 */     CommentExt ext = getCommentExt();
/* 55:46 */     if (ext != null) {
/* 56:47 */       return ext.getContent().trim();
/* 57:   */     }
/* 58:49 */     return null;
/* 59:   */   }
/* 60:   */   
/* 61:   */   public Comment() {}
/* 62:   */   
/* 63:   */   public Comment(Integer id)
/* 64:   */   {
/* 65:61 */     super(id);
/* 66:   */   }
/* 67:   */   
/* 68:   */   public Comment(Integer id, Article doc, Site site, Integer ups, Date createTime, Date lastTime, Boolean checked)
/* 69:   */   {
/* 70:73 */     super(id, doc, site, ups, createTime, lastTime, checked);
/* 71:   */   }
/* 72:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.entity.Comment
 * JD-Core Version:    0.7.0.1
 */