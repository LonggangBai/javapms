/*   1:    */ package com.portal.extrafunc.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.extrafunc.entity.Advert;
/*   4:    */ import com.portal.extrafunc.entity.AdvertSlot;
/*   5:    */ import com.portal.sysmgr.entity.Site;
/*   6:    */ import java.io.Serializable;
/*   7:    */ import java.util.Date;
/*   8:    */ 
/*   9:    */ public abstract class BaseAdvert
/*  10:    */   implements Serializable
/*  11:    */ {
/*  12: 15 */   public static String REF = "Advert";
/*  13: 16 */   public static String PROP_SITE = "site";
/*  14: 17 */   public static String PROP_ATTR_URL = "attrUrl";
/*  15: 18 */   public static String PROP_WEIGHTS = "weights";
/*  16: 19 */   public static String PROP_AEXPLAIN = "aexplain";
/*  17: 20 */   public static String PROP_PRIORITY = "priority";
/*  18: 21 */   public static String PROP_CLICKS = "clicks";
/*  19: 22 */   public static String PROP_NAME = "name";
/*  20: 23 */   public static String PROP_SHOW_TIMES = "showTimes";
/*  21: 24 */   public static String PROP_JSSTRING = "jsstring";
/*  22: 25 */   public static String PROP_URL = "url";
/*  23: 26 */   public static String PROP_SLOT = "slot";
/*  24: 27 */   public static String PROP_ID = "id";
/*  25: 28 */   public static String PROP_END_TIME = "endTime";
/*  26: 29 */   public static String PROP_START_TIME = "startTime";
/*  27: 30 */   public static String PROP_ROTATION = "rotation";
/*  28: 31 */   public static String PROP_ADV_TYPE = "advType";
/*  29:    */   
/*  30:    */   public BaseAdvert()
/*  31:    */   {
/*  32: 35 */     initialize();
/*  33:    */   }
/*  34:    */   
/*  35:    */   public BaseAdvert(Integer id)
/*  36:    */   {
/*  37: 42 */     setId(id);
/*  38: 43 */     initialize();
/*  39:    */   }
/*  40:    */   
/*  41:    */   public BaseAdvert(Integer id, AdvertSlot slot, Site site, String name, String advType, String url, Date startTime, Integer priority, Integer clicks, Boolean enable)
/*  42:    */   {
/*  43: 56 */     setId(id);
/*  44: 57 */     setSlot(slot);
/*  45: 58 */     setSite(site);
/*  46: 59 */     setName(name);
/*  47: 60 */     setAdvType(advType);
/*  48: 61 */     setUrl(url);
/*  49: 62 */     setStartTime(startTime);
/*  50: 63 */     setPriority(priority);
/*  51: 64 */     setClicks(clicks);
/*  52: 65 */     setEnable(enable);
/*  53: 66 */     initialize();
/*  54:    */   }
/*  55:    */   
/*  56: 72 */   private int hashCode = -2147483648;
/*  57:    */   private Integer id;
/*  58:    */   private String name;
/*  59:    */   private String advType;
/*  60:    */   private String attrUrl;
/*  61:    */   private String jsstring;
/*  62:    */   private String url;
/*  63:    */   private Date startTime;
/*  64:    */   private Date endTime;
/*  65:    */   private Integer priority;
/*  66:    */   private Integer weights;
/*  67:    */   private Integer clicks;
/*  68:    */   private Integer showTimes;
/*  69:    */   private String aexplain;
/*  70:    */   private Boolean enable;
/*  71:    */   private AdvertSlot slot;
/*  72:    */   private Site site;
/*  73:    */   
/*  74:    */   protected void initialize() {}
/*  75:    */   
/*  76:    */   public Integer getId()
/*  77:    */   {
/*  78:102 */     return this.id;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public void setId(Integer id)
/*  82:    */   {
/*  83:112 */     this.id = id;
/*  84:113 */     this.hashCode = -2147483648;
/*  85:    */   }
/*  86:    */   
/*  87:    */   public String getName()
/*  88:    */   {
/*  89:120 */     return this.name;
/*  90:    */   }
/*  91:    */   
/*  92:    */   public void setName(String name)
/*  93:    */   {
/*  94:130 */     this.name = name;
/*  95:    */   }
/*  96:    */   
/*  97:    */   public String getAdvType()
/*  98:    */   {
/*  99:137 */     return this.advType;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public void setAdvType(String advType)
/* 103:    */   {
/* 104:147 */     this.advType = advType;
/* 105:    */   }
/* 106:    */   
/* 107:    */   public String getAttrUrl()
/* 108:    */   {
/* 109:154 */     return this.attrUrl;
/* 110:    */   }
/* 111:    */   
/* 112:    */   public void setAttrUrl(String attrUrl)
/* 113:    */   {
/* 114:164 */     this.attrUrl = attrUrl;
/* 115:    */   }
/* 116:    */   
/* 117:    */   public String getJsstring()
/* 118:    */   {
/* 119:171 */     return this.jsstring;
/* 120:    */   }
/* 121:    */   
/* 122:    */   public void setJsstring(String jsstring)
/* 123:    */   {
/* 124:181 */     this.jsstring = jsstring;
/* 125:    */   }
/* 126:    */   
/* 127:    */   public String getUrl()
/* 128:    */   {
/* 129:188 */     return this.url;
/* 130:    */   }
/* 131:    */   
/* 132:    */   public void setUrl(String url)
/* 133:    */   {
/* 134:198 */     this.url = url;
/* 135:    */   }
/* 136:    */   
/* 137:    */   public Date getStartTime()
/* 138:    */   {
/* 139:205 */     return this.startTime;
/* 140:    */   }
/* 141:    */   
/* 142:    */   public void setStartTime(Date startTime)
/* 143:    */   {
/* 144:215 */     this.startTime = startTime;
/* 145:    */   }
/* 146:    */   
/* 147:    */   public Date getEndTime()
/* 148:    */   {
/* 149:222 */     return this.endTime;
/* 150:    */   }
/* 151:    */   
/* 152:    */   public void setEndTime(Date endTime)
/* 153:    */   {
/* 154:232 */     this.endTime = endTime;
/* 155:    */   }
/* 156:    */   
/* 157:    */   public Integer getPriority()
/* 158:    */   {
/* 159:239 */     return this.priority;
/* 160:    */   }
/* 161:    */   
/* 162:    */   public void setPriority(Integer priority)
/* 163:    */   {
/* 164:249 */     this.priority = priority;
/* 165:    */   }
/* 166:    */   
/* 167:    */   public Integer getWeights()
/* 168:    */   {
/* 169:256 */     return this.weights;
/* 170:    */   }
/* 171:    */   
/* 172:    */   public void setWeights(Integer weights)
/* 173:    */   {
/* 174:266 */     this.weights = weights;
/* 175:    */   }
/* 176:    */   
/* 177:    */   public Integer getClicks()
/* 178:    */   {
/* 179:273 */     return this.clicks;
/* 180:    */   }
/* 181:    */   
/* 182:    */   public void setClicks(Integer clicks)
/* 183:    */   {
/* 184:283 */     this.clicks = clicks;
/* 185:    */   }
/* 186:    */   
/* 187:    */   public Integer getShowTimes()
/* 188:    */   {
/* 189:290 */     return this.showTimes;
/* 190:    */   }
/* 191:    */   
/* 192:    */   public void setShowTimes(Integer showTimes)
/* 193:    */   {
/* 194:300 */     this.showTimes = showTimes;
/* 195:    */   }
/* 196:    */   
/* 197:    */   public String getAexplain()
/* 198:    */   {
/* 199:307 */     return this.aexplain;
/* 200:    */   }
/* 201:    */   
/* 202:    */   public void setAexplain(String aexplain)
/* 203:    */   {
/* 204:317 */     this.aexplain = aexplain;
/* 205:    */   }
/* 206:    */   
/* 207:    */   public Boolean getEnable()
/* 208:    */   {
/* 209:324 */     return this.enable;
/* 210:    */   }
/* 211:    */   
/* 212:    */   public void setEnable(Boolean enable)
/* 213:    */   {
/* 214:334 */     this.enable = enable;
/* 215:    */   }
/* 216:    */   
/* 217:    */   public AdvertSlot getSlot()
/* 218:    */   {
/* 219:341 */     return this.slot;
/* 220:    */   }
/* 221:    */   
/* 222:    */   public void setSlot(AdvertSlot slot)
/* 223:    */   {
/* 224:351 */     this.slot = slot;
/* 225:    */   }
/* 226:    */   
/* 227:    */   public Site getSite()
/* 228:    */   {
/* 229:358 */     return this.site;
/* 230:    */   }
/* 231:    */   
/* 232:    */   public void setSite(Site site)
/* 233:    */   {
/* 234:368 */     this.site = site;
/* 235:    */   }
/* 236:    */   
/* 237:    */   public boolean equals(Object obj)
/* 238:    */   {
/* 239:372 */     if (obj == null) {
/* 240:373 */       return false;
/* 241:    */     }
/* 242:374 */     if (!(obj instanceof Advert)) {
/* 243:375 */       return false;
/* 244:    */     }
/* 245:377 */     Advert advert = (Advert)obj;
/* 246:378 */     if ((getId() == null) || (advert.getId() == null)) {
/* 247:379 */       return false;
/* 248:    */     }
/* 249:381 */     return getId().equals(advert.getId());
/* 250:    */   }
/* 251:    */   
/* 252:    */   public int hashCode()
/* 253:    */   {
/* 254:386 */     if (-2147483648 == this.hashCode)
/* 255:    */     {
/* 256:387 */       if (getId() == null) {
/* 257:388 */         return super.hashCode();
/* 258:    */       }
/* 259:390 */       String hashStr = getClass().getName() + ":" + 
/* 260:391 */         getId().hashCode();
/* 261:392 */       this.hashCode = hashStr.hashCode();
/* 262:    */     }
/* 263:395 */     return this.hashCode;
/* 264:    */   }
/* 265:    */   
/* 266:    */   public String toString()
/* 267:    */   {
/* 268:399 */     return super.toString();
/* 269:    */   }
/* 270:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.entity.base.BaseAdvert
 * JD-Core Version:    0.7.0.1
 */