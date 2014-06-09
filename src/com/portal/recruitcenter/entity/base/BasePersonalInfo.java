/*   1:    */ package com.portal.recruitcenter.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.datacenter.commdata.entity.Specialty;
/*   4:    */ import com.portal.recruitcenter.entity.PersonalInfo;
/*   5:    */ import com.portal.recruitcenter.entity.PersonalInfoExt;
/*   6:    */ import java.io.Serializable;
/*   7:    */ import java.util.Date;
/*   8:    */ 
/*   9:    */ public abstract class BasePersonalInfo
/*  10:    */   implements Serializable
/*  11:    */ {
/*  12: 17 */   public static String REF = "PersonalInfo";
/*  13: 18 */   public static String PROP_CHECK = "check";
/*  14: 19 */   public static String PROP_BIRTHDAY = "birthday";
/*  15: 20 */   public static String PROP_SPECIAL = "special";
/*  16: 21 */   public static String PROP_EXT = "ext";
/*  17: 22 */   public static String PROP_EDUCATIONAL = "educational";
/*  18: 23 */   public static String PROP_GENDER = "gender";
/*  19: 24 */   public static String PROP_WORK_EXP = "workExp";
/*  20: 25 */   public static String PROP_COMMEND = "commend";
/*  21: 26 */   public static String PROP_WORK = "work";
/*  22: 27 */   public static String PROP_REALNAME = "realname";
/*  23: 28 */   public static String PROP_AVATAR = "avatar";
/*  24: 29 */   public static String PROP_ID = "id";
/*  25:    */   
/*  26:    */   public BasePersonalInfo()
/*  27:    */   {
/*  28: 34 */     initialize();
/*  29:    */   }
/*  30:    */   
/*  31:    */   public BasePersonalInfo(Integer id)
/*  32:    */   {
/*  33: 41 */     setId(id);
/*  34: 42 */     initialize();
/*  35:    */   }
/*  36:    */   
/*  37:    */   public BasePersonalInfo(Integer id, Byte workExp, Boolean work, Boolean check, Boolean commend)
/*  38:    */   {
/*  39: 55 */     setId(id);
/*  40: 56 */     setWorkExp(workExp);
/*  41: 57 */     setWork(work);
/*  42: 58 */     setCheck(check);
/*  43: 59 */     setCommend(commend);
/*  44: 60 */     initialize();
/*  45:    */   }
/*  46:    */   
/*  47: 67 */   private int hashCode = -2147483648;
/*  48:    */   private Integer id;
/*  49:    */   private String avatar;
/*  50:    */   private String realname;
/*  51:    */   private Boolean gender;
/*  52:    */   private Date birthday;
/*  53:    */   private Byte educational;
/*  54:    */   private Byte workExp;
/*  55:    */   private Boolean work;
/*  56:    */   private Boolean check;
/*  57:    */   private Boolean commend;
/*  58:    */   private PersonalInfoExt ext;
/*  59:    */   private Specialty special;
/*  60:    */   
/*  61:    */   protected void initialize() {}
/*  62:    */   
/*  63:    */   public Integer getId()
/*  64:    */   {
/*  65: 98 */     return this.id;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public void setId(Integer id)
/*  69:    */   {
/*  70:106 */     this.id = id;
/*  71:107 */     this.hashCode = -2147483648;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public String getAvatar()
/*  75:    */   {
/*  76:117 */     return this.avatar;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public void setAvatar(String avatar)
/*  80:    */   {
/*  81:125 */     this.avatar = avatar;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public String getRealname()
/*  85:    */   {
/*  86:134 */     return this.realname;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public void setRealname(String realname)
/*  90:    */   {
/*  91:142 */     this.realname = realname;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public Boolean getGender()
/*  95:    */   {
/*  96:151 */     return this.gender;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public void setGender(Boolean gender)
/* 100:    */   {
/* 101:159 */     this.gender = gender;
/* 102:    */   }
/* 103:    */   
/* 104:    */   public Date getBirthday()
/* 105:    */   {
/* 106:168 */     return this.birthday;
/* 107:    */   }
/* 108:    */   
/* 109:    */   public void setBirthday(Date birthday)
/* 110:    */   {
/* 111:176 */     this.birthday = birthday;
/* 112:    */   }
/* 113:    */   
/* 114:    */   public Byte getEducational()
/* 115:    */   {
/* 116:185 */     return this.educational;
/* 117:    */   }
/* 118:    */   
/* 119:    */   public void setEducational(Byte educational)
/* 120:    */   {
/* 121:193 */     this.educational = educational;
/* 122:    */   }
/* 123:    */   
/* 124:    */   public Byte getWorkExp()
/* 125:    */   {
/* 126:202 */     return this.workExp;
/* 127:    */   }
/* 128:    */   
/* 129:    */   public void setWorkExp(Byte workExp)
/* 130:    */   {
/* 131:210 */     this.workExp = workExp;
/* 132:    */   }
/* 133:    */   
/* 134:    */   public Boolean getWork()
/* 135:    */   {
/* 136:219 */     return this.work;
/* 137:    */   }
/* 138:    */   
/* 139:    */   public void setWork(Boolean work)
/* 140:    */   {
/* 141:227 */     this.work = work;
/* 142:    */   }
/* 143:    */   
/* 144:    */   public Boolean getCheck()
/* 145:    */   {
/* 146:236 */     return this.check;
/* 147:    */   }
/* 148:    */   
/* 149:    */   public void setCheck(Boolean check)
/* 150:    */   {
/* 151:244 */     this.check = check;
/* 152:    */   }
/* 153:    */   
/* 154:    */   public Boolean getCommend()
/* 155:    */   {
/* 156:253 */     return this.commend;
/* 157:    */   }
/* 158:    */   
/* 159:    */   public void setCommend(Boolean commend)
/* 160:    */   {
/* 161:261 */     this.commend = commend;
/* 162:    */   }
/* 163:    */   
/* 164:    */   public PersonalInfoExt getExt()
/* 165:    */   {
/* 166:270 */     return this.ext;
/* 167:    */   }
/* 168:    */   
/* 169:    */   public void setExt(PersonalInfoExt ext)
/* 170:    */   {
/* 171:278 */     this.ext = ext;
/* 172:    */   }
/* 173:    */   
/* 174:    */   public Specialty getSpecial()
/* 175:    */   {
/* 176:287 */     return this.special;
/* 177:    */   }
/* 178:    */   
/* 179:    */   public void setSpecial(Specialty special)
/* 180:    */   {
/* 181:295 */     this.special = special;
/* 182:    */   }
/* 183:    */   
/* 184:    */   public boolean equals(Object obj)
/* 185:    */   {
/* 186:302 */     if (obj == null) {
/* 187:302 */       return false;
/* 188:    */     }
/* 189:303 */     if (!(obj instanceof PersonalInfo)) {
/* 190:303 */       return false;
/* 191:    */     }
/* 192:305 */     PersonalInfo personalInfo = (PersonalInfo)obj;
/* 193:306 */     if ((getId() == null) || (personalInfo.getId() == null)) {
/* 194:306 */       return false;
/* 195:    */     }
/* 196:307 */     return getId().equals(personalInfo.getId());
/* 197:    */   }
/* 198:    */   
/* 199:    */   public int hashCode()
/* 200:    */   {
/* 201:312 */     if (-2147483648 == this.hashCode)
/* 202:    */     {
/* 203:313 */       if (getId() == null) {
/* 204:313 */         return super.hashCode();
/* 205:    */       }
/* 206:315 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 207:316 */       this.hashCode = hashStr.hashCode();
/* 208:    */     }
/* 209:319 */     return this.hashCode;
/* 210:    */   }
/* 211:    */   
/* 212:    */   public String toString()
/* 213:    */   {
/* 214:324 */     return super.toString();
/* 215:    */   }
/* 216:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.entity.base.BasePersonalInfo
 * JD-Core Version:    0.7.0.1
 */