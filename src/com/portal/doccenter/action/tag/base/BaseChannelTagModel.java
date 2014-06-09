/*  1:   */ package com.portal.doccenter.action.tag.base;
/*  2:   */ 
/*  3:   */ import com.portal.doccenter.service.ChannelService;
/*  4:   */ import com.portal.sysmgr.utils.TagModelTools;
/*  5:   */ import freemarker.template.TemplateDirectiveModel;
/*  6:   */ import freemarker.template.TemplateException;
/*  7:   */ import freemarker.template.TemplateModel;
/*  8:   */ import java.util.Map;
/*  9:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 10:   */ 
/* 11:   */ public abstract class BaseChannelTagModel
/* 12:   */   implements TemplateDirectiveModel
/* 13:   */ {
/* 14:   */   public static final String PARAM_PARENT_ID = "pId";
/* 15:   */   public static final String PARAM_SITE_ID = "sId";
/* 16:   */   public static final String PARAM_IS_ALONE = "isAlone";
/* 17:   */   @Autowired
/* 18:   */   protected ChannelService channelService;
/* 19:   */   
/* 20:   */   protected boolean getAlone(Map<String, TemplateModel> params)
/* 21:   */     throws TemplateException
/* 22:   */   {
/* 23:37 */     Boolean isAlone = TagModelTools.getBool("isAlone", params);
/* 24:38 */     return (isAlone != null) && (isAlone.booleanValue());
/* 25:   */   }
/* 26:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.action.tag.base.BaseChannelTagModel
 * JD-Core Version:    0.7.0.1
 */