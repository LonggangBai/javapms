package com.portal.extrafunc.service;

import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.MessageBoard;
import com.portal.extrafunc.entity.MessageBoardExt;

public abstract interface MessageBoardExtService
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract MessageBoardExt findById(Integer paramInteger);
  
  public abstract MessageBoardExt save(MessageBoard paramMessageBoard, MessageBoardExt paramMessageBoardExt);
  
  public abstract MessageBoardExt update(MessageBoardExt paramMessageBoardExt);
  
  public abstract MessageBoardExt deleteById(Integer paramInteger);
  
  public abstract MessageBoardExt[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.MessageBoardExtService
 * JD-Core Version:    0.7.0.1
 */