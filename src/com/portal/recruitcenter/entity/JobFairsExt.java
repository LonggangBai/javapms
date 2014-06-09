/*  1:   */ package com.portal.recruitcenter.entity;
/*  2:   */ 
/*  3:   */ import com.portal.recruitcenter.entity.base.BaseJobFairsExt;
/*  4:   */ 
/*  5:   */ public class JobFairsExt
/*  6:   */   extends BaseJobFairsExt
/*  7:   */ {
/*  8:   */   private static final long serialVersionUID = 1L;
/*  9:   */   
/* 10:   */   public JobFairsExt() {}
/* 11:   */   
/* 12:   */   public JobFairsExt(Integer id)
/* 13:   */   {
/* 14:19 */     super(id);
/* 15:   */   }
/* 16:   */   
/* 17:   */   public JobFairsExt(Integer id, String introduction, String hostOrgan, String cityName, String place, String linkMan, String linkTel, String email)
/* 18:   */   {
/* 19:43 */     super(id, introduction, hostOrgan, cityName, place, linkMan, linkTel, email);
/* 20:   */   }
/* 21:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.entity.JobFairsExt
 * JD-Core Version:    0.7.0.1
 */