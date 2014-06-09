/*  1:   */ package com.portal.doccenter.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.doccenter.dao.WorkFlowDao;
/*  6:   */ import com.portal.doccenter.entity.WorkFlow;
/*  7:   */ import com.portal.doccenter.service.FlowStepService;
/*  8:   */ import com.portal.doccenter.service.WorkFlowService;
/*  9:   */ import com.portal.sysmgr.entity.Site;
/* 10:   */ import java.util.List;
/* 11:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 12:   */ import org.springframework.stereotype.Service;
/* 13:   */ import org.springframework.transaction.annotation.Transactional;
/* 14:   */ 
/* 15:   */ @Service
/* 16:   */ @Transactional
/* 17:   */ public class WorkFlowServiceImpl
/* 18:   */   implements WorkFlowService
/* 19:   */ {
/* 20:   */   private WorkFlowDao dao;
/* 21:   */   private FlowStepService flowStepService;
/* 22:   */   
/* 23:   */   @Transactional(readOnly=true)
/* 24:   */   public Pagination getPage(Integer siteId, String sortname, String sortorder, int pageNo, int pageSize)
/* 25:   */   {
/* 26:23 */     Pagination page = this.dao.getPage(siteId, sortname, sortorder, pageNo, pageSize);
/* 27:24 */     return page;
/* 28:   */   }
/* 29:   */   
/* 30:   */   @Transactional(readOnly=true)
/* 31:   */   public List<WorkFlow> findByList(Integer siteId)
/* 32:   */   {
/* 33:29 */     return this.dao.findByList(siteId);
/* 34:   */   }
/* 35:   */   
/* 36:   */   @Transactional(readOnly=true)
/* 37:   */   public WorkFlow findById(Integer id)
/* 38:   */   {
/* 39:34 */     WorkFlow entity = this.dao.findById(id);
/* 40:35 */     return entity;
/* 41:   */   }
/* 42:   */   
/* 43:   */   public WorkFlow save(WorkFlow bean, Site site, Integer[] step, Integer[] roleIds)
/* 44:   */   {
/* 45:40 */     bean.init();
/* 46:41 */     bean.setSite(site);
/* 47:42 */     bean.setStepCount(Integer.valueOf(step.length));
/* 48:43 */     this.dao.save(bean);
/* 49:44 */     this.flowStepService.save(bean, step, roleIds);
/* 50:45 */     return bean;
/* 51:   */   }
/* 52:   */   
/* 53:   */   public WorkFlow update(WorkFlow bean, Integer[] step, Integer[] roleIds)
/* 54:   */   {
/* 55:49 */     Updater<WorkFlow> updater = new Updater(bean);
/* 56:50 */     bean.setStepCount(Integer.valueOf(step.length));
/* 57:51 */     bean = this.dao.updateByUpdater(updater);
/* 58:52 */     this.flowStepService.update(bean, step, roleIds);
/* 59:53 */     return bean;
/* 60:   */   }
/* 61:   */   
/* 62:   */   public WorkFlow deleteById(Integer id)
/* 63:   */   {
/* 64:57 */     WorkFlow bean = this.dao.deleteById(id);
/* 65:58 */     return bean;
/* 66:   */   }
/* 67:   */   
/* 68:   */   public WorkFlow[] deleteByIds(Integer[] ids)
/* 69:   */   {
/* 70:62 */     WorkFlow[] beans = new WorkFlow[ids.length];
/* 71:63 */     int i = 0;
/* 72:63 */     for (int len = ids.length; i < len; i++) {
/* 73:64 */       beans[i] = deleteById(ids[i]);
/* 74:   */     }
/* 75:66 */     return beans;
/* 76:   */   }
/* 77:   */   
/* 78:   */   @Autowired
/* 79:   */   public void setDao(WorkFlowDao dao)
/* 80:   */   {
/* 81:74 */     this.dao = dao;
/* 82:   */   }
/* 83:   */   
/* 84:   */   @Autowired
/* 85:   */   public void setFlowStepService(FlowStepService flowStepService)
/* 86:   */   {
/* 87:79 */     this.flowStepService = flowStepService;
/* 88:   */   }
/* 89:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.service.impl.WorkFlowServiceImpl
 * JD-Core Version:    0.7.0.1
 */