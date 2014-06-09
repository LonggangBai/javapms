/*   1:    */ package com.portal.extrafunc.service.impl;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.hibernate3.Updater;
/*   4:    */ import com.javapms.basic.page.Pagination;
/*   5:    */ import com.portal.datacenter.docdata.service.SensitivityService;
/*   6:    */ import com.portal.doccenter.entity.Article;
/*   7:    */ import com.portal.doccenter.entity.DocStatis;
/*   8:    */ import com.portal.doccenter.service.DocStatisService;
/*   9:    */ import com.portal.extrafunc.dao.CommentDao;
/*  10:    */ import com.portal.extrafunc.entity.Comment;
/*  11:    */ import com.portal.extrafunc.entity.CommentExt;
/*  12:    */ import com.portal.extrafunc.service.CommentExtService;
/*  13:    */ import com.portal.extrafunc.service.CommentService;
/*  14:    */ import com.portal.sysmgr.entity.Site;
/*  15:    */ import com.portal.usermgr.entity.User;
/*  16:    */ import java.sql.Timestamp;
/*  17:    */ import java.util.Set;
/*  18:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  19:    */ import org.springframework.stereotype.Service;
/*  20:    */ import org.springframework.transaction.annotation.Transactional;
/*  21:    */ 
/*  22:    */ @Service
/*  23:    */ @Transactional
/*  24:    */ public class CommentServiceImpl
/*  25:    */   implements CommentService
/*  26:    */ {
/*  27:    */   private SensitivityService sensitivityService;
/*  28:    */   private CommentExtService commentExtService;
/*  29:    */   private DocStatisService statisService;
/*  30:    */   private CommentDao dao;
/*  31:    */   
/*  32:    */   @Transactional(readOnly=true)
/*  33:    */   public Pagination getPage(Integer siteId, Integer docId, Integer parentId, Boolean checked, Boolean noparent, int orderBy, String sortname, String sortorder, int pageNo, int pageSize)
/*  34:    */   {
/*  35: 30 */     Pagination page = this.dao
/*  36: 31 */       .getPage(siteId, docId, parentId, checked, orderBy, sortname, 
/*  37: 32 */       sortorder, pageNo, pageSize, noparent, false);
/*  38: 33 */     return page;
/*  39:    */   }
/*  40:    */   
/*  41:    */   @Transactional(readOnly=true)
/*  42:    */   public Pagination getPageForTag(Integer siteId, Integer docId, Integer parentId, Boolean checked, Boolean noparent, int orderBy, int pageNo, int pageSize)
/*  43:    */   {
/*  44: 40 */     Pagination page = this.dao.getPage(siteId, docId, parentId, checked, 
/*  45: 41 */       orderBy, null, null, pageNo, pageSize, noparent, true);
/*  46: 42 */     return page;
/*  47:    */   }
/*  48:    */   
/*  49:    */   @Transactional(readOnly=true)
/*  50:    */   public Comment findById(Integer id)
/*  51:    */   {
/*  52: 47 */     Comment entity = this.dao.findById(id);
/*  53: 48 */     return entity;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public Comment comment(String content, String ip, Integer parentId, Article doc, User user, Site site)
/*  57:    */   {
/*  58: 53 */     Comment comment = new Comment();
/*  59: 54 */     comment.setDoc(doc);
/*  60: 55 */     comment.setSite(site);
/*  61: 56 */     comment.setUser(user);
/*  62: 57 */     if (parentId != null)
/*  63:    */     {
/*  64: 58 */       Comment parent = findById(parentId);
/*  65: 59 */       parent.addToChilds(comment);
/*  66: 60 */       parent.setLastTime(new Timestamp(System.currentTimeMillis()));
/*  67: 61 */       comment.setParent(parent);
/*  68:    */     }
/*  69: 63 */     comment.init();
/*  70: 64 */     this.dao.save(comment);
/*  71: 65 */     content = this.sensitivityService.replaceSensitivity(content);
/*  72: 66 */     this.commentExtService.save(ip, content, comment);
/*  73: 67 */     DocStatis statis = this.statisService.findById(doc.getId());
/*  74: 68 */     if (statis != null) {
/*  75: 69 */       statis.setCommentCount(Integer.valueOf(statis.getCommentCount().intValue() + 1));
/*  76:    */     } else {
/*  77: 71 */       this.statisService.save(doc);
/*  78:    */     }
/*  79: 73 */     return comment;
/*  80:    */   }
/*  81:    */   
/*  82:    */   public Comment update(Comment bean, CommentExt ext)
/*  83:    */   {
/*  84: 77 */     Updater<Comment> updater = new Updater(bean);
/*  85: 78 */     bean = this.dao.updateByUpdater(updater);
/*  86: 79 */     this.commentExtService.update(ext);
/*  87: 80 */     return bean;
/*  88:    */   }
/*  89:    */   
/*  90:    */   public Comment update(Comment bean)
/*  91:    */   {
/*  92: 84 */     Updater<Comment> updater = new Updater(bean);
/*  93: 85 */     bean = this.dao.updateByUpdater(updater);
/*  94: 86 */     return bean;
/*  95:    */   }
/*  96:    */   
/*  97:    */   public int deleteByDocId(Integer docId)
/*  98:    */   {
/*  99: 90 */     this.commentExtService.deleteByDocId(docId);
/* 100: 91 */     return this.dao.deleteByDocId(docId);
/* 101:    */   }
/* 102:    */   
/* 103:    */   public Comment checkById(Integer id)
/* 104:    */   {
/* 105: 95 */     Comment bean = findById(id);
/* 106: 96 */     if (bean.getChecked().booleanValue()) {
/* 107: 97 */       bean.setChecked(Boolean.valueOf(false));
/* 108:    */     } else {
/* 109: 99 */       bean.setChecked(Boolean.valueOf(true));
/* 110:    */     }
/* 111:101 */     return bean;
/* 112:    */   }
/* 113:    */   
/* 114:    */   public Comment[] checkByIds(Integer[] ids)
/* 115:    */   {
/* 116:105 */     Comment[] beans = new Comment[ids.length];
/* 117:106 */     int i = 0;
/* 118:106 */     for (int len = ids.length; i < len; i++) {
/* 119:107 */       beans[i] = checkById(ids[i]);
/* 120:    */     }
/* 121:109 */     return beans;
/* 122:    */   }
/* 123:    */   
/* 124:    */   public Comment deleteById(Integer id)
/* 125:    */   {
/* 126:113 */     Comment bean = this.dao.deleteById(id);
/* 127:114 */     if (bean.getParent() != null) {
/* 128:115 */       bean.getParent().getChild().remove(bean);
/* 129:    */     }
/* 130:117 */     DocStatis statis = this.statisService.findById(bean.getDoc().getId());
/* 131:118 */     if (statis != null) {
/* 132:119 */       if (statis.getCommentCount().intValue() > 0) {
/* 133:120 */         statis.setCommentCount(Integer.valueOf(statis.getCommentCount().intValue() - 1));
/* 134:    */       } else {
/* 135:122 */         statis.setCommentCount(Integer.valueOf(0));
/* 136:    */       }
/* 137:    */     }
/* 138:125 */     return bean;
/* 139:    */   }
/* 140:    */   
/* 141:    */   public Comment[] deleteByIds(Integer[] ids)
/* 142:    */   {
/* 143:129 */     Comment[] beans = new Comment[ids.length];
/* 144:130 */     int i = 0;
/* 145:130 */     for (int len = ids.length; i < len; i++) {
/* 146:131 */       beans[i] = deleteById(ids[i]);
/* 147:    */     }
/* 148:133 */     return beans;
/* 149:    */   }
/* 150:    */   
/* 151:    */   public void ups(Integer id)
/* 152:    */   {
/* 153:137 */     Comment comment = findById(id);
/* 154:138 */     comment.setUps(Integer.valueOf(comment.getUps().intValue() + 1));
/* 155:    */   }
/* 156:    */   
/* 157:    */   public void ups(Integer id, Integer ups)
/* 158:    */   {
/* 159:142 */     Comment comment = findById(id);
/* 160:143 */     comment.setUps(ups);
/* 161:    */   }
/* 162:    */   
/* 163:    */   @Autowired
/* 164:    */   public void setSensitivityService(SensitivityService sensitivityService)
/* 165:    */   {
/* 166:153 */     this.sensitivityService = sensitivityService;
/* 167:    */   }
/* 168:    */   
/* 169:    */   @Autowired
/* 170:    */   public void setCommentExtService(CommentExtService commentExtService)
/* 171:    */   {
/* 172:158 */     this.commentExtService = commentExtService;
/* 173:    */   }
/* 174:    */   
/* 175:    */   @Autowired
/* 176:    */   public void setStatisService(DocStatisService statisService)
/* 177:    */   {
/* 178:163 */     this.statisService = statisService;
/* 179:    */   }
/* 180:    */   
/* 181:    */   @Autowired
/* 182:    */   public void setDao(CommentDao dao)
/* 183:    */   {
/* 184:168 */     this.dao = dao;
/* 185:    */   }
/* 186:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.impl.CommentServiceImpl
 * JD-Core Version:    0.7.0.1
 */