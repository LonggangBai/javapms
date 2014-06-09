/*   1:    */ package com.portal.extrafunc.dao.impl;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*   4:    */ import com.javapms.basic.page.Pagination;
/*   5:    */ import com.portal.extrafunc.dao.ThemeDao;
/*   6:    */ import com.portal.extrafunc.entity.Theme;
/*   7:    */ import java.util.List;
/*   8:    */ import org.hibernate.Criteria;
/*   9:    */ import org.hibernate.Session;
/*  10:    */ import org.hibernate.criterion.Criterion;
/*  11:    */ import org.hibernate.criterion.Order;
/*  12:    */ import org.hibernate.criterion.Restrictions;
/*  13:    */ import org.springframework.stereotype.Repository;
/*  14:    */ 
/*  15:    */ @Repository
/*  16:    */ public class ThemeDaoImpl
/*  17:    */   extends HibernateBaseDao<Theme, Integer>
/*  18:    */   implements ThemeDao
/*  19:    */ {
/*  20:    */   public Pagination getPage(int pageNo, int pageSize)
/*  21:    */   {
/*  22: 19 */     Criteria crit = createCriteria(new Criterion[0]);
/*  23: 20 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/*  24: 21 */     return page;
/*  25:    */   }
/*  26:    */   
/*  27:    */   public Pagination getThemePageForTag(Integer forumId, Integer status, Integer createrId, Integer replyId, int orderBy, int pageNo, int pageSize)
/*  28:    */   {
/*  29: 27 */     Criteria crit = createCriteria(new Criterion[0]);
/*  30: 28 */     if (forumId != null) {
/*  31: 29 */       crit.add(Restrictions.eq("forum.id", forumId));
/*  32:    */     }
/*  33: 31 */     if (status != null) {
/*  34: 32 */       crit.add(Restrictions.ge("status", status));
/*  35:    */     }
/*  36: 34 */     if (createrId != null) {
/*  37: 35 */       crit.add(Restrictions.eq("creater.id", createrId));
/*  38:    */     }
/*  39: 37 */     if (replyId != null)
/*  40:    */     {
/*  41: 38 */       crit.createAlias("txt", "t");
/*  42: 39 */       crit.add(Restrictions.like("t.content", "%," + replyId + ",%"));
/*  43:    */     }
/*  44: 41 */     appendOrder(crit, orderBy);
/*  45: 42 */     return findByCriteria(crit, pageNo, pageSize);
/*  46:    */   }
/*  47:    */   
/*  48:    */   public List<Theme> getThemeByTop()
/*  49:    */   {
/*  50: 46 */     Criteria crit = createCriteria(new Criterion[0]);
/*  51: 47 */     crit.add(Restrictions.gt("status", Integer.valueOf(0)));
/*  52: 48 */     crit.addOrder(Order.desc("status"));
/*  53: 49 */     crit.addOrder(Order.desc("lastReplyTime"));
/*  54: 50 */     return findByCriteria(crit);
/*  55:    */   }
/*  56:    */   
/*  57:    */   public List<Theme> getThemeByLight()
/*  58:    */   {
/*  59: 54 */     Criteria crit = createCriteria(new Criterion[0]);
/*  60: 55 */     crit.add(Restrictions.isNotNull("color"));
/*  61: 56 */     crit.addOrder(Order.desc("status"));
/*  62: 57 */     crit.addOrder(Order.desc("lastReplyTime"));
/*  63: 58 */     return findByCriteria(crit);
/*  64:    */   }
/*  65:    */   
/*  66:    */   public List<Theme> getThemeByLock()
/*  67:    */   {
/*  68: 62 */     Criteria crit = createCriteria(new Criterion[0]);
/*  69: 63 */     crit.add(Restrictions.eq("lock", Boolean.valueOf(true)));
/*  70: 64 */     crit.addOrder(Order.desc("status"));
/*  71: 65 */     crit.addOrder(Order.desc("lastReplyTime"));
/*  72: 66 */     return findByCriteria(crit);
/*  73:    */   }
/*  74:    */   
/*  75:    */   private void appendOrder(Criteria crit, int orderBy)
/*  76:    */   {
/*  77: 70 */     switch (orderBy)
/*  78:    */     {
/*  79:    */     case 1: 
/*  80: 72 */       crit.addOrder(Order.desc("status"));
/*  81: 73 */       crit.addOrder(Order.desc("replyCount"));
/*  82: 74 */       break;
/*  83:    */     case 2: 
/*  84: 76 */       crit.addOrder(Order.desc("status"));
/*  85: 77 */       crit.addOrder(Order.desc("viewsCount"));
/*  86: 78 */       break;
/*  87:    */     case 3: 
/*  88: 80 */       crit.addOrder(Order.desc("replyCount"));
/*  89: 81 */       break;
/*  90:    */     case 4: 
/*  91: 83 */       crit.addOrder(Order.desc("viewsCount"));
/*  92: 84 */       break;
/*  93:    */     default: 
/*  94: 86 */       crit.addOrder(Order.desc("status"));
/*  95: 87 */       crit.addOrder(Order.desc("lastReplyTime"));
/*  96:    */     }
/*  97:    */   }
/*  98:    */   
/*  99:    */   public Theme findById(Integer id)
/* 100:    */   {
/* 101: 92 */     Theme entity = (Theme)get(id);
/* 102: 93 */     return entity;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public Theme save(Theme bean)
/* 106:    */   {
/* 107: 97 */     getSession().save(bean);
/* 108: 98 */     return bean;
/* 109:    */   }
/* 110:    */   
/* 111:    */   public Theme deleteById(Integer id)
/* 112:    */   {
/* 113:102 */     Theme entity = (Theme)super.get(id);
/* 114:103 */     if (entity != null) {
/* 115:104 */       getSession().delete(entity);
/* 116:    */     }
/* 117:106 */     return entity;
/* 118:    */   }
/* 119:    */   
/* 120:    */   protected Class<Theme> getEntityClass()
/* 121:    */   {
/* 122:111 */     return Theme.class;
/* 123:    */   }
/* 124:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.dao.impl.ThemeDaoImpl
 * JD-Core Version:    0.7.0.1
 */