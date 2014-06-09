/*   1:    */ package com.portal.usermgr.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.sysmgr.entity.Site;
/*   4:    */ import com.portal.usermgr.entity.Admin;
/*   5:    */ import com.portal.usermgr.entity.AdminCheck;
/*   6:    */ import java.io.Serializable;
/*   7:    */ 
/*   8:    */ public abstract class BaseAdminCheck
/*   9:    */   implements Serializable
/*  10:    */ {
/*  11: 17 */   public static String REF = "AdminCheck";
/*  12: 18 */   public static String PROP_SITE = "site";
/*  13: 19 */   public static String PROP_MANAGE_STATUS = "manageStatus";
/*  14: 20 */   public static String PROP_ID = "id";
/*  15: 21 */   public static String PROP_ADMIN = "admin";
/*  16:    */   
/*  17:    */   public BaseAdminCheck()
/*  18:    */   {
/*  19: 26 */     initialize();
/*  20:    */   }
/*  21:    */   
/*  22:    */   public BaseAdminCheck(Integer id)
/*  23:    */   {
/*  24: 33 */     setId(id);
/*  25: 34 */     initialize();
/*  26:    */   }
/*  27:    */   
/*  28:    */   public BaseAdminCheck(Integer id, Admin admin, Site site, Byte manageStatus)
/*  29:    */   {
/*  30: 46 */     setId(id);
/*  31: 47 */     setAdmin(admin);
/*  32: 48 */     setSite(site);
/*  33: 49 */     setManageStatus(manageStatus);
/*  34: 50 */     initialize();
/*  35:    */   }
/*  36:    */   
/*  37: 57 */   private int hashCode = -2147483648;
/*  38:    */   private Integer id;
/*  39:    */   private Byte manageStatus;
/*  40:    */   private Admin admin;
/*  41:    */   private Site site;
/*  42:    */   
/*  43:    */   protected void initialize() {}
/*  44:    */   
/*  45:    */   public Integer getId()
/*  46:    */   {
/*  47: 78 */     return this.id;
/*  48:    */   }
/*  49:    */   
/*  50:    */   public void setId(Integer id)
/*  51:    */   {
/*  52: 86 */     this.id = id;
/*  53: 87 */     this.hashCode = -2147483648;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public Byte getManageStatus()
/*  57:    */   {
/*  58: 97 */     return this.manageStatus;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public void setManageStatus(Byte manageStatus)
/*  62:    */   {
/*  63:105 */     this.manageStatus = manageStatus;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public Admin getAdmin()
/*  67:    */   {
/*  68:114 */     return this.admin;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public void setAdmin(Admin admin)
/*  72:    */   {
/*  73:122 */     this.admin = admin;
/*  74:    */   }
/*  75:    */   
/*  76:    */   public Site getSite()
/*  77:    */   {
/*  78:131 */     return this.site;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public void setSite(Site site)
/*  82:    */   {
/*  83:139 */     this.site = site;
/*  84:    */   }
/*  85:    */   
/*  86:    */   public boolean equals(Object obj)
/*  87:    */   {
/*  88:146 */     if (obj == null) {
/*  89:146 */       return false;
/*  90:    */     }
/*  91:147 */     if (!(obj instanceof AdminCheck)) {
/*  92:147 */       return false;
/*  93:    */     }
/*  94:149 */     AdminCheck adminCheck = (AdminCheck)obj;
/*  95:150 */     if ((getId() == null) || (adminCheck.getId() == null)) {
/*  96:150 */       return false;
/*  97:    */     }
/*  98:151 */     return getId().equals(adminCheck.getId());
/*  99:    */   }
/* 100:    */   
/* 101:    */   public int hashCode()
/* 102:    */   {
/* 103:156 */     if (-2147483648 == this.hashCode)
/* 104:    */     {
/* 105:157 */       if (getId() == null) {
/* 106:157 */         return super.hashCode();
/* 107:    */       }
/* 108:159 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 109:160 */       this.hashCode = hashStr.hashCode();
/* 110:    */     }
/* 111:163 */     return this.hashCode;
/* 112:    */   }
/* 113:    */   
/* 114:    */   public String toString()
/* 115:    */   {
/* 116:168 */     return super.toString();
/* 117:    */   }
/* 118:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.entity.base.BaseAdminCheck
 * JD-Core Version:    0.7.0.1
 */