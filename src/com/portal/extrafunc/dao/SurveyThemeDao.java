package com.portal.extrafunc.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.SurveyTheme;
import java.util.List;

public abstract interface SurveyThemeDao
{
  public abstract Pagination getPage(Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract List<SurveyTheme> getList(Integer paramInteger);
  
  public abstract SurveyTheme findById(Integer paramInteger);
  
  public abstract SurveyTheme save(SurveyTheme paramSurveyTheme);
  
  public abstract SurveyTheme updateByUpdater(Updater<SurveyTheme> paramUpdater);
  
  public abstract SurveyTheme deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.dao.SurveyThemeDao
 * JD-Core Version:    0.7.0.1
 */