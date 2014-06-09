package com.portal.doccenter.service;

import com.javapms.basic.page.Pagination;
import com.portal.doccenter.entity.Article;
import com.portal.doccenter.entity.ArticleExt;
import com.portal.doccenter.entity.ArticleTxt;
import com.portal.usermgr.entity.User;
import java.util.List;
import java.util.Map;

public abstract interface ArticleService
{
  public abstract Pagination getPageArticle(String paramString1, Integer[] paramArrayOfInteger1, Integer[] paramArrayOfInteger2, Integer paramInteger1, boolean paramBoolean1, boolean paramBoolean2, Byte[] paramArrayOfByte, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3);
  
  public abstract Pagination getPageDocByMember(String paramString, Integer[] paramArrayOfInteger1, Integer[] paramArrayOfInteger2, boolean paramBoolean1, boolean paramBoolean2, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, int paramInt1, int paramInt2);
  
  public abstract long getCountByChecking(Integer paramInteger1, Integer paramInteger2, boolean paramBoolean);
  
  public abstract Pagination getMoveDoc(Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract long getCountDoc(Integer paramInteger);
  
  public abstract int moveDoc(Integer paramInteger, Map<String, String> paramMap);
  
  public abstract List<Article> getListTagByIds(Integer[] paramArrayOfInteger, int paramInt);
  
  public abstract Article getSide(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, boolean paramBoolean);
  
  public abstract Pagination getPageTagByChannelIds(Integer[] paramArrayOfInteger1, Integer paramInteger, Integer[] paramArrayOfInteger2, Integer[] paramArrayOfInteger3, Boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract List<Article> getListTagByChannelIds(Integer[] paramArrayOfInteger1, Integer paramInteger1, Integer[] paramArrayOfInteger2, Integer[] paramArrayOfInteger3, Boolean paramBoolean, int paramInt1, int paramInt2, Integer paramInteger2, Integer paramInteger3);
  
  public abstract Pagination getPageTagByModelIds(Integer[] paramArrayOfInteger1, Integer[] paramArrayOfInteger2, Boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract List<Article> getListTagByModelIds(Integer[] paramArrayOfInteger1, Integer[] paramArrayOfInteger2, Boolean paramBoolean, int paramInt, Integer paramInteger1, Integer paramInteger2);
  
  public abstract Article findById(Integer paramInteger);
  
  public abstract Article save(Article paramArticle, ArticleExt paramArticleExt, ArticleTxt paramArticleTxt, Integer[] paramArrayOfInteger1, Integer[] paramArrayOfInteger2, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String[] paramArrayOfString4, Boolean[] paramArrayOfBoolean, String[] paramArrayOfString5, Integer paramInteger1, Integer paramInteger2, User paramUser, boolean paramBoolean);
  
  public abstract Article update(Article paramArticle, ArticleExt paramArticleExt, ArticleTxt paramArticleTxt, Integer[] paramArrayOfInteger1, Integer[] paramArrayOfInteger2, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String[] paramArrayOfString4, Boolean[] paramArrayOfBoolean, String[] paramArrayOfString5, Map<String, String> paramMap, Integer paramInteger, User paramUser, boolean paramBoolean);
  
  public abstract Article[] check(Integer[] paramArrayOfInteger, User paramUser);
  
  public abstract int emptyDoc(Integer paramInteger);
  
  public abstract Article cycle(Integer paramInteger);
  
  public abstract Article[] cycle(Integer[] paramArrayOfInteger);
  
  public abstract Article reduct(Integer paramInteger);
  
  public abstract Article[] reduct(Integer[] paramArrayOfInteger);
  
  public abstract Article deleteById(Integer paramInteger);
  
  public abstract Article[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.service.ArticleService
 * JD-Core Version:    0.7.0.1
 */