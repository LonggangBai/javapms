/*   1:    */ package com.portal.doccenter.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.doccenter.entity.Article;
/*   4:    */ import com.portal.doccenter.entity.ArticleAttachment;
/*   5:    */ import com.portal.doccenter.entity.ArticleExt;
/*   6:    */ import com.portal.doccenter.entity.ArticlePicture;
/*   7:    */ import com.portal.doccenter.entity.ArticleTxt;
/*   8:    */ import com.portal.doccenter.entity.Channel;
/*   9:    */ import com.portal.doccenter.entity.DocStatis;
/*  10:    */ import com.portal.doccenter.entity.Model;
/*  11:    */ import com.portal.sysmgr.entity.Site;
/*  12:    */ import com.portal.usermgr.entity.Depart;
/*  13:    */ import com.portal.usermgr.entity.Group;
/*  14:    */ import com.portal.usermgr.entity.User;
/*  15:    */ import java.io.Serializable;
/*  16:    */ import java.util.Date;
/*  17:    */ import java.util.List;
/*  18:    */ import java.util.Map;
/*  19:    */ import java.util.Set;
/*  20:    */ 
/*  21:    */ public abstract class BaseArticle
/*  22:    */   implements Serializable
/*  23:    */ {
/*  24: 15 */   public static String REF = "Article";
/*  25: 16 */   public static String PROP_SHORT_TITLE = "shortTitle";
/*  26: 17 */   public static String PROP_TITLE_COLOR = "titleColor";
/*  27: 18 */   public static String PROP_USER = "user";
/*  28: 19 */   public static String PROP_RELEASE_DATE = "releaseDate";
/*  29: 20 */   public static String PROP_TOP = "top";
/*  30: 21 */   public static String PROP_SITE = "site";
/*  31: 22 */   public static String PROP_MODEL = "model";
/*  32: 23 */   public static String PROP_CHANNEL = "channel";
/*  33: 24 */   public static String PROP_STYLE = "style";
/*  34: 25 */   public static String PROP_CHECK_USER = "checkUser";
/*  35: 26 */   public static String PROP_TITLE = "title";
/*  36: 27 */   public static String PROP_RECOMMEND = "recommend";
/*  37: 28 */   public static String PROP_STATUS = "status";
/*  38: 29 */   public static String PROP_INPUT_DEPART = "inputDepart";
/*  39: 30 */   public static String PROP_BOLD = "bold";
/*  40: 31 */   public static String PROP_ARTICLE_TXT = "articleTxt";
/*  41: 32 */   public static String PROP_ARTICLE_EXT = "articleExt";
/*  42: 33 */   public static String PROP_ID = "id";
/*  43:    */   
/*  44:    */   public BaseArticle()
/*  45:    */   {
/*  46: 37 */     initialize();
/*  47:    */   }
/*  48:    */   
/*  49:    */   public BaseArticle(Integer id)
/*  50:    */   {
/*  51: 44 */     setId(id);
/*  52: 45 */     initialize();
/*  53:    */   }
/*  54:    */   
/*  55:    */   public BaseArticle(Integer id, Site site, Model model)
/*  56:    */   {
/*  57: 55 */     setId(id);
/*  58: 56 */     setSite(site);
/*  59: 57 */     setModel(model);
/*  60: 58 */     initialize();
/*  61:    */   }
/*  62:    */   
/*  63: 64 */   private int hashCode = -2147483648;
/*  64:    */   private Integer id;
/*  65:    */   private String title;
/*  66:    */   private String shortTitle;
/*  67:    */   private Date releaseDate;
/*  68:    */   private String titleColor;
/*  69:    */   private Boolean bold;
/*  70:    */   private Boolean top;
/*  71:    */   private Boolean recommend;
/*  72:    */   private Byte status;
/*  73:    */   private Integer step;
/*  74:    */   private String style;
/*  75:    */   private ArticleExt articleExt;
/*  76:    */   private ArticleTxt articleTxt;
/*  77:    */   private DocStatis docStatis;
/*  78:    */   private Site site;
/*  79:    */   private Model model;
/*  80:    */   private User user;
/*  81:    */   private Depart inputDepart;
/*  82:    */   private User checkUser;
/*  83:    */   private Channel channel;
/*  84:    */   private Set<Channel> channels;
/*  85:    */   private Set<Group> viewGroups;
/*  86:    */   private List<ArticlePicture> pics;
/*  87:    */   private List<ArticleAttachment> atts;
/*  88:    */   private Map<String, String> attr;
/*  89:    */   
/*  90:    */   protected void initialize() {}
/*  91:    */   
/*  92:    */   public Integer getId()
/*  93:    */   {
/*  94:107 */     return this.id;
/*  95:    */   }
/*  96:    */   
/*  97:    */   public void setId(Integer id)
/*  98:    */   {
/*  99:117 */     this.id = id;
/* 100:118 */     this.hashCode = -2147483648;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public String getTitle()
/* 104:    */   {
/* 105:125 */     return this.title;
/* 106:    */   }
/* 107:    */   
/* 108:    */   public void setTitle(String title)
/* 109:    */   {
/* 110:135 */     this.title = title;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public String getShortTitle()
/* 114:    */   {
/* 115:142 */     return this.shortTitle;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public void setShortTitle(String shortTitle)
/* 119:    */   {
/* 120:152 */     this.shortTitle = shortTitle;
/* 121:    */   }
/* 122:    */   
/* 123:    */   public Date getReleaseDate()
/* 124:    */   {
/* 125:159 */     return this.releaseDate;
/* 126:    */   }
/* 127:    */   
/* 128:    */   public void setReleaseDate(Date releaseDate)
/* 129:    */   {
/* 130:169 */     this.releaseDate = releaseDate;
/* 131:    */   }
/* 132:    */   
/* 133:    */   public String getTitleColor()
/* 134:    */   {
/* 135:176 */     return this.titleColor;
/* 136:    */   }
/* 137:    */   
/* 138:    */   public void setTitleColor(String titleColor)
/* 139:    */   {
/* 140:186 */     this.titleColor = titleColor;
/* 141:    */   }
/* 142:    */   
/* 143:    */   public Boolean getBold()
/* 144:    */   {
/* 145:193 */     return this.bold;
/* 146:    */   }
/* 147:    */   
/* 148:    */   public void setBold(Boolean bold)
/* 149:    */   {
/* 150:203 */     this.bold = bold;
/* 151:    */   }
/* 152:    */   
/* 153:    */   public Boolean getTop()
/* 154:    */   {
/* 155:210 */     return this.top;
/* 156:    */   }
/* 157:    */   
/* 158:    */   public void setTop(Boolean top)
/* 159:    */   {
/* 160:220 */     this.top = top;
/* 161:    */   }
/* 162:    */   
/* 163:    */   public Boolean getRecommend()
/* 164:    */   {
/* 165:227 */     return this.recommend;
/* 166:    */   }
/* 167:    */   
/* 168:    */   public void setRecommend(Boolean recommend)
/* 169:    */   {
/* 170:237 */     this.recommend = recommend;
/* 171:    */   }
/* 172:    */   
/* 173:    */   public Byte getStatus()
/* 174:    */   {
/* 175:244 */     return this.status;
/* 176:    */   }
/* 177:    */   
/* 178:    */   public void setStatus(Byte status)
/* 179:    */   {
/* 180:254 */     this.status = status;
/* 181:    */   }
/* 182:    */   
/* 183:    */   public Integer getStep()
/* 184:    */   {
/* 185:258 */     return this.step;
/* 186:    */   }
/* 187:    */   
/* 188:    */   public void setStep(Integer step)
/* 189:    */   {
/* 190:262 */     this.step = step;
/* 191:    */   }
/* 192:    */   
/* 193:    */   public String getStyle()
/* 194:    */   {
/* 195:269 */     return this.style;
/* 196:    */   }
/* 197:    */   
/* 198:    */   public void setStyle(String style)
/* 199:    */   {
/* 200:279 */     this.style = style;
/* 201:    */   }
/* 202:    */   
/* 203:    */   public ArticleExt getArticleExt()
/* 204:    */   {
/* 205:286 */     return this.articleExt;
/* 206:    */   }
/* 207:    */   
/* 208:    */   public void setArticleExt(ArticleExt articleExt)
/* 209:    */   {
/* 210:296 */     this.articleExt = articleExt;
/* 211:    */   }
/* 212:    */   
/* 213:    */   public ArticleTxt getArticleTxt()
/* 214:    */   {
/* 215:303 */     return this.articleTxt;
/* 216:    */   }
/* 217:    */   
/* 218:    */   public void setArticleTxt(ArticleTxt articleTxt)
/* 219:    */   {
/* 220:313 */     this.articleTxt = articleTxt;
/* 221:    */   }
/* 222:    */   
/* 223:    */   public DocStatis getDocStatis()
/* 224:    */   {
/* 225:317 */     return this.docStatis;
/* 226:    */   }
/* 227:    */   
/* 228:    */   public void setDocStatis(DocStatis docStatis)
/* 229:    */   {
/* 230:321 */     this.docStatis = docStatis;
/* 231:    */   }
/* 232:    */   
/* 233:    */   public Site getSite()
/* 234:    */   {
/* 235:328 */     return this.site;
/* 236:    */   }
/* 237:    */   
/* 238:    */   public void setSite(Site site)
/* 239:    */   {
/* 240:338 */     this.site = site;
/* 241:    */   }
/* 242:    */   
/* 243:    */   public Model getModel()
/* 244:    */   {
/* 245:345 */     return this.model;
/* 246:    */   }
/* 247:    */   
/* 248:    */   public void setModel(Model model)
/* 249:    */   {
/* 250:355 */     this.model = model;
/* 251:    */   }
/* 252:    */   
/* 253:    */   public User getUser()
/* 254:    */   {
/* 255:362 */     return this.user;
/* 256:    */   }
/* 257:    */   
/* 258:    */   public void setUser(User user)
/* 259:    */   {
/* 260:372 */     this.user = user;
/* 261:    */   }
/* 262:    */   
/* 263:    */   public Depart getInputDepart()
/* 264:    */   {
/* 265:376 */     return this.inputDepart;
/* 266:    */   }
/* 267:    */   
/* 268:    */   public void setInputDepart(Depart inputDepart)
/* 269:    */   {
/* 270:380 */     this.inputDepart = inputDepart;
/* 271:    */   }
/* 272:    */   
/* 273:    */   public User getCheckUser()
/* 274:    */   {
/* 275:387 */     return this.checkUser;
/* 276:    */   }
/* 277:    */   
/* 278:    */   public void setCheckUser(User checkUser)
/* 279:    */   {
/* 280:397 */     this.checkUser = checkUser;
/* 281:    */   }
/* 282:    */   
/* 283:    */   public Channel getChannel()
/* 284:    */   {
/* 285:404 */     return this.channel;
/* 286:    */   }
/* 287:    */   
/* 288:    */   public void setChannel(Channel channel)
/* 289:    */   {
/* 290:414 */     this.channel = channel;
/* 291:    */   }
/* 292:    */   
/* 293:    */   public Set<Channel> getChannels()
/* 294:    */   {
/* 295:421 */     return this.channels;
/* 296:    */   }
/* 297:    */   
/* 298:    */   public void setChannels(Set<Channel> channels)
/* 299:    */   {
/* 300:432 */     this.channels = channels;
/* 301:    */   }
/* 302:    */   
/* 303:    */   public Set<Group> getViewGroups()
/* 304:    */   {
/* 305:439 */     return this.viewGroups;
/* 306:    */   }
/* 307:    */   
/* 308:    */   public void setViewGroups(Set<Group> viewGroups)
/* 309:    */   {
/* 310:450 */     this.viewGroups = viewGroups;
/* 311:    */   }
/* 312:    */   
/* 313:    */   public List<ArticlePicture> getPics()
/* 314:    */   {
/* 315:457 */     return this.pics;
/* 316:    */   }
/* 317:    */   
/* 318:    */   public void setPics(List<ArticlePicture> pics)
/* 319:    */   {
/* 320:468 */     this.pics = pics;
/* 321:    */   }
/* 322:    */   
/* 323:    */   public List<ArticleAttachment> getAtts()
/* 324:    */   {
/* 325:475 */     return this.atts;
/* 326:    */   }
/* 327:    */   
/* 328:    */   public void setAtts(List<ArticleAttachment> atts)
/* 329:    */   {
/* 330:486 */     this.atts = atts;
/* 331:    */   }
/* 332:    */   
/* 333:    */   public Map<String, String> getAttr()
/* 334:    */   {
/* 335:493 */     return this.attr;
/* 336:    */   }
/* 337:    */   
/* 338:    */   public void setAttr(Map<String, String> attr)
/* 339:    */   {
/* 340:503 */     this.attr = attr;
/* 341:    */   }
/* 342:    */   
/* 343:    */   public boolean equals(Object obj)
/* 344:    */   {
/* 345:507 */     if (obj == null) {
/* 346:508 */       return false;
/* 347:    */     }
/* 348:509 */     if (!(obj instanceof Article)) {
/* 349:510 */       return false;
/* 350:    */     }
/* 351:512 */     Article article = (Article)obj;
/* 352:513 */     if ((getId() == null) || (article.getId() == null)) {
/* 353:514 */       return false;
/* 354:    */     }
/* 355:516 */     return getId().equals(article.getId());
/* 356:    */   }
/* 357:    */   
/* 358:    */   public int hashCode()
/* 359:    */   {
/* 360:521 */     if (-2147483648 == this.hashCode)
/* 361:    */     {
/* 362:522 */       if (getId() == null) {
/* 363:523 */         return super.hashCode();
/* 364:    */       }
/* 365:525 */       String hashStr = getClass().getName() + ":" + 
/* 366:526 */         getId().hashCode();
/* 367:527 */       this.hashCode = hashStr.hashCode();
/* 368:    */     }
/* 369:530 */     return this.hashCode;
/* 370:    */   }
/* 371:    */   
/* 372:    */   public String toString()
/* 373:    */   {
/* 374:534 */     return super.toString();
/* 375:    */   }
/* 376:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.entity.base.BaseArticle
 * JD-Core Version:    0.7.0.1
 */