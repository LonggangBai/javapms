/*   1:    */ package com.portal.doccenter.action;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.page.Pagination;
/*   4:    */ import com.javapms.basic.page.SimplePage;
/*   5:    */ import com.javapms.basic.plugin.springmvc.RealPathResolver;
/*   6:    */ import com.javapms.basic.upload.FileRepository;
/*   7:    */ import com.javapms.basic.utils.ResponseUtils;
/*   8:    */ import com.javapms.basic.utils.ServicesUtils;
/*   9:    */ import com.portal.datacenter.operatedata.service.LogService;
/*  10:    */ import com.portal.doccenter.entity.Article;
/*  11:    */ import com.portal.doccenter.entity.ArticleExt;
/*  12:    */ import com.portal.doccenter.entity.ArticleTxt;
/*  13:    */ import com.portal.doccenter.entity.ArticleType;
/*  14:    */ import com.portal.doccenter.entity.Channel;
/*  15:    */ import com.portal.doccenter.entity.Model;
/*  16:    */ import com.portal.doccenter.entity.ModelField;
/*  17:    */ import com.portal.doccenter.service.ArticleService;
/*  18:    */ import com.portal.doccenter.service.ArticleTypeService;
/*  19:    */ import com.portal.doccenter.service.ChannelService;
/*  20:    */ import com.portal.doccenter.service.ModelFieldService;
/*  21:    */ import com.portal.doccenter.service.ModelService;
/*  22:    */ import com.portal.sysmgr.entity.Site;
/*  23:    */ import com.portal.sysmgr.utils.ContextTools;
/*  24:    */ import com.portal.usermgr.entity.Group;
/*  25:    */ import com.portal.usermgr.entity.User;
/*  26:    */ import com.portal.usermgr.service.GroupService;
/*  27:    */ import java.io.File;
/*  28:    */ import java.io.IOException;
/*  29:    */ import java.io.StringReader;
/*  30:    */ import java.util.ArrayList;
/*  31:    */ import java.util.List;
/*  32:    */ import java.util.Map;
/*  33:    */ import javax.servlet.http.HttpServletRequest;
/*  34:    */ import javax.servlet.http.HttpServletResponse;
/*  35:    */ import org.apache.commons.lang.StringUtils;
/*  36:    */ import org.apache.shiro.authz.annotation.RequiresPermissions;
/*  37:    */ import org.json.JSONException;
/*  38:    */ import org.json.JSONObject;
/*  39:    */ import org.slf4j.Logger;
/*  40:    */ import org.slf4j.LoggerFactory;
/*  41:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  42:    */ import org.springframework.stereotype.Controller;
/*  43:    */ import org.springframework.ui.ModelMap;
/*  44:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  45:    */ import org.springframework.web.bind.annotation.RequestParam;
/*  46:    */ import org.springframework.web.multipart.MultipartFile;
/*  47:    */ import org.wltea.analyzer.IKSegmentation;
/*  48:    */ import org.wltea.analyzer.Lexeme;
/*  49:    */ 
/*  50:    */ @Controller
/*  51:    */ public class ArticleAct
/*  52:    */ {
/*  53: 57 */   private static final Logger log = LoggerFactory.getLogger(ArticleAct.class);
/*  54:    */   @Autowired
/*  55:    */   private ChannelService channelService;
/*  56:    */   @Autowired
/*  57:    */   private ModelService modelService;
/*  58:    */   @Autowired
/*  59:    */   private ModelFieldService modelFieldService;
/*  60:    */   @Autowired
/*  61:    */   private GroupService groupService;
/*  62:    */   @Autowired
/*  63:    */   private ArticleTypeService articleTypeService;
/*  64:    */   @Autowired
/*  65:    */   private FileRepository fileRepository;
/*  66:    */   @Autowired
/*  67:    */   private RealPathResolver realPathResolver;
/*  68:    */   @Autowired
/*  69:    */   private LogService logService;
/*  70:    */   @Autowired
/*  71:    */   private ArticleService service;
/*  72:    */   
/*  73:    */   @RequestMapping({"/doc/v_tree.do"})
/*  74:    */   public String tree(Integer parentId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  75:    */   {
/*  76: 62 */     model.addAttribute("parentId", parentId);
/*  77: 63 */     Integer siteId = ContextTools.getSiteId(request);
/*  78: 64 */     Integer userId = ContextTools.getUserId(request);
/*  79: 65 */     List<Channel> list = this.channelService.getChannelByAdmin(userId, siteId, 
/*  80: 66 */       parentId, null, null, null, false);
/*  81: 67 */     model.addAttribute("list", list);
/*  82: 68 */     response.setHeader("Cache-Control", "no-cache");
/*  83: 69 */     response.setContentType("text/json;charset=UTF-8");
/*  84: 70 */     return "docCenter/document/tree";
/*  85:    */   }
/*  86:    */   
/*  87:    */   @RequestMapping({"/doc/v_addtree.do"})
/*  88:    */   public String addtree(Integer cid, Integer parentId, Integer modelId, Integer chnlId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  89:    */   {
/*  90: 77 */     model.addAttribute("parentId", parentId);
/*  91: 78 */     List<Channel> list = new ArrayList();
/*  92: 79 */     Integer siteId = ContextTools.getSiteId(request);
/*  93: 80 */     Integer userId = ContextTools.getUserId(request);
/*  94: 81 */     if ((cid != null) && (parentId == null))
/*  95:    */     {
/*  96: 82 */       parentId = cid;
/*  97: 83 */       list.add(this.channelService.findById(cid));
/*  98:    */     }
/*  99:    */     else
/* 100:    */     {
/* 101: 85 */       list = this.channelService.getChannelByModel(parentId, modelId, userId, 
/* 102: 86 */         siteId);
/* 103:    */     }
/* 104: 88 */     if (chnlId != null) {
/* 105: 89 */       list.remove(this.channelService.findById(chnlId));
/* 106:    */     }
/* 107: 91 */     model.addAttribute("list", list);
/* 108: 92 */     response.setHeader("Cache-Control", "no-cache");
/* 109: 93 */     response.setContentType("text/json;charset=UTF-8");
/* 110: 94 */     return "docCenter/document/addtree";
/* 111:    */   }
/* 112:    */   
/* 113:    */   @RequiresPermissions({"admin:doc:list"})
/* 114:    */   @RequestMapping({"/doc/v_list.do"})
/* 115:    */   public String list(Integer chnlId, HttpServletRequest request, ModelMap model)
/* 116:    */   {
/* 117:101 */     if (chnlId != null)
/* 118:    */     {
/* 119:102 */       Channel chnl = this.channelService.findById(chnlId);
/* 120:103 */       model.addAttribute("modelList", chnl.getModelList());
/* 121:    */     }
/* 122:    */     else
/* 123:    */     {
/* 124:105 */       model.addAttribute("modelList", 
/* 125:106 */         this.modelService.getList(false, null, null));
/* 126:    */     }
/* 127:108 */     List<ArticleType> typeList = this.articleTypeService.getList(false, null, 
/* 128:109 */       null);
/* 129:110 */     model.addAttribute("allModel", this.modelService.getList(false, null, null));
/* 130:111 */     model.addAttribute("chnlId", chnlId);
/* 131:112 */     model.addAttribute("typeList", typeList);
/* 132:113 */     return "docCenter/document/list";
/* 133:    */   }
/* 134:    */   
/* 135:    */   @RequiresPermissions({"admin:doc:add"})
/* 136:    */   @RequestMapping({"/doc/v_add.do"})
/* 137:    */   public String add(Integer cid, Integer modelId, HttpServletRequest request, ModelMap model)
/* 138:    */   {
/* 139:120 */     Site site = ContextTools.getSite(request);
/* 140:121 */     Channel c = null;
/* 141:122 */     if (cid != null) {
/* 142:123 */       c = this.channelService.findById(cid);
/* 143:    */     }
/* 144:125 */     Model m = this.modelService.findById(modelId);
/* 145:126 */     List<ModelField> fieldList = this.modelFieldService.getList(m.getId(), 
/* 146:127 */       false, null, null);
/* 147:128 */     List<Group> groupList = this.groupService.getList(site.getId(), null, null);
/* 148:129 */     List<ArticleType> typeList = this.articleTypeService.getList(false, null, 
/* 149:130 */       null);
/* 150:131 */     model.addAttribute("model", m);
/* 151:132 */     model.addAttribute("fieldList", fieldList);
/* 152:133 */     model.addAttribute("groupList", groupList);
/* 153:134 */     model.addAttribute("typeList", typeList);
/* 154:135 */     if (cid != null) {
/* 155:136 */       model.addAttribute("cid", cid);
/* 156:    */     }
/* 157:138 */     if (c != null) {
/* 158:139 */       model.addAttribute("channel", c);
/* 159:    */     }
/* 160:141 */     return "docCenter/document/add";
/* 161:    */   }
/* 162:    */   
/* 163:    */   @RequiresPermissions({"admin:doc:edit"})
/* 164:    */   @RequestMapping({"/doc/v_edit.do"})
/* 165:    */   public String edit(Integer id, HttpServletRequest request, ModelMap model)
/* 166:    */   {
/* 167:147 */     Site site = ContextTools.getSite(request);
/* 168:148 */     Article article = this.service.findById(id);
/* 169:149 */     List<ModelField> fieldList = this.modelFieldService.getList(article
/* 170:150 */       .getModel().getId(), false, null, null);
/* 171:151 */     List<Group> groupList = this.groupService.getList(site.getId(), null, null);
/* 172:152 */     Integer[] groupIds = Group.fetchIds(article.getViewGroups());
/* 173:153 */     List<ArticleType> typeList = this.articleTypeService.getList(false, null, 
/* 174:154 */       null);
/* 175:155 */     model.addAttribute("article", article);
/* 176:156 */     model.addAttribute("channel", article.getChannel());
/* 177:157 */     model.addAttribute("fieldList", fieldList);
/* 178:158 */     model.addAttribute("groupList", groupList);
/* 179:159 */     model.addAttribute("groupIds", groupIds);
/* 180:160 */     model.addAttribute("typeList", typeList);
/* 181:161 */     return "docCenter/document/edit";
/* 182:    */   }
/* 183:    */   
/* 184:    */   @RequiresPermissions({"admin:doc:save"})
/* 185:    */   @RequestMapping({"/doc/o_save.do"})
/* 186:    */   public String save(Article bean, ArticleExt ext, ArticleTxt txt, Integer modelId, Integer[] channelIds, Integer[] viewGroupIds, String[] attPaths, String[] attNames, String[] imgPaths, String[] imgDescs, Boolean[] thumbs, String[] imgStyles, Integer channelId, HttpServletRequest request, ModelMap model)
/* 187:    */   {
/* 188:171 */     Site site = ContextTools.getSite(request);
/* 189:172 */     User user = ContextTools.getUser(request);
/* 190:173 */     bean.setSite(site);
/* 191:174 */     bean.setAttr(ServicesUtils.getRequestMap(request, "attr_"));
/* 192:    */     
/* 193:176 */     bean = this.service.save(bean, ext, txt, channelIds, viewGroupIds, attPaths, 
/* 194:177 */       attNames, imgPaths, imgDescs, thumbs, imgStyles, channelId, 
/* 195:178 */       modelId, user, false);
/* 196:179 */     log.info("save Article id={}", bean.getId());
/* 197:180 */     this.logService.operating(request, "添加文档", "id=" + bean.getId() + ";title=" + 
/* 198:181 */       bean.getTitle());
/* 199:182 */     model.addAttribute("msg", "文档添加成功");
/* 200:183 */     return add(channelId, modelId, request, model);
/* 201:    */   }
/* 202:    */   
/* 203:    */   @RequiresPermissions({"admin:doc:update"})
/* 204:    */   @RequestMapping({"/doc/o_update.do"})
/* 205:    */   public String update(Article bean, ArticleExt ext, ArticleTxt txt, Integer[] channelIds, Integer[] topicIds, Integer[] viewGroupIds, String[] attPaths, String[] attNames, String[] imgPaths, String[] imgDescs, Boolean[] thumbs, String[] imgStyles, Integer channelId, HttpServletRequest request, ModelMap model)
/* 206:    */   {
/* 207:193 */     User user = ContextTools.getUser(request);
/* 208:194 */     Map<String, String> attr = 
/* 209:195 */       ServicesUtils.getRequestMap(request, "attr_");
/* 210:196 */     bean = this.service.update(bean, ext, txt, channelIds, viewGroupIds, 
/* 211:197 */       attPaths, attNames, imgPaths, imgDescs, thumbs, imgStyles, 
/* 212:198 */       attr, channelId, user, false);
/* 213:199 */     log.info("update Article id={}.", bean.getId());
/* 214:200 */     this.logService.operating(request, "修改文档", "id=" + bean.getId() + ";title=" + 
/* 215:201 */       bean.getTitle());
/* 216:202 */     model.addAttribute("msg", "文档修改成功");
/* 217:203 */     return edit(bean.getId(), request, model);
/* 218:    */   }
/* 219:    */   
/* 220:    */   @RequiresPermissions({"admin:doc:move"})
/* 221:    */   @RequestMapping({"/doc/o_move.do"})
/* 222:    */   public void move(Integer chnlId, String[] modelIds, HttpServletRequest request, HttpServletResponse response)
/* 223:    */     throws JSONException
/* 224:    */   {
/* 225:211 */     JSONObject json = new JSONObject();
/* 226:212 */     Map<String, String> channels = ServicesUtils.getRequestMapWithPrefix(
/* 227:213 */       request, "chnl_", modelIds);
/* 228:214 */     int count = this.service.moveDoc(chnlId, channels);
/* 229:215 */     json.put("success", true);
/* 230:216 */     json.put("count", count);
/* 231:217 */     ResponseUtils.renderJson(response, json.toString());
/* 232:    */   }
/* 233:    */   
/* 234:    */   @RequiresPermissions({"admin:doc:empty"})
/* 235:    */   @RequestMapping({"/doc/o_empty.do"})
/* 236:    */   public void empty(Integer chnlId, HttpServletRequest request, HttpServletResponse response)
/* 237:    */     throws JSONException
/* 238:    */   {
/* 239:225 */     JSONObject json = new JSONObject();
/* 240:226 */     int count = this.service.emptyDoc(chnlId);
/* 241:227 */     json.put("success", true);
/* 242:228 */     json.put("count", count);
/* 243:229 */     ResponseUtils.renderJson(response, json.toString());
/* 244:    */   }
/* 245:    */   
/* 246:    */   @RequestMapping({"/doc/jsonData.do"})
/* 247:    */   public String dataPageByJosn(String title, Byte[] status, Integer[] typeIds, Integer[] modelIds, boolean top, boolean recommend, Integer orderBy, Integer chnlId, Integer page, Integer pagesize, String sortname, String sortorder, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 248:    */   {
/* 249:240 */     Site site = ContextTools.getSite(request);
/* 250:241 */     Integer siteId = site.getId();
/* 251:242 */     User user = ContextTools.getUser(request);
/* 252:243 */     Pagination p = this.service.getPageArticle(StringUtils.trim(title), typeIds, 
/* 253:244 */       modelIds, null, top, recommend, status, siteId, user.getId(), 
/* 254:245 */       chnlId, 0, sortname, sortorder, SimplePage.cpn(page), pagesize.intValue());
/* 255:246 */     List<ArticleType> typeList = this.articleTypeService.getList(true, null, 
/* 256:247 */       null);
/* 257:248 */     model.addAttribute("pag", p);
/* 258:249 */     model.addAttribute("siteId", siteId);
/* 259:250 */     model.addAttribute("typeList", typeList);
/* 260:251 */     response.setHeader("Cache-Control", "no-cache");
/* 261:252 */     response.setContentType("text/json;charset=UTF-8");
/* 262:253 */     return "docCenter/document/listdata";
/* 263:    */   }
/* 264:    */   
/* 265:    */   @RequiresPermissions({"admin:doc:delete"})
/* 266:    */   @RequestMapping({"/doc/o_ajax_delete.do"})
/* 267:    */   public void deleteArticle(Integer[] ids, HttpServletRequest request, HttpServletResponse response)
/* 268:    */     throws JSONException
/* 269:    */   {
/* 270:260 */     JSONObject json = new JSONObject();
/* 271:261 */     Article[] beans = this.service.deleteByIds(ids);
/* 272:262 */     for (Article bean : beans)
/* 273:    */     {
/* 274:263 */       log.info("删除文档: id={}", bean.getId());
/* 275:264 */       this.logService.operating(request, "删除文档", "id=" + bean.getId() + 
/* 276:265 */         ";title=" + bean.getTitle());
/* 277:    */     }
/* 278:267 */     json.put("success", true);
/* 279:268 */     json.put("status", 1);
/* 280:269 */     ResponseUtils.renderJson(response, json.toString());
/* 281:    */   }
/* 282:    */   
/* 283:    */   @RequiresPermissions({"admin:doc:cycle"})
/* 284:    */   @RequestMapping({"/doc/o_ajax_cycle.do"})
/* 285:    */   public void cycleArticle(Integer[] ids, HttpServletRequest request, HttpServletResponse response)
/* 286:    */     throws JSONException
/* 287:    */   {
/* 288:277 */     JSONObject json = new JSONObject();
/* 289:278 */     Article[] beans = this.service.cycle(ids);
/* 290:279 */     for (Article bean : beans) {
/* 291:280 */       log.info("文档放入回收站,id={}", bean.getId());
/* 292:    */     }
/* 293:282 */     json.put("success", true);
/* 294:283 */     json.put("status", 1);
/* 295:284 */     ResponseUtils.renderJson(response, json.toString());
/* 296:    */   }
/* 297:    */   
/* 298:    */   @RequiresPermissions({"admin:doc:reduct"})
/* 299:    */   @RequestMapping({"/doc/o_ajax_reduct.do"})
/* 300:    */   public void reductArticle(Integer[] ids, HttpServletRequest request, HttpServletResponse response)
/* 301:    */     throws JSONException
/* 302:    */   {
/* 303:292 */     JSONObject json = new JSONObject();
/* 304:293 */     Article[] beans = this.service.reduct(ids);
/* 305:294 */     for (Article bean : beans) {
/* 306:295 */       log.info("文档还原,id={}", bean.getId());
/* 307:    */     }
/* 308:297 */     json.put("success", true);
/* 309:298 */     json.put("status", 1);
/* 310:299 */     ResponseUtils.renderJson(response, json.toString());
/* 311:    */   }
/* 312:    */   
/* 313:    */   @RequiresPermissions({"admin:doc:check"})
/* 314:    */   @RequestMapping({"/doc/o_check.do"})
/* 315:    */   public void check(Integer[] ids, String chnlNumber, HttpServletRequest request, HttpServletResponse response)
/* 316:    */     throws JSONException
/* 317:    */   {
/* 318:308 */     JSONObject json = new JSONObject();
/* 319:309 */     User user = ContextTools.getUser(request);
/* 320:310 */     Article[] beans = this.service.check(ids, user);
/* 321:311 */     for (Article bean : beans) {
/* 322:312 */       log.info("check Doc id={}", bean.getId());
/* 323:    */     }
/* 324:314 */     json.put("success", true);
/* 325:315 */     json.put("status", 1);
/* 326:316 */     ResponseUtils.renderJson(response, json.toString());
/* 327:    */   }
/* 328:    */   
/* 329:    */   @RequestMapping({"/doc/o_upload_attach.do"})
/* 330:    */   public void uploadAttachment(@RequestParam(value="attachFile", required=false) MultipartFile file, String attachmentNum, HttpServletRequest request, HttpServletResponse response)
/* 331:    */     throws JSONException
/* 332:    */   {
/* 333:325 */     Site site = ContextTools.getSite(request);
/* 334:326 */     String fileUrl = this.fileRepository.uploadFile(file, site.getUploadPath());
/* 335:327 */     ResponseUtils.renderText(response, fileUrl);
/* 336:    */   }
/* 337:    */   
/* 338:    */   @RequestMapping({"/doc/o_upload_img.do"})
/* 339:    */   public void uploadImg(@RequestParam(value="imgFile", required=false) MultipartFile file, HttpServletRequest request, HttpServletResponse response)
/* 340:    */     throws JSONException
/* 341:    */   {
/* 342:335 */     Site site = ContextTools.getSite(request);
/* 343:336 */     String fileUrl = this.fileRepository.uploadFile(file, site.getUploadPath());
/* 344:337 */     ResponseUtils.renderText(response, fileUrl);
/* 345:    */   }
/* 346:    */   
/* 347:    */   @RequestMapping({"/doc/o_delete_file.do"})
/* 348:    */   public void deleteFile(String path, HttpServletRequest request, HttpServletResponse response)
/* 349:    */   {
/* 350:343 */     if (path.indexOf("/member/upload/") > -1) {
/* 351:344 */       path = path.substring(path.indexOf("/member/upload/"));
/* 352:    */     }
/* 353:346 */     String realpath = this.realPathResolver.get(path);
/* 354:347 */     File f = new File(realpath);
/* 355:348 */     if (f.exists()) {
/* 356:349 */       f.delete();
/* 357:    */     }
/* 358:351 */     ResponseUtils.renderText(response, "");
/* 359:    */   }
/* 360:    */   
/* 361:    */   @RequestMapping({"/doc/v_titletags.do"})
/* 362:    */   public void titleTags(String title, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 363:    */     throws JSONException
/* 364:    */   {
/* 365:357 */     StringBuffer strb = new StringBuffer("");
/* 366:358 */     JSONObject json = new JSONObject();
/* 367:359 */     if (!StringUtils.isBlank(title))
/* 368:    */     {
/* 369:360 */       IKSegmentation ikSeg = new IKSegmentation(new StringReader(title), 
/* 370:361 */         true);
/* 371:    */       try
/* 372:    */       {
/* 373:363 */         Lexeme l = null;
/* 374:364 */         while ((l = ikSeg.next()) != null) {
/* 375:365 */           if (l.getLexemeType() == 0)
/* 376:    */           {
/* 377:366 */             strb.append(l.getLexemeText());
/* 378:367 */             strb.append(",");
/* 379:    */           }
/* 380:    */         }
/* 381:370 */         json.put("success", true);
/* 382:371 */         if (strb.toString().length() > 1) {
/* 383:372 */           json.put(
/* 384:373 */             "tag", 
/* 385:374 */             strb.toString().substring(0, 
/* 386:375 */             strb.toString().length() - 1));
/* 387:    */         }
/* 388:377 */         ResponseUtils.renderJson(response, json.toString());
/* 389:    */       }
/* 390:    */       catch (IOException e)
/* 391:    */       {
/* 392:379 */         e.printStackTrace();
/* 393:    */       }
/* 394:    */     }
/* 395:    */   }
/* 396:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.action.ArticleAct
 * JD-Core Version:    0.7.0.1
 */