/*  1:   */ package com.portal.doccenter.entity;
/*  2:   */ 
/*  3:   */ import com.portal.doccenter.entity.base.BaseArticleExt;
/*  4:   */ import org.apache.commons.lang.StringUtils;
/*  5:   */ 
/*  6:   */ public class ArticleExt
/*  7:   */   extends BaseArticleExt
/*  8:   */ {
/*  9:   */   private static final long serialVersionUID = 1L;
/* 10:   */   
/* 11:   */   public void init()
/* 12:   */   {
/* 13:11 */     if (getShowIndex() == null) {
/* 14:12 */       setShowIndex(Boolean.valueOf(true));
/* 15:   */     }
/* 16:14 */     if (getRedTape() == null) {
/* 17:15 */       setRedTape(Boolean.valueOf(false));
/* 18:   */     }
/* 19:17 */     blankToNull();
/* 20:   */   }
/* 21:   */   
/* 22:   */   public void blankToNull()
/* 23:   */   {
/* 24:21 */     if (StringUtils.isBlank(getAuthor())) {
/* 25:22 */       setAuthor(null);
/* 26:   */     }
/* 27:24 */     if (StringUtils.isBlank(getOrigin())) {
/* 28:25 */       setOrigin(null);
/* 29:   */     }
/* 30:27 */     if (StringUtils.isBlank(getOriginUrl())) {
/* 31:28 */       setOriginUrl(null);
/* 32:   */     }
/* 33:30 */     if (StringUtils.isBlank(getDescription())) {
/* 34:31 */       setDescription(null);
/* 35:   */     }
/* 36:33 */     if (StringUtils.isBlank(getLink())) {
/* 37:34 */       setLink(null);
/* 38:   */     }
/* 39:36 */     if (StringUtils.isBlank(getTplContent())) {
/* 40:37 */       setTplContent(null);
/* 41:   */     }
/* 42:   */   }
/* 43:   */   
/* 44:   */   public ArticleExt() {}
/* 45:   */   
/* 46:   */   public ArticleExt(Integer id)
/* 47:   */   {
/* 48:50 */     super(id);
/* 49:   */   }
/* 50:   */   
/* 51:   */   public ArticleExt(Integer id, Boolean redTape)
/* 52:   */   {
/* 53:58 */     super(id, redTape);
/* 54:   */   }
/* 55:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.entity.ArticleExt
 * JD-Core Version:    0.7.0.1
 */