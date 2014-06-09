package com.portal.datacenter.commdata.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.datacenter.commdata.entity.Specialty;
import java.util.List;

public abstract interface SpecialtyDao
{
  public abstract Pagination getPage(String paramString, int paramInt1, int paramInt2);
  
  public abstract List<Specialty> getSpecialtyList(Integer paramInteger);
  
  public abstract List<Specialty> getSpecialtyChild(Integer paramInteger);
  
  public abstract Specialty findByCode(String paramString);
  
  public abstract Specialty findById(Integer paramInteger);
  
  public abstract Specialty save(Specialty paramSpecialty);
  
  public abstract Specialty updateByUpdater(Updater<Specialty> paramUpdater);
  
  public abstract Specialty deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.commdata.dao.SpecialtyDao
 * JD-Core Version:    0.7.0.1
 */