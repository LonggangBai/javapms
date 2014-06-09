package com.portal.recruitcenter.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.recruitcenter.entity.JobFairsExt;

public abstract interface JobFairsExtDao
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract JobFairsExt findById(Integer paramInteger);
  
  public abstract JobFairsExt save(JobFairsExt paramJobFairsExt);
  
  public abstract JobFairsExt updateByUpdater(Updater<JobFairsExt> paramUpdater);
  
  public abstract JobFairsExt deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.dao.JobFairsExtDao
 * JD-Core Version:    0.7.0.1
 */