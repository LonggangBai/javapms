/*  1:   */ package com.portal.sysmgr.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.portal.sysmgr.dao.SiteDao;
/*  5:   */ import com.portal.sysmgr.entity.Site;
/*  6:   */ import java.util.Iterator;
/*  7:   */ import java.util.List;
/*  8:   */ import org.hibernate.Criteria;
/*  9:   */ import org.hibernate.Query;
/* 10:   */ import org.hibernate.Session;
/* 11:   */ import org.hibernate.criterion.Criterion;
/* 12:   */ import org.hibernate.criterion.Order;
/* 13:   */ import org.hibernate.criterion.Restrictions;
/* 14:   */ import org.springframework.stereotype.Repository;
/* 15:   */ 
/* 16:   */ @Repository
/* 17:   */ public class SiteDaoImpl
/* 18:   */   extends HibernateBaseDao<Site, Integer>
/* 19:   */   implements SiteDao
/* 20:   */ {
/* 21:   */   public int siteCount(boolean cacheable)
/* 22:   */   {
/* 23:19 */     String hql = "select count(*) from Site bean";
/* 24:20 */     return 
/* 25:21 */       ((Number)getSession().createQuery(hql).setCacheable(cacheable).iterate().next()).intValue();
/* 26:   */   }
/* 27:   */   
/* 28:   */   public List<Site> getList(boolean cacheable)
/* 29:   */   {
/* 30:25 */     Criteria crit = createCriteria(new Criterion[0]);
/* 31:26 */     crit.addOrder(Order.asc("id"));
/* 32:27 */     crit.setCacheable(cacheable);
/* 33:28 */     return findByCriteria(crit);
/* 34:   */   }
/* 35:   */   
/* 36:   */   public Site findByDomain(String domain, boolean cacheable)
/* 37:   */   {
/* 38:32 */     Criteria crit = createCriteria(new Criterion[0]);
/* 39:33 */     crit.add(Restrictions.eq("domain", domain));
/* 40:34 */     crit.setCacheable(cacheable);
/* 41:35 */     return (Site)findUnique(crit);
/* 42:   */   }
/* 43:   */   
/* 44:   */   public Site findById(Integer id)
/* 45:   */   {
/* 46:39 */     Site entity = (Site)get(id);
/* 47:40 */     return entity;
/* 48:   */   }
/* 49:   */   
/* 50:   */   public Site save(Site bean)
/* 51:   */   {
/* 52:44 */     getSession().save(bean);
/* 53:45 */     return bean;
/* 54:   */   }
/* 55:   */   
/* 56:   */   public Site deleteById(Integer id)
/* 57:   */   {
/* 58:49 */     Site entity = (Site)super.get(id);
/* 59:50 */     if (entity != null) {
/* 60:51 */       getSession().delete(entity);
/* 61:   */     }
/* 62:53 */     return entity;
/* 63:   */   }
/* 64:   */   
/* 65:   */   public Site getByDomain(String domain)
/* 66:   */   {
/* 67:57 */     String hql = "from Site bean where bean.domain=?";
/* 68:58 */     return (Site)findUniqueByProperty(hql, domain);
/* 69:   */   }
/* 70:   */   
/* 71:   */   protected Class<Site> getEntityClass()
/* 72:   */   {
/* 73:63 */     return Site.class;
/* 74:   */   }
/* 75:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.sysmgr.dao.impl.SiteDaoImpl
 * JD-Core Version:    0.7.0.1
 */