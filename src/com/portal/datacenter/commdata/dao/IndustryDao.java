package com.portal.datacenter.commdata.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.datacenter.commdata.entity.Industry;
import java.util.List;

public abstract interface IndustryDao
{
  public abstract Pagination getPage(String paramString, int paramInt1, int paramInt2);
  
  public abstract List<Industry> getIndustryList(Integer paramInteger);
  
  public abstract List<Industry> getIndustryChild(Integer paramInteger);
  
  public abstract Industry findByCode(String paramString);
  
  public abstract Industry findById(Integer paramInteger);
  
  public abstract Industry save(Industry paramIndustry);
  
  public abstract Industry updateByUpdater(Updater<Industry> paramUpdater);
  
  public abstract Industry deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.commdata.dao.IndustryDao
 * JD-Core Version:    0.7.0.1
 */