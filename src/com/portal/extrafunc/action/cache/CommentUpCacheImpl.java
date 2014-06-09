/*  1:   */ package com.portal.extrafunc.action.cache;
/*  2:   */ 
/*  3:   */ import com.portal.extrafunc.entity.Comment;
/*  4:   */ import com.portal.extrafunc.service.CommentService;
/*  5:   */ import java.util.List;
/*  6:   */ import net.sf.ehcache.Ehcache;
/*  7:   */ import net.sf.ehcache.Element;
/*  8:   */ import org.springframework.beans.factory.DisposableBean;
/*  9:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 10:   */ import org.springframework.beans.factory.annotation.Qualifier;
/* 11:   */ 
/* 12:   */ public class CommentUpCacheImpl
/* 13:   */   implements CommentUpCache, DisposableBean
/* 14:   */ {
/* 15:   */   private CommentService commentService;
/* 16:   */   private Ehcache cache;
/* 17:   */   
/* 18:   */   public Integer upAndGet(Integer id)
/* 19:   */   {
/* 20:25 */     Comment c = this.commentService.findById(id);
/* 21:26 */     if (c == null) {
/* 22:27 */       return null;
/* 23:   */     }
/* 24:29 */     Element e = this.cache.get(id);
/* 25:   */     Integer ups;
/* 27:31 */     if (e != null) {
/* 28:32 */       ups = Integer.valueOf(((Integer)e.getValue()).intValue() + 1);
/* 29:   */     } else {
/* 30:34 */       ups = c.getUps();
/* 31:   */     }
/* 32:36 */     this.cache.put(new Element(id, ups));
/* 33:37 */     return ups;
/* 34:   */   }
/* 35:   */   
/* 36:   */   public void upsToDB()
/* 37:   */   {
/* 38:42 */     List<Integer> keys = this.cache.getKeys();
/* 39:43 */     if (keys.size() <= 0) {
/* 40:44 */       return;
/* 41:   */     }
/* 42:46 */     for (Integer id : keys)
/* 43:   */     {
/* 44:47 */       Element e = this.cache.get(id);
/* 45:48 */       if (e != null)
/* 46:   */       {
/* 47:49 */         Integer ups = (Integer)e.getValue();
/* 48:50 */         this.commentService.ups(id, ups);
/* 49:   */       }
/* 50:   */     }
/* 51:53 */     this.cache.removeAll();
/* 52:   */   }
/* 53:   */   
/* 54:   */   public void destroy()
/* 55:   */     throws Exception
/* 56:   */   {
/* 57:61 */     List<Integer> keys = this.cache.getKeys();
/* 58:62 */     if (keys.size() <= 0) {
/* 59:63 */       return;
/* 60:   */     }
/* 61:65 */     for (Integer id : keys)
/* 62:   */     {
/* 63:66 */       Element e = this.cache.get(id);
/* 64:67 */       if (e != null)
/* 65:   */       {
/* 66:68 */         Integer ups = (Integer)e.getValue();
/* 67:69 */         this.commentService.ups(id, ups);
/* 68:   */       }
/* 69:   */     }
/* 70:72 */     this.cache.removeAll();
/* 71:   */   }
/* 72:   */   
/* 73:   */   @Autowired
/* 74:   */   public void setCommentService(CommentService commentService)
/* 75:   */   {
/* 76:81 */     this.commentService = commentService;
/* 77:   */   }
/* 78:   */   
/* 79:   */   @Autowired
/* 80:   */   public void setCache(@Qualifier("commentUp") Ehcache cache)
/* 81:   */   {
/* 82:86 */     this.cache = cache;
/* 83:   */   }
/* 84:   */ }



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.portal.extrafunc.action.cache.CommentUpCacheImpl

 * JD-Core Version:    0.7.0.1

 */