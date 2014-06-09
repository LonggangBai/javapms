package com.portal.datacenter.lucene;

import com.javapms.basic.page.Pagination;
import java.util.Date;

public abstract interface LuceneDocPageService
{
  public abstract Pagination searchArticle(String paramString1, String paramString2, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Date paramDate1, Date paramDate2, int paramInt1, int paramInt2);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.lucene.LuceneDocPageService
 * JD-Core Version:    0.7.0.1
 */