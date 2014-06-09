/*   1:    */ package com.portal.recruitcenter.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.datacenter.commdata.entity.Industry;
/*   4:    */ import com.portal.datacenter.commdata.entity.Metier;
/*   5:    */ import com.portal.recruitcenter.entity.JobIntent;
/*   6:    */ import com.portal.recruitcenter.entity.Resume;
/*   7:    */ import java.io.Serializable;
/*   8:    */ import java.util.Date;
/*   9:    */ 
/*  10:    */ public abstract class BaseJobIntent
/*  11:    */   implements Serializable
/*  12:    */ {
/*  13: 17 */   public static String REF = "JobIntent";
/*  14: 18 */   public static String PROP_METIER = "metier";
/*  15: 19 */   public static String PROP_METIER2 = "metier2";
/*  16: 20 */   public static String PROP_RESUME = "resume";
/*  17: 21 */   public static String PROP_CREATE_TIME = "createTime";
/*  18: 22 */   public static String PROP_WAGE = "wage";
/*  19: 23 */   public static String PROP_UPDATE_TIME = "updateTime";
/*  20: 24 */   public static String PROP_ID = "id";
/*  21: 25 */   public static String PROP_WORK_PLACE = "workPlace";
/*  22: 26 */   public static String PROP_NATURE = "nature";
/*  23: 27 */   public static String PROP_INDUSTRY = "industry";
/*  24:    */   
/*  25:    */   public BaseJobIntent()
/*  26:    */   {
/*  27: 32 */     initialize();
/*  28:    */   }
/*  29:    */   
/*  30:    */   public BaseJobIntent(Integer id)
/*  31:    */   {
/*  32: 39 */     setId(id);
/*  33: 40 */     initialize();
/*  34:    */   }
/*  35:    */   
/*  36:    */   public BaseJobIntent(Integer id, Metier metier, Metier metier2, Industry industry, String workPlace, Byte wage, String nature, Date createTime)
/*  37:    */   {
/*  38: 56 */     setId(id);
/*  39: 57 */     setMetier(metier);
/*  40: 58 */     setMetier2(metier2);
/*  41: 59 */     setIndustry(industry);
/*  42: 60 */     setWorkPlace(workPlace);
/*  43: 61 */     setWage(wage);
/*  44: 62 */     setNature(nature);
/*  45: 63 */     setCreateTime(createTime);
/*  46: 64 */     initialize();
/*  47:    */   }
/*  48:    */   
/*  49: 71 */   private int hashCode = -2147483648;
/*  50:    */   private Integer id;
/*  51:    */   private String workPlace;
/*  52:    */   private Byte wage;
/*  53:    */   private String nature;
/*  54:    */   private Date createTime;
/*  55:    */   private Date updateTime;
/*  56:    */   private Resume resume;
/*  57:    */   private Metier metier;
/*  58:    */   private Metier metier2;
/*  59:    */   private Industry industry;
/*  60:    */   
/*  61:    */   protected void initialize() {}
/*  62:    */   
/*  63:    */   public Integer getId()
/*  64:    */   {
/*  65:100 */     return this.id;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public void setId(Integer id)
/*  69:    */   {
/*  70:108 */     this.id = id;
/*  71:109 */     this.hashCode = -2147483648;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public String getWorkPlace()
/*  75:    */   {
/*  76:119 */     return this.workPlace;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public void setWorkPlace(String workPlace)
/*  80:    */   {
/*  81:127 */     this.workPlace = workPlace;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public Byte getWage()
/*  85:    */   {
/*  86:136 */     return this.wage;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public void setWage(Byte wage)
/*  90:    */   {
/*  91:144 */     this.wage = wage;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public String getNature()
/*  95:    */   {
/*  96:153 */     return this.nature;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public void setNature(String nature)
/* 100:    */   {
/* 101:161 */     this.nature = nature;
/* 102:    */   }
/* 103:    */   
/* 104:    */   public Date getCreateTime()
/* 105:    */   {
/* 106:170 */     return this.createTime;
/* 107:    */   }
/* 108:    */   
/* 109:    */   public void setCreateTime(Date createTime)
/* 110:    */   {
/* 111:178 */     this.createTime = createTime;
/* 112:    */   }
/* 113:    */   
/* 114:    */   public Date getUpdateTime()
/* 115:    */   {
/* 116:187 */     return this.updateTime;
/* 117:    */   }
/* 118:    */   
/* 119:    */   public void setUpdateTime(Date updateTime)
/* 120:    */   {
/* 121:195 */     this.updateTime = updateTime;
/* 122:    */   }
/* 123:    */   
/* 124:    */   public Resume getResume()
/* 125:    */   {
/* 126:204 */     return this.resume;
/* 127:    */   }
/* 128:    */   
/* 129:    */   public void setResume(Resume resume)
/* 130:    */   {
/* 131:212 */     this.resume = resume;
/* 132:    */   }
/* 133:    */   
/* 134:    */   public Metier getMetier()
/* 135:    */   {
/* 136:221 */     return this.metier;
/* 137:    */   }
/* 138:    */   
/* 139:    */   public void setMetier(Metier metier)
/* 140:    */   {
/* 141:229 */     this.metier = metier;
/* 142:    */   }
/* 143:    */   
/* 144:    */   public Metier getMetier2()
/* 145:    */   {
/* 146:238 */     return this.metier2;
/* 147:    */   }
/* 148:    */   
/* 149:    */   public void setMetier2(Metier metier2)
/* 150:    */   {
/* 151:246 */     this.metier2 = metier2;
/* 152:    */   }
/* 153:    */   
/* 154:    */   public Industry getIndustry()
/* 155:    */   {
/* 156:255 */     return this.industry;
/* 157:    */   }
/* 158:    */   
/* 159:    */   public void setIndustry(Industry industry)
/* 160:    */   {
/* 161:263 */     this.industry = industry;
/* 162:    */   }
/* 163:    */   
/* 164:    */   public boolean equals(Object obj)
/* 165:    */   {
/* 166:270 */     if (obj == null) {
/* 167:270 */       return false;
/* 168:    */     }
/* 169:271 */     if (!(obj instanceof JobIntent)) {
/* 170:271 */       return false;
/* 171:    */     }
/* 172:273 */     JobIntent jobIntent = (JobIntent)obj;
/* 173:274 */     if ((getId() == null) || (jobIntent.getId() == null)) {
/* 174:274 */       return false;
/* 175:    */     }
/* 176:275 */     return getId().equals(jobIntent.getId());
/* 177:    */   }
/* 178:    */   
/* 179:    */   public int hashCode()
/* 180:    */   {
/* 181:280 */     if (-2147483648 == this.hashCode)
/* 182:    */     {
/* 183:281 */       if (getId() == null) {
/* 184:281 */         return super.hashCode();
/* 185:    */       }
/* 186:283 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 187:284 */       this.hashCode = hashStr.hashCode();
/* 188:    */     }
/* 189:287 */     return this.hashCode;
/* 190:    */   }
/* 191:    */   
/* 192:    */   public String toString()
/* 193:    */   {
/* 194:292 */     return super.toString();
/* 195:    */   }
/* 196:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.entity.base.BaseJobIntent
 * JD-Core Version:    0.7.0.1
 */