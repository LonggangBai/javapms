package com.portal.doccenter.service;

import com.javapms.basic.page.Pagination;
import com.portal.doccenter.entity.WorkFlow;
import com.portal.sysmgr.entity.Site;
import java.util.List;

public abstract interface WorkFlowService
{
  public abstract Pagination getPage(Integer paramInteger, String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract List<WorkFlow> findByList(Integer paramInteger);
  
  public abstract WorkFlow findById(Integer paramInteger);
  
  public abstract WorkFlow save(WorkFlow paramWorkFlow, Site paramSite, Integer[] paramArrayOfInteger1, Integer[] paramArrayOfInteger2);
  
  public abstract WorkFlow update(WorkFlow paramWorkFlow, Integer[] paramArrayOfInteger1, Integer[] paramArrayOfInteger2);
  
  public abstract WorkFlow deleteById(Integer paramInteger);
  
  public abstract WorkFlow[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.service.WorkFlowService
 * JD-Core Version:    0.7.0.1
 */