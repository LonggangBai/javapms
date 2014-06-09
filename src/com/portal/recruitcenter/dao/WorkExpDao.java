package com.portal.recruitcenter.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.recruitcenter.entity.WorkExp;

public abstract interface WorkExpDao
{
  public abstract Pagination getPage(Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract int deleteByPersonalId(Integer paramInteger);
  
  public abstract int deleteByResumeId(Integer paramInteger);
  
  public abstract int deleteByNatureId(Integer paramInteger);
  
  public abstract int deleteByMetierId(Integer paramInteger);
  
  public abstract int deleteByIndustryId(Integer paramInteger);
  
  public abstract WorkExp findById(Integer paramInteger);
  
  public abstract WorkExp save(WorkExp paramWorkExp);
  
  public abstract WorkExp updateByUpdater(Updater<WorkExp> paramUpdater);
  
  public abstract WorkExp deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.dao.WorkExpDao
 * JD-Core Version:    0.7.0.1
 */