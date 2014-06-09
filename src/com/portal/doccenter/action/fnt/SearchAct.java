/*  1:   */ package com.portal.doccenter.action.fnt;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.utils.ServicesUtils;
/*  4:   */ import com.portal.sysmgr.entity.Site;
/*  5:   */ import com.portal.sysmgr.utils.ContextTools;
/*  6:   */ import com.portal.sysmgr.utils.ViewTools;
/*  7:   */ import javax.servlet.http.HttpServletRequest;
/*  8:   */ import javax.servlet.http.HttpServletResponse;
/*  9:   */ import org.springframework.stereotype.Controller;
/* 10:   */ import org.springframework.ui.ModelMap;
/* 11:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 12:   */ 
/* 13:   */ @Controller
/* 14:   */ public class SearchAct
/* 15:   */ {
/* 16:   */   public static final String SEARCH_INPUT = "tpl.searchInput";
/* 17:   */   public static final String SEARCH_RESULT = "tpl.searchResult";
/* 18:   */   
/* 19:   */   @RequestMapping(value={"/search*.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 20:   */   public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 21:   */   {
/* 22:26 */     Site site = ContextTools.getSite(request);
/* 23:27 */     model.putAll(ServicesUtils.getQueryParams(request));
/* 24:28 */     ViewTools.frontQueryData(request, model, site);
/* 25:29 */     ViewTools.frontQueryPageData(request, model);
/* 26:30 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 27:31 */       "extrafunc/search", "tpl.searchResult");
/* 28:   */   }
/* 29:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.doccenter.action.fnt.SearchAct
 * JD-Core Version:    0.7.0.1
 */