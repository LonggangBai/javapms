/*  1:   */ package com.portal.extrafunc.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.extrafunc.dao.ForumExtDao;
/*  6:   */ import com.portal.extrafunc.entity.Forum;
/*  7:   */ import com.portal.extrafunc.entity.ForumExt;
/*  8:   */ import com.portal.extrafunc.service.ForumExtService;
/*  9:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 10:   */ import org.springframework.stereotype.Service;
/* 11:   */ import org.springframework.transaction.annotation.Transactional;
/* 12:   */ 
/* 13:   */ @Service
/* 14:   */ @Transactional
/* 15:   */ public class ForumExtServiceImpl
/* 16:   */   implements ForumExtService
/* 17:   */ {
/* 18:   */   private ForumExtDao dao;
/* 19:   */   
/* 20:   */   @Transactional(readOnly=true)
/* 21:   */   public Pagination getPage(int pageNo, int pageSize)
/* 22:   */   {
/* 23:19 */     Pagination page = this.dao.getPage(pageNo, pageSize);
/* 24:20 */     return page;
/* 25:   */   }
/* 26:   */   
/* 27:   */   @Transactional(readOnly=true)
/* 28:   */   public ForumExt findById(Integer id)
/* 29:   */   {
/* 30:25 */     ForumExt entity = this.dao.findById(id);
/* 31:26 */     return entity;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public ForumExt save(ForumExt bean, Forum forum)
/* 35:   */   {
/* 36:30 */     bean.setForum(forum);
/* 37:31 */     this.dao.save(bean);
/* 38:32 */     forum.setExt(bean);
/* 39:33 */     return bean;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public ForumExt update(ForumExt bean, Forum forum)
/* 43:   */   {
/* 44:37 */     ForumExt ext = findById(forum.getId());
/* 45:38 */     if (ext != null)
/* 46:   */     {
/* 47:39 */       Updater<ForumExt> updater = new Updater(bean);
/* 48:40 */       bean = this.dao.updateByUpdater(updater);
/* 49:   */     }
/* 50:   */     else
/* 51:   */     {
/* 52:42 */       bean = save(bean, forum);
/* 53:   */     }
/* 54:44 */     return bean;
/* 55:   */   }
/* 56:   */   
/* 57:   */   public ForumExt deleteById(Integer id)
/* 58:   */   {
/* 59:48 */     ForumExt bean = this.dao.deleteById(id);
/* 60:49 */     return bean;
/* 61:   */   }
/* 62:   */   
/* 63:   */   public ForumExt[] deleteByIds(Integer[] ids)
/* 64:   */   {
/* 65:53 */     ForumExt[] beans = new ForumExt[ids.length];
/* 66:54 */     int i = 0;
/* 67:54 */     for (int len = ids.length; i < len; i++) {
/* 68:55 */       beans[i] = deleteById(ids[i]);
/* 69:   */     }
/* 70:57 */     return beans;
/* 71:   */   }
/* 72:   */   
/* 73:   */   @Autowired
/* 74:   */   public void setDao(ForumExtDao dao)
/* 75:   */   {
/* 76:64 */     this.dao = dao;
/* 77:   */   }
/* 78:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.impl.ForumExtServiceImpl
 * JD-Core Version:    0.7.0.1
 */