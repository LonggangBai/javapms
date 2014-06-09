/*   1:    */ package com.portal.doccenter.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.doccenter.entity.Channel;
/*   4:    */ import com.portal.doccenter.entity.ChannelTxt;
/*   5:    */ import java.io.Serializable;
/*   6:    */ 
/*   7:    */ public abstract class BaseChannelTxt
/*   8:    */   implements Serializable
/*   9:    */ {
/*  10: 15 */   public static String REF = "ChannelTxt";
/*  11: 16 */   public static String PROP_CHANNEL = "channel";
/*  12: 17 */   public static String PROP_TXT = "txt";
/*  13: 18 */   public static String PROP_ID = "id";
/*  14:    */   
/*  15:    */   public BaseChannelTxt()
/*  16:    */   {
/*  17: 22 */     initialize();
/*  18:    */   }
/*  19:    */   
/*  20:    */   public BaseChannelTxt(Integer id)
/*  21:    */   {
/*  22: 29 */     setId(id);
/*  23: 30 */     initialize();
/*  24:    */   }
/*  25:    */   
/*  26: 36 */   private int hashCode = -2147483648;
/*  27:    */   private Integer id;
/*  28:    */   private String txtval;
/*  29:    */   private Channel channel;
/*  30:    */   
/*  31:    */   protected void initialize() {}
/*  32:    */   
/*  33:    */   public Integer getId()
/*  34:    */   {
/*  35: 53 */     return this.id;
/*  36:    */   }
/*  37:    */   
/*  38:    */   public void setId(Integer id)
/*  39:    */   {
/*  40: 63 */     this.id = id;
/*  41: 64 */     this.hashCode = -2147483648;
/*  42:    */   }
/*  43:    */   
/*  44:    */   public String getTxtval()
/*  45:    */   {
/*  46: 71 */     return this.txtval;
/*  47:    */   }
/*  48:    */   
/*  49:    */   public void setTxtval(String txtval)
/*  50:    */   {
/*  51: 81 */     this.txtval = txtval;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public Channel getChannel()
/*  55:    */   {
/*  56: 88 */     return this.channel;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public void setChannel(Channel channel)
/*  60:    */   {
/*  61: 98 */     this.channel = channel;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public boolean equals(Object obj)
/*  65:    */   {
/*  66:102 */     if (obj == null) {
/*  67:103 */       return false;
/*  68:    */     }
/*  69:104 */     if (!(obj instanceof ChannelTxt)) {
/*  70:105 */       return false;
/*  71:    */     }
/*  72:107 */     ChannelTxt channelTxt = (ChannelTxt)obj;
/*  73:108 */     if ((getId() == null) || (channelTxt.getId() == null)) {
/*  74:109 */       return false;
/*  75:    */     }
/*  76:111 */     return getId().equals(channelTxt.getId());
/*  77:    */   }
/*  78:    */   
/*  79:    */   public int hashCode()
/*  80:    */   {
/*  81:116 */     if (-2147483648 == this.hashCode)
/*  82:    */     {
/*  83:117 */       if (getId() == null) {
/*  84:118 */         return super.hashCode();
/*  85:    */       }
/*  86:120 */       String hashStr = getClass().getName() + ":" + 
/*  87:121 */         getId().hashCode();
/*  88:122 */       this.hashCode = hashStr.hashCode();
/*  89:    */     }
/*  90:125 */     return this.hashCode;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public String toString()
/*  94:    */   {
/*  95:129 */     return super.toString();
/*  96:    */   }
/*  97:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.entity.base.BaseChannelTxt
 * JD-Core Version:    0.7.0.1
 */