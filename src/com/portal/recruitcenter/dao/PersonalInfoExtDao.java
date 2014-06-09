package com.portal.recruitcenter.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.recruitcenter.entity.PersonalInfoExt;

public abstract interface PersonalInfoExtDao
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract PersonalInfoExt findById(Integer paramInteger);
  
  public abstract PersonalInfoExt save(PersonalInfoExt paramPersonalInfoExt);
  
  public abstract PersonalInfoExt updateByUpdater(Updater<PersonalInfoExt> paramUpdater);
  
  public abstract PersonalInfoExt deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.dao.PersonalInfoExtDao
 * JD-Core Version:    0.7.0.1
 */