/*  1:   */ package com.portal.datacenter.commdata.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.datacenter.commdata.dao.SpecialtyDao;
/*  6:   */ import com.portal.datacenter.commdata.entity.Specialty;
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
/* 17:   */ public class SpecialtyDaoImpl
/* 18:   */   extends HibernateBaseDao<Specialty, Integer>
/* 19:   */   implements SpecialtyDao
/* 20:   */ {
/* 21:   */   public Pagination getPage(String key, int pageNo, int pageSize)
/* 22:   */   {
/* 23:20 */     Criteria crit = createCriteria(new Criterion[0]);
/* 24:21 */     if (!StringUtils.isBlank(key)) {
/* 25:22 */       crit.add(Restrictions.or(
/* 26:23 */         Restrictions.like("code", "%" + key + "%"), 
/* 27:24 */         Restrictions.like("name", "%" + key + "%")));
/* 28:   */     }
/* 29:26 */     crit.addOrder(Order.asc("code"));
/* 30:27 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 31:28 */     return page;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public List<Specialty> getSpecialtyList(Integer id)
/* 35:   */   {
/* 36:32 */     Criteria crit = createCriteria(new Criterion[0]);
/* 37:33 */     crit.add(Restrictions.isNull("parent"));
/* 38:34 */     if (id != null) {
/* 39:35 */       crit.add(Restrictions.ne("id", id));
/* 40:   */     }
/* 41:37 */     crit.addOrder(Order.asc("code"));
/* 42:38 */     return findByCriteria(crit);
/* 43:   */   }
/* 44:   */   
/* 45:   */   public List<Specialty> getSpecialtyChild(Integer id)
/* 46:   */   {
/* 47:42 */     Criteria crit = createCriteria(new Criterion[0]);
/* 48:43 */     crit.add(Restrictions.eq("parent.id", id));
/* 49:44 */     crit.addOrder(Order.asc("code"));
/* 50:45 */     return findByCriteria(crit);
/* 51:   */   }
/* 52:   */   
/* 53:   */   public Specialty findByCode(String code)
/* 54:   */   {
/* 55:49 */     Criteria crit = createCriteria(new Criterion[0]);
/* 56:50 */     crit.add(Restrictions.eq("code", code));
/* 57:51 */     return (Specialty)findUnique(crit);
/* 58:   */   }
/* 59:   */   
/* 60:   */   public Specialty findById(Integer id)
/* 61:   */   {
/* 62:55 */     Specialty entity = (Specialty)get(id);
/* 63:56 */     return entity;
/* 64:   */   }
/* 65:   */   
/* 66:   */   public Specialty save(Specialty bean)
/* 67:   */   {
/* 68:60 */     getSession().save(bean);
/* 69:61 */     return bean;
/* 70:   */   }
/* 71:   */   
/* 72:   */   public Specialty deleteById(Integer id)
/* 73:   */   {
/* 74:65 */     Specialty entity = (Specialty)super.get(id);
/* 75:66 */     if (entity != null) {
/* 76:67 */       getSession().delete(entity);
/* 77:   */     }
/* 78:69 */     return entity;
/* 79:   */   }
/* 80:   */   
/* 81:   */   protected Class<Specialty> getEntityClass()
/* 82:   */   {
/* 83:74 */     return Specialty.class;
/* 84:   */   }
/* 85:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.commdata.dao.impl.SpecialtyDaoImpl
 * JD-Core Version:    0.7.0.1
 */