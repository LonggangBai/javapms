package com.portal.extrafunc.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.Posts;

public abstract interface PostsDao
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract Pagination getPostsPageForTag(Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract Posts getPostsOneFloor(Integer paramInteger);
  
  public abstract Integer getFloorByTheme(Integer paramInteger);
  
  public abstract Posts findById(Integer paramInteger);
  
  public abstract Posts save(Posts paramPosts);
  
  public abstract Posts updateByUpdater(Updater<Posts> paramUpdater);
  
  public abstract Posts deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.dao.PostsDao
 * JD-Core Version:    0.7.0.1
 */