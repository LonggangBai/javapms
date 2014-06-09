/*  1:   */ package com.portal.recruitcenter.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.recruitcenter.dao.TrainDao;
/*  6:   */ import com.portal.recruitcenter.entity.Train;
/*  7:   */ import org.hibernate.Criteria;
/*  8:   */ import org.hibernate.Query;
/*  9:   */ import org.hibernate.Session;
/* 10:   */ import org.hibernate.criterion.Criterion;
/* 11:   */ import org.hibernate.criterion.Restrictions;
/* 12:   */ import org.springframework.stereotype.Repository;
/* 13:   */ 
/* 14:   */ @Repository
/* 15:   */ public class TrainDaoImpl
/* 16:   */   extends HibernateBaseDao<Train, Integer>
/* 17:   */   implements TrainDao
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
/* 29:23 */     String hql = "delete from Train bean where bean.resume.id in (select r.id from Resume r where r.personal.id=:personalId)";
/* 30:   */     
/* 31:25 */     return getSession().createQuery(hql)
/* 32:26 */       .setParameter("personalId", personalId).executeUpdate();
/* 33:   */   }
/* 34:   */   
/* 35:   */   public int deleteByResumeId(Integer resumeId)
/* 36:   */   {
/* 37:30 */     String hql = "delete from Train bean where bean.resume.id=:resumeId";
/* 38:31 */     return getSession().createQuery(hql).setParameter("resumeId", resumeId)
/* 39:32 */       .executeUpdate();
/* 40:   */   }
/* 41:   */   
/* 42:   */   public Train findById(Integer id)
/* 43:   */   {
/* 44:36 */     Train entity = (Train)get(id);
/* 45:37 */     return entity;
/* 46:   */   }
/* 47:   */   
/* 48:   */   public Train save(Train bean)
/* 49:   */   {
/* 50:41 */     getSession().save(bean);
/* 51:42 */     return bean;
/* 52:   */   }
/* 53:   */   
/* 54:   */   public Train deleteById(Integer id)
/* 55:   */   {
/* 56:46 */     Train entity = (Train)super.get(id);
/* 57:47 */     if (entity != null) {
/* 58:48 */       getSession().delete(entity);
/* 59:   */     }
/* 60:50 */     return entity;
/* 61:   */   }
/* 62:   */   
/* 63:   */   protected Class<Train> getEntityClass()
/* 64:   */   {
/* 65:55 */     return Train.class;
/* 66:   */   }
/* 67:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.dao.impl.TrainDaoImpl
 * JD-Core Version:    0.7.0.1
 */