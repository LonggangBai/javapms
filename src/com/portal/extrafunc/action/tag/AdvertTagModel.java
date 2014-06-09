/*  1:   */ package com.portal.extrafunc.action.tag;
/*  2:   */ 
/*  3:   */ import com.portal.extrafunc.entity.Advert;
/*  4:   */ import com.portal.extrafunc.service.AdvertService;
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
/* 15:   */ import java.util.Date;
/* 16:   */ import java.util.HashMap;
/* 17:   */ import java.util.List;
/* 18:   */ import java.util.Map;
/* 19:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 20:   */ 
/* 21:   */ public class AdvertTagModel
/* 22:   */   implements TemplateDirectiveModel
/* 23:   */ {
/* 24:   */   public static final String PARAM_ID = "id";
/* 25:   */   public static final String PARAM_SLOT_ID = "sId";
/* 26:   */   public static final String PARAM_CUSTOM = "custom";
/* 27:   */   @Autowired
/* 28:   */   private AdvertService service;
/* 29:   */   
/* 30:   */   public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
/* 31:   */     throws TemplateException, IOException
/* 32:   */   {
/* 33:43 */     Site site = ViewTools.getSite(env);
/* 34:44 */     Integer id = TagModelTools.getInt("id", params);
/* 35:45 */     Integer sId = TagModelTools.getInt("sId", params);
/* 36:46 */     Boolean custom = TagModelTools.getBool("custom", params);
/* 37:47 */     Map<String, TemplateModel> paramWrap = new HashMap(
/* 38:48 */       params);
/* 39:49 */     boolean out = false;
/* 40:50 */     if (id != null)
/* 41:   */     {
/* 42:51 */       Advert a = this.service.findById(id);
/* 43:52 */       if ((a.getEnable().booleanValue()) && (a.getStartTime().before(new Date()))) {
/* 44:53 */         if ((a.getEndTime() != null) && (a.getEndTime().after(new Date())))
/* 45:   */         {
/* 46:54 */           out = true;
/* 47:55 */           paramWrap.put("bean", 
/* 48:56 */             ObjectWrapper.DEFAULT_WRAPPER.wrap(a));
/* 49:   */         }
/* 50:   */         else
/* 51:   */         {
/* 52:58 */           out = true;
/* 53:59 */           paramWrap.put("bean", 
/* 54:60 */             ObjectWrapper.DEFAULT_WRAPPER.wrap(a));
/* 55:   */         }
/* 56:   */       }
/* 57:   */     }
/* 58:   */     else
/* 59:   */     {
/* 60:64 */       out = true;
/* 61:65 */       List<Advert> list = this.service.getListByTag(site.getId(), sId);
/* 62:66 */       paramWrap.put("list", ObjectWrapper.DEFAULT_WRAPPER.wrap(list));
/* 63:   */     }
/* 64:68 */     Map<String, TemplateModel> origMap = TagModelTools.addParamsToVariable(
/* 65:69 */       env, paramWrap);
/* 66:70 */     if ((custom != null) && (custom.booleanValue()))
/* 67:   */     {
/* 68:71 */       if (out) {
/* 69:72 */         body.render(env.getOut());
/* 70:   */       }
/* 71:   */     }
/* 72:   */     else {
/* 73:75 */       ViewTools.includeTpl("adv", site, env);
/* 74:   */     }
/* 75:77 */     TagModelTools.removeParamsFromVariable(env, paramWrap, origMap);
/* 76:   */   }
/* 77:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.action.tag.AdvertTagModel
 * JD-Core Version:    0.7.0.1
 */