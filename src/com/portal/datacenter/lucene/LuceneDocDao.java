package com.portal.datacenter.lucene;

import java.io.IOException;
import java.util.Date;
import org.apache.lucene.index.CorruptIndexException;

public abstract interface LuceneDocDao
{
  public abstract Integer index(NRTManagerService paramNRTManagerService, Integer paramInteger1, Integer paramInteger2, Date paramDate1, Date paramDate2, Integer paramInteger3, Integer paramInteger4)
    throws CorruptIndexException, IOException;
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.lucene.LuceneDocDao
 * JD-Core Version:    0.7.0.1
 */