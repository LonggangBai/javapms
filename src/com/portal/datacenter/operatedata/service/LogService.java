package com.portal.datacenter.operatedata.service;

import com.javapms.basic.page.Pagination;
import com.portal.datacenter.operatedata.entity.Log;
import com.portal.usermgr.entity.User;
import javax.servlet.http.HttpServletRequest;

public abstract interface LogService
{
  public abstract Pagination getPage(Integer paramInteger1, Integer paramInteger2, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2);
  
  public abstract Log findById(Integer paramInteger);
  
  public abstract Log operating(HttpServletRequest paramHttpServletRequest, String paramString1, String paramString2);
  
  public abstract Log loginFailure(HttpServletRequest paramHttpServletRequest, String paramString1, String paramString2);
  
  public abstract Log loginSuccess(HttpServletRequest paramHttpServletRequest, User paramUser, String paramString);
  
  public abstract Log save(Log paramLog);
  
  public abstract Log deleteById(Integer paramInteger);
  
  public abstract Log[] deleteByIds(Integer[] paramArrayOfInteger);
  
  public abstract int deleteBatch(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.operatedata.service.LogService
 * JD-Core Version:    0.7.0.1
 */