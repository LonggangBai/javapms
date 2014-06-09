package com.portal.extrafunc.service;

import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.MessageBoard;
import com.portal.extrafunc.entity.MessageBoardExt;
import com.portal.sysmgr.entity.Site;

public abstract interface MessageBoardService
{
  public abstract Pagination getPage(String paramString1, Integer paramInteger, Boolean paramBoolean, String paramString2, String paramString3, int paramInt1, int paramInt2);
  
  public abstract MessageBoard findById(Integer paramInteger);
  
  public abstract MessageBoard save(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Integer paramInteger, String paramString7, Site paramSite);
  
  public abstract MessageBoard save(MessageBoard paramMessageBoard, MessageBoardExt paramMessageBoardExt, Site paramSite, Integer paramInteger);
  
  public abstract MessageBoard update(MessageBoard paramMessageBoard, MessageBoardExt paramMessageBoardExt, Integer paramInteger);
  
  public abstract MessageBoard showBoard(Integer paramInteger);
  
  public abstract MessageBoard deleteById(Integer paramInteger);
  
  public abstract MessageBoard[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.MessageBoardService
 * JD-Core Version:    0.7.0.1
 */