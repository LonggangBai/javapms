package com.portal.extrafunc.service;

import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.Posts;
import com.portal.extrafunc.entity.PostsExt;

public abstract interface PostsExtService
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract PostsExt findById(Integer paramInteger);
  
  public abstract PostsExt save(String paramString, Posts paramPosts);
  
  public abstract PostsExt update(Integer paramInteger1, Integer paramInteger2, String paramString);
  
  public abstract PostsExt deleteById(Integer paramInteger);
  
  public abstract PostsExt[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.PostsExtService
 * JD-Core Version:    0.7.0.1
 */