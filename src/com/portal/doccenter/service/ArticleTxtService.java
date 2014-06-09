package com.portal.doccenter.service;

import com.portal.doccenter.entity.Article;
import com.portal.doccenter.entity.ArticleTxt;

public abstract interface ArticleTxtService
{
  public abstract ArticleTxt save(ArticleTxt paramArticleTxt, Article paramArticle);
  
  public abstract ArticleTxt update(ArticleTxt paramArticleTxt, Article paramArticle);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.service.ArticleTxtService
 * JD-Core Version:    0.7.0.1
 */