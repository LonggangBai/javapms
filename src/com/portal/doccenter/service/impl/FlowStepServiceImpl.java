/*  1:   */ package com.portal.doccenter.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.page.Pagination;
/*  4:   */ import com.portal.doccenter.dao.FlowStepDao;
/*  5:   */ import com.portal.doccenter.entity.FlowStep;
/*  6:   */ import com.portal.doccenter.entity.WorkFlow;
/*  7:   */ import com.portal.doccenter.service.FlowStepService;
/*  8:   */ import com.portal.usermgr.service.RoleService;
/*  9:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 10:   */ import org.springframework.stereotype.Service;
/* 11:   */ import org.springframework.transaction.annotation.Transactional;
/* 12:   */ 
/* 13:   */ @Service
/* 14:   */ @Transactional
/* 15:   */ public class FlowStepServiceImpl
/* 16:   */   implements FlowStepService
/* 17:   */ {
/* 18:   */   private FlowStepDao dao;
/* 19:   */   private RoleService roleService;
/* 20:   */   
/* 21:   */   @Transactional(readOnly=true)
/* 22:   */   public Pagination getPage(int pageNo, int pageSize)
/* 23:   */   {
/* 24:19 */     Pagination page = this.dao.getPage(pageNo, pageSize);
/* 25:20 */     return page;
/* 26:   */   }
/* 27:   */   
/* 28:   */   @Transactional(readOnly=true)
/* 29:   */   public FlowStep findById(Integer id)
/* 30:   */   {
/* 31:25 */     FlowStep entity = this.dao.findById(id);
/* 32:26 */     return entity;
/* 33:   */   }
/* 34:   */   
/* 35:   */   public void save(WorkFlow flow, Integer[] step, Integer[] roleIds)
/* 36:   */   {
/* 37:30 */     for (int i = 0; i < step.length; i++)
/* 38:   */     {
/* 39:31 */       FlowStep fl = new FlowStep();
/* 40:32 */       fl.setFlow(flow);
/* 41:33 */       fl.setRole(this.roleService.findById(roleIds[i]));
/* 42:34 */       fl.setStep(Integer.valueOf(i + 1));
/* 43:35 */       this.dao.save(fl);
/* 44:   */     }
/* 45:   */   }
/* 46:   */   
/* 47:   */   public void update(WorkFlow flow, Integer[] step, Integer[] roleIds)
/* 48:   */   {
/* 49:40 */     for (FlowStep fl : flow.getFlowSteps()) {
/* 50:41 */       deleteById(fl.getId());
/* 51:   */     }
/* 52:43 */     for (int i = 0; i < step.length; i++)
/* 53:   */     {
/* 54:44 */       FlowStep fl = new FlowStep();
/* 55:45 */       fl.setFlow(flow);
/* 56:46 */       fl.setRole(this.roleService.findById(roleIds[i]));
/* 57:47 */       fl.setStep(Integer.valueOf(i + 1));
/* 58:48 */       this.dao.save(fl);
/* 59:   */     }
/* 60:   */   }
/* 61:   */   
/* 62:   */   public FlowStep deleteById(Integer id)
/* 63:   */   {
/* 64:53 */     FlowStep bean = this.dao.deleteById(id);
/* 65:54 */     return bean;
/* 66:   */   }
/* 67:   */   
/* 68:   */   public FlowStep[] deleteByIds(Integer[] ids)
/* 69:   */   {
/* 70:58 */     FlowStep[] beans = new FlowStep[ids.length];
/* 71:59 */     int i = 0;
/* 72:59 */     for (int len = ids.length; i < len; i++) {
/* 73:60 */       beans[i] = deleteById(ids[i]);
/* 74:   */     }
/* 75:62 */     return beans;
/* 76:   */   }
/* 77:   */   
/* 78:   */   @Autowired
/* 79:   */   public void setDao(FlowStepDao dao)
/* 80:   */   {
/* 81:70 */     this.dao = dao;
/* 82:   */   }
/* 83:   */   
/* 84:   */   @Autowired
/* 85:   */   public void setRoleService(RoleService roleService)
/* 86:   */   {
/* 87:75 */     this.roleService = roleService;
/* 88:   */   }
/* 89:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.service.impl.FlowStepServiceImpl
 * JD-Core Version:    0.7.0.1
 */