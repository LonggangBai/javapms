/*  1:   */ package com.portal.doccenter.dao.impl;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.hibernate3.HibernateBaseDao;
/*  4:   */ import com.portal.doccenter.dao.ChannelExtDao;
/*  5:   */ import com.portal.doccenter.entity.ChannelExt;
/*  6:   */ import org.hibernate.Session;
/*  7:   */ import org.springframework.stereotype.Repository;
/*  8:   */ 
/*  9:   */ @Repository
/* 10:   */ public class ChannelExtDaoImpl
/* 11:   */   extends HibernateBaseDao<ChannelExt, Integer>
/* 12:   */   implements ChannelExtDao
/* 13:   */ {
/* 14:   */   public ChannelExt save(ChannelExt bean)
/* 15:   */   {
/* 16:13 */     getSession().save(bean);
/* 17:14 */     return bean;
/* 18:   */   }
/* 19:   */   
/* 20:   */   protected Class<ChannelExt> getEntityClass()
/* 21:   */   {
/* 22:19 */     return ChannelExt.class;
/* 23:   */   }
/* 24:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.dao.impl.ChannelExtDaoImpl
 * JD-Core Version:    0.7.0.1
 */