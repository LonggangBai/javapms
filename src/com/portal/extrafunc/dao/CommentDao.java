package com.portal.extrafunc.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.Comment;

public abstract interface CommentDao
{
  public abstract Pagination getPage(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Boolean paramBoolean1, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, Boolean paramBoolean2, boolean paramBoolean);
  
  public abstract Comment findById(Integer paramInteger);
  
  public abstract int deleteByDocId(Integer paramInteger);
  
  public abstract Comment save(Comment paramComment);
  
  public abstract Comment updateByUpdater(Updater<Comment> paramUpdater);
  
  public abstract Comment deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.dao.CommentDao
 * JD-Core Version:    0.7.0.1
 */