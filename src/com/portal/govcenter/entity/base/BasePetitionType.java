/*   1:    */ package com.portal.govcenter.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.govcenter.entity.PetitionType;
/*   4:    */ import com.portal.sysmgr.entity.Site;
/*   5:    */ import java.io.Serializable;
/*   6:    */ 
/*   7:    */ public abstract class BasePetitionType
/*   8:    */   implements Serializable
/*   9:    */ {
/*  10: 17 */   public static String REF = "PetitionType";
/*  11: 18 */   public static String PROP_NAME = "name";
/*  12: 19 */   public static String PROP_SITE = "site";
/*  13: 20 */   public static String PROP_ID = "id";
/*  14: 21 */   public static String PROP_PRIORITY = "priority";
/*  15:    */   
/*  16:    */   public BasePetitionType()
/*  17:    */   {
/*  18: 26 */     initialize();
/*  19:    */   }
/*  20:    */   
/*  21:    */   public BasePetitionType(Integer id)
/*  22:    */   {
/*  23: 33 */     setId(id);
/*  24: 34 */     initialize();
/*  25:    */   }
/*  26:    */   
/*  27:    */   public BasePetitionType(Integer id, Site site, String name, Integer priority)
/*  28:    */   {
/*  29: 46 */     setId(id);
/*  30: 47 */     setSite(site);
/*  31: 48 */     setName(name);
/*  32: 49 */     setPriority(priority);
/*  33: 50 */     initialize();
/*  34:    */   }
/*  35:    */   
/*  36: 57 */   private int hashCode = -2147483648;
/*  37:    */   private Integer id;
/*  38:    */   private String name;
/*  39:    */   private Integer priority;
/*  40:    */   private Site site;
/*  41:    */   
/*  42:    */   protected void initialize() {}
/*  43:    */   
/*  44:    */   public Integer getId()
/*  45:    */   {
/*  46: 78 */     return this.id;
/*  47:    */   }
/*  48:    */   
/*  49:    */   public void setId(Integer id)
/*  50:    */   {
/*  51: 86 */     this.id = id;
/*  52: 87 */     this.hashCode = -2147483648;
/*  53:    */   }
/*  54:    */   
/*  55:    */   public String getName()
/*  56:    */   {
/*  57: 97 */     return this.name;
/*  58:    */   }
/*  59:    */   
/*  60:    */   public void setName(String name)
/*  61:    */   {
/*  62:105 */     this.name = name;
/*  63:    */   }
/*  64:    */   
/*  65:    */   public Integer getPriority()
/*  66:    */   {
/*  67:114 */     return this.priority;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public void setPriority(Integer priority)
/*  71:    */   {
/*  72:122 */     this.priority = priority;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public Site getSite()
/*  76:    */   {
/*  77:131 */     return this.site;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public void setSite(Site site)
/*  81:    */   {
/*  82:139 */     this.site = site;
/*  83:    */   }
/*  84:    */   
/*  85:    */   public boolean equals(Object obj)
/*  86:    */   {
/*  87:146 */     if (obj == null) {
/*  88:146 */       return false;
/*  89:    */     }
/*  90:147 */     if (!(obj instanceof PetitionType)) {
/*  91:147 */       return false;
/*  92:    */     }
/*  93:149 */     PetitionType petitionType = (PetitionType)obj;
/*  94:150 */     if ((getId() == null) || (petitionType.getId() == null)) {
/*  95:150 */       return false;
/*  96:    */     }
/*  97:151 */     return getId().equals(petitionType.getId());
/*  98:    */   }
/*  99:    */   
/* 100:    */   public int hashCode()
/* 101:    */   {
/* 102:156 */     if (-2147483648 == this.hashCode)
/* 103:    */     {
/* 104:157 */       if (getId() == null) {
/* 105:157 */         return super.hashCode();
/* 106:    */       }
/* 107:159 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 108:160 */       this.hashCode = hashStr.hashCode();
/* 109:    */     }
/* 110:163 */     return this.hashCode;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public String toString()
/* 114:    */   {
/* 115:168 */     return super.toString();
/* 116:    */   }
/* 117:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.govcenter.entity.base.BasePetitionType
 * JD-Core Version:    0.7.0.1
 */