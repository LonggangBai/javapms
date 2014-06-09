/*  1:   */ package com.portal.datacenter.commdata.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.datacenter.commdata.dao.ProfessPostDao;
/*  6:   */ import com.portal.datacenter.commdata.entity.ProfessPost;
/*  7:   */ import java.util.List;
/*  8:   */ import org.hibernate.Criteria;
/*  9:   */ import org.hibernate.Session;
/* 10:   */ import org.hibernate.criterion.Criterion;
/* 11:   */ import org.hibernate.criterion.Order;
/* 12:   */ import org.hibernate.criterion.Restrictions;
/* 13:   */ import org.springframework.stereotype.Repository;
/* 14:   */ 
/* 15:   */ @Repository
/* 16:   */ public class ProfessPostDaoImpl
/* 17:   */   extends HibernateBaseDao<ProfessPost, Integer>
/* 18:   */   implements ProfessPostDao
/* 19:   */ {
/* 20:   */   public Pagination getPage(int pageNo, int pageSize)
/* 21:   */   {
/* 22:19 */     Criteria crit = createCriteria(new Criterion[0]);
/* 23:20 */     crit.addOrder(Order.asc("code"));
/* 24:21 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 25:22 */     return page;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public List<ProfessPost> getProfessPostList(Integer id)
/* 29:   */   {
/* 30:26 */     Criteria crit = createCriteria(new Criterion[0]);
/* 31:27 */     if (id != null) {
/* 32:28 */       crit.add(Restrictions.ne("id", id));
/* 33:   */     }
/* 34:30 */     crit.addOrder(Order.asc("code"));
/* 35:31 */     return findByCriteria(crit);
/* 36:   */   }
/* 37:   */   
/* 38:   */   public ProfessPost findById(Integer id)
/* 39:   */   {
/* 40:35 */     ProfessPost entity = (ProfessPost)get(id);
/* 41:36 */     return entity;
/* 42:   */   }
/* 43:   */   
/* 44:   */   public ProfessPost save(ProfessPost bean)
/* 45:   */   {
/* 46:40 */     getSession().save(bean);
/* 47:41 */     return bean;
/* 48:   */   }
/* 49:   */   
/* 50:   */   public ProfessPost deleteById(Integer id)
/* 51:   */   {
/* 52:45 */     ProfessPost entity = (ProfessPost)super.get(id);
/* 53:46 */     if (entity != null) {
/* 54:47 */       getSession().delete(entity);
/* 55:   */     }
/* 56:49 */     return entity;
/* 57:   */   }
/* 58:   */   
/* 59:   */   protected Class<ProfessPost> getEntityClass()
/* 60:   */   {
/* 61:54 */     return ProfessPost.class;
/* 62:   */   }
/* 63:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.commdata.dao.impl.ProfessPostDaoImpl
 * JD-Core Version:    0.7.0.1
 */