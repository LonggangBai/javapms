package com.portal.recruitcenter.service;

import com.javapms.basic.page.Pagination;
import com.portal.recruitcenter.entity.CompanyFavorite;

public abstract interface CompanyFavoriteService
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
  
  public abstract CompanyFavorite saveFavorite(Integer paramInteger1, Integer paramInteger2);
  
  public abstract CompanyFavorite update(CompanyFavorite paramCompanyFavorite);
  
  public abstract CompanyFavorite deleteById(Integer paramInteger);
  
  public abstract CompanyFavorite[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.service.CompanyFavoriteService
 * JD-Core Version:    0.7.0.1
 */