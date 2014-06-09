/*  1:   */ package com.portal.extrafunc.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.extrafunc.dao.SurveyDetailDao;
/*  6:   */ import com.portal.extrafunc.entity.SurveyDetail;
/*  7:   */ import org.hibernate.Criteria;
/*  8:   */ import org.hibernate.Session;
/*  9:   */ import org.hibernate.criterion.Criterion;
/* 10:   */ import org.hibernate.criterion.Order;
/* 11:   */ import org.hibernate.criterion.Restrictions;
/* 12:   */ import org.springframework.stereotype.Repository;
/* 13:   */ 
/* 14:   */ @Repository
/* 15:   */ public class SurveyDetailDaoImpl
/* 16:   */   extends HibernateBaseDao<SurveyDetail, Integer>
/* 17:   */   implements SurveyDetailDao
/* 18:   */ {
/* 19:   */   public Pagination getPage(Integer surveyId, int pageNo, int pageSize)
/* 20:   */   {
/* 21:17 */     Criteria crit = createCriteria(new Criterion[0]);
/* 22:18 */     if (surveyId != null) {
/* 23:19 */       crit.add(Restrictions.eq("survey.id", surveyId));
/* 24:   */     }
/* 25:21 */     crit.addOrder(Order.desc("createTime"));
/* 26:22 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 27:23 */     return page;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public SurveyDetail getDetailByUser(Integer surveyId, Integer userId)
/* 31:   */   {
/* 32:27 */     Criteria crit = createCriteria(new Criterion[0]);
/* 33:28 */     if (surveyId != null) {
/* 34:29 */       crit.add(Restrictions.eq("survey.id", surveyId));
/* 35:   */     }
/* 36:31 */     if (userId != null) {
/* 37:32 */       crit.add(Restrictions.eq("user.id", surveyId));
/* 38:   */     }
/* 39:34 */     return (SurveyDetail)findUnique(crit);
/* 40:   */   }
/* 41:   */   
/* 42:   */   public SurveyDetail findById(Integer id)
/* 43:   */   {
/* 44:38 */     SurveyDetail entity = (SurveyDetail)get(id);
/* 45:39 */     return entity;
/* 46:   */   }
/* 47:   */   
/* 48:   */   public SurveyDetail save(SurveyDetail bean)
/* 49:   */   {
/* 50:43 */     getSession().save(bean);
/* 51:44 */     return bean;
/* 52:   */   }
/* 53:   */   
/* 54:   */   public SurveyDetail deleteById(Integer id)
/* 55:   */   {
/* 56:48 */     SurveyDetail entity = (SurveyDetail)super.get(id);
/* 57:49 */     if (entity != null) {
/* 58:50 */       getSession().delete(entity);
/* 59:   */     }
/* 60:52 */     return entity;
/* 61:   */   }
/* 62:   */   
/* 63:   */   protected Class<SurveyDetail> getEntityClass()
/* 64:   */   {
/* 65:57 */     return SurveyDetail.class;
/* 66:   */   }
/* 67:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.dao.impl.SurveyDetailDaoImpl
 * JD-Core Version:    0.7.0.1
 */