package com.portal.recruitcenter.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.recruitcenter.entity.Resume;
import java.util.List;

public abstract interface ResumeDao
{
  public abstract Pagination getPage(Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract Pagination getPageByTag(String paramString, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, Byte paramByte1, Byte paramByte2, Byte paramByte3, Byte paramByte4, Boolean paramBoolean1, Boolean paramBoolean2, int paramInt1, int paramInt2);
  
  public abstract List<Resume> getList(Integer paramInteger);
  
  public abstract Resume getResumeByDef(Integer paramInteger);
  
  public abstract Resume getResumeByName(Integer paramInteger);
  
  public abstract int deleteByPersonalId(Integer paramInteger);
  
  public abstract Resume findById(Integer paramInteger);
  
  public abstract Resume save(Resume paramResume);
  
  public abstract Resume updateByUpdater(Updater<Resume> paramUpdater);
  
  public abstract Resume deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.dao.ResumeDao
 * JD-Core Version:    0.7.0.1
 */