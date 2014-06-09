/*  1:   */ package com.portal.sysmgr.utils;
/*  2:   */ 
/*  3:   */ public class ParentDirIsFileExceptioin
/*  4:   */   extends RuntimeException
/*  5:   */ {
/*  6:   */   private String parentDir;
/*  7:   */   
/*  8:   */   public ParentDirIsFileExceptioin(String parentDir)
/*  9:   */   {
/* 10:20 */     this.parentDir = parentDir;
/* 11:   */   }
/* 12:   */   
/* 13:   */   public String getMessage()
/* 14:   */   {
/* 15:25 */     return "parent directory is a file: " + this.parentDir;
/* 16:   */   }
/* 17:   */   
/* 18:   */   public String getParentDir()
/* 19:   */   {
/* 20:34 */     return this.parentDir;
/* 21:   */   }
/* 22:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.sysmgr.utils.ParentDirIsFileExceptioin
 * JD-Core Version:    0.7.0.1
 */