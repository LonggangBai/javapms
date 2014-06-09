/*   1:    */ package com.portal.extrafunc.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.extrafunc.entity.Category;
/*   4:    */ import com.portal.extrafunc.entity.Forum;
/*   5:    */ import com.portal.extrafunc.entity.ForumExt;
/*   6:    */ import com.portal.extrafunc.entity.Theme;
/*   7:    */ import com.portal.sysmgr.entity.Site;
/*   8:    */ import com.portal.usermgr.entity.User;
/*   9:    */ import java.io.Serializable;
/*  10:    */ 
/*  11:    */ public abstract class BaseForum
/*  12:    */   implements Serializable
/*  13:    */ {
/*  14: 17 */   public static String REF = "Forum";
/*  15: 18 */   public static String PROP_SITE = "site";
/*  16: 19 */   public static String PROP_LAST_THEME = "lastTheme";
/*  17: 20 */   public static String PROP_LAST_REPLYER = "lastReplyer";
/*  18: 21 */   public static String PROP_REPLY_TOTAL = "replyTotal";
/*  19: 22 */   public static String PROP_PRIORITY = "priority";
/*  20: 23 */   public static String PROP_THEME_TODAY = "themeToday";
/*  21: 24 */   public static String PROP_NAME = "name";
/*  22: 25 */   public static String PROP_CATEGORY = "category";
/*  23: 26 */   public static String PROP_EXT = "ext";
/*  24: 27 */   public static String PROP_THEME_TOTAL = "themeTotal";
/*  25: 28 */   public static String PROP_ID = "id";
/*  26: 29 */   public static String PROP_MODERATORS = "moderators";
/*  27: 30 */   public static String PROP_REPLY_TODAY = "replyToday";
/*  28:    */   
/*  29:    */   public BaseForum()
/*  30:    */   {
/*  31: 35 */     initialize();
/*  32:    */   }
/*  33:    */   
/*  34:    */   public BaseForum(Integer id)
/*  35:    */   {
/*  36: 42 */     setId(id);
/*  37: 43 */     initialize();
/*  38:    */   }
/*  39:    */   
/*  40:    */   public BaseForum(Integer id, Site site, Category category, String name, Integer priority, Integer themeTotal, Integer replyTotal, Integer themeToday, Integer replyToday)
/*  41:    */   {
/*  42: 60 */     setId(id);
/*  43: 61 */     setSite(site);
/*  44: 62 */     setCategory(category);
/*  45: 63 */     setName(name);
/*  46: 64 */     setPriority(priority);
/*  47: 65 */     setThemeTotal(themeTotal);
/*  48: 66 */     setReplyTotal(replyTotal);
/*  49: 67 */     setThemeToday(themeToday);
/*  50: 68 */     setReplyToday(replyToday);
/*  51: 69 */     initialize();
/*  52:    */   }
/*  53:    */   
/*  54: 76 */   private int hashCode = -2147483648;
/*  55:    */   private Integer id;
/*  56:    */   private String name;
/*  57:    */   private Integer priority;
/*  58:    */   private Integer themeTotal;
/*  59:    */   private Integer replyTotal;
/*  60:    */   private Integer themeToday;
/*  61:    */   private Integer replyToday;
/*  62:    */   private String moderators;
/*  63:    */   private ForumExt ext;
/*  64:    */   private Theme lastTheme;
/*  65:    */   private Site site;
/*  66:    */   private Category category;
/*  67:    */   private User lastReplyer;
/*  68:    */   
/*  69:    */   protected void initialize() {}
/*  70:    */   
/*  71:    */   public Integer getId()
/*  72:    */   {
/*  73:108 */     return this.id;
/*  74:    */   }
/*  75:    */   
/*  76:    */   public void setId(Integer id)
/*  77:    */   {
/*  78:116 */     this.id = id;
/*  79:117 */     this.hashCode = -2147483648;
/*  80:    */   }
/*  81:    */   
/*  82:    */   public String getName()
/*  83:    */   {
/*  84:127 */     return this.name;
/*  85:    */   }
/*  86:    */   
/*  87:    */   public void setName(String name)
/*  88:    */   {
/*  89:135 */     this.name = name;
/*  90:    */   }
/*  91:    */   
/*  92:    */   public Integer getPriority()
/*  93:    */   {
/*  94:144 */     return this.priority;
/*  95:    */   }
/*  96:    */   
/*  97:    */   public void setPriority(Integer priority)
/*  98:    */   {
/*  99:152 */     this.priority = priority;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public Integer getThemeTotal()
/* 103:    */   {
/* 104:161 */     return this.themeTotal;
/* 105:    */   }
/* 106:    */   
/* 107:    */   public void setThemeTotal(Integer themeTotal)
/* 108:    */   {
/* 109:169 */     this.themeTotal = themeTotal;
/* 110:    */   }
/* 111:    */   
/* 112:    */   public Integer getReplyTotal()
/* 113:    */   {
/* 114:178 */     return this.replyTotal;
/* 115:    */   }
/* 116:    */   
/* 117:    */   public void setReplyTotal(Integer replyTotal)
/* 118:    */   {
/* 119:186 */     this.replyTotal = replyTotal;
/* 120:    */   }
/* 121:    */   
/* 122:    */   public Integer getThemeToday()
/* 123:    */   {
/* 124:195 */     return this.themeToday;
/* 125:    */   }
/* 126:    */   
/* 127:    */   public void setThemeToday(Integer themeToday)
/* 128:    */   {
/* 129:203 */     this.themeToday = themeToday;
/* 130:    */   }
/* 131:    */   
/* 132:    */   public Integer getReplyToday()
/* 133:    */   {
/* 134:212 */     return this.replyToday;
/* 135:    */   }
/* 136:    */   
/* 137:    */   public void setReplyToday(Integer replyToday)
/* 138:    */   {
/* 139:220 */     this.replyToday = replyToday;
/* 140:    */   }
/* 141:    */   
/* 142:    */   public String getModerators()
/* 143:    */   {
/* 144:229 */     return this.moderators;
/* 145:    */   }
/* 146:    */   
/* 147:    */   public void setModerators(String moderators)
/* 148:    */   {
/* 149:237 */     this.moderators = moderators;
/* 150:    */   }
/* 151:    */   
/* 152:    */   public ForumExt getExt()
/* 153:    */   {
/* 154:246 */     return this.ext;
/* 155:    */   }
/* 156:    */   
/* 157:    */   public void setExt(ForumExt ext)
/* 158:    */   {
/* 159:254 */     this.ext = ext;
/* 160:    */   }
/* 161:    */   
/* 162:    */   public Theme getLastTheme()
/* 163:    */   {
/* 164:263 */     return this.lastTheme;
/* 165:    */   }
/* 166:    */   
/* 167:    */   public void setLastTheme(Theme lastTheme)
/* 168:    */   {
/* 169:271 */     this.lastTheme = lastTheme;
/* 170:    */   }
/* 171:    */   
/* 172:    */   public Site getSite()
/* 173:    */   {
/* 174:280 */     return this.site;
/* 175:    */   }
/* 176:    */   
/* 177:    */   public void setSite(Site site)
/* 178:    */   {
/* 179:288 */     this.site = site;
/* 180:    */   }
/* 181:    */   
/* 182:    */   public Category getCategory()
/* 183:    */   {
/* 184:297 */     return this.category;
/* 185:    */   }
/* 186:    */   
/* 187:    */   public void setCategory(Category category)
/* 188:    */   {
/* 189:305 */     this.category = category;
/* 190:    */   }
/* 191:    */   
/* 192:    */   public User getLastReplyer()
/* 193:    */   {
/* 194:314 */     return this.lastReplyer;
/* 195:    */   }
/* 196:    */   
/* 197:    */   public void setLastReplyer(User lastReplyer)
/* 198:    */   {
/* 199:322 */     this.lastReplyer = lastReplyer;
/* 200:    */   }
/* 201:    */   
/* 202:    */   public boolean equals(Object obj)
/* 203:    */   {
/* 204:329 */     if (obj == null) {
/* 205:329 */       return false;
/* 206:    */     }
/* 207:330 */     if (!(obj instanceof Forum)) {
/* 208:330 */       return false;
/* 209:    */     }
/* 210:332 */     Forum forum = (Forum)obj;
/* 211:333 */     if ((getId() == null) || (forum.getId() == null)) {
/* 212:333 */       return false;
/* 213:    */     }
/* 214:334 */     return getId().equals(forum.getId());
/* 215:    */   }
/* 216:    */   
/* 217:    */   public int hashCode()
/* 218:    */   {
/* 219:339 */     if (-2147483648 == this.hashCode)
/* 220:    */     {
/* 221:340 */       if (getId() == null) {
/* 222:340 */         return super.hashCode();
/* 223:    */       }
/* 224:342 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 225:343 */       this.hashCode = hashStr.hashCode();
/* 226:    */     }
/* 227:346 */     return this.hashCode;
/* 228:    */   }
/* 229:    */   
/* 230:    */   public String toString()
/* 231:    */   {
/* 232:351 */     return super.toString();
/* 233:    */   }
/* 234:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.entity.base.BaseForum
 * JD-Core Version:    0.7.0.1
 */