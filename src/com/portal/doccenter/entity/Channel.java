/*   1:    */ package com.portal.doccenter.entity;
/*   2:    */ 
/*   3:    */ import com.portal.doccenter.entity.base.BaseChannel;
/*   4:    */ import com.portal.sysmgr.entity.Site;
/*   5:    */ import com.portal.usermgr.entity.Depart;
/*   6:    */ import com.portal.usermgr.entity.Group;
/*   7:    */ import java.util.ArrayList;
/*   8:    */ import java.util.Collection;
/*   9:    */ import java.util.HashSet;
/*  10:    */ import java.util.LinkedList;
/*  11:    */ import java.util.List;
/*  12:    */ import java.util.Set;
/*  13:    */ import java.util.TreeSet;
/*  14:    */ import org.apache.commons.lang.StringUtils;
/*  15:    */ 
/*  16:    */ public class Channel
/*  17:    */   extends BaseChannel
/*  18:    */ {
/*  19:    */   private static final long serialVersionUID = 1L;
/*  20:    */   
/*  21:    */   public String getUrl()
/*  22:    */   {
/*  23: 33 */     StringBuilder sb = new StringBuilder(getSite().getUrl());
/*  24: 34 */     sb.append(getPath());
/*  25: 35 */     sb.append("/");
/*  26: 36 */     sb.append("index");
/*  27: 37 */     sb.append(".jsp");
/*  28: 38 */     return sb.toString();
/*  29:    */   }
/*  30:    */   
/*  31:    */   public String getUrl(Integer page)
/*  32:    */   {
/*  33: 42 */     if (page == null) {
/*  34: 43 */       page = Integer.valueOf(1);
/*  35:    */     }
/*  36: 45 */     StringBuilder sb = new StringBuilder(getSite().getUrl());
/*  37: 46 */     sb.append(getPath());
/*  38: 47 */     sb.append("/");
/*  39: 48 */     sb.append("index");
/*  40: 49 */     sb.append("_");
/*  41: 50 */     sb.append(page);
/*  42: 51 */     sb.append(".jsp");
/*  43: 52 */     return sb.toString();
/*  44:    */   }
/*  45:    */   
/*  46:    */   public List<Channel> getNodeList()
/*  47:    */   {
/*  48: 56 */     LinkedList<Channel> list = new LinkedList();
/*  49: 57 */     Channel node = this;
/*  50: 58 */     while (node != null)
/*  51:    */     {
/*  52: 59 */       list.addFirst(node);
/*  53: 60 */       node = node.getParent();
/*  54:    */     }
/*  55: 62 */     return list;
/*  56:    */   }
/*  57:    */   
/*  58:    */   public Integer[] getNodeIds()
/*  59:    */   {
/*  60: 66 */     List<Channel> channels = getNodeList();
/*  61: 67 */     Integer[] ids = new Integer[channels.size()];
/*  62: 68 */     int i = 0;
/*  63: 69 */     for (Channel c : channels) {
/*  64: 70 */       ids[(i++)] = c.getId();
/*  65:    */     }
/*  66: 72 */     return ids;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public int getDeep()
/*  70:    */   {
/*  71: 81 */     int deep = 0;
/*  72: 82 */     Channel parent = getParent();
/*  73: 83 */     while (parent != null)
/*  74:    */     {
/*  75: 84 */       deep++;
/*  76: 85 */       parent = parent.getParent();
/*  77:    */     }
/*  78: 87 */     return deep;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public String getTplChannelOrDef()
/*  82:    */   {
/*  83: 91 */     String tpl = getTplChannel();
/*  84: 92 */     if (!StringUtils.isBlank(tpl))
/*  85:    */     {
/*  86: 93 */       String root = getSite().getSolutionPath();
/*  87: 94 */       return root + tpl;
/*  88:    */     }
/*  89: 96 */     return null;
/*  90:    */   }
/*  91:    */   
/*  92:    */   public void addToTpls(ChnlTplSelection chnltpl)
/*  93:    */   {
/*  94:100 */     Set<ChnlTplSelection> chnltpls = getTpls();
/*  95:101 */     if (chnltpls == null)
/*  96:    */     {
/*  97:102 */       chnltpls = new HashSet();
/*  98:103 */       setTpls(chnltpls);
/*  99:    */     }
/* 100:105 */     chnltpls.add(chnltpl);
/* 101:    */   }
/* 102:    */   
/* 103:    */   public void addToViewGroups(Group group)
/* 104:    */   {
/* 105:109 */     Set<Group> groups = getViewGroups();
/* 106:110 */     if (groups == null)
/* 107:    */     {
/* 108:111 */       groups = new TreeSet();
/* 109:112 */       setViewGroups(groups);
/* 110:    */     }
/* 111:114 */     groups.add(group);
/* 112:115 */     group.getViewChannels().add(this);
/* 113:    */   }
/* 114:    */   
/* 115:    */   public void addToContriGroups(Group group)
/* 116:    */   {
/* 117:119 */     Set<Group> groups = getContriGroups();
/* 118:120 */     if (groups == null)
/* 119:    */     {
/* 120:121 */       groups = new TreeSet();
/* 121:122 */       setContriGroups(groups);
/* 122:    */     }
/* 123:124 */     groups.add(group);
/* 124:125 */     group.getContriChannels().add(this);
/* 125:    */   }
/* 126:    */   
/* 127:    */   public void addToDeparts(Depart depart)
/* 128:    */   {
/* 129:129 */     Set<Depart> set = getDeparts();
/* 130:130 */     if (set == null)
/* 131:    */     {
/* 132:131 */       set = new HashSet();
/* 133:132 */       setDeparts(set);
/* 134:    */     }
/* 135:134 */     set.add(depart);
/* 136:135 */     depart.addToChannels(this);
/* 137:    */   }
/* 138:    */   
/* 139:    */   public void addToChilds(Channel child)
/* 140:    */   {
/* 141:139 */     Set<Channel> set = getChild();
/* 142:140 */     if (set == null)
/* 143:    */     {
/* 144:141 */       set = new HashSet();
/* 145:142 */       setChild(set);
/* 146:    */     }
/* 147:144 */     set.add(child);
/* 148:    */   }
/* 149:    */   
/* 150:    */   public void init()
/* 151:    */   {
/* 152:148 */     if (getPriority() == null) {
/* 153:149 */       setPriority(Integer.valueOf(10));
/* 154:    */     }
/* 155:151 */     if (getShow() == null) {
/* 156:152 */       setShow(Boolean.valueOf(true));
/* 157:    */     }
/* 158:154 */     if (getAlone() == null) {
/* 159:155 */       setAlone(Boolean.valueOf(false));
/* 160:    */     }
/* 161:    */   }
/* 162:    */   
/* 163:    */   public String getWholeName()
/* 164:    */   {
/* 165:160 */     String name = getName();
/* 166:161 */     Channel parent = getParent();
/* 167:162 */     if (parent != null) {
/* 168:163 */       name = parent.getWholeName() + "-->" + name;
/* 169:    */     }
/* 170:165 */     return name;
/* 171:    */   }
/* 172:    */   
/* 173:    */   public String getLink()
/* 174:    */   {
/* 175:169 */     ChannelExt ext = getExt();
/* 176:170 */     if (ext != null) {
/* 177:171 */       return ext.getLink();
/* 178:    */     }
/* 179:173 */     return null;
/* 180:    */   }
/* 181:    */   
/* 182:    */   public String getTplChannel()
/* 183:    */   {
/* 184:178 */     ChannelExt ext = getExt();
/* 185:179 */     if (ext != null) {
/* 186:180 */       return ext.getTplChannel();
/* 187:    */     }
/* 188:182 */     return null;
/* 189:    */   }
/* 190:    */   
/* 191:    */   public String getTplDoc(Integer modelId)
/* 192:    */   {
/* 193:187 */     Set<ChnlTplSelection> tpls = getTpls();
/* 194:188 */     if (tpls != null) {
/* 195:189 */       for (ChnlTplSelection tpl : tpls) {
/* 196:190 */         if (tpl.getModelId().equals(modelId)) {
/* 197:191 */           return tpl.getTplDoc();
/* 198:    */         }
/* 199:    */       }
/* 200:    */     }
/* 201:195 */     return null;
/* 202:    */   }
/* 203:    */   
/* 204:    */   public List<Model> getModelList()
/* 205:    */   {
/* 206:199 */     Set<ChnlTplSelection> tpls = getTpls();
/* 207:200 */     if (tpls != null)
/* 208:    */     {
/* 209:201 */       List<Model> modelList = new ArrayList();
/* 210:202 */       for (ChnlTplSelection tpl : tpls) {
/* 211:203 */         modelList.add(tpl.getModel());
/* 212:    */       }
/* 213:205 */       return modelList;
/* 214:    */     }
/* 215:207 */     return null;
/* 216:    */   }
/* 217:    */   
/* 218:    */   public String getTitle()
/* 219:    */   {
/* 220:211 */     ChannelExt ext = getExt();
/* 221:212 */     if (ext != null) {
/* 222:213 */       return ext.getTitle();
/* 223:    */     }
/* 224:215 */     return null;
/* 225:    */   }
/* 226:    */   
/* 227:    */   public String getKeywords()
/* 228:    */   {
/* 229:220 */     ChannelExt ext = getExt();
/* 230:221 */     if (ext != null) {
/* 231:222 */       return ext.getKeywords();
/* 232:    */     }
/* 233:224 */     return null;
/* 234:    */   }
/* 235:    */   
/* 236:    */   public String getDescription()
/* 237:    */   {
/* 238:229 */     ChannelExt ext = getExt();
/* 239:230 */     if (ext != null) {
/* 240:231 */       return ext.getDescription();
/* 241:    */     }
/* 242:233 */     return null;
/* 243:    */   }
/* 244:    */   
/* 245:    */   public Boolean getCommentControl()
/* 246:    */   {
/* 247:238 */     ChannelExt ext = getExt();
/* 248:239 */     if (ext != null) {
/* 249:240 */       return ext.getCommentControl();
/* 250:    */     }
/* 251:242 */     return null;
/* 252:    */   }
/* 253:    */   
/* 254:    */   public Boolean getUpdownControl()
/* 255:    */   {
/* 256:247 */     ChannelExt ext = getExt();
/* 257:248 */     if (ext != null) {
/* 258:249 */       return ext.getUpdownControl();
/* 259:    */     }
/* 260:251 */     return null;
/* 261:    */   }
/* 262:    */   
/* 263:    */   public Boolean getBlank()
/* 264:    */   {
/* 265:256 */     ChannelExt ext = getExt();
/* 266:257 */     if (ext != null) {
/* 267:258 */       return ext.getBlank();
/* 268:    */     }
/* 269:260 */     return null;
/* 270:    */   }
/* 271:    */   
/* 272:    */   public String getTxtValue()
/* 273:    */   {
/* 274:270 */     ChannelTxt txt = getTxt();
/* 275:271 */     if (txt != null) {
/* 276:272 */       return txt.getTxtval();
/* 277:    */     }
/* 278:274 */     return null;
/* 279:    */   }
/* 280:    */   
/* 281:    */   public static Integer[] fetchIds(Collection<Channel> channels)
/* 282:    */   {
/* 283:279 */     if (channels == null) {
/* 284:280 */       return null;
/* 285:    */     }
/* 286:282 */     Integer[] ids = new Integer[channels.size()];
/* 287:283 */     int i = 0;
/* 288:284 */     for (Channel c : channels) {
/* 289:285 */       ids[(i++)] = c.getId();
/* 290:    */     }
/* 291:287 */     return ids;
/* 292:    */   }
/* 293:    */   
/* 294:    */   public Channel() {}
/* 295:    */   
/* 296:    */   public Channel(Integer id)
/* 297:    */   {
/* 298:299 */     super(id);
/* 299:    */   }
/* 300:    */   
/* 301:    */   public Channel(Integer id, Site site, String name, Integer priority, Boolean alone, Boolean show)
/* 302:    */   {
/* 303:309 */     super(id, site, name, priority, alone, show);
/* 304:    */   }
/* 305:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.entity.Channel
 * JD-Core Version:    0.7.0.1
 */