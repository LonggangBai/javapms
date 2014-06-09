package com.portal.recruitcenter.service;

import com.javapms.basic.page.Pagination;
import com.portal.recruitcenter.entity.VipType;
import java.util.List;

public abstract interface VipTypeService
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract List<VipType> getAllVipType();
  
  public abstract VipType findById(Integer paramInteger);
  
  public abstract VipType save(VipType paramVipType);
  
  public abstract VipType update(VipType paramVipType);
  
  public abstract VipType deleteById(Integer paramInteger);
  
  public abstract VipType[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.service.VipTypeService
 * JD-Core Version:    0.7.0.1
 */