package com.portal.datacenter.commdata.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.datacenter.commdata.entity.ProfessPost;
import java.util.List;

public abstract interface ProfessPostDao
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract List<ProfessPost> getProfessPostList(Integer paramInteger);
  
  public abstract ProfessPost findById(Integer paramInteger);
  
  public abstract ProfessPost save(ProfessPost paramProfessPost);
  
  public abstract ProfessPost updateByUpdater(Updater<ProfessPost> paramUpdater);
  
  public abstract ProfessPost deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.commdata.dao.ProfessPostDao
 * JD-Core Version:    0.7.0.1
 */