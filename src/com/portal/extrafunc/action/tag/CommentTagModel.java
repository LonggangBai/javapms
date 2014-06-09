/*  1:   */ package com.portal.extrafunc.action.tag;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.page.Pagination;
/*  4:   */ import com.portal.extrafunc.action.tag.base.BaseCommentTagModel;
/*  5:   */ import com.portal.extrafunc.service.CommentService;
/*  6:   */ import com.portal.sysmgr.entity.Site;
/*  7:   */ import com.portal.sysmgr.utils.TagModelTools;
/*  8:   */ import com.portal.sysmgr.utils.ViewTools;
/*  9:   */ import freemarker.core.Environment;
/* 10:   */ import freemarker.template.ObjectWrapper;
/* 11:   */ import freemarker.template.TemplateDirectiveBody;
/* 12:   */ import freemarker.template.TemplateException;
/* 13:   */ import freemarker.template.TemplateModel;
/* 14:   */ import java.io.IOException;
/* 15:   */ import java.util.HashMap;
/* 16:   */ import java.util.Map;
/* 17:   */ 
/* 18:   */ public class CommentTagModel
/* 19:   */   extends BaseCommentTagModel
/* 20:   */ {
/* 21:   */   public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
/* 22:   */     throws TemplateException, IOException
/* 23:   */   {
/* 24:32 */     Site site = ViewTools.getSite(env);
/* 25:33 */     boolean isPage = getIsPage(params);
/* 26:34 */     Pagination page = null;
/* 27:35 */     if (isPage) {
/* 28:36 */       page = this.commentService.getPageForTag(getSiteId(params), 
/* 29:37 */         getDocId(params), getParentId(params), Boolean.valueOf(true), null, 
/* 30:38 */         getOrderBy(params), ViewTools.getPageNo(env), 
/* 31:39 */         ViewTools.getCount(params));
/* 32:   */     } else {
/* 33:41 */       page = this.commentService.getPageForTag(getSiteId(params), 
/* 34:42 */         getDocId(params), getParentId(params), Boolean.valueOf(true), null, 
/* 35:43 */         getOrderBy(params), 1, ViewTools.getCount(params));
/* 36:   */     }
/* 37:45 */     Map<String, TemplateModel> paramWrap = new HashMap(
/* 38:46 */       params);
/* 39:47 */     paramWrap.put("page", ObjectWrapper.DEFAULT_WRAPPER.wrap(page));
/* 40:48 */     Map<String, TemplateModel> origMap = 
/* 41:49 */       TagModelTools.addParamsToVariable(env, paramWrap);
/* 42:50 */     body.render(env.getOut());
/* 43:51 */     if (isPage) {
/* 44:52 */       ViewTools.includePagination(site, params, env);
/* 45:   */     }
/* 46:54 */     TagModelTools.removeParamsFromVariable(env, paramWrap, origMap);
/* 47:   */   }
/* 48:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.action.tag.CommentTagModel
 * JD-Core Version:    0.7.0.1
 */