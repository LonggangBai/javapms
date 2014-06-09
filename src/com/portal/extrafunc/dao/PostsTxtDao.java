package com.portal.extrafunc.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.PostsTxt;

public abstract interface PostsTxtDao
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract PostsTxt findById(Integer paramInteger);
  
  public abstract PostsTxt save(PostsTxt paramPostsTxt);
  
  public abstract PostsTxt updateByUpdater(Updater<PostsTxt> paramUpdater);
  
  public abstract PostsTxt deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.dao.PostsTxtDao
 * JD-Core Version:    0.7.0.1
 */