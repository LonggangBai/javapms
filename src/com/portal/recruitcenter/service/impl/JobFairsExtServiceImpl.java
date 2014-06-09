/*  1:   */ package com.portal.recruitcenter.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.recruitcenter.dao.JobFairsExtDao;
/*  6:   */ import com.portal.recruitcenter.entity.JobFairs;
/*  7:   */ import com.portal.recruitcenter.entity.JobFairsExt;
/*  8:   */ import com.portal.recruitcenter.service.JobFairsExtService;
/*  9:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 10:   */ import org.springframework.stereotype.Service;
/* 11:   */ import org.springframework.transaction.annotation.Transactional;
/* 12:   */ 
/* 13:   */ @Service
/* 14:   */ @Transactional
/* 15:   */ public class JobFairsExtServiceImpl
/* 16:   */   implements JobFairsExtService
/* 17:   */ {
/* 18:   */   private JobFairsExtDao dao;
/* 19:   */   
/* 20:   */   @Transactional(readOnly=true)
/* 21:   */   public Pagination getPage(int pageNo, int pageSize)
/* 22:   */   {
/* 23:19 */     Pagination page = this.dao.getPage(pageNo, pageSize);
/* 24:20 */     return page;
/* 25:   */   }
/* 26:   */   
/* 27:   */   @Transactional(readOnly=true)
/* 28:   */   public JobFairsExt findById(Integer id)
/* 29:   */   {
/* 30:25 */     JobFairsExt entity = this.dao.findById(id);
/* 31:26 */     return entity;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public JobFairsExt save(JobFairsExt bean, JobFairs fairs)
/* 35:   */   {
/* 36:30 */     bean.setJobFairs(fairs);
/* 37:31 */     this.dao.save(bean);
/* 38:32 */     fairs.setExt(bean);
/* 39:33 */     return bean;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public JobFairsExt update(JobFairsExt bean)
/* 43:   */   {
/* 44:37 */     Updater<JobFairsExt> updater = new Updater(bean);
/* 45:38 */     bean = this.dao.updateByUpdater(updater);
/* 46:39 */     return bean;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public JobFairsExt deleteById(Integer id)
/* 50:   */   {
/* 51:43 */     JobFairsExt bean = this.dao.deleteById(id);
/* 52:44 */     return bean;
/* 53:   */   }
/* 54:   */   
/* 55:   */   public JobFairsExt[] deleteByIds(Integer[] ids)
/* 56:   */   {
/* 57:48 */     JobFairsExt[] beans = new JobFairsExt[ids.length];
/* 58:49 */     int i = 0;
/* 59:49 */     for (int len = ids.length; i < len; i++) {
/* 60:50 */       beans[i] = deleteById(ids[i]);
/* 61:   */     }
/* 62:52 */     return beans;
/* 63:   */   }
/* 64:   */   
/* 65:   */   @Autowired
/* 66:   */   public void setDao(JobFairsExtDao dao)
/* 67:   */   {
/* 68:59 */     this.dao = dao;
/* 69:   */   }
/* 70:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.service.impl.JobFairsExtServiceImpl
 * JD-Core Version:    0.7.0.1
 */