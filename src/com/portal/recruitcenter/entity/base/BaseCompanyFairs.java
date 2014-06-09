/*   1:    */ package com.portal.recruitcenter.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.recruitcenter.entity.CompanyFairs;
/*   4:    */ import com.portal.recruitcenter.entity.CompanyInfo;
/*   5:    */ import com.portal.recruitcenter.entity.JobFairs;
/*   6:    */ import java.io.Serializable;
/*   7:    */ import java.util.Date;
/*   8:    */ 
/*   9:    */ public abstract class BaseCompanyFairs
/*  10:    */   implements Serializable
/*  11:    */ {
/*  12: 17 */   public static String REF = "CompanyFairs";
/*  13: 18 */   public static String PROP_FAIRS = "fairs";
/*  14: 19 */   public static String PROP_CREATE_TIME = "createTime";
/*  15: 20 */   public static String PROP_ID = "id";
/*  16: 21 */   public static String PROP_SHOWCASE = "showcase";
/*  17: 22 */   public static String PROP_SHOW_TIME = "showTime";
/*  18: 23 */   public static String PROP_COMPANY = "company";
/*  19:    */   
/*  20:    */   public BaseCompanyFairs()
/*  21:    */   {
/*  22: 28 */     initialize();
/*  23:    */   }
/*  24:    */   
/*  25:    */   public BaseCompanyFairs(Integer id)
/*  26:    */   {
/*  27: 35 */     setId(id);
/*  28: 36 */     initialize();
/*  29:    */   }
/*  30:    */   
/*  31:    */   public BaseCompanyFairs(Integer id, CompanyInfo company, JobFairs fairs, String showcase, Byte showTime, Date createTime)
/*  32:    */   {
/*  33: 50 */     setId(id);
/*  34: 51 */     setCompany(company);
/*  35: 52 */     setFairs(fairs);
/*  36: 53 */     setShowcase(showcase);
/*  37: 54 */     setShowTime(showTime);
/*  38: 55 */     setCreateTime(createTime);
/*  39: 56 */     initialize();
/*  40:    */   }
/*  41:    */   
/*  42: 63 */   private int hashCode = -2147483648;
/*  43:    */   private Integer id;
/*  44:    */   private String showcase;
/*  45:    */   private Byte showTime;
/*  46:    */   private Date createTime;
/*  47:    */   private CompanyInfo company;
/*  48:    */   private JobFairs fairs;
/*  49:    */   
/*  50:    */   protected void initialize() {}
/*  51:    */   
/*  52:    */   public Integer getId()
/*  53:    */   {
/*  54: 86 */     return this.id;
/*  55:    */   }
/*  56:    */   
/*  57:    */   public void setId(Integer id)
/*  58:    */   {
/*  59: 94 */     this.id = id;
/*  60: 95 */     this.hashCode = -2147483648;
/*  61:    */   }
/*  62:    */   
/*  63:    */   public String getShowcase()
/*  64:    */   {
/*  65:105 */     return this.showcase;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public void setShowcase(String showcase)
/*  69:    */   {
/*  70:113 */     this.showcase = showcase;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public Byte getShowTime()
/*  74:    */   {
/*  75:122 */     return this.showTime;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public void setShowTime(Byte showTime)
/*  79:    */   {
/*  80:130 */     this.showTime = showTime;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public Date getCreateTime()
/*  84:    */   {
/*  85:139 */     return this.createTime;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public void setCreateTime(Date createTime)
/*  89:    */   {
/*  90:147 */     this.createTime = createTime;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public CompanyInfo getCompany()
/*  94:    */   {
/*  95:156 */     return this.company;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public void setCompany(CompanyInfo company)
/*  99:    */   {
/* 100:164 */     this.company = company;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public JobFairs getFairs()
/* 104:    */   {
/* 105:173 */     return this.fairs;
/* 106:    */   }
/* 107:    */   
/* 108:    */   public void setFairs(JobFairs fairs)
/* 109:    */   {
/* 110:181 */     this.fairs = fairs;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public boolean equals(Object obj)
/* 114:    */   {
/* 115:188 */     if (obj == null) {
/* 116:188 */       return false;
/* 117:    */     }
/* 118:189 */     if (!(obj instanceof CompanyFairs)) {
/* 119:189 */       return false;
/* 120:    */     }
/* 121:191 */     CompanyFairs companyFairs = (CompanyFairs)obj;
/* 122:192 */     if ((getId() == null) || (companyFairs.getId() == null)) {
/* 123:192 */       return false;
/* 124:    */     }
/* 125:193 */     return getId().equals(companyFairs.getId());
/* 126:    */   }
/* 127:    */   
/* 128:    */   public int hashCode()
/* 129:    */   {
/* 130:198 */     if (-2147483648 == this.hashCode)
/* 131:    */     {
/* 132:199 */       if (getId() == null) {
/* 133:199 */         return super.hashCode();
/* 134:    */       }
/* 135:201 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 136:202 */       this.hashCode = hashStr.hashCode();
/* 137:    */     }
/* 138:205 */     return this.hashCode;
/* 139:    */   }
/* 140:    */   
/* 141:    */   public String toString()
/* 142:    */   {
/* 143:210 */     return super.toString();
/* 144:    */   }
/* 145:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.entity.base.BaseCompanyFairs
 * JD-Core Version:    0.7.0.1
 */