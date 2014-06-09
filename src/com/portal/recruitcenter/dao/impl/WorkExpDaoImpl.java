/*  1:   */ package com.portal.recruitcenter.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.recruitcenter.dao.WorkExpDao;
/*  6:   */ import com.portal.recruitcenter.entity.WorkExp;
/*  7:   */ import org.hibernate.Criteria;
/*  8:   */ import org.hibernate.Query;
/*  9:   */ import org.hibernate.Session;
/* 10:   */ import org.hibernate.criterion.Criterion;
/* 11:   */ import org.hibernate.criterion.Restrictions;
/* 12:   */ import org.springframework.stereotype.Repository;
/* 13:   */ 
/* 14:   */ @Repository
/* 15:   */ public class WorkExpDaoImpl
/* 16:   */   extends HibernateBaseDao<WorkExp, Integer>
/* 17:   */   implements WorkExpDao
/* 18:   */ {
/* 19:   */   public Pagination getPage(Integer resumeId, int pageNo, int pageSize)
/* 20:   */   {
/* 21:16 */     Criteria crit = createCriteria(new Criterion[0]);
/* 22:17 */     crit.add(Restrictions.eq("resume.id", resumeId));
/* 23:18 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 24:19 */     return page;
/* 25:   */   }
/* 26:   */   
/* 27:   */   public int deleteByPersonalId(Integer personalId)
/* 28:   */   {
/* 29:23 */     String hql = "delete from WorkExp bean where bean.resume.id in (select r.id from Resume r where r.personal.id=:personalId)";
/* 30:   */     
/* 31:25 */     return getSession().createQuery(hql)
/* 32:26 */       .setParameter("personalId", personalId).executeUpdate();
/* 33:   */   }
/* 34:   */   
/* 35:   */   public int deleteByResumeId(Integer resumeId)
/* 36:   */   {
/* 37:30 */     String hql = "delete from WorkExp bean where bean.resume.id=:resumeId";
/* 38:31 */     return getSession().createQuery(hql).setParameter("resumeId", resumeId)
/* 39:32 */       .executeUpdate();
/* 40:   */   }
/* 41:   */   
/* 42:   */   public int deleteByNatureId(Integer natureId)
/* 43:   */   {
/* 44:36 */     String hql = "delete from WorkExp bean where bean.nature.id=:natureId";
/* 45:37 */     return getSession().createQuery(hql).setParameter("natureId", natureId)
/* 46:38 */       .executeUpdate();
/* 47:   */   }
/* 48:   */   
/* 49:   */   public int deleteByMetierId(Integer metierId)
/* 50:   */   {
/* 51:42 */     String hql = "delete from WorkExp bean where bean.metier.id=:metierId";
/* 52:43 */     return getSession().createQuery(hql).setParameter("metierId", metierId)
/* 53:44 */       .executeUpdate();
/* 54:   */   }
/* 55:   */   
/* 56:   */   public int deleteByIndustryId(Integer industryId)
/* 57:   */   {
/* 58:48 */     String hql = "delete from WorkExp bean where bean.industry.id=:industryId";
/* 59:49 */     return getSession().createQuery(hql)
/* 60:50 */       .setParameter("industryId", industryId).executeUpdate();
/* 61:   */   }
/* 62:   */   
/* 63:   */   public WorkExp findById(Integer id)
/* 64:   */   {
/* 65:54 */     WorkExp entity = (WorkExp)get(id);
/* 66:55 */     return entity;
/* 67:   */   }
/* 68:   */   
/* 69:   */   public WorkExp save(WorkExp bean)
/* 70:   */   {
/* 71:59 */     getSession().save(bean);
/* 72:60 */     return bean;
/* 73:   */   }
/* 74:   */   
/* 75:   */   public WorkExp deleteById(Integer id)
/* 76:   */   {
/* 77:64 */     WorkExp entity = (WorkExp)super.get(id);
/* 78:65 */     if (entity != null) {
/* 79:66 */       getSession().delete(entity);
/* 80:   */     }
/* 81:68 */     return entity;
/* 82:   */   }
/* 83:   */   
/* 84:   */   protected Class<WorkExp> getEntityClass()
/* 85:   */   {
/* 86:73 */     return WorkExp.class;
/* 87:   */   }
/* 88:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.dao.impl.WorkExpDaoImpl
 * JD-Core Version:    0.7.0.1
 */