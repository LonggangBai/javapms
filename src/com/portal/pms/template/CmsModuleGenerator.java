/*  1:   */ package com.portal.pms.template;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.developer.ModuleGenerator;
/*  4:   */ 
/*  5:   */ public class CmsModuleGenerator
/*  6:   */ {
/*  7: 6 */   private static String packName = "com.portal.pms.template";
/*  8: 7 */   private static String fileName = "pms.properties";
/*  9:   */   
/* 10:   */   public static void main(String[] args)
/* 11:   */   {
/* 12:10 */     new ModuleGenerator(packName, fileName).generate();
/* 13:   */   }
/* 14:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.pms.template.CmsModuleGenerator
 * JD-Core Version:    0.7.0.1
 */