/*  1:   */ package com.portal.doccenter.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.portal.doccenter.dao.ArticleTypeDao;
/*  5:   */ import com.portal.doccenter.entity.ArticleType;
/*  6:   */ import java.util.List;
/*  7:   */ import org.apache.commons.lang.StringUtils;
/*  8:   */ import org.hibernate.Criteria;
/*  9:   */ import org.hibernate.Session;
/* 10:   */ import org.hibernate.criterion.Criterion;
/* 11:   */ import org.hibernate.criterion.Order;
/* 12:   */ import org.hibernate.criterion.Restrictions;
/* 13:   */ import org.springframework.stereotype.Repository;
/* 14:   */ 
/* 15:   */ @Repository
/* 16:   */ public class ArticleTypeDaoImpl
/* 17:   */   extends HibernateBaseDao<ArticleType, Integer>
/* 18:   */   implements ArticleTypeDao
/* 19:   */ {
/* 20:   */   public List<ArticleType> getList(boolean containDisabled, String sortname, String sortorder)
/* 21:   */   {
/* 22:20 */     Criteria crit = createCriteria(new Criterion[0]);
/* 23:21 */     crit.add(Restrictions.eq("disabled", Boolean.valueOf(false)));
/* 24:22 */     if (!StringUtils.isBlank(sortname))
/* 25:   */     {
/* 26:23 */       if ("asc".equals(sortorder)) {
/* 27:24 */         crit.addOrder(Order.asc(sortname));
/* 28:   */       } else {
/* 29:26 */         crit.addOrder(Order.desc(sortname));
/* 30:   */       }
/* 31:   */     }
/* 32:   */     else {
/* 33:29 */       crit.addOrder(Order.asc("id"));
/* 34:   */     }
/* 35:31 */     return findByCriteria(crit);
/* 36:   */   }
/* 37:   */   
/* 38:   */   public ArticleType getDef()
/* 39:   */   {
/* 40:35 */     Criteria crit = createCriteria(new Criterion[0]);
/* 41:36 */     crit.add(Restrictions.eq("disabled", Boolean.valueOf(false)));
/* 42:37 */     crit.addOrder(Order.asc("id"));
/* 43:38 */     return (ArticleType)findUnique(crit);
/* 44:   */   }
/* 45:   */   
/* 46:   */   public ArticleType findById(Integer id)
/* 47:   */   {
/* 48:42 */     ArticleType entity = (ArticleType)get(id);
/* 49:43 */     return entity;
/* 50:   */   }
/* 51:   */   
/* 52:   */   public ArticleType save(ArticleType bean)
/* 53:   */   {
/* 54:47 */     getSession().save(bean);
/* 55:48 */     return bean;
/* 56:   */   }
/* 57:   */   
/* 58:   */   public ArticleType deleteById(Integer id)
/* 59:   */   {
/* 60:52 */     ArticleType entity = (ArticleType)super.get(id);
/* 61:53 */     if (entity != null) {
/* 62:54 */       getSession().delete(entity);
/* 63:   */     }
/* 64:56 */     return entity;
/* 65:   */   }
/* 66:   */   
/* 67:   */   protected Class<ArticleType> getEntityClass()
/* 68:   */   {
/* 69:61 */     return ArticleType.class;
/* 70:   */   }
/* 71:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.dao.impl.ArticleTypeDaoImpl
 * JD-Core Version:    0.7.0.1
 */