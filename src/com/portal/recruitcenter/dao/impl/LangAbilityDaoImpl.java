/*  1:   */ package com.portal.recruitcenter.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.recruitcenter.dao.LangAbilityDao;
/*  6:   */ import com.portal.recruitcenter.entity.LangAbility;
/*  7:   */ import org.hibernate.Criteria;
/*  8:   */ import org.hibernate.Query;
/*  9:   */ import org.hibernate.Session;
/* 10:   */ import org.hibernate.criterion.Criterion;
/* 11:   */ import org.hibernate.criterion.Order;
/* 12:   */ import org.hibernate.criterion.Restrictions;
/* 13:   */ import org.springframework.stereotype.Repository;
/* 14:   */ 
/* 15:   */ @Repository
/* 16:   */ public class LangAbilityDaoImpl
/* 17:   */   extends HibernateBaseDao<LangAbility, Integer>
/* 18:   */   implements LangAbilityDao
/* 19:   */ {
/* 20:   */   public Pagination getPage(Integer resuneId, int pageNo, int pageSize)
/* 21:   */   {
/* 22:17 */     Criteria crit = createCriteria(new Criterion[0]);
/* 23:18 */     crit.add(Restrictions.eq("resume.id", resuneId));
/* 24:19 */     crit.addOrder(Order.asc("id"));
/* 25:20 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 26:21 */     return page;
/* 27:   */   }
/* 28:   */   
/* 29:   */   public int deleteByPersonalId(Integer personalId)
/* 30:   */   {
/* 31:25 */     String hql = "delete from LangAbility bean where bean.resume.id in (select r.id from Resume r where r.personal.id=:personalId)";
/* 32:   */     
/* 33:27 */     return getSession().createQuery(hql)
/* 34:28 */       .setParameter("personalId", personalId).executeUpdate();
/* 35:   */   }
/* 36:   */   
/* 37:   */   public int deleteByResumeId(Integer resumeId)
/* 38:   */   {
/* 39:32 */     String hql = "delete from LangAbility bean where bean.resume.id=:resumeId";
/* 40:33 */     return getSession().createQuery(hql).setParameter("resumeId", resumeId)
/* 41:34 */       .executeUpdate();
/* 42:   */   }
/* 43:   */   
/* 44:   */   public int deleteByLangId(Integer langId)
/* 45:   */   {
/* 46:38 */     String hql = "delete from LangAbility bean where bean.lang.id=:langId";
/* 47:39 */     return getSession().createQuery(hql).setParameter("langId", langId)
/* 48:40 */       .executeUpdate();
/* 49:   */   }
/* 50:   */   
/* 51:   */   public LangAbility findById(Integer id)
/* 52:   */   {
/* 53:44 */     LangAbility entity = (LangAbility)get(id);
/* 54:45 */     return entity;
/* 55:   */   }
/* 56:   */   
/* 57:   */   public LangAbility save(LangAbility bean)
/* 58:   */   {
/* 59:49 */     getSession().save(bean);
/* 60:50 */     return bean;
/* 61:   */   }
/* 62:   */   
/* 63:   */   public LangAbility deleteById(Integer id)
/* 64:   */   {
/* 65:54 */     LangAbility entity = (LangAbility)super.get(id);
/* 66:55 */     if (entity != null) {
/* 67:56 */       getSession().delete(entity);
/* 68:   */     }
/* 69:58 */     return entity;
/* 70:   */   }
/* 71:   */   
/* 72:   */   protected Class<LangAbility> getEntityClass()
/* 73:   */   {
/* 74:63 */     return LangAbility.class;
/* 75:   */   }
/* 76:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.dao.impl.LangAbilityDaoImpl
 * JD-Core Version:    0.7.0.1
 */