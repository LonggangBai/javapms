/*  1:   */ package com.portal.doccenter.action.tag;
/*  2:   */ 
/*  3:   */ import com.portal.doccenter.entity.Article;
/*  4:   */ import com.portal.doccenter.service.ArticleService;
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
/* 15:   */ import java.io.PrintStream;
/* 16:   */ import java.util.HashMap;
/* 17:   */ import java.util.Map;
/* 18:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 19:   */ 
/* 20:   */ public class DocTagModel
/* 21:   */   implements TemplateDirectiveModel
/* 22:   */ {
/* 23:   */   public static final String PARAM_ID = "id";
/* 24:   */   public static final String PRAMA_NEXT = "next";
/* 25:   */   public static final String PARAM_CHANNEL_ID = "cId";
/* 26:   */   @Autowired
/* 27:   */   private ArticleService articleService;
/* 28:   */   
/* 29:   */   public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
/* 30:   */     throws TemplateException, IOException
/* 31:   */   {
/* 32:47 */     Integer id = getId(params);
/* 33:48 */     Boolean next = TagModelTools.getBool("next", params);
/* 34:   */     Article article;
/* 36:50 */     if (next == null)
/* 37:   */     {
/* 38:51 */       article = this.articleService.findById(id);
/* 39:   */     }
/* 40:   */     else
/* 41:   */     {
/* 42:53 */       Site site = ViewTools.getSite(env);
/* 43:54 */       Integer channelId = TagModelTools.getInt("cId", params);
/* 44:55 */       article = this.articleService.getSide(id, site.getId(), channelId, next.booleanValue());
/* 45:   */     }
/* 46:58 */     Map<String, TemplateModel> paramWrap = new HashMap(
/* 47:59 */       params);
/* 48:60 */     paramWrap.put("bean", ObjectWrapper.DEFAULT_WRAPPER.wrap(article));
/* 49:61 */     Map<String, TemplateModel> origMap = TagModelTools.addParamsToVariable(
/* 50:62 */       env, paramWrap);
/* 51:63 */     if (body != null) {
/* 52:64 */       body.render(env.getOut());
/* 53:   */     }
/* 54:66 */     TagModelTools.removeParamsFromVariable(env, paramWrap, origMap);
/* 55:   */   }
/* 56:   */   
/* 57:   */   private Integer getId(Map<String, TemplateModel> params)
/* 58:   */     throws TemplateException
/* 59:   */   {
/* 60:71 */     Integer id = TagModelTools.getInt("id", params);
/* 61:72 */     if (id != null) {
/* 62:73 */       return id;
/* 63:   */     }
/* 64:75 */     System.out.println("缺少必要参数!");
/* 65:76 */     return Integer.valueOf(0);
/* 66:   */   }
/* 67:   */ }



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.portal.doccenter.action.tag.DocTagModel

 * JD-Core Version:    0.7.0.1

 */