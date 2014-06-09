package com.portal.usermgr.service;

import com.javapms.basic.page.Pagination;
import com.portal.usermgr.entity.Role;
import com.portal.usermgr.entity.RolePerm;

public abstract interface RolePermService
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract RolePerm findById(Integer paramInteger);
  
  public abstract RolePerm save(Role paramRole, RolePerm paramRolePerm);
  
  public abstract RolePerm save(RolePerm paramRolePerm);
  
  public abstract RolePerm update(RolePerm paramRolePerm);
  
  public abstract RolePerm deleteById(Integer paramInteger);
  
  public abstract RolePerm[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.service.RolePermService
 * JD-Core Version:    0.7.0.1
 */