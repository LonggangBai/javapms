/*  1:   */ package com.portal.datacenter.docdata.action.fnt.tag;
/*  2:   */ 
/*  3:   */ import com.portal.datacenter.docdata.entity.ProgramDownload;
/*  4:   */ import com.portal.datacenter.docdata.service.ProgramDownloadService;
/*  5:   */ import com.portal.sysmgr.utils.TagModelTools;
/*  6:   */ import freemarker.core.Environment;
/*  7:   */ import freemarker.template.ObjectWrapper;
/*  8:   */ import freemarker.template.TemplateDirectiveBody;
/*  9:   */ import freemarker.template.TemplateDirectiveModel;
/* 10:   */ import freemarker.template.TemplateException;
/* 11:   */ import freemarker.template.TemplateModel;
/* 12:   */ import java.io.IOException;
/* 13:   */ import java.util.HashMap;
/* 14:   */ import java.util.Map;
/* 15:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 16:   */ 
/* 17:   */ public class ProgramTagModel
/* 18:   */   implements TemplateDirectiveModel
/* 19:   */ {
/* 20:   */   @Autowired
/* 21:   */   private ProgramDownloadService programDownloadService;
/* 22:   */   
/* 23:   */   public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
/* 24:   */     throws TemplateException, IOException
/* 25:   */   {
/* 26:33 */     ProgramDownload pd = this.programDownloadService.findUnique();
/* 27:34 */     Integer count = Integer.valueOf(0);
/* 28:35 */     if (pd != null) {
/* 29:36 */       count = pd.getCount();
/* 30:   */     }
/* 31:38 */     Map<String, TemplateModel> paramWrap = new HashMap(
/* 32:39 */       params);
/* 33:40 */     paramWrap.put("count", ObjectWrapper.DEFAULT_WRAPPER.wrap(count));
/* 34:41 */     Map<String, TemplateModel> origMap = TagModelTools.addParamsToVariable(
/* 35:42 */       env, paramWrap);
/* 36:43 */     body.render(env.getOut());
/* 37:44 */     TagModelTools.removeParamsFromVariable(env, paramWrap, origMap);
/* 38:   */   }
/* 39:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.datacenter.docdata.action.fnt.tag.ProgramTagModel
 * JD-Core Version:    0.7.0.1
 */