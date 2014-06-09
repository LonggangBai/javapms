/*  1:   */ package com.portal.datacenter.docdata.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.portal.datacenter.docdata.dao.SensitivityDao;
/*  5:   */ import com.portal.datacenter.docdata.entity.Sensitivity;
/*  6:   */ import com.portal.datacenter.docdata.service.SensitivityService;
/*  7:   */ import java.util.List;
/*  8:   */ import org.apache.commons.lang.StringUtils;
/*  9:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 10:   */ import org.springframework.stereotype.Service;
/* 11:   */ import org.springframework.transaction.annotation.Transactional;
/* 12:   */ 
/* 13:   */ @Service
/* 14:   */ @Transactional
/* 15:   */ public class SensitivityServiceImpl
/* 16:   */   implements SensitivityService
/* 17:   */ {
/* 18:   */   private SensitivityDao dao;
/* 19:   */   
/* 20:   */   @Transactional(readOnly=true)
/* 21:   */   public String replaceSensitivity(String s)
/* 22:   */   {
/* 23:20 */     if (StringUtils.isBlank(s)) {
/* 24:21 */       return s;
/* 25:   */     }
/* 26:23 */     List<Sensitivity> list = getList(true, null, null);
/* 27:24 */     for (Sensitivity sen : list) {
/* 28:25 */       s = StringUtils.replace(s, sen.getSearch(), sen.getReplacement());
/* 29:   */     }
/* 30:27 */     return s;
/* 31:   */   }
/* 32:   */   
/* 33:   */   @Transactional(readOnly=true)
/* 34:   */   public List<Sensitivity> getList(boolean cacheable, String sortname, String sortorder)
/* 35:   */   {
/* 36:33 */     return this.dao.getList(cacheable, sortname, sortorder);
/* 37:   */   }
/* 38:   */   
/* 39:   */   @Transactional(readOnly=true)
/* 40:   */   public Sensitivity findById(Integer id)
/* 41:   */   {
/* 42:38 */     Sensitivity entity = this.dao.findById(id);
/* 43:39 */     return entity;
/* 44:   */   }
/* 45:   */   
/* 46:   */   public Sensitivity save(Sensitivity bean)
/* 47:   */   {
/* 48:43 */     this.dao.save(bean);
/* 49:44 */     return bean;
/* 50:   */   }
/* 51:   */   
/* 52:   */   public Sensitivity update(Sensitivity bean)
/* 53:   */   {
/* 54:48 */     Updater<Sensitivity> updater = new Updater(bean);
/* 55:49 */     bean = this.dao.updateByUpdater(updater);
/* 56:50 */     return bean;
/* 57:   */   }
/* 58:   */   
/* 59:   */   public Sensitivity deleteById(Integer id)
/* 60:   */   {
/* 61:54 */     Sensitivity bean = this.dao.deleteById(id);
/* 62:55 */     return bean;
/* 63:   */   }
/* 64:   */   
/* 65:   */   public Sensitivity[] deleteByIds(Integer[] ids)
/* 66:   */   {
/* 67:59 */     Sensitivity[] beans = new Sensitivity[ids.length];
/* 68:60 */     int i = 0;
/* 69:60 */     for (int len = ids.length; i < len; i++) {
/* 70:61 */       beans[i] = deleteById(ids[i]);
/* 71:   */     }
/* 72:63 */     return beans;
/* 73:   */   }
/* 74:   */   
/* 75:   */   @Autowired
/* 76:   */   public void setDao(SensitivityDao dao)
/* 77:   */   {
/* 78:70 */     this.dao = dao;
/* 79:   */   }
/* 80:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.docdata.service.impl.SensitivityServiceImpl
 * JD-Core Version:    0.7.0.1
 */