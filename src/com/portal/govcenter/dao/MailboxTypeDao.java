package com.portal.govcenter.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.govcenter.entity.MailboxType;
import java.util.List;

public abstract interface MailboxTypeDao
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract List<MailboxType> getList(Integer paramInteger);
  
  public abstract MailboxType findById(Integer paramInteger);
  
  public abstract MailboxType save(MailboxType paramMailboxType);
  
  public abstract MailboxType updateByUpdater(Updater<MailboxType> paramUpdater);
  
  public abstract MailboxType deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.govcenter.dao.MailboxTypeDao
 * JD-Core Version:    0.7.0.1
 */