/*   1:    */ package com.portal.datacenter.lucene;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.plugin.springmvc.RealPathResolver;
/*   4:    */ import java.io.File;
/*   5:    */ import java.io.IOException;
/*   6:    */ import java.util.Collection;
/*   7:    */ import org.apache.lucene.analysis.Analyzer;
/*   8:    */ import org.apache.lucene.analysis.standard.StandardAnalyzer;
/*   9:    */ import org.apache.lucene.document.Document;
/*  10:    */ import org.apache.lucene.index.CorruptIndexException;
/*  11:    */ import org.apache.lucene.index.IndexWriter;
/*  12:    */ import org.apache.lucene.index.IndexWriterConfig;
/*  13:    */ import org.apache.lucene.index.Term;
/*  14:    */ import org.apache.lucene.search.NRTManager;
/*  15:    */ import org.apache.lucene.search.NRTManager.TrackingIndexWriter;
/*  16:    */ import org.apache.lucene.search.NRTManagerReopenThread;
/*  17:    */ import org.apache.lucene.search.Query;
/*  18:    */ import org.apache.lucene.search.SearcherFactory;
/*  19:    */ import org.apache.lucene.store.Directory;
/*  20:    */ import org.apache.lucene.store.FSDirectory;
/*  21:    */ import org.apache.lucene.util.Version;
/*  22:    */ import org.springframework.beans.factory.DisposableBean;
/*  23:    */ 
/*  24:    */ public class NRTManagerServiceImpl
/*  25:    */   implements NRTManagerService, DisposableBean
/*  26:    */ {
/*  27:    */   private IndexWriter indexWriter;
/*  28:    */   private NRTManager nrtManager;
/*  29:    */   private NRTManager.TrackingIndexWriter trackingIndexWriter;
/*  30:    */   private NRTManagerReopenThread reopenThread;
/*  31:    */   private Directory dir;
/*  32:    */   
/*  33:    */   public NRTManagerServiceImpl(RealPathResolver realPathResolver)
/*  34:    */     throws IOException
/*  35:    */   {
/*  36:    */     try
/*  37:    */     {
/*  38: 39 */       this.dir = FSDirectory.open(new File(realPathResolver
/*  39: 40 */         .get("/WEB-INF/lucene")));
/*  40: 41 */       Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_36);
/*  41: 42 */       IndexWriterConfig conf = new IndexWriterConfig(Version.LUCENE_36, 
/*  42: 43 */         analyzer);
/*  43: 44 */       this.indexWriter = new IndexWriter(this.dir, conf);
/*  44: 45 */       SearcherFactory searcherFactory = new SearcherFactory();
/*  45: 46 */       this.trackingIndexWriter = new NRTManager.TrackingIndexWriter(
/*  46: 47 */         this.indexWriter);
/*  47: 48 */       this.nrtManager = new NRTManager(this.trackingIndexWriter, searcherFactory, 
/*  48: 49 */         true);
/*  49: 50 */       this.reopenThread = new NRTManagerReopenThread(this.nrtManager, 5.0D, 0.1D);
/*  50: 51 */       this.reopenThread.setName("nrt reopen thread");
/*  51: 52 */       this.reopenThread.setDaemon(true);
/*  52: 53 */       this.reopenThread.start();
/*  53:    */     }
/*  54:    */     catch (IOException e)
/*  55:    */     {
/*  56: 55 */       e.printStackTrace();
/*  57:    */     }
/*  58:    */   }
/*  59:    */   
/*  60:    */   public void addDoc(Document doc)
/*  61:    */   {
/*  62:    */     try
/*  63:    */     {
/*  64: 61 */       this.trackingIndexWriter.addDocument(doc);
/*  65:    */     }
/*  66:    */     catch (IOException e)
/*  67:    */     {
/*  68: 63 */       e.printStackTrace();
/*  69:    */     }
/*  70:    */   }
/*  71:    */   
/*  72:    */   public void addDocuments(Collection<Document> documents)
/*  73:    */   {
/*  74:    */     try
/*  75:    */     {
/*  76: 69 */       this.trackingIndexWriter.addDocuments(documents);
/*  77:    */     }
/*  78:    */     catch (Exception e)
/*  79:    */     {
/*  80: 71 */       e.printStackTrace();
/*  81:    */     }
/*  82:    */   }
/*  83:    */   
/*  84:    */   public void updateDocument(Term term, Document document)
/*  85:    */   {
/*  86:    */     try
/*  87:    */     {
/*  88: 77 */       this.trackingIndexWriter.updateDocument(term, document);
/*  89:    */     }
/*  90:    */     catch (Exception e)
/*  91:    */     {
/*  92: 79 */       e.printStackTrace();
/*  93:    */     }
/*  94:    */   }
/*  95:    */   
/*  96:    */   public void deleteDocuments(Term term)
/*  97:    */   {
/*  98:    */     try
/*  99:    */     {
/* 100: 85 */       this.trackingIndexWriter.deleteDocuments(term);
/* 101:    */     }
/* 102:    */     catch (Exception e)
/* 103:    */     {
/* 104: 87 */       e.printStackTrace();
/* 105:    */     }
/* 106:    */   }
/* 107:    */   
/* 108:    */   public void deleteDocuments(Query query)
/* 109:    */   {
/* 110:    */     try
/* 111:    */     {
/* 112: 93 */       this.trackingIndexWriter.deleteDocuments(query);
/* 113:    */     }
/* 114:    */     catch (Exception e)
/* 115:    */     {
/* 116: 95 */       e.printStackTrace();
/* 117:    */     }
/* 118:    */   }
/* 119:    */   
/* 120:    */   public void commit()
/* 121:    */   {
/* 122:    */     try
/* 123:    */     {
/* 124:101 */       this.indexWriter.commit();
/* 125:    */     }
/* 126:    */     catch (CorruptIndexException e)
/* 127:    */     {
/* 128:103 */       e.printStackTrace();
/* 129:    */     }
/* 130:    */     catch (IOException e)
/* 131:    */     {
/* 132:105 */       e.printStackTrace();
/* 133:    */     }
/* 134:    */   }
/* 135:    */   
/* 136:    */   public void destroy()
/* 137:    */     throws Exception
/* 138:    */   {
/* 139:110 */     if (this.reopenThread != null) {
/* 140:111 */       this.reopenThread.close();
/* 141:    */     }
/* 142:113 */     if (this.nrtManager != null) {
/* 143:114 */       this.nrtManager.close();
/* 144:    */     }
/* 145:116 */     if (this.indexWriter != null) {
/* 146:117 */       this.indexWriter.close();
/* 147:    */     }
/* 148:    */   }
/* 149:    */   
/* 150:    */   public IndexWriter getIndexWriter()
/* 151:    */   {
/* 152:132 */     return this.indexWriter;
/* 153:    */   }
/* 154:    */   
/* 155:    */   public NRTManager getNrtManager()
/* 156:    */   {
/* 157:136 */     return this.nrtManager;
/* 158:    */   }
/* 159:    */   
/* 160:    */   public NRTManager.TrackingIndexWriter getTrackingIndexWriter()
/* 161:    */   {
/* 162:140 */     return this.trackingIndexWriter;
/* 163:    */   }
/* 164:    */   
/* 165:    */   public NRTManagerReopenThread getReopenThread()
/* 166:    */   {
/* 167:144 */     return this.reopenThread;
/* 168:    */   }
/* 169:    */   
/* 170:    */   public Directory getDir()
/* 171:    */   {
/* 172:148 */     return this.dir;
/* 173:    */   }
/* 174:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.lucene.NRTManagerServiceImpl
 * JD-Core Version:    0.7.0.1
 */