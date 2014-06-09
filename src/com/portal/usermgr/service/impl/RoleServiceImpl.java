/*  1:   */ package com.portal.usermgr.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.sysmgr.entity.Site;
/*  6:   */ import com.portal.usermgr.dao.RoleDao;
/*  7:   */ import com.portal.usermgr.entity.Role;
/*  8:   */ import com.portal.usermgr.entity.RolePerm;
/*  9:   */ import com.portal.usermgr.service.RolePermService;
/* 10:   */ import com.portal.usermgr.service.RoleService;
/* 11:   */ import java.util.List;
/* 12:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 13:   */ import org.springframework.stereotype.Service;
/* 14:   */ import org.springframework.transaction.annotation.Transactional;
/* 15:   */ 
/* 16:   */ @Service
/* 17:   */ @Transactional
/* 18:   */ public class RoleServiceImpl
/* 19:   */   implements RoleService
/* 20:   */ {
/* 21:   */   private RoleDao dao;
/* 22:   */   private RolePermService rolePermService;
/* 23:   */   
/* 24:   */   @Transactional(readOnly=true)
/* 25:   */   public Pagination getPage(String name, Integer siteId, String sortname, String sortorder, int pageNo, int pageSize)
/* 26:   */   {
/* 27:25 */     return this.dao.getPage(name, siteId, sortname, sortorder, pageNo, pageSize);
/* 28:   */   }
/* 29:   */   
/* 30:   */   @Transactional(readOnly=true)
/* 31:   */   public List<Role> getListBySite(Integer siteId)
/* 32:   */   {
/* 33:30 */     return this.dao.getListBySite(siteId);
/* 34:   */   }
/* 35:   */   
/* 36:   */   @Transactional(readOnly=true)
/* 37:   */   public Role findById(Integer id)
/* 38:   */   {
/* 39:35 */     Role entity = this.dao.findById(id);
/* 40:36 */     return entity;
/* 41:   */   }
/* 42:   */   
/* 43:   */   public Role saveRole(Role role, RolePerm rolePerm, Site site)
/* 44:   */   {
/* 45:40 */     role.setSite(site);
/* 46:41 */     save(role);
/* 47:42 */     this.rolePermService.save(role, rolePerm);
/* 48:43 */     return role;
/* 49:   */   }
/* 50:   */   
/* 51:   */   public Role updateRole(Role role, RolePerm rolePerm)
/* 52:   */   {
/* 53:47 */     role = update(role);
/* 54:48 */     this.rolePermService.update(rolePerm);
/* 55:49 */     return role;
/* 56:   */   }
/* 57:   */   
/* 58:   */   public Role save(Role bean)
/* 59:   */   {
/* 60:53 */     bean.init();
/* 61:54 */     this.dao.save(bean);
/* 62:55 */     return bean;
/* 63:   */   }
/* 64:   */   
/* 65:   */   public Role update(Role bean)
/* 66:   */   {
/* 67:59 */     Updater<Role> updater = new Updater(bean);
/* 68:60 */     bean = this.dao.updateByUpdater(updater);
/* 69:61 */     return bean;
/* 70:   */   }
/* 71:   */   
/* 72:   */   public Role deleteById(Integer id)
/* 73:   */   {
/* 74:65 */     Role bean = this.dao.deleteById(id);
/* 75:66 */     return bean;
/* 76:   */   }
/* 77:   */   
/* 78:   */   public Role[] deleteByIds(Integer[] ids)
/* 79:   */   {
/* 80:70 */     Role[] beans = new Role[ids.length];
/* 81:71 */     int i = 0;
/* 82:71 */     for (int len = ids.length; i < len; i++) {
/* 83:72 */       beans[i] = deleteById(ids[i]);
/* 84:   */     }
/* 85:74 */     return beans;
/* 86:   */   }
/* 87:   */   
/* 88:   */   @Autowired
/* 89:   */   public void setDao(RoleDao dao)
/* 90:   */   {
/* 91:82 */     this.dao = dao;
/* 92:   */   }
/* 93:   */   
/* 94:   */   @Autowired
/* 95:   */   public void setRolePermService(RolePermService rolePermService)
/* 96:   */   {
/* 97:87 */     this.rolePermService = rolePermService;
/* 98:   */   }
/* 99:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.service.impl.RoleServiceImpl
 * JD-Core Version:    0.7.0.1
 */