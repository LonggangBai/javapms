package com.portal.datacenter.docdata.dao;

import com.javapms.basic.hibernate3.Updater;
import com.portal.datacenter.docdata.entity.Keyword;
import java.util.List;

public abstract interface KeywordDao
{
  public abstract List<Keyword> getList(Integer paramInteger, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2);
  
  public abstract Keyword findById(Integer paramInteger);
  
  public abstract Keyword save(Keyword paramKeyword);
  
  public abstract Keyword updateByUpdater(Updater<Keyword> paramUpdater);
  
  public abstract Keyword deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.docdata.dao.KeywordDao
 * JD-Core Version:    0.7.0.1
 */