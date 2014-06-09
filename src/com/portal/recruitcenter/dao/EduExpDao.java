package com.portal.recruitcenter.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.recruitcenter.entity.EduExp;

public abstract interface EduExpDao
{
  public abstract Pagination getPage(Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract int deleteByPersonalId(Integer paramInteger);
  
  public abstract int deleteByResumeId(Integer paramInteger);
  
  public abstract int deleteBySpecialId(Integer paramInteger);
  
  public abstract EduExp findById(Integer paramInteger);
  
  public abstract EduExp save(EduExp paramEduExp);
  
  public abstract EduExp updateByUpdater(Updater<EduExp> paramUpdater);
  
  public abstract EduExp deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.dao.EduExpDao
 * JD-Core Version:    0.7.0.1
 */