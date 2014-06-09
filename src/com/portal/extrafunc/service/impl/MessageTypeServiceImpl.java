/*  1:   */ package com.portal.extrafunc.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.extrafunc.dao.MessageTypeDao;
/*  6:   */ import com.portal.extrafunc.entity.MessageType;
/*  7:   */ import com.portal.extrafunc.service.MessageTypeService;
/*  8:   */ import com.portal.sysmgr.entity.Site;
/*  9:   */ import java.util.List;
/* 10:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 11:   */ import org.springframework.stereotype.Service;
/* 12:   */ import org.springframework.transaction.annotation.Transactional;
/* 13:   */ 
/* 14:   */ @Service
/* 15:   */ @Transactional
/* 16:   */ public class MessageTypeServiceImpl
/* 17:   */   implements MessageTypeService
/* 18:   */ {
/* 19:   */   private MessageTypeDao dao;
/* 20:   */   
/* 21:   */   @Transactional(readOnly=true)
/* 22:   */   public Pagination getPage(int pageNo, int pageSize)
/* 23:   */   {
/* 24:21 */     Pagination page = this.dao.getPage(pageNo, pageSize);
/* 25:22 */     return page;
/* 26:   */   }
/* 27:   */   
/* 28:   */   @Transactional(readOnly=true)
/* 29:   */   public List<MessageType> getList(Integer siteId, String sortname, String sortorder)
/* 30:   */   {
/* 31:28 */     return this.dao.getList(siteId, sortname, sortorder);
/* 32:   */   }
/* 33:   */   
/* 34:   */   @Transactional(readOnly=true)
/* 35:   */   public MessageType getUniqueType(Integer siteId)
/* 36:   */   {
/* 37:33 */     return this.dao.getUniqueType(siteId);
/* 38:   */   }
/* 39:   */   
/* 40:   */   @Transactional(readOnly=true)
/* 41:   */   public MessageType findById(Integer id)
/* 42:   */   {
/* 43:38 */     MessageType entity = this.dao.findById(id);
/* 44:39 */     return entity;
/* 45:   */   }
/* 46:   */   
/* 47:   */   public MessageType save(MessageType bean, Site site)
/* 48:   */   {
/* 49:43 */     bean.setSite(site);
/* 50:44 */     bean.init();
/* 51:45 */     this.dao.save(bean);
/* 52:46 */     return bean;
/* 53:   */   }
/* 54:   */   
/* 55:   */   public MessageType update(MessageType bean)
/* 56:   */   {
/* 57:50 */     Updater<MessageType> updater = new Updater(bean);
/* 58:51 */     bean = this.dao.updateByUpdater(updater);
/* 59:52 */     return bean;
/* 60:   */   }
/* 61:   */   
/* 62:   */   public MessageType deleteById(Integer id)
/* 63:   */   {
/* 64:56 */     MessageType bean = this.dao.deleteById(id);
/* 65:57 */     return bean;
/* 66:   */   }
/* 67:   */   
/* 68:   */   public MessageType[] deleteByIds(Integer[] ids)
/* 69:   */   {
/* 70:61 */     MessageType[] beans = new MessageType[ids.length];
/* 71:62 */     int i = 0;
/* 72:62 */     for (int len = ids.length; i < len; i++) {
/* 73:63 */       beans[i] = deleteById(ids[i]);
/* 74:   */     }
/* 75:65 */     return beans;
/* 76:   */   }
/* 77:   */   
/* 78:   */   @Autowired
/* 79:   */   public void setDao(MessageTypeDao dao)
/* 80:   */   {
/* 81:72 */     this.dao = dao;
/* 82:   */   }
/* 83:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.impl.MessageTypeServiceImpl
 * JD-Core Version:    0.7.0.1
 */