package com.portal.govcenter.service;

import com.javapms.basic.page.Pagination;
import com.portal.govcenter.entity.MailboxType;
import com.portal.sysmgr.entity.Site;
import java.util.List;

public abstract interface MailboxTypeService
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract List<MailboxType> getList(Integer paramInteger);
  
  public abstract MailboxType findById(Integer paramInteger);
  
  public abstract MailboxType save(MailboxType paramMailboxType, Site paramSite);
  
  public abstract MailboxType update(MailboxType paramMailboxType);
  
  public abstract MailboxType deleteById(Integer paramInteger);
  
  public abstract MailboxType[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.govcenter.service.MailboxTypeService
 * JD-Core Version:    0.7.0.1
 */