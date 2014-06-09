package com.portal.recruitcenter.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.recruitcenter.entity.JobPostExt;

public abstract interface JobPostExtDao
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract int deleteByCompanyId(Integer paramInteger);
  
  public abstract int deleteByMetierId(Integer paramInteger);
  
  public abstract JobPostExt findById(Integer paramInteger);
  
  public abstract JobPostExt save(JobPostExt paramJobPostExt);
  
  public abstract JobPostExt updateByUpdater(Updater<JobPostExt> paramUpdater);
  
  public abstract JobPostExt deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.dao.JobPostExtDao
 * JD-Core Version:    0.7.0.1
 */