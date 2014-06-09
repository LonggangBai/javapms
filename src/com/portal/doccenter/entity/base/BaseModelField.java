/*   1:    */ package com.portal.doccenter.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.doccenter.entity.Model;
/*   4:    */ import com.portal.doccenter.entity.ModelField;
/*   5:    */ import java.io.Serializable;
/*   6:    */ 
/*   7:    */ public abstract class BaseModelField
/*   8:    */   implements Serializable
/*   9:    */ {
/*  10: 15 */   public static String REF = "ModelField";
/*  11: 16 */   public static String PROP_DATA_TYPE = "dataType";
/*  12: 17 */   public static String PROP_MODEL = "model";
/*  13: 18 */   public static String PROP_ECONOMY = "economy";
/*  14: 19 */   public static String PROP_MAXLENGTH = "maxlength";
/*  15: 20 */   public static String PROP_SHOW = "show";
/*  16: 21 */   public static String PROP_HEIGHT = "height";
/*  17: 22 */   public static String PROP_PRIORITY = "priority";
/*  18: 23 */   public static String PROP_SINGLE = "single";
/*  19: 24 */   public static String PROP_NAME = "name";
/*  20: 25 */   public static String PROP_EXPLAIN = "explain";
/*  21: 26 */   public static String PROP_ID = "id";
/*  22: 27 */   public static String PROP_LABEL = "label";
/*  23: 28 */   public static String PROP_WIDTH = "width";
/*  24: 29 */   public static String PROP_SIZE = "size";
/*  25:    */   
/*  26:    */   public BaseModelField()
/*  27:    */   {
/*  28: 33 */     initialize();
/*  29:    */   }
/*  30:    */   
/*  31:    */   public BaseModelField(Integer id)
/*  32:    */   {
/*  33: 40 */     setId(id);
/*  34: 41 */     initialize();
/*  35:    */   }
/*  36:    */   
/*  37:    */   public BaseModelField(Integer id, Model model, String name, String label, Integer dataType, Boolean single, Boolean economy, Boolean show)
/*  38:    */   {
/*  39: 53 */     setId(id);
/*  40: 54 */     setModel(model);
/*  41: 55 */     setName(name);
/*  42: 56 */     setLabel(label);
/*  43: 57 */     setDataType(dataType);
/*  44: 58 */     setSingle(single);
/*  45: 59 */     setEconomy(economy);
/*  46: 60 */     setShow(show);
/*  47: 61 */     initialize();
/*  48:    */   }
/*  49:    */   
/*  50: 67 */   private int hashCode = -2147483648;
/*  51:    */   private Integer id;
/*  52:    */   private String name;
/*  53:    */   private String label;
/*  54:    */   private Integer priority;
/*  55:    */   private String size;
/*  56:    */   private String maxlength;
/*  57:    */   private String width;
/*  58:    */   private String height;
/*  59:    */   private String tip;
/*  60:    */   private String valueList;
/*  61:    */   private Integer dataType;
/*  62:    */   private Boolean required;
/*  63:    */   private Boolean single;
/*  64:    */   private Boolean economy;
/*  65:    */   private Boolean show;
/*  66:    */   private Model model;
/*  67:    */   
/*  68:    */   protected void initialize() {}
/*  69:    */   
/*  70:    */   public Integer getId()
/*  71:    */   {
/*  72: 97 */     return this.id;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public void setId(Integer id)
/*  76:    */   {
/*  77:107 */     this.id = id;
/*  78:108 */     this.hashCode = -2147483648;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public String getName()
/*  82:    */   {
/*  83:115 */     return this.name;
/*  84:    */   }
/*  85:    */   
/*  86:    */   public void setName(String name)
/*  87:    */   {
/*  88:125 */     this.name = name;
/*  89:    */   }
/*  90:    */   
/*  91:    */   public String getLabel()
/*  92:    */   {
/*  93:132 */     return this.label;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public void setLabel(String label)
/*  97:    */   {
/*  98:142 */     this.label = label;
/*  99:    */   }
/* 100:    */   
/* 101:    */   public Integer getPriority()
/* 102:    */   {
/* 103:149 */     return this.priority;
/* 104:    */   }
/* 105:    */   
/* 106:    */   public void setPriority(Integer priority)
/* 107:    */   {
/* 108:159 */     this.priority = priority;
/* 109:    */   }
/* 110:    */   
/* 111:    */   public String getSize()
/* 112:    */   {
/* 113:166 */     return this.size;
/* 114:    */   }
/* 115:    */   
/* 116:    */   public void setSize(String size)
/* 117:    */   {
/* 118:176 */     this.size = size;
/* 119:    */   }
/* 120:    */   
/* 121:    */   public String getMaxlength()
/* 122:    */   {
/* 123:183 */     return this.maxlength;
/* 124:    */   }
/* 125:    */   
/* 126:    */   public void setMaxlength(String maxlength)
/* 127:    */   {
/* 128:193 */     this.maxlength = maxlength;
/* 129:    */   }
/* 130:    */   
/* 131:    */   public String getWidth()
/* 132:    */   {
/* 133:200 */     return this.width;
/* 134:    */   }
/* 135:    */   
/* 136:    */   public void setWidth(String width)
/* 137:    */   {
/* 138:210 */     this.width = width;
/* 139:    */   }
/* 140:    */   
/* 141:    */   public String getHeight()
/* 142:    */   {
/* 143:217 */     return this.height;
/* 144:    */   }
/* 145:    */   
/* 146:    */   public void setHeight(String height)
/* 147:    */   {
/* 148:227 */     this.height = height;
/* 149:    */   }
/* 150:    */   
/* 151:    */   public String getTip()
/* 152:    */   {
/* 153:234 */     return this.tip;
/* 154:    */   }
/* 155:    */   
/* 156:    */   public void setTip(String tip)
/* 157:    */   {
/* 158:244 */     this.tip = tip;
/* 159:    */   }
/* 160:    */   
/* 161:    */   public Integer getDataType()
/* 162:    */   {
/* 163:251 */     return this.dataType;
/* 164:    */   }
/* 165:    */   
/* 166:    */   public void setDataType(Integer dataType)
/* 167:    */   {
/* 168:261 */     this.dataType = dataType;
/* 169:    */   }
/* 170:    */   
/* 171:    */   public Boolean getRequired()
/* 172:    */   {
/* 173:265 */     return this.required;
/* 174:    */   }
/* 175:    */   
/* 176:    */   public void setRequired(Boolean required)
/* 177:    */   {
/* 178:269 */     this.required = required;
/* 179:    */   }
/* 180:    */   
/* 181:    */   public Boolean getSingle()
/* 182:    */   {
/* 183:276 */     return this.single;
/* 184:    */   }
/* 185:    */   
/* 186:    */   public void setSingle(Boolean single)
/* 187:    */   {
/* 188:286 */     this.single = single;
/* 189:    */   }
/* 190:    */   
/* 191:    */   public Boolean getEconomy()
/* 192:    */   {
/* 193:293 */     return this.economy;
/* 194:    */   }
/* 195:    */   
/* 196:    */   public void setEconomy(Boolean economy)
/* 197:    */   {
/* 198:303 */     this.economy = economy;
/* 199:    */   }
/* 200:    */   
/* 201:    */   public Boolean getShow()
/* 202:    */   {
/* 203:310 */     return this.show;
/* 204:    */   }
/* 205:    */   
/* 206:    */   public void setShow(Boolean show)
/* 207:    */   {
/* 208:320 */     this.show = show;
/* 209:    */   }
/* 210:    */   
/* 211:    */   public Model getModel()
/* 212:    */   {
/* 213:327 */     return this.model;
/* 214:    */   }
/* 215:    */   
/* 216:    */   public void setModel(Model model)
/* 217:    */   {
/* 218:337 */     this.model = model;
/* 219:    */   }
/* 220:    */   
/* 221:    */   public String getValueList()
/* 222:    */   {
/* 223:344 */     return this.valueList;
/* 224:    */   }
/* 225:    */   
/* 226:    */   public void setValueList(String valueList)
/* 227:    */   {
/* 228:354 */     this.valueList = valueList;
/* 229:    */   }
/* 230:    */   
/* 231:    */   public boolean equals(Object obj)
/* 232:    */   {
/* 233:358 */     if (obj == null) {
/* 234:359 */       return false;
/* 235:    */     }
/* 236:360 */     if (!(obj instanceof ModelField)) {
/* 237:361 */       return false;
/* 238:    */     }
/* 239:363 */     ModelField modelField = (ModelField)obj;
/* 240:364 */     if ((getId() == null) || (modelField.getId() == null)) {
/* 241:365 */       return false;
/* 242:    */     }
/* 243:367 */     return getId().equals(modelField.getId());
/* 244:    */   }
/* 245:    */   
/* 246:    */   public int hashCode()
/* 247:    */   {
/* 248:372 */     if (-2147483648 == this.hashCode)
/* 249:    */     {
/* 250:373 */       if (getId() == null) {
/* 251:374 */         return super.hashCode();
/* 252:    */       }
/* 253:376 */       String hashStr = getClass().getName() + ":" + 
/* 254:377 */         getId().hashCode();
/* 255:378 */       this.hashCode = hashStr.hashCode();
/* 256:    */     }
/* 257:381 */     return this.hashCode;
/* 258:    */   }
/* 259:    */   
/* 260:    */   public String toString()
/* 261:    */   {
/* 262:385 */     return super.toString();
/* 263:    */   }
/* 264:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.entity.base.BaseModelField
 * JD-Core Version:    0.7.0.1
 */