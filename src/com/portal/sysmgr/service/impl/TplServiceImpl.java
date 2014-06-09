/*   1:    */ package com.portal.sysmgr.service.impl;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.plugin.springmvc.RealPathResolver;
/*   4:    */ import com.portal.sysmgr.service.TplService;
/*   5:    */ import com.portal.sysmgr.utils.FileTpl;
/*   6:    */ import com.portal.sysmgr.utils.Tpl;
/*   7:    */ import java.io.File;
/*   8:    */ import java.io.FileFilter;
/*   9:    */ import java.io.IOException;
/*  10:    */ import java.util.ArrayList;
/*  11:    */ import java.util.List;
/*  12:    */ import org.apache.commons.io.FileUtils;
/*  13:    */ import org.slf4j.Logger;
/*  14:    */ import org.slf4j.LoggerFactory;
/*  15:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  16:    */ import org.springframework.stereotype.Service;
/*  17:    */ import org.springframework.web.multipart.MultipartFile;
/*  18:    */ 
/*  19:    */ @Service
/*  20:    */ public class TplServiceImpl
/*  21:    */   implements TplService
/*  22:    */ {
/*  23: 25 */   private static Logger log = LoggerFactory.getLogger(TplServiceImpl.class);
/*  24:    */   private String root;
/*  25:    */   private RealPathResolver realPathResolver;
/*  26:    */   
/*  27:    */   public int delete(String mroot, String[] names)
/*  28:    */   {
/*  29: 29 */     int count = 0;
/*  30: 30 */     for (String name : names)
/*  31:    */     {
/*  32: 31 */       File f = new File(this.realPathResolver.get(mroot + name));
/*  33: 32 */       if (f.isDirectory())
/*  34:    */       {
/*  35: 33 */         if (FileUtils.deleteQuietly(f)) {
/*  36: 34 */           count++;
/*  37:    */         }
/*  38:    */       }
/*  39: 37 */       else if (f.delete()) {
/*  40: 38 */         count++;
/*  41:    */       }
/*  42:    */     }
/*  43: 42 */     return count;
/*  44:    */   }
/*  45:    */   
/*  46:    */   public Tpl get(String mroot, String name)
/*  47:    */   {
/*  48: 46 */     File f = new File(this.realPathResolver.get(mroot + name));
/*  49: 47 */     if (f.exists()) {
/*  50: 48 */       return new FileTpl(f, this.root + mroot);
/*  51:    */     }
/*  52: 50 */     return null;
/*  53:    */   }
/*  54:    */   
/*  55:    */   public List<Tpl> getListByPrefix(String prefix)
/*  56:    */   {
/*  57: 55 */     File f = new File(this.realPathResolver.get(prefix));
/*  58: 56 */     String name = prefix.substring(prefix.lastIndexOf("/") + 1);
/*  59:    */     File parent;
/*  61: 58 */     if (prefix.endsWith("/"))
/*  62:    */     {
/*  63: 59 */       name = "";
/*  64: 60 */       parent = f;
/*  65:    */     }
/*  66:    */     else
/*  67:    */     {
/*  68: 62 */       parent = f.getParentFile();
/*  69:    */     }
/*  70: 64 */     if (parent.exists())
/*  71:    */     {
/*  72: 65 */       File[] files = parent.listFiles(new PrefixFilter(name));
/*  73: 66 */       if (files != null)
/*  74:    */       {
/*  75: 67 */         List<Tpl> list = new ArrayList();
/*  76: 68 */         for (File file : files) {
/*  77: 69 */           list.add(new FileTpl(file, this.root));
/*  78:    */         }
/*  79: 71 */         return list;
/*  80:    */       }
/*  81: 73 */       return new ArrayList(0);
/*  82:    */     }
/*  83: 76 */     return new ArrayList(0);
/*  84:    */   }
/*  85:    */   
/*  86:    */   public List<String> getNameListByPrefix(String prefix)
/*  87:    */   {
/*  88: 81 */     List<Tpl> list = getListByPrefix(prefix);
/*  89: 82 */     List<String> result = new ArrayList(list.size());
/*  90: 83 */     for (Tpl tpl : list) {
/*  91: 84 */       result.add(tpl.getName());
/*  92:    */     }
/*  93: 86 */     return result;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public List<Tpl> getChild(String mroot, String path)
/*  97:    */   {
/*  98: 90 */     File file = new File(this.realPathResolver.get(mroot + path));
/*  99: 91 */     File[] child = file.listFiles();
/* 100: 92 */     if (child != null)
/* 101:    */     {
/* 102: 93 */       List<Tpl> list = new ArrayList(child.length);
/* 103: 94 */       for (File f : child) {
/* 104: 95 */         list.add(new FileTpl(f, this.root + mroot));
/* 105:    */       }
/* 106: 97 */       return list;
/* 107:    */     }
/* 108: 99 */     return new ArrayList(0);
/* 109:    */   }
/* 110:    */   
/* 111:    */   public List<Tpl> getDirChild(String mroot, String path)
/* 112:    */   {
/* 113:104 */     File file = new File(this.realPathResolver.get(mroot + path));
/* 114:105 */     File[] child = file.listFiles();
/* 115:106 */     if (child != null)
/* 116:    */     {
/* 117:107 */       List<Tpl> list = new ArrayList(child.length);
/* 118:108 */       for (File f : child) {
/* 119:109 */         if (f.isDirectory()) {
/* 120:110 */           list.add(new FileTpl(f, this.root + mroot));
/* 121:    */         }
/* 122:    */       }
/* 123:113 */       return list;
/* 124:    */     }
/* 125:115 */     return new ArrayList(0);
/* 126:    */   }
/* 127:    */   
/* 128:    */   public List<Tpl> getFileChild(String mroot, String path)
/* 129:    */   {
/* 130:120 */     File file = new File(this.realPathResolver.get(mroot + path));
/* 131:121 */     File[] child = file.listFiles();
/* 132:122 */     if (child != null)
/* 133:    */     {
/* 134:123 */       List<Tpl> list = new ArrayList(child.length);
/* 135:124 */       for (File f : child) {
/* 136:125 */         if (!f.isDirectory()) {
/* 137:126 */           list.add(new FileTpl(f, this.root + mroot));
/* 138:    */         }
/* 139:    */       }
/* 140:129 */       return list;
/* 141:    */     }
/* 142:131 */     return new ArrayList(0);
/* 143:    */   }
/* 144:    */   
/* 145:    */   public void rename(String orig, String dist)
/* 146:    */   {
/* 147:136 */     String os = this.realPathResolver.get(orig);
/* 148:137 */     File of = new File(os);
/* 149:138 */     String ds = this.realPathResolver.get(dist);
/* 150:139 */     File df = new File(ds);
/* 151:    */     try
/* 152:    */     {
/* 153:141 */       if (of.isDirectory()) {
/* 154:142 */         FileUtils.moveDirectory(of, df);
/* 155:    */       } else {
/* 156:144 */         FileUtils.moveFile(of, df);
/* 157:    */       }
/* 158:    */     }
/* 159:    */     catch (IOException e)
/* 160:    */     {
/* 161:147 */       log.error("Move template error: " + orig + " to " + dist, e);
/* 162:    */     }
/* 163:    */   }
/* 164:    */   
/* 165:    */   public void save(String name, String source, boolean isDirectory)
/* 166:    */   {
/* 167:152 */     String real = this.realPathResolver.get(name);
/* 168:153 */     File f = new File(real);
/* 169:154 */     if (isDirectory) {
/* 170:155 */       f.mkdirs();
/* 171:    */     } else {
/* 172:    */       try
/* 173:    */       {
/* 174:158 */         FileUtils.writeStringToFile(f, source, "UTF-8");
/* 175:    */       }
/* 176:    */       catch (IOException e)
/* 177:    */       {
/* 178:160 */         log.error("Save template error: " + name, e);
/* 179:161 */         throw new RuntimeException(e);
/* 180:    */       }
/* 181:    */     }
/* 182:    */   }
/* 183:    */   
/* 184:    */   public void save(String path, MultipartFile file)
/* 185:    */   {
/* 186:167 */     File f = new File(this.realPathResolver.get(path), 
/* 187:168 */       file.getOriginalFilename());
/* 188:    */     try
/* 189:    */     {
/* 190:170 */       file.transferTo(f);
/* 191:    */     }
/* 192:    */     catch (IllegalStateException e)
/* 193:    */     {
/* 194:172 */       log.error("upload template error!", e);
/* 195:    */     }
/* 196:    */     catch (IOException e)
/* 197:    */     {
/* 198:174 */       log.error("upload template error!", e);
/* 199:    */     }
/* 200:    */   }
/* 201:    */   
/* 202:    */   public void update(String name, String source)
/* 203:    */   {
/* 204:179 */     String real = this.realPathResolver.get(name);
/* 205:180 */     File f = new File(real);
/* 206:    */     try
/* 207:    */     {
/* 208:182 */       FileUtils.writeStringToFile(f, source, "UTF-8");
/* 209:    */     }
/* 210:    */     catch (IOException e)
/* 211:    */     {
/* 212:184 */       log.error("Save template error: " + name, e);
/* 213:185 */       throw new RuntimeException(e);
/* 214:    */     }
/* 215:    */   }
/* 216:    */   
/* 217:    */   @Autowired
/* 218:    */   public void setRealPathResolver(RealPathResolver realPathResolver)
/* 219:    */   {
/* 220:195 */     this.realPathResolver = realPathResolver;
/* 221:196 */     this.root = realPathResolver.get("");
/* 222:    */   }
/* 223:    */   
/* 224:    */   private static class PrefixFilter
/* 225:    */     implements FileFilter
/* 226:    */   {
/* 227:    */     private String prefix;
/* 228:    */     
/* 229:    */     public PrefixFilter(String prefix)
/* 230:    */     {
/* 231:203 */       this.prefix = prefix;
/* 232:    */     }
/* 233:    */     
/* 234:    */     public boolean accept(File file)
/* 235:    */     {
/* 236:207 */       String name = file.getName();
/* 237:208 */       return (file.isFile()) && (name.startsWith(this.prefix));
/* 238:    */     }
/* 239:    */   }
/* 240:    */ }



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.portal.sysmgr.service.impl.TplServiceImpl

 * JD-Core Version:    0.7.0.1

 */