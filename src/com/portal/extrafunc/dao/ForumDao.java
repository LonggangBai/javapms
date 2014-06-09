package com.portal.extrafunc.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.Forum;
import java.util.List;

public abstract interface ForumDao
{
  public abstract Pagination getPage(Integer paramInteger1, Integer paramInteger2, String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract List<Forum> getList(Integer paramInteger);
  
  public abstract List<Forum> getList();
  
  public abstract Forum findById(Integer paramInteger);
  
  public abstract Forum save(Forum paramForum);
  
  public abstract Forum updateByUpdater(Updater<Forum> paramUpdater);
  
  public abstract Forum deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.dao.ForumDao
 * JD-Core Version:    0.7.0.1
 */