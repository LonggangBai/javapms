package com.portal.usermgr.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.usermgr.entity.Depart;
import java.util.List;

public abstract interface DepartDao
{
  public abstract Pagination getPage(Integer paramInteger, String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract List<Depart> getListByTag(Integer paramInteger);
  
  public abstract List<Depart> getAllList(Integer paramInteger);
  
  public abstract List<Depart> getListNoParent(Integer paramInteger);
  
  public abstract List<Depart> getListByParent(Integer paramInteger);
  
  public abstract Depart getDepartByPath(String paramString, Integer paramInteger);
  
  public abstract Depart findById(Integer paramInteger);
  
  public abstract Depart save(Depart paramDepart);
  
  public abstract Depart updateByUpdater(Updater<Depart> paramUpdater);
  
  public abstract Depart deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.dao.DepartDao
 * JD-Core Version:    0.7.0.1
 */