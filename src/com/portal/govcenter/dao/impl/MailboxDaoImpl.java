/*  1:   */ package com.portal.govcenter.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.govcenter.dao.MailboxDao;
/*  6:   */ import com.portal.govcenter.entity.Mailbox;
/*  7:   */ import org.apache.commons.lang.StringUtils;
/*  8:   */ import org.hibernate.Criteria;
/*  9:   */ import org.hibernate.Session;
/* 10:   */ import org.hibernate.criterion.Criterion;
/* 11:   */ import org.hibernate.criterion.Restrictions;
/* 12:   */ import org.springframework.stereotype.Repository;
/* 13:   */ 
/* 14:   */ @Repository
/* 15:   */ public class MailboxDaoImpl
/* 16:   */   extends HibernateBaseDao<Mailbox, Integer>
/* 17:   */   implements MailboxDao
/* 18:   */ {
/* 19:   */   public Pagination getPage(String name, Integer siteId, Integer departId, Integer typeId, int pageNo, int pageSize)
/* 20:   */   {
/* 21:18 */     Criteria crit = createCriteria(new Criterion[0]);
/* 22:19 */     if (!StringUtils.isBlank(name)) {
/* 23:20 */       crit.add(Restrictions.like("title", "%" + name + "%"));
/* 24:   */     }
/* 25:22 */     crit.add(Restrictions.eq("site.id", siteId));
/* 26:23 */     if (typeId != null) {
/* 27:24 */       crit.add(Restrictions.eq("type.id", typeId));
/* 28:   */     }
/* 29:26 */     if (departId != null)
/* 30:   */     {
/* 31:27 */       crit.add(Restrictions.eq("depart.id", departId));
/* 32:28 */       crit.add(Restrictions.ne("status", Mailbox.DELETED));
/* 33:   */     }
/* 34:   */     else
/* 35:   */     {
/* 36:30 */       crit.add(Restrictions.ne("status", Mailbox.DELETED));
/* 37:31 */       crit.add(Restrictions.ne("status", Mailbox.FORWARD));
/* 38:   */     }
/* 39:33 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 40:34 */     return page;
/* 41:   */   }
/* 42:   */   
/* 43:   */   public Mailbox findById(Integer id)
/* 44:   */   {
/* 45:38 */     Mailbox entity = (Mailbox)get(id);
/* 46:39 */     return entity;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public Mailbox save(Mailbox bean)
/* 50:   */   {
/* 51:43 */     getSession().save(bean);
/* 52:44 */     return bean;
/* 53:   */   }
/* 54:   */   
/* 55:   */   public Mailbox deleteById(Integer id)
/* 56:   */   {
/* 57:48 */     Mailbox entity = (Mailbox)super.get(id);
/* 58:49 */     if (entity != null) {
/* 59:50 */       getSession().delete(entity);
/* 60:   */     }
/* 61:52 */     return entity;
/* 62:   */   }
/* 63:   */   
/* 64:   */   protected Class<Mailbox> getEntityClass()
/* 65:   */   {
/* 66:57 */     return Mailbox.class;
/* 67:   */   }
/* 68:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.govcenter.dao.impl.MailboxDaoImpl
 * JD-Core Version:    0.7.0.1
 */