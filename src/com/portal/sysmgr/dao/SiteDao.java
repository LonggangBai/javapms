package com.portal.sysmgr.dao;

import com.javapms.basic.hibernate3.Updater;
import com.portal.sysmgr.entity.Site;
import java.util.List;

public abstract interface SiteDao
{
  public abstract int siteCount(boolean paramBoolean);
  
  public abstract List<Site> getList(boolean paramBoolean);
  
  public abstract Site findByDomain(String paramString, boolean paramBoolean);
  
  public abstract Site findById(Integer paramInteger);
  
  public abstract Site save(Site paramSite);
  
  public abstract Site updateByUpdater(Updater<Site> paramUpdater);
  
  public abstract Site deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.sysmgr.dao.SiteDao
 * JD-Core Version:    0.7.0.1
 */