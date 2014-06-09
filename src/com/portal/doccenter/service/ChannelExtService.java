package com.portal.doccenter.service;

import com.portal.doccenter.entity.Channel;
import com.portal.doccenter.entity.ChannelExt;

public abstract interface ChannelExtService
{
  public abstract ChannelExt save(ChannelExt paramChannelExt, Channel paramChannel);
  
  public abstract ChannelExt update(ChannelExt paramChannelExt);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.service.ChannelExtService
 * JD-Core Version:    0.7.0.1
 */