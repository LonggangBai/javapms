/*  1:   */ package com.portal.extrafunc.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.extrafunc.dao.MessageTypeDao;
/*  6:   */ import com.portal.extrafunc.entity.MessageType;
/*  7:   */ import java.util.List;
/*  8:   */ import org.apache.commons.lang.StringUtils;
/*  9:   */ import org.hibernate.Criteria;
/* 10:   */ import org.hibernate.Session;
/* 11:   */ import org.hibernate.criterion.Criterion;
/* 12:   */ import org.hibernate.criterion.Order;
/* 13:   */ import org.hibernate.criterion.Restrictions;
/* 14:   */ import org.springframework.stereotype.Repository;
/* 15:   */ 
/* 16:   */ @Repository
/* 17:   */ public class MessageTypeDaoImpl
/* 18:   */   extends HibernateBaseDao<MessageType, Integer>
/* 19:   */   implements MessageTypeDao
/* 20:   */ {
/* 21:   */   public Pagination getPage(int pageNo, int pageSize)
/* 22:   */   {
/* 23:20 */     Criteria crit = createCriteria(new Criterion[0]);
/* 24:21 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 25:22 */     return page;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public List<MessageType> getList(Integer siteId, String sortname, String sortorder)
/* 29:   */   {
/* 30:27 */     Criteria crit = createCriteria(new Criterion[0]);
/* 31:28 */     crit.add(Restrictions.eq("site.id", siteId));
/* 32:29 */     if (!StringUtils.isBlank(sortname))
/* 33:   */     {
/* 34:30 */       if ("asc".equals(sortorder)) {
/* 35:31 */         crit.addOrder(Order.asc(sortname));
/* 36:   */       } else {
/* 37:33 */         crit.addOrder(Order.desc(sortname));
/* 38:   */       }
/* 39:   */     }
/* 40:   */     else {
/* 41:36 */       crit.addOrder(Order.asc("priority"));
/* 42:   */     }
/* 43:38 */     return findByCriteria(crit);
/* 44:   */   }
/* 45:   */   
/* 46:   */   public MessageType getUniqueType(Integer siteId)
/* 47:   */   {
/* 48:42 */     Criteria crit = createCriteria(new Criterion[0]);
/* 49:43 */     crit.add(Restrictions.eq("site.id", siteId));
/* 50:44 */     crit.addOrder(Order.asc("priority"));
/* 51:45 */     return (MessageType)findUnique(crit);
/* 52:   */   }
/* 53:   */   
/* 54:   */   public MessageType findById(Integer id)
/* 55:   */   {
/* 56:49 */     MessageType entity = (MessageType)get(id);
/* 57:50 */     return entity;
/* 58:   */   }
/* 59:   */   
/* 60:   */   public MessageType save(MessageType bean)
/* 61:   */   {
/* 62:54 */     getSession().save(bean);
/* 63:55 */     return bean;
/* 64:   */   }
/* 65:   */   
/* 66:   */   public MessageType deleteById(Integer id)
/* 67:   */   {
/* 68:59 */     MessageType entity = (MessageType)super.get(id);
/* 69:60 */     if (entity != null) {
/* 70:61 */       getSession().delete(entity);
/* 71:   */     }
/* 72:63 */     return entity;
/* 73:   */   }
/* 74:   */   
/* 75:   */   protected Class<MessageType> getEntityClass()
/* 76:   */   {
/* 77:68 */     return MessageType.class;
/* 78:   */   }
/* 79:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.dao.impl.MessageTypeDaoImpl
 * JD-Core Version:    0.7.0.1
 */