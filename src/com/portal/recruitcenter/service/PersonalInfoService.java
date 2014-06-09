package com.portal.recruitcenter.service;

import com.javapms.basic.page.Pagination;
import com.portal.recruitcenter.entity.PersonalInfo;
import com.portal.recruitcenter.entity.PersonalInfoExt;
import com.portal.sysmgr.entity.Site;
import java.util.Date;
import org.springframework.web.multipart.MultipartFile;

public abstract interface PersonalInfoService
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract Pagination getPageBySelect(String paramString, Integer paramInteger1, Integer paramInteger2, Date paramDate1, Date paramDate2, int paramInt1, int paramInt2);
  
  public abstract Pagination getPageBySelect(int paramInt1, int paramInt2);
  
  public abstract PersonalInfo findById(Integer paramInteger);
  
  public abstract PersonalInfo regist(PersonalInfo paramPersonalInfo, PersonalInfoExt paramPersonalInfoExt, String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract PersonalInfo save(PersonalInfo paramPersonalInfo, PersonalInfoExt paramPersonalInfoExt, Integer paramInteger);
  
  public abstract PersonalInfo update(PersonalInfo paramPersonalInfo, PersonalInfoExt paramPersonalInfoExt, Integer paramInteger, MultipartFile paramMultipartFile, Site paramSite);
  
  public abstract PersonalInfo update(PersonalInfo paramPersonalInfo);
  
  public abstract PersonalInfo deleteById(Integer paramInteger);
  
  public abstract PersonalInfo[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.service.PersonalInfoService
 * JD-Core Version:    0.7.0.1
 */