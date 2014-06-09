/*   1:    */ package com.portal.extrafunc.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.extrafunc.entity.MessageBoard;
/*   4:    */ import com.portal.extrafunc.entity.MessageBoardExt;
/*   5:    */ import com.portal.extrafunc.entity.MessageType;
/*   6:    */ import com.portal.sysmgr.entity.Site;
/*   7:    */ import java.io.Serializable;
/*   8:    */ import java.util.Date;
/*   9:    */ 
/*  10:    */ public abstract class BaseMessageBoard
/*  11:    */   implements Serializable
/*  12:    */ {
/*  13: 15 */   public static String REF = "MessageBoard";
/*  14: 16 */   public static String PROP_SITE = "site";
/*  15: 17 */   public static String PROP_TYPE = "type";
/*  16: 18 */   public static String PROP_SHOW = "show";
/*  17: 19 */   public static String PROP_ZIPCODE = "zipcode";
/*  18: 20 */   public static String PROP_TITLE = "title";
/*  19: 21 */   public static String PROP_NAME = "name";
/*  20: 22 */   public static String PROP_EMAIL = "email";
/*  21: 23 */   public static String PROP_EXT = "ext";
/*  22: 24 */   public static String PROP_REPLY_TIME = "replyTime";
/*  23: 25 */   public static String PROP_ADDRESS = "address";
/*  24: 26 */   public static String PROP_CREATE_TIME = "createTime";
/*  25: 27 */   public static String PROP_MOBILE = "mobile";
/*  26: 28 */   public static String PROP_ID = "id";
/*  27:    */   
/*  28:    */   public BaseMessageBoard()
/*  29:    */   {
/*  30: 32 */     initialize();
/*  31:    */   }
/*  32:    */   
/*  33:    */   public BaseMessageBoard(Integer id)
/*  34:    */   {
/*  35: 39 */     setId(id);
/*  36: 40 */     initialize();
/*  37:    */   }
/*  38:    */   
/*  39:    */   public BaseMessageBoard(Integer id, Site site, MessageType type, String title, String name, String mobile, String email, Boolean show, Date createTime)
/*  40:    */   {
/*  41: 53 */     setId(id);
/*  42: 54 */     setSite(site);
/*  43: 55 */     setType(type);
/*  44: 56 */     setTitle(title);
/*  45: 57 */     setName(name);
/*  46: 58 */     setMobile(mobile);
/*  47: 59 */     setEmail(email);
/*  48: 60 */     setShow(show);
/*  49: 61 */     setCreateTime(createTime);
/*  50: 62 */     initialize();
/*  51:    */   }
/*  52:    */   
/*  53: 68 */   private int hashCode = -2147483648;
/*  54:    */   private Integer id;
/*  55:    */   private String title;
/*  56:    */   private String name;
/*  57:    */   private String mobile;
/*  58:    */   private String email;
/*  59:    */   private String address;
/*  60:    */   private String zipcode;
/*  61:    */   private Boolean show;
/*  62:    */   private Date createTime;
/*  63:    */   private Date replyTime;
/*  64:    */   private MessageBoardExt ext;
/*  65:    */   private Site site;
/*  66:    */   private MessageType type;
/*  67:    */   
/*  68:    */   protected void initialize() {}
/*  69:    */   
/*  70:    */   public Integer getId()
/*  71:    */   {
/*  72: 97 */     return this.id;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public void setId(Integer id)
/*  76:    */   {
/*  77:107 */     this.id = id;
/*  78:108 */     this.hashCode = -2147483648;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public String getTitle()
/*  82:    */   {
/*  83:115 */     return this.title;
/*  84:    */   }
/*  85:    */   
/*  86:    */   public void setTitle(String title)
/*  87:    */   {
/*  88:125 */     this.title = title;
/*  89:    */   }
/*  90:    */   
/*  91:    */   public String getName()
/*  92:    */   {
/*  93:132 */     return this.name;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public void setName(String name)
/*  97:    */   {
/*  98:142 */     this.name = name;
/*  99:    */   }
/* 100:    */   
/* 101:    */   public String getMobile()
/* 102:    */   {
/* 103:149 */     return this.mobile;
/* 104:    */   }
/* 105:    */   
/* 106:    */   public void setMobile(String mobile)
/* 107:    */   {
/* 108:159 */     this.mobile = mobile;
/* 109:    */   }
/* 110:    */   
/* 111:    */   public String getEmail()
/* 112:    */   {
/* 113:166 */     return this.email;
/* 114:    */   }
/* 115:    */   
/* 116:    */   public void setEmail(String email)
/* 117:    */   {
/* 118:176 */     this.email = email;
/* 119:    */   }
/* 120:    */   
/* 121:    */   public String getAddress()
/* 122:    */   {
/* 123:183 */     return this.address;
/* 124:    */   }
/* 125:    */   
/* 126:    */   public void setAddress(String address)
/* 127:    */   {
/* 128:193 */     this.address = address;
/* 129:    */   }
/* 130:    */   
/* 131:    */   public String getZipcode()
/* 132:    */   {
/* 133:200 */     return this.zipcode;
/* 134:    */   }
/* 135:    */   
/* 136:    */   public void setZipcode(String zipcode)
/* 137:    */   {
/* 138:210 */     this.zipcode = zipcode;
/* 139:    */   }
/* 140:    */   
/* 141:    */   public Boolean getShow()
/* 142:    */   {
/* 143:217 */     return this.show;
/* 144:    */   }
/* 145:    */   
/* 146:    */   public void setShow(Boolean show)
/* 147:    */   {
/* 148:227 */     this.show = show;
/* 149:    */   }
/* 150:    */   
/* 151:    */   public Date getCreateTime()
/* 152:    */   {
/* 153:234 */     return this.createTime;
/* 154:    */   }
/* 155:    */   
/* 156:    */   public void setCreateTime(Date createTime)
/* 157:    */   {
/* 158:244 */     this.createTime = createTime;
/* 159:    */   }
/* 160:    */   
/* 161:    */   public Date getReplyTime()
/* 162:    */   {
/* 163:251 */     return this.replyTime;
/* 164:    */   }
/* 165:    */   
/* 166:    */   public void setReplyTime(Date replyTime)
/* 167:    */   {
/* 168:261 */     this.replyTime = replyTime;
/* 169:    */   }
/* 170:    */   
/* 171:    */   public MessageBoardExt getExt()
/* 172:    */   {
/* 173:268 */     return this.ext;
/* 174:    */   }
/* 175:    */   
/* 176:    */   public void setExt(MessageBoardExt ext)
/* 177:    */   {
/* 178:278 */     this.ext = ext;
/* 179:    */   }
/* 180:    */   
/* 181:    */   public Site getSite()
/* 182:    */   {
/* 183:285 */     return this.site;
/* 184:    */   }
/* 185:    */   
/* 186:    */   public void setSite(Site site)
/* 187:    */   {
/* 188:295 */     this.site = site;
/* 189:    */   }
/* 190:    */   
/* 191:    */   public MessageType getType()
/* 192:    */   {
/* 193:302 */     return this.type;
/* 194:    */   }
/* 195:    */   
/* 196:    */   public void setType(MessageType type)
/* 197:    */   {
/* 198:312 */     this.type = type;
/* 199:    */   }
/* 200:    */   
/* 201:    */   public boolean equals(Object obj)
/* 202:    */   {
/* 203:316 */     if (obj == null) {
/* 204:317 */       return false;
/* 205:    */     }
/* 206:318 */     if (!(obj instanceof MessageBoard)) {
/* 207:319 */       return false;
/* 208:    */     }
/* 209:321 */     MessageBoard messageBoard = (MessageBoard)obj;
/* 210:322 */     if ((getId() == null) || (messageBoard.getId() == null)) {
/* 211:323 */       return false;
/* 212:    */     }
/* 213:325 */     return getId().equals(messageBoard.getId());
/* 214:    */   }
/* 215:    */   
/* 216:    */   public int hashCode()
/* 217:    */   {
/* 218:330 */     if (-2147483648 == this.hashCode)
/* 219:    */     {
/* 220:331 */       if (getId() == null) {
/* 221:332 */         return super.hashCode();
/* 222:    */       }
/* 223:334 */       String hashStr = getClass().getName() + ":" + 
/* 224:335 */         getId().hashCode();
/* 225:336 */       this.hashCode = hashStr.hashCode();
/* 226:    */     }
/* 227:339 */     return this.hashCode;
/* 228:    */   }
/* 229:    */   
/* 230:    */   public String toString()
/* 231:    */   {
/* 232:343 */     return super.toString();
/* 233:    */   }
/* 234:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.entity.base.BaseMessageBoard
 * JD-Core Version:    0.7.0.1
 */