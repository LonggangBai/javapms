/*   1:    */ package com.portal.recruitcenter.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.recruitcenter.entity.PersonalInfo;
/*   4:    */ import com.portal.recruitcenter.entity.PersonalInfoExt;
/*   5:    */ import java.io.Serializable;
/*   6:    */ 
/*   7:    */ public abstract class BasePersonalInfoExt
/*   8:    */   implements Serializable
/*   9:    */ {
/*  10: 17 */   public static String REF = "PersonalInfoExt";
/*  11: 18 */   public static String PROP_POLITICAL = "political";
/*  12: 19 */   public static String PROP_IDCARD = "idcard";
/*  13: 20 */   public static String PROP_COMMUN1 = "commun1";
/*  14: 21 */   public static String PROP_COMMUN2 = "commun2";
/*  15: 22 */   public static String PROP_NATION = "nation";
/*  16: 23 */   public static String PROP_ADDRESS = "address";
/*  17: 24 */   public static String PROP_ID = "id";
/*  18: 25 */   public static String PROP_INFO = "info";
/*  19: 26 */   public static String PROP_MARRIAGE = "marriage";
/*  20: 27 */   public static String PROP_CARD_TYPE = "cardType";
/*  21: 28 */   public static String PROP_COMMUN_TYPE2 = "communType2";
/*  22: 29 */   public static String PROP_COMMUN_TYPE1 = "communType1";
/*  23:    */   
/*  24:    */   public BasePersonalInfoExt()
/*  25:    */   {
/*  26: 34 */     initialize();
/*  27:    */   }
/*  28:    */   
/*  29:    */   public BasePersonalInfoExt(Integer id)
/*  30:    */   {
/*  31: 41 */     setId(id);
/*  32: 42 */     initialize();
/*  33:    */   }
/*  34:    */   
/*  35: 49 */   private int hashCode = -2147483648;
/*  36:    */   private Integer id;
/*  37:    */   private Byte cardType;
/*  38:    */   private String idcard;
/*  39:    */   private String address;
/*  40:    */   private Byte communType1;
/*  41:    */   private String commun1;
/*  42:    */   private Byte communType2;
/*  43:    */   private String commun2;
/*  44:    */   private Boolean marriage;
/*  45:    */   private String political;
/*  46:    */   private String nation;
/*  47:    */   private PersonalInfo info;
/*  48:    */   
/*  49:    */   protected void initialize() {}
/*  50:    */   
/*  51:    */   public Integer getId()
/*  52:    */   {
/*  53: 78 */     return this.id;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public void setId(Integer id)
/*  57:    */   {
/*  58: 86 */     this.id = id;
/*  59: 87 */     this.hashCode = -2147483648;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public Byte getCardType()
/*  63:    */   {
/*  64: 97 */     return this.cardType;
/*  65:    */   }
/*  66:    */   
/*  67:    */   public void setCardType(Byte cardType)
/*  68:    */   {
/*  69:105 */     this.cardType = cardType;
/*  70:    */   }
/*  71:    */   
/*  72:    */   public String getIdcard()
/*  73:    */   {
/*  74:114 */     return this.idcard;
/*  75:    */   }
/*  76:    */   
/*  77:    */   public void setIdcard(String idcard)
/*  78:    */   {
/*  79:122 */     this.idcard = idcard;
/*  80:    */   }
/*  81:    */   
/*  82:    */   public String getAddress()
/*  83:    */   {
/*  84:131 */     return this.address;
/*  85:    */   }
/*  86:    */   
/*  87:    */   public void setAddress(String address)
/*  88:    */   {
/*  89:139 */     this.address = address;
/*  90:    */   }
/*  91:    */   
/*  92:    */   public Byte getCommunType1()
/*  93:    */   {
/*  94:148 */     return this.communType1;
/*  95:    */   }
/*  96:    */   
/*  97:    */   public void setCommunType1(Byte communType1)
/*  98:    */   {
/*  99:156 */     this.communType1 = communType1;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public String getCommun1()
/* 103:    */   {
/* 104:165 */     return this.commun1;
/* 105:    */   }
/* 106:    */   
/* 107:    */   public void setCommun1(String commun1)
/* 108:    */   {
/* 109:173 */     this.commun1 = commun1;
/* 110:    */   }
/* 111:    */   
/* 112:    */   public Byte getCommunType2()
/* 113:    */   {
/* 114:182 */     return this.communType2;
/* 115:    */   }
/* 116:    */   
/* 117:    */   public void setCommunType2(Byte communType2)
/* 118:    */   {
/* 119:190 */     this.communType2 = communType2;
/* 120:    */   }
/* 121:    */   
/* 122:    */   public String getCommun2()
/* 123:    */   {
/* 124:199 */     return this.commun2;
/* 125:    */   }
/* 126:    */   
/* 127:    */   public void setCommun2(String commun2)
/* 128:    */   {
/* 129:207 */     this.commun2 = commun2;
/* 130:    */   }
/* 131:    */   
/* 132:    */   public Boolean getMarriage()
/* 133:    */   {
/* 134:216 */     return this.marriage;
/* 135:    */   }
/* 136:    */   
/* 137:    */   public void setMarriage(Boolean marriage)
/* 138:    */   {
/* 139:224 */     this.marriage = marriage;
/* 140:    */   }
/* 141:    */   
/* 142:    */   public String getPolitical()
/* 143:    */   {
/* 144:233 */     return this.political;
/* 145:    */   }
/* 146:    */   
/* 147:    */   public void setPolitical(String political)
/* 148:    */   {
/* 149:241 */     this.political = political;
/* 150:    */   }
/* 151:    */   
/* 152:    */   public String getNation()
/* 153:    */   {
/* 154:250 */     return this.nation;
/* 155:    */   }
/* 156:    */   
/* 157:    */   public void setNation(String nation)
/* 158:    */   {
/* 159:258 */     this.nation = nation;
/* 160:    */   }
/* 161:    */   
/* 162:    */   public PersonalInfo getInfo()
/* 163:    */   {
/* 164:267 */     return this.info;
/* 165:    */   }
/* 166:    */   
/* 167:    */   public void setInfo(PersonalInfo info)
/* 168:    */   {
/* 169:275 */     this.info = info;
/* 170:    */   }
/* 171:    */   
/* 172:    */   public boolean equals(Object obj)
/* 173:    */   {
/* 174:282 */     if (obj == null) {
/* 175:282 */       return false;
/* 176:    */     }
/* 177:283 */     if (!(obj instanceof PersonalInfoExt)) {
/* 178:283 */       return false;
/* 179:    */     }
/* 180:285 */     PersonalInfoExt personalInfoExt = (PersonalInfoExt)obj;
/* 181:286 */     if ((getId() == null) || (personalInfoExt.getId() == null)) {
/* 182:286 */       return false;
/* 183:    */     }
/* 184:287 */     return getId().equals(personalInfoExt.getId());
/* 185:    */   }
/* 186:    */   
/* 187:    */   public int hashCode()
/* 188:    */   {
/* 189:292 */     if (-2147483648 == this.hashCode)
/* 190:    */     {
/* 191:293 */       if (getId() == null) {
/* 192:293 */         return super.hashCode();
/* 193:    */       }
/* 194:295 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 195:296 */       this.hashCode = hashStr.hashCode();
/* 196:    */     }
/* 197:299 */     return this.hashCode;
/* 198:    */   }
/* 199:    */   
/* 200:    */   public String toString()
/* 201:    */   {
/* 202:304 */     return super.toString();
/* 203:    */   }
/* 204:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.entity.base.BasePersonalInfoExt
 * JD-Core Version:    0.7.0.1
 */