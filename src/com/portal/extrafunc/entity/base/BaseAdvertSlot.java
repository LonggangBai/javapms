/*   1:    */ package com.portal.extrafunc.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.extrafunc.entity.AdvertSlot;
/*   4:    */ import com.portal.sysmgr.entity.Site;
/*   5:    */ import java.io.Serializable;
/*   6:    */ 
/*   7:    */ public abstract class BaseAdvertSlot
/*   8:    */   implements Serializable
/*   9:    */ {
/*  10: 17 */   public static String REF = "AdvertSlot";
/*  11: 18 */   public static String PROP_REMAIN = "remain";
/*  12: 19 */   public static String PROP_NAME = "name";
/*  13: 20 */   public static String PROP_SITE = "site";
/*  14: 21 */   public static String PROP_SLOT_TYPE = "slotType";
/*  15: 22 */   public static String PROP_HEIGHT = "height";
/*  16: 23 */   public static String PROP_ID = "id";
/*  17: 24 */   public static String PROP_SEXPLAIN = "sexplain";
/*  18: 25 */   public static String PROP_WIDTH = "width";
/*  19: 26 */   public static String PROP_IDLEHOLDER = "idleholder";
/*  20: 27 */   public static String PROP_SCROLLBAR = "scrollbar";
/*  21:    */   
/*  22:    */   public BaseAdvertSlot()
/*  23:    */   {
/*  24: 32 */     initialize();
/*  25:    */   }
/*  26:    */   
/*  27:    */   public BaseAdvertSlot(Integer id)
/*  28:    */   {
/*  29: 39 */     setId(id);
/*  30: 40 */     initialize();
/*  31:    */   }
/*  32:    */   
/*  33:    */   public BaseAdvertSlot(Integer id, Site site, String name, Short slotType)
/*  34:    */   {
/*  35: 52 */     setId(id);
/*  36: 53 */     setSite(site);
/*  37: 54 */     setName(name);
/*  38: 55 */     setSlotType(slotType);
/*  39: 56 */     initialize();
/*  40:    */   }
/*  41:    */   
/*  42: 63 */   private int hashCode = -2147483648;
/*  43:    */   private Integer id;
/*  44:    */   private String name;
/*  45:    */   private Short slotType;
/*  46:    */   private Integer height;
/*  47:    */   private Integer width;
/*  48:    */   private Integer remain;
/*  49:    */   private Boolean scrollbar;
/*  50:    */   private String sexplain;
/*  51:    */   private Boolean idleholder;
/*  52:    */   private Boolean rotation;
/*  53:    */   private Site site;
/*  54:    */   
/*  55:    */   protected void initialize() {}
/*  56:    */   
/*  57:    */   public Integer getId()
/*  58:    */   {
/*  59: 91 */     return this.id;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public void setId(Integer id)
/*  63:    */   {
/*  64: 99 */     this.id = id;
/*  65:100 */     this.hashCode = -2147483648;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public String getName()
/*  69:    */   {
/*  70:110 */     return this.name;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public void setName(String name)
/*  74:    */   {
/*  75:118 */     this.name = name;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public Short getSlotType()
/*  79:    */   {
/*  80:127 */     return this.slotType;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public void setSlotType(Short slotType)
/*  84:    */   {
/*  85:135 */     this.slotType = slotType;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public Integer getHeight()
/*  89:    */   {
/*  90:144 */     return this.height;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public void setHeight(Integer height)
/*  94:    */   {
/*  95:152 */     this.height = height;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public Integer getWidth()
/*  99:    */   {
/* 100:161 */     return this.width;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public void setWidth(Integer width)
/* 104:    */   {
/* 105:169 */     this.width = width;
/* 106:    */   }
/* 107:    */   
/* 108:    */   public Integer getRemain()
/* 109:    */   {
/* 110:178 */     return this.remain;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public void setRemain(Integer remain)
/* 114:    */   {
/* 115:186 */     this.remain = remain;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public Boolean getScrollbar()
/* 119:    */   {
/* 120:195 */     return this.scrollbar;
/* 121:    */   }
/* 122:    */   
/* 123:    */   public void setScrollbar(Boolean scrollbar)
/* 124:    */   {
/* 125:203 */     this.scrollbar = scrollbar;
/* 126:    */   }
/* 127:    */   
/* 128:    */   public String getSexplain()
/* 129:    */   {
/* 130:212 */     return this.sexplain;
/* 131:    */   }
/* 132:    */   
/* 133:    */   public void setSexplain(String sexplain)
/* 134:    */   {
/* 135:220 */     this.sexplain = sexplain;
/* 136:    */   }
/* 137:    */   
/* 138:    */   public Boolean getIdleholder()
/* 139:    */   {
/* 140:229 */     return this.idleholder;
/* 141:    */   }
/* 142:    */   
/* 143:    */   public void setIdleholder(Boolean idleholder)
/* 144:    */   {
/* 145:237 */     this.idleholder = idleholder;
/* 146:    */   }
/* 147:    */   
/* 148:    */   public Boolean getRotation()
/* 149:    */   {
/* 150:243 */     return this.rotation;
/* 151:    */   }
/* 152:    */   
/* 153:    */   public void setRotation(Boolean rotation)
/* 154:    */   {
/* 155:247 */     this.rotation = rotation;
/* 156:    */   }
/* 157:    */   
/* 158:    */   public Site getSite()
/* 159:    */   {
/* 160:254 */     return this.site;
/* 161:    */   }
/* 162:    */   
/* 163:    */   public void setSite(Site site)
/* 164:    */   {
/* 165:262 */     this.site = site;
/* 166:    */   }
/* 167:    */   
/* 168:    */   public boolean equals(Object obj)
/* 169:    */   {
/* 170:269 */     if (obj == null) {
/* 171:269 */       return false;
/* 172:    */     }
/* 173:270 */     if (!(obj instanceof AdvertSlot)) {
/* 174:270 */       return false;
/* 175:    */     }
/* 176:272 */     AdvertSlot advertSlot = (AdvertSlot)obj;
/* 177:273 */     if ((getId() == null) || (advertSlot.getId() == null)) {
/* 178:273 */       return false;
/* 179:    */     }
/* 180:274 */     return getId().equals(advertSlot.getId());
/* 181:    */   }
/* 182:    */   
/* 183:    */   public int hashCode()
/* 184:    */   {
/* 185:279 */     if (-2147483648 == this.hashCode)
/* 186:    */     {
/* 187:280 */       if (getId() == null) {
/* 188:280 */         return super.hashCode();
/* 189:    */       }
/* 190:282 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 191:283 */       this.hashCode = hashStr.hashCode();
/* 192:    */     }
/* 193:286 */     return this.hashCode;
/* 194:    */   }
/* 195:    */   
/* 196:    */   public String toString()
/* 197:    */   {
/* 198:291 */     return super.toString();
/* 199:    */   }
/* 200:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.entity.base.BaseAdvertSlot
 * JD-Core Version:    0.7.0.1
 */