/*   1:    */ package com.portal.doccenter.action.tag.base;
/*   2:    */ 
/*   3:    */ import com.portal.doccenter.service.ArticleService;
/*   4:    */ import com.portal.doccenter.service.ChannelService;
/*   5:    */ import com.portal.sysmgr.entity.Site;
/*   6:    */ import com.portal.sysmgr.service.SiteService;
/*   7:    */ import com.portal.sysmgr.utils.TagModelTools;
/*   8:    */ import com.portal.sysmgr.utils.ViewTools;
/*   9:    */ import freemarker.core.Environment;
/*  10:    */ import freemarker.template.TemplateDirectiveModel;
/*  11:    */ import freemarker.template.TemplateException;
/*  12:    */ import freemarker.template.TemplateModel;
/*  13:    */ import java.util.Map;
/*  14:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  15:    */ 
/*  16:    */ public abstract class BaseDocTagModel
/*  17:    */   implements TemplateDirectiveModel
/*  18:    */ {
/*  19:    */   public static final String PARAM_CHANNEL_ID = "cId";
/*  20:    */   public static final String PARAM_MODEL_ID = "mId";
/*  21:    */   public static final String PARAM_DEPART_ID = "dId";
/*  22:    */   public static final String PARAM_CALL_LEVEL = "callLevel";
/*  23:    */   public static final String PARAM_TYPE_ID = "tId";
/*  24:    */   public static final String PARAM_RECOMMEND = "recommend";
/*  25:    */   public static final String PARAM_ORDER_BY = "orderBy";
/*  26:    */   @Autowired
/*  27:    */   protected ChannelService channelService;
/*  28:    */   @Autowired
/*  29:    */   protected SiteService siteService;
/*  30:    */   @Autowired
/*  31:    */   protected ArticleService articleService;
/*  32:    */   
/*  33:    */   protected Integer[] getChannelIds(Map<String, TemplateModel> params)
/*  34:    */     throws TemplateException
/*  35:    */   {
/*  36: 57 */     Integer[] ids = TagModelTools.getIntArray("cId", params);
/*  37: 58 */     if ((ids != null) && (ids.length > 0)) {
/*  38: 59 */       return ids;
/*  39:    */     }
/*  40: 61 */     return null;
/*  41:    */   }
/*  42:    */   
/*  43:    */   protected Integer[] getModelIds(Map<String, TemplateModel> params)
/*  44:    */     throws TemplateException
/*  45:    */   {
/*  46: 67 */     Integer[] ids = TagModelTools.getIntArray("mId", params);
/*  47: 68 */     if ((ids != null) && (ids.length > 0)) {
/*  48: 69 */       return ids;
/*  49:    */     }
/*  50: 71 */     return null;
/*  51:    */   }
/*  52:    */   
/*  53:    */   protected int getCallLevel(Map<String, TemplateModel> params)
/*  54:    */     throws TemplateException
/*  55:    */   {
/*  56: 77 */     Integer callLevel = TagModelTools.getInt("callLevel", params);
/*  57: 78 */     if ((callLevel == null) || (callLevel.intValue() < 0)) {
/*  58: 79 */       return 0;
/*  59:    */     }
/*  60: 81 */     return callLevel.intValue();
/*  61:    */   }
/*  62:    */   
/*  63:    */   protected Integer[] getTypeIds(Map<String, TemplateModel> params)
/*  64:    */     throws TemplateException
/*  65:    */   {
/*  66: 87 */     Integer[] typeIds = TagModelTools.getIntArray("tId", params);
/*  67: 88 */     return typeIds;
/*  68:    */   }
/*  69:    */   
/*  70:    */   protected Boolean getRecommend(Map<String, TemplateModel> params)
/*  71:    */     throws TemplateException
/*  72:    */   {
/*  73: 93 */     String recommend = TagModelTools.getString("recommend", params);
/*  74: 94 */     if ("1".equals(recommend)) {
/*  75: 95 */       return Boolean.valueOf(true);
/*  76:    */     }
/*  77: 97 */     return null;
/*  78:    */   }
/*  79:    */   
/*  80:    */   protected int getOrderBy(Map<String, TemplateModel> params)
/*  81:    */     throws TemplateException
/*  82:    */   {
/*  83:103 */     Integer orderBy = TagModelTools.getInt("orderBy", params);
/*  84:104 */     if (orderBy == null) {
/*  85:105 */       return 0;
/*  86:    */     }
/*  87:107 */     return orderBy.intValue();
/*  88:    */   }
/*  89:    */   
/*  90:    */   protected Object getData(Map<String, TemplateModel> params, Environment env)
/*  91:    */     throws TemplateException
/*  92:    */   {
/*  93:113 */     int orderBy = getOrderBy(params);
/*  94:114 */     Boolean recommend = getRecommend(params);
/*  95:115 */     Integer siteId = ViewTools.getSite(env).getId();
/*  96:116 */     Integer[] typeIds = getTypeIds(params);
/*  97:117 */     int count = ViewTools.getCount(params);
/*  98:    */     
/*  99:119 */     Integer[] channelIds = getChannelIds(params);
/* 100:120 */     if (channelIds != null)
/* 101:    */     {
/* 102:121 */       Integer[] modelIds = getModelIds(params);
/* 103:122 */       int callLevel = getCallLevel(params);
/* 104:123 */       if (isPage())
/* 105:    */       {
/* 106:124 */         int pageNo = ViewTools.getPageNo(env);
/* 107:125 */         return this.articleService.getPageTagByChannelIds(channelIds, 
/* 108:126 */           siteId, modelIds, typeIds, recommend, orderBy, 
/* 109:127 */           callLevel, pageNo, count);
/* 110:    */       }
/* 111:129 */       int first = ViewTools.getFirst(params);
/* 112:130 */       return this.articleService.getListTagByChannelIds(channelIds, 
/* 113:131 */         siteId, modelIds, typeIds, recommend, orderBy, 
/* 114:132 */         callLevel, Integer.valueOf(first), Integer.valueOf(count));
/* 115:    */     }
/* 116:136 */     Integer[] modelIds = getModelIds(params);
/* 117:137 */     if (modelIds != null)
/* 118:    */     {
/* 119:138 */       if (isPage())
/* 120:    */       {
/* 121:139 */         int pageNo = ViewTools.getPageNo(env);
/* 122:140 */         return this.articleService.getPageTagByModelIds(modelIds, typeIds, 
/* 123:141 */           recommend, orderBy, pageNo, count);
/* 124:    */       }
/* 125:143 */       int first = ViewTools.getFirst(params);
/* 126:144 */       return this.articleService.getListTagByModelIds(modelIds, typeIds, 
/* 127:145 */         recommend, orderBy, Integer.valueOf(first), Integer.valueOf(count));
/* 128:    */     }
/* 129:149 */     if (isPage())
/* 130:    */     {
/* 131:150 */       int pageNo = ViewTools.getPageNo(env);
/* 132:151 */       return this.articleService.getPageTagByChannelIds(null, siteId, null, 
/* 133:152 */         typeIds, recommend, orderBy, 0, pageNo, count);
/* 134:    */     }
/* 135:154 */     int first = ViewTools.getFirst(params);
/* 136:155 */     return this.articleService.getListTagByChannelIds(null, siteId, null, 
/* 137:156 */       typeIds, recommend, orderBy, 0, Integer.valueOf(first), Integer.valueOf(count));
/* 138:    */   }
/* 139:    */   
/* 140:    */   protected abstract boolean isPage();
/* 141:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.action.tag.base.BaseDocTagModel
 * JD-Core Version:    0.7.0.1
 */