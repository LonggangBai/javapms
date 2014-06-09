/*   1:    */ package com.portal.extrafunc.service.impl;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.hibernate3.Updater;
/*   4:    */ import com.javapms.basic.page.Pagination;
/*   5:    */ import com.portal.extrafunc.dao.AdvertDao;
/*   6:    */ import com.portal.extrafunc.entity.Advert;
/*   7:    */ import com.portal.extrafunc.service.AdvertService;
/*   8:    */ import com.portal.extrafunc.service.AdvertSlotService;
/*   9:    */ import com.portal.sysmgr.entity.Site;
/*  10:    */ import java.util.List;
/*  11:    */ import org.apache.commons.lang.StringUtils;
/*  12:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  13:    */ import org.springframework.stereotype.Service;
/*  14:    */ import org.springframework.transaction.annotation.Transactional;
/*  15:    */ 
/*  16:    */ @Service
/*  17:    */ @Transactional
/*  18:    */ public class AdvertServiceImpl
/*  19:    */   implements AdvertService
/*  20:    */ {
/*  21:    */   private AdvertDao dao;
/*  22:    */   private AdvertSlotService slotService;
/*  23:    */   
/*  24:    */   @Transactional(readOnly=true)
/*  25:    */   public Pagination getPage(Integer siteId, Integer slotId, String sortname, String sortorder, int pageNo, int pageSize)
/*  26:    */   {
/*  27: 24 */     Pagination page = this.dao.getPage(siteId, slotId, sortname, sortorder, 
/*  28: 25 */       pageNo, pageSize);
/*  29: 26 */     return page;
/*  30:    */   }
/*  31:    */   
/*  32:    */   @Transactional(readOnly=true)
/*  33:    */   public List<Advert> getListByTag(Integer siteId, Integer slotId)
/*  34:    */   {
/*  35: 31 */     return this.dao.getListByTag(siteId, slotId);
/*  36:    */   }
/*  37:    */   
/*  38:    */   @Transactional(readOnly=true)
/*  39:    */   public Advert findById(Integer id)
/*  40:    */   {
/*  41: 36 */     Advert entity = this.dao.findById(id);
/*  42: 37 */     return entity;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public Advert save(Advert bean, Integer slotId, boolean advtype, Site site)
/*  46:    */   {
/*  47: 41 */     if (slotId != null) {
/*  48: 42 */       bean.setSlot(this.slotService.findById(slotId));
/*  49:    */     }
/*  50: 44 */     if (advtype) {
/*  51: 45 */       bean.setAdvType("js");
/*  52: 47 */     } else if ((!StringUtils.isBlank(bean.getAttrUrl())) && 
/*  53: 48 */       (bean.getAttrUrl().indexOf("swf") > -1)) {
/*  54: 49 */       bean.setAdvType("flash");
/*  55:    */     } else {
/*  56: 51 */       bean.setAdvType("img");
/*  57:    */     }
/*  58: 54 */     bean.setSite(site);
/*  59: 55 */     bean.init();
/*  60: 56 */     this.dao.save(bean);
/*  61: 57 */     return bean;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public Advert update(Advert bean, Integer slotId, boolean advtype)
/*  65:    */   {
/*  66: 61 */     Updater<Advert> updater = new Updater(bean);
/*  67: 62 */     bean = this.dao.updateByUpdater(updater);
/*  68: 63 */     if (slotId != null) {
/*  69: 64 */       bean.setSlot(this.slotService.findById(slotId));
/*  70:    */     }
/*  71: 66 */     if (advtype) {
/*  72: 67 */       bean.setAdvType("js");
/*  73: 69 */     } else if ((!StringUtils.isBlank(bean.getAttrUrl())) && 
/*  74: 70 */       (bean.getAttrUrl().indexOf("swf") > -1)) {
/*  75: 71 */       bean.setAdvType("flash");
/*  76:    */     } else {
/*  77: 73 */       bean.setAdvType("img");
/*  78:    */     }
/*  79: 76 */     return bean;
/*  80:    */   }
/*  81:    */   
/*  82:    */   public Advert deleteById(Integer id)
/*  83:    */   {
/*  84: 80 */     Advert bean = this.dao.deleteById(id);
/*  85: 81 */     return bean;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public Advert[] deleteByIds(Integer[] ids)
/*  89:    */   {
/*  90: 85 */     Advert[] beans = new Advert[ids.length];
/*  91: 86 */     int i = 0;
/*  92: 86 */     for (int len = ids.length; i < len; i++) {
/*  93: 87 */       beans[i] = deleteById(ids[i]);
/*  94:    */     }
/*  95: 89 */     return beans;
/*  96:    */   }
/*  97:    */   
/*  98:    */   @Autowired
/*  99:    */   public void setDao(AdvertDao dao)
/* 100:    */   {
/* 101: 97 */     this.dao = dao;
/* 102:    */   }
/* 103:    */   
/* 104:    */   @Autowired
/* 105:    */   public void setSlotService(AdvertSlotService slotService)
/* 106:    */   {
/* 107:102 */     this.slotService = slotService;
/* 108:    */   }
/* 109:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.impl.AdvertServiceImpl
 * JD-Core Version:    0.7.0.1
 */