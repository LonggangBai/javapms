/*  1:   */ package com.portal.datacenter.operatedata.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Finder;
/*  4:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  5:   */ import com.javapms.basic.page.Pagination;
/*  6:   */ import com.portal.datacenter.operatedata.dao.LogDao;
/*  7:   */ import com.portal.datacenter.operatedata.entity.Log;
/*  8:   */ import java.util.Date;
/*  9:   */ import org.apache.commons.lang.StringUtils;
/* 10:   */ import org.hibernate.Criteria;
/* 11:   */ import org.hibernate.Query;
/* 12:   */ import org.hibernate.Session;
/* 13:   */ import org.hibernate.criterion.Criterion;
/* 14:   */ import org.hibernate.criterion.Order;
/* 15:   */ import org.hibernate.criterion.Restrictions;
/* 16:   */ import org.springframework.stereotype.Repository;
/* 17:   */ 
/* 18:   */ @Repository
/* 19:   */ public class LogDaoImpl
/* 20:   */   extends HibernateBaseDao<Log, Integer>
/* 21:   */   implements LogDao
/* 22:   */ {
/* 23:   */   public Pagination getPage(Integer category, Integer siteId, Integer userId, String title, String ip, int pageNo, int pageSize)
/* 24:   */   {
/* 25:23 */     Criteria crit = createCriteria(new Criterion[0]);
/* 26:24 */     if (category != null) {
/* 27:25 */       crit.add(Restrictions.eq("category", category));
/* 28:   */     }
/* 29:27 */     if (siteId != null) {
/* 30:28 */       crit.add(Restrictions.eq("site.id", siteId));
/* 31:   */     }
/* 32:30 */     if (userId != null) {
/* 33:31 */       crit.add(Restrictions.eq("user.id", userId));
/* 34:   */     }
/* 35:33 */     if (StringUtils.isNotBlank(title)) {
/* 36:34 */       crit.add(Restrictions.like("title", "%" + title + "%"));
/* 37:   */     }
/* 38:36 */     if (StringUtils.isNotBlank(ip)) {
/* 39:37 */       crit.add(Restrictions.like("ip", ip + "%"));
/* 40:   */     }
/* 41:39 */     crit.addOrder(Order.desc("id"));
/* 42:40 */     return findByCriteria(crit, pageNo, pageSize);
/* 43:   */   }
/* 44:   */   
/* 45:   */   public Log findById(Integer id)
/* 46:   */   {
/* 47:44 */     Log entity = (Log)get(id);
/* 48:45 */     return entity;
/* 49:   */   }
/* 50:   */   
/* 51:   */   public Log save(Log bean)
/* 52:   */   {
/* 53:49 */     getSession().save(bean);
/* 54:50 */     return bean;
/* 55:   */   }
/* 56:   */   
/* 57:   */   public Log deleteById(Integer id)
/* 58:   */   {
/* 59:54 */     Log entity = (Log)super.get(id);
/* 60:55 */     if (entity != null) {
/* 61:56 */       getSession().delete(entity);
/* 62:   */     }
/* 63:58 */     return entity;
/* 64:   */   }
/* 65:   */   
/* 66:   */   public int deleteBatch(Integer category, Integer siteId, Date before)
/* 67:   */   {
/* 68:62 */     Finder f = Finder.create("delete Log bean where 1=1");
/* 69:63 */     if (category != null)
/* 70:   */     {
/* 71:64 */       f.append(" and bean.category=:category");
/* 72:65 */       f.setParam("category", category);
/* 73:   */     }
/* 74:67 */     if (siteId != null)
/* 75:   */     {
/* 76:68 */       f.append(" and bean.site.id=:siteId");
/* 77:69 */       f.setParam("siteId", siteId);
/* 78:   */     }
/* 79:71 */     if (before != null)
/* 80:   */     {
/* 81:72 */       f.append(" and bean.time<=:before");
/* 82:73 */       f.setParam("before", before);
/* 83:   */     }
/* 84:75 */     Query q = f.createQuery(getSession());
/* 85:76 */     return q.executeUpdate();
/* 86:   */   }
/* 87:   */   
/* 88:   */   protected Class<Log> getEntityClass()
/* 89:   */   {
/* 90:81 */     return Log.class;
/* 91:   */   }
/* 92:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.operatedata.dao.impl.LogDaoImpl
 * JD-Core Version:    0.7.0.1
 */