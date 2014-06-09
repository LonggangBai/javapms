/*   1:    */ package com.portal.doccenter.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.doccenter.entity.Article;
/*   4:    */ import com.portal.doccenter.entity.ArticleExt;
/*   5:    */ import java.io.Serializable;
/*   6:    */ import java.util.Date;
/*   7:    */ 
/*   8:    */ public abstract class BaseArticleExt
/*   9:    */   implements Serializable
/*  10:    */ {
/*  11: 15 */   public static String REF = "ArticleExt";
/*  12: 16 */   public static String PROP_DESCRIPTION = "description";
/*  13: 17 */   public static String PROP_REDTAPE_ORIGIN = "redtapeOrigin";
/*  14: 18 */   public static String PROP_TIME_HOUR = "timeHour";
/*  15: 19 */   public static String PROP_AUTHOR = "author";
/*  16: 20 */   public static String PROP_ORIGIN = "origin";
/*  17: 21 */   public static String PROP_TAG_STR = "tagStr";
/*  18: 22 */   public static String PROP_TIME_DAY = "timeDay";
/*  19: 23 */   public static String PROP_COMMENT_CONTROL = "commentControl";
/*  20: 24 */   public static String PROP_ARTICLE = "article";
/*  21: 25 */   public static String PROP_ORIGIN_URL = "originUrl";
/*  22: 26 */   public static String PROP_SHOW_INDEX = "showIndex";
/*  23: 27 */   public static String PROP_LINK = "link";
/*  24: 28 */   public static String PROP_RED_TAPE = "redTape";
/*  25: 29 */   public static String PROP_UPDOWN_CONTROL = "updownControl";
/*  26: 30 */   public static String PROP_SUB_TITLE = "subTitle";
/*  27: 31 */   public static String PROP_ID = "id";
/*  28: 32 */   public static String PROP_TPL_CONTENT = "tplContent";
/*  29:    */   
/*  30:    */   public BaseArticleExt()
/*  31:    */   {
/*  32: 36 */     initialize();
/*  33:    */   }
/*  34:    */   
/*  35:    */   public BaseArticleExt(Integer id)
/*  36:    */   {
/*  37: 43 */     setId(id);
/*  38: 44 */     initialize();
/*  39:    */   }
/*  40:    */   
/*  41:    */   public BaseArticleExt(Integer id, Boolean redTape)
/*  42:    */   {
/*  43: 52 */     setId(id);
/*  44: 53 */     setRedTape(redTape);
/*  45: 54 */     initialize();
/*  46:    */   }
/*  47:    */   
/*  48: 60 */   private int hashCode = -2147483648;
/*  49:    */   private Integer id;
/*  50:    */   private String subTitle;
/*  51:    */   private String author;
/*  52:    */   private String origin;
/*  53:    */   private String originUrl;
/*  54:    */   private String tagStr;
/*  55:    */   private Boolean showIndex;
/*  56:    */   private Boolean redTape;
/*  57:    */   private String redtapeOrigin;
/*  58:    */   private String description;
/*  59:    */   private String tplContent;
/*  60:    */   private String link;
/*  61:    */   private Boolean commentControl;
/*  62:    */   private Boolean updownControl;
/*  63:    */   private Date timeDay;
/*  64:    */   private Date timeHour;
/*  65:    */   private Article article;
/*  66:    */   
/*  67:    */   protected void initialize() {}
/*  68:    */   
/*  69:    */   public Integer getId()
/*  70:    */   {
/*  71: 91 */     return this.id;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public void setId(Integer id)
/*  75:    */   {
/*  76:101 */     this.id = id;
/*  77:102 */     this.hashCode = -2147483648;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public String getSubTitle()
/*  81:    */   {
/*  82:109 */     return this.subTitle;
/*  83:    */   }
/*  84:    */   
/*  85:    */   public void setSubTitle(String subTitle)
/*  86:    */   {
/*  87:119 */     this.subTitle = subTitle;
/*  88:    */   }
/*  89:    */   
/*  90:    */   public String getAuthor()
/*  91:    */   {
/*  92:126 */     return this.author;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public void setAuthor(String author)
/*  96:    */   {
/*  97:136 */     this.author = author;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public String getOrigin()
/* 101:    */   {
/* 102:143 */     return this.origin;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public void setOrigin(String origin)
/* 106:    */   {
/* 107:153 */     this.origin = origin;
/* 108:    */   }
/* 109:    */   
/* 110:    */   public String getOriginUrl()
/* 111:    */   {
/* 112:160 */     return this.originUrl;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public void setOriginUrl(String originUrl)
/* 116:    */   {
/* 117:170 */     this.originUrl = originUrl;
/* 118:    */   }
/* 119:    */   
/* 120:    */   public String getTagStr()
/* 121:    */   {
/* 122:174 */     return this.tagStr;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public void setTagStr(String tagStr)
/* 126:    */   {
/* 127:178 */     this.tagStr = tagStr;
/* 128:    */   }
/* 129:    */   
/* 130:    */   public Boolean getShowIndex()
/* 131:    */   {
/* 132:185 */     return this.showIndex;
/* 133:    */   }
/* 134:    */   
/* 135:    */   public void setShowIndex(Boolean showIndex)
/* 136:    */   {
/* 137:195 */     this.showIndex = showIndex;
/* 138:    */   }
/* 139:    */   
/* 140:    */   public Boolean getRedTape()
/* 141:    */   {
/* 142:202 */     return this.redTape;
/* 143:    */   }
/* 144:    */   
/* 145:    */   public void setRedTape(Boolean redTape)
/* 146:    */   {
/* 147:212 */     this.redTape = redTape;
/* 148:    */   }
/* 149:    */   
/* 150:    */   public String getRedtapeOrigin()
/* 151:    */   {
/* 152:219 */     return this.redtapeOrigin;
/* 153:    */   }
/* 154:    */   
/* 155:    */   public void setRedtapeOrigin(String redtapeOrigin)
/* 156:    */   {
/* 157:229 */     this.redtapeOrigin = redtapeOrigin;
/* 158:    */   }
/* 159:    */   
/* 160:    */   public String getDescription()
/* 161:    */   {
/* 162:236 */     return this.description;
/* 163:    */   }
/* 164:    */   
/* 165:    */   public void setDescription(String description)
/* 166:    */   {
/* 167:246 */     this.description = description;
/* 168:    */   }
/* 169:    */   
/* 170:    */   public String getTplContent()
/* 171:    */   {
/* 172:253 */     return this.tplContent;
/* 173:    */   }
/* 174:    */   
/* 175:    */   public void setTplContent(String tplContent)
/* 176:    */   {
/* 177:263 */     this.tplContent = tplContent;
/* 178:    */   }
/* 179:    */   
/* 180:    */   public String getLink()
/* 181:    */   {
/* 182:270 */     return this.link;
/* 183:    */   }
/* 184:    */   
/* 185:    */   public void setLink(String link)
/* 186:    */   {
/* 187:280 */     this.link = link;
/* 188:    */   }
/* 189:    */   
/* 190:    */   public Boolean getCommentControl()
/* 191:    */   {
/* 192:287 */     return this.commentControl;
/* 193:    */   }
/* 194:    */   
/* 195:    */   public void setCommentControl(Boolean commentControl)
/* 196:    */   {
/* 197:297 */     this.commentControl = commentControl;
/* 198:    */   }
/* 199:    */   
/* 200:    */   public Boolean getUpdownControl()
/* 201:    */   {
/* 202:304 */     return this.updownControl;
/* 203:    */   }
/* 204:    */   
/* 205:    */   public void setUpdownControl(Boolean updownControl)
/* 206:    */   {
/* 207:314 */     this.updownControl = updownControl;
/* 208:    */   }
/* 209:    */   
/* 210:    */   public Date getTimeDay()
/* 211:    */   {
/* 212:321 */     return this.timeDay;
/* 213:    */   }
/* 214:    */   
/* 215:    */   public void setTimeDay(Date timeDay)
/* 216:    */   {
/* 217:331 */     this.timeDay = timeDay;
/* 218:    */   }
/* 219:    */   
/* 220:    */   public Date getTimeHour()
/* 221:    */   {
/* 222:338 */     return this.timeHour;
/* 223:    */   }
/* 224:    */   
/* 225:    */   public void setTimeHour(Date timeHour)
/* 226:    */   {
/* 227:348 */     this.timeHour = timeHour;
/* 228:    */   }
/* 229:    */   
/* 230:    */   public Article getArticle()
/* 231:    */   {
/* 232:355 */     return this.article;
/* 233:    */   }
/* 234:    */   
/* 235:    */   public void setArticle(Article article)
/* 236:    */   {
/* 237:365 */     this.article = article;
/* 238:    */   }
/* 239:    */   
/* 240:    */   public boolean equals(Object obj)
/* 241:    */   {
/* 242:369 */     if (obj == null) {
/* 243:370 */       return false;
/* 244:    */     }
/* 245:371 */     if (!(obj instanceof ArticleExt)) {
/* 246:372 */       return false;
/* 247:    */     }
/* 248:374 */     ArticleExt articleExt = (ArticleExt)obj;
/* 249:375 */     if ((getId() == null) || (articleExt.getId() == null)) {
/* 250:376 */       return false;
/* 251:    */     }
/* 252:378 */     return getId().equals(articleExt.getId());
/* 253:    */   }
/* 254:    */   
/* 255:    */   public int hashCode()
/* 256:    */   {
/* 257:383 */     if (-2147483648 == this.hashCode)
/* 258:    */     {
/* 259:384 */       if (getId() == null) {
/* 260:385 */         return super.hashCode();
/* 261:    */       }
/* 262:387 */       String hashStr = getClass().getName() + ":" + 
/* 263:388 */         getId().hashCode();
/* 264:389 */       this.hashCode = hashStr.hashCode();
/* 265:    */     }
/* 266:392 */     return this.hashCode;
/* 267:    */   }
/* 268:    */   
/* 269:    */   public String toString()
/* 270:    */   {
/* 271:396 */     return super.toString();
/* 272:    */   }
/* 273:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.entity.base.BaseArticleExt
 * JD-Core Version:    0.7.0.1
 */