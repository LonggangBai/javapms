package com.portal.doccenter.dao;

import com.javapms.basic.hibernate3.Updater;
import com.portal.doccenter.entity.ModelField;
import java.util.List;

public abstract interface ModelFieldDao
{
  public abstract List<ModelField> getList(Integer paramInteger, boolean paramBoolean, String paramString1, String paramString2);
  
  public abstract List<ModelField> getListByPriority(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, boolean paramBoolean);
  
  public abstract int getMaxPriority(Integer paramInteger);
  
  public abstract ModelField findById(Integer paramInteger);
  
  public abstract ModelField save(ModelField paramModelField);
  
  public abstract ModelField updateByUpdater(Updater<ModelField> paramUpdater);
  
  public abstract ModelField deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.dao.ModelFieldDao
 * JD-Core Version:    0.7.0.1
 */