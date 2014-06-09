package com.portal.extrafunc.service;

import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.Theme;
import com.portal.extrafunc.entity.ThemeTxt;

public abstract interface ThemeTxtService
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract ThemeTxt findById(Integer paramInteger);
  
  public abstract ThemeTxt save(Theme paramTheme);
  
  public abstract ThemeTxt update(Integer paramInteger1, Integer paramInteger2);
  
  public abstract ThemeTxt deleteById(Integer paramInteger);
  
  public abstract ThemeTxt[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.ThemeTxtService
 * JD-Core Version:    0.7.0.1
 */