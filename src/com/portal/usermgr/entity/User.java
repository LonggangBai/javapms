/*  1:   */ package com.portal.usermgr.entity;
/*  2:   */ 
/*  3:   */ import com.portal.usermgr.entity.base.BaseUser;
/*  4:   */ import java.util.Collection;
/*  5:   */ import java.util.Date;
/*  6:   */ 
/*  7:   */ public class User
/*  8:   */   extends BaseUser
/*  9:   */ {
/* 10:   */   private static final long serialVersionUID = 1L;
/* 11:   */   public static final byte NORMAL = 0;
/* 12:   */   public static final byte DISABLED = -1;
/* 13:   */   
/* 14:   */   public void init()
/* 15:   */   {
/* 16:21 */     if (getStatus() == null) {
/* 17:22 */       setStatus(Byte.valueOf((byte)0));
/* 18:   */     }
/* 19:   */   }
/* 20:   */   
/* 21:   */   public static Integer[] fetchIds(Collection<User> users)
/* 22:   */   {
/* 23:27 */     if (users == null) {
/* 24:28 */       return null;
/* 25:   */     }
/* 26:30 */     Integer[] ids = new Integer[users.size()];
/* 27:31 */     int i = 0;
/* 28:32 */     for (User u : users) {
/* 29:33 */       ids[(i++)] = u.getId();
/* 30:   */     }
/* 31:35 */     return ids;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public static boolean isToday(Date date)
/* 35:   */   {
/* 36:45 */     long day = date.getTime() / 1000L / 60L / 60L / 24L;
/* 37:46 */     long currentDay = System.currentTimeMillis() / 1000L / 60L / 60L / 24L;
/* 38:47 */     return day == currentDay;
/* 39:   */   }
/* 40:   */   
/* 41:   */   public User() {}
/* 42:   */   
/* 43:   */   public User(Integer id)
/* 44:   */   {
/* 45:59 */     super(id);
/* 46:   */   }
/* 47:   */   
/* 48:   */   public User(Integer id, String username, Byte status)
/* 49:   */   {
/* 50:68 */     super(id, username, status);
/* 51:   */   }
/* 52:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.entity.User
 * JD-Core Version:    0.7.0.1
 */