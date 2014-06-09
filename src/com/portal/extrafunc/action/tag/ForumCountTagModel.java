/*  1:   */ package com.portal.extrafunc.action.tag;
/*  2:   */ 
/*  3:   */ import com.portal.extrafunc.action.cache.ForumCache;
/*  4:   */ import com.portal.extrafunc.entity.Forum;
/*  5:   */ import com.portal.sysmgr.utils.TagModelTools;
/*  6:   */ import freemarker.core.Environment;
/*  7:   */ import freemarker.template.ObjectWrapper;
/*  8:   */ import freemarker.template.TemplateDirectiveBody;
/*  9:   */ import freemarker.template.TemplateDirectiveModel;
/* 10:   */ import freemarker.template.TemplateException;
/* 11:   */ import freemarker.template.TemplateModel;
/* 12:   */ import java.io.IOException;
/* 13:   */ import java.util.HashMap;
/* 14:   */ import java.util.Map;
/* 15:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 16:   */ 
/* 17:   */ public class ForumCountTagModel
/* 18:   */   implements TemplateDirectiveModel
/* 19:   */ {
/* 20:   */   public static final String PARAM_FORUM_ID = "id";
/* 21:   */   @Autowired
/* 22:   */   private ForumCache forumCache;
/* 23:   */   
/* 24:   */   public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
/* 25:   */     throws TemplateException, IOException
/* 26:   */   {
/* 27:35 */     Integer id = TagModelTools.getInt("id", params);
/* 28:36 */     Forum forum = this.forumCache.getForum(id);
/* 29:37 */     Map<String, TemplateModel> paramWrap = new HashMap(
/* 30:38 */       params);
/* 31:39 */     paramWrap.put("bean", ObjectWrapper.DEFAULT_WRAPPER.wrap(forum));
/* 32:40 */     Map<String, TemplateModel> origMap = TagModelTools.addParamsToVariable(
/* 33:41 */       env, paramWrap);
/* 34:42 */     body.render(env.getOut());
/* 35:43 */     TagModelTools.removeParamsFromVariable(env, paramWrap, origMap);
/* 36:   */   }
/* 37:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.action.tag.ForumCountTagModel
 * JD-Core Version:    0.7.0.1
 */