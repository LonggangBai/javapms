package com.portal.recruitcenter.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.recruitcenter.entity.PersonalInfo;
import java.util.Date;

public abstract interface PersonalInfoDao
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract Pagination getPageBySelect(String paramString, Integer paramInteger1, Integer paramInteger2, Date paramDate1, Date paramDate2, int paramInt1, int paramInt2);
  
  public abstract Pagination getPageBySelect(int paramInt1, int paramInt2);
  
  public abstract PersonalInfo findById(Integer paramInteger);
  
  public abstract PersonalInfo save(PersonalInfo paramPersonalInfo);
  
  public abstract PersonalInfo updateByUpdater(Updater<PersonalInfo> paramUpdater);
  
  public abstract PersonalInfo deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.dao.PersonalInfoDao
 * JD-Core Version:    0.7.0.1
 */