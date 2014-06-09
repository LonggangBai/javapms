package com.portal.recruitcenter.service;

import com.javapms.basic.page.Pagination;
import com.portal.recruitcenter.entity.CompanyFairs;

public abstract interface CompanyFairsService
{
  public abstract Pagination getPage(Integer paramInteger1, Integer paramInteger2, int paramInt1, int paramInt2);
  
  public abstract Pagination getPageByTag(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, int paramInt1, int paramInt2);
  
  public abstract CompanyFairs findById(Integer paramInteger);
  
  public abstract CompanyFairs save(CompanyFairs paramCompanyFairs, Integer paramInteger1, Integer paramInteger2);
  
  public abstract CompanyFairs update(CompanyFairs paramCompanyFairs, Integer paramInteger1, Integer paramInteger2);
  
  public abstract CompanyFairs deleteById(Integer paramInteger);
  
  public abstract CompanyFairs[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.service.CompanyFairsService
 * JD-Core Version:    0.7.0.1
 */