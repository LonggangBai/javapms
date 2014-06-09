/*  1:   */ package com.portal.doccenter.action.fnt;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.utils.ResponseUtils;
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
/* 14:   */ public class RssAct
/* 15:   */ {
/* 16:   */   public static final String RSS_TPL = "tpl.rss";
/* 17:   */   
/* 18:   */   @RequestMapping(value={"/rss.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 19:   */   public String rss(HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 20:   */   {
/* 21:25 */     response.setContentType("text/xml;charset=UTF-8");
/* 22:26 */     Site site = ContextTools.getSite(request);
/* 23:27 */     ViewTools.frontData(request, model, site);
/* 24:28 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 25:29 */       "extrafunc/rss", "tpl.rss");
/* 26:   */   }
/* 27:   */   
/* 28:   */   @RequestMapping(value={"/showmsg.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 29:   */   public void showmsg(HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 30:   */   {
/* 31:35 */     ResponseUtils.render(response, "text/html;charset=UTF-8", "ssssJAVAPMSx");
/* 32:   */   }
/* 33:   */ }



/* Location:           F:\jspss\ssssss\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.portal.doccenter.action.fnt.RssAct

 * JD-Core Version:    0.7.0.1

 */