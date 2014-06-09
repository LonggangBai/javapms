/*   1:    */ package com.portal.recruitcenter.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.recruitcenter.entity.JobFairs;
/*   4:    */ import com.portal.recruitcenter.entity.JobFairsExt;
/*   5:    */ import java.io.Serializable;
/*   6:    */ 
/*   7:    */ public abstract class BaseJobFairsExt
/*   8:    */   implements Serializable
/*   9:    */ {
/*  10: 17 */   public static String REF = "JobFairsExt";
/*  11: 18 */   public static String PROP_PLACE = "place";
/*  12: 19 */   public static String PROP_EMAIL = "email";
/*  13: 20 */   public static String PROP_INTRODUCTION = "introduction";
/*  14: 21 */   public static String PROP_LINK_TEL = "linkTel";
/*  15: 22 */   public static String PROP_CITY_NAME = "cityName";
/*  16: 23 */   public static String PROP_TPL_ADDRESS = "tplAddress";
/*  17: 24 */   public static String PROP_HOST_ORGAN = "hostOrgan";
/*  18: 25 */   public static String PROP_ID = "id";
/*  19: 26 */   public static String PROP_UNDERTAKE = "undertake";
/*  20: 27 */   public static String PROP_LINK_MAN = "linkMan";
/*  21: 28 */   public static String PROP_JOB_FAIRS = "jobFairs";
/*  22:    */   
/*  23:    */   public BaseJobFairsExt()
/*  24:    */   {
/*  25: 33 */     initialize();
/*  26:    */   }
/*  27:    */   
/*  28:    */   public BaseJobFairsExt(Integer id)
/*  29:    */   {
/*  30: 40 */     setId(id);
/*  31: 41 */     initialize();
/*  32:    */   }
/*  33:    */   
/*  34:    */   public BaseJobFairsExt(Integer id, String introduction, String hostOrgan, String cityName, String place, String linkMan, String linkTel, String email)
/*  35:    */   {
/*  36: 57 */     setId(id);
/*  37: 58 */     setIntroduction(introduction);
/*  38: 59 */     setHostOrgan(hostOrgan);
/*  39: 60 */     setCityName(cityName);
/*  40: 61 */     setPlace(place);
/*  41: 62 */     setLinkMan(linkMan);
/*  42: 63 */     setLinkTel(linkTel);
/*  43: 64 */     setEmail(email);
/*  44: 65 */     initialize();
/*  45:    */   }
/*  46:    */   
/*  47: 72 */   private int hashCode = -2147483648;
/*  48:    */   private Integer id;
/*  49:    */   private String tplAddress;
/*  50:    */   private String introduction;
/*  51:    */   private String hostOrgan;
/*  52:    */   private String undertake;
/*  53:    */   private String cityName;
/*  54:    */   private String place;
/*  55:    */   private String linkMan;
/*  56:    */   private String linkTel;
/*  57:    */   private String email;
/*  58:    */   private JobFairs jobFairs;
/*  59:    */   
/*  60:    */   protected void initialize() {}
/*  61:    */   
/*  62:    */   public Integer getId()
/*  63:    */   {
/*  64:100 */     return this.id;
/*  65:    */   }
/*  66:    */   
/*  67:    */   public void setId(Integer id)
/*  68:    */   {
/*  69:108 */     this.id = id;
/*  70:109 */     this.hashCode = -2147483648;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public String getTplAddress()
/*  74:    */   {
/*  75:119 */     return this.tplAddress;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public void setTplAddress(String tplAddress)
/*  79:    */   {
/*  80:127 */     this.tplAddress = tplAddress;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public String getIntroduction()
/*  84:    */   {
/*  85:136 */     return this.introduction;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public void setIntroduction(String introduction)
/*  89:    */   {
/*  90:144 */     this.introduction = introduction;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public String getHostOrgan()
/*  94:    */   {
/*  95:153 */     return this.hostOrgan;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public void setHostOrgan(String hostOrgan)
/*  99:    */   {
/* 100:161 */     this.hostOrgan = hostOrgan;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public String getUndertake()
/* 104:    */   {
/* 105:170 */     return this.undertake;
/* 106:    */   }
/* 107:    */   
/* 108:    */   public void setUndertake(String undertake)
/* 109:    */   {
/* 110:178 */     this.undertake = undertake;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public String getCityName()
/* 114:    */   {
/* 115:187 */     return this.cityName;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public void setCityName(String cityName)
/* 119:    */   {
/* 120:195 */     this.cityName = cityName;
/* 121:    */   }
/* 122:    */   
/* 123:    */   public String getPlace()
/* 124:    */   {
/* 125:204 */     return this.place;
/* 126:    */   }
/* 127:    */   
/* 128:    */   public void setPlace(String place)
/* 129:    */   {
/* 130:212 */     this.place = place;
/* 131:    */   }
/* 132:    */   
/* 133:    */   public String getLinkMan()
/* 134:    */   {
/* 135:221 */     return this.linkMan;
/* 136:    */   }
/* 137:    */   
/* 138:    */   public void setLinkMan(String linkMan)
/* 139:    */   {
/* 140:229 */     this.linkMan = linkMan;
/* 141:    */   }
/* 142:    */   
/* 143:    */   public String getLinkTel()
/* 144:    */   {
/* 145:238 */     return this.linkTel;
/* 146:    */   }
/* 147:    */   
/* 148:    */   public void setLinkTel(String linkTel)
/* 149:    */   {
/* 150:246 */     this.linkTel = linkTel;
/* 151:    */   }
/* 152:    */   
/* 153:    */   public String getEmail()
/* 154:    */   {
/* 155:255 */     return this.email;
/* 156:    */   }
/* 157:    */   
/* 158:    */   public void setEmail(String email)
/* 159:    */   {
/* 160:263 */     this.email = email;
/* 161:    */   }
/* 162:    */   
/* 163:    */   public JobFairs getJobFairs()
/* 164:    */   {
/* 165:272 */     return this.jobFairs;
/* 166:    */   }
/* 167:    */   
/* 168:    */   public void setJobFairs(JobFairs jobFairs)
/* 169:    */   {
/* 170:280 */     this.jobFairs = jobFairs;
/* 171:    */   }
/* 172:    */   
/* 173:    */   public boolean equals(Object obj)
/* 174:    */   {
/* 175:287 */     if (obj == null) {
/* 176:287 */       return false;
/* 177:    */     }
/* 178:288 */     if (!(obj instanceof JobFairsExt)) {
/* 179:288 */       return false;
/* 180:    */     }
/* 181:290 */     JobFairsExt jobFairsExt = (JobFairsExt)obj;
/* 182:291 */     if ((getId() == null) || (jobFairsExt.getId() == null)) {
/* 183:291 */       return false;
/* 184:    */     }
/* 185:292 */     return getId().equals(jobFairsExt.getId());
/* 186:    */   }
/* 187:    */   
/* 188:    */   public int hashCode()
/* 189:    */   {
/* 190:297 */     if (-2147483648 == this.hashCode)
/* 191:    */     {
/* 192:298 */       if (getId() == null) {
/* 193:298 */         return super.hashCode();
/* 194:    */       }
/* 195:300 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 196:301 */       this.hashCode = hashStr.hashCode();
/* 197:    */     }
/* 198:304 */     return this.hashCode;
/* 199:    */   }
/* 200:    */   
/* 201:    */   public String toString()
/* 202:    */   {
/* 203:309 */     return super.toString();
/* 204:    */   }
/* 205:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.entity.base.BaseJobFairsExt
 * JD-Core Version:    0.7.0.1
 */