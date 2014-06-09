/*  1:   */ package com.portal.datacenter.docdata.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.datacenter.docdata.dao.ProgramDownloadDao;
/*  6:   */ import com.portal.datacenter.docdata.entity.ProgramDownload;
/*  7:   */ import org.hibernate.Criteria;
/*  8:   */ import org.hibernate.Session;
/*  9:   */ import org.hibernate.criterion.Criterion;
/* 10:   */ import org.springframework.stereotype.Repository;
/* 11:   */ 
/* 12:   */ @Repository
/* 13:   */ public class ProgramDownloadDaoImpl
/* 14:   */   extends HibernateBaseDao<ProgramDownload, Integer>
/* 15:   */   implements ProgramDownloadDao
/* 16:   */ {
/* 17:   */   public Pagination getPage(int pageNo, int pageSize)
/* 18:   */   {
/* 19:16 */     Criteria crit = createCriteria(new Criterion[0]);
/* 20:17 */     Pagination page = findByCriteria(crit, pageNo, pageSize);
/* 21:18 */     return page;
/* 22:   */   }
/* 23:   */   
/* 24:   */   public ProgramDownload findUnique()
/* 25:   */   {
/* 26:22 */     Criteria crit = createCriteria(new Criterion[0]);
/* 27:23 */     return (ProgramDownload)findUnique(crit);
/* 28:   */   }
/* 29:   */   
/* 30:   */   public ProgramDownload findById(Integer id)
/* 31:   */   {
/* 32:27 */     ProgramDownload entity = (ProgramDownload)get(id);
/* 33:28 */     return entity;
/* 34:   */   }
/* 35:   */   
/* 36:   */   public ProgramDownload save(ProgramDownload bean)
/* 37:   */   {
/* 38:32 */     getSession().save(bean);
/* 39:33 */     return bean;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public ProgramDownload deleteById(Integer id)
/* 43:   */   {
/* 44:37 */     ProgramDownload entity = (ProgramDownload)super.get(id);
/* 45:38 */     if (entity != null) {
/* 46:39 */       getSession().delete(entity);
/* 47:   */     }
/* 48:41 */     return entity;
/* 49:   */   }
/* 50:   */   
/* 51:   */   protected Class<ProgramDownload> getEntityClass()
/* 52:   */   {
/* 53:46 */     return ProgramDownload.class;
/* 54:   */   }
/* 55:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.docdata.dao.impl.ProgramDownloadDaoImpl
 * JD-Core Version:    0.7.0.1
 */