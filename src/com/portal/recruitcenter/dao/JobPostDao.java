package com.portal.recruitcenter.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.recruitcenter.entity.JobPost;

public abstract interface JobPostDao
{
  public abstract Pagination getPage(String paramString1, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Byte paramByte1, Byte paramByte2, Integer paramInteger4, Byte paramByte3, Byte paramByte4, Byte paramByte5, Integer paramInteger5, Integer paramInteger6, String paramString2, Boolean paramBoolean, int paramInt1, int paramInt2);
  
  public abstract Pagination getPageByTag(String paramString1, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Byte paramByte1, Byte paramByte2, Integer paramInteger4, Byte paramByte3, Byte paramByte4, Byte paramByte5, Integer paramInteger5, Integer paramInteger6, String paramString2, Boolean paramBoolean1, Boolean paramBoolean2, int paramInt1, int paramInt2);
  
  public abstract int countByCompanyId(Integer paramInteger);
  
  public abstract JobPost findById(Integer paramInteger);
  
  public abstract int deleteByCompanyId(Integer paramInteger);
  
  public abstract int deleteByMetierId(Integer paramInteger);
  
  public abstract JobPost save(JobPost paramJobPost);
  
  public abstract JobPost updateByUpdater(Updater<JobPost> paramUpdater);
  
  public abstract JobPost deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.dao.JobPostDao
 * JD-Core Version:    0.7.0.1
 */