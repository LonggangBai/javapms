package com.portal.extrafunc.action.cache;

import java.util.Date;

public abstract interface PostsCheckCache
{
  public abstract void updateCheck(String paramString);
  
  public abstract Date postsTime(String paramString);
  
  public abstract void refreshCheck();
  
  public abstract long getInterval();
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.action.cache.PostsCheckCache
 * JD-Core Version:    0.7.0.1
 */