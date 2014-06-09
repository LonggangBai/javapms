package com.portal.datacenter.docdata.service;

import com.portal.datacenter.docdata.entity.Keyword;
import com.portal.sysmgr.entity.Site;
import java.util.List;

public abstract interface KeywordService
{
  public abstract List<Keyword> getListBySiteId(Integer paramInteger, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2);
  
  public abstract String attachKeyword(Integer paramInteger, String paramString);
  
  public abstract Keyword findById(Integer paramInteger);
  
  public abstract Keyword save(Keyword paramKeyword, Site paramSite);
  
  public abstract Keyword update(Keyword paramKeyword);
  
  public abstract Keyword deleteById(Integer paramInteger);
  
  public abstract Keyword[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.docdata.service.KeywordService
 * JD-Core Version:    0.7.0.1
 */