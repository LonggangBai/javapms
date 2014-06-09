/*   1:    */ package com.portal.usermgr.action.fnt;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.page.Pagination;
/*   4:    */ import com.javapms.basic.page.SimplePage;
/*   5:    */ import com.javapms.basic.security.encoder.PwdEncoder;
/*   6:    */ import com.javapms.basic.upload.FileRepository;
/*   7:    */ import com.javapms.basic.utils.ServicesUtils;
/*   8:    */ import com.portal.doccenter.entity.Article;
/*   9:    */ import com.portal.doccenter.entity.ArticleExt;
/*  10:    */ import com.portal.doccenter.entity.ArticleTxt;
/*  11:    */ import com.portal.doccenter.entity.ArticleType;
/*  12:    */ import com.portal.doccenter.entity.Channel;
/*  13:    */ import com.portal.doccenter.entity.Model;
/*  14:    */ import com.portal.doccenter.entity.ModelField;
/*  15:    */ import com.portal.doccenter.service.ArticleService;
/*  16:    */ import com.portal.doccenter.service.ArticleTypeService;
/*  17:    */ import com.portal.doccenter.service.ChannelService;
/*  18:    */ import com.portal.doccenter.service.ModelFieldService;
/*  19:    */ import com.portal.doccenter.service.ModelService;
/*  20:    */ import com.portal.sysmgr.entity.Site;
/*  21:    */ import com.portal.sysmgr.utils.ContextTools;
/*  22:    */ import com.portal.sysmgr.utils.ViewTools;
/*  23:    */ import com.portal.usermgr.entity.Member;
/*  24:    */ import com.portal.usermgr.entity.User;
/*  25:    */ import com.portal.usermgr.service.MemberService;
/*  26:    */ import java.util.List;
/*  27:    */ import java.util.Map;
/*  28:    */ import javax.servlet.http.HttpServletRequest;
/*  29:    */ import javax.servlet.http.HttpServletResponse;
/*  30:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  31:    */ import org.springframework.stereotype.Controller;
/*  32:    */ import org.springframework.ui.ModelMap;
/*  33:    */ import org.springframework.web.bind.annotation.PathVariable;
/*  34:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  35:    */ import org.springframework.web.bind.annotation.RequestParam;
/*  36:    */ import org.springframework.web.multipart.MultipartFile;
/*  37:    */ import org.springframework.web.servlet.mvc.support.RedirectAttributes;
/*  38:    */ 
/*  39:    */ @Controller
/*  40:    */ public class MemberAct
/*  41:    */ {
/*  42:    */   public static final String MEMBER_INDEX = "tpl.memberIndex";
/*  43:    */   public static final String MEMBER_EDIT_PASS = "tpl.memberEditPass";
/*  44:    */   public static final String MEMBER_EDIT_INFO = "tpl.memberEditInfo";
/*  45:    */   public static final String DOC_LIST = "tpl.docList";
/*  46:    */   public static final String DOC_ADD = "tpl.docAdd";
/*  47:    */   public static final String DOC_EDIT = "tpl.docEdit";
/*  48:    */   public static final String MY_THEME = "tpl.myTheme";
/*  49:    */   public static final String MY_REPLY = "tpl.myReply";
/*  50:    */   @Autowired
/*  51:    */   private MemberService memberService;
/*  52:    */   @Autowired
/*  53:    */   private ModelService modelService;
/*  54:    */   @Autowired
/*  55:    */   private ModelFieldService modelFieldService;
/*  56:    */   @Autowired
/*  57:    */   private ArticleTypeService articleTypeService;
/*  58:    */   @Autowired
/*  59:    */   private ChannelService channelService;
/*  60:    */   @Autowired
/*  61:    */   private ArticleService service;
/*  62:    */   @Autowired
/*  63:    */   private PwdEncoder pwdEncoder;
/*  64:    */   @Autowired
/*  65:    */   private FileRepository fileRepository;
/*  66:    */   
/*  67:    */   @RequestMapping(value={"/member/index.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  68:    */   public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  69:    */   {
/*  70: 67 */     Site site = ContextTools.getSite(request);
/*  71: 68 */     User user = ContextTools.getUser(request);
/*  72: 69 */     if (user == null) {
/*  73: 70 */       return ViewTools.showLogin(request, model, "必须登录才可以访问该页面!");
/*  74:    */     }
/*  75: 72 */     ViewTools.frontData(request, model, site);
/*  76: 73 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/*  77: 74 */       "user", "tpl.memberIndex");
/*  78:    */   }
/*  79:    */   
/*  80:    */   @RequestMapping(value={"/member/editPass.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  81:    */   public String editPass(HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  82:    */   {
/*  83: 80 */     Site site = ContextTools.getSite(request);
/*  84: 81 */     User user = ContextTools.getUser(request);
/*  85: 82 */     if (user == null) {
/*  86: 83 */       return ViewTools.showLogin(request, model, "必须登录才可以访问该页面!");
/*  87:    */     }
/*  88: 85 */     ViewTools.frontData(request, model, site);
/*  89: 86 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/*  90: 87 */       "user", "tpl.memberEditPass");
/*  91:    */   }
/*  92:    */   
/*  93:    */   @RequestMapping(value={"/member/editPass.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  94:    */   public String editPassSumbit(String oldpassword, String password, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  95:    */   {
/*  96: 94 */     Site site = ContextTools.getSite(request);
/*  97: 95 */     User user = ContextTools.getUser(request);
/*  98: 96 */     if (user == null) {
/*  99: 97 */       return ViewTools.showLogin(request, model, "必须登录才可以访问该页面!");
/* 100:    */     }
/* 101: 99 */     if (user.getPassword().equals(this.pwdEncoder.encodePassword(oldpassword)))
/* 102:    */     {
/* 103:100 */       this.memberService.updatePass(user.getId(), password);
/* 104:101 */       model.addAttribute("msg", "密码修改成功!");
/* 105:102 */       model.addAttribute("status", Integer.valueOf(1));
/* 106:    */     }
/* 107:    */     else
/* 108:    */     {
/* 109:104 */       model.addAttribute("msg", "原密码错误，修改失败!");
/* 110:105 */       model.addAttribute("status", Integer.valueOf(0));
/* 111:    */     }
/* 112:107 */     ViewTools.frontData(request, model, site);
/* 113:108 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 114:109 */       "user", "tpl.memberEditPass");
/* 115:    */   }
/* 116:    */   
/* 117:    */   @RequestMapping(value={"/member/editInfo.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 118:    */   public String editInfo(HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 119:    */   {
/* 120:115 */     Site site = ContextTools.getSite(request);
/* 121:116 */     User user = ContextTools.getUser(request);
/* 122:117 */     if (user == null) {
/* 123:118 */       return ViewTools.showLogin(request, model, "必须登录才可以访问该页面!");
/* 124:    */     }
/* 125:120 */     ViewTools.frontData(request, model, site);
/* 126:121 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 127:122 */       "user", "tpl.memberEditInfo");
/* 128:    */   }
/* 129:    */   
/* 130:    */   @RequestMapping(value={"/member/editInfo.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 131:    */   public String editInfoSubmit(User u, Member m, @RequestParam(value="file", required=false) MultipartFile file, HttpServletRequest request, HttpServletResponse response, ModelMap model, RedirectAttributes ra)
/* 132:    */   {
/* 133:130 */     Site site = ContextTools.getSite(request);
/* 134:131 */     User user = ContextTools.getUser(request);
/* 135:132 */     if (user == null) {
/* 136:133 */       return ViewTools.showLogin(request, model, "必须登录才可以访问该页面!");
/* 137:    */     }
/* 138:135 */     if (!file.isEmpty())
/* 139:    */     {
/* 140:136 */       String fileUrl = this.fileRepository.uploadFile(file, 
/* 141:137 */         site.getUploadPath());
/* 142:138 */       m.setAvatar(fileUrl);
/* 143:    */     }
/* 144:140 */     m.setRegisterIp(ServicesUtils.getIpAddr(request));
/* 145:141 */     this.memberService.updateMember(u, m, null, site.getId());
/* 146:142 */     ra.addFlashAttribute("msg", "基本资料修改成功!");
/* 147:143 */     return "redirect:index.jsp";
/* 148:    */   }
/* 149:    */   
/* 150:    */   @RequestMapping(value={"/member/docList.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 151:    */   public String docList(String title, Integer chnlId, Integer[] typeIds, Integer[] modelIds, boolean top, boolean recommend, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 152:    */   {
/* 153:151 */     return docListpage(title, chnlId, typeIds, modelIds, top, recommend, Integer.valueOf(1), 
/* 154:152 */       request, response, model);
/* 155:    */   }
/* 156:    */   
/* 157:    */   @RequestMapping(value={"/member/docList_{pageNo:[0-9]+}.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 158:    */   public String docListpage(String title, Integer chnlId, Integer[] typeIds, Integer[] modelIds, boolean top, boolean recommend, @PathVariable Integer pageNo, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 159:    */   {
/* 160:160 */     Site site = ContextTools.getSite(request);
/* 161:161 */     User user = ContextTools.getUser(request);
/* 162:162 */     if (user == null) {
/* 163:163 */       return ViewTools.showLogin(request, model, "必须登录才可以访问该页面!");
/* 164:    */     }
/* 165:165 */     List<ArticleType> typeList = this.articleTypeService.getList(false, null, 
/* 166:166 */       null);
/* 167:167 */     Pagination p = this.service.getPageDocByMember(title, typeIds, modelIds, 
/* 168:168 */       top, recommend, site.getId(), user.getId(), chnlId, 
/* 169:169 */       SimplePage.cpn(pageNo), 15);
/* 170:170 */     model.addAttribute("page", p);
/* 171:171 */     model.addAttribute("typeList", typeList);
/* 172:172 */     model.addAttribute("modelList", this.modelService.getList(false, null, null));
/* 173:173 */     ViewTools.frontData(request, model, site);
/* 174:174 */     ViewTools.frontPageData(request, model);
/* 175:175 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 176:176 */       "user", "tpl.docList");
/* 177:    */   }
/* 178:    */   
/* 179:    */   @RequestMapping(value={"/member/docAdd-{modelId:[0-9]+}.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 180:    */   public String docAdd(@PathVariable Integer modelId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 181:    */   {
/* 182:183 */     Site site = ContextTools.getSite(request);
/* 183:184 */     User user = ContextTools.getUser(request);
/* 184:185 */     if (user == null) {
/* 185:186 */       return ViewTools.showLogin(request, model, "必须登录才可以访问该页面!");
/* 186:    */     }
/* 187:188 */     Model m = this.modelService.findById(modelId);
/* 188:189 */     if (m == null) {
/* 189:190 */       return ViewTools.pageNotFound(response);
/* 190:    */     }
/* 191:192 */     List<ModelField> fieldList = this.modelFieldService.getList(m.getId(), 
/* 192:193 */       false, null, null);
/* 193:194 */     List<ArticleType> typeList = this.articleTypeService.getList(false, null, 
/* 194:195 */       null);
/* 195:196 */     ViewTools.frontData(request, model, site);
/* 196:197 */     model.addAttribute("model", m);
/* 197:198 */     model.addAttribute("fieldList", fieldList);
/* 198:199 */     model.addAttribute("typeList", typeList);
/* 199:200 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 200:201 */       "user", "tpl.docAdd");
/* 201:    */   }
/* 202:    */   
/* 203:    */   @RequestMapping(value={"/member/docSave.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 204:    */   public String docSave(Article bean, ArticleExt ext, ArticleTxt txt, Integer modelId, String[] attPaths, String[] attNames, String[] imgPaths, String[] imgDescs, Boolean[] thumbs, String[] imgStyles, Integer channelId, HttpServletRequest request, HttpServletResponse response, ModelMap model, RedirectAttributes ra)
/* 205:    */   {
/* 206:210 */     Site site = ContextTools.getSite(request);
/* 207:211 */     User user = ContextTools.getUser(request);
/* 208:212 */     if (user == null) {
/* 209:213 */       return ViewTools.showLogin(request, model, "必须登录才可以访问该页面!");
/* 210:    */     }
/* 211:215 */     bean.setSite(site);
/* 212:216 */     bean.setAttr(ServicesUtils.getRequestMap(request, "attr_"));
/* 213:217 */     bean = this.service.save(bean, ext, txt, null, null, attPaths, attNames, 
/* 214:218 */       imgPaths, imgDescs, thumbs, imgStyles, channelId, modelId, 
/* 215:219 */       user, true);
/* 216:220 */     ra.addFlashAttribute("msg", "文档添加成功，请等待审核!");
/* 217:221 */     return "redirect:docList.jsp";
/* 218:    */   }
/* 219:    */   
/* 220:    */   @RequestMapping(value={"/member/docEdit-{id:[0-9]+}.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 221:    */   public String docEdit(@PathVariable Integer id, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 222:    */   {
/* 223:227 */     Site site = ContextTools.getSite(request);
/* 224:228 */     User user = ContextTools.getUser(request);
/* 225:229 */     if (user == null) {
/* 226:230 */       return ViewTools.showLogin(request, model, "必须登录才可以访问该页面!");
/* 227:    */     }
/* 228:232 */     Article article = this.service.findById(id);
/* 229:233 */     if ((article == null) || (!article.getUser().equals(user))) {
/* 230:234 */       return ViewTools.pageNotFound(response);
/* 231:    */     }
/* 232:236 */     List<ModelField> fieldList = this.modelFieldService.getList(article
/* 233:237 */       .getModel().getId(), false, null, null);
/* 234:238 */     List<ArticleType> typeList = this.articleTypeService.getList(false, null, 
/* 235:239 */       null);
/* 236:240 */     model.addAttribute("article", article);
/* 237:241 */     model.addAttribute("channel", article.getChannel());
/* 238:242 */     model.addAttribute("fieldList", fieldList);
/* 239:243 */     model.addAttribute("typeList", typeList);
/* 240:244 */     ViewTools.frontData(request, model, site);
/* 241:245 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 242:246 */       "user", "tpl.docEdit");
/* 243:    */   }
/* 244:    */   
/* 245:    */   @RequestMapping(value={"/member/docUpdate.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 246:    */   public String docUpdate(Article bean, ArticleExt ext, ArticleTxt txt, Integer[] channelIds, Integer[] topicIds, Integer[] viewGroupIds, String[] attPaths, String[] attNames, String[] imgPaths, String[] imgDescs, Boolean[] thumbs, String[] imgStyles, Integer channelId, HttpServletRequest request, ModelMap model, RedirectAttributes ra)
/* 247:    */   {
/* 248:256 */     User user = ContextTools.getUser(request);
/* 249:257 */     Map<String, String> attr = 
/* 250:258 */       ServicesUtils.getRequestMap(request, "attr_");
/* 251:259 */     bean = this.service.update(bean, ext, txt, channelIds, viewGroupIds, 
/* 252:260 */       attPaths, attNames, imgPaths, imgDescs, thumbs, imgStyles, 
/* 253:261 */       attr, channelId, user, true);
/* 254:262 */     ra.addFlashAttribute("msg", "文档修改成功，请等待审核!");
/* 255:263 */     return "redirect:docList.jsp";
/* 256:    */   }
/* 257:    */   
/* 258:    */   @RequestMapping(value={"/member/docDel-{id:[0-9]+}.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 259:    */   public String docDel(@PathVariable Integer id, HttpServletRequest request, HttpServletResponse response, ModelMap model, RedirectAttributes ra)
/* 260:    */   {
/* 261:269 */     User user = ContextTools.getUser(request);
/* 262:270 */     if (user == null) {
/* 263:271 */       return ViewTools.showLogin(request, model, "必须登录才可以访问该页面!");
/* 264:    */     }
/* 265:273 */     Article article = this.service.findById(id);
/* 266:274 */     if ((article == null) || (!article.getUser().equals(user))) {
/* 267:275 */       return ViewTools.pageNotFound(response);
/* 268:    */     }
/* 269:277 */     this.service.cycle(id);
/* 270:278 */     ra.addFlashAttribute("msg", "文档删除成功!");
/* 271:279 */     return "redirect:docList.jsp";
/* 272:    */   }
/* 273:    */   
/* 274:    */   @RequestMapping(value={"/member/themeList.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 275:    */   public String themeList(HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 276:    */   {
/* 277:285 */     return themeListpage(request, response, model);
/* 278:    */   }
/* 279:    */   
/* 280:    */   @RequestMapping(value={"/member/themeList_{page:[0-9]+}.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 281:    */   public String themeListpage(HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 282:    */   {
/* 283:291 */     Site site = ContextTools.getSite(request);
/* 284:292 */     User user = ContextTools.getUser(request);
/* 285:293 */     if (user == null) {
/* 286:294 */       return ViewTools.showLogin(request, model, "必须登录才可以访问该页面!");
/* 287:    */     }
/* 288:296 */     ViewTools.frontData(request, model, site);
/* 289:297 */     ViewTools.frontPageData(request, model);
/* 290:298 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 291:299 */       "user", "tpl.myTheme");
/* 292:    */   }
/* 293:    */   
/* 294:    */   @RequestMapping(value={"/member/replyList.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 295:    */   public String replyList(HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 296:    */   {
/* 297:305 */     return replyListpage(request, response, model);
/* 298:    */   }
/* 299:    */   
/* 300:    */   @RequestMapping(value={"/member/replyList_{page:[0-9]+}.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 301:    */   public String replyListpage(HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 302:    */   {
/* 303:311 */     Site site = ContextTools.getSite(request);
/* 304:312 */     User user = ContextTools.getUser(request);
/* 305:313 */     if (user == null) {
/* 306:314 */       return ViewTools.showLogin(request, model, "必须登录才可以访问该页面!");
/* 307:    */     }
/* 308:316 */     ViewTools.frontData(request, model, site);
/* 309:317 */     ViewTools.frontPageData(request, model);
/* 310:318 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 311:319 */       "user", "tpl.myReply");
/* 312:    */   }
/* 313:    */   
/* 314:    */   @RequestMapping({"/member/channeltree.jsp"})
/* 315:    */   public String addtree(Integer parentId, Integer modelId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 316:    */   {
/* 317:326 */     model.addAttribute("parentId", parentId);
/* 318:327 */     Site site = ContextTools.getSite(request);
/* 319:328 */     User user = ContextTools.getUser(request);
/* 320:329 */     List<Channel> list = this.channelService.getChannelByModel(parentId, 
/* 321:330 */       modelId, user.getId(), site.getId());
/* 322:331 */     model.addAttribute("list", list);
/* 323:332 */     response.setHeader("Cache-Control", "no-cache");
/* 324:333 */     response.setContentType("text/json;charset=UTF-8");
/* 325:334 */     return ViewTools.getTplPath(null, site.getSolutionPath(), 
/* 326:335 */       "user", "channeltree");
/* 327:    */   }
/* 328:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.action.fnt.MemberAct
 * JD-Core Version:    0.7.0.1
 */