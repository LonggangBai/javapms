/*   1:    */ package com.portal.extrafunc.service.impl;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.hibernate3.Updater;
/*   4:    */ import com.javapms.basic.page.Pagination;
/*   5:    */ import com.portal.extrafunc.dao.UserForumDao;
/*   6:    */ import com.portal.extrafunc.entity.UserForum;
/*   7:    */ import com.portal.extrafunc.service.UserForumService;
/*   8:    */ import com.portal.usermgr.entity.User;
/*   9:    */ import com.portal.usermgr.service.UserService;
/*  10:    */ import java.util.Date;
/*  11:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  12:    */ import org.springframework.stereotype.Service;
/*  13:    */ import org.springframework.transaction.annotation.Transactional;
/*  14:    */ 
/*  15:    */ @Service
/*  16:    */ @Transactional
/*  17:    */ public class UserForumServiceImpl
/*  18:    */   implements UserForumService
/*  19:    */ {
/*  20:    */   private UserForumDao dao;
/*  21:    */   private UserService userService;
/*  22:    */   
/*  23:    */   @Transactional(readOnly=true)
/*  24:    */   public Pagination getPage(int pageNo, int pageSize)
/*  25:    */   {
/*  26: 22 */     Pagination page = this.dao.getPage(pageNo, pageSize);
/*  27: 23 */     return page;
/*  28:    */   }
/*  29:    */   
/*  30:    */   @Transactional(readOnly=true)
/*  31:    */   public UserForum findById(Integer id)
/*  32:    */   {
/*  33: 28 */     UserForum entity = this.dao.findById(id);
/*  34: 29 */     return entity;
/*  35:    */   }
/*  36:    */   
/*  37:    */   public UserForum save(User user)
/*  38:    */   {
/*  39: 33 */     UserForum bean = new UserForum();
/*  40: 34 */     bean.setUser(user);
/*  41: 35 */     bean.init();
/*  42: 36 */     this.dao.save(bean);
/*  43: 37 */     user.setUserForum(bean);
/*  44: 38 */     return bean;
/*  45:    */   }
/*  46:    */   
/*  47:    */   public UserForum update(Integer userId, Integer themeCount, Integer replyCount, Integer essenaCount, Integer point)
/*  48:    */   {
/*  49: 43 */     UserForum bean = findById(userId);
/*  50: 44 */     if (bean != null)
/*  51:    */     {
/*  52: 45 */       bean.setThemeCount(Integer.valueOf(bean.getThemeCount().intValue() + themeCount.intValue()));
/*  53: 46 */       bean.setEssenaCount(Integer.valueOf(bean.getEssenaCount().intValue() + essenaCount.intValue()));
/*  54: 47 */       bean.setReplyCount(Integer.valueOf(bean.getReplyCount().intValue() + replyCount.intValue()));
/*  55: 48 */       bean.setPoint(Integer.valueOf(bean.getPoint().intValue() + point.intValue()));
/*  56:    */     }
/*  57:    */     else
/*  58:    */     {
/*  59: 50 */       bean = new UserForum();
/*  60: 51 */       User user = this.userService.findById(userId);
/*  61: 52 */       bean.setThemeCount(themeCount);
/*  62: 53 */       bean.setEssenaCount(essenaCount);
/*  63: 54 */       bean.setReplyCount(replyCount);
/*  64: 55 */       bean.setPoint(point);
/*  65: 56 */       bean.setUser(user);
/*  66: 57 */       bean.init();
/*  67: 58 */       this.dao.save(bean);
/*  68: 59 */       user.setUserForum(bean);
/*  69:    */     }
/*  70: 61 */     return bean;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public UserForum shieldUserForum(Integer userId, Date shieldTime)
/*  74:    */   {
/*  75: 65 */     UserForum bean = findById(userId);
/*  76: 66 */     bean.setStatus(Integer.valueOf(-2));
/*  77: 67 */     bean.setStatusTime(shieldTime);
/*  78: 68 */     return bean;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public UserForum update(UserForum bean)
/*  82:    */   {
/*  83: 72 */     Updater<UserForum> updater = new Updater(bean);
/*  84: 73 */     bean = this.dao.updateByUpdater(updater);
/*  85: 74 */     return bean;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public UserForum deleteById(Integer id)
/*  89:    */   {
/*  90: 78 */     UserForum bean = this.dao.deleteById(id);
/*  91: 79 */     return bean;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public UserForum[] deleteByIds(Integer[] ids)
/*  95:    */   {
/*  96: 83 */     UserForum[] beans = new UserForum[ids.length];
/*  97: 84 */     int i = 0;
/*  98: 84 */     for (int len = ids.length; i < len; i++) {
/*  99: 85 */       beans[i] = deleteById(ids[i]);
/* 100:    */     }
/* 101: 87 */     return beans;
/* 102:    */   }
/* 103:    */   
/* 104:    */   @Autowired
/* 105:    */   public void setDao(UserForumDao dao)
/* 106:    */   {
/* 107: 95 */     this.dao = dao;
/* 108:    */   }
/* 109:    */   
/* 110:    */   @Autowired
/* 111:    */   public void setUserService(UserService userService)
/* 112:    */   {
/* 113:100 */     this.userService = userService;
/* 114:    */   }
/* 115:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.impl.UserForumServiceImpl
 * JD-Core Version:    0.7.0.1
 */