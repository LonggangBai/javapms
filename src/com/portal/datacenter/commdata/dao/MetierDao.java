package com.portal.datacenter.commdata.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.datacenter.commdata.entity.Metier;
import java.util.List;

public abstract interface MetierDao
{
  public abstract Pagination getPage(String paramString, int paramInt1, int paramInt2);
  
  public abstract List<Metier> getMetierList(Integer paramInteger);
  
  public abstract List<Metier> getMetierChild(Integer paramInteger);
  
  public abstract Metier findByCode(String paramString);
  
  public abstract Metier findById(Integer paramInteger);
  
  public abstract Metier save(Metier paramMetier);
  
  public abstract Metier updateByUpdater(Updater<Metier> paramUpdater);
  
  public abstract Metier deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.commdata.dao.MetierDao
 * JD-Core Version:    0.7.0.1
 */