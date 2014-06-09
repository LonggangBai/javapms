/*  1:   */ package com.portal.doccenter.entity;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.comparator.BeanInterface;
/*  4:   */ import com.portal.doccenter.entity.base.BaseChnlTplSelection;
/*  5:   */ import java.util.Collection;
/*  6:   */ 
/*  7:   */ public class ChnlTplSelection
/*  8:   */   extends BaseChnlTplSelection
/*  9:   */   implements BeanInterface
/* 10:   */ {
/* 11:   */   private static final long serialVersionUID = 1L;
/* 12:   */   
/* 13:   */   public static Integer[] fetchIds(Collection<ChnlTplSelection> tpls)
/* 14:   */   {
/* 15:18 */     Integer[] ids = new Integer[tpls.size()];
/* 16:19 */     int i = 0;
/* 17:20 */     for (ChnlTplSelection g : tpls) {
/* 18:21 */       ids[(i++)] = g.getModelId();
/* 19:   */     }
/* 20:23 */     return ids;
/* 21:   */   }
/* 22:   */   
/* 23:   */   public Integer getModelId()
/* 24:   */   {
/* 25:27 */     return getModel().getId();
/* 26:   */   }
/* 27:   */   
/* 28:   */   public Integer getPriority()
/* 29:   */   {
/* 30:31 */     return getModel().getPriority();
/* 31:   */   }
/* 32:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.entity.ChnlTplSelection
 * JD-Core Version:    0.7.0.1
 */