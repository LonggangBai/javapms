/*  1:   */ package com.portal.extrafunc.action.tag;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.page.Pagination;
/*  4:   */ import com.portal.extrafunc.service.ThemeService;
/*  5:   */ import com.portal.sysmgr.utils.TagModelTools;
/*  6:   */ import com.portal.sysmgr.utils.ViewTools;
/*  7:   */ import freemarker.core.Environment;
/*  8:   */ import freemarker.template.ObjectWrapper;
/*  9:   */ import freemarker.template.TemplateDirectiveBody;
/* 10:   */ import freemarker.template.TemplateDirectiveModel;
/* 11:   */ import freemarker.template.TemplateException;
/* 12:   */ import freemarker.template.TemplateModel;
/* 13:   */ import java.io.IOException;
/* 14:   */ import java.util.HashMap;
/* 15:   */ import java.util.Map;
/* 16:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 17:   */ 
/* 18:   */ public class ThemeTagModel
/* 19:   */   implements TemplateDirectiveModel
/* 20:   */ {
/* 21:   */   public static final String PARAM_FORUM_ID = "fId";
/* 22:   */   public static final String PARAM_STATUS = "status";
/* 23:   */   public static final String PARAM_CREATE_ID = "cId";
/* 24:   */   public static final String PARAM_REPLY_ID = "rId";
/* 25:   */   public static final String PARAM_ORDER_BY = "orderBy";
/* 26:   */   @Autowired
/* 27:   */   private ThemeService service;
/* 28:   */   
/* 29:   */   public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
/* 30:   */     throws TemplateException, IOException
/* 31:   */   {
/* 32:40 */     Integer fId = TagModelTools.getInt("fId", params);
/* 33:41 */     Integer status = TagModelTools.getInt("status", params);
/* 34:42 */     Integer cId = TagModelTools.getInt("cId", params);
/* 35:43 */     Integer rId = TagModelTools.getInt("rId", params);
/* 36:44 */     Integer orderBy = TagModelTools.getInt("orderBy", params);
/* 37:45 */     if (orderBy == null) {
/* 38:46 */       orderBy = Integer.valueOf(0);
/* 39:   */     }
/* 40:48 */     Pagination page = this.service.getThemePageForTag(fId, status, cId, rId, 
/* 41:49 */       orderBy.intValue(), ViewTools.getPageNo(env), ViewTools.getCount(params));
/* 42:50 */     Map<String, TemplateModel> paramWrap = new HashMap(
/* 43:51 */       params);
/* 44:52 */     paramWrap.put("page", ObjectWrapper.DEFAULT_WRAPPER.wrap(page));
/* 45:53 */     Map<String, TemplateModel> origMap = TagModelTools.addParamsToVariable(
/* 46:54 */       env, paramWrap);
/* 47:55 */     body.render(env.getOut());
/* 48:56 */     TagModelTools.removeParamsFromVariable(env, paramWrap, origMap);
/* 49:   */   }
/* 50:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.action.tag.ThemeTagModel
 * JD-Core Version:    0.7.0.1
 */