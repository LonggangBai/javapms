/*  1:   */ package com.portal.datacenter.docdata.entity;
/*  2:   */ 
/*  3:   */ import com.portal.datacenter.docdata.entity.base.BaseKeyword;
/*  4:   */ 
/*  5:   */ public class Keyword
/*  6:   */   extends BaseKeyword
/*  7:   */ {
/*  8:   */   private static final long serialVersionUID = 1L;
/*  9:   */   
/* 10:   */   public void init()
/* 11:   */   {
/* 12: 9 */     if (getEnable() == null) {
/* 13:10 */       setEnable(Boolean.valueOf(true));
/* 14:   */     }
/* 15:12 */     if (getBold() == null) {
/* 16:13 */       setBold(Boolean.valueOf(true));
/* 17:   */     }
/* 18:15 */     if (getUnderline() == null) {
/* 19:16 */       setUnderline(Boolean.valueOf(true));
/* 20:   */     }
/* 21:   */   }
/* 22:   */   
/* 23:   */   public Keyword() {}
/* 24:   */   
/* 25:   */   public Keyword(Integer id)
/* 26:   */   {
/* 27:29 */     super(id);
/* 28:   */   }
/* 29:   */   
/* 30:   */   public Keyword(Integer id, String name, String url, Boolean bold, Boolean underline, Boolean enable)
/* 31:   */   {
/* 32:39 */     super(id, name, url, bold, underline, enable);
/* 33:   */   }
/* 34:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.docdata.entity.Keyword
 * JD-Core Version:    0.7.0.1
 */