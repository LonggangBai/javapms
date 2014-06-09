/*  1:   */ package com.portal.recruitcenter.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.recruitcenter.dao.CompanyInfoExtDao;
/*  6:   */ import com.portal.recruitcenter.entity.CompanyInfo;
/*  7:   */ import com.portal.recruitcenter.entity.CompanyInfoExt;
/*  8:   */ import com.portal.recruitcenter.service.CompanyInfoExtService;
/*  9:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 10:   */ import org.springframework.stereotype.Service;
/* 11:   */ import org.springframework.transaction.annotation.Transactional;
/* 12:   */ 
/* 13:   */ @Service
/* 14:   */ @Transactional
/* 15:   */ public class CompanyInfoExtServiceImpl
/* 16:   */   implements CompanyInfoExtService
/* 17:   */ {
/* 18:   */   private CompanyInfoExtDao dao;
/* 19:   */   
/* 20:   */   @Transactional(readOnly=true)
/* 21:   */   public Pagination getPage(int pageNo, int pageSize)
/* 22:   */   {
/* 23:19 */     Pagination page = this.dao.getPage(pageNo, pageSize);
/* 24:20 */     return page;
/* 25:   */   }
/* 26:   */   
/* 27:   */   @Transactional(readOnly=true)
/* 28:   */   public CompanyInfoExt findById(Integer id)
/* 29:   */   {
/* 30:25 */     CompanyInfoExt entity = this.dao.findById(id);
/* 31:26 */     return entity;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public CompanyInfoExt save(CompanyInfoExt bean, CompanyInfo info)
/* 35:   */   {
/* 36:30 */     bean.setInfo(info);
/* 37:31 */     bean.init();
/* 38:32 */     this.dao.save(bean);
/* 39:33 */     info.setExt(bean);
/* 40:34 */     return bean;
/* 41:   */   }
/* 42:   */   
/* 43:   */   public CompanyInfoExt update(CompanyInfoExt bean, CompanyInfo info)
/* 44:   */   {
/* 45:38 */     CompanyInfoExt ext = this.dao.findById(info.getId());
/* 46:39 */     if (ext == null)
/* 47:   */     {
/* 48:40 */       ext = save(bean, info);
/* 49:41 */       return ext;
/* 50:   */     }
/* 51:43 */     Updater<CompanyInfoExt> updater = new Updater(bean);
/* 52:44 */     ext = this.dao.updateByUpdater(updater);
/* 53:45 */     return ext;
/* 54:   */   }
/* 55:   */   
/* 56:   */   public CompanyInfoExt deleteById(Integer id)
/* 57:   */   {
/* 58:50 */     CompanyInfoExt bean = this.dao.deleteById(id);
/* 59:51 */     return bean;
/* 60:   */   }
/* 61:   */   
/* 62:   */   public CompanyInfoExt[] deleteByIds(Integer[] ids)
/* 63:   */   {
/* 64:55 */     CompanyInfoExt[] beans = new CompanyInfoExt[ids.length];
/* 65:56 */     int i = 0;
/* 66:56 */     for (int len = ids.length; i < len; i++) {
/* 67:57 */       beans[i] = deleteById(ids[i]);
/* 68:   */     }
/* 69:59 */     return beans;
/* 70:   */   }
/* 71:   */   
/* 72:   */   @Autowired
/* 73:   */   public void setDao(CompanyInfoExtDao dao)
/* 74:   */   {
/* 75:66 */     this.dao = dao;
/* 76:   */   }
/* 77:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.service.impl.CompanyInfoExtServiceImpl
 * JD-Core Version:    0.7.0.1
 */