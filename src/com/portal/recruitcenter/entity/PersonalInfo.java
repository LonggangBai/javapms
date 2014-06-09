/*   1:    */ package com.portal.recruitcenter.entity;
/*   2:    */ 
/*   3:    */ import com.portal.recruitcenter.entity.base.BasePersonalInfo;
/*   4:    */ import java.util.Date;
/*   5:    */ 
/*   6:    */ public class PersonalInfo
/*   7:    */   extends BasePersonalInfo
/*   8:    */ {
/*   9:    */   private static final long serialVersionUID = 1L;
/*  10:    */   
/*  11:    */   public void init()
/*  12:    */   {
/*  13:  9 */     if (getWork() == null) {
/*  14: 10 */       setWork(Boolean.valueOf(false));
/*  15:    */     }
/*  16: 12 */     if (getCheck() == null) {
/*  17: 13 */       setCheck(Boolean.valueOf(true));
/*  18:    */     }
/*  19: 15 */     if (getCommend() == null) {
/*  20: 16 */       setCommend(Boolean.valueOf(false));
/*  21:    */     }
/*  22:    */   }
/*  23:    */   
/*  24:    */   public Long getAge()
/*  25:    */   {
/*  26: 21 */     if (getBirthday() == null) {
/*  27: 22 */       return null;
/*  28:    */     }
/*  29: 24 */     long d = System.currentTimeMillis() - getBirthday().getTime();
/*  30: 25 */     long year = d / 86400000L;
/*  31: 26 */     year /= 365L;
/*  32: 27 */     return Long.valueOf(year);
/*  33:    */   }
/*  34:    */   
/*  35:    */   public Byte getCardType()
/*  36:    */   {
/*  37: 31 */     PersonalInfoExt ext = getExt();
/*  38: 32 */     if (ext != null) {
/*  39: 33 */       return ext.getCardType();
/*  40:    */     }
/*  41: 35 */     return null;
/*  42:    */   }
/*  43:    */   
/*  44:    */   public String getIdcard()
/*  45:    */   {
/*  46: 39 */     PersonalInfoExt ext = getExt();
/*  47: 40 */     if (ext != null) {
/*  48: 41 */       return ext.getIdcard();
/*  49:    */     }
/*  50: 43 */     return null;
/*  51:    */   }
/*  52:    */   
/*  53:    */   public String getAddress()
/*  54:    */   {
/*  55: 47 */     PersonalInfoExt ext = getExt();
/*  56: 48 */     if (ext != null) {
/*  57: 49 */       return ext.getAddress();
/*  58:    */     }
/*  59: 51 */     return null;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public Byte getCommunType1()
/*  63:    */   {
/*  64: 55 */     PersonalInfoExt ext = getExt();
/*  65: 56 */     if (ext != null) {
/*  66: 57 */       return ext.getCommunType1();
/*  67:    */     }
/*  68: 59 */     return null;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public String getCommun1()
/*  72:    */   {
/*  73: 63 */     PersonalInfoExt ext = getExt();
/*  74: 64 */     if (ext != null) {
/*  75: 65 */       return ext.getCommun1();
/*  76:    */     }
/*  77: 67 */     return null;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public Byte getCommunType2()
/*  81:    */   {
/*  82: 71 */     PersonalInfoExt ext = getExt();
/*  83: 72 */     if (ext != null) {
/*  84: 73 */       return ext.getCommunType2();
/*  85:    */     }
/*  86: 75 */     return null;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public String getCommun2()
/*  90:    */   {
/*  91: 79 */     PersonalInfoExt ext = getExt();
/*  92: 80 */     if (ext != null) {
/*  93: 81 */       return ext.getCommun2();
/*  94:    */     }
/*  95: 83 */     return null;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public Boolean getMarriage()
/*  99:    */   {
/* 100: 87 */     PersonalInfoExt ext = getExt();
/* 101: 88 */     if (ext != null) {
/* 102: 89 */       return ext.getMarriage();
/* 103:    */     }
/* 104: 91 */     return null;
/* 105:    */   }
/* 106:    */   
/* 107:    */   public String getPolitical()
/* 108:    */   {
/* 109: 95 */     PersonalInfoExt ext = getExt();
/* 110: 96 */     if (ext != null) {
/* 111: 97 */       return ext.getPolitical();
/* 112:    */     }
/* 113: 99 */     return null;
/* 114:    */   }
/* 115:    */   
/* 116:    */   public String getNation()
/* 117:    */   {
/* 118:103 */     PersonalInfoExt ext = getExt();
/* 119:104 */     if (ext != null) {
/* 120:105 */       return ext.getNation();
/* 121:    */     }
/* 122:107 */     return null;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public PersonalInfo() {}
/* 126:    */   
/* 127:    */   public PersonalInfo(Integer id)
/* 128:    */   {
/* 129:119 */     super(id);
/* 130:    */   }
/* 131:    */   
/* 132:    */   public PersonalInfo(Integer id, Byte workExp, Boolean work, Boolean check, Boolean commend)
/* 133:    */   {
/* 134:137 */     super(id, workExp, work, check, commend);
/* 135:    */   }
/* 136:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.entity.PersonalInfo
 * JD-Core Version:    0.7.0.1
 */