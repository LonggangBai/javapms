package com.portal.usermgr.dao;

import com.javapms.basic.hibernate3.Updater;
import com.portal.usermgr.entity.User;

public abstract interface UserDao
{
  public abstract User findById(Integer paramInteger);
  
  public abstract User findByUsername(String paramString);
  
  public abstract User findByPersonal(Integer paramInteger);
  
  public abstract User findByCompany(Integer paramInteger);
  
  public abstract int countByUsername(String paramString);
  
  public abstract int countByEmail(String paramString);
  
  public abstract User save(User paramUser);
  
  public abstract User updateByUpdater(Updater<User> paramUpdater);
  
  public abstract User deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.dao.UserDao
 * JD-Core Version:    0.7.0.1
 */