/*  1:   */ package com.portal.recruitcenter.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.recruitcenter.dao.PersonalFavoriteDao;
/*  6:   */ import com.portal.recruitcenter.entity.PersonalFavorite;
/*  7:   */ import org.hibernate.Criteria;
/*  8:   */ import org.hibernate.Query;
/*  9:   */ import org.hibernate.Session;
/* 10:   */ import org.hibernate.criterion.Criterion;
/* 11:   */ import org.springframework.stereotype.Repository;
/* 12:   */ 
/* 13:   */ @Repository
/* 14:   */ public class PersonalFavoriteDaoImpl
/* 15:   */   extends HibernateBaseDao<PersonalFavorite, Integer>
/* 16:   */   implements PersonalFavoriteDao
/* 17:   */ {
/* 18:   */   public Pagination getPage(int pageNo, int pageSize)
/* 19:   */   {
/* 20:16 */     Criteria crit = createCriteria(new Criterion[0]);
/* 21:17 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 22:18 */     return page;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public Pagination getPageByTag(Integer personalId, int pageNo, int pageSize)
/* 26:   */   {
/* 27:32 */     return null;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public PersonalFavorite getFavoriteByPersonal(Integer personalId, Integer jobId)
/* 31:   */   {
/* 32:42 */     return null;
/* 33:   */   }
/* 34:   */   
/* 35:   */   public int deleteByCompanyId(Integer companyId)
/* 36:   */   {
/* 37:46 */     String hql = "delete from PersonalFavorite bean where bean.job.id in (select j.id from JobPost j where j.company.id=:companyId)";
/* 38:   */     
/* 39:48 */     return getSession().createQuery(hql)
/* 40:49 */       .setParameter("companyId", companyId).executeUpdate();
/* 41:   */   }
/* 42:   */   
/* 43:   */   public int deleteByJobId(Integer jobId)
/* 44:   */   {
/* 45:53 */     String hql = "delete from PersonalFavorite bean where bean.job.id=:jobId";
/* 46:54 */     return getSession().createQuery(hql).setParameter("jobId", jobId)
/* 47:55 */       .executeUpdate();
/* 48:   */   }
/* 49:   */   
/* 50:   */   public int deleteByPersonalId(Integer personalId)
/* 51:   */   {
/* 52:59 */     String hql = "delete from PersonalFavorite bean where bean.personal.id=:personalId";
/* 53:60 */     return getSession().createQuery(hql)
/* 54:61 */       .setParameter("personalId", personalId).executeUpdate();
/* 55:   */   }
/* 56:   */   
/* 57:   */   public int deleteByMetierId(Integer metierId)
/* 58:   */   {
/* 59:65 */     String hql = "delete from PersonalFavorite bean where bean.job.id in (select j.id from JobPost j where j.metier.id=:metierId)";
/* 60:   */     
/* 61:67 */     return getSession().createQuery(hql).setParameter("metierId", metierId)
/* 62:68 */       .executeUpdate();
/* 63:   */   }
/* 64:   */   
/* 65:   */   public PersonalFavorite findById(Integer id)
/* 66:   */   {
/* 67:72 */     PersonalFavorite entity = (PersonalFavorite)get(id);
/* 68:73 */     return entity;
/* 69:   */   }
/* 70:   */   
/* 71:   */   public PersonalFavorite save(PersonalFavorite bean)
/* 72:   */   {
/* 73:77 */     getSession().save(bean);
/* 74:78 */     return bean;
/* 75:   */   }
/* 76:   */   
/* 77:   */   public PersonalFavorite deleteById(Integer id)
/* 78:   */   {
/* 79:82 */     PersonalFavorite entity = (PersonalFavorite)super.get(id);
/* 80:83 */     if (entity != null) {
/* 81:84 */       getSession().delete(entity);
/* 82:   */     }
/* 83:86 */     return entity;
/* 84:   */   }
/* 85:   */   
/* 86:   */   protected Class<PersonalFavorite> getEntityClass()
/* 87:   */   {
/* 88:91 */     return PersonalFavorite.class;
/* 89:   */   }
/* 90:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.dao.impl.PersonalFavoriteDaoImpl
 * JD-Core Version:    0.7.0.1
 */