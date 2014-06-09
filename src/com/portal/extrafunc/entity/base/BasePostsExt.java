/*   1:    */ package com.portal.extrafunc.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.extrafunc.entity.Posts;
/*   4:    */ import com.portal.extrafunc.entity.PostsExt;
/*   5:    */ import com.portal.usermgr.entity.User;
/*   6:    */ import java.io.Serializable;
/*   7:    */ import java.util.Date;
/*   8:    */ 
/*   9:    */ public abstract class BasePostsExt
/*  10:    */   implements Serializable
/*  11:    */ {
/*  12: 17 */   public static String REF = "PostsExt";
/*  13: 18 */   public static String PROP_EDIT_TIME = "editTime";
/*  14: 19 */   public static String PROP_POSTS = "posts";
/*  15: 20 */   public static String PROP_EDIT_IP = "editIp";
/*  16: 21 */   public static String PROP_EDITER = "editer";
/*  17: 22 */   public static String PROP_EDIT_COUNT = "editCount";
/*  18: 23 */   public static String PROP_ID = "id";
/*  19: 24 */   public static String PROP_CREATE_IP = "createIp";
/*  20:    */   
/*  21:    */   public BasePostsExt()
/*  22:    */   {
/*  23: 29 */     initialize();
/*  24:    */   }
/*  25:    */   
/*  26:    */   public BasePostsExt(Integer id)
/*  27:    */   {
/*  28: 36 */     setId(id);
/*  29: 37 */     initialize();
/*  30:    */   }
/*  31:    */   
/*  32:    */   public BasePostsExt(Integer id, String createIp, Integer editCount)
/*  33:    */   {
/*  34: 48 */     setId(id);
/*  35: 49 */     setCreateIp(createIp);
/*  36: 50 */     setEditCount(editCount);
/*  37: 51 */     initialize();
/*  38:    */   }
/*  39:    */   
/*  40: 58 */   private int hashCode = -2147483648;
/*  41:    */   private Integer id;
/*  42:    */   private String createIp;
/*  43:    */   private Date editTime;
/*  44:    */   private String editIp;
/*  45:    */   private Integer editCount;
/*  46:    */   private Posts posts;
/*  47:    */   private User editer;
/*  48:    */   
/*  49:    */   protected void initialize() {}
/*  50:    */   
/*  51:    */   public Integer getId()
/*  52:    */   {
/*  53: 84 */     return this.id;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public void setId(Integer id)
/*  57:    */   {
/*  58: 92 */     this.id = id;
/*  59: 93 */     this.hashCode = -2147483648;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public String getCreateIp()
/*  63:    */   {
/*  64:103 */     return this.createIp;
/*  65:    */   }
/*  66:    */   
/*  67:    */   public void setCreateIp(String createIp)
/*  68:    */   {
/*  69:111 */     this.createIp = createIp;
/*  70:    */   }
/*  71:    */   
/*  72:    */   public Date getEditTime()
/*  73:    */   {
/*  74:120 */     return this.editTime;
/*  75:    */   }
/*  76:    */   
/*  77:    */   public void setEditTime(Date editTime)
/*  78:    */   {
/*  79:128 */     this.editTime = editTime;
/*  80:    */   }
/*  81:    */   
/*  82:    */   public String getEditIp()
/*  83:    */   {
/*  84:137 */     return this.editIp;
/*  85:    */   }
/*  86:    */   
/*  87:    */   public void setEditIp(String editIp)
/*  88:    */   {
/*  89:145 */     this.editIp = editIp;
/*  90:    */   }
/*  91:    */   
/*  92:    */   public Integer getEditCount()
/*  93:    */   {
/*  94:154 */     return this.editCount;
/*  95:    */   }
/*  96:    */   
/*  97:    */   public void setEditCount(Integer editCount)
/*  98:    */   {
/*  99:162 */     this.editCount = editCount;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public Posts getPosts()
/* 103:    */   {
/* 104:171 */     return this.posts;
/* 105:    */   }
/* 106:    */   
/* 107:    */   public void setPosts(Posts posts)
/* 108:    */   {
/* 109:179 */     this.posts = posts;
/* 110:    */   }
/* 111:    */   
/* 112:    */   public User getEditer()
/* 113:    */   {
/* 114:188 */     return this.editer;
/* 115:    */   }
/* 116:    */   
/* 117:    */   public void setEditer(User editer)
/* 118:    */   {
/* 119:196 */     this.editer = editer;
/* 120:    */   }
/* 121:    */   
/* 122:    */   public boolean equals(Object obj)
/* 123:    */   {
/* 124:203 */     if (obj == null) {
/* 125:203 */       return false;
/* 126:    */     }
/* 127:204 */     if (!(obj instanceof PostsExt)) {
/* 128:204 */       return false;
/* 129:    */     }
/* 130:206 */     PostsExt postsExt = (PostsExt)obj;
/* 131:207 */     if ((getId() == null) || (postsExt.getId() == null)) {
/* 132:207 */       return false;
/* 133:    */     }
/* 134:208 */     return getId().equals(postsExt.getId());
/* 135:    */   }
/* 136:    */   
/* 137:    */   public int hashCode()
/* 138:    */   {
/* 139:213 */     if (-2147483648 == this.hashCode)
/* 140:    */     {
/* 141:214 */       if (getId() == null) {
/* 142:214 */         return super.hashCode();
/* 143:    */       }
/* 144:216 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 145:217 */       this.hashCode = hashStr.hashCode();
/* 146:    */     }
/* 147:220 */     return this.hashCode;
/* 148:    */   }
/* 149:    */   
/* 150:    */   public String toString()
/* 151:    */   {
/* 152:225 */     return super.toString();
/* 153:    */   }
/* 154:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.entity.base.BasePostsExt
 * JD-Core Version:    0.7.0.1
 */