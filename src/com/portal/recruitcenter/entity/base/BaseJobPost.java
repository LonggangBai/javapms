/*   1:    */ package com.portal.recruitcenter.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.datacenter.commdata.entity.Metier;
/*   4:    */ import com.portal.recruitcenter.entity.CompanyInfo;
/*   5:    */ import com.portal.recruitcenter.entity.JobPost;
/*   6:    */ import com.portal.recruitcenter.entity.JobPostExt;
/*   7:    */ import java.io.Serializable;
/*   8:    */ import java.util.Date;
/*   9:    */ 
/*  10:    */ public abstract class BaseJobPost
/*  11:    */   implements Serializable
/*  12:    */ {
/*  13: 17 */   public static String REF = "JobPost";
/*  14: 18 */   public static String PROP_CHECK = "check";
/*  15: 19 */   public static String PROP_MIN_AGE = "minAge";
/*  16: 20 */   public static String PROP_EDUCATIONAL = "educational";
/*  17: 21 */   public static String PROP_JOB_NAME = "jobName";
/*  18: 22 */   public static String PROP_WORK_ADDRESS = "workAddress";
/*  19: 23 */   public static String PROP_MAX_AGE = "maxAge";
/*  20: 24 */   public static String PROP_METIER = "metier";
/*  21: 25 */   public static String PROP_REFRESH_TIME = "refreshTime";
/*  22: 26 */   public static String PROP_EXT = "ext";
/*  23: 27 */   public static String PROP_GENDER = "gender";
/*  24: 28 */   public static String PROP_CREATE_TIME = "createTime";
/*  25: 29 */   public static String PROP_ID = "id";
/*  26: 30 */   public static String PROP_END_TIME = "endTime";
/*  27: 31 */   public static String PROP_RECRUIT_COUNT = "recruitCount";
/*  28: 32 */   public static String PROP_START_TIME = "startTime";
/*  29: 33 */   public static String PROP_COMPANY = "company";
/*  30:    */   
/*  31:    */   public BaseJobPost()
/*  32:    */   {
/*  33: 38 */     initialize();
/*  34:    */   }
/*  35:    */   
/*  36:    */   public BaseJobPost(Integer id)
/*  37:    */   {
/*  38: 45 */     setId(id);
/*  39: 46 */     initialize();
/*  40:    */   }
/*  41:    */   
/*  42:    */   public BaseJobPost(Integer id, Metier metier, CompanyInfo company, String jobName, String workAddress, Byte gender, Byte educational, Integer recruitCount, Date startTime, Date endTime, Boolean check)
/*  43:    */   {
/*  44: 65 */     setId(id);
/*  45: 66 */     setMetier(metier);
/*  46: 67 */     setCompany(company);
/*  47: 68 */     setJobName(jobName);
/*  48: 69 */     setWorkAddress(workAddress);
/*  49: 70 */     setGender(gender);
/*  50: 71 */     setEducational(educational);
/*  51: 72 */     setRecruitCount(recruitCount);
/*  52: 73 */     setStartTime(startTime);
/*  53: 74 */     setEndTime(endTime);
/*  54: 75 */     setCheck(check);
/*  55: 76 */     initialize();
/*  56:    */   }
/*  57:    */   
/*  58: 83 */   private int hashCode = -2147483648;
/*  59:    */   private Integer id;
/*  60:    */   private String jobName;
/*  61:    */   private String workAddress;
/*  62:    */   private Byte gender;
/*  63:    */   private Integer minAge;
/*  64:    */   private Integer maxAge;
/*  65:    */   private Byte educational;
/*  66:    */   private Integer recruitCount;
/*  67:    */   private Date startTime;
/*  68:    */   private Date endTime;
/*  69:    */   private Date refreshTime;
/*  70:    */   private Date createTime;
/*  71:    */   private Boolean check;
/*  72:    */   private JobPostExt ext;
/*  73:    */   private Metier metier;
/*  74:    */   private CompanyInfo company;
/*  75:    */   
/*  76:    */   protected void initialize() {}
/*  77:    */   
/*  78:    */   public Integer getId()
/*  79:    */   {
/*  80:118 */     return this.id;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public void setId(Integer id)
/*  84:    */   {
/*  85:126 */     this.id = id;
/*  86:127 */     this.hashCode = -2147483648;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public String getJobName()
/*  90:    */   {
/*  91:137 */     return this.jobName;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public void setJobName(String jobName)
/*  95:    */   {
/*  96:145 */     this.jobName = jobName;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public String getWorkAddress()
/* 100:    */   {
/* 101:154 */     return this.workAddress;
/* 102:    */   }
/* 103:    */   
/* 104:    */   public void setWorkAddress(String workAddress)
/* 105:    */   {
/* 106:162 */     this.workAddress = workAddress;
/* 107:    */   }
/* 108:    */   
/* 109:    */   public Byte getGender()
/* 110:    */   {
/* 111:171 */     return this.gender;
/* 112:    */   }
/* 113:    */   
/* 114:    */   public void setGender(Byte gender)
/* 115:    */   {
/* 116:179 */     this.gender = gender;
/* 117:    */   }
/* 118:    */   
/* 119:    */   public Integer getMinAge()
/* 120:    */   {
/* 121:188 */     return this.minAge;
/* 122:    */   }
/* 123:    */   
/* 124:    */   public void setMinAge(Integer minAge)
/* 125:    */   {
/* 126:196 */     this.minAge = minAge;
/* 127:    */   }
/* 128:    */   
/* 129:    */   public Integer getMaxAge()
/* 130:    */   {
/* 131:205 */     return this.maxAge;
/* 132:    */   }
/* 133:    */   
/* 134:    */   public void setMaxAge(Integer maxAge)
/* 135:    */   {
/* 136:213 */     this.maxAge = maxAge;
/* 137:    */   }
/* 138:    */   
/* 139:    */   public Byte getEducational()
/* 140:    */   {
/* 141:222 */     return this.educational;
/* 142:    */   }
/* 143:    */   
/* 144:    */   public void setEducational(Byte educational)
/* 145:    */   {
/* 146:230 */     this.educational = educational;
/* 147:    */   }
/* 148:    */   
/* 149:    */   public Integer getRecruitCount()
/* 150:    */   {
/* 151:239 */     return this.recruitCount;
/* 152:    */   }
/* 153:    */   
/* 154:    */   public void setRecruitCount(Integer recruitCount)
/* 155:    */   {
/* 156:247 */     this.recruitCount = recruitCount;
/* 157:    */   }
/* 158:    */   
/* 159:    */   public Date getStartTime()
/* 160:    */   {
/* 161:256 */     return this.startTime;
/* 162:    */   }
/* 163:    */   
/* 164:    */   public void setStartTime(Date startTime)
/* 165:    */   {
/* 166:264 */     this.startTime = startTime;
/* 167:    */   }
/* 168:    */   
/* 169:    */   public Date getEndTime()
/* 170:    */   {
/* 171:273 */     return this.endTime;
/* 172:    */   }
/* 173:    */   
/* 174:    */   public void setEndTime(Date endTime)
/* 175:    */   {
/* 176:281 */     this.endTime = endTime;
/* 177:    */   }
/* 178:    */   
/* 179:    */   public Date getRefreshTime()
/* 180:    */   {
/* 181:290 */     return this.refreshTime;
/* 182:    */   }
/* 183:    */   
/* 184:    */   public void setRefreshTime(Date refreshTime)
/* 185:    */   {
/* 186:298 */     this.refreshTime = refreshTime;
/* 187:    */   }
/* 188:    */   
/* 189:    */   public Date getCreateTime()
/* 190:    */   {
/* 191:307 */     return this.createTime;
/* 192:    */   }
/* 193:    */   
/* 194:    */   public void setCreateTime(Date createTime)
/* 195:    */   {
/* 196:315 */     this.createTime = createTime;
/* 197:    */   }
/* 198:    */   
/* 199:    */   public Boolean getCheck()
/* 200:    */   {
/* 201:324 */     return this.check;
/* 202:    */   }
/* 203:    */   
/* 204:    */   public void setCheck(Boolean check)
/* 205:    */   {
/* 206:332 */     this.check = check;
/* 207:    */   }
/* 208:    */   
/* 209:    */   public JobPostExt getExt()
/* 210:    */   {
/* 211:341 */     return this.ext;
/* 212:    */   }
/* 213:    */   
/* 214:    */   public void setExt(JobPostExt ext)
/* 215:    */   {
/* 216:349 */     this.ext = ext;
/* 217:    */   }
/* 218:    */   
/* 219:    */   public Metier getMetier()
/* 220:    */   {
/* 221:358 */     return this.metier;
/* 222:    */   }
/* 223:    */   
/* 224:    */   public void setMetier(Metier metier)
/* 225:    */   {
/* 226:366 */     this.metier = metier;
/* 227:    */   }
/* 228:    */   
/* 229:    */   public CompanyInfo getCompany()
/* 230:    */   {
/* 231:375 */     return this.company;
/* 232:    */   }
/* 233:    */   
/* 234:    */   public void setCompany(CompanyInfo company)
/* 235:    */   {
/* 236:383 */     this.company = company;
/* 237:    */   }
/* 238:    */   
/* 239:    */   public boolean equals(Object obj)
/* 240:    */   {
/* 241:390 */     if (obj == null) {
/* 242:390 */       return false;
/* 243:    */     }
/* 244:391 */     if (!(obj instanceof JobPost)) {
/* 245:391 */       return false;
/* 246:    */     }
/* 247:393 */     JobPost jobPost = (JobPost)obj;
/* 248:394 */     if ((getId() == null) || (jobPost.getId() == null)) {
/* 249:394 */       return false;
/* 250:    */     }
/* 251:395 */     return getId().equals(jobPost.getId());
/* 252:    */   }
/* 253:    */   
/* 254:    */   public int hashCode()
/* 255:    */   {
/* 256:400 */     if (-2147483648 == this.hashCode)
/* 257:    */     {
/* 258:401 */       if (getId() == null) {
/* 259:401 */         return super.hashCode();
/* 260:    */       }
/* 261:403 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 262:404 */       this.hashCode = hashStr.hashCode();
/* 263:    */     }
/* 264:407 */     return this.hashCode;
/* 265:    */   }
/* 266:    */   
/* 267:    */   public String toString()
/* 268:    */   {
/* 269:412 */     return super.toString();
/* 270:    */   }
/* 271:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.entity.base.BaseJobPost
 * JD-Core Version:    0.7.0.1
 */