/*  1:   */ package com.portal.usermgr.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.usermgr.dao.GroupPermDao;
/*  6:   */ import com.portal.usermgr.entity.Group;
/*  7:   */ import com.portal.usermgr.entity.GroupPerm;
/*  8:   */ import com.portal.usermgr.service.GroupPermService;
/*  9:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 10:   */ import org.springframework.stereotype.Service;
/* 11:   */ import org.springframework.transaction.annotation.Transactional;
/* 12:   */ 
/* 13:   */ @Service
/* 14:   */ @Transactional
/* 15:   */ public class GroupPermServiceImpl
/* 16:   */   implements GroupPermService
/* 17:   */ {
/* 18:   */   private GroupPermDao dao;
/* 19:   */   
/* 20:   */   @Transactional(readOnly=true)
/* 21:   */   public Pagination getPage(int pageNo, int pageSize)
/* 22:   */   {
/* 23:19 */     Pagination page = this.dao.getPage(pageNo, pageSize);
/* 24:20 */     return page;
/* 25:   */   }
/* 26:   */   
/* 27:   */   @Transactional(readOnly=true)
/* 28:   */   public GroupPerm findById(Integer id)
/* 29:   */   {
/* 30:25 */     GroupPerm entity = this.dao.findById(id);
/* 31:26 */     return entity;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public GroupPerm save(Group group, GroupPerm perm)
/* 35:   */   {
/* 36:30 */     perm.setGroup(group);
/* 37:31 */     save(perm);
/* 38:32 */     group.setGroupPerm(perm);
/* 39:33 */     return perm;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public GroupPerm save(GroupPerm bean)
/* 43:   */   {
/* 44:37 */     this.dao.save(bean);
/* 45:38 */     return bean;
/* 46:   */   }
/* 47:   */   
/* 48:   */   public GroupPerm update(GroupPerm bean)
/* 49:   */   {
/* 50:42 */     Updater<GroupPerm> updater = new Updater(bean);
/* 51:43 */     bean = this.dao.updateByUpdater(updater);
/* 52:44 */     return bean;
/* 53:   */   }
/* 54:   */   
/* 55:   */   public GroupPerm deleteById(Integer id)
/* 56:   */   {
/* 57:48 */     GroupPerm bean = this.dao.deleteById(id);
/* 58:49 */     return bean;
/* 59:   */   }
/* 60:   */   
/* 61:   */   public GroupPerm[] deleteByIds(Integer[] ids)
/* 62:   */   {
/* 63:53 */     GroupPerm[] beans = new GroupPerm[ids.length];
/* 64:54 */     int i = 0;
/* 65:54 */     for (int len = ids.length; i < len; i++) {
/* 66:55 */       beans[i] = deleteById(ids[i]);
/* 67:   */     }
/* 68:57 */     return beans;
/* 69:   */   }
/* 70:   */   
/* 71:   */   @Autowired
/* 72:   */   public void setDao(GroupPermDao dao)
/* 73:   */   {
/* 74:64 */     this.dao = dao;
/* 75:   */   }
/* 76:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.service.impl.GroupPermServiceImpl
 * JD-Core Version:    0.7.0.1
 */