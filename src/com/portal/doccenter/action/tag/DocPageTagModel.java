/*  1:   */ package com.portal.doccenter.action.tag;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.page.Pagination;
/*  4:   */ import com.portal.doccenter.action.tag.base.BaseDocTagModel;
/*  5:   */ import com.portal.sysmgr.entity.Site;
/*  6:   */ import com.portal.sysmgr.utils.TagModelTools;
/*  7:   */ import com.portal.sysmgr.utils.ViewTools;
/*  8:   */ import freemarker.core.Environment;
/*  9:   */ import freemarker.template.ObjectWrapper;
/* 10:   */ import freemarker.template.TemplateDirectiveBody;
/* 11:   */ import freemarker.template.TemplateException;
/* 12:   */ import freemarker.template.TemplateModel;
/* 13:   */ import java.io.IOException;
/* 14:   */ import java.util.HashMap;
/* 15:   */ import java.util.Map;
/* 16:   */ import org.apache.commons.lang.StringUtils;
/* 17:   */ 
/* 18:   */ public class DocPageTagModel
/* 19:   */   extends BaseDocTagModel
/* 20:   */ {
/* 21:   */   public static final String TPL_NAME = "tplName";
/* 22:   */   
/* 23:   */   public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
/* 24:   */     throws TemplateException, IOException
/* 25:   */   {
/* 26:39 */     Site site = ViewTools.getSite(env);
/* 27:40 */     String tplName = TagModelTools.getString("tplName", params);
/* 28:41 */     Pagination page = (Pagination)super.getData(params, env);
/* 29:42 */     Map<String, TemplateModel> paramWrap = new HashMap(
/* 30:43 */       params);
/* 31:44 */     paramWrap.put("page", ObjectWrapper.DEFAULT_WRAPPER.wrap(page));
/* 32:45 */     paramWrap.put("list", ObjectWrapper.DEFAULT_WRAPPER.wrap(page.getList()));
/* 33:46 */     paramWrap.put("isPage", ObjectWrapper.DEFAULT_WRAPPER.wrap(Boolean.valueOf(true)));
/* 34:47 */     Map<String, TemplateModel> origMap = 
/* 35:48 */       TagModelTools.addParamsToVariable(env, paramWrap);
/* 36:49 */     if (!StringUtils.isBlank(tplName)) {
/* 37:50 */       ViewTools.includeTpl(tplName, site, env);
/* 38:52 */     } else if (body != null) {
/* 39:53 */       body.render(env.getOut());
/* 40:   */     }
/* 41:56 */     TagModelTools.removeParamsFromVariable(env, paramWrap, origMap);
/* 42:   */   }
/* 43:   */   
/* 44:   */   protected boolean isPage()
/* 45:   */   {
/* 46:61 */     return true;
/* 47:   */   }
/* 48:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.action.tag.DocPageTagModel
 * JD-Core Version:    0.7.0.1
 */