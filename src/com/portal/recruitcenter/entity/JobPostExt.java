/*  1:   */ package com.portal.recruitcenter.entity;
/*  2:   */ 
/*  3:   */ import com.portal.recruitcenter.entity.base.BaseJobPostExt;
/*  4:   */ import org.apache.commons.lang.StringUtils;
/*  5:   */ 
/*  6:   */ public class JobPostExt
/*  7:   */   extends BaseJobPostExt
/*  8:   */ {
/*  9:   */   private static final long serialVersionUID = 1L;
/* 10:   */   
/* 11:   */   public void init()
/* 12:   */   {
/* 13:11 */     if (StringUtils.isBlank(getJobType())) {
/* 14:12 */       setJobType("6");
/* 15:   */     }
/* 16:14 */     if (getWage() == null) {
/* 17:15 */       setWage(new Byte("0"));
/* 18:   */     }
/* 19:17 */     if (getWorkExp() == null) {
/* 20:18 */       setWorkExp(new Byte("0"));
/* 21:   */     }
/* 22:20 */     if (getOnbusiness() == null) {
/* 23:21 */       setOnbusiness(new Byte("1"));
/* 24:   */     }
/* 25:   */   }
/* 26:   */   
/* 27:   */   public JobPostExt() {}
/* 28:   */   
/* 29:   */   public JobPostExt(Integer id)
/* 30:   */   {
/* 31:34 */     super(id);
/* 32:   */   }
/* 33:   */   
/* 34:   */   public JobPostExt(Integer id, String jobType, Byte wage, Byte workExp, String appeal, Byte onbusiness)
/* 35:   */   {
/* 36:54 */     super(id, jobType, wage, workExp, appeal, onbusiness);
/* 37:   */   }
/* 38:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.entity.JobPostExt
 * JD-Core Version:    0.7.0.1
 */