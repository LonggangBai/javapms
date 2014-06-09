package com.portal.extrafunc.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.Advert;
import java.util.List;

public abstract interface AdvertDao
{
  public abstract Pagination getPage(Integer paramInteger1, Integer paramInteger2, String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract List<Advert> getListByTag(Integer paramInteger1, Integer paramInteger2);
  
  public abstract Advert findById(Integer paramInteger);
  
  public abstract Advert save(Advert paramAdvert);
  
  public abstract Advert updateByUpdater(Updater<Advert> paramUpdater);
  
  public abstract Advert deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.dao.AdvertDao
 * JD-Core Version:    0.7.0.1
 */