/*  1:   */ package com.portal.doccenter.action.tag;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.page.Pagination;
/*  4:   */ import com.portal.doccenter.action.tag.base.BaseChannelTagModel;
/*  5:   */ import com.portal.doccenter.service.ChannelService;
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
/* 17:   */ import org.apache.commons.lang.StringUtils;
/* 18:   */ 
/* 19:   */ public class ChannelPageTagModel
/* 20:   */   extends BaseChannelTagModel
/* 21:   */ {
/* 22:   */   public static final String TPL_NAME = "tplName";
/* 23:   */   
/* 24:   */   public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
/* 25:   */     throws TemplateException, IOException
/* 26:   */   {
/* 27:38 */     Site site = ViewTools.getSite(env);
/* 28:39 */     Integer parentId = TagModelTools.getInt("pId", params);
/* 29:40 */     Integer siteId = TagModelTools.getInt("sId", params);
/* 30:41 */     String tplName = TagModelTools.getString("tplName", params);
/* 31:42 */     boolean isAlone = getAlone(params);
/* 32:43 */     if (siteId == null) {
/* 33:44 */       siteId = site.getId();
/* 34:   */     }
/* 35:46 */     Pagination page = this.channelService.getChannelPageByTag(siteId, parentId, 
/* 36:47 */       isAlone, true, true, ViewTools.getPageNo(env), 
/* 37:48 */       ViewTools.getCount(params));
/* 38:49 */     Map<String, TemplateModel> paramWrap = new HashMap(
/* 39:50 */       params);
/* 40:51 */     paramWrap.put("page", ObjectWrapper.DEFAULT_WRAPPER.wrap(page));
/* 41:52 */     Map<String, TemplateModel> origMap = 
/* 42:53 */       TagModelTools.addParamsToVariable(env, paramWrap);
/* 43:54 */     if (!StringUtils.isBlank(tplName)) {
/* 44:55 */       ViewTools.includeTpl(tplName, site, env);
/* 45:57 */     } else if (body != null) {
/* 46:58 */       body.render(env.getOut());
/* 47:   */     }
/* 48:61 */     TagModelTools.removeParamsFromVariable(env, paramWrap, origMap);
/* 49:   */   }
/* 50:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.action.tag.ChannelPageTagModel
 * JD-Core Version:    0.7.0.1
 */