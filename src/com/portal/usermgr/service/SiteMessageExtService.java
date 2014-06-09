package com.portal.usermgr.service;

import com.javapms.basic.page.Pagination;
import com.portal.usermgr.entity.SiteMessage;
import com.portal.usermgr.entity.SiteMessageExt;

public abstract interface SiteMessageExtService
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract int deleteByUserId(Integer paramInteger);
  
  public abstract SiteMessageExt findById(Integer paramInteger);
  
  public abstract SiteMessageExt save(SiteMessageExt paramSiteMessageExt, SiteMessage paramSiteMessage);
  
  public abstract SiteMessageExt update(SiteMessageExt paramSiteMessageExt);
  
  public abstract SiteMessageExt deleteById(Integer paramInteger);
  
  public abstract SiteMessageExt[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.service.SiteMessageExtService
 * JD-Core Version:    0.7.0.1
 */