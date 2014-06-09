/*   1:    */ package com.portal.extrafunc.service.impl;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.hibernate3.Updater;
/*   4:    */ import com.javapms.basic.page.Pagination;
/*   5:    */ import com.portal.extrafunc.action.cache.ForumCache;
/*   6:    */ import com.portal.extrafunc.action.cache.ForumStatisCache;
/*   7:    */ import com.portal.extrafunc.dao.ThemeDao;
/*   8:    */ import com.portal.extrafunc.entity.Theme;
/*   9:    */ import com.portal.extrafunc.service.ForumOperateService;
/*  10:    */ import com.portal.extrafunc.service.ForumService;
/*  11:    */ import com.portal.extrafunc.service.ThemeService;
/*  12:    */ import com.portal.extrafunc.service.ThemeTxtService;
/*  13:    */ import com.portal.sysmgr.service.SiteService;
/*  14:    */ import com.portal.usermgr.entity.User;
/*  15:    */ import com.portal.usermgr.service.UserService;
/*  16:    */ import java.sql.Timestamp;
/*  17:    */ import java.util.Date;
/*  18:    */ import java.util.List;
/*  19:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  20:    */ import org.springframework.stereotype.Service;
/*  21:    */ import org.springframework.transaction.annotation.Transactional;
/*  22:    */ 
/*  23:    */ @Service
/*  24:    */ @Transactional
/*  25:    */ public class ThemeServiceImpl
/*  26:    */   implements ThemeService
/*  27:    */ {
/*  28:    */   private ThemeDao dao;
/*  29:    */   private UserService userService;
/*  30:    */   private ForumService forumService;
/*  31:    */   private SiteService siteService;
/*  32:    */   private ThemeTxtService txtService;
/*  33:    */   private ForumCache forumCache;
/*  34:    */   private ForumStatisCache statisCache;
/*  35:    */   private ForumOperateService operateService;
/*  36:    */   
/*  37:    */   @Transactional(readOnly=true)
/*  38:    */   public Pagination getPage(int pageNo, int pageSize)
/*  39:    */   {
/*  40: 31 */     Pagination page = this.dao.getPage(pageNo, pageSize);
/*  41: 32 */     return page;
/*  42:    */   }
/*  43:    */   
/*  44:    */   @Transactional(readOnly=true)
/*  45:    */   public Pagination getThemePageForTag(Integer forumId, Integer status, Integer createrId, Integer replyId, int orderBy, int pageNo, int pageSize)
/*  46:    */   {
/*  47: 39 */     return this.dao.getThemePageForTag(forumId, status, createrId, replyId, 
/*  48: 40 */       orderBy, pageNo, pageSize);
/*  49:    */   }
/*  50:    */   
/*  51:    */   @Transactional(readOnly=true)
/*  52:    */   public Theme findById(Integer id)
/*  53:    */   {
/*  54: 45 */     Theme entity = this.dao.findById(id);
/*  55: 46 */     return entity;
/*  56:    */   }
/*  57:    */   
/*  58:    */   public Theme save(Integer siteId, Integer userId, Integer forumId, String title, boolean img, boolean affix)
/*  59:    */   {
/*  60: 51 */     Theme theme = new Theme();
/*  61: 52 */     theme.setCreater(this.userService.findById(userId));
/*  62: 53 */     theme.setLastReplyer(this.userService.findById(userId));
/*  63: 54 */     theme.setSite(this.siteService.findById(siteId));
/*  64: 55 */     theme.setForum(this.forumService.findById(forumId));
/*  65: 56 */     theme.setTitle(title);
/*  66: 57 */     theme.setAffix(Boolean.valueOf(affix));
/*  67: 58 */     theme.setImg(Boolean.valueOf(img));
/*  68: 59 */     theme.init();
/*  69: 60 */     this.dao.save(theme);
/*  70: 61 */     this.txtService.save(theme);
/*  71: 62 */     this.forumCache.updateForum(theme, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0));
/*  72: 63 */     this.statisCache.updateStatis(this.siteService.findById(siteId), Integer.valueOf(1), Integer.valueOf(1));
/*  73: 64 */     return theme;
/*  74:    */   }
/*  75:    */   
/*  76:    */   public Theme updateReply(Theme theme, User user, boolean affix)
/*  77:    */   {
/*  78: 68 */     if (!theme.getAffix().booleanValue()) {
/*  79: 69 */       theme.setAffix(Boolean.valueOf(affix));
/*  80:    */     }
/*  81: 71 */     if (user.getAdmin() != null) {
/*  82: 72 */       theme.setModerReply(Boolean.valueOf(true));
/*  83:    */     }
/*  84: 74 */     theme.setLastReplyer(user);
/*  85: 75 */     theme.setLastReplyTime(new Timestamp(System.currentTimeMillis()));
/*  86: 76 */     theme.setReplyCount(Integer.valueOf(theme.getReplyCount().intValue() + 1));
/*  87: 77 */     this.txtService.update(theme.getId(), user.getId());
/*  88: 78 */     this.forumCache.updateForum(theme, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1));
/*  89: 79 */     this.statisCache.updateStatis(theme.getSite(), Integer.valueOf(1), Integer.valueOf(1));
/*  90: 80 */     return theme;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public Theme topTheme(Integer themeId, Integer userId, Integer topLevel, Date topTime, String reason)
/*  94:    */   {
/*  95: 85 */     Theme theme = findById(themeId);
/*  96: 86 */     theme.setStatus(topLevel);
/*  97: 87 */     theme.setTopTime(topTime);
/*  98: 88 */     this.operateService.save(theme.getId(), "THEME", "置顶", reason, 
/*  99: 89 */       theme.getSite(), this.userService.findById(userId));
/* 100: 90 */     return theme;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public Theme essenaTheme(Integer themeId, Integer userId, Date essenaTime, String reason)
/* 104:    */   {
/* 105: 95 */     Theme theme = findById(themeId);
/* 106: 96 */     theme.setEssena(Boolean.valueOf(true));
/* 107: 97 */     theme.setEssenaTime(essenaTime);
/* 108: 98 */     this.operateService.save(theme.getId(), "THEME", "精华", reason, 
/* 109: 99 */       theme.getSite(), this.userService.findById(userId));
/* 110:100 */     return theme;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public Theme lightTheme(Integer themeId, Integer userId, String color, Boolean bold, Boolean italic, Date lightTime, String reason)
/* 114:    */   {
/* 115:105 */     Theme theme = findById(themeId);
/* 116:106 */     theme.setBold(bold);
/* 117:107 */     theme.setColor(color);
/* 118:108 */     theme.setItalic(italic);
/* 119:109 */     theme.setLightTime(lightTime);
/* 120:110 */     this.operateService.save(theme.getId(), "THEME", "高亮", reason, 
/* 121:111 */       theme.getSite(), this.userService.findById(userId));
/* 122:112 */     return theme;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public Theme lockTheme(Integer themeId, Integer userId, Date lockTime, String reason)
/* 126:    */   {
/* 127:117 */     Theme theme = findById(themeId);
/* 128:118 */     theme.setLock(Boolean.valueOf(true));
/* 129:119 */     theme.setLockTime(lockTime);
/* 130:120 */     this.operateService.save(theme.getId(), "THEME", "锁定", reason, 
/* 131:121 */       theme.getSite(), this.userService.findById(userId));
/* 132:122 */     return theme;
/* 133:    */   }
/* 134:    */   
/* 135:    */   public Theme moveTheme(Integer themeId, Integer userId, Integer forumId, String reason)
/* 136:    */   {
/* 137:127 */     Theme theme = findById(themeId);
/* 138:128 */     theme.setForum(this.forumService.findById(forumId));
/* 139:129 */     this.operateService.save(theme.getId(), "THEME", "移动", reason, 
/* 140:130 */       theme.getSite(), this.userService.findById(userId));
/* 141:131 */     return theme;
/* 142:    */   }
/* 143:    */   
/* 144:    */   public void themeTopCheck()
/* 145:    */   {
/* 146:135 */     List<Theme> list = this.dao.getThemeByTop();
/* 147:136 */     for (Theme theme : list) {
/* 148:137 */       if (theme.getCheckTopTime())
/* 149:    */       {
/* 150:138 */         theme.setStatus(Integer.valueOf(0));
/* 151:139 */         theme.setTopTime(null);
/* 152:    */       }
/* 153:    */     }
/* 154:    */   }
/* 155:    */   
/* 156:    */   public void themeLightCheck()
/* 157:    */   {
/* 158:145 */     List<Theme> list = this.dao.getThemeByLight();
/* 159:146 */     for (Theme theme : list) {
/* 160:147 */       if (theme.getCheckLightTime())
/* 161:    */       {
/* 162:148 */         theme.setColor(null);
/* 163:149 */         theme.setItalic(Boolean.valueOf(false));
/* 164:150 */         theme.setLightTime(null);
/* 165:    */       }
/* 166:    */     }
/* 167:    */   }
/* 168:    */   
/* 169:    */   public void themeLockCheck()
/* 170:    */   {
/* 171:156 */     List<Theme> list = this.dao.getThemeByLock();
/* 172:157 */     for (Theme theme : list) {
/* 173:158 */       if (theme.getCheckLockTime())
/* 174:    */       {
/* 175:159 */         theme.setLock(Boolean.valueOf(false));
/* 176:160 */         theme.setLockTime(null);
/* 177:    */       }
/* 178:    */     }
/* 179:    */   }
/* 180:    */   
/* 181:    */   public Theme update(Theme bean)
/* 182:    */   {
/* 183:166 */     Updater<Theme> updater = new Updater(bean);
/* 184:167 */     bean = this.dao.updateByUpdater(updater);
/* 185:168 */     return bean;
/* 186:    */   }
/* 187:    */   
/* 188:    */   public Theme updateViewCount(Integer themeId, Integer viewCount)
/* 189:    */   {
/* 190:172 */     Theme theme = findById(themeId);
/* 191:173 */     theme.setViewsCount(viewCount);
/* 192:174 */     return theme;
/* 193:    */   }
/* 194:    */   
/* 195:    */   public Theme deleteById(Integer id)
/* 196:    */   {
/* 197:178 */     Theme bean = this.dao.deleteById(id);
/* 198:179 */     return bean;
/* 199:    */   }
/* 200:    */   
/* 201:    */   public Theme[] deleteByIds(Integer[] ids)
/* 202:    */   {
/* 203:183 */     Theme[] beans = new Theme[ids.length];
/* 204:184 */     int i = 0;
/* 205:184 */     for (int len = ids.length; i < len; i++) {
/* 206:185 */       beans[i] = deleteById(ids[i]);
/* 207:    */     }
/* 208:187 */     return beans;
/* 209:    */   }
/* 210:    */   
/* 211:    */   @Autowired
/* 212:    */   public void setDao(ThemeDao dao)
/* 213:    */   {
/* 214:201 */     this.dao = dao;
/* 215:    */   }
/* 216:    */   
/* 217:    */   @Autowired
/* 218:    */   public void setUserService(UserService userService)
/* 219:    */   {
/* 220:206 */     this.userService = userService;
/* 221:    */   }
/* 222:    */   
/* 223:    */   @Autowired
/* 224:    */   public void setForumService(ForumService forumService)
/* 225:    */   {
/* 226:211 */     this.forumService = forumService;
/* 227:    */   }
/* 228:    */   
/* 229:    */   @Autowired
/* 230:    */   public void setSiteService(SiteService siteService)
/* 231:    */   {
/* 232:216 */     this.siteService = siteService;
/* 233:    */   }
/* 234:    */   
/* 235:    */   @Autowired
/* 236:    */   public void setTxtService(ThemeTxtService txtService)
/* 237:    */   {
/* 238:221 */     this.txtService = txtService;
/* 239:    */   }
/* 240:    */   
/* 241:    */   @Autowired
/* 242:    */   public void setForumCache(ForumCache forumCache)
/* 243:    */   {
/* 244:226 */     this.forumCache = forumCache;
/* 245:    */   }
/* 246:    */   
/* 247:    */   @Autowired
/* 248:    */   public void setStatisCache(ForumStatisCache statisCache)
/* 249:    */   {
/* 250:231 */     this.statisCache = statisCache;
/* 251:    */   }
/* 252:    */   
/* 253:    */   @Autowired
/* 254:    */   public void setOperateService(ForumOperateService operateService)
/* 255:    */   {
/* 256:236 */     this.operateService = operateService;
/* 257:    */   }
/* 258:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.impl.ThemeServiceImpl
 * JD-Core Version:    0.7.0.1
 */