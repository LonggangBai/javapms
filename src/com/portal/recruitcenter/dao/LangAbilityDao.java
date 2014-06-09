package com.portal.recruitcenter.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.recruitcenter.entity.LangAbility;

public abstract interface LangAbilityDao
{
  public abstract Pagination getPage(Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract int deleteByPersonalId(Integer paramInteger);
  
  public abstract int deleteByResumeId(Integer paramInteger);
  
  public abstract int deleteByLangId(Integer paramInteger);
  
  public abstract LangAbility findById(Integer paramInteger);
  
  public abstract LangAbility save(LangAbility paramLangAbility);
  
  public abstract LangAbility updateByUpdater(Updater<LangAbility> paramUpdater);
  
  public abstract LangAbility deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.dao.LangAbilityDao
 * JD-Core Version:    0.7.0.1
 */