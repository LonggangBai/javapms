/*   1:    */ package com.portal.doccenter.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.doccenter.entity.Article;
/*   4:    */ import com.portal.doccenter.entity.ArticleTxt;
/*   5:    */ import java.io.Serializable;
/*   6:    */ 
/*   7:    */ public abstract class BaseArticleTxt
/*   8:    */   implements Serializable
/*   9:    */ {
/*  10: 17 */   public static String REF = "ArticleTxt";
/*  11: 18 */   public static String PROP_TXT = "txt";
/*  12: 19 */   public static String PROP_ID = "id";
/*  13: 20 */   public static String PROP_ARTICLE = "article";
/*  14:    */   
/*  15:    */   public BaseArticleTxt()
/*  16:    */   {
/*  17: 25 */     initialize();
/*  18:    */   }
/*  19:    */   
/*  20:    */   public BaseArticleTxt(Integer id)
/*  21:    */   {
/*  22: 32 */     setId(id);
/*  23: 33 */     initialize();
/*  24:    */   }
/*  25:    */   
/*  26: 40 */   private int hashCode = -2147483648;
/*  27:    */   private Integer id;
/*  28:    */   private String txt;
/*  29:    */   private Article article;
/*  30:    */   
/*  31:    */   protected void initialize() {}
/*  32:    */   
/*  33:    */   public Integer getId()
/*  34:    */   {
/*  35: 60 */     return this.id;
/*  36:    */   }
/*  37:    */   
/*  38:    */   public void setId(Integer id)
/*  39:    */   {
/*  40: 68 */     this.id = id;
/*  41: 69 */     this.hashCode = -2147483648;
/*  42:    */   }
/*  43:    */   
/*  44:    */   public String getTxt()
/*  45:    */   {
/*  46: 79 */     return this.txt;
/*  47:    */   }
/*  48:    */   
/*  49:    */   public void setTxt(String txt)
/*  50:    */   {
/*  51: 87 */     this.txt = txt;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public Article getArticle()
/*  55:    */   {
/*  56: 96 */     return this.article;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public void setArticle(Article article)
/*  60:    */   {
/*  61:104 */     this.article = article;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public boolean equals(Object obj)
/*  65:    */   {
/*  66:111 */     if (obj == null) {
/*  67:111 */       return false;
/*  68:    */     }
/*  69:112 */     if (!(obj instanceof ArticleTxt)) {
/*  70:112 */       return false;
/*  71:    */     }
/*  72:114 */     ArticleTxt articleTxt = (ArticleTxt)obj;
/*  73:115 */     if ((getId() == null) || (articleTxt.getId() == null)) {
/*  74:115 */       return false;
/*  75:    */     }
/*  76:116 */     return getId().equals(articleTxt.getId());
/*  77:    */   }
/*  78:    */   
/*  79:    */   public int hashCode()
/*  80:    */   {
/*  81:121 */     if (-2147483648 == this.hashCode)
/*  82:    */     {
/*  83:122 */       if (getId() == null) {
/*  84:122 */         return super.hashCode();
/*  85:    */       }
/*  86:124 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/*  87:125 */       this.hashCode = hashStr.hashCode();
/*  88:    */     }
/*  89:128 */     return this.hashCode;
/*  90:    */   }
/*  91:    */   
/*  92:    */   public String toString()
/*  93:    */   {
/*  94:133 */     return super.toString();
/*  95:    */   }
/*  96:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.entity.base.BaseArticleTxt
 * JD-Core Version:    0.7.0.1
 */