package com.portal.usermgr.service;

import com.javapms.basic.page.Pagination;
import com.portal.sysmgr.entity.Site;
import com.portal.usermgr.entity.Admin;
import com.portal.usermgr.entity.User;

public abstract interface AdminService
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract Pagination getPage(String paramString1, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, String paramString2, String paramString3, int paramInt1, int paramInt2);
  
  public abstract Admin findById(Integer paramInteger);
  
  public abstract Admin saveAdmin(User paramUser, Admin paramAdmin, String paramString, Integer paramInteger1, Integer paramInteger2, Site paramSite, Byte paramByte);
  
  public abstract Admin updateAdmin(User paramUser, Admin paramAdmin, Integer paramInteger1, Integer paramInteger2, Site paramSite, Byte paramByte);
  
  public abstract void updateLoginInfo(User paramUser, String paramString);
  
  public abstract Admin save(Admin paramAdmin);
  
  public abstract Admin update(Admin paramAdmin);
  
  public abstract Admin updatePass(Integer paramInteger, String paramString);
  
  public abstract Admin deleteById(Integer paramInteger);
  
  public abstract Admin[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.service.AdminService
 * JD-Core Version:    0.7.0.1
 */