/*  1:   */ package com.portal.extrafunc.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.extrafunc.dao.QuestionDetailDao;
/*  6:   */ import com.portal.extrafunc.entity.QuestionDetail;
/*  7:   */ import org.apache.commons.lang.StringUtils;
/*  8:   */ import org.hibernate.Criteria;
/*  9:   */ import org.hibernate.Session;
/* 10:   */ import org.hibernate.criterion.Criterion;
/* 11:   */ import org.hibernate.criterion.Order;
/* 12:   */ import org.hibernate.criterion.Projections;
/* 13:   */ import org.hibernate.criterion.Restrictions;
/* 14:   */ import org.springframework.stereotype.Repository;
/* 15:   */ 
/* 16:   */ @Repository
/* 17:   */ public class QuestionDetailDaoImpl
/* 18:   */   extends HibernateBaseDao<QuestionDetail, Integer>
/* 19:   */   implements QuestionDetailDao
/* 20:   */ {
/* 21:   */   public Pagination getPage(Integer questionId, int pageNo, int pageSize)
/* 22:   */   {
/* 23:19 */     Criteria crit = createCriteria(new Criterion[0]);
/* 24:20 */     if (questionId != null) {
/* 25:21 */       crit.add(Restrictions.eq("question.id", questionId));
/* 26:   */     }
/* 27:23 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 28:24 */     return page;
/* 29:   */   }
/* 30:   */   
/* 31:   */   public QuestionDetail getDetail(Integer questionId, Integer userId, String ip)
/* 32:   */   {
/* 33:29 */     Criteria crit = createCriteria(new Criterion[0]);
/* 34:30 */     if (questionId != null) {
/* 35:31 */       crit.add(Restrictions.eq("question.id", questionId));
/* 36:   */     }
/* 37:33 */     if (userId != null) {
/* 38:34 */       crit.add(Restrictions.eq("user.id", userId));
/* 39:   */     }
/* 40:36 */     if (!StringUtils.isBlank(ip)) {
/* 41:37 */       crit.add(Restrictions.eq("ip", ip));
/* 42:   */     }
/* 43:39 */     crit.addOrder(Order.desc("createTime"));
/* 44:40 */     return (QuestionDetail)findUnique(crit);
/* 45:   */   }
/* 46:   */   
/* 47:   */   public long getCountDetail(Integer questionId)
/* 48:   */   {
/* 49:44 */     Criteria crit = createCriteria(new Criterion[0]);
/* 50:45 */     if (questionId != null) {
/* 51:46 */       crit.add(Restrictions.eq("question.id", questionId));
/* 52:   */     }
/* 53:48 */     crit.setProjection(Projections.count("id"));
/* 54:49 */     return ((Long)crit.uniqueResult()).longValue();
/* 55:   */   }
/* 56:   */   
/* 57:   */   public QuestionDetail findById(Integer id)
/* 58:   */   {
/* 59:53 */     QuestionDetail entity = (QuestionDetail)get(id);
/* 60:54 */     return entity;
/* 61:   */   }
/* 62:   */   
/* 63:   */   public QuestionDetail save(QuestionDetail bean)
/* 64:   */   {
/* 65:58 */     getSession().save(bean);
/* 66:59 */     return bean;
/* 67:   */   }
/* 68:   */   
/* 69:   */   public QuestionDetail deleteById(Integer id)
/* 70:   */   {
/* 71:63 */     QuestionDetail entity = (QuestionDetail)super.get(id);
/* 72:64 */     if (entity != null) {
/* 73:65 */       getSession().delete(entity);
/* 74:   */     }
/* 75:67 */     return entity;
/* 76:   */   }
/* 77:   */   
/* 78:   */   protected Class<QuestionDetail> getEntityClass()
/* 79:   */   {
/* 80:72 */     return QuestionDetail.class;
/* 81:   */   }
/* 82:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.dao.impl.QuestionDetailDaoImpl
 * JD-Core Version:    0.7.0.1
 */