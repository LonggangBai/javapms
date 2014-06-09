/*   1:    */ package com.portal.sysmgr.utils.code;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.utils.StringBeanUtils;
/*   4:    */ import java.util.Collection;
/*   5:    */ import java.util.Iterator;
/*   6:    */ import java.util.LinkedHashMap;
/*   7:    */ import java.util.Map;
/*   8:    */ import java.util.regex.Matcher;
/*   9:    */ import java.util.regex.Pattern;
/*  10:    */ import javax.xml.parsers.SAXParser;
/*  11:    */ import javax.xml.parsers.SAXParserFactory;
/*  12:    */ import org.apache.commons.lang.StringUtils;
/*  13:    */ import org.springframework.beans.factory.InitializingBean;
/*  14:    */ import org.springframework.core.io.Resource;
/*  15:    */ import org.xml.sax.Attributes;
/*  16:    */ import org.xml.sax.SAXException;
/*  17:    */ import org.xml.sax.SAXParseException;
/*  18:    */ import org.xml.sax.helpers.DefaultHandler;
/*  19:    */ 
/*  20:    */ public class BbcodeHandler
/*  21:    */   extends DefaultHandler
/*  22:    */   implements InitializingBean
/*  23:    */ {
/*  24: 24 */   private Map<String, Bbcode> bbMap = new LinkedHashMap();
/*  25: 25 */   private Map<String, Bbcode> alwaysProcessMap = new LinkedHashMap();
/*  26: 26 */   private String tagName = "";
/*  27:    */   private StringBuffer sb;
/*  28:    */   private Bbcode bb;
/*  29:    */   private static BbcodeHandler handler;
/*  30:    */   private Resource configLocation;
/*  31:    */   
/*  32:    */   public String bbcode2html(String s)
/*  33:    */   {
/*  34: 34 */     if (StringUtils.isBlank(s)) {
/*  35: 35 */       return s;
/*  36:    */     }
/*  37: 37 */     s = StringBeanUtils.txt2htm(s);
/*  38: 38 */     return processText(s);
/*  39:    */   }
/*  40:    */   
/*  41:    */   public String processText(String s)
/*  42:    */   {
/*  43: 42 */     int codeIndex = s.indexOf("[code");
/*  44: 43 */     int codeEndIndex = codeIndex > -1 ? s.indexOf("[/code]") : -1;
/*  45: 45 */     if ((codeIndex == -1) || (codeEndIndex == -1) || (codeEndIndex < codeIndex)) {
/*  46: 46 */       return bbcode2htmlExceptCodeTag(s);
/*  47:    */     }
/*  48: 48 */     int nextStartPos = 0;
/*  49: 49 */     StringBuilder result = new StringBuilder(s.length());
/*  50: 51 */     while ((codeIndex > -1) && (codeEndIndex > -1) && 
/*  51: 52 */       (codeEndIndex > codeIndex))
/*  52:    */     {
/*  53: 53 */       codeEndIndex += "[/code]".length();
/*  54: 54 */       String nonCodeResult = bbcode2htmlExceptCodeTag(s.substring(
/*  55: 55 */         nextStartPos, codeIndex));
/*  56: 56 */       String codeResult = parseCode(s.substring(codeIndex, 
/*  57: 57 */         codeEndIndex));
/*  58: 58 */       result.append(nonCodeResult).append(codeResult);
/*  59: 59 */       nextStartPos = codeEndIndex;
/*  60: 60 */       codeIndex = s.indexOf("[code", codeEndIndex);
/*  61: 61 */       codeEndIndex = codeIndex > -1 ? s.indexOf("[/code]", codeIndex) : 
/*  62: 62 */         -1;
/*  63:    */     }
/*  64: 65 */     if (nextStartPos > -1)
/*  65:    */     {
/*  66: 66 */       String nonCodeResult = bbcode2htmlExceptCodeTag(s
/*  67: 67 */         .substring(nextStartPos));
/*  68: 68 */       result.append(nonCodeResult);
/*  69:    */     }
/*  70: 70 */     return result.toString();
/*  71:    */   }
/*  72:    */   
/*  73:    */   private String parseCode(String text)
/*  74:    */   {
/*  75: 75 */     for (Iterator<Bbcode> iter = getBbList().iterator(); iter.hasNext();)
/*  76:    */     {
/*  77: 76 */       Bbcode bb = (Bbcode)iter.next();
/*  78: 77 */       if (bb.getTagName().startsWith("code"))
/*  79:    */       {
/*  80: 78 */         Matcher matcher = Pattern.compile(bb.getRegex()).matcher(text);
/*  81: 79 */         StringBuffer sb = new StringBuffer(text);
/*  82: 80 */         while (matcher.find())
/*  83:    */         {
/*  84: 81 */           StringBuilder lang = null;
/*  85: 82 */           StringBuilder contents = null;
/*  86: 83 */           if ("code".equals(bb.getTagName()))
/*  87:    */           {
/*  88: 84 */             contents = new StringBuilder(matcher.group(1));
/*  89:    */           }
/*  90:    */           else
/*  91:    */           {
/*  92: 86 */             lang = new StringBuilder(matcher.group(1));
/*  93: 87 */             contents = new StringBuilder(matcher.group(2));
/*  94:    */           }
/*  95: 89 */           StringBeanUtils.replace(contents, "<br /> ", "\n");
/*  96:    */           
/*  97: 91 */           StringBeanUtils.replace(contents, "<", "&lt;");
/*  98: 92 */           StringBeanUtils.replace(contents, ">", "&gt;");
/*  99:    */           
/* 100:    */ 
/* 101:    */ 
/* 102:    */ 
/* 103: 97 */           StringBuffer replace = new StringBuffer(bb.getReplace());
/* 104: 98 */           int index = replace.indexOf("$1");
/* 105: 99 */           if ("code".equals(bb.getTagName()))
/* 106:    */           {
/* 107:100 */             if (index > -1) {
/* 108:101 */               replace.replace(index, index + 2, 
/* 109:102 */                 contents.toString());
/* 110:    */             }
/* 111:104 */             index = sb.indexOf("[code]");
/* 112:    */           }
/* 113:    */           else
/* 114:    */           {
/* 115:106 */             if (index > -1) {
/* 116:107 */               replace.replace(index, index + 2, lang.toString());
/* 117:    */             }
/* 118:109 */             index = replace.indexOf("$2");
/* 119:110 */             if (index > -1) {
/* 120:111 */               replace.replace(index, index + 2, 
/* 121:112 */                 contents.toString());
/* 122:    */             }
/* 123:114 */             index = sb.indexOf("[code=");
/* 124:    */           }
/* 125:116 */           int lastIndex = sb.indexOf("[/code]", index) + 
/* 126:117 */             "[/code]".length();
/* 127:119 */           if (lastIndex > index) {
/* 128:120 */             sb.replace(index, lastIndex, replace.toString());
/* 129:    */           }
/* 130:    */         }
/* 131:123 */         text = sb.toString();
/* 132:    */       }
/* 133:    */     }
/* 134:126 */     return text;
/* 135:    */   }
/* 136:    */   
/* 137:    */   public String bbcode2htmlExceptCodeTag(String text)
/* 138:    */   {
/* 139:130 */     if (text == null) {
/* 140:131 */       return text;
/* 141:    */     }
/* 142:134 */     if ((text.indexOf('[') > -1) && (text.indexOf(']') > -1)) {
/* 143:135 */       for (Iterator<Bbcode> iter = getBbList().iterator(); iter.hasNext();)
/* 144:    */       {
/* 145:136 */         Bbcode bb = (Bbcode)iter.next();
/* 146:137 */         if (!bb.getTagName().startsWith("code")) {
/* 147:138 */           text = text.replaceAll(bb.getRegex(), bb.getReplace());
/* 148:    */         }
/* 149:    */       }
/* 150:    */     }
/* 151:143 */     text = parseDefaultRequiredBBCode(text);
/* 152:    */     
/* 153:145 */     return text;
/* 154:    */   }
/* 155:    */   
/* 156:    */   public String parseDefaultRequiredBBCode(String text)
/* 157:    */   {
/* 158:149 */     Collection<Bbcode> list = getAlwaysProcessList();
/* 159:151 */     for (Iterator<Bbcode> iter = list.iterator(); iter.hasNext();)
/* 160:    */     {
/* 161:152 */       Bbcode bb = (Bbcode)iter.next();
/* 162:153 */       text = text.replaceAll(bb.getRegex(), bb.getReplace());
/* 163:    */     }
/* 164:156 */     return text;
/* 165:    */   }
/* 166:    */   
/* 167:    */   public void addBb(Bbcode bb)
/* 168:    */   {
/* 169:160 */     if (bb.alwaysProcess()) {
/* 170:161 */       this.alwaysProcessMap.put(bb.getTagName(), bb);
/* 171:    */     } else {
/* 172:163 */       this.bbMap.put(bb.getTagName(), bb);
/* 173:    */     }
/* 174:    */   }
/* 175:    */   
/* 176:    */   public Collection<Bbcode> getBbList()
/* 177:    */   {
/* 178:168 */     return this.bbMap.values();
/* 179:    */   }
/* 180:    */   
/* 181:    */   public Collection<Bbcode> getAlwaysProcessList()
/* 182:    */   {
/* 183:172 */     return this.alwaysProcessMap.values();
/* 184:    */   }
/* 185:    */   
/* 186:    */   public Bbcode findByName(String tagName)
/* 187:    */   {
/* 188:176 */     return (Bbcode)this.bbMap.get(tagName);
/* 189:    */   }
/* 190:    */   
/* 191:    */   public void startElement(String uri, String localName, String tag, Attributes attrs)
/* 192:    */   {
/* 193:181 */     if (tag.equals("match"))
/* 194:    */     {
/* 195:182 */       this.sb = new StringBuffer();
/* 196:183 */       this.bb = new Bbcode();
/* 197:    */       
/* 198:185 */       String tagName = attrs.getValue("name");
/* 199:186 */       if (tagName != null) {
/* 200:187 */         this.bb.setTagName(tagName);
/* 201:    */       }
/* 202:191 */       String removeQuotes = attrs.getValue("removeQuotes");
/* 203:192 */       if ((removeQuotes != null) && (removeQuotes.equals("true"))) {
/* 204:193 */         this.bb.enableRemoveQuotes();
/* 205:    */       }
/* 206:196 */       String alwaysProcess = attrs.getValue("alwaysProcess");
/* 207:197 */       if ((alwaysProcess != null) && ("true".equals(alwaysProcess))) {
/* 208:198 */         this.bb.enableAlwaysProcess();
/* 209:    */       }
/* 210:    */     }
/* 211:202 */     this.tagName = tag;
/* 212:    */   }
/* 213:    */   
/* 214:    */   public void endElement(String uri, String localName, String tag)
/* 215:    */   {
/* 216:206 */     if (tag.equals("match"))
/* 217:    */     {
/* 218:207 */       addBb(this.bb);
/* 219:    */     }
/* 220:208 */     else if (this.tagName.equals("replace"))
/* 221:    */     {
/* 222:209 */       this.bb.setReplace(this.sb.toString().trim());
/* 223:210 */       this.sb.delete(0, this.sb.length());
/* 224:    */     }
/* 225:211 */     else if (this.tagName.equals("regex"))
/* 226:    */     {
/* 227:212 */       this.bb.setRegex(this.sb.toString().trim());
/* 228:213 */       this.sb.delete(0, this.sb.length());
/* 229:    */     }
/* 230:216 */     this.tagName = "";
/* 231:    */   }
/* 232:    */   
/* 233:    */   public void characters(char[] ch, int start, int length)
/* 234:    */   {
/* 235:220 */     if ((this.tagName.equals("replace")) || (this.tagName.equals("regex"))) {
/* 236:221 */       this.sb.append(ch, start, length);
/* 237:    */     }
/* 238:    */   }
/* 239:    */   
/* 240:    */   public void error(SAXParseException exception)
/* 241:    */     throws SAXException
/* 242:    */   {
/* 243:225 */     throw exception;
/* 244:    */   }
/* 245:    */   
/* 246:    */   public void afterPropertiesSet()
/* 247:    */     throws Exception
/* 248:    */   {
/* 249:229 */     SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
/* 250:230 */     parser.parse(this.configLocation.getInputStream(), this);
/* 251:231 */     handler = this;
/* 252:    */   }
/* 253:    */   
/* 254:    */   public static String toHtml(String s)
/* 255:    */   {
/* 256:237 */     if (handler == null) {
/* 257:238 */       throw new RuntimeException("BbcodeHandler not prepared!");
/* 258:    */     }
/* 259:240 */     return handler.bbcode2html(s);
/* 260:    */   }
/* 261:    */   
/* 262:    */   public Resource getConfigLocation()
/* 263:    */   {
/* 264:246 */     return this.configLocation;
/* 265:    */   }
/* 266:    */   
/* 267:    */   public void setConfigLocation(Resource configLocation)
/* 268:    */   {
/* 269:250 */     this.configLocation = configLocation;
/* 270:    */   }
/* 271:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.sysmgr.utils.code.BbcodeHandler
 * JD-Core Version:    0.7.0.1
 */