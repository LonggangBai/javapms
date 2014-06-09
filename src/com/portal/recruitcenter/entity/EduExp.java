/*  1:   */ package com.portal.recruitcenter.entity;
/*  2:   */ 
/*  3:   */ import com.portal.datacenter.commdata.entity.Specialty;
/*  4:   */ import com.portal.recruitcenter.entity.base.BaseEduExp;
/*  5:   */ import java.sql.Timestamp;
/*  6:   */ import java.util.Date;
/*  7:   */ 
/*  8:   */ public class EduExp
/*  9:   */   extends BaseEduExp
/* 10:   */ {
/* 11:   */   private static final long serialVersionUID = 1L;
/* 12:   */   
/* 13:   */   public void init()
/* 14:   */   {
/* 15:11 */     if (getCreateTime() == null) {
/* 16:12 */       setCreateTime(new Timestamp(System.currentTimeMillis()));
/* 17:   */     }
/* 18:   */   }
/* 19:   */   
/* 20:   */   public EduExp() {}
/* 21:   */   
/* 22:   */   public EduExp(Integer id)
/* 23:   */   {
/* 24:25 */     super(id);
/* 25:   */   }
/* 26:   */   
/* 27:   */   public EduExp(Integer id, Resume resume, Specialty special, String startTime, String endTime, String school, Byte educational, Boolean oversea, Date createTime)
/* 28:   */   {
/* 29:39 */     super(id, resume, special, startTime, endTime, school, educational, oversea, createTime);
/* 30:   */   }
/* 31:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.entity.EduExp
 * JD-Core Version:    0.7.0.1
 */