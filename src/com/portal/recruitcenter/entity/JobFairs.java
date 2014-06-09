/*   1:    */ package com.portal.recruitcenter.entity;
/*   2:    */ 
/*   3:    */ import com.portal.recruitcenter.entity.base.BaseJobFairs;
/*   4:    */ import java.sql.Timestamp;
/*   5:    */ import java.util.Date;
/*   6:    */ 
/*   7:    */ public class JobFairs
/*   8:    */   extends BaseJobFairs
/*   9:    */ {
/*  10:    */   private static final long serialVersionUID = 1L;
/*  11:    */   
/*  12:    */   public void init()
/*  13:    */   {
/*  14: 11 */     if (getCreateTime() == null) {
/*  15: 12 */       setCreateTime(new Timestamp(System.currentTimeMillis()));
/*  16:    */     }
/*  17:    */   }
/*  18:    */   
/*  19:    */   public String getTplAddress()
/*  20:    */   {
/*  21: 17 */     JobFairsExt ext = getExt();
/*  22: 18 */     if (ext != null) {
/*  23: 19 */       return ext.getTplAddress();
/*  24:    */     }
/*  25: 21 */     return null;
/*  26:    */   }
/*  27:    */   
/*  28:    */   public String getIntroduction()
/*  29:    */   {
/*  30: 25 */     JobFairsExt ext = getExt();
/*  31: 26 */     if (ext != null) {
/*  32: 27 */       return ext.getIntroduction();
/*  33:    */     }
/*  34: 29 */     return null;
/*  35:    */   }
/*  36:    */   
/*  37:    */   public String getHostOrgan()
/*  38:    */   {
/*  39: 33 */     JobFairsExt ext = getExt();
/*  40: 34 */     if (ext != null) {
/*  41: 35 */       return ext.getHostOrgan();
/*  42:    */     }
/*  43: 37 */     return null;
/*  44:    */   }
/*  45:    */   
/*  46:    */   public String getUndertake()
/*  47:    */   {
/*  48: 41 */     JobFairsExt ext = getExt();
/*  49: 42 */     if (ext != null) {
/*  50: 43 */       return ext.getUndertake();
/*  51:    */     }
/*  52: 45 */     return null;
/*  53:    */   }
/*  54:    */   
/*  55:    */   public String getCityName()
/*  56:    */   {
/*  57: 49 */     JobFairsExt ext = getExt();
/*  58: 50 */     if (ext != null) {
/*  59: 51 */       return ext.getCityName();
/*  60:    */     }
/*  61: 53 */     return null;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public String getPlace()
/*  65:    */   {
/*  66: 57 */     JobFairsExt ext = getExt();
/*  67: 58 */     if (ext != null) {
/*  68: 59 */       return ext.getPlace();
/*  69:    */     }
/*  70: 61 */     return null;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public String getLinkMan()
/*  74:    */   {
/*  75: 65 */     JobFairsExt ext = getExt();
/*  76: 66 */     if (ext != null) {
/*  77: 67 */       return ext.getLinkMan();
/*  78:    */     }
/*  79: 69 */     return null;
/*  80:    */   }
/*  81:    */   
/*  82:    */   public String getLinkTel()
/*  83:    */   {
/*  84: 73 */     JobFairsExt ext = getExt();
/*  85: 74 */     if (ext != null) {
/*  86: 75 */       return ext.getLinkTel();
/*  87:    */     }
/*  88: 77 */     return null;
/*  89:    */   }
/*  90:    */   
/*  91:    */   public String getEmail()
/*  92:    */   {
/*  93: 81 */     JobFairsExt ext = getExt();
/*  94: 82 */     if (ext != null) {
/*  95: 83 */       return ext.getEmail();
/*  96:    */     }
/*  97: 85 */     return null;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public JobFairs() {}
/* 101:    */   
/* 102:    */   public JobFairs(Integer id)
/* 103:    */   {
/* 104: 97 */     super(id);
/* 105:    */   }
/* 106:    */   
/* 107:    */   public JobFairs(Integer id, String name, String theme, Date startTime, Date createTime)
/* 108:    */   {
/* 109:107 */     super(id, name, theme, startTime, createTime);
/* 110:    */   }
/* 111:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.entity.JobFairs
 * JD-Core Version:    0.7.0.1
 */