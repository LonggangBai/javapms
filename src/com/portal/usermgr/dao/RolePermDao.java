package com.portal.usermgr.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.usermgr.entity.RolePerm;

public abstract interface RolePermDao
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract RolePerm findById(Integer paramInteger);
  
  public abstract RolePerm save(RolePerm paramRolePerm);
  
  public abstract RolePerm updateByUpdater(Updater<RolePerm> paramUpdater);
  
  public abstract RolePerm deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.dao.RolePermDao
 * JD-Core Version:    0.7.0.1
 */