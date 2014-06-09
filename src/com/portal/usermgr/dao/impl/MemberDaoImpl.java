/*  1:   */ package com.portal.usermgr.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.usermgr.dao.MemberDao;
/*  6:   */ import com.portal.usermgr.entity.Member;
/*  7:   */ import org.apache.commons.lang.StringUtils;
/*  8:   */ import org.hibernate.Criteria;
/*  9:   */ import org.hibernate.Session;
/* 10:   */ import org.hibernate.criterion.Criterion;
/* 11:   */ import org.hibernate.criterion.Order;
/* 12:   */ import org.hibernate.criterion.Restrictions;
/* 13:   */ import org.springframework.stereotype.Repository;
/* 14:   */ 
/* 15:   */ @Repository
/* 16:   */ public class MemberDaoImpl
/* 17:   */   extends HibernateBaseDao<Member, Integer>
/* 18:   */   implements MemberDao
/* 19:   */ {
/* 20:   */   public Pagination getPage(int pageNo, int pageSize)
/* 21:   */   {
/* 22:18 */     Criteria crit = createCriteria(new Criterion[0]);
/* 23:19 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 24:20 */     return page;
/* 25:   */   }
/* 26:   */   
/* 27:   */   public Pagination getPage(String key, Integer siteId, Integer groupId, String sortname, String sortorder, int pageNo, int pageSize)
/* 28:   */   {
/* 29:25 */     Criteria crit = createCriteria(new Criterion[0]);
/* 30:26 */     if (groupId != null)
/* 31:   */     {
/* 32:27 */       crit.createAlias("groups", "g");
/* 33:28 */       crit.add(Restrictions.eq("g.id", groupId));
/* 34:   */     }
/* 35:29 */     else if (siteId != null)
/* 36:   */     {
/* 37:30 */       crit.createAlias("groups", "g");
/* 38:31 */       crit.add(Restrictions.eq("g.site.id", siteId));
/* 39:   */     }
/* 40:33 */     if (!StringUtils.isBlank(key)) {
/* 41:34 */       crit.add(Restrictions.or(
/* 42:35 */         Restrictions.like("user.username", "%" + key + "%"), 
/* 43:36 */         Restrictions.like("user.realName", "%" + key + "%")));
/* 44:   */     }
/* 45:38 */     if (!StringUtils.isBlank(sortname))
/* 46:   */     {
/* 47:39 */       crit.createAlias("user", "u");
/* 48:40 */       if ("asc".equals(sortorder)) {
/* 49:41 */         crit.addOrder(Order.asc(sortname));
/* 50:   */       } else {
/* 51:43 */         crit.addOrder(Order.desc(sortname));
/* 52:   */       }
/* 53:   */     }
/* 54:   */     else
/* 55:   */     {
/* 56:46 */       crit.addOrder(Order.desc("registerTime"));
/* 57:   */     }
/* 58:48 */     return findByCriteria(crit, pageNo, pageSize);
/* 59:   */   }
/* 60:   */   
/* 61:   */   public Member findById(Integer id)
/* 62:   */   {
/* 63:52 */     Member entity = (Member)get(id);
/* 64:53 */     return entity;
/* 65:   */   }
/* 66:   */   
/* 67:   */   public Member save(Member bean)
/* 68:   */   {
/* 69:57 */     getSession().save(bean);
/* 70:58 */     return bean;
/* 71:   */   }
/* 72:   */   
/* 73:   */   public Member deleteById(Integer id)
/* 74:   */   {
/* 75:62 */     Member entity = (Member)super.get(id);
/* 76:63 */     if (entity != null) {
/* 77:64 */       getSession().delete(entity);
/* 78:   */     }
/* 79:66 */     return entity;
/* 80:   */   }
/* 81:   */   
/* 82:   */   protected Class<Member> getEntityClass()
/* 83:   */   {
/* 84:71 */     return Member.class;
/* 85:   */   }
/* 86:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.dao.impl.MemberDaoImpl
 * JD-Core Version:    0.7.0.1
 */