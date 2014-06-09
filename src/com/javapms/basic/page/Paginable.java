package com.javapms.basic.page;

public abstract interface Paginable
{
  public abstract int getTotalCount();
  
  public abstract int getTotalPage();
  
  public abstract int getPageSize();
  
  public abstract int getPageNo();
  
  public abstract boolean isFirstPage();
  
  public abstract boolean isLastPage();
  
  public abstract int getNextPage();
  
  public abstract int getPrePage();
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.javapms.basic.page.Paginable
 * JD-Core Version:    0.7.0.1
 */