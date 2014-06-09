/*  1:   */ package com.portal.datacenter.lucene;
/*  2:   */ 
/*  3:   */ import com.portal.doccenter.entity.Article;
/*  4:   */ import java.io.IOException;
/*  5:   */ import java.util.Date;
/*  6:   */ import org.apache.lucene.queryParser.ParseException;
/*  7:   */ import org.apache.lucene.search.Query;
/*  8:   */ import org.springframework.beans.factory.annotation.Autowired;
/*  9:   */ import org.springframework.stereotype.Service;
/* 10:   */ import org.springframework.transaction.annotation.Transactional;
/* 11:   */ 
/* 12:   */ @Service
/* 13:   */ @Transactional
/* 14:   */ public class LuceneDocServiceImpl
/* 15:   */   implements LuceneDocService
/* 16:   */ {
/* 17:   */   private LuceneDocDao dao;
/* 18:   */   private NRTManagerService nrtManager;
/* 19:   */   
/* 20:   */   public Integer createSearchIndex(Integer siteId, Integer channelId, Date startDate, Date endDate, Integer startId, Integer max, boolean delete)
/* 21:   */     throws IOException
/* 22:   */   {
/* 23:21 */     if (delete) {
/* 24:   */       try
/* 25:   */       {
/* 26:23 */         Query query = LuceneCommon.createQuery(null, null, siteId, 
/* 27:24 */           null, channelId, startDate, endDate);
/* 28:25 */         this.nrtManager.deleteDocuments(query);
/* 29:   */       }
/* 30:   */       catch (ParseException e)
/* 31:   */       {
/* 32:27 */         e.printStackTrace();
/* 33:   */       }
/* 34:   */     }
/* 35:30 */     Integer docId = this.dao.index(this.nrtManager, siteId, channelId, startDate, 
/* 36:31 */       endDate, startId, max);
/* 37:32 */     return docId;
/* 38:   */   }
/* 39:   */   
/* 40:   */   public void addDoc(Article doc)
/* 41:   */   {
/* 42:36 */     this.nrtManager.addDoc(LuceneCommon.createDoc(doc));
/* 43:   */   }
/* 44:   */   
/* 45:   */   public void updateDoc(Article doc)
/* 46:   */   {
/* 47:40 */     this.nrtManager.updateDocument(LuceneCommon.term(doc.getId()), 
/* 48:41 */       LuceneCommon.createDoc(doc));
/* 49:   */   }
/* 50:   */   
/* 51:   */   public void deleteDoc(Integer docId)
/* 52:   */   {
/* 53:45 */     this.nrtManager.deleteDocuments(LuceneCommon.term(docId));
/* 54:   */   }
/* 55:   */   
/* 56:   */   @Autowired
/* 57:   */   public void setDao(LuceneDocDao dao)
/* 58:   */   {
/* 59:53 */     this.dao = dao;
/* 60:   */   }
/* 61:   */   
/* 62:   */   @Autowired
/* 63:   */   public void setNrtManager(NRTManagerService nrtManager)
/* 64:   */   {
/* 65:58 */     this.nrtManager = nrtManager;
/* 66:   */   }
/* 67:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.lucene.LuceneDocServiceImpl
 * JD-Core Version:    0.7.0.1
 */