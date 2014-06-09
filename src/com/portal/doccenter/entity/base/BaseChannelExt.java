/*   1:    */ package com.portal.doccenter.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.doccenter.entity.Channel;
/*   4:    */ import com.portal.doccenter.entity.ChannelExt;
/*   5:    */ import java.io.Serializable;
/*   6:    */ 
/*   7:    */ public abstract class BaseChannelExt
/*   8:    */   implements Serializable
/*   9:    */ {
/*  10: 17 */   public static String REF = "ChannelExt";
/*  11: 18 */   public static String PROP_DESCRIPTION = "description";
/*  12: 19 */   public static String PROP_CHANNEL = "channel";
/*  13: 20 */   public static String PROP_LINK = "link";
/*  14: 21 */   public static String PROP_TPL_CHANNEL = "tplChannel";
/*  15: 22 */   public static String PROP_ID = "id";
/*  16: 23 */   public static String PROP_COMMENT_CONTROL = "commentControl";
/*  17: 24 */   public static String PROP_UPDOWN_CONTROL = "updownControl";
/*  18: 25 */   public static String PROP_KEYWORDS = "keywords";
/*  19: 26 */   public static String PROP_TITLE = "title";
/*  20: 27 */   public static String PROP_BLANK = "blank";
/*  21:    */   
/*  22:    */   public BaseChannelExt()
/*  23:    */   {
/*  24: 32 */     initialize();
/*  25:    */   }
/*  26:    */   
/*  27:    */   public BaseChannelExt(Integer id)
/*  28:    */   {
/*  29: 39 */     setId(id);
/*  30: 40 */     initialize();
/*  31:    */   }
/*  32:    */   
/*  33:    */   public BaseChannelExt(Integer id, Boolean commentControl, Boolean blank)
/*  34:    */   {
/*  35: 51 */     setId(id);
/*  36: 52 */     setCommentControl(commentControl);
/*  37: 53 */     setBlank(blank);
/*  38: 54 */     initialize();
/*  39:    */   }
/*  40:    */   
/*  41: 61 */   private int hashCode = -2147483648;
/*  42:    */   private Integer id;
/*  43:    */   private String link;
/*  44:    */   private String tplChannel;
/*  45:    */   private Boolean commentControl;
/*  46:    */   private Boolean updownControl;
/*  47:    */   private Boolean blank;
/*  48:    */   private String title;
/*  49:    */   private String keywords;
/*  50:    */   private String description;
/*  51:    */   private Channel channel;
/*  52:    */   
/*  53:    */   protected void initialize() {}
/*  54:    */   
/*  55:    */   public Integer getId()
/*  56:    */   {
/*  57: 88 */     return this.id;
/*  58:    */   }
/*  59:    */   
/*  60:    */   public void setId(Integer id)
/*  61:    */   {
/*  62: 96 */     this.id = id;
/*  63: 97 */     this.hashCode = -2147483648;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public String getLink()
/*  67:    */   {
/*  68:107 */     return this.link;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public void setLink(String link)
/*  72:    */   {
/*  73:115 */     this.link = link;
/*  74:    */   }
/*  75:    */   
/*  76:    */   public String getTplChannel()
/*  77:    */   {
/*  78:124 */     return this.tplChannel;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public void setTplChannel(String tplChannel)
/*  82:    */   {
/*  83:132 */     this.tplChannel = tplChannel;
/*  84:    */   }
/*  85:    */   
/*  86:    */   public Boolean getCommentControl()
/*  87:    */   {
/*  88:141 */     return this.commentControl;
/*  89:    */   }
/*  90:    */   
/*  91:    */   public void setCommentControl(Boolean commentControl)
/*  92:    */   {
/*  93:149 */     this.commentControl = commentControl;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public Boolean getUpdownControl()
/*  97:    */   {
/*  98:158 */     return this.updownControl;
/*  99:    */   }
/* 100:    */   
/* 101:    */   public void setUpdownControl(Boolean updownControl)
/* 102:    */   {
/* 103:166 */     this.updownControl = updownControl;
/* 104:    */   }
/* 105:    */   
/* 106:    */   public Boolean getBlank()
/* 107:    */   {
/* 108:175 */     return this.blank;
/* 109:    */   }
/* 110:    */   
/* 111:    */   public void setBlank(Boolean blank)
/* 112:    */   {
/* 113:183 */     this.blank = blank;
/* 114:    */   }
/* 115:    */   
/* 116:    */   public String getTitle()
/* 117:    */   {
/* 118:192 */     return this.title;
/* 119:    */   }
/* 120:    */   
/* 121:    */   public void setTitle(String title)
/* 122:    */   {
/* 123:200 */     this.title = title;
/* 124:    */   }
/* 125:    */   
/* 126:    */   public String getKeywords()
/* 127:    */   {
/* 128:209 */     return this.keywords;
/* 129:    */   }
/* 130:    */   
/* 131:    */   public void setKeywords(String keywords)
/* 132:    */   {
/* 133:217 */     this.keywords = keywords;
/* 134:    */   }
/* 135:    */   
/* 136:    */   public String getDescription()
/* 137:    */   {
/* 138:226 */     return this.description;
/* 139:    */   }
/* 140:    */   
/* 141:    */   public void setDescription(String description)
/* 142:    */   {
/* 143:234 */     this.description = description;
/* 144:    */   }
/* 145:    */   
/* 146:    */   public Channel getChannel()
/* 147:    */   {
/* 148:243 */     return this.channel;
/* 149:    */   }
/* 150:    */   
/* 151:    */   public void setChannel(Channel channel)
/* 152:    */   {
/* 153:251 */     this.channel = channel;
/* 154:    */   }
/* 155:    */   
/* 156:    */   public boolean equals(Object obj)
/* 157:    */   {
/* 158:258 */     if (obj == null) {
/* 159:258 */       return false;
/* 160:    */     }
/* 161:259 */     if (!(obj instanceof ChannelExt)) {
/* 162:259 */       return false;
/* 163:    */     }
/* 164:261 */     ChannelExt channelExt = (ChannelExt)obj;
/* 165:262 */     if ((getId() == null) || (channelExt.getId() == null)) {
/* 166:262 */       return false;
/* 167:    */     }
/* 168:263 */     return getId().equals(channelExt.getId());
/* 169:    */   }
/* 170:    */   
/* 171:    */   public int hashCode()
/* 172:    */   {
/* 173:268 */     if (-2147483648 == this.hashCode)
/* 174:    */     {
/* 175:269 */       if (getId() == null) {
/* 176:269 */         return super.hashCode();
/* 177:    */       }
/* 178:271 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 179:272 */       this.hashCode = hashStr.hashCode();
/* 180:    */     }
/* 181:275 */     return this.hashCode;
/* 182:    */   }
/* 183:    */   
/* 184:    */   public String toString()
/* 185:    */   {
/* 186:280 */     return super.toString();
/* 187:    */   }
/* 188:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.entity.base.BaseChannelExt
 * JD-Core Version:    0.7.0.1
 */