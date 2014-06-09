package com.portal.datacenter.docdata.service;

import com.javapms.basic.page.Pagination;
import com.portal.datacenter.docdata.entity.ProgramDownload;

public abstract interface ProgramDownloadService
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract ProgramDownload findUnique();
  
  public abstract ProgramDownload findById(Integer paramInteger);
  
  public abstract ProgramDownload save();
  
  public abstract ProgramDownload updateCount();
  
  public abstract ProgramDownload update(ProgramDownload paramProgramDownload);
  
  public abstract ProgramDownload deleteById(Integer paramInteger);
  
  public abstract ProgramDownload[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.docdata.service.ProgramDownloadService
 * JD-Core Version:    0.7.0.1
 */