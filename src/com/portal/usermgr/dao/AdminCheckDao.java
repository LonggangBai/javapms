package com.portal.usermgr.dao;

import com.javapms.basic.hibernate3.Updater;
import com.portal.usermgr.entity.AdminCheck;

public abstract interface AdminCheckDao
{
  public abstract AdminCheck findById(Integer paramInteger);
  
  public abstract AdminCheck save(AdminCheck paramAdminCheck);
  
  public abstract AdminCheck updateByUpdater(Updater<AdminCheck> paramUpdater);
  
  public abstract int deleteBySiteId(Integer paramInteger);
  
  public abstract AdminCheck deleteById(Integer paramInteger);
  
  public abstract void delete(AdminCheck paramAdminCheck);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.dao.AdminCheckDao
 * JD-Core Version:    0.7.0.1
 */