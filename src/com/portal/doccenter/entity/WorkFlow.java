/*  1:   */ package com.portal.doccenter.entity;
/*  2:   */ 
/*  3:   */ import com.portal.doccenter.entity.base.BaseWorkFlow;
/*  4:   */ import com.portal.sysmgr.entity.Site;
/*  5:   */ import com.portal.usermgr.entity.Role;
/*  6:   */ import java.sql.Timestamp;
/*  7:   */ import java.util.ArrayList;
/*  8:   */ import java.util.Date;
/*  9:   */ import java.util.List;
/* 10:   */ import java.util.Set;
/* 11:   */ 
/* 12:   */ public class WorkFlow
/* 13:   */   extends BaseWorkFlow
/* 14:   */ {
/* 15:   */   private static final long serialVersionUID = 1L;
/* 16:   */   
/* 17:   */   public void init()
/* 18:   */   {
/* 19:14 */     if (getCreateTime() == null) {
/* 20:15 */       setCreateTime(new Timestamp(System.currentTimeMillis()));
/* 21:   */     }
/* 22:   */   }
/* 23:   */   
/* 24:   */   public List<Integer> getSteps()
/* 25:   */   {
/* 26:20 */     if (getFlowSteps() != null)
/* 27:   */     {
/* 28:21 */       List<Integer> l = new ArrayList();
/* 29:22 */       for (FlowStep fl : getFlowSteps()) {
/* 30:23 */         l.add(fl.getStep());
/* 31:   */       }
/* 32:25 */       return l;
/* 33:   */     }
/* 34:27 */     return null;
/* 35:   */   }
/* 36:   */   
/* 37:   */   public FlowStep getFlowStep(Integer step)
/* 38:   */   {
/* 39:31 */     if (getFlowSteps() != null) {
/* 40:32 */       for (FlowStep fl : getFlowSteps()) {
/* 41:33 */         if (fl.getStep().equals(step)) {
/* 42:34 */           return fl;
/* 43:   */         }
/* 44:   */       }
/* 45:   */     }
/* 46:38 */     return null;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public FlowStep getNextFlowStep(Integer roleId)
/* 50:   */   {
/* 51:42 */     Set<FlowStep> steps = getFlowSteps();
/* 52:43 */     if (steps != null)
/* 53:   */     {
/* 54:44 */       List<FlowStep> stepList = new ArrayList(steps);
/* 55:45 */       for (int i = stepList.size() - 1; i >= 0; i--) {
/* 56:46 */         if ((((FlowStep)stepList.get(i)).getRole().getId().equals(roleId)) && 
/* 57:47 */           (i + 1 < stepList.size())) {
/* 58:48 */           return (FlowStep)stepList.get(i + 1);
/* 59:   */         }
/* 60:   */       }
/* 61:   */     }
/* 62:52 */     return null;
/* 63:   */   }
/* 64:   */   
/* 65:   */   public FlowStep getLastFlowStep()
/* 66:   */   {
/* 67:56 */     Set<FlowStep> steps = getFlowSteps();
/* 68:57 */     if (steps != null)
/* 69:   */     {
/* 70:58 */       List<FlowStep> stepList = new ArrayList(steps);
/* 71:59 */       return (FlowStep)stepList.get(stepList.size() - 1);
/* 72:   */     }
/* 73:61 */     return null;
/* 74:   */   }
/* 75:   */   
/* 76:   */   public FlowStep getStep(Integer roleId)
/* 77:   */   {
/* 78:65 */     Set<FlowStep> steps = getFlowSteps();
/* 79:66 */     if (steps != null) {
/* 80:67 */       for (FlowStep step : steps) {
/* 81:68 */         if (step.getRole().getId().equals(roleId)) {
/* 82:69 */           return step;
/* 83:   */         }
/* 84:   */       }
/* 85:   */     }
/* 86:73 */     return null;
/* 87:   */   }
/* 88:   */   
/* 89:   */   public WorkFlow() {}
/* 90:   */   
/* 91:   */   public WorkFlow(Integer id)
/* 92:   */   {
/* 93:85 */     super(id);
/* 94:   */   }
/* 95:   */   
/* 96:   */   public WorkFlow(Integer id, Site site, String name, Date createTime)
/* 97:   */   {
/* 98:94 */     super(id, site, name, createTime);
/* 99:   */   }
/* :0:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.entity.WorkFlow
 * JD-Core Version:    0.7.0.1
 */