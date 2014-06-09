/*  1:   */ package com.portal.doccenter.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.portal.doccenter.dao.DocStatisDao;
/*  5:   */ import com.portal.doccenter.entity.DocStatis;
/*  6:   */ import org.hibernate.Session;
/*  7:   */ import org.springframework.stereotype.Repository;
/*  8:   */ 
/*  9:   */ @Repository
/* 10:   */ public class DocStatisDaoImpl
/* 11:   */   extends HibernateBaseDao<DocStatis, Integer>
/* 12:   */   implements DocStatisDao
/* 13:   */ {
/* 14:   */   public DocStatis findById(Integer id)
/* 15:   */   {
/* 16:13 */     DocStatis entity = (DocStatis)get(id);
/* 17:14 */     return entity;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public DocStatis save(DocStatis bean)
/* 21:   */   {
/* 22:18 */     getSession().save(bean);
/* 23:19 */     return bean;
/* 24:   */   }
/* 25:   */   
/* 26:   */   protected Class<DocStatis> getEntityClass()
/* 27:   */   {
/* 28:24 */     return DocStatis.class;
/* 29:   */   }
/* 30:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.dao.impl.DocStatisDaoImpl
 * JD-Core Version:    0.7.0.1
 */