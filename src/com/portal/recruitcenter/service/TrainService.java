package com.portal.recruitcenter.service;

import com.javapms.basic.page.Pagination;
import com.portal.recruitcenter.entity.Train;

public abstract interface TrainService
{
  public abstract Pagination getPage(Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract int deleteByPersonalId(Integer paramInteger);
  
  public abstract int deleteByResumeId(Integer paramInteger);
  
  public abstract Train findById(Integer paramInteger);
  
  public abstract Train save(Train paramTrain, Integer paramInteger);
  
  public abstract Train update(Train paramTrain);
  
  public abstract Train deleteById(Integer paramInteger);
  
  public abstract Train[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.service.TrainService
 * JD-Core Version:    0.7.0.1
 */