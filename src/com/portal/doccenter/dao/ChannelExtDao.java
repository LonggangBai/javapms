package com.portal.doccenter.dao;

import com.javapms.basic.hibernate3.Updater;
import com.portal.doccenter.entity.ChannelExt;

public abstract interface ChannelExtDao
{
  public abstract ChannelExt save(ChannelExt paramChannelExt);
  
  public abstract ChannelExt updateByUpdater(Updater<ChannelExt> paramUpdater);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.dao.ChannelExtDao
 * JD-Core Version:    0.7.0.1
 */