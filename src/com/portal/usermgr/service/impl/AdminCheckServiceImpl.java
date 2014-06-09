/*  1:   */ package com.portal.usermgr.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.portal.sysmgr.entity.Site;
/*  5:   */ import com.portal.usermgr.dao.AdminCheckDao;
/*  6:   */ import com.portal.usermgr.entity.Admin;
/*  7:   */ import com.portal.usermgr.entity.AdminCheck;
/*  8:   */ import com.portal.usermgr.service.AdminCheckService;
/*  9:   */ import java.util.Set;
/* 10:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 11:   */ import org.springframework.stereotype.Service;
/* 12:   */ import org.springframework.transaction.annotation.Transactional;
/* 13:   */ 
/* 14:   */ @Service
/* 15:   */ @Transactional
/* 16:   */ public class AdminCheckServiceImpl
/* 17:   */   implements AdminCheckService
/* 18:   */ {
/* 19:   */   private AdminCheckDao dao;
/* 20:   */   
/* 21:   */   @Transactional(readOnly=true)
/* 22:   */   public AdminCheck findById(Integer id)
/* 23:   */   {
/* 24:21 */     AdminCheck entity = this.dao.findById(id);
/* 25:22 */     return entity;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public AdminCheck save(Site site, Admin admin, Byte manageStatus)
/* 29:   */   {
/* 30:26 */     AdminCheck bean = new AdminCheck();
/* 31:27 */     bean.setSite(site);
/* 32:28 */     bean.setAdmin(admin);
/* 33:29 */     bean.setManageStatus(manageStatus);
/* 34:30 */     this.dao.save(bean);
/* 35:31 */     admin.addToAdminChecks(bean);
/* 36:32 */     return bean;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public AdminCheck update(AdminCheck bean)
/* 40:   */   {
/* 41:36 */     Updater<AdminCheck> updater = new Updater(bean);
/* 42:37 */     bean = this.dao.updateByUpdater(updater);
/* 43:38 */     return bean;
/* 44:   */   }
/* 45:   */   
/* 46:   */   public void updateByAdmin(Admin admin, Site site, Byte manageStatus)
/* 47:   */   {
/* 48:42 */     Set<AdminCheck> ass = admin.getAdminChecks();
/* 49:43 */     if ((site == null) || (manageStatus == null)) {
/* 50:44 */       return;
/* 51:   */     }
/* 52:46 */     if (ass == null) {
/* 53:47 */       save(site, admin, manageStatus);
/* 54:   */     } else {
/* 55:49 */       for (AdminCheck as : ass) {
/* 56:50 */         if (site.getId().equals(as.getSite().getId())) {
/* 57:51 */           as.setManageStatus(manageStatus);
/* 58:   */         }
/* 59:   */       }
/* 60:   */     }
/* 61:   */   }
/* 62:   */   
/* 63:   */   public int deleteBySiteId(Integer siteId)
/* 64:   */   {
/* 65:58 */     return this.dao.deleteBySiteId(siteId);
/* 66:   */   }
/* 67:   */   
/* 68:   */   public AdminCheck deleteById(Integer id)
/* 69:   */   {
/* 70:62 */     AdminCheck bean = this.dao.deleteById(id);
/* 71:63 */     return bean;
/* 72:   */   }
/* 73:   */   
/* 74:   */   public AdminCheck[] deleteByIds(Integer[] ids)
/* 75:   */   {
/* 76:67 */     AdminCheck[] beans = new AdminCheck[ids.length];
/* 77:68 */     int i = 0;
/* 78:68 */     for (int len = ids.length; i < len; i++) {
/* 79:69 */       beans[i] = deleteById(ids[i]);
/* 80:   */     }
/* 81:71 */     return beans;
/* 82:   */   }
/* 83:   */   
/* 84:   */   @Autowired
/* 85:   */   public void setDao(AdminCheckDao dao)
/* 86:   */   {
/* 87:78 */     this.dao = dao;
/* 88:   */   }
/* 89:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.service.impl.AdminCheckServiceImpl
 * JD-Core Version:    0.7.0.1
 */