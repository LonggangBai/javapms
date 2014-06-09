/*   1:    */ package com.portal.extrafunc.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.extrafunc.entity.SurveyDetail;
/*   4:    */ import com.portal.extrafunc.entity.SurveyTheme;
/*   5:    */ import com.portal.usermgr.entity.User;
/*   6:    */ import java.io.Serializable;
/*   7:    */ import java.util.Date;
/*   8:    */ 
/*   9:    */ public abstract class BaseSurveyDetail
/*  10:    */   implements Serializable
/*  11:    */ {
/*  12: 17 */   public static String REF = "SurveyDetail";
/*  13: 18 */   public static String PROP_USER = "user";
/*  14: 19 */   public static String PROP_SURVEY = "survey";
/*  15: 20 */   public static String PROP_CREATE_TIME = "createTime";
/*  16: 21 */   public static String PROP_ID = "id";
/*  17: 22 */   public static String PROP_CONTENT = "content";
/*  18:    */   
/*  19:    */   public BaseSurveyDetail()
/*  20:    */   {
/*  21: 27 */     initialize();
/*  22:    */   }
/*  23:    */   
/*  24:    */   public BaseSurveyDetail(Integer id)
/*  25:    */   {
/*  26: 34 */     setId(id);
/*  27: 35 */     initialize();
/*  28:    */   }
/*  29:    */   
/*  30:    */   public BaseSurveyDetail(Integer id, SurveyTheme survey, Date createTime)
/*  31:    */   {
/*  32: 46 */     setId(id);
/*  33: 47 */     setSurvey(survey);
/*  34: 48 */     setCreateTime(createTime);
/*  35: 49 */     initialize();
/*  36:    */   }
/*  37:    */   
/*  38: 56 */   private int hashCode = -2147483648;
/*  39:    */   private Integer id;
/*  40:    */   private String content;
/*  41:    */   private Date createTime;
/*  42:    */   private SurveyTheme survey;
/*  43:    */   private User user;
/*  44:    */   
/*  45:    */   protected void initialize() {}
/*  46:    */   
/*  47:    */   public Integer getId()
/*  48:    */   {
/*  49: 78 */     return this.id;
/*  50:    */   }
/*  51:    */   
/*  52:    */   public void setId(Integer id)
/*  53:    */   {
/*  54: 86 */     this.id = id;
/*  55: 87 */     this.hashCode = -2147483648;
/*  56:    */   }
/*  57:    */   
/*  58:    */   public String getContent()
/*  59:    */   {
/*  60: 97 */     return this.content;
/*  61:    */   }
/*  62:    */   
/*  63:    */   public void setContent(String content)
/*  64:    */   {
/*  65:105 */     this.content = content;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public Date getCreateTime()
/*  69:    */   {
/*  70:114 */     return this.createTime;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public void setCreateTime(Date createTime)
/*  74:    */   {
/*  75:122 */     this.createTime = createTime;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public SurveyTheme getSurvey()
/*  79:    */   {
/*  80:131 */     return this.survey;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public void setSurvey(SurveyTheme survey)
/*  84:    */   {
/*  85:139 */     this.survey = survey;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public User getUser()
/*  89:    */   {
/*  90:148 */     return this.user;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public void setUser(User user)
/*  94:    */   {
/*  95:156 */     this.user = user;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public boolean equals(Object obj)
/*  99:    */   {
/* 100:163 */     if (obj == null) {
/* 101:163 */       return false;
/* 102:    */     }
/* 103:164 */     if (!(obj instanceof SurveyDetail)) {
/* 104:164 */       return false;
/* 105:    */     }
/* 106:166 */     SurveyDetail surveyDetail = (SurveyDetail)obj;
/* 107:167 */     if ((getId() == null) || (surveyDetail.getId() == null)) {
/* 108:167 */       return false;
/* 109:    */     }
/* 110:168 */     return getId().equals(surveyDetail.getId());
/* 111:    */   }
/* 112:    */   
/* 113:    */   public int hashCode()
/* 114:    */   {
/* 115:173 */     if (-2147483648 == this.hashCode)
/* 116:    */     {
/* 117:174 */       if (getId() == null) {
/* 118:174 */         return super.hashCode();
/* 119:    */       }
/* 120:176 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 121:177 */       this.hashCode = hashStr.hashCode();
/* 122:    */     }
/* 123:180 */     return this.hashCode;
/* 124:    */   }
/* 125:    */   
/* 126:    */   public String toString()
/* 127:    */   {
/* 128:185 */     return super.toString();
/* 129:    */   }
/* 130:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.entity.base.BaseSurveyDetail
 * JD-Core Version:    0.7.0.1
 */