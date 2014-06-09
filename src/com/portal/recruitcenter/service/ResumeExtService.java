package com.portal.recruitcenter.service;

import com.javapms.basic.page.Pagination;
import com.portal.recruitcenter.entity.Resume;
import com.portal.recruitcenter.entity.ResumeExt;

public abstract interface ResumeExtService
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract int deleteByPersonalId(Integer paramInteger);
  
  public abstract ResumeExt findById(Integer paramInteger);
  
  public abstract ResumeExt save(ResumeExt paramResumeExt, Resume paramResume);
  
  public abstract ResumeExt update(ResumeExt paramResumeExt, Resume paramResume);
  
  public abstract ResumeExt deleteById(Integer paramInteger);
  
  public abstract ResumeExt[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.service.ResumeExtService
 * JD-Core Version:    0.7.0.1
 */