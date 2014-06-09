/*   1:    */ package com.portal.extrafunc.action.cache;
/*   2:    */ 
/*   3:    */ import com.portal.extrafunc.entity.ForumStatis;
/*   4:    */ import com.portal.extrafunc.service.ForumStatisService;
/*   5:    */ import com.portal.sysmgr.entity.Site;
/*   6:    */ import java.util.List;
/*   7:    */ import net.sf.ehcache.Ehcache;
/*   8:    */ import net.sf.ehcache.Element;
/*   9:    */ import org.springframework.beans.factory.DisposableBean;
/*  10:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  11:    */ import org.springframework.beans.factory.annotation.Qualifier;
/*  12:    */ 
/*  13:    */ public class ForumStatisCacheImpl
/*  14:    */   implements ForumStatisCache, DisposableBean
/*  15:    */ {
/*  16:    */   private ForumStatisService statisService;
/*  17:    */   private Ehcache cache;
/*  18:    */   
/*  19:    */   public ForumStatis updateStatis(Site site, Integer postsToday, Integer postsTotal)
/*  20:    */   {
/*  21: 27 */     Element e = this.cache.get(site.getId());
/*  22:    */     ForumStatis fstatis;
/*  24: 29 */     if (e != null) {
/*  25: 30 */       fstatis = (ForumStatis)e.getObjectValue();
/*  26:    */     } else {
/*  27: 32 */       fstatis = this.statisService.findById(site.getId());
/*  28:    */     }
/*  29: 34 */     if (fstatis == null) {
/*  30: 35 */       fstatis = this.statisService.save(site);
/*  31:    */     }
/*  32: 37 */     fstatis.setPostsToday(Integer.valueOf(fstatis.getPostsToday().intValue() + postsToday.intValue()));
/*  33: 38 */     fstatis.setPostsTotal(Integer.valueOf(fstatis.getPostsTotal().intValue() + postsTotal.intValue()));
/*  34: 39 */     this.cache.put(new Element(site.getId(), fstatis));
/*  35: 40 */     return fstatis;
/*  36:    */   }
/*  37:    */   
/*  38:    */   public ForumStatis getStatis(Site site)
/*  39:    */   {
/*  40: 44 */     Element e = this.cache.get(site.getId());
/*  41:    */     ForumStatis fstatis;
/*  43: 46 */     if (e != null) {
/*  44: 47 */       fstatis = (ForumStatis)e.getObjectValue();
/*  45:    */     } else {
/*  46: 49 */       fstatis = this.statisService.findById(site.getId());
/*  47:    */     }
/*  48: 51 */     if (fstatis == null) {
/*  49: 52 */       fstatis = this.statisService.save(site);
/*  50:    */     }
/*  51: 54 */     return fstatis;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public void statisToDB()
/*  55:    */   {
/*  56: 59 */     List<Integer> keys = this.cache.getKeys();
/*  57: 60 */     if (keys.size() <= 0) {
/*  58: 61 */       return;
/*  59:    */     }
/*  60: 63 */     for (Integer id : keys)
/*  61:    */     {
/*  62: 64 */       Element e = this.cache.get(id);
/*  63: 65 */       if (e != null)
/*  64:    */       {
/*  65: 66 */         ForumStatis fstatis = (ForumStatis)e.getObjectValue();
/*  66: 67 */         this.statisService.update(id, fstatis.getPostsToday(), 
/*  67: 68 */           fstatis.getPostsTotal());
/*  68:    */       }
/*  69:    */     }
/*  70:    */   }
/*  71:    */   
/*  72:    */   public void statisOneday()
/*  73:    */   {
/*  74: 75 */     List<Integer> keys = this.cache.getKeys();
/*  75: 76 */     if (keys.size() <= 0) {
/*  76: 77 */       return;
/*  77:    */     }
/*  78: 79 */     for (Integer id : keys)
/*  79:    */     {
/*  80: 80 */       Element e = this.cache.get(id);
/*  81: 81 */       if (e != null)
/*  82:    */       {
/*  83: 82 */         ForumStatis fstatis = (ForumStatis)e.getObjectValue();
/*  84: 83 */         this.statisService.updateOnday(id, fstatis.getPostsToday(), 
/*  85: 84 */           fstatis.getPostsTotal());
/*  86:    */       }
/*  87:    */     }
/*  88: 87 */     this.cache.removeAll();
/*  89:    */   }
/*  90:    */   
/*  91:    */   public void destroy()
/*  92:    */     throws Exception
/*  93:    */   {
/*  94: 95 */     List<Integer> keys = this.cache.getKeys();
/*  95: 96 */     if (keys.size() <= 0) {
/*  96: 97 */       return;
/*  97:    */     }
/*  98: 99 */     for (Integer id : keys)
/*  99:    */     {
/* 100:100 */       Element e = this.cache.get(id);
/* 101:101 */       ForumStatis fstatis = (ForumStatis)e.getObjectValue();
/* 102:102 */       this.statisService.update(id, fstatis.getPostsToday(), 
/* 103:103 */         fstatis.getPostsTotal());
/* 104:    */     }
/* 105:105 */     this.cache.removeAll();
/* 106:    */   }
/* 107:    */   
/* 108:    */   @Autowired
/* 109:    */   public void setStatisService(ForumStatisService statisService)
/* 110:    */   {
/* 111:114 */     this.statisService = statisService;
/* 112:    */   }
/* 113:    */   
/* 114:    */   @Autowired
/* 115:    */   public void setCache(@Qualifier("forumStatis") Ehcache cache)
/* 116:    */   {
/* 117:119 */     this.cache = cache;
/* 118:    */   }
/* 119:    */ }



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.portal.extrafunc.action.cache.ForumStatisCacheImpl

 * JD-Core Version:    0.7.0.1

 */