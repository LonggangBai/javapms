/*  1:   */ package com.portal.extrafunc.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.extrafunc.dao.ForumDao;
/*  6:   */ import com.portal.extrafunc.entity.Forum;
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
/* 17:   */ public class ForumDaoImpl
/* 18:   */   extends HibernateBaseDao<Forum, Integer>
/* 19:   */   implements ForumDao
/* 20:   */ {
/* 21:   */   public Pagination getPage(Integer siteId, Integer categoryId, String sortname, String sortorder, int pageNo, int pageSize)
/* 22:   */   {
/* 23:21 */     Criteria crit = createCriteria(new Criterion[0]);
/* 24:22 */     if (siteId != null) {
/* 25:23 */       crit.add(Restrictions.eq("site.id", siteId));
/* 26:   */     }
/* 27:25 */     if (categoryId != null) {
/* 28:26 */       crit.add(Restrictions.eq("category.id", categoryId));
/* 29:   */     }
/* 30:28 */     if (!StringUtils.isBlank(sortname))
/* 31:   */     {
/* 32:29 */       if ("asc".equals(sortorder)) {
/* 33:30 */         crit.addOrder(Order.asc(sortname));
/* 34:   */       } else {
/* 35:32 */         crit.addOrder(Order.desc(sortname));
/* 36:   */       }
/* 37:   */     }
/* 38:   */     else {
/* 39:35 */       crit.addOrder(Order.asc("priority"));
/* 40:   */     }
/* 41:37 */     return findByCriteria(crit, pageNo, pageSize);
/* 42:   */   }
/* 43:   */   
/* 44:   */   public List<Forum> getList(Integer categoryId)
/* 45:   */   {
/* 46:41 */     Criteria crit = createCriteria(new Criterion[0]);
/* 47:42 */     if (categoryId != null) {
/* 48:43 */       crit.add(Restrictions.eq("category.id", categoryId));
/* 49:   */     }
/* 50:45 */     crit.addOrder(Order.asc("priority"));
/* 51:46 */     return findByCriteria(crit);
/* 52:   */   }
/* 53:   */   
/* 54:   */   public List<Forum> getList()
/* 55:   */   {
/* 56:50 */     Criteria crit = createCriteria(new Criterion[0]);
/* 57:51 */     crit.addOrder(Order.asc("priority"));
/* 58:52 */     return findByCriteria(crit);
/* 59:   */   }
/* 60:   */   
/* 61:   */   public Forum findById(Integer id)
/* 62:   */   {
/* 63:56 */     Forum entity = (Forum)get(id);
/* 64:57 */     return entity;
/* 65:   */   }
/* 66:   */   
/* 67:   */   public Forum save(Forum bean)
/* 68:   */   {
/* 69:61 */     getSession().save(bean);
/* 70:62 */     return bean;
/* 71:   */   }
/* 72:   */   
/* 73:   */   public Forum deleteById(Integer id)
/* 74:   */   {
/* 75:66 */     Forum entity = (Forum)super.get(id);
/* 76:67 */     if (entity != null) {
/* 77:68 */       getSession().delete(entity);
/* 78:   */     }
/* 79:70 */     return entity;
/* 80:   */   }
/* 81:   */   
/* 82:   */   protected Class<Forum> getEntityClass()
/* 83:   */   {
/* 84:75 */     return Forum.class;
/* 85:   */   }
/* 86:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.dao.impl.ForumDaoImpl
 * JD-Core Version:    0.7.0.1
 */