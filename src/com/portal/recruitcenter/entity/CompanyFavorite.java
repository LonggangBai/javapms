/*  1:   */ package com.portal.recruitcenter.entity;
/*  2:   */ 
/*  3:   */ import com.portal.recruitcenter.entity.base.BaseCompanyFavorite;
/*  4:   */ import java.util.Date;
/*  5:   */ 
/*  6:   */ public class CompanyFavorite
/*  7:   */   extends BaseCompanyFavorite
/*  8:   */ {
/*  9:   */   private static final long serialVersionUID = 1L;
/* 10:   */   
/* 11:   */   public PersonalInfo getPersonal()
/* 12:   */   {
/* 13:11 */     return getResume().getPersonal();
/* 14:   */   }
/* 15:   */   
/* 16:   */   public CompanyFavorite() {}
/* 17:   */   
/* 18:   */   public CompanyFavorite(Integer id)
/* 19:   */   {
/* 20:23 */     super(id);
/* 21:   */   }
/* 22:   */   
/* 23:   */   public CompanyFavorite(Integer id, Resume resume, CompanyInfo company, Date createTime)
/* 24:   */   {
/* 25:39 */     super(id, resume, company, createTime);
/* 26:   */   }
/* 27:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.entity.CompanyFavorite
 * JD-Core Version:    0.7.0.1
 */