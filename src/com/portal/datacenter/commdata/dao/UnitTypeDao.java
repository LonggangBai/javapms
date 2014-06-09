package com.portal.datacenter.commdata.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.datacenter.commdata.entity.UnitType;

public abstract interface UnitTypeDao
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract UnitType findById(Integer paramInteger);
  
  public abstract UnitType save(UnitType paramUnitType);
  
  public abstract UnitType updateByUpdater(Updater<UnitType> paramUpdater);
  
  public abstract UnitType deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.commdata.dao.UnitTypeDao
 * JD-Core Version:    0.7.0.1
 */