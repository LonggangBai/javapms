/*  1:   */ package com.portal.recruitcenter.entity;
/*  2:   */ 
/*  3:   */ import com.portal.recruitcenter.entity.base.BasePersonalFavorite;
/*  4:   */ import java.util.Date;
/*  5:   */ 
/*  6:   */ public class PersonalFavorite
/*  7:   */   extends BasePersonalFavorite
/*  8:   */ {
/*  9:   */   private static final long serialVersionUID = 1L;
/* 10:   */   
/* 11:   */   public PersonalFavorite() {}
/* 12:   */   
/* 13:   */   public PersonalFavorite(Integer id)
/* 14:   */   {
/* 15:19 */     super(id);
/* 16:   */   }
/* 17:   */   
/* 18:   */   public PersonalFavorite(Integer id, PersonalInfo personal, JobPost job, Date createTime)
/* 19:   */   {
/* 20:35 */     super(id, personal, job, createTime);
/* 21:   */   }
/* 22:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.entity.PersonalFavorite
 * JD-Core Version:    0.7.0.1
 */