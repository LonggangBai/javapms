/*  1:   */ package com.portal.recruitcenter.action.tag;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.page.Pagination;
/*  4:   */ import com.portal.recruitcenter.service.CompanyInfoService;
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
/* 19:   */ public class CompanyInfoTagModel
/* 20:   */   implements TemplateDirectiveModel
/* 21:   */ {
/* 22:   */   public static final String PARAM_KEY = "key";
/* 23:   */   public static final String PARAM_INDUSTRY_ID = "industryId";
/* 24:   */   public static final String PARAM_NATURE_ID = "natureId";
/* 25:   */   public static final String PARAM_HAVA_JOB = "havejob";
/* 26:   */   public static final String PARAM_WORK_EXP = "workexp";
/* 27:   */   public static final String PARAM_WORK_TYPE = "worktype";
/* 28:   */   public static final String PARAM_VIP = "vip";
/* 29:   */   public static final String PARAM_COMMEND = "commend";
/* 30:   */   @Autowired
/* 31:   */   private CompanyInfoService companyInfoService;
/* 32:   */   
/* 33:   */   public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
/* 34:   */     throws TemplateException, IOException
/* 35:   */   {
/* 36:39 */     Site site = ViewTools.getSite(env);
/* 37:40 */     String key = TagModelTools.getString("key", params);
/* 38:41 */     Integer industryId = TagModelTools.getInt("industryId", params);
/* 39:42 */     Integer natureId = TagModelTools.getInt("natureId", params);
/* 40:43 */     Boolean havejob = TagModelTools.getBool("havejob", params);
/* 41:44 */     Byte workexp = TagModelTools.getByte("workexp", params);
/* 42:45 */     Integer worktype = TagModelTools.getInt("worktype", params);
/* 43:46 */     Boolean vip = TagModelTools.getBool("natureId", params);
/* 44:47 */     Boolean commend = TagModelTools.getBool("commend", params);
/* 45:48 */     Pagination page = this.companyInfoService.getPageByTag(key, industryId, 
/* 46:49 */       natureId, havejob, workexp, worktype, commend, vip, 
/* 47:50 */       ViewTools.getPageNo(env), ViewTools.getCount(params));
/* 48:51 */     Map<String, TemplateModel> paramWrap = new HashMap(
/* 49:52 */       params);
/* 50:53 */     paramWrap.put("page", ObjectWrapper.DEFAULT_WRAPPER.wrap(page));
/* 51:54 */     Map<String, TemplateModel> origMap = 
/* 52:55 */       TagModelTools.addParamsToVariable(env, paramWrap);
/* 53:56 */     body.render(env.getOut());
/* 54:57 */     ViewTools.includePagination(site, params, env);
/* 55:58 */     TagModelTools.removeParamsFromVariable(env, paramWrap, origMap);
/* 56:   */   }
/* 57:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.action.tag.CompanyInfoTagModel
 * JD-Core Version:    0.7.0.1
 */