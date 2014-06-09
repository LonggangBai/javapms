/*  1:   */ package com.portal.datacenter.commdata.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.datacenter.commdata.dao.EconomyTypeDao;
/*  6:   */ import com.portal.datacenter.commdata.entity.EconomyType;
/*  7:   */ import com.portal.datacenter.commdata.service.EconomyTypeService;
/*  8:   */ import java.util.List;
/*  9:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 10:   */ import org.springframework.stereotype.Service;
/* 11:   */ import org.springframework.transaction.annotation.Transactional;
/* 12:   */ 
/* 13:   */ @Service
/* 14:   */ @Transactional
/* 15:   */ public class EconomyTypeServiceImpl
/* 16:   */   implements EconomyTypeService
/* 17:   */ {
/* 18:   */   private EconomyTypeDao dao;
/* 19:   */   
/* 20:   */   @Transactional(readOnly=true)
/* 21:   */   public Pagination getPage(int pageNo, int pageSize)
/* 22:   */   {
/* 23:20 */     Pagination page = this.dao.getPage(pageNo, pageSize);
/* 24:21 */     return page;
/* 25:   */   }
/* 26:   */   
/* 27:   */   @Transactional(readOnly=true)
/* 28:   */   public List<EconomyType> getEconomyTypeList()
/* 29:   */   {
/* 30:26 */     return this.dao.getEconomyTypeList();
/* 31:   */   }
/* 32:   */   
/* 33:   */   @Transactional(readOnly=true)
/* 34:   */   public EconomyType findByCode(String code)
/* 35:   */   {
/* 36:31 */     return this.dao.findByCode(code);
/* 37:   */   }
/* 38:   */   
/* 39:   */   @Transactional(readOnly=true)
/* 40:   */   public EconomyType findById(Integer id)
/* 41:   */   {
/* 42:36 */     EconomyType entity = this.dao.findById(id);
/* 43:37 */     return entity;
/* 44:   */   }
/* 45:   */   
/* 46:   */   public EconomyType save(EconomyType bean)
/* 47:   */   {
/* 48:41 */     this.dao.save(bean);
/* 49:42 */     return bean;
/* 50:   */   }
/* 51:   */   
/* 52:   */   public EconomyType update(EconomyType bean)
/* 53:   */   {
/* 54:46 */     Updater<EconomyType> updater = new Updater(bean);
/* 55:47 */     bean = this.dao.updateByUpdater(updater);
/* 56:48 */     return bean;
/* 57:   */   }
/* 58:   */   
/* 59:   */   public EconomyType deleteById(Integer id)
/* 60:   */   {
/* 61:52 */     EconomyType bean = this.dao.deleteById(id);
/* 62:53 */     return bean;
/* 63:   */   }
/* 64:   */   
/* 65:   */   public EconomyType[] deleteByIds(Integer[] ids)
/* 66:   */   {
/* 67:57 */     EconomyType[] beans = new EconomyType[ids.length];
/* 68:58 */     int i = 0;
/* 69:58 */     for (int len = ids.length; i < len; i++) {
/* 70:59 */       beans[i] = deleteById(ids[i]);
/* 71:   */     }
/* 72:61 */     return beans;
/* 73:   */   }
/* 74:   */   
/* 75:   */   @Autowired
/* 76:   */   public void setDao(EconomyTypeDao dao)
/* 77:   */   {
/* 78:68 */     this.dao = dao;
/* 79:   */   }
/* 80:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.commdata.service.impl.EconomyTypeServiceImpl
 * JD-Core Version:    0.7.0.1
 */