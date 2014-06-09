/*   1:    */ package com.portal.usermgr.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.extrafunc.entity.UserForum;
/*   4:    */ import com.portal.usermgr.entity.Admin;
/*   5:    */ import com.portal.usermgr.entity.Member;
/*   6:    */ import com.portal.usermgr.entity.User;
/*   7:    */ import java.io.Serializable;
/*   8:    */ 
/*   9:    */ public abstract class BaseUser
/*  10:    */   implements Serializable
/*  11:    */ {
/*  12: 17 */   public static String REF = "User";
/*  13: 18 */   public static String PROP_STATUS = "status";
/*  14: 19 */   public static String PROP_MEMBER = "member";
/*  15: 20 */   public static String PROP_PHONE = "phone";
/*  16: 21 */   public static String PROP_EMAIL = "email";
/*  17: 22 */   public static String PROP_PASSWORD = "password";
/*  18: 23 */   public static String PROP_USERNAME = "username";
/*  19: 24 */   public static String PROP_MOBILE = "mobile";
/*  20: 25 */   public static String PROP_ID = "id";
/*  21: 26 */   public static String PROP_REAL_NAME = "realName";
/*  22: 27 */   public static String PROP_ADMIN = "admin";
/*  23:    */   
/*  24:    */   public BaseUser()
/*  25:    */   {
/*  26: 32 */     initialize();
/*  27:    */   }
/*  28:    */   
/*  29:    */   public BaseUser(Integer id)
/*  30:    */   {
/*  31: 39 */     setId(id);
/*  32: 40 */     initialize();
/*  33:    */   }
/*  34:    */   
/*  35:    */   public BaseUser(Integer id, String username, Byte status)
/*  36:    */   {
/*  37: 51 */     setId(id);
/*  38: 52 */     setUsername(username);
/*  39: 53 */     setStatus(status);
/*  40: 54 */     initialize();
/*  41:    */   }
/*  42:    */   
/*  43: 61 */   private int hashCode = -2147483648;
/*  44:    */   private Integer id;
/*  45:    */   private String username;
/*  46:    */   private String password;
/*  47:    */   private String email;
/*  48:    */   private String realName;
/*  49:    */   private String phone;
/*  50:    */   private String mobile;
/*  51:    */   private Byte status;
/*  52:    */   private Member member;
/*  53:    */   private Admin admin;
/*  54:    */   private UserForum userForum;
/*  55:    */   
/*  56:    */   protected void initialize() {}
/*  57:    */   
/*  58:    */   public Integer getId()
/*  59:    */   {
/*  60: 89 */     return this.id;
/*  61:    */   }
/*  62:    */   
/*  63:    */   public void setId(Integer id)
/*  64:    */   {
/*  65: 97 */     this.id = id;
/*  66: 98 */     this.hashCode = -2147483648;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public String getUsername()
/*  70:    */   {
/*  71:108 */     return this.username;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public void setUsername(String username)
/*  75:    */   {
/*  76:116 */     this.username = username;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public String getPassword()
/*  80:    */   {
/*  81:125 */     return this.password;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public void setPassword(String password)
/*  85:    */   {
/*  86:133 */     this.password = password;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public String getEmail()
/*  90:    */   {
/*  91:142 */     return this.email;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public void setEmail(String email)
/*  95:    */   {
/*  96:150 */     this.email = email;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public String getRealName()
/* 100:    */   {
/* 101:159 */     return this.realName;
/* 102:    */   }
/* 103:    */   
/* 104:    */   public void setRealName(String realName)
/* 105:    */   {
/* 106:167 */     this.realName = realName;
/* 107:    */   }
/* 108:    */   
/* 109:    */   public String getPhone()
/* 110:    */   {
/* 111:176 */     return this.phone;
/* 112:    */   }
/* 113:    */   
/* 114:    */   public void setPhone(String phone)
/* 115:    */   {
/* 116:184 */     this.phone = phone;
/* 117:    */   }
/* 118:    */   
/* 119:    */   public String getMobile()
/* 120:    */   {
/* 121:193 */     return this.mobile;
/* 122:    */   }
/* 123:    */   
/* 124:    */   public void setMobile(String mobile)
/* 125:    */   {
/* 126:201 */     this.mobile = mobile;
/* 127:    */   }
/* 128:    */   
/* 129:    */   public Byte getStatus()
/* 130:    */   {
/* 131:210 */     return this.status;
/* 132:    */   }
/* 133:    */   
/* 134:    */   public void setStatus(Byte status)
/* 135:    */   {
/* 136:218 */     this.status = status;
/* 137:    */   }
/* 138:    */   
/* 139:    */   public Member getMember()
/* 140:    */   {
/* 141:227 */     return this.member;
/* 142:    */   }
/* 143:    */   
/* 144:    */   public void setMember(Member member)
/* 145:    */   {
/* 146:235 */     this.member = member;
/* 147:    */   }
/* 148:    */   
/* 149:    */   public Admin getAdmin()
/* 150:    */   {
/* 151:244 */     return this.admin;
/* 152:    */   }
/* 153:    */   
/* 154:    */   public void setAdmin(Admin admin)
/* 155:    */   {
/* 156:252 */     this.admin = admin;
/* 157:    */   }
/* 158:    */   
/* 159:    */   public UserForum getUserForum()
/* 160:    */   {
/* 161:259 */     return this.userForum;
/* 162:    */   }
/* 163:    */   
/* 164:    */   public void setUserForum(UserForum userForum)
/* 165:    */   {
/* 166:263 */     this.userForum = userForum;
/* 167:    */   }
/* 168:    */   
/* 169:    */   public boolean equals(Object obj)
/* 170:    */   {
/* 171:267 */     if (obj == null) {
/* 172:267 */       return false;
/* 173:    */     }
/* 174:268 */     if (!(obj instanceof User)) {
/* 175:268 */       return false;
/* 176:    */     }
/* 177:270 */     User user = (User)obj;
/* 178:271 */     if ((getId() == null) || (user.getId() == null)) {
/* 179:271 */       return false;
/* 180:    */     }
/* 181:272 */     return getId().equals(user.getId());
/* 182:    */   }
/* 183:    */   
/* 184:    */   public int hashCode()
/* 185:    */   {
/* 186:277 */     if (-2147483648 == this.hashCode)
/* 187:    */     {
/* 188:278 */       if (getId() == null) {
/* 189:278 */         return super.hashCode();
/* 190:    */       }
/* 191:280 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 192:281 */       this.hashCode = hashStr.hashCode();
/* 193:    */     }
/* 194:284 */     return this.hashCode;
/* 195:    */   }
/* 196:    */   
/* 197:    */   public String toString()
/* 198:    */   {
/* 199:289 */     return super.toString();
/* 200:    */   }
/* 201:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.entity.base.BaseUser
 * JD-Core Version:    0.7.0.1
 */