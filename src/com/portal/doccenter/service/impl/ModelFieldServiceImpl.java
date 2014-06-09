/*  1:   */ package com.portal.doccenter.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.portal.doccenter.dao.ModelFieldDao;
/*  5:   */ import com.portal.doccenter.entity.Model;
/*  6:   */ import com.portal.doccenter.entity.ModelField;
/*  7:   */ import com.portal.doccenter.service.ModelFieldService;
/*  8:   */ import com.portal.doccenter.service.ModelService;
/*  9:   */ import java.util.List;
/* 10:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 11:   */ import org.springframework.stereotype.Service;
/* 12:   */ import org.springframework.transaction.annotation.Transactional;
/* 13:   */ 
/* 14:   */ @Service
/* 15:   */ @Transactional
/* 16:   */ public class ModelFieldServiceImpl
/* 17:   */   implements ModelFieldService
/* 18:   */ {
/* 19:   */   private ModelService modelService;
/* 20:   */   private ModelFieldDao dao;
/* 21:   */   
/* 22:   */   @Transactional(readOnly=true)
/* 23:   */   public List<ModelField> getList(Integer modelId, boolean hasDisabled, String sortname, String sortorder)
/* 24:   */   {
/* 25:21 */     return this.dao.getList(modelId, hasDisabled, sortname, sortorder);
/* 26:   */   }
/* 27:   */   
/* 28:   */   @Transactional(readOnly=true)
/* 29:   */   public ModelField findById(Integer id)
/* 30:   */   {
/* 31:26 */     ModelField entity = this.dao.findById(id);
/* 32:27 */     return entity;
/* 33:   */   }
/* 34:   */   
/* 35:   */   public ModelField save(ModelField bean, Integer modelId)
/* 36:   */   {
/* 37:31 */     bean.setModel(this.modelService.findById(modelId));
/* 38:32 */     int maxpri = this.dao.getMaxPriority(modelId);
/* 39:33 */     bean.setPriority(Integer.valueOf(maxpri + 1));
/* 40:34 */     return save(bean);
/* 41:   */   }
/* 42:   */   
/* 43:   */   public ModelField save(ModelField bean)
/* 44:   */   {
/* 45:38 */     bean.init();
/* 46:39 */     this.dao.save(bean);
/* 47:40 */     return bean;
/* 48:   */   }
/* 49:   */   
/* 50:   */   public void saveList(List<ModelField> list)
/* 51:   */   {
/* 52:44 */     for (ModelField item : list) {
/* 53:45 */       save(item);
/* 54:   */     }
/* 55:   */   }
/* 56:   */   
/* 57:   */   public void updatePriority(Integer id, Integer priority)
/* 58:   */   {
/* 59:50 */     ModelField item = findById(id);
/* 60:51 */     if (priority.intValue() > item.getPriority().intValue())
/* 61:   */     {
/* 62:52 */       List<ModelField> list = this.dao.getListByPriority(item.getModel()
/* 63:53 */         .getId(), Integer.valueOf(item.getPriority().intValue() + 1), Integer.valueOf(priority.intValue() + 1), true);
/* 64:54 */       for (ModelField itemi : list) {
/* 65:55 */         itemi.setPriority(Integer.valueOf(itemi.getPriority().intValue() - 1));
/* 66:   */       }
/* 67:   */     }
/* 68:   */     else
/* 69:   */     {
/* 70:58 */       List<ModelField> list = this.dao.getListByPriority(item.getModel()
/* 71:59 */         .getId(), priority, item.getPriority(), true);
/* 72:60 */       for (ModelField itemi : list) {
/* 73:61 */         itemi.setPriority(Integer.valueOf(itemi.getPriority().intValue() + 1));
/* 74:   */       }
/* 75:   */     }
/* 76:64 */     item.setPriority(priority);
/* 77:   */   }
/* 78:   */   
/* 79:   */   public ModelField update(ModelField bean)
/* 80:   */   {
/* 81:68 */     Updater<ModelField> updater = new Updater(bean);
/* 82:69 */     ModelField entity = this.dao.updateByUpdater(updater);
/* 83:70 */     entity.emptyToNull();
/* 84:71 */     return entity;
/* 85:   */   }
/* 86:   */   
/* 87:   */   public ModelField deleteById(Integer id)
/* 88:   */   {
/* 89:75 */     ModelField bean = this.dao.deleteById(id);
/* 90:76 */     return bean;
/* 91:   */   }
/* 92:   */   
/* 93:   */   public ModelField[] deleteByIds(Integer[] ids)
/* 94:   */   {
/* 95:80 */     ModelField[] beans = new ModelField[ids.length];
/* 96:81 */     int i = 0;
/* 97:81 */     for (int len = ids.length; i < len; i++) {
/* 98:82 */       beans[i] = deleteById(ids[i]);
/* 99:   */     }
/* :0:84 */     return beans;
/* :1:   */   }
/* :2:   */   
/* :3:   */   @Autowired
/* :4:   */   public void setModelService(ModelService modelService)
/* :5:   */   {
/* :6:92 */     this.modelService = modelService;
/* :7:   */   }
/* :8:   */   
/* :9:   */   @Autowired
/* ;0:   */   public void setDao(ModelFieldDao dao)
/* ;1:   */   {
/* ;2:97 */     this.dao = dao;
/* ;3:   */   }
/* ;4:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.service.impl.ModelFieldServiceImpl
 * JD-Core Version:    0.7.0.1
 */