/*  1:   */ package com.portal.govcenter.entity;
/*  2:   */ 
/*  3:   */ import com.portal.govcenter.entity.base.BasePetition;
/*  4:   */ import com.portal.sysmgr.entity.Site;
/*  5:   */ import java.util.Date;
/*  6:   */ 
/*  7:   */ public class Petition
/*  8:   */   extends BasePetition
/*  9:   */ {
/* 10:   */   private static final long serialVersionUID = 1L;
/* 11:   */   
/* 12:   */   public Petition() {}
/* 13:   */   
/* 14:   */   public Petition(Integer id)
/* 15:   */   {
/* 16:19 */     super(id);
/* 17:   */   }
/* 18:   */   
/* 19:   */   public Petition(Integer id, Site site, PetitionType type, String title, String name, String mobile, String email, Byte status, Boolean show, Date createTime)
/* 20:   */   {
/* 21:47 */     super(id, site, type, title, name, mobile, email, status, show, createTime);
/* 22:   */   }
/* 23:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.govcenter.entity.Petition
 * JD-Core Version:    0.7.0.1
 */