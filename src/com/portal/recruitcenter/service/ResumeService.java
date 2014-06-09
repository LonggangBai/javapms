package com.portal.recruitcenter.service;

import com.javapms.basic.page.Pagination;
import com.portal.recruitcenter.entity.Resume;
import com.portal.recruitcenter.entity.ResumeExt;
import java.util.List;

public abstract interface ResumeService
{
  public abstract Pagination getPage(Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract Pagination getPageByTag(String paramString, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, Byte paramByte1, Byte paramByte2, Byte paramByte3, Byte paramByte4, Boolean paramBoolean1, Boolean paramBoolean2, int paramInt1, int paramInt2);
  
  public abstract List<Resume> getList(Integer paramInteger);
  
  public abstract Resume getResumeByDef(Integer paramInteger);
  
  public abstract Resume getResumeByName(Integer paramInteger);
  
  public abstract int deleteByPersonalId(Integer paramInteger);
  
  public abstract Resume findById(Integer paramInteger);
  
  public abstract Resume save(Resume paramResume, ResumeExt paramResumeExt);
  
  public abstract Resume update(Resume paramResume, ResumeExt paramResumeExt);
  
  public abstract Resume update(Resume paramResume);
  
  public abstract Resume deleteById(Integer paramInteger);
  
  public abstract Resume[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.service.ResumeService
 * JD-Core Version:    0.7.0.1
 */