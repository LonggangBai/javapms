/*  1:   */ package com.portal.extrafunc.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.extrafunc.dao.AdvertSlotDao;
/*  6:   */ import com.portal.extrafunc.entity.AdvertSlot;
/*  7:   */ import com.portal.extrafunc.service.AdvertSlotService;
/*  8:   */ import com.portal.sysmgr.entity.Site;
/*  9:   */ import java.util.List;
/* 10:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 11:   */ import org.springframework.stereotype.Service;
/* 12:   */ import org.springframework.transaction.annotation.Transactional;
/* 13:   */ 
/* 14:   */ @Service
/* 15:   */ @Transactional
/* 16:   */ public class AdvertSlotServiceImpl
/* 17:   */   implements AdvertSlotService
/* 18:   */ {
/* 19:   */   private AdvertSlotDao dao;
/* 20:   */   
/* 21:   */   @Transactional(readOnly=true)
/* 22:   */   public Pagination getPage(Integer siteId, String sortname, String sortorder, int pageNo, int pageSize)
/* 23:   */   {
/* 24:22 */     Pagination page = this.dao.getPage(siteId, sortname, sortorder, pageNo, 
/* 25:23 */       pageSize);
/* 26:24 */     return page;
/* 27:   */   }
/* 28:   */   
/* 29:   */   @Transactional(readOnly=true)
/* 30:   */   public List<AdvertSlot> getList(Integer siteId)
/* 31:   */   {
/* 32:29 */     return this.dao.getList(siteId);
/* 33:   */   }
/* 34:   */   
/* 35:   */   @Transactional(readOnly=true)
/* 36:   */   public AdvertSlot findById(Integer id)
/* 37:   */   {
/* 38:34 */     AdvertSlot entity = this.dao.findById(id);
/* 39:35 */     return entity;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public AdvertSlot save(AdvertSlot bean, Site site)
/* 43:   */   {
/* 44:39 */     bean.setSite(site);
/* 45:40 */     bean.init();
/* 46:41 */     this.dao.save(bean);
/* 47:42 */     return bean;
/* 48:   */   }
/* 49:   */   
/* 50:   */   public AdvertSlot update(AdvertSlot bean)
/* 51:   */   {
/* 52:46 */     bean.init();
/* 53:47 */     Updater<AdvertSlot> updater = new Updater(bean);
/* 54:48 */     bean = this.dao.updateByUpdater(updater);
/* 55:49 */     return bean;
/* 56:   */   }
/* 57:   */   
/* 58:   */   public AdvertSlot deleteById(Integer id)
/* 59:   */   {
/* 60:53 */     AdvertSlot bean = this.dao.deleteById(id);
/* 61:54 */     return bean;
/* 62:   */   }
/* 63:   */   
/* 64:   */   public AdvertSlot[] deleteByIds(Integer[] ids)
/* 65:   */   {
/* 66:58 */     AdvertSlot[] beans = new AdvertSlot[ids.length];
/* 67:59 */     int i = 0;
/* 68:59 */     for (int len = ids.length; i < len; i++) {
/* 69:60 */       beans[i] = deleteById(ids[i]);
/* 70:   */     }
/* 71:62 */     return beans;
/* 72:   */   }
/* 73:   */   
/* 74:   */   @Autowired
/* 75:   */   public void setDao(AdvertSlotDao dao)
/* 76:   */   {
/* 77:69 */     this.dao = dao;
/* 78:   */   }
/* 79:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.impl.AdvertSlotServiceImpl
 * JD-Core Version:    0.7.0.1
 */