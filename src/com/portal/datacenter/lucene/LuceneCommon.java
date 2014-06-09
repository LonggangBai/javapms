/*   1:    */ package com.portal.datacenter.lucene;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.page.Pagination;
/*   4:    */ import com.portal.doccenter.entity.Article;
/*   5:    */ import com.portal.doccenter.entity.Channel;
/*   6:    */ import com.portal.doccenter.entity.Model;
/*   7:    */ import com.portal.sysmgr.entity.Site;
/*   8:    */ import java.io.IOException;
/*   9:    */ import java.util.ArrayList;
/*  10:    */ import java.util.Date;
/*  11:    */ import java.util.Iterator;
/*  12:    */ import java.util.List;
/*  13:    */ import java.util.Map;
/*  14:    */ import java.util.Map.Entry;
/*  15:    */ import java.util.Set;
/*  16:    */ import org.apache.commons.lang.StringUtils;
/*  17:    */ import org.apache.lucene.analysis.Analyzer;
/*  18:    */ import org.apache.lucene.analysis.standard.StandardAnalyzer;
/*  19:    */ import org.apache.lucene.document.DateTools;
/*  20:    */ import org.apache.lucene.document.DateTools.Resolution;
/*  21:    */ import org.apache.lucene.document.Document;
/*  22:    */ import org.apache.lucene.document.Field;
/*  23:    */ import org.apache.lucene.document.Field.Index;
/*  24:    */ import org.apache.lucene.document.Field.Store;
/*  25:    */ import org.apache.lucene.index.CorruptIndexException;
/*  26:    */ import org.apache.lucene.index.Term;
/*  27:    */ import org.apache.lucene.queryParser.MultiFieldQueryParser;
/*  28:    */ import org.apache.lucene.queryParser.ParseException;
/*  29:    */ import org.apache.lucene.search.*;
import org.apache.lucene.search.BooleanClause.Occur;
/*  30:    */
/*  31:    */
/*  32:    */
/*  33:    */
/*  34:    */
/*  35:    */
/*  36:    */
/*  37:    */ import org.apache.lucene.util.NumericUtils;
/*  38:    */ import org.apache.lucene.util.Version;
/*  39:    */ 
/*  40:    */ public class LuceneCommon
/*  41:    */ {
/*  42:    */   public static final String ID = "id";
/*  43:    */   public static final String SITE_ID = "siteId";
/*  44:    */   public static final String MODEL_ID = "modelId";
/*  45:    */   public static final String CHANNEL_ID = "channelId";
/*  46:    */   public static final String CHANNEL_NUMBER = "number";
/*  47:    */   public static final String RELEASE_DATE = "releaseDate";
/*  48:    */   public static final String TITLE = "title";
/*  49:    */   public static final String CONTENT = "content";
/*  50:    */   public static final String ATTR_VALUE = "attr_value";
/*  51: 48 */   public static final String[] QUERY_FIELD = { "title", "content", "attr_value" };
/*  52: 49 */   public static final BooleanClause.Occur[] QUERY_FLAGS = {
/*  53: 50 */     BooleanClause.Occur.SHOULD, BooleanClause.Occur.SHOULD, 
/*  54: 51 */     BooleanClause.Occur.SHOULD };
/*  55:    */   
/*  56:    */   public static Term term(Integer id)
/*  57:    */   {
/*  58: 54 */     return new Term("id", NumericUtils.intToPrefixCoded(id.intValue()));
/*  59:    */   }
/*  60:    */   
/*  61:    */   public static Document createDoc(Article a)
/*  62:    */   {
/*  63: 58 */     Document doc = new Document();
/*  64: 59 */     doc.add(new Field("id", a.getId().toString(), Field.Store.YES, 
/*  65: 60 */       Field.Index.NOT_ANALYZED));
/*  66: 61 */     doc.add(new Field("siteId", a.getSite().getId().toString(), 
/*  67: 62 */       Field.Store.NO, Field.Index.NOT_ANALYZED));
/*  68: 63 */     Channel channel = a.getChannel();
/*  69: 64 */     while (channel != null)
/*  70:    */     {
/*  71: 65 */       doc.add(new Field("channelId", channel.getId().toString(), 
/*  72: 66 */         Field.Store.NO, Field.Index.NOT_ANALYZED));
/*  73: 67 */       channel = channel.getParent();
/*  74:    */     }
/*  75: 69 */     doc.add(new Field("modelId", a.getModel().getId().toString(), 
/*  76: 70 */       Field.Store.NO, Field.Index.NOT_ANALYZED));
/*  77: 71 */     doc.add(new Field("releaseDate", DateTools.dateToString(
/*  78: 72 */       a.getReleaseDate(), DateTools.Resolution.DAY), Field.Store.NO, 
/*  79: 73 */       Field.Index.NOT_ANALYZED));
/*  80: 74 */     doc.add(new Field("title", a.getTitle(), Field.Store.NO, 
/*  81: 75 */       Field.Index.ANALYZED));
/*  82: 76 */     if (!StringUtils.isBlank(a.getTxtValue())) {
/*  83: 77 */       doc.add(new Field("content", a.getTxtValue(), Field.Store.NO, 
/*  84: 78 */         Field.Index.ANALYZED));
/*  85:    */     }
/*  86: 80 */     if (a.getAttr() != null)
/*  87:    */     {
/*  88: 81 */       Iterator<Entry<String, String>> iter = a.getAttr().entrySet()
/*  89: 82 */         .iterator();
/*  90: 83 */       String value = "";
/*  91: 84 */       while (iter.hasNext())
/*  92:    */       {
/*  93: 85 */         Entry<String, String> entry =
/*  94: 86 */           (Entry)iter.next();
/*  95: 87 */         if ((!StringUtils.isBlank((String)entry.getValue())) && 
/*  96: 88 */           (!StringUtils.isBlank((String)entry.getKey())))
/*  97:    */         {
/*  98: 89 */           value = value + (String)entry.getValue();
/*  99: 90 */           doc.add(new Field((String)entry.getKey(), (String)entry.getValue(), 
/* 100: 91 */             Field.Store.NO, Field.Index.ANALYZED));
/* 101:    */         }
/* 102:    */       }
/* 103: 94 */       if (!StringUtils.isBlank(value)) {
/* 104: 95 */         doc.add(new Field("attr_value", value, Field.Store.NO, 
/* 105: 96 */           Field.Index.ANALYZED));
/* 106:    */       }
/* 107:    */     }
/* 108: 99 */     return doc;
/* 109:    */   }
/* 110:    */   
/* 111:    */   public static Query createQuery(String queryKey, String attrqueryKey, Integer siteId, Integer modelId, Integer channelId, Date startDate, Date endDate)
/* 112:    */     throws ParseException
/* 113:    */   {
/* 114:105 */     Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_36);
/* 115:106 */     BooleanQuery bq = new BooleanQuery();
/* 116:108 */     if (!StringUtils.isBlank(queryKey))
/* 117:    */     {
/* 118:109 */       Query q = MultiFieldQueryParser.parse(Version.LUCENE_36, queryKey, 
/* 119:110 */         QUERY_FIELD, QUERY_FLAGS, analyzer);
/* 120:111 */       bq.add(q, BooleanClause.Occur.MUST);
/* 121:    */     }
/* 122:113 */     if (!StringUtils.isBlank(attrqueryKey))
/* 123:    */     {
/* 124:114 */       String[] attrs = attrqueryKey.split("!~!");
/* 125:115 */       for (String attr : attrs) {
/* 126:116 */         if (attr.indexOf(":") > -1)
/* 127:    */         {
/* 128:117 */           String[] attrinfo = attr.split(":");
/* 129:118 */           if ((attrinfo.length == 2) && 
/* 130:119 */             (!StringUtils.isBlank(attrinfo[1])))
/* 131:    */           {
/* 132:120 */             String[] sq = { attrinfo[1] };
/* 133:121 */             String[] sf = { attrinfo[0] };
/* 134:122 */             BooleanClause.Occur[] sfla = { BooleanClause.Occur.MUST };
/* 135:123 */             Query q = MultiFieldQueryParser.parse(Version.LUCENE_36, sq, 
/* 136:124 */               sf, sfla, analyzer);
/* 137:125 */             bq.add(q, BooleanClause.Occur.MUST);
/* 138:    */           }
/* 139:    */         }
/* 140:    */       }
/* 141:    */     }
/* 142:130 */     if (siteId != null)
/* 143:    */     {
/* 144:131 */       Query q = new TermQuery(new Term("siteId", siteId.toString()));
/* 145:132 */       bq.add(q, BooleanClause.Occur.MUST);
/* 146:    */     }
/* 147:134 */     if (channelId != null)
/* 148:    */     {
/* 149:135 */       Query q = new TermQuery(new Term("channelId", channelId.toString()));
/* 150:136 */       bq.add(q, BooleanClause.Occur.MUST);
/* 151:    */     }
/* 152:138 */     if (modelId != null)
/* 153:    */     {
/* 154:139 */       Query q = new TermQuery(new Term("modelId", modelId.toString()));
/* 155:140 */       bq.add(q, BooleanClause.Occur.MUST);
/* 156:    */     }
/* 157:142 */     if ((startDate != null) || (endDate != null))
/* 158:    */     {
/* 159:143 */       String start = null;
/* 160:144 */       String end = null;
/* 161:145 */       if (startDate != null) {
/* 162:146 */         start = DateTools.dateToString(startDate, DateTools.Resolution.DAY);
/* 163:    */       }
/* 164:148 */       if (endDate != null) {
/* 165:149 */         end = DateTools.dateToString(endDate, DateTools.Resolution.DAY);
/* 166:    */       }
/* 167:151 */       Query q = new TermRangeQuery("releaseDate", start, end, true, true);
/* 168:152 */       bq.add(q, BooleanClause.Occur.MUST);
/* 169:    */     }
/* 170:154 */     return bq;
/* 171:    */   }
/* 172:    */   
/* 173:    */   public static Pagination getResultPage(IndexSearcher searcher, TopDocs docs, int pageNo, int pageSize)
/* 174:    */     throws CorruptIndexException, IOException
/* 175:    */   {
/* 176:160 */     List<Integer> list = new ArrayList(pageSize);
/* 177:161 */     ScoreDoc[] hits = docs.scoreDocs;
/* 178:162 */     int endIndex = pageNo * pageSize;
/* 179:163 */     int len = hits.length;
/* 180:164 */     if (endIndex > len) {
/* 181:165 */       endIndex = len;
/* 182:    */     }
/* 183:167 */     for (int i = (pageNo - 1) * pageSize; i < endIndex; i++)
/* 184:    */     {
/* 185:168 */       Document d = searcher.doc(hits[i].doc);
/* 186:169 */       list.add(Integer.valueOf(d.get("id")));
/* 187:    */     }
/* 188:171 */     return new Pagination(pageNo, pageSize, docs.totalHits, list);
/* 189:    */   }
/* 190:    */   
/* 191:    */   public static List<Integer> getResultList(IndexSearcher searcher, TopDocs docs, int first, int max)
/* 192:    */     throws CorruptIndexException, IOException
/* 193:    */   {
/* 194:177 */     List<Integer> list = new ArrayList(max);
/* 195:178 */     ScoreDoc[] hits = docs.scoreDocs;
/* 196:179 */     if (first < 0) {
/* 197:180 */       first = 0;
/* 198:    */     }
/* 199:182 */     if (max < 0) {
/* 200:183 */       max = 0;
/* 201:    */     }
/* 202:185 */     int last = first + max;
/* 203:186 */     int len = hits.length;
/* 204:187 */     if (last > len) {
/* 205:188 */       last = len;
/* 206:    */     }
/* 207:190 */     for (int i = first; i < last; i++)
/* 208:    */     {
/* 209:191 */       Document d = searcher.doc(hits[i].doc);
/* 210:192 */       list.add(Integer.valueOf(d.get("id")));
/* 211:    */     }
/* 212:194 */     return list;
/* 213:    */   }
/* 214:    */ }



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.portal.datacenter.lucene.LuceneCommon

 * JD-Core Version:    0.7.0.1

 */