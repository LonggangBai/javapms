/*  1:   */ package com.portal.doccenter.entity;
/*  2:   */ 
/*  3:   */ import com.portal.doccenter.entity.base.BaseFlowStep;
/*  4:   */ 
/*  5:   */ public class FlowStep
/*  6:   */   extends BaseFlowStep
/*  7:   */ {
/*  8:   */   private static final long serialVersionUID = 1L;
/*  9:   */   
/* 10:   */   public FlowStep() {}
/* 11:   */   
/* 12:   */   public FlowStep(Integer id)
/* 13:   */   {
/* 14:19 */     super(id);
/* 15:   */   }
/* 16:   */   
/* 17:   */   public FlowStep(Integer id, WorkFlow flow, Integer step)
/* 18:   */   {
/* 19:33 */     super(id, flow, step);
/* 20:   */   }
/* 21:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.entity.FlowStep
 * JD-Core Version:    0.7.0.1
 */