/*   1:    */ package com.portal.extrafunc.entity;
/*   2:    */ 
/*   3:    */ import com.portal.extrafunc.entity.base.BaseTheme;
/*   4:    */ import com.portal.sysmgr.entity.Site;
/*   5:    */ import java.sql.Timestamp;
/*   6:    */ 
/*   7:    */ public class Theme
/*   8:    */   extends BaseTheme
/*   9:    */ {
/*  10:    */   private static final long serialVersionUID = 1L;
/*  11:    */   public static final int TOP_THREE = 3;
/*  12:    */   public static final int TOP_TWO = 2;
/*  13:    */   public static final int TOP_ONE = 1;
/*  14:    */   public static final int NORMAL = 0;
/*  15:    */   public static final int SHIELD = -1;
/*  16:    */   public static final int DELETE = -2;
/*  17:    */   public static final String HTEME_DETAIL = "themeDetail";
/*  18:    */   
/*  19:    */   public void init()
/*  20:    */   {
/*  21: 27 */     if (getViewsCount() == null) {
/*  22: 28 */       setViewsCount(Integer.valueOf(0));
/*  23:    */     }
/*  24: 30 */     if (getReplyCount() == null) {
/*  25: 31 */       setReplyCount(Integer.valueOf(0));
/*  26:    */     }
/*  27: 33 */     if (getLock() == null) {
/*  28: 34 */       setLock(Boolean.valueOf(false));
/*  29:    */     }
/*  30: 36 */     if (getBold() == null) {
/*  31: 37 */       setBold(Boolean.valueOf(false));
/*  32:    */     }
/*  33: 39 */     if (getEssena() == null) {
/*  34: 40 */       setEssena(Boolean.valueOf(false));
/*  35:    */     }
/*  36: 42 */     if (getItalic() == null) {
/*  37: 43 */       setItalic(Boolean.valueOf(false));
/*  38:    */     }
/*  39: 45 */     if (getModerReply() == null) {
/*  40: 46 */       setModerReply(Boolean.valueOf(false));
/*  41:    */     }
/*  42: 48 */     if (getStatus() == null) {
/*  43: 49 */       setStatus(Integer.valueOf(0));
/*  44:    */     }
/*  45: 51 */     if (getCreateTime() == null) {
/*  46: 52 */       setCreateTime(new Timestamp(System.currentTimeMillis()));
/*  47:    */     }
/*  48: 54 */     if (getLastReplyTime() == null) {
/*  49: 55 */       setLastReplyTime(new Timestamp(System.currentTimeMillis()));
/*  50:    */     }
/*  51:    */   }
/*  52:    */   
/*  53:    */   public String getUrl()
/*  54:    */   {
/*  55: 60 */     StringBuilder sb = new StringBuilder(getSite().getUrl());
/*  56: 61 */     sb.append("themeDetail");
/*  57: 62 */     sb.append("-");
/*  58: 63 */     sb.append(getId());
/*  59: 64 */     sb.append(".jsp");
/*  60: 65 */     return sb.toString();
/*  61:    */   }
/*  62:    */   
/*  63:    */   public String getUrl(Integer pn)
/*  64:    */   {
/*  65: 69 */     StringBuilder sb = new StringBuilder(getSite().getUrl());
/*  66: 70 */     sb.append("themeDetail");
/*  67: 71 */     sb.append("-");
/*  68: 72 */     sb.append(getId());
/*  69: 73 */     sb.append("_");
/*  70: 74 */     sb.append(pn);
/*  71: 75 */     sb.append(".jsp");
/*  72: 76 */     return sb.toString();
/*  73:    */   }
/*  74:    */   
/*  75:    */   public boolean getTop()
/*  76:    */   {
/*  77: 80 */     if (getStatus().intValue() > 0) {
/*  78: 81 */       return true;
/*  79:    */     }
/*  80: 83 */     return false;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public boolean getCheckTopTime()
/*  84:    */   {
/*  85: 87 */     if (getTopTime() == null) {
/*  86: 88 */       return false;
/*  87:    */     }
/*  88: 90 */     java.sql.Date d = new java.sql.Date(System.currentTimeMillis());
/*  89: 91 */     java.sql.Date d1 = new java.sql.Date(getTopTime().getTime());
/*  90: 92 */     if (d.toString().equals(d1.toString())) {
/*  91: 93 */       return true;
/*  92:    */     }
/*  93: 95 */     return false;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public boolean getCheckLightTime()
/*  97:    */   {
/*  98: 99 */     if (getLightTime() == null) {
/*  99:100 */       return false;
/* 100:    */     }
/* 101:102 */     java.sql.Date d = new java.sql.Date(System.currentTimeMillis());
/* 102:103 */     java.sql.Date d1 = new java.sql.Date(getLightTime().getTime());
/* 103:104 */     if (d.toString().equals(d1.toString())) {
/* 104:105 */       return true;
/* 105:    */     }
/* 106:107 */     return false;
/* 107:    */   }
/* 108:    */   
/* 109:    */   public boolean getCheckLockTime()
/* 110:    */   {
/* 111:111 */     if (getLockTime() == null) {
/* 112:112 */       return false;
/* 113:    */     }
/* 114:114 */     java.sql.Date d = new java.sql.Date(System.currentTimeMillis());
/* 115:115 */     java.sql.Date d1 = new java.sql.Date(getLockTime().getTime());
/* 116:116 */     if (d.toString().equals(d1.toString())) {
/* 117:117 */       return true;
/* 118:    */     }
/* 119:119 */     return false;
/* 120:    */   }
/* 121:    */   
/* 122:    */   public boolean getNewTheme()
/* 123:    */   {
/* 124:123 */     java.sql.Date d = new java.sql.Date(System.currentTimeMillis());
/* 125:124 */     java.sql.Date d1 = new java.sql.Date(getCreateTime().getTime());
/* 126:125 */     if (d.toString().equals(d1.toString())) {
/* 127:126 */       return true;
/* 128:    */     }
/* 129:128 */     return false;
/* 130:    */   }
/* 131:    */   
/* 132:    */   public String getReplyTimeString()
/* 133:    */   {
/* 134:132 */     java.util.Date d = new java.util.Date();
/* 135:133 */     long s = d.getTime() - getLastReplyTime().getTime();
/* 136:134 */     s /= 1000L;
/* 137:135 */     if (s < 60L) {
/* 138:136 */       return s + "aa";
/* 139:    */     }
/* 140:137 */     if ((s > 60L) && (s < 3600L))
/* 141:    */     {
/* 142:138 */       s /= 60L;
/* 143:139 */       return s + "aaa";
/* 144:    */     }
/* 145:140 */     if ((s > 3600L) && (s < 86400L))
/* 146:    */     {
/* 147:141 */       s /= 3600L;
/* 148:142 */       return s + "aaa";
/* 149:    */     }
/* 150:144 */     return getLastReplyTime().toString().substring(0, 
/* 151:145 */       getLastReplyTime().toString().length() - 2);
/* 152:    */   }
/* 153:    */   
/* 154:    */   public String getReplyUser()
/* 155:    */   {
/* 156:150 */     ThemeTxt txt = getTxt();
/* 157:151 */     if (txt != null) {
/* 158:152 */       return txt.getContent();
/* 159:    */     }
/* 160:154 */     return ",";
/* 161:    */   }
/* 162:    */   
/* 163:    */   public Theme() {}
/* 164:    */   
/* 165:    */   public Theme(Integer id)
/* 166:    */   {
/* 167:166 */     super(id);
/* 168:    */   }
/* 169:    */   
/* 170:    */   public Theme(Integer id, Forum forum, Site site, String title, Integer viewsCount, Integer replyCount, Integer status, Boolean affix, Boolean img, Boolean moderReply, java.util.Date createTime)
/* 171:    */   {
/* 172:180 */     super(id, forum, site, title, viewsCount, replyCount, status, affix, img, moderReply, createTime);
/* 173:    */   }
/* 174:    */ }



/* Location:           F:\jspaa\aaaaaa\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.portal.extrafunc.entity.Theme

 * JD-Core Version:    0.7.0.1

 */