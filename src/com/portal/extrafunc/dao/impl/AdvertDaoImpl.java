/*  1:   */ package com.portal.extrafunc.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.extrafunc.dao.AdvertDao;
/*  6:   */ import com.portal.extrafunc.entity.Advert;
/*  7:   */ import java.util.Date;
/*  8:   */ import java.util.List;
/*  9:   */ import org.apache.commons.lang.StringUtils;
/* 10:   */ import org.hibernate.Criteria;
/* 11:   */ import org.hibernate.Session;
/* 12:   */ import org.hibernate.criterion.Criterion;
/* 13:   */ import org.hibernate.criterion.Order;
/* 14:   */ import org.hibernate.criterion.Restrictions;
/* 15:   */ import org.springframework.stereotype.Repository;
/* 16:   */ 
/* 17:   */ @Repository
/* 18:   */ public class AdvertDaoImpl
/* 19:   */   extends HibernateBaseDao<Advert, Integer>
/* 20:   */   implements AdvertDao
/* 21:   */ {
/* 22:   */   public Pagination getPage(Integer siteId, Integer slotId, String sortname, String sortorder, int pageNo, int pageSize)
/* 23:   */   {
/* 24:22 */     Criteria crit = createCriteria(new Criterion[0]);
/* 25:23 */     crit.add(Restrictions.eq("site.id", siteId));
/* 26:24 */     if (slotId != null) {
/* 27:25 */       crit.add(Restrictions.eq("slot.id", slotId));
/* 28:   */     }
/* 29:27 */     if (!StringUtils.isBlank(sortname))
/* 30:   */     {
/* 31:28 */       if ("asc".equals(sortorder)) {
/* 32:29 */         crit.addOrder(Order.asc(sortname));
/* 33:   */       } else {
/* 34:31 */         crit.addOrder(Order.desc(sortname));
/* 35:   */       }
/* 36:   */     }
/* 37:   */     else {
/* 38:34 */       crit.addOrder(Order.asc("priority"));
/* 39:   */     }
/* 40:36 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 41:37 */     return page;
/* 42:   */   }
/* 43:   */   
/* 44:   */   public List<Advert> getListByTag(Integer siteId, Integer slotId)
/* 45:   */   {
/* 46:41 */     Criteria crit = createCriteria(new Criterion[0]);
/* 47:42 */     crit.add(Restrictions.eq("site.id", siteId));
/* 48:43 */     if (slotId != null) {
/* 49:44 */       crit.add(Restrictions.eq("slot.id", slotId));
/* 50:   */     }
/* 51:46 */     crit.add(Restrictions.eq("enable", Boolean.valueOf(true)));
/* 52:47 */     crit.add(Restrictions.le("startTime", new Date()));
/* 53:48 */     crit.add(Restrictions.or(Restrictions.isNull("endTime"), 
/* 54:49 */       Restrictions.ge("endTime", new Date())));
/* 55:50 */     crit.addOrder(Order.asc("priority"));
/* 56:51 */     return findByCriteria(crit);
/* 57:   */   }
/* 58:   */   
/* 59:   */   public Advert findById(Integer id)
/* 60:   */   {
/* 61:55 */     Advert entity = (Advert)get(id);
/* 62:56 */     return entity;
/* 63:   */   }
/* 64:   */   
/* 65:   */   public Advert save(Advert bean)
/* 66:   */   {
/* 67:60 */     getSession().save(bean);
/* 68:61 */     return bean;
/* 69:   */   }
/* 70:   */   
/* 71:   */   public Advert deleteById(Integer id)
/* 72:   */   {
/* 73:65 */     Advert entity = (Advert)super.get(id);
/* 74:66 */     if (entity != null) {
/* 75:67 */       getSession().delete(entity);
/* 76:   */     }
/* 77:69 */     return entity;
/* 78:   */   }
/* 79:   */   
/* 80:   */   protected Class<Advert> getEntityClass()
/* 81:   */   {
/* 82:74 */     return Advert.class;
/* 83:   */   }
/* 84:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.dao.impl.AdvertDaoImpl
 * JD-Core Version:    0.7.0.1
 */