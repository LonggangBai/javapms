/*  1:   */ package com.portal.recruitcenter.entity;
/*  2:   */ 
/*  3:   */ import com.portal.datacenter.commdata.entity.ForeignLang;
/*  4:   */ import com.portal.recruitcenter.entity.base.BaseLangAbility;
/*  5:   */ 
/*  6:   */ public class LangAbility
/*  7:   */   extends BaseLangAbility
/*  8:   */ {
/*  9:   */   private static final long serialVersionUID = 1L;
/* 10:   */   
/* 11:   */   public LangAbility() {}
/* 12:   */   
/* 13:   */   public LangAbility(Integer id)
/* 14:   */   {
/* 15:19 */     super(id);
/* 16:   */   }
/* 17:   */   
/* 18:   */   public LangAbility(Integer id, Resume resume, ForeignLang lang)
/* 19:   */   {
/* 20:33 */     super(id, resume, lang);
/* 21:   */   }
/* 22:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.entity.LangAbility
 * JD-Core Version:    0.7.0.1
 */