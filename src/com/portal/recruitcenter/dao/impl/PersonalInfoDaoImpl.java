/*  1:   */ package com.portal.recruitcenter.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.recruitcenter.dao.PersonalInfoDao;
/*  6:   */ import com.portal.recruitcenter.entity.PersonalInfo;
/*  7:   */ import java.util.Date;
/*  8:   */ import org.hibernate.Criteria;
/*  9:   */ import org.hibernate.Session;
/* 10:   */ import org.hibernate.criterion.Criterion;
/* 11:   */ import org.springframework.stereotype.Repository;
/* 12:   */ 
/* 13:   */ @Repository
/* 14:   */ public class PersonalInfoDaoImpl
/* 15:   */   extends HibernateBaseDao<PersonalInfo, Integer>
/* 16:   */   implements PersonalInfoDao
/* 17:   */ {
/* 18:   */   public Pagination getPage(int pageNo, int pageSize)
/* 19:   */   {
/* 20:17 */     Criteria crit = createCriteria(new Criterion[0]);
/* 21:18 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 22:19 */     return page;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public Pagination getPageBySelect(int pageNo, int pageSize)
/* 26:   */   {
/* 27:27 */     return null;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public Pagination getPageBySelect(String key, Integer specialId, Integer industryId, Date startTime, Date endTime, int pageNo, int pageSize)
/* 31:   */   {
/* 32:66 */     return null;
/* 33:   */   }
/* 34:   */   
/* 35:   */   public PersonalInfo findById(Integer id)
/* 36:   */   {
/* 37:70 */     PersonalInfo entity = (PersonalInfo)get(id);
/* 38:71 */     return entity;
/* 39:   */   }
/* 40:   */   
/* 41:   */   public PersonalInfo save(PersonalInfo bean)
/* 42:   */   {
/* 43:75 */     getSession().save(bean);
/* 44:76 */     return bean;
/* 45:   */   }
/* 46:   */   
/* 47:   */   public PersonalInfo deleteById(Integer id)
/* 48:   */   {
/* 49:80 */     PersonalInfo entity = (PersonalInfo)super.get(id);
/* 50:81 */     if (entity != null) {
/* 51:82 */       getSession().delete(entity);
/* 52:   */     }
/* 53:84 */     return entity;
/* 54:   */   }
/* 55:   */   
/* 56:   */   protected Class<PersonalInfo> getEntityClass()
/* 57:   */   {
/* 58:89 */     return PersonalInfo.class;
/* 59:   */   }
/* 60:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.dao.impl.PersonalInfoDaoImpl
 * JD-Core Version:    0.7.0.1
 */