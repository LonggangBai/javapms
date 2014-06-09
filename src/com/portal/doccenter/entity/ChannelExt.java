/*  1:   */ package com.portal.doccenter.entity;
/*  2:   */ 
/*  3:   */ import com.portal.doccenter.entity.base.BaseChannelExt;
/*  4:   */ import org.apache.commons.lang.StringUtils;
/*  5:   */ 
/*  6:   */ public class ChannelExt
/*  7:   */   extends BaseChannelExt
/*  8:   */ {
/*  9:   */   private static final long serialVersionUID = 1L;
/* 10:   */   
/* 11:   */   public void init()
/* 12:   */   {
/* 13:11 */     if (getBlank() == null) {
/* 14:12 */       setBlank(Boolean.valueOf(false));
/* 15:   */     }
/* 16:14 */     if (getCommentControl() == null) {
/* 17:15 */       setCommentControl(Boolean.valueOf(true));
/* 18:   */     }
/* 19:17 */     if (getUpdownControl() == null) {
/* 20:18 */       setUpdownControl(Boolean.valueOf(true));
/* 21:   */     }
/* 22:20 */     blankToNull();
/* 23:   */   }
/* 24:   */   
/* 25:   */   public void blankToNull()
/* 26:   */   {
/* 27:24 */     if (StringUtils.isBlank(getLink())) {
/* 28:25 */       setLink(null);
/* 29:   */     }
/* 30:27 */     if (StringUtils.isBlank(getTplChannel())) {
/* 31:28 */       setTplChannel(null);
/* 32:   */     }
/* 33:30 */     if (StringUtils.isBlank(getTitle())) {
/* 34:31 */       setTitle(null);
/* 35:   */     }
/* 36:33 */     if (StringUtils.isBlank(getKeywords())) {
/* 37:34 */       setKeywords(null);
/* 38:   */     }
/* 39:36 */     if (StringUtils.isBlank(getDescription())) {
/* 40:37 */       setDescription(null);
/* 41:   */     }
/* 42:   */   }
/* 43:   */   
/* 44:   */   public ChannelExt() {}
/* 45:   */   
/* 46:   */   public ChannelExt(Integer id)
/* 47:   */   {
/* 48:50 */     super(id);
/* 49:   */   }
/* 50:   */   
/* 51:   */   public ChannelExt(Integer id, Boolean commentControl, Boolean blank)
/* 52:   */   {
/* 53:59 */     super(id, commentControl, blank);
/* 54:   */   }
/* 55:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.entity.ChannelExt
 * JD-Core Version:    0.7.0.1
 */