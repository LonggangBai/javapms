/*  1:   */ package com.portal.doccenter.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.portal.doccenter.dao.ChannelTxtDao;
/*  5:   */ import com.portal.doccenter.entity.ChannelTxt;
/*  6:   */ import org.hibernate.Session;
/*  7:   */ import org.springframework.stereotype.Repository;
/*  8:   */ 
/*  9:   */ @Repository
/* 10:   */ public class ChannelTxtDaoImpl
/* 11:   */   extends HibernateBaseDao<ChannelTxt, Integer>
/* 12:   */   implements ChannelTxtDao
/* 13:   */ {
/* 14:   */   public ChannelTxt findById(Integer id)
/* 15:   */   {
/* 16:13 */     ChannelTxt entity = (ChannelTxt)get(id);
/* 17:14 */     return entity;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public ChannelTxt save(ChannelTxt bean)
/* 21:   */   {
/* 22:18 */     getSession().save(bean);
/* 23:19 */     return bean;
/* 24:   */   }
/* 25:   */   
/* 26:   */   protected Class<ChannelTxt> getEntityClass()
/* 27:   */   {
/* 28:24 */     return ChannelTxt.class;
/* 29:   */   }
/* 30:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.dao.impl.ChannelTxtDaoImpl
 * JD-Core Version:    0.7.0.1
 */