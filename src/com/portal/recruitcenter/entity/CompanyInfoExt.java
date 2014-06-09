/*  1:   */ package com.portal.recruitcenter.entity;
/*  2:   */ 
/*  3:   */ import com.portal.recruitcenter.entity.base.BaseCompanyInfoExt;
/*  4:   */ 
/*  5:   */ public class CompanyInfoExt
/*  6:   */   extends BaseCompanyInfoExt
/*  7:   */ {
/*  8:   */   private static final long serialVersionUID = 1L;
/*  9:   */   
/* 10:   */   public void init()
/* 11:   */   {
/* 12: 9 */     if (getVip() == null) {
/* 13:10 */       setVip(Boolean.valueOf(false));
/* 14:   */     }
/* 15:12 */     if (getApplyVip() == null) {
/* 16:13 */       setApplyVip(Boolean.valueOf(false));
/* 17:   */     }
/* 18:15 */     if (getNeedLogin() == null) {
/* 19:16 */       setNeedLogin(Boolean.valueOf(false));
/* 20:   */     }
/* 21:   */   }
/* 22:   */   
/* 23:   */   public CompanyInfoExt() {}
/* 24:   */   
/* 25:   */   public CompanyInfoExt(Integer id)
/* 26:   */   {
/* 27:29 */     super(id);
/* 28:   */   }
/* 29:   */   
/* 30:   */   public CompanyInfoExt(Integer id, Boolean applyVip, Boolean needLogin, Boolean vip)
/* 31:   */   {
/* 32:38 */     super(id, applyVip, needLogin, vip);
/* 33:   */   }
/* 34:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.entity.CompanyInfoExt
 * JD-Core Version:    0.7.0.1
 */