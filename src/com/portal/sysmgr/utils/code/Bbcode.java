/*   1:    */ package com.portal.sysmgr.utils.code;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ 
/*   5:    */ public class Bbcode
/*   6:    */   implements Serializable
/*   7:    */ {
/*   8:    */   private static final long serialVersionUID = 1L;
/*   9:  7 */   private String tagName = "";
/*  10:    */   private String regex;
/*  11:    */   private String replace;
/*  12:    */   private boolean removQuotes;
/*  13:    */   private boolean alwaysProcess;
/*  14:    */   
/*  15:    */   public Bbcode() {}
/*  16:    */   
/*  17:    */   public Bbcode(String tagName, String regex, String replace)
/*  18:    */   {
/*  19: 27 */     this.tagName = tagName;
/*  20: 28 */     this.regex = regex;
/*  21: 29 */     this.replace = replace;
/*  22:    */   }
/*  23:    */   
/*  24:    */   public String getRegex()
/*  25:    */   {
/*  26: 38 */     return this.regex;
/*  27:    */   }
/*  28:    */   
/*  29:    */   public String getReplace()
/*  30:    */   {
/*  31: 47 */     return this.replace;
/*  32:    */   }
/*  33:    */   
/*  34:    */   public String getTagName()
/*  35:    */   {
/*  36: 56 */     return this.tagName;
/*  37:    */   }
/*  38:    */   
/*  39:    */   public boolean removeQuotes()
/*  40:    */   {
/*  41: 60 */     return this.removQuotes;
/*  42:    */   }
/*  43:    */   
/*  44:    */   public void setRegex(String regex)
/*  45:    */   {
/*  46: 70 */     this.regex = regex;
/*  47:    */   }
/*  48:    */   
/*  49:    */   public void setReplace(String replace)
/*  50:    */   {
/*  51: 80 */     this.replace = replace;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public void setTagName(String tagName)
/*  55:    */   {
/*  56: 90 */     this.tagName = tagName;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public void enableAlwaysProcess()
/*  60:    */   {
/*  61: 94 */     this.alwaysProcess = true;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public boolean alwaysProcess()
/*  65:    */   {
/*  66: 98 */     return this.alwaysProcess;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public void enableRemoveQuotes()
/*  70:    */   {
/*  71:102 */     this.removQuotes = true;
/*  72:    */   }
/*  73:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.sysmgr.utils.code.Bbcode
 * JD-Core Version:    0.7.0.1
 */