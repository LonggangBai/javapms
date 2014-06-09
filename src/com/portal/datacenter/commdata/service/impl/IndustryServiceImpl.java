/*  1:   */ package com.portal.datacenter.commdata.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.datacenter.commdata.dao.IndustryDao;
/*  6:   */ import com.portal.datacenter.commdata.entity.Industry;
/*  7:   */ import com.portal.datacenter.commdata.service.IndustryService;
/*  8:   */ import java.util.List;
/*  9:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 10:   */ import org.springframework.stereotype.Service;
/* 11:   */ import org.springframework.transaction.annotation.Transactional;
/* 12:   */ 
/* 13:   */ @Service
/* 14:   */ @Transactional
/* 15:   */ public class IndustryServiceImpl
/* 16:   */   implements IndustryService
/* 17:   */ {
/* 18:   */   private IndustryDao dao;
/* 19:   */   
/* 20:   */   @Transactional(readOnly=true)
/* 21:   */   public Pagination getPage(String key, int pageNo, int pageSize)
/* 22:   */   {
/* 23:20 */     Pagination page = this.dao.getPage(key, pageNo, pageSize);
/* 24:21 */     return page;
/* 25:   */   }
/* 26:   */   
/* 27:   */   @Transactional(readOnly=true)
/* 28:   */   public List<Industry> getIndustryList(Integer id)
/* 29:   */   {
/* 30:26 */     return this.dao.getIndustryList(id);
/* 31:   */   }
/* 32:   */   
/* 33:   */   @Transactional(readOnly=true)
/* 34:   */   public List<Industry> getIndustryChild(Integer id)
/* 35:   */   {
/* 36:31 */     return this.dao.getIndustryChild(id);
/* 37:   */   }
/* 38:   */   
/* 39:   */   @Transactional(readOnly=true)
/* 40:   */   public Industry findByCode(String code)
/* 41:   */   {
/* 42:36 */     return this.dao.findByCode(code);
/* 43:   */   }
/* 44:   */   
/* 45:   */   @Transactional(readOnly=true)
/* 46:   */   public Industry findById(Integer id)
/* 47:   */   {
/* 48:41 */     Industry entity = this.dao.findById(id);
/* 49:42 */     return entity;
/* 50:   */   }
/* 51:   */   
/* 52:   */   public Industry save(Industry bean, Integer parentId)
/* 53:   */   {
/* 54:46 */     if (parentId != null) {
/* 55:47 */       bean.setParent(findById(parentId));
/* 56:   */     }
/* 57:49 */     this.dao.save(bean);
/* 58:50 */     return bean;
/* 59:   */   }
/* 60:   */   
/* 61:   */   public Industry update(Industry bean, Integer parentId)
/* 62:   */   {
/* 63:54 */     Updater<Industry> updater = new Updater(bean);
/* 64:55 */     bean = this.dao.updateByUpdater(updater);
/* 65:56 */     if (parentId != null) {
/* 66:57 */       bean.setParent(findById(parentId));
/* 67:   */     } else {
/* 68:59 */       bean.setParent(null);
/* 69:   */     }
/* 70:61 */     return bean;
/* 71:   */   }
/* 72:   */   
/* 73:   */   public Industry deleteById(Integer id)
/* 74:   */   {
/* 75:65 */     Industry bean = this.dao.deleteById(id);
/* 76:66 */     return bean;
/* 77:   */   }
/* 78:   */   
/* 79:   */   public Industry[] deleteByIds(Integer[] ids)
/* 80:   */   {
/* 81:70 */     Industry[] beans = new Industry[ids.length];
/* 82:71 */     int i = 0;
/* 83:71 */     for (int len = ids.length; i < len; i++) {
/* 84:72 */       beans[i] = deleteById(ids[i]);
/* 85:   */     }
/* 86:74 */     return beans;
/* 87:   */   }
/* 88:   */   
/* 89:   */   @Autowired
/* 90:   */   public void setDao(IndustryDao dao)
/* 91:   */   {
/* 92:81 */     this.dao = dao;
/* 93:   */   }
/* 94:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.commdata.service.impl.IndustryServiceImpl
 * JD-Core Version:    0.7.0.1
 */