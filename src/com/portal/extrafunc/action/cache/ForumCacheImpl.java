/*   1:    */ package com.portal.extrafunc.action.cache;
/*   2:    */ 
/*   3:    */ import com.portal.extrafunc.entity.Forum;
/*   4:    */ import com.portal.extrafunc.entity.Theme;
/*   5:    */ import com.portal.extrafunc.service.ForumService;
/*   6:    */ import java.util.List;
/*   7:    */ import net.sf.ehcache.Ehcache;
/*   8:    */ import net.sf.ehcache.Element;
/*   9:    */ import org.springframework.beans.factory.DisposableBean;
/*  10:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  11:    */ import org.springframework.beans.factory.annotation.Qualifier;
/*  12:    */ 
/*  13:    */ public class ForumCacheImpl
/*  14:    */   implements ForumCache, DisposableBean
/*  15:    */ {
/*  16:    */   private ForumService forumService;
/*  17:    */   private Ehcache cache;
/*  18:    */   
/*  19:    */   public Forum updateForum(Theme theme, Integer themeTotal, Integer replyTotal, Integer themeToday, Integer replyToday)
/*  20:    */   {
/*  21: 27 */     Integer forumId = theme.getForum().getId();
/*  22: 28 */     Element e = this.cache.get(forumId);
/*  23:    */     Forum f;
/*  25: 30 */     if (e != null) {
/*  26: 31 */       f = (Forum)e.getObjectValue();
/*  27:    */     } else {
/*  28: 33 */       f = this.forumService.findById(forumId);
/*  29:    */     }
/*  30: 35 */     if (f == null) {
/*  31: 36 */       return null;
/*  32:    */     }
/*  33: 38 */     f.setThemeTotal(Integer.valueOf(f.getThemeTotal().intValue() + themeTotal.intValue()));
/*  34: 39 */     f.setReplyTotal(Integer.valueOf(f.getReplyTotal().intValue() + replyTotal.intValue()));
/*  35: 40 */     f.setThemeToday(Integer.valueOf(f.getThemeToday().intValue() + themeToday.intValue()));
/*  36: 41 */     f.setReplyToday(Integer.valueOf(f.getReplyToday().intValue() + replyToday.intValue()));
/*  37: 42 */     f.setLastTheme(theme);
/*  38: 43 */     f.setLastReplyer(theme.getLastReplyer());
/*  39: 44 */     this.cache.put(new Element(forumId, f));
/*  40: 45 */     return f;
/*  41:    */   }
/*  42:    */   
/*  43:    */   public Forum getForum(Integer forumId)
/*  44:    */   {
/*  45: 49 */     Element e = this.cache.get(forumId);
/*  46:    */     Forum f;
/*  48: 51 */     if (e != null) {
/*  49: 52 */       f = (Forum)e.getObjectValue();
/*  50:    */     } else {
/*  51: 54 */       f = this.forumService.findById(forumId);
/*  52:    */     }
/*  53: 56 */     if (f == null) {
/*  54: 57 */       return null;
/*  55:    */     }
/*  56: 59 */     return f;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public void statisToDB()
/*  60:    */   {
/*  61: 64 */     List<Integer> keys = this.cache.getKeys();
/*  62: 65 */     if (keys.size() <= 0) {
/*  63: 66 */       return;
/*  64:    */     }
/*  65: 68 */     for (Integer id : keys)
/*  66:    */     {
/*  67: 69 */       Element e = this.cache.get(id);
/*  68: 70 */       if (e != null)
/*  69:    */       {
/*  70: 71 */         Forum forum = (Forum)e.getObjectValue();
/*  71: 72 */         this.forumService.updateForum(forum);
/*  72:    */       }
/*  73:    */     }
/*  74: 75 */     this.cache.removeAll();
/*  75:    */   }
/*  76:    */   
/*  77:    */   public void statisOneday()
/*  78:    */   {
/*  79: 79 */     List<Forum> flist = this.forumService.getList();
/*  80: 80 */     for (Forum f : flist)
/*  81:    */     {
/*  82: 81 */       Element e = this.cache.get(f.getId());
/*  83: 82 */       if (e != null)
/*  84:    */       {
/*  85: 83 */         Forum forum = (Forum)e.getObjectValue();
/*  86: 84 */         this.forumService.updateForumOnday(forum);
/*  87:    */       }
/*  88:    */       else
/*  89:    */       {
/*  90: 86 */         this.forumService.updateForumOnday(f);
/*  91:    */       }
/*  92:    */     }
/*  93: 89 */     this.cache.removeAll();
/*  94:    */   }
/*  95:    */   
/*  96:    */   public void destroy()
/*  97:    */     throws Exception
/*  98:    */   {
/*  99: 97 */     List<Integer> keys = this.cache.getKeys();
/* 100: 98 */     if (keys.size() <= 0) {
/* 101: 99 */       return;
/* 102:    */     }
/* 103:101 */     for (Integer id : keys)
/* 104:    */     {
/* 105:102 */       Element e = this.cache.get(id);
/* 106:103 */       Forum forum = (Forum)e.getObjectValue();
/* 107:104 */       this.forumService.updateForum(forum);
/* 108:    */     }
/* 109:106 */     this.cache.removeAll();
/* 110:    */   }
/* 111:    */   
/* 112:    */   @Autowired
/* 113:    */   public void setForumService(ForumService forumService)
/* 114:    */   {
/* 115:115 */     this.forumService = forumService;
/* 116:    */   }
/* 117:    */   
/* 118:    */   @Autowired
/* 119:    */   public void setCache(@Qualifier("forum") Ehcache cache)
/* 120:    */   {
/* 121:120 */     this.cache = cache;
/* 122:    */   }
/* 123:    */ }



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.portal.extrafunc.action.cache.ForumCacheImpl

 * JD-Core Version:    0.7.0.1

 */