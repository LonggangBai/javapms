/*  1:   */ package com.portal.datacenter.commdata.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.datacenter.commdata.dao.SpecialtyDao;
/*  6:   */ import com.portal.datacenter.commdata.entity.Specialty;
/*  7:   */ import com.portal.datacenter.commdata.service.SpecialtyService;
/*  8:   */ import java.util.List;
/*  9:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 10:   */ import org.springframework.stereotype.Service;
/* 11:   */ import org.springframework.transaction.annotation.Transactional;
/* 12:   */ 
/* 13:   */ @Service
/* 14:   */ @Transactional
/* 15:   */ public class SpecialtyServiceImpl
/* 16:   */   implements SpecialtyService
/* 17:   */ {
/* 18:   */   private SpecialtyDao dao;
/* 19:   */   
/* 20:   */   @Transactional(readOnly=true)
/* 21:   */   public Pagination getPage(String key, int pageNo, int pageSize)
/* 22:   */   {
/* 23:20 */     Pagination page = this.dao.getPage(key, pageNo, pageSize);
/* 24:21 */     return page;
/* 25:   */   }
/* 26:   */   
/* 27:   */   @Transactional(readOnly=true)
/* 28:   */   public List<Specialty> getSpecialtyList(Integer id)
/* 29:   */   {
/* 30:26 */     return this.dao.getSpecialtyList(id);
/* 31:   */   }
/* 32:   */   
/* 33:   */   @Transactional(readOnly=true)
/* 34:   */   public List<Specialty> getSpecialtyChild(Integer id)
/* 35:   */   {
/* 36:31 */     return this.dao.getSpecialtyChild(id);
/* 37:   */   }
/* 38:   */   
/* 39:   */   @Transactional(readOnly=true)
/* 40:   */   public Specialty findByCode(String code)
/* 41:   */   {
/* 42:36 */     return this.dao.findByCode(code);
/* 43:   */   }
/* 44:   */   
/* 45:   */   @Transactional(readOnly=true)
/* 46:   */   public Specialty findById(Integer id)
/* 47:   */   {
/* 48:41 */     Specialty entity = this.dao.findById(id);
/* 49:42 */     return entity;
/* 50:   */   }
/* 51:   */   
/* 52:   */   public Specialty save(Specialty bean, Integer parentId)
/* 53:   */   {
/* 54:46 */     if (parentId != null) {
/* 55:47 */       bean.setParent(findById(parentId));
/* 56:   */     }
/* 57:49 */     this.dao.save(bean);
/* 58:50 */     return bean;
/* 59:   */   }
/* 60:   */   
/* 61:   */   public Specialty update(Specialty bean, Integer parentId)
/* 62:   */   {
/* 63:54 */     Updater<Specialty> updater = new Updater(bean);
/* 64:55 */     bean = this.dao.updateByUpdater(updater);
/* 65:56 */     if (parentId != null) {
/* 66:57 */       bean.setParent(findById(parentId));
/* 67:   */     } else {
/* 68:59 */       bean.setParent(null);
/* 69:   */     }
/* 70:61 */     return bean;
/* 71:   */   }
/* 72:   */   
/* 73:   */   public Specialty deleteById(Integer id)
/* 74:   */   {
/* 75:65 */     Specialty bean = this.dao.deleteById(id);
/* 76:66 */     return bean;
/* 77:   */   }
/* 78:   */   
/* 79:   */   public Specialty[] deleteByIds(Integer[] ids)
/* 80:   */   {
/* 81:70 */     Specialty[] beans = new Specialty[ids.length];
/* 82:71 */     int i = 0;
/* 83:71 */     for (int len = ids.length; i < len; i++) {
/* 84:72 */       beans[i] = deleteById(ids[i]);
/* 85:   */     }
/* 86:74 */     return beans;
/* 87:   */   }
/* 88:   */   
/* 89:   */   @Autowired
/* 90:   */   public void setDao(SpecialtyDao dao)
/* 91:   */   {
/* 92:81 */     this.dao = dao;
/* 93:   */   }
/* 94:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.commdata.service.impl.SpecialtyServiceImpl
 * JD-Core Version:    0.7.0.1
 */