/*  1:   */ package com.portal.extrafunc.action.cache;
/*  2:   */ 
/*  3:   */ import java.util.Date;
/*  4:   */ import java.util.List;
/*  5:   */ import net.sf.ehcache.Ehcache;
/*  6:   */ import net.sf.ehcache.Element;
/*  7:   */ import org.springframework.beans.factory.annotation.Autowired;
/*  8:   */ import org.springframework.beans.factory.annotation.Qualifier;
/*  9:   */ 
/* 10:   */ public class PostsCheckCacheImpl
/* 11:   */   implements PostsCheckCache
/* 12:   */ {
/* 13:   */   private long interval;
/* 14:   */   private Ehcache cache;
/* 15:   */   
/* 16:   */   public void updateCheck(String username)
/* 17:   */   {
/* 18:22 */     Date d = new Date();
/* 19:23 */     this.cache.put(new Element(username, d));
/* 20:   */   }
/* 21:   */   
/* 22:   */   public Date postsTime(String username)
/* 23:   */   {
/* 24:27 */     Element e = this.cache.get(username);
/* 25:28 */     if (e != null)
/* 26:   */     {
/* 27:29 */       Date d = (Date)e.getValue();
/* 28:30 */       return d;
/* 29:   */     }
/* 30:32 */     return null;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public void refreshCheck()
/* 34:   */   {
/* 35:38 */     List<String> keys = this.cache.getKeys();
/* 36:39 */     if (keys.size() <= 0) {
/* 37:40 */       return;
/* 38:   */     }
/* 39:42 */     for (String key : keys)
/* 40:   */     {
/* 41:43 */       Element e = this.cache.get(key);
/* 42:44 */       if (e != null)
/* 43:   */       {
/* 44:45 */         Date d = (Date)e.getValue();
/* 45:46 */         long second = System.currentTimeMillis() - d.getTime();
/* 46:47 */         second /= 1000L;
/* 47:48 */         if (second > this.interval) {
/* 48:49 */           this.cache.remove(key);
/* 49:   */         }
/* 50:   */       }
/* 51:   */     }
/* 52:   */   }
/* 53:   */   
/* 54:   */   public long getInterval()
/* 55:   */   {
/* 56:59 */     return this.interval;
/* 57:   */   }
/* 58:   */   
/* 59:   */   public void setInterval(long interval)
/* 60:   */   {
/* 61:63 */     this.interval = interval;
/* 62:   */   }
/* 63:   */   
/* 64:   */   @Autowired
/* 65:   */   public void setCache(@Qualifier("postsCheck") Ehcache cache)
/* 66:   */   {
/* 67:68 */     this.cache = cache;
/* 68:   */   }
/* 69:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.action.cache.PostsCheckCacheImpl
 * JD-Core Version:    0.7.0.1
 */