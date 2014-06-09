/*  1:   */ package com.portal.recruitcenter.action.tag;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.page.Pagination;
/*  4:   */ import com.portal.recruitcenter.service.JobPostService;
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
/* 19:   */ public class JobPostTagModel
/* 20:   */   implements TemplateDirectiveModel
/* 21:   */ {
/* 22:   */   public static final String PARAM_KEY = "key";
/* 23:   */   public static final String PARAM_COMPANY_ID = "companyId";
/* 24:   */   public static final String PARAM_METIER_ID = "metierId";
/* 25:   */   public static final String PARAM_INDUSTRY_ID = "industryId";
/* 26:   */   public static final String PARAM_METIER_ID1 = "metierId1";
/* 27:   */   public static final String PARAM_INDUSTRY_ID1 = "industryId1";
/* 28:   */   public static final String PARAM_WAGE = "wage";
/* 29:   */   public static final String PARAM_EDU = "edu";
/* 30:   */   public static final String PARAM_NATURE_ID = "natureId";
/* 31:   */   public static final String PARAM_SCALE = "scale";
/* 32:   */   public static final String PARAM_GENDER = "gender";
/* 33:   */   public static final String PARAM_WOKR_EXP = "workExp";
/* 34:   */   public static final String PARAM_MIN_AGE = "minAge";
/* 35:   */   public static final String PARAM_MAX_AGE = "maxAge";
/* 36:   */   public static final String PARAM_JOB_TYPE = "jobType";
/* 37:   */   public static final String PARAM_CHECK_TIME = "checkTime";
/* 38:   */   public static final String PARAM_SHOW = "show";
/* 39:   */   @Autowired
/* 40:   */   private JobPostService jobPostService;
/* 41:   */   
/* 42:   */   public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
/* 43:   */     throws TemplateException, IOException
/* 44:   */   {
/* 45:48 */     Site site = ViewTools.getSite(env);
/* 46:49 */     String key = TagModelTools.getString("key", params);
/* 47:50 */     Integer companyId = TagModelTools.getInt("companyId", params);
/* 48:51 */     Integer metierId = TagModelTools.getInt("metierId", params);
/* 49:52 */     if (metierId == null) {
/* 50:53 */       metierId = TagModelTools.getInt("metierId1", params);
/* 51:   */     }
/* 52:55 */     Integer industryId = TagModelTools.getInt("industryId", params);
/* 53:56 */     if (industryId == null) {
/* 54:57 */       industryId = TagModelTools.getInt("industryId1", params);
/* 55:   */     }
/* 56:59 */     Byte wage = TagModelTools.getByte("wage", params);
/* 57:60 */     Byte edu = TagModelTools.getByte("edu", params);
/* 58:61 */     Integer natureId = TagModelTools.getInt("natureId", params);
/* 59:62 */     Byte scale = TagModelTools.getByte("scale", params);
/* 60:63 */     Byte gender = TagModelTools.getByte("gender", params);
/* 61:64 */     Byte workExp = TagModelTools.getByte("workExp", params);
/* 62:65 */     Integer minAge = TagModelTools.getInt("minAge", params);
/* 63:66 */     Integer maxAge = TagModelTools.getInt("maxAge", params);
/* 64:67 */     String jobType = TagModelTools.getString("jobType", params);
/* 65:68 */     Boolean checkTime = TagModelTools.getBool("checkTime", params);
/* 66:69 */     Boolean show = TagModelTools.getBool("show", params);
/* 67:70 */     Pagination page = this.jobPostService.getPageByTag(key, companyId, metierId, 
/* 68:71 */       industryId, wage, edu, natureId, scale, gender, workExp, 
/* 69:72 */       minAge, maxAge, jobType, checkTime, show, 
/* 70:73 */       ViewTools.getPageNo(env), ViewTools.getCount(params));
/* 71:74 */     Map<String, TemplateModel> paramWrap = new HashMap(
/* 72:75 */       params);
/* 73:76 */     paramWrap.put("page", ObjectWrapper.DEFAULT_WRAPPER.wrap(page));
/* 74:77 */     Map<String, TemplateModel> origMap = 
/* 75:78 */       TagModelTools.addParamsToVariable(env, paramWrap);
/* 76:79 */     body.render(env.getOut());
/* 77:80 */     ViewTools.includePagination(site, params, env);
/* 78:81 */     TagModelTools.removeParamsFromVariable(env, paramWrap, origMap);
/* 79:   */   }
/* 80:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.action.tag.JobPostTagModel
 * JD-Core Version:    0.7.0.1
 */