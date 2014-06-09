/*   1:    */ package com.portal.doccenter.entity;
/*   2:    */ 
/*   3:    */ import com.portal.doccenter.entity.base.BaseArticleTxt;
/*   4:    */ import java.io.PrintStream;
/*   5:    */ import org.apache.commons.lang.StringUtils;
/*   6:    */ 
/*   7:    */ public class ArticleTxt
/*   8:    */   extends BaseArticleTxt
/*   9:    */ {
/*  10:    */   private static final long serialVersionUID = 1L;
/*  11:  9 */   public static String PAGE_STRING = "<hr class=\"ke-pagebreak\" style=\"page-break-after:always;\" />";
/*  12:    */   
/*  13:    */   public int getTxtCount()
/*  14:    */   {
/*  15: 12 */     String txt = getTxt();
/*  16: 13 */     if (StringUtils.isBlank(txt)) {
/*  17: 14 */       return 1;
/*  18:    */     }
/*  19: 16 */     return StringUtils.countMatches(txt, PAGE_STRING) + 1;
/*  20:    */   }
/*  21:    */   
/*  22:    */   public String getTxtByNo(int pageNo)
/*  23:    */   {
/*  24: 21 */     String txt = getTxt();
/*  25: 22 */     if ((StringUtils.isBlank(txt)) || (pageNo < 1)) {
/*  26: 23 */       return null;
/*  27:    */     }
/*  28: 25 */     int start = 0;int end = 0;
/*  29: 26 */     for (int i = 0; i < pageNo; i++)
/*  30:    */     {
/*  31: 28 */       if (i != 0)
/*  32:    */       {
/*  33: 29 */         start = txt.indexOf(PAGE_STRING, end);
/*  34: 30 */         if (start == -1) {
/*  35: 31 */           return null;
/*  36:    */         }
/*  37: 33 */         start += PAGE_STRING.length();
/*  38:    */       }
/*  39: 36 */       end = txt.indexOf(PAGE_STRING, start);
/*  40: 37 */       System.out.println("end=" + end);
/*  41: 38 */       if (end == -1) {
/*  42: 39 */         end = txt.length();
/*  43:    */       }
/*  44:    */     }
/*  45: 42 */     return txt.substring(start, end);
/*  46:    */   }
/*  47:    */   
/*  48:    */   public String getTitleByNo(int pageNo)
/*  49:    */   {
/*  50: 46 */     if (pageNo < 1) {
/*  51: 47 */       return null;
/*  52:    */     }
/*  53: 49 */     String title = getArticle().getTitle();
/*  54: 50 */     if (pageNo == 1) {
/*  55: 51 */       return title;
/*  56:    */     }
/*  57: 53 */     String txt = getTxt();
/*  58: 54 */     int start = 0;int end = 0;
/*  59: 55 */     for (int i = 1; i < pageNo; i++)
/*  60:    */     {
/*  61: 56 */       start = txt.indexOf(PAGE_STRING, end);
/*  62: 57 */       if (start == -1) {
/*  63: 58 */         return title;
/*  64:    */       }
/*  65: 60 */       start += PAGE_STRING.length();
/*  66:    */       
/*  67: 62 */       end = txt.indexOf(PAGE_STRING, start);
/*  68: 63 */       if (end == -1) {
/*  69: 64 */         return title;
/*  70:    */       }
/*  71:    */     }
/*  72: 67 */     String result = txt.substring(start, end);
/*  73: 68 */     if (!StringUtils.isBlank(result)) {
/*  74: 69 */       return result;
/*  75:    */     }
/*  76: 71 */     return title;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public void init()
/*  80:    */   {
/*  81: 76 */     blankToNull();
/*  82:    */   }
/*  83:    */   
/*  84:    */   public void blankToNull()
/*  85:    */   {
/*  86: 80 */     if (StringUtils.isBlank(getTxt())) {
/*  87: 81 */       setTxt(null);
/*  88:    */     }
/*  89:    */   }
/*  90:    */   
/*  91:    */   public boolean isAllBlank()
/*  92:    */   {
/*  93: 91 */     return StringUtils.isBlank(getTxt());
/*  94:    */   }
/*  95:    */   
/*  96:    */   public ArticleTxt() {}
/*  97:    */   
/*  98:    */   public ArticleTxt(Integer id)
/*  99:    */   {
/* 100:103 */     super(id);
/* 101:    */   }
/* 102:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.entity.ArticleTxt
 * JD-Core Version:    0.7.0.1
 */