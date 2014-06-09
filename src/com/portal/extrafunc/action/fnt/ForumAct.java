/*  1:   */ package com.portal.extrafunc.action.fnt;
/*  2:   */ 
/*  3:   */ import com.portal.sysmgr.entity.Site;
/*  4:   */ import com.portal.sysmgr.utils.ContextTools;
/*  5:   */ import com.portal.sysmgr.utils.ViewTools;
/*  6:   */ import javax.servlet.http.HttpServletRequest;
/*  7:   */ import org.springframework.stereotype.Controller;
/*  8:   */ import org.springframework.ui.ModelMap;
/*  9:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 10:   */ 
/* 11:   */ @Controller
/* 12:   */ public class ForumAct
/* 13:   */ {
/* 14:   */   public static final String FORUM_INDEX = "tpl.forumIndex";
/* 15:   */   
/* 16:   */   @RequestMapping(value={"/forum.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 17:   */   public String index(HttpServletRequest request, ModelMap model)
/* 18:   */   {
/* 19:29 */     Site site = ContextTools.getSite(request);
/* 20:30 */     ViewTools.frontData(request, model, site);
/* 21:31 */     return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 22:32 */       "extrafunc/forum", "tpl.forumIndex");
/* 23:   */   }
/* 24:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.action.fnt.ForumAct
 * JD-Core Version:    0.7.0.1
 */