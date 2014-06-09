/*  1:   */ package com.portal.recruitcenter.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.recruitcenter.dao.ResumeExtDao;
/*  6:   */ import com.portal.recruitcenter.entity.Resume;
/*  7:   */ import com.portal.recruitcenter.entity.ResumeExt;
/*  8:   */ import com.portal.recruitcenter.service.ResumeExtService;
/*  9:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 10:   */ import org.springframework.stereotype.Service;
/* 11:   */ import org.springframework.transaction.annotation.Transactional;
/* 12:   */ 
/* 13:   */ @Service
/* 14:   */ @Transactional
/* 15:   */ public class ResumeExtServiceImpl
/* 16:   */   implements ResumeExtService
/* 17:   */ {
/* 18:   */   private ResumeExtDao dao;
/* 19:   */   
/* 20:   */   @Transactional(readOnly=true)
/* 21:   */   public Pagination getPage(int pageNo, int pageSize)
/* 22:   */   {
/* 23:19 */     Pagination page = this.dao.getPage(pageNo, pageSize);
/* 24:20 */     return page;
/* 25:   */   }
/* 26:   */   
/* 27:   */   @Transactional(readOnly=true)
/* 28:   */   public ResumeExt findById(Integer id)
/* 29:   */   {
/* 30:25 */     ResumeExt entity = this.dao.findById(id);
/* 31:26 */     return entity;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public ResumeExt save(ResumeExt bean, Resume resume)
/* 35:   */   {
/* 36:30 */     bean.setResume(resume);
/* 37:31 */     this.dao.save(bean);
/* 38:32 */     resume.setExt(bean);
/* 39:33 */     return bean;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public ResumeExt update(ResumeExt bean, Resume resume)
/* 43:   */   {
/* 44:37 */     ResumeExt ext = this.dao.findById(resume.getId());
/* 45:38 */     if (ext == null)
/* 46:   */     {
/* 47:39 */       ext = save(bean, resume);
/* 48:40 */       return ext;
/* 49:   */     }
/* 50:42 */     Updater<ResumeExt> updater = new Updater(bean);
/* 51:43 */     ext = this.dao.updateByUpdater(updater);
/* 52:44 */     return bean;
/* 53:   */   }
/* 54:   */   
/* 55:   */   public int deleteByPersonalId(Integer personalId)
/* 56:   */   {
/* 57:49 */     return this.dao.deleteByPersonalId(personalId);
/* 58:   */   }
/* 59:   */   
/* 60:   */   public ResumeExt deleteById(Integer id)
/* 61:   */   {
/* 62:53 */     ResumeExt bean = this.dao.deleteById(id);
/* 63:54 */     return bean;
/* 64:   */   }
/* 65:   */   
/* 66:   */   public ResumeExt[] deleteByIds(Integer[] ids)
/* 67:   */   {
/* 68:58 */     ResumeExt[] beans = new ResumeExt[ids.length];
/* 69:59 */     int i = 0;
/* 70:59 */     for (int len = ids.length; i < len; i++) {
/* 71:60 */       beans[i] = deleteById(ids[i]);
/* 72:   */     }
/* 73:62 */     return beans;
/* 74:   */   }
/* 75:   */   
/* 76:   */   @Autowired
/* 77:   */   public void setDao(ResumeExtDao dao)
/* 78:   */   {
/* 79:69 */     this.dao = dao;
/* 80:   */   }
/* 81:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.service.impl.ResumeExtServiceImpl
 * JD-Core Version:    0.7.0.1
 */