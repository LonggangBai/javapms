package com.portal.usermgr.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.usermgr.entity.GroupPerm;

public abstract interface GroupPermDao
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract GroupPerm findById(Integer paramInteger);
  
  public abstract GroupPerm save(GroupPerm paramGroupPerm);
  
  public abstract GroupPerm updateByUpdater(Updater<GroupPerm> paramUpdater);
  
  public abstract GroupPerm deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.dao.GroupPermDao
 * JD-Core Version:    0.7.0.1
 */