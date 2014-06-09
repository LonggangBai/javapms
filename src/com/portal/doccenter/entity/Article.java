/*   1:    */ package com.portal.doccenter.entity;
/*   2:    */ 
/*   3:    */ import com.portal.doccenter.entity.base.BaseArticle;
/*   4:    */ import com.portal.sysmgr.entity.Site;
/*   5:    */ import com.portal.usermgr.entity.Group;
/*   6:    */ import java.sql.Timestamp;
/*   7:    */ import java.util.ArrayList;
/*   8:    */ import java.util.Date;
/*   9:    */ import java.util.HashSet;
/*  10:    */ import java.util.List;
/*  11:    */ import java.util.Set;
/*  12:    */ import org.apache.commons.lang.StringUtils;
/*  13:    */ 
/*  14:    */ public class Article
/*  15:    */   extends BaseArticle
/*  16:    */ {
/*  17:    */   private static final long serialVersionUID = 1L;
/*  18:    */   public static final byte BACK = -1;
/*  19:    */   public static final byte CHECKING = 1;
/*  20:    */   public static final byte CHECKED = 2;
/*  21:    */   public static final byte RECYCLE = 3;
/*  22:    */   public static final String DOC_URL = "doc";
/*  23:    */   
/*  24:    */   public String getUrl()
/*  25:    */   {
/*  26: 44 */     StringBuilder sb = new StringBuilder(getSite().getUrl());
/*  27: 45 */     sb.append("doc");
/*  28: 46 */     sb.append("/");
/*  29: 47 */     sb.append(getId());
/*  30: 48 */     sb.append(".jsp");
/*  31: 49 */     return sb.toString();
/*  32:    */   }
/*  33:    */   
/*  34:    */   public String getUrl(Integer page)
/*  35:    */   {
/*  36: 53 */     if (page == null) {
/*  37: 54 */       page = Integer.valueOf(1);
/*  38:    */     }
/*  39: 56 */     StringBuilder sb = new StringBuilder(getSite().getUrl());
/*  40: 57 */     sb.append("doc");
/*  41: 58 */     sb.append("/");
/*  42: 59 */     sb.append(getId());
/*  43: 60 */     sb.append("_");
/*  44: 61 */     sb.append(page);
/*  45: 62 */     sb.append(".jsp");
/*  46: 63 */     return sb.toString();
/*  47:    */   }
/*  48:    */   
/*  49:    */   public void addToChannels(Channel channel)
/*  50:    */   {
/*  51: 67 */     Set<Channel> channels = getChannels();
/*  52: 68 */     if (channels == null)
/*  53:    */     {
/*  54: 69 */       channels = new HashSet();
/*  55: 70 */       setChannels(channels);
/*  56:    */     }
/*  57: 72 */     channels.add(channel);
/*  58:    */   }
/*  59:    */   
/*  60:    */   public void addToGroups(Group group)
/*  61:    */   {
/*  62: 76 */     Set<Group> groups = getViewGroups();
/*  63: 77 */     if (groups == null)
/*  64:    */     {
/*  65: 78 */       groups = new HashSet();
/*  66: 79 */       setViewGroups(groups);
/*  67:    */     }
/*  68: 81 */     groups.add(group);
/*  69:    */   }
/*  70:    */   
/*  71:    */   public void addToAttachmemts(String path, String name)
/*  72:    */   {
/*  73: 85 */     List<ArticleAttachment> list = getAtts();
/*  74: 86 */     if (list == null)
/*  75:    */     {
/*  76: 87 */       list = new ArrayList();
/*  77: 88 */       setAtts(list);
/*  78:    */     }
/*  79: 90 */     ArticleAttachment ca = new ArticleAttachment(path, name, Integer.valueOf(0));
/*  80: 91 */     list.add(ca);
/*  81:    */   }
/*  82:    */   
/*  83:    */   public void addToPictures(String path, String desc, Boolean thumb, String style)
/*  84:    */   {
/*  85: 96 */     List<ArticlePicture> list = getPics();
/*  86: 97 */     if (list == null)
/*  87:    */     {
/*  88: 98 */       list = new ArrayList();
/*  89: 99 */       setPics(list);
/*  90:    */     }
/*  91:101 */     ArticlePicture ap = new ArticlePicture();
/*  92:102 */     ap.setImgPath(path);
/*  93:103 */     ap.setDescription(desc);
/*  94:104 */     ap.setThumb(thumb);
/*  95:105 */     ap.setStyle(style);
/*  96:106 */     list.add(ap);
/*  97:    */   }
/*  98:    */   
/*  99:    */   public String getStatusString()
/* 100:    */   {
/* 101:110 */     Byte status = getStatus();
/* 102:111 */     if (status.byteValue() == 2) {
/* 103:112 */       return "<span style='color:blue'>已审核</span>";
/* 104:    */     }
/* 105:113 */     if (status.byteValue() == 3) {
/* 106:114 */       return "<span style='color:red'>回收站</span>";
/* 107:    */     }
/* 108:115 */     if (status.byteValue() == 1) {
/* 109:116 */       return "<span style='color:red'>审核中</span>";
/* 110:    */     }
/* 111:118 */     return "<span style='color:red'>退稿</span>";
/* 112:    */   }
/* 113:    */   
/* 114:    */   public Set<Group> getViewGroupsExt()
/* 115:    */   {
/* 116:123 */     Set<Group> set = getViewGroups();
/* 117:124 */     if ((set != null) && (set.size() > 0)) {
/* 118:125 */       return set;
/* 119:    */     }
/* 120:127 */     return getChannel().getViewGroups();
/* 121:    */   }
/* 122:    */   
/* 123:    */   public String getTplContentOrDef()
/* 124:    */   {
/* 125:132 */     String tpl = getTplContent();
/* 126:133 */     String root = getSite().getSolutionPath();
/* 127:134 */     if (!StringUtils.isBlank(tpl)) {
/* 128:135 */       return root + tpl;
/* 129:    */     }
/* 130:137 */     return root + getChannel().getTplDoc(getModel().getId());
/* 131:    */   }
/* 132:    */   
/* 133:    */   public void init()
/* 134:    */   {
/* 135:142 */     if (getRecommend() == null) {
/* 136:143 */       setRecommend(Boolean.valueOf(false));
/* 137:    */     }
/* 138:145 */     if (getReleaseDate() == null) {
/* 139:146 */       setReleaseDate(new Timestamp(System.currentTimeMillis()));
/* 140:    */     }
/* 141:148 */     if (getTop() == null) {
/* 142:149 */       setTop(Boolean.valueOf(false));
/* 143:    */     }
/* 144:151 */     if (getChannels() == null) {
/* 145:152 */       setChannels(new HashSet());
/* 146:    */     }
/* 147:154 */     if (getViewGroups() == null) {
/* 148:155 */       setViewGroups(new HashSet());
/* 149:    */     }
/* 150:157 */     if (getPics() == null) {
/* 151:158 */       setPics(new ArrayList());
/* 152:    */     }
/* 153:160 */     if (getAtts() == null) {
/* 154:161 */       setAtts(new ArrayList());
/* 155:    */     }
/* 156:    */   }
/* 157:    */   
/* 158:    */   public int getPageCount()
/* 159:    */   {
/* 160:166 */     int txtCount = getTxtCount();
/* 161:167 */     if (txtCount <= 1)
/* 162:    */     {
/* 163:168 */       List<ArticlePicture> pics = getPics();
/* 164:169 */       if (pics != null)
/* 165:    */       {
/* 166:170 */         int picCount = pics.size();
/* 167:171 */         if (picCount > 1) {
/* 168:172 */           return picCount;
/* 169:    */         }
/* 170:    */       }
/* 171:    */     }
/* 172:176 */     return txtCount;
/* 173:    */   }
/* 174:    */   
/* 175:    */   public int getTxtCount()
/* 176:    */   {
/* 177:180 */     ArticleTxt txt = getArticleTxt();
/* 178:181 */     if (txt != null) {
/* 179:182 */       return txt.getTxtCount();
/* 180:    */     }
/* 181:184 */     return 1;
/* 182:    */   }
/* 183:    */   
/* 184:    */   public String getTxtByNo(int pageNo)
/* 185:    */   {
/* 186:189 */     ArticleTxt txt = getArticleTxt();
/* 187:190 */     if (txt != null) {
/* 188:191 */       return txt.getTxtByNo(pageNo);
/* 189:    */     }
/* 190:193 */     return null;
/* 191:    */   }
/* 192:    */   
/* 193:    */   public Integer getViewsCount()
/* 194:    */   {
/* 195:198 */     DocStatis ds = getDocStatis();
/* 196:199 */     if (ds != null) {
/* 197:200 */       return ds.getViewsCount();
/* 198:    */     }
/* 199:202 */     return Integer.valueOf(0);
/* 200:    */   }
/* 201:    */   
/* 202:    */   public Integer getCommentCount()
/* 203:    */   {
/* 204:206 */     DocStatis ds = getDocStatis();
/* 205:207 */     if (ds != null) {
/* 206:208 */       return ds.getCommentCount();
/* 207:    */     }
/* 208:210 */     return Integer.valueOf(0);
/* 209:    */   }
/* 210:    */   
/* 211:    */   public String getStitle()
/* 212:    */   {
/* 213:214 */     if (getShortTitle() == null) {
/* 214:215 */       return getTitle();
/* 215:    */     }
/* 216:217 */     return getShortTitle();
/* 217:    */   }
/* 218:    */   
/* 219:    */   public String getSubTitle()
/* 220:    */   {
/* 221:221 */     ArticleExt ext = getArticleExt();
/* 222:222 */     if (ext != null) {
/* 223:223 */       return ext.getSubTitle();
/* 224:    */     }
/* 225:225 */     return null;
/* 226:    */   }
/* 227:    */   
/* 228:    */   public Boolean getShowIndex()
/* 229:    */   {
/* 230:229 */     ArticleExt ext = getArticleExt();
/* 231:230 */     if (ext != null) {
/* 232:231 */       return ext.getShowIndex();
/* 233:    */     }
/* 234:233 */     return Boolean.valueOf(false);
/* 235:    */   }
/* 236:    */   
/* 237:    */   public String getDescription()
/* 238:    */   {
/* 239:238 */     ArticleExt ext = getArticleExt();
/* 240:239 */     if (ext != null) {
/* 241:240 */       return ext.getDescription();
/* 242:    */     }
/* 243:242 */     return null;
/* 244:    */   }
/* 245:    */   
/* 246:    */   public String getAuthor()
/* 247:    */   {
/* 248:247 */     ArticleExt ext = getArticleExt();
/* 249:248 */     if (ext != null) {
/* 250:249 */       return ext.getAuthor();
/* 251:    */     }
/* 252:251 */     return null;
/* 253:    */   }
/* 254:    */   
/* 255:    */   public String getOrigin()
/* 256:    */   {
/* 257:256 */     ArticleExt ext = getArticleExt();
/* 258:257 */     if (ext != null) {
/* 259:258 */       return ext.getOrigin();
/* 260:    */     }
/* 261:260 */     return null;
/* 262:    */   }
/* 263:    */   
/* 264:    */   public String getOriginUrl()
/* 265:    */   {
/* 266:265 */     ArticleExt ext = getArticleExt();
/* 267:266 */     if (ext != null) {
/* 268:267 */       return ext.getOriginUrl();
/* 269:    */     }
/* 270:269 */     return null;
/* 271:    */   }
/* 272:    */   
/* 273:    */   public Boolean getCommentControl()
/* 274:    */   {
/* 275:274 */     ArticleExt ext = getArticleExt();
/* 276:275 */     if ((ext != null) && 
/* 277:276 */       (ext.getCommentControl() != null)) {
/* 278:277 */       return ext.getCommentControl();
/* 279:    */     }
/* 280:280 */     return getChannel().getCommentControl();
/* 281:    */   }
/* 282:    */   
/* 283:    */   public String getLink()
/* 284:    */   {
/* 285:284 */     ArticleExt ext = getArticleExt();
/* 286:285 */     if (ext != null) {
/* 287:286 */       return ext.getLink();
/* 288:    */     }
/* 289:288 */     return null;
/* 290:    */   }
/* 291:    */   
/* 292:    */   public String getTagStr()
/* 293:    */   {
/* 294:293 */     ArticleExt ext = getArticleExt();
/* 295:294 */     if (ext != null) {
/* 296:295 */       return ext.getTagStr();
/* 297:    */     }
/* 298:297 */     return null;
/* 299:    */   }
/* 300:    */   
/* 301:    */   public String getTplContent()
/* 302:    */   {
/* 303:302 */     ArticleExt ext = getArticleExt();
/* 304:303 */     if (ext != null) {
/* 305:304 */       return ext.getTplContent();
/* 306:    */     }
/* 307:306 */     return null;
/* 308:    */   }
/* 309:    */   
/* 310:    */   public String getTxtValue()
/* 311:    */   {
/* 312:311 */     ArticleTxt txt = getArticleTxt();
/* 313:312 */     if (txt != null) {
/* 314:313 */       return txt.getTxt();
/* 315:    */     }
/* 316:315 */     return null;
/* 317:    */   }
/* 318:    */   
/* 319:    */   public String getPicStyle(String typeId)
/* 320:    */   {
/* 321:320 */     List<ArticlePicture> list = getPics();
/* 322:321 */     if (list != null) {
/* 323:322 */       for (ArticlePicture ap : list) {
/* 324:323 */         if ((ap.getStyle() != null) && 
/* 325:324 */           (ap.getStyle().indexOf("," + typeId + ",") > -1) && 
/* 326:325 */           (ap.getThumb().booleanValue())) {
/* 327:326 */           return ap.getImgPath();
/* 328:    */         }
/* 329:    */       }
/* 330:    */     }
/* 331:330 */     return null;
/* 332:    */   }
/* 333:    */   
/* 334:    */   public String getGraphic()
/* 335:    */   {
/* 336:334 */     List<ArticlePicture> list = getPics();
/* 337:335 */     if (list != null) {
/* 338:336 */       for (ArticlePicture ap : list) {
/* 339:337 */         if ((ap.getStyle() != null) && (ap.getStyle().indexOf(",0,") > -1) && 
/* 340:338 */           (ap.getThumb().booleanValue())) {
/* 341:339 */           return ap.getImgPath();
/* 342:    */         }
/* 343:    */       }
/* 344:    */     }
/* 345:343 */     return null;
/* 346:    */   }
/* 347:    */   
/* 348:    */   public String getCover()
/* 349:    */   {
/* 350:347 */     List<ArticlePicture> list = getPics();
/* 351:348 */     if (list != null) {
/* 352:349 */       for (ArticlePicture ap : list) {
/* 353:350 */         if ((ap.getStyle() != null) && (ap.getStyle().indexOf(",1,") > -1) && 
/* 354:351 */           (!ap.getThumb().booleanValue())) {
/* 355:352 */           return ap.getImgPath();
/* 356:    */         }
/* 357:    */       }
/* 358:    */     }
/* 359:356 */     return null;
/* 360:    */   }
/* 361:    */   
/* 362:    */   public Date getDate()
/* 363:    */   {
/* 364:360 */     return getReleaseDate();
/* 365:    */   }
/* 366:    */   
/* 367:    */   public Boolean getTarget()
/* 368:    */   {
/* 369:364 */     return null;
/* 370:    */   }
/* 371:    */   
/* 372:    */   public Article() {}
/* 373:    */   
/* 374:    */   public Article(Integer id)
/* 375:    */   {
/* 376:376 */     super(id);
/* 377:    */   }
/* 378:    */   
/* 379:    */   public Article(Integer id, Site site, Model model)
/* 380:    */   {
/* 381:385 */     super(id, site, model);
/* 382:    */   }
/* 383:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.entity.Article
 * JD-Core Version:    0.7.0.1
 */