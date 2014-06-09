/*  1:   */ package com.portal.usermgr.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.usermgr.dao.SiteMessageDao;
/*  6:   */ import com.portal.usermgr.entity.SiteMessage;
/*  7:   */ import java.util.Iterator;
/*  8:   */ import org.hibernate.Criteria;
/*  9:   */ import org.hibernate.Query;
/* 10:   */ import org.hibernate.Session;
/* 11:   */ import org.hibernate.criterion.Criterion;
/* 12:   */ import org.hibernate.criterion.Order;
/* 13:   */ import org.hibernate.criterion.Restrictions;
/* 14:   */ import org.springframework.stereotype.Repository;
/* 15:   */ 
/* 16:   */ @Repository
/* 17:   */ public class SiteMessageDaoImpl
/* 18:   */   extends HibernateBaseDao<SiteMessage, Integer>
/* 19:   */   implements SiteMessageDao
/* 20:   */ {
/* 21:   */   public Pagination getPage(int pageNo, int pageSize)
/* 22:   */   {
/* 23:18 */     Criteria crit = createCriteria(new Criterion[0]);
/* 24:19 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 25:20 */     return page;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public Pagination getPageByTag(Integer fromId, Integer toId, Integer allId, Integer replyId, int pageNo, int pageSize)
/* 29:   */   {
/* 30:25 */     Criteria crit = createCriteria(new Criterion[0]);
/* 31:26 */     if (fromId != null)
/* 32:   */     {
/* 33:27 */       crit.add(Restrictions.eq("fromUser.id", fromId));
/* 34:28 */       crit.add(Restrictions.eq("deleteFrom", Boolean.valueOf(false)));
/* 35:   */     }
/* 36:30 */     if (toId != null)
/* 37:   */     {
/* 38:31 */       crit.add(Restrictions.eq("toUser.id", toId));
/* 39:32 */       crit.add(Restrictions.eq("deleteTo", Boolean.valueOf(false)));
/* 40:   */     }
/* 41:34 */     if (replyId != null) {
/* 42:35 */       crit.add(Restrictions.eq("reply.id", replyId));
/* 43:   */     }
/* 44:37 */     crit.addOrder(Order.asc("read"));
/* 45:38 */     crit.addOrder(Order.desc("createTime"));
/* 46:39 */     return findByCriteria(crit, pageNo, pageSize);
/* 47:   */   }
/* 48:   */   
/* 49:   */   public int countByFromId(Integer userId)
/* 50:   */   {
/* 51:43 */     String hql = "select count(*) from SiteMessage bean where bean.fromUser.id=:userId";
/* 52:   */     
/* 53:45 */     Query query = getSession().createQuery(hql);
/* 54:46 */     query.setParameter("userId", userId);
/* 55:47 */     return ((Number)query.iterate().next()).intValue();
/* 56:   */   }
/* 57:   */   
/* 58:   */   public int countByToId(Integer userId)
/* 59:   */   {
/* 60:51 */     String hql = "select count(*) from SiteMessage bean where bean.toUser.id=:userId";
/* 61:   */     
/* 62:53 */     Query query = getSession().createQuery(hql);
/* 63:54 */     query.setParameter("userId", userId);
/* 64:55 */     return ((Number)query.iterate().next()).intValue();
/* 65:   */   }
/* 66:   */   
/* 67:   */   public int deleteByUserId(Integer userId)
/* 68:   */   {
/* 69:59 */     String hql = "delete from SiteMessage bean where bean.fromUser.id=:userId or bean.toUser.id=:userId";
/* 70:   */     
/* 71:61 */     return getSession().createQuery(hql).setParameter("userId", userId)
/* 72:62 */       .executeUpdate();
/* 73:   */   }
/* 74:   */   
/* 75:   */   public SiteMessage findById(Integer id)
/* 76:   */   {
/* 77:66 */     SiteMessage entity = (SiteMessage)get(id);
/* 78:67 */     return entity;
/* 79:   */   }
/* 80:   */   
/* 81:   */   public SiteMessage save(SiteMessage bean)
/* 82:   */   {
/* 83:71 */     getSession().save(bean);
/* 84:72 */     return bean;
/* 85:   */   }
/* 86:   */   
/* 87:   */   public SiteMessage deleteById(Integer id)
/* 88:   */   {
/* 89:76 */     SiteMessage entity = (SiteMessage)super.get(id);
/* 90:77 */     if (entity != null) {
/* 91:78 */       getSession().delete(entity);
/* 92:   */     }
/* 93:80 */     return entity;
/* 94:   */   }
/* 95:   */   
/* 96:   */   protected Class<SiteMessage> getEntityClass()
/* 97:   */   {
/* 98:85 */     return SiteMessage.class;
/* 99:   */   }
/* :0:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.dao.impl.SiteMessageDaoImpl
 * JD-Core Version:    0.7.0.1
 */