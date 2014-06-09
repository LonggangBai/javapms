/*  1:   */ package com.portal.recruitcenter.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.recruitcenter.dao.JobPostExtDao;
/*  6:   */ import com.portal.recruitcenter.entity.JobPostExt;
/*  7:   */ import org.hibernate.Criteria;
/*  8:   */ import org.hibernate.Query;
/*  9:   */ import org.hibernate.Session;
/* 10:   */ import org.hibernate.criterion.Criterion;
/* 11:   */ import org.springframework.stereotype.Repository;
/* 12:   */ 
/* 13:   */ @Repository
/* 14:   */ public class JobPostExtDaoImpl
/* 15:   */   extends HibernateBaseDao<JobPostExt, Integer>
/* 16:   */   implements JobPostExtDao
/* 17:   */ {
/* 18:   */   public Pagination getPage(int pageNo, int pageSize)
/* 19:   */   {
/* 20:15 */     Criteria crit = createCriteria(new Criterion[0]);
/* 21:16 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 22:17 */     return page;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public int deleteByCompanyId(Integer companyId)
/* 26:   */   {
/* 27:21 */     String hql = "delete from JobPostExt bean where bean.id in (select j.id from JobPost j where j.company.id=:companyId)";
/* 28:   */     
/* 29:23 */     return getSession().createQuery(hql)
/* 30:24 */       .setParameter("companyId", companyId).executeUpdate();
/* 31:   */   }
/* 32:   */   
/* 33:   */   public int deleteByMetierId(Integer metierId)
/* 34:   */   {
/* 35:28 */     String hql = "delete from JobPostExt bean where bean.id in (select j.id from JobPost j where j.metier.id=:metierId)";
/* 36:   */     
/* 37:30 */     return getSession().createQuery(hql).setParameter("metierId", metierId)
/* 38:31 */       .executeUpdate();
/* 39:   */   }
/* 40:   */   
/* 41:   */   public JobPostExt findById(Integer id)
/* 42:   */   {
/* 43:35 */     JobPostExt entity = (JobPostExt)get(id);
/* 44:36 */     return entity;
/* 45:   */   }
/* 46:   */   
/* 47:   */   public JobPostExt save(JobPostExt bean)
/* 48:   */   {
/* 49:40 */     getSession().save(bean);
/* 50:41 */     return bean;
/* 51:   */   }
/* 52:   */   
/* 53:   */   public JobPostExt deleteById(Integer id)
/* 54:   */   {
/* 55:45 */     JobPostExt entity = (JobPostExt)super.get(id);
/* 56:46 */     if (entity != null) {
/* 57:47 */       getSession().delete(entity);
/* 58:   */     }
/* 59:49 */     return entity;
/* 60:   */   }
/* 61:   */   
/* 62:   */   protected Class<JobPostExt> getEntityClass()
/* 63:   */   {
/* 64:54 */     return JobPostExt.class;
/* 65:   */   }
/* 66:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.dao.impl.JobPostExtDaoImpl
 * JD-Core Version:    0.7.0.1
 */