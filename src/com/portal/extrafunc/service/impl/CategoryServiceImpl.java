/*  1:   */ package com.portal.extrafunc.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.extrafunc.dao.CategoryDao;
/*  6:   */ import com.portal.extrafunc.entity.Category;
/*  7:   */ import com.portal.extrafunc.service.CategoryService;
/*  8:   */ import com.portal.sysmgr.entity.Site;
/*  9:   */ import java.util.List;
/* 10:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 11:   */ import org.springframework.stereotype.Service;
/* 12:   */ import org.springframework.transaction.annotation.Transactional;
/* 13:   */ 
/* 14:   */ @Service
/* 15:   */ @Transactional
/* 16:   */ public class CategoryServiceImpl
/* 17:   */   implements CategoryService
/* 18:   */ {
/* 19:   */   private CategoryDao dao;
/* 20:   */   
/* 21:   */   @Transactional(readOnly=true)
/* 22:   */   public Pagination getPage(String sortname, String sortorder, int pageNo, int pageSize)
/* 23:   */   {
/* 24:22 */     Pagination page = this.dao.getPage(sortname, sortorder, pageNo, pageSize);
/* 25:23 */     return page;
/* 26:   */   }
/* 27:   */   
/* 28:   */   @Transactional(readOnly=true)
/* 29:   */   public List<Category> getList(Integer siteId, String sortname, String sortorder)
/* 30:   */   {
/* 31:29 */     return this.dao.getList(siteId, sortname, sortorder);
/* 32:   */   }
/* 33:   */   
/* 34:   */   @Transactional(readOnly=true)
/* 35:   */   public Category findById(Integer id)
/* 36:   */   {
/* 37:34 */     Category entity = this.dao.findById(id);
/* 38:35 */     return entity;
/* 39:   */   }
/* 40:   */   
/* 41:   */   public Category save(Category bean, Site site)
/* 42:   */   {
/* 43:39 */     bean.setSite(site);
/* 44:40 */     this.dao.save(bean);
/* 45:41 */     return bean;
/* 46:   */   }
/* 47:   */   
/* 48:   */   public Category update(Category bean)
/* 49:   */   {
/* 50:45 */     Updater<Category> updater = new Updater(bean);
/* 51:46 */     bean = this.dao.updateByUpdater(updater);
/* 52:47 */     return bean;
/* 53:   */   }
/* 54:   */   
/* 55:   */   public Category deleteById(Integer id)
/* 56:   */   {
/* 57:51 */     Category bean = this.dao.deleteById(id);
/* 58:52 */     return bean;
/* 59:   */   }
/* 60:   */   
/* 61:   */   public Category[] deleteByIds(Integer[] ids)
/* 62:   */   {
/* 63:56 */     Category[] beans = new Category[ids.length];
/* 64:57 */     int i = 0;
/* 65:57 */     for (int len = ids.length; i < len; i++) {
/* 66:58 */       beans[i] = deleteById(ids[i]);
/* 67:   */     }
/* 68:60 */     return beans;
/* 69:   */   }
/* 70:   */   
/* 71:   */   @Autowired
/* 72:   */   public void setDao(CategoryDao dao)
/* 73:   */   {
/* 74:67 */     this.dao = dao;
/* 75:   */   }
/* 76:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.impl.CategoryServiceImpl
 * JD-Core Version:    0.7.0.1
 */