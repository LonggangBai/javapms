/*   1:    */ package com.portal.extrafunc.action.fnt;
/*   2:    */ 
/*   3:    */ import com.portal.extrafunc.entity.Forum;
/*   4:    */ import com.portal.extrafunc.entity.Posts;
/*   5:    */ import com.portal.extrafunc.entity.Theme;
/*   6:    */ import com.portal.extrafunc.entity.UserForum;
/*   7:    */ import com.portal.extrafunc.service.PostsService;
/*   8:    */ import com.portal.extrafunc.service.ThemeService;
/*   9:    */ import com.portal.extrafunc.service.UserForumService;
/*  10:    */ import com.portal.sysmgr.utils.ContextTools;
/*  11:    */ import com.portal.sysmgr.utils.ViewTools;
/*  12:    */ import com.portal.usermgr.entity.User;
/*  13:    */ import java.util.Date;
/*  14:    */ import javax.servlet.http.HttpServletRequest;
/*  15:    */ import javax.servlet.http.HttpServletResponse;
/*  16:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  17:    */ import org.springframework.stereotype.Controller;
/*  18:    */ import org.springframework.ui.ModelMap;
/*  19:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  20:    */ 
/*  21:    */ @Controller
/*  22:    */ public class OperateAct
/*  23:    */ {
/*  24:    */   @Autowired
/*  25:    */   private ThemeService themeService;
/*  26:    */   @Autowired
/*  27:    */   private PostsService postsService;
/*  28:    */   @Autowired
/*  29:    */   private UserForumService userForumService;
/*  30:    */   
/*  31:    */   @RequestMapping(value={"/topTheme.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  32:    */   public String topTheme(Integer[] themeId, Integer topLevel, Date topTime, String reason, Integer pn, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  33:    */   {
/*  34: 38 */     if (themeId != null)
/*  35:    */     {
/*  36: 39 */       User user = ContextTools.getUser(request);
/*  37: 40 */       Theme theme = null;
/*  38: 41 */       for (Integer tid : themeId)
/*  39:    */       {
/*  40: 42 */         theme = this.themeService.findById(tid);
/*  41: 43 */         if (theme == null) {
/*  42: 44 */           return ViewTools.pageNotFound(response);
/*  43:    */         }
/*  44: 46 */         if (user == null) {
/*  45: 47 */           return ViewTools.showLogin(request, model, 
/*  46: 48 */             "必须登录才可以进行置顶操作!");
/*  47:    */         }
/*  48: 50 */         if (user.getAdmin() == null) {
/*  49: 51 */           return ViewTools.pageNotFound(response);
/*  50:    */         }
/*  51: 53 */         this.themeService.topTheme(tid, user.getId(), topLevel, topTime, 
/*  52: 54 */           reason);
/*  53:    */       }
/*  54: 56 */       if ((pn != null) && (pn.intValue() > 1)) {
/*  55: 57 */         return "redirect:" + theme.getForum().getUrl(pn);
/*  56:    */       }
/*  57: 59 */       return "redirect:" + theme.getForum().getUrl();
/*  58:    */     }
/*  59: 61 */     return ViewTools.pageNotFound(response);
/*  60:    */   }
/*  61:    */   
/*  62:    */   @RequestMapping(value={"/essenaTheme.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  63:    */   public String essenaTheme(Integer[] themeId, Date essenaTime, String reason, Integer pn, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  64:    */   {
/*  65: 68 */     if (themeId != null)
/*  66:    */     {
/*  67: 69 */       User user = ContextTools.getUser(request);
/*  68: 70 */       Theme theme = null;
/*  69: 71 */       for (Integer tid : themeId)
/*  70:    */       {
/*  71: 72 */         theme = this.themeService.findById(tid);
/*  72: 73 */         if (theme == null) {
/*  73: 74 */           return ViewTools.pageNotFound(response);
/*  74:    */         }
/*  75: 76 */         if (user == null) {
/*  76: 77 */           return ViewTools.showLogin(request, model, 
/*  77: 78 */             "必须登录才可以进行精华操作!");
/*  78:    */         }
/*  79: 80 */         if (user.getAdmin() == null) {
/*  80: 81 */           return ViewTools.pageNotFound(response);
/*  81:    */         }
/*  82: 83 */         this.themeService.essenaTheme(tid, user.getId(), essenaTime, reason);
/*  83:    */       }
/*  84: 85 */       if ((pn != null) && (pn.intValue() > 1)) {
/*  85: 86 */         return "redirect:" + theme.getForum().getUrl(pn);
/*  86:    */       }
/*  87: 88 */       return "redirect:" + theme.getForum().getUrl();
/*  88:    */     }
/*  89: 90 */     return ViewTools.pageNotFound(response);
/*  90:    */   }
/*  91:    */   
/*  92:    */   @RequestMapping(value={"/lightTheme.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  93:    */   public String lightTheme(Integer[] themeId, String color, Boolean bold, Boolean italic, Date lightTime, String reason, Integer pn, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*  94:    */   {
/*  95: 98 */     if (themeId != null)
/*  96:    */     {
/*  97: 99 */       User user = ContextTools.getUser(request);
/*  98:100 */       Theme theme = null;
/*  99:101 */       for (Integer tid : themeId)
/* 100:    */       {
/* 101:102 */         theme = this.themeService.findById(tid);
/* 102:103 */         if (theme == null) {
/* 103:104 */           return ViewTools.pageNotFound(response);
/* 104:    */         }
/* 105:106 */         if (user == null) {
/* 106:107 */           return ViewTools.showLogin(request, model, 
/* 107:108 */             "必须登录才可以进行高亮操作!");
/* 108:    */         }
/* 109:110 */         if (user.getAdmin() == null) {
/* 110:111 */           return ViewTools.pageNotFound(response);
/* 111:    */         }
/* 112:113 */         this.themeService.lightTheme(tid, user.getId(), color, bold, italic, 
/* 113:114 */           lightTime, reason);
/* 114:    */       }
/* 115:116 */       if ((pn != null) && (pn.intValue() > 1)) {
/* 116:117 */         return "redirect:" + theme.getForum().getUrl(pn);
/* 117:    */       }
/* 118:119 */       return "redirect:" + theme.getForum().getUrl();
/* 119:    */     }
/* 120:121 */     return ViewTools.pageNotFound(response);
/* 121:    */   }
/* 122:    */   
/* 123:    */   @RequestMapping(value={"/lockTheme.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 124:    */   public String lockTheme(Integer[] themeId, Date lockTime, String reason, Integer pn, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 125:    */   {
/* 126:128 */     if (themeId != null)
/* 127:    */     {
/* 128:129 */       User user = ContextTools.getUser(request);
/* 129:130 */       Theme theme = null;
/* 130:131 */       for (Integer tid : themeId)
/* 131:    */       {
/* 132:132 */         theme = this.themeService.findById(tid);
/* 133:133 */         if (theme == null) {
/* 134:134 */           return ViewTools.pageNotFound(response);
/* 135:    */         }
/* 136:136 */         if (user == null) {
/* 137:137 */           return ViewTools.showLogin(request, model, 
/* 138:138 */             "必须登录才可以进行锁定操作!");
/* 139:    */         }
/* 140:140 */         if (user.getAdmin() == null) {
/* 141:141 */           return ViewTools.pageNotFound(response);
/* 142:    */         }
/* 143:143 */         this.themeService.lockTheme(tid, user.getId(), lockTime, reason);
/* 144:    */       }
/* 145:145 */       if ((pn != null) && (pn.intValue() > 1)) {
/* 146:146 */         return "redirect:" + theme.getForum().getUrl(pn);
/* 147:    */       }
/* 148:148 */       return "redirect:" + theme.getForum().getUrl();
/* 149:    */     }
/* 150:150 */     return ViewTools.pageNotFound(response);
/* 151:    */   }
/* 152:    */   
/* 153:    */   @RequestMapping(value={"/moveTheme.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 154:    */   public String moveTheme(Integer[] themeId, Integer forumId, String reason, Integer pn, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 155:    */   {
/* 156:157 */     if (themeId != null)
/* 157:    */     {
/* 158:158 */       User user = ContextTools.getUser(request);
/* 159:159 */       Theme theme = null;
/* 160:160 */       for (Integer tid : themeId)
/* 161:    */       {
/* 162:161 */         theme = this.themeService.findById(tid);
/* 163:162 */         if (theme == null) {
/* 164:163 */           return ViewTools.pageNotFound(response);
/* 165:    */         }
/* 166:165 */         if (user == null) {
/* 167:166 */           return ViewTools.showLogin(request, model, 
/* 168:167 */             "必须登录才可以进行移动操作!");
/* 169:    */         }
/* 170:169 */         if (user.getAdmin() == null) {
/* 171:170 */           return ViewTools.pageNotFound(response);
/* 172:    */         }
/* 173:172 */         this.themeService.moveTheme(tid, user.getId(), forumId, reason);
/* 174:    */       }
/* 175:174 */       if ((pn != null) && (pn.intValue() > 1)) {
/* 176:175 */         return "redirect:" + theme.getForum().getUrl(pn);
/* 177:    */       }
/* 178:177 */       return "redirect:" + theme.getForum().getUrl();
/* 179:    */     }
/* 180:179 */     return ViewTools.pageNotFound(response);
/* 181:    */   }
/* 182:    */   
/* 183:    */   @RequestMapping(value={"/shieldTheme.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 184:    */   public String shieldTheme(Integer[] themeId, String reason, Integer pn, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 185:    */   {
/* 186:186 */     if (themeId != null)
/* 187:    */     {
/* 188:187 */       User user = ContextTools.getUser(request);
/* 189:188 */       Theme theme = null;
/* 190:189 */       for (Integer tid : themeId)
/* 191:    */       {
/* 192:190 */         theme = this.themeService.findById(tid);
/* 193:191 */         if (theme == null) {
/* 194:192 */           return ViewTools.pageNotFound(response);
/* 195:    */         }
/* 196:194 */         if (user == null) {
/* 197:195 */           return ViewTools.showLogin(request, model, 
/* 198:196 */             "必须登录才可以进行屏蔽操作!");
/* 199:    */         }
/* 200:198 */         if (user.getAdmin() == null) {
/* 201:199 */           return ViewTools.pageNotFound(response);
/* 202:    */         }
/* 203:201 */         this.postsService.shieldTheme(tid, user.getId(), reason);
/* 204:    */       }
/* 205:203 */       if ((pn != null) && (pn.intValue() > 1)) {
/* 206:204 */         return "redirect:" + theme.getForum().getUrl(pn);
/* 207:    */       }
/* 208:206 */       return "redirect:" + theme.getForum().getUrl();
/* 209:    */     }
/* 210:208 */     return ViewTools.pageNotFound(response);
/* 211:    */   }
/* 212:    */   
/* 213:    */   @RequestMapping(value={"/shieldPosts.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 214:    */   public String shieldPosts(Integer postsId, String reason, Integer pn, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 215:    */   {
/* 216:215 */     Posts posts = this.postsService.findById(postsId);
/* 217:216 */     User user = ContextTools.getUser(request);
/* 218:217 */     if (posts == null) {
/* 219:218 */       return ViewTools.pageNotFound(response);
/* 220:    */     }
/* 221:220 */     if (user == null) {
/* 222:221 */       return ViewTools.showLogin(request, model, "必须登录才可以进行屏蔽操作!");
/* 223:    */     }
/* 224:223 */     if (user.getAdmin() == null) {
/* 225:224 */       return ViewTools.pageNotFound(response);
/* 226:    */     }
/* 227:226 */     if (posts.getFloor().intValue() == 1) {
/* 228:227 */       this.postsService.shieldTheme(posts.getTheme().getId(), user.getId(), 
/* 229:228 */         reason);
/* 230:    */     } else {
/* 231:230 */       this.postsService.shieldPosts(postsId, user.getId(), reason);
/* 232:    */     }
/* 233:232 */     if ((pn != null) && (pn.intValue() > 1)) {
/* 234:233 */       return "redirect:" + posts.getTheme().getUrl(pn);
/* 235:    */     }
/* 236:235 */     return "redirect:" + posts.getTheme().getUrl();
/* 237:    */   }
/* 238:    */   
/* 239:    */   @RequestMapping(value={"/deleteTheme.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 240:    */   public String deleteTheme(Integer[] themeId, String reason, Integer pn, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 241:    */   {
/* 242:242 */     if (themeId != null)
/* 243:    */     {
/* 244:243 */       User user = ContextTools.getUser(request);
/* 245:244 */       Theme theme = null;
/* 246:245 */       for (Integer tid : themeId)
/* 247:    */       {
/* 248:246 */         theme = this.themeService.findById(tid);
/* 249:247 */         if (theme == null) {
/* 250:248 */           return ViewTools.pageNotFound(response);
/* 251:    */         }
/* 252:250 */         if (user == null) {
/* 253:251 */           return ViewTools.showLogin(request, model, 
/* 254:252 */             "必须登录才可以进行删除操作!");
/* 255:    */         }
/* 256:254 */         if (user.getAdmin() == null) {
/* 257:255 */           return ViewTools.pageNotFound(response);
/* 258:    */         }
/* 259:257 */         this.postsService.deleteTheme(tid, user.getId(), reason);
/* 260:    */       }
/* 261:259 */       if ((pn != null) && (pn.intValue() > 1)) {
/* 262:260 */         return "redirect:" + theme.getForum().getUrl(pn);
/* 263:    */       }
/* 264:262 */       return "redirect:" + theme.getForum().getUrl();
/* 265:    */     }
/* 266:264 */     return ViewTools.pageNotFound(response);
/* 267:    */   }
/* 268:    */   
/* 269:    */   @RequestMapping(value={"/shieldUser.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 270:    */   public String shieldUser(Integer userId, Integer themeId, Date shieldTime, String reason, Integer pn, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 271:    */   {
/* 272:271 */     UserForum uf = this.userForumService.findById(userId);
/* 273:272 */     User user = ContextTools.getUser(request);
/* 274:273 */     if (uf == null) {
/* 275:274 */       return ViewTools.pageNotFound(response);
/* 276:    */     }
/* 277:276 */     if (user == null) {
/* 278:277 */       return ViewTools.showLogin(request, model, "必须登录才可以进行屏蔽会员操作!");
/* 279:    */     }
/* 280:279 */     if (user.getAdmin() == null) {
/* 281:280 */       return ViewTools.pageNotFound(response);
/* 282:    */     }
/* 283:282 */     Theme theme = this.themeService.findById(themeId);
/* 284:283 */     if (theme == null) {
/* 285:284 */       return ViewTools.pageNotFound(response);
/* 286:    */     }
/* 287:286 */     this.userForumService.shieldUserForum(userId, shieldTime);
/* 288:287 */     if ((pn != null) && (pn.intValue() > 1)) {
/* 289:288 */       return "redirect:" + theme.getUrl(pn);
/* 290:    */     }
/* 291:290 */     return "redirect:" + theme.getUrl();
/* 292:    */   }
/* 293:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.action.fnt.OperateAct
 * JD-Core Version:    0.7.0.1
 */