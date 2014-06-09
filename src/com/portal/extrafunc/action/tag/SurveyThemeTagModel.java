/*  1:   */ package com.portal.extrafunc.action.tag;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.page.Pagination;
/*  4:   */ import com.portal.extrafunc.entity.SurveyTheme;
/*  5:   */ import com.portal.extrafunc.service.SurveyThemeService;
/*  6:   */ import com.portal.sysmgr.entity.Site;
/*  7:   */ import com.portal.sysmgr.utils.TagModelTools;
/*  8:   */ import com.portal.sysmgr.utils.ViewTools;
/*  9:   */ import freemarker.core.Environment;
/* 10:   */ import freemarker.template.ObjectWrapper;
/* 11:   */ import freemarker.template.TemplateDirectiveBody;
/* 12:   */ import freemarker.template.TemplateDirectiveModel;
/* 13:   */ import freemarker.template.TemplateException;
/* 14:   */ import freemarker.template.TemplateModel;
/* 15:   */ import java.io.IOException;
/* 16:   */ import java.util.HashMap;
/* 17:   */ import java.util.Map;
/* 18:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 19:   */ 
/* 20:   */ public class SurveyThemeTagModel
/* 21:   */   implements TemplateDirectiveModel
/* 22:   */ {
/* 23:   */   public static final String PARAM_QUESTION_ID = "qId";
/* 24:   */   public static final String PARAM_CUSTOM = "custom";
/* 25:   */   @Autowired
/* 26:   */   private SurveyThemeService service;
/* 27:   */   
/* 28:   */   public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
/* 29:   */     throws TemplateException, IOException
/* 30:   */   {
/* 31:40 */     Site site = ViewTools.getSite(env);
/* 32:41 */     Integer qId = TagModelTools.getInt("qId", params);
/* 33:42 */     Boolean custom = TagModelTools.getBool("custom", params);
/* 34:43 */     Map<String, TemplateModel> paramWrap = new HashMap(
/* 35:44 */       params);
/* 36:45 */     Pagination page = this.service.getPage(qId, ViewTools.getPageNo(env), 
/* 37:46 */       ViewTools.getCount(params));
/* 38:47 */     paramWrap.put("NORMAL", ObjectWrapper.DEFAULT_WRAPPER.wrap(SurveyTheme.NORMAL));
/* 39:48 */     paramWrap.put("WRITED", ObjectWrapper.DEFAULT_WRAPPER.wrap(SurveyTheme.WRITED));
/* 40:49 */     paramWrap.put("CHECKED", ObjectWrapper.DEFAULT_WRAPPER.wrap(SurveyTheme.CHECKED));
/* 41:50 */     paramWrap.put("SELECTED", ObjectWrapper.DEFAULT_WRAPPER.wrap(SurveyTheme.SELECTED));
/* 42:51 */     paramWrap.put("TEXT", ObjectWrapper.DEFAULT_WRAPPER.wrap(SurveyTheme.TEXT));
/* 43:52 */     paramWrap.put("ONLINE", ObjectWrapper.DEFAULT_WRAPPER.wrap(SurveyTheme.ONLINE));
/* 44:53 */     paramWrap.put("AREA", ObjectWrapper.DEFAULT_WRAPPER.wrap(SurveyTheme.AREA));
/* 45:54 */     paramWrap.put("page", ObjectWrapper.DEFAULT_WRAPPER.wrap(page));
/* 46:55 */     Map<String, TemplateModel> origMap = TagModelTools.addParamsToVariable(
/* 47:56 */       env, paramWrap);
/* 48:57 */     if ((custom != null) && (custom.booleanValue())) {
/* 49:58 */       body.render(env.getOut());
/* 50:   */     } else {
/* 51:60 */       ViewTools.includeTpl("surveyTheme", site, env);
/* 52:   */     }
/* 53:62 */     TagModelTools.removeParamsFromVariable(env, paramWrap, origMap);
/* 54:   */   }
/* 55:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.action.tag.SurveyThemeTagModel
 * JD-Core Version:    0.7.0.1
 */