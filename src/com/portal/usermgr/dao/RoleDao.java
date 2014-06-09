package com.portal.usermgr.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.usermgr.entity.Role;
import java.util.List;

public abstract interface RoleDao
{
  public abstract Pagination getPage(String paramString1, Integer paramInteger, String paramString2, String paramString3, int paramInt1, int paramInt2);
  
  public abstract List<Role> getListBySite(Integer paramInteger);
  
  public abstract Role findById(Integer paramInteger);
  
  public abstract Role save(Role paramRole);
  
  public abstract Role updateByUpdater(Updater<Role> paramUpdater);
  
  public abstract Role deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.dao.RoleDao
 * JD-Core Version:    0.7.0.1
 */