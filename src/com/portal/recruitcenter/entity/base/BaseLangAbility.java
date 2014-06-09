/*   1:    */ package com.portal.recruitcenter.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.datacenter.commdata.entity.ForeignLang;
/*   4:    */ import com.portal.recruitcenter.entity.LangAbility;
/*   5:    */ import com.portal.recruitcenter.entity.Resume;
/*   6:    */ import java.io.Serializable;
/*   7:    */ 
/*   8:    */ public abstract class BaseLangAbility
/*   9:    */   implements Serializable
/*  10:    */ {
/*  11: 17 */   public static String REF = "LangAbility";
/*  12: 18 */   public static String PROP_LANG = "lang";
/*  13: 19 */   public static String PROP_COMMUNICATIONS = "communications";
/*  14: 20 */   public static String PROP_GRADE = "grade";
/*  15: 21 */   public static String PROP_RESUME = "resume";
/*  16: 22 */   public static String PROP_CERT_TYPE = "certType";
/*  17: 23 */   public static String PROP_ID = "id";
/*  18: 24 */   public static String PROP_LITERACY = "literacy";
/*  19:    */   
/*  20:    */   public BaseLangAbility()
/*  21:    */   {
/*  22: 29 */     initialize();
/*  23:    */   }
/*  24:    */   
/*  25:    */   public BaseLangAbility(Integer id)
/*  26:    */   {
/*  27: 36 */     setId(id);
/*  28: 37 */     initialize();
/*  29:    */   }
/*  30:    */   
/*  31:    */   public BaseLangAbility(Integer id, Resume resume, ForeignLang lang)
/*  32:    */   {
/*  33: 48 */     setId(id);
/*  34: 49 */     setResume(resume);
/*  35: 50 */     setLang(lang);
/*  36: 51 */     initialize();
/*  37:    */   }
/*  38:    */   
/*  39: 58 */   private int hashCode = -2147483648;
/*  40:    */   private Integer id;
/*  41:    */   private String certType;
/*  42:    */   private String grade;
/*  43:    */   private Byte literacy;
/*  44:    */   private Byte communications;
/*  45:    */   private Resume resume;
/*  46:    */   private ForeignLang lang;
/*  47:    */   
/*  48:    */   protected void initialize() {}
/*  49:    */   
/*  50:    */   public Integer getId()
/*  51:    */   {
/*  52: 82 */     return this.id;
/*  53:    */   }
/*  54:    */   
/*  55:    */   public void setId(Integer id)
/*  56:    */   {
/*  57: 90 */     this.id = id;
/*  58: 91 */     this.hashCode = -2147483648;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public String getCertType()
/*  62:    */   {
/*  63:101 */     return this.certType;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public void setCertType(String certType)
/*  67:    */   {
/*  68:109 */     this.certType = certType;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public String getGrade()
/*  72:    */   {
/*  73:118 */     return this.grade;
/*  74:    */   }
/*  75:    */   
/*  76:    */   public void setGrade(String grade)
/*  77:    */   {
/*  78:126 */     this.grade = grade;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public Byte getLiteracy()
/*  82:    */   {
/*  83:135 */     return this.literacy;
/*  84:    */   }
/*  85:    */   
/*  86:    */   public void setLiteracy(Byte literacy)
/*  87:    */   {
/*  88:143 */     this.literacy = literacy;
/*  89:    */   }
/*  90:    */   
/*  91:    */   public Byte getCommunications()
/*  92:    */   {
/*  93:152 */     return this.communications;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public void setCommunications(Byte communications)
/*  97:    */   {
/*  98:160 */     this.communications = communications;
/*  99:    */   }
/* 100:    */   
/* 101:    */   public Resume getResume()
/* 102:    */   {
/* 103:169 */     return this.resume;
/* 104:    */   }
/* 105:    */   
/* 106:    */   public void setResume(Resume resume)
/* 107:    */   {
/* 108:177 */     this.resume = resume;
/* 109:    */   }
/* 110:    */   
/* 111:    */   public ForeignLang getLang()
/* 112:    */   {
/* 113:186 */     return this.lang;
/* 114:    */   }
/* 115:    */   
/* 116:    */   public void setLang(ForeignLang lang)
/* 117:    */   {
/* 118:194 */     this.lang = lang;
/* 119:    */   }
/* 120:    */   
/* 121:    */   public boolean equals(Object obj)
/* 122:    */   {
/* 123:201 */     if (obj == null) {
/* 124:201 */       return false;
/* 125:    */     }
/* 126:202 */     if (!(obj instanceof LangAbility)) {
/* 127:202 */       return false;
/* 128:    */     }
/* 129:204 */     LangAbility langAbility = (LangAbility)obj;
/* 130:205 */     if ((getId() == null) || (langAbility.getId() == null)) {
/* 131:205 */       return false;
/* 132:    */     }
/* 133:206 */     return getId().equals(langAbility.getId());
/* 134:    */   }
/* 135:    */   
/* 136:    */   public int hashCode()
/* 137:    */   {
/* 138:211 */     if (-2147483648 == this.hashCode)
/* 139:    */     {
/* 140:212 */       if (getId() == null) {
/* 141:212 */         return super.hashCode();
/* 142:    */       }
/* 143:214 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 144:215 */       this.hashCode = hashStr.hashCode();
/* 145:    */     }
/* 146:218 */     return this.hashCode;
/* 147:    */   }
/* 148:    */   
/* 149:    */   public String toString()
/* 150:    */   {
/* 151:223 */     return super.toString();
/* 152:    */   }
/* 153:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.entity.base.BaseLangAbility
 * JD-Core Version:    0.7.0.1
 */