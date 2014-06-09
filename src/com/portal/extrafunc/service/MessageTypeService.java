package com.portal.extrafunc.service;

import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.MessageType;
import com.portal.sysmgr.entity.Site;
import java.util.List;

public abstract interface MessageTypeService
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract List<MessageType> getList(Integer paramInteger, String paramString1, String paramString2);
  
  public abstract MessageType getUniqueType(Integer paramInteger);
  
  public abstract MessageType findById(Integer paramInteger);
  
  public abstract MessageType save(MessageType paramMessageType, Site paramSite);
  
  public abstract MessageType update(MessageType paramMessageType);
  
  public abstract MessageType deleteById(Integer paramInteger);
  
  public abstract MessageType[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.MessageTypeService
 * JD-Core Version:    0.7.0.1
 */