/*   1:    */ package com.portal.usermgr.service.impl;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.hibernate3.Updater;
/*   4:    */ import com.javapms.basic.page.Pagination;
/*   5:    */ import com.portal.usermgr.dao.SiteMessageDao;
/*   6:    */ import com.portal.usermgr.entity.SiteMessage;
/*   7:    */ import com.portal.usermgr.entity.SiteMessageExt;
/*   8:    */ import com.portal.usermgr.service.SiteMessageExtService;
/*   9:    */ import com.portal.usermgr.service.SiteMessageService;
/*  10:    */ import com.portal.usermgr.service.UserService;
/*  11:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  12:    */ import org.springframework.stereotype.Service;
/*  13:    */ import org.springframework.transaction.annotation.Transactional;
/*  14:    */ 
/*  15:    */ @Service
/*  16:    */ @Transactional
/*  17:    */ public class SiteMessageServiceImpl
/*  18:    */   implements SiteMessageService
/*  19:    */ {
/*  20:    */   private SiteMessageDao dao;
/*  21:    */   private UserService userService;
/*  22:    */   private SiteMessageExtService messageExtService;
/*  23:    */   
/*  24:    */   @Transactional(readOnly=true)
/*  25:    */   public Pagination getPage(int pageNo, int pageSize)
/*  26:    */   {
/*  27: 21 */     Pagination page = this.dao.getPage(pageNo, pageSize);
/*  28: 22 */     return page;
/*  29:    */   }
/*  30:    */   
/*  31:    */   @Transactional(readOnly=true)
/*  32:    */   public Pagination getPageByTag(Integer fromId, Integer toId, Integer allId, Integer replyId, int pageNo, int pageSize)
/*  33:    */   {
/*  34: 28 */     return this.dao.getPageByTag(fromId, toId, allId, replyId, pageNo, pageSize);
/*  35:    */   }
/*  36:    */   
/*  37:    */   @Transactional(readOnly=true)
/*  38:    */   public int countByFromId(Integer userId)
/*  39:    */   {
/*  40: 33 */     return this.dao.countByFromId(userId);
/*  41:    */   }
/*  42:    */   
/*  43:    */   @Transactional(readOnly=true)
/*  44:    */   public int countByToId(Integer userId)
/*  45:    */   {
/*  46: 38 */     return this.dao.countByToId(userId);
/*  47:    */   }
/*  48:    */   
/*  49:    */   @Transactional(readOnly=true)
/*  50:    */   public SiteMessage findById(Integer id)
/*  51:    */   {
/*  52: 43 */     SiteMessage entity = this.dao.findById(id);
/*  53: 44 */     return entity;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public SiteMessage save(SiteMessage bean, SiteMessageExt ext, Integer fromId, Integer toId, Integer replyId)
/*  57:    */   {
/*  58: 49 */     if (fromId != null) {
/*  59: 50 */       bean.setFromUser(this.userService.findById(fromId));
/*  60:    */     }
/*  61: 52 */     if (toId != null) {
/*  62: 53 */       bean.setToUser(this.userService.findById(toId));
/*  63:    */     }
/*  64: 55 */     if (replyId != null) {
/*  65: 56 */       bean.setReply(findById(replyId));
/*  66:    */     }
/*  67: 58 */     bean.init();
/*  68: 59 */     this.dao.save(bean);
/*  69: 60 */     this.messageExtService.save(ext, bean);
/*  70: 61 */     return bean;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public SiteMessage update(SiteMessage bean)
/*  74:    */   {
/*  75: 65 */     Updater<SiteMessage> updater = new Updater(bean);
/*  76: 66 */     bean = this.dao.updateByUpdater(updater);
/*  77: 67 */     return bean;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public int deleteByUserId(Integer userId)
/*  81:    */   {
/*  82: 71 */     this.messageExtService.deleteByUserId(userId);
/*  83: 72 */     return this.dao.deleteByUserId(userId);
/*  84:    */   }
/*  85:    */   
/*  86:    */   public SiteMessage deleteById(Integer id)
/*  87:    */   {
/*  88: 76 */     SiteMessage bean = this.dao.deleteById(id);
/*  89: 77 */     return bean;
/*  90:    */   }
/*  91:    */   
/*  92:    */   public SiteMessage[] deleteByIds(Integer[] ids)
/*  93:    */   {
/*  94: 81 */     SiteMessage[] beans = new SiteMessage[ids.length];
/*  95: 82 */     int i = 0;
/*  96: 82 */     for (int len = ids.length; i < len; i++) {
/*  97: 83 */       beans[i] = deleteById(ids[i]);
/*  98:    */     }
/*  99: 85 */     return beans;
/* 100:    */   }
/* 101:    */   
/* 102:    */   @Autowired
/* 103:    */   public void setDao(SiteMessageDao dao)
/* 104:    */   {
/* 105: 94 */     this.dao = dao;
/* 106:    */   }
/* 107:    */   
/* 108:    */   @Autowired
/* 109:    */   public void setPmsUserService(UserService userService)
/* 110:    */   {
/* 111: 99 */     this.userService = userService;
/* 112:    */   }
/* 113:    */   
/* 114:    */   @Autowired
/* 115:    */   public void setMessageExtService(SiteMessageExtService messageExtService)
/* 116:    */   {
/* 117:104 */     this.messageExtService = messageExtService;
/* 118:    */   }
/* 119:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.service.impl.SiteMessageServiceImpl
 * JD-Core Version:    0.7.0.1
 */