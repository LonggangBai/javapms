/*  1:   */ package com.portal.extrafunc.action.tag;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.page.Pagination;
/*  4:   */ import com.portal.extrafunc.service.QuestionnaireService;
/*  5:   */ import com.portal.sysmgr.entity.Site;
/*  6:   */ import com.portal.sysmgr.utils.TagModelTools;
/*  7:   */ import com.portal.sysmgr.utils.ViewTools;
/*  8:   */ import freemarker.core.Environment;
/*  9:   */ import freemarker.template.ObjectWrapper;
/* 10:   */ import freemarker.template.TemplateDirectiveBody;
/* 11:   */ import freemarker.template.TemplateDirectiveModel;
/* 12:   */ import freemarker.template.TemplateException;
/* 13:   */ import freemarker.template.TemplateModel;
/* 14:   */ import java.io.IOException;
/* 15:   */ import java.util.HashMap;
/* 16:   */ import java.util.Map;
/* 17:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 18:   */ 
/* 19:   */ public class QuestionnaireTagModel
/* 20:   */   implements TemplateDirectiveModel
/* 21:   */ {
/* 22:   */   public static final String PARAM_QUESTION_ID = "qId";
/* 23:   */   public static final String PARAM_CUSTOM = "custom";
/* 24:   */   @Autowired
/* 25:   */   private QuestionnaireService service;
/* 26:   */   
/* 27:   */   public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
/* 28:   */     throws TemplateException, IOException
/* 29:   */   {
/* 30:39 */     Site site = ViewTools.getSite(env);
/* 31:40 */     Boolean custom = TagModelTools.getBool("custom", params);
/* 32:41 */     Map<String, TemplateModel> paramWrap = new HashMap(
/* 33:42 */       params);
/* 34:43 */     Pagination page = this.service.getPage(site.getId(), true, 
/* 35:44 */       ViewTools.getPageNo(env), ViewTools.getCount(params));
/* 36:45 */     paramWrap.put("page", ObjectWrapper.DEFAULT_WRAPPER.wrap(page));
/* 37:46 */     Map<String, TemplateModel> origMap = TagModelTools.addParamsToVariable(
/* 38:47 */       env, paramWrap);
/* 39:48 */     if ((custom != null) && (custom.booleanValue())) {
/* 40:49 */       body.render(env.getOut());
/* 41:   */     } else {
/* 42:51 */       ViewTools.includeTpl("question", site, env);
/* 43:   */     }
/* 44:53 */     TagModelTools.removeParamsFromVariable(env, paramWrap, origMap);
/* 45:   */   }
/* 46:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.action.tag.QuestionnaireTagModel
 * JD-Core Version:    0.7.0.1
 */