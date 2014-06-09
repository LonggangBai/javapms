package com.portal.extrafunc.service;

import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.Theme;
import com.portal.usermgr.entity.User;
import java.util.Date;

public abstract interface ThemeService
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract Pagination getThemePageForTag(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract Theme findById(Integer paramInteger);
  
  public abstract Theme save(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, String paramString, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract Theme updateReply(Theme paramTheme, User paramUser, boolean paramBoolean);
  
  public abstract Theme topTheme(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Date paramDate, String paramString);
  
  public abstract Theme essenaTheme(Integer paramInteger1, Integer paramInteger2, Date paramDate, String paramString);
  
  public abstract Theme lightTheme(Integer paramInteger1, Integer paramInteger2, String paramString1, Boolean paramBoolean1, Boolean paramBoolean2, Date paramDate, String paramString2);
  
  public abstract Theme lockTheme(Integer paramInteger1, Integer paramInteger2, Date paramDate, String paramString);
  
  public abstract Theme moveTheme(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, String paramString);
  
  public abstract void themeTopCheck();
  
  public abstract void themeLightCheck();
  
  public abstract void themeLockCheck();
  
  public abstract Theme update(Theme paramTheme);
  
  public abstract Theme updateViewCount(Integer paramInteger1, Integer paramInteger2);
  
  public abstract Theme deleteById(Integer paramInteger);
  
  public abstract Theme[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.ThemeService
 * JD-Core Version:    0.7.0.1
 */