package com.portal.extrafunc.service;

import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.SurveyTheme;
import com.portal.usermgr.entity.User;
import java.util.List;
import java.util.Map;

public abstract interface SurveyThemeService
{
  public abstract Pagination getPage(Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract List<SurveyTheme> getList(Integer paramInteger);
  
  public abstract SurveyTheme findById(Integer paramInteger);
  
  public abstract SurveyTheme save(SurveyTheme paramSurveyTheme, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, String[] paramArrayOfString, Integer[] paramArrayOfInteger1, Integer[] paramArrayOfInteger2);
  
  public abstract SurveyTheme update(SurveyTheme paramSurveyTheme, Integer paramInteger1, Integer paramInteger2, String[] paramArrayOfString, Integer[] paramArrayOfInteger1, Integer[] paramArrayOfInteger2);
  
  public abstract void voteSurvey(Integer paramInteger, Map<String, String> paramMap, Map<String, String[]> paramMap1, String paramString, User paramUser);
  
  public abstract SurveyTheme deleteById(Integer paramInteger);
  
  public abstract SurveyTheme[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.SurveyThemeService
 * JD-Core Version:    0.7.0.1
 */