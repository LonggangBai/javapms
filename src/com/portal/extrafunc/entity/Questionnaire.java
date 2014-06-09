/*  1:   */ package com.portal.extrafunc.entity;
/*  2:   */ 
/*  3:   */ import com.portal.extrafunc.entity.base.BaseQuestionnaire;
/*  4:   */ import com.portal.sysmgr.entity.Site;
/*  5:   */ import java.sql.Timestamp;
/*  6:   */ import java.util.Date;
/*  7:   */ 
/*  8:   */ public class Questionnaire
/*  9:   */   extends BaseQuestionnaire
/* 10:   */ {
/* 11:   */   private static final long serialVersionUID = 1L;
/* 12:   */   
/* 13:   */   public void init()
/* 14:   */   {
/* 15:11 */     if (getRepeateTime() == null) {
/* 16:12 */       setRepeateTime(Integer.valueOf(9999999));
/* 17:   */     }
/* 18:14 */     if (getCreateTime() == null) {
/* 19:15 */       setCreateTime(new Timestamp(System.currentTimeMillis()));
/* 20:   */     }
/* 21:17 */     if (getStartTime() == null) {
/* 22:18 */       setStartTime(new Timestamp(System.currentTimeMillis()));
/* 23:   */     }
/* 24:20 */     if (getRestrictIp() == null) {
/* 25:21 */       setRestrictIp(Boolean.valueOf(false));
/* 26:   */     }
/* 27:23 */     if (getNeedLogin() == null) {
/* 28:24 */       setNeedLogin(Boolean.valueOf(false));
/* 29:   */     }
/* 30:26 */     if (getEnable() == null) {
/* 31:27 */       setEnable(Boolean.valueOf(false));
/* 32:   */     }
/* 33:   */   }
/* 34:   */   
/* 35:   */   public void updateinit()
/* 36:   */   {
/* 37:32 */     if (getRepeateTime() == null) {
/* 38:33 */       setRepeateTime(Integer.valueOf(0));
/* 39:   */     }
/* 40:35 */     if (getRestrictIp() == null) {
/* 41:36 */       setRestrictIp(Boolean.valueOf(false));
/* 42:   */     }
/* 43:38 */     if (getNeedLogin() == null) {
/* 44:39 */       setNeedLogin(Boolean.valueOf(false));
/* 45:   */     }
/* 46:41 */     if (getEnable() == null) {
/* 47:42 */       setEnable(Boolean.valueOf(false));
/* 48:   */     }
/* 49:   */   }
/* 50:   */   
/* 51:   */   public Questionnaire() {}
/* 52:   */   
/* 53:   */   public Questionnaire(Integer id)
/* 54:   */   {
/* 55:55 */     super(id);
/* 56:   */   }
/* 57:   */   
/* 58:   */   public Questionnaire(Integer id, Site site, String name, Integer repeateTime, Boolean restrictIp, Boolean needLogin, Date createTime, Date startTime, Boolean enable)
/* 59:   */   {
/* 60:68 */     super(id, site, name, repeateTime, restrictIp, needLogin, createTime, startTime, enable);
/* 61:   */   }
/* 62:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.entity.Questionnaire
 * JD-Core Version:    0.7.0.1
 */