package com.portal.extrafunc.service;

import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.ForumStatis;
import com.portal.sysmgr.entity.Site;

public abstract interface ForumStatisService
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract ForumStatis findById(Integer paramInteger);
  
  public abstract ForumStatis save(Site paramSite);
  
  public abstract ForumStatis update(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3);
  
  public abstract ForumStatis updateOnday(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3);
  
  public abstract ForumStatis update(ForumStatis paramForumStatis);
  
  public abstract ForumStatis deleteById(Integer paramInteger);
  
  public abstract ForumStatis[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.ForumStatisService
 * JD-Core Version:    0.7.0.1
 */