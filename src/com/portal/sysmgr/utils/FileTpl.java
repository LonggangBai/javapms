/*  1:   */ package com.portal.sysmgr.utils;
/*  2:   */ 
/*  3:   */ import java.io.File;
/*  4:   */ import java.io.IOException;
/*  5:   */ import java.sql.Timestamp;
/*  6:   */ import java.util.Date;
/*  7:   */ import org.apache.commons.io.FileUtils;
/*  8:   */ 
/*  9:   */ public class FileTpl
/* 10:   */   implements Tpl
/* 11:   */ {
/* 12:   */   private File file;
/* 13:   */   private String root;
/* 14:   */   
/* 15:   */   public FileTpl(File file, String root)
/* 16:   */   {
/* 17:16 */     this.file = file;
/* 18:17 */     this.root = root;
/* 19:   */   }
/* 20:   */   
/* 21:   */   public String getName()
/* 22:   */   {
/* 23:21 */     String ap = this.file.getAbsolutePath().substring(this.root.length());
/* 24:22 */     ap = ap.replace(File.separatorChar, '/');
/* 25:24 */     if (!ap.startsWith("/")) {
/* 26:25 */       ap = "/" + ap;
/* 27:   */     }
/* 28:27 */     return ap;
/* 29:   */   }
/* 30:   */   
/* 31:   */   public String getPath()
/* 32:   */   {
/* 33:31 */     String name = getName();
/* 34:32 */     return name.substring(0, name.lastIndexOf('/'));
/* 35:   */   }
/* 36:   */   
/* 37:   */   public String getFilename()
/* 38:   */   {
/* 39:36 */     return this.file.getName();
/* 40:   */   }
/* 41:   */   
/* 42:   */   public String getSource()
/* 43:   */   {
/* 44:40 */     if (this.file.isDirectory()) {
/* 45:41 */       return null;
/* 46:   */     }
/* 47:   */     try
/* 48:   */     {
/* 49:44 */       return FileUtils.readFileToString(this.file, "UTF-8");
/* 50:   */     }
/* 51:   */     catch (IOException e)
/* 52:   */     {
/* 53:46 */       throw new RuntimeException(e);
/* 54:   */     }
/* 55:   */   }
/* 56:   */   
/* 57:   */   public long getLastModified()
/* 58:   */   {
/* 59:51 */     return this.file.lastModified();
/* 60:   */   }
/* 61:   */   
/* 62:   */   public Date getLastModifiedDate()
/* 63:   */   {
/* 64:55 */     return new Timestamp(getLastModified());
/* 65:   */   }
/* 66:   */   
/* 67:   */   public long getLength()
/* 68:   */   {
/* 69:59 */     return this.file.length();
/* 70:   */   }
/* 71:   */   
/* 72:   */   public int getSize()
/* 73:   */   {
/* 74:63 */     return (int)(getLength() / 1024L) + 1;
/* 75:   */   }
/* 76:   */   
/* 77:   */   public boolean isDirectory()
/* 78:   */   {
/* 79:67 */     return this.file.isDirectory();
/* 80:   */   }
/* 81:   */   
/* 82:   */   public boolean isLeaf()
/* 83:   */   {
/* 84:71 */     File[] child = this.file.listFiles();
/* 85:72 */     if (child != null) {
/* 86:73 */       for (File f : child) {
/* 87:74 */         if (f.isDirectory()) {
/* 88:75 */           return false;
/* 89:   */         }
/* 90:   */       }
/* 91:   */     }
/* 92:79 */     return true;
/* 93:   */   }
/* 94:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.sysmgr.utils.FileTpl
 * JD-Core Version:    0.7.0.1
 */