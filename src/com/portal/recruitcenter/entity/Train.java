/*  1:   */ package com.portal.recruitcenter.entity;
/*  2:   */ 
/*  3:   */ import com.portal.recruitcenter.entity.base.BaseTrain;
/*  4:   */ import java.sql.Timestamp;
/*  5:   */ import java.util.Date;
/*  6:   */ 
/*  7:   */ public class Train
/*  8:   */   extends BaseTrain
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
/* 19:   */   public Train() {}
/* 20:   */   
/* 21:   */   public Train(Integer id)
/* 22:   */   {
/* 23:25 */     super(id);
/* 24:   */   }
/* 25:   */   
/* 26:   */   public Train(Integer id, Resume resume, String startTime, String endTime, String training, String trainCourse, String certName, Date createTime)
/* 27:   */   {
/* 28:38 */     super(id, resume, startTime, endTime, training, trainCourse, certName, createTime);
/* 29:   */   }
/* 30:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.entity.Train
 * JD-Core Version:    0.7.0.1
 */