/*  1:   */ package com.portal.usermgr.entity;
/*  2:   */ 
/*  3:   */ import com.portal.doccenter.entity.Channel;
/*  4:   */ import com.portal.sysmgr.entity.Site;
/*  5:   */ import com.portal.usermgr.entity.base.BaseDepart;
/*  6:   */ import java.sql.Timestamp;
/*  7:   */ import java.util.Date;
/*  8:   */ import java.util.HashSet;
/*  9:   */ import java.util.Set;
/* 10:   */ 
/* 11:   */ public class Depart
/* 12:   */   extends BaseDepart
/* 13:   */ {
/* 14:   */   private static final long serialVersionUID = 1L;
/* 15:   */   
/* 16:   */   public void init()
/* 17:   */   {
/* 18:16 */     if (getCreateTime() == null) {
/* 19:17 */       setCreateTime(new Timestamp(System.currentTimeMillis()));
/* 20:   */     }
/* 21:19 */     if (getPriority() == null) {
/* 22:20 */       setPriority(Integer.valueOf(10));
/* 23:   */     }
/* 24:22 */     if (getShow() == null) {
/* 25:23 */       setShow(Boolean.valueOf(false));
/* 26:   */     }
/* 27:   */   }
/* 28:   */   
/* 29:   */   public void addToChannels(Channel channel)
/* 30:   */   {
/* 31:28 */     if (channel == null) {
/* 32:29 */       return;
/* 33:   */     }
/* 34:31 */     Set<Channel> set = getChannels();
/* 35:32 */     if (set == null)
/* 36:   */     {
/* 37:33 */       set = new HashSet();
/* 38:34 */       setChannels(set);
/* 39:   */     }
/* 40:36 */     set.add(channel);
/* 41:   */   }
/* 42:   */   
/* 43:   */   public void addToChilds(Depart child)
/* 44:   */   {
/* 45:40 */     Set<Depart> set = getChild();
/* 46:41 */     if (set == null)
/* 47:   */     {
/* 48:42 */       set = new HashSet();
/* 49:43 */       setChild(set);
/* 50:   */     }
/* 51:45 */     set.add(child);
/* 52:   */   }
/* 53:   */   
/* 54:   */   public String getUrl()
/* 55:   */   {
/* 56:49 */     Site site = getSite();
/* 57:50 */     StringBuilder url = new StringBuilder(site.getUrl());
/* 58:51 */     url.append("/").append(getVisitPath());
/* 59:52 */     url.append("/").append("dp~")
/* 60:53 */       .append("index");
/* 61:54 */     url.append(".jsp");
/* 62:55 */     return url.toString();
/* 63:   */   }
/* 64:   */   
/* 65:   */   public int getDeep()
/* 66:   */   {
/* 67:64 */     int deep = 0;
/* 68:65 */     Depart parent = getParent();
/* 69:66 */     while (parent != null)
/* 70:   */     {
/* 71:67 */       deep++;
/* 72:68 */       parent = parent.getParent();
/* 73:   */     }
/* 74:70 */     return deep;
/* 75:   */   }
/* 76:   */   
/* 77:   */   public Integer[] getChannelIds()
/* 78:   */   {
/* 79:74 */     Set<Channel> channels = getChannels();
/* 80:75 */     return Channel.fetchIds(channels);
/* 81:   */   }
/* 82:   */   
/* 83:   */   public Depart() {}
/* 84:   */   
/* 85:   */   public Depart(Integer id)
/* 86:   */   {
/* 87:87 */     super(id);
/* 88:   */   }
/* 89:   */   
/* 90:   */   public Depart(Integer id, String name, Integer priority, Boolean show, Date createTime)
/* 91:   */   {
/* 92:97 */     super(id, name, priority, show, createTime);
/* 93:   */   }
/* 94:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.entity.Depart
 * JD-Core Version:    0.7.0.1
 */