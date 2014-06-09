/*   1:    */ package com.portal.usermgr.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.doccenter.entity.Channel;
/*   4:    */ import com.portal.sysmgr.entity.Site;
/*   5:    */ import com.portal.usermgr.entity.Group;
/*   6:    */ import com.portal.usermgr.entity.GroupPerm;
/*   7:    */ import java.io.Serializable;
/*   8:    */ import java.util.Set;
/*   9:    */ 
/*  10:    */ public abstract class BaseGroup
/*  11:    */   implements Serializable
/*  12:    */ {
/*  13: 17 */   public static String REF = "Group";
/*  14: 18 */   public static String PROP_NAME = "name";
/*  15: 19 */   public static String PROP_REGIST_SHOW = "registShow";
/*  16: 20 */   public static String PROP_SITE = "site";
/*  17: 21 */   public static String PROP_ALL_PERM = "allPerm";
/*  18: 22 */   public static String PROP_GROUP_PERM = "groupPerm";
/*  19: 23 */   public static String PROP_ID = "id";
/*  20: 24 */   public static String PROP_PRIORITY = "priority";
/*  21:    */   
/*  22:    */   public BaseGroup()
/*  23:    */   {
/*  24: 29 */     initialize();
/*  25:    */   }
/*  26:    */   
/*  27:    */   public BaseGroup(Integer id)
/*  28:    */   {
/*  29: 36 */     setId(id);
/*  30: 37 */     initialize();
/*  31:    */   }
/*  32:    */   
/*  33:    */   public BaseGroup(Integer id, String name, Integer priority, Boolean allPerm, Boolean registShow)
/*  34:    */   {
/*  35: 50 */     setId(id);
/*  36: 51 */     setName(name);
/*  37: 52 */     setPriority(priority);
/*  38: 53 */     setAllPerm(allPerm);
/*  39: 54 */     setRegistShow(registShow);
/*  40: 55 */     initialize();
/*  41:    */   }
/*  42:    */   
/*  43: 62 */   private int hashCode = -2147483648;
/*  44:    */   private Integer id;
/*  45:    */   private String name;
/*  46:    */   private Integer priority;
/*  47:    */   private Boolean allPerm;
/*  48:    */   private Boolean registShow;
/*  49:    */   private GroupPerm groupPerm;
/*  50:    */   private Site site;
/*  51:    */   private Set<Channel> viewChannels;
/*  52:    */   private Set<Channel> contriChannels;
/*  53:    */   
/*  54:    */   protected void initialize() {}
/*  55:    */   
/*  56:    */   public Integer getId()
/*  57:    */   {
/*  58: 92 */     return this.id;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public void setId(Integer id)
/*  62:    */   {
/*  63:100 */     this.id = id;
/*  64:101 */     this.hashCode = -2147483648;
/*  65:    */   }
/*  66:    */   
/*  67:    */   public String getName()
/*  68:    */   {
/*  69:111 */     return this.name;
/*  70:    */   }
/*  71:    */   
/*  72:    */   public void setName(String name)
/*  73:    */   {
/*  74:119 */     this.name = name;
/*  75:    */   }
/*  76:    */   
/*  77:    */   public Integer getPriority()
/*  78:    */   {
/*  79:128 */     return this.priority;
/*  80:    */   }
/*  81:    */   
/*  82:    */   public void setPriority(Integer priority)
/*  83:    */   {
/*  84:136 */     this.priority = priority;
/*  85:    */   }
/*  86:    */   
/*  87:    */   public Boolean getAllPerm()
/*  88:    */   {
/*  89:145 */     return this.allPerm;
/*  90:    */   }
/*  91:    */   
/*  92:    */   public void setAllPerm(Boolean allPerm)
/*  93:    */   {
/*  94:153 */     this.allPerm = allPerm;
/*  95:    */   }
/*  96:    */   
/*  97:    */   public Boolean getRegistShow()
/*  98:    */   {
/*  99:162 */     return this.registShow;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public void setRegistShow(Boolean registShow)
/* 103:    */   {
/* 104:170 */     this.registShow = registShow;
/* 105:    */   }
/* 106:    */   
/* 107:    */   public GroupPerm getGroupPerm()
/* 108:    */   {
/* 109:179 */     return this.groupPerm;
/* 110:    */   }
/* 111:    */   
/* 112:    */   public void setGroupPerm(GroupPerm groupPerm)
/* 113:    */   {
/* 114:187 */     this.groupPerm = groupPerm;
/* 115:    */   }
/* 116:    */   
/* 117:    */   public Site getSite()
/* 118:    */   {
/* 119:196 */     return this.site;
/* 120:    */   }
/* 121:    */   
/* 122:    */   public void setSite(Site site)
/* 123:    */   {
/* 124:204 */     this.site = site;
/* 125:    */   }
/* 126:    */   
/* 127:    */   public Set<Channel> getViewChannels()
/* 128:    */   {
/* 129:213 */     return this.viewChannels;
/* 130:    */   }
/* 131:    */   
/* 132:    */   public void setViewChannels(Set<Channel> viewChannels)
/* 133:    */   {
/* 134:221 */     this.viewChannels = viewChannels;
/* 135:    */   }
/* 136:    */   
/* 137:    */   public Set<Channel> getContriChannels()
/* 138:    */   {
/* 139:230 */     return this.contriChannels;
/* 140:    */   }
/* 141:    */   
/* 142:    */   public void setContriChannels(Set<Channel> contriChannels)
/* 143:    */   {
/* 144:238 */     this.contriChannels = contriChannels;
/* 145:    */   }
/* 146:    */   
/* 147:    */   public boolean equals(Object obj)
/* 148:    */   {
/* 149:245 */     if (obj == null) {
/* 150:245 */       return false;
/* 151:    */     }
/* 152:246 */     if (!(obj instanceof Group)) {
/* 153:246 */       return false;
/* 154:    */     }
/* 155:248 */     Group group = (Group)obj;
/* 156:249 */     if ((getId() == null) || (group.getId() == null)) {
/* 157:249 */       return false;
/* 158:    */     }
/* 159:250 */     return getId().equals(group.getId());
/* 160:    */   }
/* 161:    */   
/* 162:    */   public int hashCode()
/* 163:    */   {
/* 164:255 */     if (-2147483648 == this.hashCode)
/* 165:    */     {
/* 166:256 */       if (getId() == null) {
/* 167:256 */         return super.hashCode();
/* 168:    */       }
/* 169:258 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 170:259 */       this.hashCode = hashStr.hashCode();
/* 171:    */     }
/* 172:262 */     return this.hashCode;
/* 173:    */   }
/* 174:    */   
/* 175:    */   public String toString()
/* 176:    */   {
/* 177:267 */     return super.toString();
/* 178:    */   }
/* 179:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.entity.base.BaseGroup
 * JD-Core Version:    0.7.0.1
 */