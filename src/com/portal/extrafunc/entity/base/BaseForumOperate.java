/*   1:    */ package com.portal.extrafunc.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.extrafunc.entity.ForumOperate;
/*   4:    */ import com.portal.sysmgr.entity.Site;
/*   5:    */ import com.portal.usermgr.entity.User;
/*   6:    */ import java.io.Serializable;
/*   7:    */ import java.util.Date;
/*   8:    */ 
/*   9:    */ public abstract class BaseForumOperate
/*  10:    */   implements Serializable
/*  11:    */ {
/*  12: 17 */   public static String REF = "ForumOperate";
/*  13: 18 */   public static String PROP_NAME = "name";
/*  14: 19 */   public static String PROP_SITE = "site";
/*  15: 20 */   public static String PROP_TARGET = "target";
/*  16: 21 */   public static String PROP_TARGET_TYPE = "targetType";
/*  17: 22 */   public static String PROP_ID = "id";
/*  18: 23 */   public static String PROP_OPERATE_TIME = "operateTime";
/*  19: 24 */   public static String PROP_ADMIN = "admin";
/*  20: 25 */   public static String PROP_REASON = "reason";
/*  21:    */   
/*  22:    */   public BaseForumOperate()
/*  23:    */   {
/*  24: 30 */     initialize();
/*  25:    */   }
/*  26:    */   
/*  27:    */   public BaseForumOperate(Integer id)
/*  28:    */   {
/*  29: 37 */     setId(id);
/*  30: 38 */     initialize();
/*  31:    */   }
/*  32:    */   
/*  33:    */   public BaseForumOperate(Integer id, User admin, Site site, Integer target, String targetType, String name, Date operateTime)
/*  34:    */   {
/*  35: 53 */     setId(id);
/*  36: 54 */     setAdmin(admin);
/*  37: 55 */     setSite(site);
/*  38: 56 */     setTarget(target);
/*  39: 57 */     setTargetType(targetType);
/*  40: 58 */     setName(name);
/*  41: 59 */     setOperateTime(operateTime);
/*  42: 60 */     initialize();
/*  43:    */   }
/*  44:    */   
/*  45: 67 */   private int hashCode = -2147483648;
/*  46:    */   private Integer id;
/*  47:    */   private Integer target;
/*  48:    */   private String targetType;
/*  49:    */   private String name;
/*  50:    */   private String reason;
/*  51:    */   private Date operateTime;
/*  52:    */   private User admin;
/*  53:    */   private Site site;
/*  54:    */   
/*  55:    */   protected void initialize() {}
/*  56:    */   
/*  57:    */   public Integer getId()
/*  58:    */   {
/*  59: 92 */     return this.id;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public void setId(Integer id)
/*  63:    */   {
/*  64:100 */     this.id = id;
/*  65:101 */     this.hashCode = -2147483648;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public Integer getTarget()
/*  69:    */   {
/*  70:111 */     return this.target;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public void setTarget(Integer target)
/*  74:    */   {
/*  75:119 */     this.target = target;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public String getTargetType()
/*  79:    */   {
/*  80:128 */     return this.targetType;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public void setTargetType(String targetType)
/*  84:    */   {
/*  85:136 */     this.targetType = targetType;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public String getName()
/*  89:    */   {
/*  90:145 */     return this.name;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public void setName(String name)
/*  94:    */   {
/*  95:153 */     this.name = name;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public String getReason()
/*  99:    */   {
/* 100:162 */     return this.reason;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public void setReason(String reason)
/* 104:    */   {
/* 105:170 */     this.reason = reason;
/* 106:    */   }
/* 107:    */   
/* 108:    */   public Date getOperateTime()
/* 109:    */   {
/* 110:179 */     return this.operateTime;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public void setOperateTime(Date operateTime)
/* 114:    */   {
/* 115:187 */     this.operateTime = operateTime;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public User getAdmin()
/* 119:    */   {
/* 120:196 */     return this.admin;
/* 121:    */   }
/* 122:    */   
/* 123:    */   public void setAdmin(User admin)
/* 124:    */   {
/* 125:204 */     this.admin = admin;
/* 126:    */   }
/* 127:    */   
/* 128:    */   public Site getSite()
/* 129:    */   {
/* 130:213 */     return this.site;
/* 131:    */   }
/* 132:    */   
/* 133:    */   public void setSite(Site site)
/* 134:    */   {
/* 135:221 */     this.site = site;
/* 136:    */   }
/* 137:    */   
/* 138:    */   public boolean equals(Object obj)
/* 139:    */   {
/* 140:228 */     if (obj == null) {
/* 141:228 */       return false;
/* 142:    */     }
/* 143:229 */     if (!(obj instanceof ForumOperate)) {
/* 144:229 */       return false;
/* 145:    */     }
/* 146:231 */     ForumOperate forumOperate = (ForumOperate)obj;
/* 147:232 */     if ((getId() == null) || (forumOperate.getId() == null)) {
/* 148:232 */       return false;
/* 149:    */     }
/* 150:233 */     return getId().equals(forumOperate.getId());
/* 151:    */   }
/* 152:    */   
/* 153:    */   public int hashCode()
/* 154:    */   {
/* 155:238 */     if (-2147483648 == this.hashCode)
/* 156:    */     {
/* 157:239 */       if (getId() == null) {
/* 158:239 */         return super.hashCode();
/* 159:    */       }
/* 160:241 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 161:242 */       this.hashCode = hashStr.hashCode();
/* 162:    */     }
/* 163:245 */     return this.hashCode;
/* 164:    */   }
/* 165:    */   
/* 166:    */   public String toString()
/* 167:    */   {
/* 168:250 */     return super.toString();
/* 169:    */   }
/* 170:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.entity.base.BaseForumOperate
 * JD-Core Version:    0.7.0.1
 */