/*  1:   */ package com.portal.recruitcenter.action.tag;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.page.Pagination;
/*  4:   */ import com.portal.recruitcenter.service.ResumeService;
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
/* 19:   */ public class ResumeTagModel
/* 20:   */   implements TemplateDirectiveModel
/* 21:   */ {
/* 22:   */   public static final String PARAM_KEY = "key";
/* 23:   */   public static final String PARAM_PERSONAL_ID = "personalId";
/* 24:   */   public static final String PARAM_METIER_ID = "metierId";
/* 25:   */   public static final String PARAM_SPECIAL_ID = "specialId";
/* 26:   */   public static final String PARAM_METIER_ID1 = "metierId1";
/* 27:   */   public static final String PARAM_SPECIAL_ID1 = "specialId1";
/* 28:   */   public static final String PARAM_EDU = "edu";
/* 29:   */   public static final String PARAM_INDUSTRY_ID = "industryId";
/* 30:   */   public static final String PARAM_INDUSTRY_ID1 = "industryId1";
/* 31:   */   public static final String PARAM_WAGE = "wage";
/* 32:   */   public static final String PARAM_MINWORK = "minwork";
/* 33:   */   public static final String PARAM_MAXWORK = "maxwork";
/* 34:   */   public static final String PARAM_GENDER = "gender";
/* 35:   */   public static final String PARAM_SHOW = "show";
/* 36:   */   @Autowired
/* 37:   */   private ResumeService resumeService;
/* 38:   */   
/* 39:   */   public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
/* 40:   */     throws TemplateException, IOException
/* 41:   */   {
/* 42:45 */     Site site = ViewTools.getSite(env);
/* 43:46 */     String key = TagModelTools.getString("key", params);
/* 44:47 */     Integer personalId = TagModelTools.getInt("personalId", params);
/* 45:48 */     Integer metierId = TagModelTools.getInt("metierId", params);
/* 46:49 */     if (metierId == null) {
/* 47:50 */       metierId = TagModelTools.getInt("metierId1", params);
/* 48:   */     }
/* 49:52 */     Integer industryId = TagModelTools.getInt("industryId", params);
/* 50:53 */     if (industryId == null) {
/* 51:54 */       industryId = TagModelTools.getInt("industryId1", params);
/* 52:   */     }
/* 53:56 */     Integer specialId = TagModelTools.getInt("specialId", params);
/* 54:57 */     if (specialId == null) {
/* 55:58 */       specialId = TagModelTools.getInt("specialId1", params);
/* 56:   */     }
/* 57:60 */     Byte wage = TagModelTools.getByte("wage", params);
/* 58:61 */     Byte edu = TagModelTools.getByte("edu", params);
/* 59:62 */     Byte minwork = TagModelTools.getByte("minwork", params);
/* 60:63 */     Byte maxwork = TagModelTools.getByte("maxwork", params);
/* 61:64 */     Boolean gender = TagModelTools.getBool("gender", params);
/* 62:65 */     Boolean show = TagModelTools.getBool("show", params);
/* 63:66 */     Pagination page = this.resumeService.getPageByTag(key, personalId, metierId, 
/* 64:67 */       industryId, specialId, wage, edu, minwork, maxwork, gender, 
/* 65:68 */       show, ViewTools.getPageNo(env), ViewTools.getCount(params));
/* 66:69 */     Map<String, TemplateModel> paramWrap = new HashMap(
/* 67:70 */       params);
/* 68:71 */     paramWrap.put("page", ObjectWrapper.DEFAULT_WRAPPER.wrap(page));
/* 69:72 */     Map<String, TemplateModel> origMap = 
/* 70:73 */       TagModelTools.addParamsToVariable(env, paramWrap);
/* 71:74 */     body.render(env.getOut());
/* 72:75 */     ViewTools.includePagination(site, params, env);
/* 73:76 */     TagModelTools.removeParamsFromVariable(env, paramWrap, origMap);
/* 74:   */   }
/* 75:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.action.tag.ResumeTagModel
 * JD-Core Version:    0.7.0.1
 */