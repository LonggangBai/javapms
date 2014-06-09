/*  1:   */ package com.portal.extrafunc.action.tag;
/*  2:   */ 
/*  3:   */ import com.portal.extrafunc.action.cache.ForumStatisCache;
/*  4:   */ import com.portal.extrafunc.entity.ForumStatis;
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
/* 19:   */ public class ForumStatisTagModel
/* 20:   */   implements TemplateDirectiveModel
/* 21:   */ {
/* 22:   */   @Autowired
/* 23:   */   private ForumStatisCache statisCache;
/* 24:   */   
/* 25:   */   public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
/* 26:   */     throws TemplateException, IOException
/* 27:   */   {
/* 28:35 */     Site site = ViewTools.getSite(env);
/* 29:36 */     ForumStatis statis = this.statisCache.getStatis(site);
/* 30:37 */     Map<String, TemplateModel> paramWrap = new HashMap(
/* 31:38 */       params);
/* 32:39 */     paramWrap.put("bean", ObjectWrapper.DEFAULT_WRAPPER.wrap(statis));
/* 33:40 */     Map<String, TemplateModel> origMap = TagModelTools.addParamsToVariable(
/* 34:41 */       env, paramWrap);
/* 35:42 */     body.render(env.getOut());
/* 36:43 */     TagModelTools.removeParamsFromVariable(env, paramWrap, origMap);
/* 37:   */   }
/* 38:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.action.tag.ForumStatisTagModel
 * JD-Core Version:    0.7.0.1
 */