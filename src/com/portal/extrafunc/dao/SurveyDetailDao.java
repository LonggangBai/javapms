package com.portal.extrafunc.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.SurveyDetail;

public abstract interface SurveyDetailDao
{
  public abstract Pagination getPage(Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract SurveyDetail findById(Integer paramInteger);
  
  public abstract SurveyDetail save(SurveyDetail paramSurveyDetail);
  
  public abstract SurveyDetail updateByUpdater(Updater<SurveyDetail> paramUpdater);
  
  public abstract SurveyDetail deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.dao.SurveyDetailDao
 * JD-Core Version:    0.7.0.1
 */