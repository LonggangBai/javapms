package com.portal.extrafunc.service;

import com.javapms.basic.page.Pagination;
import com.portal.doccenter.entity.Article;
import com.portal.extrafunc.entity.Comment;
import com.portal.extrafunc.entity.CommentExt;
import com.portal.sysmgr.entity.Site;
import com.portal.usermgr.entity.User;

public abstract interface CommentService
{
  public abstract Pagination getPage(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Boolean paramBoolean1, Boolean paramBoolean2, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3);
  
  public abstract Pagination getPageForTag(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Boolean paramBoolean1, Boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract Comment findById(Integer paramInteger);
  
  public abstract Comment comment(String paramString1, String paramString2, Integer paramInteger, Article paramArticle, User paramUser, Site paramSite);
  
  public abstract Comment update(Comment paramComment, CommentExt paramCommentExt);
  
  public abstract int deleteByDocId(Integer paramInteger);
  
  public abstract Comment checkById(Integer paramInteger);
  
  public abstract Comment[] checkByIds(Integer[] paramArrayOfInteger);
  
  public abstract Comment deleteById(Integer paramInteger);
  
  public abstract Comment[] deleteByIds(Integer[] paramArrayOfInteger);
  
  public abstract void ups(Integer paramInteger);
  
  public abstract void ups(Integer paramInteger1, Integer paramInteger2);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.CommentService
 * JD-Core Version:    0.7.0.1
 */