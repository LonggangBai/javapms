/*  1:   */ package com.portal.usermgr.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.usermgr.dao.DepartDao;
/*  6:   */ import com.portal.usermgr.entity.Depart;
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
/* 17:   */ public class DepartDaoImpl
/* 18:   */   extends HibernateBaseDao<Depart, Integer>
/* 19:   */   implements DepartDao
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
/* 34:30 */       crit.addOrder(Order.desc("registerTime"));
/* 35:   */     }
/* 36:32 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 37:33 */     return page;
/* 38:   */   }
/* 39:   */   
/* 40:   */   public List<Depart> getListByTag(Integer siteId)
/* 41:   */   {
/* 42:37 */     Criteria crit = createCriteria(new Criterion[0]);
/* 43:38 */     crit.add(Restrictions.eq("site.id", siteId));
/* 44:39 */     crit.add(Restrictions.eq("show", Boolean.valueOf(true)));
/* 45:40 */     crit.addOrder(Order.asc("priority"));
/* 46:41 */     return findByCriteria(crit);
/* 47:   */   }
/* 48:   */   
/* 49:   */   public List<Depart> getAllList(Integer siteId)
/* 50:   */   {
/* 51:45 */     Criteria crit = createCriteria(new Criterion[0]);
/* 52:46 */     crit.add(Restrictions.eq("site.id", siteId));
/* 53:47 */     crit.addOrder(Order.asc("priority"));
/* 54:48 */     return findByCriteria(crit);
/* 55:   */   }
/* 56:   */   
/* 57:   */   public List<Depart> getListNoParent(Integer siteId)
/* 58:   */   {
/* 59:52 */     Criteria crit = createCriteria(new Criterion[0]);
/* 60:53 */     crit.add(Restrictions.eq("site.id", siteId));
/* 61:54 */     crit.add(Restrictions.isNull("parent"));
/* 62:55 */     crit.addOrder(Order.asc("priority"));
/* 63:56 */     return findByCriteria(crit);
/* 64:   */   }
/* 65:   */   
/* 66:   */   public List<Depart> getListByParent(Integer parentId)
/* 67:   */   {
/* 68:60 */     Criteria crit = createCriteria(new Criterion[0]);
/* 69:61 */     crit.add(Restrictions.eq("parent.id", parentId));
/* 70:62 */     crit.addOrder(Order.asc("priority"));
/* 71:63 */     return findByCriteria(crit);
/* 72:   */   }
/* 73:   */   
/* 74:   */   public Depart getDepartByPath(String path, Integer siteId)
/* 75:   */   {
/* 76:67 */     Criteria crit = createCriteria(new Criterion[0]);
/* 77:68 */     crit.add(Restrictions.eq("site.id", siteId));
/* 78:69 */     crit.add(Restrictions.eq("visitPath", path));
/* 79:70 */     return (Depart)findUnique(crit);
/* 80:   */   }
/* 81:   */   
/* 82:   */   public Depart findById(Integer id)
/* 83:   */   {
/* 84:74 */     Depart entity = (Depart)get(id);
/* 85:75 */     return entity;
/* 86:   */   }
/* 87:   */   
/* 88:   */   public Depart save(Depart bean)
/* 89:   */   {
/* 90:79 */     getSession().save(bean);
/* 91:80 */     return bean;
/* 92:   */   }
/* 93:   */   
/* 94:   */   public Depart deleteById(Integer id)
/* 95:   */   {
/* 96:84 */     Depart entity = (Depart)super.get(id);
/* 97:85 */     if (entity != null) {
/* 98:86 */       getSession().delete(entity);
/* 99:   */     }
/* :0:88 */     return entity;
/* :1:   */   }
/* :2:   */   
/* :3:   */   protected Class<Depart> getEntityClass()
/* :4:   */   {
/* :5:93 */     return Depart.class;
/* :6:   */   }
/* :7:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.dao.impl.DepartDaoImpl
 * JD-Core Version:    0.7.0.1
 */