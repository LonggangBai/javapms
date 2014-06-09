package com.portal.doccenter.dao;

import com.javapms.basic.hibernate3.Updater;
import com.portal.doccenter.entity.DocStatis;

public abstract interface DocStatisDao
{
  public abstract DocStatis findById(Integer paramInteger);
  
  public abstract DocStatis save(DocStatis paramDocStatis);
  
  public abstract DocStatis updateByUpdater(Updater<DocStatis> paramUpdater);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.dao.DocStatisDao
 * JD-Core Version:    0.7.0.1
 */