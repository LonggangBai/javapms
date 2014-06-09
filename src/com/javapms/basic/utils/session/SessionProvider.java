package com.javapms.basic.utils.session;

import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract interface SessionProvider
{
  public abstract Serializable getAttribute(HttpServletRequest paramHttpServletRequest, String paramString);
  
  public abstract void setAttribute(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, String paramString, Serializable paramSerializable);
  
  public abstract String getSessionId(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse);
  
  public abstract void logout(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.javapms.basic.utils.session.SessionProvider
 * JD-Core Version:    0.7.0.1
 */