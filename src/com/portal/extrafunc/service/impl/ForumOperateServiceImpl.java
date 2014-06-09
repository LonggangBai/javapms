/*  1:   */ package com.portal.extrafunc.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.extrafunc.dao.ForumOperateDao;
/*  6:   */ import com.portal.extrafunc.entity.ForumOperate;
/*  7:   */ import com.portal.extrafunc.service.ForumOperateService;
/*  8:   */ import com.portal.sysmgr.entity.Site;
/*  9:   */ import com.portal.usermgr.entity.User;
/* 10:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 11:   */ import org.springframework.stereotype.Service;
/* 12:   */ import org.springframework.transaction.annotation.Transactional;
/* 13:   */ 
/* 14:   */ @Service
/* 15:   */ @Transactional
/* 16:   */ public class ForumOperateServiceImpl
/* 17:   */   implements ForumOperateService
/* 18:   */ {
/* 19:   */   private ForumOperateDao dao;
/* 20:   */   
/* 21:   */   @Transactional(readOnly=true)
/* 22:   */   public Pagination getPage(int pageNo, int pageSize)
/* 23:   */   {
/* 24:20 */     Pagination page = this.dao.getPage(pageNo, pageSize);
/* 25:21 */     return page;
/* 26:   */   }
/* 27:   */   
/* 28:   */   @Transactional(readOnly=true)
/* 29:   */   public ForumOperate findById(Integer id)
/* 30:   */   {
/* 31:26 */     ForumOperate entity = this.dao.findById(id);
/* 32:27 */     return entity;
/* 33:   */   }
/* 34:   */   
/* 35:   */   public ForumOperate save(Integer targetId, String targetType, String name, String reason, Site site, User user)
/* 36:   */   {
/* 37:32 */     ForumOperate bean = new ForumOperate();
/* 38:33 */     bean.setAdmin(user);
/* 39:34 */     bean.setSite(site);
/* 40:35 */     bean.setName(name);
/* 41:36 */     bean.setTarget(targetId);
/* 42:37 */     bean.setTargetType(targetType);
/* 43:38 */     bean.setReason(reason);
/* 44:39 */     bean.init();
/* 45:40 */     this.dao.save(bean);
/* 46:41 */     return bean;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public ForumOperate update(ForumOperate bean)
/* 50:   */   {
/* 51:45 */     Updater<ForumOperate> updater = new Updater(bean);
/* 52:46 */     bean = this.dao.updateByUpdater(updater);
/* 53:47 */     return bean;
/* 54:   */   }
/* 55:   */   
/* 56:   */   public ForumOperate deleteById(Integer id)
/* 57:   */   {
/* 58:51 */     ForumOperate bean = this.dao.deleteById(id);
/* 59:52 */     return bean;
/* 60:   */   }
/* 61:   */   
/* 62:   */   public ForumOperate[] deleteByIds(Integer[] ids)
/* 63:   */   {
/* 64:56 */     ForumOperate[] beans = new ForumOperate[ids.length];
/* 65:57 */     int i = 0;
/* 66:57 */     for (int len = ids.length; i < len; i++) {
/* 67:58 */       beans[i] = deleteById(ids[i]);
/* 68:   */     }
/* 69:60 */     return beans;
/* 70:   */   }
/* 71:   */   
/* 72:   */   @Autowired
/* 73:   */   public void setDao(ForumOperateDao dao)
/* 74:   */   {
/* 75:67 */     this.dao = dao;
/* 76:   */   }
/* 77:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.impl.ForumOperateServiceImpl
 * JD-Core Version:    0.7.0.1
 */