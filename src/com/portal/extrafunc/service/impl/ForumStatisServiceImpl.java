/*  1:   */ package com.portal.extrafunc.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.extrafunc.dao.ForumStatisDao;
/*  6:   */ import com.portal.extrafunc.entity.ForumStatis;
/*  7:   */ import com.portal.extrafunc.service.ForumStatisService;
/*  8:   */ import com.portal.sysmgr.entity.Site;
/*  9:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 10:   */ import org.springframework.stereotype.Service;
/* 11:   */ import org.springframework.transaction.annotation.Transactional;
/* 12:   */ 
/* 13:   */ @Service
/* 14:   */ @Transactional
/* 15:   */ public class ForumStatisServiceImpl
/* 16:   */   implements ForumStatisService
/* 17:   */ {
/* 18:   */   private ForumStatisDao dao;
/* 19:   */   
/* 20:   */   @Transactional(readOnly=true)
/* 21:   */   public Pagination getPage(int pageNo, int pageSize)
/* 22:   */   {
/* 23:19 */     Pagination page = this.dao.getPage(pageNo, pageSize);
/* 24:20 */     return page;
/* 25:   */   }
/* 26:   */   
/* 27:   */   @Transactional(readOnly=true)
/* 28:   */   public ForumStatis findById(Integer id)
/* 29:   */   {
/* 30:25 */     ForumStatis entity = this.dao.findById(id);
/* 31:26 */     return entity;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public ForumStatis save(Site site)
/* 35:   */   {
/* 36:30 */     ForumStatis bean = new ForumStatis();
/* 37:31 */     bean.setPostsToday(Integer.valueOf(0));
/* 38:32 */     bean.setPostsYestoday(Integer.valueOf(0));
/* 39:33 */     bean.setPostsTotal(Integer.valueOf(0));
/* 40:34 */     bean.setHighestDay(Integer.valueOf(0));
/* 41:35 */     bean.setSite(site);
/* 42:36 */     this.dao.save(bean);
/* 43:37 */     site.setForumStatis(bean);
/* 44:38 */     return bean;
/* 45:   */   }
/* 46:   */   
/* 47:   */   public ForumStatis update(Integer siteId, Integer postsToday, Integer postsTotal)
/* 48:   */   {
/* 49:43 */     ForumStatis bean = findById(siteId);
/* 50:44 */     bean.setPostsToday(postsToday);
/* 51:45 */     bean.setPostsTotal(postsTotal);
/* 52:46 */     return bean;
/* 53:   */   }
/* 54:   */   
/* 55:   */   public ForumStatis updateOnday(Integer siteId, Integer postsToday, Integer postsTotal)
/* 56:   */   {
/* 57:51 */     ForumStatis bean = findById(siteId);
/* 58:52 */     if (postsToday.intValue() > bean.getHighestDay().intValue()) {
/* 59:53 */       bean.setHighestDay(postsToday);
/* 60:   */     }
/* 61:55 */     bean.setPostsToday(Integer.valueOf(0));
/* 62:56 */     bean.setPostsYestoday(postsToday);
/* 63:57 */     bean.setPostsTotal(postsTotal);
/* 64:58 */     return bean;
/* 65:   */   }
/* 66:   */   
/* 67:   */   public ForumStatis update(ForumStatis bean)
/* 68:   */   {
/* 69:62 */     Updater<ForumStatis> updater = new Updater(bean);
/* 70:63 */     bean = this.dao.updateByUpdater(updater);
/* 71:64 */     return bean;
/* 72:   */   }
/* 73:   */   
/* 74:   */   public ForumStatis deleteById(Integer id)
/* 75:   */   {
/* 76:68 */     ForumStatis bean = this.dao.deleteById(id);
/* 77:69 */     return bean;
/* 78:   */   }
/* 79:   */   
/* 80:   */   public ForumStatis[] deleteByIds(Integer[] ids)
/* 81:   */   {
/* 82:73 */     ForumStatis[] beans = new ForumStatis[ids.length];
/* 83:74 */     int i = 0;
/* 84:74 */     for (int len = ids.length; i < len; i++) {
/* 85:75 */       beans[i] = deleteById(ids[i]);
/* 86:   */     }
/* 87:77 */     return beans;
/* 88:   */   }
/* 89:   */   
/* 90:   */   @Autowired
/* 91:   */   public void setDao(ForumStatisDao dao)
/* 92:   */   {
/* 93:84 */     this.dao = dao;
/* 94:   */   }
/* 95:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.impl.ForumStatisServiceImpl
 * JD-Core Version:    0.7.0.1
 */