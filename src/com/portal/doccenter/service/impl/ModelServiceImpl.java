/*  1:   */ package com.portal.doccenter.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.portal.doccenter.dao.ModelDao;
/*  5:   */ import com.portal.doccenter.entity.Model;
/*  6:   */ import com.portal.doccenter.service.ModelService;
/*  7:   */ import java.util.ArrayList;
/*  8:   */ import java.util.List;
/*  9:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 10:   */ import org.springframework.stereotype.Service;
/* 11:   */ import org.springframework.transaction.annotation.Transactional;
/* 12:   */ 
/* 13:   */ @Service
/* 14:   */ @Transactional
/* 15:   */ public class ModelServiceImpl
/* 16:   */   implements ModelService
/* 17:   */ {
/* 18:   */   private ModelDao dao;
/* 19:   */   
/* 20:   */   @Transactional(readOnly=true)
/* 21:   */   public List<Model> getList(boolean containDisabled, String sortname, String sortorder)
/* 22:   */   {
/* 23:21 */     return this.dao.getList(containDisabled, sortname, sortorder);
/* 24:   */   }
/* 25:   */   
/* 26:   */   public Model getDefModel()
/* 27:   */   {
/* 28:25 */     return this.dao.getDefModel();
/* 29:   */   }
/* 30:   */   
/* 31:   */   @Transactional(readOnly=true)
/* 32:   */   public Model findById(Integer id)
/* 33:   */   {
/* 34:30 */     Model entity = this.dao.findById(id);
/* 35:31 */     return entity;
/* 36:   */   }
/* 37:   */   
/* 38:   */   public Model save(Model bean)
/* 39:   */   {
/* 40:35 */     bean.init();
/* 41:36 */     this.dao.save(bean);
/* 42:37 */     return bean;
/* 43:   */   }
/* 44:   */   
/* 45:   */   public Model update(Model bean)
/* 46:   */   {
/* 47:41 */     Updater<Model> updater = new Updater(bean);
/* 48:42 */     Model entity = this.dao.updateByUpdater(updater);
/* 49:43 */     return entity;
/* 50:   */   }
/* 51:   */   
/* 52:   */   public Model deleteById(Integer id)
/* 53:   */   {
/* 54:47 */     Model bean = this.dao.deleteById(id);
/* 55:48 */     return bean;
/* 56:   */   }
/* 57:   */   
/* 58:   */   public Model[] deleteByIds(Integer[] ids)
/* 59:   */   {
/* 60:52 */     Model[] beans = new Model[ids.length];
/* 61:53 */     int i = 0;
/* 62:53 */     for (int len = ids.length; i < len; i++) {
/* 63:54 */       beans[i] = deleteById(ids[i]);
/* 64:   */     }
/* 65:56 */     return beans;
/* 66:   */   }
/* 67:   */   
/* 68:   */   public List<Model> getModelList(List<Integer> modelIdList)
/* 69:   */   {
/* 70:60 */     List<Model> modelList = new ArrayList();
/* 71:61 */     if ((modelIdList != null) && (modelIdList.size() > 0)) {
/* 72:62 */       for (Integer modelId : modelIdList) {
/* 73:63 */         modelList.add(findById(modelId));
/* 74:   */       }
/* 75:   */     }
/* 76:66 */     return modelList;
/* 77:   */   }
/* 78:   */   
/* 79:   */   public Model[] updatePriority(Integer[] ids, Integer[] priority, Boolean[] disabled, Integer defId)
/* 80:   */   {
/* 81:71 */     int len = ids.length;
/* 82:72 */     Model[] beans = new Model[len];
/* 83:73 */     for (int i = 0; i < len; i++)
/* 84:   */     {
/* 85:74 */       beans[i] = findById(ids[i]);
/* 86:75 */       beans[i].setPriority(priority[i]);
/* 87:76 */       beans[i].setDisabled(disabled[i]);
/* 88:   */     }
/* 89:78 */     return beans;
/* 90:   */   }
/* 91:   */   
/* 92:   */   @Autowired
/* 93:   */   public void setDao(ModelDao dao)
/* 94:   */   {
/* 95:85 */     this.dao = dao;
/* 96:   */   }
/* 97:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.service.impl.ModelServiceImpl
 * JD-Core Version:    0.7.0.1
 */