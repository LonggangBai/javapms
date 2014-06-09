/*  1:   */ package com.portal.doccenter.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.doccenter.dao.WorkFlowDao;
/*  6:   */ import com.portal.doccenter.entity.WorkFlow;
/*  7:   */ import java.util.List;
/*  8:   */ import org.apache.commons.lang.StringUtils;
/*  9:   */ import org.hibernate.Criteria;
/* 10:   */ import org.hibernate.Session;
/* 11:   */ import org.hibernate.criterion.Criterion;
/* 12:   */ import org.hibernate.criterion.Order;
/* 13:   */ import org.hibernate.criterion.Restrictions;
/* 14:   */ import org.springframework.stereotype.Repository;
/* 15:   */ 
/* 16:   */ @Repository
/* 17:   */ public class WorkFlowDaoImpl
/* 18:   */   extends HibernateBaseDao<WorkFlow, Integer>
/* 19:   */   implements WorkFlowDao
/* 20:   */ {
/* 21:   */   public Pagination getPage(Integer siteId, String sortname, String sortorder, int pageNo, int pageSize)
/* 22:   */   {
/* 23:21 */     Criteria crit = createCriteria(new Criterion[0]);
/* 24:22 */     crit.add(Restrictions.eq("site.id", siteId));
/* 25:23 */     if (!StringUtils.isBlank(sortname))
/* 26:   */     {
/* 27:24 */       if ("asc".equals(sortorder)) {
/* 28:25 */         crit.addOrder(Order.asc(sortname));
/* 29:   */       } else {
/* 30:27 */         crit.addOrder(Order.desc(sortname));
/* 31:   */       }
/* 32:   */     }
/* 33:   */     else {
/* 34:30 */       crit.addOrder(Order.asc("id"));
/* 35:   */     }
/* 36:32 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 37:33 */     return page;
/* 38:   */   }
/* 39:   */   
/* 40:   */   public List<WorkFlow> findByList(Integer siteId)
/* 41:   */   {
/* 42:37 */     Criteria crit = createCriteria(new Criterion[0]);
/* 43:38 */     crit.add(Restrictions.eq("site.id", siteId));
/* 44:39 */     crit.addOrder(Order.desc("createTime"));
/* 45:40 */     return findByCriteria(crit);
/* 46:   */   }
/* 47:   */   
/* 48:   */   public WorkFlow findById(Integer id)
/* 49:   */   {
/* 50:44 */     WorkFlow entity = (WorkFlow)get(id);
/* 51:45 */     return entity;
/* 52:   */   }
/* 53:   */   
/* 54:   */   public WorkFlow save(WorkFlow bean)
/* 55:   */   {
/* 56:49 */     getSession().save(bean);
/* 57:50 */     return bean;
/* 58:   */   }
/* 59:   */   
/* 60:   */   public WorkFlow deleteById(Integer id)
/* 61:   */   {
/* 62:54 */     WorkFlow entity = (WorkFlow)super.get(id);
/* 63:55 */     if (entity != null) {
/* 64:56 */       getSession().delete(entity);
/* 65:   */     }
/* 66:58 */     return entity;
/* 67:   */   }
/* 68:   */   
/* 69:   */   protected Class<WorkFlow> getEntityClass()
/* 70:   */   {
/* 71:63 */     return WorkFlow.class;
/* 72:   */   }
/* 73:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.dao.impl.WorkFlowDaoImpl
 * JD-Core Version:    0.7.0.1
 */