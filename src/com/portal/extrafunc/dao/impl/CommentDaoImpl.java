/*  1:   */ package com.portal.extrafunc.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.extrafunc.dao.CommentDao;
/*  6:   */ import com.portal.extrafunc.entity.Comment;
/*  7:   */ import org.apache.commons.lang.StringUtils;
/*  8:   */ import org.hibernate.Criteria;
/*  9:   */ import org.hibernate.Query;
/* 10:   */ import org.hibernate.Session;
/* 11:   */ import org.hibernate.criterion.Criterion;
/* 12:   */ import org.hibernate.criterion.Order;
/* 13:   */ import org.hibernate.criterion.Restrictions;
/* 14:   */ import org.springframework.stereotype.Repository;
/* 15:   */ 
/* 16:   */ @Repository
/* 17:   */ public class CommentDaoImpl
/* 18:   */   extends HibernateBaseDao<Comment, Integer>
/* 19:   */   implements CommentDao
/* 20:   */ {
/* 21:   */   public Pagination getPage(Integer siteId, Integer docId, Integer parentId, Boolean checked, int orderBy, String sortname, String sortorder, int pageNo, int pageSize, Boolean noparent, boolean cacheable)
/* 22:   */   {
/* 23:20 */     Criteria crit = createCriteria(new Criterion[0]);
/* 24:21 */     if (parentId != null) {
/* 25:22 */       crit.add(Restrictions.eq("parent.id", parentId));
/* 26:23 */     } else if (docId != null) {
/* 27:24 */       crit.add(Restrictions.eq("doc.id", docId));
/* 28:25 */     } else if (siteId != null) {
/* 29:26 */       crit.add(Restrictions.eq("site.id", siteId));
/* 30:   */     }
/* 31:28 */     if ((noparent != null) && (noparent.booleanValue())) {
/* 32:29 */       crit.add(Restrictions.isNull("parent"));
/* 33:   */     }
/* 34:31 */     if (checked != null) {
/* 35:32 */       crit.add(Restrictions.eq("checked", checked));
/* 36:   */     }
/* 37:34 */     if (orderBy == 1) {
/* 38:35 */       crit.addOrder(Order.desc("ups"));
/* 39:36 */     } else if (orderBy == 2) {
/* 40:37 */       crit.addOrder(Order.desc("lastTime"));
/* 41:39 */     } else if (!StringUtils.isBlank(sortname))
/* 42:   */     {
/* 43:40 */       if ("asc".equals(sortorder)) {
/* 44:41 */         crit.addOrder(Order.asc(sortname));
/* 45:   */       } else {
/* 46:43 */         crit.addOrder(Order.desc(sortname));
/* 47:   */       }
/* 48:   */     }
/* 49:   */     else {
/* 50:46 */       crit.addOrder(Order.desc("createTime"));
/* 51:   */     }
/* 52:49 */     crit.setCacheable(cacheable);
/* 53:50 */     return findByCriteria(crit, pageNo, pageSize);
/* 54:   */   }
/* 55:   */   
/* 56:   */   public Comment findById(Integer id)
/* 57:   */   {
/* 58:54 */     Comment entity = (Comment)get(id);
/* 59:55 */     return entity;
/* 60:   */   }
/* 61:   */   
/* 62:   */   public Comment save(Comment bean)
/* 63:   */   {
/* 64:59 */     getSession().save(bean);
/* 65:60 */     return bean;
/* 66:   */   }
/* 67:   */   
/* 68:   */   public Comment deleteById(Integer id)
/* 69:   */   {
/* 70:64 */     Comment entity = (Comment)super.get(id);
/* 71:65 */     if (entity != null) {
/* 72:66 */       getSession().delete(entity);
/* 73:   */     }
/* 74:68 */     return entity;
/* 75:   */   }
/* 76:   */   
/* 77:   */   public int deleteByDocId(Integer docId)
/* 78:   */   {
/* 79:72 */     String hql = "delete from Comment bean where bean.doc.id=:docId";
/* 80:73 */     return getSession().createQuery(hql).setParameter("docId", docId)
/* 81:74 */       .executeUpdate();
/* 82:   */   }
/* 83:   */   
/* 84:   */   protected Class<Comment> getEntityClass()
/* 85:   */   {
/* 86:79 */     return Comment.class;
/* 87:   */   }
/* 88:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.dao.impl.CommentDaoImpl
 * JD-Core Version:    0.7.0.1
 */