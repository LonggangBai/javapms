/*  1:   */ package com.portal.datacenter.operatedata.entity;
/*  2:   */ 
/*  3:   */ import com.portal.datacenter.operatedata.entity.base.BaseLog;
/*  4:   */ import java.util.Date;
/*  5:   */ 
/*  6:   */ public class Log
/*  7:   */   extends BaseLog
/*  8:   */ {
/*  9:   */   private static final long serialVersionUID = 1L;
/* 10:   */   public static final int LOGIN_SUCCESS = 1;
/* 11:   */   public static final int LOGIN_FAILURE = 2;
/* 12:   */   public static final int OPERATING = 3;
/* 13:   */   
/* 14:   */   public Log() {}
/* 15:   */   
/* 16:   */   public Log(Integer id)
/* 17:   */   {
/* 18:20 */     super(id);
/* 19:   */   }
/* 20:   */   
/* 21:   */   public Log(Integer id, Integer category, Date time)
/* 22:   */   {
/* 23:34 */     super(id, category, time);
/* 24:   */   }
/* 25:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.operatedata.entity.Log
 * JD-Core Version:    0.7.0.1
 */