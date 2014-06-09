/*  1:   */ package com.portal.recruitcenter.action;
/*  2:   */ 
/*  3:   */ import com.javapms.basic.page.Pagination;
/*  4:   */ import com.javapms.basic.page.SimplePage;
/*  5:   */ import com.portal.recruitcenter.entity.JobIntent;
/*  6:   */ import com.portal.recruitcenter.service.JobIntentService;
/*  7:   */ import javax.servlet.http.HttpServletRequest;
/*  8:   */ import org.slf4j.Logger;
/*  9:   */ import org.slf4j.LoggerFactory;
/* 10:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 11:   */ import org.springframework.stereotype.Controller;
/* 12:   */ import org.springframework.ui.ModelMap;
/* 13:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 14:   */ 
/* 15:   */ @Controller
/* 16:   */ public class JobIntentAct
/* 17:   */ {
/* 18:21 */   private static final Logger log = LoggerFactory.getLogger(JobIntentAct.class);
/* 19:   */   @Autowired
/* 20:   */   private JobIntentService service;
/* 21:   */   
/* 22:   */   @RequestMapping({"/jobintent/v_list.do"})
/* 23:   */   public String list(Integer pageNo, HttpServletRequest request, ModelMap model)
/* 24:   */   {
/* 25:26 */     Pagination pagination = this.service.getPage(SimplePage.cpn(pageNo), 
/* 26:27 */       20);
/* 27:28 */     model.addAttribute("pagination", pagination);
/* 28:29 */     model.addAttribute("pageNo", Integer.valueOf(pagination.getPageNo()));
/* 29:30 */     return "jobintent/list";
/* 30:   */   }
/* 31:   */   
/* 32:   */   @RequestMapping({"/jobintent/v_add.do"})
/* 33:   */   public String add(ModelMap model)
/* 34:   */   {
/* 35:35 */     return "jobintent/add";
/* 36:   */   }
/* 37:   */   
/* 38:   */   @RequestMapping({"/jobintent/v_edit.do"})
/* 39:   */   public String edit(Integer id, Integer pageNo, HttpServletRequest request, ModelMap model)
/* 40:   */   {
/* 41:41 */     model.addAttribute("jobIntent", this.service.findById(id));
/* 42:42 */     model.addAttribute("pageNo", pageNo);
/* 43:43 */     return "jobintent/edit";
/* 44:   */   }
/* 45:   */   
/* 46:   */   @RequestMapping({"/jobintent/o_save.do"})
/* 47:   */   public String save(JobIntent bean, Integer resumeId, Integer metierId, Integer metierId2, Integer industryId, HttpServletRequest request, ModelMap model)
/* 48:   */   {
/* 49:50 */     bean = this.service.save(bean, resumeId, metierId, metierId2, industryId);
/* 50:51 */     log.info("save JobIntent id={}", bean.getId());
/* 51:52 */     return "redirect:v_list.do";
/* 52:   */   }
/* 53:   */   
/* 54:   */   @RequestMapping({"/jobintent/o_update.do"})
/* 55:   */   public String update(JobIntent bean, Integer resumeId, Integer metierId, Integer metierId2, Integer industryId, Integer pageNo, HttpServletRequest request, ModelMap model)
/* 56:   */   {
/* 57:59 */     bean = this.service.update(bean, resumeId, metierId, metierId2, industryId);
/* 58:60 */     log.info("update JobIntent id={}.", bean.getId());
/* 59:61 */     return list(pageNo, request, model);
/* 60:   */   }
/* 61:   */   
/* 62:   */   @RequestMapping({"/jobintent/o_delete.do"})
/* 63:   */   public String delete(Integer[] ids, Integer pageNo, HttpServletRequest request, ModelMap model)
/* 64:   */   {
/* 65:67 */     JobIntent[] beans = this.service.deleteByIds(ids);
/* 66:68 */     for (JobIntent bean : beans) {
/* 67:69 */       log.info("delete JobIntent id={}", bean.getId());
/* 68:   */     }
/* 69:71 */     return list(pageNo, request, model);
/* 70:   */   }
/* 71:   */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.action.JobIntentAct
 * JD-Core Version:    0.7.0.1
 */