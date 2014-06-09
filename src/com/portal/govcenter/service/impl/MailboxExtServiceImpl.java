/*  1:   */ package com.portal.govcenter.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.govcenter.dao.MailboxExtDao;
/*  6:   */ import com.portal.govcenter.entity.Mailbox;
/*  7:   */ import com.portal.govcenter.entity.MailboxExt;
/*  8:   */ import com.portal.govcenter.service.MailboxExtService;
/*  9:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 10:   */ import org.springframework.stereotype.Service;
/* 11:   */ import org.springframework.transaction.annotation.Transactional;
/* 12:   */ 
/* 13:   */ @Service
/* 14:   */ @Transactional
/* 15:   */ public class MailboxExtServiceImpl
/* 16:   */   implements MailboxExtService
/* 17:   */ {
/* 18:   */   private MailboxExtDao dao;
/* 19:   */   
/* 20:   */   @Transactional(readOnly=true)
/* 21:   */   public Pagination getPage(int pageNo, int pageSize)
/* 22:   */   {
/* 23:19 */     Pagination page = this.dao.getPage(pageNo, pageSize);
/* 24:20 */     return page;
/* 25:   */   }
/* 26:   */   
/* 27:   */   @Transactional(readOnly=true)
/* 28:   */   public MailboxExt findById(Integer id)
/* 29:   */   {
/* 30:25 */     MailboxExt entity = this.dao.findById(id);
/* 31:26 */     return entity;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public MailboxExt save(Mailbox mailbox, MailboxExt bean)
/* 35:   */   {
/* 36:30 */     bean.setMailbox(mailbox);
/* 37:31 */     this.dao.save(bean);
/* 38:32 */     mailbox.setExt(bean);
/* 39:33 */     return bean;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public MailboxExt update(Mailbox mailbox, MailboxExt bean)
/* 43:   */   {
/* 44:37 */     MailboxExt ext = findById(mailbox.getId());
/* 45:38 */     if (ext == null)
/* 46:   */     {
/* 47:39 */       ext = save(mailbox, bean);
/* 48:40 */       return ext;
/* 49:   */     }
/* 50:42 */     Updater<MailboxExt> updater = new Updater(bean);
/* 51:43 */     bean = this.dao.updateByUpdater(updater);
/* 52:44 */     return bean;
/* 53:   */   }
/* 54:   */   
/* 55:   */   public MailboxExt deleteById(Integer id)
/* 56:   */   {
/* 57:49 */     MailboxExt bean = this.dao.deleteById(id);
/* 58:50 */     return bean;
/* 59:   */   }
/* 60:   */   
/* 61:   */   public MailboxExt[] deleteByIds(Integer[] ids)
/* 62:   */   {
/* 63:54 */     MailboxExt[] beans = new MailboxExt[ids.length];
/* 64:55 */     int i = 0;
/* 65:55 */     for (int len = ids.length; i < len; i++) {
/* 66:56 */       beans[i] = deleteById(ids[i]);
/* 67:   */     }
/* 68:58 */     return beans;
/* 69:   */   }
/* 70:   */   
/* 71:   */   @Autowired
/* 72:   */   public void setDao(MailboxExtDao dao)
/* 73:   */   {
/* 74:65 */     this.dao = dao;
/* 75:   */   }
/* 76:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.govcenter.service.impl.MailboxExtServiceImpl
 * JD-Core Version:    0.7.0.1
 */