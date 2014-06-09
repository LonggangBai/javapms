package com.portal.usermgr.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.usermgr.entity.Member;

public abstract interface MemberDao
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract Pagination getPage(String paramString1, Integer paramInteger1, Integer paramInteger2, String paramString2, String paramString3, int paramInt1, int paramInt2);
  
  public abstract Member findById(Integer paramInteger);
  
  public abstract Member save(Member paramMember);
  
  public abstract Member updateByUpdater(Updater<Member> paramUpdater);
  
  public abstract Member deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.dao.MemberDao
 * JD-Core Version:    0.7.0.1
 */