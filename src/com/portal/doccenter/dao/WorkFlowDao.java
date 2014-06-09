package com.portal.doccenter.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.doccenter.entity.WorkFlow;
import java.util.List;

public abstract interface WorkFlowDao
{
  public abstract Pagination getPage(Integer paramInteger, String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract List<WorkFlow> findByList(Integer paramInteger);
  
  public abstract WorkFlow findById(Integer paramInteger);
  
  public abstract WorkFlow save(WorkFlow paramWorkFlow);
  
  public abstract WorkFlow updateByUpdater(Updater<WorkFlow> paramUpdater);
  
  public abstract WorkFlow deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.dao.WorkFlowDao
 * JD-Core Version:    0.7.0.1
 */