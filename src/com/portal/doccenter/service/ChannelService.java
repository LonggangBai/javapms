package com.portal.doccenter.service;

import com.javapms.basic.page.Pagination;
import com.portal.doccenter.entity.Channel;
import com.portal.doccenter.entity.ChannelExt;
import com.portal.doccenter.entity.ChannelTxt;
import java.util.List;
import java.util.Map;

public abstract interface ChannelService
{
  public abstract List<Channel> getChannelListByTag(Integer paramInteger1, Integer paramInteger2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt);
  
  public abstract Pagination getChannelPageByTag(Integer paramInteger1, Integer paramInteger2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt1, int paramInt2);
  
  public abstract List<Channel> getChannelByAdmin(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, String paramString1, String paramString2, String paramString3, boolean paramBoolean);
  
  public abstract List<Channel> getChannelByModel(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4);
  
  public abstract Channel delChannel(Integer paramInteger1, Boolean paramBoolean, Integer paramInteger2);
  
  public abstract Channel findByPath(String paramString, Integer paramInteger);
  
  public abstract Channel findByPathForTag(String paramString, Integer paramInteger);
  
  public abstract Channel findByNumber(String paramString);
  
  public abstract Channel findById(Integer paramInteger);
  
  public abstract Channel save(Channel paramChannel, ChannelExt paramChannelExt, ChannelTxt paramChannelTxt, Integer[] paramArrayOfInteger1, Integer[] paramArrayOfInteger2, Integer paramInteger1, Integer paramInteger2, String[] paramArrayOfString, Map<String, String> paramMap);
  
  public abstract Channel update(Channel paramChannel, ChannelExt paramChannelExt, ChannelTxt paramChannelTxt, Integer[] paramArrayOfInteger1, Integer[] paramArrayOfInteger2, Integer paramInteger, String[] paramArrayOfString, Map<String, String> paramMap);
  
  public abstract Channel deleteById(Integer paramInteger);
  
  public abstract Channel[] deleteByIds(Integer[] paramArrayOfInteger);
  
  public abstract Channel[] updatePriority(Integer[] paramArrayOfInteger1, Integer[] paramArrayOfInteger2);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.service.ChannelService
 * JD-Core Version:    0.7.0.1
 */