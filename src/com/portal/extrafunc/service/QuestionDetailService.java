package com.portal.extrafunc.service;

import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.QuestionDetail;
import com.portal.extrafunc.entity.Questionnaire;
import com.portal.usermgr.entity.User;

public abstract interface QuestionDetailService
{
  public abstract Pagination getPage(Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract QuestionDetail getDetail(Integer paramInteger1, Integer paramInteger2, String paramString);
  
  public abstract long getCountDetail(Integer paramInteger);
  
  public abstract QuestionDetail findById(Integer paramInteger);
  
  public abstract QuestionDetail save(Questionnaire paramQuestionnaire, User paramUser, String paramString);
  
  public abstract QuestionDetail update(QuestionDetail paramQuestionDetail);
  
  public abstract QuestionDetail deleteById(Integer paramInteger);
  
  public abstract QuestionDetail[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.QuestionDetailService
 * JD-Core Version:    0.7.0.1
 */