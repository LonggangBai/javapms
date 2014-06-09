/*  1:   */ package com.portal.extrafunc.action.cache;
/*  2:   */ 
/*  3:   */ import com.portal.extrafunc.entity.Theme;
/*  4:   */ import com.portal.extrafunc.service.ThemeService;
/*  5:   */ import java.util.List;
/*  6:   */ import net.sf.ehcache.Ehcache;
/*  7:   */ import net.sf.ehcache.Element;
/*  8:   */ import org.springframework.beans.factory.DisposableBean;
/*  9:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 10:   */ import org.springframework.beans.factory.annotation.Qualifier;
/* 11:   */ 
/* 12:   */ public class ThemeStatisCacheImpl
/* 13:   */   implements ThemeStatisCache, DisposableBean
/* 14:   */ {
/* 15:   */   private ThemeService themeService;
/* 16:   */   private Ehcache cache;
/* 17:   */   
/* 18:   */   public Integer updateStatis(Integer themeId)
/* 19:   */   {
/* 20:25 */     Theme theme = this.themeService.findById(themeId);
/* 21:26 */     if (theme == null) {
/* 22:27 */       return null;
/* 23:   */     }
/* 24:29 */     Element e = this.cache.get(theme.getId());
/* 25:   */     Integer viewCount;
/* 27:31 */     if (e != null) {
/* 28:32 */       viewCount = Integer.valueOf(((Integer)e.getValue()).intValue() + 1);
/* 29:   */     } else {
/* 30:34 */       viewCount = Integer.valueOf(theme.getViewsCount().intValue() + 1);
/* 31:   */     }
/* 32:36 */     this.cache.put(new Element(theme.getId(), viewCount));
/* 33:37 */     return viewCount;
/* 34:   */   }
/* 35:   */   
/* 36:   */   public Integer getStatis(Integer themeId)
/* 37:   */   {
/* 38:41 */     Theme theme = this.themeService.findById(themeId);
/* 39:42 */     if (theme == null) {
/* 40:43 */       return null;
/* 41:   */     }
/* 42:45 */     Element e = this.cache.get(theme.getId());
/* 43:   */     Integer viewCount;
/* 45:47 */     if (e != null) {
/* 46:48 */       viewCount = (Integer)e.getValue();
/* 47:   */     } else {
/* 48:50 */       viewCount = theme.getViewsCount();
/* 49:   */     }
/* 50:52 */     return viewCount;
/* 51:   */   }
/* 52:   */   
/* 53:   */   public void statisToDB()
/* 54:   */   {
/* 55:57 */     List<Integer> keys = this.cache.getKeys();
/* 56:58 */     if (keys.size() <= 0) {
/* 57:59 */       return;
/* 58:   */     }
/* 59:61 */     for (Integer id : keys)
/* 60:   */     {
/* 61:62 */       Element e = this.cache.get(id);
/* 62:63 */       if (e != null)
/* 63:   */       {
/* 64:64 */         Integer viewCount = (Integer)e.getValue();
/* 65:65 */         this.themeService.updateViewCount(id, viewCount);
/* 66:   */       }
/* 67:   */     }
/* 68:68 */     this.cache.removeAll();
/* 69:   */   }
/* 70:   */   
/* 71:   */   public void destroy()
/* 72:   */     throws Exception
/* 73:   */   {
/* 74:76 */     List<Integer> keys = this.cache.getKeys();
/* 75:77 */     if (keys.size() <= 0) {
/* 76:78 */       return;
/* 77:   */     }
/* 78:80 */     for (Integer id : keys)
/* 79:   */     {
/* 80:81 */       Element e = this.cache.get(id);
/* 81:82 */       Integer viewCount = (Integer)e.getValue();
/* 82:83 */       this.themeService.updateViewCount(id, viewCount);
/* 83:   */     }
/* 84:85 */     this.cache.removeAll();
/* 85:   */   }
/* 86:   */   
/* 87:   */   @Autowired
/* 88:   */   public void setCache(@Qualifier("themeViewCount") Ehcache cache)
/* 89:   */   {
/* 90:94 */     this.cache = cache;
/* 91:   */   }
/* 92:   */   
/* 93:   */   @Autowired
/* 94:   */   public void setThemeService(ThemeService themeService)
/* 95:   */   {
/* 96:99 */     this.themeService = themeService;
/* 97:   */   }
/* 98:   */ }



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.portal.extrafunc.action.cache.ThemeStatisCacheImpl

 * JD-Core Version:    0.7.0.1

 */