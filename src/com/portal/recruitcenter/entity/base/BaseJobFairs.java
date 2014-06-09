/*   1:    */ package com.portal.recruitcenter.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.recruitcenter.entity.JobFairs;
/*   4:    */ import com.portal.recruitcenter.entity.JobFairsExt;
/*   5:    */ import java.io.Serializable;
/*   6:    */ import java.util.Date;
/*   7:    */ 
/*   8:    */ public abstract class BaseJobFairs
/*   9:    */   implements Serializable
/*  10:    */ {
/*  11: 17 */   public static String REF = "JobFairs";
/*  12: 18 */   public static String PROP_NAME = "name";
/*  13: 19 */   public static String PROP_THEME = "theme";
/*  14: 20 */   public static String PROP_EXT = "ext";
/*  15: 21 */   public static String PROP_CREATE_TIME = "createTime";
/*  16: 22 */   public static String PROP_ID = "id";
/*  17: 23 */   public static String PROP_END_TIME = "endTime";
/*  18: 24 */   public static String PROP_START_TIME = "startTime";
/*  19:    */   
/*  20:    */   public BaseJobFairs()
/*  21:    */   {
/*  22: 29 */     initialize();
/*  23:    */   }
/*  24:    */   
/*  25:    */   public BaseJobFairs(Integer id)
/*  26:    */   {
/*  27: 36 */     setId(id);
/*  28: 37 */     initialize();
/*  29:    */   }
/*  30:    */   
/*  31:    */   public BaseJobFairs(Integer id, String name, String theme, Date startTime, Date createTime)
/*  32:    */   {
/*  33: 50 */     setId(id);
/*  34: 51 */     setName(name);
/*  35: 52 */     setTheme(theme);
/*  36: 53 */     setStartTime(startTime);
/*  37: 54 */     setCreateTime(createTime);
/*  38: 55 */     initialize();
/*  39:    */   }
/*  40:    */   
/*  41: 62 */   private int hashCode = -2147483648;
/*  42:    */   private Integer id;
/*  43:    */   private String name;
/*  44:    */   private String theme;
/*  45:    */   private Date startTime;
/*  46:    */   private Date endTime;
/*  47:    */   private Date createTime;
/*  48:    */   private JobFairsExt ext;
/*  49:    */   
/*  50:    */   protected void initialize() {}
/*  51:    */   
/*  52:    */   public Integer getId()
/*  53:    */   {
/*  54: 86 */     return this.id;
/*  55:    */   }
/*  56:    */   
/*  57:    */   public void setId(Integer id)
/*  58:    */   {
/*  59: 94 */     this.id = id;
/*  60: 95 */     this.hashCode = -2147483648;
/*  61:    */   }
/*  62:    */   
/*  63:    */   public String getName()
/*  64:    */   {
/*  65:105 */     return this.name;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public void setName(String name)
/*  69:    */   {
/*  70:113 */     this.name = name;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public String getTheme()
/*  74:    */   {
/*  75:122 */     return this.theme;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public void setTheme(String theme)
/*  79:    */   {
/*  80:130 */     this.theme = theme;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public Date getStartTime()
/*  84:    */   {
/*  85:139 */     return this.startTime;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public void setStartTime(Date startTime)
/*  89:    */   {
/*  90:147 */     this.startTime = startTime;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public Date getEndTime()
/*  94:    */   {
/*  95:156 */     return this.endTime;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public void setEndTime(Date endTime)
/*  99:    */   {
/* 100:164 */     this.endTime = endTime;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public Date getCreateTime()
/* 104:    */   {
/* 105:173 */     return this.createTime;
/* 106:    */   }
/* 107:    */   
/* 108:    */   public void setCreateTime(Date createTime)
/* 109:    */   {
/* 110:181 */     this.createTime = createTime;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public JobFairsExt getExt()
/* 114:    */   {
/* 115:190 */     return this.ext;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public void setExt(JobFairsExt ext)
/* 119:    */   {
/* 120:198 */     this.ext = ext;
/* 121:    */   }
/* 122:    */   
/* 123:    */   public boolean equals(Object obj)
/* 124:    */   {
/* 125:205 */     if (obj == null) {
/* 126:205 */       return false;
/* 127:    */     }
/* 128:206 */     if (!(obj instanceof JobFairs)) {
/* 129:206 */       return false;
/* 130:    */     }
/* 131:208 */     JobFairs jobFairs = (JobFairs)obj;
/* 132:209 */     if ((getId() == null) || (jobFairs.getId() == null)) {
/* 133:209 */       return false;
/* 134:    */     }
/* 135:210 */     return getId().equals(jobFairs.getId());
/* 136:    */   }
/* 137:    */   
/* 138:    */   public int hashCode()
/* 139:    */   {
/* 140:215 */     if (-2147483648 == this.hashCode)
/* 141:    */     {
/* 142:216 */       if (getId() == null) {
/* 143:216 */         return super.hashCode();
/* 144:    */       }
/* 145:218 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 146:219 */       this.hashCode = hashStr.hashCode();
/* 147:    */     }
/* 148:222 */     return this.hashCode;
/* 149:    */   }
/* 150:    */   
/* 151:    */   public String toString()
/* 152:    */   {
/* 153:227 */     return super.toString();
/* 154:    */   }
/* 155:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.entity.base.BaseJobFairs
 * JD-Core Version:    0.7.0.1
 */