package com.portal.extrafunc.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.UserForum;

public abstract interface UserForumDao
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract UserForum findById(Integer paramInteger);
  
  public abstract UserForum save(UserForum paramUserForum);
  
  public abstract UserForum updateByUpdater(Updater<UserForum> paramUpdater);
  
  public abstract UserForum deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.dao.UserForumDao
 * JD-Core Version:    0.7.0.1
 */