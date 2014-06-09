/*   1:    */ package com.portal.recruitcenter.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.recruitcenter.entity.JobPost;
/*   4:    */ import com.portal.recruitcenter.entity.Resume;
/*   5:    */ import com.portal.recruitcenter.entity.ResumeApply;
/*   6:    */ import java.io.Serializable;
/*   7:    */ import java.util.Date;
/*   8:    */ 
/*   9:    */ public abstract class BaseResumeApply
/*  10:    */   implements Serializable
/*  11:    */ {
/*  12: 17 */   public static String REF = "ResumeApply";
/*  13: 18 */   public static String PROP_JOB = "job";
/*  14: 19 */   public static String PROP_RESUME = "resume";
/*  15: 20 */   public static String PROP_CREATE_TIME = "createTime";
/*  16: 21 */   public static String PROP_ID = "id";
/*  17: 22 */   public static String PROP_READ = "read";
/*  18:    */   
/*  19:    */   public BaseResumeApply()
/*  20:    */   {
/*  21: 27 */     initialize();
/*  22:    */   }
/*  23:    */   
/*  24:    */   public BaseResumeApply(Integer id)
/*  25:    */   {
/*  26: 34 */     setId(id);
/*  27: 35 */     initialize();
/*  28:    */   }
/*  29:    */   
/*  30:    */   public BaseResumeApply(Integer id, Resume resume, JobPost job, Date createTime, Boolean read)
/*  31:    */   {
/*  32: 48 */     setId(id);
/*  33: 49 */     setResume(resume);
/*  34: 50 */     setJob(job);
/*  35: 51 */     setCreateTime(createTime);
/*  36: 52 */     setRead(read);
/*  37: 53 */     initialize();
/*  38:    */   }
/*  39:    */   
/*  40: 60 */   private int hashCode = -2147483648;
/*  41:    */   private Integer id;
/*  42:    */   private Date createTime;
/*  43:    */   private Boolean read;
/*  44:    */   private Resume resume;
/*  45:    */   private JobPost job;
/*  46:    */   
/*  47:    */   protected void initialize() {}
/*  48:    */   
/*  49:    */   public Integer getId()
/*  50:    */   {
/*  51: 82 */     return this.id;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public void setId(Integer id)
/*  55:    */   {
/*  56: 90 */     this.id = id;
/*  57: 91 */     this.hashCode = -2147483648;
/*  58:    */   }
/*  59:    */   
/*  60:    */   public Date getCreateTime()
/*  61:    */   {
/*  62:101 */     return this.createTime;
/*  63:    */   }
/*  64:    */   
/*  65:    */   public void setCreateTime(Date createTime)
/*  66:    */   {
/*  67:109 */     this.createTime = createTime;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public Boolean getRead()
/*  71:    */   {
/*  72:118 */     return this.read;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public void setRead(Boolean read)
/*  76:    */   {
/*  77:126 */     this.read = read;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public Resume getResume()
/*  81:    */   {
/*  82:135 */     return this.resume;
/*  83:    */   }
/*  84:    */   
/*  85:    */   public void setResume(Resume resume)
/*  86:    */   {
/*  87:143 */     this.resume = resume;
/*  88:    */   }
/*  89:    */   
/*  90:    */   public JobPost getJob()
/*  91:    */   {
/*  92:152 */     return this.job;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public void setJob(JobPost job)
/*  96:    */   {
/*  97:160 */     this.job = job;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public boolean equals(Object obj)
/* 101:    */   {
/* 102:167 */     if (obj == null) {
/* 103:167 */       return false;
/* 104:    */     }
/* 105:168 */     if (!(obj instanceof ResumeApply)) {
/* 106:168 */       return false;
/* 107:    */     }
/* 108:170 */     ResumeApply resumeApply = (ResumeApply)obj;
/* 109:171 */     if ((getId() == null) || (resumeApply.getId() == null)) {
/* 110:171 */       return false;
/* 111:    */     }
/* 112:172 */     return getId().equals(resumeApply.getId());
/* 113:    */   }
/* 114:    */   
/* 115:    */   public int hashCode()
/* 116:    */   {
/* 117:177 */     if (-2147483648 == this.hashCode)
/* 118:    */     {
/* 119:178 */       if (getId() == null) {
/* 120:178 */         return super.hashCode();
/* 121:    */       }
/* 122:180 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 123:181 */       this.hashCode = hashStr.hashCode();
/* 124:    */     }
/* 125:184 */     return this.hashCode;
/* 126:    */   }
/* 127:    */   
/* 128:    */   public String toString()
/* 129:    */   {
/* 130:189 */     return super.toString();
/* 131:    */   }
/* 132:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.entity.base.BaseResumeApply
 * JD-Core Version:    0.7.0.1
 */