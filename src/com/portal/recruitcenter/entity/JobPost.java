/*   1:    */ package com.portal.recruitcenter.entity;
/*   2:    */ 
/*   3:    */ import com.portal.datacenter.commdata.entity.Metier;
/*   4:    */ import com.portal.recruitcenter.entity.base.BaseJobPost;
/*   5:    */ import java.sql.Timestamp;
/*   6:    */ import java.util.Date;
/*   7:    */ 
/*   8:    */ public class JobPost
/*   9:    */   extends BaseJobPost
/*  10:    */ {
/*  11:    */   private static final long serialVersionUID = 1L;
/*  12:    */   
/*  13:    */   public void init()
/*  14:    */   {
/*  15: 11 */     if (getRefreshTime() == null) {
/*  16: 12 */       setRefreshTime(new Timestamp(System.currentTimeMillis()));
/*  17:    */     }
/*  18: 14 */     if (getCreateTime() == null) {
/*  19: 15 */       setCreateTime(new Timestamp(System.currentTimeMillis()));
/*  20:    */     }
/*  21: 17 */     if (getCheck() == null) {
/*  22: 18 */       setCheck(Boolean.valueOf(true));
/*  23:    */     }
/*  24:    */   }
/*  25:    */   
/*  26:    */   public Byte getWage()
/*  27:    */   {
/*  28: 23 */     JobPostExt ext = getExt();
/*  29: 24 */     if (ext != null) {
/*  30: 25 */       return ext.getWage();
/*  31:    */     }
/*  32: 27 */     return null;
/*  33:    */   }
/*  34:    */   
/*  35:    */   public Byte getWorkExp()
/*  36:    */   {
/*  37: 31 */     JobPostExt ext = getExt();
/*  38: 32 */     if (ext != null) {
/*  39: 33 */       return ext.getWorkExp();
/*  40:    */     }
/*  41: 35 */     return null;
/*  42:    */   }
/*  43:    */   
/*  44:    */   public String getJobType()
/*  45:    */   {
/*  46: 39 */     JobPostExt ext = getExt();
/*  47: 40 */     if (ext != null) {
/*  48: 41 */       return ext.getJobType();
/*  49:    */     }
/*  50: 43 */     return null;
/*  51:    */   }
/*  52:    */   
/*  53:    */   public String getAppeal()
/*  54:    */   {
/*  55: 47 */     JobPostExt ext = getExt();
/*  56: 48 */     if (ext != null) {
/*  57: 49 */       return ext.getAppeal();
/*  58:    */     }
/*  59: 51 */     return null;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public String getJobNature()
/*  63:    */   {
/*  64: 55 */     JobPostExt ext = getExt();
/*  65: 56 */     if (ext != null) {
/*  66: 57 */       return ext.getJobNature();
/*  67:    */     }
/*  68: 59 */     return null;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public String getOthers()
/*  72:    */   {
/*  73: 63 */     JobPostExt ext = getExt();
/*  74: 64 */     if (ext != null) {
/*  75: 65 */       return ext.getOthers();
/*  76:    */     }
/*  77: 67 */     return null;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public Byte getOnbusiness()
/*  81:    */   {
/*  82: 71 */     JobPostExt ext = getExt();
/*  83: 72 */     if (ext != null) {
/*  84: 73 */       return ext.getOnbusiness();
/*  85:    */     }
/*  86: 75 */     return null;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public JobPost() {}
/*  90:    */   
/*  91:    */   public JobPost(Integer id)
/*  92:    */   {
/*  93: 87 */     super(id);
/*  94:    */   }
/*  95:    */   
/*  96:    */   public JobPost(Integer id, Metier metier, CompanyInfo company, String jobName, String workAddress, Byte gender, Byte educational, Integer recruitCount, Date startTime, Date endTime, Boolean check)
/*  97:    */   {
/*  98:102 */     super(id, metier, company, jobName, workAddress, gender, educational, recruitCount, startTime, endTime, check);
/*  99:    */   }
/* 100:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.entity.JobPost
 * JD-Core Version:    0.7.0.1
 */