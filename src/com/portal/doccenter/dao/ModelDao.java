package com.portal.doccenter.dao;

import com.javapms.basic.hibernate3.Updater;
import com.portal.doccenter.entity.Model;
import java.util.List;

public abstract interface ModelDao
{
  public abstract List<Model> getList(boolean paramBoolean, String paramString1, String paramString2);
  
  public abstract Model getDefModel();
  
  public abstract Model findById(Integer paramInteger);
  
  public abstract Model save(Model paramModel);
  
  public abstract Model updateByUpdater(Updater<Model> paramUpdater);
  
  public abstract Model deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.dao.ModelDao
 * JD-Core Version:    0.7.0.1
 */