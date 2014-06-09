/*  1:   */ package com.portal.extrafunc.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.extrafunc.dao.CategoryDao;
/*  6:   */ import com.portal.extrafunc.entity.Category;
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
/* 17:   */ public class CategoryDaoImpl
/* 18:   */   extends HibernateBaseDao<Category, Integer>
/* 19:   */   implements CategoryDao
/* 20:   */ {
/* 21:   */   public Pagination getPage(String sortname, String sortorder, int pageNo, int pageSize)
/* 22:   */   {
/* 23:21 */     Criteria crit = createCriteria(new Criterion[0]);
/* 24:22 */     if (!StringUtils.isBlank(sortname))
/* 25:   */     {
/* 26:23 */       if ("asc".equals(sortorder)) {
/* 27:24 */         crit.addOrder(Order.asc(sortname));
/* 28:   */       } else {
/* 29:26 */         crit.addOrder(Order.desc(sortname));
/* 30:   */       }
/* 31:   */     }
/* 32:   */     else {
/* 33:29 */       crit.addOrder(Order.asc("priority"));
/* 34:   */     }
/* 35:31 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 36:32 */     return page;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public List<Category> getList(Integer siteId, String sortname, String sortorder)
/* 40:   */   {
/* 41:37 */     Criteria crit = createCriteria(new Criterion[0]);
/* 42:38 */     crit.add(Restrictions.eq("site.id", siteId));
/* 43:39 */     if (!StringUtils.isBlank(sortname))
/* 44:   */     {
/* 45:40 */       if ("asc".equals(sortorder)) {
/* 46:41 */         crit.addOrder(Order.asc(sortname));
/* 47:   */       } else {
/* 48:43 */         crit.addOrder(Order.desc(sortname));
/* 49:   */       }
/* 50:   */     }
/* 51:   */     else {
/* 52:46 */       crit.addOrder(Order.asc("priority"));
/* 53:   */     }
/* 54:48 */     return findByCriteria(crit);
/* 55:   */   }
/* 56:   */   
/* 57:   */   public Category findById(Integer id)
/* 58:   */   {
/* 59:52 */     Category entity = (Category)get(id);
/* 60:53 */     return entity;
/* 61:   */   }
/* 62:   */   
/* 63:   */   public Category save(Category bean)
/* 64:   */   {
/* 65:57 */     getSession().save(bean);
/* 66:58 */     return bean;
/* 67:   */   }
/* 68:   */   
/* 69:   */   public Category deleteById(Integer id)
/* 70:   */   {
/* 71:62 */     Category entity = (Category)super.get(id);
/* 72:63 */     if (entity != null) {
/* 73:64 */       getSession().delete(entity);
/* 74:   */     }
/* 75:66 */     return entity;
/* 76:   */   }
/* 77:   */   
/* 78:   */   protected Class<Category> getEntityClass()
/* 79:   */   {
/* 80:71 */     return Category.class;
/* 81:   */   }
/* 82:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.dao.impl.CategoryDaoImpl
 * JD-Core Version:    0.7.0.1
 */