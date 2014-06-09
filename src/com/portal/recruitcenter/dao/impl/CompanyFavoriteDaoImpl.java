/*  1:   */ package com.portal.recruitcenter.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.recruitcenter.dao.CompanyFavoriteDao;
/*  6:   */ import com.portal.recruitcenter.entity.CompanyFavorite;
/*  7:   */ import java.util.Iterator;
/*  8:   */ import org.hibernate.Criteria;
/*  9:   */ import org.hibernate.Query;
/* 10:   */ import org.hibernate.Session;
/* 11:   */ import org.hibernate.criterion.Criterion;
/* 12:   */ import org.hibernate.criterion.Order;
/* 13:   */ import org.hibernate.criterion.Restrictions;
/* 14:   */ import org.springframework.stereotype.Repository;
/* 15:   */ 
/* 16:   */ @Repository
/* 17:   */ public class CompanyFavoriteDaoImpl
/* 18:   */   extends HibernateBaseDao<CompanyFavorite, Integer>
/* 19:   */   implements CompanyFavoriteDao
/* 20:   */ {
/* 21:   */   public Pagination getPage(int pageNo, int pageSize)
/* 22:   */   {
/* 23:19 */     Criteria crit = createCriteria(new Criterion[0]);
/* 24:20 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 25:21 */     return page;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public Pagination getPageByTag(Integer companyId, int pageNo, int pageSize)
/* 29:   */   {
/* 30:25 */     Criteria crit = createCriteria(new Criterion[0]);
/* 31:26 */     crit.createAlias("resume", "r");
/* 32:27 */     crit.createAlias("r.personal", "p");
/* 33:28 */     if (companyId != null) {
/* 34:29 */       crit.add(Restrictions.eq("company.id", companyId));
/* 35:   */     }
/* 36:31 */     crit.add(Restrictions.eq("company.check", Boolean.valueOf(true)));
/* 37:32 */     crit.add(Restrictions.eq("p.check", Boolean.valueOf(true)));
/* 38:33 */     crit.addOrder(Order.desc("createTime"));
/* 39:34 */     return findByCriteria(crit, pageNo, pageSize);
/* 40:   */   }
/* 41:   */   
/* 42:   */   public CompanyFavorite getFavoriteByCompany(Integer companyId, Integer resumeId)
/* 43:   */   {
/* 44:39 */     Criteria crit = createCriteria(new Criterion[0]);
/* 45:40 */     crit.createAlias("resume", "r");
/* 46:41 */     crit.createAlias("r.personal", "p");
/* 47:42 */     crit.add(Restrictions.eq("company.id", companyId));
/* 48:43 */     crit.add(Restrictions.eq("r.id", resumeId));
/* 49:44 */     crit.add(Restrictions.eq("company.check", Boolean.valueOf(true)));
/* 50:45 */     crit.add(Restrictions.eq("p.check", Boolean.valueOf(true)));
/* 51:46 */     return (CompanyFavorite)findUnique(crit);
/* 52:   */   }
/* 53:   */   
/* 54:   */   public int countByCompanyId(Integer companyId)
/* 55:   */   {
/* 56:50 */     String hql = "select count(*) from CompanyFavorite bean where bean.company.id=:companyId";
/* 57:   */     
/* 58:52 */     Query query = getSession().createQuery(hql);
/* 59:53 */     query.setParameter("companyId", companyId);
/* 60:54 */     return ((Number)query.iterate().next()).intValue();
/* 61:   */   }
/* 62:   */   
/* 63:   */   public int deleteByCompanyId(Integer companyId)
/* 64:   */   {
/* 65:58 */     String hql = "delete from CompanyFavorite bean where bean.company.id=:companyId";
/* 66:59 */     return getSession().createQuery(hql)
/* 67:60 */       .setParameter("companyId", companyId).executeUpdate();
/* 68:   */   }
/* 69:   */   
/* 70:   */   public int deleteByResumeId(Integer resumeId)
/* 71:   */   {
/* 72:64 */     String hql = "delete from CompanyFavorite bean where bean.resume.id=:resumeId";
/* 73:65 */     return getSession().createQuery(hql).setParameter("resumeId", resumeId)
/* 74:66 */       .executeUpdate();
/* 75:   */   }
/* 76:   */   
/* 77:   */   public int deleteByPersonalId(Integer personalId)
/* 78:   */   {
/* 79:70 */     String hql = "delete from CompanyFavorite bean where bean.resume.id in (select r.id from Resume r where r.personal.id=:personalId)";
/* 80:   */     
/* 81:72 */     return getSession().createQuery(hql)
/* 82:73 */       .setParameter("personalId", personalId).executeUpdate();
/* 83:   */   }
/* 84:   */   
/* 85:   */   public CompanyFavorite findById(Integer id)
/* 86:   */   {
/* 87:77 */     CompanyFavorite entity = (CompanyFavorite)get(id);
/* 88:78 */     return entity;
/* 89:   */   }
/* 90:   */   
/* 91:   */   public CompanyFavorite save(CompanyFavorite bean)
/* 92:   */   {
/* 93:82 */     getSession().save(bean);
/* 94:83 */     return bean;
/* 95:   */   }
/* 96:   */   
/* 97:   */   public CompanyFavorite deleteById(Integer id)
/* 98:   */   {
/* 99:87 */     CompanyFavorite entity = (CompanyFavorite)super.get(id);
/* :0:88 */     if (entity != null) {
/* :1:89 */       getSession().delete(entity);
/* :2:   */     }
/* :3:91 */     return entity;
/* :4:   */   }
/* :5:   */   
/* :6:   */   protected Class<CompanyFavorite> getEntityClass()
/* :7:   */   {
/* :8:96 */     return CompanyFavorite.class;
/* :9:   */   }
/* ;0:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.dao.impl.CompanyFavoriteDaoImpl
 * JD-Core Version:    0.7.0.1
 */