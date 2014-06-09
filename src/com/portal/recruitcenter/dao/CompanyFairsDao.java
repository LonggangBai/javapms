package com.portal.recruitcenter.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.recruitcenter.entity.CompanyFairs;

public abstract interface CompanyFairsDao
{
  public abstract Pagination getPage(Integer paramInteger1, Integer paramInteger2, int paramInt1, int paramInt2);
  
  public abstract Pagination getPageByTag(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, int paramInt1, int paramInt2);
  
  public abstract CompanyFairs findById(Integer paramInteger);
  
  public abstract CompanyFairs save(CompanyFairs paramCompanyFairs);
  
  public abstract CompanyFairs updateByUpdater(Updater<CompanyFairs> paramUpdater);
  
  public abstract CompanyFairs deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.dao.CompanyFairsDao
 * JD-Core Version:    0.7.0.1
 */