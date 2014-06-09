/*   1:    */ package com.portal.recruitcenter.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.datacenter.commdata.entity.Specialty;
/*   4:    */ import com.portal.recruitcenter.entity.EduExp;
/*   5:    */ import com.portal.recruitcenter.entity.Resume;
/*   6:    */ import java.io.Serializable;
/*   7:    */ import java.util.Date;
/*   8:    */ 
/*   9:    */ public abstract class BaseEduExp
/*  10:    */   implements Serializable
/*  11:    */ {
/*  12: 17 */   public static String REF = "EduExp";
/*  13: 18 */   public static String PROP_DESCRIPTION = "description";
/*  14: 19 */   public static String PROP_SPECIAL = "special";
/*  15: 20 */   public static String PROP_RESUME = "resume";
/*  16: 21 */   public static String PROP_CREATE_TIME = "createTime";
/*  17: 22 */   public static String PROP_EDUCATIONAL = "educational";
/*  18: 23 */   public static String PROP_DEGREE = "degree";
/*  19: 24 */   public static String PROP_OVERSEA = "oversea";
/*  20: 25 */   public static String PROP_ID = "id";
/*  21: 26 */   public static String PROP_END_TIME = "endTime";
/*  22: 27 */   public static String PROP_START_TIME = "startTime";
/*  23: 28 */   public static String PROP_SCHOOL = "school";
/*  24:    */   
/*  25:    */   public BaseEduExp()
/*  26:    */   {
/*  27: 33 */     initialize();
/*  28:    */   }
/*  29:    */   
/*  30:    */   public BaseEduExp(Integer id)
/*  31:    */   {
/*  32: 40 */     setId(id);
/*  33: 41 */     initialize();
/*  34:    */   }
/*  35:    */   
/*  36:    */   public BaseEduExp(Integer id, Resume resume, Specialty special, String startTime, String endTime, String school, Byte educational, Boolean oversea, Date createTime)
/*  37:    */   {
/*  38: 58 */     setId(id);
/*  39: 59 */     setResume(resume);
/*  40: 60 */     setSpecial(special);
/*  41: 61 */     setStartTime(startTime);
/*  42: 62 */     setEndTime(endTime);
/*  43: 63 */     setSchool(school);
/*  44: 64 */     setEducational(educational);
/*  45: 65 */     setOversea(oversea);
/*  46: 66 */     setCreateTime(createTime);
/*  47: 67 */     initialize();
/*  48:    */   }
/*  49:    */   
/*  50: 74 */   private int hashCode = -2147483648;
/*  51:    */   private Integer id;
/*  52:    */   private String startTime;
/*  53:    */   private String endTime;
/*  54:    */   private String school;
/*  55:    */   private Byte educational;
/*  56:    */   private Byte degree;
/*  57:    */   private Boolean oversea;
/*  58:    */   private String description;
/*  59:    */   private Date createTime;
/*  60:    */   private Resume resume;
/*  61:    */   private Specialty special;
/*  62:    */   
/*  63:    */   protected void initialize() {}
/*  64:    */   
/*  65:    */   public Integer getId()
/*  66:    */   {
/*  67:102 */     return this.id;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public void setId(Integer id)
/*  71:    */   {
/*  72:110 */     this.id = id;
/*  73:111 */     this.hashCode = -2147483648;
/*  74:    */   }
/*  75:    */   
/*  76:    */   public String getStartTime()
/*  77:    */   {
/*  78:121 */     return this.startTime;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public void setStartTime(String startTime)
/*  82:    */   {
/*  83:129 */     this.startTime = startTime;
/*  84:    */   }
/*  85:    */   
/*  86:    */   public String getEndTime()
/*  87:    */   {
/*  88:138 */     return this.endTime;
/*  89:    */   }
/*  90:    */   
/*  91:    */   public void setEndTime(String endTime)
/*  92:    */   {
/*  93:146 */     this.endTime = endTime;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public String getSchool()
/*  97:    */   {
/*  98:155 */     return this.school;
/*  99:    */   }
/* 100:    */   
/* 101:    */   public void setSchool(String school)
/* 102:    */   {
/* 103:163 */     this.school = school;
/* 104:    */   }
/* 105:    */   
/* 106:    */   public Byte getEducational()
/* 107:    */   {
/* 108:172 */     return this.educational;
/* 109:    */   }
/* 110:    */   
/* 111:    */   public void setEducational(Byte educational)
/* 112:    */   {
/* 113:180 */     this.educational = educational;
/* 114:    */   }
/* 115:    */   
/* 116:    */   public Byte getDegree()
/* 117:    */   {
/* 118:189 */     return this.degree;
/* 119:    */   }
/* 120:    */   
/* 121:    */   public void setDegree(Byte degree)
/* 122:    */   {
/* 123:197 */     this.degree = degree;
/* 124:    */   }
/* 125:    */   
/* 126:    */   public Boolean getOversea()
/* 127:    */   {
/* 128:206 */     return this.oversea;
/* 129:    */   }
/* 130:    */   
/* 131:    */   public void setOversea(Boolean oversea)
/* 132:    */   {
/* 133:214 */     this.oversea = oversea;
/* 134:    */   }
/* 135:    */   
/* 136:    */   public String getDescription()
/* 137:    */   {
/* 138:223 */     return this.description;
/* 139:    */   }
/* 140:    */   
/* 141:    */   public void setDescription(String description)
/* 142:    */   {
/* 143:231 */     this.description = description;
/* 144:    */   }
/* 145:    */   
/* 146:    */   public Date getCreateTime()
/* 147:    */   {
/* 148:240 */     return this.createTime;
/* 149:    */   }
/* 150:    */   
/* 151:    */   public void setCreateTime(Date createTime)
/* 152:    */   {
/* 153:248 */     this.createTime = createTime;
/* 154:    */   }
/* 155:    */   
/* 156:    */   public Resume getResume()
/* 157:    */   {
/* 158:257 */     return this.resume;
/* 159:    */   }
/* 160:    */   
/* 161:    */   public void setResume(Resume resume)
/* 162:    */   {
/* 163:265 */     this.resume = resume;
/* 164:    */   }
/* 165:    */   
/* 166:    */   public Specialty getSpecial()
/* 167:    */   {
/* 168:274 */     return this.special;
/* 169:    */   }
/* 170:    */   
/* 171:    */   public void setSpecial(Specialty special)
/* 172:    */   {
/* 173:282 */     this.special = special;
/* 174:    */   }
/* 175:    */   
/* 176:    */   public boolean equals(Object obj)
/* 177:    */   {
/* 178:289 */     if (obj == null) {
/* 179:289 */       return false;
/* 180:    */     }
/* 181:290 */     if (!(obj instanceof EduExp)) {
/* 182:290 */       return false;
/* 183:    */     }
/* 184:292 */     EduExp eduExp = (EduExp)obj;
/* 185:293 */     if ((getId() == null) || (eduExp.getId() == null)) {
/* 186:293 */       return false;
/* 187:    */     }
/* 188:294 */     return getId().equals(eduExp.getId());
/* 189:    */   }
/* 190:    */   
/* 191:    */   public int hashCode()
/* 192:    */   {
/* 193:299 */     if (-2147483648 == this.hashCode)
/* 194:    */     {
/* 195:300 */       if (getId() == null) {
/* 196:300 */         return super.hashCode();
/* 197:    */       }
/* 198:302 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 199:303 */       this.hashCode = hashStr.hashCode();
/* 200:    */     }
/* 201:306 */     return this.hashCode;
/* 202:    */   }
/* 203:    */   
/* 204:    */   public String toString()
/* 205:    */   {
/* 206:311 */     return super.toString();
/* 207:    */   }
/* 208:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.entity.base.BaseEduExp
 * JD-Core Version:    0.7.0.1
 */