/*   1:    */ package com.portal.recruitcenter.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.recruitcenter.entity.JobPost;
/*   4:    */ import com.portal.recruitcenter.entity.JobPostExt;
/*   5:    */ import java.io.Serializable;
/*   6:    */ 
/*   7:    */ public abstract class BaseJobPostExt
/*   8:    */   implements Serializable
/*   9:    */ {
/*  10: 17 */   public static String REF = "JobPostExt";
/*  11: 18 */   public static String PROP_JOB_TYPE = "jobType";
/*  12: 19 */   public static String PROP_APPEAL = "appeal";
/*  13: 20 */   public static String PROP_JOB_POST = "jobPost";
/*  14: 21 */   public static String PROP_OTHERS = "others";
/*  15: 22 */   public static String PROP_ONBUSINESS = "onbusiness";
/*  16: 23 */   public static String PROP_JOB_NATURE = "jobNature";
/*  17: 24 */   public static String PROP_WORK_EXP = "workExp";
/*  18: 25 */   public static String PROP_WAGE = "wage";
/*  19: 26 */   public static String PROP_ID = "id";
/*  20:    */   
/*  21:    */   public BaseJobPostExt()
/*  22:    */   {
/*  23: 31 */     initialize();
/*  24:    */   }
/*  25:    */   
/*  26:    */   public BaseJobPostExt(Integer id)
/*  27:    */   {
/*  28: 38 */     setId(id);
/*  29: 39 */     initialize();
/*  30:    */   }
/*  31:    */   
/*  32:    */   public BaseJobPostExt(Integer id, String jobType, Byte wage, Byte workExp, String appeal, Byte onbusiness)
/*  33:    */   {
/*  34: 53 */     setId(id);
/*  35: 54 */     setJobType(jobType);
/*  36: 55 */     setWage(wage);
/*  37: 56 */     setWorkExp(workExp);
/*  38: 57 */     setAppeal(appeal);
/*  39: 58 */     setOnbusiness(onbusiness);
/*  40: 59 */     initialize();
/*  41:    */   }
/*  42:    */   
/*  43: 66 */   private int hashCode = -2147483648;
/*  44:    */   private Integer id;
/*  45:    */   private String jobType;
/*  46:    */   private Byte wage;
/*  47:    */   private Byte workExp;
/*  48:    */   private String appeal;
/*  49:    */   private String jobNature;
/*  50:    */   private String others;
/*  51:    */   private Byte onbusiness;
/*  52:    */   private JobPost jobPost;
/*  53:    */   
/*  54:    */   protected void initialize() {}
/*  55:    */   
/*  56:    */   public Integer getId()
/*  57:    */   {
/*  58: 92 */     return this.id;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public void setId(Integer id)
/*  62:    */   {
/*  63:100 */     this.id = id;
/*  64:101 */     this.hashCode = -2147483648;
/*  65:    */   }
/*  66:    */   
/*  67:    */   public String getJobType()
/*  68:    */   {
/*  69:111 */     return this.jobType;
/*  70:    */   }
/*  71:    */   
/*  72:    */   public void setJobType(String jobType)
/*  73:    */   {
/*  74:119 */     this.jobType = jobType;
/*  75:    */   }
/*  76:    */   
/*  77:    */   public Byte getWage()
/*  78:    */   {
/*  79:128 */     return this.wage;
/*  80:    */   }
/*  81:    */   
/*  82:    */   public void setWage(Byte wage)
/*  83:    */   {
/*  84:136 */     this.wage = wage;
/*  85:    */   }
/*  86:    */   
/*  87:    */   public Byte getWorkExp()
/*  88:    */   {
/*  89:145 */     return this.workExp;
/*  90:    */   }
/*  91:    */   
/*  92:    */   public void setWorkExp(Byte workExp)
/*  93:    */   {
/*  94:153 */     this.workExp = workExp;
/*  95:    */   }
/*  96:    */   
/*  97:    */   public String getAppeal()
/*  98:    */   {
/*  99:162 */     return this.appeal;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public void setAppeal(String appeal)
/* 103:    */   {
/* 104:170 */     this.appeal = appeal;
/* 105:    */   }
/* 106:    */   
/* 107:    */   public String getJobNature()
/* 108:    */   {
/* 109:179 */     return this.jobNature;
/* 110:    */   }
/* 111:    */   
/* 112:    */   public void setJobNature(String jobNature)
/* 113:    */   {
/* 114:187 */     this.jobNature = jobNature;
/* 115:    */   }
/* 116:    */   
/* 117:    */   public String getOthers()
/* 118:    */   {
/* 119:196 */     return this.others;
/* 120:    */   }
/* 121:    */   
/* 122:    */   public void setOthers(String others)
/* 123:    */   {
/* 124:204 */     this.others = others;
/* 125:    */   }
/* 126:    */   
/* 127:    */   public Byte getOnbusiness()
/* 128:    */   {
/* 129:213 */     return this.onbusiness;
/* 130:    */   }
/* 131:    */   
/* 132:    */   public void setOnbusiness(Byte onbusiness)
/* 133:    */   {
/* 134:221 */     this.onbusiness = onbusiness;
/* 135:    */   }
/* 136:    */   
/* 137:    */   public JobPost getJobPost()
/* 138:    */   {
/* 139:230 */     return this.jobPost;
/* 140:    */   }
/* 141:    */   
/* 142:    */   public void setJobPost(JobPost jobPost)
/* 143:    */   {
/* 144:238 */     this.jobPost = jobPost;
/* 145:    */   }
/* 146:    */   
/* 147:    */   public boolean equals(Object obj)
/* 148:    */   {
/* 149:245 */     if (obj == null) {
/* 150:245 */       return false;
/* 151:    */     }
/* 152:246 */     if (!(obj instanceof JobPostExt)) {
/* 153:246 */       return false;
/* 154:    */     }
/* 155:248 */     JobPostExt jobPostExt = (JobPostExt)obj;
/* 156:249 */     if ((getId() == null) || (jobPostExt.getId() == null)) {
/* 157:249 */       return false;
/* 158:    */     }
/* 159:250 */     return getId().equals(jobPostExt.getId());
/* 160:    */   }
/* 161:    */   
/* 162:    */   public int hashCode()
/* 163:    */   {
/* 164:255 */     if (-2147483648 == this.hashCode)
/* 165:    */     {
/* 166:256 */       if (getId() == null) {
/* 167:256 */         return super.hashCode();
/* 168:    */       }
/* 169:258 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 170:259 */       this.hashCode = hashStr.hashCode();
/* 171:    */     }
/* 172:262 */     return this.hashCode;
/* 173:    */   }
/* 174:    */   
/* 175:    */   public String toString()
/* 176:    */   {
/* 177:267 */     return super.toString();
/* 178:    */   }
/* 179:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.entity.base.BaseJobPostExt
 * JD-Core Version:    0.7.0.1
 */