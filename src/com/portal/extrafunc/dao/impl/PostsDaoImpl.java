/*  1:   */ package com.portal.extrafunc.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.extrafunc.dao.PostsDao;
/*  6:   */ import com.portal.extrafunc.entity.Posts;
/*  7:   */ import java.util.Iterator;
/*  8:   */ import org.hibernate.Criteria;
/*  9:   */ import org.hibernate.Query;
/* 10:   */ import org.hibernate.Session;
/* 11:   */ import org.hibernate.criterion.Criterion;
/* 12:   */ import org.hibernate.criterion.Order;
/* 13:   */ import org.hibernate.criterion.Restrictions;
/* 14:   */ import org.springframework.stereotype.Repository;
/* 15:   */ 
/* 16:   */ @Repository
/* 17:   */ public class PostsDaoImpl
/* 18:   */   extends HibernateBaseDao<Posts, Integer>
/* 19:   */   implements PostsDao
/* 20:   */ {
/* 21:   */   public Pagination getPage(int pageNo, int pageSize)
/* 22:   */   {
/* 23:17 */     Criteria crit = createCriteria(new Criterion[0]);
/* 24:18 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 25:19 */     return page;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public Pagination getPostsPageForTag(Integer themeId, int pageNo, int pageSize)
/* 29:   */   {
/* 30:24 */     Criteria crit = createCriteria(new Criterion[0]);
/* 31:25 */     crit.add(Restrictions.eq("theme.id", themeId));
/* 32:26 */     crit.addOrder(Order.asc("floor"));
/* 33:27 */     return findByCriteria(crit, pageNo, pageSize);
/* 34:   */   }
/* 35:   */   
/* 36:   */   public Posts getPostsOneFloor(Integer themeId)
/* 37:   */   {
/* 38:31 */     Criteria crit = createCriteria(new Criterion[0]);
/* 39:32 */     crit.add(Restrictions.eq("theme.id", themeId));
/* 40:33 */     crit.add(Restrictions.eq("floor", Integer.valueOf(1)));
/* 41:34 */     return (Posts)findUnique(crit);
/* 42:   */   }
/* 43:   */   
/* 44:   */   public Integer getFloorByTheme(Integer themeId)
/* 45:   */   {
/* 46:38 */     String hql = "select max(bean.floor) from Posts bean where bean.theme.id=:themeId";
/* 47:39 */     return Integer.valueOf(
/* 48:40 */       ((Number)getSession().createQuery(hql).setParameter("themeId", themeId).iterate().next()).intValue() + 1);
/* 49:   */   }
/* 50:   */   
/* 51:   */   public Posts findById(Integer id)
/* 52:   */   {
/* 53:44 */     Posts entity = (Posts)get(id);
/* 54:45 */     return entity;
/* 55:   */   }
/* 56:   */   
/* 57:   */   public Posts save(Posts bean)
/* 58:   */   {
/* 59:49 */     getSession().save(bean);
/* 60:50 */     return bean;
/* 61:   */   }
/* 62:   */   
/* 63:   */   public Posts deleteById(Integer id)
/* 64:   */   {
/* 65:54 */     Posts entity = (Posts)super.get(id);
/* 66:55 */     if (entity != null) {
/* 67:56 */       getSession().delete(entity);
/* 68:   */     }
/* 69:58 */     return entity;
/* 70:   */   }
/* 71:   */   
/* 72:   */   protected Class<Posts> getEntityClass()
/* 73:   */   {
/* 74:63 */     return Posts.class;
/* 75:   */   }
/* 76:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.dao.impl.PostsDaoImpl
 * JD-Core Version:    0.7.0.1
 */