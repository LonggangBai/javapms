/*   1:    */ package com.portal.recruitcenter.action;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.page.Pagination;
/*   4:    */ import com.javapms.basic.page.SimplePage;
/*   5:    */ import com.portal.recruitcenter.entity.JobFairs;
/*   6:    */ import com.portal.recruitcenter.entity.JobFairsExt;
/*   7:    */ import com.portal.recruitcenter.service.JobFairsService;
/*   8:    */ import com.portal.sysmgr.entity.Site;
/*   9:    */ import com.portal.sysmgr.service.TplService;
/*  10:    */ import com.portal.sysmgr.utils.ContextTools;
/*  11:    */ import java.util.List;
/*  12:    */ import javax.servlet.http.HttpServletRequest;
/*  13:    */ import org.apache.commons.lang.StringUtils;
/*  14:    */ import org.slf4j.Logger;
/*  15:    */ import org.slf4j.LoggerFactory;
/*  16:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  17:    */ import org.springframework.stereotype.Controller;
/*  18:    */ import org.springframework.ui.ModelMap;
/*  19:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  20:    */ 
/*  21:    */ @Controller
/*  22:    */ public class JobFairsAct
/*  23:    */ {
/*  24: 29 */   private static final Logger log = LoggerFactory.getLogger(JobFairsAct.class);
/*  25:    */   @Autowired
/*  26:    */   private JobFairsService service;
/*  27:    */   @Autowired
/*  28:    */   private TplService tplService;
/*  29:    */   
/*  30:    */   @RequestMapping({"/jobfairs/v_list.do"})
/*  31:    */   public String list(Integer pageNo, HttpServletRequest request, ModelMap model)
/*  32:    */   {
/*  33: 34 */     Pagination pagination = this.service.getPage(SimplePage.cpn(pageNo), 
/*  34: 35 */       20);
/*  35: 36 */     model.addAttribute("pagination", pagination);
/*  36: 37 */     model.addAttribute("pageNo", Integer.valueOf(pagination.getPageNo()));
/*  37: 38 */     return "jobfairs/list";
/*  38:    */   }
/*  39:    */   
/*  40:    */   @RequestMapping({"/jobfairs/v_add.do"})
/*  41:    */   public String add(HttpServletRequest request, ModelMap model)
/*  42:    */   {
/*  43: 43 */     Site site = ContextTools.getSite(request);
/*  44: 44 */     List<String> tplList = getTplList(request, site, null);
/*  45: 45 */     model.addAttribute("tplList", tplList);
/*  46: 46 */     return "jobfairs/add";
/*  47:    */   }
/*  48:    */   
/*  49:    */   @RequestMapping({"/jobfairs/v_edit.do"})
/*  50:    */   public String edit(Integer id, Integer pageNo, HttpServletRequest request, ModelMap model)
/*  51:    */   {
/*  52: 52 */     Site site = ContextTools.getSite(request);
/*  53: 53 */     JobFairs fairs = this.service.findById(id);
/*  54: 54 */     List<String> tplList = getTplList(request, site, null);
/*  55: 55 */     int tplPathLength = site.getTplPath().length();
/*  56: 56 */     String tplAddress = fairs.getTplAddress();
/*  57: 57 */     if (!StringUtils.isBlank(tplAddress)) {
/*  58: 58 */       tplAddress = tplAddress.substring(tplPathLength);
/*  59:    */     }
/*  60: 60 */     model.addAttribute("tplList", tplList);
/*  61: 61 */     model.addAttribute("jobFairs", fairs);
/*  62: 62 */     model.addAttribute("tplAddress", tplAddress);
/*  63: 63 */     model.addAttribute("pageNo", pageNo);
/*  64: 64 */     return "jobfairs/edit";
/*  65:    */   }
/*  66:    */   
/*  67:    */   @RequestMapping({"/jobfairs/o_save.do"})
/*  68:    */   public String save(JobFairs bean, JobFairsExt ext, HttpServletRequest request, ModelMap model)
/*  69:    */   {
/*  70: 70 */     Site site = ContextTools.getSite(request);
/*  71: 71 */     if (!StringUtils.isBlank(ext.getTplAddress())) {
/*  72: 72 */       ext.setTplAddress(site.getTplPath() + ext.getTplAddress());
/*  73:    */     }
/*  74: 74 */     bean = this.service.save(bean, ext);
/*  75: 75 */     log.info("save JobFairs id={}", bean.getId());
/*  76: 76 */     return "redirect:v_list.do";
/*  77:    */   }
/*  78:    */   
/*  79:    */   @RequestMapping({"/jobfairs/o_update.do"})
/*  80:    */   public String update(JobFairs bean, JobFairsExt ext, Integer pageNo, HttpServletRequest request, ModelMap model)
/*  81:    */   {
/*  82: 82 */     Site site = ContextTools.getSite(request);
/*  83: 83 */     if (!StringUtils.isBlank(ext.getTplAddress())) {
/*  84: 84 */       ext.setTplAddress(site.getTplPath() + ext.getTplAddress());
/*  85:    */     }
/*  86: 86 */     bean = this.service.update(bean, ext);
/*  87: 87 */     log.info("update JobFairs id={}.", bean.getId());
/*  88: 88 */     return list(pageNo, request, model);
/*  89:    */   }
/*  90:    */   
/*  91:    */   @RequestMapping({"/jobfairs/o_delete.do"})
/*  92:    */   public String delete(Integer[] ids, Integer pageNo, HttpServletRequest request, ModelMap model)
/*  93:    */   {
/*  94: 94 */     JobFairs[] beans = this.service.deleteByIds(ids);
/*  95: 95 */     for (JobFairs bean : beans) {
/*  96: 96 */       log.info("delete JobFairs id={}", bean.getId());
/*  97:    */     }
/*  98: 98 */     return list(pageNo, request, model);
/*  99:    */   }
/* 100:    */   
/* 101:    */   private List<String> getTplList(HttpServletRequest request, Site site, String tpl)
/* 102:    */   {
/* 103:103 */     List<String> tplList = this.tplService.getNameListByPrefix(site
/* 104:104 */       .getSolutionPath() + "/" + "fairs" + "/");
/* 105:105 */     return tplList;
/* 106:    */   }
/* 107:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.action.JobFairsAct
 * JD-Core Version:    0.7.0.1
 */