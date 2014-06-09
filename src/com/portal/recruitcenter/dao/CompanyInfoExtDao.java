package com.portal.recruitcenter.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.recruitcenter.entity.CompanyInfoExt;

public abstract interface CompanyInfoExtDao
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract CompanyInfoExt findById(Integer paramInteger);
  
  public abstract CompanyInfoExt save(CompanyInfoExt paramCompanyInfoExt);
  
  public abstract CompanyInfoExt updateByUpdater(Updater<CompanyInfoExt> paramUpdater);
  
  public abstract CompanyInfoExt deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.dao.CompanyInfoExtDao
 * JD-Core Version:    0.7.0.1
 */