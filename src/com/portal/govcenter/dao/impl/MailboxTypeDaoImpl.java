/*  1:   */ package com.portal.govcenter.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.govcenter.dao.MailboxTypeDao;
/*  6:   */ import com.portal.govcenter.entity.MailboxType;
/*  7:   */ import java.util.List;
/*  8:   */ import org.hibernate.Criteria;
/*  9:   */ import org.hibernate.Session;
/* 10:   */ import org.hibernate.criterion.Criterion;
/* 11:   */ import org.hibernate.criterion.Order;
/* 12:   */ import org.hibernate.criterion.Restrictions;
/* 13:   */ import org.springframework.stereotype.Repository;
/* 14:   */ 
/* 15:   */ @Repository
/* 16:   */ public class MailboxTypeDaoImpl
/* 17:   */   extends HibernateBaseDao<MailboxType, Integer>
/* 18:   */   implements MailboxTypeDao
/* 19:   */ {
/* 20:   */   public Pagination getPage(int pageNo, int pageSize)
/* 21:   */   {
/* 22:19 */     Criteria crit = createCriteria(new Criterion[0]);
/* 23:20 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 24:21 */     return page;
/* 25:   */   }
/* 26:   */   
/* 27:   */   public List<MailboxType> getList(Integer siteId)
/* 28:   */   {
/* 29:25 */     Criteria crit = createCriteria(new Criterion[0]);
/* 30:26 */     crit.add(Restrictions.eq("site.id", siteId));
/* 31:27 */     crit.addOrder(Order.asc("priority"));
/* 32:28 */     return findByCriteria(crit);
/* 33:   */   }
/* 34:   */   
/* 35:   */   public MailboxType findById(Integer id)
/* 36:   */   {
/* 37:32 */     MailboxType entity = (MailboxType)get(id);
/* 38:33 */     return entity;
/* 39:   */   }
/* 40:   */   
/* 41:   */   public MailboxType save(MailboxType bean)
/* 42:   */   {
/* 43:37 */     getSession().save(bean);
/* 44:38 */     return bean;
/* 45:   */   }
/* 46:   */   
/* 47:   */   public MailboxType deleteById(Integer id)
/* 48:   */   {
/* 49:42 */     MailboxType entity = (MailboxType)super.get(id);
/* 50:43 */     if (entity != null) {
/* 51:44 */       getSession().delete(entity);
/* 52:   */     }
/* 53:46 */     return entity;
/* 54:   */   }
/* 55:   */   
/* 56:   */   protected Class<MailboxType> getEntityClass()
/* 57:   */   {
/* 58:51 */     return MailboxType.class;
/* 59:   */   }
/* 60:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.govcenter.dao.impl.MailboxTypeDaoImpl
 * JD-Core Version:    0.7.0.1
 */