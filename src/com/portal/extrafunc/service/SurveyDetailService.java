package com.portal.extrafunc.service;

import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.SurveyDetail;
import com.portal.extrafunc.entity.SurveyTheme;
import com.portal.usermgr.entity.User;

public abstract interface SurveyDetailService
{
  public abstract Pagination getPage(Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract SurveyDetail findById(Integer paramInteger);
  
  public abstract SurveyDetail save(String paramString, SurveyTheme paramSurveyTheme, User paramUser);
  
  public abstract SurveyDetail update(SurveyDetail paramSurveyDetail);
  
  public abstract SurveyDetail deleteById(Integer paramInteger);
  
  public abstract SurveyDetail[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.SurveyDetailService
 * JD-Core Version:    0.7.0.1
 */