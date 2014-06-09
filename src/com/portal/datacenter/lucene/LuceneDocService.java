package com.portal.datacenter.lucene;

import com.portal.doccenter.entity.Article;
import java.io.IOException;
import java.util.Date;

public abstract interface LuceneDocService
{
  public abstract Integer createSearchIndex(Integer paramInteger1, Integer paramInteger2, Date paramDate1, Date paramDate2, Integer paramInteger3, Integer paramInteger4, boolean paramBoolean)
    throws IOException;
  
  public abstract void addDoc(Article paramArticle);
  
  public abstract void updateDoc(Article paramArticle);
  
  public abstract void deleteDoc(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.lucene.LuceneDocService
 * JD-Core Version:    0.7.0.1
 */