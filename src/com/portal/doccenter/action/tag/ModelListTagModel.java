/*  1:   */ package com.portal.doccenter.action.tag;
/*  2:   */ 
/*  3:   */ import com.portal.doccenter.entity.Model;
/*  4:   */ import com.portal.doccenter.service.ModelService;
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
/* 16:   */ import java.util.List;
/* 17:   */ import java.util.Map;
/* 18:   */ import org.apache.commons.lang.StringUtils;
/* 19:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 20:   */ 
/* 21:   */ public class ModelListTagModel
/* 22:   */   implements TemplateDirectiveModel
/* 23:   */ {
/* 24:   */   public static final String TPL_NAME = "tplName";
/* 25:   */   @Autowired
/* 26:   */   private ModelService modelService;
/* 27:   */   
/* 28:   */   public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
/* 29:   */     throws TemplateException, IOException
/* 30:   */   {
/* 31:41 */     Site site = ViewTools.getSite(env);
/* 32:42 */     String tplName = TagModelTools.getString("tplName", params);
/* 33:43 */     List<Model> list = this.modelService.getList(false, null, null);
/* 34:44 */     Map<String, TemplateModel> paramWrap = new HashMap(
/* 35:45 */       params);
/* 36:46 */     paramWrap.put("list", ObjectWrapper.DEFAULT_WRAPPER.wrap(list));
/* 37:47 */     Map<String, TemplateModel> origMap = TagModelTools.addParamsToVariable(
/* 38:48 */       env, paramWrap);
/* 39:49 */     if (!StringUtils.isBlank(tplName)) {
/* 40:50 */       ViewTools.includeTpl(tplName, site, env);
/* 41:52 */     } else if (body != null) {
/* 42:53 */       body.render(env.getOut());
/* 43:   */     }
/* 44:56 */     TagModelTools.removeParamsFromVariable(env, paramWrap, origMap);
/* 45:   */   }
/* 46:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.action.tag.ModelListTagModel
 * JD-Core Version:    0.7.0.1
 */