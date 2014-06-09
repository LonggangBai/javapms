package com.portal.extrafunc.service;

import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.Forum;
import com.portal.extrafunc.entity.ForumExt;

public abstract interface ForumExtService
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract ForumExt findById(Integer paramInteger);
  
  public abstract ForumExt save(ForumExt paramForumExt, Forum paramForum);
  
  public abstract ForumExt update(ForumExt paramForumExt, Forum paramForum);
  
  public abstract ForumExt deleteById(Integer paramInteger);
  
  public abstract ForumExt[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.ForumExtService
 * JD-Core Version:    0.7.0.1
 */