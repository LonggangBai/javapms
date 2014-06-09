package com.portal.usermgr.dao;

import com.javapms.basic.hibernate3.Updater;
import com.portal.usermgr.entity.Group;
import java.util.List;

public abstract interface GroupDao
{
  public abstract List<Group> getList(Integer paramInteger, String paramString1, String paramString2);
  
  public abstract Group findById(Integer paramInteger);
  
  public abstract Group save(Group paramGroup);
  
  public abstract Group updateByUpdater(Updater<Group> paramUpdater);
  
  public abstract Group deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.dao.GroupDao
 * JD-Core Version:    0.7.0.1
 */