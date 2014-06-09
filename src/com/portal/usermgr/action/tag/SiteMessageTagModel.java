/*  1:   */ package com.portal.usermgr.action.tag;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.page.Pagination;
/*  4:   */ import com.portal.sysmgr.entity.Site;
/*  5:   */ import com.portal.sysmgr.utils.TagModelTools;
/*  6:   */ import com.portal.sysmgr.utils.ViewTools;
/*  7:   */ import com.portal.usermgr.service.SiteMessageService;
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
/* 19:   */ public class SiteMessageTagModel
/* 20:   */   implements TemplateDirectiveModel
/* 21:   */ {
/* 22:   */   public static final String PARAM_FROM_ID = "fromId";
/* 23:   */   public static final String PARAM_TO_ID = "toId";
/* 24:   */   public static final String PARAM_ALL_ID = "allId";
/* 25:   */   public static final String PARAM_REPLY_ID = "replyId";
/* 26:   */   @Autowired
/* 27:   */   private SiteMessageService messageService;
/* 28:   */   
/* 29:   */   public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
/* 30:   */     throws TemplateException, IOException
/* 31:   */   {
/* 32:35 */     Site site = ViewTools.getSite(env);
/* 33:36 */     Integer fromId = TagModelTools.getInt("fromId", params);
/* 34:37 */     Integer toId = TagModelTools.getInt("toId", params);
/* 35:38 */     Integer allId = TagModelTools.getInt("allId", params);
/* 36:39 */     Integer replyId = TagModelTools.getInt("replyId", params);
/* 37:40 */     Pagination page = this.messageService.getPageByTag(fromId, toId, allId, replyId, 
/* 38:41 */       ViewTools.getPageNo(env), ViewTools.getCount(params));
/* 39:42 */     Map<String, TemplateModel> paramWrap = new HashMap(
/* 40:43 */       params);
/* 41:44 */     paramWrap.put("page", ObjectWrapper.DEFAULT_WRAPPER.wrap(page));
/* 42:45 */     Map<String, TemplateModel> origMap = 
/* 43:46 */       TagModelTools.addParamsToVariable(env, paramWrap);
/* 44:47 */     body.render(env.getOut());
/* 45:48 */     ViewTools.includePagination(site, params, env);
/* 46:49 */     TagModelTools.removeParamsFromVariable(env, paramWrap, origMap);
/* 47:   */   }
/* 48:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.action.tag.SiteMessageTagModel
 * JD-Core Version:    0.7.0.1
 */