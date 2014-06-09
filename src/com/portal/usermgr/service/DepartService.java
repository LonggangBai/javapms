package com.portal.usermgr.service;

import com.javapms.basic.page.Pagination;
import com.portal.sysmgr.entity.Site;
import com.portal.usermgr.entity.Depart;
import java.util.List;

public abstract interface DepartService
{
  public abstract Pagination getPage(Integer paramInteger, String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract List<Depart> getListByTag(Integer paramInteger);
  
  public abstract List<Depart> getAllList(Integer paramInteger);
  
  public abstract List<Depart> getListNoParent(Integer paramInteger);
  
  public abstract List<Depart> getListByParent(Integer paramInteger);
  
  public abstract Depart getDepartByPath(String paramString, Integer paramInteger);
  
  public abstract Depart findById(Integer paramInteger);
  
  public abstract Depart save(Depart paramDepart, Site paramSite, Integer paramInteger1, Integer paramInteger2, Integer[] paramArrayOfInteger);
  
  public abstract Depart update(Depart paramDepart, Integer paramInteger1, Integer paramInteger2, Integer[] paramArrayOfInteger);
  
  public abstract Depart deleteById(Integer paramInteger);
  
  public abstract Depart[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.service.DepartService
 * JD-Core Version:    0.7.0.1
 */