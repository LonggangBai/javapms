package com.portal.recruitcenter.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.recruitcenter.entity.ResumeApply;

public abstract interface ResumeApplyDao
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract Pagination getPageByTag(Integer paramInteger1, Integer paramInteger2, int paramInt1, int paramInt2);
  
  public abstract ResumeApply getApply(Integer paramInteger1, Integer paramInteger2);
  
  public abstract int deleteByCompanyId(Integer paramInteger);
  
  public abstract int deleteByJobId(Integer paramInteger);
  
  public abstract int deleteByResumelId(Integer paramInteger);
  
  public abstract int deleteByPersonalId(Integer paramInteger);
  
  public abstract int deleteByMetierId(Integer paramInteger);
  
  public abstract ResumeApply findById(Integer paramInteger);
  
  public abstract ResumeApply save(ResumeApply paramResumeApply);
  
  public abstract ResumeApply updateByUpdater(Updater<ResumeApply> paramUpdater);
  
  public abstract ResumeApply deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.dao.ResumeApplyDao
 * JD-Core Version:    0.7.0.1
 */