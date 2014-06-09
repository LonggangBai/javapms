/*   1:    */ package com.portal.usermgr.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.doccenter.entity.Channel;
/*   4:    */ import com.portal.doccenter.entity.WorkFlow;
/*   5:    */ import com.portal.sysmgr.entity.Site;
/*   6:    */ import com.portal.usermgr.entity.Depart;
/*   7:    */ import java.io.Serializable;
/*   8:    */ import java.util.Date;
/*   9:    */ import java.util.Set;
/*  10:    */ import java.util.TreeSet;
/*  11:    */ 
/*  12:    */ public abstract class BaseDepart
/*  13:    */   implements Serializable
/*  14:    */ {
/*  15: 17 */   public static String REF = "Depart";
/*  16: 18 */   public static String PROP_FLOW = "flow";
/*  17: 19 */   public static String PROP_NAME = "name";
/*  18: 20 */   public static String PROP_PARENT = "parent";
/*  19: 21 */   public static String PROP_SITE = "site";
/*  20: 22 */   public static String PROP_VISIT_PATH = "visitPath";
/*  21: 23 */   public static String PROP_NUMBER = "number";
/*  22: 24 */   public static String PROP_CREATE_TIME = "createTime";
/*  23: 25 */   public static String PROP_SHOW = "show";
/*  24: 26 */   public static String PROP_ID = "id";
/*  25: 27 */   public static String PROP_PRIORITY = "priority";
/*  26:    */   
/*  27:    */   public BaseDepart()
/*  28:    */   {
/*  29: 32 */     initialize();
/*  30:    */   }
/*  31:    */   
/*  32:    */   public BaseDepart(Integer id)
/*  33:    */   {
/*  34: 39 */     setId(id);
/*  35: 40 */     initialize();
/*  36:    */   }
/*  37:    */   
/*  38:    */   public BaseDepart(Integer id, String name, Integer priority, Boolean show, Date createTime)
/*  39:    */   {
/*  40: 53 */     setId(id);
/*  41: 54 */     setName(name);
/*  42: 55 */     setPriority(priority);
/*  43: 56 */     setShow(show);
/*  44: 57 */     setCreateTime(createTime);
/*  45: 58 */     initialize();
/*  46:    */   }
/*  47:    */   
/*  48: 65 */   private int hashCode = -2147483648;
/*  49:    */   private Integer id;
/*  50:    */   private String name;
/*  51:    */   private String number;
/*  52:    */   private String visitPath;
/*  53:    */   private Integer priority;
/*  54:    */   private Boolean show;
/*  55:    */   private Date createTime;
/*  56:    */   private Depart parent;
/*  57:    */   private WorkFlow flow;
/*  58:    */   private Site site;
/*  59:    */   private Set<Channel> channels;
/*  60:    */   private Set<Depart> child;
/*  61:    */   
/*  62:    */   protected void initialize() {}
/*  63:    */   
/*  64:    */   public Integer getId()
/*  65:    */   {
/*  66: 96 */     return this.id;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public void setId(Integer id)
/*  70:    */   {
/*  71:104 */     this.id = id;
/*  72:105 */     this.hashCode = -2147483648;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public String getName()
/*  76:    */   {
/*  77:115 */     return this.name;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public void setName(String name)
/*  81:    */   {
/*  82:123 */     this.name = name;
/*  83:    */   }
/*  84:    */   
/*  85:    */   public String getNumber()
/*  86:    */   {
/*  87:132 */     return this.number;
/*  88:    */   }
/*  89:    */   
/*  90:    */   public void setNumber(String number)
/*  91:    */   {
/*  92:140 */     this.number = number;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public String getVisitPath()
/*  96:    */   {
/*  97:149 */     return this.visitPath;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public void setVisitPath(String visitPath)
/* 101:    */   {
/* 102:157 */     this.visitPath = visitPath;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public Integer getPriority()
/* 106:    */   {
/* 107:166 */     return this.priority;
/* 108:    */   }
/* 109:    */   
/* 110:    */   public void setPriority(Integer priority)
/* 111:    */   {
/* 112:174 */     this.priority = priority;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public Boolean getShow()
/* 116:    */   {
/* 117:183 */     return this.show;
/* 118:    */   }
/* 119:    */   
/* 120:    */   public void setShow(Boolean show)
/* 121:    */   {
/* 122:191 */     this.show = show;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public Date getCreateTime()
/* 126:    */   {
/* 127:200 */     return this.createTime;
/* 128:    */   }
/* 129:    */   
/* 130:    */   public void setCreateTime(Date createTime)
/* 131:    */   {
/* 132:208 */     this.createTime = createTime;
/* 133:    */   }
/* 134:    */   
/* 135:    */   public Depart getParent()
/* 136:    */   {
/* 137:217 */     return this.parent;
/* 138:    */   }
/* 139:    */   
/* 140:    */   public void setParent(Depart parent)
/* 141:    */   {
/* 142:225 */     this.parent = parent;
/* 143:    */   }
/* 144:    */   
/* 145:    */   public WorkFlow getFlow()
/* 146:    */   {
/* 147:234 */     return this.flow;
/* 148:    */   }
/* 149:    */   
/* 150:    */   public void setFlow(WorkFlow flow)
/* 151:    */   {
/* 152:242 */     this.flow = flow;
/* 153:    */   }
/* 154:    */   
/* 155:    */   public Site getSite()
/* 156:    */   {
/* 157:251 */     return this.site;
/* 158:    */   }
/* 159:    */   
/* 160:    */   public void setSite(Site site)
/* 161:    */   {
/* 162:259 */     this.site = site;
/* 163:    */   }
/* 164:    */   
/* 165:    */   public Set<Channel> getChannels()
/* 166:    */   {
/* 167:268 */     return this.channels;
/* 168:    */   }
/* 169:    */   
/* 170:    */   public void setChannels(Set<Channel> channels)
/* 171:    */   {
/* 172:276 */     this.channels = channels;
/* 173:    */   }
/* 174:    */   
/* 175:    */   public Set<Depart> getChild()
/* 176:    */   {
/* 177:285 */     return this.child;
/* 178:    */   }
/* 179:    */   
/* 180:    */   public void setChild(Set<Depart> child)
/* 181:    */   {
/* 182:293 */     this.child = child;
/* 183:    */   }
/* 184:    */   
/* 185:    */   public void addTochild(Depart depart)
/* 186:    */   {
/* 187:297 */     if (getChild() == null) {
/* 188:297 */       setChild(new TreeSet());
/* 189:    */     }
/* 190:298 */     getChild().add(depart);
/* 191:    */   }
/* 192:    */   
/* 193:    */   public boolean equals(Object obj)
/* 194:    */   {
/* 195:305 */     if (obj == null) {
/* 196:305 */       return false;
/* 197:    */     }
/* 198:306 */     if (!(obj instanceof Depart)) {
/* 199:306 */       return false;
/* 200:    */     }
/* 201:308 */     Depart depart = (Depart)obj;
/* 202:309 */     if ((getId() == null) || (depart.getId() == null)) {
/* 203:309 */       return false;
/* 204:    */     }
/* 205:310 */     return getId().equals(depart.getId());
/* 206:    */   }
/* 207:    */   
/* 208:    */   public int hashCode()
/* 209:    */   {
/* 210:315 */     if (-2147483648 == this.hashCode)
/* 211:    */     {
/* 212:316 */       if (getId() == null) {
/* 213:316 */         return super.hashCode();
/* 214:    */       }
/* 215:318 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 216:319 */       this.hashCode = hashStr.hashCode();
/* 217:    */     }
/* 218:322 */     return this.hashCode;
/* 219:    */   }
/* 220:    */   
/* 221:    */   public String toString()
/* 222:    */   {
/* 223:327 */     return super.toString();
/* 224:    */   }
/* 225:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.entity.base.BaseDepart
 * JD-Core Version:    0.7.0.1
 */