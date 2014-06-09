/*  1:   */ package com.portal.recruitcenter.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.recruitcenter.dao.JobFairsDao;
/*  6:   */ import com.portal.recruitcenter.entity.JobFairs;
/*  7:   */ import com.portal.recruitcenter.entity.JobFairsExt;
/*  8:   */ import com.portal.recruitcenter.service.JobFairsExtService;
/*  9:   */ import com.portal.recruitcenter.service.JobFairsService;
/* 10:   */ import java.util.List;
/* 11:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 12:   */ import org.springframework.stereotype.Service;
/* 13:   */ import org.springframework.transaction.annotation.Transactional;
/* 14:   */ 
/* 15:   */ @Service
/* 16:   */ @Transactional
/* 17:   */ public class JobFairsServiceImpl
/* 18:   */   implements JobFairsService
/* 19:   */ {
/* 20:   */   private JobFairsDao dao;
/* 21:   */   private JobFairsExtService fairsExtService;
/* 22:   */   
/* 23:   */   @Transactional(readOnly=true)
/* 24:   */   public Pagination getPage(int pageNo, int pageSize)
/* 25:   */   {
/* 26:22 */     Pagination page = this.dao.getPage(pageNo, pageSize);
/* 27:23 */     return page;
/* 28:   */   }
/* 29:   */   
/* 30:   */   @Transactional(readOnly=true)
/* 31:   */   public Pagination getPageByTag(int pageNo, int pageSize)
/* 32:   */   {
/* 33:28 */     return this.dao.getPageByTag(pageNo, pageSize);
/* 34:   */   }
/* 35:   */   
/* 36:   */   @Transactional(readOnly=true)
/* 37:   */   public List<JobFairs> getFairsByTime()
/* 38:   */   {
/* 39:33 */     return this.dao.getFairsByTime();
/* 40:   */   }
/* 41:   */   
/* 42:   */   @Transactional(readOnly=true)
/* 43:   */   public JobFairs findById(Integer id)
/* 44:   */   {
/* 45:38 */     JobFairs entity = this.dao.findById(id);
/* 46:39 */     return entity;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public JobFairs save(JobFairs bean, JobFairsExt ext)
/* 50:   */   {
/* 51:43 */     bean.init();
/* 52:44 */     this.dao.save(bean);
/* 53:45 */     this.fairsExtService.save(ext, bean);
/* 54:46 */     return bean;
/* 55:   */   }
/* 56:   */   
/* 57:   */   public JobFairs update(JobFairs bean, JobFairsExt ext)
/* 58:   */   {
/* 59:50 */     Updater<JobFairs> updater = new Updater(bean);
/* 60:51 */     bean = this.dao.updateByUpdater(updater);
/* 61:52 */     this.fairsExtService.update(ext);
/* 62:53 */     return bean;
/* 63:   */   }
/* 64:   */   
/* 65:   */   public JobFairs deleteById(Integer id)
/* 66:   */   {
/* 67:57 */     JobFairs bean = this.dao.deleteById(id);
/* 68:58 */     return bean;
/* 69:   */   }
/* 70:   */   
/* 71:   */   public JobFairs[] deleteByIds(Integer[] ids)
/* 72:   */   {
/* 73:62 */     JobFairs[] beans = new JobFairs[ids.length];
/* 74:63 */     int i = 0;
/* 75:63 */     for (int len = ids.length; i < len; i++) {
/* 76:64 */       beans[i] = deleteById(ids[i]);
/* 77:   */     }
/* 78:66 */     return beans;
/* 79:   */   }
/* 80:   */   
/* 81:   */   @Autowired
/* 82:   */   public void setDao(JobFairsDao dao)
/* 83:   */   {
/* 84:74 */     this.dao = dao;
/* 85:   */   }
/* 86:   */   
/* 87:   */   @Autowired
/* 88:   */   public void setFairsExtService(JobFairsExtService fairsExtService)
/* 89:   */   {
/* 90:79 */     this.fairsExtService = fairsExtService;
/* 91:   */   }
/* 92:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.service.impl.JobFairsServiceImpl
 * JD-Core Version:    0.7.0.1
 */