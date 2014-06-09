package com.portal.usermgr.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.usermgr.entity.SiteMessageExt;

public abstract interface SiteMessageExtDao
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract int deleteByUserId(Integer paramInteger);
  
  public abstract SiteMessageExt findById(Integer paramInteger);
  
  public abstract SiteMessageExt save(SiteMessageExt paramSiteMessageExt);
  
  public abstract SiteMessageExt updateByUpdater(Updater<SiteMessageExt> paramUpdater);
  
  public abstract SiteMessageExt deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.dao.SiteMessageExtDao
 * JD-Core Version:    0.7.0.1
 */