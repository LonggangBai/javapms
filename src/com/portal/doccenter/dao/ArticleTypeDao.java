package com.portal.doccenter.dao;

import com.javapms.basic.hibernate3.Updater;
import com.portal.doccenter.entity.ArticleType;
import java.util.List;

public abstract interface ArticleTypeDao
{
  public abstract List<ArticleType> getList(boolean paramBoolean, String paramString1, String paramString2);
  
  public abstract ArticleType getDef();
  
  public abstract ArticleType findById(Integer paramInteger);
  
  public abstract ArticleType save(ArticleType paramArticleType);
  
  public abstract ArticleType updateByUpdater(Updater<ArticleType> paramUpdater);
  
  public abstract ArticleType deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.dao.ArticleTypeDao
 * JD-Core Version:    0.7.0.1
 */