/*   1:    */ package com.portal.extrafunc.entity;
/*   2:    */ 
/*   3:    */ import com.portal.extrafunc.entity.base.BaseForum;
/*   4:    */ import com.portal.sysmgr.entity.Site;
/*   5:    */ 
/*   6:    */ public class Forum
/*   7:    */   extends BaseForum
/*   8:    */ {
/*   9:    */   private static final long serialVersionUID = 1L;
/*  10:    */   public static final String HTEME_LIST = "themeList";
/*  11:    */   
/*  12:    */   public void init()
/*  13:    */   {
/*  14: 12 */     if (getPriority() == null) {
/*  15: 13 */       setPriority(Integer.valueOf(10));
/*  16:    */     }
/*  17: 15 */     if (getThemeTotal() == null) {
/*  18: 16 */       setThemeTotal(Integer.valueOf(0));
/*  19:    */     }
/*  20: 18 */     if (getThemeToday() == null) {
/*  21: 19 */       setThemeToday(Integer.valueOf(0));
/*  22:    */     }
/*  23: 21 */     if (getReplyTotal() == null) {
/*  24: 22 */       setReplyTotal(Integer.valueOf(0));
/*  25:    */     }
/*  26: 24 */     if (getReplyToday() == null) {
/*  27: 25 */       setReplyToday(Integer.valueOf(0));
/*  28:    */     }
/*  29:    */   }
/*  30:    */   
/*  31:    */   public String getUrl()
/*  32:    */   {
/*  33: 30 */     StringBuilder sb = new StringBuilder(getSite().getUrl());
/*  34: 31 */     sb.append("themeList");
/*  35: 32 */     sb.append("-");
/*  36: 33 */     sb.append(getId());
/*  37: 34 */     sb.append(".jsp");
/*  38: 35 */     return sb.toString();
/*  39:    */   }
/*  40:    */   
/*  41:    */   public String getUrl(Integer pn)
/*  42:    */   {
/*  43: 39 */     StringBuilder sb = new StringBuilder(getSite().getUrl());
/*  44: 40 */     sb.append("themeList");
/*  45: 41 */     sb.append("-");
/*  46: 42 */     sb.append(getId());
/*  47: 43 */     sb.append("_");
/*  48: 44 */     sb.append(pn);
/*  49: 45 */     sb.append(".jsp");
/*  50: 46 */     return sb.toString();
/*  51:    */   }
/*  52:    */   
/*  53:    */   public String getKeywords()
/*  54:    */   {
/*  55: 50 */     ForumExt ext = getExt();
/*  56: 51 */     if (ext != null) {
/*  57: 52 */       return ext.getKeywords();
/*  58:    */     }
/*  59: 54 */     return null;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public String getDescription()
/*  63:    */   {
/*  64: 58 */     ForumExt ext = getExt();
/*  65: 59 */     if (ext != null) {
/*  66: 60 */       return ext.getDescription();
/*  67:    */     }
/*  68: 62 */     return null;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public String getRule()
/*  72:    */   {
/*  73: 66 */     ForumExt ext = getExt();
/*  74: 67 */     if (ext != null) {
/*  75: 68 */       return ext.getRule();
/*  76:    */     }
/*  77: 70 */     return null;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public String getTplContent()
/*  81:    */   {
/*  82: 74 */     ForumExt ext = getExt();
/*  83: 75 */     if (ext != null) {
/*  84: 76 */       return ext.getTplContent();
/*  85:    */     }
/*  86: 78 */     return null;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public Forum() {}
/*  90:    */   
/*  91:    */   public Forum(Integer id)
/*  92:    */   {
/*  93: 90 */     super(id);
/*  94:    */   }
/*  95:    */   
/*  96:    */   public Forum(Integer id, Site site, Category category, String name, Integer priority, Integer themeTotal, Integer replyTotal, Integer themeToday, Integer replyToday)
/*  97:    */   {
/*  98:103 */     super(id, site, category, name, priority, themeTotal, replyTotal, themeToday, replyToday);
/*  99:    */   }
/* 100:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.entity.Forum
 * JD-Core Version:    0.7.0.1
 */