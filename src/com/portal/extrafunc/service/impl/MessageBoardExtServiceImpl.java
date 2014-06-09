/*  1:   */ package com.portal.extrafunc.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.extrafunc.dao.MessageBoardExtDao;
/*  6:   */ import com.portal.extrafunc.entity.MessageBoard;
/*  7:   */ import com.portal.extrafunc.entity.MessageBoardExt;
/*  8:   */ import com.portal.extrafunc.service.MessageBoardExtService;
/*  9:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 10:   */ import org.springframework.stereotype.Service;
/* 11:   */ import org.springframework.transaction.annotation.Transactional;
/* 12:   */ 
/* 13:   */ @Service
/* 14:   */ @Transactional
/* 15:   */ public class MessageBoardExtServiceImpl
/* 16:   */   implements MessageBoardExtService
/* 17:   */ {
/* 18:   */   private MessageBoardExtDao dao;
/* 19:   */   
/* 20:   */   @Transactional(readOnly=true)
/* 21:   */   public Pagination getPage(int pageNo, int pageSize)
/* 22:   */   {
/* 23:19 */     Pagination page = this.dao.getPage(pageNo, pageSize);
/* 24:20 */     return page;
/* 25:   */   }
/* 26:   */   
/* 27:   */   @Transactional(readOnly=true)
/* 28:   */   public MessageBoardExt findById(Integer id)
/* 29:   */   {
/* 30:25 */     MessageBoardExt entity = this.dao.findById(id);
/* 31:26 */     return entity;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public MessageBoardExt save(MessageBoard MessageBoard, MessageBoardExt bean)
/* 35:   */   {
/* 36:30 */     bean.setBoard(MessageBoard);
/* 37:31 */     this.dao.save(bean);
/* 38:32 */     MessageBoard.setExt(bean);
/* 39:33 */     return bean;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public MessageBoardExt update(MessageBoardExt bean)
/* 43:   */   {
/* 44:37 */     Updater<MessageBoardExt> updater = new Updater(bean);
/* 45:38 */     bean = this.dao.updateByUpdater(updater);
/* 46:39 */     return bean;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public MessageBoardExt deleteById(Integer id)
/* 50:   */   {
/* 51:43 */     MessageBoardExt bean = this.dao.deleteById(id);
/* 52:44 */     return bean;
/* 53:   */   }
/* 54:   */   
/* 55:   */   public MessageBoardExt[] deleteByIds(Integer[] ids)
/* 56:   */   {
/* 57:48 */     MessageBoardExt[] beans = new MessageBoardExt[ids.length];
/* 58:49 */     int i = 0;
/* 59:49 */     for (int len = ids.length; i < len; i++) {
/* 60:50 */       beans[i] = deleteById(ids[i]);
/* 61:   */     }
/* 62:52 */     return beans;
/* 63:   */   }
/* 64:   */   
/* 65:   */   @Autowired
/* 66:   */   public void setDao(MessageBoardExtDao dao)
/* 67:   */   {
/* 68:59 */     this.dao = dao;
/* 69:   */   }
/* 70:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.impl.MessageBoardExtServiceImpl
 * JD-Core Version:    0.7.0.1
 */