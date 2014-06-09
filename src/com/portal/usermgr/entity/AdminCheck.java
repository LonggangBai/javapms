/*  1:   */ package com.portal.usermgr.entity;
/*  2:   */ 
/*  3:   */ import com.portal.sysmgr.entity.Site;
/*  4:   */ import com.portal.usermgr.entity.base.BaseAdminCheck;
/*  5:   */ 
/*  6:   */ public class AdminCheck
/*  7:   */   extends BaseAdminCheck
/*  8:   */ {
/*  9:   */   private static final long serialVersionUID = 1L;
/* 10:   */   public static final byte READ_ONLY = 0;
/* 11:   */   public static final byte MANAGE_SELF = 1;
/* 12:   */   public static final byte MANAGE_CHECK = 2;
/* 13:   */   public static final byte MANAGE_DEPART = 3;
/* 14:   */   public static final byte MANAGE_ALL = 4;
/* 15:   */   
/* 16:   */   public AdminCheck() {}
/* 17:   */   
/* 18:   */   public AdminCheck(Integer id)
/* 19:   */   {
/* 20:38 */     super(id);
/* 21:   */   }
/* 22:   */   
/* 23:   */   public AdminCheck(Integer id, Admin admin, Site site, Byte manageStatus)
/* 24:   */   {
/* 25:54 */     super(id, admin, site, manageStatus);
/* 26:   */   }
/* 27:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.entity.AdminCheck
 * JD-Core Version:    0.7.0.1
 */