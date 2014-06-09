/*  1:   */ package com.portal.recruitcenter.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.recruitcenter.dao.VipTypeDao;
/*  6:   */ import com.portal.recruitcenter.entity.VipType;
/*  7:   */ import com.portal.recruitcenter.service.VipTypeService;
/*  8:   */ import java.util.List;
/*  9:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 10:   */ import org.springframework.stereotype.Service;
/* 11:   */ import org.springframework.transaction.annotation.Transactional;
/* 12:   */ 
/* 13:   */ @Service
/* 14:   */ @Transactional
/* 15:   */ public class VipTypeServiceImpl
/* 16:   */   implements VipTypeService
/* 17:   */ {
/* 18:   */   private VipTypeDao dao;
/* 19:   */   
/* 20:   */   @Transactional(readOnly=true)
/* 21:   */   public Pagination getPage(int pageNo, int pageSize)
/* 22:   */   {
/* 23:20 */     Pagination page = this.dao.getPage(pageNo, pageSize);
/* 24:21 */     return page;
/* 25:   */   }
/* 26:   */   
/* 27:   */   @Transactional(readOnly=true)
/* 28:   */   public List<VipType> getAllVipType()
/* 29:   */   {
/* 30:26 */     return this.dao.getAllVipType();
/* 31:   */   }
/* 32:   */   
/* 33:   */   @Transactional(readOnly=true)
/* 34:   */   public VipType findById(Integer id)
/* 35:   */   {
/* 36:31 */     VipType entity = this.dao.findById(id);
/* 37:32 */     return entity;
/* 38:   */   }
/* 39:   */   
/* 40:   */   public VipType save(VipType bean)
/* 41:   */   {
/* 42:36 */     this.dao.save(bean);
/* 43:37 */     return bean;
/* 44:   */   }
/* 45:   */   
/* 46:   */   public VipType update(VipType bean)
/* 47:   */   {
/* 48:41 */     Updater<VipType> updater = new Updater(bean);
/* 49:42 */     bean = this.dao.updateByUpdater(updater);
/* 50:43 */     return bean;
/* 51:   */   }
/* 52:   */   
/* 53:   */   public VipType deleteById(Integer id)
/* 54:   */   {
/* 55:47 */     VipType bean = this.dao.deleteById(id);
/* 56:48 */     return bean;
/* 57:   */   }
/* 58:   */   
/* 59:   */   public VipType[] deleteByIds(Integer[] ids)
/* 60:   */   {
/* 61:52 */     VipType[] beans = new VipType[ids.length];
/* 62:53 */     int i = 0;
/* 63:53 */     for (int len = ids.length; i < len; i++) {
/* 64:54 */       beans[i] = deleteById(ids[i]);
/* 65:   */     }
/* 66:56 */     return beans;
/* 67:   */   }
/* 68:   */   
/* 69:   */   @Autowired
/* 70:   */   public void setDao(VipTypeDao dao)
/* 71:   */   {
/* 72:63 */     this.dao = dao;
/* 73:   */   }
/* 74:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.service.impl.VipTypeServiceImpl
 * JD-Core Version:    0.7.0.1
 */