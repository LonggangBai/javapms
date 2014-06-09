package com.portal.extrafunc.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.PostsExt;

public abstract interface PostsExtDao
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract PostsExt findById(Integer paramInteger);
  
  public abstract PostsExt save(PostsExt paramPostsExt);
  
  public abstract PostsExt updateByUpdater(Updater<PostsExt> paramUpdater);
  
  public abstract PostsExt deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.dao.PostsExtDao
 * JD-Core Version:    0.7.0.1
 */