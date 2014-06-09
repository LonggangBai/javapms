/*   1:    */ package com.portal.doccenter.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.doccenter.entity.ArticleType;
/*   4:    */ import java.io.Serializable;
/*   5:    */ 
/*   6:    */ public abstract class BaseArticleType
/*   7:    */   implements Serializable
/*   8:    */ {
/*   9: 15 */   public static String REF = "ArticleType";
/*  10: 16 */   public static String PROP_DISABLED = "disabled";
/*  11: 17 */   public static String PROP_NAME = "name";
/*  12: 18 */   public static String PROP_ID = "id";
/*  13: 19 */   public static String PROP_HAS_IMAGE = "hasImage";
/*  14:    */   
/*  15:    */   public BaseArticleType()
/*  16:    */   {
/*  17: 23 */     initialize();
/*  18:    */   }
/*  19:    */   
/*  20:    */   public BaseArticleType(Integer id)
/*  21:    */   {
/*  22: 30 */     setId(id);
/*  23: 31 */     initialize();
/*  24:    */   }
/*  25:    */   
/*  26:    */   public BaseArticleType(Integer id, String name, Boolean hasImage, Boolean disabled)
/*  27:    */   {
/*  28: 40 */     setId(id);
/*  29: 41 */     setName(name);
/*  30: 42 */     setHasImage(hasImage);
/*  31: 43 */     setDisabled(disabled);
/*  32: 44 */     initialize();
/*  33:    */   }
/*  34:    */   
/*  35: 50 */   private int hashCode = -2147483648;
/*  36:    */   private Integer id;
/*  37:    */   private String name;
/*  38:    */   private Boolean hasImage;
/*  39:    */   private Boolean disabled;
/*  40:    */   
/*  41:    */   protected void initialize() {}
/*  42:    */   
/*  43:    */   public Integer getId()
/*  44:    */   {
/*  45: 66 */     return this.id;
/*  46:    */   }
/*  47:    */   
/*  48:    */   public void setId(Integer id)
/*  49:    */   {
/*  50: 76 */     this.id = id;
/*  51: 77 */     this.hashCode = -2147483648;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public String getName()
/*  55:    */   {
/*  56: 84 */     return this.name;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public void setName(String name)
/*  60:    */   {
/*  61: 94 */     this.name = name;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public Boolean getHasImage()
/*  65:    */   {
/*  66:101 */     return this.hasImage;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public void setHasImage(Boolean hasImage)
/*  70:    */   {
/*  71:111 */     this.hasImage = hasImage;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public Boolean getDisabled()
/*  75:    */   {
/*  76:118 */     return this.disabled;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public void setDisabled(Boolean disabled)
/*  80:    */   {
/*  81:128 */     this.disabled = disabled;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public boolean equals(Object obj)
/*  85:    */   {
/*  86:132 */     if (obj == null) {
/*  87:133 */       return false;
/*  88:    */     }
/*  89:134 */     if (!(obj instanceof ArticleType)) {
/*  90:135 */       return false;
/*  91:    */     }
/*  92:137 */     ArticleType articleType = (ArticleType)obj;
/*  93:138 */     if ((getId() == null) || (articleType.getId() == null)) {
/*  94:139 */       return false;
/*  95:    */     }
/*  96:141 */     return getId().equals(articleType.getId());
/*  97:    */   }
/*  98:    */   
/*  99:    */   public int hashCode()
/* 100:    */   {
/* 101:146 */     if (-2147483648 == this.hashCode)
/* 102:    */     {
/* 103:147 */       if (getId() == null) {
/* 104:148 */         return super.hashCode();
/* 105:    */       }
/* 106:150 */       String hashStr = getClass().getName() + ":" + 
/* 107:151 */         getId().hashCode();
/* 108:152 */       this.hashCode = hashStr.hashCode();
/* 109:    */     }
/* 110:155 */     return this.hashCode;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public String toString()
/* 114:    */   {
/* 115:159 */     return super.toString();
/* 116:    */   }
/* 117:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.entity.base.BaseArticleType
 * JD-Core Version:    0.7.0.1
 */