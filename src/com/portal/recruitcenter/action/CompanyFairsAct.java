/*   1:    */ package com.portal.recruitcenter.action;
/*   2:    */ 
/*   3:    */ import com.javapms.basic.page.Pagination;
/*   4:    */ import com.javapms.basic.page.SimplePage;
/*   5:    */ import com.javapms.basic.utils.ResponseUtils;
/*   6:    */ import com.portal.recruitcenter.entity.CompanyFairs;
/*   7:    */ import com.portal.recruitcenter.entity.CompanyInfo;
/*   8:    */ import com.portal.recruitcenter.entity.JobFairs;
/*   9:    */ import com.portal.recruitcenter.service.CompanyFairsService;
/*  10:    */ import com.portal.recruitcenter.service.CompanyInfoService;
/*  11:    */ import com.portal.recruitcenter.service.JobFairsService;
/*  12:    */ import java.util.List;
/*  13:    */ import javax.servlet.http.HttpServletRequest;
/*  14:    */ import javax.servlet.http.HttpServletResponse;
/*  15:    */ import org.apache.shiro.authz.annotation.RequiresPermissions;
/*  16:    */ import org.json.JSONException;
/*  17:    */ import org.json.JSONObject;
/*  18:    */ import org.slf4j.Logger;
/*  19:    */ import org.slf4j.LoggerFactory;
/*  20:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  21:    */ import org.springframework.stereotype.Controller;
/*  22:    */ import org.springframework.ui.ModelMap;
/*  23:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  24:    */ 
/*  25:    */ @Controller
/*  26:    */ public class CompanyFairsAct
/*  27:    */ {
/*  28: 33 */   private static final Logger log = LoggerFactory.getLogger(CompanyFairsAct.class);
/*  29:    */   @Autowired
/*  30:    */   private CompanyFairsService service;
/*  31:    */   @Autowired
/*  32:    */   private JobFairsService jobFairsService;
/*  33:    */   @Autowired
/*  34:    */   private CompanyInfoService companyInfoService;
/*  35:    */   
/*  36:    */   @RequiresPermissions({"admin:companyfairs:list"})
/*  37:    */   @RequestMapping({"/companyfairs/v_list.do"})
/*  38:    */   public String list(Integer companyId, Integer fairsId, Integer pageNo, HttpServletRequest request, ModelMap model)
/*  39:    */   {
/*  40: 39 */     Pagination pagination = this.service.getPage(companyId, fairsId, 
/*  41: 40 */       SimplePage.cpn(pageNo), 20);
/*  42: 41 */     model.addAttribute("pagination", pagination);
/*  43: 42 */     model.addAttribute("pageNo", Integer.valueOf(pagination.getPageNo()));
/*  44: 43 */     return "companyfairs/list";
/*  45:    */   }
/*  46:    */   
/*  47:    */   @RequiresPermissions({"admin:companyfairs:add"})
/*  48:    */   @RequestMapping({"/companyfairs/v_add.do"})
/*  49:    */   public String add(Integer companyId, ModelMap model)
/*  50:    */   {
/*  51: 49 */     List<JobFairs> fairsList = this.jobFairsService.getFairsByTime();
/*  52: 50 */     CompanyInfo company = this.companyInfoService.findById(companyId);
/*  53: 51 */     model.addAttribute("fairsList", fairsList);
/*  54: 52 */     model.addAttribute("company", company);
/*  55: 53 */     return "companyfairs/add";
/*  56:    */   }
/*  57:    */   
/*  58:    */   @RequiresPermissions({"admin:companyfairs:edit"})
/*  59:    */   @RequestMapping({"/companyfairs/v_edit.do"})
/*  60:    */   public String edit(Integer id, Integer pageNo, HttpServletRequest request, ModelMap model)
/*  61:    */   {
/*  62: 60 */     List<JobFairs> fairsList = this.jobFairsService.getFairsByTime();
/*  63: 61 */     model.addAttribute("companyFairs", this.service.findById(id));
/*  64: 62 */     model.addAttribute("pageNo", pageNo);
/*  65: 63 */     model.addAttribute("fairsList", fairsList);
/*  66: 64 */     return "companyfairs/edit";
/*  67:    */   }
/*  68:    */   
/*  69:    */   @RequiresPermissions({"admin:companyfairs:save"})
/*  70:    */   @RequestMapping({"/companyfairs/o_save.do"})
/*  71:    */   public String save(CompanyFairs bean, Integer companyId, Integer fairsId, HttpServletRequest request, ModelMap model)
/*  72:    */   {
/*  73: 71 */     bean = this.service.save(bean, companyId, fairsId);
/*  74: 72 */     log.info("save CompanyFairs id={}", bean.getId());
/*  75: 73 */     return "redirect:v_list.do";
/*  76:    */   }
/*  77:    */   
/*  78:    */   @RequiresPermissions({"admin:companyfairs:update"})
/*  79:    */   @RequestMapping({"/companyfairs/o_update.do"})
/*  80:    */   public String update(CompanyFairs bean, Integer fairsId, Integer pageNo, HttpServletRequest request, ModelMap model)
/*  81:    */   {
/*  82: 80 */     bean = this.service.update(bean, null, fairsId);
/*  83: 81 */     log.info("update CompanyFairs id={}.", bean.getId());
/*  84: 82 */     return list(bean.getCompany().getId(), bean.getFairs().getId(), pageNo, 
/*  85: 83 */       request, model);
/*  86:    */   }
/*  87:    */   
/*  88:    */   @RequiresPermissions({"admin:companyfairs:delete"})
/*  89:    */   @RequestMapping({"/companyfairs/o_delete.do"})
/*  90:    */   public String delete(Integer[] ids, Integer pageNo, HttpServletRequest request, ModelMap model)
/*  91:    */   {
/*  92: 90 */     CompanyFairs[] beans = this.service.deleteByIds(ids);
/*  93: 91 */     for (CompanyFairs bean : beans) {
/*  94: 92 */       log.info("delete CompanyFairs id={}", bean.getId());
/*  95:    */     }
/*  96: 94 */     return list(beans[0].getCompany().getId(), beans[0].getFairs().getId(), 
/*  97: 95 */       pageNo, request, model);
/*  98:    */   }
/*  99:    */   
/* 100:    */   @RequiresPermissions({"admin:companyfairs:ajaxdelete"})
/* 101:    */   @RequestMapping(value={"/companyfairs/o_ajaxSave.do"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 102:    */   public void messageaAjaxSend(Integer companyId, Integer fairsId, String showcase, Byte showTime, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/* 103:    */     throws JSONException
/* 104:    */   {
/* 105:103 */     JSONObject json = new JSONObject();
/* 106:104 */     if (companyId == null)
/* 107:    */     {
/* 108:105 */       json.put("success", false);
/* 109:106 */       json.put("status", 0);
/* 110:107 */       ResponseUtils.renderJson(response, json.toString());
/* 111:108 */       return;
/* 112:    */     }
/* 113:110 */     if (fairsId == null)
/* 114:    */     {
/* 115:111 */       json.put("success", false);
/* 116:112 */       json.put("status", 0);
/* 117:113 */       ResponseUtils.renderJson(response, json.toString());
/* 118:114 */       return;
/* 119:    */     }
/* 120:116 */     Pagination pagination = this.service.getPage(companyId, fairsId, 1, 1);
/* 121:117 */     if (pagination.getTotalCount() > 0)
/* 122:    */     {
/* 123:118 */       json.put("success", false);
/* 124:119 */       json.put("status", -1);
/* 125:120 */       ResponseUtils.renderJson(response, json.toString());
/* 126:121 */       return;
/* 127:    */     }
/* 128:123 */     CompanyFairs fairs = new CompanyFairs();
/* 129:124 */     fairs.setShowcase(showcase);
/* 130:125 */     fairs.setShowTime(showTime);
/* 131:126 */     this.service.save(fairs, companyId, fairsId);
/* 132:127 */     json.put("success", true);
/* 133:128 */     json.put("status", 1);
/* 134:129 */     ResponseUtils.renderJson(response, json.toString());
/* 135:    */   }
/* 136:    */ }


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.recruitcenter.action.CompanyFairsAct
 * JD-Core Version:    0.7.0.1
 */