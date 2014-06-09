package com.portal.recruitcenter.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.recruitcenter.entity.CompanyInfo;
import java.util.Date;

public abstract interface CompanyInfoDao
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract Pagination getPageByTag(String paramString, Integer paramInteger1, Integer paramInteger2, Boolean paramBoolean1, Byte paramByte, Integer paramInteger3, Boolean paramBoolean2, Boolean paramBoolean3, int paramInt1, int paramInt2);
  
  public abstract Pagination getPageBySelect(String paramString, Integer paramInteger1, Integer paramInteger2, Date paramDate1, Date paramDate2, int paramInt1, int paramInt2);
  
  public abstract Pagination getPageByApply(String paramString, Integer paramInteger1, Integer paramInteger2, Date paramDate1, Date paramDate2, int paramInt1, int paramInt2);
  
  public abstract CompanyInfo findById(Integer paramInteger);
  
  public abstract CompanyInfo save(CompanyInfo paramCompanyInfo);
  
  public abstract CompanyInfo updateByUpdater(Updater<CompanyInfo> paramUpdater);
  
  public abstract CompanyInfo deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.dao.CompanyInfoDao
 * JD-Core Version:    0.7.0.1
 */