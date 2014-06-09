/*   1:    */ package com.portal.extrafunc.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.extrafunc.entity.Posts;
/*   4:    */ import com.portal.extrafunc.entity.PostsAttach;
/*   5:    */ import com.portal.extrafunc.entity.PostsExt;
/*   6:    */ import com.portal.extrafunc.entity.PostsTxt;
/*   7:    */ import com.portal.extrafunc.entity.Theme;
/*   8:    */ import com.portal.sysmgr.entity.Site;
/*   9:    */ import com.portal.usermgr.entity.User;
/*  10:    */ import java.io.Serializable;
/*  11:    */ import java.util.Date;
/*  12:    */ import java.util.List;
/*  13:    */ 
/*  14:    */ public abstract class BasePosts
/*  15:    */   implements Serializable
/*  16:    */ {
/*  17: 17 */   public static String REF = "Posts";
/*  18: 18 */   public static String PROP_SITE = "site";
/*  19: 19 */   public static String PROP_HIDDEN = "hidden";
/*  20: 20 */   public static String PROP_CREATER = "creater";
/*  21: 21 */   public static String PROP_TITLE = "title";
/*  22: 22 */   public static String PROP_FLOOR = "floor";
/*  23: 23 */   public static String PROP_STATUS = "status";
/*  24: 24 */   public static String PROP_AFFIX = "affix";
/*  25: 25 */   public static String PROP_THEME = "theme";
/*  26: 26 */   public static String PROP_TXT = "txt";
/*  27: 27 */   public static String PROP_EXT = "ext";
/*  28: 28 */   public static String PROP_IMG = "img";
/*  29: 29 */   public static String PROP_CREATE_TIME = "createTime";
/*  30: 30 */   public static String PROP_ID = "id";
/*  31:    */   
/*  32:    */   public BasePosts()
/*  33:    */   {
/*  34: 35 */     initialize();
/*  35:    */   }
/*  36:    */   
/*  37:    */   public BasePosts(Integer id)
/*  38:    */   {
/*  39: 42 */     setId(id);
/*  40: 43 */     initialize();
/*  41:    */   }
/*  42:    */   
/*  43:    */   public BasePosts(Integer id, Theme theme, Site site, Integer status, Boolean affix, Boolean img, Boolean hidden, Integer floor, Date createTime)
/*  44:    */   {
/*  45: 60 */     setId(id);
/*  46: 61 */     setTheme(theme);
/*  47: 62 */     setSite(site);
/*  48: 63 */     setStatus(status);
/*  49: 64 */     setAffix(affix);
/*  50: 65 */     setImg(img);
/*  51: 66 */     setHidden(hidden);
/*  52: 67 */     setFloor(floor);
/*  53: 68 */     setCreateTime(createTime);
/*  54: 69 */     initialize();
/*  55:    */   }
/*  56:    */   
/*  57: 76 */   private int hashCode = -2147483648;
/*  58:    */   private Integer id;
/*  59:    */   private String title;
/*  60:    */   private Integer status;
/*  61:    */   private Boolean affix;
/*  62:    */   private Boolean img;
/*  63:    */   private Boolean hidden;
/*  64:    */   private Integer floor;
/*  65:    */   private Date createTime;
/*  66:    */   private PostsExt ext;
/*  67:    */   private PostsTxt txt;
/*  68:    */   private Theme theme;
/*  69:    */   private Posts quote;
/*  70:    */   private User creater;
/*  71:    */   private Site site;
/*  72:    */   private List<PostsAttach> attachs;
/*  73:    */   
/*  74:    */   protected void initialize() {}
/*  75:    */   
/*  76:    */   public Integer getId()
/*  77:    */   {
/*  78:112 */     return this.id;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public void setId(Integer id)
/*  82:    */   {
/*  83:120 */     this.id = id;
/*  84:121 */     this.hashCode = -2147483648;
/*  85:    */   }
/*  86:    */   
/*  87:    */   public String getTitle()
/*  88:    */   {
/*  89:131 */     return this.title;
/*  90:    */   }
/*  91:    */   
/*  92:    */   public void setTitle(String title)
/*  93:    */   {
/*  94:139 */     this.title = title;
/*  95:    */   }
/*  96:    */   
/*  97:    */   public Integer getStatus()
/*  98:    */   {
/*  99:148 */     return this.status;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public void setStatus(Integer status)
/* 103:    */   {
/* 104:156 */     this.status = status;
/* 105:    */   }
/* 106:    */   
/* 107:    */   public Boolean getAffix()
/* 108:    */   {
/* 109:165 */     return this.affix;
/* 110:    */   }
/* 111:    */   
/* 112:    */   public void setAffix(Boolean affix)
/* 113:    */   {
/* 114:173 */     this.affix = affix;
/* 115:    */   }
/* 116:    */   
/* 117:    */   public Boolean getImg()
/* 118:    */   {
/* 119:182 */     return this.img;
/* 120:    */   }
/* 121:    */   
/* 122:    */   public void setImg(Boolean img)
/* 123:    */   {
/* 124:190 */     this.img = img;
/* 125:    */   }
/* 126:    */   
/* 127:    */   public Boolean getHidden()
/* 128:    */   {
/* 129:199 */     return this.hidden;
/* 130:    */   }
/* 131:    */   
/* 132:    */   public void setHidden(Boolean hidden)
/* 133:    */   {
/* 134:207 */     this.hidden = hidden;
/* 135:    */   }
/* 136:    */   
/* 137:    */   public Integer getFloor()
/* 138:    */   {
/* 139:216 */     return this.floor;
/* 140:    */   }
/* 141:    */   
/* 142:    */   public void setFloor(Integer floor)
/* 143:    */   {
/* 144:224 */     this.floor = floor;
/* 145:    */   }
/* 146:    */   
/* 147:    */   public Date getCreateTime()
/* 148:    */   {
/* 149:233 */     return this.createTime;
/* 150:    */   }
/* 151:    */   
/* 152:    */   public void setCreateTime(Date createTime)
/* 153:    */   {
/* 154:241 */     this.createTime = createTime;
/* 155:    */   }
/* 156:    */   
/* 157:    */   public PostsExt getExt()
/* 158:    */   {
/* 159:250 */     return this.ext;
/* 160:    */   }
/* 161:    */   
/* 162:    */   public void setExt(PostsExt ext)
/* 163:    */   {
/* 164:258 */     this.ext = ext;
/* 165:    */   }
/* 166:    */   
/* 167:    */   public PostsTxt getTxt()
/* 168:    */   {
/* 169:267 */     return this.txt;
/* 170:    */   }
/* 171:    */   
/* 172:    */   public void setTxt(PostsTxt txt)
/* 173:    */   {
/* 174:275 */     this.txt = txt;
/* 175:    */   }
/* 176:    */   
/* 177:    */   public Theme getTheme()
/* 178:    */   {
/* 179:284 */     return this.theme;
/* 180:    */   }
/* 181:    */   
/* 182:    */   public void setTheme(Theme theme)
/* 183:    */   {
/* 184:292 */     this.theme = theme;
/* 185:    */   }
/* 186:    */   
/* 187:    */   public Posts getQuote()
/* 188:    */   {
/* 189:296 */     return this.quote;
/* 190:    */   }
/* 191:    */   
/* 192:    */   public void setQuote(Posts quote)
/* 193:    */   {
/* 194:300 */     this.quote = quote;
/* 195:    */   }
/* 196:    */   
/* 197:    */   public User getCreater()
/* 198:    */   {
/* 199:307 */     return this.creater;
/* 200:    */   }
/* 201:    */   
/* 202:    */   public void setCreater(User creater)
/* 203:    */   {
/* 204:315 */     this.creater = creater;
/* 205:    */   }
/* 206:    */   
/* 207:    */   public Site getSite()
/* 208:    */   {
/* 209:324 */     return this.site;
/* 210:    */   }
/* 211:    */   
/* 212:    */   public void setSite(Site site)
/* 213:    */   {
/* 214:332 */     this.site = site;
/* 215:    */   }
/* 216:    */   
/* 217:    */   public List<PostsAttach> getAttachs()
/* 218:    */   {
/* 219:341 */     return this.attachs;
/* 220:    */   }
/* 221:    */   
/* 222:    */   public void setAttachs(List<PostsAttach> attachs)
/* 223:    */   {
/* 224:349 */     this.attachs = attachs;
/* 225:    */   }
/* 226:    */   
/* 227:    */   public boolean equals(Object obj)
/* 228:    */   {
/* 229:355 */     if (obj == null) {
/* 230:355 */       return false;
/* 231:    */     }
/* 232:356 */     if (!(obj instanceof Posts)) {
/* 233:356 */       return false;
/* 234:    */     }
/* 235:358 */     Posts posts = (Posts)obj;
/* 236:359 */     if ((getId() == null) || (posts.getId() == null)) {
/* 237:359 */       return false;
/* 238:    */     }
/* 239:360 */     return getId().equals(posts.getId());
/* 240:    */   }
/* 241:    */   
/* 242:    */   public int hashCode()
/* 243:    */   {
/* 244:365 */     if (-2147483648 == this.hashCode)
/* 245:    */     {
/* 246:366 */       if (getId() == null) {
/* 247:366 */         return super.hashCode();
/* 248:    */       }
/* 249:368 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 250:369 */       this.hashCode = hashStr.hashCode();
/* 251:    */     }
/* 252:372 */     return this.hashCode;
/* 253:    */   }
/* 254:    */   
/* 255:    */   public String toString()
/* 256:    */   {
/* 257:377 */     return super.toString();
/* 258:    */   }
/* 259:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.entity.base.BasePosts
 * JD-Core Version:    0.7.0.1
 */