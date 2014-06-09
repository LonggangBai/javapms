package com.portal.recruitcenter.service;

import com.javapms.basic.page.Pagination;
import com.portal.recruitcenter.entity.PersonalInfo;
import com.portal.recruitcenter.entity.PersonalInfoExt;

public abstract interface PersonalInfoExtService
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract PersonalInfoExt findById(Integer paramInteger);
  
  public abstract PersonalInfoExt save(PersonalInfoExt paramPersonalInfoExt, PersonalInfo paramPersonalInfo);
  
  public abstract PersonalInfoExt update(PersonalInfoExt paramPersonalInfoExt, PersonalInfo paramPersonalInfo);
  
  public abstract PersonalInfoExt deleteById(Integer paramInteger);
  
  public abstract PersonalInfoExt[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.service.PersonalInfoExtService
 * JD-Core Version:    0.7.0.1
 */