package com.portal.recruitcenter.service;

import com.javapms.basic.page.Pagination;
import com.portal.recruitcenter.entity.CompanyInfo;
import com.portal.recruitcenter.entity.CompanyInfoExt;
import java.util.Date;

public abstract interface CompanyInfoService
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract Pagination getPageByTag(String paramString, Integer paramInteger1, Integer paramInteger2, Boolean paramBoolean1, Byte paramByte, Integer paramInteger3, Boolean paramBoolean2, Boolean paramBoolean3, int paramInt1, int paramInt2);
  
  public abstract Pagination getPageBySelect(String paramString, Integer paramInteger1, Integer paramInteger2, Date paramDate1, Date paramDate2, int paramInt1, int paramInt2);
  
  public abstract Pagination getPageByApply(String paramString, Integer paramInteger1, Integer paramInteger2, Date paramDate1, Date paramDate2, int paramInt1, int paramInt2);
  
  public abstract CompanyInfo findById(Integer paramInteger);
  
  public abstract CompanyInfo regist(CompanyInfo paramCompanyInfo, CompanyInfoExt paramCompanyInfoExt, String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract CompanyInfo save(CompanyInfo paramCompanyInfo, CompanyInfoExt paramCompanyInfoExt, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3);
  
  public abstract CompanyInfo update(CompanyInfo paramCompanyInfo, CompanyInfoExt paramCompanyInfoExt, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4);
  
  public abstract CompanyInfo applyVip(CompanyInfo paramCompanyInfo, Integer paramInteger);
  
  public abstract CompanyInfo applyAgree(Integer paramInteger);
  
  public abstract CompanyInfo reflush(CompanyInfo paramCompanyInfo);
  
  public abstract CompanyInfo update(CompanyInfo paramCompanyInfo, Integer paramInteger);
  
  public abstract CompanyInfo deleteById(Integer paramInteger);
  
  public abstract CompanyInfo[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.service.CompanyInfoService
 * JD-Core Version:    0.7.0.1
 */