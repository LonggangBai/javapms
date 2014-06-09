package com.portal.extrafunc.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.ForumStatis;

public abstract interface ForumStatisDao
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract ForumStatis findById(Integer paramInteger);
  
  public abstract ForumStatis save(ForumStatis paramForumStatis);
  
  public abstract ForumStatis updateByUpdater(Updater<ForumStatis> paramUpdater);
  
  public abstract ForumStatis deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.dao.ForumStatisDao
 * JD-Core Version:    0.7.0.1
 */