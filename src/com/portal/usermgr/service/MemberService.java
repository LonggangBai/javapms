package com.portal.usermgr.service;

import com.javapms.basic.page.Pagination;
import com.portal.usermgr.entity.Member;
import com.portal.usermgr.entity.User;

public abstract interface MemberService
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract Pagination getPage(String paramString1, Integer paramInteger1, Integer paramInteger2, String paramString2, String paramString3, int paramInt1, int paramInt2);
  
  public abstract Member findById(Integer paramInteger);
  
  public abstract Member registerMember(User paramUser, Member paramMember, String paramString, Integer paramInteger);
  
  public abstract Member updateMember(User paramUser, Member paramMember, Integer paramInteger1, Integer paramInteger2);
  
  public abstract void updateLoginInfo(User paramUser, String paramString);
  
  public abstract Member save(Member paramMember);
  
  public abstract Member update(Member paramMember);
  
  public abstract Member updatePass(Integer paramInteger, String paramString);
  
  public abstract Member deleteById(Integer paramInteger);
  
  public abstract Member[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.service.MemberService
 * JD-Core Version:    0.7.0.1
 */