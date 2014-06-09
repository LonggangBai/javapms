package com.portal.extrafunc.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.CommentExt;

public abstract interface CommentExtDao
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract CommentExt findById(Integer paramInteger);
  
  public abstract CommentExt save(CommentExt paramCommentExt);
  
  public abstract CommentExt updateByUpdater(Updater<CommentExt> paramUpdater);
  
  public abstract int deleteByDocId(Integer paramInteger);
  
  public abstract CommentExt deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.dao.CommentExtDao
 * JD-Core Version:    0.7.0.1
 */