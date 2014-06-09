/*   1:    */ package com.portal.usermgr.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.usermgr.entity.Admin;
/*   4:    */ import com.portal.usermgr.entity.AdminCheck;
/*   5:    */ import com.portal.usermgr.entity.Depart;
/*   6:    */ import com.portal.usermgr.entity.Role;
/*   7:    */ import com.portal.usermgr.entity.User;
/*   8:    */ import java.io.Serializable;
/*   9:    */ import java.util.Date;
/*  10:    */ import java.util.Set;
/*  11:    */ import java.util.TreeSet;
/*  12:    */ 
/*  13:    */ public abstract class BaseAdmin
/*  14:    */   implements Serializable
/*  15:    */ {
/*  16: 17 */   public static String REF = "Admin";
/*  17: 18 */   public static String PROP_USER = "user";
/*  18: 19 */   public static String PROP_LOGIN_COUNT = "loginCount";
/*  19: 20 */   public static String PROP_STATUS = "status";
/*  20: 21 */   public static String PROP_LAST_LOGIN_TIME = "lastLoginTime";
/*  21: 22 */   public static String PROP_REGISTER_TIME = "registerTime";
/*  22: 23 */   public static String PROP_ID = "id";
/*  23: 24 */   public static String PROP_REGISTER_IP = "registerIp";
/*  24: 25 */   public static String PROP_LAST_LOGIN_IP = "lastLoginIp";
/*  25:    */   
/*  26:    */   public BaseAdmin()
/*  27:    */   {
/*  28: 30 */     initialize();
/*  29:    */   }
/*  30:    */   
/*  31:    */   public BaseAdmin(Integer id)
/*  32:    */   {
/*  33: 37 */     setId(id);
/*  34: 38 */     initialize();
/*  35:    */   }
/*  36:    */   
/*  37:    */   public BaseAdmin(Integer id, Date registerTime, String registerIp, Integer loginCount, Byte status)
/*  38:    */   {
/*  39: 51 */     setId(id);
/*  40: 52 */     setRegisterTime(registerTime);
/*  41: 53 */     setRegisterIp(registerIp);
/*  42: 54 */     setLoginCount(loginCount);
/*  43: 55 */     setStatus(status);
/*  44: 56 */     initialize();
/*  45:    */   }
/*  46:    */   
/*  47: 63 */   private int hashCode = -2147483648;
/*  48:    */   private Integer id;
/*  49:    */   private Date registerTime;
/*  50:    */   private String registerIp;
/*  51:    */   private Date lastLoginTime;
/*  52:    */   private String lastLoginIp;
/*  53:    */   private Integer loginCount;
/*  54:    */   private Byte status;
/*  55:    */   private User user;
/*  56:    */   private Set<AdminCheck> adminChecks;
/*  57:    */   private Set<Role> roles;
/*  58:    */   private Set<Depart> departs;
/*  59:    */   
/*  60:    */   protected void initialize() {}
/*  61:    */   
/*  62:    */   public Integer getId()
/*  63:    */   {
/*  64: 93 */     return this.id;
/*  65:    */   }
/*  66:    */   
/*  67:    */   public void setId(Integer id)
/*  68:    */   {
/*  69:101 */     this.id = id;
/*  70:102 */     this.hashCode = -2147483648;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public Date getRegisterTime()
/*  74:    */   {
/*  75:112 */     return this.registerTime;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public void setRegisterTime(Date registerTime)
/*  79:    */   {
/*  80:120 */     this.registerTime = registerTime;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public String getRegisterIp()
/*  84:    */   {
/*  85:129 */     return this.registerIp;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public void setRegisterIp(String registerIp)
/*  89:    */   {
/*  90:137 */     this.registerIp = registerIp;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public Date getLastLoginTime()
/*  94:    */   {
/*  95:146 */     return this.lastLoginTime;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public void setLastLoginTime(Date lastLoginTime)
/*  99:    */   {
/* 100:154 */     this.lastLoginTime = lastLoginTime;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public String getLastLoginIp()
/* 104:    */   {
/* 105:163 */     return this.lastLoginIp;
/* 106:    */   }
/* 107:    */   
/* 108:    */   public void setLastLoginIp(String lastLoginIp)
/* 109:    */   {
/* 110:171 */     this.lastLoginIp = lastLoginIp;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public Integer getLoginCount()
/* 114:    */   {
/* 115:180 */     return this.loginCount;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public void setLoginCount(Integer loginCount)
/* 119:    */   {
/* 120:188 */     this.loginCount = loginCount;
/* 121:    */   }
/* 122:    */   
/* 123:    */   public Byte getStatus()
/* 124:    */   {
/* 125:197 */     return this.status;
/* 126:    */   }
/* 127:    */   
/* 128:    */   public void setStatus(Byte status)
/* 129:    */   {
/* 130:205 */     this.status = status;
/* 131:    */   }
/* 132:    */   
/* 133:    */   public User getUser()
/* 134:    */   {
/* 135:214 */     return this.user;
/* 136:    */   }
/* 137:    */   
/* 138:    */   public void setUser(User user)
/* 139:    */   {
/* 140:222 */     this.user = user;
/* 141:    */   }
/* 142:    */   
/* 143:    */   public Set<AdminCheck> getAdminChecks()
/* 144:    */   {
/* 145:231 */     return this.adminChecks;
/* 146:    */   }
/* 147:    */   
/* 148:    */   public void setAdminChecks(Set<AdminCheck> adminChecks)
/* 149:    */   {
/* 150:239 */     this.adminChecks = adminChecks;
/* 151:    */   }
/* 152:    */   
/* 153:    */   public void addToadminChecks(AdminCheck adminCheck)
/* 154:    */   {
/* 155:243 */     if (getAdminChecks() == null) {
/* 156:243 */       setAdminChecks(new TreeSet());
/* 157:    */     }
/* 158:244 */     getAdminChecks().add(adminCheck);
/* 159:    */   }
/* 160:    */   
/* 161:    */   public Set<Role> getRoles()
/* 162:    */   {
/* 163:253 */     return this.roles;
/* 164:    */   }
/* 165:    */   
/* 166:    */   public void setRoles(Set<Role> roles)
/* 167:    */   {
/* 168:261 */     this.roles = roles;
/* 169:    */   }
/* 170:    */   
/* 171:    */   public void addToroles(Role role)
/* 172:    */   {
/* 173:265 */     if (getRoles() == null) {
/* 174:265 */       setRoles(new TreeSet());
/* 175:    */     }
/* 176:266 */     getRoles().add(role);
/* 177:    */   }
/* 178:    */   
/* 179:    */   public Set<Depart> getDeparts()
/* 180:    */   {
/* 181:275 */     return this.departs;
/* 182:    */   }
/* 183:    */   
/* 184:    */   public void setDeparts(Set<Depart> departs)
/* 185:    */   {
/* 186:283 */     this.departs = departs;
/* 187:    */   }
/* 188:    */   
/* 189:    */   public boolean equals(Object obj)
/* 190:    */   {
/* 191:288 */     if (obj == null) {
/* 192:288 */       return false;
/* 193:    */     }
/* 194:289 */     if (!(obj instanceof Admin)) {
/* 195:289 */       return false;
/* 196:    */     }
/* 197:291 */     Admin admin = (Admin)obj;
/* 198:292 */     if ((getId() == null) || (admin.getId() == null)) {
/* 199:292 */       return false;
/* 200:    */     }
/* 201:293 */     return getId().equals(admin.getId());
/* 202:    */   }
/* 203:    */   
/* 204:    */   public int hashCode()
/* 205:    */   {
/* 206:298 */     if (-2147483648 == this.hashCode)
/* 207:    */     {
/* 208:299 */       if (getId() == null) {
/* 209:299 */         return super.hashCode();
/* 210:    */       }
/* 211:301 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 212:302 */       this.hashCode = hashStr.hashCode();
/* 213:    */     }
/* 214:305 */     return this.hashCode;
/* 215:    */   }
/* 216:    */   
/* 217:    */   public String toString()
/* 218:    */   {
/* 219:310 */     return super.toString();
/* 220:    */   }
/* 221:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.entity.base.BaseAdmin
 * JD-Core Version:    0.7.0.1
 */