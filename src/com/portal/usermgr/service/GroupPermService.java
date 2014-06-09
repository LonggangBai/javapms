package com.portal.usermgr.service;

import com.javapms.basic.page.Pagination;
import com.portal.usermgr.entity.Group;
import com.portal.usermgr.entity.GroupPerm;

public abstract interface GroupPermService
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract GroupPerm findById(Integer paramInteger);
  
  public abstract GroupPerm save(Group paramGroup, GroupPerm paramGroupPerm);
  
  public abstract GroupPerm save(GroupPerm paramGroupPerm);
  
  public abstract GroupPerm update(GroupPerm paramGroupPerm);
  
  public abstract GroupPerm deleteById(Integer paramInteger);
  
  public abstract GroupPerm[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.service.GroupPermService
 * JD-Core Version:    0.7.0.1
 */