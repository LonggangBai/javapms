package com.portal.sysmgr.utils;

import java.util.Date;

public abstract interface Tpl
{
  public abstract String getName();
  
  public abstract String getPath();
  
  public abstract String getFilename();
  
  public abstract String getSource();
  
  public abstract long getLastModified();
  
  public abstract Date getLastModifiedDate();
  
  public abstract long getLength();
  
  public abstract int getSize();
  
  public abstract boolean isDirectory();
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.sysmgr.utils.Tpl
 * JD-Core Version:    0.7.0.1
 */