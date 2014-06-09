/*  1:   */ package com.portal.sysmgr.action.tag;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.utils.StringBeanUtils;
/*  4:   */ import com.portal.sysmgr.utils.TagModelTools;
/*  5:   */ import freemarker.core.Environment;
/*  6:   */ import freemarker.template.TemplateDirectiveBody;
/*  7:   */ import freemarker.template.TemplateDirectiveModel;
/*  8:   */ import freemarker.template.TemplateException;
/*  9:   */ import freemarker.template.TemplateModel;
/* 10:   */ import java.io.IOException;
/* 11:   */ import java.io.Writer;
/* 12:   */ import java.util.Map;
/* 13:   */ 
/* 14:   */ public class StrLimitTagModel
/* 15:   */   implements TemplateDirectiveModel
/* 16:   */ {
/* 17:   */   public static final String PARAM_S = "s";
/* 18:   */   public static final String PARAM_LEN = "l";
/* 19:   */   
/* 20:   */   public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
/* 21:   */     throws TemplateException, IOException
/* 22:   */   {
/* 23:29 */     String s = TagModelTools.getString("s", params);
/* 24:30 */     Integer len = TagModelTools.getInt("l", params);
/* 25:31 */     String append = "&hellip;";
/* 26:32 */     if (s != null)
/* 27:   */     {
/* 28:33 */       Writer out = env.getOut();
/* 29:34 */       if (len != null) {
/* 30:35 */         out.append(StringBeanUtils.textCut(s, len.intValue(), append));
/* 31:   */       } else {
/* 32:37 */         out.append(s);
/* 33:   */       }
/* 34:   */     }
/* 35:   */   }
/* 36:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.sysmgr.action.tag.StrLimitTagModel
 * JD-Core Version:    0.7.0.1
 */