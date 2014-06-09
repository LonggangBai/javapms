/*   1:    */ package com.portal.extrafunc.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.extrafunc.entity.MessageBoard;
/*   4:    */ import com.portal.extrafunc.entity.MessageBoardExt;
/*   5:    */ import java.io.Serializable;
/*   6:    */ 
/*   7:    */ public abstract class BaseMessageBoardExt
/*   8:    */   implements Serializable
/*   9:    */ {
/*  10: 17 */   public static String REF = "MessageBoardExt";
/*  11: 18 */   public static String PROP_BOARD = "board";
/*  12: 19 */   public static String PROP_ID = "id";
/*  13: 20 */   public static String PROP_REPLY = "reply";
/*  14: 21 */   public static String PROP_CONTENT = "content";
/*  15:    */   
/*  16:    */   public BaseMessageBoardExt()
/*  17:    */   {
/*  18: 26 */     initialize();
/*  19:    */   }
/*  20:    */   
/*  21:    */   public BaseMessageBoardExt(Integer id)
/*  22:    */   {
/*  23: 33 */     setId(id);
/*  24: 34 */     initialize();
/*  25:    */   }
/*  26:    */   
/*  27:    */   public BaseMessageBoardExt(Integer id, String content)
/*  28:    */   {
/*  29: 44 */     setId(id);
/*  30: 45 */     setContent(content);
/*  31: 46 */     initialize();
/*  32:    */   }
/*  33:    */   
/*  34: 53 */   private int hashCode = -2147483648;
/*  35:    */   private Integer id;
/*  36:    */   private String content;
/*  37:    */   private String reply;
/*  38:    */   private MessageBoard board;
/*  39:    */   
/*  40:    */   protected void initialize() {}
/*  41:    */   
/*  42:    */   public Integer getId()
/*  43:    */   {
/*  44: 74 */     return this.id;
/*  45:    */   }
/*  46:    */   
/*  47:    */   public void setId(Integer id)
/*  48:    */   {
/*  49: 82 */     this.id = id;
/*  50: 83 */     this.hashCode = -2147483648;
/*  51:    */   }
/*  52:    */   
/*  53:    */   public String getContent()
/*  54:    */   {
/*  55: 93 */     return this.content;
/*  56:    */   }
/*  57:    */   
/*  58:    */   public void setContent(String content)
/*  59:    */   {
/*  60:101 */     this.content = content;
/*  61:    */   }
/*  62:    */   
/*  63:    */   public String getReply()
/*  64:    */   {
/*  65:110 */     return this.reply;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public void setReply(String reply)
/*  69:    */   {
/*  70:118 */     this.reply = reply;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public MessageBoard getBoard()
/*  74:    */   {
/*  75:127 */     return this.board;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public void setBoard(MessageBoard board)
/*  79:    */   {
/*  80:135 */     this.board = board;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public boolean equals(Object obj)
/*  84:    */   {
/*  85:142 */     if (obj == null) {
/*  86:142 */       return false;
/*  87:    */     }
/*  88:143 */     if (!(obj instanceof MessageBoardExt)) {
/*  89:143 */       return false;
/*  90:    */     }
/*  91:145 */     MessageBoardExt messageBoardExt = (MessageBoardExt)obj;
/*  92:146 */     if ((getId() == null) || (messageBoardExt.getId() == null)) {
/*  93:146 */       return false;
/*  94:    */     }
/*  95:147 */     return getId().equals(messageBoardExt.getId());
/*  96:    */   }
/*  97:    */   
/*  98:    */   public int hashCode()
/*  99:    */   {
/* 100:152 */     if (-2147483648 == this.hashCode)
/* 101:    */     {
/* 102:153 */       if (getId() == null) {
/* 103:153 */         return super.hashCode();
/* 104:    */       }
/* 105:155 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 106:156 */       this.hashCode = hashStr.hashCode();
/* 107:    */     }
/* 108:159 */     return this.hashCode;
/* 109:    */   }
/* 110:    */   
/* 111:    */   public String toString()
/* 112:    */   {
/* 113:164 */     return super.toString();
/* 114:    */   }
/* 115:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.entity.base.BaseMessageBoardExt
 * JD-Core Version:    0.7.0.1
 */