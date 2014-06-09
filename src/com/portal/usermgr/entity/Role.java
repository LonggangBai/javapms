/*  1:   */ package com.portal.usermgr.entity;
/*  2:   */ 
/*  3:   */ import com.portal.usermgr.entity.base.BaseRole;
/*  4:   */ import java.util.Collection;
/*  5:   */ import java.util.HashSet;
/*  6:   */ import java.util.Set;
/*  7:   */ 
/*  8:   */ public class Role
/*  9:   */   extends BaseRole
/* 10:   */ {
/* 11:   */   private static final long serialVersionUID = 1L;
/* 12:   */   
/* 13:   */   public void init()
/* 14:   */   {
/* 15:13 */     if (getPriority() == null) {
/* 16:14 */       setPriority(Integer.valueOf(10));
/* 17:   */     }
/* 18:   */   }
/* 19:   */   
/* 20:   */   public static Integer[] fetchIds(Collection<Role> roles)
/* 21:   */   {
/* 22:19 */     if (roles == null) {
/* 23:20 */       return null;
/* 24:   */     }
/* 25:22 */     Integer[] ids = new Integer[roles.size()];
/* 26:23 */     int i = 0;
/* 27:24 */     for (Role r : roles) {
/* 28:25 */       ids[(i++)] = r.getId();
/* 29:   */     }
/* 30:27 */     return ids;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public String getPerms()
/* 34:   */   {
/* 35:31 */     RolePerm rolePerm = getRolePerm();
/* 36:32 */     if (rolePerm != null) {
/* 37:33 */       return rolePerm.getPerms();
/* 38:   */     }
/* 39:35 */     return null;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public Set<String> getPermsSet()
/* 43:   */   {
/* 44:39 */     Set<String> perms = new HashSet();
/* 45:40 */     RolePerm rolePerm = getRolePerm();
/* 46:41 */     if ((rolePerm != null) && 
/* 47:42 */       (rolePerm.getPerms() != null)) {
/* 48:43 */       for (String perm : rolePerm.getPerms().split(",")) {
/* 49:44 */         perms.add(perm);
/* 50:   */       }
/* 51:   */     }
/* 52:48 */     return perms;
/* 53:   */   }
/* 54:   */   
/* 55:   */   public Role() {}
/* 56:   */   
/* 57:   */   public Role(Integer id)
/* 58:   */   {
/* 59:60 */     super(id);
/* 60:   */   }
/* 61:   */   
/* 62:   */   public Role(Integer id, String name, Integer priority, Boolean allPerm)
/* 63:   */   {
/* 64:69 */     super(id, name, priority, allPerm);
/* 65:   */   }
/* 66:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.entity.Role
 * JD-Core Version:    0.7.0.1
 */