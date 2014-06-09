/*  1:   */ package com.portal.extrafunc.action.tag.base;
/*  2:   */ 
/*  3:   */ import com.portal.extrafunc.service.CommentService;
/*  4:   */ import com.portal.sysmgr.utils.TagModelTools;
/*  5:   */ import freemarker.template.TemplateDirectiveModel;
/*  6:   */ import freemarker.template.TemplateException;
/*  7:   */ import freemarker.template.TemplateModel;
/*  8:   */ import java.util.Map;
/*  9:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 10:   */ 
/* 11:   */ public abstract class BaseCommentTagModel
/* 12:   */   implements TemplateDirectiveModel
/* 13:   */ {
/* 14:   */   public static final String PARAM_SITE_ID = "siteId";
/* 15:   */   public static final String PARAM_DOC_ID = "docId";
/* 16:   */   public static final String PARAM_PARENT_ID = "parentId";
/* 17:   */   public static final String PARAM_ORDER_BY = "orderBy";
/* 18:   */   public static final String PARAM_IS_PAGE = "isPage";
/* 19:   */   @Autowired
/* 20:   */   protected CommentService commentService;
/* 21:   */   
/* 22:   */   protected Integer getSiteId(Map<String, TemplateModel> params)
/* 23:   */     throws TemplateException
/* 24:   */   {
/* 25:34 */     return TagModelTools.getInt("siteId", params);
/* 26:   */   }
/* 27:   */   
/* 28:   */   protected Integer getDocId(Map<String, TemplateModel> params)
/* 29:   */     throws TemplateException
/* 30:   */   {
/* 31:39 */     return TagModelTools.getInt("docId", params);
/* 32:   */   }
/* 33:   */   
/* 34:   */   protected Integer getParentId(Map<String, TemplateModel> params)
/* 35:   */     throws TemplateException
/* 36:   */   {
/* 37:44 */     return TagModelTools.getInt("parentId", params);
/* 38:   */   }
/* 39:   */   
/* 40:   */   protected int getOrderBy(Map<String, TemplateModel> params)
/* 41:   */     throws TemplateException
/* 42:   */   {
/* 43:49 */     Integer orderBy = TagModelTools.getInt("orderBy", params);
/* 44:50 */     if (orderBy != null) {
/* 45:51 */       return orderBy.intValue();
/* 46:   */     }
/* 47:53 */     return 0;
/* 48:   */   }
/* 49:   */   
/* 50:   */   protected boolean getIsPage(Map<String, TemplateModel> params)
/* 51:   */     throws TemplateException
/* 52:   */   {
/* 53:59 */     Integer isPage = TagModelTools.getInt("isPage", params);
/* 54:60 */     if ((isPage != null) && (isPage.equals(Integer.valueOf(0)))) {
/* 55:61 */       return false;
/* 56:   */     }
/* 57:63 */     return true;
/* 58:   */   }
/* 59:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.action.tag.base.BaseCommentTagModel
 * JD-Core Version:    0.7.0.1
 */