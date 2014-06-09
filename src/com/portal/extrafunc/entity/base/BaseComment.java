/*   1:    */ package com.portal.extrafunc.entity.base;
/*   2:    */ 
/*   3:    */ import com.portal.doccenter.entity.Article;
/*   4:    */ import com.portal.extrafunc.entity.Comment;
/*   5:    */ import com.portal.extrafunc.entity.CommentExt;
/*   6:    */ import com.portal.sysmgr.entity.Site;
/*   7:    */ import com.portal.usermgr.entity.User;
/*   8:    */ import java.io.Serializable;
/*   9:    */ import java.util.Date;
/*  10:    */ import java.util.Set;
/*  11:    */ import java.util.TreeSet;
/*  12:    */ 
/*  13:    */ public abstract class BaseComment
/*  14:    */   implements Serializable
/*  15:    */ {
/*  16: 17 */   public static String REF = "Comment";
/*  17: 18 */   public static String PROP_USER = "user";
/*  18: 19 */   public static String PROP_PARENT = "parent";
/*  19: 20 */   public static String PROP_DOC = "doc";
/*  20: 21 */   public static String PROP_SITE = "site";
/*  21: 22 */   public static String PROP_CHECKED = "checked";
/*  22: 23 */   public static String PROP_LAST_TIME = "lastTime";
/*  23: 24 */   public static String PROP_UPS = "ups";
/*  24: 25 */   public static String PROP_COMMENT_EXT = "commentExt";
/*  25: 26 */   public static String PROP_CREATE_TIME = "createTime";
/*  26: 27 */   public static String PROP_ID = "id";
/*  27:    */   
/*  28:    */   public BaseComment()
/*  29:    */   {
/*  30: 32 */     initialize();
/*  31:    */   }
/*  32:    */   
/*  33:    */   public BaseComment(Integer id)
/*  34:    */   {
/*  35: 39 */     setId(id);
/*  36: 40 */     initialize();
/*  37:    */   }
/*  38:    */   
/*  39:    */   public BaseComment(Integer id, Article doc, Site site, Integer ups, Date createTime, Date lastTime, Boolean checked)
/*  40:    */   {
/*  41: 55 */     setId(id);
/*  42: 56 */     setDoc(doc);
/*  43: 57 */     setSite(site);
/*  44: 58 */     setUps(ups);
/*  45: 59 */     setCreateTime(createTime);
/*  46: 60 */     setLastTime(lastTime);
/*  47: 61 */     setChecked(checked);
/*  48: 62 */     initialize();
/*  49:    */   }
/*  50:    */   
/*  51: 69 */   private int hashCode = -2147483648;
/*  52:    */   private Integer id;
/*  53:    */   private Integer ups;
/*  54:    */   private Date createTime;
/*  55:    */   private Date lastTime;
/*  56:    */   private Boolean checked;
/*  57:    */   private CommentExt commentExt;
/*  58:    */   private Comment parent;
/*  59:    */   private Article doc;
/*  60:    */   private User user;
/*  61:    */   private Site site;
/*  62:    */   private Set<Comment> child;
/*  63:    */   
/*  64:    */   protected void initialize() {}
/*  65:    */   
/*  66:    */   public Integer getId()
/*  67:    */   {
/*  68:101 */     return this.id;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public void setId(Integer id)
/*  72:    */   {
/*  73:109 */     this.id = id;
/*  74:110 */     this.hashCode = -2147483648;
/*  75:    */   }
/*  76:    */   
/*  77:    */   public Integer getUps()
/*  78:    */   {
/*  79:120 */     return this.ups;
/*  80:    */   }
/*  81:    */   
/*  82:    */   public void setUps(Integer ups)
/*  83:    */   {
/*  84:128 */     this.ups = ups;
/*  85:    */   }
/*  86:    */   
/*  87:    */   public Date getCreateTime()
/*  88:    */   {
/*  89:137 */     return this.createTime;
/*  90:    */   }
/*  91:    */   
/*  92:    */   public void setCreateTime(Date createTime)
/*  93:    */   {
/*  94:145 */     this.createTime = createTime;
/*  95:    */   }
/*  96:    */   
/*  97:    */   public Date getLastTime()
/*  98:    */   {
/*  99:154 */     return this.lastTime;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public void setLastTime(Date lastTime)
/* 103:    */   {
/* 104:162 */     this.lastTime = lastTime;
/* 105:    */   }
/* 106:    */   
/* 107:    */   public Boolean getChecked()
/* 108:    */   {
/* 109:171 */     return this.checked;
/* 110:    */   }
/* 111:    */   
/* 112:    */   public void setChecked(Boolean checked)
/* 113:    */   {
/* 114:179 */     this.checked = checked;
/* 115:    */   }
/* 116:    */   
/* 117:    */   public CommentExt getCommentExt()
/* 118:    */   {
/* 119:188 */     return this.commentExt;
/* 120:    */   }
/* 121:    */   
/* 122:    */   public void setCommentExt(CommentExt commentExt)
/* 123:    */   {
/* 124:196 */     this.commentExt = commentExt;
/* 125:    */   }
/* 126:    */   
/* 127:    */   public Comment getParent()
/* 128:    */   {
/* 129:205 */     return this.parent;
/* 130:    */   }
/* 131:    */   
/* 132:    */   public void setParent(Comment parent)
/* 133:    */   {
/* 134:213 */     this.parent = parent;
/* 135:    */   }
/* 136:    */   
/* 137:    */   public Article getDoc()
/* 138:    */   {
/* 139:222 */     return this.doc;
/* 140:    */   }
/* 141:    */   
/* 142:    */   public void setDoc(Article doc)
/* 143:    */   {
/* 144:230 */     this.doc = doc;
/* 145:    */   }
/* 146:    */   
/* 147:    */   public User getUser()
/* 148:    */   {
/* 149:239 */     return this.user;
/* 150:    */   }
/* 151:    */   
/* 152:    */   public void setUser(User user)
/* 153:    */   {
/* 154:247 */     this.user = user;
/* 155:    */   }
/* 156:    */   
/* 157:    */   public Site getSite()
/* 158:    */   {
/* 159:256 */     return this.site;
/* 160:    */   }
/* 161:    */   
/* 162:    */   public void setSite(Site site)
/* 163:    */   {
/* 164:264 */     this.site = site;
/* 165:    */   }
/* 166:    */   
/* 167:    */   public Set<Comment> getChild()
/* 168:    */   {
/* 169:273 */     return this.child;
/* 170:    */   }
/* 171:    */   
/* 172:    */   public void setChild(Set<Comment> child)
/* 173:    */   {
/* 174:281 */     this.child = child;
/* 175:    */   }
/* 176:    */   
/* 177:    */   public void addTochild(Comment comment)
/* 178:    */   {
/* 179:285 */     if (getChild() == null) {
/* 180:285 */       setChild(new TreeSet());
/* 181:    */     }
/* 182:286 */     getChild().add(comment);
/* 183:    */   }
/* 184:    */   
/* 185:    */   public boolean equals(Object obj)
/* 186:    */   {
/* 187:293 */     if (obj == null) {
/* 188:293 */       return false;
/* 189:    */     }
/* 190:294 */     if (!(obj instanceof Comment)) {
/* 191:294 */       return false;
/* 192:    */     }
/* 193:296 */     Comment comment = (Comment)obj;
/* 194:297 */     if ((getId() == null) || (comment.getId() == null)) {
/* 195:297 */       return false;
/* 196:    */     }
/* 197:298 */     return getId().equals(comment.getId());
/* 198:    */   }
/* 199:    */   
/* 200:    */   public int hashCode()
/* 201:    */   {
/* 202:303 */     if (-2147483648 == this.hashCode)
/* 203:    */     {
/* 204:304 */       if (getId() == null) {
/* 205:304 */         return super.hashCode();
/* 206:    */       }
/* 207:306 */       String hashStr = getClass().getName() + ":" + getId().hashCode();
/* 208:307 */       this.hashCode = hashStr.hashCode();
/* 209:    */     }
/* 210:310 */     return this.hashCode;
/* 211:    */   }
/* 212:    */   
/* 213:    */   public String toString()
/* 214:    */   {
/* 215:315 */     return super.toString();
/* 216:    */   }
/* 217:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.entity.base.BaseComment
 * JD-Core Version:    0.7.0.1
 */