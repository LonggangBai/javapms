/*   1:    */ package com.portal.extrafunc.service.impl;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.hibernate3.Updater;
/*   4:    */ import com.javapms.basic.page.Pagination;
/*   5:    */ import com.portal.extrafunc.dao.ForumDao;
/*   6:    */ import com.portal.extrafunc.entity.Forum;
/*   7:    */ import com.portal.extrafunc.entity.ForumExt;
/*   8:    */ import com.portal.extrafunc.service.CategoryService;
/*   9:    */ import com.portal.extrafunc.service.ForumExtService;
/*  10:    */ import com.portal.extrafunc.service.ForumService;
/*  11:    */ import com.portal.sysmgr.entity.Site;
/*  12:    */ import java.util.List;
/*  13:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  14:    */ import org.springframework.stereotype.Service;
/*  15:    */ import org.springframework.transaction.annotation.Transactional;
/*  16:    */ 
/*  17:    */ @Service
/*  18:    */ @Transactional
/*  19:    */ public class ForumServiceImpl
/*  20:    */   implements ForumService
/*  21:    */ {
/*  22:    */   private ForumDao dao;
/*  23:    */   private CategoryService categoryService;
/*  24:    */   private ForumExtService extService;
/*  25:    */   
/*  26:    */   @Transactional(readOnly=true)
/*  27:    */   public Pagination getPage(Integer siteId, Integer categoryId, String sortname, String sortorder, int pageNo, int pageSize)
/*  28:    */   {
/*  29: 25 */     Pagination page = this.dao.getPage(siteId, categoryId, sortname, sortorder, 
/*  30: 26 */       pageNo, pageSize);
/*  31: 27 */     return page;
/*  32:    */   }
/*  33:    */   
/*  34:    */   @Transactional(readOnly=true)
/*  35:    */   public List<Forum> getList(Integer categoryId)
/*  36:    */   {
/*  37: 32 */     return this.dao.getList(categoryId);
/*  38:    */   }
/*  39:    */   
/*  40:    */   public List<Forum> getList()
/*  41:    */   {
/*  42: 36 */     return this.dao.getList();
/*  43:    */   }
/*  44:    */   
/*  45:    */   @Transactional(readOnly=true)
/*  46:    */   public Forum findById(Integer id)
/*  47:    */   {
/*  48: 41 */     Forum entity = this.dao.findById(id);
/*  49: 42 */     return entity;
/*  50:    */   }
/*  51:    */   
/*  52:    */   public Forum save(Forum bean, ForumExt ext, Site site, Integer categoryId)
/*  53:    */   {
/*  54: 46 */     bean.setSite(site);
/*  55: 47 */     bean.setCategory(this.categoryService.findById(categoryId));
/*  56: 48 */     bean.init();
/*  57: 49 */     this.dao.save(bean);
/*  58: 50 */     this.extService.save(ext, bean);
/*  59: 51 */     return bean;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public Forum updateForum(Forum forum)
/*  63:    */   {
/*  64: 55 */     Forum f = findById(forum.getId());
/*  65: 56 */     f.setThemeTotal(forum.getThemeTotal());
/*  66: 57 */     f.setReplyTotal(forum.getReplyTotal());
/*  67: 58 */     f.setThemeToday(forum.getThemeToday());
/*  68: 59 */     f.setReplyToday(forum.getReplyToday());
/*  69: 60 */     f.setLastTheme(forum.getLastTheme());
/*  70: 61 */     f.setLastReplyer(forum.getLastReplyer());
/*  71: 62 */     return f;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public Forum updateForumOnday(Forum forum)
/*  75:    */   {
/*  76: 66 */     Forum f = findById(forum.getId());
/*  77: 67 */     f.setThemeTotal(forum.getThemeTotal());
/*  78: 68 */     f.setReplyTotal(forum.getReplyTotal());
/*  79: 69 */     f.setThemeToday(Integer.valueOf(0));
/*  80: 70 */     f.setReplyToday(Integer.valueOf(0));
/*  81: 71 */     f.setLastTheme(forum.getLastTheme());
/*  82: 72 */     f.setLastReplyer(forum.getLastReplyer());
/*  83: 73 */     return f;
/*  84:    */   }
/*  85:    */   
/*  86:    */   public Forum update(Forum bean, ForumExt ext, Integer categoryId)
/*  87:    */   {
/*  88: 77 */     Updater<Forum> updater = new Updater(bean);
/*  89: 78 */     bean = this.dao.updateByUpdater(updater);
/*  90: 79 */     bean.setCategory(this.categoryService.findById(categoryId));
/*  91: 80 */     this.extService.update(ext, bean);
/*  92: 81 */     return bean;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public Forum deleteById(Integer id)
/*  96:    */   {
/*  97: 85 */     Forum bean = this.dao.deleteById(id);
/*  98: 86 */     return bean;
/*  99:    */   }
/* 100:    */   
/* 101:    */   public Forum[] deleteByIds(Integer[] ids)
/* 102:    */   {
/* 103: 90 */     Forum[] beans = new Forum[ids.length];
/* 104: 91 */     int i = 0;
/* 105: 91 */     for (int len = ids.length; i < len; i++) {
/* 106: 92 */       beans[i] = deleteById(ids[i]);
/* 107:    */     }
/* 108: 94 */     return beans;
/* 109:    */   }
/* 110:    */   
/* 111:    */   @Autowired
/* 112:    */   public void setDao(ForumDao dao)
/* 113:    */   {
/* 114:103 */     this.dao = dao;
/* 115:    */   }
/* 116:    */   
/* 117:    */   @Autowired
/* 118:    */   public void setCategoryService(CategoryService categoryService)
/* 119:    */   {
/* 120:108 */     this.categoryService = categoryService;
/* 121:    */   }
/* 122:    */   
/* 123:    */   @Autowired
/* 124:    */   public void setExtService(ForumExtService extService)
/* 125:    */   {
/* 126:113 */     this.extService = extService;
/* 127:    */   }
/* 128:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.impl.ForumServiceImpl
 * JD-Core Version:    0.7.0.1
 */