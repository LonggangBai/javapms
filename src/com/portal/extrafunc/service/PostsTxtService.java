package com.portal.extrafunc.service;

import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.Posts;
import com.portal.extrafunc.entity.PostsTxt;

public abstract interface PostsTxtService
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract PostsTxt findById(Integer paramInteger);
  
  public abstract PostsTxt save(String paramString, Posts paramPosts);
  
  public abstract PostsTxt update(Integer paramInteger, String paramString);
  
  public abstract PostsTxt deleteById(Integer paramInteger);
  
  public abstract PostsTxt[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.PostsTxtService
 * JD-Core Version:    0.7.0.1
 */