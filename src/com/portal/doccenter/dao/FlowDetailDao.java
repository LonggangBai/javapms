package com.portal.doccenter.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.doccenter.entity.FlowDetail;

public abstract interface FlowDetailDao
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract FlowDetail getLastFlowDetail(Integer paramInteger);
  
  public abstract FlowDetail findById(Integer paramInteger);
  
  public abstract FlowDetail save(FlowDetail paramFlowDetail);
  
  public abstract FlowDetail updateByUpdater(Updater<FlowDetail> paramUpdater);
  
  public abstract FlowDetail deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.dao.FlowDetailDao
 * JD-Core Version:    0.7.0.1
 */