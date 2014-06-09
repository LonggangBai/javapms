package com.portal.extrafunc.service;

import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.Forum;
import com.portal.extrafunc.entity.ForumExt;
import com.portal.sysmgr.entity.Site;
import java.util.List;

public abstract interface ForumService
{
  public abstract Pagination getPage(Integer paramInteger1, Integer paramInteger2, String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract List<Forum> getList(Integer paramInteger);
  
  public abstract List<Forum> getList();
  
  public abstract Forum findById(Integer paramInteger);
  
  public abstract Forum save(Forum paramForum, ForumExt paramForumExt, Site paramSite, Integer paramInteger);
  
  public abstract Forum updateForum(Forum paramForum);
  
  public abstract Forum updateForumOnday(Forum paramForum);
  
  public abstract Forum update(Forum paramForum, ForumExt paramForumExt, Integer paramInteger);
  
  public abstract Forum deleteById(Integer paramInteger);
  
  public abstract Forum[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.ForumService
 * JD-Core Version:    0.7.0.1
 */