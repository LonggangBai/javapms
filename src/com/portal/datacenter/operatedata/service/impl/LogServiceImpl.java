/*   1:    */ package com.portal.datacenter.operatedata.service.impl;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.page.Pagination;
/*   4:    */ import com.javapms.basic.plugin.springmvc.MessageResolver;
/*   5:    */ import com.javapms.basic.utils.ServicesUtils;
/*   6:    */ import com.portal.datacenter.operatedata.dao.LogDao;
/*   7:    */ import com.portal.datacenter.operatedata.entity.Log;
/*   8:    */ import com.portal.datacenter.operatedata.service.LogService;
/*   9:    */ import com.portal.sysmgr.entity.Site;
/*  10:    */ import com.portal.sysmgr.utils.ContextTools;
/*  11:    */ import com.portal.usermgr.entity.User;
/*  12:    */ import com.portal.usermgr.service.UserService;
/*  13:    */ import java.util.ArrayList;
/*  14:    */ import java.util.Calendar;
/*  15:    */ import java.util.Date;
/*  16:    */ import javax.servlet.http.HttpServletRequest;
/*  17:    */ import org.apache.commons.lang.StringUtils;
/*  18:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  19:    */ import org.springframework.stereotype.Service;
/*  20:    */ import org.springframework.transaction.annotation.Transactional;
/*  21:    */ import org.springframework.web.util.UrlPathHelper;
/*  22:    */ 
/*  23:    */ @Service
/*  24:    */ @Transactional
/*  25:    */ public class LogServiceImpl
/*  26:    */   implements LogService
/*  27:    */ {
/*  28:    */   private UserService userService;
/*  29:    */   private LogDao dao;
/*  30:    */   
/*  31:    */   @Transactional(readOnly=true)
/*  32:    */   public Pagination getPage(Integer category, Integer siteId, String username, String title, String ip, int pageNo, int pageSize)
/*  33:    */   {
/*  34:    */     Pagination page;
/*  36: 33 */     if (StringUtils.isBlank(username))
/*  37:    */     {
/*  38: 34 */       page = this.dao.getPage(category, siteId, null, title, ip, pageNo, 
/*  39: 35 */         pageSize);
/*  40:    */     }
/*  41:    */     else
/*  42:    */     {
/*  43: 37 */       User user = this.userService.findByUsername(username);
/*  45: 38 */       if (user != null) {
/*  46: 39 */         page = this.dao.getPage(category, siteId, user.getId(), title, ip, 
/*  47: 40 */           pageNo, pageSize);
/*  48:    */       } else {
/*  49: 42 */         page = new Pagination(1, pageSize, 0, new ArrayList(0));
/*  50:    */       }
/*  51:    */     }
/*  52: 45 */     return page;
/*  53:    */   }
/*  54:    */   
/*  55:    */   @Transactional(readOnly=true)
/*  56:    */   public Log findById(Integer id)
/*  57:    */   {
/*  58: 50 */     Log entity = this.dao.findById(id);
/*  59: 51 */     return entity;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public Log save(Integer category, Site site, User user, String url, String ip, Date date, String title, String content)
/*  63:    */   {
/*  64: 56 */     Log log = new Log();
/*  65: 57 */     log.setSite(site);
/*  66: 58 */     log.setUser(user);
/*  67: 59 */     log.setCategory(category);
/*  68: 60 */     log.setIp(ip);
/*  69: 61 */     log.setTime(date);
/*  70: 62 */     log.setUrl(url);
/*  71: 63 */     log.setTitle(title);
/*  72: 64 */     log.setContent(content);
/*  73: 65 */     save(log);
/*  74: 66 */     return log;
/*  75:    */   }
/*  76:    */   
/*  77:    */   public Log loginSuccess(HttpServletRequest request, User user, String title)
/*  78:    */   {
/*  79: 71 */     String ip = ServicesUtils.getIpAddr(request);
/*  80: 72 */     UrlPathHelper helper = new UrlPathHelper();
/*  81: 73 */     String uri = helper.getOriginatingRequestUri(request);
/*  82: 74 */     Date date = new Date();
/*  83: 75 */     Log log = save(Integer.valueOf(1), null, user, uri, ip, date, 
/*  84: 76 */       MessageResolver.getMessage(request, title, new Object[0]), null);
/*  85: 77 */     return log;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public Log loginFailure(HttpServletRequest request, String title, String content)
/*  89:    */   {
/*  90: 82 */     String ip = ServicesUtils.getIpAddr(request);
/*  91: 83 */     UrlPathHelper helper = new UrlPathHelper();
/*  92: 84 */     String uri = helper.getOriginatingRequestUri(request);
/*  93: 85 */     Date date = new Date();
/*  94: 86 */     Log log = save(Integer.valueOf(2), null, null, uri, ip, date, 
/*  95: 87 */       MessageResolver.getMessage(request, title, new Object[0]), content);
/*  96: 88 */     return log;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public Log operating(HttpServletRequest request, String title, String content)
/* 100:    */   {
/* 101: 93 */     Site site = ContextTools.getSite(request);
/* 102: 94 */     User user = ContextTools.getUser(request);
/* 103: 95 */     String ip = ServicesUtils.getIpAddr(request);
/* 104: 96 */     UrlPathHelper helper = new UrlPathHelper();
/* 105: 97 */     String uri = helper.getOriginatingRequestUri(request);
/* 106: 98 */     Date date = new Date();
/* 107: 99 */     Log log = save(Integer.valueOf(3), site, user, uri, ip, date, title, 
/* 108:100 */       content);
/* 109:101 */     return log;
/* 110:    */   }
/* 111:    */   
/* 112:    */   public Log save(Log bean)
/* 113:    */   {
/* 114:105 */     this.dao.save(bean);
/* 115:106 */     return bean;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public int deleteBatch(Integer category, Integer siteId, Integer days)
/* 119:    */   {
/* 120:110 */     Date date = null;
/* 121:111 */     if ((days != null) && (days.intValue() > 0))
/* 122:    */     {
/* 123:112 */       Calendar cal = Calendar.getInstance();
/* 124:113 */       cal.add(5, -days.intValue());
/* 125:114 */       date = cal.getTime();
/* 126:    */     }
/* 127:116 */     return this.dao.deleteBatch(category, siteId, date);
/* 128:    */   }
/* 129:    */   
/* 130:    */   public Log deleteById(Integer id)
/* 131:    */   {
/* 132:120 */     Log bean = this.dao.deleteById(id);
/* 133:121 */     return bean;
/* 134:    */   }
/* 135:    */   
/* 136:    */   public Log[] deleteByIds(Integer[] ids)
/* 137:    */   {
/* 138:125 */     Log[] beans = new Log[ids.length];
/* 139:126 */     int i = 0;
/* 140:126 */     for (int len = ids.length; i < len; i++) {
/* 141:127 */       beans[i] = deleteById(ids[i]);
/* 142:    */     }
/* 143:129 */     return beans;
/* 144:    */   }
/* 145:    */   
/* 146:    */   @Autowired
/* 147:    */   public void setUserService(UserService userService)
/* 148:    */   {
/* 149:137 */     this.userService = userService;
/* 150:    */   }
/* 151:    */   
/* 152:    */   @Autowired
/* 153:    */   public void setDao(LogDao dao)
/* 154:    */   {
/* 155:142 */     this.dao = dao;
/* 156:    */   }
/* 157:    */ }



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.portal.datacenter.operatedata.service.impl.LogServiceImpl

 * JD-Core Version:    0.7.0.1

 */