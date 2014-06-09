package com.portal.extrafunc.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.Theme;
import java.util.List;

public abstract interface ThemeDao
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract Pagination getThemePageForTag(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract List<Theme> getThemeByTop();
  
  public abstract List<Theme> getThemeByLight();
  
  public abstract List<Theme> getThemeByLock();
  
  public abstract Theme findById(Integer paramInteger);
  
  public abstract Theme save(Theme paramTheme);
  
  public abstract Theme updateByUpdater(Updater<Theme> paramUpdater);
  
  public abstract Theme deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.dao.ThemeDao
 * JD-Core Version:    0.7.0.1
 */