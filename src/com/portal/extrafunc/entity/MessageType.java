/*  1:   */ package com.portal.extrafunc.entity;
/*  2:   */ 
/*  3:   */ import com.portal.extrafunc.entity.base.BaseMessageType;
/*  4:   */ import com.portal.sysmgr.entity.Site;
/*  5:   */ 
/*  6:   */ public class MessageType
/*  7:   */   extends BaseMessageType
/*  8:   */ {
/*  9:   */   private static final long serialVersionUID = 1L;
/* 10:   */   
/* 11:   */   public void init()
/* 12:   */   {
/* 13:11 */     if (getPriority() == null) {
/* 14:12 */       setPriority(Integer.valueOf(10));
/* 15:   */     }
/* 16:   */   }
/* 17:   */   
/* 18:   */   public MessageType() {}
/* 19:   */   
/* 20:   */   public MessageType(Integer id)
/* 21:   */   {
/* 22:25 */     super(id);
/* 23:   */   }
/* 24:   */   
/* 25:   */   public MessageType(Integer id, Site site, String name, Integer priority)
/* 26:   */   {
/* 27:41 */     super(id, site, name, priority);
/* 28:   */   }
/* 29:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.entity.MessageType
 * JD-Core Version:    0.7.0.1
 */