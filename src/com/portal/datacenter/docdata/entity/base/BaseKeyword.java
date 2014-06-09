/*   1:    */ package com.portal.datacenter.docdata.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.datacenter.docdata.entity.Keyword;
/*   4:    */ import com.portal.sysmgr.entity.Site;
/*   5:    */ import java.io.Serializable;
/*   6:    */ 
/*   7:    */ public abstract class BaseKeyword
/*   8:    */   implements Serializable
/*   9:    */ {
/*  10: 17 */   public static String REF = "Keyword";
/*  11: 18 */   public static String PROP_NAME = "name";
/*  12: 19 */   public static String PROP_SITE = "site";
/*  13: 20 */   public static String PROP_URL = "url";
/*  14: 21 */   public static String PROP_ENABLE = "enable";
/*  15: 22 */   public static String PROP_BOLD = "bold";
/*  16: 23 */   public static String PROP_UNDERLINE = "underline";
/*  17: 24 */   public static String PROP_ID = "id";
/*  18:    */   
/*  19:    */   public BaseKeyword()
/*  20:    */   {
/*  21: 29 */     initialize();
/*  22:    */   }
/*  23:    */   
/*  24:    */   public BaseKeyword(Integer id)
/*  25:    */   {
/*  26: 36 */     setId(id);
/*  27: 37 */     initialize();
/*  28:    */   }
/*  29:    */   
/*  30:    */   public BaseKeyword(Integer id, String name, String url, Boolean bold, Boolean underline, Boolean enable)
/*  31:    */   {
/*  32: 51 */     setId(id);
/*  33: 52 */     setName(name);
/*  34: 53 */     setUrl(url);
/*  35: 54 */     setBold(bold);
/*  36: 55 */     setUnderline(underline);
/*  37: 56 */     setEnable(enable);
/*  38: 57 */     initialize();
/*  39:    */   }
/*  40:    */   
/*  41: 64 */   private int hashCode = -2147483648;
/*  42:    */   private Integer id;
/*  43:    */   private String name;
/*  44:    */   private String url;
/*  45:    */   private Boolean bold;
/*  46:    */   private Boolean underline;
/*  47:    */   private Boolean enable;
/*  48:    */   private Site site;
/*  49:    */   
/*  50:    */   protected void initialize() {}
/*  51:    */   
/*  52:    */   public Integer getId()
/*  53:    */   {
/*  54: 88 */     return this.id;
/*  55:    */   }
/*  56:    */   
/*  57:    */   public void setId(Integer id)
/*  58:    */   {
/*  59: 96 */     this.id = id;
/*  60: 97 */     this.hashCode = -2147483648;
/*  61:    */   }
/*  62:    */   
/*  63:    */   public String getName()
/*  64:    */   {
/*  65:107 */     return this.name;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public void setName(String name)
/*  69:    */   {
/*  70:115 */     this.name = name;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public String getUrl()
/*  74:    */   {
/*  75:124 */     return this.url;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public void setUrl(String url)
/*  79:    */   {
/*  80:132 */     this.url = url;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public Boolean getBold()
/*  84:    */   {
/*  85:141 */     return this.bold;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public void setBold(Boolean bold)
/*  89:    */   {
/*  90:149 */     this.bold = bold;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public Boolean getUnderline()
/*  94:    */   {
/*  95:158 */     return this.underline;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public void setUnderline(Boolean underline)
/*  99:    */   {
/* 100:166 */     this.underline = underline;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public Boolean getEnable()
/* 104:    */   {
/* 105:175 */     return this.enable;
/* 106:    */   }
/* 107:    */   
/* 108:    */   public void setEnable(Boolean enable)
/* 109:    */   {
/* 110:183 */     this.enable = enable;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public Site getSite()
/* 114:    */   {
/* 115:192 */     return this.site;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public void setSite(Site site)
/* 119:    */   {
/* 120:200 */     this.site = site;
/* 121:    */   }
/* 122:    */   
/* 123:    */   public boolean equals(Object obj)
/* 124:    */   {
/* 125:207 */     if (obj == null) {
/* 126:207 */       return false;
/* 127:    */     }
/* 128:208 */     if (!(obj instanceof Keyword)) {
/* 129:208 */       return false;
/* 130:    */     }
/* 131:210 */     Keyword keyword = (Keyword)obj;
/* 132:211 */     if ((getId() == null) || (keyword.getId() == null)) {
/* 133:211 */       return false;
/* 134:    */     }
/* 135:212 */     return getId().equals(keyword.getId());
/* 136:    */   }
/* 137:    */   
/* 138:    */   public int hashCode()
/* 139:    */   {
/* 140:217 */     if (-2147483648 == this.hashCode)
/* 141:    */     {
/* 142:218 */       if (getId() == null) {
/* 143:218 */         return super.hashCode();
/* 144:    */       }
/* 145:220 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 146:221 */       this.hashCode = hashStr.hashCode();
/* 147:    */     }
/* 148:224 */     return this.hashCode;
/* 149:    */   }
/* 150:    */   
/* 151:    */   public String toString()
/* 152:    */   {
/* 153:229 */     return super.toString();
/* 154:    */   }
/* 155:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.docdata.entity.base.BaseKeyword
 * JD-Core Version:    0.7.0.1
 */