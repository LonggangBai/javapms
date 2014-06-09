/*  1:   */ package com.portal.doccenter.action.tag;
/*  2:   */ 
/*  3:   */ import com.portal.doccenter.action.tag.base.BaseChannelTagModel;
/*  4:   */ import com.portal.doccenter.entity.Channel;
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
/* 16:   */ import java.util.List;
/* 17:   */ import java.util.Map;
/* 18:   */ import org.apache.commons.lang.StringUtils;
/* 19:   */ 
/* 20:   */ public class ChannelListTagModel
/* 21:   */   extends BaseChannelTagModel
/* 22:   */ {
/* 23:   */   public static final String TPL_NAME = "tplName";
/* 24:   */   
/* 25:   */   public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
/* 26:   */     throws TemplateException, IOException
/* 27:   */   {
/* 28:39 */     Site site = ViewTools.getSite(env);
/* 29:40 */     Integer parentId = TagModelTools.getInt("pId", params);
/* 30:41 */     Integer siteId = TagModelTools.getInt("sId", params);
/* 31:42 */     String tplName = TagModelTools.getString("tplName", params);
/* 32:43 */     boolean isAlone = getAlone(params);
/* 33:44 */     if (siteId == null) {
/* 34:45 */       siteId = site.getId();
/* 35:   */     }
/* 36:47 */     List<Channel> list = this.channelService.getChannelListByTag(siteId, 
/* 37:48 */       parentId, isAlone, true, true, ViewTools.getCount(params));
/* 38:49 */     Map<String, TemplateModel> paramWrap = new HashMap(
/* 39:50 */       params);
/* 40:51 */     paramWrap.put("list", ObjectWrapper.DEFAULT_WRAPPER.wrap(list));
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
 * Qualified Name:     com.portal.doccenter.action.tag.ChannelListTagModel
 * JD-Core Version:    0.7.0.1
 */