package com.portal.usermgr.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.usermgr.entity.SiteMessage;

public abstract interface SiteMessageDao
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract Pagination getPageByTag(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, int paramInt1, int paramInt2);
  
  public abstract int countByFromId(Integer paramInteger);
  
  public abstract int countByToId(Integer paramInteger);
  
  public abstract int deleteByUserId(Integer paramInteger);
  
  public abstract SiteMessage findById(Integer paramInteger);
  
  public abstract SiteMessage save(SiteMessage paramSiteMessage);
  
  public abstract SiteMessage updateByUpdater(Updater<SiteMessage> paramUpdater);
  
  public abstract SiteMessage deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.dao.SiteMessageDao
 * JD-Core Version:    0.7.0.1
 */