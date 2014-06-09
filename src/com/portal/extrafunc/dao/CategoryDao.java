package com.portal.extrafunc.dao;

import com.javapms.basic.hibernate3.Updater;
import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.Category;
import java.util.List;

public abstract interface CategoryDao
{
  public abstract Pagination getPage(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract List<Category> getList(Integer paramInteger, String paramString1, String paramString2);
  
  public abstract Category findById(Integer paramInteger);
  
  public abstract Category save(Category paramCategory);
  
  public abstract Category updateByUpdater(Updater<Category> paramUpdater);
  
  public abstract Category deleteById(Integer paramInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.dao.CategoryDao
 * JD-Core Version:    0.7.0.1
 */