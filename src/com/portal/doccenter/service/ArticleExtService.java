package com.portal.doccenter.service;

import com.portal.doccenter.entity.Article;
import com.portal.doccenter.entity.ArticleExt;

public abstract interface ArticleExtService
{
  public abstract ArticleExt save(ArticleExt paramArticleExt, Article paramArticle);
  
  public abstract ArticleExt update(ArticleExt paramArticleExt);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.service.ArticleExtService
 * JD-Core Version:    0.7.0.1
 */