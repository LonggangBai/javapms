/*  1:   */ package com.portal.doccenter.action.tag.base;
/*  2:   */ 
/*  3:   */ import com.portal.sysmgr.utils.TagModelTools;
/*  4:   */ import freemarker.template.TemplateDirectiveModel;
/*  5:   */ import freemarker.template.TemplateException;
/*  6:   */ import freemarker.template.TemplateModel;
/*  7:   */ import java.util.Date;
/*  8:   */ import java.util.Map;
/*  9:   */ 
/* 10:   */ public abstract class BaseSearchTagModel
/* 11:   */   implements TemplateDirectiveModel
/* 12:   */ {
/* 13:   */   public static final String PARAM_QUERY = "q";
/* 14:   */   public static final String PARAM_MODEL_ID = "mId";
/* 15:   */   public static final String PARAM_CHANNEL_ID = "cId";
/* 16:   */   public static final String PARAM_START_DATE = "startDate";
/* 17:   */   public static final String PARAM_END_DATE = "endDate";
/* 18:   */   
/* 19:   */   protected String getQuery(Map<String, TemplateModel> params)
/* 20:   */     throws TemplateException
/* 21:   */   {
/* 22:36 */     return TagModelTools.getString("q", params);
/* 23:   */   }
/* 24:   */   
/* 25:   */   protected Integer getModelId(Map<String, TemplateModel> params)
/* 26:   */     throws TemplateException
/* 27:   */   {
/* 28:41 */     return TagModelTools.getInt("mId", params);
/* 29:   */   }
/* 30:   */   
/* 31:   */   protected Integer getChannelId(Map<String, TemplateModel> params)
/* 32:   */     throws TemplateException
/* 33:   */   {
/* 34:46 */     return TagModelTools.getInt("cId", params);
/* 35:   */   }
/* 36:   */   
/* 37:   */   protected Date getStartDate(Map<String, TemplateModel> params)
/* 38:   */     throws TemplateException
/* 39:   */   {
/* 40:51 */     return TagModelTools.getDate("startDate", params);
/* 41:   */   }
/* 42:   */   
/* 43:   */   protected Date getEndDate(Map<String, TemplateModel> params)
/* 44:   */     throws TemplateException
/* 45:   */   {
/* 46:56 */     return TagModelTools.getDate("endDate", params);
/* 47:   */   }
/* 48:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.action.tag.base.BaseSearchTagModel
 * JD-Core Version:    0.7.0.1
 */