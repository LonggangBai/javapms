/*  1:   */ package com.portal.extrafunc.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.extrafunc.dao.MessageBoardExtDao;
/*  6:   */ import com.portal.extrafunc.entity.MessageBoardExt;
/*  7:   */ import org.hibernate.Criteria;
/*  8:   */ import org.hibernate.Session;
/*  9:   */ import org.hibernate.criterion.Criterion;
/* 10:   */ import org.springframework.stereotype.Repository;
/* 11:   */ 
/* 12:   */ @Repository
/* 13:   */ public class MessageBoardExtDaoImpl
/* 14:   */   extends HibernateBaseDao<MessageBoardExt, Integer>
/* 15:   */   implements MessageBoardExtDao
/* 16:   */ {
/* 17:   */   public Pagination getPage(int pageNo, int pageSize)
/* 18:   */   {
/* 19:16 */     Criteria crit = createCriteria(new Criterion[0]);
/* 20:17 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 21:18 */     return page;
/* 22:   */   }
/* 23:   */   
/* 24:   */   public MessageBoardExt findById(Integer id)
/* 25:   */   {
/* 26:22 */     MessageBoardExt entity = (MessageBoardExt)get(id);
/* 27:23 */     return entity;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public MessageBoardExt save(MessageBoardExt bean)
/* 31:   */   {
/* 32:27 */     getSession().save(bean);
/* 33:28 */     return bean;
/* 34:   */   }
/* 35:   */   
/* 36:   */   public MessageBoardExt deleteById(Integer id)
/* 37:   */   {
/* 38:32 */     MessageBoardExt entity = (MessageBoardExt)super.get(id);
/* 39:33 */     if (entity != null) {
/* 40:34 */       getSession().delete(entity);
/* 41:   */     }
/* 42:36 */     return entity;
/* 43:   */   }
/* 44:   */   
/* 45:   */   protected Class<MessageBoardExt> getEntityClass()
/* 46:   */   {
/* 47:41 */     return MessageBoardExt.class;
/* 48:   */   }
/* 49:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.dao.impl.MessageBoardExtDaoImpl
 * JD-Core Version:    0.7.0.1
 */