/*   1:    */ package com.portal.sysmgr.service.impl;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.file.FileWrap;
/*   4:    */ import com.javapms.basic.file.FileWrap.FileComparator;
/*   5:    */ import com.javapms.basic.plugin.springmvc.RealPathResolver;
/*   6:    */ import com.portal.sysmgr.entity.Site;
/*   7:    */ import com.portal.sysmgr.service.ResourceService;
/*   8:    */ import java.io.File;
/*   9:    */ import java.io.FileFilter;
/*  10:    */ import java.io.FilenameFilter;
/*  11:    */ import java.io.IOException;
/*  12:    */ import java.util.ArrayList;
/*  13:    */ import java.util.Arrays;
/*  14:    */ import java.util.List;
/*  15:    */ import org.apache.commons.io.FileUtils;
/*  16:    */ import org.apache.commons.io.FilenameUtils;
/*  17:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  18:    */ import org.springframework.stereotype.Service;
/*  19:    */ import org.springframework.web.multipart.MultipartFile;
/*  20:    */ 
/*  21:    */ @Service
/*  22:    */ public class ResourceServiceImpl
/*  23:    */   implements ResourceService
/*  24:    */ {
/*  25:    */   public List<FileWrap> listFile(String root, String path, boolean dirAndEditable)
/*  26:    */   {
/*  27: 29 */     File parent = new File(this.realPathResolver.get(root + path));
/*  28: 30 */     if (parent.exists())
/*  29:    */     {
/*  30:    */       File[] files;
/*  32: 32 */       if (dirAndEditable) {
/*  33: 33 */         files = parent.listFiles(this.filter);
/*  34:    */       } else {
/*  35: 35 */         files = parent.listFiles();
/*  36:    */       }
/*  37: 37 */       Arrays.sort(files, new FileComparator());
/*  38: 38 */       List<FileWrap> list = new ArrayList(files.length);
/*  39: 39 */       for (File f : files) {
/*  40: 40 */         list.add(new FileWrap(f, this.realPathResolver.get("") + root));
/*  41:    */       }
/*  42: 42 */       return list;
/*  43:    */     }
/*  44: 44 */     return new ArrayList(0);
/*  45:    */   }
/*  46:    */   
/*  47:    */   public boolean createDir(String path, String dirName)
/*  48:    */   {
/*  49: 49 */     File parent = new File(this.realPathResolver.get(path));
/*  50: 50 */     parent.mkdirs();
/*  51: 51 */     File dir = new File(parent, dirName);
/*  52: 52 */     return dir.mkdir();
/*  53:    */   }
/*  54:    */   
/*  55:    */   public void saveFile(String path, MultipartFile file)
/*  56:    */     throws IllegalStateException, IOException
/*  57:    */   {
/*  58: 57 */     File dest = new File(this.realPathResolver.get(path), 
/*  59: 58 */       file.getOriginalFilename());
/*  60: 59 */     file.transferTo(dest);
/*  61:    */   }
/*  62:    */   
/*  63:    */   public void createFile(String path, String filename, String data)
/*  64:    */     throws IOException
/*  65:    */   {
/*  66: 64 */     File parent = new File(this.realPathResolver.get(path));
/*  67: 65 */     parent.mkdirs();
/*  68: 66 */     File file = new File(parent, filename);
/*  69: 67 */     FileUtils.writeStringToFile(file, data, "UTF-8");
/*  70:    */   }
/*  71:    */   
/*  72:    */   public String readFile(String name)
/*  73:    */     throws IOException
/*  74:    */   {
/*  75: 71 */     File file = new File(this.realPathResolver.get(name));
/*  76: 72 */     return FileUtils.readFileToString(file, "UTF-8");
/*  77:    */   }
/*  78:    */   
/*  79:    */   public void updateFile(String name, String data)
/*  80:    */     throws IOException
/*  81:    */   {
/*  82: 76 */     File file = new File(this.realPathResolver.get(name));
/*  83: 77 */     FileUtils.writeStringToFile(file, data, "UTF-8");
/*  84:    */   }
/*  85:    */   
/*  86:    */   public int delete(String root, String[] names)
/*  87:    */   {
/*  88: 81 */     int count = 0;
/*  89: 83 */     for (String name : names)
/*  90:    */     {
/*  91: 84 */       File f = new File(this.realPathResolver.get(root + name));
/*  92: 85 */       if (FileUtils.deleteQuietly(f)) {
/*  93: 86 */         count++;
/*  94:    */       }
/*  95:    */     }
/*  96: 89 */     return count;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public void rename(String origName, String destName)
/* 100:    */   {
/* 101: 93 */     File orig = new File(this.realPathResolver.get(origName));
/* 102: 94 */     File dest = new File(this.realPathResolver.get(destName));
/* 103: 95 */     orig.renameTo(dest);
/* 104:    */   }
/* 105:    */   
/* 106:    */   public void copyTplAndRes(Site from, Site to)
/* 107:    */     throws IOException
/* 108:    */   {
/* 109: 99 */     String fromSol = from.getTplStyle();
/* 110:100 */     String toSol = to.getTplStyle();
/* 111:101 */     File tplFrom = new File(this.realPathResolver.get(from.getTplPath()), 
/* 112:102 */       fromSol);
/* 113:103 */     File tplTo = new File(this.realPathResolver.get(to.getTplPath()), toSol);
/* 114:104 */     FileUtils.copyDirectory(tplFrom, tplTo);
/* 115:105 */     File resFrom = new File(this.realPathResolver.get(from.getResPath()), 
/* 116:106 */       fromSol);
/* 117:107 */     if (resFrom.exists())
/* 118:    */     {
/* 119:108 */       File resTo = new File(this.realPathResolver.get(to.getResPath()), toSol);
/* 120:109 */       FileUtils.copyDirectory(resFrom, resTo);
/* 121:    */     }
/* 122:    */   }
/* 123:    */   
/* 124:    */   public void delTplAndRes(Site site)
/* 125:    */     throws IOException
/* 126:    */   {
/* 127:114 */     File tpl = new File(this.realPathResolver.get(site.getTplPath()));
/* 128:115 */     File res = new File(this.realPathResolver.get(site.getResPath()));
/* 129:116 */     FileUtils.deleteDirectory(tpl);
/* 130:117 */     FileUtils.deleteDirectory(res);
/* 131:    */   }
/* 132:    */   
/* 133:    */   public String[] getStyles(String path)
/* 134:    */   {
/* 135:121 */     File tpl = new File(this.realPathResolver.get(path));
/* 136:122 */     tpl.list(new FilenameFilter()
/* 137:    */     {
/* 138:    */       public boolean accept(File dir, String name)
/* 139:    */       {
/* 140:124 */         return dir.isDirectory();
/* 141:    */       }
/* 142:    */     });
/* 143:    */
    return new String[0];
}
/* 144:    */   
/* 145:130 */   private FileFilter filter = new FileFilter()
/* 146:    */   {
/* 147:    */     public boolean accept(File file)
/* 148:    */     {
/* 149:133 */       return (file.isDirectory()) || (FileWrap.editableExt(FilenameUtils.getExtension(file
/* 150:134 */         .getName())));
/* 151:    */     }
/* 152:    */   };
/* 153:    */   private RealPathResolver realPathResolver;
/* 154:    */   
/* 155:    */   @Autowired
/* 156:    */   public void setRealPathResolver(RealPathResolver realPathResolver)
/* 157:    */   {
/* 158:142 */     this.realPathResolver = realPathResolver;
/* 159:    */   }
/* 160:    */ }



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.portal.sysmgr.service.impl.ResourceServiceImpl

 * JD-Core Version:    0.7.0.1

 */