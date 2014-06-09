/*   1:    */ package com.portal.sysmgr.service.impl;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.hibernate3.Updater;
/*   4:    */ import com.portal.sysmgr.dao.SiteDao;
/*   5:    */ import com.portal.sysmgr.entity.Site;
/*   6:    */ import com.portal.sysmgr.service.ResourceService;
/*   7:    */ import com.portal.sysmgr.service.SiteService;
/*   8:    */ import com.portal.usermgr.entity.User;
/*   9:    */ import com.portal.usermgr.service.AdminCheckService;
/*  10:    */ import java.io.IOException;
/*  11:    */ import java.util.List;
/*  12:    */ import org.apache.commons.lang.StringUtils;
/*  13:    */ import org.slf4j.Logger;
/*  14:    */ import org.slf4j.LoggerFactory;
/*  15:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  16:    */ import org.springframework.stereotype.Service;
/*  17:    */ import org.springframework.transaction.annotation.Transactional;
/*  18:    */ 
/*  19:    */ @Service
/*  20:    */ @Transactional
/*  21:    */ public class SiteServiceImpl
/*  22:    */   implements SiteService
/*  23:    */ {
/*  24: 25 */   private static final Logger log = LoggerFactory.getLogger(SiteServiceImpl.class);
/*  25:    */   private AdminCheckService adminCheckService;
/*  26:    */   private ResourceService resourceService;
/*  27:    */   private SiteDao dao;
/*  28:    */   
/*  29:    */   @Transactional(readOnly=true)
/*  30:    */   public List<Site> getList()
/*  31:    */   {
/*  32: 29 */     return this.dao.getList(false);
/*  33:    */   }
/*  34:    */   
/*  35:    */   @Transactional(readOnly=true)
/*  36:    */   public List<Site> getListFromCache()
/*  37:    */   {
/*  38: 34 */     return this.dao.getList(true);
/*  39:    */   }
/*  40:    */   
/*  41:    */   @Transactional(readOnly=true)
/*  42:    */   public Site findByDomain(String domain, boolean cacheable)
/*  43:    */   {
/*  44: 39 */     return this.dao.findByDomain(domain, cacheable);
/*  45:    */   }
/*  46:    */   
/*  47:    */   @Transactional(readOnly=true)
/*  48:    */   public Site findById(Integer id)
/*  49:    */   {
/*  50: 44 */     Site entity = this.dao.findById(id);
/*  51: 45 */     return entity;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public Site save(Site currSite, User currUser, Site bean, Integer uploadFtpId)
/*  55:    */     throws IOException
/*  56:    */   {
/*  57: 50 */     bean.init();
/*  58: 51 */     this.dao.save(bean);
/*  59: 52 */     this.resourceService.copyTplAndRes(currSite, bean);
/*  60: 53 */     return bean;
/*  61:    */   }
/*  62:    */   
/*  63:    */   public Site update(Site bean)
/*  64:    */   {
/*  65: 57 */     Site entity = findById(bean.getId());
/*  66: 58 */     Updater<Site> updater = new Updater(bean);
/*  67: 59 */     entity = this.dao.updateByUpdater(updater);
/*  68: 60 */     if (bean.getPort() == null) {
/*  69: 61 */       entity.setPort(null);
/*  70:    */     }
/*  71: 63 */     if (StringUtils.isBlank(bean.getContextPath())) {
/*  72: 64 */       entity.setContextPath(null);
/*  73:    */     }
/*  74: 66 */     return entity;
/*  75:    */   }
/*  76:    */   
/*  77:    */   public void updateTplStyle(Integer siteId, String style)
/*  78:    */   {
/*  79: 70 */     Site site = findById(siteId);
/*  80: 71 */     site.setTplStyle(style);
/*  81:    */   }
/*  82:    */   
/*  83:    */   public Site deleteById(Integer id)
/*  84:    */   {
/*  85: 75 */     this.adminCheckService.deleteBySiteId(id);
/*  86: 76 */     Site bean = this.dao.deleteById(id);
/*  87:    */     try
/*  88:    */     {
/*  89: 78 */       this.resourceService.delTplAndRes(bean);
/*  90:    */     }
/*  91:    */     catch (IOException e)
/*  92:    */     {
/*  93: 80 */       log.error("delete Template and Resource fail!", e);
/*  94:    */     }
/*  95: 82 */     return bean;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public Site[] deleteByIds(Integer[] ids)
/*  99:    */   {
/* 100: 86 */     Site[] beans = new Site[ids.length];
/* 101: 87 */     int i = 0;
/* 102: 87 */     for (int len = ids.length; i < len; i++) {
/* 103: 88 */       beans[i] = deleteById(ids[i]);
/* 104:    */     }
/* 105: 90 */     return beans;
/* 106:    */   }
/* 107:    */   
/* 108:    */   @Autowired
/* 109:    */   public void setAdminCheckService(AdminCheckService adminCheckService)
/* 110:    */   {
/* 111: 99 */     this.adminCheckService = adminCheckService;
/* 112:    */   }
/* 113:    */   
/* 114:    */   @Autowired
/* 115:    */   public void setResourceService(ResourceService resourceService)
/* 116:    */   {
/* 117:104 */     this.resourceService = resourceService;
/* 118:    */   }
/* 119:    */   
/* 120:    */   @Autowired
/* 121:    */   public void setDao(SiteDao dao)
/* 122:    */   {
/* 123:109 */     this.dao = dao;
/* 124:    */   }
/* 125:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.sysmgr.service.impl.SiteServiceImpl
 * JD-Core Version:    0.7.0.1
 */