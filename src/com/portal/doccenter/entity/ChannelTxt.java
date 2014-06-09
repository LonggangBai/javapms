/*  1:   */ package com.portal.doccenter.entity;
/*  2:   */ 
/*  3:   */ import com.portal.doccenter.entity.base.BaseChannelTxt;
/*  4:   */ import org.apache.commons.lang.StringUtils;
/*  5:   */ 
/*  6:   */ public class ChannelTxt
/*  7:   */   extends BaseChannelTxt
/*  8:   */ {
/*  9:   */   private static final long serialVersionUID = 1L;
/* 10:   */   
/* 11:   */   public void init()
/* 12:   */   {
/* 13:11 */     blankToNull();
/* 14:   */   }
/* 15:   */   
/* 16:   */   public void blankToNull()
/* 17:   */   {
/* 18:15 */     if (StringUtils.isBlank(getTxtval())) {
/* 19:16 */       setTxtval(null);
/* 20:   */     }
/* 21:   */   }
/* 22:   */   
/* 23:   */   public boolean isAllBlank()
/* 24:   */   {
/* 25:26 */     return StringUtils.isBlank(getTxtval());
/* 26:   */   }
/* 27:   */   
/* 28:   */   public ChannelTxt() {}
/* 29:   */   
/* 30:   */   public ChannelTxt(Integer id)
/* 31:   */   {
/* 32:38 */     super(id);
/* 33:   */   }
/* 34:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.entity.ChannelTxt
 * JD-Core Version:    0.7.0.1
 */