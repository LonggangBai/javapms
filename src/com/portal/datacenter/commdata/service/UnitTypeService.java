package com.portal.datacenter.commdata.service;

import com.javapms.basic.page.Pagination;
import com.portal.datacenter.commdata.entity.UnitType;

public abstract interface UnitTypeService
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract UnitType findById(Integer paramInteger);
  
  public abstract UnitType save(UnitType paramUnitType);
  
  public abstract UnitType update(UnitType paramUnitType);
  
  public abstract UnitType deleteById(Integer paramInteger);
  
  public abstract UnitType[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.commdata.service.UnitTypeService
 * JD-Core Version:    0.7.0.1
 */