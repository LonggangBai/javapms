/*   1:    */ package com.portal.recruitcenter.dao.impl;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*   4:    */ import com.javapms.basic.page.Pagination;
/*   5:    */ import com.portal.recruitcenter.dao.JobIntentDao;
/*   6:    */ import com.portal.recruitcenter.entity.JobIntent;
/*   7:    */ import org.hibernate.Criteria;
/*   8:    */ import org.hibernate.Query;
/*   9:    */ import org.hibernate.Session;
/*  10:    */ import org.hibernate.criterion.Criterion;
/*  11:    */ import org.springframework.stereotype.Repository;
/*  12:    */ 
/*  13:    */ @Repository
/*  14:    */ public class JobIntentDaoImpl
/*  15:    */   extends HibernateBaseDao<JobIntent, Integer>
/*  16:    */   implements JobIntentDao
/*  17:    */ {
/*  18:    */   public Pagination getPage(int pageNo, int pageSize)
/*  19:    */   {
/*  20: 15 */     Criteria crit = createCriteria(new Criterion[0]);
/*  21: 16 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/*  22: 17 */     return page;
/*  23:    */   }
/*  24:    */   
/*  25:    */   public Pagination getPageByTag(String key, Integer personalId, Integer metierId, Integer industryId, Integer specialId, Byte wage, Byte edu, Byte minwork, Byte maxwork, Boolean gender, Boolean show, int pageNo, int pageSize)
/*  26:    */   {
/*  27: 72 */     return null;
/*  28:    */   }
/*  29:    */   
/*  30:    */   public int deleteByPersonalId(Integer personalId)
/*  31:    */   {
/*  32: 76 */     String hql = "delete from JobIntent bean where bean.id in (select r.id from Resume r where r.personal.id=:personalId)";
/*  33:    */     
/*  34: 78 */     return getSession().createQuery(hql)
/*  35: 79 */       .setParameter("personalId", personalId).executeUpdate();
/*  36:    */   }
/*  37:    */   
/*  38:    */   public JobIntent findById(Integer id)
/*  39:    */   {
/*  40: 83 */     JobIntent entity = (JobIntent)get(id);
/*  41: 84 */     return entity;
/*  42:    */   }
/*  43:    */   
/*  44:    */   public JobIntent save(JobIntent bean)
/*  45:    */   {
/*  46: 88 */     getSession().save(bean);
/*  47: 89 */     return bean;
/*  48:    */   }
/*  49:    */   
/*  50:    */   public JobIntent deleteById(Integer id)
/*  51:    */   {
/*  52: 93 */     JobIntent entity = (JobIntent)super.get(id);
/*  53: 94 */     if (entity != null) {
/*  54: 95 */       getSession().delete(entity);
/*  55:    */     }
/*  56: 97 */     return entity;
/*  57:    */   }
/*  58:    */   
/*  59:    */   protected Class<JobIntent> getEntityClass()
/*  60:    */   {
/*  61:102 */     return JobIntent.class;
/*  62:    */   }
/*  63:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.dao.impl.JobIntentDaoImpl
 * JD-Core Version:    0.7.0.1
 */