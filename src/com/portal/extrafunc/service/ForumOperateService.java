package com.portal.extrafunc.service;

import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.ForumOperate;
import com.portal.sysmgr.entity.Site;
import com.portal.usermgr.entity.User;

public abstract interface ForumOperateService
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract ForumOperate findById(Integer paramInteger);
  
  public abstract ForumOperate save(Integer paramInteger, String paramString1, String paramString2, String paramString3, Site paramSite, User paramUser);
  
  public abstract ForumOperate update(ForumOperate paramForumOperate);
  
  public abstract ForumOperate deleteById(Integer paramInteger);
  
  public abstract ForumOperate[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.ForumOperateService
 * JD-Core Version:    0.7.0.1
 */