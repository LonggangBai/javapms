/*   1:    */ package com.portal.usermgr.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.usermgr.entity.Group;
/*   4:    */ import com.portal.usermgr.entity.GroupPerm;
/*   5:    */ import java.io.Serializable;
/*   6:    */ 
/*   7:    */ public abstract class BaseGroupPerm
/*   8:    */   implements Serializable
/*   9:    */ {
/*  10: 17 */   public static String REF = "GroupPerm";
/*  11: 18 */   public static String PROP_PERMS = "perms";
/*  12: 19 */   public static String PROP_ID = "id";
/*  13: 20 */   public static String PROP_GROUP = "group";
/*  14:    */   
/*  15:    */   public BaseGroupPerm()
/*  16:    */   {
/*  17: 25 */     initialize();
/*  18:    */   }
/*  19:    */   
/*  20:    */   public BaseGroupPerm(Integer id)
/*  21:    */   {
/*  22: 32 */     setId(id);
/*  23: 33 */     initialize();
/*  24:    */   }
/*  25:    */   
/*  26: 40 */   private int hashCode = -2147483648;
/*  27:    */   private Integer id;
/*  28:    */   private String perms;
/*  29:    */   private Group group;
/*  30:    */   
/*  31:    */   protected void initialize() {}
/*  32:    */   
/*  33:    */   public Integer getId()
/*  34:    */   {
/*  35: 60 */     return this.id;
/*  36:    */   }
/*  37:    */   
/*  38:    */   public void setId(Integer id)
/*  39:    */   {
/*  40: 68 */     this.id = id;
/*  41: 69 */     this.hashCode = -2147483648;
/*  42:    */   }
/*  43:    */   
/*  44:    */   public String getPerms()
/*  45:    */   {
/*  46: 79 */     return this.perms;
/*  47:    */   }
/*  48:    */   
/*  49:    */   public void setPerms(String perms)
/*  50:    */   {
/*  51: 87 */     this.perms = perms;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public Group getGroup()
/*  55:    */   {
/*  56: 96 */     return this.group;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public void setGroup(Group group)
/*  60:    */   {
/*  61:104 */     this.group = group;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public boolean equals(Object obj)
/*  65:    */   {
/*  66:111 */     if (obj == null) {
/*  67:111 */       return false;
/*  68:    */     }
/*  69:112 */     if (!(obj instanceof GroupPerm)) {
/*  70:112 */       return false;
/*  71:    */     }
/*  72:114 */     GroupPerm groupPerm = (GroupPerm)obj;
/*  73:115 */     if ((getId() == null) || (groupPerm.getId() == null)) {
/*  74:115 */       return false;
/*  75:    */     }
/*  76:116 */     return getId().equals(groupPerm.getId());
/*  77:    */   }
/*  78:    */   
/*  79:    */   public int hashCode()
/*  80:    */   {
/*  81:121 */     if (-2147483648 == this.hashCode)
/*  82:    */     {
/*  83:122 */       if (getId() == null) {
/*  84:122 */         return super.hashCode();
/*  85:    */       }
/*  86:124 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/*  87:125 */       this.hashCode = hashStr.hashCode();
/*  88:    */     }
/*  89:128 */     return this.hashCode;
/*  90:    */   }
/*  91:    */   
/*  92:    */   public String toString()
/*  93:    */   {
/*  94:133 */     return super.toString();
/*  95:    */   }
/*  96:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.entity.base.BaseGroupPerm
 * JD-Core Version:    0.7.0.1
 */