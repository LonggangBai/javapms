/*   1:    */ package com.portal.recruitcenter.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.datacenter.commdata.entity.EconomyType;
/*   4:    */ import com.portal.datacenter.commdata.entity.Industry;
/*   5:    */ import com.portal.recruitcenter.entity.CompanyInfo;
/*   6:    */ import com.portal.recruitcenter.entity.CompanyInfoExt;
/*   7:    */ import com.portal.recruitcenter.entity.VipType;
/*   8:    */ import java.io.Serializable;
/*   9:    */ import java.util.Date;
/*  10:    */ 
/*  11:    */ public abstract class BaseCompanyInfo
/*  12:    */   implements Serializable
/*  13:    */ {
/*  14: 17 */   public static String REF = "CompanyInfo";
/*  15: 18 */   public static String PROP_CHECK = "check";
/*  16: 19 */   public static String PROP_SHOW = "show";
/*  17: 20 */   public static String PROP_NATURE = "nature";
/*  18: 21 */   public static String PROP_NAME = "name";
/*  19: 22 */   public static String PROP_LAST_POST_TIME = "lastPostTime";
/*  20: 23 */   public static String PROP_COM_SCALE = "comScale";
/*  21: 24 */   public static String PROP_POST_COUNT = "postCount";
/*  22: 25 */   public static String PROP_LINK_TEL = "linkTel";
/*  23: 26 */   public static String PROP_EXT = "ext";
/*  24: 27 */   public static String PROP_COMMEND = "commend";
/*  25: 28 */   public static String PROP_ID = "id";
/*  26: 29 */   public static String PROP_INDUSTRY2 = "industry2";
/*  27: 30 */   public static String PROP_LINK_MAN = "linkMan";
/*  28: 31 */   public static String PROP_INDUSTRY1 = "industry1";
/*  29:    */   
/*  30:    */   public BaseCompanyInfo()
/*  31:    */   {
/*  32: 36 */     initialize();
/*  33:    */   }
/*  34:    */   
/*  35:    */   public BaseCompanyInfo(Integer id)
/*  36:    */   {
/*  37: 43 */     setId(id);
/*  38: 44 */     initialize();
/*  39:    */   }
/*  40:    */   
/*  41:    */   public BaseCompanyInfo(Integer id, String name, String linkMan, String linkTel, Boolean check, Boolean commend, Boolean show)
/*  42:    */   {
/*  43: 59 */     setId(id);
/*  44: 60 */     setName(name);
/*  45: 61 */     setLinkMan(linkMan);
/*  46: 62 */     setLinkTel(linkTel);
/*  47: 63 */     setCheck(check);
/*  48: 64 */     setCommend(commend);
/*  49: 65 */     setShow(show);
/*  50: 66 */     initialize();
/*  51:    */   }
/*  52:    */   
/*  53: 73 */   private int hashCode = -2147483648;
/*  54:    */   private Integer id;
/*  55:    */   private String name;
/*  56:    */   private String linkMan;
/*  57:    */   private String linkTel;
/*  58:    */   private Byte comScale;
/*  59:    */   private Date lastPostTime;
/*  60:    */   private Boolean check;
/*  61:    */   private Boolean commend;
/*  62:    */   private Boolean show;
/*  63:    */   private Integer postCount;
/*  64:    */   private CompanyInfoExt ext;
/*  65:    */   private EconomyType nature;
/*  66:    */   private Industry industry1;
/*  67:    */   private Industry industry2;
/*  68:    */   private VipType vipType;
/*  69:    */   private VipType applyType;
/*  70:    */   
/*  71:    */   protected void initialize() {}
/*  72:    */   
/*  73:    */   public Integer getId()
/*  74:    */   {
/*  75:108 */     return this.id;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public void setId(Integer id)
/*  79:    */   {
/*  80:116 */     this.id = id;
/*  81:117 */     this.hashCode = -2147483648;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public String getName()
/*  85:    */   {
/*  86:127 */     return this.name;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public void setName(String name)
/*  90:    */   {
/*  91:135 */     this.name = name;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public String getLinkMan()
/*  95:    */   {
/*  96:144 */     return this.linkMan;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public void setLinkMan(String linkMan)
/* 100:    */   {
/* 101:152 */     this.linkMan = linkMan;
/* 102:    */   }
/* 103:    */   
/* 104:    */   public String getLinkTel()
/* 105:    */   {
/* 106:161 */     return this.linkTel;
/* 107:    */   }
/* 108:    */   
/* 109:    */   public void setLinkTel(String linkTel)
/* 110:    */   {
/* 111:169 */     this.linkTel = linkTel;
/* 112:    */   }
/* 113:    */   
/* 114:    */   public Byte getComScale()
/* 115:    */   {
/* 116:178 */     return this.comScale;
/* 117:    */   }
/* 118:    */   
/* 119:    */   public void setComScale(Byte comScale)
/* 120:    */   {
/* 121:186 */     this.comScale = comScale;
/* 122:    */   }
/* 123:    */   
/* 124:    */   public Date getLastPostTime()
/* 125:    */   {
/* 126:195 */     return this.lastPostTime;
/* 127:    */   }
/* 128:    */   
/* 129:    */   public void setLastPostTime(Date lastPostTime)
/* 130:    */   {
/* 131:203 */     this.lastPostTime = lastPostTime;
/* 132:    */   }
/* 133:    */   
/* 134:    */   public Boolean getCheck()
/* 135:    */   {
/* 136:212 */     return this.check;
/* 137:    */   }
/* 138:    */   
/* 139:    */   public void setCheck(Boolean check)
/* 140:    */   {
/* 141:220 */     this.check = check;
/* 142:    */   }
/* 143:    */   
/* 144:    */   public Boolean getCommend()
/* 145:    */   {
/* 146:229 */     return this.commend;
/* 147:    */   }
/* 148:    */   
/* 149:    */   public void setCommend(Boolean commend)
/* 150:    */   {
/* 151:237 */     this.commend = commend;
/* 152:    */   }
/* 153:    */   
/* 154:    */   public Boolean getShow()
/* 155:    */   {
/* 156:246 */     return this.show;
/* 157:    */   }
/* 158:    */   
/* 159:    */   public void setShow(Boolean show)
/* 160:    */   {
/* 161:254 */     this.show = show;
/* 162:    */   }
/* 163:    */   
/* 164:    */   public Integer getPostCount()
/* 165:    */   {
/* 166:263 */     return this.postCount;
/* 167:    */   }
/* 168:    */   
/* 169:    */   public void setPostCount(Integer postCount)
/* 170:    */   {
/* 171:271 */     this.postCount = postCount;
/* 172:    */   }
/* 173:    */   
/* 174:    */   public CompanyInfoExt getExt()
/* 175:    */   {
/* 176:280 */     return this.ext;
/* 177:    */   }
/* 178:    */   
/* 179:    */   public void setExt(CompanyInfoExt ext)
/* 180:    */   {
/* 181:288 */     this.ext = ext;
/* 182:    */   }
/* 183:    */   
/* 184:    */   public EconomyType getNature()
/* 185:    */   {
/* 186:297 */     return this.nature;
/* 187:    */   }
/* 188:    */   
/* 189:    */   public void setNature(EconomyType nature)
/* 190:    */   {
/* 191:305 */     this.nature = nature;
/* 192:    */   }
/* 193:    */   
/* 194:    */   public Industry getIndustry1()
/* 195:    */   {
/* 196:314 */     return this.industry1;
/* 197:    */   }
/* 198:    */   
/* 199:    */   public void setIndustry1(Industry industry1)
/* 200:    */   {
/* 201:322 */     this.industry1 = industry1;
/* 202:    */   }
/* 203:    */   
/* 204:    */   public Industry getIndustry2()
/* 205:    */   {
/* 206:331 */     return this.industry2;
/* 207:    */   }
/* 208:    */   
/* 209:    */   public void setIndustry2(Industry industry2)
/* 210:    */   {
/* 211:339 */     this.industry2 = industry2;
/* 212:    */   }
/* 213:    */   
/* 214:    */   public VipType getVipType()
/* 215:    */   {
/* 216:346 */     return this.vipType;
/* 217:    */   }
/* 218:    */   
/* 219:    */   public void setVipType(VipType vipType)
/* 220:    */   {
/* 221:350 */     this.vipType = vipType;
/* 222:    */   }
/* 223:    */   
/* 224:    */   public VipType getApplyType()
/* 225:    */   {
/* 226:354 */     return this.applyType;
/* 227:    */   }
/* 228:    */   
/* 229:    */   public void setApplyType(VipType applyType)
/* 230:    */   {
/* 231:358 */     this.applyType = applyType;
/* 232:    */   }
/* 233:    */   
/* 234:    */   public boolean equals(Object obj)
/* 235:    */   {
/* 236:362 */     if (obj == null) {
/* 237:362 */       return false;
/* 238:    */     }
/* 239:363 */     if (!(obj instanceof CompanyInfo)) {
/* 240:363 */       return false;
/* 241:    */     }
/* 242:365 */     CompanyInfo companyInfo = (CompanyInfo)obj;
/* 243:366 */     if ((getId() == null) || (companyInfo.getId() == null)) {
/* 244:366 */       return false;
/* 245:    */     }
/* 246:367 */     return getId().equals(companyInfo.getId());
/* 247:    */   }
/* 248:    */   
/* 249:    */   public int hashCode()
/* 250:    */   {
/* 251:372 */     if (-2147483648 == this.hashCode)
/* 252:    */     {
/* 253:373 */       if (getId() == null) {
/* 254:373 */         return super.hashCode();
/* 255:    */       }
/* 256:375 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 257:376 */       this.hashCode = hashStr.hashCode();
/* 258:    */     }
/* 259:379 */     return this.hashCode;
/* 260:    */   }
/* 261:    */   
/* 262:    */   public String toString()
/* 263:    */   {
/* 264:384 */     return super.toString();
/* 265:    */   }
/* 266:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.entity.base.BaseCompanyInfo
 * JD-Core Version:    0.7.0.1
 */