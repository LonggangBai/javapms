package com.portal.datacenter.docdata.service;

import com.portal.datacenter.docdata.entity.Sensitivity;
import java.util.List;

public abstract interface SensitivityService
{
  public abstract String replaceSensitivity(String paramString);
  
  public abstract List<Sensitivity> getList(boolean paramBoolean, String paramString1, String paramString2);
  
  public abstract Sensitivity findById(Integer paramInteger);
  
  public abstract Sensitivity save(Sensitivity paramSensitivity);
  
  public abstract Sensitivity update(Sensitivity paramSensitivity);
  
  public abstract Sensitivity deleteById(Integer paramInteger);
  
  public abstract Sensitivity[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.docdata.service.SensitivityService
 * JD-Core Version:    0.7.0.1
 */