/*   1:    */ package com.portal.usermgr.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.usermgr.entity.SiteMessage;
/*   4:    */ import com.portal.usermgr.entity.SiteMessageExt;
/*   5:    */ import com.portal.usermgr.entity.User;
/*   6:    */ import java.io.Serializable;
/*   7:    */ import java.util.Date;
/*   8:    */ 
/*   9:    */ public abstract class BaseSiteMessage
/*  10:    */   implements Serializable
/*  11:    */ {
/*  12: 17 */   public static String REF = "SiteMessage";
/*  13: 18 */   public static String PROP_TO_USER = "toUser";
/*  14: 19 */   public static String PROP_EXT = "ext";
/*  15: 20 */   public static String PROP_FROM_USER = "fromUser";
/*  16: 21 */   public static String PROP_CREATE_TIME = "createTime";
/*  17: 22 */   public static String PROP_ID = "id";
/*  18: 23 */   public static String PROP_READ = "read";
/*  19: 24 */   public static String PROP_REPLY = "reply";
/*  20: 25 */   public static String PROP_DELETE_FROM = "deleteFrom";
/*  21: 26 */   public static String PROP_DELETE_TO = "deleteTo";
/*  22:    */   
/*  23:    */   public BaseSiteMessage()
/*  24:    */   {
/*  25: 31 */     initialize();
/*  26:    */   }
/*  27:    */   
/*  28:    */   public BaseSiteMessage(Integer id)
/*  29:    */   {
/*  30: 38 */     setId(id);
/*  31: 39 */     initialize();
/*  32:    */   }
/*  33:    */   
/*  34:    */   public BaseSiteMessage(Integer id, User fromUser, User toUser, Date createTime, Boolean read, Boolean deleteFrom, Boolean deleteTo)
/*  35:    */   {
/*  36: 54 */     setId(id);
/*  37: 55 */     setFromUser(fromUser);
/*  38: 56 */     setToUser(toUser);
/*  39: 57 */     setCreateTime(createTime);
/*  40: 58 */     setRead(read);
/*  41: 59 */     setDeleteFrom(deleteFrom);
/*  42: 60 */     setDeleteTo(deleteTo);
/*  43: 61 */     initialize();
/*  44:    */   }
/*  45:    */   
/*  46: 68 */   private int hashCode = -2147483648;
/*  47:    */   private Integer id;
/*  48:    */   private Date createTime;
/*  49:    */   private Boolean read;
/*  50:    */   private Boolean deleteFrom;
/*  51:    */   private Boolean deleteTo;
/*  52:    */   private SiteMessageExt ext;
/*  53:    */   private SiteMessage reply;
/*  54:    */   private User fromUser;
/*  55:    */   private User toUser;
/*  56:    */   
/*  57:    */   protected void initialize() {}
/*  58:    */   
/*  59:    */   public Integer getId()
/*  60:    */   {
/*  61: 96 */     return this.id;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public void setId(Integer id)
/*  65:    */   {
/*  66:104 */     this.id = id;
/*  67:105 */     this.hashCode = -2147483648;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public Date getCreateTime()
/*  71:    */   {
/*  72:115 */     return this.createTime;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public void setCreateTime(Date createTime)
/*  76:    */   {
/*  77:123 */     this.createTime = createTime;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public Boolean getRead()
/*  81:    */   {
/*  82:132 */     return this.read;
/*  83:    */   }
/*  84:    */   
/*  85:    */   public void setRead(Boolean read)
/*  86:    */   {
/*  87:140 */     this.read = read;
/*  88:    */   }
/*  89:    */   
/*  90:    */   public Boolean getDeleteFrom()
/*  91:    */   {
/*  92:149 */     return this.deleteFrom;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public void setDeleteFrom(Boolean deleteFrom)
/*  96:    */   {
/*  97:157 */     this.deleteFrom = deleteFrom;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public Boolean getDeleteTo()
/* 101:    */   {
/* 102:166 */     return this.deleteTo;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public void setDeleteTo(Boolean deleteTo)
/* 106:    */   {
/* 107:174 */     this.deleteTo = deleteTo;
/* 108:    */   }
/* 109:    */   
/* 110:    */   public SiteMessageExt getExt()
/* 111:    */   {
/* 112:183 */     return this.ext;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public void setExt(SiteMessageExt ext)
/* 116:    */   {
/* 117:191 */     this.ext = ext;
/* 118:    */   }
/* 119:    */   
/* 120:    */   public SiteMessage getReply()
/* 121:    */   {
/* 122:200 */     return this.reply;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public void setReply(SiteMessage reply)
/* 126:    */   {
/* 127:208 */     this.reply = reply;
/* 128:    */   }
/* 129:    */   
/* 130:    */   public User getFromUser()
/* 131:    */   {
/* 132:217 */     return this.fromUser;
/* 133:    */   }
/* 134:    */   
/* 135:    */   public void setFromUser(User fromUser)
/* 136:    */   {
/* 137:225 */     this.fromUser = fromUser;
/* 138:    */   }
/* 139:    */   
/* 140:    */   public User getToUser()
/* 141:    */   {
/* 142:234 */     return this.toUser;
/* 143:    */   }
/* 144:    */   
/* 145:    */   public void setToUser(User toUser)
/* 146:    */   {
/* 147:242 */     this.toUser = toUser;
/* 148:    */   }
/* 149:    */   
/* 150:    */   public boolean equals(Object obj)
/* 151:    */   {
/* 152:249 */     if (obj == null) {
/* 153:249 */       return false;
/* 154:    */     }
/* 155:250 */     if (!(obj instanceof SiteMessage)) {
/* 156:250 */       return false;
/* 157:    */     }
/* 158:252 */     SiteMessage siteMessage = (SiteMessage)obj;
/* 159:253 */     if ((getId() == null) || (siteMessage.getId() == null)) {
/* 160:253 */       return false;
/* 161:    */     }
/* 162:254 */     return getId().equals(siteMessage.getId());
/* 163:    */   }
/* 164:    */   
/* 165:    */   public int hashCode()
/* 166:    */   {
/* 167:259 */     if (-2147483648 == this.hashCode)
/* 168:    */     {
/* 169:260 */       if (getId() == null) {
/* 170:260 */         return super.hashCode();
/* 171:    */       }
/* 172:262 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 173:263 */       this.hashCode = hashStr.hashCode();
/* 174:    */     }
/* 175:266 */     return this.hashCode;
/* 176:    */   }
/* 177:    */   
/* 178:    */   public String toString()
/* 179:    */   {
/* 180:271 */     return super.toString();
/* 181:    */   }
/* 182:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.entity.base.BaseSiteMessage
 * JD-Core Version:    0.7.0.1
 */