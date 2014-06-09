package com.portal.extrafunc.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.MessageBoard;

public abstract interface MessageBoardDao
{
  public abstract Pagination getPage(String paramString1, Integer paramInteger, Boolean paramBoolean, String paramString2, String paramString3, int paramInt1, int paramInt2);
  
  public abstract MessageBoard findById(Integer paramInteger);
  
  public abstract MessageBoard save(MessageBoard paramMessageBoard);
  
  public abstract MessageBoard updateByUpdater(Updater<MessageBoard> paramUpdater);
  
  public abstract MessageBoard deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.dao.MessageBoardDao
 * JD-Core Version:    0.7.0.1
 */