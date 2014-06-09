/*   1:    */ package com.portal.govcenter.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.govcenter.entity.Mailbox;
/*   4:    */ import com.portal.govcenter.entity.MailboxExt;
/*   5:    */ import com.portal.govcenter.entity.MailboxType;
/*   6:    */ import com.portal.sysmgr.entity.Site;
/*   7:    */ import com.portal.usermgr.entity.Depart;
/*   8:    */ import java.io.Serializable;
/*   9:    */ import java.util.Date;
/*  10:    */ 
/*  11:    */ public abstract class BaseMailbox
/*  12:    */   implements Serializable
/*  13:    */ {
/*  14: 17 */   public static String REF = "Mailbox";
/*  15: 18 */   public static String PROP_SITE = "site";
/*  16: 19 */   public static String PROP_TYPE = "type";
/*  17: 20 */   public static String PROP_SHOW = "show";
/*  18: 21 */   public static String PROP_ZIPCODE = "zipcode";
/*  19: 22 */   public static String PROP_TITLE = "title";
/*  20: 23 */   public static String PROP_NAME = "name";
/*  21: 24 */   public static String PROP_DEPART = "depart";
/*  22: 25 */   public static String PROP_STATUS = "status";
/*  23: 26 */   public static String PROP_EMAIL = "email";
/*  24: 27 */   public static String PROP_EXT = "ext";
/*  25: 28 */   public static String PROP_REPLY_TIME = "replyTime";
/*  26: 29 */   public static String PROP_ADDRESS = "address";
/*  27: 30 */   public static String PROP_CREATE_TIME = "createTime";
/*  28: 31 */   public static String PROP_MOBILE = "mobile";
/*  29: 32 */   public static String PROP_ID = "id";
/*  30:    */   
/*  31:    */   public BaseMailbox()
/*  32:    */   {
/*  33: 37 */     initialize();
/*  34:    */   }
/*  35:    */   
/*  36:    */   public BaseMailbox(Integer id)
/*  37:    */   {
/*  38: 44 */     setId(id);
/*  39: 45 */     initialize();
/*  40:    */   }
/*  41:    */   
/*  42:    */   public BaseMailbox(Integer id, Site site, Depart depart, MailboxType type, String title, String name, String mobile, String email, Byte status, Boolean show, Date createTime)
/*  43:    */   {
/*  44: 64 */     setId(id);
/*  45: 65 */     setSite(site);
/*  46: 66 */     setDepart(depart);
/*  47: 67 */     setType(type);
/*  48: 68 */     setTitle(title);
/*  49: 69 */     setName(name);
/*  50: 70 */     setMobile(mobile);
/*  51: 71 */     setEmail(email);
/*  52: 72 */     setStatus(status);
/*  53: 73 */     setShow(show);
/*  54: 74 */     setCreateTime(createTime);
/*  55: 75 */     initialize();
/*  56:    */   }
/*  57:    */   
/*  58: 82 */   private int hashCode = -2147483648;
/*  59:    */   private Integer id;
/*  60:    */   private String title;
/*  61:    */   private String name;
/*  62:    */   private String mobile;
/*  63:    */   private String email;
/*  64:    */   private String address;
/*  65:    */   private String zipcode;
/*  66:    */   private Byte status;
/*  67:    */   private Boolean show;
/*  68:    */   private Date createTime;
/*  69:    */   private Date replyTime;
/*  70:    */   private MailboxExt ext;
/*  71:    */   private Site site;
/*  72:    */   private Depart depart;
/*  73:    */   private MailboxType type;
/*  74:    */   
/*  75:    */   protected void initialize() {}
/*  76:    */   
/*  77:    */   public Integer getId()
/*  78:    */   {
/*  79:116 */     return this.id;
/*  80:    */   }
/*  81:    */   
/*  82:    */   public void setId(Integer id)
/*  83:    */   {
/*  84:124 */     this.id = id;
/*  85:125 */     this.hashCode = -2147483648;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public String getTitle()
/*  89:    */   {
/*  90:135 */     return this.title;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public void setTitle(String title)
/*  94:    */   {
/*  95:143 */     this.title = title;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public String getName()
/*  99:    */   {
/* 100:152 */     return this.name;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public void setName(String name)
/* 104:    */   {
/* 105:160 */     this.name = name;
/* 106:    */   }
/* 107:    */   
/* 108:    */   public String getMobile()
/* 109:    */   {
/* 110:169 */     return this.mobile;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public void setMobile(String mobile)
/* 114:    */   {
/* 115:177 */     this.mobile = mobile;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public String getEmail()
/* 119:    */   {
/* 120:186 */     return this.email;
/* 121:    */   }
/* 122:    */   
/* 123:    */   public void setEmail(String email)
/* 124:    */   {
/* 125:194 */     this.email = email;
/* 126:    */   }
/* 127:    */   
/* 128:    */   public String getAddress()
/* 129:    */   {
/* 130:203 */     return this.address;
/* 131:    */   }
/* 132:    */   
/* 133:    */   public void setAddress(String address)
/* 134:    */   {
/* 135:211 */     this.address = address;
/* 136:    */   }
/* 137:    */   
/* 138:    */   public String getZipcode()
/* 139:    */   {
/* 140:220 */     return this.zipcode;
/* 141:    */   }
/* 142:    */   
/* 143:    */   public void setZipcode(String zipcode)
/* 144:    */   {
/* 145:228 */     this.zipcode = zipcode;
/* 146:    */   }
/* 147:    */   
/* 148:    */   public Byte getStatus()
/* 149:    */   {
/* 150:237 */     return this.status;
/* 151:    */   }
/* 152:    */   
/* 153:    */   public void setStatus(Byte status)
/* 154:    */   {
/* 155:245 */     this.status = status;
/* 156:    */   }
/* 157:    */   
/* 158:    */   public Boolean getShow()
/* 159:    */   {
/* 160:254 */     return this.show;
/* 161:    */   }
/* 162:    */   
/* 163:    */   public void setShow(Boolean show)
/* 164:    */   {
/* 165:262 */     this.show = show;
/* 166:    */   }
/* 167:    */   
/* 168:    */   public Date getCreateTime()
/* 169:    */   {
/* 170:271 */     return this.createTime;
/* 171:    */   }
/* 172:    */   
/* 173:    */   public void setCreateTime(Date createTime)
/* 174:    */   {
/* 175:279 */     this.createTime = createTime;
/* 176:    */   }
/* 177:    */   
/* 178:    */   public Date getReplyTime()
/* 179:    */   {
/* 180:288 */     return this.replyTime;
/* 181:    */   }
/* 182:    */   
/* 183:    */   public void setReplyTime(Date replyTime)
/* 184:    */   {
/* 185:296 */     this.replyTime = replyTime;
/* 186:    */   }
/* 187:    */   
/* 188:    */   public MailboxExt getExt()
/* 189:    */   {
/* 190:305 */     return this.ext;
/* 191:    */   }
/* 192:    */   
/* 193:    */   public void setExt(MailboxExt ext)
/* 194:    */   {
/* 195:313 */     this.ext = ext;
/* 196:    */   }
/* 197:    */   
/* 198:    */   public Site getSite()
/* 199:    */   {
/* 200:322 */     return this.site;
/* 201:    */   }
/* 202:    */   
/* 203:    */   public void setSite(Site site)
/* 204:    */   {
/* 205:330 */     this.site = site;
/* 206:    */   }
/* 207:    */   
/* 208:    */   public Depart getDepart()
/* 209:    */   {
/* 210:339 */     return this.depart;
/* 211:    */   }
/* 212:    */   
/* 213:    */   public void setDepart(Depart depart)
/* 214:    */   {
/* 215:347 */     this.depart = depart;
/* 216:    */   }
/* 217:    */   
/* 218:    */   public MailboxType getType()
/* 219:    */   {
/* 220:356 */     return this.type;
/* 221:    */   }
/* 222:    */   
/* 223:    */   public void setType(MailboxType type)
/* 224:    */   {
/* 225:364 */     this.type = type;
/* 226:    */   }
/* 227:    */   
/* 228:    */   public boolean equals(Object obj)
/* 229:    */   {
/* 230:371 */     if (obj == null) {
/* 231:371 */       return false;
/* 232:    */     }
/* 233:372 */     if (!(obj instanceof Mailbox)) {
/* 234:372 */       return false;
/* 235:    */     }
/* 236:374 */     Mailbox mailbox = (Mailbox)obj;
/* 237:375 */     if ((getId() == null) || (mailbox.getId() == null)) {
/* 238:375 */       return false;
/* 239:    */     }
/* 240:376 */     return getId().equals(mailbox.getId());
/* 241:    */   }
/* 242:    */   
/* 243:    */   public int hashCode()
/* 244:    */   {
/* 245:381 */     if (-2147483648 == this.hashCode)
/* 246:    */     {
/* 247:382 */       if (getId() == null) {
/* 248:382 */         return super.hashCode();
/* 249:    */       }
/* 250:384 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 251:385 */       this.hashCode = hashStr.hashCode();
/* 252:    */     }
/* 253:388 */     return this.hashCode;
/* 254:    */   }
/* 255:    */   
/* 256:    */   public String toString()
/* 257:    */   {
/* 258:393 */     return super.toString();
/* 259:    */   }
/* 260:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.govcenter.entity.base.BaseMailbox
 * JD-Core Version:    0.7.0.1
 */