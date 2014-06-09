/*  1:   */ package com.portal.recruitcenter.entity;
/*  2:   */ 
/*  3:   */ import com.portal.recruitcenter.entity.base.BaseResume;
/*  4:   */ import java.sql.Timestamp;
/*  5:   */ import java.util.Date;
/*  6:   */ 
/*  7:   */ public class Resume
/*  8:   */   extends BaseResume
/*  9:   */ {
/* 10:   */   private static final long serialVersionUID = 1L;
/* 11:   */   
/* 12:   */   public void init()
/* 13:   */   {
/* 14:11 */     if (getCreateTime() == null) {
/* 15:12 */       setCreateTime(new Timestamp(System.currentTimeMillis()));
/* 16:   */     }
/* 17:14 */     if (getUpdateTime() == null) {
/* 18:15 */       setUpdateTime(new Timestamp(System.currentTimeMillis()));
/* 19:   */     }
/* 20:17 */     if (getApplyDef() == null) {
/* 21:18 */       setApplyDef(Boolean.valueOf(false));
/* 22:   */     }
/* 23:   */   }
/* 24:   */   
/* 25:   */   public Resume() {}
/* 26:   */   
/* 27:   */   public Resume(Integer id)
/* 28:   */   {
/* 29:31 */     super(id);
/* 30:   */   }
/* 31:   */   
/* 32:   */   public Resume(Integer id, PersonalInfo personal, String name, String lang, Byte open, Boolean applyDef, Date createTime)
/* 33:   */   {
/* 34:53 */     super(id, personal, name, lang, open, applyDef, createTime);
/* 35:   */   }
/* 36:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.entity.Resume
 * JD-Core Version:    0.7.0.1
 */