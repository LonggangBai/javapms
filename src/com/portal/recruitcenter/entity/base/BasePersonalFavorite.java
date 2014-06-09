/*   1:    */ package com.portal.recruitcenter.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.recruitcenter.entity.JobPost;
/*   4:    */ import com.portal.recruitcenter.entity.PersonalFavorite;
/*   5:    */ import com.portal.recruitcenter.entity.PersonalInfo;
/*   6:    */ import java.io.Serializable;
/*   7:    */ import java.util.Date;
/*   8:    */ 
/*   9:    */ public abstract class BasePersonalFavorite
/*  10:    */   implements Serializable
/*  11:    */ {
/*  12: 17 */   public static String REF = "PersonalFavorite";
/*  13: 18 */   public static String PROP_JOB = "job";
/*  14: 19 */   public static String PROP_CREATE_TIME = "createTime";
/*  15: 20 */   public static String PROP_ID = "id";
/*  16: 21 */   public static String PROP_PERSONAL = "personal";
/*  17:    */   
/*  18:    */   public BasePersonalFavorite()
/*  19:    */   {
/*  20: 26 */     initialize();
/*  21:    */   }
/*  22:    */   
/*  23:    */   public BasePersonalFavorite(Integer id)
/*  24:    */   {
/*  25: 33 */     setId(id);
/*  26: 34 */     initialize();
/*  27:    */   }
/*  28:    */   
/*  29:    */   public BasePersonalFavorite(Integer id, PersonalInfo personal, JobPost job, Date createTime)
/*  30:    */   {
/*  31: 46 */     setId(id);
/*  32: 47 */     setPersonal(personal);
/*  33: 48 */     setJob(job);
/*  34: 49 */     setCreateTime(createTime);
/*  35: 50 */     initialize();
/*  36:    */   }
/*  37:    */   
/*  38: 57 */   private int hashCode = -2147483648;
/*  39:    */   private Integer id;
/*  40:    */   private Date createTime;
/*  41:    */   private PersonalInfo personal;
/*  42:    */   private JobPost job;
/*  43:    */   
/*  44:    */   protected void initialize() {}
/*  45:    */   
/*  46:    */   public Integer getId()
/*  47:    */   {
/*  48: 78 */     return this.id;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public void setId(Integer id)
/*  52:    */   {
/*  53: 86 */     this.id = id;
/*  54: 87 */     this.hashCode = -2147483648;
/*  55:    */   }
/*  56:    */   
/*  57:    */   public Date getCreateTime()
/*  58:    */   {
/*  59: 97 */     return this.createTime;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public void setCreateTime(Date createTime)
/*  63:    */   {
/*  64:105 */     this.createTime = createTime;
/*  65:    */   }
/*  66:    */   
/*  67:    */   public PersonalInfo getPersonal()
/*  68:    */   {
/*  69:114 */     return this.personal;
/*  70:    */   }
/*  71:    */   
/*  72:    */   public void setPersonal(PersonalInfo personal)
/*  73:    */   {
/*  74:122 */     this.personal = personal;
/*  75:    */   }
/*  76:    */   
/*  77:    */   public JobPost getJob()
/*  78:    */   {
/*  79:131 */     return this.job;
/*  80:    */   }
/*  81:    */   
/*  82:    */   public void setJob(JobPost job)
/*  83:    */   {
/*  84:139 */     this.job = job;
/*  85:    */   }
/*  86:    */   
/*  87:    */   public boolean equals(Object obj)
/*  88:    */   {
/*  89:146 */     if (obj == null) {
/*  90:146 */       return false;
/*  91:    */     }
/*  92:147 */     if (!(obj instanceof PersonalFavorite)) {
/*  93:147 */       return false;
/*  94:    */     }
/*  95:149 */     PersonalFavorite personalFavorite = (PersonalFavorite)obj;
/*  96:150 */     if ((getId() == null) || (personalFavorite.getId() == null)) {
/*  97:150 */       return false;
/*  98:    */     }
/*  99:151 */     return getId().equals(personalFavorite.getId());
/* 100:    */   }
/* 101:    */   
/* 102:    */   public int hashCode()
/* 103:    */   {
/* 104:156 */     if (-2147483648 == this.hashCode)
/* 105:    */     {
/* 106:157 */       if (getId() == null) {
/* 107:157 */         return super.hashCode();
/* 108:    */       }
/* 109:159 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 110:160 */       this.hashCode = hashStr.hashCode();
/* 111:    */     }
/* 112:163 */     return this.hashCode;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public String toString()
/* 116:    */   {
/* 117:168 */     return super.toString();
/* 118:    */   }
/* 119:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.entity.base.BasePersonalFavorite
 * JD-Core Version:    0.7.0.1
 */