package com.portal.datacenter.docdata.dao;

import com.javapms.basic.hibernate3.Updater;
import com.portal.datacenter.docdata.entity.Sensitivity;
import java.util.List;

public abstract interface SensitivityDao
{
  public abstract List<Sensitivity> getList(boolean paramBoolean, String paramString1, String paramString2);
  
  public abstract Sensitivity findById(Integer paramInteger);
  
  public abstract Sensitivity save(Sensitivity paramSensitivity);
  
  public abstract Sensitivity updateByUpdater(Updater<Sensitivity> paramUpdater);
  
  public abstract Sensitivity deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.docdata.dao.SensitivityDao
 * JD-Core Version:    0.7.0.1
 */