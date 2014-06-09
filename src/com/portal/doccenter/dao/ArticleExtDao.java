package com.portal.doccenter.dao;

import com.javapms.basic.hibernate3.Updater;
import com.portal.doccenter.entity.ArticleExt;

public abstract interface ArticleExtDao
{
  public abstract ArticleExt findById(Integer paramInteger);
  
  public abstract ArticleExt save(ArticleExt paramArticleExt);
  
  public abstract ArticleExt updateByUpdater(Updater<ArticleExt> paramUpdater);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.dao.ArticleExtDao
 * JD-Core Version:    0.7.0.1
 */