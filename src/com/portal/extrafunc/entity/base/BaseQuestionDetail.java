/*   1:    */ package com.portal.extrafunc.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.extrafunc.entity.QuestionDetail;
/*   4:    */ import com.portal.extrafunc.entity.Questionnaire;
/*   5:    */ import com.portal.usermgr.entity.User;
/*   6:    */ import java.io.Serializable;
/*   7:    */ import java.util.Date;
/*   8:    */ 
/*   9:    */ public abstract class BaseQuestionDetail
/*  10:    */   implements Serializable
/*  11:    */ {
/*  12: 17 */   public static String REF = "QuestionDetail";
/*  13: 18 */   public static String PROP_USER = "user";
/*  14: 19 */   public static String PROP_IP = "ip";
/*  15: 20 */   public static String PROP_QUESTION = "question";
/*  16: 21 */   public static String PROP_CREATE_TIME = "createTime";
/*  17: 22 */   public static String PROP_ID = "id";
/*  18:    */   
/*  19:    */   public BaseQuestionDetail()
/*  20:    */   {
/*  21: 27 */     initialize();
/*  22:    */   }
/*  23:    */   
/*  24:    */   public BaseQuestionDetail(Integer id)
/*  25:    */   {
/*  26: 34 */     setId(id);
/*  27: 35 */     initialize();
/*  28:    */   }
/*  29:    */   
/*  30:    */   public BaseQuestionDetail(Integer id, Questionnaire question, String ip, Date createTime)
/*  31:    */   {
/*  32: 47 */     setId(id);
/*  33: 48 */     setQuestion(question);
/*  34: 49 */     setIp(ip);
/*  35: 50 */     setCreateTime(createTime);
/*  36: 51 */     initialize();
/*  37:    */   }
/*  38:    */   
/*  39: 58 */   private int hashCode = -2147483648;
/*  40:    */   private Integer id;
/*  41:    */   private String ip;
/*  42:    */   private Date createTime;
/*  43:    */   private Questionnaire question;
/*  44:    */   private User user;
/*  45:    */   
/*  46:    */   protected void initialize() {}
/*  47:    */   
/*  48:    */   public Integer getId()
/*  49:    */   {
/*  50: 80 */     return this.id;
/*  51:    */   }
/*  52:    */   
/*  53:    */   public void setId(Integer id)
/*  54:    */   {
/*  55: 88 */     this.id = id;
/*  56: 89 */     this.hashCode = -2147483648;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public String getIp()
/*  60:    */   {
/*  61: 99 */     return this.ip;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public void setIp(String ip)
/*  65:    */   {
/*  66:107 */     this.ip = ip;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public Date getCreateTime()
/*  70:    */   {
/*  71:116 */     return this.createTime;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public void setCreateTime(Date createTime)
/*  75:    */   {
/*  76:124 */     this.createTime = createTime;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public Questionnaire getQuestion()
/*  80:    */   {
/*  81:133 */     return this.question;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public void setQuestion(Questionnaire question)
/*  85:    */   {
/*  86:141 */     this.question = question;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public User getUser()
/*  90:    */   {
/*  91:150 */     return this.user;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public void setUser(User user)
/*  95:    */   {
/*  96:158 */     this.user = user;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public boolean equals(Object obj)
/* 100:    */   {
/* 101:165 */     if (obj == null) {
/* 102:165 */       return false;
/* 103:    */     }
/* 104:166 */     if (!(obj instanceof QuestionDetail)) {
/* 105:166 */       return false;
/* 106:    */     }
/* 107:168 */     QuestionDetail questionDetail = (QuestionDetail)obj;
/* 108:169 */     if ((getId() == null) || (questionDetail.getId() == null)) {
/* 109:169 */       return false;
/* 110:    */     }
/* 111:170 */     return getId().equals(questionDetail.getId());
/* 112:    */   }
/* 113:    */   
/* 114:    */   public int hashCode()
/* 115:    */   {
/* 116:175 */     if (-2147483648 == this.hashCode)
/* 117:    */     {
/* 118:176 */       if (getId() == null) {
/* 119:176 */         return super.hashCode();
/* 120:    */       }
/* 121:178 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 122:179 */       this.hashCode = hashStr.hashCode();
/* 123:    */     }
/* 124:182 */     return this.hashCode;
/* 125:    */   }
/* 126:    */   
/* 127:    */   public String toString()
/* 128:    */   {
/* 129:187 */     return super.toString();
/* 130:    */   }
/* 131:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.entity.base.BaseQuestionDetail
 * JD-Core Version:    0.7.0.1
 */