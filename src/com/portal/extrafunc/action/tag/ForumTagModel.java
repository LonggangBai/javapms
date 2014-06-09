/*  1:   */ package com.portal.extrafunc.action.tag;
/*  2:   */ 
/*  3:   */ import com.portal.extrafunc.entity.Forum;
/*  4:   */ import com.portal.extrafunc.service.ForumService;
/*  5:   */ import com.portal.sysmgr.utils.TagModelTools;
/*  6:   */ import freemarker.core.Environment;
/*  7:   */ import freemarker.template.ObjectWrapper;
/*  8:   */ import freemarker.template.TemplateDirectiveBody;
/*  9:   */ import freemarker.template.TemplateDirectiveModel;
/* 10:   */ import freemarker.template.TemplateException;
/* 11:   */ import freemarker.template.TemplateModel;
/* 12:   */ import java.io.IOException;
/* 13:   */ import java.util.HashMap;
/* 14:   */ import java.util.List;
/* 15:   */ import java.util.Map;
/* 16:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 17:   */ 
/* 18:   */ public class ForumTagModel
/* 19:   */   implements TemplateDirectiveModel
/* 20:   */ {
/* 21:   */   public static final String PARAM_CATEGORY_ID = "cId";
/* 22:   */   @Autowired
/* 23:   */   private ForumService service;
/* 24:   */   
/* 25:   */   public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
/* 26:   */     throws TemplateException, IOException
/* 27:   */   {
/* 28:36 */     Integer cId = TagModelTools.getInt("cId", params);
/* 29:37 */     List<Forum> list = this.service.getList(cId);
/* 30:38 */     Map<String, TemplateModel> paramWrap = new HashMap(
/* 31:39 */       params);
/* 32:40 */     paramWrap.put("list", ObjectWrapper.DEFAULT_WRAPPER.wrap(list));
/* 33:41 */     Map<String, TemplateModel> origMap = TagModelTools.addParamsToVariable(
/* 34:42 */       env, paramWrap);
/* 35:43 */     body.render(env.getOut());
/* 36:44 */     TagModelTools.removeParamsFromVariable(env, paramWrap, origMap);
/* 37:   */   }
/* 38:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.action.tag.ForumTagModel
 * JD-Core Version:    0.7.0.1
 */