package com.portal.doccenter.service;

import com.portal.doccenter.entity.Article;
import com.portal.doccenter.entity.DocStatis;

public abstract interface DocStatisService
{
  public abstract DocStatis save(Article paramArticle);
  
  public abstract DocStatis update(Integer paramInteger1, Integer paramInteger2);
  
  public abstract DocStatis findById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.service.DocStatisService
 * JD-Core Version:    0.7.0.1
 */