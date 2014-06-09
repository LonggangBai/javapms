/*  1:   */ package com.portal.recruitcenter.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.recruitcenter.dao.JobFairsDao;
/*  6:   */ import com.portal.recruitcenter.entity.JobFairs;
/*  7:   */ import java.util.List;
/*  8:   */ import org.hibernate.Criteria;
/*  9:   */ import org.hibernate.Session;
/* 10:   */ import org.hibernate.criterion.Criterion;
/* 11:   */ import org.hibernate.criterion.Order;
/* 12:   */ import org.springframework.stereotype.Repository;
/* 13:   */ 
/* 14:   */ @Repository
/* 15:   */ public class JobFairsDaoImpl
/* 16:   */   extends HibernateBaseDao<JobFairs, Integer>
/* 17:   */   implements JobFairsDao
/* 18:   */ {
/* 19:   */   public Pagination getPage(int pageNo, int pageSize)
/* 20:   */   {
/* 21:18 */     Criteria crit = createCriteria(new Criterion[0]);
/* 22:19 */     crit.addOrder(Order.desc("createTime"));
/* 23:20 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 24:21 */     return page;
/* 25:   */   }
/* 26:   */   
/* 27:   */   public Pagination getPageByTag(int pageNo, int pageSize)
/* 28:   */   {
/* 29:28 */     return null;
/* 30:   */   }
/* 31:   */   
/* 32:   */   public List<JobFairs> getFairsByTime()
/* 33:   */   {
/* 34:38 */     return null;
/* 35:   */   }
/* 36:   */   
/* 37:   */   public JobFairs findById(Integer id)
/* 38:   */   {
/* 39:42 */     JobFairs entity = (JobFairs)get(id);
/* 40:43 */     return entity;
/* 41:   */   }
/* 42:   */   
/* 43:   */   public JobFairs save(JobFairs bean)
/* 44:   */   {
/* 45:47 */     getSession().save(bean);
/* 46:48 */     return bean;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public JobFairs deleteById(Integer id)
/* 50:   */   {
/* 51:52 */     JobFairs entity = (JobFairs)super.get(id);
/* 52:53 */     if (entity != null) {
/* 53:54 */       getSession().delete(entity);
/* 54:   */     }
/* 55:56 */     return entity;
/* 56:   */   }
/* 57:   */   
/* 58:   */   protected Class<JobFairs> getEntityClass()
/* 59:   */   {
/* 60:61 */     return JobFairs.class;
/* 61:   */   }
/* 62:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.dao.impl.JobFairsDaoImpl
 * JD-Core Version:    0.7.0.1
 */