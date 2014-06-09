/*  1:   */ package com.portal.recruitcenter.service.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.Updater;
/*  4:   */ import com.javapms.basic.page.Pagination;
/*  5:   */ import com.portal.datacenter.commdata.service.ForeignLangService;
/*  6:   */ import com.portal.recruitcenter.dao.LangAbilityDao;
/*  7:   */ import com.portal.recruitcenter.entity.LangAbility;
/*  8:   */ import com.portal.recruitcenter.service.LangAbilityService;
/*  9:   */ import com.portal.recruitcenter.service.ResumeService;
/* 10:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 11:   */ import org.springframework.stereotype.Service;
/* 12:   */ import org.springframework.transaction.annotation.Transactional;
/* 13:   */ 
/* 14:   */ @Service
/* 15:   */ @Transactional
/* 16:   */ public class LangAbilityServiceImpl
/* 17:   */   implements LangAbilityService
/* 18:   */ {
/* 19:   */   private LangAbilityDao dao;
/* 20:   */   private ResumeService resumeService;
/* 21:   */   private ForeignLangService foreignLangService;
/* 22:   */   
/* 23:   */   @Transactional(readOnly=true)
/* 24:   */   public Pagination getPage(Integer resuneId, int pageNo, int pageSize)
/* 25:   */   {
/* 26:20 */     Pagination page = this.dao.getPage(resuneId, pageNo, pageSize);
/* 27:21 */     return page;
/* 28:   */   }
/* 29:   */   
/* 30:   */   @Transactional(readOnly=true)
/* 31:   */   public LangAbility findById(Integer id)
/* 32:   */   {
/* 33:26 */     LangAbility entity = this.dao.findById(id);
/* 34:27 */     return entity;
/* 35:   */   }
/* 36:   */   
/* 37:   */   public LangAbility save(LangAbility bean, Integer resumeId, Integer langId)
/* 38:   */   {
/* 39:31 */     if (resumeId != null) {
/* 40:32 */       bean.setResume(this.resumeService.findById(resumeId));
/* 41:   */     }
/* 42:34 */     if (langId != null) {
/* 43:35 */       bean.setLang(this.foreignLangService.findById(langId));
/* 44:   */     }
/* 45:37 */     this.dao.save(bean);
/* 46:38 */     return bean;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public LangAbility update(LangAbility bean, Integer langId)
/* 50:   */   {
/* 51:42 */     Updater<LangAbility> updater = new Updater(bean);
/* 52:43 */     bean = this.dao.updateByUpdater(updater);
/* 53:44 */     if (langId != null) {
/* 54:45 */       bean.setLang(this.foreignLangService.findById(langId));
/* 55:   */     }
/* 56:47 */     return bean;
/* 57:   */   }
/* 58:   */   
/* 59:   */   public int deleteByPersonalId(Integer personalId)
/* 60:   */   {
/* 61:51 */     return this.dao.deleteByPersonalId(personalId);
/* 62:   */   }
/* 63:   */   
/* 64:   */   public int deleteByResumeId(Integer resumeId)
/* 65:   */   {
/* 66:55 */     return this.dao.deleteByResumeId(resumeId);
/* 67:   */   }
/* 68:   */   
/* 69:   */   public int deleteByLangId(Integer langId)
/* 70:   */   {
/* 71:59 */     return this.dao.deleteByLangId(langId);
/* 72:   */   }
/* 73:   */   
/* 74:   */   public LangAbility deleteById(Integer id)
/* 75:   */   {
/* 76:63 */     LangAbility bean = this.dao.deleteById(id);
/* 77:64 */     return bean;
/* 78:   */   }
/* 79:   */   
/* 80:   */   public LangAbility[] deleteByIds(Integer[] ids)
/* 81:   */   {
/* 82:68 */     LangAbility[] beans = new LangAbility[ids.length];
/* 83:69 */     int i = 0;
/* 84:69 */     for (int len = ids.length; i < len; i++) {
/* 85:70 */       beans[i] = deleteById(ids[i]);
/* 86:   */     }
/* 87:72 */     return beans;
/* 88:   */   }
/* 89:   */   
/* 90:   */   @Autowired
/* 91:   */   public void setDao(LangAbilityDao dao)
/* 92:   */   {
/* 93:81 */     this.dao = dao;
/* 94:   */   }
/* 95:   */   
/* 96:   */   @Autowired
/* 97:   */   public void setResumeService(ResumeService resumeService)
/* 98:   */   {
/* 99:86 */     this.resumeService = resumeService;
/* :0:   */   }
/* :1:   */   
/* :2:   */   @Autowired
/* :3:   */   public void setForeignLangService(ForeignLangService foreignLangService)
/* :4:   */   {
/* :5:91 */     this.foreignLangService = foreignLangService;
/* :6:   */   }
/* :7:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.service.impl.LangAbilityServiceImpl
 * JD-Core Version:    0.7.0.1
 */