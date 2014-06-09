package com.portal.recruitcenter.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.recruitcenter.entity.JobFairs;
import java.util.List;

public abstract interface JobFairsDao
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract Pagination getPageByTag(int paramInt1, int paramInt2);
  
  public abstract List<JobFairs> getFairsByTime();
  
  public abstract JobFairs findById(Integer paramInteger);
  
  public abstract JobFairs save(JobFairs paramJobFairs);
  
  public abstract JobFairs updateByUpdater(Updater<JobFairs> paramUpdater);
  
  public abstract JobFairs deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.dao.JobFairsDao
 * JD-Core Version:    0.7.0.1
 */