/*  1:   */ package com.portal.datacenter.lucene;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.page.Pagination;
/*  4:   */ import com.portal.doccenter.entity.Article;
/*  5:   */ import com.portal.doccenter.service.ArticleService;
/*  6:   */ import java.io.IOException;
/*  7:   */ import java.util.ArrayList;
/*  8:   */ import java.util.Date;
/*  9:   */ import java.util.List;
/* 10:   */ import org.apache.lucene.search.IndexSearcher;
/* 11:   */ import org.apache.lucene.search.NRTManager;
/* 12:   */ import org.apache.lucene.search.Query;
/* 13:   */ import org.apache.lucene.search.TopDocs;
/* 14:   */ import org.apache.lucene.search.highlight.Formatter;
/* 15:   */ import org.apache.lucene.search.highlight.Fragmenter;
/* 16:   */ import org.apache.lucene.search.highlight.Highlighter;
/* 17:   */ import org.apache.lucene.search.highlight.QueryScorer;
/* 18:   */ import org.apache.lucene.search.highlight.Scorer;
/* 19:   */ import org.apache.lucene.search.highlight.SimpleFragmenter;
/* 20:   */ import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
/* 21:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 22:   */ import org.springframework.stereotype.Service;
/* 23:   */ import org.springframework.transaction.annotation.Transactional;
/* 24:   */ 
/* 25:   */ @Service
/* 26:   */ @Transactional
/* 27:   */ public class LuceneDocPageServiceImpl
/* 28:   */   implements LuceneDocPageService
/* 29:   */ {
/* 30:   */   private ArticleService articleService;
/* 31:   */   private NRTManagerService nrtManager;
/* 32:   */   
/* 33:   */   @Transactional(readOnly=true)
/* 34:   */   public Pagination searchArticle(String queryKey, String attrqueryKey, Integer siteId, Integer modelId, Integer channelId, Date startDate, Date endDate, int pageNo, int pageSize)
/* 35:   */   {
/* 36:34 */     IndexSearcher searcher = null;
/* 37:   */     try
/* 38:   */     {
/* 39:36 */       searcher = (IndexSearcher)this.nrtManager.getNrtManager().acquire();
/* 40:37 */       Query query = LuceneCommon.createQuery(queryKey, attrqueryKey, 
/* 41:38 */         siteId, modelId, channelId, startDate, endDate);
/* 42:39 */       Scorer fragmentScore = new QueryScorer(query);
/* 43:40 */       Fragmenter fragmenter = new SimpleFragmenter(100);
/* 44:41 */       Formatter formatter = new SimpleHTMLFormatter("<font color='red'>", 
/* 45:42 */         "</font>");
/* 46:43 */       Highlighter highlighter = new Highlighter(formatter, fragmentScore);
/* 47:44 */       highlighter.setTextFragmenter(fragmenter);
/* 48:45 */       TopDocs topdocs = searcher.search(query, pageNo * pageSize);
/* 49:46 */       Pagination p = LuceneCommon.getResultPage(searcher, topdocs, 
/* 50:47 */         pageNo, pageSize);
/* 51:48 */       List<?> ids = p.getList();
/* 52:49 */       List<Article> docs = new ArrayList(ids.size());
/* 53:50 */       for (Object id : ids) {
/* 54:51 */         docs.add(this.articleService.findById((Integer)id));
/* 55:   */       }
/* 56:53 */       p.setList(docs);
/* 57:54 */       return p;
/* 58:   */     }
/* 59:   */     catch (Exception e)
/* 60:   */     {
/* 61:56 */       e.printStackTrace();
/* 62:   */     }
/* 63:   */     finally
/* 64:   */     {
/* 65:   */       try
/* 66:   */       {
/* 67:59 */         this.nrtManager.getNrtManager().release(searcher);
/* 68:   */       }
/* 69:   */       catch (IOException e)
/* 70:   */       {
/* 71:61 */         e.printStackTrace();
/* 72:   */       }
/* 73:   */     }
/* 74:64 */     return null;
/* 75:   */   }
/* 76:   */   
/* 77:   */   @Autowired
/* 78:   */   public void setArticleService(ArticleService articleService)
/* 79:   */   {
/* 80:72 */     this.articleService = articleService;
/* 81:   */   }
/* 82:   */   
/* 83:   */   @Autowired
/* 84:   */   public void setNrtManager(NRTManagerService nrtManager)
/* 85:   */   {
/* 86:77 */     this.nrtManager = nrtManager;
/* 87:   */   }
/* 88:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.lucene.LuceneDocPageServiceImpl
 * JD-Core Version:    0.7.0.1
 */