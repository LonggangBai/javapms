/*  1:   */ package com.portal.recruitcenter.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.recruitcenter.dao.EduExpDao;
/*  6:   */ import com.portal.recruitcenter.entity.EduExp;
/*  7:   */ import org.hibernate.Criteria;
/*  8:   */ import org.hibernate.Query;
/*  9:   */ import org.hibernate.Session;
/* 10:   */ import org.hibernate.criterion.Criterion;
/* 11:   */ import org.hibernate.criterion.Restrictions;
/* 12:   */ import org.springframework.stereotype.Repository;
/* 13:   */ 
/* 14:   */ @Repository
/* 15:   */ public class EduExpDaoImpl
/* 16:   */   extends HibernateBaseDao<EduExp, Integer>
/* 17:   */   implements EduExpDao
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
/* 29:23 */     String hql = "delete from EduExp bean where bean.resume.id in (select r.id from Resume r where r.personal.id=:personalId)";
/* 30:   */     
/* 31:25 */     return getSession().createQuery(hql)
/* 32:26 */       .setParameter("personalId", personalId).executeUpdate();
/* 33:   */   }
/* 34:   */   
/* 35:   */   public int deleteByResumeId(Integer resumeId)
/* 36:   */   {
/* 37:30 */     String hql = "delete from EduExp bean where bean.resume.id=:resumeId";
/* 38:31 */     return getSession().createQuery(hql).setParameter("resumeId", resumeId)
/* 39:32 */       .executeUpdate();
/* 40:   */   }
/* 41:   */   
/* 42:   */   public int deleteBySpecialId(Integer specialId)
/* 43:   */   {
/* 44:36 */     String hql = "delete from EduExp bean where bean.special.id=:specialId";
/* 45:37 */     return getSession().createQuery(hql)
/* 46:38 */       .setParameter("specialId", specialId).executeUpdate();
/* 47:   */   }
/* 48:   */   
/* 49:   */   public EduExp findById(Integer id)
/* 50:   */   {
/* 51:42 */     EduExp entity = (EduExp)get(id);
/* 52:43 */     return entity;
/* 53:   */   }
/* 54:   */   
/* 55:   */   public EduExp save(EduExp bean)
/* 56:   */   {
/* 57:47 */     getSession().save(bean);
/* 58:48 */     return bean;
/* 59:   */   }
/* 60:   */   
/* 61:   */   public EduExp deleteById(Integer id)
/* 62:   */   {
/* 63:52 */     EduExp entity = (EduExp)super.get(id);
/* 64:53 */     if (entity != null) {
/* 65:54 */       getSession().delete(entity);
/* 66:   */     }
/* 67:56 */     return entity;
/* 68:   */   }
/* 69:   */   
/* 70:   */   protected Class<EduExp> getEntityClass()
/* 71:   */   {
/* 72:61 */     return EduExp.class;
/* 73:   */   }
/* 74:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.dao.impl.EduExpDaoImpl
 * JD-Core Version:    0.7.0.1
 */