/*   1:    */ package com.portal.recruitcenter.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.datacenter.commdata.entity.EconomyType;
/*   4:    */ import com.portal.datacenter.commdata.entity.Industry;
/*   5:    */ import com.portal.datacenter.commdata.entity.Metier;
/*   6:    */ import com.portal.recruitcenter.entity.Resume;
/*   7:    */ import com.portal.recruitcenter.entity.WorkExp;
/*   8:    */ import java.io.Serializable;
/*   9:    */ import java.util.Date;
/*  10:    */ 
/*  11:    */ public abstract class BaseWorkExp
/*  12:    */   implements Serializable
/*  13:    */ {
/*  14: 17 */   public static String REF = "WorkExp";
/*  15: 18 */   public static String PROP_DESCRIPTION = "description";
/*  16: 19 */   public static String PROP_DEPART_NAME = "departName";
/*  17: 20 */   public static String PROP_WAGE = "wage";
/*  18: 21 */   public static String PROP_NATURE = "nature";
/*  19: 22 */   public static String PROP_NAME = "name";
/*  20: 23 */   public static String PROP_METIER = "metier";
/*  21: 24 */   public static String PROP_RESUME = "resume";
/*  22: 25 */   public static String PROP_CREATE_TIME = "createTime";
/*  23: 26 */   public static String PROP_OVERSEA = "oversea";
/*  24: 27 */   public static String PROP_ID = "id";
/*  25: 28 */   public static String PROP_END_TIME = "endTime";
/*  26: 29 */   public static String PROP_START_TIME = "startTime";
/*  27: 30 */   public static String PROP_SCALE = "scale";
/*  28: 31 */   public static String PROP_INDUSTRY = "industry";
/*  29:    */   
/*  30:    */   public BaseWorkExp()
/*  31:    */   {
/*  32: 36 */     initialize();
/*  33:    */   }
/*  34:    */   
/*  35:    */   public BaseWorkExp(Integer id)
/*  36:    */   {
/*  37: 43 */     setId(id);
/*  38: 44 */     initialize();
/*  39:    */   }
/*  40:    */   
/*  41:    */   public BaseWorkExp(Integer id, Resume resume, Metier metier, String startTime, String endTime, String name, Byte scale, Byte wage, Boolean oversea, Date createTime)
/*  42:    */   {
/*  43: 62 */     setId(id);
/*  44: 63 */     setResume(resume);
/*  45: 64 */     setMetier(metier);
/*  46: 65 */     setStartTime(startTime);
/*  47: 66 */     setEndTime(endTime);
/*  48: 67 */     setName(name);
/*  49: 68 */     setScale(scale);
/*  50: 69 */     setWage(wage);
/*  51: 70 */     setOversea(oversea);
/*  52: 71 */     setCreateTime(createTime);
/*  53: 72 */     initialize();
/*  54:    */   }
/*  55:    */   
/*  56: 79 */   private int hashCode = -2147483648;
/*  57:    */   private Integer id;
/*  58:    */   private String startTime;
/*  59:    */   private String endTime;
/*  60:    */   private String name;
/*  61:    */   private Byte scale;
/*  62:    */   private String departName;
/*  63:    */   private Byte wage;
/*  64:    */   private Boolean oversea;
/*  65:    */   private String description;
/*  66:    */   private Date createTime;
/*  67:    */   private Resume resume;
/*  68:    */   private EconomyType nature;
/*  69:    */   private Metier metier;
/*  70:    */   private Industry industry;
/*  71:    */   
/*  72:    */   protected void initialize() {}
/*  73:    */   
/*  74:    */   public Integer getId()
/*  75:    */   {
/*  76:110 */     return this.id;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public void setId(Integer id)
/*  80:    */   {
/*  81:118 */     this.id = id;
/*  82:119 */     this.hashCode = -2147483648;
/*  83:    */   }
/*  84:    */   
/*  85:    */   public String getStartTime()
/*  86:    */   {
/*  87:129 */     return this.startTime;
/*  88:    */   }
/*  89:    */   
/*  90:    */   public void setStartTime(String startTime)
/*  91:    */   {
/*  92:137 */     this.startTime = startTime;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public String getEndTime()
/*  96:    */   {
/*  97:146 */     return this.endTime;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public void setEndTime(String endTime)
/* 101:    */   {
/* 102:154 */     this.endTime = endTime;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public String getName()
/* 106:    */   {
/* 107:163 */     return this.name;
/* 108:    */   }
/* 109:    */   
/* 110:    */   public void setName(String name)
/* 111:    */   {
/* 112:171 */     this.name = name;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public Byte getScale()
/* 116:    */   {
/* 117:180 */     return this.scale;
/* 118:    */   }
/* 119:    */   
/* 120:    */   public void setScale(Byte scale)
/* 121:    */   {
/* 122:188 */     this.scale = scale;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public String getDepartName()
/* 126:    */   {
/* 127:197 */     return this.departName;
/* 128:    */   }
/* 129:    */   
/* 130:    */   public void setDepartName(String departName)
/* 131:    */   {
/* 132:205 */     this.departName = departName;
/* 133:    */   }
/* 134:    */   
/* 135:    */   public Byte getWage()
/* 136:    */   {
/* 137:214 */     return this.wage;
/* 138:    */   }
/* 139:    */   
/* 140:    */   public void setWage(Byte wage)
/* 141:    */   {
/* 142:222 */     this.wage = wage;
/* 143:    */   }
/* 144:    */   
/* 145:    */   public Boolean getOversea()
/* 146:    */   {
/* 147:231 */     return this.oversea;
/* 148:    */   }
/* 149:    */   
/* 150:    */   public void setOversea(Boolean oversea)
/* 151:    */   {
/* 152:239 */     this.oversea = oversea;
/* 153:    */   }
/* 154:    */   
/* 155:    */   public String getDescription()
/* 156:    */   {
/* 157:248 */     return this.description;
/* 158:    */   }
/* 159:    */   
/* 160:    */   public void setDescription(String description)
/* 161:    */   {
/* 162:256 */     this.description = description;
/* 163:    */   }
/* 164:    */   
/* 165:    */   public Date getCreateTime()
/* 166:    */   {
/* 167:265 */     return this.createTime;
/* 168:    */   }
/* 169:    */   
/* 170:    */   public void setCreateTime(Date createTime)
/* 171:    */   {
/* 172:273 */     this.createTime = createTime;
/* 173:    */   }
/* 174:    */   
/* 175:    */   public Resume getResume()
/* 176:    */   {
/* 177:282 */     return this.resume;
/* 178:    */   }
/* 179:    */   
/* 180:    */   public void setResume(Resume resume)
/* 181:    */   {
/* 182:290 */     this.resume = resume;
/* 183:    */   }
/* 184:    */   
/* 185:    */   public EconomyType getNature()
/* 186:    */   {
/* 187:299 */     return this.nature;
/* 188:    */   }
/* 189:    */   
/* 190:    */   public void setNature(EconomyType nature)
/* 191:    */   {
/* 192:307 */     this.nature = nature;
/* 193:    */   }
/* 194:    */   
/* 195:    */   public Metier getMetier()
/* 196:    */   {
/* 197:316 */     return this.metier;
/* 198:    */   }
/* 199:    */   
/* 200:    */   public void setMetier(Metier metier)
/* 201:    */   {
/* 202:324 */     this.metier = metier;
/* 203:    */   }
/* 204:    */   
/* 205:    */   public Industry getIndustry()
/* 206:    */   {
/* 207:333 */     return this.industry;
/* 208:    */   }
/* 209:    */   
/* 210:    */   public void setIndustry(Industry industry)
/* 211:    */   {
/* 212:341 */     this.industry = industry;
/* 213:    */   }
/* 214:    */   
/* 215:    */   public boolean equals(Object obj)
/* 216:    */   {
/* 217:348 */     if (obj == null) {
/* 218:348 */       return false;
/* 219:    */     }
/* 220:349 */     if (!(obj instanceof WorkExp)) {
/* 221:349 */       return false;
/* 222:    */     }
/* 223:351 */     WorkExp workExp = (WorkExp)obj;
/* 224:352 */     if ((getId() == null) || (workExp.getId() == null)) {
/* 225:352 */       return false;
/* 226:    */     }
/* 227:353 */     return getId().equals(workExp.getId());
/* 228:    */   }
/* 229:    */   
/* 230:    */   public int hashCode()
/* 231:    */   {
/* 232:358 */     if (-2147483648 == this.hashCode)
/* 233:    */     {
/* 234:359 */       if (getId() == null) {
/* 235:359 */         return super.hashCode();
/* 236:    */       }
/* 237:361 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 238:362 */       this.hashCode = hashStr.hashCode();
/* 239:    */     }
/* 240:365 */     return this.hashCode;
/* 241:    */   }
/* 242:    */   
/* 243:    */   public String toString()
/* 244:    */   {
/* 245:370 */     return super.toString();
/* 246:    */   }
/* 247:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.entity.base.BaseWorkExp
 * JD-Core Version:    0.7.0.1
 */