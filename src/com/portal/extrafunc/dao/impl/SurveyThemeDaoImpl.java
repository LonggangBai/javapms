/*  1:   */ package com.portal.extrafunc.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.extrafunc.dao.SurveyThemeDao;
/*  6:   */ import com.portal.extrafunc.entity.SurveyTheme;
/*  7:   */ import java.util.List;
/*  8:   */ import org.hibernate.Criteria;
/*  9:   */ import org.hibernate.Session;
/* 10:   */ import org.hibernate.criterion.Criterion;
/* 11:   */ import org.hibernate.criterion.Order;
/* 12:   */ import org.hibernate.criterion.Restrictions;
/* 13:   */ import org.springframework.stereotype.Repository;
/* 14:   */ 
/* 15:   */ @Repository
/* 16:   */ public class SurveyThemeDaoImpl
/* 17:   */   extends HibernateBaseDao<SurveyTheme, Integer>
/* 18:   */   implements SurveyThemeDao
/* 19:   */ {
/* 20:   */   public Pagination getPage(Integer naireId, int pageNo, int pageSize)
/* 21:   */   {
/* 22:19 */     Criteria crit = createCriteria(new Criterion[0]);
/* 23:20 */     crit.add(Restrictions.eq("naire.id", naireId));
/* 24:21 */     crit.addOrder(Order.asc("priority"));
/* 25:22 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 26:23 */     return page;
/* 27:   */   }
/* 28:   */   
/* 29:   */   public List<SurveyTheme> getList(Integer naireId)
/* 30:   */   {
/* 31:27 */     Criteria crit = createCriteria(new Criterion[0]);
/* 32:28 */     crit.add(Restrictions.eq("naire.id", naireId));
/* 33:29 */     crit.addOrder(Order.asc("priority"));
/* 34:30 */     return findByCriteria(crit);
/* 35:   */   }
/* 36:   */   
/* 37:   */   public SurveyTheme findById(Integer id)
/* 38:   */   {
/* 39:34 */     SurveyTheme entity = (SurveyTheme)get(id);
/* 40:35 */     return entity;
/* 41:   */   }
/* 42:   */   
/* 43:   */   public SurveyTheme save(SurveyTheme bean)
/* 44:   */   {
/* 45:39 */     getSession().save(bean);
/* 46:40 */     return bean;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public SurveyTheme deleteById(Integer id)
/* 50:   */   {
/* 51:44 */     SurveyTheme entity = (SurveyTheme)super.get(id);
/* 52:45 */     if (entity != null) {
/* 53:46 */       getSession().delete(entity);
/* 54:   */     }
/* 55:48 */     return entity;
/* 56:   */   }
/* 57:   */   
/* 58:   */   protected Class<SurveyTheme> getEntityClass()
/* 59:   */   {
/* 60:53 */     return SurveyTheme.class;
/* 61:   */   }
/* 62:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.dao.impl.SurveyThemeDaoImpl
 * JD-Core Version:    0.7.0.1
 */