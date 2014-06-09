/*  1:   */ package com.portal.sysmgr.action.tag;
/*  2:   */ 
/*  3:   */ import com.portal.sysmgr.utils.TagModelTools;
/*  4:   */ import freemarker.core.Environment;
/*  5:   */ import freemarker.template.TemplateDirectiveBody;
/*  6:   */ import freemarker.template.TemplateDirectiveModel;
/*  7:   */ import freemarker.template.TemplateException;
/*  8:   */ import freemarker.template.TemplateModel;
/*  9:   */ import java.io.IOException;
/* 10:   */ import java.util.Map;
/* 11:   */ import org.apache.shiro.SecurityUtils;
/* 12:   */ import org.apache.shiro.subject.Subject;
/* 13:   */ 
/* 14:   */ public class PermTagModel
/* 15:   */   implements TemplateDirectiveModel
/* 16:   */ {
/* 17:   */   public static final String PARAM_URL = "perm";
/* 18:   */   
/* 19:   */   public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
/* 20:   */     throws TemplateException, IOException
/* 21:   */   {
/* 22:30 */     String perm = TagModelTools.getString("perm", params);
/* 23:31 */     Subject subject = SecurityUtils.getSubject();
/* 24:32 */     if (subject.isPermitted(perm)) {
/* 25:33 */       body.render(env.getOut());
/* 26:   */     }
/* 27:   */   }
/* 28:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.sysmgr.action.tag.PermTagModel
 * JD-Core Version:    0.7.0.1
 */