/*  1:   */ package com.portal.datacenter.commdata.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.datacenter.commdata.dao.EconomyTypeDao;
/*  6:   */ import com.portal.datacenter.commdata.entity.EconomyType;
/*  7:   */ import java.util.List;
/*  8:   */ import org.hibernate.Criteria;
/*  9:   */ import org.hibernate.Session;
/* 10:   */ import org.hibernate.criterion.Criterion;
/* 11:   */ import org.hibernate.criterion.Order;
/* 12:   */ import org.hibernate.criterion.Restrictions;
/* 13:   */ import org.springframework.stereotype.Repository;
/* 14:   */ 
/* 15:   */ @Repository
/* 16:   */ public class EconomyTypeDaoImpl
/* 17:   */   extends HibernateBaseDao<EconomyType, Integer>
/* 18:   */   implements EconomyTypeDao
/* 19:   */ {
/* 20:   */   public Pagination getPage(int pageNo, int pageSize)
/* 21:   */   {
/* 22:19 */     Criteria crit = createCriteria(new Criterion[0]);
/* 23:20 */     crit.addOrder(Order.asc("code"));
/* 24:21 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 25:22 */     return page;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public List<EconomyType> getEconomyTypeList()
/* 29:   */   {
/* 30:26 */     Criteria crit = createCriteria(new Criterion[0]);
/* 31:27 */     crit.addOrder(Order.asc("code"));
/* 32:28 */     return findByCriteria(crit);
/* 33:   */   }
/* 34:   */   
/* 35:   */   public EconomyType findByCode(String code)
/* 36:   */   {
/* 37:32 */     Criteria crit = createCriteria(new Criterion[0]);
/* 38:33 */     crit.add(Restrictions.eq("code", code));
/* 39:34 */     return (EconomyType)findUnique(crit);
/* 40:   */   }
/* 41:   */   
/* 42:   */   public EconomyType findById(Integer id)
/* 43:   */   {
/* 44:38 */     EconomyType entity = (EconomyType)get(id);
/* 45:39 */     return entity;
/* 46:   */   }
/* 47:   */   
/* 48:   */   public EconomyType save(EconomyType bean)
/* 49:   */   {
/* 50:43 */     getSession().save(bean);
/* 51:44 */     return bean;
/* 52:   */   }
/* 53:   */   
/* 54:   */   public EconomyType deleteById(Integer id)
/* 55:   */   {
/* 56:48 */     EconomyType entity = (EconomyType)super.get(id);
/* 57:49 */     if (entity != null) {
/* 58:50 */       getSession().delete(entity);
/* 59:   */     }
/* 60:52 */     return entity;
/* 61:   */   }
/* 62:   */   
/* 63:   */   protected Class<EconomyType> getEntityClass()
/* 64:   */   {
/* 65:57 */     return EconomyType.class;
/* 66:   */   }
/* 67:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.commdata.dao.impl.EconomyTypeDaoImpl
 * JD-Core Version:    0.7.0.1
 */