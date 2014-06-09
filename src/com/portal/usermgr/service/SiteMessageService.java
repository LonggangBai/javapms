package com.portal.usermgr.service;

import com.javapms.basic.page.Pagination;
import com.portal.usermgr.entity.SiteMessage;
import com.portal.usermgr.entity.SiteMessageExt;

public abstract interface SiteMessageService
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract Pagination getPageByTag(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, int paramInt1, int paramInt2);
  
  public abstract int countByFromId(Integer paramInteger);
  
  public abstract int countByToId(Integer paramInteger);
  
  public abstract int deleteByUserId(Integer paramInteger);
  
  public abstract SiteMessage findById(Integer paramInteger);
  
  public abstract SiteMessage save(SiteMessage paramSiteMessage, SiteMessageExt paramSiteMessageExt, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3);
  
  public abstract SiteMessage update(SiteMessage paramSiteMessage);
  
  public abstract SiteMessage deleteById(Integer paramInteger);
  
  public abstract SiteMessage[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.service.SiteMessageService
 * JD-Core Version:    0.7.0.1
 */