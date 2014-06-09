package com.portal.doccenter.service;

import com.portal.doccenter.entity.Channel;
import com.portal.doccenter.entity.ChannelTxt;

public abstract interface ChannelTxtService
{
  public abstract ChannelTxt save(ChannelTxt paramChannelTxt, Channel paramChannel);
  
  public abstract ChannelTxt update(ChannelTxt paramChannelTxt, Channel paramChannel);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.service.ChannelTxtService
 * JD-Core Version:    0.7.0.1
 */