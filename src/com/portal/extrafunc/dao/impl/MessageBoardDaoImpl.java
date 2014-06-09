/*  1:   */ package com.portal.extrafunc.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.extrafunc.dao.MessageBoardDao;
/*  6:   */ import com.portal.extrafunc.entity.MessageBoard;
/*  7:   */ import org.apache.commons.lang.StringUtils;
/*  8:   */ import org.hibernate.Criteria;
/*  9:   */ import org.hibernate.Session;
/* 10:   */ import org.hibernate.criterion.Criterion;
/* 11:   */ import org.hibernate.criterion.Order;
/* 12:   */ import org.hibernate.criterion.Restrictions;
/* 13:   */ import org.springframework.stereotype.Repository;
/* 14:   */ 
/* 15:   */ @Repository
/* 16:   */ public class MessageBoardDaoImpl
/* 17:   */   extends HibernateBaseDao<MessageBoard, Integer>
/* 18:   */   implements MessageBoardDao
/* 19:   */ {
/* 20:   */   public Pagination getPage(String name, Integer siteId, Boolean show, String sortname, String sortorder, int pageNo, int pageSize)
/* 21:   */   {
/* 22:19 */     Criteria crit = createCriteria(new Criterion[0]);
/* 23:20 */     if (!StringUtils.isBlank(name)) {
/* 24:21 */       crit.add(Restrictions.like("title", "%" + name + "%"));
/* 25:   */     }
/* 26:23 */     if (show != null) {
/* 27:24 */       crit.add(Restrictions.eq("show", show));
/* 28:   */     }
/* 29:26 */     crit.add(Restrictions.eq("site.id", siteId));
/* 30:27 */     if (!StringUtils.isBlank(sortname))
/* 31:   */     {
/* 32:28 */       if ("asc".equals(sortorder)) {
/* 33:29 */         crit.addOrder(Order.asc(sortname));
/* 34:   */       } else {
/* 35:31 */         crit.addOrder(Order.desc(sortname));
/* 36:   */       }
/* 37:   */     }
/* 38:   */     else {
/* 39:34 */       crit.addOrder(Order.desc("createTime"));
/* 40:   */     }
/* 41:36 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 42:37 */     return page;
/* 43:   */   }
/* 44:   */   
/* 45:   */   public MessageBoard findById(Integer id)
/* 46:   */   {
/* 47:41 */     MessageBoard entity = (MessageBoard)get(id);
/* 48:42 */     return entity;
/* 49:   */   }
/* 50:   */   
/* 51:   */   public MessageBoard save(MessageBoard bean)
/* 52:   */   {
/* 53:46 */     getSession().save(bean);
/* 54:47 */     return bean;
/* 55:   */   }
/* 56:   */   
/* 57:   */   public MessageBoard deleteById(Integer id)
/* 58:   */   {
/* 59:51 */     MessageBoard entity = (MessageBoard)super.get(id);
/* 60:52 */     if (entity != null) {
/* 61:53 */       getSession().delete(entity);
/* 62:   */     }
/* 63:55 */     return entity;
/* 64:   */   }
/* 65:   */   
/* 66:   */   protected Class<MessageBoard> getEntityClass()
/* 67:   */   {
/* 68:60 */     return MessageBoard.class;
/* 69:   */   }
/* 70:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.dao.impl.MessageBoardDaoImpl
 * JD-Core Version:    0.7.0.1
 */