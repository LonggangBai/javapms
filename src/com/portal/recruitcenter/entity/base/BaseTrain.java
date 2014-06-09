/*   1:    */ package com.portal.recruitcenter.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.recruitcenter.entity.Resume;
/*   4:    */ import com.portal.recruitcenter.entity.Train;
/*   5:    */ import java.io.Serializable;
/*   6:    */ import java.util.Date;
/*   7:    */ 
/*   8:    */ public abstract class BaseTrain
/*   9:    */   implements Serializable
/*  10:    */ {
/*  11: 17 */   public static String REF = "Train";
/*  12: 18 */   public static String PROP_DESCRIPTION = "description";
/*  13: 19 */   public static String PROP_TRAINING = "training";
/*  14: 20 */   public static String PROP_RESUME = "resume";
/*  15: 21 */   public static String PROP_CREATE_TIME = "createTime";
/*  16: 22 */   public static String PROP_CERT_NAME = "certName";
/*  17: 23 */   public static String PROP_ID = "id";
/*  18: 24 */   public static String PROP_END_TIME = "endTime";
/*  19: 25 */   public static String PROP_START_TIME = "startTime";
/*  20: 26 */   public static String PROP_TRAIN_COURSE = "trainCourse";
/*  21:    */   
/*  22:    */   public BaseTrain()
/*  23:    */   {
/*  24: 31 */     initialize();
/*  25:    */   }
/*  26:    */   
/*  27:    */   public BaseTrain(Integer id)
/*  28:    */   {
/*  29: 38 */     setId(id);
/*  30: 39 */     initialize();
/*  31:    */   }
/*  32:    */   
/*  33:    */   public BaseTrain(Integer id, Resume resume, String startTime, String endTime, String training, String trainCourse, String certName, Date createTime)
/*  34:    */   {
/*  35: 55 */     setId(id);
/*  36: 56 */     setResume(resume);
/*  37: 57 */     setStartTime(startTime);
/*  38: 58 */     setEndTime(endTime);
/*  39: 59 */     setTraining(training);
/*  40: 60 */     setTrainCourse(trainCourse);
/*  41: 61 */     setCertName(certName);
/*  42: 62 */     setCreateTime(createTime);
/*  43: 63 */     initialize();
/*  44:    */   }
/*  45:    */   
/*  46: 70 */   private int hashCode = -2147483648;
/*  47:    */   private Integer id;
/*  48:    */   private String startTime;
/*  49:    */   private String endTime;
/*  50:    */   private String training;
/*  51:    */   private String trainCourse;
/*  52:    */   private String certName;
/*  53:    */   private String description;
/*  54:    */   private Date createTime;
/*  55:    */   private Resume resume;
/*  56:    */   
/*  57:    */   protected void initialize() {}
/*  58:    */   
/*  59:    */   public Integer getId()
/*  60:    */   {
/*  61: 96 */     return this.id;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public void setId(Integer id)
/*  65:    */   {
/*  66:104 */     this.id = id;
/*  67:105 */     this.hashCode = -2147483648;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public String getStartTime()
/*  71:    */   {
/*  72:115 */     return this.startTime;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public void setStartTime(String startTime)
/*  76:    */   {
/*  77:123 */     this.startTime = startTime;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public String getEndTime()
/*  81:    */   {
/*  82:132 */     return this.endTime;
/*  83:    */   }
/*  84:    */   
/*  85:    */   public void setEndTime(String endTime)
/*  86:    */   {
/*  87:140 */     this.endTime = endTime;
/*  88:    */   }
/*  89:    */   
/*  90:    */   public String getTraining()
/*  91:    */   {
/*  92:149 */     return this.training;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public void setTraining(String training)
/*  96:    */   {
/*  97:157 */     this.training = training;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public String getTrainCourse()
/* 101:    */   {
/* 102:166 */     return this.trainCourse;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public void setTrainCourse(String trainCourse)
/* 106:    */   {
/* 107:174 */     this.trainCourse = trainCourse;
/* 108:    */   }
/* 109:    */   
/* 110:    */   public String getCertName()
/* 111:    */   {
/* 112:183 */     return this.certName;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public void setCertName(String certName)
/* 116:    */   {
/* 117:191 */     this.certName = certName;
/* 118:    */   }
/* 119:    */   
/* 120:    */   public String getDescription()
/* 121:    */   {
/* 122:200 */     return this.description;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public void setDescription(String description)
/* 126:    */   {
/* 127:208 */     this.description = description;
/* 128:    */   }
/* 129:    */   
/* 130:    */   public Date getCreateTime()
/* 131:    */   {
/* 132:217 */     return this.createTime;
/* 133:    */   }
/* 134:    */   
/* 135:    */   public void setCreateTime(Date createTime)
/* 136:    */   {
/* 137:225 */     this.createTime = createTime;
/* 138:    */   }
/* 139:    */   
/* 140:    */   public Resume getResume()
/* 141:    */   {
/* 142:234 */     return this.resume;
/* 143:    */   }
/* 144:    */   
/* 145:    */   public void setResume(Resume resume)
/* 146:    */   {
/* 147:242 */     this.resume = resume;
/* 148:    */   }
/* 149:    */   
/* 150:    */   public boolean equals(Object obj)
/* 151:    */   {
/* 152:249 */     if (obj == null) {
/* 153:249 */       return false;
/* 154:    */     }
/* 155:250 */     if (!(obj instanceof Train)) {
/* 156:250 */       return false;
/* 157:    */     }
/* 158:252 */     Train train = (Train)obj;
/* 159:253 */     if ((getId() == null) || (train.getId() == null)) {
/* 160:253 */       return false;
/* 161:    */     }
/* 162:254 */     return getId().equals(train.getId());
/* 163:    */   }
/* 164:    */   
/* 165:    */   public int hashCode()
/* 166:    */   {
/* 167:259 */     if (-2147483648 == this.hashCode)
/* 168:    */     {
/* 169:260 */       if (getId() == null) {
/* 170:260 */         return super.hashCode();
/* 171:    */       }
/* 172:262 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 173:263 */       this.hashCode = hashStr.hashCode();
/* 174:    */     }
/* 175:266 */     return this.hashCode;
/* 176:    */   }
/* 177:    */   
/* 178:    */   public String toString()
/* 179:    */   {
/* 180:271 */     return super.toString();
/* 181:    */   }
/* 182:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.entity.base.BaseTrain
 * JD-Core Version:    0.7.0.1
 */