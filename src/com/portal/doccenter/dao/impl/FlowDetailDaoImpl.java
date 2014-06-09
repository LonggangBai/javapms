/*  1:   */ package com.portal.doccenter.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.doccenter.dao.FlowDetailDao;
/*  6:   */ import com.portal.doccenter.entity.FlowDetail;
/*  7:   */ import org.hibernate.Criteria;
/*  8:   */ import org.hibernate.Session;
/*  9:   */ import org.hibernate.criterion.Criterion;
/* 10:   */ import org.hibernate.criterion.Order;
/* 11:   */ import org.hibernate.criterion.Restrictions;
/* 12:   */ import org.springframework.stereotype.Repository;
/* 13:   */ 
/* 14:   */ @Repository
/* 15:   */ public class FlowDetailDaoImpl
/* 16:   */   extends HibernateBaseDao<FlowDetail, Integer>
/* 17:   */   implements FlowDetailDao
/* 18:   */ {
/* 19:   */   public Pagination getPage(int pageNo, int pageSize)
/* 20:   */   {
/* 21:17 */     Criteria crit = createCriteria(new Criterion[0]);
/* 22:18 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 23:19 */     return page;
/* 24:   */   }
/* 25:   */   
/* 26:   */   public FlowDetail getLastFlowDetail(Integer docId)
/* 27:   */   {
/* 28:23 */     Criteria crit = createCriteria(new Criterion[0]);
/* 29:24 */     crit.add(Restrictions.eq("doc.id", docId));
/* 30:25 */     crit.addOrder(Order.desc("priority"));
/* 31:26 */     return (FlowDetail)findUnique(crit);
/* 32:   */   }
/* 33:   */   
/* 34:   */   public FlowDetail getLastFlowDetail(Integer docId, Integer userId)
/* 35:   */   {
/* 36:30 */     Criteria crit = createCriteria(new Criterion[0]);
/* 37:31 */     crit.add(Restrictions.eq("doc.id", docId));
/* 38:32 */     crit.add(Restrictions.eq("user.id", userId));
/* 39:33 */     crit.add(Restrictions.eq("checked", Boolean.valueOf(true)));
/* 40:34 */     crit.addOrder(Order.desc("priority"));
/* 41:35 */     return (FlowDetail)findUnique(crit);
/* 42:   */   }
/* 43:   */   
/* 44:   */   public FlowDetail getFlowDetailByPri(Integer docId, Integer priority)
/* 45:   */   {
/* 46:39 */     Criteria crit = createCriteria(new Criterion[0]);
/* 47:40 */     crit.add(Restrictions.eq("doc.id", docId));
/* 48:41 */     crit.add(Restrictions.lt("priority", priority));
/* 49:42 */     crit.add(Restrictions.eq("checked", Boolean.valueOf(true)));
/* 50:43 */     crit.addOrder(Order.desc("priority"));
/* 51:44 */     return (FlowDetail)findUnique(crit);
/* 52:   */   }
/* 53:   */   
/* 54:   */   public FlowDetail findById(Integer id)
/* 55:   */   {
/* 56:48 */     FlowDetail entity = (FlowDetail)get(id);
/* 57:49 */     return entity;
/* 58:   */   }
/* 59:   */   
/* 60:   */   public FlowDetail save(FlowDetail bean)
/* 61:   */   {
/* 62:53 */     getSession().save(bean);
/* 63:54 */     return bean;
/* 64:   */   }
/* 65:   */   
/* 66:   */   public FlowDetail deleteById(Integer id)
/* 67:   */   {
/* 68:58 */     FlowDetail entity = (FlowDetail)super.get(id);
/* 69:59 */     if (entity != null) {
/* 70:60 */       getSession().delete(entity);
/* 71:   */     }
/* 72:62 */     return entity;
/* 73:   */   }
/* 74:   */   
/* 75:   */   protected Class<FlowDetail> getEntityClass()
/* 76:   */   {
/* 77:67 */     return FlowDetail.class;
/* 78:   */   }
/* 79:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.dao.impl.FlowDetailDaoImpl
 * JD-Core Version:    0.7.0.1
 */