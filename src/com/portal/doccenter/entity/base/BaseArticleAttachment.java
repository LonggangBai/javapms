/*   1:    */ package com.portal.doccenter.entity.base;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ 
/*   5:    */ public abstract class BaseArticleAttachment
/*   6:    */   implements Serializable
/*   7:    */ {
/*   8: 17 */   public static String REF = "ArticleAttachment";
/*   9: 18 */   public static String PROP_NAME = "name";
/*  10: 19 */   public static String PROP_COUNT = "count";
/*  11: 20 */   public static String PROP_PATH = "path";
/*  12:    */   private String path;
/*  13:    */   private String name;
/*  14:    */   private Integer count;
/*  15:    */   
/*  16:    */   public BaseArticleAttachment()
/*  17:    */   {
/*  18: 25 */     initialize();
/*  19:    */   }
/*  20:    */   
/*  21:    */   public BaseArticleAttachment(String path, String name, Integer count)
/*  22:    */   {
/*  23: 36 */     setPath(path);
/*  24: 37 */     setName(name);
/*  25: 38 */     setCount(count);
/*  26: 39 */     initialize();
/*  27:    */   }
/*  28:    */   
/*  29:    */   protected void initialize() {}
/*  30:    */   
/*  31:    */   public String getPath()
/*  32:    */   {
/*  33: 60 */     return this.path;
/*  34:    */   }
/*  35:    */   
/*  36:    */   public void setPath(String path)
/*  37:    */   {
/*  38: 68 */     this.path = path;
/*  39:    */   }
/*  40:    */   
/*  41:    */   public String getName()
/*  42:    */   {
/*  43: 77 */     return this.name;
/*  44:    */   }
/*  45:    */   
/*  46:    */   public void setName(String name)
/*  47:    */   {
/*  48: 85 */     this.name = name;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public Integer getCount()
/*  52:    */   {
/*  53: 94 */     return this.count;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public void setCount(Integer count)
/*  57:    */   {
/*  58:102 */     this.count = count;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public String toString()
/*  62:    */   {
/*  63:110 */     return super.toString();
/*  64:    */   }
/*  65:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.entity.base.BaseArticleAttachment
 * JD-Core Version:    0.7.0.1
 */