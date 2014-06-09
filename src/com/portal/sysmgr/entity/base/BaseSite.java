/*   1:    */ package com.portal.sysmgr.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.extrafunc.entity.ForumStatis;
/*   4:    */ import com.portal.sysmgr.entity.Site;
/*   5:    */ import java.io.Serializable;
/*   6:    */ 
/*   7:    */ public abstract class BaseSite
/*   8:    */   implements Serializable
/*   9:    */ {
/*  10: 17 */   public static String REF = "Site";
/*  11: 18 */   public static String PROP_DESCRIPTION = "description";
/*  12: 19 */   public static String PROP_RECOVER = "recover";
/*  13: 20 */   public static String PROP_DOMAIN = "domain";
/*  14: 21 */   public static String PROP_TITLE = "title";
/*  15: 22 */   public static String PROP_PATH = "path";
/*  16: 23 */   public static String PROP_NAME = "name";
/*  17: 24 */   public static String PROP_PORT = "port";
/*  18: 25 */   public static String PROP_CONTEXT_PATH = "contextPath";
/*  19: 26 */   public static String PROP_SHORT_NAME = "shortName";
/*  20: 27 */   public static String PROP_ID = "id";
/*  21: 28 */   public static String PROP_FORUM_STATIS = "forumStatis";
/*  22: 29 */   public static String PROP_TPL_STYLE = "tplStyle";
/*  23: 30 */   public static String PROP_KEYWORDS = "keywords";
/*  24:    */   
/*  25:    */   public BaseSite()
/*  26:    */   {
/*  27: 35 */     initialize();
/*  28:    */   }
/*  29:    */   
/*  30:    */   public BaseSite(Integer id)
/*  31:    */   {
/*  32: 42 */     setId(id);
/*  33: 43 */     initialize();
/*  34:    */   }
/*  35:    */   
/*  36:    */   public BaseSite(Integer id, String domain, String path, String name, String tplStyle, Boolean recover)
/*  37:    */   {
/*  38: 57 */     setId(id);
/*  39: 58 */     setDomain(domain);
/*  40: 59 */     setPath(path);
/*  41: 60 */     setName(name);
/*  42: 61 */     setTplStyle(tplStyle);
/*  43: 62 */     setRecover(recover);
/*  44: 63 */     initialize();
/*  45:    */   }
/*  46:    */   
/*  47: 70 */   private int hashCode = -2147483648;
/*  48:    */   private Integer id;
/*  49:    */   private String domain;
/*  50:    */   private String path;
/*  51:    */   private String name;
/*  52:    */   private String shortName;
/*  53:    */   private String contextPath;
/*  54:    */   private Integer port;
/*  55:    */   private String tplStyle;
/*  56:    */   private String title;
/*  57:    */   private String keywords;
/*  58:    */   private String description;
/*  59:    */   private Boolean recover;
/*  60:    */   private ForumStatis forumStatis;
/*  61:    */   
/*  62:    */   protected void initialize() {}
/*  63:    */   
/*  64:    */   public Integer getId()
/*  65:    */   {
/*  66:100 */     return this.id;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public void setId(Integer id)
/*  70:    */   {
/*  71:108 */     this.id = id;
/*  72:109 */     this.hashCode = -2147483648;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public String getDomain()
/*  76:    */   {
/*  77:119 */     return this.domain;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public void setDomain(String domain)
/*  81:    */   {
/*  82:127 */     this.domain = domain;
/*  83:    */   }
/*  84:    */   
/*  85:    */   public String getPath()
/*  86:    */   {
/*  87:136 */     return this.path;
/*  88:    */   }
/*  89:    */   
/*  90:    */   public void setPath(String path)
/*  91:    */   {
/*  92:144 */     this.path = path;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public String getName()
/*  96:    */   {
/*  97:153 */     return this.name;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public void setName(String name)
/* 101:    */   {
/* 102:161 */     this.name = name;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public String getShortName()
/* 106:    */   {
/* 107:170 */     return this.shortName;
/* 108:    */   }
/* 109:    */   
/* 110:    */   public void setShortName(String shortName)
/* 111:    */   {
/* 112:178 */     this.shortName = shortName;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public String getContextPath()
/* 116:    */   {
/* 117:187 */     return this.contextPath;
/* 118:    */   }
/* 119:    */   
/* 120:    */   public void setContextPath(String contextPath)
/* 121:    */   {
/* 122:195 */     this.contextPath = contextPath;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public Integer getPort()
/* 126:    */   {
/* 127:204 */     return this.port;
/* 128:    */   }
/* 129:    */   
/* 130:    */   public void setPort(Integer port)
/* 131:    */   {
/* 132:212 */     this.port = port;
/* 133:    */   }
/* 134:    */   
/* 135:    */   public String getTplStyle()
/* 136:    */   {
/* 137:221 */     return this.tplStyle;
/* 138:    */   }
/* 139:    */   
/* 140:    */   public void setTplStyle(String tplStyle)
/* 141:    */   {
/* 142:229 */     this.tplStyle = tplStyle;
/* 143:    */   }
/* 144:    */   
/* 145:    */   public String getTitle()
/* 146:    */   {
/* 147:238 */     return this.title;
/* 148:    */   }
/* 149:    */   
/* 150:    */   public void setTitle(String title)
/* 151:    */   {
/* 152:246 */     this.title = title;
/* 153:    */   }
/* 154:    */   
/* 155:    */   public String getKeywords()
/* 156:    */   {
/* 157:255 */     return this.keywords;
/* 158:    */   }
/* 159:    */   
/* 160:    */   public void setKeywords(String keywords)
/* 161:    */   {
/* 162:263 */     this.keywords = keywords;
/* 163:    */   }
/* 164:    */   
/* 165:    */   public String getDescription()
/* 166:    */   {
/* 167:272 */     return this.description;
/* 168:    */   }
/* 169:    */   
/* 170:    */   public void setDescription(String description)
/* 171:    */   {
/* 172:280 */     this.description = description;
/* 173:    */   }
/* 174:    */   
/* 175:    */   public Boolean getRecover()
/* 176:    */   {
/* 177:289 */     return this.recover;
/* 178:    */   }
/* 179:    */   
/* 180:    */   public void setRecover(Boolean recover)
/* 181:    */   {
/* 182:297 */     this.recover = recover;
/* 183:    */   }
/* 184:    */   
/* 185:    */   public ForumStatis getForumStatis()
/* 186:    */   {
/* 187:306 */     return this.forumStatis;
/* 188:    */   }
/* 189:    */   
/* 190:    */   public void setForumStatis(ForumStatis forumStatis)
/* 191:    */   {
/* 192:314 */     this.forumStatis = forumStatis;
/* 193:    */   }
/* 194:    */   
/* 195:    */   public boolean equals(Object obj)
/* 196:    */   {
/* 197:321 */     if (obj == null) {
/* 198:321 */       return false;
/* 199:    */     }
/* 200:322 */     if (!(obj instanceof Site)) {
/* 201:322 */       return false;
/* 202:    */     }
/* 203:324 */     Site site = (Site)obj;
/* 204:325 */     if ((getId() == null) || (site.getId() == null)) {
/* 205:325 */       return false;
/* 206:    */     }
/* 207:326 */     return getId().equals(site.getId());
/* 208:    */   }
/* 209:    */   
/* 210:    */   public int hashCode()
/* 211:    */   {
/* 212:331 */     if (-2147483648 == this.hashCode)
/* 213:    */     {
/* 214:332 */       if (getId() == null) {
/* 215:332 */         return super.hashCode();
/* 216:    */       }
/* 217:334 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 218:335 */       this.hashCode = hashStr.hashCode();
/* 219:    */     }
/* 220:338 */     return this.hashCode;
/* 221:    */   }
/* 222:    */   
/* 223:    */   public String toString()
/* 224:    */   {
/* 225:343 */     return super.toString();
/* 226:    */   }
/* 227:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.sysmgr.entity.base.BaseSite
 * JD-Core Version:    0.7.0.1
 */