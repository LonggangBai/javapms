/*   1:    */ package com.portal.datacenter.commdata.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.datacenter.commdata.entity.ProfessPost;
/*   4:    */ import java.io.Serializable;
/*   5:    */ 
/*   6:    */ public abstract class BaseProfessPost
/*   7:    */   implements Serializable
/*   8:    */ {
/*   9: 17 */   public static String REF = "ProfessPost";
/*  10: 18 */   public static String PROP_NAME = "name";
/*  11: 19 */   public static String PROP_ID = "id";
/*  12: 20 */   public static String PROP_CODE = "code";
/*  13:    */   
/*  14:    */   public BaseProfessPost()
/*  15:    */   {
/*  16: 25 */     initialize();
/*  17:    */   }
/*  18:    */   
/*  19:    */   public BaseProfessPost(Integer id)
/*  20:    */   {
/*  21: 32 */     setId(id);
/*  22: 33 */     initialize();
/*  23:    */   }
/*  24:    */   
/*  25:    */   public BaseProfessPost(Integer id, String code, String name)
/*  26:    */   {
/*  27: 44 */     setId(id);
/*  28: 45 */     setCode(code);
/*  29: 46 */     setName(name);
/*  30: 47 */     initialize();
/*  31:    */   }
/*  32:    */   
/*  33: 54 */   private int hashCode = -2147483648;
/*  34:    */   private Integer id;
/*  35:    */   private String code;
/*  36:    */   private String name;
/*  37:    */   
/*  38:    */   protected void initialize() {}
/*  39:    */   
/*  40:    */   public Integer getId()
/*  41:    */   {
/*  42: 72 */     return this.id;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public void setId(Integer id)
/*  46:    */   {
/*  47: 80 */     this.id = id;
/*  48: 81 */     this.hashCode = -2147483648;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public String getCode()
/*  52:    */   {
/*  53: 91 */     return this.code;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public void setCode(String code)
/*  57:    */   {
/*  58: 99 */     this.code = code;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public String getName()
/*  62:    */   {
/*  63:108 */     return this.name;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public void setName(String name)
/*  67:    */   {
/*  68:116 */     this.name = name;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public boolean equals(Object obj)
/*  72:    */   {
/*  73:123 */     if (obj == null) {
/*  74:123 */       return false;
/*  75:    */     }
/*  76:124 */     if (!(obj instanceof ProfessPost)) {
/*  77:124 */       return false;
/*  78:    */     }
/*  79:126 */     ProfessPost professPost = (ProfessPost)obj;
/*  80:127 */     if ((getId() == null) || (professPost.getId() == null)) {
/*  81:127 */       return false;
/*  82:    */     }
/*  83:128 */     return getId().equals(professPost.getId());
/*  84:    */   }
/*  85:    */   
/*  86:    */   public int hashCode()
/*  87:    */   {
/*  88:133 */     if (-2147483648 == this.hashCode)
/*  89:    */     {
/*  90:134 */       if (getId() == null) {
/*  91:134 */         return super.hashCode();
/*  92:    */       }
/*  93:136 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/*  94:137 */       this.hashCode = hashStr.hashCode();
/*  95:    */     }
/*  96:140 */     return this.hashCode;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public String toString()
/* 100:    */   {
/* 101:145 */     return super.toString();
/* 102:    */   }
/* 103:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.commdata.entity.base.BaseProfessPost
 * JD-Core Version:    0.7.0.1
 */