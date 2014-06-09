/*  1:   */ package com.javapms.basic.plugin.springmvc;
/*  2:   */ 
/*  3:   */ import java.util.Date;
/*  4:   */ import org.springframework.web.bind.WebDataBinder;
/*  5:   */ import org.springframework.web.bind.support.WebBindingInitializer;
/*  6:   */ import org.springframework.web.context.request.WebRequest;
/*  7:   */ 
/*  8:   */ public class BindingInitializer
/*  9:   */   implements WebBindingInitializer
/* 10:   */ {
/* 11:   */   public void initBinder(WebDataBinder binder, WebRequest request)
/* 12:   */   {
/* 13:20 */     binder.registerCustomEditor(Date.class, new DateTypeEditor());
/* 14:   */   }
/* 15:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.javapms.basic.plugin.springmvc.BindingInitializer
 * JD-Core Version:    0.7.0.1
 */