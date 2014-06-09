/*   1:    */ package com.portal.usermgr.entity;
/*   2:    */ 
/*   3:    */ import com.portal.doccenter.entity.Channel;
/*   4:    */ import com.portal.doccenter.entity.FlowStep;
/*   5:    */ import com.portal.doccenter.entity.WorkFlow;
/*   6:    */ import com.portal.sysmgr.entity.Site;
/*   7:    */ import com.portal.usermgr.entity.base.BaseAdmin;
/*   8:    */ import java.sql.Timestamp;
/*   9:    */ import java.util.Date;
/*  10:    */ import java.util.HashSet;
/*  11:    */ import java.util.Set;
/*  12:    */ 
/*  13:    */ public class Admin
/*  14:    */   extends BaseAdmin
/*  15:    */ {
/*  16:    */   private static final long serialVersionUID = 1L;
/*  17:    */   
/*  18:    */   public void init()
/*  19:    */   {
/*  20: 15 */     if (getRegisterTime() == null) {
/*  21: 16 */       setRegisterTime(new Timestamp(System.currentTimeMillis()));
/*  22:    */     }
/*  23: 18 */     if (getLoginCount() == null) {
/*  24: 19 */       setLoginCount(Integer.valueOf(0));
/*  25:    */     }
/*  26: 21 */     if (getStatus() == null) {
/*  27: 22 */       setStatus(Byte.valueOf((byte)0));
/*  28:    */     }
/*  29:    */   }
/*  30:    */   
/*  31:    */   public Byte getManageStatus(Integer siteId)
/*  32:    */   {
/*  33: 27 */     AdminCheck uc = getAdminCheck(siteId);
/*  34: 28 */     if (uc != null) {
/*  35: 29 */       return uc.getManageStatus();
/*  36:    */     }
/*  37: 31 */     return null;
/*  38:    */   }
/*  39:    */   
/*  40:    */   public boolean haveAllManage(Integer siteId)
/*  41:    */   {
/*  42: 36 */     if (getManageStatus(siteId) == null) {
/*  43: 37 */       return false;
/*  44:    */     }
/*  45: 39 */     if (getManageStatus(siteId).equals(Byte.valueOf((byte)4))) {
/*  46: 40 */       return true;
/*  47:    */     }
/*  48: 42 */     return false;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public AdminCheck getAdminCheck(Integer siteId)
/*  52:    */   {
/*  53: 46 */     Set<AdminCheck> set = getAdminChecks();
/*  54: 47 */     for (AdminCheck uc : set) {
/*  55: 48 */       if (uc.getSite().getId().equals(siteId)) {
/*  56: 49 */         return uc;
/*  57:    */       }
/*  58:    */     }
/*  59: 52 */     return null;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public Role getRole(Integer siteId)
/*  63:    */   {
/*  64: 56 */     for (Role role : getRoles()) {
/*  65: 57 */       if (role.getSite().getId().equals(siteId)) {
/*  66: 58 */         return role;
/*  67:    */       }
/*  68:    */     }
/*  69: 61 */     return null;
/*  70:    */   }
/*  71:    */   
/*  72:    */   public Depart getDepart(Integer siteId)
/*  73:    */   {
/*  74: 65 */     for (Depart depart : getDeparts()) {
/*  75: 66 */       if (depart.getSite().getId().equals(siteId)) {
/*  76: 67 */         return depart;
/*  77:    */       }
/*  78:    */     }
/*  79: 70 */     return null;
/*  80:    */   }
/*  81:    */   
/*  82:    */   public Set<Channel> getChannels(Integer siteId)
/*  83:    */   {
/*  84: 74 */     Depart depart = getDepart(siteId);
/*  85: 75 */     if (depart == null) {
/*  86: 76 */       return null;
/*  87:    */     }
/*  88: 78 */     return depart.getChannels();
/*  89:    */   }
/*  90:    */   
/*  91:    */   public Integer[] getChannelIds(Integer siteId)
/*  92:    */   {
/*  93: 82 */     Set<Channel> channels = getChannels(siteId);
/*  94: 83 */     return Channel.fetchIds(channels);
/*  95:    */   }
/*  96:    */   
/*  97:    */   public Integer getStep(Integer siteId)
/*  98:    */   {
/*  99: 87 */     Integer roleId = getRole(siteId).getId();
/* 100: 88 */     Depart depart = getDepart(siteId);
/* 101: 89 */     if ((depart != null) && 
/* 102: 90 */       (depart.getFlow() != null) && 
/* 103: 91 */       (depart.getFlow().getStep(roleId) != null)) {
/* 104: 92 */       return depart.getFlow().getStep(roleId).getStep();
/* 105:    */     }
/* 106: 96 */     return null;
/* 107:    */   }
/* 108:    */   
/* 109:    */   public AdminCheck getAdminCheck()
/* 110:    */   {
/* 111:100 */     return getAdminCheck(Integer.valueOf(1));
/* 112:    */   }
/* 113:    */   
/* 114:    */   public String getStatusString()
/* 115:    */   {
/* 116:104 */     if (getStatus().equals(Byte.valueOf((byte)0))) {
/* 117:105 */       return "<span style='color:blue'>正常</span>";
/* 118:    */     }
/* 119:107 */     return "<span style='color:red'>禁用</span>";
/* 120:    */   }
/* 121:    */   
/* 122:    */   public Boolean getAllChannel(Integer siteId)
/* 123:    */   {
/* 124:112 */     Depart depart = getDepart(siteId);
/* 125:113 */     if (depart == null) {
/* 126:114 */       return Boolean.valueOf(true);
/* 127:    */     }
/* 128:116 */     if ((depart.getChannels() == null) || (depart.getChannels().size() == 0)) {
/* 129:117 */       return Boolean.valueOf(true);
/* 130:    */     }
/* 131:119 */     return Boolean.valueOf(false);
/* 132:    */   }
/* 133:    */   
/* 134:    */   public String getUsername()
/* 135:    */   {
/* 136:123 */     return getUser().getUsername();
/* 137:    */   }
/* 138:    */   
/* 139:    */   public Role getRole()
/* 140:    */   {
/* 141:127 */     return getRole(Integer.valueOf(1));
/* 142:    */   }
/* 143:    */   
/* 144:    */   public Depart getDepart()
/* 145:    */   {
/* 146:131 */     return getDepart(Integer.valueOf(1));
/* 147:    */   }
/* 148:    */   
/* 149:    */   public Set<Channel> getChannels()
/* 150:    */   {
/* 151:135 */     return getChannels(Integer.valueOf(1));
/* 152:    */   }
/* 153:    */   
/* 154:    */   public Integer[] getChannelIds()
/* 155:    */   {
/* 156:139 */     return getChannelIds(Integer.valueOf(1));
/* 157:    */   }
/* 158:    */   
/* 159:    */   public void addToRoles(Role role)
/* 160:    */   {
/* 161:143 */     if (role == null) {
/* 162:144 */       return;
/* 163:    */     }
/* 164:146 */     Set<Role> set = getRoles();
/* 165:147 */     if (set == null)
/* 166:    */     {
/* 167:148 */       set = new HashSet();
/* 168:149 */       setRoles(set);
/* 169:    */     }
/* 170:151 */     set.add(role);
/* 171:    */   }
/* 172:    */   
/* 173:    */   public void addToDeparts(Depart depart)
/* 174:    */   {
/* 175:155 */     if (depart == null) {
/* 176:156 */       return;
/* 177:    */     }
/* 178:158 */     Set<Depart> set = getDeparts();
/* 179:159 */     if (set == null)
/* 180:    */     {
/* 181:160 */       set = new HashSet();
/* 182:161 */       setDeparts(set);
/* 183:    */     }
/* 184:163 */     set.add(depart);
/* 185:    */   }
/* 186:    */   
/* 187:    */   public void addToAdminChecks(AdminCheck adminCheck)
/* 188:    */   {
/* 189:167 */     if (adminCheck == null) {
/* 190:168 */       return;
/* 191:    */     }
/* 192:170 */     Set<AdminCheck> set = getAdminChecks();
/* 193:171 */     if (set == null)
/* 194:    */     {
/* 195:172 */       set = new HashSet();
/* 196:173 */       setAdminChecks(set);
/* 197:    */     }
/* 198:175 */     set.add(adminCheck);
/* 199:    */   }
/* 200:    */   
/* 201:    */   public Set<Site> getSites()
/* 202:    */   {
/* 203:179 */     Set<AdminCheck> adminSites = getAdminChecks();
/* 204:180 */     Set<Site> sites = new HashSet(adminSites.size());
/* 205:181 */     for (AdminCheck us : adminSites) {
/* 206:182 */       sites.add(us.getSite());
/* 207:    */     }
/* 208:184 */     return sites;
/* 209:    */   }
/* 210:    */   
/* 211:    */   public Boolean getAllPerm(Integer siteId)
/* 212:    */   {
/* 213:188 */     Role role = getRole(siteId);
/* 214:189 */     if (role == null) {
/* 215:190 */       return Boolean.valueOf(false);
/* 216:    */     }
/* 217:192 */     if (role.getAllPerm() != null) {
/* 218:193 */       return role.getAllPerm();
/* 219:    */     }
/* 220:195 */     return Boolean.valueOf(false);
/* 221:    */   }
/* 222:    */   
/* 223:    */   public Set<String> getPerms(Integer siteId)
/* 224:    */   {
/* 225:199 */     Role role = getRole(siteId);
/* 226:200 */     if (role == null) {
/* 227:201 */       return null;
/* 228:    */     }
/* 229:203 */     Set<String> perms = new HashSet();
/* 230:204 */     if (role.getAllPerm().booleanValue()) {
/* 231:205 */       perms.add("*");
/* 232:207 */     } else if (role.getPerms() != null) {
/* 233:208 */       for (String perm : role.getPerms().split(",")) {
/* 234:209 */         perms.add(perm);
/* 235:    */       }
/* 236:    */     }
/* 237:213 */     return perms;
/* 238:    */   }
/* 239:    */   
/* 240:    */   public Admin() {}
/* 241:    */   
/* 242:    */   public Admin(Integer id)
/* 243:    */   {
/* 244:225 */     super(id);
/* 245:    */   }
/* 246:    */   
/* 247:    */   public Admin(Integer id, Date registerTime, String registerIp, Integer loginCount, Byte status)
/* 248:    */   {
/* 249:235 */     super(id, registerTime, registerIp, loginCount, status);
/* 250:    */   }
/* 251:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.entity.Admin
 * JD-Core Version:    0.7.0.1
 */