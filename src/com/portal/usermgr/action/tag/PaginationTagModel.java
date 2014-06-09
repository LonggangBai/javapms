/*  1:   */ package com.portal.usermgr.action.tag;
/*  2:   */ 
/*  3:   */ import com.portal.sysmgr.entity.Site;
/*  4:   */ import com.portal.sysmgr.utils.ViewTools;
/*  5:   */ import freemarker.core.Environment;
/*  6:   */ import freemarker.template.TemplateDirectiveBody;
/*  7:   */ import freemarker.template.TemplateDirectiveModel;
/*  8:   */ import freemarker.template.TemplateException;
/*  9:   */ import freemarker.template.TemplateModel;
/* 10:   */ import java.io.IOException;
/* 11:   */ import java.util.Map;
/* 12:   */ 
/* 13:   */ public class PaginationTagModel
/* 14:   */   implements TemplateDirectiveModel
/* 15:   */ {
/* 16:   */   public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
/* 17:   */     throws TemplateException, IOException
/* 18:   */   {
/* 19:26 */     Site site = ViewTools.getSite(env);
/* 20:27 */     ViewTools.includePagination(site, params, env);
/* 21:   */   }
/* 22:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.usermgr.action.tag.PaginationTagModel
 * JD-Core Version:    0.7.0.1
 */