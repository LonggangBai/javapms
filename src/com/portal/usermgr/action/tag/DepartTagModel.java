/*  1:   */ package com.portal.usermgr.action.tag;
/*  2:   */ 
/*  3:   */ import com.portal.sysmgr.entity.Site;
/*  4:   */ import com.portal.sysmgr.utils.TagModelTools;
/*  5:   */ import com.portal.sysmgr.utils.ViewTools;
/*  6:   */ import com.portal.usermgr.entity.Depart;
/*  7:   */ import com.portal.usermgr.service.DepartService;
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
/* 20:   */ public class DepartTagModel
/* 21:   */   implements TemplateDirectiveModel
/* 22:   */ {
/* 23:   */   @Autowired
/* 24:   */   private DepartService departService;
/* 25:   */   
/* 26:   */   public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
/* 27:   */     throws TemplateException, IOException
/* 28:   */   {
/* 29:30 */     Site site = ViewTools.getSite(env);
/* 30:31 */     List<Depart> list = this.departService.getListByTag(site.getId());
/* 31:32 */     Map<String, TemplateModel> paramWrap = new HashMap(
/* 32:33 */       params);
/* 33:34 */     paramWrap.put("list", ObjectWrapper.DEFAULT_WRAPPER.wrap(list));
/* 34:35 */     Map<String, TemplateModel> origMap = TagModelTools.addParamsToVariable(
/* 35:36 */       env, paramWrap);
/* 36:37 */     body.render(env.getOut());
/* 37:38 */     ViewTools.includePagination(site, params, env);
/* 38:39 */     TagModelTools.removeParamsFromVariable(env, paramWrap, origMap);
/* 39:   */   }
/* 40:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.action.tag.DepartTagModel
 * JD-Core Version:    0.7.0.1
 */