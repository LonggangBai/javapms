/*  1:   */ package com.portal.recruitcenter.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.recruitcenter.dao.PersonalInfoExtDao;
/*  6:   */ import com.portal.recruitcenter.entity.PersonalInfoExt;
/*  7:   */ import org.hibernate.Criteria;
/*  8:   */ import org.hibernate.Session;
/*  9:   */ import org.hibernate.criterion.Criterion;
/* 10:   */ import org.springframework.stereotype.Repository;
/* 11:   */ 
/* 12:   */ @Repository
/* 13:   */ public class PersonalInfoExtDaoImpl
/* 14:   */   extends HibernateBaseDao<PersonalInfoExt, Integer>
/* 15:   */   implements PersonalInfoExtDao
/* 16:   */ {
/* 17:   */   public Pagination getPage(int pageNo, int pageSize)
/* 18:   */   {
/* 19:14 */     Criteria crit = createCriteria(new Criterion[0]);
/* 20:15 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 21:16 */     return page;
/* 22:   */   }
/* 23:   */   
/* 24:   */   public PersonalInfoExt findById(Integer id)
/* 25:   */   {
/* 26:20 */     PersonalInfoExt entity = (PersonalInfoExt)get(id);
/* 27:21 */     return entity;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public PersonalInfoExt save(PersonalInfoExt bean)
/* 31:   */   {
/* 32:25 */     getSession().save(bean);
/* 33:26 */     return bean;
/* 34:   */   }
/* 35:   */   
/* 36:   */   public PersonalInfoExt deleteById(Integer id)
/* 37:   */   {
/* 38:30 */     PersonalInfoExt entity = (PersonalInfoExt)super.get(id);
/* 39:31 */     if (entity != null) {
/* 40:32 */       getSession().delete(entity);
/* 41:   */     }
/* 42:34 */     return entity;
/* 43:   */   }
/* 44:   */   
/* 45:   */   protected Class<PersonalInfoExt> getEntityClass()
/* 46:   */   {
/* 47:39 */     return PersonalInfoExt.class;
/* 48:   */   }
/* 49:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.dao.impl.PersonalInfoExtDaoImpl
 * JD-Core Version:    0.7.0.1
 */