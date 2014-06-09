/*   1:    */ package com.portal.recruitcenter.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.recruitcenter.entity.VipType;
/*   4:    */ import java.io.Serializable;
/*   5:    */ 
/*   6:    */ public abstract class BaseVipType
/*   7:    */   implements Serializable
/*   8:    */ {
/*   9: 17 */   public static String REF = "VipType";
/*  10: 18 */   public static String PROP_DAY_COUNT = "dayCount";
/*  11: 19 */   public static String PROP_SEND_COUNT = "sendCount";
/*  12: 20 */   public static String PROP_SETUP_LOGIN = "setupLogin";
/*  13: 21 */   public static String PROP_POST_COUNT = "postCount";
/*  14: 22 */   public static String PROP_RECEIPT_COUNT = "receiptCount";
/*  15: 23 */   public static String PROP_FAVORITE_COUNT = "favoriteCount";
/*  16: 24 */   public static String PROP_ID = "id";
/*  17: 25 */   public static String PROP_TYPE_NAME = "typeName";
/*  18: 26 */   public static String PROP_AUDITION_COUNT = "auditionCount";
/*  19:    */   
/*  20:    */   public BaseVipType()
/*  21:    */   {
/*  22: 31 */     initialize();
/*  23:    */   }
/*  24:    */   
/*  25:    */   public BaseVipType(Integer id)
/*  26:    */   {
/*  27: 38 */     setId(id);
/*  28: 39 */     initialize();
/*  29:    */   }
/*  30:    */   
/*  31:    */   public BaseVipType(Integer id, String typeName, Integer dayCount, Integer postCount, Integer favoriteCount, Integer auditionCount, Integer receiptCount, Integer sendCount, Boolean setupLogin)
/*  32:    */   {
/*  33: 56 */     setId(id);
/*  34: 57 */     setTypeName(typeName);
/*  35: 58 */     setDayCount(dayCount);
/*  36: 59 */     setPostCount(postCount);
/*  37: 60 */     setFavoriteCount(favoriteCount);
/*  38: 61 */     setAuditionCount(auditionCount);
/*  39: 62 */     setReceiptCount(receiptCount);
/*  40: 63 */     setSendCount(sendCount);
/*  41: 64 */     setSetupLogin(setupLogin);
/*  42: 65 */     initialize();
/*  43:    */   }
/*  44:    */   
/*  45: 72 */   private int hashCode = -2147483648;
/*  46:    */   private Integer id;
/*  47:    */   private String typeName;
/*  48:    */   private Integer dayCount;
/*  49:    */   private Integer postCount;
/*  50:    */   private Integer favoriteCount;
/*  51:    */   private Integer auditionCount;
/*  52:    */   private Integer receiptCount;
/*  53:    */   private Integer sendCount;
/*  54:    */   private Boolean setupLogin;
/*  55:    */   
/*  56:    */   protected void initialize() {}
/*  57:    */   
/*  58:    */   public Integer getId()
/*  59:    */   {
/*  60: 96 */     return this.id;
/*  61:    */   }
/*  62:    */   
/*  63:    */   public void setId(Integer id)
/*  64:    */   {
/*  65:104 */     this.id = id;
/*  66:105 */     this.hashCode = -2147483648;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public String getTypeName()
/*  70:    */   {
/*  71:115 */     return this.typeName;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public void setTypeName(String typeName)
/*  75:    */   {
/*  76:123 */     this.typeName = typeName;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public Integer getDayCount()
/*  80:    */   {
/*  81:132 */     return this.dayCount;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public void setDayCount(Integer dayCount)
/*  85:    */   {
/*  86:140 */     this.dayCount = dayCount;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public Integer getPostCount()
/*  90:    */   {
/*  91:149 */     return this.postCount;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public void setPostCount(Integer postCount)
/*  95:    */   {
/*  96:157 */     this.postCount = postCount;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public Integer getFavoriteCount()
/* 100:    */   {
/* 101:166 */     return this.favoriteCount;
/* 102:    */   }
/* 103:    */   
/* 104:    */   public void setFavoriteCount(Integer favoriteCount)
/* 105:    */   {
/* 106:174 */     this.favoriteCount = favoriteCount;
/* 107:    */   }
/* 108:    */   
/* 109:    */   public Integer getAuditionCount()
/* 110:    */   {
/* 111:183 */     return this.auditionCount;
/* 112:    */   }
/* 113:    */   
/* 114:    */   public void setAuditionCount(Integer auditionCount)
/* 115:    */   {
/* 116:191 */     this.auditionCount = auditionCount;
/* 117:    */   }
/* 118:    */   
/* 119:    */   public Integer getReceiptCount()
/* 120:    */   {
/* 121:200 */     return this.receiptCount;
/* 122:    */   }
/* 123:    */   
/* 124:    */   public void setReceiptCount(Integer receiptCount)
/* 125:    */   {
/* 126:208 */     this.receiptCount = receiptCount;
/* 127:    */   }
/* 128:    */   
/* 129:    */   public Integer getSendCount()
/* 130:    */   {
/* 131:217 */     return this.sendCount;
/* 132:    */   }
/* 133:    */   
/* 134:    */   public void setSendCount(Integer sendCount)
/* 135:    */   {
/* 136:225 */     this.sendCount = sendCount;
/* 137:    */   }
/* 138:    */   
/* 139:    */   public Boolean getSetupLogin()
/* 140:    */   {
/* 141:234 */     return this.setupLogin;
/* 142:    */   }
/* 143:    */   
/* 144:    */   public void setSetupLogin(Boolean setupLogin)
/* 145:    */   {
/* 146:242 */     this.setupLogin = setupLogin;
/* 147:    */   }
/* 148:    */   
/* 149:    */   public boolean equals(Object obj)
/* 150:    */   {
/* 151:249 */     if (obj == null) {
/* 152:249 */       return false;
/* 153:    */     }
/* 154:250 */     if (!(obj instanceof VipType)) {
/* 155:250 */       return false;
/* 156:    */     }
/* 157:252 */     VipType vipType = (VipType)obj;
/* 158:253 */     if ((getId() == null) || (vipType.getId() == null)) {
/* 159:253 */       return false;
/* 160:    */     }
/* 161:254 */     return getId().equals(vipType.getId());
/* 162:    */   }
/* 163:    */   
/* 164:    */   public int hashCode()
/* 165:    */   {
/* 166:259 */     if (-2147483648 == this.hashCode)
/* 167:    */     {
/* 168:260 */       if (getId() == null) {
/* 169:260 */         return super.hashCode();
/* 170:    */       }
/* 171:262 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 172:263 */       this.hashCode = hashStr.hashCode();
/* 173:    */     }
/* 174:266 */     return this.hashCode;
/* 175:    */   }
/* 176:    */   
/* 177:    */   public String toString()
/* 178:    */   {
/* 179:271 */     return super.toString();
/* 180:    */   }
/* 181:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.entity.base.BaseVipType
 * JD-Core Version:    0.7.0.1
 */