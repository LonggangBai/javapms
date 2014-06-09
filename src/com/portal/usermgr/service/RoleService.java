package com.portal.usermgr.service;

import com.javapms.basic.page.Pagination;
import com.portal.sysmgr.entity.Site;
import com.portal.usermgr.entity.Role;
import com.portal.usermgr.entity.RolePerm;
import java.util.List;

public abstract interface RoleService
{
  public abstract Pagination getPage(String paramString1, Integer paramInteger, String paramString2, String paramString3, int paramInt1, int paramInt2);
  
  public abstract List<Role> getListBySite(Integer paramInteger);
  
  public abstract Role findById(Integer paramInteger);
  
  public abstract Role saveRole(Role paramRole, RolePerm paramRolePerm, Site paramSite);
  
  public abstract Role updateRole(Role paramRole, RolePerm paramRolePerm);
  
  public abstract Role save(Role paramRole);
  
  public abstract Role update(Role paramRole);
  
  public abstract Role deleteById(Integer paramInteger);
  
  public abstract Role[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.service.RoleService
 * JD-Core Version:    0.7.0.1
 */