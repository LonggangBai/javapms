/*  1:   */ package com.portal.usermgr.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.javapms.basic.security.encoder.PwdEncoder;
/*  5:   */ import com.portal.usermgr.dao.UserDao;
/*  6:   */ import com.portal.usermgr.entity.User;
/*  7:   */ import com.portal.usermgr.service.UserService;
/*  8:   */ import org.springframework.beans.factory.annotation.Autowired;
/*  9:   */ import org.springframework.stereotype.Service;
/* 10:   */ import org.springframework.transaction.annotation.Transactional;
/* 11:   */ 
/* 12:   */ @Service
/* 13:   */ @Transactional
/* 14:   */ public class UserServiceImpl
/* 15:   */   implements UserService
/* 16:   */ {
/* 17:   */   private UserDao dao;
/* 18:   */   private PwdEncoder pwdEncoder;
/* 19:   */   
/* 20:   */   @Transactional(readOnly=true)
/* 21:   */   public User findByPersonal(Integer personalId)
/* 22:   */   {
/* 23:18 */     return this.dao.findByPersonal(personalId);
/* 24:   */   }
/* 25:   */   
/* 26:   */   @Transactional(readOnly=true)
/* 27:   */   public User findByCompany(Integer companyId)
/* 28:   */   {
/* 29:23 */     return this.dao.findByCompany(companyId);
/* 30:   */   }
/* 31:   */   
/* 32:   */   @Transactional(readOnly=true)
/* 33:   */   public User findById(Integer id)
/* 34:   */   {
/* 35:28 */     User entity = this.dao.findById(id);
/* 36:29 */     return entity;
/* 37:   */   }
/* 38:   */   
/* 39:   */   @Transactional(readOnly=true)
/* 40:   */   public User findByUsername(String username)
/* 41:   */   {
/* 42:34 */     User entity = this.dao.findByUsername(username);
/* 43:35 */     return entity;
/* 44:   */   }
/* 45:   */   
/* 46:   */   public User save(User user)
/* 47:   */   {
/* 48:39 */     user.init();
/* 49:40 */     user.setPassword(this.pwdEncoder.encodePassword(user.getPassword()));
/* 50:41 */     this.dao.save(user);
/* 51:42 */     return user;
/* 52:   */   }
/* 53:   */   
/* 54:   */   public User update(User user)
/* 55:   */   {
/* 56:46 */     Updater<User> updater = new Updater(user);
/* 57:47 */     User u = this.dao.updateByUpdater(updater);
/* 58:48 */     return u;
/* 59:   */   }
/* 60:   */   
/* 61:   */   public User updatePass(Integer userId, String password)
/* 62:   */   {
/* 63:52 */     User user = findById(userId);
/* 64:53 */     user.setPassword(this.pwdEncoder.encodePassword(password));
/* 65:54 */     return user;
/* 66:   */   }
/* 67:   */   
/* 68:   */   public User deleteById(Integer id)
/* 69:   */   {
/* 70:58 */     User bean = this.dao.deleteById(id);
/* 71:59 */     return bean;
/* 72:   */   }
/* 73:   */   
/* 74:   */   public User[] deleteByIds(Integer[] ids)
/* 75:   */   {
/* 76:63 */     User[] beans = new User[ids.length];
/* 77:64 */     int i = 0;
/* 78:64 */     for (int len = ids.length; i < len; i++) {
/* 79:65 */       beans[i] = deleteById(ids[i]);
/* 80:   */     }
/* 81:67 */     return beans;
/* 82:   */   }
/* 83:   */   
/* 84:   */   @Autowired
/* 85:   */   public void setDao(UserDao dao)
/* 86:   */   {
/* 87:75 */     this.dao = dao;
/* 88:   */   }
/* 89:   */   
/* 90:   */   @Autowired
/* 91:   */   public void setPwdEncoder(PwdEncoder pwdEncoder)
/* 92:   */   {
/* 93:80 */     this.pwdEncoder = pwdEncoder;
/* 94:   */   }
/* 95:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.service.impl.UserServiceImpl
 * JD-Core Version:    0.7.0.1
 */