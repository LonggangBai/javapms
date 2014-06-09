package com.portal.recruitcenter.service;

import com.javapms.basic.page.Pagination;
import com.portal.recruitcenter.entity.JobIntent;

public abstract interface JobIntentService
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract Pagination getPageByTag(String paramString, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, Byte paramByte1, Byte paramByte2, Byte paramByte3, Byte paramByte4, Boolean paramBoolean1, Boolean paramBoolean2, int paramInt1, int paramInt2);
  
  public abstract int deleteByPersonalId(Integer paramInteger);
  
  public abstract JobIntent findById(Integer paramInteger);
  
  public abstract JobIntent save(JobIntent paramJobIntent, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4);
  
  public abstract JobIntent update(JobIntent paramJobIntent, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4);
  
  public abstract JobIntent deleteById(Integer paramInteger);
  
  public abstract JobIntent[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.service.JobIntentService
 * JD-Core Version:    0.7.0.1
 */