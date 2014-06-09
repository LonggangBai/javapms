package com.portal.doccenter.dao;

import com.javapms.basic.hibernate3.Updater;
import com.portal.doccenter.entity.ChannelTxt;

public abstract interface ChannelTxtDao
{
  public abstract ChannelTxt findById(Integer paramInteger);
  
  public abstract ChannelTxt save(ChannelTxt paramChannelTxt);
  
  public abstract ChannelTxt updateByUpdater(Updater<ChannelTxt> paramUpdater);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.dao.ChannelTxtDao
 * JD-Core Version:    0.7.0.1
 */