package com.javapms.basic.upload;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract interface Repository
{
  public abstract String storeByExt(String paramString, InputStream paramInputStream)
    throws IOException;
  
  public abstract String storeByName(String paramString, InputStream paramInputStream)
    throws IOException;
  
  public abstract boolean retrieve(String paramString, OutputStream paramOutputStream);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.javapms.basic.upload.Repository
 * JD-Core Version:    0.7.0.1
 */