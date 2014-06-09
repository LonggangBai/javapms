/*   1:    */ package com.portal.doccenter.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.doccenter.entity.Article;
/*   4:    */ import com.portal.doccenter.entity.DocStatis;
/*   5:    */ import java.io.Serializable;
/*   6:    */ 
/*   7:    */ public abstract class BaseDocStatis
/*   8:    */   implements Serializable
/*   9:    */ {
/*  10: 17 */   public static String REF = "DocStatis";
/*  11: 18 */   public static String PROP_DOC = "doc";
/*  12: 19 */   public static String PROP_VIEWS_COUNT = "viewsCount";
/*  13: 20 */   public static String PROP_ID = "id";
/*  14: 21 */   public static String PROP_COMMENT_COUNT = "commentCount";
/*  15:    */   
/*  16:    */   public BaseDocStatis()
/*  17:    */   {
/*  18: 26 */     initialize();
/*  19:    */   }
/*  20:    */   
/*  21:    */   public BaseDocStatis(Integer id)
/*  22:    */   {
/*  23: 33 */     setId(id);
/*  24: 34 */     initialize();
/*  25:    */   }
/*  26:    */   
/*  27:    */   public BaseDocStatis(Integer id, Integer viewsCount, Integer commentCount)
/*  28:    */   {
/*  29: 45 */     setId(id);
/*  30: 46 */     setViewsCount(viewsCount);
/*  31: 47 */     setCommentCount(commentCount);
/*  32: 48 */     initialize();
/*  33:    */   }
/*  34:    */   
/*  35: 55 */   private int hashCode = -2147483648;
/*  36:    */   private Integer id;
/*  37:    */   private Integer viewsCount;
/*  38:    */   private Integer commentCount;
/*  39:    */   private Article doc;
/*  40:    */   
/*  41:    */   protected void initialize() {}
/*  42:    */   
/*  43:    */   public Integer getId()
/*  44:    */   {
/*  45: 76 */     return this.id;
/*  46:    */   }
/*  47:    */   
/*  48:    */   public void setId(Integer id)
/*  49:    */   {
/*  50: 84 */     this.id = id;
/*  51: 85 */     this.hashCode = -2147483648;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public Integer getViewsCount()
/*  55:    */   {
/*  56: 95 */     return this.viewsCount;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public void setViewsCount(Integer viewsCount)
/*  60:    */   {
/*  61:103 */     this.viewsCount = viewsCount;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public Integer getCommentCount()
/*  65:    */   {
/*  66:112 */     return this.commentCount;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public void setCommentCount(Integer commentCount)
/*  70:    */   {
/*  71:120 */     this.commentCount = commentCount;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public Article getDoc()
/*  75:    */   {
/*  76:129 */     return this.doc;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public void setDoc(Article doc)
/*  80:    */   {
/*  81:137 */     this.doc = doc;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public boolean equals(Object obj)
/*  85:    */   {
/*  86:144 */     if (obj == null) {
/*  87:144 */       return false;
/*  88:    */     }
/*  89:145 */     if (!(obj instanceof DocStatis)) {
/*  90:145 */       return false;
/*  91:    */     }
/*  92:147 */     DocStatis docStatis = (DocStatis)obj;
/*  93:148 */     if ((getId() == null) || (docStatis.getId() == null)) {
/*  94:148 */       return false;
/*  95:    */     }
/*  96:149 */     return getId().equals(docStatis.getId());
/*  97:    */   }
/*  98:    */   
/*  99:    */   public int hashCode()
/* 100:    */   {
/* 101:154 */     if (-2147483648 == this.hashCode)
/* 102:    */     {
/* 103:155 */       if (getId() == null) {
/* 104:155 */         return super.hashCode();
/* 105:    */       }
/* 106:157 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 107:158 */       this.hashCode = hashStr.hashCode();
/* 108:    */     }
/* 109:161 */     return this.hashCode;
/* 110:    */   }
/* 111:    */   
/* 112:    */   public String toString()
/* 113:    */   {
/* 114:166 */     return super.toString();
/* 115:    */   }
/* 116:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.entity.base.BaseDocStatis
 * JD-Core Version:    0.7.0.1
 */