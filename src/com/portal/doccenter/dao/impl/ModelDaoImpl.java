/*  1:   */ package com.portal.doccenter.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.portal.doccenter.dao.ModelDao;
/*  5:   */ import com.portal.doccenter.entity.Model;
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
/* 16:   */ public class ModelDaoImpl
/* 17:   */   extends HibernateBaseDao<Model, Integer>
/* 18:   */   implements ModelDao
/* 19:   */ {
/* 20:   */   public List<Model> getList(boolean containDisabled, String sortname, String sortorder)
/* 21:   */   {
/* 22:21 */     Criteria crit = createCriteria(new Criterion[0]);
/* 23:22 */     if (!containDisabled) {
/* 24:23 */       crit.add(Restrictions.eq("disabled", Boolean.valueOf(false)));
/* 25:   */     }
/* 26:25 */     if (!StringUtils.isBlank(sortname))
/* 27:   */     {
/* 28:26 */       if ("asc".equals(sortorder)) {
/* 29:27 */         crit.addOrder(Order.asc(sortname));
/* 30:   */       } else {
/* 31:29 */         crit.addOrder(Order.desc(sortname));
/* 32:   */       }
/* 33:   */     }
/* 34:   */     else
/* 35:   */     {
/* 36:32 */       crit.addOrder(Order.asc("priority"));
/* 37:33 */       crit.addOrder(Order.asc("id"));
/* 38:   */     }
/* 39:35 */     return findByCriteria(crit);
/* 40:   */   }
/* 41:   */   
/* 42:   */   public Model getDefModel()
/* 43:   */   {
/* 44:39 */     Criteria crit = createCriteria(new Criterion[0]);
/* 45:40 */     crit.add(Restrictions.eq("def", Boolean.valueOf(true)));
/* 46:41 */     return (Model)findUnique(crit);
/* 47:   */   }
/* 48:   */   
/* 49:   */   public Model findById(Integer id)
/* 50:   */   {
/* 51:45 */     Model entity = (Model)get(id);
/* 52:46 */     return entity;
/* 53:   */   }
/* 54:   */   
/* 55:   */   public Model save(Model bean)
/* 56:   */   {
/* 57:50 */     getSession().save(bean);
/* 58:51 */     return bean;
/* 59:   */   }
/* 60:   */   
/* 61:   */   public Model deleteById(Integer id)
/* 62:   */   {
/* 63:55 */     Model entity = (Model)super.get(id);
/* 64:56 */     if (entity != null) {
/* 65:57 */       getSession().delete(entity);
/* 66:   */     }
/* 67:59 */     return entity;
/* 68:   */   }
/* 69:   */   
/* 70:   */   protected Class<Model> getEntityClass()
/* 71:   */   {
/* 72:64 */     return Model.class;
/* 73:   */   }
/* 74:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.dao.impl.ModelDaoImpl
 * JD-Core Version:    0.7.0.1
 */