/*  1:   */ package com.portal.doccenter.entity;
/*  2:   */ 
/*  3:   */ import com.portal.doccenter.entity.base.BaseFlowDetail;
/*  4:   */ import com.portal.usermgr.entity.Role;
/*  5:   */ import com.portal.usermgr.entity.User;
/*  6:   */ import java.sql.Timestamp;
/*  7:   */ import java.util.Date;
/*  8:   */ 
/*  9:   */ public class FlowDetail
/* 10:   */   extends BaseFlowDetail
/* 11:   */ {
/* 12:   */   private static final long serialVersionUID = 1L;
/* 13:   */   
/* 14:   */   public void init()
/* 15:   */   {
/* 16:11 */     if (getBackInitial() == null) {
/* 17:12 */       setBackInitial(Boolean.valueOf(false));
/* 18:   */     }
/* 19:14 */     if (getChecked() == null) {
/* 20:15 */       setChecked(Boolean.valueOf(true));
/* 21:   */     }
/* 22:17 */     if (getPriority() == null) {
/* 23:18 */       setPriority(Integer.valueOf(1));
/* 24:   */     }
/* 25:20 */     if (getCreateTime() == null) {
/* 26:21 */       setCreateTime(new Timestamp(System.currentTimeMillis()));
/* 27:   */     }
/* 28:   */   }
/* 29:   */   
/* 30:   */   public FlowDetail() {}
/* 31:   */   
/* 32:   */   public FlowDetail(Integer id)
/* 33:   */   {
/* 34:34 */     super(id);
/* 35:   */   }
/* 36:   */   
/* 37:   */   public FlowDetail(Integer id, Article doc, User user, Role role, Boolean backInitial, Boolean checked, Integer priority, Date createTime)
/* 38:   */   {
/* 39:47 */     super(id, doc, user, role, backInitial, checked, priority, createTime);
/* 40:   */   }
/* 41:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.entity.FlowDetail
 * JD-Core Version:    0.7.0.1
 */