/*   1:    */ package com.portal.extrafunc.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.extrafunc.entity.Questionnaire;
/*   4:    */ import com.portal.sysmgr.entity.Site;
/*   5:    */ import java.io.Serializable;
/*   6:    */ import java.util.Date;
/*   7:    */ 
/*   8:    */ public abstract class BaseQuestionnaire
/*   9:    */   implements Serializable
/*  10:    */ {
/*  11: 17 */   public static String REF = "Questionnaire";
/*  12: 18 */   public static String PROP_NAME = "name";
/*  13: 19 */   public static String PROP_NEED_LOGIN = "needLogin";
/*  14: 20 */   public static String PROP_DESCRIPTION = "description";
/*  15: 21 */   public static String PROP_SITE = "site";
/*  16: 22 */   public static String PROP_REPEATE_TIME = "repeateTime";
/*  17: 23 */   public static String PROP_ENABLE = "enable";
/*  18: 24 */   public static String PROP_CREATE_TIME = "createTime";
/*  19: 25 */   public static String PROP_RESTRICT_IP = "restrictIp";
/*  20: 26 */   public static String PROP_ID = "id";
/*  21: 27 */   public static String PROP_END_TIME = "endTime";
/*  22: 28 */   public static String PROP_START_TIME = "startTime";
/*  23:    */   
/*  24:    */   public BaseQuestionnaire()
/*  25:    */   {
/*  26: 33 */     initialize();
/*  27:    */   }
/*  28:    */   
/*  29:    */   public BaseQuestionnaire(Integer id)
/*  30:    */   {
/*  31: 40 */     setId(id);
/*  32: 41 */     initialize();
/*  33:    */   }
/*  34:    */   
/*  35:    */   public BaseQuestionnaire(Integer id, Site site, String name, Integer repeateTime, Boolean restrictIp, Boolean needLogin, Date createTime, Date startTime, Boolean enable)
/*  36:    */   {
/*  37: 58 */     setId(id);
/*  38: 59 */     setSite(site);
/*  39: 60 */     setName(name);
/*  40: 61 */     setRepeateTime(repeateTime);
/*  41: 62 */     setRestrictIp(restrictIp);
/*  42: 63 */     setNeedLogin(needLogin);
/*  43: 64 */     setCreateTime(createTime);
/*  44: 65 */     setStartTime(startTime);
/*  45: 66 */     setEnable(enable);
/*  46: 67 */     initialize();
/*  47:    */   }
/*  48:    */   
/*  49: 74 */   private int hashCode = -2147483648;
/*  50:    */   private Integer id;
/*  51:    */   private String name;
/*  52:    */   private String description;
/*  53:    */   private Integer repeateTime;
/*  54:    */   private Boolean restrictIp;
/*  55:    */   private Boolean needLogin;
/*  56:    */   private Date createTime;
/*  57:    */   private Date startTime;
/*  58:    */   private Date endTime;
/*  59:    */   private Boolean enable;
/*  60:    */   private Site site;
/*  61:    */   
/*  62:    */   protected void initialize() {}
/*  63:    */   
/*  64:    */   public Integer getId()
/*  65:    */   {
/*  66:102 */     return this.id;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public void setId(Integer id)
/*  70:    */   {
/*  71:110 */     this.id = id;
/*  72:111 */     this.hashCode = -2147483648;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public String getName()
/*  76:    */   {
/*  77:121 */     return this.name;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public void setName(String name)
/*  81:    */   {
/*  82:129 */     this.name = name;
/*  83:    */   }
/*  84:    */   
/*  85:    */   public String getDescription()
/*  86:    */   {
/*  87:138 */     return this.description;
/*  88:    */   }
/*  89:    */   
/*  90:    */   public void setDescription(String description)
/*  91:    */   {
/*  92:146 */     this.description = description;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public Integer getRepeateTime()
/*  96:    */   {
/*  97:155 */     return this.repeateTime;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public void setRepeateTime(Integer repeateTime)
/* 101:    */   {
/* 102:163 */     this.repeateTime = repeateTime;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public Boolean getRestrictIp()
/* 106:    */   {
/* 107:172 */     return this.restrictIp;
/* 108:    */   }
/* 109:    */   
/* 110:    */   public void setRestrictIp(Boolean restrictIp)
/* 111:    */   {
/* 112:180 */     this.restrictIp = restrictIp;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public Boolean getNeedLogin()
/* 116:    */   {
/* 117:189 */     return this.needLogin;
/* 118:    */   }
/* 119:    */   
/* 120:    */   public void setNeedLogin(Boolean needLogin)
/* 121:    */   {
/* 122:197 */     this.needLogin = needLogin;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public Date getCreateTime()
/* 126:    */   {
/* 127:206 */     return this.createTime;
/* 128:    */   }
/* 129:    */   
/* 130:    */   public void setCreateTime(Date createTime)
/* 131:    */   {
/* 132:214 */     this.createTime = createTime;
/* 133:    */   }
/* 134:    */   
/* 135:    */   public Date getStartTime()
/* 136:    */   {
/* 137:223 */     return this.startTime;
/* 138:    */   }
/* 139:    */   
/* 140:    */   public void setStartTime(Date startTime)
/* 141:    */   {
/* 142:231 */     this.startTime = startTime;
/* 143:    */   }
/* 144:    */   
/* 145:    */   public Date getEndTime()
/* 146:    */   {
/* 147:240 */     return this.endTime;
/* 148:    */   }
/* 149:    */   
/* 150:    */   public void setEndTime(Date endTime)
/* 151:    */   {
/* 152:248 */     this.endTime = endTime;
/* 153:    */   }
/* 154:    */   
/* 155:    */   public Boolean getEnable()
/* 156:    */   {
/* 157:257 */     return this.enable;
/* 158:    */   }
/* 159:    */   
/* 160:    */   public void setEnable(Boolean enable)
/* 161:    */   {
/* 162:265 */     this.enable = enable;
/* 163:    */   }
/* 164:    */   
/* 165:    */   public Site getSite()
/* 166:    */   {
/* 167:274 */     return this.site;
/* 168:    */   }
/* 169:    */   
/* 170:    */   public void setSite(Site site)
/* 171:    */   {
/* 172:282 */     this.site = site;
/* 173:    */   }
/* 174:    */   
/* 175:    */   public boolean equals(Object obj)
/* 176:    */   {
/* 177:289 */     if (obj == null) {
/* 178:289 */       return false;
/* 179:    */     }
/* 180:290 */     if (!(obj instanceof Questionnaire)) {
/* 181:290 */       return false;
/* 182:    */     }
/* 183:292 */     Questionnaire questionnaire = (Questionnaire)obj;
/* 184:293 */     if ((getId() == null) || (questionnaire.getId() == null)) {
/* 185:293 */       return false;
/* 186:    */     }
/* 187:294 */     return getId().equals(questionnaire.getId());
/* 188:    */   }
/* 189:    */   
/* 190:    */   public int hashCode()
/* 191:    */   {
/* 192:299 */     if (-2147483648 == this.hashCode)
/* 193:    */     {
/* 194:300 */       if (getId() == null) {
/* 195:300 */         return super.hashCode();
/* 196:    */       }
/* 197:302 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 198:303 */       this.hashCode = hashStr.hashCode();
/* 199:    */     }
/* 200:306 */     return this.hashCode;
/* 201:    */   }
/* 202:    */   
/* 203:    */   public String toString()
/* 204:    */   {
/* 205:311 */     return super.toString();
/* 206:    */   }
/* 207:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.entity.base.BaseQuestionnaire
 * JD-Core Version:    0.7.0.1
 */