/*  1:   */ package com.portal.usermgr.entity;
/*  2:   */ 
/*  3:   */ import com.portal.usermgr.entity.base.BaseGroup;
/*  4:   */ import java.util.Collection;
/*  5:   */ 
/*  6:   */ public class Group
/*  7:   */   extends BaseGroup
/*  8:   */ {
/*  9:   */   private static final long serialVersionUID = 1L;
/* 10:   */   
/* 11:   */   public void init()
/* 12:   */   {
/* 13:11 */     if (getPriority() == null) {
/* 14:12 */       setPriority(Integer.valueOf(10));
/* 15:   */     }
/* 16:14 */     if (getRegistShow() == null) {
/* 17:15 */       setRegistShow(Boolean.valueOf(true));
/* 18:   */     }
/* 19:   */   }
/* 20:   */   
/* 21:   */   public static Integer[] fetchIds(Collection<Group> groups)
/* 22:   */   {
/* 23:26 */     Integer[] ids = new Integer[groups.size()];
/* 24:27 */     int i = 0;
/* 25:28 */     for (Group g : groups) {
/* 26:29 */       ids[(i++)] = g.getId();
/* 27:   */     }
/* 28:31 */     return ids;
/* 29:   */   }
/* 30:   */   
/* 31:   */   public String getPerms()
/* 32:   */   {
/* 33:35 */     GroupPerm groupPerm = getGroupPerm();
/* 34:36 */     if (groupPerm != null) {
/* 35:37 */       return groupPerm.getPerms();
/* 36:   */     }
/* 37:39 */     return null;
/* 38:   */   }
/* 39:   */   
/* 40:   */   public Group() {}
/* 41:   */   
/* 42:   */   public Group(Integer id)
/* 43:   */   {
/* 44:51 */     super(id);
/* 45:   */   }
/* 46:   */   
/* 47:   */   public Group(Integer id, String name, Integer priority, Boolean allPerm, Boolean registShow)
/* 48:   */   {
/* 49:61 */     super(id, name, priority, allPerm, registShow);
/* 50:   */   }
/* 51:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.entity.Group
 * JD-Core Version:    0.7.0.1
 */