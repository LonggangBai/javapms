/*   1:    */ package com.portal.usermgr.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.sysmgr.entity.Site;
/*   4:    */ import com.portal.usermgr.entity.Role;
/*   5:    */ import com.portal.usermgr.entity.RolePerm;
/*   6:    */ import java.io.Serializable;
/*   7:    */ 
/*   8:    */ public abstract class BaseRole
/*   9:    */   implements Serializable
/*  10:    */ {
/*  11: 17 */   public static String REF = "Role";
/*  12: 18 */   public static String PROP_NAME = "name";
/*  13: 19 */   public static String PROP_ALL_PERM = "allPerm";
/*  14: 20 */   public static String PROP_ID = "id";
/*  15: 21 */   public static String PROP_ROLE_PERM = "rolePerm";
/*  16: 22 */   public static String PROP_PRIORITY = "priority";
/*  17:    */   
/*  18:    */   public BaseRole()
/*  19:    */   {
/*  20: 27 */     initialize();
/*  21:    */   }
/*  22:    */   
/*  23:    */   public BaseRole(Integer id)
/*  24:    */   {
/*  25: 34 */     setId(id);
/*  26: 35 */     initialize();
/*  27:    */   }
/*  28:    */   
/*  29:    */   public BaseRole(Integer id, String name, Integer priority, Boolean allPerm)
/*  30:    */   {
/*  31: 47 */     setId(id);
/*  32: 48 */     setName(name);
/*  33: 49 */     setPriority(priority);
/*  34: 50 */     setAllPerm(allPerm);
/*  35: 51 */     initialize();
/*  36:    */   }
/*  37:    */   
/*  38: 58 */   private int hashCode = -2147483648;
/*  39:    */   private Integer id;
/*  40:    */   private String name;
/*  41:    */   private Integer priority;
/*  42:    */   private Boolean allPerm;
/*  43:    */   private RolePerm rolePerm;
/*  44:    */   private Site site;
/*  45:    */   
/*  46:    */   protected void initialize() {}
/*  47:    */   
/*  48:    */   public Integer getId()
/*  49:    */   {
/*  50: 81 */     return this.id;
/*  51:    */   }
/*  52:    */   
/*  53:    */   public void setId(Integer id)
/*  54:    */   {
/*  55: 89 */     this.id = id;
/*  56: 90 */     this.hashCode = -2147483648;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public String getName()
/*  60:    */   {
/*  61:100 */     return this.name;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public void setName(String name)
/*  65:    */   {
/*  66:108 */     this.name = name;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public Integer getPriority()
/*  70:    */   {
/*  71:117 */     return this.priority;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public void setPriority(Integer priority)
/*  75:    */   {
/*  76:125 */     this.priority = priority;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public Boolean getAllPerm()
/*  80:    */   {
/*  81:134 */     return this.allPerm;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public void setAllPerm(Boolean allPerm)
/*  85:    */   {
/*  86:142 */     this.allPerm = allPerm;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public RolePerm getRolePerm()
/*  90:    */   {
/*  91:151 */     return this.rolePerm;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public void setRolePerm(RolePerm rolePerm)
/*  95:    */   {
/*  96:159 */     this.rolePerm = rolePerm;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public Site getSite()
/* 100:    */   {
/* 101:166 */     return this.site;
/* 102:    */   }
/* 103:    */   
/* 104:    */   public void setSite(Site site)
/* 105:    */   {
/* 106:174 */     this.site = site;
/* 107:    */   }
/* 108:    */   
/* 109:    */   public boolean equals(Object obj)
/* 110:    */   {
/* 111:179 */     if (obj == null) {
/* 112:179 */       return false;
/* 113:    */     }
/* 114:180 */     if (!(obj instanceof Role)) {
/* 115:180 */       return false;
/* 116:    */     }
/* 117:182 */     Role role = (Role)obj;
/* 118:183 */     if ((getId() == null) || (role.getId() == null)) {
/* 119:183 */       return false;
/* 120:    */     }
/* 121:184 */     return getId().equals(role.getId());
/* 122:    */   }
/* 123:    */   
/* 124:    */   public int hashCode()
/* 125:    */   {
/* 126:189 */     if (-2147483648 == this.hashCode)
/* 127:    */     {
/* 128:190 */       if (getId() == null) {
/* 129:190 */         return super.hashCode();
/* 130:    */       }
/* 131:192 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 132:193 */       this.hashCode = hashStr.hashCode();
/* 133:    */     }
/* 134:196 */     return this.hashCode;
/* 135:    */   }
/* 136:    */   
/* 137:    */   public String toString()
/* 138:    */   {
/* 139:201 */     return super.toString();
/* 140:    */   }
/* 141:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.entity.base.BaseRole
 * JD-Core Version:    0.7.0.1
 */