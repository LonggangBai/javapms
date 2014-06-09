package com.portal.doccenter.service;

import com.javapms.basic.page.Pagination;
import com.portal.doccenter.entity.FlowStep;
import com.portal.doccenter.entity.WorkFlow;

public abstract interface FlowStepService
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract FlowStep findById(Integer paramInteger);
  
  public abstract void save(WorkFlow paramWorkFlow, Integer[] paramArrayOfInteger1, Integer[] paramArrayOfInteger2);
  
  public abstract void update(WorkFlow paramWorkFlow, Integer[] paramArrayOfInteger1, Integer[] paramArrayOfInteger2);
  
  public abstract FlowStep deleteById(Integer paramInteger);
  
  public abstract FlowStep[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.service.FlowStepService
 * JD-Core Version:    0.7.0.1
 */