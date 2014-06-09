/*  1:   */ package com.portal.doccenter.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.portal.doccenter.dao.ChannelExtDao;
/*  5:   */ import com.portal.doccenter.entity.Channel;
/*  6:   */ import com.portal.doccenter.entity.ChannelExt;
/*  7:   */ import com.portal.doccenter.service.ChannelExtService;
/*  8:   */ import org.springframework.beans.factory.annotation.Autowired;
/*  9:   */ import org.springframework.stereotype.Service;
/* 10:   */ import org.springframework.transaction.annotation.Transactional;
/* 11:   */ 
/* 12:   */ @Service
/* 13:   */ @Transactional
/* 14:   */ public class ChannelExtServiceImpl
/* 15:   */   implements ChannelExtService
/* 16:   */ {
/* 17:   */   private ChannelExtDao dao;
/* 18:   */   
/* 19:   */   public ChannelExt save(ChannelExt ext, Channel channel)
/* 20:   */   {
/* 21:17 */     channel.setExt(ext);
/* 22:18 */     ext.setChannel(channel);
/* 23:19 */     ext.init();
/* 24:20 */     this.dao.save(ext);
/* 25:21 */     return ext;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public ChannelExt update(ChannelExt ext)
/* 29:   */   {
/* 30:25 */     Updater<ChannelExt> updater = new Updater(ext);
/* 31:26 */     ChannelExt entity = this.dao.updateByUpdater(updater);
/* 32:27 */     entity.blankToNull();
/* 33:28 */     return entity;
/* 34:   */   }
/* 35:   */   
/* 36:   */   @Autowired
/* 37:   */   public void setDao(ChannelExtDao dao)
/* 38:   */   {
/* 39:35 */     this.dao = dao;
/* 40:   */   }
/* 41:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.service.impl.ChannelExtServiceImpl
 * JD-Core Version:    0.7.0.1
 */