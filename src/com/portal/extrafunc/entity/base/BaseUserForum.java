/*   1:    */ package com.portal.extrafunc.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.extrafunc.entity.UserForum;
/*   4:    */ import com.portal.usermgr.entity.User;
/*   5:    */ import java.io.Serializable;
/*   6:    */ import java.util.Date;
/*   7:    */ 
/*   8:    */ public abstract class BaseUserForum
/*   9:    */   implements Serializable
/*  10:    */ {
/*  11: 17 */   public static String REF = "UserForum";
/*  12: 18 */   public static String PROP_USER = "user";
/*  13: 19 */   public static String PROP_STATUS = "status";
/*  14: 20 */   public static String PROP_REPLY_COUNT = "replyCount";
/*  15: 21 */   public static String PROP_STATUS_TIME = "statusTime";
/*  16: 22 */   public static String PROP_AVATAR = "avatar";
/*  17: 23 */   public static String PROP_ID = "id";
/*  18: 24 */   public static String PROP_THEME_COUNT = "themeCount";
/*  19: 25 */   public static String PROP_SIGNATURE = "signature";
/*  20: 26 */   public static String PROP_POINT = "point";
/*  21: 27 */   public static String PROP_ESSENA_COUNT = "essenaCount";
/*  22:    */   
/*  23:    */   public BaseUserForum()
/*  24:    */   {
/*  25: 32 */     initialize();
/*  26:    */   }
/*  27:    */   
/*  28:    */   public BaseUserForum(Integer id)
/*  29:    */   {
/*  30: 39 */     setId(id);
/*  31: 40 */     initialize();
/*  32:    */   }
/*  33:    */   
/*  34:    */   public BaseUserForum(Integer id, Integer essenaCount, Integer themeCount, Integer replyCount, Integer point, Integer status)
/*  35:    */   {
/*  36: 54 */     setId(id);
/*  37: 55 */     setEssenaCount(essenaCount);
/*  38: 56 */     setThemeCount(themeCount);
/*  39: 57 */     setReplyCount(replyCount);
/*  40: 58 */     setPoint(point);
/*  41: 59 */     setStatus(status);
/*  42: 60 */     initialize();
/*  43:    */   }
/*  44:    */   
/*  45: 67 */   private int hashCode = -2147483648;
/*  46:    */   private Integer id;
/*  47:    */   private String avatar;
/*  48:    */   private Integer essenaCount;
/*  49:    */   private Integer themeCount;
/*  50:    */   private Integer replyCount;
/*  51:    */   private Integer point;
/*  52:    */   private Integer status;
/*  53:    */   private Date statusTime;
/*  54:    */   private String signature;
/*  55:    */   private User user;
/*  56:    */   
/*  57:    */   protected void initialize() {}
/*  58:    */   
/*  59:    */   public Integer getId()
/*  60:    */   {
/*  61: 94 */     return this.id;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public void setId(Integer id)
/*  65:    */   {
/*  66:102 */     this.id = id;
/*  67:103 */     this.hashCode = -2147483648;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public String getAvatar()
/*  71:    */   {
/*  72:113 */     return this.avatar;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public void setAvatar(String avatar)
/*  76:    */   {
/*  77:121 */     this.avatar = avatar;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public Integer getEssenaCount()
/*  81:    */   {
/*  82:130 */     return this.essenaCount;
/*  83:    */   }
/*  84:    */   
/*  85:    */   public void setEssenaCount(Integer essenaCount)
/*  86:    */   {
/*  87:138 */     this.essenaCount = essenaCount;
/*  88:    */   }
/*  89:    */   
/*  90:    */   public Integer getThemeCount()
/*  91:    */   {
/*  92:147 */     return this.themeCount;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public void setThemeCount(Integer themeCount)
/*  96:    */   {
/*  97:155 */     this.themeCount = themeCount;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public Integer getReplyCount()
/* 101:    */   {
/* 102:164 */     return this.replyCount;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public void setReplyCount(Integer replyCount)
/* 106:    */   {
/* 107:172 */     this.replyCount = replyCount;
/* 108:    */   }
/* 109:    */   
/* 110:    */   public Integer getPoint()
/* 111:    */   {
/* 112:181 */     return this.point;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public void setPoint(Integer point)
/* 116:    */   {
/* 117:189 */     this.point = point;
/* 118:    */   }
/* 119:    */   
/* 120:    */   public Integer getStatus()
/* 121:    */   {
/* 122:198 */     return this.status;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public void setStatus(Integer status)
/* 126:    */   {
/* 127:206 */     this.status = status;
/* 128:    */   }
/* 129:    */   
/* 130:    */   public Date getStatusTime()
/* 131:    */   {
/* 132:215 */     return this.statusTime;
/* 133:    */   }
/* 134:    */   
/* 135:    */   public void setStatusTime(Date statusTime)
/* 136:    */   {
/* 137:223 */     this.statusTime = statusTime;
/* 138:    */   }
/* 139:    */   
/* 140:    */   public String getSignature()
/* 141:    */   {
/* 142:232 */     return this.signature;
/* 143:    */   }
/* 144:    */   
/* 145:    */   public void setSignature(String signature)
/* 146:    */   {
/* 147:240 */     this.signature = signature;
/* 148:    */   }
/* 149:    */   
/* 150:    */   public User getUser()
/* 151:    */   {
/* 152:249 */     return this.user;
/* 153:    */   }
/* 154:    */   
/* 155:    */   public void setUser(User user)
/* 156:    */   {
/* 157:257 */     this.user = user;
/* 158:    */   }
/* 159:    */   
/* 160:    */   public boolean equals(Object obj)
/* 161:    */   {
/* 162:264 */     if (obj == null) {
/* 163:264 */       return false;
/* 164:    */     }
/* 165:265 */     if (!(obj instanceof UserForum)) {
/* 166:265 */       return false;
/* 167:    */     }
/* 168:267 */     UserForum userForum = (UserForum)obj;
/* 169:268 */     if ((getId() == null) || (userForum.getId() == null)) {
/* 170:268 */       return false;
/* 171:    */     }
/* 172:269 */     return getId().equals(userForum.getId());
/* 173:    */   }
/* 174:    */   
/* 175:    */   public int hashCode()
/* 176:    */   {
/* 177:274 */     if (-2147483648 == this.hashCode)
/* 178:    */     {
/* 179:275 */       if (getId() == null) {
/* 180:275 */         return super.hashCode();
/* 181:    */       }
/* 182:277 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 183:278 */       this.hashCode = hashStr.hashCode();
/* 184:    */     }
/* 185:281 */     return this.hashCode;
/* 186:    */   }
/* 187:    */   
/* 188:    */   public String toString()
/* 189:    */   {
/* 190:286 */     return super.toString();
/* 191:    */   }
/* 192:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.entity.base.BaseUserForum
 * JD-Core Version:    0.7.0.1
 */