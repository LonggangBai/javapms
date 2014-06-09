package com.portal.sysmgr.service;

import com.portal.sysmgr.entity.Site;
import com.portal.usermgr.entity.User;
import java.io.IOException;
import java.util.List;

public abstract interface SiteService
{
  public abstract List<Site> getList();
  
  public abstract List<Site> getListFromCache();
  
  public abstract Site findByDomain(String paramString, boolean paramBoolean);
  
  public abstract Site findById(Integer paramInteger);
  
  public abstract Site save(Site paramSite1, User paramUser, Site paramSite2, Integer paramInteger)
    throws IOException;
  
  public abstract Site update(Site paramSite);
  
  public abstract void updateTplStyle(Integer paramInteger, String paramString);
  
  public abstract Site deleteById(Integer paramInteger);
  
  public abstract Site[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.sysmgr.service.SiteService
 * JD-Core Version:    0.7.0.1
 */