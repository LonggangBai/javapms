/*   1:    */ package com.portal.usermgr.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.usermgr.entity.SiteMessage;
/*   4:    */ import com.portal.usermgr.entity.SiteMessageExt;
/*   5:    */ import java.io.Serializable;
/*   6:    */ 
/*   7:    */ public abstract class BaseSiteMessageExt
/*   8:    */   implements Serializable
/*   9:    */ {
/*  10: 17 */   public static String REF = "SiteMessageExt";
/*  11: 18 */   public static String PROP_MESSAGE = "message";
/*  12: 19 */   public static String PROP_ID = "id";
/*  13: 20 */   public static String PROP_CONTENT = "content";
/*  14: 21 */   public static String PROP_TITLE = "title";
/*  15:    */   
/*  16:    */   public BaseSiteMessageExt()
/*  17:    */   {
/*  18: 26 */     initialize();
/*  19:    */   }
/*  20:    */   
/*  21:    */   public BaseSiteMessageExt(Integer id)
/*  22:    */   {
/*  23: 33 */     setId(id);
/*  24: 34 */     initialize();
/*  25:    */   }
/*  26:    */   
/*  27: 41 */   private int hashCode = -2147483648;
/*  28:    */   private Integer id;
/*  29:    */   private String title;
/*  30:    */   private String content;
/*  31:    */   private SiteMessage message;
/*  32:    */   
/*  33:    */   protected void initialize() {}
/*  34:    */   
/*  35:    */   public Integer getId()
/*  36:    */   {
/*  37: 62 */     return this.id;
/*  38:    */   }
/*  39:    */   
/*  40:    */   public void setId(Integer id)
/*  41:    */   {
/*  42: 70 */     this.id = id;
/*  43: 71 */     this.hashCode = -2147483648;
/*  44:    */   }
/*  45:    */   
/*  46:    */   public String getTitle()
/*  47:    */   {
/*  48: 81 */     return this.title;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public void setTitle(String title)
/*  52:    */   {
/*  53: 89 */     this.title = title;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public String getContent()
/*  57:    */   {
/*  58: 98 */     return this.content;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public void setContent(String content)
/*  62:    */   {
/*  63:106 */     this.content = content;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public SiteMessage getMessage()
/*  67:    */   {
/*  68:115 */     return this.message;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public void setMessage(SiteMessage message)
/*  72:    */   {
/*  73:123 */     this.message = message;
/*  74:    */   }
/*  75:    */   
/*  76:    */   public boolean equals(Object obj)
/*  77:    */   {
/*  78:130 */     if (obj == null) {
/*  79:130 */       return false;
/*  80:    */     }
/*  81:131 */     if (!(obj instanceof SiteMessageExt)) {
/*  82:131 */       return false;
/*  83:    */     }
/*  84:133 */     SiteMessageExt siteMessageExt = (SiteMessageExt)obj;
/*  85:134 */     if ((getId() == null) || (siteMessageExt.getId() == null)) {
/*  86:134 */       return false;
/*  87:    */     }
/*  88:135 */     return getId().equals(siteMessageExt.getId());
/*  89:    */   }
/*  90:    */   
/*  91:    */   public int hashCode()
/*  92:    */   {
/*  93:140 */     if (-2147483648 == this.hashCode)
/*  94:    */     {
/*  95:141 */       if (getId() == null) {
/*  96:141 */         return super.hashCode();
/*  97:    */       }
/*  98:143 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/*  99:144 */       this.hashCode = hashStr.hashCode();
/* 100:    */     }
/* 101:147 */     return this.hashCode;
/* 102:    */   }
/* 103:    */   
/* 104:    */   public String toString()
/* 105:    */   {
/* 106:152 */     return super.toString();
/* 107:    */   }
/* 108:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.entity.base.BaseSiteMessageExt
 * JD-Core Version:    0.7.0.1
 */