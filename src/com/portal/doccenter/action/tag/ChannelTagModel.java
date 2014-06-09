/*  1:   */ package com.portal.doccenter.action.tag;
/*  2:   */ 
/*  3:   */ import com.portal.doccenter.entity.Channel;
/*  4:   */ import com.portal.doccenter.service.ChannelService;
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
/* 18:   */ import org.apache.commons.lang.StringUtils;
/* 19:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 20:   */ 
/* 21:   */ public class ChannelTagModel
/* 22:   */   implements TemplateDirectiveModel
/* 23:   */ {
/* 24:   */   public static final String PARAM_ID = "id";
/* 25:   */   public static final String PARAM_PATH = "path";
/* 26:   */   public static final String PARAM_SITE_ID = "siteId";
/* 27:   */   @Autowired
/* 28:   */   private ChannelService channelService;
/* 29:   */   
/* 30:   */   public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
/* 31:   */     throws TemplateException, IOException
/* 32:   */   {
/* 33:48 */     Site site = ViewTools.getSite(env);
/* 34:49 */     Integer id = TagModelTools.getInt("id", params);
/* 36:   */     Channel channel;
/* 37:51 */     if (id != null)
/* 38:   */     {
/* 39:52 */       channel = this.channelService.findById(id);
/* 40:   */     }
/* 41:   */     else
/* 42:   */     {
/* 43:54 */       String path = TagModelTools.getString("path", params);
/* 44:55 */       if (StringUtils.isBlank(path))
/* 45:   */       {
/* 46:56 */         System.out.println("缺少必要参数!");
/* 47:57 */         return;
/* 48:   */       }
/* 49:59 */       Integer siteId = TagModelTools.getInt("siteId", params);
/* 50:60 */       if (siteId == null) {
/* 51:61 */         siteId = site.getId();
/* 52:   */       }
/* 53:63 */       channel = this.channelService.findByPathForTag(path, siteId);
/* 54:   */     }
/* 55:66 */     Map<String, TemplateModel> paramWrap = new HashMap(
/* 56:67 */       params);
/* 57:68 */     paramWrap.put("bean", ObjectWrapper.DEFAULT_WRAPPER.wrap(channel));
/* 58:69 */     Map<String, TemplateModel> origMap = 
/* 59:70 */       TagModelTools.addParamsToVariable(env, paramWrap);
/* 60:71 */     if (body != null) {
/* 61:72 */       body.render(env.getOut());
/* 62:   */     }
/* 63:74 */     TagModelTools.removeParamsFromVariable(env, paramWrap, origMap);
/* 64:   */   }
/* 65:   */ }



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.portal.doccenter.action.tag.ChannelTagModel

 * JD-Core Version:    0.7.0.1

 */