package com.portal.datacenter.commdata.service;

import com.javapms.basic.page.Pagination;
import com.portal.datacenter.commdata.entity.EconomyType;
import java.util.List;

public abstract interface EconomyTypeService
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract List<EconomyType> getEconomyTypeList();
  
  public abstract EconomyType findByCode(String paramString);
  
  public abstract EconomyType findById(Integer paramInteger);
  
  public abstract EconomyType save(EconomyType paramEconomyType);
  
  public abstract EconomyType update(EconomyType paramEconomyType);
  
  public abstract EconomyType deleteById(Integer paramInteger);
  
  public abstract EconomyType[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.commdata.service.EconomyTypeService
 * JD-Core Version:    0.7.0.1
 */