/*  1:   */ package com.portal.extrafunc.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.extrafunc.dao.QuestionnaireDao;
/*  6:   */ import com.portal.extrafunc.entity.Questionnaire;
/*  7:   */ import org.hibernate.Criteria;
/*  8:   */ import org.hibernate.Session;
/*  9:   */ import org.hibernate.criterion.Criterion;
/* 10:   */ import org.hibernate.criterion.Restrictions;
/* 11:   */ import org.springframework.stereotype.Repository;
/* 12:   */ 
/* 13:   */ @Repository
/* 14:   */ public class QuestionnaireDaoImpl
/* 15:   */   extends HibernateBaseDao<Questionnaire, Integer>
/* 16:   */   implements QuestionnaireDao
/* 17:   */ {
/* 18:   */   public Pagination getPage(Integer siteId, boolean enable, int pageNo, int pageSize)
/* 19:   */   {
/* 20:17 */     Criteria crit = createCriteria(new Criterion[0]);
/* 21:18 */     crit.add(Restrictions.eq("site.id", siteId));
/* 22:19 */     if (enable) {
/* 23:20 */       crit.add(Restrictions.eq("enable", Boolean.valueOf(true)));
/* 24:   */     }
/* 25:22 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 26:23 */     return page;
/* 27:   */   }
/* 28:   */   
/* 29:   */   public Questionnaire findById(Integer id)
/* 30:   */   {
/* 31:27 */     Questionnaire entity = (Questionnaire)get(id);
/* 32:28 */     return entity;
/* 33:   */   }
/* 34:   */   
/* 35:   */   public Questionnaire save(Questionnaire bean)
/* 36:   */   {
/* 37:32 */     getSession().save(bean);
/* 38:33 */     return bean;
/* 39:   */   }
/* 40:   */   
/* 41:   */   public Questionnaire deleteById(Integer id)
/* 42:   */   {
/* 43:37 */     Questionnaire entity = (Questionnaire)super.get(id);
/* 44:38 */     if (entity != null) {
/* 45:39 */       getSession().delete(entity);
/* 46:   */     }
/* 47:41 */     return entity;
/* 48:   */   }
/* 49:   */   
/* 50:   */   protected Class<Questionnaire> getEntityClass()
/* 51:   */   {
/* 52:46 */     return Questionnaire.class;
/* 53:   */   }
/* 54:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.dao.impl.QuestionnaireDaoImpl
 * JD-Core Version:    0.7.0.1
 */