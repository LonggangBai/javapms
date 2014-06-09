/*  1:   */ package com.portal.recruitcenter.action.tag;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.page.Pagination;
/*  4:   */ import com.portal.recruitcenter.service.JobIntentService;
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
/* 19:   */ public class JobIntentTagModel
/* 20:   */   implements TemplateDirectiveModel
/* 21:   */ {
/* 22:   */   public static final String PARAM_KEY = "key";
/* 23:   */   public static final String PARAM_PERSONAL_ID = "personalId";
/* 24:   */   public static final String PARAM_METIER_ID = "metierId";
/* 25:   */   public static final String PARAM_SPECIAL_ID = "specialId";
/* 26:   */   public static final String PARAM_EDU = "edu";
/* 27:   */   public static final String PARAM_INDUSTRY_ID = "industryId";
/* 28:   */   public static final String PARAM_WAGE = "wage";
/* 29:   */   public static final String PARAM_MINWORK = "minwork";
/* 30:   */   public static final String PARAM_MAXWORK = "maxwork";
/* 31:   */   public static final String PARAM_GENDER = "gender";
/* 32:   */   public static final String PARAM_SHOW = "show";
/* 33:   */   @Autowired
/* 34:   */   private JobIntentService jobIntentService;
/* 35:   */   
/* 36:   */   public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
/* 37:   */     throws TemplateException, IOException
/* 38:   */   {
/* 39:42 */     Site site = ViewTools.getSite(env);
/* 40:43 */     String key = TagModelTools.getString("key", params);
/* 41:44 */     Integer personalId = TagModelTools.getInt("personalId", params);
/* 42:45 */     Integer metierId = TagModelTools.getInt("metierId", params);
/* 43:46 */     Integer industryId = TagModelTools.getInt("industryId", params);
/* 44:47 */     Integer specialId = TagModelTools.getInt("specialId", params);
/* 45:48 */     Byte wage = TagModelTools.getByte("wage", params);
/* 46:49 */     Byte edu = TagModelTools.getByte("edu", params);
/* 47:50 */     Byte minwork = TagModelTools.getByte("minwork", params);
/* 48:51 */     Byte maxwork = TagModelTools.getByte("maxwork", params);
/* 49:52 */     Boolean gender = TagModelTools.getBool("gender", params);
/* 50:53 */     Boolean show = TagModelTools.getBool("show", params);
/* 51:54 */     Pagination page = this.jobIntentService.getPageByTag(key, personalId, metierId, 
/* 52:55 */       industryId, specialId, wage, edu, minwork, maxwork, gender, 
/* 53:56 */       show, ViewTools.getPageNo(env), ViewTools.getCount(params));
/* 54:57 */     Map<String, TemplateModel> paramWrap = new HashMap(
/* 55:58 */       params);
/* 56:59 */     paramWrap.put("page", ObjectWrapper.DEFAULT_WRAPPER.wrap(page));
/* 57:60 */     Map<String, TemplateModel> origMap = 
/* 58:61 */       TagModelTools.addParamsToVariable(env, paramWrap);
/* 59:62 */     body.render(env.getOut());
/* 60:63 */     ViewTools.includePagination(site, params, env);
/* 61:64 */     TagModelTools.removeParamsFromVariable(env, paramWrap, origMap);
/* 62:   */   }
/* 63:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.action.tag.JobIntentTagModel
 * JD-Core Version:    0.7.0.1
 */