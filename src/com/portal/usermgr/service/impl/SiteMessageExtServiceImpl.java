/*  1:   */ package com.portal.usermgr.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.usermgr.dao.SiteMessageExtDao;
/*  6:   */ import com.portal.usermgr.entity.SiteMessage;
/*  7:   */ import com.portal.usermgr.entity.SiteMessageExt;
/*  8:   */ import com.portal.usermgr.service.SiteMessageExtService;
/*  9:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 10:   */ import org.springframework.stereotype.Service;
/* 11:   */ import org.springframework.transaction.annotation.Transactional;
/* 12:   */ 
/* 13:   */ @Service
/* 14:   */ @Transactional
/* 15:   */ public class SiteMessageExtServiceImpl
/* 16:   */   implements SiteMessageExtService
/* 17:   */ {
/* 18:   */   private SiteMessageExtDao dao;
/* 19:   */   
/* 20:   */   @Transactional(readOnly=true)
/* 21:   */   public Pagination getPage(int pageNo, int pageSize)
/* 22:   */   {
/* 23:19 */     Pagination page = this.dao.getPage(pageNo, pageSize);
/* 24:20 */     return page;
/* 25:   */   }
/* 26:   */   
/* 27:   */   @Transactional(readOnly=true)
/* 28:   */   public SiteMessageExt findById(Integer id)
/* 29:   */   {
/* 30:25 */     SiteMessageExt entity = this.dao.findById(id);
/* 31:26 */     return entity;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public SiteMessageExt save(SiteMessageExt bean, SiteMessage message)
/* 35:   */   {
/* 36:30 */     bean.setMessage(message);
/* 37:31 */     this.dao.save(bean);
/* 38:32 */     message.setExt(bean);
/* 39:33 */     return bean;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public SiteMessageExt update(SiteMessageExt bean)
/* 43:   */   {
/* 44:37 */     Updater<SiteMessageExt> updater = new Updater(bean);
/* 45:38 */     bean = this.dao.updateByUpdater(updater);
/* 46:39 */     return bean;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public int deleteByUserId(Integer userId)
/* 50:   */   {
/* 51:43 */     return this.dao.deleteByUserId(userId);
/* 52:   */   }
/* 53:   */   
/* 54:   */   public SiteMessageExt deleteById(Integer id)
/* 55:   */   {
/* 56:47 */     SiteMessageExt bean = this.dao.deleteById(id);
/* 57:48 */     return bean;
/* 58:   */   }
/* 59:   */   
/* 60:   */   public SiteMessageExt[] deleteByIds(Integer[] ids)
/* 61:   */   {
/* 62:52 */     SiteMessageExt[] beans = new SiteMessageExt[ids.length];
/* 63:53 */     int i = 0;
/* 64:53 */     for (int len = ids.length; i < len; i++) {
/* 65:54 */       beans[i] = deleteById(ids[i]);
/* 66:   */     }
/* 67:56 */     return beans;
/* 68:   */   }
/* 69:   */   
/* 70:   */   @Autowired
/* 71:   */   public void setDao(SiteMessageExtDao dao)
/* 72:   */   {
/* 73:63 */     this.dao = dao;
/* 74:   */   }
/* 75:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.service.impl.SiteMessageExtServiceImpl
 * JD-Core Version:    0.7.0.1
 */