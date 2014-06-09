/*  1:   */ package com.portal.extrafunc.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.extrafunc.dao.AdvertSlotDao;
/*  6:   */ import com.portal.extrafunc.entity.AdvertSlot;
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
/* 17:   */ public class AdvertSlotDaoImpl
/* 18:   */   extends HibernateBaseDao<AdvertSlot, Integer>
/* 19:   */   implements AdvertSlotDao
/* 20:   */ {
/* 21:   */   public Pagination getPage(Integer siteId, String sortname, String sortorder, int pageNo, int pageSize)
/* 22:   */   {
/* 23:21 */     Criteria crit = createCriteria(new Criterion[0]);
/* 24:22 */     crit.add(Restrictions.eq("site.id", siteId));
/* 25:23 */     if (!StringUtils.isBlank(sortname))
/* 26:   */     {
/* 27:24 */       if ("asc".equals(sortorder)) {
/* 28:25 */         crit.addOrder(Order.asc(sortname));
/* 29:   */       } else {
/* 30:27 */         crit.addOrder(Order.desc(sortname));
/* 31:   */       }
/* 32:   */     }
/* 33:   */     else {
/* 34:30 */       crit.addOrder(Order.asc("id"));
/* 35:   */     }
/* 36:32 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 37:33 */     return page;
/* 38:   */   }
/* 39:   */   
/* 40:   */   public List<AdvertSlot> getList(Integer siteId)
/* 41:   */   {
/* 42:37 */     Criteria crit = createCriteria(new Criterion[0]);
/* 43:38 */     crit.add(Restrictions.eq("site.id", siteId));
/* 44:39 */     return findByCriteria(crit);
/* 45:   */   }
/* 46:   */   
/* 47:   */   public AdvertSlot findById(Integer id)
/* 48:   */   {
/* 49:43 */     AdvertSlot entity = (AdvertSlot)get(id);
/* 50:44 */     return entity;
/* 51:   */   }
/* 52:   */   
/* 53:   */   public AdvertSlot save(AdvertSlot bean)
/* 54:   */   {
/* 55:48 */     getSession().save(bean);
/* 56:49 */     return bean;
/* 57:   */   }
/* 58:   */   
/* 59:   */   public AdvertSlot deleteById(Integer id)
/* 60:   */   {
/* 61:53 */     AdvertSlot entity = (AdvertSlot)super.get(id);
/* 62:54 */     if (entity != null) {
/* 63:55 */       getSession().delete(entity);
/* 64:   */     }
/* 65:57 */     return entity;
/* 66:   */   }
/* 67:   */   
/* 68:   */   protected Class<AdvertSlot> getEntityClass()
/* 69:   */   {
/* 70:62 */     return AdvertSlot.class;
/* 71:   */   }
/* 72:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.dao.impl.AdvertSlotDaoImpl
 * JD-Core Version:    0.7.0.1
 */