/*   1:    */ package com.portal.recruitcenter.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.recruitcenter.entity.JobIntent;
/*   4:    */ import com.portal.recruitcenter.entity.PersonalInfo;
/*   5:    */ import com.portal.recruitcenter.entity.Resume;
/*   6:    */ import com.portal.recruitcenter.entity.ResumeExt;
/*   7:    */ import java.io.Serializable;
/*   8:    */ import java.util.Date;
/*   9:    */ 
/*  10:    */ public abstract class BaseResume
/*  11:    */   implements Serializable
/*  12:    */ {
/*  13: 17 */   public static String REF = "Resume";
/*  14: 18 */   public static String PROP_LANG = "lang";
/*  15: 19 */   public static String PROP_NAME = "name";
/*  16: 20 */   public static String PROP_OPEN = "open";
/*  17: 21 */   public static String PROP_INTENT = "intent";
/*  18: 22 */   public static String PROP_EXT = "ext";
/*  19: 23 */   public static String PROP_CREATE_TIME = "createTime";
/*  20: 24 */   public static String PROP_UPDATE_TIME = "updateTime";
/*  21: 25 */   public static String PROP_ID = "id";
/*  22: 26 */   public static String PROP_APPLY_DEF = "applyDef";
/*  23: 27 */   public static String PROP_PERSONAL = "personal";
/*  24:    */   
/*  25:    */   public BaseResume()
/*  26:    */   {
/*  27: 32 */     initialize();
/*  28:    */   }
/*  29:    */   
/*  30:    */   public BaseResume(Integer id)
/*  31:    */   {
/*  32: 39 */     setId(id);
/*  33: 40 */     initialize();
/*  34:    */   }
/*  35:    */   
/*  36:    */   public BaseResume(Integer id, PersonalInfo personal, String name, String lang, Byte open, Boolean applyDef, Date createTime)
/*  37:    */   {
/*  38: 55 */     setId(id);
/*  39: 56 */     setPersonal(personal);
/*  40: 57 */     setName(name);
/*  41: 58 */     setLang(lang);
/*  42: 59 */     setOpen(open);
/*  43: 60 */     setApplyDef(applyDef);
/*  44: 61 */     setCreateTime(createTime);
/*  45: 62 */     initialize();
/*  46:    */   }
/*  47:    */   
/*  48: 69 */   private int hashCode = -2147483648;
/*  49:    */   private Integer id;
/*  50:    */   private String name;
/*  51:    */   private String lang;
/*  52:    */   private Byte open;
/*  53:    */   private Boolean applyDef;
/*  54:    */   private Date createTime;
/*  55:    */   private Date updateTime;
/*  56:    */   private ResumeExt ext;
/*  57:    */   private JobIntent intent;
/*  58:    */   private PersonalInfo personal;
/*  59:    */   
/*  60:    */   protected void initialize() {}
/*  61:    */   
/*  62:    */   public Integer getId()
/*  63:    */   {
/*  64: 98 */     return this.id;
/*  65:    */   }
/*  66:    */   
/*  67:    */   public void setId(Integer id)
/*  68:    */   {
/*  69:106 */     this.id = id;
/*  70:107 */     this.hashCode = -2147483648;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public String getName()
/*  74:    */   {
/*  75:117 */     return this.name;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public void setName(String name)
/*  79:    */   {
/*  80:125 */     this.name = name;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public String getLang()
/*  84:    */   {
/*  85:134 */     return this.lang;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public void setLang(String lang)
/*  89:    */   {
/*  90:142 */     this.lang = lang;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public Byte getOpen()
/*  94:    */   {
/*  95:151 */     return this.open;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public void setOpen(Byte open)
/*  99:    */   {
/* 100:159 */     this.open = open;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public Boolean getApplyDef()
/* 104:    */   {
/* 105:168 */     return this.applyDef;
/* 106:    */   }
/* 107:    */   
/* 108:    */   public void setApplyDef(Boolean applyDef)
/* 109:    */   {
/* 110:176 */     this.applyDef = applyDef;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public Date getCreateTime()
/* 114:    */   {
/* 115:185 */     return this.createTime;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public void setCreateTime(Date createTime)
/* 119:    */   {
/* 120:193 */     this.createTime = createTime;
/* 121:    */   }
/* 122:    */   
/* 123:    */   public Date getUpdateTime()
/* 124:    */   {
/* 125:202 */     return this.updateTime;
/* 126:    */   }
/* 127:    */   
/* 128:    */   public void setUpdateTime(Date updateTime)
/* 129:    */   {
/* 130:210 */     this.updateTime = updateTime;
/* 131:    */   }
/* 132:    */   
/* 133:    */   public ResumeExt getExt()
/* 134:    */   {
/* 135:219 */     return this.ext;
/* 136:    */   }
/* 137:    */   
/* 138:    */   public void setExt(ResumeExt ext)
/* 139:    */   {
/* 140:227 */     this.ext = ext;
/* 141:    */   }
/* 142:    */   
/* 143:    */   public JobIntent getIntent()
/* 144:    */   {
/* 145:236 */     return this.intent;
/* 146:    */   }
/* 147:    */   
/* 148:    */   public void setIntent(JobIntent intent)
/* 149:    */   {
/* 150:244 */     this.intent = intent;
/* 151:    */   }
/* 152:    */   
/* 153:    */   public PersonalInfo getPersonal()
/* 154:    */   {
/* 155:253 */     return this.personal;
/* 156:    */   }
/* 157:    */   
/* 158:    */   public void setPersonal(PersonalInfo personal)
/* 159:    */   {
/* 160:261 */     this.personal = personal;
/* 161:    */   }
/* 162:    */   
/* 163:    */   public boolean equals(Object obj)
/* 164:    */   {
/* 165:268 */     if (obj == null) {
/* 166:268 */       return false;
/* 167:    */     }
/* 168:269 */     if (!(obj instanceof Resume)) {
/* 169:269 */       return false;
/* 170:    */     }
/* 171:271 */     Resume resume = (Resume)obj;
/* 172:272 */     if ((getId() == null) || (resume.getId() == null)) {
/* 173:272 */       return false;
/* 174:    */     }
/* 175:273 */     return getId().equals(resume.getId());
/* 176:    */   }
/* 177:    */   
/* 178:    */   public int hashCode()
/* 179:    */   {
/* 180:278 */     if (-2147483648 == this.hashCode)
/* 181:    */     {
/* 182:279 */       if (getId() == null) {
/* 183:279 */         return super.hashCode();
/* 184:    */       }
/* 185:281 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 186:282 */       this.hashCode = hashStr.hashCode();
/* 187:    */     }
/* 188:285 */     return this.hashCode;
/* 189:    */   }
/* 190:    */   
/* 191:    */   public String toString()
/* 192:    */   {
/* 193:290 */     return super.toString();
/* 194:    */   }
/* 195:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.entity.base.BaseResume
 * JD-Core Version:    0.7.0.1
 */