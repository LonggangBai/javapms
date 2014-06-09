/*  1:   */ package com.portal.datacenter.lucene;
/*  2:   */ 
/*  3:   */ import java.io.IOException;
/*  4:   */ import java.util.List;
/*  5:   */ import org.apache.lucene.index.FilterIndexReader;
/*  6:   */ import org.apache.lucene.index.FilterIndexReader.FilterTermDocs;
/*  7:   */ import org.apache.lucene.index.IndexReader;
/*  8:   */ import org.apache.lucene.index.Term;
/*  9:   */ import org.apache.lucene.index.TermDocs;
/* 10:   */ import org.apache.lucene.util.OpenBitSet;
/* 11:   */ 
/* 12:   */ public class MyFilterIndexReader
/* 13:   */   extends FilterIndexReader
/* 14:   */ {
/* 15:   */   OpenBitSet dels;
/* 16:   */   
/* 17:   */   public MyFilterIndexReader(IndexReader in)
/* 18:   */   {
/* 19:17 */     super(in);
/* 20:18 */     this.dels = new OpenBitSet(in.maxDoc());
/* 21:   */   }
/* 22:   */   
/* 23:   */   public MyFilterIndexReader(IndexReader in, List<String> idToDelete)
/* 24:   */     throws IOException
/* 25:   */   {
/* 26:23 */     super(in);
/* 27:24 */     this.dels = new OpenBitSet(in.maxDoc());
/* 28:25 */     for (String id : idToDelete)
/* 29:   */     {
/* 30:26 */       TermDocs td = in.termDocs(new Term("id", id));
/* 31:27 */       if (td.next()) {
/* 32:28 */         this.dels.set(td.doc());
/* 33:   */       }
/* 34:   */     }
/* 35:   */   }
/* 36:   */   
/* 37:   */   public int numDocs()
/* 38:   */   {
/* 39:34 */     return this.in.numDocs() - (int)this.dels.cardinality();
/* 40:   */   }
/* 41:   */   
/* 42:   */   public TermDocs termDocs(Term term)
/* 43:   */     throws IOException
/* 44:   */   {
/* 45:38 */     new FilterIndexReader.FilterTermDocs(this.in.termDocs(term))
/* 46:   */     {
/* 47:   */       public boolean next()
/* 48:   */         throws IOException
/* 49:   */       {
/* 50:   */         boolean res;
/* 51:41 */         while ((res = super.next()))
/* 52:   */         {
/* 54:42 */           if (!MyFilterIndexReader.this.dels.get(doc())) {
/* 55:   */             break;
/* 56:   */           }
/* 57:   */         }
/* 58:46 */         return res;
/* 59:   */       }
/* 60:   */     };
/* 61:   */
    return null;
}
/* 62:   */   
/* 63:   */   public TermDocs termDocs()
/* 64:   */     throws IOException
/* 65:   */   {
/* 66:52 */     new FilterIndexReader.FilterTermDocs(this.in.termDocs())
/* 67:   */     {
/* 68:   */       public boolean next()
/* 69:   */         throws IOException
/* 70:   */       {
/* 71:   */         boolean res;
/* 72:55 */         while ((res = super.next()))
/* 73:   */         {
/* 75:56 */           if (!MyFilterIndexReader.this.dels.get(doc())) {
/* 76:   */             break;
/* 77:   */           }
/* 78:   */         }
/* 79:60 */         return res;
/* 80:   */       }
/* 81:   */     };
/* 82:   */
    return null;
}
/* 83:   */ }



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.portal.datacenter.lucene.MyFilterIndexReader

 * JD-Core Version:    0.7.0.1

 */