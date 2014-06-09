package com.portal.usermgr.service;

import com.portal.usermgr.entity.User;

public abstract interface UserService
{
  public abstract User findById(Integer paramInteger);
  
  public abstract User findByUsername(String paramString);
  
  public abstract User findByPersonal(Integer paramInteger);
  
  public abstract User findByCompany(Integer paramInteger);
  
  public abstract User save(User paramUser);
  
  public abstract User update(User paramUser);
  
  public abstract User updatePass(Integer paramInteger, String paramString);
  
  public abstract User deleteById(Integer paramInteger);
  
  public abstract User[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.service.UserService
 * JD-Core Version:    0.7.0.1
 */