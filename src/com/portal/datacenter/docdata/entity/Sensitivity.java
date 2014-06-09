/*  1:   */ package com.portal.datacenter.docdata.entity;
/*  2:   */ 
/*  3:   */ import com.portal.datacenter.docdata.entity.base.BaseSensitivity;
/*  4:   */ 
/*  5:   */ public class Sensitivity
/*  6:   */   extends BaseSensitivity
/*  7:   */ {
/*  8:   */   private static final long serialVersionUID = 1L;
/*  9:   */   
/* 10:   */   public Sensitivity() {}
/* 11:   */   
/* 12:   */   public Sensitivity(Integer id)
/* 13:   */   {
/* 14:19 */     super(id);
/* 15:   */   }
/* 16:   */   
/* 17:   */   public Sensitivity(Integer id, String search, String replacement)
/* 18:   */   {
/* 19:33 */     super(id, search, replacement);
/* 20:   */   }
/* 21:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.docdata.entity.Sensitivity
 * JD-Core Version:    0.7.0.1
 */