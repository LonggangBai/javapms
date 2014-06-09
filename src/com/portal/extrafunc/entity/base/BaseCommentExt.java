/*   1:    */ package com.portal.extrafunc.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.extrafunc.entity.Comment;
/*   4:    */ import com.portal.extrafunc.entity.CommentExt;
/*   5:    */ import java.io.Serializable;
/*   6:    */ 
/*   7:    */ public abstract class BaseCommentExt
/*   8:    */   implements Serializable
/*   9:    */ {
/*  10: 15 */   public static String REF = "CommentExt";
/*  11: 16 */   public static String PROP_IP = "ip";
/*  12: 17 */   public static String PROP_COMMENT = "comment";
/*  13: 18 */   public static String PROP_ID = "id";
/*  14: 19 */   public static String PROP_CONTENT = "content";
/*  15:    */   
/*  16:    */   public BaseCommentExt()
/*  17:    */   {
/*  18: 23 */     initialize();
/*  19:    */   }
/*  20:    */   
/*  21:    */   public BaseCommentExt(Integer id)
/*  22:    */   {
/*  23: 30 */     setId(id);
/*  24: 31 */     initialize();
/*  25:    */   }
/*  26:    */   
/*  27: 37 */   private int hashCode = -2147483648;
/*  28:    */   private Integer id;
/*  29:    */   private String ip;
/*  30:    */   private String content;
/*  31:    */   private Comment comment;
/*  32:    */   
/*  33:    */   protected void initialize() {}
/*  34:    */   
/*  35:    */   public Integer getId()
/*  36:    */   {
/*  37: 55 */     return this.id;
/*  38:    */   }
/*  39:    */   
/*  40:    */   public void setId(Integer id)
/*  41:    */   {
/*  42: 65 */     this.id = id;
/*  43: 66 */     this.hashCode = -2147483648;
/*  44:    */   }
/*  45:    */   
/*  46:    */   public String getIp()
/*  47:    */   {
/*  48: 73 */     return this.ip;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public void setIp(String ip)
/*  52:    */   {
/*  53: 83 */     this.ip = ip;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public String getContent()
/*  57:    */   {
/*  58: 90 */     return this.content;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public void setContent(String content)
/*  62:    */   {
/*  63:100 */     this.content = content;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public Comment getComment()
/*  67:    */   {
/*  68:107 */     return this.comment;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public void setComment(Comment comment)
/*  72:    */   {
/*  73:117 */     this.comment = comment;
/*  74:    */   }
/*  75:    */   
/*  76:    */   public boolean equals(Object obj)
/*  77:    */   {
/*  78:121 */     if (obj == null) {
/*  79:122 */       return false;
/*  80:    */     }
/*  81:123 */     if (!(obj instanceof CommentExt)) {
/*  82:124 */       return false;
/*  83:    */     }
/*  84:126 */     CommentExt commentExt = (CommentExt)obj;
/*  85:127 */     if ((getId() == null) || (commentExt.getId() == null)) {
/*  86:128 */       return false;
/*  87:    */     }
/*  88:130 */     return getId().equals(commentExt.getId());
/*  89:    */   }
/*  90:    */   
/*  91:    */   public int hashCode()
/*  92:    */   {
/*  93:135 */     if (-2147483648 == this.hashCode)
/*  94:    */     {
/*  95:136 */       if (getId() == null) {
/*  96:137 */         return super.hashCode();
/*  97:    */       }
/*  98:139 */       String hashStr = getClass().getName() + ":" + 
/*  99:140 */         getId().hashCode();
/* 100:141 */       this.hashCode = hashStr.hashCode();
/* 101:    */     }
/* 102:144 */     return this.hashCode;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public String toString()
/* 106:    */   {
/* 107:148 */     return super.toString();
/* 108:    */   }
/* 109:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.entity.base.BaseCommentExt
 * JD-Core Version:    0.7.0.1
 */