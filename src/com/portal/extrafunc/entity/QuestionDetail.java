/*  1:   */ package com.portal.extrafunc.entity;
/*  2:   */ 
/*  3:   */ import com.portal.extrafunc.entity.base.BaseQuestionDetail;
/*  4:   */ import java.sql.Timestamp;
/*  5:   */ import java.util.Date;
/*  6:   */ 
/*  7:   */ public class QuestionDetail
/*  8:   */   extends BaseQuestionDetail
/*  9:   */ {
/* 10:   */   private static final long serialVersionUID = 1L;
/* 11:   */   
/* 12:   */   public void init()
/* 13:   */   {
/* 14:11 */     if (getCreateTime() == null) {
/* 15:12 */       setCreateTime(new Timestamp(System.currentTimeMillis()));
/* 16:   */     }
/* 17:   */   }
/* 18:   */   
/* 19:   */   public QuestionDetail() {}
/* 20:   */   
/* 21:   */   public QuestionDetail(Integer id)
/* 22:   */   {
/* 23:25 */     super(id);
/* 24:   */   }
/* 25:   */   
/* 26:   */   public QuestionDetail(Integer id, Questionnaire question, String ip, Date createTime)
/* 27:   */   {
/* 28:35 */     super(id, question, ip, createTime);
/* 29:   */   }
/* 30:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.entity.QuestionDetail
 * JD-Core Version:    0.7.0.1
 */