package com.portal.extrafunc.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.QuestionDetail;

public abstract interface QuestionDetailDao
{
  public abstract Pagination getPage(Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract QuestionDetail getDetail(Integer paramInteger1, Integer paramInteger2, String paramString);
  
  public abstract long getCountDetail(Integer paramInteger);
  
  public abstract QuestionDetail findById(Integer paramInteger);
  
  public abstract QuestionDetail save(QuestionDetail paramQuestionDetail);
  
  public abstract QuestionDetail updateByUpdater(Updater<QuestionDetail> paramUpdater);
  
  public abstract QuestionDetail deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.dao.QuestionDetailDao
 * JD-Core Version:    0.7.0.1
 */