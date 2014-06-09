/*  1:   */ package com.portal.recruitcenter.action.fnt;
/*  2:   */ 
/*  3:   */ import com.portal.recruitcenter.entity.JobFairs;
/*  4:   */ import com.portal.recruitcenter.service.JobFairsService;
/*  5:   */ import com.portal.sysmgr.entity.Site;
/*  6:   */ import com.portal.sysmgr.utils.ContextTools;
/*  7:   */ import com.portal.sysmgr.utils.ViewTools;
/*  8:   */ import javax.servlet.http.HttpServletRequest;
/*  9:   */ import javax.servlet.http.HttpServletResponse;
/* 10:   */ import org.apache.commons.lang.StringUtils;
/* 11:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 12:   */ import org.springframework.stereotype.Controller;
/* 13:   */ import org.springframework.ui.ModelMap;
/* 14:   */ import org.springframework.web.bind.annotation.PathVariable;
/* 15:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 16:   */ 
/* 17:   */ @Controller
/* 18:   */ public class JobFairsAct
/* 19:   */ {
/* 20:   */   public static final String FAIRS_INDEX = "tpl.fairsIndex";
/* 21:   */   @Autowired
/* 22:   */   private JobFairsService jobFairsService;
/* 23:   */   
/* 24:   */   @RequestMapping(value={"/fairs/detail{id}.jsp"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 25:   */   public String eduList(@PathVariable("id") Integer id, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 26:   */   {
/* 27:30 */     Site site = ContextTools.getSite(request);
/* 28:31 */     ViewTools.frontData(request, model, site);
/* 29:32 */     JobFairs fairs = this.jobFairsService.findById(id);
/* 30:33 */     model.addAttribute("fairs", fairs);
/* 31:34 */     ViewTools.frontPageData(request, model);
/* 32:35 */     if (StringUtils.isBlank(fairs.getTplAddress())) {
/* 33:36 */       return ViewTools.getTplPath(request, site.getSolutionPath(), 
/* 34:37 */         "fairs", "tpl.fairsIndex");
/* 35:   */     }
/* 36:39 */     return fairs.getTplAddress();
/* 37:   */   }
/* 38:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.action.fnt.JobFairsAct
 * JD-Core Version:    0.7.0.1
 */