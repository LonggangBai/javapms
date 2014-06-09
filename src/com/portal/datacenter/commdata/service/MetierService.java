package com.portal.datacenter.commdata.service;

import com.javapms.basic.page.Pagination;
import com.portal.datacenter.commdata.entity.Metier;
import java.util.List;

public abstract interface MetierService
{
  public abstract Pagination getPage(String paramString, int paramInt1, int paramInt2);
  
  public abstract List<Metier> getMetierList(Integer paramInteger);
  
  public abstract List<Metier> getMetierChild(Integer paramInteger);
  
  public abstract Metier findByCode(String paramString);
  
  public abstract Metier findById(Integer paramInteger);
  
  public abstract Metier save(Metier paramMetier, Integer paramInteger);
  
  public abstract Metier update(Metier paramMetier, Integer paramInteger);
  
  public abstract Metier deleteById(Integer paramInteger);
  
  public abstract Metier[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.commdata.service.MetierService
 * JD-Core Version:    0.7.0.1
 */