/*   1:    */ package com.portal.recruitcenter.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.recruitcenter.entity.CompanyInfo;
/*   4:    */ import com.portal.recruitcenter.entity.CompanyInfoExt;
/*   5:    */ import java.io.Serializable;
/*   6:    */ import java.util.Date;
/*   7:    */ 
/*   8:    */ public abstract class BaseCompanyInfoExt
/*   9:    */   implements Serializable
/*  10:    */ {
/*  11: 17 */   public static String REF = "CompanyInfoExt";
/*  12: 18 */   public static String PROP_PHONE = "phone";
/*  13: 19 */   public static String PROP_FAX = "fax";
/*  14: 20 */   public static String PROP_VIP_DAY = "vipDay";
/*  15: 21 */   public static String PROP_VIP = "vip";
/*  16: 22 */   public static String PROP_REG_CAPITAL = "regCapital";
/*  17: 23 */   public static String PROP_WEB_URL = "webUrl";
/*  18: 24 */   public static String PROP_APPLY_VIP = "applyVip";
/*  19: 25 */   public static String PROP_ZIP_CODE = "zipCode";
/*  20: 26 */   public static String PROP_CITY = "city";
/*  21: 27 */   public static String PROP_NEED_LOGIN = "needLogin";
/*  22: 28 */   public static String PROP_SET_UP = "setUp";
/*  23: 29 */   public static String PROP_EMAIL = "email";
/*  24: 30 */   public static String PROP_ADDRESS = "address";
/*  25: 31 */   public static String PROP_ID = "id";
/*  26: 32 */   public static String PROP_INFO = "info";
/*  27: 33 */   public static String PROP_SYNOPSIS = "synopsis";
/*  28: 34 */   public static String PROP_APPLY_TIME = "applyTime";
/*  29: 35 */   public static String PROP_DREDGE_TIME = "dredgeTime";
/*  30:    */   
/*  31:    */   public BaseCompanyInfoExt()
/*  32:    */   {
/*  33: 40 */     initialize();
/*  34:    */   }
/*  35:    */   
/*  36:    */   public BaseCompanyInfoExt(Integer id)
/*  37:    */   {
/*  38: 47 */     setId(id);
/*  39: 48 */     initialize();
/*  40:    */   }
/*  41:    */   
/*  42:    */   public BaseCompanyInfoExt(Integer id, Boolean applyVip, Boolean needLogin, Boolean vip)
/*  43:    */   {
/*  44: 60 */     setId(id);
/*  45: 61 */     setApplyVip(applyVip);
/*  46: 62 */     setNeedLogin(needLogin);
/*  47: 63 */     setVip(vip);
/*  48: 64 */     initialize();
/*  49:    */   }
/*  50:    */   
/*  51: 71 */   private int hashCode = -2147483648;
/*  52:    */   private Integer id;
/*  53:    */   private Integer regCapital;
/*  54:    */   private String setUp;
/*  55:    */   private String city;
/*  56:    */   private String address;
/*  57:    */   private String zipCode;
/*  58:    */   private String webUrl;
/*  59:    */   private String email;
/*  60:    */   private String phone;
/*  61:    */   private String fax;
/*  62:    */   private String synopsis;
/*  63:    */   private Boolean applyVip;
/*  64:    */   private Date applyTime;
/*  65:    */   private Boolean needLogin;
/*  66:    */   private Boolean vip;
/*  67:    */   private Date dredgeTime;
/*  68:    */   private Integer vipDay;
/*  69:    */   private CompanyInfo info;
/*  70:    */   
/*  71:    */   protected void initialize() {}
/*  72:    */   
/*  73:    */   public Integer getId()
/*  74:    */   {
/*  75:106 */     return this.id;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public void setId(Integer id)
/*  79:    */   {
/*  80:114 */     this.id = id;
/*  81:115 */     this.hashCode = -2147483648;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public Integer getRegCapital()
/*  85:    */   {
/*  86:125 */     return this.regCapital;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public void setRegCapital(Integer regCapital)
/*  90:    */   {
/*  91:133 */     this.regCapital = regCapital;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public String getSetUp()
/*  95:    */   {
/*  96:142 */     return this.setUp;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public void setSetUp(String setUp)
/* 100:    */   {
/* 101:150 */     this.setUp = setUp;
/* 102:    */   }
/* 103:    */   
/* 104:    */   public String getCity()
/* 105:    */   {
/* 106:159 */     return this.city;
/* 107:    */   }
/* 108:    */   
/* 109:    */   public void setCity(String city)
/* 110:    */   {
/* 111:167 */     this.city = city;
/* 112:    */   }
/* 113:    */   
/* 114:    */   public String getAddress()
/* 115:    */   {
/* 116:176 */     return this.address;
/* 117:    */   }
/* 118:    */   
/* 119:    */   public void setAddress(String address)
/* 120:    */   {
/* 121:184 */     this.address = address;
/* 122:    */   }
/* 123:    */   
/* 124:    */   public String getZipCode()
/* 125:    */   {
/* 126:193 */     return this.zipCode;
/* 127:    */   }
/* 128:    */   
/* 129:    */   public void setZipCode(String zipCode)
/* 130:    */   {
/* 131:201 */     this.zipCode = zipCode;
/* 132:    */   }
/* 133:    */   
/* 134:    */   public String getWebUrl()
/* 135:    */   {
/* 136:210 */     return this.webUrl;
/* 137:    */   }
/* 138:    */   
/* 139:    */   public void setWebUrl(String webUrl)
/* 140:    */   {
/* 141:218 */     this.webUrl = webUrl;
/* 142:    */   }
/* 143:    */   
/* 144:    */   public String getEmail()
/* 145:    */   {
/* 146:227 */     return this.email;
/* 147:    */   }
/* 148:    */   
/* 149:    */   public void setEmail(String email)
/* 150:    */   {
/* 151:235 */     this.email = email;
/* 152:    */   }
/* 153:    */   
/* 154:    */   public String getPhone()
/* 155:    */   {
/* 156:244 */     return this.phone;
/* 157:    */   }
/* 158:    */   
/* 159:    */   public void setPhone(String phone)
/* 160:    */   {
/* 161:252 */     this.phone = phone;
/* 162:    */   }
/* 163:    */   
/* 164:    */   public String getFax()
/* 165:    */   {
/* 166:261 */     return this.fax;
/* 167:    */   }
/* 168:    */   
/* 169:    */   public void setFax(String fax)
/* 170:    */   {
/* 171:269 */     this.fax = fax;
/* 172:    */   }
/* 173:    */   
/* 174:    */   public String getSynopsis()
/* 175:    */   {
/* 176:278 */     return this.synopsis;
/* 177:    */   }
/* 178:    */   
/* 179:    */   public void setSynopsis(String synopsis)
/* 180:    */   {
/* 181:286 */     this.synopsis = synopsis;
/* 182:    */   }
/* 183:    */   
/* 184:    */   public Boolean getApplyVip()
/* 185:    */   {
/* 186:295 */     return this.applyVip;
/* 187:    */   }
/* 188:    */   
/* 189:    */   public void setApplyVip(Boolean applyVip)
/* 190:    */   {
/* 191:303 */     this.applyVip = applyVip;
/* 192:    */   }
/* 193:    */   
/* 194:    */   public Date getApplyTime()
/* 195:    */   {
/* 196:312 */     return this.applyTime;
/* 197:    */   }
/* 198:    */   
/* 199:    */   public void setApplyTime(Date applyTime)
/* 200:    */   {
/* 201:320 */     this.applyTime = applyTime;
/* 202:    */   }
/* 203:    */   
/* 204:    */   public Boolean getNeedLogin()
/* 205:    */   {
/* 206:329 */     return this.needLogin;
/* 207:    */   }
/* 208:    */   
/* 209:    */   public void setNeedLogin(Boolean needLogin)
/* 210:    */   {
/* 211:337 */     this.needLogin = needLogin;
/* 212:    */   }
/* 213:    */   
/* 214:    */   public Boolean getVip()
/* 215:    */   {
/* 216:346 */     return this.vip;
/* 217:    */   }
/* 218:    */   
/* 219:    */   public void setVip(Boolean vip)
/* 220:    */   {
/* 221:354 */     this.vip = vip;
/* 222:    */   }
/* 223:    */   
/* 224:    */   public Date getDredgeTime()
/* 225:    */   {
/* 226:363 */     return this.dredgeTime;
/* 227:    */   }
/* 228:    */   
/* 229:    */   public void setDredgeTime(Date dredgeTime)
/* 230:    */   {
/* 231:371 */     this.dredgeTime = dredgeTime;
/* 232:    */   }
/* 233:    */   
/* 234:    */   public Integer getVipDay()
/* 235:    */   {
/* 236:380 */     return this.vipDay;
/* 237:    */   }
/* 238:    */   
/* 239:    */   public void setVipDay(Integer vipDay)
/* 240:    */   {
/* 241:388 */     this.vipDay = vipDay;
/* 242:    */   }
/* 243:    */   
/* 244:    */   public CompanyInfo getInfo()
/* 245:    */   {
/* 246:397 */     return this.info;
/* 247:    */   }
/* 248:    */   
/* 249:    */   public void setInfo(CompanyInfo info)
/* 250:    */   {
/* 251:405 */     this.info = info;
/* 252:    */   }
/* 253:    */   
/* 254:    */   public boolean equals(Object obj)
/* 255:    */   {
/* 256:412 */     if (obj == null) {
/* 257:412 */       return false;
/* 258:    */     }
/* 259:413 */     if (!(obj instanceof CompanyInfoExt)) {
/* 260:413 */       return false;
/* 261:    */     }
/* 262:415 */     CompanyInfoExt companyInfoExt = (CompanyInfoExt)obj;
/* 263:416 */     if ((getId() == null) || (companyInfoExt.getId() == null)) {
/* 264:416 */       return false;
/* 265:    */     }
/* 266:417 */     return getId().equals(companyInfoExt.getId());
/* 267:    */   }
/* 268:    */   
/* 269:    */   public int hashCode()
/* 270:    */   {
/* 271:422 */     if (-2147483648 == this.hashCode)
/* 272:    */     {
/* 273:423 */       if (getId() == null) {
/* 274:423 */         return super.hashCode();
/* 275:    */       }
/* 276:425 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 277:426 */       this.hashCode = hashStr.hashCode();
/* 278:    */     }
/* 279:429 */     return this.hashCode;
/* 280:    */   }
/* 281:    */   
/* 282:    */   public String toString()
/* 283:    */   {
/* 284:434 */     return super.toString();
/* 285:    */   }
/* 286:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.entity.base.BaseCompanyInfoExt
 * JD-Core Version:    0.7.0.1
 */