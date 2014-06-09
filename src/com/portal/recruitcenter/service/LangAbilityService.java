package com.portal.recruitcenter.service;

import com.javapms.basic.page.Pagination;
import com.portal.recruitcenter.entity.LangAbility;

public abstract interface LangAbilityService
{
  public abstract Pagination getPage(Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract int deleteByPersonalId(Integer paramInteger);
  
  public abstract int deleteByResumeId(Integer paramInteger);
  
  public abstract int deleteByLangId(Integer paramInteger);
  
  public abstract LangAbility findById(Integer paramInteger);
  
  public abstract LangAbility save(LangAbility paramLangAbility, Integer paramInteger1, Integer paramInteger2);
  
  public abstract LangAbility update(LangAbility paramLangAbility, Integer paramInteger);
  
  public abstract LangAbility deleteById(Integer paramInteger);
  
  public abstract LangAbility[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.service.LangAbilityService
 * JD-Core Version:    0.7.0.1
 */