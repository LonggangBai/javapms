package com.portal.extrafunc.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.AdvertSlot;
import java.util.List;

public abstract interface AdvertSlotDao
{
  public abstract Pagination getPage(Integer paramInteger, String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract List<AdvertSlot> getList(Integer paramInteger);
  
  public abstract AdvertSlot findById(Integer paramInteger);
  
  public abstract AdvertSlot save(AdvertSlot paramAdvertSlot);
  
  public abstract AdvertSlot updateByUpdater(Updater<AdvertSlot> paramUpdater);
  
  public abstract AdvertSlot deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.dao.AdvertSlotDao
 * JD-Core Version:    0.7.0.1
 */