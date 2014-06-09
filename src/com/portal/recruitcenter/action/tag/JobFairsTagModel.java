/*  1:   */ package com.portal.recruitcenter.action.tag;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.page.Pagination;
/*  4:   */ import com.portal.recruitcenter.service.JobFairsService;
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
/* 19:   */ public class JobFairsTagModel
/* 20:   */   implements TemplateDirectiveModel
/* 21:   */ {
/* 22:   */   @Autowired
/* 23:   */   private JobFairsService jobFairsService;
/* 24:   */   
/* 25:   */   public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
/* 26:   */     throws TemplateException, IOException
/* 27:   */   {
/* 28:30 */     Site site = ViewTools.getSite(env);
/* 29:31 */     Pagination page = this.jobFairsService.getPageByTag(ViewTools.getPageNo(env), 
/* 30:32 */       ViewTools.getCount(params));
/* 31:33 */     Map<String, TemplateModel> paramWrap = new HashMap(
/* 32:34 */       params);
/* 33:35 */     paramWrap.put("page", ObjectWrapper.DEFAULT_WRAPPER.wrap(page));
/* 34:36 */     Map<String, TemplateModel> origMap = 
/* 35:37 */       TagModelTools.addParamsToVariable(env, paramWrap);
/* 36:38 */     body.render(env.getOut());
/* 37:39 */     ViewTools.includePagination(site, params, env);
/* 38:40 */     TagModelTools.removeParamsFromVariable(env, paramWrap, origMap);
/* 39:   */   }
/* 40:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.action.tag.JobFairsTagModel
 * JD-Core Version:    0.7.0.1
 */