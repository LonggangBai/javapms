/*   1:    */ package com.portal.extrafunc.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.extrafunc.entity.Questionnaire;
/*   4:    */ import com.portal.extrafunc.entity.SurveyItem;
/*   5:    */ import com.portal.extrafunc.entity.SurveyTheme;
/*   6:    */ import java.io.Serializable;
/*   7:    */ import java.util.Set;
/*   8:    */ 
/*   9:    */ public abstract class BaseSurveyTheme
/*  10:    */   implements Serializable
/*  11:    */ {
/*  12: 17 */   public static String REF = "SurveyTheme";
/*  13: 18 */   public static String PROP_SURVEY_TYPE = "surveyType";
/*  14: 19 */   public static String PROP_TOTAL_COUNT = "totalCount";
/*  15: 20 */   public static String PROP_MAXLENGTH = "maxlength";
/*  16: 21 */   public static String PROP_NAIRE = "naire";
/*  17: 22 */   public static String PROP_ID = "id";
/*  18: 23 */   public static String PROP_SHOW_TYPE = "showType";
/*  19: 24 */   public static String PROP_TITLE = "title";
/*  20: 25 */   public static String PROP_PRIORITY = "priority";
/*  21:    */   
/*  22:    */   public BaseSurveyTheme()
/*  23:    */   {
/*  24: 30 */     initialize();
/*  25:    */   }
/*  26:    */   
/*  27:    */   public BaseSurveyTheme(Integer id)
/*  28:    */   {
/*  29: 37 */     setId(id);
/*  30: 38 */     initialize();
/*  31:    */   }
/*  32:    */   
/*  33:    */   public BaseSurveyTheme(Integer id, Questionnaire naire, String title, Integer surveyType, Integer priority)
/*  34:    */   {
/*  35: 51 */     setId(id);
/*  36: 52 */     setNaire(naire);
/*  37: 53 */     setTitle(title);
/*  38: 54 */     setSurveyType(surveyType);
/*  39: 55 */     setPriority(priority);
/*  40: 56 */     initialize();
/*  41:    */   }
/*  42:    */   
/*  43: 63 */   private int hashCode = -2147483648;
/*  44:    */   private Integer id;
/*  45:    */   private String title;
/*  46:    */   private Integer surveyType;
/*  47:    */   private Integer totalCount;
/*  48:    */   private Integer maxlength;
/*  49:    */   private Integer showType;
/*  50:    */   private Integer priority;
/*  51:    */   private Questionnaire naire;
/*  52:    */   private Set<SurveyItem> items;
/*  53:    */   
/*  54:    */   protected void initialize() {}
/*  55:    */   
/*  56:    */   public Integer getId()
/*  57:    */   {
/*  58: 91 */     return this.id;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public void setId(Integer id)
/*  62:    */   {
/*  63: 99 */     this.id = id;
/*  64:100 */     this.hashCode = -2147483648;
/*  65:    */   }
/*  66:    */   
/*  67:    */   public String getTitle()
/*  68:    */   {
/*  69:110 */     return this.title;
/*  70:    */   }
/*  71:    */   
/*  72:    */   public void setTitle(String title)
/*  73:    */   {
/*  74:118 */     this.title = title;
/*  75:    */   }
/*  76:    */   
/*  77:    */   public Integer getSurveyType()
/*  78:    */   {
/*  79:127 */     return this.surveyType;
/*  80:    */   }
/*  81:    */   
/*  82:    */   public void setSurveyType(Integer surveyType)
/*  83:    */   {
/*  84:135 */     this.surveyType = surveyType;
/*  85:    */   }
/*  86:    */   
/*  87:    */   public Integer getTotalCount()
/*  88:    */   {
/*  89:144 */     return this.totalCount;
/*  90:    */   }
/*  91:    */   
/*  92:    */   public void setTotalCount(Integer totalCount)
/*  93:    */   {
/*  94:152 */     this.totalCount = totalCount;
/*  95:    */   }
/*  96:    */   
/*  97:    */   public Integer getMaxlength()
/*  98:    */   {
/*  99:161 */     return this.maxlength;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public void setMaxlength(Integer maxlength)
/* 103:    */   {
/* 104:169 */     this.maxlength = maxlength;
/* 105:    */   }
/* 106:    */   
/* 107:    */   public Integer getShowType()
/* 108:    */   {
/* 109:178 */     return this.showType;
/* 110:    */   }
/* 111:    */   
/* 112:    */   public void setShowType(Integer showType)
/* 113:    */   {
/* 114:186 */     this.showType = showType;
/* 115:    */   }
/* 116:    */   
/* 117:    */   public Integer getPriority()
/* 118:    */   {
/* 119:195 */     return this.priority;
/* 120:    */   }
/* 121:    */   
/* 122:    */   public void setPriority(Integer priority)
/* 123:    */   {
/* 124:203 */     this.priority = priority;
/* 125:    */   }
/* 126:    */   
/* 127:    */   public Questionnaire getNaire()
/* 128:    */   {
/* 129:212 */     return this.naire;
/* 130:    */   }
/* 131:    */   
/* 132:    */   public void setNaire(Questionnaire naire)
/* 133:    */   {
/* 134:220 */     this.naire = naire;
/* 135:    */   }
/* 136:    */   
/* 137:    */   public Set<SurveyItem> getItems()
/* 138:    */   {
/* 139:229 */     return this.items;
/* 140:    */   }
/* 141:    */   
/* 142:    */   public void setItems(Set<SurveyItem> items)
/* 143:    */   {
/* 144:237 */     this.items = items;
/* 145:    */   }
/* 146:    */   
/* 147:    */   public boolean equals(Object obj)
/* 148:    */   {
/* 149:244 */     if (obj == null) {
/* 150:244 */       return false;
/* 151:    */     }
/* 152:245 */     if (!(obj instanceof SurveyTheme)) {
/* 153:245 */       return false;
/* 154:    */     }
/* 155:247 */     SurveyTheme surveyTheme = (SurveyTheme)obj;
/* 156:248 */     if ((getId() == null) || (surveyTheme.getId() == null)) {
/* 157:248 */       return false;
/* 158:    */     }
/* 159:249 */     return getId().equals(surveyTheme.getId());
/* 160:    */   }
/* 161:    */   
/* 162:    */   public int hashCode()
/* 163:    */   {
/* 164:254 */     if (-2147483648 == this.hashCode)
/* 165:    */     {
/* 166:255 */       if (getId() == null) {
/* 167:255 */         return super.hashCode();
/* 168:    */       }
/* 169:257 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 170:258 */       this.hashCode = hashStr.hashCode();
/* 171:    */     }
/* 172:261 */     return this.hashCode;
/* 173:    */   }
/* 174:    */   
/* 175:    */   public String toString()
/* 176:    */   {
/* 177:266 */     return super.toString();
/* 178:    */   }
/* 179:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.entity.base.BaseSurveyTheme
 * JD-Core Version:    0.7.0.1
 */