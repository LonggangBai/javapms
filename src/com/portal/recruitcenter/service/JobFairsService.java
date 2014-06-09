package com.portal.recruitcenter.service;

import com.javapms.basic.page.Pagination;
import com.portal.recruitcenter.entity.JobFairs;
import com.portal.recruitcenter.entity.JobFairsExt;
import java.util.List;

public abstract interface JobFairsService
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract Pagination getPageByTag(int paramInt1, int paramInt2);
  
  public abstract List<JobFairs> getFairsByTime();
  
  public abstract JobFairs findById(Integer paramInteger);
  
  public abstract JobFairs save(JobFairs paramJobFairs, JobFairsExt paramJobFairsExt);
  
  public abstract JobFairs update(JobFairs paramJobFairs, JobFairsExt paramJobFairsExt);
  
  public abstract JobFairs deleteById(Integer paramInteger);
  
  public abstract JobFairs[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.service.JobFairsService
 * JD-Core Version:    0.7.0.1
 */