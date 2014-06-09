package com.portal.extrafunc.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.MessageBoardExt;

public abstract interface MessageBoardExtDao
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract MessageBoardExt findById(Integer paramInteger);
  
  public abstract MessageBoardExt save(MessageBoardExt paramMessageBoardExt);
  
  public abstract MessageBoardExt updateByUpdater(Updater<MessageBoardExt> paramUpdater);
  
  public abstract MessageBoardExt deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.dao.MessageBoardExtDao
 * JD-Core Version:    0.7.0.1
 */