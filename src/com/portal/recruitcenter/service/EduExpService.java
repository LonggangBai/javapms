package com.portal.recruitcenter.service;

import com.javapms.basic.page.Pagination;
import com.portal.recruitcenter.entity.EduExp;

public abstract interface EduExpService
{
  public abstract Pagination getPage(Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract int deleteByPersonalId(Integer paramInteger);
  
  public abstract int deleteByResumeId(Integer paramInteger);
  
  public abstract int deleteBySpecialId(Integer paramInteger);
  
  public abstract EduExp findById(Integer paramInteger);
  
  public abstract EduExp save(EduExp paramEduExp, Integer paramInteger1, Integer paramInteger2);
  
  public abstract EduExp update(EduExp paramEduExp, Integer paramInteger);
  
  public abstract EduExp deleteById(Integer paramInteger);
  
  public abstract EduExp[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.service.EduExpService
 * JD-Core Version:    0.7.0.1
 */