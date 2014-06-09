/*   1:    */ package com.portal.usermgr.service.impl;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.hibernate3.Updater;
/*   4:    */ import com.javapms.basic.page.Pagination;
/*   5:    */ import com.portal.sysmgr.entity.Site;
/*   6:    */ import com.portal.usermgr.dao.AdminDao;
/*   7:    */ import com.portal.usermgr.entity.Admin;
/*   8:    */ import com.portal.usermgr.entity.Depart;
/*   9:    */ import com.portal.usermgr.entity.Role;
/*  10:    */ import com.portal.usermgr.entity.User;
/*  11:    */ import com.portal.usermgr.service.AdminCheckService;
/*  12:    */ import com.portal.usermgr.service.AdminService;
/*  13:    */ import com.portal.usermgr.service.DepartService;
/*  14:    */ import com.portal.usermgr.service.RoleService;
/*  15:    */ import com.portal.usermgr.service.UserService;
/*  16:    */ import java.sql.Timestamp;
/*  17:    */ import java.util.Set;
/*  18:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  19:    */ import org.springframework.stereotype.Service;
/*  20:    */ import org.springframework.transaction.annotation.Transactional;
/*  21:    */ 
/*  22:    */ @Service
/*  23:    */ @Transactional
/*  24:    */ public class AdminServiceImpl
/*  25:    */   implements AdminService
/*  26:    */ {
/*  27:    */   private AdminDao dao;
/*  28:    */   private UserService userService;
/*  29:    */   private AdminCheckService adminCheckService;
/*  30:    */   private RoleService roleService;
/*  31:    */   private DepartService departService;
/*  32:    */   
/*  33:    */   @Transactional(readOnly=true)
/*  34:    */   public Pagination getPage(int pageNo, int pageSize)
/*  35:    */   {
/*  36: 26 */     Pagination page = this.dao.getPage(pageNo, pageSize);
/*  37: 27 */     return page;
/*  38:    */   }
/*  39:    */   
/*  40:    */   @Transactional(readOnly=true)
/*  41:    */   public Pagination getPage(String key, Integer siteId, Integer departId, Integer roleId, String sortname, String sortorder, int pageNo, int pageSize)
/*  42:    */   {
/*  43: 34 */     return this.dao.getPage(key, siteId, departId, roleId, sortname, sortorder, 
/*  44: 35 */       pageNo, pageSize);
/*  45:    */   }
/*  46:    */   
/*  47:    */   @Transactional(readOnly=true)
/*  48:    */   public Admin findById(Integer id)
/*  49:    */   {
/*  50: 40 */     Admin entity = this.dao.findById(id);
/*  51: 41 */     return entity;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public Admin saveAdmin(User user, Admin admin, String ip, Integer roleId, Integer departId, Site site, Byte manageStatus)
/*  55:    */   {
/*  56: 46 */     admin.setRegisterIp(ip);
/*  57: 47 */     if (roleId != null) {
/*  58: 48 */       admin.addToRoles(this.roleService.findById(roleId));
/*  59:    */     }
/*  60: 50 */     if (departId != null) {
/*  61: 51 */       admin.addToDeparts(this.departService.findById(departId));
/*  62:    */     }
/*  63: 53 */     this.userService.save(user);
/*  64: 54 */     admin.setUser(user);
/*  65: 55 */     admin = save(admin);
/*  66: 56 */     user.setAdmin(admin);
/*  67: 57 */     this.adminCheckService.save(site, admin, manageStatus);
/*  68: 58 */     return admin;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public Admin updateAdmin(User user, Admin admin, Integer roleId, Integer departId, Site site, Byte manageStatus)
/*  72:    */   {
/*  73: 63 */     admin = update(admin);
/*  74: 64 */     this.adminCheckService.updateByAdmin(admin, site, manageStatus);
/*  75: 65 */     this.userService.update(user);
/*  76: 66 */     if ((roleId != null) && 
/*  77: 67 */       (!roleId.equals(admin.getRole(site.getId()).getId())))
/*  78:    */     {
/*  79: 68 */       admin.getRoles().remove(admin.getRole(site.getId()));
/*  80: 69 */       admin.addToRoles(this.roleService.findById(roleId));
/*  81:    */     }
/*  82: 72 */     if (departId != null) {
/*  83: 73 */       if (admin.getDepart(site.getId()) != null)
/*  84:    */       {
/*  85: 74 */         if (!departId.equals(admin.getDepart(site.getId()).getId()))
/*  86:    */         {
/*  87: 75 */           admin.getDeparts().remove(admin.getDepart(site.getId()));
/*  88: 76 */           admin.addToDeparts(this.departService.findById(departId));
/*  89:    */         }
/*  90:    */       }
/*  91:    */       else {
/*  92: 79 */         admin.addToDeparts(this.departService.findById(departId));
/*  93:    */       }
/*  94:    */     }
/*  95: 82 */     return admin;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public void updateLoginInfo(User user, String lastLoginIp)
/*  99:    */   {
/* 100: 86 */     Admin admin = findById(user.getId());
/* 101: 87 */     if (admin != null)
/* 102:    */     {
/* 103: 88 */       admin.setLastLoginIp(lastLoginIp);
/* 104: 89 */       admin.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
/* 105: 90 */       if (admin.getRegisterIp() == null) {
/* 106: 91 */         admin.setRegisterIp(lastLoginIp);
/* 107:    */       }
/* 108: 93 */       admin.setLoginCount(Integer.valueOf(admin.getLoginCount().intValue() + 1));
/* 109:    */     }
/* 110:    */   }
/* 111:    */   
/* 112:    */   public Admin save(Admin bean)
/* 113:    */   {
/* 114: 98 */     bean.init();
/* 115: 99 */     this.dao.save(bean);
/* 116:100 */     return bean;
/* 117:    */   }
/* 118:    */   
/* 119:    */   public Admin update(Admin bean)
/* 120:    */   {
/* 121:104 */     Updater<Admin> updater = new Updater(bean);
/* 122:105 */     bean = this.dao.updateByUpdater(updater);
/* 123:106 */     return bean;
/* 124:    */   }
/* 125:    */   
/* 126:    */   public Admin updatePass(Integer adminId, String password)
/* 127:    */   {
/* 128:110 */     User user = this.userService.updatePass(adminId, password);
/* 129:111 */     return user.getAdmin();
/* 130:    */   }
/* 131:    */   
/* 132:    */   public Admin deleteById(Integer id)
/* 133:    */   {
/* 134:115 */     Admin bean = this.dao.deleteById(id);
/* 135:116 */     this.userService.deleteById(id);
/* 136:117 */     return bean;
/* 137:    */   }
/* 138:    */   
/* 139:    */   public Admin[] deleteByIds(Integer[] ids)
/* 140:    */   {
/* 141:121 */     Admin[] beans = new Admin[ids.length];
/* 142:122 */     int i = 0;
/* 143:122 */     for (int len = ids.length; i < len; i++) {
/* 144:123 */       beans[i] = deleteById(ids[i]);
/* 145:    */     }
/* 146:125 */     return beans;
/* 147:    */   }
/* 148:    */   
/* 149:    */   @Autowired
/* 150:    */   public void setDao(AdminDao dao)
/* 151:    */   {
/* 152:136 */     this.dao = dao;
/* 153:    */   }
/* 154:    */   
/* 155:    */   @Autowired
/* 156:    */   public void setUserService(UserService userService)
/* 157:    */   {
/* 158:141 */     this.userService = userService;
/* 159:    */   }
/* 160:    */   
/* 161:    */   @Autowired
/* 162:    */   public void setAdminCheckService(AdminCheckService adminCheckService)
/* 163:    */   {
/* 164:146 */     this.adminCheckService = adminCheckService;
/* 165:    */   }
/* 166:    */   
/* 167:    */   @Autowired
/* 168:    */   public void setRoleService(RoleService roleService)
/* 169:    */   {
/* 170:151 */     this.roleService = roleService;
/* 171:    */   }
/* 172:    */   
/* 173:    */   @Autowired
/* 174:    */   public void setDepartService(DepartService departService)
/* 175:    */   {
/* 176:156 */     this.departService = departService;
/* 177:    */   }
/* 178:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.service.impl.AdminServiceImpl
 * JD-Core Version:    0.7.0.1
 */