/*  1:   */ package com.portal.extrafunc.action.tag;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.page.Pagination;
/*  4:   */ import com.portal.extrafunc.service.SurveyDetailService;
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
/* 18:   */ public class SurveyDetailTagModel
/* 19:   */   implements TemplateDirectiveModel
/* 20:   */ {
/* 21:   */   public static final String PARAM_SURVEY_ID = "sId";
/* 22:   */   @Autowired
/* 23:   */   private SurveyDetailService service;
/* 24:   */   
/* 25:   */   public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
/* 26:   */     throws TemplateException, IOException
/* 27:   */   {
/* 28:36 */     Integer sId = TagModelTools.getInt("sId", params);
/* 29:37 */     Map<String, TemplateModel> paramWrap = new HashMap(
/* 30:38 */       params);
/* 31:39 */     Pagination page = this.service.getPage(sId, ViewTools.getPageNo(env), 
/* 32:40 */       ViewTools.getCount(params));
/* 33:41 */     paramWrap.put("page", ObjectWrapper.DEFAULT_WRAPPER.wrap(page));
/* 34:42 */     Map<String, TemplateModel> origMap = TagModelTools.addParamsToVariable(
/* 35:43 */       env, paramWrap);
/* 36:44 */     body.render(env.getOut());
/* 37:45 */     TagModelTools.removeParamsFromVariable(env, paramWrap, origMap);
/* 38:   */   }
/* 39:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.action.tag.SurveyDetailTagModel
 * JD-Core Version:    0.7.0.1
 */