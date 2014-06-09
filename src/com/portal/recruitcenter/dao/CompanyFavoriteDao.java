package com.portal.recruitcenter.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.recruitcenter.entity.CompanyFavorite;

public abstract interface CompanyFavoriteDao
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract Pagination getPageByTag(Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract CompanyFavorite getFavoriteByCompany(Integer paramInteger1, Integer paramInteger2);
  
  public abstract int countByCompanyId(Integer paramInteger);
  
  public abstract int deleteByCompanyId(Integer paramInteger);
  
  public abstract int deleteByResumeId(Integer paramInteger);
  
  public abstract int deleteByPersonalId(Integer paramInteger);
  
  public abstract CompanyFavorite findById(Integer paramInteger);
  
  public abstract CompanyFavorite save(CompanyFavorite paramCompanyFavorite);
  
  public abstract CompanyFavorite updateByUpdater(Updater<CompanyFavorite> paramUpdater);
  
  public abstract CompanyFavorite deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.dao.CompanyFavoriteDao
 * JD-Core Version:    0.7.0.1
 */