package com.portal.doccenter.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.doccenter.entity.FlowStep;

public abstract interface FlowStepDao
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract FlowStep findById(Integer paramInteger);
  
  public abstract FlowStep save(FlowStep paramFlowStep);
  
  public abstract FlowStep updateByUpdater(Updater<FlowStep> paramUpdater);
  
  public abstract FlowStep deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.dao.FlowStepDao
 * JD-Core Version:    0.7.0.1
 */