/*  1:   */ package com.portal.extrafunc.action.tag;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.page.Pagination;
/*  4:   */ import com.portal.extrafunc.service.PostsService;
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
/* 18:   */ public class PostsTagModel
/* 19:   */   implements TemplateDirectiveModel
/* 20:   */ {
/* 21:   */   public static final String PARAM_THEME_ID = "tId";
/* 22:   */   @Autowired
/* 23:   */   private PostsService service;
/* 24:   */   
/* 25:   */   public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
/* 26:   */     throws TemplateException, IOException
/* 27:   */   {
/* 28:36 */     Integer tId = TagModelTools.getInt("tId", params);
/* 29:37 */     Pagination page = this.service.getPostsPageForTag(tId, 
/* 30:38 */       ViewTools.getPageNo(env), ViewTools.getCount(params));
/* 31:39 */     Map<String, TemplateModel> paramWrap = new HashMap(
/* 32:40 */       params);
/* 33:41 */     paramWrap.put("page", ObjectWrapper.DEFAULT_WRAPPER.wrap(page));
/* 34:42 */     Map<String, TemplateModel> origMap = TagModelTools.addParamsToVariable(
/* 35:43 */       env, paramWrap);
/* 36:44 */     body.render(env.getOut());
/* 37:45 */     TagModelTools.removeParamsFromVariable(env, paramWrap, origMap);
/* 38:   */   }
/* 39:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.action.tag.PostsTagModel
 * JD-Core Version:    0.7.0.1
 */