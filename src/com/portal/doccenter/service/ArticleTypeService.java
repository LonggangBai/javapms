package com.portal.doccenter.service;

import com.portal.doccenter.entity.ArticleType;
import java.util.List;

public abstract interface ArticleTypeService
{
  public abstract List<ArticleType> getList(boolean paramBoolean, String paramString1, String paramString2);
  
  public abstract ArticleType getDef();
  
  public abstract ArticleType findById(Integer paramInteger);
  
  public abstract ArticleType save(ArticleType paramArticleType);
  
  public abstract ArticleType update(ArticleType paramArticleType);
  
  public abstract ArticleType deleteById(Integer paramInteger);
  
  public abstract ArticleType[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.service.ArticleTypeService
 * JD-Core Version:    0.7.0.1
 */