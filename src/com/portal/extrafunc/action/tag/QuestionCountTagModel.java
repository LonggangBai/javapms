/*  1:   */ package com.portal.extrafunc.action.tag;
/*  2:   */ 
/*  3:   */ import com.portal.extrafunc.service.QuestionDetailService;
/*  4:   */ import com.portal.sysmgr.utils.TagModelTools;
/*  5:   */ import freemarker.core.Environment;
/*  6:   */ import freemarker.template.ObjectWrapper;
/*  7:   */ import freemarker.template.TemplateDirectiveBody;
/*  8:   */ import freemarker.template.TemplateDirectiveModel;
/*  9:   */ import freemarker.template.TemplateException;
/* 10:   */ import freemarker.template.TemplateModel;
/* 11:   */ import java.io.IOException;
/* 12:   */ import java.util.HashMap;
/* 13:   */ import java.util.Map;
/* 14:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 15:   */ 
/* 16:   */ public class QuestionCountTagModel
/* 17:   */   implements TemplateDirectiveModel
/* 18:   */ {
/* 19:   */   public static final String PARAM_QUESTION_ID = "qId";
/* 20:   */   @Autowired
/* 21:   */   private QuestionDetailService service;
/* 22:   */   
/* 23:   */   public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
/* 24:   */     throws TemplateException, IOException
/* 25:   */   {
/* 26:34 */     Integer qId = TagModelTools.getInt("qId", params);
/* 27:35 */     Map<String, TemplateModel> paramWrap = new HashMap(
/* 28:36 */       params);
/* 29:37 */     long count = this.service.getCountDetail(qId);
/* 30:38 */     paramWrap.put("count", ObjectWrapper.DEFAULT_WRAPPER.wrap(Long.valueOf(count)));
/* 31:39 */     Map<String, TemplateModel> origMap = TagModelTools.addParamsToVariable(
/* 32:40 */       env, paramWrap);
/* 33:41 */     body.render(env.getOut());
/* 34:42 */     TagModelTools.removeParamsFromVariable(env, paramWrap, origMap);
/* 35:   */   }
/* 36:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.action.tag.QuestionCountTagModel
 * JD-Core Version:    0.7.0.1
 */