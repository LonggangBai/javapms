/*  1:   */ package com.portal.usermgr.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.portal.sysmgr.entity.Site;
/*  5:   */ import com.portal.usermgr.dao.GroupDao;
/*  6:   */ import com.portal.usermgr.entity.Group;
/*  7:   */ import com.portal.usermgr.entity.GroupPerm;
/*  8:   */ import com.portal.usermgr.service.GroupPermService;
/*  9:   */ import com.portal.usermgr.service.GroupService;
/* 10:   */ import java.util.List;
/* 11:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 12:   */ import org.springframework.stereotype.Service;
/* 13:   */ import org.springframework.transaction.annotation.Transactional;
/* 14:   */ 
/* 15:   */ @Service
/* 16:   */ @Transactional
/* 17:   */ public class GroupServiceImpl
/* 18:   */   implements GroupService
/* 19:   */ {
/* 20:   */   private GroupDao dao;
/* 21:   */   private GroupPermService groupPermService;
/* 22:   */   
/* 23:   */   @Transactional(readOnly=true)
/* 24:   */   public List<Group> getList(Integer siteId, String sortname, String sortorder)
/* 25:   */   {
/* 26:22 */     return this.dao.getList(siteId, sortname, sortorder);
/* 27:   */   }
/* 28:   */   
/* 29:   */   @Transactional(readOnly=true)
/* 30:   */   public Group findById(Integer id)
/* 31:   */   {
/* 32:27 */     Group entity = this.dao.findById(id);
/* 33:28 */     return entity;
/* 34:   */   }
/* 35:   */   
/* 36:   */   public Group saveGroup(Group group, GroupPerm groupPerm, Site site)
/* 37:   */   {
/* 38:32 */     group.setSite(site);
/* 39:33 */     save(group);
/* 40:34 */     this.groupPermService.save(group, groupPerm);
/* 41:35 */     return group;
/* 42:   */   }
/* 43:   */   
/* 44:   */   public Group updateGroup(Group group, GroupPerm groupPerm)
/* 45:   */   {
/* 46:39 */     update(group);
/* 47:40 */     this.groupPermService.update(groupPerm);
/* 48:41 */     return group;
/* 49:   */   }
/* 50:   */   
/* 51:   */   public Group save(Group bean)
/* 52:   */   {
/* 53:45 */     bean.init();
/* 54:46 */     this.dao.save(bean);
/* 55:47 */     return bean;
/* 56:   */   }
/* 57:   */   
/* 58:   */   public Group update(Group bean)
/* 59:   */   {
/* 60:51 */     Updater<Group> updater = new Updater(bean);
/* 61:52 */     Group entity = this.dao.updateByUpdater(updater);
/* 62:53 */     return entity;
/* 63:   */   }
/* 64:   */   
/* 65:   */   public Group deleteById(Integer id)
/* 66:   */   {
/* 67:57 */     Group bean = this.dao.deleteById(id);
/* 68:58 */     return bean;
/* 69:   */   }
/* 70:   */   
/* 71:   */   public Group[] deleteByIds(Integer[] ids)
/* 72:   */   {
/* 73:62 */     Group[] beans = new Group[ids.length];
/* 74:63 */     int i = 0;
/* 75:63 */     for (int len = ids.length; i < len; i++) {
/* 76:64 */       beans[i] = deleteById(ids[i]);
/* 77:   */     }
/* 78:66 */     return beans;
/* 79:   */   }
/* 80:   */   
/* 81:   */   public Group[] updatePriority(Integer[] ids, Integer[] priority)
/* 82:   */   {
/* 83:70 */     int len = ids.length;
/* 84:71 */     Group[] beans = new Group[len];
/* 85:72 */     for (int i = 0; i < len; i++)
/* 86:   */     {
/* 87:73 */       beans[i] = findById(ids[i]);
/* 88:74 */       beans[i].setPriority(priority[i]);
/* 89:   */     }
/* 90:76 */     return beans;
/* 91:   */   }
/* 92:   */   
/* 93:   */   @Autowired
/* 94:   */   public void setDao(GroupDao dao)
/* 95:   */   {
/* 96:84 */     this.dao = dao;
/* 97:   */   }
/* 98:   */   
/* 99:   */   @Autowired
/* :0:   */   public void setGroupPermService(GroupPermService groupPermService)
/* :1:   */   {
/* :2:89 */     this.groupPermService = groupPermService;
/* :3:   */   }
/* :4:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.service.impl.GroupServiceImpl
 * JD-Core Version:    0.7.0.1
 */