package com.portal.doccenter.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.doccenter.entity.Channel;
import java.util.List;

public abstract interface ChannelDao
{
  public abstract List<Channel> getChannelListByTag(Integer paramInteger1, Integer paramInteger2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt);
  
  public abstract Pagination getChannelPageByTag(Integer paramInteger1, Integer paramInteger2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt1, int paramInt2);
  
  public abstract List<Channel> getChannelByAdmin(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, String paramString1, String paramString2, String paramString3, boolean paramBoolean);
  
  public abstract List<Channel> getChannelByModel(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4);
  
  public abstract Channel findByPath(String paramString, Integer paramInteger, boolean paramBoolean);
  
  public abstract Channel findByNumber(String paramString);
  
  public abstract Channel findById(Integer paramInteger);
  
  public abstract Channel save(Channel paramChannel);
  
  public abstract Channel updateByUpdater(Updater<Channel> paramUpdater);
  
  public abstract Channel deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.dao.ChannelDao
 * JD-Core Version:    0.7.0.1
 */