/*  1:   */ package com.portal.datacenter.commdata.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.datacenter.commdata.dao.UnitTypeDao;
/*  6:   */ import com.portal.datacenter.commdata.entity.UnitType;
/*  7:   */ import com.portal.datacenter.commdata.service.UnitTypeService;
/*  8:   */ import org.springframework.beans.factory.annotation.Autowired;
/*  9:   */ import org.springframework.stereotype.Service;
/* 10:   */ import org.springframework.transaction.annotation.Transactional;
/* 11:   */ 
/* 12:   */ @Service
/* 13:   */ @Transactional
/* 14:   */ public class UnitTypeServiceImpl
/* 15:   */   implements UnitTypeService
/* 16:   */ {
/* 17:   */   private UnitTypeDao dao;
/* 18:   */   
/* 19:   */   @Transactional(readOnly=true)
/* 20:   */   public Pagination getPage(int pageNo, int pageSize)
/* 21:   */   {
/* 22:18 */     Pagination page = this.dao.getPage(pageNo, pageSize);
/* 23:19 */     return page;
/* 24:   */   }
/* 25:   */   
/* 26:   */   @Transactional(readOnly=true)
/* 27:   */   public UnitType findById(Integer id)
/* 28:   */   {
/* 29:24 */     UnitType entity = this.dao.findById(id);
/* 30:25 */     return entity;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public UnitType save(UnitType bean)
/* 34:   */   {
/* 35:29 */     this.dao.save(bean);
/* 36:30 */     return bean;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public UnitType update(UnitType bean)
/* 40:   */   {
/* 41:34 */     Updater<UnitType> updater = new Updater(bean);
/* 42:35 */     bean = this.dao.updateByUpdater(updater);
/* 43:36 */     return bean;
/* 44:   */   }
/* 45:   */   
/* 46:   */   public UnitType deleteById(Integer id)
/* 47:   */   {
/* 48:40 */     UnitType bean = this.dao.deleteById(id);
/* 49:41 */     return bean;
/* 50:   */   }
/* 51:   */   
/* 52:   */   public UnitType[] deleteByIds(Integer[] ids)
/* 53:   */   {
/* 54:45 */     UnitType[] beans = new UnitType[ids.length];
/* 55:46 */     int i = 0;
/* 56:46 */     for (int len = ids.length; i < len; i++) {
/* 57:47 */       beans[i] = deleteById(ids[i]);
/* 58:   */     }
/* 59:49 */     return beans;
/* 60:   */   }
/* 61:   */   
/* 62:   */   @Autowired
/* 63:   */   public void setDao(UnitTypeDao dao)
/* 64:   */   {
/* 65:56 */     this.dao = dao;
/* 66:   */   }
/* 67:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.commdata.service.impl.UnitTypeServiceImpl
 * JD-Core Version:    0.7.0.1
 */