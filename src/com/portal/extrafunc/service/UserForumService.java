package com.portal.extrafunc.service;

import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.UserForum;
import com.portal.usermgr.entity.User;
import java.util.Date;

public abstract interface UserForumService
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract UserForum findById(Integer paramInteger);
  
  public abstract UserForum save(User paramUser);
  
  public abstract UserForum update(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, Integer paramInteger5);
  
  public abstract UserForum shieldUserForum(Integer paramInteger, Date paramDate);
  
  public abstract UserForum update(UserForum paramUserForum);
  
  public abstract UserForum deleteById(Integer paramInteger);
  
  public abstract UserForum[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.UserForumService
 * JD-Core Version:    0.7.0.1
 */