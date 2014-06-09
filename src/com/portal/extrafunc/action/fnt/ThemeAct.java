/*   1:    */ package com.portal.extrafunc.action.fnt;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.utils.ServicesUtils;
/*   4:    */ import com.portal.extrafunc.action.cache.PostsCheckCache;
/*   5:    */ import com.portal.extrafunc.action.cache.ThemeStatisCache;
/*   6:    */ import com.portal.extrafunc.entity.Forum;
/*   7:    */ import com.portal.extrafunc.entity.Posts;
/*   8:    */ import com.portal.extrafunc.entity.Theme;
/*   9:    */ import com.portal.extrafunc.entity.UserForum;
/*  10:    */ import com.portal.extrafunc.service.ForumService;
/*  11:    */ import com.portal.extrafunc.service.PostsService;
/*  12:    */ import com.portal.extrafunc.service.ThemeService;
/*  13:    */ import com.portal.sysmgr.entity.Site;
/*  14:    */ import com.portal.sysmgr.utils.ContextTools;
/*  15:    */ import com.portal.sysmgr.utils.ViewTools;
/*  16:    */ import com.portal.usermgr.entity.User;
/*  17:    */ import java.util.Date;
/*  18:    */ import java.util.List;
/*  19:    */ import javax.servlet.http.HttpServletRequest;
/*  20:    */ import javax.servlet.http.HttpServletResponse;
/*  21:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  22:    */ import org.springframework.stereotype.Controller;
/*  23:    */ import org.springframework.ui.ModelMap;
/*  24:    */ import org.springframework.web.bind.annotation.PathVariable;
/*  25:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  26:    */ import org.springframework.web.bind.annotation.RequestParam;
/*  27:    */ import org.springframework.web.multipart.MultipartHttpServletRequest;
/*  28:    */ 
/*  29:    */ @Controller
/*  30:    */ public class ThemeAct
/*  31:    */ {
/*  32:    */   public static final String THEME_LIST = "tpl.themeList";
/*  33:    */   public static final String THEME_DETAIL = "tpl.themeDetail";
/*  34:    */   public static final String THEME_INPUT = "tpl.themeInput";
/*  35:    */   public static final String REPLY_INPUT = "tpl.replyInput";
/*  36:    */   public static final String QUOTE_INPUT = "tpl.quoteInput";
/*  37:    */   public static final String NOT_IRRIGATION = "tpl.notIrrigation";
/*  38:    */   @Autowired
/*  39:    */   private ThemeService themeService;
/*  40:    */   @Autowired
/*  41:    */   private PostsService postsService;
/*  42:    */   @Autowired
/*  43:    */   private ForumService forumService;
/*  44:    */   @Autowired
/*  45:    */   private ThemeStatisCache statisCache;
/*  46:    */   @Autowired
/*  47:    */   private PostsCheckCache postsCheckCache;
/*  48:    */   
/*  49:    */   @RequestMapping(value={"/themeList-{forumId:[0-9]+}.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  50:    */   public String themeList(@PathVariable Integer forumId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  51:    */   {
/*  52: 55 */     Site site = ContextTools.getSite(request);
/*  53: 56 */     Forum forum = this.forumService.findById(forumId);
/*  54: 57 */     if (forum == null) {
/*  55: 58 */       return ViewTools.pageNotFound(response);
/*  56:    */     }
/*  57: 60 */     ViewTools.frontData(request, model, site);
/*  58: 61 */     ViewTools.frontPageData(request, model);
/*  59: 62 */     model.addAttribute("forum", forum);
/*  60: 63 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/*  61: 64 */       "extrafunc/forum", "tpl.themeList");
/*  62:    */   }
/*  63:    */   
/*  64:    */   @RequestMapping(value={"/themeList-{forumId:[0-9]+}_{[0-9]+}.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  65:    */   public String themeListPage(@PathVariable Integer forumId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  66:    */   {
/*  67: 71 */     Site site = ContextTools.getSite(request);
/*  68: 72 */     Forum forum = this.forumService.findById(forumId);
/*  69: 73 */     if (forum == null) {
/*  70: 74 */       return ViewTools.pageNotFound(response);
/*  71:    */     }
/*  72: 76 */     ViewTools.frontData(request, model, site);
/*  73: 77 */     ViewTools.frontPageData(request, model);
/*  74: 78 */     model.addAttribute("forum", forum);
/*  75: 79 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/*  76: 80 */       "extrafunc/forum", "tpl.themeList");
/*  77:    */   }
/*  78:    */   
/*  79:    */   @RequestMapping(value={"/themeDetail-{themeId:[0-9]+}.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  80:    */   public String themeDetail(@PathVariable Integer themeId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  81:    */   {
/*  82: 87 */     Site site = ContextTools.getSite(request);
/*  83: 88 */     Theme theme = this.themeService.findById(themeId);
/*  84: 89 */     if (theme == null) {
/*  85: 90 */       return ViewTools.pageNotFound(response);
/*  86:    */     }
/*  87: 92 */     model.addAttribute("theme", this.themeService.findById(themeId));
/*  88: 93 */     ViewTools.frontData(request, model, site);
/*  89: 94 */     ViewTools.frontPageData(request, model);
/*  90: 95 */     this.statisCache.updateStatis(themeId);
/*  91: 96 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/*  92: 97 */       "extrafunc/forum", "tpl.themeDetail");
/*  93:    */   }
/*  94:    */   
/*  95:    */   @RequestMapping(value={"/themeDetail-{themeId:[0-9]+}_{[0-9]+}.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  96:    */   public String themeDetailPage(@PathVariable Integer themeId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  97:    */   {
/*  98:104 */     Site site = ContextTools.getSite(request);
/*  99:105 */     Theme theme = this.themeService.findById(themeId);
/* 100:106 */     if (theme == null) {
/* 101:107 */       return ViewTools.pageNotFound(response);
/* 102:    */     }
/* 103:109 */     model.addAttribute("theme", this.themeService.findById(themeId));
/* 104:110 */     ViewTools.frontData(request, model, site);
/* 105:111 */     ViewTools.frontPageData(request, model);
/* 106:112 */     this.statisCache.updateStatis(themeId);
/* 107:113 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 108:114 */       "extrafunc/forum", "tpl.themeDetail");
/* 109:    */   }
/* 110:    */   
/* 111:    */   @RequestMapping(value={"/themeInput-{forumId:[0-9]+}.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 112:    */   public String themeInput(@PathVariable Integer forumId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 113:    */   {
/* 114:121 */     Site site = ContextTools.getSite(request);
/* 115:122 */     User user = ContextTools.getUser(request);
/* 116:123 */     if (user == null) {
/* 117:124 */       return ViewTools.showLogin(request, model, "必须登录才可以发帖!");
/* 118:    */     }
/* 119:126 */     Forum forum = this.forumService.findById(forumId);
/* 120:127 */     if (forum == null) {
/* 121:128 */       return ViewTools.pageNotFound(response);
/* 122:    */     }
/* 123:130 */     if ((user.getUserForum() != null) && 
/* 124:131 */       (!user.getUserForum().getStatus().equals(Integer.valueOf(0)))) {
/* 125:132 */       return ViewTools.showMessage(forum.getUrl(), request, model, 
/* 126:133 */         "对不起，您的账号已经被管理员屏蔽，无法发帖!", Integer.valueOf(0));
/* 127:    */     }
/* 128:135 */     ViewTools.frontData(request, model, site);
/* 129:136 */     model.addAttribute("forum", forum);
/* 130:137 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 131:138 */       "extrafunc/forum", "tpl.themeInput");
/* 132:    */   }
/* 133:    */   
/* 134:    */   @RequestMapping(value={"/themeSave.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 135:    */   public String themeSubmit(Integer forumId, String title, String content, @RequestParam(value="code", required=false) List<String> code, MultipartHttpServletRequest mrequest, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 136:    */   {
/* 137:146 */     Site site = ContextTools.getSite(request);
/* 138:147 */     User user = ContextTools.getUser(request);
/* 139:148 */     if (user == null) {
/* 140:149 */       return ViewTools.showLogin(request, model, "必须登录才可以发帖!");
/* 141:    */     }
/* 142:151 */     Forum forum = this.forumService.findById(forumId);
/* 143:152 */     if (forum == null) {
/* 144:153 */       return ViewTools.pageNotFound(response);
/* 145:    */     }
/* 146:155 */     Date d = this.postsCheckCache.postsTime(user.getUsername());
/* 147:156 */     if (!checkPostsTime(d))
/* 148:    */     {
/* 149:157 */       model.addAttribute("interval", Long.valueOf(this.postsCheckCache.getInterval()));
/* 150:158 */       ViewTools.frontData(request, model, site);
/* 151:159 */       return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 152:160 */         "extrafunc/forum", "tpl.notIrrigation");
/* 153:    */     }
/* 154:162 */     this.postsCheckCache.updateCheck(user.getUsername());
/* 155:163 */     String ip = ServicesUtils.getIpAddr(request);
/* 156:164 */     Posts posts = this.postsService.saveTheme(site.getId(), user.getId(), 
/* 157:165 */       forumId, title, content, ip, mrequest.getFiles("attachment"), 
/* 158:166 */       code);
/* 159:167 */     return "redirect:" + posts.getTheme().getUrl();
/* 160:    */   }
/* 161:    */   
/* 162:    */   @RequestMapping(value={"/replyInput-{themeId:[0-9]+}.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 163:    */   public String replyInput(@PathVariable Integer themeId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 164:    */   {
/* 165:174 */     Site site = ContextTools.getSite(request);
/* 166:175 */     User user = ContextTools.getUser(request);
/* 167:176 */     if (user == null) {
/* 168:177 */       return ViewTools.showLogin(request, model, "必须登录才可以回复!");
/* 169:    */     }
/* 170:179 */     Theme theme = this.themeService.findById(themeId);
/* 171:180 */     if (theme == null) {
/* 172:181 */       return ViewTools.pageNotFound(response);
/* 173:    */     }
/* 174:183 */     if (theme.getLock().booleanValue()) {
/* 175:184 */       return ViewTools.showMessage(theme.getUrl(), request, model, 
/* 176:185 */         "对不起，该主题已经被锁定，无法回复!", Integer.valueOf(0));
/* 177:    */     }
/* 178:187 */     if ((user.getUserForum() != null) && 
/* 179:188 */       (!user.getUserForum().getStatus().equals(Integer.valueOf(0)))) {
/* 180:189 */       return ViewTools.showMessage(theme.getUrl(), request, model, 
/* 181:190 */         "对不起，您的账号已经被管理员屏蔽，无法发帖!", Integer.valueOf(0));
/* 182:    */     }
/* 183:192 */     ViewTools.frontData(request, model, site);
/* 184:193 */     model.addAttribute("theme", theme);
/* 185:194 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 186:195 */       "extrafunc/forum", "tpl.replyInput");
/* 187:    */   }
/* 188:    */   
/* 189:    */   @RequestMapping(value={"/replyInput-{themeId:[0-9]+}-{floor:[0-9]+}.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 190:    */   public String replyFloorInput(@PathVariable Integer themeId, @PathVariable Integer floor, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 191:    */   {
/* 192:202 */     Site site = ContextTools.getSite(request);
/* 193:203 */     User user = ContextTools.getUser(request);
/* 194:204 */     if (user == null) {
/* 195:205 */       return ViewTools.showLogin(request, model, "必须登录才可以回复!");
/* 196:    */     }
/* 197:207 */     Theme theme = this.themeService.findById(themeId);
/* 198:208 */     if (theme == null) {
/* 199:209 */       return ViewTools.pageNotFound(response);
/* 200:    */     }
/* 201:211 */     if (theme.getLock().booleanValue()) {
/* 202:212 */       return ViewTools.showMessage(theme.getUrl(), request, model, 
/* 203:213 */         "对不起，该主题已经被锁定，无法回复!", Integer.valueOf(0));
/* 204:    */     }
/* 205:215 */     if ((user.getUserForum() != null) && 
/* 206:216 */       (!user.getUserForum().getStatus().equals(Integer.valueOf(0)))) {
/* 207:217 */       return ViewTools.showMessage(theme.getUrl(), request, model, 
/* 208:218 */         "对不起，您的账号已经被管理员屏蔽，无法发帖!", Integer.valueOf(0));
/* 209:    */     }
/* 210:220 */     ViewTools.frontData(request, model, site);
/* 211:221 */     model.addAttribute("theme", theme);
/* 212:222 */     model.addAttribute("floor", floor);
/* 213:223 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 214:224 */       "extrafunc/forum", "tpl.replyInput");
/* 215:    */   }
/* 216:    */   
/* 217:    */   @RequestMapping(value={"/quoteInput-{postsId:[0-9]+}.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 218:    */   public String quoteInput(@PathVariable Integer postsId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 219:    */   {
/* 220:231 */     Site site = ContextTools.getSite(request);
/* 221:232 */     User user = ContextTools.getUser(request);
/* 222:233 */     if (user == null) {
/* 223:234 */       return ViewTools.showLogin(request, model, "必须登录才可以回复!");
/* 224:    */     }
/* 225:236 */     Posts posts = this.postsService.findById(postsId);
/* 226:237 */     if (posts == null) {
/* 227:238 */       return ViewTools.pageNotFound(response);
/* 228:    */     }
/* 229:240 */     if (posts.getTheme().getLock().booleanValue()) {
/* 230:241 */       return ViewTools.showMessage(posts.getTheme().getUrl(), request, 
/* 231:242 */         model, "对不起，该主题已经被锁定，无法回复!", Integer.valueOf(0));
/* 232:    */     }
/* 233:244 */     if ((user.getUserForum() != null) && 
/* 234:245 */       (!user.getUserForum().getStatus().equals(Integer.valueOf(0)))) {
/* 235:246 */       return ViewTools.showMessage(posts.getTheme().getUrl(), request, 
/* 236:247 */         model, "对不起，您的账号已经被管理员屏蔽，无法发帖!", Integer.valueOf(0));
/* 237:    */     }
/* 238:249 */     if ((user.getAdmin() != null) || 
/* 239:250 */       ((posts.getHidden().booleanValue()) && (posts.getCreater().equals(user))) || 
/* 240:    */       
/* 241:252 */       (posts.getTheme().getReplyUser().indexOf("," + user.getId() + ",") > -1)) {
/* 242:253 */       model.addAttribute("showhide", Boolean.valueOf(true));
/* 243:    */     } else {
/* 244:255 */       model.addAttribute("showhide", Boolean.valueOf(false));
/* 245:    */     }
/* 246:257 */     ViewTools.frontData(request, model, site);
/* 247:258 */     model.addAttribute("posts", posts);
/* 248:259 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 249:260 */       "extrafunc/forum", "tpl.quoteInput");
/* 250:    */   }
/* 251:    */   
/* 252:    */   @RequestMapping(value={"/replySave.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 253:    */   public String replySubmit(Integer themeId, Integer quoteId, String title, String content, @RequestParam(value="code", required=false) List<String> code, MultipartHttpServletRequest mrequest, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 254:    */   {
/* 255:269 */     Site site = ContextTools.getSite(request);
/* 256:270 */     User user = ContextTools.getUser(request);
/* 257:271 */     if (user == null) {
/* 258:272 */       return ViewTools.showLogin(request, model, "必须登录才可以回复!");
/* 259:    */     }
/* 260:274 */     Theme theme = this.themeService.findById(themeId);
/* 261:275 */     if (theme == null) {
/* 262:276 */       return ViewTools.pageNotFound(response);
/* 263:    */     }
/* 264:278 */     if (theme.getLock().booleanValue()) {
/* 265:279 */       return ViewTools.showMessage(theme.getUrl(), request, model, 
/* 266:280 */         "对不起，该主题已经被锁定，无法回复!", Integer.valueOf(0));
/* 267:    */     }
/* 268:282 */     Date d = this.postsCheckCache.postsTime(user.getUsername());
/* 269:283 */     if (!checkPostsTime(d))
/* 270:    */     {
/* 271:284 */       model.addAttribute("interval", Long.valueOf(this.postsCheckCache.getInterval()));
/* 272:285 */       ViewTools.frontData(request, model, site);
/* 273:286 */       return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 274:287 */         "extrafunc/forum", "tpl.notIrrigation");
/* 275:    */     }
/* 276:289 */     this.postsCheckCache.updateCheck(user.getUsername());
/* 277:290 */     String ip = ServicesUtils.getIpAddr(request);
/* 278:291 */     this.postsService.savePosts(site.getId(), user.getId(), themeId, quoteId, 
/* 279:292 */       title, content, ip, mrequest.getFiles("attachment"), code);
/* 280:293 */     return "redirect:" + theme.getUrl();
/* 281:    */   }
/* 282:    */   
/* 283:    */   private boolean checkPostsTime(Date d)
/* 284:    */   {
/* 285:297 */     if (d == null) {
/* 286:298 */       return true;
/* 287:    */     }
/* 288:300 */     long second = System.currentTimeMillis() - d.getTime();
/* 289:301 */     second /= 1000L;
/* 290:302 */     if (second > this.postsCheckCache.getInterval()) {
/* 291:303 */       return true;
/* 292:    */     }
/* 293:305 */     return false;
/* 294:    */   }
/* 295:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.action.fnt.ThemeAct
 * JD-Core Version:    0.7.0.1
 */