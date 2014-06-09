/*   1:    */ package com.portal.datacenter.operatedata.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.datacenter.operatedata.entity.Log;
/*   4:    */ import com.portal.sysmgr.entity.Site;
/*   5:    */ import com.portal.usermgr.entity.User;
/*   6:    */ import java.io.Serializable;
/*   7:    */ import java.util.Date;
/*   8:    */ 
/*   9:    */ public abstract class BaseLog
/*  10:    */   implements Serializable
/*  11:    */ {
/*  12: 15 */   public static String REF = "Log";
/*  13: 16 */   public static String PROP_TIME = "time";
/*  14: 17 */   public static String PROP_SITE = "site";
/*  15: 18 */   public static String PROP_USER = "user";
/*  16: 19 */   public static String PROP_URL = "url";
/*  17: 20 */   public static String PROP_IP = "ip";
/*  18: 21 */   public static String PROP_CATEGORY = "category";
/*  19: 22 */   public static String PROP_TITLE = "title";
/*  20: 23 */   public static String PROP_CONTENT = "content";
/*  21: 24 */   public static String PROP_ID = "id";
/*  22:    */   
/*  23:    */   public BaseLog()
/*  24:    */   {
/*  25: 28 */     initialize();
/*  26:    */   }
/*  27:    */   
/*  28:    */   public BaseLog(Integer id)
/*  29:    */   {
/*  30: 35 */     setId(id);
/*  31: 36 */     initialize();
/*  32:    */   }
/*  33:    */   
/*  34:    */   public BaseLog(Integer id, Integer category, Date time)
/*  35:    */   {
/*  36: 45 */     setId(id);
/*  37: 46 */     setCategory(category);
/*  38: 47 */     setTime(time);
/*  39: 48 */     initialize();
/*  40:    */   }
/*  41:    */   
/*  42: 54 */   private int hashCode = -2147483648;
/*  43:    */   private Integer id;
/*  44:    */   private Integer category;
/*  45:    */   private Date time;
/*  46:    */   private String ip;
/*  47:    */   private String url;
/*  48:    */   private String title;
/*  49:    */   private String content;
/*  50:    */   private User user;
/*  51:    */   private Site site;
/*  52:    */   
/*  53:    */   protected void initialize() {}
/*  54:    */   
/*  55:    */   public Integer getId()
/*  56:    */   {
/*  57: 77 */     return this.id;
/*  58:    */   }
/*  59:    */   
/*  60:    */   public void setId(Integer id)
/*  61:    */   {
/*  62: 87 */     this.id = id;
/*  63: 88 */     this.hashCode = -2147483648;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public Integer getCategory()
/*  67:    */   {
/*  68: 95 */     return this.category;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public void setCategory(Integer category)
/*  72:    */   {
/*  73:105 */     this.category = category;
/*  74:    */   }
/*  75:    */   
/*  76:    */   public Date getTime()
/*  77:    */   {
/*  78:112 */     return this.time;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public void setTime(Date time)
/*  82:    */   {
/*  83:122 */     this.time = time;
/*  84:    */   }
/*  85:    */   
/*  86:    */   public String getIp()
/*  87:    */   {
/*  88:129 */     return this.ip;
/*  89:    */   }
/*  90:    */   
/*  91:    */   public void setIp(String ip)
/*  92:    */   {
/*  93:139 */     this.ip = ip;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public String getUrl()
/*  97:    */   {
/*  98:146 */     return this.url;
/*  99:    */   }
/* 100:    */   
/* 101:    */   public void setUrl(String url)
/* 102:    */   {
/* 103:156 */     this.url = url;
/* 104:    */   }
/* 105:    */   
/* 106:    */   public String getTitle()
/* 107:    */   {
/* 108:163 */     return this.title;
/* 109:    */   }
/* 110:    */   
/* 111:    */   public void setTitle(String title)
/* 112:    */   {
/* 113:173 */     this.title = title;
/* 114:    */   }
/* 115:    */   
/* 116:    */   public String getContent()
/* 117:    */   {
/* 118:180 */     return this.content;
/* 119:    */   }
/* 120:    */   
/* 121:    */   public void setContent(String content)
/* 122:    */   {
/* 123:190 */     this.content = content;
/* 124:    */   }
/* 125:    */   
/* 126:    */   public User getUser()
/* 127:    */   {
/* 128:197 */     return this.user;
/* 129:    */   }
/* 130:    */   
/* 131:    */   public void setUser(User user)
/* 132:    */   {
/* 133:207 */     this.user = user;
/* 134:    */   }
/* 135:    */   
/* 136:    */   public Site getSite()
/* 137:    */   {
/* 138:214 */     return this.site;
/* 139:    */   }
/* 140:    */   
/* 141:    */   public void setSite(Site site)
/* 142:    */   {
/* 143:224 */     this.site = site;
/* 144:    */   }
/* 145:    */   
/* 146:    */   public boolean equals(Object obj)
/* 147:    */   {
/* 148:228 */     if (obj == null) {
/* 149:229 */       return false;
/* 150:    */     }
/* 151:230 */     if (!(obj instanceof Log)) {
/* 152:231 */       return false;
/* 153:    */     }
/* 154:233 */     Log log = (Log)obj;
/* 155:234 */     if ((getId() == null) || (log.getId() == null)) {
/* 156:235 */       return false;
/* 157:    */     }
/* 158:237 */     return getId().equals(log.getId());
/* 159:    */   }
/* 160:    */   
/* 161:    */   public int hashCode()
/* 162:    */   {
/* 163:242 */     if (-2147483648 == this.hashCode)
/* 164:    */     {
/* 165:243 */       if (getId() == null) {
/* 166:244 */         return super.hashCode();
/* 167:    */       }
/* 168:246 */       String hashStr = getClass().getName() + ":" + 
/* 169:247 */         getId().hashCode();
/* 170:248 */       this.hashCode = hashStr.hashCode();
/* 171:    */     }
/* 172:251 */     return this.hashCode;
/* 173:    */   }
/* 174:    */   
/* 175:    */   public String toString()
/* 176:    */   {
/* 177:255 */     return super.toString();
/* 178:    */   }
/* 179:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.operatedata.entity.base.BaseLog
 * JD-Core Version:    0.7.0.1
 */