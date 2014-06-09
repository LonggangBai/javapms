package com.portal.datacenter.operatedata.dao;

import com.javapms.basic.page.Pagination;
import com.portal.datacenter.operatedata.entity.Log;
import java.util.Date;

public abstract interface LogDao
{
  public abstract Pagination getPage(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract Log findById(Integer paramInteger);
  
  public abstract Log save(Log paramLog);
  
  public abstract Log deleteById(Integer paramInteger);
  
  public abstract int deleteBatch(Integer paramInteger1, Integer paramInteger2, Date paramDate);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.operatedata.dao.LogDao
 * JD-Core Version:    0.7.0.1
 */