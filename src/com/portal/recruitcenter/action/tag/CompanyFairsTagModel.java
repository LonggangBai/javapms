/*  1:   */ package com.portal.recruitcenter.action.tag;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.page.Pagination;
/*  4:   */ import com.portal.recruitcenter.service.CompanyFairsService;
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
/* 19:   */ public class CompanyFairsTagModel
/* 20:   */   implements TemplateDirectiveModel
/* 21:   */ {
/* 22:   */   public static final String PARAM_FAIRS_ID = "fairsId";
/* 23:   */   public static final String PARAM_COMPANY_ID = "companyId";
/* 24:   */   public static final String PARAM_ORDER_BY = "orderBy";
/* 25:   */   @Autowired
/* 26:   */   private CompanyFairsService companyFairsService;
/* 27:   */   
/* 28:   */   public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
/* 29:   */     throws TemplateException, IOException
/* 30:   */   {
/* 31:34 */     Site site = ViewTools.getSite(env);
/* 32:35 */     Integer fairsId = TagModelTools.getInt("fairsId", params);
/* 33:36 */     Integer companyId = TagModelTools.getInt("companyId", params);
/* 34:37 */     Integer orderBy = TagModelTools.getInt("orderBy", params);
/* 35:38 */     Pagination page = this.companyFairsService.getPageByTag(fairsId, companyId, orderBy, 
/* 36:39 */       ViewTools.getPageNo(env), ViewTools.getCount(params));
/* 37:40 */     Map<String, TemplateModel> paramWrap = new HashMap(
/* 38:41 */       params);
/* 39:42 */     paramWrap.put("page", ObjectWrapper.DEFAULT_WRAPPER.wrap(page));
/* 40:43 */     Map<String, TemplateModel> origMap = 
/* 41:44 */       TagModelTools.addParamsToVariable(env, paramWrap);
/* 42:45 */     body.render(env.getOut());
/* 43:46 */     ViewTools.includePagination(site, params, env);
/* 44:47 */     TagModelTools.removeParamsFromVariable(env, paramWrap, origMap);
/* 45:   */   }
/* 46:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.action.tag.CompanyFairsTagModel
 * JD-Core Version:    0.7.0.1
 */