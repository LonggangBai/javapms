/*  1:   */ package com.portal.doccenter.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.portal.doccenter.dao.ChannelTxtDao;
/*  5:   */ import com.portal.doccenter.entity.Channel;
/*  6:   */ import com.portal.doccenter.entity.ChannelTxt;
/*  7:   */ import com.portal.doccenter.service.ChannelTxtService;
/*  8:   */ import org.springframework.beans.factory.annotation.Autowired;
/*  9:   */ import org.springframework.stereotype.Service;
/* 10:   */ import org.springframework.transaction.annotation.Transactional;
/* 11:   */ 
/* 12:   */ @Service
/* 13:   */ @Transactional
/* 14:   */ public class ChannelTxtServiceImpl
/* 15:   */   implements ChannelTxtService
/* 16:   */ {
/* 17:   */   private ChannelTxtDao dao;
/* 18:   */   
/* 19:   */   public ChannelTxt save(ChannelTxt txt, Channel channel)
/* 20:   */   {
/* 21:26 */     if (txt.isAllBlank()) {
/* 22:27 */       return null;
/* 23:   */     }
/* 24:29 */     txt.setChannel(channel);
/* 25:30 */     txt.init();
/* 26:31 */     this.dao.save(txt);
/* 27:32 */     return txt;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public ChannelTxt update(ChannelTxt txt, Channel channel)
/* 31:   */   {
/* 32:40 */     ChannelTxt entity = this.dao.findById(channel.getId());
/* 33:41 */     if (entity == null)
/* 34:   */     {
/* 35:42 */       entity = save(txt, channel);
/* 36:43 */       return entity;
/* 37:   */     }
/* 38:45 */     if (txt.isAllBlank())
/* 39:   */     {
/* 40:46 */       channel.setTxt(null);
/* 41:47 */       return null;
/* 42:   */     }
/* 43:49 */     Updater<ChannelTxt> updater = new Updater(txt);
/* 44:50 */     entity = this.dao.updateByUpdater(updater);
/* 45:51 */     entity.blankToNull();
/* 46:52 */     return entity;
/* 47:   */   }
/* 48:   */   
/* 49:   */   @Autowired
/* 50:   */   public void setDao(ChannelTxtDao dao)
/* 51:   */   {
/* 52:61 */     this.dao = dao;
/* 53:   */   }
/* 54:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.service.impl.ChannelTxtServiceImpl
 * JD-Core Version:    0.7.0.1
 */