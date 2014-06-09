/*  1:   */ package com.portal.recruitcenter.entity;
/*  2:   */ 
/*  3:   */ import com.portal.datacenter.commdata.entity.Industry;
/*  4:   */ import com.portal.datacenter.commdata.entity.Metier;
/*  5:   */ import com.portal.recruitcenter.entity.base.BaseJobIntent;
/*  6:   */ import java.sql.Timestamp;
/*  7:   */ import java.util.Date;
/*  8:   */ 
/*  9:   */ public class JobIntent
/* 10:   */   extends BaseJobIntent
/* 11:   */ {
/* 12:   */   private static final long serialVersionUID = 1L;
/* 13:   */   
/* 14:   */   public void init()
/* 15:   */   {
/* 16:11 */     if (getCreateTime() == null) {
/* 17:12 */       setCreateTime(new Timestamp(System.currentTimeMillis()));
/* 18:   */     }
/* 19:14 */     if (getUpdateTime() == null) {
/* 20:15 */       setUpdateTime(new Timestamp(System.currentTimeMillis()));
/* 21:   */     }
/* 22:   */   }
/* 23:   */   
/* 24:   */   public PersonalInfo getPersonal()
/* 25:   */   {
/* 26:20 */     return getResume().getPersonal();
/* 27:   */   }
/* 28:   */   
/* 29:   */   public JobIntent() {}
/* 30:   */   
/* 31:   */   public JobIntent(Integer id)
/* 32:   */   {
/* 33:32 */     super(id);
/* 34:   */   }
/* 35:   */   
/* 36:   */   public JobIntent(Integer id, Metier metier, Metier metier2, Industry industry, String workPlace, Byte wage, String nature, Date createTime)
/* 37:   */   {
/* 38:56 */     super(id, metier, metier2, industry, workPlace, wage, nature, createTime);
/* 39:   */   }
/* 40:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.entity.JobIntent
 * JD-Core Version:    0.7.0.1
 */