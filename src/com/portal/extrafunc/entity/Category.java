/*  1:   */ package com.portal.extrafunc.entity;
/*  2:   */ 
/*  3:   */ import com.portal.extrafunc.entity.base.BaseCategory;
/*  4:   */ import com.portal.sysmgr.entity.Site;
/*  5:   */ 
/*  6:   */ public class Category
/*  7:   */   extends BaseCategory
/*  8:   */ {
/*  9:   */   private static final long serialVersionUID = 1L;
/* 10:   */   
/* 11:   */   public Category() {}
/* 12:   */   
/* 13:   */   public Category(Integer id)
/* 14:   */   {
/* 15:19 */     super(id);
/* 16:   */   }
/* 17:   */   
/* 18:   */   public Category(Integer id, Site site, String name, Integer priority)
/* 19:   */   {
/* 20:35 */     super(id, site, name, priority);
/* 21:   */   }
/* 22:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.entity.Category
 * JD-Core Version:    0.7.0.1
 */