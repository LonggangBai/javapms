package com.portal.extrafunc.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.ForumExt;

public abstract interface ForumExtDao
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract ForumExt findById(Integer paramInteger);
  
  public abstract ForumExt save(ForumExt paramForumExt);
  
  public abstract ForumExt updateByUpdater(Updater<ForumExt> paramUpdater);
  
  public abstract ForumExt deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.dao.ForumExtDao
 * JD-Core Version:    0.7.0.1
 */