package com.portal.recruitcenter.service;

import com.javapms.basic.page.Pagination;
import com.portal.recruitcenter.entity.JobFairs;
import com.portal.recruitcenter.entity.JobFairsExt;

public abstract interface JobFairsExtService
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract JobFairsExt findById(Integer paramInteger);
  
  public abstract JobFairsExt save(JobFairsExt paramJobFairsExt, JobFairs paramJobFairs);
  
  public abstract JobFairsExt update(JobFairsExt paramJobFairsExt);
  
  public abstract JobFairsExt deleteById(Integer paramInteger);
  
  public abstract JobFairsExt[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.service.JobFairsExtService
 * JD-Core Version:    0.7.0.1
 */