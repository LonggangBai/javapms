/*  1:   */ package com.portal.datacenter.docdata.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.datacenter.docdata.dao.ProgramDownloadDao;
/*  6:   */ import com.portal.datacenter.docdata.entity.ProgramDownload;
/*  7:   */ import com.portal.datacenter.docdata.service.ProgramDownloadService;
/*  8:   */ import org.springframework.beans.factory.annotation.Autowired;
/*  9:   */ import org.springframework.stereotype.Service;
/* 10:   */ import org.springframework.transaction.annotation.Transactional;
/* 11:   */ 
/* 12:   */ @Service
/* 13:   */ @Transactional
/* 14:   */ public class ProgramDownloadServiceImpl
/* 15:   */   implements ProgramDownloadService
/* 16:   */ {
/* 17:   */   private ProgramDownloadDao dao;
/* 18:   */   
/* 19:   */   @Transactional(readOnly=true)
/* 20:   */   public Pagination getPage(int pageNo, int pageSize)
/* 21:   */   {
/* 22:18 */     Pagination page = this.dao.getPage(pageNo, pageSize);
/* 23:19 */     return page;
/* 24:   */   }
/* 25:   */   
/* 26:   */   @Transactional(readOnly=true)
/* 27:   */   public ProgramDownload findUnique()
/* 28:   */   {
/* 29:24 */     return this.dao.findUnique();
/* 30:   */   }
/* 31:   */   
/* 32:   */   @Transactional(readOnly=true)
/* 33:   */   public ProgramDownload findById(Integer id)
/* 34:   */   {
/* 35:29 */     ProgramDownload entity = this.dao.findById(id);
/* 36:30 */     return entity;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public ProgramDownload save()
/* 40:   */   {
/* 41:34 */     ProgramDownload bean = new ProgramDownload();
/* 42:35 */     bean.setCount(Integer.valueOf(1));
/* 43:36 */     this.dao.save(bean);
/* 44:37 */     return bean;
/* 45:   */   }
/* 46:   */   
/* 47:   */   public ProgramDownload updateCount()
/* 48:   */   {
/* 49:41 */     ProgramDownload pd = findUnique();
/* 50:42 */     if (pd != null) {
/* 51:43 */       pd.setCount(Integer.valueOf(pd.getCount().intValue() + 1));
/* 52:   */     } else {
/* 53:45 */       pd = save();
/* 54:   */     }
/* 55:47 */     return pd;
/* 56:   */   }
/* 57:   */   
/* 58:   */   public ProgramDownload update(ProgramDownload bean)
/* 59:   */   {
/* 60:51 */     Updater<ProgramDownload> updater = new Updater(bean);
/* 61:52 */     bean = this.dao.updateByUpdater(updater);
/* 62:53 */     return bean;
/* 63:   */   }
/* 64:   */   
/* 65:   */   public ProgramDownload deleteById(Integer id)
/* 66:   */   {
/* 67:57 */     ProgramDownload bean = this.dao.deleteById(id);
/* 68:58 */     return bean;
/* 69:   */   }
/* 70:   */   
/* 71:   */   public ProgramDownload[] deleteByIds(Integer[] ids)
/* 72:   */   {
/* 73:62 */     ProgramDownload[] beans = new ProgramDownload[ids.length];
/* 74:63 */     int i = 0;
/* 75:63 */     for (int len = ids.length; i < len; i++) {
/* 76:64 */       beans[i] = deleteById(ids[i]);
/* 77:   */     }
/* 78:66 */     return beans;
/* 79:   */   }
/* 80:   */   
/* 81:   */   @Autowired
/* 82:   */   public void setDao(ProgramDownloadDao dao)
/* 83:   */   {
/* 84:73 */     this.dao = dao;
/* 85:   */   }
/* 86:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.docdata.service.impl.ProgramDownloadServiceImpl
 * JD-Core Version:    0.7.0.1
 */