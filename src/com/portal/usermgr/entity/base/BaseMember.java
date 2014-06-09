/*   1:    */ package com.portal.usermgr.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.usermgr.entity.Group;
/*   4:    */ import com.portal.usermgr.entity.Member;
/*   5:    */ import com.portal.usermgr.entity.User;
/*   6:    */ import java.io.Serializable;
/*   7:    */ import java.util.Date;
/*   8:    */ import java.util.Set;
/*   9:    */ import java.util.TreeSet;
/*  10:    */ 
/*  11:    */ public abstract class BaseMember
/*  12:    */   implements Serializable
/*  13:    */ {
/*  14: 17 */   public static String REF = "Member";
/*  15: 18 */   public static String PROP_USER = "user";
/*  16: 19 */   public static String PROP_AVATAR = "avatar";
/*  17: 20 */   public static String PROP_SIGNATURE = "signature";
/*  18: 21 */   public static String PROP_LOGIN_COUNT = "loginCount";
/*  19: 22 */   public static String PROP_STATUS = "status";
/*  20: 23 */   public static String PROP_BIRTHDAY = "birthday";
/*  21: 24 */   public static String PROP_LAST_LOGIN_TIME = "lastLoginTime";
/*  22: 25 */   public static String PROP_REGISTER_TIME = "registerTime";
/*  23: 26 */   public static String PROP_GENDER = "gender";
/*  24: 27 */   public static String PROP_ADDRESS = "address";
/*  25: 28 */   public static String PROP_REGISTER_IP = "registerIp";
/*  26: 29 */   public static String PROP_ID = "id";
/*  27: 30 */   public static String PROP_LAST_LOGIN_IP = "lastLoginIp";
/*  28:    */   
/*  29:    */   public BaseMember()
/*  30:    */   {
/*  31: 35 */     initialize();
/*  32:    */   }
/*  33:    */   
/*  34:    */   public BaseMember(Integer id)
/*  35:    */   {
/*  36: 42 */     setId(id);
/*  37: 43 */     initialize();
/*  38:    */   }
/*  39:    */   
/*  40:    */   public BaseMember(Integer id, Date registerTime, String registerIp, Integer loginCount, Byte status)
/*  41:    */   {
/*  42: 56 */     setId(id);
/*  43: 57 */     setRegisterTime(registerTime);
/*  44: 58 */     setRegisterIp(registerIp);
/*  45: 59 */     setLoginCount(loginCount);
/*  46: 60 */     setStatus(status);
/*  47: 61 */     initialize();
/*  48:    */   }
/*  49:    */   
/*  50: 68 */   private int hashCode = -2147483648;
/*  51:    */   private Integer id;
/*  52:    */   private String avatar;
/*  53:    */   private Byte gender;
/*  54:    */   private Date birthday;
/*  55:    */   private String address;
/*  56:    */   private String signature;
/*  57:    */   private Date registerTime;
/*  58:    */   private String registerIp;
/*  59:    */   private Date lastLoginTime;
/*  60:    */   private String lastLoginIp;
/*  61:    */   private Integer loginCount;
/*  62:    */   private Byte status;
/*  63:    */   private User user;
/*  64:    */   private Set<Group> groups;
/*  65:    */   
/*  66:    */   protected void initialize() {}
/*  67:    */   
/*  68:    */   public Integer getId()
/*  69:    */   {
/*  70:101 */     return this.id;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public void setId(Integer id)
/*  74:    */   {
/*  75:109 */     this.id = id;
/*  76:110 */     this.hashCode = -2147483648;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public String getAvatar()
/*  80:    */   {
/*  81:120 */     return this.avatar;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public void setAvatar(String avatar)
/*  85:    */   {
/*  86:128 */     this.avatar = avatar;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public Byte getGender()
/*  90:    */   {
/*  91:137 */     return this.gender;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public void setGender(Byte gender)
/*  95:    */   {
/*  96:145 */     this.gender = gender;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public Date getBirthday()
/* 100:    */   {
/* 101:154 */     return this.birthday;
/* 102:    */   }
/* 103:    */   
/* 104:    */   public void setBirthday(Date birthday)
/* 105:    */   {
/* 106:162 */     this.birthday = birthday;
/* 107:    */   }
/* 108:    */   
/* 109:    */   public String getAddress()
/* 110:    */   {
/* 111:171 */     return this.address;
/* 112:    */   }
/* 113:    */   
/* 114:    */   public void setAddress(String address)
/* 115:    */   {
/* 116:179 */     this.address = address;
/* 117:    */   }
/* 118:    */   
/* 119:    */   public String getSignature()
/* 120:    */   {
/* 121:188 */     return this.signature;
/* 122:    */   }
/* 123:    */   
/* 124:    */   public void setSignature(String signature)
/* 125:    */   {
/* 126:196 */     this.signature = signature;
/* 127:    */   }
/* 128:    */   
/* 129:    */   public Date getRegisterTime()
/* 130:    */   {
/* 131:205 */     return this.registerTime;
/* 132:    */   }
/* 133:    */   
/* 134:    */   public void setRegisterTime(Date registerTime)
/* 135:    */   {
/* 136:213 */     this.registerTime = registerTime;
/* 137:    */   }
/* 138:    */   
/* 139:    */   public String getRegisterIp()
/* 140:    */   {
/* 141:222 */     return this.registerIp;
/* 142:    */   }
/* 143:    */   
/* 144:    */   public void setRegisterIp(String registerIp)
/* 145:    */   {
/* 146:230 */     this.registerIp = registerIp;
/* 147:    */   }
/* 148:    */   
/* 149:    */   public Date getLastLoginTime()
/* 150:    */   {
/* 151:239 */     return this.lastLoginTime;
/* 152:    */   }
/* 153:    */   
/* 154:    */   public void setLastLoginTime(Date lastLoginTime)
/* 155:    */   {
/* 156:247 */     this.lastLoginTime = lastLoginTime;
/* 157:    */   }
/* 158:    */   
/* 159:    */   public String getLastLoginIp()
/* 160:    */   {
/* 161:256 */     return this.lastLoginIp;
/* 162:    */   }
/* 163:    */   
/* 164:    */   public void setLastLoginIp(String lastLoginIp)
/* 165:    */   {
/* 166:264 */     this.lastLoginIp = lastLoginIp;
/* 167:    */   }
/* 168:    */   
/* 169:    */   public Integer getLoginCount()
/* 170:    */   {
/* 171:273 */     return this.loginCount;
/* 172:    */   }
/* 173:    */   
/* 174:    */   public void setLoginCount(Integer loginCount)
/* 175:    */   {
/* 176:281 */     this.loginCount = loginCount;
/* 177:    */   }
/* 178:    */   
/* 179:    */   public Byte getStatus()
/* 180:    */   {
/* 181:290 */     return this.status;
/* 182:    */   }
/* 183:    */   
/* 184:    */   public void setStatus(Byte status)
/* 185:    */   {
/* 186:298 */     this.status = status;
/* 187:    */   }
/* 188:    */   
/* 189:    */   public User getUser()
/* 190:    */   {
/* 191:307 */     return this.user;
/* 192:    */   }
/* 193:    */   
/* 194:    */   public void setUser(User user)
/* 195:    */   {
/* 196:315 */     this.user = user;
/* 197:    */   }
/* 198:    */   
/* 199:    */   public Set<Group> getGroups()
/* 200:    */   {
/* 201:324 */     return this.groups;
/* 202:    */   }
/* 203:    */   
/* 204:    */   public void setGroups(Set<Group> groups)
/* 205:    */   {
/* 206:332 */     this.groups = groups;
/* 207:    */   }
/* 208:    */   
/* 209:    */   public void addTogroups(Group group)
/* 210:    */   {
/* 211:336 */     if (getGroups() == null) {
/* 212:336 */       setGroups(new TreeSet());
/* 213:    */     }
/* 214:337 */     getGroups().add(group);
/* 215:    */   }
/* 216:    */   
/* 217:    */   public boolean equals(Object obj)
/* 218:    */   {
/* 219:344 */     if (obj == null) {
/* 220:344 */       return false;
/* 221:    */     }
/* 222:345 */     if (!(obj instanceof Member)) {
/* 223:345 */       return false;
/* 224:    */     }
/* 225:347 */     Member member = (Member)obj;
/* 226:348 */     if ((getId() == null) || (member.getId() == null)) {
/* 227:348 */       return false;
/* 228:    */     }
/* 229:349 */     return getId().equals(member.getId());
/* 230:    */   }
/* 231:    */   
/* 232:    */   public int hashCode()
/* 233:    */   {
/* 234:354 */     if (-2147483648 == this.hashCode)
/* 235:    */     {
/* 236:355 */       if (getId() == null) {
/* 237:355 */         return super.hashCode();
/* 238:    */       }
/* 239:357 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 240:358 */       this.hashCode = hashStr.hashCode();
/* 241:    */     }
/* 242:361 */     return this.hashCode;
/* 243:    */   }
/* 244:    */   
/* 245:    */   public String toString()
/* 246:    */   {
/* 247:366 */     return super.toString();
/* 248:    */   }
/* 249:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.entity.base.BaseMember
 * JD-Core Version:    0.7.0.1
 */