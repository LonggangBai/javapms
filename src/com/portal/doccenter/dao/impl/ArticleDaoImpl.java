/*   1:    */ package com.portal.doccenter.dao.impl;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*   4:    */ import com.javapms.basic.page.Pagination;
/*   5:    */ import com.portal.doccenter.dao.ArticleDao;
/*   6:    */ import com.portal.doccenter.entity.Article;
/*   7:    */ import java.util.List;
/*   8:    */ import org.apache.commons.lang.StringUtils;
/*   9:    */ import org.hibernate.Criteria;
/*  10:    */ import org.hibernate.Session;
/*  11:    */ import org.hibernate.criterion.Criterion;
/*  12:    */ import org.hibernate.criterion.Disjunction;
/*  13:    */ import org.hibernate.criterion.Order;
/*  14:    */ import org.hibernate.criterion.Projections;
/*  15:    */ import org.hibernate.criterion.Restrictions;
/*  16:    */ import org.hibernate.type.IntegerType;
/*  17:    */ import org.springframework.stereotype.Repository;
/*  18:    */ 
/*  19:    */ @Repository
/*  20:    */ public class ArticleDaoImpl
/*  21:    */   extends HibernateBaseDao<Article, Integer>
/*  22:    */   implements ArticleDao
/*  23:    */ {
/*  24:    */   public Pagination getPageArticle(String title, Integer[] typeIds, Integer[] modelIds, Integer inputDepartId, boolean top, boolean recommend, Byte[] statuss, Integer siteId, Integer userId, Integer departId, Integer step, String number, Byte manageStatus, Boolean allChannel, int orderBy, String sortname, String sortorder, int pageNo, int pageSize)
/*  25:    */   {
/*  26: 30 */     Criteria crit = byPageArticle(title, typeIds, modelIds, inputDepartId, 
/*  27: 31 */       top, recommend, statuss, siteId, userId, departId, step, 
/*  28: 32 */       number, manageStatus, allChannel);
/*  29: 33 */     if (!StringUtils.isBlank(sortname))
/*  30:    */     {
/*  31: 34 */       if ("asc".equals(sortorder)) {
/*  32: 35 */         crit.addOrder(Order.asc(sortname));
/*  33:    */       } else {
/*  34: 37 */         crit.addOrder(Order.desc(sortname));
/*  35:    */       }
/*  36:    */     }
/*  37:    */     else {
/*  38: 40 */       crit.addOrder(Order.desc("releaseDate"));
/*  39:    */     }
/*  40: 42 */     return findByCriteria(crit, pageNo, pageSize);
/*  41:    */   }
/*  42:    */   
/*  43:    */   public Pagination getPageDocByMember(String title, Integer[] typeIds, Integer[] modelIds, boolean top, boolean recommend, Integer siteId, Integer userId, String number, int pageNo, int pageSize)
/*  44:    */   {
/*  45: 48 */     Criteria crit = createCriteria(new Criterion[0]);
/*  46: 49 */     crit.createAlias("channel", "c");
/*  47: 50 */     if (!StringUtils.isBlank(number)) {
/*  48: 51 */       crit.add(Restrictions.like("c.number", number + "%"));
/*  49: 52 */     } else if (siteId != null) {
/*  50: 53 */       crit.add(Restrictions.eq("site.id", siteId));
/*  51:    */     }
/*  52: 55 */     crit.add(Restrictions.eq("user.id", userId));
/*  53: 56 */     if (!StringUtils.isBlank(title)) {
/*  54: 57 */       crit.add(Restrictions.like("title", "%" + title + "%"));
/*  55:    */     }
/*  56: 59 */     if (typeIds != null) {
/*  57: 60 */       appendTypeIds(crit, typeIds);
/*  58:    */     }
/*  59: 62 */     if (modelIds != null) {
/*  60: 63 */       appendModelIds(crit, modelIds);
/*  61:    */     }
/*  62: 65 */     if (top) {
/*  63: 66 */       crit.add(Restrictions.eq("top", Boolean.valueOf(true)));
/*  64:    */     }
/*  65: 68 */     if (recommend) {
/*  66: 69 */       crit.add(Restrictions.eq("recommend", Boolean.valueOf(true)));
/*  67:    */     }
/*  68: 71 */     crit.add(Restrictions.ne("status", Byte.valueOf((byte)3)));
/*  69: 72 */     crit.addOrder(Order.desc("releaseDate"));
/*  70: 73 */     return findByCriteria(crit, pageNo, pageSize);
/*  71:    */   }
/*  72:    */   
/*  73:    */   public Pagination getMoveDoc(String number, int pageNo, int pageSize)
/*  74:    */   {
/*  75: 77 */     Criteria crit = createCriteria(new Criterion[0]);
/*  76: 78 */     crit.createAlias("channel", "c");
/*  77: 79 */     crit.add(Restrictions.like("c.number", number + "%"));
/*  78: 80 */     crit.addOrder(Order.desc("releaseDate"));
/*  79: 81 */     return findByCriteria(crit, pageNo, pageSize);
/*  80:    */   }
/*  81:    */   
/*  82:    */   public long getCountDoc(String number)
/*  83:    */   {
/*  84: 85 */     Criteria crit = createCriteria(new Criterion[0]);
/*  85: 86 */     crit.createAlias("channel", "c");
/*  86: 87 */     crit.add(Restrictions.like("c.number", number + "%"));
/*  87: 88 */     crit.setProjection(Projections.count("id"));
/*  88: 89 */     return ((Long)crit.list().get(0)).longValue();
/*  89:    */   }
/*  90:    */   
/*  91:    */   public long getCountByChecking(Integer siteId, Integer userId, Integer departId, Integer step, Byte manageStatus, Boolean allChannel, boolean checking)
/*  92:    */   {
/*  93: 96 */     Byte[] status = (Byte[])null;
/*  94: 97 */     if (checking) {
/*  95: 98 */       status[0] = Byte.valueOf((byte) 1);
/*  96:    */     }
/*  97:100 */     Criteria crit = byPageArticle(null, null, null, null, false, false, 
/*  98:101 */       status, siteId, userId, departId, step, null, manageStatus, 
/*  99:102 */       allChannel);
/* 100:103 */     crit.setProjection(Projections.count("id"));
/* 101:104 */     return ((Long)crit.list().get(0)).longValue();
/* 102:    */   }
/* 103:    */   
/* 104:    */   public Article getSide(Integer id, Integer siteId, Integer channelId, boolean next, boolean cacheable)
/* 105:    */   {
/* 106:109 */     Criteria crit = createCriteria(new Criterion[0]);
/* 107:110 */     if (channelId != null) {
/* 108:111 */       crit.add(Restrictions.eq("channel.id", channelId));
/* 109:112 */     } else if (siteId != null) {
/* 110:113 */       crit.add(Restrictions.eq("site.id", siteId));
/* 111:    */     }
/* 112:115 */     crit.add(Restrictions.eq("status", Byte.valueOf((byte)2)));
/* 113:116 */     if (next)
/* 114:    */     {
/* 115:117 */       crit.add(Restrictions.gt("id", id));
/* 116:118 */       crit.addOrder(Order.asc("id"));
/* 117:    */     }
/* 118:    */     else
/* 119:    */     {
/* 120:120 */       crit.add(Restrictions.lt("id", id));
/* 121:121 */       crit.addOrder(Order.desc("id"));
/* 122:    */     }
/* 123:123 */     crit.setCacheable(cacheable);
/* 124:124 */     return (Article)findUnique(crit);
/* 125:    */   }
/* 126:    */   
/* 127:    */   public List<Article> getListTagByIds(Integer[] ids, int orderBy)
/* 128:    */   {
/* 129:128 */     Criteria crit = createCriteria(new Criterion[0]);
/* 130:129 */     crit.add(Restrictions.in("id", ids));
/* 131:130 */     appendOrder(crit, orderBy);
/* 132:131 */     crit.setCacheable(true);
/* 133:132 */     return findByCriteria(crit);
/* 134:    */   }
/* 135:    */   
/* 136:    */   public Pagination getPageTagByChannelIds(Integer[] channelIds, Integer siteId, Integer[] modelIds, Integer[] typeIds, String chnlNumber, Boolean recommend, int orderBy, int callLevel, int pageNo, int pageSize)
/* 137:    */   {
/* 138:139 */     Criteria crit = byChannelIds(channelIds, siteId, modelIds, typeIds, 
/* 139:140 */       chnlNumber, recommend, orderBy, callLevel);
/* 140:141 */     crit.setCacheable(true);
/* 141:142 */     return findByCriteria(crit, pageNo, pageSize);
/* 142:    */   }
/* 143:    */   
/* 144:    */   public List<Article> getListTagByChannelIds(Integer[] channelIds, Integer siteId, Integer[] modelIds, Integer[] typeIds, String chnlNumber, Boolean recommend, int orderBy, int callLevel, Integer first, Integer count)
/* 145:    */   {
/* 146:149 */     Criteria crit = byChannelIds(channelIds, siteId, modelIds, typeIds, 
/* 147:150 */       chnlNumber, recommend, orderBy, callLevel);
/* 148:151 */     if (first != null) {
/* 149:152 */       crit.setFirstResult(first.intValue());
/* 150:    */     }
/* 151:154 */     if (count != null) {
/* 152:155 */       crit.setMaxResults(count.intValue());
/* 153:    */     }
/* 154:157 */     crit.setCacheable(true);
/* 155:158 */     return findByCriteria(crit);
/* 156:    */   }
/* 157:    */   
/* 158:    */   public Pagination getPageTagByModelIds(Integer[] modelIds, Integer[] typeIds, Boolean recommend, int orderBy, int pageNo, int pageSize)
/* 159:    */   {
/* 160:164 */     Criteria crit = byModelIds(modelIds, typeIds, recommend, orderBy);
/* 161:165 */     crit.setCacheable(true);
/* 162:166 */     return findByCriteria(crit, pageNo, pageSize);
/* 163:    */   }
/* 164:    */   
/* 165:    */   public List<Article> getListTagByModelIds(Integer[] modelIds, Integer[] typeIds, Boolean recommend, int orderBy, Integer first, Integer count)
/* 166:    */   {
/* 167:172 */     Criteria crit = byModelIds(modelIds, typeIds, recommend, orderBy);
/* 168:173 */     if (first != null) {
/* 169:174 */       crit.setFirstResult(first.intValue());
/* 170:    */     }
/* 171:176 */     if (count != null) {
/* 172:177 */       crit.setMaxResults(count.intValue());
/* 173:    */     }
/* 174:179 */     crit.setCacheable(true);
/* 175:180 */     return findByCriteria(crit);
/* 176:    */   }
/* 177:    */   
/* 178:    */   private Criteria byChannelIds(Integer[] channelIds, Integer siteId, Integer[] modelIds, Integer[] typeIds, String number, Boolean recommend, int orderBy, int callLevel)
/* 179:    */   {
/* 180:186 */     Criteria crit = createCriteria(new Criterion[0]);
/* 181:187 */     if (channelIds != null)
/* 182:    */     {
/* 183:188 */       if (callLevel == 1)
/* 184:    */       {
/* 185:189 */         crit.createAlias("channel", "c");
/* 186:190 */         if (!StringUtils.isBlank(number)) {
/* 187:191 */           crit.add(Restrictions.like("c.number", number + "%"));
/* 188:    */         }
/* 189:    */       }
/* 190:193 */       else if (callLevel == 2)
/* 191:    */       {
/* 192:194 */         crit.createAlias("channels", "c");
/* 193:195 */         if (!StringUtils.isBlank(number)) {
/* 194:196 */           crit.add(Restrictions.eq("c.id", channelIds[0]));
/* 195:    */         }
/* 196:    */       }
/* 197:    */       else
/* 198:    */       {
/* 199:199 */         appendChannelIds(crit, channelIds);
/* 200:    */       }
/* 201:    */     }
/* 202:    */     else {
/* 203:202 */       crit.add(Restrictions.eq("site.id", siteId));
/* 204:    */     }
/* 205:204 */     if (recommend != null) {
/* 206:205 */       crit.add(Restrictions.eq("recommend", recommend));
/* 207:    */     }
/* 208:207 */     appendModelIds(crit, modelIds);
/* 209:208 */     appendTypeIds(crit, typeIds);
/* 210:209 */     crit.add(Restrictions.eq("status", Byte.valueOf((byte)2)));
/* 211:210 */     appendOrder(crit, orderBy);
/* 212:211 */     return crit;
/* 213:    */   }
/* 214:    */   
/* 215:    */   private Criteria byPageArticle(String title, Integer[] typeIds, Integer[] modelIds, Integer inputDepartId, boolean top, boolean recommend, Byte[] statuss, Integer siteId, Integer userId, Integer departId, Integer step, String number, Byte manageStatus, Boolean allChannel)
/* 216:    */   {
/* 217:219 */     Criteria crit = createCriteria(new Criterion[0]);
/* 218:220 */     crit.createAlias("channel", "c");
/* 219:221 */     if (!StringUtils.isBlank(number)) {
/* 220:222 */       crit.add(Restrictions.like("c.number", number + "%"));
/* 221:223 */     } else if (siteId != null) {
/* 222:224 */       crit.add(Restrictions.eq("site.id", siteId));
/* 223:    */     }
/* 224:226 */     if (!allChannel.booleanValue())
/* 225:    */     {
/* 226:227 */       crit.createAlias("c.departs", "depart");
/* 227:228 */       crit.add(Restrictions.eq("depart.id", departId));
/* 228:    */     }
/* 229:230 */     if (inputDepartId != null) {
/* 230:231 */       crit.add(Restrictions.eq("inputDepart.id", inputDepartId));
/* 231:    */     }
/* 232:233 */     if (manageStatus.equals(Byte.valueOf((byte)1)))
/* 233:    */     {
/* 234:234 */       crit.add(Restrictions.eq("user.id", userId));
/* 235:    */     }
/* 236:235 */     else if (manageStatus.equals(Byte.valueOf((byte)2)))
/* 237:    */     {
/* 238:236 */       crit.add(Restrictions.eq("inputDepart.id", departId));
/* 239:237 */       crit.add(Restrictions.or(Restrictions.eq("user.id", userId), 
/* 240:238 */         Restrictions.sqlRestriction("{alias}.step+1=?", step, 
/* 241:239 */         IntegerType.INSTANCE)));
/* 242:    */     }
/* 243:240 */     else if (manageStatus.equals(Byte.valueOf((byte)3)))
/* 244:    */     {
/* 245:241 */       crit.add(Restrictions.eq("inputDepart.id", departId));
/* 246:    */     }
/* 247:243 */     if (!StringUtils.isBlank(title)) {
/* 248:244 */       crit.add(Restrictions.like("title", "%" + title + "%"));
/* 249:    */     }
/* 250:246 */     if (typeIds != null) {
/* 251:247 */       appendTypeIds(crit, typeIds);
/* 252:    */     }
/* 253:249 */     if (modelIds != null) {
/* 254:250 */       appendModelIds(crit, modelIds);
/* 255:    */     }
/* 256:252 */     if (top) {
/* 257:253 */       crit.add(Restrictions.eq("top", Boolean.valueOf(true)));
/* 258:    */     }
/* 259:255 */     if (recommend) {
/* 260:256 */       crit.add(Restrictions.eq("recommend", Boolean.valueOf(true)));
/* 261:    */     }
/* 262:258 */     if (statuss != null) {
/* 263:259 */       appendStatuss(crit, statuss);
/* 264:    */     } else {
/* 265:261 */       crit.add(Restrictions.ne("status", Byte.valueOf((byte)3)));
/* 266:    */     }
/* 267:263 */     return crit;
/* 268:    */   }
/* 269:    */   
/* 270:    */   private Criteria byModelIds(Integer[] modelIds, Integer[] typeIds, Boolean recommend, int orderBy)
/* 271:    */   {
/* 272:268 */     Criteria crit = createCriteria(new Criterion[0]);
/* 273:269 */     appendModelIds(crit, modelIds);
/* 274:270 */     if (recommend != null) {
/* 275:271 */       crit.add(Restrictions.eq("recommend", recommend));
/* 276:    */     }
/* 277:273 */     appendTypeIds(crit, typeIds);
/* 278:274 */     crit.add(Restrictions.eq("status", Byte.valueOf((byte)2)));
/* 279:275 */     appendOrder(crit, orderBy);
/* 280:276 */     return crit;
/* 281:    */   }
/* 282:    */   
/* 283:    */   private void appendChannelIds(Criteria crit, Integer[] channelIds)
/* 284:    */   {
/* 285:280 */     if (channelIds != null)
/* 286:    */     {
/* 287:281 */       int len = channelIds.length;
/* 288:282 */       if (len == 1) {
/* 289:283 */         crit.add(Restrictions.eq("channel.id", channelIds[0]));
/* 290:    */       } else {
/* 291:285 */         crit.add(Restrictions.in("channel.id", channelIds));
/* 292:    */       }
/* 293:    */     }
/* 294:    */   }
/* 295:    */   
/* 296:    */   private void appendModelIds(Criteria crit, Integer[] modelIds)
/* 297:    */   {
/* 298:291 */     if (modelIds != null)
/* 299:    */     {
/* 300:292 */       int len = modelIds.length;
/* 301:293 */       if (len == 1) {
/* 302:294 */         crit.add(Restrictions.eq("model.id", modelIds[0]));
/* 303:    */       } else {
/* 304:296 */         crit.add(Restrictions.in("model.id", modelIds));
/* 305:    */       }
/* 306:    */     }
/* 307:    */   }
/* 308:    */   
/* 309:    */   private void appendStatuss(Criteria crit, Byte[] statuss)
/* 310:    */   {
/* 311:303 */     if (statuss != null)
/* 312:    */     {
/* 313:304 */       int len = statuss.length;
/* 314:305 */       if (len == 1)
/* 315:    */       {
/* 316:306 */         crit.add(Restrictions.eq("status", statuss[0]));
/* 317:    */       }
/* 318:307 */       else if (len > 1)
/* 319:    */       {
/* 320:308 */         Disjunction dis = Restrictions.disjunction();
/* 321:309 */         for (Byte status : statuss) {
/* 322:310 */           dis.add(Restrictions.eq("status", status));
/* 323:    */         }
/* 324:312 */         crit.add(dis);
/* 325:    */       }
/* 326:    */     }
/* 327:    */   }
/* 328:    */   
/* 329:    */   private void appendTypeIds(Criteria crit, Integer[] typeIds)
/* 330:    */   {
/* 331:319 */     if (typeIds != null)
/* 332:    */     {
/* 333:320 */       int len = typeIds.length;
/* 334:321 */       if (len == 1)
/* 335:    */       {
/* 336:322 */         crit.add(Restrictions.like("style", "%," + typeIds[0] + ",%"));
/* 337:    */       }
/* 338:323 */       else if (len > 1)
/* 339:    */       {
/* 340:324 */         Disjunction dis = Restrictions.disjunction();
/* 341:325 */         for (Integer typeId : typeIds) {
/* 342:326 */           dis.add(Restrictions.like("style", "%," + typeId + ",%"));
/* 343:    */         }
/* 344:328 */         crit.add(dis);
/* 345:    */       }
/* 346:    */     }
/* 347:    */   }
/* 348:    */   
/* 349:    */   private void appendOrder(Criteria crit, int orderBy)
/* 350:    */   {
/* 351:334 */     switch (orderBy)
/* 352:    */     {
/* 353:    */     case 1: 
/* 354:336 */       crit.addOrder(Order.desc("releaseDate"));
/* 355:337 */       break;
/* 356:    */     case 2: 
/* 357:339 */       crit.addOrder(Order.desc("top"));
/* 358:340 */       crit.addOrder(Order.desc("releaseDate"));
/* 359:341 */       break;
/* 360:    */     case 3: 
/* 361:343 */       crit.addOrder(Order.desc("recommend"));
/* 362:344 */       crit.addOrder(Order.desc("releaseDate"));
/* 363:345 */       break;
/* 364:    */     case 4: 
/* 365:347 */       crit.createAlias("docStatis", "docStatis");
/* 366:348 */       crit.addOrder(Order.desc("docStatis.viewsCount"));
/* 367:349 */       crit.addOrder(Order.desc("releaseDate"));
/* 368:350 */       break;
/* 369:    */     case 5: 
/* 370:352 */       crit.createAlias("docStatis", "docStatis");
/* 371:353 */       crit.addOrder(Order.desc("docStatis.commentCount"));
/* 372:354 */       crit.addOrder(Order.desc("releaseDate"));
/* 373:355 */       break;
/* 374:    */     case 6: 
/* 375:357 */       crit.addOrder(Order.desc("top"));
/* 376:358 */       crit.addOrder(Order.desc("recommend"));
/* 377:359 */       crit.addOrder(Order.desc("releaseDate"));
/* 378:360 */       break;
/* 379:    */     default: 
/* 380:362 */       crit.addOrder(Order.desc("releaseDate"));
/* 381:    */     }
/* 382:    */   }
/* 383:    */   
/* 384:    */   public Article findById(Integer id)
/* 385:    */   {
/* 386:367 */     Article entity = (Article)get(id);
/* 387:368 */     return entity;
/* 388:    */   }
/* 389:    */   
/* 390:    */   public Article save(Article bean)
/* 391:    */   {
/* 392:372 */     getSession().save(bean);
/* 393:373 */     return bean;
/* 394:    */   }
/* 395:    */   
/* 396:    */   public Article deleteById(Integer id)
/* 397:    */   {
/* 398:377 */     Article entity = (Article)super.get(id);
/* 399:378 */     if (entity != null) {
/* 400:379 */       getSession().delete(entity);
/* 401:    */     }
/* 402:381 */     return entity;
/* 403:    */   }
/* 404:    */   
/* 405:    */   protected Class<Article> getEntityClass()
/* 406:    */   {
/* 407:386 */     return Article.class;
/* 408:    */   }
/* 409:    */ }



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.portal.doccenter.dao.impl.ArticleDaoImpl

 * JD-Core Version:    0.7.0.1

 */