/*   1:    */ package com.portal.datacenter.docdata.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.datacenter.docdata.entity.Sensitivity;
/*   4:    */ import java.io.Serializable;
/*   5:    */ 
/*   6:    */ public abstract class BaseSensitivity
/*   7:    */   implements Serializable
/*   8:    */ {
/*   9: 15 */   public static String REF = "Sensitivity";
/*  10: 16 */   public static String PROP_SEARCH = "search";
/*  11: 17 */   public static String PROP_ID = "id";
/*  12: 18 */   public static String PROP_REPLACEMENT = "replacement";
/*  13:    */   
/*  14:    */   public BaseSensitivity()
/*  15:    */   {
/*  16: 22 */     initialize();
/*  17:    */   }
/*  18:    */   
/*  19:    */   public BaseSensitivity(Integer id)
/*  20:    */   {
/*  21: 29 */     setId(id);
/*  22: 30 */     initialize();
/*  23:    */   }
/*  24:    */   
/*  25:    */   public BaseSensitivity(Integer id, String search, String replacement)
/*  26:    */   {
/*  27: 39 */     setId(id);
/*  28: 40 */     setSearch(search);
/*  29: 41 */     setReplacement(replacement);
/*  30: 42 */     initialize();
/*  31:    */   }
/*  32:    */   
/*  33: 48 */   private int hashCode = -2147483648;
/*  34:    */   private Integer id;
/*  35:    */   private String search;
/*  36:    */   private String replacement;
/*  37:    */   
/*  38:    */   protected void initialize() {}
/*  39:    */   
/*  40:    */   public Integer getId()
/*  41:    */   {
/*  42: 63 */     return this.id;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public void setId(Integer id)
/*  46:    */   {
/*  47: 73 */     this.id = id;
/*  48: 74 */     this.hashCode = -2147483648;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public String getSearch()
/*  52:    */   {
/*  53: 81 */     return this.search;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public void setSearch(String search)
/*  57:    */   {
/*  58: 91 */     this.search = search;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public String getReplacement()
/*  62:    */   {
/*  63: 98 */     return this.replacement;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public void setReplacement(String replacement)
/*  67:    */   {
/*  68:108 */     this.replacement = replacement;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public boolean equals(Object obj)
/*  72:    */   {
/*  73:112 */     if (obj == null) {
/*  74:113 */       return false;
/*  75:    */     }
/*  76:114 */     if (!(obj instanceof Sensitivity)) {
/*  77:115 */       return false;
/*  78:    */     }
/*  79:117 */     Sensitivity sensitivity = (Sensitivity)obj;
/*  80:118 */     if ((getId() == null) || (sensitivity.getId() == null)) {
/*  81:119 */       return false;
/*  82:    */     }
/*  83:121 */     return getId().equals(sensitivity.getId());
/*  84:    */   }
/*  85:    */   
/*  86:    */   public int hashCode()
/*  87:    */   {
/*  88:126 */     if (-2147483648 == this.hashCode)
/*  89:    */     {
/*  90:127 */       if (getId() == null) {
/*  91:128 */         return super.hashCode();
/*  92:    */       }
/*  93:130 */       String hashStr = getClass().getName() + ":" + 
/*  94:131 */         getId().hashCode();
/*  95:132 */       this.hashCode = hashStr.hashCode();
/*  96:    */     }
/*  97:135 */     return this.hashCode;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public String toString()
/* 101:    */   {
/* 102:139 */     return super.toString();
/* 103:    */   }
/* 104:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.docdata.entity.base.BaseSensitivity
 * JD-Core Version:    0.7.0.1
 */