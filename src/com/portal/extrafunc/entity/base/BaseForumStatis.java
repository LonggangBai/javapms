/*   1:    */ package com.portal.extrafunc.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.extrafunc.entity.ForumStatis;
/*   4:    */ import com.portal.sysmgr.entity.Site;
/*   5:    */ import java.io.Serializable;
/*   6:    */ 
/*   7:    */ public abstract class BaseForumStatis
/*   8:    */   implements Serializable
/*   9:    */ {
/*  10: 17 */   public static String REF = "ForumStatis";
/*  11: 18 */   public static String PROP_POSTS_TOTAL = "postsTotal";
/*  12: 19 */   public static String PROP_HIGHEST_DAY = "highestDay";
/*  13: 20 */   public static String PROP_SITE = "site";
/*  14: 21 */   public static String PROP_ID = "id";
/*  15: 22 */   public static String PROP_POSTS_YESTODAY = "postsYestoday";
/*  16: 23 */   public static String PROP_POSTS_TODAY = "postsToday";
/*  17:    */   
/*  18:    */   public BaseForumStatis()
/*  19:    */   {
/*  20: 28 */     initialize();
/*  21:    */   }
/*  22:    */   
/*  23:    */   public BaseForumStatis(Integer id)
/*  24:    */   {
/*  25: 35 */     setId(id);
/*  26: 36 */     initialize();
/*  27:    */   }
/*  28:    */   
/*  29:    */   public BaseForumStatis(Integer id, Integer postsToday, Integer postsYestoday, Integer highestDay, Integer postsTotal)
/*  30:    */   {
/*  31: 49 */     setId(id);
/*  32: 50 */     setPostsToday(postsToday);
/*  33: 51 */     setPostsYestoday(postsYestoday);
/*  34: 52 */     setHighestDay(highestDay);
/*  35: 53 */     setPostsTotal(postsTotal);
/*  36: 54 */     initialize();
/*  37:    */   }
/*  38:    */   
/*  39: 61 */   private int hashCode = -2147483648;
/*  40:    */   private Integer id;
/*  41:    */   private Integer postsToday;
/*  42:    */   private Integer postsYestoday;
/*  43:    */   private Integer highestDay;
/*  44:    */   private Integer postsTotal;
/*  45:    */   private Site site;
/*  46:    */   
/*  47:    */   protected void initialize() {}
/*  48:    */   
/*  49:    */   public Integer getId()
/*  50:    */   {
/*  51: 84 */     return this.id;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public void setId(Integer id)
/*  55:    */   {
/*  56: 92 */     this.id = id;
/*  57: 93 */     this.hashCode = -2147483648;
/*  58:    */   }
/*  59:    */   
/*  60:    */   public Integer getPostsToday()
/*  61:    */   {
/*  62:103 */     return this.postsToday;
/*  63:    */   }
/*  64:    */   
/*  65:    */   public void setPostsToday(Integer postsToday)
/*  66:    */   {
/*  67:111 */     this.postsToday = postsToday;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public Integer getPostsYestoday()
/*  71:    */   {
/*  72:120 */     return this.postsYestoday;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public void setPostsYestoday(Integer postsYestoday)
/*  76:    */   {
/*  77:128 */     this.postsYestoday = postsYestoday;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public Integer getHighestDay()
/*  81:    */   {
/*  82:137 */     return this.highestDay;
/*  83:    */   }
/*  84:    */   
/*  85:    */   public void setHighestDay(Integer highestDay)
/*  86:    */   {
/*  87:145 */     this.highestDay = highestDay;
/*  88:    */   }
/*  89:    */   
/*  90:    */   public Integer getPostsTotal()
/*  91:    */   {
/*  92:154 */     return this.postsTotal;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public void setPostsTotal(Integer postsTotal)
/*  96:    */   {
/*  97:162 */     this.postsTotal = postsTotal;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public Site getSite()
/* 101:    */   {
/* 102:171 */     return this.site;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public void setSite(Site site)
/* 106:    */   {
/* 107:179 */     this.site = site;
/* 108:    */   }
/* 109:    */   
/* 110:    */   public boolean equals(Object obj)
/* 111:    */   {
/* 112:186 */     if (obj == null) {
/* 113:186 */       return false;
/* 114:    */     }
/* 115:187 */     if (!(obj instanceof ForumStatis)) {
/* 116:187 */       return false;
/* 117:    */     }
/* 118:189 */     ForumStatis forumStatis = (ForumStatis)obj;
/* 119:190 */     if ((getId() == null) || (forumStatis.getId() == null)) {
/* 120:190 */       return false;
/* 121:    */     }
/* 122:191 */     return getId().equals(forumStatis.getId());
/* 123:    */   }
/* 124:    */   
/* 125:    */   public int hashCode()
/* 126:    */   {
/* 127:196 */     if (-2147483648 == this.hashCode)
/* 128:    */     {
/* 129:197 */       if (getId() == null) {
/* 130:197 */         return super.hashCode();
/* 131:    */       }
/* 132:199 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 133:200 */       this.hashCode = hashStr.hashCode();
/* 134:    */     }
/* 135:203 */     return this.hashCode;
/* 136:    */   }
/* 137:    */   
/* 138:    */   public String toString()
/* 139:    */   {
/* 140:208 */     return super.toString();
/* 141:    */   }
/* 142:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.entity.base.BaseForumStatis
 * JD-Core Version:    0.7.0.1
 */