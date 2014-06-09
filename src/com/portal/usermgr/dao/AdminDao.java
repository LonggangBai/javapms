package com.portal.usermgr.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.usermgr.entity.Admin;

public abstract interface AdminDao
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract Pagination getPage(String paramString1, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, String paramString2, String paramString3, int paramInt1, int paramInt2);
  
  public abstract Admin findById(Integer paramInteger);
  
  public abstract Admin save(Admin paramAdmin);
  
  public abstract Admin updateByUpdater(Updater<Admin> paramUpdater);
  
  public abstract Admin deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.dao.AdminDao
 * JD-Core Version:    0.7.0.1
 */