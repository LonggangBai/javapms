/*   1:    */ package com.portal.doccenter.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.doccenter.entity.Article;
/*   4:    */ import com.portal.doccenter.entity.FlowDetail;
/*   5:    */ import com.portal.usermgr.entity.Role;
/*   6:    */ import com.portal.usermgr.entity.User;
/*   7:    */ import java.io.Serializable;
/*   8:    */ import java.util.Date;
/*   9:    */ 
/*  10:    */ public abstract class BaseFlowDetail
/*  11:    */   implements Serializable
/*  12:    */ {
/*  13: 17 */   public static String REF = "FlowDetail";
/*  14: 18 */   public static String PROP_USER = "user";
/*  15: 19 */   public static String PROP_DOC = "doc";
/*  16: 20 */   public static String PROP_CHECKED = "checked";
/*  17: 21 */   public static String PROP_CREATE_TIME = "createTime";
/*  18: 22 */   public static String PROP_ROLE = "role";
/*  19: 23 */   public static String PROP_BACK_INITIAL = "backInitial";
/*  20: 24 */   public static String PROP_ID = "id";
/*  21: 25 */   public static String PROP_PRIORITY = "priority";
/*  22: 26 */   public static String PROP_REASON = "reason";
/*  23:    */   
/*  24:    */   public BaseFlowDetail()
/*  25:    */   {
/*  26: 31 */     initialize();
/*  27:    */   }
/*  28:    */   
/*  29:    */   public BaseFlowDetail(Integer id)
/*  30:    */   {
/*  31: 38 */     setId(id);
/*  32: 39 */     initialize();
/*  33:    */   }
/*  34:    */   
/*  35:    */   public BaseFlowDetail(Integer id, Article doc, User user, Role role, Boolean backInitial, Boolean checked, Integer priority, Date createTime)
/*  36:    */   {
/*  37: 55 */     setId(id);
/*  38: 56 */     setDoc(doc);
/*  39: 57 */     setUser(user);
/*  40: 58 */     setRole(role);
/*  41: 59 */     setBackInitial(backInitial);
/*  42: 60 */     setChecked(checked);
/*  43: 61 */     setPriority(priority);
/*  44: 62 */     setCreateTime(createTime);
/*  45: 63 */     initialize();
/*  46:    */   }
/*  47:    */   
/*  48: 70 */   private int hashCode = -2147483648;
/*  49:    */   private Integer id;
/*  50:    */   private Boolean backInitial;
/*  51:    */   private Boolean checked;
/*  52:    */   private String reason;
/*  53:    */   private Integer priority;
/*  54:    */   private Date createTime;
/*  55:    */   private Article doc;
/*  56:    */   private User user;
/*  57:    */   private Role role;
/*  58:    */   
/*  59:    */   protected void initialize() {}
/*  60:    */   
/*  61:    */   public Integer getId()
/*  62:    */   {
/*  63: 96 */     return this.id;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public void setId(Integer id)
/*  67:    */   {
/*  68:104 */     this.id = id;
/*  69:105 */     this.hashCode = -2147483648;
/*  70:    */   }
/*  71:    */   
/*  72:    */   public Boolean getBackInitial()
/*  73:    */   {
/*  74:115 */     return this.backInitial;
/*  75:    */   }
/*  76:    */   
/*  77:    */   public void setBackInitial(Boolean backInitial)
/*  78:    */   {
/*  79:123 */     this.backInitial = backInitial;
/*  80:    */   }
/*  81:    */   
/*  82:    */   public Boolean getChecked()
/*  83:    */   {
/*  84:132 */     return this.checked;
/*  85:    */   }
/*  86:    */   
/*  87:    */   public void setChecked(Boolean checked)
/*  88:    */   {
/*  89:140 */     this.checked = checked;
/*  90:    */   }
/*  91:    */   
/*  92:    */   public String getReason()
/*  93:    */   {
/*  94:149 */     return this.reason;
/*  95:    */   }
/*  96:    */   
/*  97:    */   public void setReason(String reason)
/*  98:    */   {
/*  99:157 */     this.reason = reason;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public Integer getPriority()
/* 103:    */   {
/* 104:166 */     return this.priority;
/* 105:    */   }
/* 106:    */   
/* 107:    */   public void setPriority(Integer priority)
/* 108:    */   {
/* 109:174 */     this.priority = priority;
/* 110:    */   }
/* 111:    */   
/* 112:    */   public Date getCreateTime()
/* 113:    */   {
/* 114:183 */     return this.createTime;
/* 115:    */   }
/* 116:    */   
/* 117:    */   public void setCreateTime(Date createTime)
/* 118:    */   {
/* 119:191 */     this.createTime = createTime;
/* 120:    */   }
/* 121:    */   
/* 122:    */   public Article getDoc()
/* 123:    */   {
/* 124:200 */     return this.doc;
/* 125:    */   }
/* 126:    */   
/* 127:    */   public void setDoc(Article doc)
/* 128:    */   {
/* 129:208 */     this.doc = doc;
/* 130:    */   }
/* 131:    */   
/* 132:    */   public User getUser()
/* 133:    */   {
/* 134:217 */     return this.user;
/* 135:    */   }
/* 136:    */   
/* 137:    */   public void setUser(User user)
/* 138:    */   {
/* 139:225 */     this.user = user;
/* 140:    */   }
/* 141:    */   
/* 142:    */   public Role getRole()
/* 143:    */   {
/* 144:234 */     return this.role;
/* 145:    */   }
/* 146:    */   
/* 147:    */   public void setRole(Role role)
/* 148:    */   {
/* 149:242 */     this.role = role;
/* 150:    */   }
/* 151:    */   
/* 152:    */   public boolean equals(Object obj)
/* 153:    */   {
/* 154:249 */     if (obj == null) {
/* 155:249 */       return false;
/* 156:    */     }
/* 157:250 */     if (!(obj instanceof FlowDetail)) {
/* 158:250 */       return false;
/* 159:    */     }
/* 160:252 */     FlowDetail flowDetail = (FlowDetail)obj;
/* 161:253 */     if ((getId() == null) || (flowDetail.getId() == null)) {
/* 162:253 */       return false;
/* 163:    */     }
/* 164:254 */     return getId().equals(flowDetail.getId());
/* 165:    */   }
/* 166:    */   
/* 167:    */   public int hashCode()
/* 168:    */   {
/* 169:259 */     if (-2147483648 == this.hashCode)
/* 170:    */     {
/* 171:260 */       if (getId() == null) {
/* 172:260 */         return super.hashCode();
/* 173:    */       }
/* 174:262 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 175:263 */       this.hashCode = hashStr.hashCode();
/* 176:    */     }
/* 177:266 */     return this.hashCode;
/* 178:    */   }
/* 179:    */   
/* 180:    */   public String toString()
/* 181:    */   {
/* 182:271 */     return super.toString();
/* 183:    */   }
/* 184:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.entity.base.BaseFlowDetail
 * JD-Core Version:    0.7.0.1
 */