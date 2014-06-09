/*   1:    */ package com.portal.govcenter.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.govcenter.entity.Petition;
/*   4:    */ import com.portal.govcenter.entity.PetitionExt;
/*   5:    */ import com.portal.govcenter.entity.PetitionType;
/*   6:    */ import com.portal.sysmgr.entity.Site;
/*   7:    */ import java.io.Serializable;
/*   8:    */ import java.util.Date;
/*   9:    */ 
/*  10:    */ public abstract class BasePetition
/*  11:    */   implements Serializable
/*  12:    */ {
/*  13: 17 */   public static String REF = "Petition";
/*  14: 18 */   public static String PROP_SITE = "site";
/*  15: 19 */   public static String PROP_TYPE = "type";
/*  16: 20 */   public static String PROP_SHOW = "show";
/*  17: 21 */   public static String PROP_ZIPCODE = "zipcode";
/*  18: 22 */   public static String PROP_TITLE = "title";
/*  19: 23 */   public static String PROP_NAME = "name";
/*  20: 24 */   public static String PROP_STATUS = "status";
/*  21: 25 */   public static String PROP_EMAIL = "email";
/*  22: 26 */   public static String PROP_EXT = "ext";
/*  23: 27 */   public static String PROP_REPLY_TIME = "replyTime";
/*  24: 28 */   public static String PROP_ADDRESS = "address";
/*  25: 29 */   public static String PROP_CREATE_TIME = "createTime";
/*  26: 30 */   public static String PROP_MOBILE = "mobile";
/*  27: 31 */   public static String PROP_ID = "id";
/*  28:    */   
/*  29:    */   public BasePetition()
/*  30:    */   {
/*  31: 36 */     initialize();
/*  32:    */   }
/*  33:    */   
/*  34:    */   public BasePetition(Integer id)
/*  35:    */   {
/*  36: 43 */     setId(id);
/*  37: 44 */     initialize();
/*  38:    */   }
/*  39:    */   
/*  40:    */   public BasePetition(Integer id, Site site, PetitionType type, String title, String name, String mobile, String email, Byte status, Boolean show, Date createTime)
/*  41:    */   {
/*  42: 62 */     setId(id);
/*  43: 63 */     setSite(site);
/*  44: 64 */     setType(type);
/*  45: 65 */     setTitle(title);
/*  46: 66 */     setName(name);
/*  47: 67 */     setMobile(mobile);
/*  48: 68 */     setEmail(email);
/*  49: 69 */     setStatus(status);
/*  50: 70 */     setShow(show);
/*  51: 71 */     setCreateTime(createTime);
/*  52: 72 */     initialize();
/*  53:    */   }
/*  54:    */   
/*  55: 79 */   private int hashCode = -2147483648;
/*  56:    */   private Integer id;
/*  57:    */   private String title;
/*  58:    */   private String name;
/*  59:    */   private String mobile;
/*  60:    */   private String email;
/*  61:    */   private String address;
/*  62:    */   private String zipcode;
/*  63:    */   private Byte status;
/*  64:    */   private Boolean show;
/*  65:    */   private Date createTime;
/*  66:    */   private Date replyTime;
/*  67:    */   private PetitionExt ext;
/*  68:    */   private Site site;
/*  69:    */   private PetitionType type;
/*  70:    */   
/*  71:    */   protected void initialize() {}
/*  72:    */   
/*  73:    */   public Integer getId()
/*  74:    */   {
/*  75:112 */     return this.id;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public void setId(Integer id)
/*  79:    */   {
/*  80:120 */     this.id = id;
/*  81:121 */     this.hashCode = -2147483648;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public String getTitle()
/*  85:    */   {
/*  86:131 */     return this.title;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public void setTitle(String title)
/*  90:    */   {
/*  91:139 */     this.title = title;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public String getName()
/*  95:    */   {
/*  96:148 */     return this.name;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public void setName(String name)
/* 100:    */   {
/* 101:156 */     this.name = name;
/* 102:    */   }
/* 103:    */   
/* 104:    */   public String getMobile()
/* 105:    */   {
/* 106:165 */     return this.mobile;
/* 107:    */   }
/* 108:    */   
/* 109:    */   public void setMobile(String mobile)
/* 110:    */   {
/* 111:173 */     this.mobile = mobile;
/* 112:    */   }
/* 113:    */   
/* 114:    */   public String getEmail()
/* 115:    */   {
/* 116:182 */     return this.email;
/* 117:    */   }
/* 118:    */   
/* 119:    */   public void setEmail(String email)
/* 120:    */   {
/* 121:190 */     this.email = email;
/* 122:    */   }
/* 123:    */   
/* 124:    */   public String getAddress()
/* 125:    */   {
/* 126:199 */     return this.address;
/* 127:    */   }
/* 128:    */   
/* 129:    */   public void setAddress(String address)
/* 130:    */   {
/* 131:207 */     this.address = address;
/* 132:    */   }
/* 133:    */   
/* 134:    */   public String getZipcode()
/* 135:    */   {
/* 136:216 */     return this.zipcode;
/* 137:    */   }
/* 138:    */   
/* 139:    */   public void setZipcode(String zipcode)
/* 140:    */   {
/* 141:224 */     this.zipcode = zipcode;
/* 142:    */   }
/* 143:    */   
/* 144:    */   public Byte getStatus()
/* 145:    */   {
/* 146:233 */     return this.status;
/* 147:    */   }
/* 148:    */   
/* 149:    */   public void setStatus(Byte status)
/* 150:    */   {
/* 151:241 */     this.status = status;
/* 152:    */   }
/* 153:    */   
/* 154:    */   public Boolean isShow()
/* 155:    */   {
/* 156:250 */     return this.show;
/* 157:    */   }
/* 158:    */   
/* 159:    */   public void setShow(Boolean show)
/* 160:    */   {
/* 161:258 */     this.show = show;
/* 162:    */   }
/* 163:    */   
/* 164:    */   public Date getCreateTime()
/* 165:    */   {
/* 166:267 */     return this.createTime;
/* 167:    */   }
/* 168:    */   
/* 169:    */   public void setCreateTime(Date createTime)
/* 170:    */   {
/* 171:275 */     this.createTime = createTime;
/* 172:    */   }
/* 173:    */   
/* 174:    */   public Date getReplyTime()
/* 175:    */   {
/* 176:284 */     return this.replyTime;
/* 177:    */   }
/* 178:    */   
/* 179:    */   public void setReplyTime(Date replyTime)
/* 180:    */   {
/* 181:292 */     this.replyTime = replyTime;
/* 182:    */   }
/* 183:    */   
/* 184:    */   public PetitionExt getExt()
/* 185:    */   {
/* 186:301 */     return this.ext;
/* 187:    */   }
/* 188:    */   
/* 189:    */   public void setExt(PetitionExt ext)
/* 190:    */   {
/* 191:309 */     this.ext = ext;
/* 192:    */   }
/* 193:    */   
/* 194:    */   public Site getSite()
/* 195:    */   {
/* 196:318 */     return this.site;
/* 197:    */   }
/* 198:    */   
/* 199:    */   public void setSite(Site site)
/* 200:    */   {
/* 201:326 */     this.site = site;
/* 202:    */   }
/* 203:    */   
/* 204:    */   public PetitionType getType()
/* 205:    */   {
/* 206:335 */     return this.type;
/* 207:    */   }
/* 208:    */   
/* 209:    */   public void setType(PetitionType type)
/* 210:    */   {
/* 211:343 */     this.type = type;
/* 212:    */   }
/* 213:    */   
/* 214:    */   public boolean equals(Object obj)
/* 215:    */   {
/* 216:350 */     if (obj == null) {
/* 217:350 */       return false;
/* 218:    */     }
/* 219:351 */     if (!(obj instanceof Petition)) {
/* 220:351 */       return false;
/* 221:    */     }
/* 222:353 */     Petition petition = (Petition)obj;
/* 223:354 */     if ((getId() == null) || (petition.getId() == null)) {
/* 224:354 */       return false;
/* 225:    */     }
/* 226:355 */     return getId().equals(petition.getId());
/* 227:    */   }
/* 228:    */   
/* 229:    */   public int hashCode()
/* 230:    */   {
/* 231:360 */     if (-2147483648 == this.hashCode)
/* 232:    */     {
/* 233:361 */       if (getId() == null) {
/* 234:361 */         return super.hashCode();
/* 235:    */       }
/* 236:363 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 237:364 */       this.hashCode = hashStr.hashCode();
/* 238:    */     }
/* 239:367 */     return this.hashCode;
/* 240:    */   }
/* 241:    */   
/* 242:    */   public String toString()
/* 243:    */   {
/* 244:372 */     return super.toString();
/* 245:    */   }
/* 246:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.govcenter.entity.base.BasePetition
 * JD-Core Version:    0.7.0.1
 */