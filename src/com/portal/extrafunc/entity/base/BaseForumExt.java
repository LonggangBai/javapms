/*   1:    */ package com.portal.extrafunc.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.extrafunc.entity.Forum;
/*   4:    */ import com.portal.extrafunc.entity.ForumExt;
/*   5:    */ import java.io.Serializable;
/*   6:    */ 
/*   7:    */ public abstract class BaseForumExt
/*   8:    */   implements Serializable
/*   9:    */ {
/*  10: 17 */   public static String REF = "ForumExt";
/*  11: 18 */   public static String PROP_DESCRIPTION = "description";
/*  12: 19 */   public static String PROP_FORUM = "forum";
/*  13: 20 */   public static String PROP_ID = "id";
/*  14: 21 */   public static String PROP_RULE = "rule";
/*  15: 22 */   public static String PROP_KEYWORDS = "keywords";
/*  16: 23 */   public static String PROP_TPL_CONTENT = "tplContent";
/*  17:    */   
/*  18:    */   public BaseForumExt()
/*  19:    */   {
/*  20: 28 */     initialize();
/*  21:    */   }
/*  22:    */   
/*  23:    */   public BaseForumExt(Integer id)
/*  24:    */   {
/*  25: 35 */     setId(id);
/*  26: 36 */     initialize();
/*  27:    */   }
/*  28:    */   
/*  29: 43 */   private int hashCode = -2147483648;
/*  30:    */   private Integer id;
/*  31:    */   private String keywords;
/*  32:    */   private String description;
/*  33:    */   private String rule;
/*  34:    */   private String tplContent;
/*  35:    */   private Forum forum;
/*  36:    */   
/*  37:    */   protected void initialize() {}
/*  38:    */   
/*  39:    */   public Integer getId()
/*  40:    */   {
/*  41: 66 */     return this.id;
/*  42:    */   }
/*  43:    */   
/*  44:    */   public void setId(Integer id)
/*  45:    */   {
/*  46: 74 */     this.id = id;
/*  47: 75 */     this.hashCode = -2147483648;
/*  48:    */   }
/*  49:    */   
/*  50:    */   public String getKeywords()
/*  51:    */   {
/*  52: 85 */     return this.keywords;
/*  53:    */   }
/*  54:    */   
/*  55:    */   public void setKeywords(String keywords)
/*  56:    */   {
/*  57: 93 */     this.keywords = keywords;
/*  58:    */   }
/*  59:    */   
/*  60:    */   public String getDescription()
/*  61:    */   {
/*  62:102 */     return this.description;
/*  63:    */   }
/*  64:    */   
/*  65:    */   public void setDescription(String description)
/*  66:    */   {
/*  67:110 */     this.description = description;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public String getRule()
/*  71:    */   {
/*  72:119 */     return this.rule;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public void setRule(String rule)
/*  76:    */   {
/*  77:127 */     this.rule = rule;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public String getTplContent()
/*  81:    */   {
/*  82:136 */     return this.tplContent;
/*  83:    */   }
/*  84:    */   
/*  85:    */   public void setTplContent(String tplContent)
/*  86:    */   {
/*  87:144 */     this.tplContent = tplContent;
/*  88:    */   }
/*  89:    */   
/*  90:    */   public Forum getForum()
/*  91:    */   {
/*  92:153 */     return this.forum;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public void setForum(Forum forum)
/*  96:    */   {
/*  97:161 */     this.forum = forum;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public boolean equals(Object obj)
/* 101:    */   {
/* 102:168 */     if (obj == null) {
/* 103:168 */       return false;
/* 104:    */     }
/* 105:169 */     if (!(obj instanceof ForumExt)) {
/* 106:169 */       return false;
/* 107:    */     }
/* 108:171 */     ForumExt forumExt = (ForumExt)obj;
/* 109:172 */     if ((getId() == null) || (forumExt.getId() == null)) {
/* 110:172 */       return false;
/* 111:    */     }
/* 112:173 */     return getId().equals(forumExt.getId());
/* 113:    */   }
/* 114:    */   
/* 115:    */   public int hashCode()
/* 116:    */   {
/* 117:178 */     if (-2147483648 == this.hashCode)
/* 118:    */     {
/* 119:179 */       if (getId() == null) {
/* 120:179 */         return super.hashCode();
/* 121:    */       }
/* 122:181 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 123:182 */       this.hashCode = hashStr.hashCode();
/* 124:    */     }
/* 125:185 */     return this.hashCode;
/* 126:    */   }
/* 127:    */   
/* 128:    */   public String toString()
/* 129:    */   {
/* 130:190 */     return super.toString();
/* 131:    */   }
/* 132:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.entity.base.BaseForumExt
 * JD-Core Version:    0.7.0.1
 */