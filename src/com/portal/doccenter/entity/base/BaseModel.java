/*   1:    */ package com.portal.doccenter.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.doccenter.entity.Model;
/*   4:    */ import com.portal.doccenter.entity.ModelField;
/*   5:    */ import java.io.Serializable;
/*   6:    */ import java.util.Set;
/*   7:    */ import java.util.TreeSet;
/*   8:    */ 
/*   9:    */ public abstract class BaseModel
/*  10:    */   implements Serializable
/*  11:    */ {
/*  12: 17 */   public static String REF = "Model";
/*  13: 18 */   public static String PROP_TPL_SEARCH = "tplSearch";
/*  14: 19 */   public static String PROP_NAME = "name";
/*  15: 20 */   public static String PROP_TPL_PRINT = "tplPrint";
/*  16: 21 */   public static String PROP_TPL_ADV_SEARCH = "tplAdvSearch";
/*  17: 22 */   public static String PROP_TPL_DOC = "tplDoc";
/*  18: 23 */   public static String PROP_DISABLED = "disabled";
/*  19: 24 */   public static String PROP_TPL_COMMENT = "tplComment";
/*  20: 25 */   public static String PROP_ID = "id";
/*  21: 26 */   public static String PROP_ICON = "icon";
/*  22: 27 */   public static String PROP_PRIORITY = "priority";
/*  23:    */   
/*  24:    */   public BaseModel()
/*  25:    */   {
/*  26: 32 */     initialize();
/*  27:    */   }
/*  28:    */   
/*  29:    */   public BaseModel(Integer id)
/*  30:    */   {
/*  31: 39 */     setId(id);
/*  32: 40 */     initialize();
/*  33:    */   }
/*  34:    */   
/*  35:    */   public BaseModel(Integer id, String name, Integer priority, Boolean disabled)
/*  36:    */   {
/*  37: 52 */     setId(id);
/*  38: 53 */     setName(name);
/*  39: 54 */     setPriority(priority);
/*  40: 55 */     setDisabled(disabled);
/*  41: 56 */     initialize();
/*  42:    */   }
/*  43:    */   
/*  44: 63 */   private int hashCode = -2147483648;
/*  45:    */   private Integer id;
/*  46:    */   private String name;
/*  47:    */   private String icon;
/*  48:    */   private String tplDoc;
/*  49:    */   private String tplPrint;
/*  50:    */   private String tplSearch;
/*  51:    */   private String tplAdvSearch;
/*  52:    */   private String tplComment;
/*  53:    */   private Integer priority;
/*  54:    */   private Boolean disabled;
/*  55:    */   private Set<ModelField> fields;
/*  56:    */   
/*  57:    */   protected void initialize() {}
/*  58:    */   
/*  59:    */   public Integer getId()
/*  60:    */   {
/*  61: 91 */     return this.id;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public void setId(Integer id)
/*  65:    */   {
/*  66: 99 */     this.id = id;
/*  67:100 */     this.hashCode = -2147483648;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public String getName()
/*  71:    */   {
/*  72:110 */     return this.name;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public void setName(String name)
/*  76:    */   {
/*  77:118 */     this.name = name;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public String getIcon()
/*  81:    */   {
/*  82:127 */     return this.icon;
/*  83:    */   }
/*  84:    */   
/*  85:    */   public void setIcon(String icon)
/*  86:    */   {
/*  87:135 */     this.icon = icon;
/*  88:    */   }
/*  89:    */   
/*  90:    */   public String getTplDoc()
/*  91:    */   {
/*  92:144 */     return this.tplDoc;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public void setTplDoc(String tplDoc)
/*  96:    */   {
/*  97:152 */     this.tplDoc = tplDoc;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public String getTplPrint()
/* 101:    */   {
/* 102:161 */     return this.tplPrint;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public void setTplPrint(String tplPrint)
/* 106:    */   {
/* 107:169 */     this.tplPrint = tplPrint;
/* 108:    */   }
/* 109:    */   
/* 110:    */   public String getTplSearch()
/* 111:    */   {
/* 112:178 */     return this.tplSearch;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public void setTplSearch(String tplSearch)
/* 116:    */   {
/* 117:186 */     this.tplSearch = tplSearch;
/* 118:    */   }
/* 119:    */   
/* 120:    */   public String getTplAdvSearch()
/* 121:    */   {
/* 122:195 */     return this.tplAdvSearch;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public void setTplAdvSearch(String tplAdvSearch)
/* 126:    */   {
/* 127:203 */     this.tplAdvSearch = tplAdvSearch;
/* 128:    */   }
/* 129:    */   
/* 130:    */   public String getTplComment()
/* 131:    */   {
/* 132:212 */     return this.tplComment;
/* 133:    */   }
/* 134:    */   
/* 135:    */   public void setTplComment(String tplComment)
/* 136:    */   {
/* 137:220 */     this.tplComment = tplComment;
/* 138:    */   }
/* 139:    */   
/* 140:    */   public Integer getPriority()
/* 141:    */   {
/* 142:229 */     return this.priority;
/* 143:    */   }
/* 144:    */   
/* 145:    */   public void setPriority(Integer priority)
/* 146:    */   {
/* 147:237 */     this.priority = priority;
/* 148:    */   }
/* 149:    */   
/* 150:    */   public Boolean getDisabled()
/* 151:    */   {
/* 152:246 */     return this.disabled;
/* 153:    */   }
/* 154:    */   
/* 155:    */   public void setDisabled(Boolean disabled)
/* 156:    */   {
/* 157:254 */     this.disabled = disabled;
/* 158:    */   }
/* 159:    */   
/* 160:    */   public Set<ModelField> getFields()
/* 161:    */   {
/* 162:263 */     return this.fields;
/* 163:    */   }
/* 164:    */   
/* 165:    */   public void setFields(Set<ModelField> fields)
/* 166:    */   {
/* 167:271 */     this.fields = fields;
/* 168:    */   }
/* 169:    */   
/* 170:    */   public void addToitems(ModelField modelField)
/* 171:    */   {
/* 172:275 */     if (getFields() == null) {
/* 173:275 */       setFields(new TreeSet());
/* 174:    */     }
/* 175:276 */     getFields().add(modelField);
/* 176:    */   }
/* 177:    */   
/* 178:    */   public boolean equals(Object obj)
/* 179:    */   {
/* 180:283 */     if (obj == null) {
/* 181:283 */       return false;
/* 182:    */     }
/* 183:284 */     if (!(obj instanceof Model)) {
/* 184:284 */       return false;
/* 185:    */     }
/* 186:286 */     Model model = (Model)obj;
/* 187:287 */     if ((getId() == null) || (model.getId() == null)) {
/* 188:287 */       return false;
/* 189:    */     }
/* 190:288 */     return getId().equals(model.getId());
/* 191:    */   }
/* 192:    */   
/* 193:    */   public int hashCode()
/* 194:    */   {
/* 195:293 */     if (-2147483648 == this.hashCode)
/* 196:    */     {
/* 197:294 */       if (getId() == null) {
/* 198:294 */         return super.hashCode();
/* 199:    */       }
/* 200:296 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 201:297 */       this.hashCode = hashStr.hashCode();
/* 202:    */     }
/* 203:300 */     return this.hashCode;
/* 204:    */   }
/* 205:    */   
/* 206:    */   public String toString()
/* 207:    */   {
/* 208:305 */     return super.toString();
/* 209:    */   }
/* 210:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.entity.base.BaseModel
 * JD-Core Version:    0.7.0.1
 */