package com.portal.extrafunc.service;

import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.Questionnaire;
import com.portal.sysmgr.entity.Site;

public abstract interface QuestionnaireService
{
  public abstract Pagination getPage(Integer paramInteger, boolean paramBoolean, int paramInt1, int paramInt2);
  
  public abstract Questionnaire findById(Integer paramInteger);
  
  public abstract Questionnaire save(Questionnaire paramQuestionnaire, Site paramSite);
  
  public abstract Questionnaire update(Questionnaire paramQuestionnaire);
  
  public abstract Questionnaire deleteById(Integer paramInteger);
  
  public abstract Questionnaire[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.QuestionnaireService
 * JD-Core Version:    0.7.0.1
 */