/*  1:   */ package com.portal.usermgr.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.portal.usermgr.dao.UserDao;
/*  5:   */ import com.portal.usermgr.entity.User;
/*  6:   */ import java.util.Iterator;
/*  7:   */ import org.hibernate.Criteria;
/*  8:   */ import org.hibernate.Query;
/*  9:   */ import org.hibernate.Session;
/* 10:   */ import org.hibernate.criterion.Criterion;
/* 11:   */ import org.hibernate.criterion.Restrictions;
/* 12:   */ import org.springframework.stereotype.Repository;
/* 13:   */ 
/* 14:   */ @Repository
/* 15:   */ public class UserDaoImpl
/* 16:   */   extends HibernateBaseDao<User, Integer>
/* 17:   */   implements UserDao
/* 18:   */ {
/* 19:   */   public User findByPersonal(Integer personalId)
/* 20:   */   {
/* 21:16 */     Criteria crit = createCriteria(new Criterion[0]);
/* 22:17 */     crit.add(Restrictions.eq("personal.id", personalId));
/* 23:18 */     return (User)findUnique(crit);
/* 24:   */   }
/* 25:   */   
/* 26:   */   public User findByCompany(Integer companyId)
/* 27:   */   {
/* 28:22 */     Criteria crit = createCriteria(new Criterion[0]);
/* 29:23 */     crit.add(Restrictions.eq("company.id", companyId));
/* 30:24 */     return (User)findUnique(crit);
/* 31:   */   }
/* 32:   */   
/* 33:   */   public User findById(Integer id)
/* 34:   */   {
/* 35:28 */     User entity = (User)get(id);
/* 36:29 */     return entity;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public User findByUsername(String username)
/* 40:   */   {
/* 41:33 */     Criteria crit = createCriteria(new Criterion[0]);
/* 42:34 */     crit.add(Restrictions.eq("username", username));
/* 43:35 */     return (User)findUnique(crit);
/* 44:   */   }
/* 45:   */   
/* 46:   */   public int countByUsername(String username)
/* 47:   */   {
/* 48:39 */     String hql = "select count(*) from PmsUser bean where bean.username=:username";
/* 49:40 */     Query query = getSession().createQuery(hql);
/* 50:41 */     query.setParameter("username", username);
/* 51:42 */     return ((Number)query.iterate().next()).intValue();
/* 52:   */   }
/* 53:   */   
/* 54:   */   public int countByEmail(String email)
/* 55:   */   {
/* 56:46 */     String hql = "select count(*) from PmsUser bean where bean.email=:email";
/* 57:47 */     Query query = getSession().createQuery(hql);
/* 58:48 */     query.setParameter("email", email);
/* 59:49 */     return ((Number)query.iterate().next()).intValue();
/* 60:   */   }
/* 61:   */   
/* 62:   */   public User save(User bean)
/* 63:   */   {
/* 64:53 */     getSession().save(bean);
/* 65:54 */     return bean;
/* 66:   */   }
/* 67:   */   
/* 68:   */   public User deleteById(Integer id)
/* 69:   */   {
/* 70:58 */     User entity = (User)super.get(id);
/* 71:59 */     if (entity != null) {
/* 72:60 */       getSession().delete(entity);
/* 73:   */     }
/* 74:62 */     return entity;
/* 75:   */   }
/* 76:   */   
/* 77:   */   protected Class<User> getEntityClass()
/* 78:   */   {
/* 79:67 */     return User.class;
/* 80:   */   }
/* 81:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.dao.impl.UserDaoImpl
 * JD-Core Version:    0.7.0.1
 */