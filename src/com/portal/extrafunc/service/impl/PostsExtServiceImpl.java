/*  1:   */ package com.portal.extrafunc.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.page.Pagination;
/*  4:   */ import com.portal.extrafunc.dao.PostsExtDao;
/*  5:   */ import com.portal.extrafunc.entity.Posts;
/*  6:   */ import com.portal.extrafunc.entity.PostsExt;
/*  7:   */ import com.portal.extrafunc.service.PostsExtService;
/*  8:   */ import com.portal.usermgr.service.UserService;
/*  9:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 10:   */ import org.springframework.stereotype.Service;
/* 11:   */ import org.springframework.transaction.annotation.Transactional;
/* 12:   */ 
/* 13:   */ @Service
/* 14:   */ @Transactional
/* 15:   */ public class PostsExtServiceImpl
/* 16:   */   implements PostsExtService
/* 17:   */ {
/* 18:   */   private PostsExtDao dao;
/* 19:   */   private UserService userService;
/* 20:   */   
/* 21:   */   @Transactional(readOnly=true)
/* 22:   */   public Pagination getPage(int pageNo, int pageSize)
/* 23:   */   {
/* 24:19 */     Pagination page = this.dao.getPage(pageNo, pageSize);
/* 25:20 */     return page;
/* 26:   */   }
/* 27:   */   
/* 28:   */   @Transactional(readOnly=true)
/* 29:   */   public PostsExt findById(Integer id)
/* 30:   */   {
/* 31:25 */     PostsExt entity = this.dao.findById(id);
/* 32:26 */     return entity;
/* 33:   */   }
/* 34:   */   
/* 35:   */   public PostsExt save(String ip, Posts posts)
/* 36:   */   {
/* 37:30 */     PostsExt ext = new PostsExt();
/* 38:31 */     ext.setCreateIp(ip);
/* 39:32 */     ext.setPosts(posts);
/* 40:33 */     ext.init();
/* 41:34 */     this.dao.save(ext);
/* 42:35 */     posts.setExt(ext);
/* 43:36 */     return ext;
/* 44:   */   }
/* 45:   */   
/* 46:   */   public PostsExt update(Integer extId, Integer userId, String ip)
/* 47:   */   {
/* 48:40 */     PostsExt ext = findById(extId);
/* 49:41 */     ext.setEditer(this.userService.findById(userId));
/* 50:42 */     ext.setCreateIp(ip);
/* 51:43 */     ext.setEditCount(Integer.valueOf(ext.getEditCount().intValue() + 1));
/* 52:44 */     return ext;
/* 53:   */   }
/* 54:   */   
/* 55:   */   public PostsExt deleteById(Integer id)
/* 56:   */   {
/* 57:48 */     PostsExt bean = this.dao.deleteById(id);
/* 58:49 */     return bean;
/* 59:   */   }
/* 60:   */   
/* 61:   */   public PostsExt[] deleteByIds(Integer[] ids)
/* 62:   */   {
/* 63:53 */     PostsExt[] beans = new PostsExt[ids.length];
/* 64:54 */     int i = 0;
/* 65:54 */     for (int len = ids.length; i < len; i++) {
/* 66:55 */       beans[i] = deleteById(ids[i]);
/* 67:   */     }
/* 68:57 */     return beans;
/* 69:   */   }
/* 70:   */   
/* 71:   */   @Autowired
/* 72:   */   public void setDao(PostsExtDao dao)
/* 73:   */   {
/* 74:65 */     this.dao = dao;
/* 75:   */   }
/* 76:   */   
/* 77:   */   @Autowired
/* 78:   */   public void setUserService(UserService userService)
/* 79:   */   {
/* 80:70 */     this.userService = userService;
/* 81:   */   }
/* 82:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.impl.PostsExtServiceImpl
 * JD-Core Version:    0.7.0.1
 */