package com.portal.extrafunc.service;

import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.Category;
import com.portal.sysmgr.entity.Site;
import java.util.List;

public abstract interface CategoryService
{
  public abstract Pagination getPage(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract List<Category> getList(Integer paramInteger, String paramString1, String paramString2);
  
  public abstract Category findById(Integer paramInteger);
  
  public abstract Category save(Category paramCategory, Site paramSite);
  
  public abstract Category update(Category paramCategory);
  
  public abstract Category deleteById(Integer paramInteger);
  
  public abstract Category[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.CategoryService
 * JD-Core Version:    0.7.0.1
 */