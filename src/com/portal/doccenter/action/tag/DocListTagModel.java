/*  1:   */ package com.portal.doccenter.action.tag;
/*  2:   */ 
/*  3:   */ import com.portal.doccenter.action.tag.base.BaseDocTagModel;
/*  4:   */ import com.portal.doccenter.entity.Article;
/*  5:   */ import com.portal.doccenter.service.ArticleService;
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
/* 16:   */ import java.util.List;
/* 17:   */ import java.util.Map;
/* 18:   */ import org.apache.commons.lang.StringUtils;
/* 19:   */ 
/* 20:   */ public class DocListTagModel
/* 21:   */   extends BaseDocTagModel
/* 22:   */ {
/* 23:   */   public static final String TPL_NAME = "tplName";
/* 24:   */   public static final String PARAM_IDS = "ids";
/* 25:   */   
/* 26:   */   public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
/* 27:   */     throws TemplateException, IOException
/* 28:   */   {
/* 29:44 */     Site site = ViewTools.getSite(env);
/* 30:45 */     String tplName = TagModelTools.getString("tplName", params);
/* 31:46 */     List<Article> list = getList(params, env);
/* 32:47 */     Map<String, TemplateModel> paramWrap = new HashMap(
/* 33:48 */       params);
/* 34:49 */     paramWrap.put("list", ObjectWrapper.DEFAULT_WRAPPER.wrap(list));
/* 35:50 */     paramWrap.put("isPage", ObjectWrapper.DEFAULT_WRAPPER.wrap(Boolean.valueOf(false)));
/* 36:51 */     Map<String, TemplateModel> origMap = 
/* 37:52 */       TagModelTools.addParamsToVariable(env, paramWrap);
/* 38:53 */     if (!StringUtils.isBlank(tplName)) {
/* 39:54 */       ViewTools.includeTpl(tplName, site, env);
/* 40:56 */     } else if (body != null) {
/* 41:57 */       body.render(env.getOut());
/* 42:   */     }
/* 43:60 */     TagModelTools.removeParamsFromVariable(env, paramWrap, origMap);
/* 44:   */   }
/* 45:   */   
/* 46:   */   protected List<Article> getList(Map<String, TemplateModel> params, Environment env)
/* 47:   */     throws TemplateException
/* 48:   */   {
/* 49:66 */     Integer[] ids = TagModelTools.getIntArray("ids", params);
/* 50:67 */     if (ids != null) {
/* 51:68 */       return this.articleService.getListTagByIds(ids, getOrderBy(params));
/* 52:   */     }
/* 53:70 */     return (List)super.getData(params, env);
/* 54:   */   }
/* 55:   */   
/* 56:   */   protected boolean isPage()
/* 57:   */   {
/* 58:76 */     return false;
/* 59:   */   }
/* 60:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.action.tag.DocListTagModel
 * JD-Core Version:    0.7.0.1
 */