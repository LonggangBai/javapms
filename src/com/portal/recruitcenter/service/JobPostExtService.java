package com.portal.recruitcenter.service;

import com.javapms.basic.page.Pagination;
import com.portal.recruitcenter.entity.JobPost;
import com.portal.recruitcenter.entity.JobPostExt;

public abstract interface JobPostExtService
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract int deleteByCompanyId(Integer paramInteger);
  
  public abstract int deleteByMetierId(Integer paramInteger);
  
  public abstract JobPostExt findById(Integer paramInteger);
  
  public abstract JobPostExt save(JobPostExt paramJobPostExt, JobPost paramJobPost);
  
  public abstract JobPostExt update(JobPostExt paramJobPostExt);
  
  public abstract JobPostExt deleteById(Integer paramInteger);
  
  public abstract JobPostExt[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.service.JobPostExtService
 * JD-Core Version:    0.7.0.1
 */