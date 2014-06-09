/*  1:   */ package com.portal.datacenter.lucene;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Finder;
/*  4:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  5:   */ import com.portal.doccenter.entity.Article;
/*  6:   */ import java.io.IOException;
/*  7:   */ import java.util.Date;
/*  8:   */ import org.apache.lucene.index.CorruptIndexException;
/*  9:   */ import org.hibernate.CacheMode;
/* 10:   */ import org.hibernate.Query;
/* 11:   */ import org.hibernate.ScrollMode;
/* 12:   */ import org.hibernate.ScrollableResults;
/* 13:   */ import org.hibernate.Session;
/* 14:   */ import org.springframework.stereotype.Repository;
/* 15:   */ 
/* 16:   */ @Repository
/* 17:   */ public class LuceneDocDaoImpl
/* 18:   */   extends HibernateBaseDao<Article, Integer>
/* 19:   */   implements LuceneDocDao
/* 20:   */ {
/* 21:   */   public Integer index(NRTManagerService service, Integer siteId, Integer channelId, Date startDate, Date endDate, Integer startId, Integer max)
/* 22:   */     throws CorruptIndexException, IOException
/* 23:   */   {
/* 24:24 */     Finder f = Finder.create("select bean from Article bean");
/* 25:25 */     if (channelId != null)
/* 26:   */     {
/* 27:26 */       f.append(" join bean.channel channel, Channel parent");
/* 28:27 */       f.append(" where channel.number like parent.number||'%'");
/* 29:28 */       f.append(" and channel.site.id=parent.site.id");
/* 30:29 */       f.append(" and parent.id=:parentId");
/* 31:30 */       f.setParam("parentId", channelId);
/* 32:   */     }
/* 33:31 */     else if (siteId != null)
/* 34:   */     {
/* 35:32 */       f.append(" where bean.site.id=:siteId");
/* 36:33 */       f.setParam("siteId", siteId);
/* 37:   */     }
/* 38:   */     else
/* 39:   */     {
/* 40:35 */       f.append(" where 1=1");
/* 41:   */     }
/* 42:37 */     if (startId != null)
/* 43:   */     {
/* 44:38 */       f.append(" and bean.id > :startId");
/* 45:39 */       f.setParam("startId", startId);
/* 46:   */     }
/* 47:41 */     if (startDate != null)
/* 48:   */     {
/* 49:42 */       f.append(" and bean.releaseDate >= :startDate");
/* 50:43 */       f.setParam("startDate", startDate);
/* 51:   */     }
/* 52:45 */     if (endDate != null)
/* 53:   */     {
/* 54:46 */       f.append(" and bean.releaseDate <= :endDate");
/* 55:47 */       f.setParam("endDate", endDate);
/* 56:   */     }
/* 57:49 */     f.append(" and bean.status=2");
/* 58:50 */     f.append(" order by bean.id asc");
/* 59:51 */     if (max != null) {
/* 60:52 */       f.setMaxResults(max.intValue());
/* 61:   */     }
/* 62:54 */     Session session = getSession();
/* 63:55 */     ScrollableResults articles = f.createQuery(getSession())
/* 64:56 */       .setCacheMode(CacheMode.IGNORE).scroll(ScrollMode.FORWARD_ONLY);
/* 65:57 */     int count = 0;
/* 66:58 */     Article doc = null;
/* 67:59 */     while (articles.next())
/* 68:   */     {
/* 69:60 */       doc = (Article)articles.get(0);
/* 70:61 */       service.addDoc(LuceneCommon.createDoc(doc));
/* 71:62 */       count++;
/* 72:62 */       if (count % 20 == 0) {
/* 73:63 */         session.clear();
/* 74:   */       }
/* 75:   */     }
/* 76:66 */     if ((count < max.intValue()) || (doc == null)) {
/* 77:67 */       return null;
/* 78:   */     }
/* 79:69 */     return doc.getId();
/* 80:   */   }
/* 81:   */   
/* 82:   */   protected Class<Article> getEntityClass()
/* 83:   */   {
/* 84:74 */     return Article.class;
/* 85:   */   }
/* 86:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.lucene.LuceneDocDaoImpl
 * JD-Core Version:    0.7.0.1
 */