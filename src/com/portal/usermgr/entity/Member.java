/*  1:   */ package com.portal.usermgr.entity;
/*  2:   */ 
/*  3:   */ import com.portal.sysmgr.entity.Site;
/*  4:   */ import com.portal.usermgr.entity.base.BaseMember;
/*  5:   */ import java.sql.Timestamp;
/*  6:   */ import java.util.Date;
/*  7:   */ import java.util.HashSet;
/*  8:   */ import java.util.Set;
/*  9:   */ 
/* 10:   */ public class Member
/* 11:   */   extends BaseMember
/* 12:   */ {
/* 13:   */   private static final long serialVersionUID = 1L;
/* 14:   */   
/* 15:   */   public void init()
/* 16:   */   {
/* 17:13 */     if (getRegisterTime() == null) {
/* 18:14 */       setRegisterTime(new Timestamp(System.currentTimeMillis()));
/* 19:   */     }
/* 20:16 */     if (getLastLoginTime() == null) {
/* 21:17 */       setLastLoginTime(new Timestamp(System.currentTimeMillis()));
/* 22:   */     }
/* 23:19 */     if (getLoginCount() == null) {
/* 24:20 */       setLoginCount(Integer.valueOf(1));
/* 25:   */     }
/* 26:22 */     if (getStatus() == null) {
/* 27:23 */       setStatus(Byte.valueOf((byte)0));
/* 28:   */     }
/* 29:   */   }
/* 30:   */   
/* 31:   */   public Group getGroup(Integer siteId)
/* 32:   */   {
/* 33:28 */     for (Group group : getGroups()) {
/* 34:29 */       if (group.getSite().getId().equals(siteId)) {
/* 35:30 */         return group;
/* 36:   */       }
/* 37:   */     }
/* 38:33 */     return null;
/* 39:   */   }
/* 40:   */   
/* 41:   */   public Group getGroup()
/* 42:   */   {
/* 43:37 */     return getGroup(Integer.valueOf(1));
/* 44:   */   }
/* 45:   */   
/* 46:   */   public Set<String> getPerms(Integer siteId)
/* 47:   */   {
/* 48:41 */     Group group = getGroup(siteId);
/* 49:42 */     if (group == null) {
/* 50:43 */       return null;
/* 51:   */     }
/* 52:45 */     Set<String> perms = new HashSet();
/* 53:46 */     if (group.getPerms() != null) {
/* 54:47 */       for (String perm : group.getPerms().split(",")) {
/* 55:48 */         perms.add(perm);
/* 56:   */       }
/* 57:   */     }
/* 58:51 */     return perms;
/* 59:   */   }
/* 60:   */   
/* 61:   */   public void addToGroups(Group group)
/* 62:   */   {
/* 63:55 */     if (group == null) {
/* 64:56 */       return;
/* 65:   */     }
/* 66:58 */     Set<Group> set = getGroups();
/* 67:59 */     if (set == null)
/* 68:   */     {
/* 69:60 */       set = new HashSet();
/* 70:61 */       setGroups(set);
/* 71:   */     }
/* 72:63 */     set.add(group);
/* 73:   */   }
/* 74:   */   
/* 75:   */   public String getStatusString()
/* 76:   */   {
/* 77:67 */     if (getStatus().equals(Byte.valueOf((byte)0))) {
/* 78:68 */       return "<span style='color:blue'>正常</span>";
/* 79:   */     }
/* 80:70 */     return "<span style='color:red'>禁用</span>";
/* 81:   */   }
/* 82:   */   
/* 83:   */   public Member() {}
/* 84:   */   
/* 85:   */   public Member(Integer id)
/* 86:   */   {
/* 87:83 */     super(id);
/* 88:   */   }
/* 89:   */   
/* 90:   */   public Member(Integer id, Date registerTime, String registerIp, Integer loginCount, Byte status)
/* 91:   */   {
/* 92:93 */     super(id, registerTime, registerIp, loginCount, status);
/* 93:   */   }
/* 94:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.entity.Member
 * JD-Core Version:    0.7.0.1
 */