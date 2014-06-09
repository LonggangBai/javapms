/*   1:    */ package com.portal.extrafunc.entity.base;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ 
/*   5:    */ public abstract class BasePostsAttach
/*   6:    */   implements Serializable
/*   7:    */ {
/*   8: 17 */   public static String REF = "PostsAttach";
/*   9: 18 */   public static String PROP_FILE_SIZE = "fileSize";
/*  10: 19 */   public static String PROP_NAME = "name";
/*  11: 20 */   public static String PROP_DESCRIPTION = "description";
/*  12: 21 */   public static String PROP_IMG = "img";
/*  13: 22 */   public static String PROP_FILE_NAME = "fileName";
/*  14: 23 */   public static String PROP_FILE_PATH = "filePath";
/*  15:    */   private String name;
/*  16:    */   private String description;
/*  17:    */   private String filePath;
/*  18:    */   private String fileName;
/*  19:    */   private Integer fileSize;
/*  20:    */   private Boolean img;
/*  21:    */   
/*  22:    */   public BasePostsAttach()
/*  23:    */   {
/*  24: 28 */     initialize();
/*  25:    */   }
/*  26:    */   
/*  27:    */   public BasePostsAttach(String filePath, Boolean img)
/*  28:    */   {
/*  29: 38 */     setFilePath(filePath);
/*  30: 39 */     setImg(img);
/*  31: 40 */     initialize();
/*  32:    */   }
/*  33:    */   
/*  34:    */   protected void initialize() {}
/*  35:    */   
/*  36:    */   public String getName()
/*  37:    */   {
/*  38: 64 */     return this.name;
/*  39:    */   }
/*  40:    */   
/*  41:    */   public void setName(String name)
/*  42:    */   {
/*  43: 72 */     this.name = name;
/*  44:    */   }
/*  45:    */   
/*  46:    */   public String getDescription()
/*  47:    */   {
/*  48: 81 */     return this.description;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public void setDescription(String description)
/*  52:    */   {
/*  53: 89 */     this.description = description;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public String getFilePath()
/*  57:    */   {
/*  58: 98 */     return this.filePath;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public void setFilePath(String filePath)
/*  62:    */   {
/*  63:106 */     this.filePath = filePath;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public String getFileName()
/*  67:    */   {
/*  68:115 */     return this.fileName;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public void setFileName(String fileName)
/*  72:    */   {
/*  73:123 */     this.fileName = fileName;
/*  74:    */   }
/*  75:    */   
/*  76:    */   public Integer getFileSize()
/*  77:    */   {
/*  78:132 */     return this.fileSize;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public void setFileSize(Integer fileSize)
/*  82:    */   {
/*  83:140 */     this.fileSize = fileSize;
/*  84:    */   }
/*  85:    */   
/*  86:    */   public Boolean getImg()
/*  87:    */   {
/*  88:149 */     return this.img;
/*  89:    */   }
/*  90:    */   
/*  91:    */   public void setImg(Boolean img)
/*  92:    */   {
/*  93:157 */     this.img = img;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public String toString()
/*  97:    */   {
/*  98:167 */     return super.toString();
/*  99:    */   }
/* 100:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.entity.base.BasePostsAttach
 * JD-Core Version:    0.7.0.1
 */