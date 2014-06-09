/*   1:    */ package com.portal.extrafunc.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.extrafunc.entity.Forum;
/*   4:    */ import com.portal.extrafunc.entity.Theme;
/*   5:    */ import com.portal.extrafunc.entity.ThemeTxt;
/*   6:    */ import com.portal.sysmgr.entity.Site;
/*   7:    */ import com.portal.usermgr.entity.User;
/*   8:    */ import java.io.Serializable;
/*   9:    */ import java.util.Date;
/*  10:    */ 
/*  11:    */ public abstract class BaseTheme
/*  12:    */   implements Serializable
/*  13:    */ {
/*  14: 17 */   public static String REF = "Theme";
/*  15: 18 */   public static String PROP_SITE = "site";
/*  16: 19 */   public static String PROP_REPLY_COUNT = "replyCount";
/*  17: 20 */   public static String PROP_VIEWS_COUNT = "viewsCount";
/*  18: 21 */   public static String PROP_LOCK = "lock";
/*  19: 22 */   public static String PROP_FORUM = "forum";
/*  20: 23 */   public static String PROP_CREATER = "creater";
/*  21: 24 */   public static String PROP_MODER_REPLY = "moderReply";
/*  22: 25 */   public static String PROP_LAST_REPLYER = "lastReplyer";
/*  23: 26 */   public static String PROP_TITLE = "title";
/*  24: 27 */   public static String PROP_COLOR = "color";
/*  25: 28 */   public static String PROP_STATUS = "status";
/*  26: 29 */   public static String PROP_TOP_TIME = "topTime";
/*  27: 30 */   public static String PROP_LOCK_TIME = "lockTime";
/*  28: 31 */   public static String PROP_AFFIX = "affix";
/*  29: 32 */   public static String PROP_TXT = "txt";
/*  30: 33 */   public static String PROP_BOLD = "bold";
/*  31: 34 */   public static String PROP_ESSENA_TIME = "essenaTime";
/*  32: 35 */   public static String PROP_IMG = "img";
/*  33: 36 */   public static String PROP_CREATE_TIME = "createTime";
/*  34: 37 */   public static String PROP_LAST_REPLY_TIME = "lastReplyTime";
/*  35: 38 */   public static String PROP_ID = "id";
/*  36: 39 */   public static String PROP_ITALIC = "italic";
/*  37: 40 */   public static String PROP_ESSENA = "essena";
/*  38:    */   
/*  39:    */   public BaseTheme()
/*  40:    */   {
/*  41: 45 */     initialize();
/*  42:    */   }
/*  43:    */   
/*  44:    */   public BaseTheme(Integer id)
/*  45:    */   {
/*  46: 52 */     setId(id);
/*  47: 53 */     initialize();
/*  48:    */   }
/*  49:    */   
/*  50:    */   public BaseTheme(Integer id, Forum forum, Site site, String title, Integer viewsCount, Integer replyCount, Integer status, Boolean affix, Boolean img, Boolean moderReply, Date createTime)
/*  51:    */   {
/*  52: 72 */     setId(id);
/*  53: 73 */     setForum(forum);
/*  54: 74 */     setSite(site);
/*  55: 75 */     setTitle(title);
/*  56: 76 */     setViewsCount(viewsCount);
/*  57: 77 */     setReplyCount(replyCount);
/*  58: 78 */     setStatus(status);
/*  59: 79 */     setAffix(affix);
/*  60: 80 */     setImg(img);
/*  61: 81 */     setModerReply(moderReply);
/*  62: 82 */     setCreateTime(createTime);
/*  63: 83 */     initialize();
/*  64:    */   }
/*  65:    */   
/*  66: 90 */   private int hashCode = -2147483648;
/*  67:    */   private Integer id;
/*  68:    */   private String title;
/*  69:    */   private Integer viewsCount;
/*  70:    */   private Integer replyCount;
/*  71:    */   private Boolean lock;
/*  72:    */   private Boolean essena;
/*  73:    */   private Boolean bold;
/*  74:    */   private Boolean italic;
/*  75:    */   private String color;
/*  76:    */   private Date topTime;
/*  77:    */   private Date essenaTime;
/*  78:    */   private Date lockTime;
/*  79:    */   private Date lightTime;
/*  80:    */   private Integer status;
/*  81:    */   private Boolean affix;
/*  82:    */   private Boolean img;
/*  83:    */   private Boolean moderReply;
/*  84:    */   private Date lastReplyTime;
/*  85:    */   private Date createTime;
/*  86:    */   private ThemeTxt txt;
/*  87:    */   private User creater;
/*  88:    */   private Forum forum;
/*  89:    */   private Site site;
/*  90:    */   private User lastReplyer;
/*  91:    */   
/*  92:    */   protected void initialize() {}
/*  93:    */   
/*  94:    */   public Integer getId()
/*  95:    */   {
/*  96:133 */     return this.id;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public void setId(Integer id)
/* 100:    */   {
/* 101:141 */     this.id = id;
/* 102:142 */     this.hashCode = -2147483648;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public String getTitle()
/* 106:    */   {
/* 107:152 */     return this.title;
/* 108:    */   }
/* 109:    */   
/* 110:    */   public void setTitle(String title)
/* 111:    */   {
/* 112:160 */     this.title = title;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public Integer getViewsCount()
/* 116:    */   {
/* 117:169 */     return this.viewsCount;
/* 118:    */   }
/* 119:    */   
/* 120:    */   public void setViewsCount(Integer viewsCount)
/* 121:    */   {
/* 122:177 */     this.viewsCount = viewsCount;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public Integer getReplyCount()
/* 126:    */   {
/* 127:186 */     return this.replyCount;
/* 128:    */   }
/* 129:    */   
/* 130:    */   public void setReplyCount(Integer replyCount)
/* 131:    */   {
/* 132:194 */     this.replyCount = replyCount;
/* 133:    */   }
/* 134:    */   
/* 135:    */   public Boolean getLock()
/* 136:    */   {
/* 137:203 */     return this.lock;
/* 138:    */   }
/* 139:    */   
/* 140:    */   public void setLock(Boolean lock)
/* 141:    */   {
/* 142:211 */     this.lock = lock;
/* 143:    */   }
/* 144:    */   
/* 145:    */   public Boolean getEssena()
/* 146:    */   {
/* 147:220 */     return this.essena;
/* 148:    */   }
/* 149:    */   
/* 150:    */   public void setEssena(Boolean essena)
/* 151:    */   {
/* 152:228 */     this.essena = essena;
/* 153:    */   }
/* 154:    */   
/* 155:    */   public Boolean getBold()
/* 156:    */   {
/* 157:237 */     return this.bold;
/* 158:    */   }
/* 159:    */   
/* 160:    */   public void setBold(Boolean bold)
/* 161:    */   {
/* 162:245 */     this.bold = bold;
/* 163:    */   }
/* 164:    */   
/* 165:    */   public Boolean getItalic()
/* 166:    */   {
/* 167:254 */     return this.italic;
/* 168:    */   }
/* 169:    */   
/* 170:    */   public void setItalic(Boolean italic)
/* 171:    */   {
/* 172:262 */     this.italic = italic;
/* 173:    */   }
/* 174:    */   
/* 175:    */   public String getColor()
/* 176:    */   {
/* 177:271 */     return this.color;
/* 178:    */   }
/* 179:    */   
/* 180:    */   public void setColor(String color)
/* 181:    */   {
/* 182:279 */     this.color = color;
/* 183:    */   }
/* 184:    */   
/* 185:    */   public Date getTopTime()
/* 186:    */   {
/* 187:288 */     return this.topTime;
/* 188:    */   }
/* 189:    */   
/* 190:    */   public void setTopTime(Date topTime)
/* 191:    */   {
/* 192:296 */     this.topTime = topTime;
/* 193:    */   }
/* 194:    */   
/* 195:    */   public Date getEssenaTime()
/* 196:    */   {
/* 197:305 */     return this.essenaTime;
/* 198:    */   }
/* 199:    */   
/* 200:    */   public void setEssenaTime(Date essenaTime)
/* 201:    */   {
/* 202:313 */     this.essenaTime = essenaTime;
/* 203:    */   }
/* 204:    */   
/* 205:    */   public Date getLockTime()
/* 206:    */   {
/* 207:319 */     return this.lockTime;
/* 208:    */   }
/* 209:    */   
/* 210:    */   public void setLockTime(Date lockTime)
/* 211:    */   {
/* 212:323 */     this.lockTime = lockTime;
/* 213:    */   }
/* 214:    */   
/* 215:    */   public Date getLightTime()
/* 216:    */   {
/* 217:327 */     return this.lightTime;
/* 218:    */   }
/* 219:    */   
/* 220:    */   public void setLightTime(Date lightTime)
/* 221:    */   {
/* 222:331 */     this.lightTime = lightTime;
/* 223:    */   }
/* 224:    */   
/* 225:    */   public Integer getStatus()
/* 226:    */   {
/* 227:338 */     return this.status;
/* 228:    */   }
/* 229:    */   
/* 230:    */   public void setStatus(Integer status)
/* 231:    */   {
/* 232:346 */     this.status = status;
/* 233:    */   }
/* 234:    */   
/* 235:    */   public Boolean getAffix()
/* 236:    */   {
/* 237:355 */     return this.affix;
/* 238:    */   }
/* 239:    */   
/* 240:    */   public void setAffix(Boolean affix)
/* 241:    */   {
/* 242:363 */     this.affix = affix;
/* 243:    */   }
/* 244:    */   
/* 245:    */   public Boolean getImg()
/* 246:    */   {
/* 247:372 */     return this.img;
/* 248:    */   }
/* 249:    */   
/* 250:    */   public void setImg(Boolean img)
/* 251:    */   {
/* 252:380 */     this.img = img;
/* 253:    */   }
/* 254:    */   
/* 255:    */   public Boolean getModerReply()
/* 256:    */   {
/* 257:389 */     return this.moderReply;
/* 258:    */   }
/* 259:    */   
/* 260:    */   public void setModerReply(Boolean moderReply)
/* 261:    */   {
/* 262:397 */     this.moderReply = moderReply;
/* 263:    */   }
/* 264:    */   
/* 265:    */   public Date getLastReplyTime()
/* 266:    */   {
/* 267:406 */     return this.lastReplyTime;
/* 268:    */   }
/* 269:    */   
/* 270:    */   public void setLastReplyTime(Date lastReplyTime)
/* 271:    */   {
/* 272:414 */     this.lastReplyTime = lastReplyTime;
/* 273:    */   }
/* 274:    */   
/* 275:    */   public Date getCreateTime()
/* 276:    */   {
/* 277:423 */     return this.createTime;
/* 278:    */   }
/* 279:    */   
/* 280:    */   public void setCreateTime(Date createTime)
/* 281:    */   {
/* 282:431 */     this.createTime = createTime;
/* 283:    */   }
/* 284:    */   
/* 285:    */   public ThemeTxt getTxt()
/* 286:    */   {
/* 287:439 */     return this.txt;
/* 288:    */   }
/* 289:    */   
/* 290:    */   public void setTxt(ThemeTxt txt)
/* 291:    */   {
/* 292:447 */     this.txt = txt;
/* 293:    */   }
/* 294:    */   
/* 295:    */   public User getCreater()
/* 296:    */   {
/* 297:456 */     return this.creater;
/* 298:    */   }
/* 299:    */   
/* 300:    */   public void setCreater(User creater)
/* 301:    */   {
/* 302:464 */     this.creater = creater;
/* 303:    */   }
/* 304:    */   
/* 305:    */   public Forum getForum()
/* 306:    */   {
/* 307:473 */     return this.forum;
/* 308:    */   }
/* 309:    */   
/* 310:    */   public void setForum(Forum forum)
/* 311:    */   {
/* 312:481 */     this.forum = forum;
/* 313:    */   }
/* 314:    */   
/* 315:    */   public Site getSite()
/* 316:    */   {
/* 317:490 */     return this.site;
/* 318:    */   }
/* 319:    */   
/* 320:    */   public void setSite(Site site)
/* 321:    */   {
/* 322:498 */     this.site = site;
/* 323:    */   }
/* 324:    */   
/* 325:    */   public User getLastReplyer()
/* 326:    */   {
/* 327:507 */     return this.lastReplyer;
/* 328:    */   }
/* 329:    */   
/* 330:    */   public void setLastReplyer(User lastReplyer)
/* 331:    */   {
/* 332:515 */     this.lastReplyer = lastReplyer;
/* 333:    */   }
/* 334:    */   
/* 335:    */   public boolean equals(Object obj)
/* 336:    */   {
/* 337:522 */     if (obj == null) {
/* 338:522 */       return false;
/* 339:    */     }
/* 340:523 */     if (!(obj instanceof Theme)) {
/* 341:523 */       return false;
/* 342:    */     }
/* 343:525 */     Theme theme = (Theme)obj;
/* 344:526 */     if ((getId() == null) || (theme.getId() == null)) {
/* 345:526 */       return false;
/* 346:    */     }
/* 347:527 */     return getId().equals(theme.getId());
/* 348:    */   }
/* 349:    */   
/* 350:    */   public int hashCode()
/* 351:    */   {
/* 352:532 */     if (-2147483648 == this.hashCode)
/* 353:    */     {
/* 354:533 */       if (getId() == null) {
/* 355:533 */         return super.hashCode();
/* 356:    */       }
/* 357:535 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 358:536 */       this.hashCode = hashStr.hashCode();
/* 359:    */     }
/* 360:539 */     return this.hashCode;
/* 361:    */   }
/* 362:    */   
/* 363:    */   public String toString()
/* 364:    */   {
/* 365:544 */     return super.toString();
/* 366:    */   }
/* 367:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.entity.base.BaseTheme
 * JD-Core Version:    0.7.0.1
 */