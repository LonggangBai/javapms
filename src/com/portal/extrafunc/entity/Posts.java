/*   1:    */ package com.portal.extrafunc.entity;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.utils.StringBeanUtils;
/*   4:    */ import com.portal.extrafunc.entity.base.BasePosts;
/*   5:    */ import com.portal.sysmgr.entity.Site;
/*   6:    */ import com.portal.sysmgr.utils.code.BbcodeHandler;
/*   7:    */ import java.sql.Timestamp;
/*   8:    */ import java.util.ArrayList;
/*   9:    */ import java.util.Date;
/*  10:    */ import java.util.List;
/*  11:    */ import java.util.regex.Matcher;
/*  12:    */ import java.util.regex.Pattern;
/*  13:    */ import org.apache.commons.lang.StringUtils;
/*  14:    */ 
/*  15:    */ public class Posts
/*  16:    */   extends BasePosts
/*  17:    */ {
/*  18:    */   private static final long serialVersionUID = 1L;
/*  19:    */   public static final int NORMAL = 0;
/*  20:    */   public static final int SHIELD = -1;
/*  21:    */   public static final int DELETE = -2;
/*  22:    */   
/*  23:    */   public void init()
/*  24:    */   {
/*  25: 25 */     if (getStatus() == null) {
/*  26: 26 */       setStatus(Integer.valueOf(0));
/*  27:    */     }
/*  28: 28 */     if (getImg() == null) {
/*  29: 29 */       setImg(Boolean.valueOf(false));
/*  30:    */     }
/*  31: 31 */     if (getCreateTime() == null) {
/*  32: 32 */       setCreateTime(new Timestamp(System.currentTimeMillis()));
/*  33:    */     }
/*  34:    */   }
/*  35:    */   
/*  36:    */   public void addToAttachs(String name, String description, String fileName, String filePath, Integer fileSize, Boolean img)
/*  37:    */   {
/*  38: 38 */     List<PostsAttach> list = getAttachs();
/*  39: 39 */     if (list == null)
/*  40:    */     {
/*  41: 40 */       list = new ArrayList();
/*  42: 41 */       setAttachs(list);
/*  43:    */     }
/*  44: 43 */     PostsAttach pa = new PostsAttach();
/*  45: 44 */     pa.setName(name);
/*  46: 45 */     pa.setDescription(description);
/*  47: 46 */     pa.setFileName(fileName);
/*  48: 47 */     pa.setFilePath(filePath);
/*  49: 48 */     pa.setFileSize(fileSize);
/*  50: 49 */     pa.setImg(img);
/*  51: 50 */     list.add(pa);
/*  52:    */   }
/*  53:    */   
/*  54:    */   public String getContent()
/*  55:    */   {
/*  56: 54 */     PostsTxt txt = getTxt();
/*  57: 55 */     if (txt != null) {
/*  58: 56 */       return txt.getContent();
/*  59:    */     }
/*  60: 58 */     return null;
/*  61:    */   }
/*  62:    */   
/*  63:    */   public String getContentAll()
/*  64:    */   {
/*  65: 67 */     String s = getContent();
/*  66: 68 */     String qc = "";
/*  67: 69 */     if (StringUtils.isBlank(s)) {
/*  68: 70 */       return "";
/*  69:    */     }
/*  70: 72 */     if (getStatus().intValue() < 0) {
/*  71: 73 */       s = 
/*  72: 74 */         "[quote='shield'][h=6]提示:该贴已被删除或者被屏蔽,您是管理员，可见其内容[/h]" + s + "[/quote]";
/*  73:    */     }
/*  74: 76 */     if (getQuote() != null) {
/*  75: 77 */       qc = getQuote().getContentNoQuote(true);
/*  76:    */     }
/*  77: 79 */     if (getHidden().booleanValue())
/*  78:    */     {
/*  79: 80 */       List<String> list = getHideContent(s);
/*  80: 81 */       for (String str : list) {
/*  81: 82 */         s = StringBeanUtils.replace(s, "[hide]" + str + "[/hide]", 
/*  82: 83 */           "[quote='content_hidden'][h=6]此为隐藏内容:[/h]" + str + 
/*  83: 84 */           "[/quote]");
/*  84:    */       }
/*  85:    */     }
/*  86: 87 */     if (getAffix().booleanValue())
/*  87:    */     {
/*  88: 88 */       List<PostsAttach> att = getAttachs();
/*  89: 89 */       for (int i = 0; i < att.size(); i++)
/*  90:    */       {
/*  91: 90 */         PostsAttach pa = (PostsAttach)att.get(i);
/*  92: 91 */         if (pa != null)
/*  93:    */         {
/*  94: 92 */           String oldcontent = "[attachment]" + i + 
/*  95: 93 */             "[/attachment]";
/*  96: 94 */           if (pa.getImg().booleanValue())
/*  97:    */           {
/*  98: 95 */             String newcontent = "[img]" + getSite().getUrl() + 
/*  99: 96 */               pa.getFilePath().substring(1) + "[/img]";
/* 100: 97 */             s = StringBeanUtils.replace(s, oldcontent, 
/* 101: 98 */               newcontent);
/* 102:    */           }
/* 103:    */           else
/* 104:    */           {
/* 105:100 */             String newcontent = "[url=" + getSite().getUrl() + 
/* 106:101 */               pa.getFilePath().substring(1) + "]" + 
/* 107:102 */               pa.getFileName() + "[/url]";
/* 108:103 */             s = StringBeanUtils.replace(s, oldcontent, 
/* 109:104 */               newcontent);
/* 110:    */           }
/* 111:    */         }
/* 112:    */       }
/* 113:    */     }
/* 114:109 */     return qc + BbcodeHandler.toHtml(s);
/* 115:    */   }
/* 116:    */   
/* 117:    */   public String getContentAndQuote(boolean showhidden)
/* 118:    */   {
/* 119:119 */     String s = getContent();
/* 120:120 */     String qc = "";
/* 121:121 */     if (StringUtils.isBlank(s)) {
/* 122:122 */       return "";
/* 123:    */     }
/* 124:124 */     if (getStatus().intValue() < 0)
/* 125:    */     {
/* 126:125 */       String content = "[quote='shield'][color=red]该贴已被删除或者被屏蔽[/color][/quote]";
/* 127:126 */       return BbcodeHandler.toHtml(content);
/* 128:    */     }
/* 129:128 */     if (getQuote() != null) {
/* 130:129 */       qc = getQuote().getContentNoQuote(showhidden);
/* 131:    */     }
/* 132:131 */     if (getHidden().booleanValue())
/* 133:    */     {
/* 134:132 */       List<String> list = getHideContent(s);
/* 135:133 */       if (showhidden) {
/* 136:134 */         for (String str : list) {
/* 137:135 */           s = StringBeanUtils.replace(s, "[hide]" + str + 
/* 138:136 */             "[/hide]", 
/* 139:137 */             "[quote='content_hidden'][h=6]此为隐藏内容:[/h]" + 
/* 140:138 */             str + "[/quote]");
/* 141:    */         }
/* 142:    */       } else {
/* 143:141 */         for (String str : list) {
/* 144:142 */           s = 
/* 145:143 */             StringBeanUtils.replace(
/* 146:144 */             s, 
/* 147:145 */             "[hide]" + str + "[/hide]", 
/* 148:146 */             "[quote='content_hidden'][h=6]提示:[/h][color=red]这是隐藏内容.需要回复才能浏览[/color][/quote]");
/* 149:    */         }
/* 150:    */       }
/* 151:    */     }
/* 152:150 */     if (getAffix().booleanValue())
/* 153:    */     {
/* 154:151 */       List<PostsAttach> att = getAttachs();
/* 155:152 */       for (int i = 0; i < att.size(); i++)
/* 156:    */       {
/* 157:153 */         PostsAttach pa = (PostsAttach)att.get(i);
/* 158:154 */         if (pa != null)
/* 159:    */         {
/* 160:155 */           String oldcontent = "[attachment]" + i + 
/* 161:156 */             "[/attachment]";
/* 162:157 */           if (pa.getImg().booleanValue())
/* 163:    */           {
/* 164:158 */             String newcontent = "[img]" + getSite().getUrl() + 
/* 165:159 */               pa.getFilePath().substring(1) + "[/img]";
/* 166:160 */             s = StringBeanUtils.replace(s, oldcontent, 
/* 167:161 */               newcontent);
/* 168:    */           }
/* 169:    */           else
/* 170:    */           {
/* 171:163 */             String newcontent = "[url=" + getSite().getUrl() + 
/* 172:164 */               pa.getFilePath().substring(1) + "]" + 
/* 173:165 */               pa.getFileName() + "[/url]";
/* 174:166 */             s = StringBeanUtils.replace(s, oldcontent, 
/* 175:167 */               newcontent);
/* 176:    */           }
/* 177:    */         }
/* 178:    */       }
/* 179:    */     }
/* 180:172 */     return qc + BbcodeHandler.toHtml(s);
/* 181:    */   }
/* 182:    */   
/* 183:    */   private String getContentNoQuote(boolean showhidden)
/* 184:    */   {
/* 185:182 */     String s = getContent();
/* 186:183 */     if (StringUtils.isBlank(s)) {
/* 187:184 */       return "";
/* 188:    */     }
/* 189:186 */     if (getStatus().intValue() < 0)
/* 190:    */     {
/* 191:187 */       String content = "[quote='shield'][color=red]该贴已被删除或者被屏蔽[/color][/quote]";
/* 192:188 */       return BbcodeHandler.toHtml(content);
/* 193:    */     }
/* 194:190 */     if (getHidden().booleanValue())
/* 195:    */     {
/* 196:191 */       List<String> list = getHideContent(s);
/* 197:192 */       if (showhidden) {
/* 198:193 */         for (String str : list) {
/* 199:194 */           s = StringBeanUtils.replace(s, "[hide]" + str + 
/* 200:195 */             "[/hide]", 
/* 201:196 */             "[quote='content_hidden'][h=6]此为隐藏内容:[/h]" + 
/* 202:197 */             str + "[/quote]");
/* 203:    */         }
/* 204:    */       } else {
/* 205:200 */         for (String str : list) {
/* 206:201 */           s = 
/* 207:202 */             StringBeanUtils.replace(
/* 208:203 */             s, 
/* 209:204 */             "[hide]" + str + "[/hide]", 
/* 210:205 */             "[quote='content_hidden'][h=6]提示:[/h][color=red]引用了隐藏内容，需要回复才能浏览！[/color][/quote]");
/* 211:    */         }
/* 212:    */       }
/* 213:    */     }
/* 214:209 */     if (getAffix().booleanValue())
/* 215:    */     {
/* 216:210 */       List<PostsAttach> att = getAttachs();
/* 217:211 */       for (int i = 0; i < att.size(); i++)
/* 218:    */       {
/* 219:212 */         PostsAttach pa = (PostsAttach)att.get(i);
/* 220:213 */         if (pa != null)
/* 221:    */         {
/* 222:214 */           String oldcontent = "[attachment]" + i + 
/* 223:215 */             "[/attachment]";
/* 224:216 */           if (pa.getImg().booleanValue())
/* 225:    */           {
/* 226:217 */             String newcontent = "[img]" + getSite().getUrl() + 
/* 227:218 */               pa.getFilePath().substring(1) + "[/img]";
/* 228:219 */             s = StringBeanUtils.replace(s, oldcontent, 
/* 229:220 */               newcontent);
/* 230:    */           }
/* 231:    */           else
/* 232:    */           {
/* 233:222 */             String newcontent = "[url=" + getSite().getUrl() + 
/* 234:223 */               pa.getFilePath().substring(1) + "]" + 
/* 235:224 */               pa.getFileName() + "[/url]";
/* 236:225 */             s = StringBeanUtils.replace(s, oldcontent, 
/* 237:226 */               newcontent);
/* 238:    */           }
/* 239:    */         }
/* 240:    */       }
/* 241:    */     }
/* 242:231 */     s = "[quote][h=6]引用:[/h]" + s + "[/quote]";
/* 243:232 */     return BbcodeHandler.toHtml(s);
/* 244:    */   }
/* 245:    */   
/* 246:    */   public String getContentNotHtml(boolean showhidden)
/* 247:    */   {
/* 248:242 */     String s = getContent();
/* 249:243 */     if (StringUtils.isBlank(s)) {
/* 250:244 */       return "";
/* 251:    */     }
/* 252:246 */     if (getStatus().intValue() < 0)
/* 253:    */     {
/* 254:247 */       String content = "[color=red]该贴已被删除或者被屏蔽[/color]";
/* 255:248 */       return content;
/* 256:    */     }
/* 257:250 */     if (getHidden().booleanValue())
/* 258:    */     {
/* 259:251 */       List<String> list = getHideContent(s);
/* 260:252 */       if (showhidden) {
/* 261:253 */         for (String str : list) {
/* 262:254 */           s = StringBeanUtils.replace(s, "[hide]" + str + 
/* 263:255 */             "[/hide]", str);
/* 264:    */         }
/* 265:    */       } else {
/* 266:258 */         for (String str : list)
/* 267:    */         {
/* 268:259 */           String newcontent = "[color=red]这是隐藏内容.需要回复才能浏览[/color]";
/* 269:260 */           s = StringBeanUtils.replace(s, "[hide]" + str + 
/* 270:261 */             "[/hide]", newcontent);
/* 271:    */         }
/* 272:    */       }
/* 273:    */     }
/* 274:265 */     return s;
/* 275:    */   }
/* 276:    */   
/* 277:    */   private List<String> getHideContent(String content)
/* 278:    */   {
/* 279:276 */     String ems = "\\[hide\\]([\\s\\S]*)\\[/hide\\]";
/* 280:277 */     Matcher matcher = Pattern.compile(ems).matcher(content);
/* 281:278 */     List<String> list = new ArrayList();
/* 282:279 */     while (matcher.find())
/* 283:    */     {
/* 284:280 */       String url = matcher.group(1);
/* 285:281 */       list.add(url);
/* 286:    */     }
/* 287:283 */     return list;
/* 288:    */   }
/* 289:    */   
/* 290:    */   public Posts() {}
/* 291:    */   
/* 292:    */   public Posts(Integer id)
/* 293:    */   {
/* 294:295 */     super(id);
/* 295:    */   }
/* 296:    */   
/* 297:    */   public Posts(Integer id, Theme theme, Site site, Integer status, Boolean affix, Boolean img, Boolean hidden, Integer floor, Date createTime)
/* 298:    */   {
/* 299:307 */     super(id, theme, site, status, affix, img, hidden, floor, createTime);
/* 300:    */   }
/* 301:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.entity.Posts
 * JD-Core Version:    0.7.0.1
 */