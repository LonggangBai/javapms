/*   1:    */ package com.portal.doccenter.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.doccenter.entity.Channel;
/*   4:    */ import com.portal.doccenter.entity.ChannelExt;
/*   5:    */ import com.portal.doccenter.entity.ChannelTxt;
/*   6:    */ import com.portal.doccenter.entity.ChnlTplSelection;
/*   7:    */ import com.portal.sysmgr.entity.Site;
/*   8:    */ import com.portal.usermgr.entity.Depart;
/*   9:    */ import com.portal.usermgr.entity.Group;
/*  10:    */ import java.io.Serializable;
/*  11:    */ import java.util.Set;
/*  12:    */ import java.util.TreeSet;
/*  13:    */ 
/*  14:    */ public abstract class BaseChannel
/*  15:    */   implements Serializable
/*  16:    */ {
/*  17: 19 */   public static String REF = "Channel";
/*  18: 20 */   public static String PROP_NAME = "name";
/*  19: 21 */   public static String PROP_PARENT = "parent";
/*  20: 22 */   public static String PROP_SITE = "site";
/*  21: 23 */   public static String PROP_TXT = "txt";
/*  22: 24 */   public static String PROP_EXT = "ext";
/*  23: 25 */   public static String PROP_NUMBER = "number";
/*  24: 26 */   public static String PROP_SHOW = "show";
/*  25: 27 */   public static String PROP_ID = "id";
/*  26: 28 */   public static String PROP_ALONE = "alone";
/*  27: 29 */   public static String PROP_PRIORITY = "priority";
/*  28: 30 */   public static String PROP_PATH = "path";
/*  29:    */   
/*  30:    */   public BaseChannel()
/*  31:    */   {
/*  32: 35 */     initialize();
/*  33:    */   }
/*  34:    */   
/*  35:    */   public BaseChannel(Integer id)
/*  36:    */   {
/*  37: 42 */     setId(id);
/*  38: 43 */     initialize();
/*  39:    */   }
/*  40:    */   
/*  41:    */   public BaseChannel(Integer id, Site site, String name, Integer priority, Boolean alone, Boolean show)
/*  42:    */   {
/*  43: 57 */     setId(id);
/*  44: 58 */     setSite(site);
/*  45: 59 */     setName(name);
/*  46: 60 */     setPriority(priority);
/*  47: 61 */     setAlone(alone);
/*  48: 62 */     setShow(show);
/*  49: 63 */     initialize();
/*  50:    */   }
/*  51:    */   
/*  52: 70 */   private int hashCode = -2147483648;
/*  53:    */   private Integer id;
/*  54:    */   private String name;
/*  55:    */   private String path;
/*  56:    */   private String number;
/*  57:    */   private Integer priority;
/*  58:    */   private Boolean alone;
/*  59:    */   private Boolean show;
/*  60:    */   private ChannelExt ext;
/*  61:    */   private ChannelTxt txt;
/*  62:    */   private Site site;
/*  63:    */   private Channel parent;
/*  64:    */   private Set<ChnlTplSelection> tpls;
/*  65:    */   private Set<Channel> child;
/*  66:    */   private Set<Group> viewGroups;
/*  67:    */   private Set<Group> contriGroups;
/*  68:    */   private Set<Depart> departs;
/*  69:    */   
/*  70:    */   protected void initialize() {}
/*  71:    */   
/*  72:    */   public Integer getId()
/*  73:    */   {
/*  74:107 */     return this.id;
/*  75:    */   }
/*  76:    */   
/*  77:    */   public void setId(Integer id)
/*  78:    */   {
/*  79:115 */     this.id = id;
/*  80:116 */     this.hashCode = -2147483648;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public String getName()
/*  84:    */   {
/*  85:126 */     return this.name;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public void setName(String name)
/*  89:    */   {
/*  90:134 */     this.name = name;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public String getPath()
/*  94:    */   {
/*  95:143 */     return this.path;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public void setPath(String path)
/*  99:    */   {
/* 100:151 */     this.path = path;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public String getNumber()
/* 104:    */   {
/* 105:160 */     return this.number;
/* 106:    */   }
/* 107:    */   
/* 108:    */   public void setNumber(String number)
/* 109:    */   {
/* 110:168 */     this.number = number;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public Integer getPriority()
/* 114:    */   {
/* 115:177 */     return this.priority;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public void setPriority(Integer priority)
/* 119:    */   {
/* 120:185 */     this.priority = priority;
/* 121:    */   }
/* 122:    */   
/* 123:    */   public Boolean getAlone()
/* 124:    */   {
/* 125:194 */     return this.alone;
/* 126:    */   }
/* 127:    */   
/* 128:    */   public void setAlone(Boolean alone)
/* 129:    */   {
/* 130:202 */     this.alone = alone;
/* 131:    */   }
/* 132:    */   
/* 133:    */   public Boolean getShow()
/* 134:    */   {
/* 135:211 */     return this.show;
/* 136:    */   }
/* 137:    */   
/* 138:    */   public void setShow(Boolean show)
/* 139:    */   {
/* 140:219 */     this.show = show;
/* 141:    */   }
/* 142:    */   
/* 143:    */   public ChannelExt getExt()
/* 144:    */   {
/* 145:228 */     return this.ext;
/* 146:    */   }
/* 147:    */   
/* 148:    */   public void setExt(ChannelExt ext)
/* 149:    */   {
/* 150:236 */     this.ext = ext;
/* 151:    */   }
/* 152:    */   
/* 153:    */   public ChannelTxt getTxt()
/* 154:    */   {
/* 155:245 */     return this.txt;
/* 156:    */   }
/* 157:    */   
/* 158:    */   public void setTxt(ChannelTxt txt)
/* 159:    */   {
/* 160:253 */     this.txt = txt;
/* 161:    */   }
/* 162:    */   
/* 163:    */   public Site getSite()
/* 164:    */   {
/* 165:262 */     return this.site;
/* 166:    */   }
/* 167:    */   
/* 168:    */   public void setSite(Site site)
/* 169:    */   {
/* 170:270 */     this.site = site;
/* 171:    */   }
/* 172:    */   
/* 173:    */   public Channel getParent()
/* 174:    */   {
/* 175:279 */     return this.parent;
/* 176:    */   }
/* 177:    */   
/* 178:    */   public void setParent(Channel parent)
/* 179:    */   {
/* 180:287 */     this.parent = parent;
/* 181:    */   }
/* 182:    */   
/* 183:    */   public Set<ChnlTplSelection> getTpls()
/* 184:    */   {
/* 185:296 */     return this.tpls;
/* 186:    */   }
/* 187:    */   
/* 188:    */   public void setTpls(Set<ChnlTplSelection> tpls)
/* 189:    */   {
/* 190:304 */     this.tpls = tpls;
/* 191:    */   }
/* 192:    */   
/* 193:    */   public Set<Channel> getChild()
/* 194:    */   {
/* 195:313 */     return this.child;
/* 196:    */   }
/* 197:    */   
/* 198:    */   public void setChild(Set<Channel> child)
/* 199:    */   {
/* 200:321 */     this.child = child;
/* 201:    */   }
/* 202:    */   
/* 203:    */   public void addTochild(Channel channel)
/* 204:    */   {
/* 205:325 */     if (getChild() == null) {
/* 206:325 */       setChild(new TreeSet());
/* 207:    */     }
/* 208:326 */     getChild().add(channel);
/* 209:    */   }
/* 210:    */   
/* 211:    */   public Set<Group> getViewGroups()
/* 212:    */   {
/* 213:335 */     return this.viewGroups;
/* 214:    */   }
/* 215:    */   
/* 216:    */   public void setViewGroups(Set<Group> viewGroups)
/* 217:    */   {
/* 218:343 */     this.viewGroups = viewGroups;
/* 219:    */   }
/* 220:    */   
/* 221:    */   public Set<Group> getContriGroups()
/* 222:    */   {
/* 223:352 */     return this.contriGroups;
/* 224:    */   }
/* 225:    */   
/* 226:    */   public void setContriGroups(Set<Group> contriGroups)
/* 227:    */   {
/* 228:360 */     this.contriGroups = contriGroups;
/* 229:    */   }
/* 230:    */   
/* 231:    */   public Set<Depart> getDeparts()
/* 232:    */   {
/* 233:369 */     return this.departs;
/* 234:    */   }
/* 235:    */   
/* 236:    */   public void setDeparts(Set<Depart> departs)
/* 237:    */   {
/* 238:377 */     this.departs = departs;
/* 239:    */   }
/* 240:    */   
/* 241:    */   public boolean equals(Object obj)
/* 242:    */   {
/* 243:384 */     if (obj == null) {
/* 244:384 */       return false;
/* 245:    */     }
/* 246:385 */     if (!(obj instanceof Channel)) {
/* 247:385 */       return false;
/* 248:    */     }
/* 249:387 */     Channel channel = (Channel)obj;
/* 250:388 */     if ((getId() == null) || (channel.getId() == null)) {
/* 251:388 */       return false;
/* 252:    */     }
/* 253:389 */     return getId().equals(channel.getId());
/* 254:    */   }
/* 255:    */   
/* 256:    */   public int hashCode()
/* 257:    */   {
/* 258:394 */     if (-2147483648 == this.hashCode)
/* 259:    */     {
/* 260:395 */       if (getId() == null) {
/* 261:395 */         return super.hashCode();
/* 262:    */       }
/* 263:397 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 264:398 */       this.hashCode = hashStr.hashCode();
/* 265:    */     }
/* 266:401 */     return this.hashCode;
/* 267:    */   }
/* 268:    */   
/* 269:    */   public String toString()
/* 270:    */   {
/* 271:406 */     return super.toString();
/* 272:    */   }
/* 273:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.entity.base.BaseChannel
 * JD-Core Version:    0.7.0.1
 */