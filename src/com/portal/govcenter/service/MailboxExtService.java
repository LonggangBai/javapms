package com.portal.govcenter.service;

import com.javapms.basic.page.Pagination;
import com.portal.govcenter.entity.Mailbox;
import com.portal.govcenter.entity.MailboxExt;

public abstract interface MailboxExtService
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract MailboxExt findById(Integer paramInteger);
  
  public abstract MailboxExt save(Mailbox paramMailbox, MailboxExt paramMailboxExt);
  
  public abstract MailboxExt update(Mailbox paramMailbox, MailboxExt paramMailboxExt);
  
  public abstract MailboxExt deleteById(Integer paramInteger);
  
  public abstract MailboxExt[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.govcenter.service.MailboxExtService
 * JD-Core Version:    0.7.0.1
 */