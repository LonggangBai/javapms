/*  1:   */ package com.portal.extrafunc.action.tag;
/*  2:   */ 
/*  3:   */ import com.portal.extrafunc.entity.Category;
/*  4:   */ import com.portal.extrafunc.service.CategoryService;
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
/* 18:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 19:   */ 
/* 20:   */ public class CategoryTagModel
/* 21:   */   implements TemplateDirectiveModel
/* 22:   */ {
/* 23:   */   @Autowired
/* 24:   */   private CategoryService service;
/* 25:   */   
/* 26:   */   public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
/* 27:   */     throws TemplateException, IOException
/* 28:   */   {
/* 29:36 */     Site site = ViewTools.getSite(env);
/* 30:37 */     List<Category> list = this.service.getList(site.getId(), null, null);
/* 31:38 */     Map<String, TemplateModel> paramWrap = new HashMap(
/* 32:39 */       params);
/* 33:40 */     paramWrap.put("list", ObjectWrapper.DEFAULT_WRAPPER.wrap(list));
/* 34:41 */     Map<String, TemplateModel> origMap = TagModelTools.addParamsToVariable(
/* 35:42 */       env, paramWrap);
/* 36:43 */     body.render(env.getOut());
/* 37:44 */     TagModelTools.removeParamsFromVariable(env, paramWrap, origMap);
/* 38:   */   }
/* 39:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.action.tag.CategoryTagModel
 * JD-Core Version:    0.7.0.1
 */