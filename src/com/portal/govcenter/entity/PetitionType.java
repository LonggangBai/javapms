/*  1:   */ package com.portal.govcenter.entity;
/*  2:   */ 
/*  3:   */ import com.portal.govcenter.entity.base.BasePetitionType;
/*  4:   */ import com.portal.sysmgr.entity.Site;
/*  5:   */ 
/*  6:   */ public class PetitionType
/*  7:   */   extends BasePetitionType
/*  8:   */ {
/*  9:   */   private static final long serialVersionUID = 1L;
/* 10:   */   
/* 11:   */   public PetitionType() {}
/* 12:   */   
/* 13:   */   public PetitionType(Integer id)
/* 14:   */   {
/* 15:19 */     super(id);
/* 16:   */   }
/* 17:   */   
/* 18:   */   public PetitionType(Integer id, Site site, String name, Integer priority)
/* 19:   */   {
/* 20:35 */     super(id, site, name, priority);
/* 21:   */   }
/* 22:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.govcenter.entity.PetitionType
 * JD-Core Version:    0.7.0.1
 */