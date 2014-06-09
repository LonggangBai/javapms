package com.portal.extrafunc.service;

import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.Advert;
import com.portal.sysmgr.entity.Site;
import java.util.List;

public abstract interface AdvertService
{
  public abstract Pagination getPage(Integer paramInteger1, Integer paramInteger2, String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract List<Advert> getListByTag(Integer paramInteger1, Integer paramInteger2);
  
  public abstract Advert findById(Integer paramInteger);
  
  public abstract Advert save(Advert paramAdvert, Integer paramInteger, boolean paramBoolean, Site paramSite);
  
  public abstract Advert update(Advert paramAdvert, Integer paramInteger, boolean paramBoolean);
  
  public abstract Advert deleteById(Integer paramInteger);
  
  public abstract Advert[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.AdvertService
 * JD-Core Version:    0.7.0.1
 */