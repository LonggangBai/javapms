/*  1:   */ package com.portal.doccenter.entity;
/*  2:   */ 
/*  3:   */ import com.portal.doccenter.entity.base.BaseDocStatis;
/*  4:   */ 
/*  5:   */ public class DocStatis
/*  6:   */   extends BaseDocStatis
/*  7:   */ {
/*  8:   */   private static final long serialVersionUID = 1L;
/*  9:   */   
/* 10:   */   public void init()
/* 11:   */   {
/* 12: 9 */     if (getViewsCount() == null) {
/* 13:10 */       setViewsCount(Integer.valueOf(0));
/* 14:   */     }
/* 15:12 */     if (getCommentCount() == null) {
/* 16:13 */       setCommentCount(Integer.valueOf(0));
/* 17:   */     }
/* 18:   */   }
/* 19:   */   
/* 20:   */   public DocStatis() {}
/* 21:   */   
/* 22:   */   public DocStatis(Integer id)
/* 23:   */   {
/* 24:26 */     super(id);
/* 25:   */   }
/* 26:   */   
/* 27:   */   public DocStatis(Integer id, Integer viewsCount, Integer commentCount)
/* 28:   */   {
/* 29:35 */     super(id, viewsCount, commentCount);
/* 30:   */   }
/* 31:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.entity.DocStatis
 * JD-Core Version:    0.7.0.1
 */