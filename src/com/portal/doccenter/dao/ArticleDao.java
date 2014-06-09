package com.portal.doccenter.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.doccenter.entity.Article;
import java.util.List;

public abstract interface ArticleDao
{
  public abstract Pagination getPageArticle(String paramString1, Integer[] paramArrayOfInteger1, Integer[] paramArrayOfInteger2, Integer paramInteger1, boolean paramBoolean1, boolean paramBoolean2, Byte[] paramArrayOfByte, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, Integer paramInteger5, String paramString2, Byte paramByte, Boolean paramBoolean, int paramInt1, String paramString3, String paramString4, int paramInt2, int paramInt3);
  
  public abstract Pagination getPageDocByMember(String paramString1, Integer[] paramArrayOfInteger1, Integer[] paramArrayOfInteger2, boolean paramBoolean1, boolean paramBoolean2, Integer paramInteger1, Integer paramInteger2, String paramString2, int paramInt1, int paramInt2);
  
  public abstract long getCountByChecking(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, Byte paramByte, Boolean paramBoolean, boolean paramBoolean1);
  
  public abstract Pagination getMoveDoc(String paramString, int paramInt1, int paramInt2);
  
  public abstract long getCountDoc(String paramString);
  
  public abstract Article getSide(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract List<Article> getListTagByIds(Integer[] paramArrayOfInteger, int paramInt);
  
  public abstract Pagination getPageTagByChannelIds(Integer[] paramArrayOfInteger1, Integer paramInteger, Integer[] paramArrayOfInteger2, Integer[] paramArrayOfInteger3, String paramString, Boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract List<Article> getListTagByChannelIds(Integer[] paramArrayOfInteger1, Integer paramInteger1, Integer[] paramArrayOfInteger2, Integer[] paramArrayOfInteger3, String paramString, Boolean paramBoolean, int paramInt1, int paramInt2, Integer paramInteger2, Integer paramInteger3);
  
  public abstract Pagination getPageTagByModelIds(Integer[] paramArrayOfInteger1, Integer[] paramArrayOfInteger2, Boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract List<Article> getListTagByModelIds(Integer[] paramArrayOfInteger1, Integer[] paramArrayOfInteger2, Boolean paramBoolean, int paramInt, Integer paramInteger1, Integer paramInteger2);
  
  public abstract Article findById(Integer paramInteger);
  
  public abstract Article save(Article paramArticle);
  
  public abstract Article updateByUpdater(Updater<Article> paramUpdater);
  
  public abstract Article deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.dao.ArticleDao
 * JD-Core Version:    0.7.0.1
 */