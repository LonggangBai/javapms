/*  1:   */ package com.portal.recruitcenter.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.recruitcenter.dao.PersonalInfoExtDao;
/*  6:   */ import com.portal.recruitcenter.entity.PersonalInfo;
/*  7:   */ import com.portal.recruitcenter.entity.PersonalInfoExt;
/*  8:   */ import com.portal.recruitcenter.service.PersonalInfoExtService;
/*  9:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 10:   */ import org.springframework.stereotype.Service;
/* 11:   */ import org.springframework.transaction.annotation.Transactional;
/* 12:   */ 
/* 13:   */ @Service
/* 14:   */ @Transactional
/* 15:   */ public class PersonalInfoExtServiceImpl
/* 16:   */   implements PersonalInfoExtService
/* 17:   */ {
/* 18:   */   private PersonalInfoExtDao dao;
/* 19:   */   
/* 20:   */   @Transactional(readOnly=true)
/* 21:   */   public Pagination getPage(int pageNo, int pageSize)
/* 22:   */   {
/* 23:19 */     Pagination page = this.dao.getPage(pageNo, pageSize);
/* 24:20 */     return page;
/* 25:   */   }
/* 26:   */   
/* 27:   */   @Transactional(readOnly=true)
/* 28:   */   public PersonalInfoExt findById(Integer id)
/* 29:   */   {
/* 30:25 */     PersonalInfoExt entity = this.dao.findById(id);
/* 31:26 */     return entity;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public PersonalInfoExt save(PersonalInfoExt bean, PersonalInfo info)
/* 35:   */   {
/* 36:30 */     bean.setInfo(info);
/* 37:31 */     this.dao.save(bean);
/* 38:32 */     info.setExt(bean);
/* 39:33 */     return bean;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public PersonalInfoExt update(PersonalInfoExt bean, PersonalInfo info)
/* 43:   */   {
/* 44:37 */     PersonalInfoExt ext = this.dao.findById(info.getId());
/* 45:38 */     if (ext == null)
/* 46:   */     {
/* 47:39 */       ext = save(bean, info);
/* 48:40 */       return ext;
/* 49:   */     }
/* 50:42 */     Updater<PersonalInfoExt> updater = new Updater(
/* 51:43 */       bean);
/* 52:44 */     ext = this.dao.updateByUpdater(updater);
/* 53:45 */     return bean;
/* 54:   */   }
/* 55:   */   
/* 56:   */   public PersonalInfoExt deleteById(Integer id)
/* 57:   */   {
/* 58:50 */     PersonalInfoExt bean = this.dao.deleteById(id);
/* 59:51 */     return bean;
/* 60:   */   }
/* 61:   */   
/* 62:   */   public PersonalInfoExt[] deleteByIds(Integer[] ids)
/* 63:   */   {
/* 64:55 */     PersonalInfoExt[] beans = new PersonalInfoExt[ids.length];
/* 65:56 */     int i = 0;
/* 66:56 */     for (int len = ids.length; i < len; i++) {
/* 67:57 */       beans[i] = deleteById(ids[i]);
/* 68:   */     }
/* 69:59 */     return beans;
/* 70:   */   }
/* 71:   */   
/* 72:   */   @Autowired
/* 73:   */   public void setDao(PersonalInfoExtDao dao)
/* 74:   */   {
/* 75:66 */     this.dao = dao;
/* 76:   */   }
/* 77:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.service.impl.PersonalInfoExtServiceImpl
 * JD-Core Version:    0.7.0.1
 */