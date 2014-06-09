/*  1:   */ package com.portal.govcenter.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.govcenter.dao.MailboxTypeDao;
/*  6:   */ import com.portal.govcenter.entity.MailboxType;
/*  7:   */ import com.portal.govcenter.service.MailboxTypeService;
/*  8:   */ import com.portal.sysmgr.entity.Site;
/*  9:   */ import java.util.List;
/* 10:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 11:   */ import org.springframework.stereotype.Service;
/* 12:   */ import org.springframework.transaction.annotation.Transactional;
/* 13:   */ 
/* 14:   */ @Service
/* 15:   */ @Transactional
/* 16:   */ public class MailboxTypeServiceImpl
/* 17:   */   implements MailboxTypeService
/* 18:   */ {
/* 19:   */   private MailboxTypeDao dao;
/* 20:   */   
/* 21:   */   @Transactional(readOnly=true)
/* 22:   */   public Pagination getPage(int pageNo, int pageSize)
/* 23:   */   {
/* 24:21 */     Pagination page = this.dao.getPage(pageNo, pageSize);
/* 25:22 */     return page;
/* 26:   */   }
/* 27:   */   
/* 28:   */   @Transactional(readOnly=true)
/* 29:   */   public List<MailboxType> getList(Integer siteId)
/* 30:   */   {
/* 31:27 */     return this.dao.getList(siteId);
/* 32:   */   }
/* 33:   */   
/* 34:   */   @Transactional(readOnly=true)
/* 35:   */   public MailboxType findById(Integer id)
/* 36:   */   {
/* 37:32 */     MailboxType entity = this.dao.findById(id);
/* 38:33 */     return entity;
/* 39:   */   }
/* 40:   */   
/* 41:   */   public MailboxType save(MailboxType bean, Site site)
/* 42:   */   {
/* 43:37 */     bean.setSite(site);
/* 44:38 */     bean.init();
/* 45:39 */     this.dao.save(bean);
/* 46:40 */     return bean;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public MailboxType update(MailboxType bean)
/* 50:   */   {
/* 51:44 */     Updater<MailboxType> updater = new Updater(bean);
/* 52:45 */     bean = this.dao.updateByUpdater(updater);
/* 53:46 */     return bean;
/* 54:   */   }
/* 55:   */   
/* 56:   */   public MailboxType deleteById(Integer id)
/* 57:   */   {
/* 58:50 */     MailboxType bean = this.dao.deleteById(id);
/* 59:51 */     return bean;
/* 60:   */   }
/* 61:   */   
/* 62:   */   public MailboxType[] deleteByIds(Integer[] ids)
/* 63:   */   {
/* 64:55 */     MailboxType[] beans = new MailboxType[ids.length];
/* 65:56 */     int i = 0;
/* 66:56 */     for (int len = ids.length; i < len; i++) {
/* 67:57 */       beans[i] = deleteById(ids[i]);
/* 68:   */     }
/* 69:59 */     return beans;
/* 70:   */   }
/* 71:   */   
/* 72:   */   @Autowired
/* 73:   */   public void setDao(MailboxTypeDao dao)
/* 74:   */   {
/* 75:66 */     this.dao = dao;
/* 76:   */   }
/* 77:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.govcenter.service.impl.MailboxTypeServiceImpl
 * JD-Core Version:    0.7.0.1
 */