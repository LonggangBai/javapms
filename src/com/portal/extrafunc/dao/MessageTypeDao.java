package com.portal.extrafunc.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.MessageType;
import java.util.List;

public abstract interface MessageTypeDao
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract List<MessageType> getList(Integer paramInteger, String paramString1, String paramString2);
  
  public abstract MessageType getUniqueType(Integer paramInteger);
  
  public abstract MessageType findById(Integer paramInteger);
  
  public abstract MessageType save(MessageType paramMessageType);
  
  public abstract MessageType updateByUpdater(Updater<MessageType> paramUpdater);
  
  public abstract MessageType deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.dao.MessageTypeDao
 * JD-Core Version:    0.7.0.1
 */