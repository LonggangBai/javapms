/*   1:    */ package com.portal.recruitcenter.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.recruitcenter.entity.CompanyFavorite;
/*   4:    */ import com.portal.recruitcenter.entity.CompanyInfo;
/*   5:    */ import com.portal.recruitcenter.entity.Resume;
/*   6:    */ import java.io.Serializable;
/*   7:    */ import java.util.Date;
/*   8:    */ 
/*   9:    */ public abstract class BaseCompanyFavorite
/*  10:    */   implements Serializable
/*  11:    */ {
/*  12: 17 */   public static String REF = "CompanyFavorite";
/*  13: 18 */   public static String PROP_RESUME = "resume";
/*  14: 19 */   public static String PROP_CREATE_TIME = "createTime";
/*  15: 20 */   public static String PROP_ID = "id";
/*  16: 21 */   public static String PROP_COMPANY = "company";
/*  17:    */   
/*  18:    */   public BaseCompanyFavorite()
/*  19:    */   {
/*  20: 26 */     initialize();
/*  21:    */   }
/*  22:    */   
/*  23:    */   public BaseCompanyFavorite(Integer id)
/*  24:    */   {
/*  25: 33 */     setId(id);
/*  26: 34 */     initialize();
/*  27:    */   }
/*  28:    */   
/*  29:    */   public BaseCompanyFavorite(Integer id, Resume resume, CompanyInfo company, Date createTime)
/*  30:    */   {
/*  31: 46 */     setId(id);
/*  32: 47 */     setResume(resume);
/*  33: 48 */     setCompany(company);
/*  34: 49 */     setCreateTime(createTime);
/*  35: 50 */     initialize();
/*  36:    */   }
/*  37:    */   
/*  38: 57 */   private int hashCode = -2147483648;
/*  39:    */   private Integer id;
/*  40:    */   private Date createTime;
/*  41:    */   private Resume resume;
/*  42:    */   private CompanyInfo company;
/*  43:    */   
/*  44:    */   protected void initialize() {}
/*  45:    */   
/*  46:    */   public Integer getId()
/*  47:    */   {
/*  48: 78 */     return this.id;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public void setId(Integer id)
/*  52:    */   {
/*  53: 86 */     this.id = id;
/*  54: 87 */     this.hashCode = -2147483648;
/*  55:    */   }
/*  56:    */   
/*  57:    */   public Date getCreateTime()
/*  58:    */   {
/*  59: 97 */     return this.createTime;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public void setCreateTime(Date createTime)
/*  63:    */   {
/*  64:105 */     this.createTime = createTime;
/*  65:    */   }
/*  66:    */   
/*  67:    */   public Resume getResume()
/*  68:    */   {
/*  69:114 */     return this.resume;
/*  70:    */   }
/*  71:    */   
/*  72:    */   public void setResume(Resume resume)
/*  73:    */   {
/*  74:122 */     this.resume = resume;
/*  75:    */   }
/*  76:    */   
/*  77:    */   public CompanyInfo getCompany()
/*  78:    */   {
/*  79:131 */     return this.company;
/*  80:    */   }
/*  81:    */   
/*  82:    */   public void setCompany(CompanyInfo company)
/*  83:    */   {
/*  84:139 */     this.company = company;
/*  85:    */   }
/*  86:    */   
/*  87:    */   public boolean equals(Object obj)
/*  88:    */   {
/*  89:146 */     if (obj == null) {
/*  90:146 */       return false;
/*  91:    */     }
/*  92:147 */     if (!(obj instanceof CompanyFavorite)) {
/*  93:147 */       return false;
/*  94:    */     }
/*  95:149 */     CompanyFavorite companyFavorite = (CompanyFavorite)obj;
/*  96:150 */     if ((getId() == null) || (companyFavorite.getId() == null)) {
/*  97:150 */       return false;
/*  98:    */     }
/*  99:151 */     return getId().equals(companyFavorite.getId());
/* 100:    */   }
/* 101:    */   
/* 102:    */   public int hashCode()
/* 103:    */   {
/* 104:156 */     if (-2147483648 == this.hashCode)
/* 105:    */     {
/* 106:157 */       if (getId() == null) {
/* 107:157 */         return super.hashCode();
/* 108:    */       }
/* 109:159 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 110:160 */       this.hashCode = hashStr.hashCode();
/* 111:    */     }
/* 112:163 */     return this.hashCode;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public String toString()
/* 116:    */   {
/* 117:168 */     return super.toString();
/* 118:    */   }
/* 119:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.entity.base.BaseCompanyFavorite
 * JD-Core Version:    0.7.0.1
 */