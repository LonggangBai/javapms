/*  1:   */ package com.portal.doccenter.action.fnt.cache;
/*  2:   */ 
/*  3:   */ import com.portal.doccenter.entity.Article;
/*  4:   */ import com.portal.doccenter.entity.DocStatis;
/*  5:   */ import com.portal.doccenter.service.ArticleService;
/*  6:   */ import com.portal.doccenter.service.DocStatisService;
/*  7:   */ import java.util.List;
/*  8:   */ import net.sf.ehcache.Ehcache;
/*  9:   */ import net.sf.ehcache.Element;
/* 10:   */ import org.springframework.beans.factory.DisposableBean;
/* 11:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 12:   */ import org.springframework.beans.factory.annotation.Qualifier;
/* 13:   */ 
/* 14:   */ public class DocViewsCountCacheImpl
/* 15:   */   implements DocViewsCountCache, DisposableBean
/* 16:   */ {
/* 17:   */   private ArticleService articleService;
/* 18:   */   private DocStatisService statisService;
/* 19:   */   private Ehcache cache;
/* 20:   */   
/* 21:   */   public Integer viewsCount(Integer docId)
/* 22:   */   {
/* 23:28 */     DocStatis statis = this.statisService.findById(docId);
/* 24:29 */     if (statis == null)
/* 25:   */     {
/* 26:30 */       Article doc = this.articleService.findById(docId);
/* 27:31 */       if (doc == null) {
/* 28:32 */         return null;
/* 29:   */       }
/* 30:34 */       statis = this.statisService.save(doc);
/* 31:   */     }
/* 32:36 */     Element e = this.cache.get(docId);
/* 33:   */     Integer views;
/* 35:38 */     if (e != null) {
/* 36:39 */       views = Integer.valueOf(((Integer)e.getValue()).intValue() + 1);
/* 37:   */     } else {
/* 38:41 */       views = statis.getViewsCount();
/* 39:   */     }
/* 40:43 */     this.cache.put(new Element(docId, views));
/* 41:44 */     return views;
/* 42:   */   }
/* 43:   */   
/* 44:   */   public void viewsToDB()
/* 45:   */   {
/* 46:49 */     List<Integer> keys = this.cache.getKeys();
/* 47:50 */     if (keys.size() <= 0) {
/* 48:51 */       return;
/* 49:   */     }
/* 50:53 */     for (Integer id : keys)
/* 51:   */     {
/* 52:54 */       Element e = this.cache.get(id);
/* 53:55 */       Integer viewsCount = (Integer)e.getValue();
/* 54:56 */       this.statisService.update(id, viewsCount);
/* 55:   */     }
/* 56:58 */     this.cache.removeAll();
/* 57:   */   }
/* 58:   */   
/* 59:   */   public void destroy()
/* 60:   */     throws Exception
/* 61:   */   {
/* 62:66 */     List<Integer> keys = this.cache.getKeys();
/* 63:67 */     if (keys.size() <= 0) {
/* 64:68 */       return;
/* 65:   */     }
/* 66:70 */     for (Integer id : keys)
/* 67:   */     {
/* 68:71 */       Element e = this.cache.get(id);
/* 69:72 */       Integer viewsCount = (Integer)e.getValue();
/* 70:73 */       this.statisService.update(id, viewsCount);
/* 71:   */     }
/* 72:75 */     this.cache.removeAll();
/* 73:   */   }
/* 74:   */   
/* 75:   */   @Autowired
/* 76:   */   public void setArticleService(ArticleService articleService)
/* 77:   */   {
/* 78:84 */     this.articleService = articleService;
/* 79:   */   }
/* 80:   */   
/* 81:   */   @Autowired
/* 82:   */   public void setStatisService(DocStatisService statisService)
/* 83:   */   {
/* 84:89 */     this.statisService = statisService;
/* 85:   */   }
/* 86:   */   
/* 87:   */   @Autowired
/* 88:   */   public void setCache(@Qualifier("docViews") Ehcache cache)
/* 89:   */   {
/* 90:94 */     this.cache = cache;
/* 91:   */   }
/* 92:   */ }



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.portal.doccenter.action.fnt.cache.DocViewsCountCacheImpl

 * JD-Core Version:    0.7.0.1

 */