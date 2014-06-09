package com.portal.doccenter.dao;

import com.javapms.basic.hibernate3.Updater;
import com.portal.doccenter.entity.ArticleTxt;

public abstract interface ArticleTxtDao
{
  public abstract ArticleTxt findById(Integer paramInteger);
  
  public abstract ArticleTxt save(ArticleTxt paramArticleTxt);
  
  public abstract ArticleTxt updateByUpdater(Updater<ArticleTxt> paramUpdater);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.dao.ArticleTxtDao
 * JD-Core Version:    0.7.0.1
 */