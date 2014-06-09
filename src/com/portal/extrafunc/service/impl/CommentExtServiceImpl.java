/*  1:   */ package com.portal.extrafunc.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.portal.extrafunc.dao.CommentExtDao;
/*  5:   */ import com.portal.extrafunc.entity.Comment;
/*  6:   */ import com.portal.extrafunc.entity.CommentExt;
/*  7:   */ import com.portal.extrafunc.service.CommentExtService;
/*  8:   */ import org.springframework.beans.factory.annotation.Autowired;
/*  9:   */ import org.springframework.stereotype.Service;
/* 10:   */ import org.springframework.transaction.annotation.Transactional;
/* 11:   */ 
/* 12:   */ @Service
/* 13:   */ @Transactional
/* 14:   */ public class CommentExtServiceImpl
/* 15:   */   implements CommentExtService
/* 16:   */ {
/* 17:   */   private CommentExtDao dao;
/* 18:   */   
/* 19:   */   public CommentExt save(String ip, String content, Comment comment)
/* 20:   */   {
/* 21:17 */     CommentExt ext = new CommentExt();
/* 22:18 */     ext.setContent(content);
/* 23:19 */     ext.setIp(ip);
/* 24:20 */     ext.setComment(comment);
/* 25:21 */     comment.setCommentExt(ext);
/* 26:22 */     this.dao.save(ext);
/* 27:23 */     return ext;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public CommentExt update(CommentExt bean)
/* 31:   */   {
/* 32:27 */     Updater<CommentExt> updater = new Updater(bean);
/* 33:28 */     bean = this.dao.updateByUpdater(updater);
/* 34:29 */     return bean;
/* 35:   */   }
/* 36:   */   
/* 37:   */   public int deleteByDocId(Integer docId)
/* 38:   */   {
/* 39:33 */     return this.dao.deleteByDocId(docId);
/* 40:   */   }
/* 41:   */   
/* 42:   */   @Autowired
/* 43:   */   public void setDao(CommentExtDao dao)
/* 44:   */   {
/* 45:40 */     this.dao = dao;
/* 46:   */   }
/* 47:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.impl.CommentExtServiceImpl
 * JD-Core Version:    0.7.0.1
 */