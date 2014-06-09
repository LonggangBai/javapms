package com.portal.extrafunc.service;

import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.AdvertSlot;
import com.portal.sysmgr.entity.Site;
import java.util.List;

public abstract interface AdvertSlotService
{
  public abstract Pagination getPage(Integer paramInteger, String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract List<AdvertSlot> getList(Integer paramInteger);
  
  public abstract AdvertSlot findById(Integer paramInteger);
  
  public abstract AdvertSlot save(AdvertSlot paramAdvertSlot, Site paramSite);
  
  public abstract AdvertSlot update(AdvertSlot paramAdvertSlot);
  
  public abstract AdvertSlot deleteById(Integer paramInteger);
  
  public abstract AdvertSlot[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.AdvertSlotService
 * JD-Core Version:    0.7.0.1
 */