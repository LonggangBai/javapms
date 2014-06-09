/*   1:    */ package com.portal.doccenter.entity.base;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ 
/*   5:    */ public abstract class BaseArticlePicture
/*   6:    */   implements Serializable
/*   7:    */ {
/*   8: 17 */   public static String REF = "ArticlePicture";
/*   9: 18 */   public static String PROP_DESCRIPTION = "description";
/*  10: 19 */   public static String PROP_IMG_PATH = "imgPath";
/*  11: 20 */   public static String PROP_STYLE = "style";
/*  12:    */   private String imgPath;
/*  13:    */   private String description;
/*  14:    */   private Boolean thumb;
/*  15:    */   private String style;
/*  16:    */   
/*  17:    */   public BaseArticlePicture()
/*  18:    */   {
/*  19: 25 */     initialize();
/*  20:    */   }
/*  21:    */   
/*  22:    */   public BaseArticlePicture(String imgPath)
/*  23:    */   {
/*  24: 34 */     setImgPath(imgPath);
/*  25: 35 */     initialize();
/*  26:    */   }
/*  27:    */   
/*  28:    */   protected void initialize() {}
/*  29:    */   
/*  30:    */   public String getImgPath()
/*  31:    */   {
/*  32: 57 */     return this.imgPath;
/*  33:    */   }
/*  34:    */   
/*  35:    */   public void setImgPath(String imgPath)
/*  36:    */   {
/*  37: 65 */     this.imgPath = imgPath;
/*  38:    */   }
/*  39:    */   
/*  40:    */   public String getDescription()
/*  41:    */   {
/*  42: 74 */     return this.description;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public void setDescription(String description)
/*  46:    */   {
/*  47: 82 */     this.description = description;
/*  48:    */   }
/*  49:    */   
/*  50:    */   public Boolean getThumb()
/*  51:    */   {
/*  52: 86 */     return this.thumb;
/*  53:    */   }
/*  54:    */   
/*  55:    */   public void setThumb(Boolean thumb)
/*  56:    */   {
/*  57: 90 */     this.thumb = thumb;
/*  58:    */   }
/*  59:    */   
/*  60:    */   public String getStyle()
/*  61:    */   {
/*  62: 94 */     return this.style;
/*  63:    */   }
/*  64:    */   
/*  65:    */   public void setStyle(String style)
/*  66:    */   {
/*  67: 98 */     this.style = style;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public String toString()
/*  71:    */   {
/*  72:102 */     return super.toString();
/*  73:    */   }
/*  74:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.entity.base.BaseArticlePicture
 * JD-Core Version:    0.7.0.1
 */