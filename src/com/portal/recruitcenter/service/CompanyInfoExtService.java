package com.portal.recruitcenter.service;

import com.javapms.basic.page.Pagination;
import com.portal.recruitcenter.entity.CompanyInfo;
import com.portal.recruitcenter.entity.CompanyInfoExt;

public abstract interface CompanyInfoExtService
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract CompanyInfoExt findById(Integer paramInteger);
  
  public abstract CompanyInfoExt save(CompanyInfoExt paramCompanyInfoExt, CompanyInfo paramCompanyInfo);
  
  public abstract CompanyInfoExt update(CompanyInfoExt paramCompanyInfoExt, CompanyInfo paramCompanyInfo);
  
  public abstract CompanyInfoExt deleteById(Integer paramInteger);
  
  public abstract CompanyInfoExt[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.service.CompanyInfoExtService
 * JD-Core Version:    0.7.0.1
 */