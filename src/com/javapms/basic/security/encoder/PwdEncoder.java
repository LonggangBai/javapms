package com.javapms.basic.security.encoder;

public abstract interface PwdEncoder
{
  public abstract String encodePassword(String paramString);
  
  public abstract String encodePassword(String paramString1, String paramString2);
  
  public abstract boolean isPasswordValid(String paramString1, String paramString2);
  
  public abstract boolean isPasswordValid(String paramString1, String paramString2, String paramString3);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.javapms.basic.security.encoder.PwdEncoder
 * JD-Core Version:    0.7.0.1
 */