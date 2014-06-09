/*  1:   */ package com.portal.usermgr.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.usermgr.dao.AdminDao;
/*  6:   */ import com.portal.usermgr.entity.Admin;
/*  7:   */ import org.apache.commons.lang.StringUtils;
/*  8:   */ import org.hibernate.Criteria;
/*  9:   */ import org.hibernate.Session;
/* 10:   */ import org.hibernate.criterion.Criterion;
/* 11:   */ import org.hibernate.criterion.Order;
/* 12:   */ import org.hibernate.criterion.Restrictions;
/* 13:   */ import org.springframework.stereotype.Repository;
/* 14:   */ 
/* 15:   */ @Repository
/* 16:   */ public class AdminDaoImpl
/* 17:   */   extends HibernateBaseDao<Admin, Integer>
/* 18:   */   implements AdminDao
/* 19:   */ {
/* 20:   */   public Pagination getPage(int pageNo, int pageSize)
/* 21:   */   {
/* 22:18 */     Criteria crit = createCriteria(new Criterion[0]);
/* 23:19 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 24:20 */     return page;
/* 25:   */   }
/* 26:   */   
/* 27:   */   public Pagination getPage(String key, Integer siteId, Integer departId, Integer roleId, String sortname, String sortorder, int pageNo, int pageSize)
/* 28:   */   {
/* 29:26 */     Criteria crit = createCriteria(new Criterion[0]);
/* 30:27 */     if (roleId != null)
/* 31:   */     {
/* 32:28 */       crit.createAlias("roles", "role");
/* 33:29 */       crit.add(Restrictions.eq("role.id", roleId));
/* 34:   */     }
/* 35:30 */     else if (departId != null)
/* 36:   */     {
/* 37:31 */       crit.createAlias("departs", "depart");
/* 38:32 */       crit.add(Restrictions.eq("depart.id", departId));
/* 39:   */     }
/* 40:33 */     else if (siteId != null)
/* 41:   */     {
/* 42:34 */       crit.createAlias("roles", "role");
/* 43:35 */       crit.add(Restrictions.eq("role.site.id", siteId));
/* 44:   */     }
/* 45:37 */     if (!StringUtils.isBlank(key)) {
/* 46:38 */       crit.add(Restrictions.or(
/* 47:39 */         Restrictions.like("user.username", "%" + key + "%"), 
/* 48:40 */         Restrictions.like("user.realName", "%" + key + "%")));
/* 49:   */     }
/* 50:42 */     if (!StringUtils.isBlank(sortname))
/* 51:   */     {
/* 52:43 */       crit.createAlias("user", "u");
/* 53:44 */       if ("asc".equals(sortorder)) {
/* 54:45 */         crit.addOrder(Order.asc(sortname));
/* 55:   */       } else {
/* 56:47 */         crit.addOrder(Order.desc(sortname));
/* 57:   */       }
/* 58:   */     }
/* 59:   */     else
/* 60:   */     {
/* 61:50 */       crit.addOrder(Order.desc("registerTime"));
/* 62:   */     }
/* 63:52 */     return findByCriteria(crit, pageNo, pageSize);
/* 64:   */   }
/* 65:   */   
/* 66:   */   public Admin findById(Integer id)
/* 67:   */   {
/* 68:56 */     Admin entity = (Admin)get(id);
/* 69:57 */     return entity;
/* 70:   */   }
/* 71:   */   
/* 72:   */   public Admin save(Admin bean)
/* 73:   */   {
/* 74:61 */     getSession().save(bean);
/* 75:62 */     return bean;
/* 76:   */   }
/* 77:   */   
/* 78:   */   public Admin deleteById(Integer id)
/* 79:   */   {
/* 80:66 */     Admin entity = (Admin)super.get(id);
/* 81:67 */     if (entity != null) {
/* 82:68 */       getSession().delete(entity);
/* 83:   */     }
/* 84:70 */     return entity;
/* 85:   */   }
/* 86:   */   
/* 87:   */   protected Class<Admin> getEntityClass()
/* 88:   */   {
/* 89:75 */     return Admin.class;
/* 90:   */   }
/* 91:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.dao.impl.AdminDaoImpl
 * JD-Core Version:    0.7.0.1
 */