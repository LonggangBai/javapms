/*  1:   */ package com.portal.usermgr.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.portal.usermgr.dao.GroupDao;
/*  5:   */ import com.portal.usermgr.entity.Group;
/*  6:   */ import java.util.List;
/*  7:   */ import org.apache.commons.lang.StringUtils;
/*  8:   */ import org.hibernate.Criteria;
/*  9:   */ import org.hibernate.Session;
/* 10:   */ import org.hibernate.criterion.Criterion;
/* 11:   */ import org.hibernate.criterion.Order;
/* 12:   */ import org.hibernate.criterion.Restrictions;
/* 13:   */ import org.springframework.stereotype.Repository;
/* 14:   */ 
/* 15:   */ @Repository
/* 16:   */ public class GroupDaoImpl
/* 17:   */   extends HibernateBaseDao<Group, Integer>
/* 18:   */   implements GroupDao
/* 19:   */ {
/* 20:   */   public List<Group> getList(Integer siteId, String sortname, String sortorder)
/* 21:   */   {
/* 22:19 */     Criteria crit = createCriteria(new Criterion[0]);
/* 23:20 */     crit.add(Restrictions.eq("site.id", siteId));
/* 24:21 */     if (!StringUtils.isBlank(sortname))
/* 25:   */     {
/* 26:22 */       if ("asc".equals(sortorder)) {
/* 27:23 */         crit.addOrder(Order.asc(sortname));
/* 28:   */       } else {
/* 29:25 */         crit.addOrder(Order.desc(sortname));
/* 30:   */       }
/* 31:   */     }
/* 32:   */     else
/* 33:   */     {
/* 34:28 */       crit.addOrder(Order.asc("priority"));
/* 35:29 */       crit.addOrder(Order.asc("id"));
/* 36:   */     }
/* 37:31 */     return findByCriteria(crit);
/* 38:   */   }
/* 39:   */   
/* 40:   */   public Group findById(Integer id)
/* 41:   */   {
/* 42:35 */     Group entity = (Group)get(id);
/* 43:36 */     return entity;
/* 44:   */   }
/* 45:   */   
/* 46:   */   public Group save(Group bean)
/* 47:   */   {
/* 48:40 */     getSession().save(bean);
/* 49:41 */     return bean;
/* 50:   */   }
/* 51:   */   
/* 52:   */   public Group deleteById(Integer id)
/* 53:   */   {
/* 54:45 */     Group entity = (Group)super.get(id);
/* 55:46 */     if (entity != null) {
/* 56:47 */       getSession().delete(entity);
/* 57:   */     }
/* 58:49 */     return entity;
/* 59:   */   }
/* 60:   */   
/* 61:   */   protected Class<Group> getEntityClass()
/* 62:   */   {
/* 63:54 */     return Group.class;
/* 64:   */   }
/* 65:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.dao.impl.GroupDaoImpl
 * JD-Core Version:    0.7.0.1
 */