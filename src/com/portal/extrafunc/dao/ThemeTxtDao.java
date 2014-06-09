package com.portal.extrafunc.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.ThemeTxt;

public abstract interface ThemeTxtDao
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract ThemeTxt findById(Integer paramInteger);
  
  public abstract ThemeTxt save(ThemeTxt paramThemeTxt);
  
  public abstract ThemeTxt updateByUpdater(Updater<ThemeTxt> paramUpdater);
  
  public abstract ThemeTxt deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.dao.ThemeTxtDao
 * JD-Core Version:    0.7.0.1
 */