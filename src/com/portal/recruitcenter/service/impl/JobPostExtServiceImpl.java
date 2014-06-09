/*  1:   */ package com.portal.recruitcenter.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.recruitcenter.dao.JobPostExtDao;
/*  6:   */ import com.portal.recruitcenter.entity.JobPost;
/*  7:   */ import com.portal.recruitcenter.entity.JobPostExt;
/*  8:   */ import com.portal.recruitcenter.service.JobPostExtService;
/*  9:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 10:   */ import org.springframework.stereotype.Service;
/* 11:   */ import org.springframework.transaction.annotation.Transactional;
/* 12:   */ 
/* 13:   */ @Service
/* 14:   */ @Transactional
/* 15:   */ public class JobPostExtServiceImpl
/* 16:   */   implements JobPostExtService
/* 17:   */ {
/* 18:   */   private JobPostExtDao dao;
/* 19:   */   
/* 20:   */   @Transactional(readOnly=true)
/* 21:   */   public Pagination getPage(int pageNo, int pageSize)
/* 22:   */   {
/* 23:19 */     Pagination page = this.dao.getPage(pageNo, pageSize);
/* 24:20 */     return page;
/* 25:   */   }
/* 26:   */   
/* 27:   */   @Transactional(readOnly=true)
/* 28:   */   public JobPostExt findById(Integer id)
/* 29:   */   {
/* 30:25 */     JobPostExt entity = this.dao.findById(id);
/* 31:26 */     return entity;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public JobPostExt save(JobPostExt bean, JobPost jobpost)
/* 35:   */   {
/* 36:30 */     bean.setJobPost(jobpost);
/* 37:31 */     this.dao.save(bean);
/* 38:32 */     jobpost.setExt(bean);
/* 39:33 */     return bean;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public JobPostExt update(JobPostExt bean)
/* 43:   */   {
/* 44:37 */     Updater<JobPostExt> updater = new Updater(bean);
/* 45:38 */     bean = this.dao.updateByUpdater(updater);
/* 46:39 */     return bean;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public int deleteByCompanyId(Integer companyId)
/* 50:   */   {
/* 51:43 */     return this.dao.deleteByCompanyId(companyId);
/* 52:   */   }
/* 53:   */   
/* 54:   */   public int deleteByMetierId(Integer metierId)
/* 55:   */   {
/* 56:47 */     return this.dao.deleteByMetierId(metierId);
/* 57:   */   }
/* 58:   */   
/* 59:   */   public JobPostExt deleteById(Integer id)
/* 60:   */   {
/* 61:51 */     JobPostExt bean = this.dao.deleteById(id);
/* 62:52 */     return bean;
/* 63:   */   }
/* 64:   */   
/* 65:   */   public JobPostExt[] deleteByIds(Integer[] ids)
/* 66:   */   {
/* 67:56 */     JobPostExt[] beans = new JobPostExt[ids.length];
/* 68:57 */     int i = 0;
/* 69:57 */     for (int len = ids.length; i < len; i++) {
/* 70:58 */       beans[i] = deleteById(ids[i]);
/* 71:   */     }
/* 72:60 */     return beans;
/* 73:   */   }
/* 74:   */   
/* 75:   */   @Autowired
/* 76:   */   public void setDao(JobPostExtDao dao)
/* 77:   */   {
/* 78:67 */     this.dao = dao;
/* 79:   */   }
/* 80:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.service.impl.JobPostExtServiceImpl
 * JD-Core Version:    0.7.0.1
 */