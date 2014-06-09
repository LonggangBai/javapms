package com.portal.govcenter.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.govcenter.entity.Mailbox;

public abstract interface MailboxDao
{
  public abstract Pagination getPage(String paramString, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, int paramInt1, int paramInt2);
  
  public abstract Mailbox findById(Integer paramInteger);
  
  public abstract Mailbox save(Mailbox paramMailbox);
  
  public abstract Mailbox updateByUpdater(Updater<Mailbox> paramUpdater);
  
  public abstract Mailbox deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.govcenter.dao.MailboxDao
 * JD-Core Version:    0.7.0.1
 */