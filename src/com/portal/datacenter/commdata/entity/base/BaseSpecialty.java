/*   1:    */ package com.portal.datacenter.commdata.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.datacenter.commdata.entity.Specialty;
/*   4:    */ import java.io.Serializable;
/*   5:    */ 
/*   6:    */ public abstract class BaseSpecialty
/*   7:    */   implements Serializable
/*   8:    */ {
/*   9: 17 */   public static String REF = "Specialty";
/*  10: 18 */   public static String PROP_NAME = "name";
/*  11: 19 */   public static String PROP_PARENT = "parent";
/*  12: 20 */   public static String PROP_ID = "id";
/*  13: 21 */   public static String PROP_CODE = "code";
/*  14:    */   
/*  15:    */   public BaseSpecialty()
/*  16:    */   {
/*  17: 26 */     initialize();
/*  18:    */   }
/*  19:    */   
/*  20:    */   public BaseSpecialty(Integer id)
/*  21:    */   {
/*  22: 33 */     setId(id);
/*  23: 34 */     initialize();
/*  24:    */   }
/*  25:    */   
/*  26:    */   public BaseSpecialty(Integer id, String code, String name)
/*  27:    */   {
/*  28: 45 */     setId(id);
/*  29: 46 */     setCode(code);
/*  30: 47 */     setName(name);
/*  31: 48 */     initialize();
/*  32:    */   }
/*  33:    */   
/*  34: 55 */   private int hashCode = -2147483648;
/*  35:    */   private Integer id;
/*  36:    */   private String code;
/*  37:    */   private String name;
/*  38:    */   private Specialty parent;
/*  39:    */   
/*  40:    */   protected void initialize() {}
/*  41:    */   
/*  42:    */   public Integer getId()
/*  43:    */   {
/*  44: 76 */     return this.id;
/*  45:    */   }
/*  46:    */   
/*  47:    */   public void setId(Integer id)
/*  48:    */   {
/*  49: 84 */     this.id = id;
/*  50: 85 */     this.hashCode = -2147483648;
/*  51:    */   }
/*  52:    */   
/*  53:    */   public String getCode()
/*  54:    */   {
/*  55: 95 */     return this.code;
/*  56:    */   }
/*  57:    */   
/*  58:    */   public void setCode(String code)
/*  59:    */   {
/*  60:103 */     this.code = code;
/*  61:    */   }
/*  62:    */   
/*  63:    */   public String getName()
/*  64:    */   {
/*  65:112 */     return this.name;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public void setName(String name)
/*  69:    */   {
/*  70:120 */     this.name = name;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public Specialty getParent()
/*  74:    */   {
/*  75:129 */     return this.parent;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public void setParent(Specialty parent)
/*  79:    */   {
/*  80:137 */     this.parent = parent;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public boolean equals(Object obj)
/*  84:    */   {
/*  85:144 */     if (obj == null) {
/*  86:144 */       return false;
/*  87:    */     }
/*  88:145 */     if (!(obj instanceof Specialty)) {
/*  89:145 */       return false;
/*  90:    */     }
/*  91:147 */     Specialty specialty = (Specialty)obj;
/*  92:148 */     if ((getId() == null) || (specialty.getId() == null)) {
/*  93:148 */       return false;
/*  94:    */     }
/*  95:149 */     return getId().equals(specialty.getId());
/*  96:    */   }
/*  97:    */   
/*  98:    */   public int hashCode()
/*  99:    */   {
/* 100:154 */     if (-2147483648 == this.hashCode)
/* 101:    */     {
/* 102:155 */       if (getId() == null) {
/* 103:155 */         return super.hashCode();
/* 104:    */       }
/* 105:157 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 106:158 */       this.hashCode = hashStr.hashCode();
/* 107:    */     }
/* 108:161 */     return this.hashCode;
/* 109:    */   }
/* 110:    */   
/* 111:    */   public String toString()
/* 112:    */   {
/* 113:166 */     return super.toString();
/* 114:    */   }
/* 115:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.commdata.entity.base.BaseSpecialty
 * JD-Core Version:    0.7.0.1
 */