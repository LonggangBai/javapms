/*  1:   */ package com.portal.doccenter.action.tag;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.page.Pagination;
/*  4:   */ import com.portal.datacenter.lucene.LuceneDocPageService;
/*  5:   */ import com.portal.doccenter.action.tag.base.BaseSearchTagModel;
/*  6:   */ import com.portal.sysmgr.entity.Site;
/*  7:   */ import com.portal.sysmgr.utils.TagModelTools;
/*  8:   */ import com.portal.sysmgr.utils.ViewTools;
/*  9:   */ import freemarker.core.Environment;
/* 10:   */ import freemarker.template.ObjectWrapper;
/* 11:   */ import freemarker.template.TemplateDirectiveBody;
/* 12:   */ import freemarker.template.TemplateException;
/* 13:   */ import freemarker.template.TemplateModel;
/* 14:   */ import java.io.IOException;
/* 15:   */ import java.util.Date;
/* 16:   */ import java.util.HashMap;
/* 17:   */ import java.util.Map;
/* 18:   */ import org.apache.commons.lang.StringUtils;
/* 19:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 20:   */ 
/* 21:   */ public class SearchPageTagModel
/* 22:   */   extends BaseSearchTagModel
/* 23:   */ {
/* 24:   */   public static final String TPL_NAME = "tplName";
/* 25:   */   @Autowired
/* 26:   */   private LuceneDocPageService luceneDocPageService;
/* 27:   */   
/* 28:   */   public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
/* 29:   */     throws TemplateException, IOException
/* 30:   */   {
/* 31:35 */     Site site = ViewTools.getSite(env);
/* 32:36 */     int pageNo = ViewTools.getPageNo(env);
/* 33:37 */     int count = ViewTools.getCount(params);
/* 34:38 */     String tplName = TagModelTools.getString("tplName", params);
/* 35:39 */     String query = getQuery(params);
/* 36:40 */     Integer channelId = getChannelId(params);
/* 37:41 */     Integer modelId = getModelId(params);
/* 38:42 */     Date startDate = getStartDate(params);
/* 39:43 */     Date endDate = getEndDate(params);
/* 40:   */     
/* 41:45 */     Pagination page = this.luceneDocPageService.searchArticle(query, query, site.getId(), 
/* 42:46 */       modelId, channelId, startDate, endDate, pageNo, count);
/* 43:   */     
/* 44:48 */     Map<String, TemplateModel> paramWrap = new HashMap(
/* 45:49 */       params);
/* 46:50 */     paramWrap.put("page", ObjectWrapper.DEFAULT_WRAPPER.wrap(page));
/* 47:51 */     Map<String, TemplateModel> origMap = TagModelTools.addParamsToVariable(
/* 48:52 */       env, paramWrap);
/* 49:53 */     if (!StringUtils.isBlank(tplName)) {
/* 50:54 */       ViewTools.includeTpl(tplName, site, env);
/* 51:56 */     } else if (body != null) {
/* 52:57 */       body.render(env.getOut());
/* 53:   */     }
/* 54:60 */     TagModelTools.removeParamsFromVariable(env, paramWrap, origMap);
/* 55:   */   }
/* 56:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.action.tag.SearchPageTagModel
 * JD-Core Version:    0.7.0.1
 */