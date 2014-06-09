/*   1:    */ package com.portal.datacenter.docdata.service.impl;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.hibernate3.Updater;
/*   4:    */ import com.portal.datacenter.docdata.dao.KeywordDao;
/*   5:    */ import com.portal.datacenter.docdata.entity.Keyword;
/*   6:    */ import com.portal.datacenter.docdata.service.KeywordService;
/*   7:    */ import com.portal.sysmgr.entity.Site;
/*   8:    */ import java.util.List;
/*   9:    */ import org.apache.commons.lang.StringUtils;
/*  10:    */ import org.htmlparser.Node;
/*  11:    */ import org.htmlparser.lexer.Lexer;
/*  12:    */ import org.htmlparser.nodes.TextNode;
/*  13:    */ import org.htmlparser.util.ParserException;
/*  14:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  15:    */ import org.springframework.stereotype.Service;
/*  16:    */ import org.springframework.transaction.annotation.Transactional;
/*  17:    */ 
/*  18:    */ @Service
/*  19:    */ @Transactional
/*  20:    */ public class KeywordServiceImpl
/*  21:    */   implements KeywordService
/*  22:    */ {
/*  23:    */   private KeywordDao dao;
/*  24:    */   
/*  25:    */   @Transactional(readOnly=true)
/*  26:    */   public List<Keyword> getListBySiteId(Integer siteId, boolean enable, boolean cacheable, String sortname, String sortorder)
/*  27:    */   {
/*  28: 27 */     List<Keyword> list = this.dao.getList(siteId, enable, cacheable, sortname, 
/*  29: 28 */       sortorder);
/*  30: 29 */     return list;
/*  31:    */   }
/*  32:    */   
/*  33:    */   @Transactional(readOnly=true)
/*  34:    */   public String attachKeyword(Integer siteId, String txt)
/*  35:    */   {
/*  36: 34 */     if (StringUtils.isBlank(txt)) {
/*  37: 35 */       return txt;
/*  38:    */     }
/*  39: 37 */     List<Keyword> list = getListBySiteId(siteId, true, true, null, null);
/*  40: 38 */     int len = list.size();
/*  41: 39 */     if (len <= 0) {
/*  42: 40 */       return txt;
/*  43:    */     }
/*  44: 42 */     String[] searchArr = new String[len];
/*  45: 43 */     String[] replacementArr = new String[len];
/*  46: 44 */     int i = 0;
/*  47: 45 */     for (Keyword k : list)
/*  48:    */     {
/*  49: 46 */       searchArr[i] = k.getName();
/*  50: 47 */       String style = "";
/*  51: 48 */       if (k.getBold().booleanValue()) {
/*  52: 49 */         style = "font-weight:bold;";
/*  53:    */       }
/*  54: 51 */       if (k.getUnderline().booleanValue()) {
/*  55: 52 */         style = style + "text-decoration:underline;";
/*  56:    */       }
/*  57: 54 */       StringBuffer sb = new StringBuffer();
/*  58: 55 */       sb.append("<a href=\"");
/*  59: 56 */       sb.append(k.getUrl()).append("\" target=\"_blank\">");
/*  60: 57 */       if (!StringUtils.isBlank(style))
/*  61:    */       {
/*  62: 58 */         sb.append("<span style=\"");
/*  63: 59 */         sb.append(style).append("\">");
/*  64:    */       }
/*  65: 61 */       sb.append(searchArr[i]);
/*  66: 62 */       if (!StringUtils.isBlank(style)) {
/*  67: 63 */         sb.append("</span>");
/*  68:    */       }
/*  69: 65 */       sb.append("</a>");
/*  70: 66 */       replacementArr[i] = sb.toString();
/*  71: 67 */       i++;
/*  72:    */     }
/*  73:    */     try
/*  74:    */     {
/*  75: 70 */       Lexer lexer = new Lexer(txt);
/*  76:    */       
/*  77: 72 */       StringBuilder sb = new StringBuilder((int)(txt.length() * 1.2D));
/*  78:    */       Node node;
/*  79: 73 */       while ((node = lexer.nextNode()) != null)
/*  80:    */       {
/*  82: 74 */         if ((node instanceof TextNode)) {
/*  83: 75 */           sb.append(StringUtils.replaceEach(node.toHtml(), searchArr, 
/*  84: 76 */             replacementArr));
/*  85:    */         } else {
/*  86: 78 */           sb.append(node.toHtml());
/*  87:    */         }
/*  88:    */       }
/*  89: 81 */       return sb.toString();
/*  90:    */     }
/*  91:    */     catch (ParserException e)
/*  92:    */     {
/*  93: 83 */       throw new RuntimeException(e);
/*  94:    */     }
/*  95:    */   }
/*  96:    */   
/*  97:    */   @Transactional(readOnly=true)
/*  98:    */   public Keyword findById(Integer id)
/*  99:    */   {
/* 100: 89 */     Keyword entity = this.dao.findById(id);
/* 101: 90 */     return entity;
/* 102:    */   }
/* 103:    */   
/* 104:    */   public Keyword save(Keyword bean, Site site)
/* 105:    */   {
/* 106: 94 */     bean.setSite(site);
/* 107: 95 */     bean.init();
/* 108: 96 */     this.dao.save(bean);
/* 109: 97 */     return bean;
/* 110:    */   }
/* 111:    */   
/* 112:    */   public Keyword update(Keyword bean)
/* 113:    */   {
/* 114:101 */     Updater<Keyword> updater = new Updater(bean);
/* 115:102 */     bean = this.dao.updateByUpdater(updater);
/* 116:103 */     return bean;
/* 117:    */   }
/* 118:    */   
/* 119:    */   public Keyword deleteById(Integer id)
/* 120:    */   {
/* 121:107 */     Keyword bean = this.dao.deleteById(id);
/* 122:108 */     return bean;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public Keyword[] deleteByIds(Integer[] ids)
/* 126:    */   {
/* 127:112 */     Keyword[] beans = new Keyword[ids.length];
/* 128:113 */     int i = 0;
/* 129:113 */     for (int len = ids.length; i < len; i++) {
/* 130:114 */       beans[i] = deleteById(ids[i]);
/* 131:    */     }
/* 132:116 */     return beans;
/* 133:    */   }
/* 134:    */   
/* 135:    */   @Autowired
/* 136:    */   public void setDao(KeywordDao dao)
/* 137:    */   {
/* 138:123 */     this.dao = dao;
/* 139:    */   }
/* 140:    */ }



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.portal.datacenter.docdata.service.impl.KeywordServiceImpl

 * JD-Core Version:    0.7.0.1

 */