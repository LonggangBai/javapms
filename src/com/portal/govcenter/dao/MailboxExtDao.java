package com.portal.govcenter.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.govcenter.entity.MailboxExt;

public abstract interface MailboxExtDao
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract MailboxExt findById(Integer paramInteger);
  
  public abstract MailboxExt save(MailboxExt paramMailboxExt);
  
  public abstract MailboxExt updateByUpdater(Updater<MailboxExt> paramUpdater);
  
  public abstract MailboxExt deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.govcenter.dao.MailboxExtDao
 * JD-Core Version:    0.7.0.1
 */