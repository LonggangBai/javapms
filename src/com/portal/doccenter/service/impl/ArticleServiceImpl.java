/*   1:    */
package com.portal.doccenter.service.impl;
/*   2:    */ 
/*   3:    */

import com.javapms.basic.hibernate3.Updater;
/*   4:    */ import com.javapms.basic.page.Pagination;
/*   5:    */ import com.portal.datacenter.lucene.LuceneDocService;
/*   6:    */ import com.portal.doccenter.dao.ArticleDao;
/*   7:    */ import com.portal.doccenter.entity.Article;
/*   8:    */ import com.portal.doccenter.entity.ArticleExt;
/*   9:    */ import com.portal.doccenter.entity.ArticleTxt;
/*  10:    */ import com.portal.doccenter.entity.ArticleType;
/*  11:    */ import com.portal.doccenter.entity.Channel;
/*  12:    */ import com.portal.doccenter.entity.FlowDetail;
/*  13:    */ import com.portal.doccenter.entity.FlowStep;
/*  14:    */ import com.portal.doccenter.entity.Model;
/*  15:    */ import com.portal.doccenter.entity.WorkFlow;
/*  16:    */ import com.portal.doccenter.service.ArticleExtService;
/*  17:    */ import com.portal.doccenter.service.ArticleService;
/*  18:    */ import com.portal.doccenter.service.ArticleTxtService;
/*  19:    */ import com.portal.doccenter.service.ArticleTypeService;
/*  20:    */ import com.portal.doccenter.service.ChannelService;
/*  21:    */ import com.portal.doccenter.service.DocStatisService;
/*  22:    */ import com.portal.doccenter.service.FlowDetailService;
/*  23:    */ import com.portal.doccenter.service.ModelService;
/*  24:    */ import com.portal.extrafunc.service.CommentService;
/*  25:    */ import com.portal.sysmgr.entity.Site;
/*  26:    */ import com.portal.usermgr.entity.Admin;
/*  27:    */ import com.portal.usermgr.entity.Depart;
/*  28:    */ import com.portal.usermgr.entity.Group;
/*  29:    */ import com.portal.usermgr.entity.Role;
/*  30:    */ import com.portal.usermgr.entity.User;
/*  31:    */ import com.portal.usermgr.service.GroupService;
/*  32:    */ import com.portal.usermgr.service.UserService;
/*  33:    */ import java.util.ArrayList;
/*  34:    */ import java.util.List;
/*  35:    */ import java.util.Map;
/*  36:    */ import java.util.Set;
/*  37:    */ import org.apache.commons.lang.StringUtils;
/*  38:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  39:    */ import org.springframework.stereotype.Service;
/*  40:    */ import org.springframework.transaction.annotation.Transactional;

/*  41:    */
/*  42:    */
@Service
/*  43:    */
@Transactional
/*  44:    */ public class ArticleServiceImpl
/*  45:    */ implements ArticleService
/*  46:    */ {
    /*  47:    */   private ChannelService channelService;
    /*  48:    */   private ArticleExtService articleExtService;
    /*  49:    */   private ArticleTxtService articleTxtService;
    /*  50:    */   private DocStatisService statisService;
    /*  51:    */   private ArticleTypeService articleTypeService;
    /*  52:    */   private GroupService groupService;
    /*  53:    */   private UserService userService;
    /*  54:    */   private CommentService commentService;
    /*  55:    */   private ModelService modelService;
    /*  56:    */   private LuceneDocService luceneDocService;
    /*  57:    */   private FlowDetailService detailService;
    /*  58:    */   private ArticleDao dao;

    /*  59:    */
/*  60:    */
    @Transactional(readOnly = true)
/*  61:    */ public Pagination getPageArticle(String title, Integer[] typeIds, Integer[] modelIds, Integer inputDepartId, boolean top, boolean recommend, Byte[] statuss, Integer siteId, Integer userId, Integer chnlId, int orderBy, String sortname, String sortorder, int pageNo, int pageSize)
/*  62:    */ {
/*  63: 47 */
        User user = this.userService.findById(userId);
/*  64: 48 */
        Depart depart = user.getAdmin().getDepart(siteId);
/*  65: 49 */
        String chnlNumber = "";
/*  66: 50 */
        if (chnlId != null) {
/*  67: 51 */
            chnlNumber = this.channelService.findById(chnlId).getNumber();
/*  68:    */
        }
/*  69: 54 */
        Boolean allChannel = null;
/*  70: 55 */
        if (user.getAdmin().getAllChannel(siteId).booleanValue()) {
/*  71: 56 */
            allChannel = Boolean.valueOf(true);
/*  72:    */
        } else {
/*  73: 58 */
            allChannel = Boolean.valueOf(false);
/*  74:    */
        }
/*  75: 60 */
        Integer departId = null;
/*  76: 61 */
        if (depart != null) {
/*  77: 62 */
            departId = depart.getId();
/*  78:    */
        }
/*  79: 64 */
        Pagination p = this.dao.getPageArticle(title, typeIds, modelIds, inputDepartId, top,
/*  80: 65 */       recommend, statuss, siteId, userId, departId, user.getAdmin()
/*  81: 66 */.getStep(siteId), chnlNumber, user.getAdmin()
/*  82: 67 */.getManageStatus(siteId), allChannel, orderBy,
/*  83: 68 */       sortname, sortorder, pageNo, pageSize);
/*  84: 69 */
        return p;
/*  85:    */
    }

    /*  86:    */
/*  87:    */
    public Pagination getPageDocByMember(String title, Integer[] typeIds, Integer[] modelIds, boolean top, boolean recommend, Integer siteId, Integer userId, Integer chnlId, int pageNo, int pageSize)
/*  88:    */ {
/*  89: 75 */
        String chnlNumber = "";
/*  90: 76 */
        if (chnlId != null) {
/*  91: 77 */
            chnlNumber = this.channelService.findById(chnlId).getNumber();
/*  92:    */
        }
/*  93: 79 */
        return this.dao.getPageDocByMember(title, typeIds, modelIds, top, recommend,
/*  94: 80 */       siteId, userId, chnlNumber, pageNo, pageSize);
/*  95:    */
    }

    /*  96:    */
/*  97:    */
    @Transactional(readOnly = true)
/*  98:    */ public long getCountByChecking(Integer siteId, Integer userId, boolean checking)
/*  99:    */ {
/* 100: 86 */
        User user = this.userService.findById(userId);
/* 101: 87 */
        Depart depart = user.getAdmin().getDepart(siteId);
/* 102: 88 */
        Boolean allChannel = null;
/* 103: 89 */
        if (user.getAdmin().getAllChannel(siteId).booleanValue()) {
/* 104: 90 */
            allChannel = Boolean.valueOf(true);
/* 105:    */
        } else {
/* 106: 92 */
            allChannel = Boolean.valueOf(false);
/* 107:    */
        }
/* 108: 94 */
        Integer departId = null;
/* 109: 95 */
        if (depart != null) {
/* 110: 96 */
            departId = depart.getId();
/* 111:    */
        }
/* 112: 98 */
        return this.dao.getCountByChecking(siteId, userId, departId, user.getAdmin()
/* 113: 99 */.getStep(siteId), user.getAdmin().getManageStatus(siteId),
/* 114:100 */       allChannel, checking);
/* 115:    */
    }

    /* 116:    */
/* 117:    */
    @Transactional(readOnly = true)
/* 118:    */ public Pagination getMoveDoc(Integer chnlId, int pageNo, int pageSize)
/* 119:    */ {
/* 120:105 */
        String number = this.channelService.findById(chnlId).getNumber();
/* 121:106 */
        return this.dao.getMoveDoc(number, pageNo, pageSize);
/* 122:    */
    }

    /* 123:    */
/* 124:    */
    @Transactional(readOnly = true)
/* 125:    */ public long getCountDoc(Integer chnlId)
/* 126:    */ {
/* 127:111 */
        String number = this.channelService.findById(chnlId).getNumber();
/* 128:112 */
        return this.dao.getCountDoc(number);
/* 129:    */
    }

    /* 130:    */
/* 131:    */
    @Transactional(readOnly = true)
/* 132:    */ public Article getSide(Integer id, Integer siteId, Integer channelId, boolean next)
/* 133:    */ {
/* 134:118 */
        return this.dao.getSide(id, siteId, channelId, next, true);
/* 135:    */
    }

    /* 136:    */
/* 137:    */
    @Transactional(readOnly = true)
/* 138:    */ public List<Article> getListTagByIds(Integer[] ids, int orderBy)
/* 139:    */ {
/* 140:123 */
        if (ids.length == 1)
/* 141:    */ {
/* 142:124 */
            Article article = findById(ids[0]);
/* 143:    */
            List<Article> list;
/* 144:126 */
            if (article != null)
/* 145:    */ {
/* 146:127 */
                list = new ArrayList(1);
/* 147:128 */
                list.add(article);
/* 148:    */
            }
/* 149:    */
            else
/* 150:    */ {
/* 151:130 */
                list = new ArrayList(0);
/* 152:    */
            }
/* 153:132 */
            return list;
/* 154:    */
        }
/* 155:134 */
        return this.dao.getListTagByIds(ids, orderBy);
/* 156:    */
    }

    /* 157:    */
/* 158:    */
    @Transactional(readOnly = true)
/* 159:    */ public Pagination getPageTagByChannelIds(Integer[] channelIds, Integer siteId, Integer[] modelIds, Integer[] typeIds, Boolean recommend, int orderBy, int callLevel, int pageNo, int pageSize)
/* 160:    */ {
/* 161:143 */
        String chnlNumber = "";
/* 162:144 */
        if ((callLevel == 1) &&
/* 163:145 */       (channelIds != null)) {
/* 164:146 */
            chnlNumber = this.channelService.findById(channelIds[0]).getNumber();
/* 165:    */
        }
/* 166:149 */
        return this.dao.getPageTagByChannelIds(channelIds, siteId, modelIds,
/* 167:150 */       typeIds, chnlNumber, recommend, orderBy, callLevel, pageNo, 
/* 168:151 */       pageSize);
/* 169:    */
    }

    /* 170:    */
/* 171:    */
    @Transactional(readOnly = true)
/* 172:    */ public List<Article> getListTagByChannelIds(Integer[] channelIds, Integer siteId, Integer[] modelIds, Integer[] typeIds, Boolean recommend, int orderBy, int callLevel, Integer first, Integer count)
/* 173:    */ {
/* 174:159 */
        String chnlNumber = "";
/* 175:160 */
        if ((callLevel == 1) &&
/* 176:161 */       (channelIds != null)) {
/* 177:162 */
            chnlNumber = this.channelService.findById(channelIds[0]).getNumber();
/* 178:    */
        }
/* 179:165 */
        return this.dao.getListTagByChannelIds(channelIds, siteId, modelIds,
/* 180:166 */       typeIds, chnlNumber, recommend, orderBy, callLevel, first, 
/* 181:167 */       count);
/* 182:    */
    }

    /* 183:    */
/* 184:    */
    @Transactional(readOnly = true)
/* 185:    */ public Pagination getPageTagByModelIds(Integer[] modelIds, Integer[] typeIds, Boolean recommend, int orderBy, int pageNo, int pageSize)
/* 186:    */ {
/* 187:174 */
        return this.dao.getPageTagByModelIds(modelIds, typeIds, recommend, orderBy,
/* 188:175 */       pageNo, pageSize);
/* 189:    */
    }

    /* 190:    */
/* 191:    */
    @Transactional(readOnly = true)
/* 192:    */ public List<Article> getListTagByModelIds(Integer[] modelIds, Integer[] typeIds, Boolean recommend, int orderBy, Integer first, Integer count)
/* 193:    */ {
/* 194:182 */
        return this.dao.getListTagByModelIds(modelIds, typeIds, recommend, orderBy,
/* 195:183 */       first, count);
/* 196:    */
    }

    /* 197:    */
/* 198:    */
    @Transactional(readOnly = true)
/* 199:    */ public Article findById(Integer id)
/* 200:    */ {
/* 201:188 */
        Article entity = this.dao.findById(id);
/* 202:189 */
        return entity;
/* 203:    */
    }

    /* 204:    */
/* 205:    */
    public Article save(Article bean, ArticleExt ext, ArticleTxt txt, Integer[] channelIds, Integer[] viewGroupIds, String[] attPaths, String[] attNames, String[] imgPaths, String[] imgDescs, Boolean[] thumbs, String[] imgStyles, Integer channelId, Integer modelId, User user, boolean isMember)
/* 206:    */ {
/* 207:197 */
        bean.setChannel(this.channelService.findById(channelId));
/* 208:198 */
        if (StringUtils.isBlank(bean.getStyle())) {
/* 209:199 */
            bean.setStyle("," + this.articleTypeService.getDef().getId() + ",");
/* 210:    */
        } else {
/* 211:201 */
            bean.setStyle("," + bean.getStyle() + ",");
/* 212:    */
        }
/* 213:203 */
        if (modelId != null) {
/* 214:204 */
            bean.setModel(this.modelService.findById(modelId));
/* 215:    */
        }
/* 216:206 */
        bean.setUser(user);
/* 217:    */
        Role role;
/* 218:    */
        Integer roleId;
/* 219:207 */
        if (!isMember)
/* 220:    */ {
/* 221:208 */
            Depart depart = user.getAdmin().getDepart(bean.getSite().getId());
/* 222:209 */
            role = user.getAdmin().getRole(bean.getSite().getId());
/* 223:210 */
            roleId = role.getId();
/* 224:211 */
            bean.setCheckUser(user);
/* 225:212 */
            bean.setInputDepart(depart);
/* 226:213 */
            if (depart.getFlow() != null)
/* 227:    */ {
/* 228:214 */
                if (depart.getFlow().getStep(roleId) != null)
/* 229:    */ {
/* 230:216 */
                    if (depart.getFlow().getLastFlowStep().getRole().equals(role))
/* 231:    */ {
/* 232:217 */
                        bean.setStatus(Byte.valueOf((byte) 2));
/* 233:218 */
                        bean.setStep(depart.getFlow().getStepCount());
/* 234:    */
                    }
/* 235:    */
                    else
/* 236:    */ {
/* 237:220 */
                        bean.setStatus(Byte.valueOf((byte) 1));
/* 238:221 */
                        bean.setStep(depart.getFlow().getStep(roleId).getStep());
/* 239:    */
                    }
/* 240:    */
                }
/* 241:    */
                else {
/* 242:224 */
                    bean.setStatus(Byte.valueOf((byte) 2));
/* 243:    */
                }
/* 244:    */
            }
/* 245:    */
            else {
/* 246:227 */
                bean.setStatus(Byte.valueOf((byte) 2));
/* 247:    */
            }
/* 248:    */
        }
/* 249:    */
        else
/* 250:    */ {
/* 251:230 */
            bean.setStatus(Byte.valueOf((byte) 1));
/* 252:    */
        }
/* 253:232 */
        bean.init();
/* 254:233 */
        this.dao.save(bean);
/* 255:234 */
        this.articleExtService.save(ext, bean);
/* 256:235 */
        this.articleTxtService.save(txt, bean);
/* 257:236 */
        this.statisService.save(bean);
/* 258:237 */
        if ((viewGroupIds != null) && (viewGroupIds.length > 0))
/* 259:    */ {
/* 260:    */
            Integer[] arrayOfInteger;
/* 261:238 */
            roleId = (arrayOfInteger = viewGroupIds).length;
/* 262:238 */
            for (int roleindex = 0; roleindex < roleId; roleindex++)
/* 263:    */ {
/* 264:238 */
                Integer gid = arrayOfInteger[roleindex];
/* 265:239 */
                bean.addToGroups(this.groupService.findById(gid));
/* 266:    */
            }
/* 267:    */
        }
/* 268:242 */
        if ((attPaths != null) && (attPaths.length > 0))
/* 269:    */ {
/* 270:243 */
            int i = 0;
/* 271:243 */
            for (int len = attPaths.length; i < len; i++) {
/* 272:244 */
                if (!StringUtils.isBlank(attPaths[i])) {
/* 273:245 */
                    bean.addToAttachmemts(attPaths[i], attNames[i]);
/* 274:    */
                }
/* 275:    */
            }
/* 276:    */
        }
/* 277:249 */
        if ((imgPaths != null) && (imgPaths.length > 0)) {
/* 278:250 */
            for (int i = 0; i < imgPaths.length; i++) {
/* 279:251 */
                if (!StringUtils.isBlank(imgPaths[i])) {
/* 280:252 */
                    bean.addToPictures(imgPaths[i], imgDescs[i], thumbs[i],
/* 281:253 */             imgStyles[i]);
/* 282:    */
                }
/* 283:    */
            }
/* 284:    */
        }
/* 285:257 */
        this.luceneDocService.addDoc(bean);
/* 286:258 */
        return bean;
/* 287:    */
    }

    /* 288:    */
/* 289:    */
    public Article update(Article bean, ArticleExt ext, ArticleTxt txt, Integer[] channelIds, Integer[] viewGroupIds, String[] attPaths, String[] attNames, String[] imgPaths, String[] imgDescs, Boolean[] thumbs, String[] imgStyles, Map<String, String> attr, Integer channelId, User user, boolean isMember)
/* 290:    */ {
/* 291:266 */
        Updater<Article> updater = new Updater(bean);
/* 292:267 */
        bean = this.dao.updateByUpdater(updater);
/* 293:268 */
        if (StringUtils.isBlank(bean.getStyle())) {
/* 294:269 */
            bean.setStyle("," + this.articleTypeService.getDef().getId() + ",");
/* 295:    */
        } else {
/* 296:271 */
            bean.setStyle("," + bean.getStyle() + ",");
/* 297:    */
        }
/* 298:273 */
        if (channelId != null) {
/* 299:274 */
            bean.setChannel(this.channelService.findById(channelId));
/* 300:    */
        }
/* 301:276 */
        if (isMember) {
/* 302:277 */
            bean.setStatus(Byte.valueOf((byte) 1));
/* 303:    */
        }
/* 304:285 */
        this.articleExtService.update(ext);
/* 305:286 */
        this.articleTxtService.update(txt, bean);
/* 306:287 */
        if (attr != null)
/* 307:    */ {
/* 308:288 */
            Map<String, String> attrOrig = bean.getAttr();
/* 309:289 */
            attrOrig.clear();
/* 310:290 */
            attrOrig.putAll(attr);
/* 311:    */
        }
/* 312:292 */
        Set<Group> groups = bean.getViewGroups();
/* 313:293 */
        groups.clear();
/* 314:294 */
        if ((viewGroupIds != null) && (viewGroupIds.length > 0)) {
/* 315:295 */
            for (Integer gid : viewGroupIds) {
/* 316:296 */
                groups.add(this.groupService.findById(gid));
/* 317:    */
            }
/* 318:    */
        }
/* 319:299 */
        bean.getAtts().clear();
/* 320:300 */
        if ((attPaths != null) && (attPaths.length > 0))
/* 321:    */ {
/* 322:301 */
            int i = 0;
/* 323:301 */
            for (int len = attPaths.length; i < len; i++) {
/* 324:302 */
                if (!StringUtils.isBlank(attPaths[i])) {
/* 325:303 */
                    bean.addToAttachmemts(attPaths[i], attNames[i]);
/* 326:    */
                }
/* 327:    */
            }
/* 328:    */
        }
/* 329:307 */
        bean.getPics().clear();
/* 330:308 */
        if ((imgPaths != null) && (imgPaths.length > 0)) {
/* 331:309 */
            for (int i = 0; i < imgPaths.length; i++) {
/* 332:310 */
                if (!StringUtils.isBlank(imgPaths[i])) {
/* 333:311 */
                    bean.addToPictures(imgPaths[i], imgDescs[i], thumbs[i],
/* 334:312 */             imgStyles[i]);
/* 335:    */
                }
/* 336:    */
            }
/* 337:    */
        }
/* 338:316 */
        this.luceneDocService.updateDoc(bean);
/* 339:317 */
        return bean;
/* 340:    */
    }

    /* 341:    */
/* 342:    */
    public int moveDoc(Integer chnlId, Map<String, String> channels)
/* 343:    */ {
/* 344:322 */
        int count = 0;
/* 345:323 */
        String number = this.channelService.findById(chnlId).getNumber();
/* 346:324 */
        Pagination p = this.dao.getMoveDoc(number, 1, 100);
/* 347:325 */
        List<Article> alist = (List<Article>) p.getList();
/* 348:326 */
        for (Article a : alist) {
/* 349:327 */
            if (!StringUtils.isBlank((String) channels.get(a.getModel().getId()
/* 350:328 */.toString())))
/* 351:    */ {
/* 352:329 */
                Integer cId = Integer.valueOf(Integer.parseInt((String) channels.get(a.getModel()
/* 353:330 */.getId().toString())));
/* 354:331 */
                a.setChannel(this.channelService.findById(cId));
/* 355:332 */
                this.luceneDocService.updateDoc(a);
/* 356:333 */
                count++;
/* 357:    */
            }
/* 358:    */
        }
/* 359:336 */
        if (p.getTotalPage() > 1) {
/* 360:337 */
            for (int i = 2; i <= p.getTotalPage(); i++)
/* 361:    */ {
/* 362:338 */
                Pagination pi = this.dao.getMoveDoc(number, i, 100);
/* 363:339 */
                List<Article> ailist = (List<Article>) pi.getList();
/* 364:340 */
                for (Article a : ailist) {
/* 365:341 */
                    if (!StringUtils.isBlank((String) channels.get(a.getModel().getId()
/* 366:342 */.toString())))
/* 367:    */ {
/* 368:343 */
                        Integer cId = Integer.valueOf(Integer.parseInt((String) channels.get(a
/* 369:344 */.getModel().getId().toString())));
/* 370:345 */
                        a.setChannel(this.channelService.findById(cId));
/* 371:346 */
                        this.luceneDocService.updateDoc(a);
/* 372:347 */
                        count++;
/* 373:    */
                    }
/* 374:    */
                }
/* 375:    */
            }
/* 376:    */
        }
/* 377:352 */
        return count;
/* 378:    */
    }

    /* 379:    */
/* 380:    */
    public int emptyDoc(Integer chnlId)
/* 381:    */ {
/* 382:357 */
        int count = 0;
/* 383:358 */
        String number = this.channelService.findById(chnlId).getNumber();
/* 384:359 */
        Pagination p = this.dao.getMoveDoc(number, 1, 100);
/* 385:360 */
        List<Article> alist = (List<Article>) p.getList();
/* 386:361 */
        for (Article a : alist)
/* 387:    */ {
/* 388:362 */
            deleteById(a.getId());
/* 389:363 */
            count++;
/* 390:    */
        }
/* 391:365 */
        if (p.getTotalPage() > 1) {
/* 392:366 */
            for (int i = 2; i <= p.getTotalPage(); i++)
/* 393:    */ {
/* 394:367 */
                Pagination pi = this.dao.getMoveDoc(number, i, 100);
/* 395:368 */
                List<Article> ailist = (List<Article>) pi.getList();
/* 396:369 */
                for (Article a : ailist)
/* 397:    */ {
/* 398:370 */
                    deleteById(a.getId());
/* 399:371 */
                    count++;
/* 400:    */
                }
/* 401:    */
            }
/* 402:    */
        }
/* 403:375 */
        return count;
/* 404:    */
    }

    /* 405:    */
/* 406:    */
    public Article check(Integer id, User user)
/* 407:    */ {
/* 408:379 */
        Article article = findById(id);
/* 409:380 */
        Integer siteId = article.getSite().getId();
/* 410:381 */
        Depart depart = user.getAdmin().getDepart(siteId);
/* 411:382 */
        Role role = user.getAdmin().getRole(siteId);
/* 412:383 */
        Integer roleId = role.getId();
/* 413:384 */
        if (!article.getStatus().equals(Byte.valueOf((byte) 2)))
/* 414:    */ {
/* 415:385 */
            if (depart.getFlow() != null)
/* 416:    */ {
/* 417:387 */
                if ((user.getAdmin().getManageStatus(siteId).equals(Byte.valueOf((byte) 4))) ||
/* 418:    */         
/* 419:389 */           (user.getAdmin().getManageStatus(siteId).equals(Byte.valueOf((byte) 3))))
/* 420:    */ {
/* 421:390 */
                    article.setStatus(Byte.valueOf((byte) 2));
/* 422:391 */
                    article.setCheckUser(user);
/* 423:392 */
                    article.setStep(depart.getFlow().getStepCount());
/* 424:393 */
                    this.luceneDocService.addDoc(article);
/* 425:    */
                }
/* 426:395 */
                else if (user.getAdmin().getManageStatus(siteId).equals(Byte.valueOf((byte) 2)))
/* 427:    */ {
/* 428:396 */
                    if (article.getStep().equals(
/* 429:397 */             Integer.valueOf(depart.getFlow().getStepCount().intValue() - 1)))
/* 430:    */ {
/* 431:398 */
                        article.setStatus(Byte.valueOf((byte) 2));
/* 432:399 */
                        article.setCheckUser(user);
/* 433:400 */
                        article.setStep(depart.getFlow().getStepCount());
/* 434:401 */
                        this.luceneDocService.addDoc(article);
/* 435:    */
                    }
/* 436:    */
                    else
/* 437:    */ {
/* 438:403 */
                        article.setStatus(Byte.valueOf((byte) 1));
/* 439:404 */
                        article.setCheckUser(user);
/* 440:405 */
                        article.setStep(depart.getFlow().getStep(roleId)
/* 441:406 */.getStep());
/* 442:    */
                    }
/* 443:    */
                }
/* 444:410 */
                return article;
/* 445:    */
            }
/* 446:413 */
            article.setStatus(Byte.valueOf((byte) 2));
/* 447:414 */
            article.setCheckUser(user);
/* 448:415 */
            this.luceneDocService.addDoc(article);
/* 449:    */
        }
/* 450:    */
        else
/* 451:    */ {
/* 452:417 */
            article.setStatus(Byte.valueOf((byte) 1));
/* 453:    */
        }
/* 454:419 */
        return article;
/* 455:    */
    }

    /* 456:    */
/* 457:    */
    public Article back(Integer id, User user, String reason, boolean initial)
/* 458:    */ {
/* 459:423 */
        Article article = findById(id);
/* 460:424 */
        Integer siteId = article.getSite().getId();
/* 461:425 */
        Depart depart = user.getAdmin().getDepart(siteId);
/* 462:426 */
        Role role = user.getAdmin().getRole(siteId);
/* 463:427 */
        if ((article.getStatus().equals(Byte.valueOf((byte) 1))) ||
/* 464:428 */       (article.getStatus().equals(Byte.valueOf((byte) -1))))
/* 465:    */ {
/* 466:429 */
            if (depart.getFlow() != null)
/* 467:    */ {
/* 468:430 */
                if (initial)
/* 469:    */ {
/* 470:431 */
                    article.setStep(null);
/* 471:    */
                }
/* 472:    */
                else
/* 473:    */ {
/* 474:433 */
                    FlowDetail fd = this.detailService.getLastFlowDetail(id);
/* 475:434 */
                    if (fd != null) {
/* 476:435 */
                        article.setStep(
/* 477:436 */               Integer.valueOf(depart.getFlow().getStep(fd.getRole().getId()).getStep().intValue() - 1));
/* 478:    */
                    } else {
/* 479:438 */
                        article.setStep(null);
/* 480:    */
                    }
/* 481:    */
                }
/* 482:    */
            }
/* 483:    */
            else {
/* 484:442 */
                article.setStep(null);
/* 485:    */
            }
/* 486:444 */
            article.setStatus(Byte.valueOf((byte) -1));
/* 487:445 */
            this.detailService.saveReturn(article, user, role, reason, initial);
/* 488:446 */
            return article;
/* 489:    */
        }
/* 490:448 */
        return article;
/* 491:    */
    }

    /* 492:    */
/* 493:    */
    public Article[] check(Integer[] ids, User user)
/* 494:    */ {
/* 495:452 */
        Article[] beans = new Article[ids.length];
/* 496:453 */
        int i = 0;
/* 497:453 */
        for (int len = ids.length; i < len; i++) {
/* 498:454 */
            beans[i] = check(ids[i], user);
/* 499:    */
        }
/* 500:456 */
        return beans;
/* 501:    */
    }

    /* 502:    */
/* 503:    */
    public Article cycle(Integer id)
/* 504:    */ {
/* 505:460 */
        Article article = findById(id);
/* 506:461 */
        article.setStatus(Byte.valueOf((byte) 3));
/* 507:462 */
        this.luceneDocService.deleteDoc(id);
/* 508:463 */
        return article;
/* 509:    */
    }

    /* 510:    */
/* 511:    */
    public Article[] cycle(Integer[] ids)
/* 512:    */ {
/* 513:467 */
        Article[] beans = new Article[ids.length];
/* 514:468 */
        int i = 0;
/* 515:468 */
        for (int len = ids.length; i < len; i++) {
/* 516:469 */
            beans[i] = cycle(ids[i]);
/* 517:    */
        }
/* 518:471 */
        return beans;
/* 519:    */
    }

    /* 520:    */
/* 521:    */
    public Article reduct(Integer id)
/* 522:    */ {
/* 523:475 */
        Article article = findById(id);
/* 524:476 */
        article.setStatus(Byte.valueOf((byte) 2));
/* 525:477 */
        this.luceneDocService.addDoc(article);
/* 526:478 */
        return article;
/* 527:    */
    }

    /* 528:    */
/* 529:    */
    public Article[] reduct(Integer[] ids)
/* 530:    */ {
/* 531:482 */
        Article[] beans = new Article[ids.length];
/* 532:483 */
        int i = 0;
/* 533:483 */
        for (int len = ids.length; i < len; i++) {
/* 534:484 */
            beans[i] = reduct(ids[i]);
/* 535:    */
        }
/* 536:486 */
        return beans;
/* 537:    */
    }

    /* 538:    */
/* 539:    */
    public Article deleteById(Integer id)
/* 540:    */ {
/* 541:490 */
        Article bean = findById(id);
/* 542:491 */
        this.commentService.deleteByDocId(id);
/* 543:492 */
        bean = this.dao.deleteById(id);
/* 544:493 */
        this.luceneDocService.deleteDoc(id);
/* 545:494 */
        return bean;
/* 546:    */
    }

    /* 547:    */
/* 548:    */
    public Article[] deleteByIds(Integer[] ids)
/* 549:    */ {
/* 550:498 */
        Article[] beans = new Article[ids.length];
/* 551:499 */
        int i = 0;
/* 552:499 */
        for (int len = ids.length; i < len; i++) {
/* 553:500 */
            beans[i] = deleteById(ids[i]);
/* 554:    */
        }
/* 555:502 */
        return beans;
/* 556:    */
    }

    /* 557:    */
/* 558:    */
    @Autowired
/* 559:    */ public void setChannelService(ChannelService channelService)
/* 560:    */ {
/* 561:520 */
        this.channelService = channelService;
/* 562:    */
    }

    /* 563:    */
/* 564:    */
    @Autowired
/* 565:    */ public void setArticleExtService(ArticleExtService articleExtService)
/* 566:    */ {
/* 567:525 */
        this.articleExtService = articleExtService;
/* 568:    */
    }

    /* 569:    */
/* 570:    */
    @Autowired
/* 571:    */ public void setArticleTxtService(ArticleTxtService articleTxtService)
/* 572:    */ {
/* 573:530 */
        this.articleTxtService = articleTxtService;
/* 574:    */
    }

    /* 575:    */
/* 576:    */
    @Autowired
/* 577:    */ public void setStatisService(DocStatisService statisService)
/* 578:    */ {
/* 579:535 */
        this.statisService = statisService;
/* 580:    */
    }

    /* 581:    */
/* 582:    */
    @Autowired
/* 583:    */ public void setArticleTypeService(ArticleTypeService articleTypeService)
/* 584:    */ {
/* 585:540 */
        this.articleTypeService = articleTypeService;
/* 586:    */
    }

    /* 587:    */
/* 588:    */
    @Autowired
/* 589:    */ public void setGroupService(GroupService groupService)
/* 590:    */ {
/* 591:545 */
        this.groupService = groupService;
/* 592:    */
    }

    /* 593:    */
/* 594:    */
    @Autowired
/* 595:    */ public void setUserService(UserService userService)
/* 596:    */ {
/* 597:550 */
        this.userService = userService;
/* 598:    */
    }

    /* 599:    */
/* 600:    */
    @Autowired
/* 601:    */ public void setCommentService(CommentService commentService)
/* 602:    */ {
/* 603:555 */
        this.commentService = commentService;
/* 604:    */
    }

    /* 605:    */
/* 606:    */
    @Autowired
/* 607:    */ public void setModelService(ModelService modelService)
/* 608:    */ {
/* 609:560 */
        this.modelService = modelService;
/* 610:    */
    }

    /* 611:    */
/* 612:    */
    @Autowired
/* 613:    */ public void setLuceneDocService(LuceneDocService luceneDocService)
/* 614:    */ {
/* 615:565 */
        this.luceneDocService = luceneDocService;
/* 616:    */
    }

    /* 617:    */
/* 618:    */
    @Autowired
/* 619:    */ public void setDetailService(FlowDetailService detailService)
/* 620:    */ {
/* 621:570 */
        this.detailService = detailService;
/* 622:    */
    }

    /* 623:    */
/* 624:    */
    @Autowired
/* 625:    */ public void setDao(ArticleDao dao)
/* 626:    */ {
/* 627:575 */
        this.dao = dao;
/* 628:    */
    }
/* 629:    */
}



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.portal.doccenter.service.impl.ArticleServiceImpl

 * JD-Core Version:    0.7.0.1

 */