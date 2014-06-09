package com.portal.extrafunc.service;

import com.portal.extrafunc.entity.Comment;
import com.portal.extrafunc.entity.CommentExt;

public abstract interface CommentExtService
{
  public abstract CommentExt save(String paramString1, String paramString2, Comment paramComment);
  
  public abstract CommentExt update(CommentExt paramCommentExt);
  
  public abstract int deleteByDocId(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.CommentExtService
 * JD-Core Version:    0.7.0.1
 */