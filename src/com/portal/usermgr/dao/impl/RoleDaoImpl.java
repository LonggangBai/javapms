/*  1:   */ package com.portal.usermgr.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.usermgr.dao.RoleDao;
/*  6:   */ import com.portal.usermgr.entity.Role;
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
/* 17:   */ public class RoleDaoImpl
/* 18:   */   extends HibernateBaseDao<Role, Integer>
/* 19:   */   implements RoleDao
/* 20:   */ {
/* 21:   */   public Pagination getPage(String name, Integer siteId, String sortname, String sortorder, int pageNo, int pageSize)
/* 22:   */   {
/* 23:21 */     Criteria crit = createCriteria(new Criterion[0]);
/* 24:22 */     if (!StringUtils.isBlank(name)) {
/* 25:23 */       crit.add(Restrictions.like("name", "%" + name + "%"));
/* 26:   */     }
/* 27:25 */     if (siteId != null) {
/* 28:26 */       crit.add(Restrictions.eq("site.id", siteId));
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
/* 41:37 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 42:38 */     return page;
/* 43:   */   }
/* 44:   */   
/* 45:   */   public List<Role> getListBySite(Integer siteId)
/* 46:   */   {
/* 47:42 */     Criteria crit = createCriteria(new Criterion[0]);
/* 48:43 */     crit.add(Restrictions.eq("site.id", siteId));
/* 49:44 */     crit.addOrder(Order.asc("priority"));
/* 50:45 */     return findByCriteria(crit);
/* 51:   */   }
/* 52:   */   
/* 53:   */   public Role findById(Integer id)
/* 54:   */   {
/* 55:49 */     Role entity = (Role)get(id);
/* 56:50 */     return entity;
/* 57:   */   }
/* 58:   */   
/* 59:   */   public Role save(Role bean)
/* 60:   */   {
/* 61:54 */     getSession().save(bean);
/* 62:55 */     return bean;
/* 63:   */   }
/* 64:   */   
/* 65:   */   public Role deleteById(Integer id)
/* 66:   */   {
/* 67:59 */     Role entity = (Role)super.get(id);
/* 68:60 */     if (entity != null) {
/* 69:61 */       getSession().delete(entity);
/* 70:   */     }
/* 71:63 */     return entity;
/* 72:   */   }
/* 73:   */   
/* 74:   */   protected Class<Role> getEntityClass()
/* 75:   */   {
/* 76:68 */     return Role.class;
/* 77:   */   }
/* 78:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.dao.impl.RoleDaoImpl
 * JD-Core Version:    0.7.0.1
 */