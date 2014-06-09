/*  1:   */ package com.portal.datacenter.commdata.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.datacenter.commdata.dao.MetierDao;
/*  6:   */ import com.portal.datacenter.commdata.entity.Metier;
/*  7:   */ import com.portal.datacenter.commdata.service.MetierService;
/*  8:   */ import java.util.List;
/*  9:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 10:   */ import org.springframework.stereotype.Service;
/* 11:   */ import org.springframework.transaction.annotation.Transactional;
/* 12:   */ 
/* 13:   */ @Service
/* 14:   */ @Transactional
/* 15:   */ public class MetierServiceImpl
/* 16:   */   implements MetierService
/* 17:   */ {
/* 18:   */   private MetierDao dao;
/* 19:   */   
/* 20:   */   @Transactional(readOnly=true)
/* 21:   */   public Pagination getPage(String key, int pageNo, int pageSize)
/* 22:   */   {
/* 23:20 */     Pagination page = this.dao.getPage(key, pageNo, pageSize);
/* 24:21 */     return page;
/* 25:   */   }
/* 26:   */   
/* 27:   */   @Transactional(readOnly=true)
/* 28:   */   public List<Metier> getMetierList(Integer id)
/* 29:   */   {
/* 30:26 */     return this.dao.getMetierList(id);
/* 31:   */   }
/* 32:   */   
/* 33:   */   @Transactional(readOnly=true)
/* 34:   */   public List<Metier> getMetierChild(Integer id)
/* 35:   */   {
/* 36:31 */     return this.dao.getMetierChild(id);
/* 37:   */   }
/* 38:   */   
/* 39:   */   public Metier findByCode(String code)
/* 40:   */   {
/* 41:35 */     return this.dao.findByCode(code);
/* 42:   */   }
/* 43:   */   
/* 44:   */   @Transactional(readOnly=true)
/* 45:   */   public Metier findById(Integer id)
/* 46:   */   {
/* 47:40 */     Metier entity = this.dao.findById(id);
/* 48:41 */     return entity;
/* 49:   */   }
/* 50:   */   
/* 51:   */   public Metier save(Metier bean, Integer parentId)
/* 52:   */   {
/* 53:45 */     if (parentId != null) {
/* 54:46 */       bean.setParent(findById(parentId));
/* 55:   */     }
/* 56:48 */     this.dao.save(bean);
/* 57:49 */     return bean;
/* 58:   */   }
/* 59:   */   
/* 60:   */   public Metier update(Metier bean, Integer parentId)
/* 61:   */   {
/* 62:53 */     Updater<Metier> updater = new Updater(bean);
/* 63:54 */     bean = this.dao.updateByUpdater(updater);
/* 64:55 */     if (parentId != null) {
/* 65:56 */       bean.setParent(findById(parentId));
/* 66:   */     } else {
/* 67:58 */       bean.setParent(null);
/* 68:   */     }
/* 69:60 */     return bean;
/* 70:   */   }
/* 71:   */   
/* 72:   */   public Metier deleteById(Integer id)
/* 73:   */   {
/* 74:64 */     Metier bean = this.dao.deleteById(id);
/* 75:65 */     return bean;
/* 76:   */   }
/* 77:   */   
/* 78:   */   public Metier[] deleteByIds(Integer[] ids)
/* 79:   */   {
/* 80:69 */     Metier[] beans = new Metier[ids.length];
/* 81:70 */     int i = 0;
/* 82:70 */     for (int len = ids.length; i < len; i++) {
/* 83:71 */       beans[i] = deleteById(ids[i]);
/* 84:   */     }
/* 85:73 */     return beans;
/* 86:   */   }
/* 87:   */   
/* 88:   */   @Autowired
/* 89:   */   public void setDao(MetierDao dao)
/* 90:   */   {
/* 91:80 */     this.dao = dao;
/* 92:   */   }
/* 93:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.commdata.service.impl.MetierServiceImpl
 * JD-Core Version:    0.7.0.1
 */